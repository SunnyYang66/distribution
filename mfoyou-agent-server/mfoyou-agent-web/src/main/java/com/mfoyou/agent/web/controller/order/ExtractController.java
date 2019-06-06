package com.mfoyou.agent.web.controller.order;

import com.alibaba.fastjson.JSONObject;
import com.mfoyou.agent.web.intercepter.UrlRight;
import com.mfoyou.agent.web.intercepter.UserRight;
import com.mfoyou.agent.web.service.order.PaymentService;
import com.mfoyou.agent.web.service.session.SessionService;
import com.mfoyou.agent.web.service.thirdPart.AliPayService;
import com.mfoyou.agent.web.service.thirdPart.WeiXinService;
import com.mfoyou.agent.web.service.thirdPart.XGPushSerivce;
import com.mfoyou.agent.web.utils.redis.RedisCacheManger;
import org.mfoyou.agent.common.dao.domain.HuawuExtract;
import org.mfoyou.agent.common.dao.domain.HuawuUser;
import org.mfoyou.agent.common.dao.domain.HuawuWallet;
import org.mfoyou.agent.common.entity.enums.CommonState;
import org.mfoyou.agent.common.entity.enums.MfoyouUserType;
import org.mfoyou.agent.common.inf.IAccount;
import org.mfoyou.agent.utils.common.DateUtils;
import org.mfoyou.agent.utils.common.JsonRet;
import org.mfoyou.agent.utils.common.ListObject;
import org.mfoyou.agent.utils.common.StrUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.Date;

@Path("/extract")
@Service
public class ExtractController {

    @Autowired
    SessionService sessionService;
    @Autowired
    IAccount iAccount;
    @Autowired
    PaymentService paymentService;
    @Autowired
    AliPayService aliPayService;
    @Autowired
    WeiXinService weiXinService;
    @Autowired
    XGPushSerivce xgPushSerivce;
    @Autowired
    RedisCacheManger redisCacheManger;

    public static final String EXTRACT_STATE = "wx:extract:push";

    // 提现申请列表
    @GET
    @Path("extract/list")
    @Produces("application/json;charset=UTF-8")
    @UrlRight(UserRight.AGENTACCESS)
    public JsonRet<?> auditExtractList(@Context HttpServletRequest request, @Context HttpServletResponse response,
                                       @QueryParam("pageId") Integer pageId, @QueryParam("pageSize") Integer pageSize) {
        Date startDate = DateUtils.parse(request.getParameter("startDate"));
        Date endDate = DateUtils.parse(request.getParameter("endDate"));
        Integer agentId = sessionService.currentUserId(request);
        String typeS = request.getParameter("type");
        Integer type = typeS == null ? null : Integer.valueOf(typeS);
        HuawuExtract mfoyouExtract = new HuawuExtract();
        mfoyouExtract.setExtractState(StrUtil.parseInteger(request.getParameter("extractState")));
        mfoyouExtract.setExtractAccount(request.getParameter("extractAccount"));
        String phone = request.getParameter("phoneNumber");
        if (phone != null) {
            HuawuUser userInfo = iAccount.getUserInfoByPhone(phone, agentId);
            Integer userId = userInfo.getUserId();
            mfoyouExtract.setUserId(userId);
        }
        mfoyouExtract.setAgentId(agentId);
        mfoyouExtract.setExtractAuditResult(StrUtil.parseInteger(request.getParameter("extractAuditResult")));
        mfoyouExtract.setExtractType(StrUtil.parseInteger(request.getParameter("extractType")));
        mfoyouExtract.setExtractUserType(StrUtil.parseInteger(request.getParameter("userType")));
        return JsonRet.buildRet(0, ListObject.BulidListObject(
                paymentService.getExtractList(type, mfoyouExtract, pageId, pageSize, startDate, endDate)));
    }

    // 提现审核
    @POST
    @Path("audit/extract/{auditId}/{state}")
    @Produces("application/json;charset=UTF-8")
    @UrlRight(UserRight.AGENTACCESS)
    public JsonRet<?> auditExtract(@Context HttpServletRequest request, @Context HttpServletResponse response,
                                   @PathParam("auditId") Integer auditId, @PathParam("state") Integer state) throws IOException {
        Integer agentId = sessionService.currentUserId(request);
        if ((state != -1 && state != 1) || auditId == null) {
            return JsonRet.buildRet(-11);
        }
        HuawuExtract checkExtract = new HuawuExtract();
        checkExtract.setExtractId(auditId);
        checkExtract.setExtractAuditResult(0);//等同于where extract_audit_result = 0   这个数据是没有的  就更新不到值
        //这里实际上是校验类
        checkExtract.setAgentId(agentId);
        HuawuExtract updateExtract = new HuawuExtract();
        updateExtract.setAdminId(sessionService.currentUserId(request));
        updateExtract.setExtractAuditTime(new Date());
        updateExtract.setExtractAuditResult(state);//这就确定-1或1   这里是判断是否可以提现
        updateExtract.setExtractState(state == -1 ? 3 : null);
        if (paymentService.modifyExtract(checkExtract, updateExtract)) {
            // 修改成功
            if (state == 1) {
                // 开始进入提现步骤
                HuawuExtract mfoyouExtract = paymentService.getMfoyouExtract(auditId);
                Integer amount = mfoyouExtract.getExtractAmount();
//				根据获取出来的userId去user表里查询openId
                Integer userId = mfoyouExtract.getUserId();
                HuawuUser userInfo = paymentService.getOpenId(userId);
                String openId = userInfo.getOpenId();
//				这里使用微信进行提现
                String ret = weiXinService.extract(amount, openId);
                HuawuExtract restultExtract = new HuawuExtract();
                restultExtract.setExtractId(auditId);
                restultExtract.setExtractPayTime(new Date());
                restultExtract.setExtractState(
                        state == 1 ? CommonState.emauitSucess.getValue() : CommonState.emauitfail.getValue());
                restultExtract.setExtractPayCode("" + auditId);
                restultExtract.setExtractPayResult(ret);
                // 有问题 要弄到生产者 事务进行操作
                if (!ret.equals("提现成功")) {
                    // 返回钱包
                    Integer userType = mfoyouExtract.getExtractUserType();
                    HuawuWallet userMfoyouWallet = paymentService.getUserWallet(userId);
                    int oldValue = getUserextractAmount(userMfoyouWallet, userType);
                    boolean result = paymentService.returnExtractFailMoney(5, userId, oldValue, amount, auditId,
                            userType);
                    if (!result) {
                        JsonRet.buildRet(-17);
                    }
                }
                if (mfoyouExtract.getExtractUserType().intValue() == MfoyouUserType.runer.getValue()
                        || mfoyouExtract.getExtractUserType().intValue() == MfoyouUserType.agent.getValue()) {
                    String title = ret.equals("提现成功") ? "提现成功通知。" : "提现失败通知";
                    String content = "";
                    if (ret.equals("提现成功")) {
                        content = "提现" + formatPrice(amount) + "元成功！";
                    } else {
                        content = ret;
                    }
                    xgPushSerivce.pushExtractNotify(mfoyouExtract.getUserId(), auditId,
                            mfoyouExtract.getExtractUserType(), title, content);
                }
//                判断如果返回的是错误的就不更新提现表的信息了
                if(ret.equals("提现成功")){
                    if (paymentService.modifyExtract(restultExtract)) {
                        return JsonRet.buildRet(0);
                    } else {
                        return JsonRet.buildRet(-100);
                    }
                }else {
                    return JsonRet.buildRet(5002);
                }

            } else if (state == -1) {
                HuawuExtract mfoyouExtract = paymentService.getMfoyouExtract(auditId);
                Integer userId = mfoyouExtract.getUserId();
                Integer userType = mfoyouExtract.getExtractUserType();
                HuawuWallet mfoyouWallet = paymentService.getUserWallet(userId);
                Integer oldValue = getUserextractAmount(mfoyouWallet, userType);
                Integer amount = mfoyouExtract.getExtractAmount();
                boolean result = paymentService.returnExtractFailMoney(6, userId, oldValue, amount, auditId, userType);
                if (!result) {
                    JsonRet.buildRet(-17);
                }
                if (mfoyouExtract.getExtractUserType().intValue() == MfoyouUserType.runer.getValue()
                        || mfoyouExtract.getExtractUserType().intValue() == MfoyouUserType.agent.getValue()) {
                    String title = "提现被驳回通知";
                    String content = "你的提现金额为" + formatPrice(amount) + "元的请求已被驳回，请与管理员联系";
                    xgPushSerivce.pushExtractNotify(mfoyouExtract.getUserId(), auditId,
                            mfoyouExtract.getExtractUserType(), title, content);
                } else if (mfoyouExtract.getExtractUserType().intValue() == MfoyouUserType.store.getValue()) {
                    JSONObject jsonObject = new JSONObject();
                    jsonObject.put("userid", mfoyouExtract.getUserId());
                    jsonObject.put("result", 3);
                    jsonObject.put("amount", amount);
                    jsonObject.put("date", new Date().getTime());
                    redisCacheManger.pushRList(EXTRACT_STATE, jsonObject.toJSONString());
                }
            }
        } else {
            return JsonRet.buildRet(-95);
        }
        return JsonRet.buildRet(0);
    }

    public static int getUserextractAmount(HuawuWallet mfoyouWallet, int userType) {

        if (MfoyouUserType.agent.getValue() == userType) {
            return mfoyouWallet.getWalletAgentAmount();
        }
        if (MfoyouUserType.runer.getValue() == userType) {
            return mfoyouWallet.getWalletRunerAmount();
        }
        if (MfoyouUserType.store.getValue() == userType) {
            return mfoyouWallet.getWalletStoreAmount();
        }
        if (16 == userType) {
            return mfoyouWallet.getWalletStoreAgentAmount();
        }
        return mfoyouWallet.getWalletExtractAmount();
    }

    private static String formatPrice(Integer acount) {
        DecimalFormat df = new DecimalFormat("#0.00");
        Double intValue = (double) acount.intValue();
        return df.format(intValue / 100);
    }
}
