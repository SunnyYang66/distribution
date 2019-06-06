package com.mfoyou.agent.web.controller.account;

import com.mfoyou.agent.web.intercepter.UrlRight;
import com.mfoyou.agent.web.intercepter.UserRight;
import com.mfoyou.agent.web.service.account.AccountService;
import com.mfoyou.agent.web.service.session.SessionService;
import com.mfoyou.agent.web.service.sms.SmsService;
import com.mfoyou.agent.web.service.wx.WXBaseService;
import com.mfoyou.agent.web.utils.redis.RedisCacheManger;
import org.mfoyou.agent.common.dao.domain.*;
import org.mfoyou.agent.common.entity.enums.CommonState;
import org.mfoyou.agent.common.inf.IAccount;
import org.mfoyou.agent.common.inf.IIdentity;
import org.mfoyou.agent.common.inf.IStore;
import org.mfoyou.agent.utils.common.JsonRet;
import org.mfoyou.agent.utils.common.MfoyouMap;
import org.mfoyou.agent.utils.common.StrUtil;
import org.mfoyou.agent.utils.json.Json2Object;
import org.mfoyou.agent.utils.map.ObjectToMappr;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Path("/user")
@Service
public class AccountController {
    @Autowired
    SessionService sessionService;
    @Autowired
    RedisCacheManger redisCacheManger;
    @Autowired
    AccountService accountService;
    @Autowired
    SmsService smsService;
    @Autowired
    IAccount iAccount;
    @Autowired
    IStore iStore;
    @Autowired
    IIdentity iIdentity;
    @Autowired
    WXBaseService wxBaseService;


    @GET
    @Path(value = "/info")
    @Produces("application/json;charset=UTF-8")
    @UrlRight(UserRight.LOGINACCESS)
    public JsonRet<?> info(@Context HttpServletRequest request, @Context HttpServletResponse response) {
        return JsonRet.buildSuccRet(sessionService.currentUser(request));
    }

    @POST
    @Path(value = "/login/pass/{agentId}")
    @Produces("application/json;charset=UTF-8")
    @UrlRight(UserRight.ALLACCESS)
    public JsonRet<?> loginPass(@Context HttpServletRequest request, @Context HttpServletResponse response, String json,
                                @PathParam("agentId") Integer agentId) {
        MfoyouMap mfoyouMap = Json2Object.json2MfoyouMap(json);
        Integer type = mfoyouMap.getInteger("type");
        // 1=顾客，2=代理商，4=跑腿员，8=商家 16=商家服务商 128总管
        if (type == null || mfoyouMap.get("phone") == null || mfoyouMap.get("pass") == null) {
            return JsonRet.buildRet(-6);
        }
        Integer appId = mfoyouMap.getInteger("appId");
        if (appId != null && appId == 20L) {
            if (mfoyouMap.get("code") == null)
                return JsonRet.buildRet(-96);
            String value = redisCacheManger.getValue("varifyCode:" + SessionService.getSeesionId(request));
            if (value == null || !value.equals(mfoyouMap.get("code"))) {
                return JsonRet.buildRet(-1444);
            }

        }

        Double lon = mfoyouMap.getDouble("lon");
        Double lat = mfoyouMap.getDouble("lat");
        HuawuUser huawuUser = accountService.login(mfoyouMap.get("phone"), mfoyouMap.get("pass"), agentId);
        if (huawuUser != null && appId.intValue() == 100) {
            huawuUser.setUserNickName(mfoyouMap.get("nickName"));
            huawuUser.setUserHeadUrl(mfoyouMap.get("headUrl"));
            huawuUser.setUserSex(mfoyouMap.get("sex"));
            huawuUser.setAgentId(agentId);
        }
        if (huawuUser == null) {
            HuawuUser userInfoByPhone = iAccount.getUserInfoByPhone(mfoyouMap.get("phone"), agentId);
            if (userInfoByPhone == null) {
                return JsonRet.buildRet(-13);
            }
        }
        JsonRet<?> ret = accountService.loginV2(request, type, huawuUser, appId, lon, lat, agentId);
        return ret;
    }

    @POST
    @Path(value = "/login/wechat/{agentId}")
    @Produces("application/json;charset=UTF-8")
    @UrlRight(UserRight.ALLACCESS)
    public JsonRet<?> loginWechat(@Context HttpServletRequest request, @Context HttpServletResponse response,
                                  @PathParam("agentId") Integer agentId, String json) {
        MfoyouMap mfoyouMap = Json2Object.json2MfoyouMap(json);
        Integer type = mfoyouMap.getInteger("type");
        // 1=顾客，2=代理商，4=跑腿员，8=商家
        if (type == null || mfoyouMap.get("code") == null) {
            return JsonRet.buildRet(-6);
        }
        Integer appId = mfoyouMap.getInteger("appId");
        Double lon = mfoyouMap.getDouble("lon");
        Double lat = mfoyouMap.getDouble("lat");
        HuawuUser huawuUser = null;
        String headUrl = mfoyouMap.get("headUrl");
        String  sex = mfoyouMap.get("sex");
        String nickName = mfoyouMap.get("nickName");
        huawuUser = accountService.loginWechat(request, mfoyouMap.get("code"), appId, agentId, headUrl, sex, nickName);
        if (huawuUser == null)
            return JsonRet.buildRet(-1998);
        if (huawuUser.getUserId() == null) {
            Map<String, String> objectToMaps = ObjectToMappr.ObjectToMaps(huawuUser);
            sessionService.loginAppend(request, objectToMaps);
            return JsonRet.buildRet(-83, huawuUser);
        }
        JsonRet<?> ret = accountService.loginV2(request, type, huawuUser, appId, lon, lat, agentId);
        return ret;
    }

    @POST
    @Path(value = "/login/code/{agentId}")
    @Produces("application/json;charset=UTF-8")
    @UrlRight(UserRight.ALLACCESS)
    public JsonRet<?> loginCode(@Context HttpServletRequest request, @Context HttpServletResponse response,
                                @PathParam("agentId") Integer agentId, String json) {
        MfoyouMap mfoyouMap = Json2Object.json2MfoyouMap(json);
        Integer type = mfoyouMap.getInteger("type");
        // 1=顾客，2=代理商，4=跑腿员，8=商家
        if (type == null || mfoyouMap.get("phone") == null || mfoyouMap.get("code") == null) {
            return JsonRet.buildRet(-6);
        }
        int checkPhoneCode = smsService.checkPhoneCode(request, mfoyouMap.get("phone"), mfoyouMap.get("code"), 2, true);
        if (checkPhoneCode == -1) {
            return JsonRet.buildRet(-24);
        } else if (checkPhoneCode == -12) {
            return JsonRet.buildRet(-8);
        }
        Integer appId = mfoyouMap.getInteger("appId");
        Double lon = mfoyouMap.getDouble("lon");
        Double lat = mfoyouMap.getDouble("lat");
        HuawuUser huawuUser = accountService.userInfoByPhoneV1(mfoyouMap.get("phone"), agentId);
        if (huawuUser == null) {
            // 自动注册一个新用户
            huawuUser = new HuawuUser();
            huawuUser.setUserPhone(mfoyouMap.get("phone"));
            huawuUser.setAgentId(agentId);
            huawuUser = accountService.registUser(huawuUser);
        }
        JsonRet<?> ret = accountService.loginV2(request, type, huawuUser, appId, lon, lat, agentId);
        return ret;
    }

    @POST
    @Path(value = "/login/wechat/bind/newuser/{agentId}")
    @Produces("application/json;charset=UTF-8")
    @UrlRight(UserRight.ALLACCESS)
    public JsonRet<?> WechatBindnew(@Context HttpServletRequest request, @Context HttpServletResponse response,
                                    @PathParam("agentId") Integer agentId, String json) {
        MfoyouMap mfoyouMap = Json2Object.json2MfoyouMap(json);
        Integer type = mfoyouMap.getInteger("type");
        String code = mfoyouMap.get("code");
        String phone = mfoyouMap.get("phone");
        String pass = mfoyouMap.get("pass");
        Integer appId = mfoyouMap.getInteger("appId");
        Double lon = mfoyouMap.getDouble("lon");
        Double lat = mfoyouMap.getDouble("lat");
        // 1=顾客，2=代理商，4=跑腿员，8=商家 16=服务商
        if (type == null || code == null || phone == null || pass == null || appId == null) {
            return JsonRet.buildRet(-6);
        }
        if (0 != smsService.checkPhoneCode(request, phone, code, 1, true)) {
            return JsonRet.buildRet(-8);
        }
        HuawuUser huawuUser = accountService.bindWechat(request, appId, phone, pass, true, agentId);
        if (huawuUser == null)
            return JsonRet.buildRet(-100);
        return accountService.loginV2(request, type, huawuUser, appId, lon, lat, agentId);
    }

    @POST
    @Path(value = "/login/wechat/bind/olduser/{agentId}")
    @Produces("application/json;charset=UTF-8")
    @UrlRight(UserRight.ALLACCESS)
    public JsonRet<?> WechatBindold(@Context HttpServletRequest request, @Context HttpServletResponse response,
                                    @PathParam("agentId") Integer agentId, String json) {
        MfoyouMap mfoyouMap = Json2Object.json2MfoyouMap(json);
        Integer type = mfoyouMap.getInteger("type");
        String code = mfoyouMap.get("code");
        String phone = mfoyouMap.get("phone");
        String pass = mfoyouMap.get("pass");
        Integer appId = mfoyouMap.getInteger("appId");
        Double lon = mfoyouMap.getDouble("lon");
        Double lat = mfoyouMap.getDouble("lat");
        // 1=顾客，2=代理商，4=跑腿员，8=商家
        if (type == null || phone == null || appId == null) {
            return JsonRet.buildRet(-6);
        }
        if (code != null) {
            if (0 != smsService.checkPhoneCode(request, phone, code, 2, true)) {
                return JsonRet.buildRet(-8);
            }
        } else if (pass == null) {
            return JsonRet.buildRet(-6);
        }
        HuawuUser huawuUser = accountService.bindWechat(request, appId, phone, pass, false, agentId);
        if (huawuUser == null)
            return JsonRet.buildRet(-100);
        return accountService.loginV2(request, type, huawuUser, appId, lon, lat, agentId);
    }

    @POST
    @Path(value = "/modify/password/{agentId}")
    @Produces("application/json;charset=UTF-8")
    @UrlRight(UserRight.LOGINACCESS)
    public JsonRet<?> modifyPassword(@Context HttpServletRequest request, @Context HttpServletResponse response,
                                     @PathParam("agentId") Integer agentId, String json) {
        MfoyouMap mfoyouMap = Json2Object.json2MfoyouMap(json);
        String oldPass = mfoyouMap.get("oldPass");
        String newPass = mfoyouMap.get("newPass");
        if (oldPass == null || newPass == null)
            JsonRet.buildRet(-99);
        if (accountService.modifyUserPass(request, null, oldPass, newPass, agentId)) {
            return JsonRet.buildRet(0);
        } else {
            return JsonRet.buildRet(-1);
        }
    }

    @POST
    @Path(value = "/modify/password/usecode")
    @Produces("application/json;charset=UTF-8")
    @UrlRight(UserRight.LOGINACCESS)
    public JsonRet<?> modifyusecode(@Context HttpServletRequest request, @Context HttpServletResponse response,
                                    String json) {
        MfoyouMap mfoyouMap = Json2Object.json2MfoyouMap(json);
        String code = mfoyouMap.get("code");
        String newPass = mfoyouMap.get("newPass");
        if (code == null || newPass == null)
            JsonRet.buildRet(-99);
        if (0 != smsService.checkPhoneCode(request, sessionService.currentUserPhone(request), code, 10, true)) {
            return JsonRet.buildRet(-8);
        }
        if (accountService.modifyUserPass(request, newPass)) {
            return JsonRet.buildRet(0);
        } else {
            return JsonRet.buildRet(-1);
        }
    }

    // 找回密码
    @POST
    @Path(value = "/find/password/{agentId}")
    @Produces("application/json;charset=UTF-8")
    @UrlRight(UserRight.ALLACCESS)
    public JsonRet<?> findPassword(@Context HttpServletRequest request, @Context HttpServletResponse response,
                                   @PathParam("agentId") Integer agentId, String json) {
        MfoyouMap mfoyouMap = Json2Object.json2MfoyouMap(json);
        String code = mfoyouMap.get("code");
        String newPass = mfoyouMap.get("newPass");
        String phone = mfoyouMap.get("phone");
        if (code == null || newPass == null)
            return JsonRet.buildRet(-99);
        if (0 != smsService.checkPhoneCode(request, phone, code, 5, true)) {
            return JsonRet.buildRet(-8);
        }
        if (accountService.modifyUserPass(request, phone, null, newPass, agentId)) {
            return JsonRet.buildRet(0);
        } else {
            return JsonRet.buildRet(-1);
        }
    }

    @GET
    @Path(value = "/get/baseinfo")
    @Produces("application/json;charset=UTF-8")
    @UrlRight(UserRight.LOGINACCESS)
    public JsonRet<?> getBaseInfo(@Context HttpServletRequest request, @Context HttpServletResponse response) {
        // HuawuUser huawuUser =
        // accountService.userInfo(sessionService.currentUserId(request));
        MfoyouMap currentUser = sessionService.currentUser(request);
        if (currentUser != null) {
            // if (huawuUser.getUserHeadUrl() == null) {
            // huawuUser.setUserHeadUrl(sessionService.currentHeadUrl(request));
            // }
            return JsonRet.buildSuccRet(currentUser);
        } else {
            return JsonRet.buildRet(-1);
        }
    }

    @GET
    @Path(value = "/logout")
    @Produces("application/json;charset=UTF-8")
    @UrlRight(UserRight.ALLACCESS)
    public JsonRet<?> logout(@Context HttpServletRequest request) {
        sessionService.clearCurrentUser(request);
        return JsonRet.buildSuccRet(null);
    }

    @POST
    @Path(value = "post/idcardinfo")
    @Produces("application/json;charset=UTF-8")
    @UrlRight(UserRight.LOGINACCESS)
    public JsonRet<?> authAgent(@Context HttpServletRequest request, @Context HttpServletResponse response,
                                String json) {
        Integer agentid = sessionService.currentUserId(request);
        HuawuIdcardInfo idcardInfo = iAccount.getIdcardInfo(agentid);
        if (idcardInfo != null && idcardInfo.getState() != CommonState.emauitfail.getValue()) {
            return JsonRet.buildRet(-45);
        }
        MfoyouMap json2MfoyouMap = Json2Object.json2MfoyouMap(json);
        String name = json2MfoyouMap.get("name");
        String code = json2MfoyouMap.get("code");
        String fact = json2MfoyouMap.get("idcardFact");
        String reverse = json2MfoyouMap.get("idcardReverse");
        String hand = json2MfoyouMap.get("idcardHand");
        HuawuIdcardInfo mfoyouIdcardInfo = new HuawuIdcardInfo();
        mfoyouIdcardInfo.setUserId(agentid);
        mfoyouIdcardInfo.setUserHandleIdcard(hand);
        mfoyouIdcardInfo.setUserFactIdcard(fact);
        mfoyouIdcardInfo.setUserReverseIdcard(reverse);
        mfoyouIdcardInfo.setUserTrueName(name);
        mfoyouIdcardInfo.setUserIdCode(code);
        mfoyouIdcardInfo.setState(CommonState.emauit.getValue());
        int result = 0;
        if (idcardInfo == null) {
            result = iAccount.addIdcardInfo(mfoyouIdcardInfo);
        } else {
            result = iAccount.updateMfoyouIdcardInfo(mfoyouIdcardInfo);
        }
        return result == 1 ? JsonRet.buildRet(0) : JsonRet.buildRet(-11);
    }

    @GET
    @Path(value = "/info/list")
    @Produces("application/json;charset=UTF-8")
    @UrlRight({UserRight.RUNERACCESS, UserRight.AGENTACCESS, UserRight.ADMINACCESS})
    public JsonRet<?> listInfo(@Context HttpServletRequest request, @Context HttpServletResponse response,
                               @QueryParam("ids") String ids) {
        if (ids == null || ids.equals("")) {
            return JsonRet.buildRet(-6);
        }
        String[] is = ids.split(",");
        List<Integer> list = new ArrayList<>();
        for (String s : is) {
            list.add(StrUtil.parseInteger(s));
        }
        List<HuawuUser> list2 = iAccount.userListById(list);
        Map<Integer, HuawuUser> map = new HashMap<>();
        for (HuawuUser mfoyouUser : list2) {
            if (mfoyouUser.getAgentId().intValue() == -2) {
                HuawuStoreInfo storeInfo = iStore.getStoreInfo(mfoyouUser.getUserId());
                if (storeInfo != null) {
                    mfoyouUser.setUserHeadUrl(storeInfo.getStoreLogo());
                }
            }
            map.put(mfoyouUser.getUserId(), mfoyouUser);
        }
        list2.clear();
        for (Integer id : list) {
            list2.add(map.get(id));
        }
        return JsonRet.buildSuccRet(list2);
    }

    // 华悟云商认证
    @POST
    @Path(value = "/storeAuthentication")
    @Produces("application/json;charset=UTF-8")
    @UrlRight(UserRight.ALLACCESS)
    public JsonRet<?> storeAuthentication(@Context HttpServletRequest request, @Context HttpServletResponse response,
                                          String json) {
        MfoyouMap mfoyouMap = Json2Object.json2MfoyouMap(json);
        Integer storeId = mfoyouMap.getInteger("storeId");
        String code = mfoyouMap.get("code");
        String appId = mfoyouMap.get("appId");
        String agentId = mfoyouMap.get("agentId");
        if (code == null || storeId == null || appId == null) {
            return JsonRet.buildRet(-6);
        }
        HuawuThirdUser thirdUser = iAccount.getThirdByUserId(storeId, 200);
        if (thirdUser != null) {
            accountService.updateWe(appId, storeId);
            return JsonRet.buildRet(-44);
        }
        Integer mfoyouUserV1 = accountService.authentication(code, appId, storeId, Integer.parseInt(agentId));
        return mfoyouUserV1.intValue() == 1 ? JsonRet.buildRet(0) : JsonRet.buildRet(-50);
    }

    @POST
    @Path(value = "/regist/{agentId}")
    @Produces("application/json;charset=UTF-8")
    @UrlRight(UserRight.ALLACCESS)
    public JsonRet<?> regist(@Context HttpServletRequest request, @Context HttpServletResponse response, String json,
                             @PathParam("agentId") Integer agentId) {


        MfoyouMap mfoyouMap = Json2Object.json2MfoyouMap(json);
        String code = mfoyouMap.get("code");
        String phone = mfoyouMap.get("phone");
        String pass = mfoyouMap.get("pass");
        Integer type = mfoyouMap.getInteger("type");
        Integer appId = mfoyouMap.getInteger("appId");
        Double lon = mfoyouMap.getDouble("lon");
        Double lat = mfoyouMap.getDouble("lat");
        String nickname = mfoyouMap.get("nickname");
        String headUrl = mfoyouMap.get("headUrl");
        String sex=mfoyouMap.get("sex");
        String openId=mfoyouMap.get("openId");
        if ((type == null || appId == null || phone == null) && type != 16) {
            return JsonRet.buildRet(-96);
        }
//        if (0 != smsService.checkPhoneCode(request, phone, code, 1, true)) {
//            return JsonRet.buildRet(-8);
//        }
//        HuawuUser mfoyouUser1 = iAccount.getUserInfoByPhone(phone, agentId);
//        if (mfoyouUser1 != null) {
//            return JsonRet.buildRet(-10);
//        }

        HuawuUser mfoyouUser = new HuawuUser();
        mfoyouUser.setUserPhone(phone);
        mfoyouUser.setUserPassword(pass);
        mfoyouUser.setUserHeadUrl(headUrl);
        mfoyouUser.setUserNickName(nickname);
        mfoyouUser.setAgentId(agentId);
        mfoyouUser.setUserSex(sex);
        mfoyouUser.setOpenId(openId);
        if ((mfoyouUser = accountService.registUser(mfoyouUser)) != null) {
            JsonRet<?> ret = accountService.loginV2(request, type, mfoyouUser, appId, lon, lat, agentId);
            return ret;
        } else {
            return JsonRet.buildRet(-1);
        }
    }

    @GET
    @Path(value = "authInfo")
    @Produces("application/json;charset=UTF-8")
    @UrlRight(UserRight.LOGINACCESS)
    public JsonRet<?> authInfo(@Context HttpServletRequest request, @Context HttpServletResponse response,
                               String json) {
        Integer agentid = sessionService.currentUserId(request);
        HuawuIdcardInfo idcardInfo = iAccount.getIdcardInfo(agentid);
        if (idcardInfo == null) {
            return JsonRet.buildRet(-1108);
        }
        return JsonRet.buildSuccRet(idcardInfo);
    }

    @POST
    @Path(value = "/modify/baseinfo")
    @Produces("application/json;charset=UTF-8")
    @UrlRight(UserRight.LOGINACCESS)
    public JsonRet<?> modifyBaseInfo(@Context HttpServletRequest request, @Context HttpServletResponse response,
                                     String json) {
        json = json.replace("workerPhone", "userPhone");
        HuawuUser mfoyouUser = Json2Object.json2Object(json, HuawuUser.class);
        if (mfoyouUser == null)
            JsonRet.buildRet(-99);
        mfoyouUser.setUserId(sessionService.currentUserId(request));
        mfoyouUser.setUserPassword(null);
        String phone = mfoyouUser.getUserPhone();
        mfoyouUser.setUserPhone(null);
        mfoyouUser.setUserModifyTime(null);
        mfoyouUser.setUserDisable(null);
        if (mfoyouUser.getUserHeadUrl() != null) {
            sessionService.appendUserInfo_head(mfoyouUser);
        }
        if (phone != null) {
            if (sessionService.currentUserType(request) == 4) {
                HuawuWorker mfoyouWorker = new HuawuWorker();
                mfoyouWorker.setUserId(sessionService.currentUserId(request));
                mfoyouWorker.setWorkerPhone(phone);
                iIdentity.modifyMfoyouWorkerInfo(mfoyouWorker);
            }
        }
        if (iAccount.modifyUser(mfoyouUser) == 1) {
            return JsonRet.buildRet(0);
        } else {
            return JsonRet.buildRet(-1);
        }
    }

}
