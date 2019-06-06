package com.mfoyou.agent.web.controller.payment;

import java.io.IOException;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;

import org.apache.commons.io.IOUtils;
import org.mfoyou.agent.common.dao.domain.HuawuAgentWxInfo;
import org.mfoyou.agent.common.dao.domain.HuawuOrderLog;
import org.mfoyou.agent.common.dao.domain.HuawuPay;
import org.mfoyou.agent.common.dao.domain.HuawuThirdUser;
import org.mfoyou.agent.common.entity.enums.MfoyouUserType;
import org.mfoyou.agent.common.entity.enums.OrderState;
import org.mfoyou.agent.common.entity.enums.OrderType;
import org.mfoyou.agent.common.entity.enums.PayType;
import org.mfoyou.agent.common.inf.IAccount;
import org.mfoyou.agent.common.inf.ICommon;
import org.mfoyou.agent.common.inf.IPayment;
import org.mfoyou.agent.utils.common.JsonRet;
import org.mfoyou.agent.utils.common.StringUtils;
import org.mfoyou.agent.utils.wx.XMLParse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.boyuanitsm.pay.wxpay.bean.Result;
import com.boyuanitsm.pay.wxpay.common.XMLParser;
import com.mfoyou.agent.web.intercepter.UrlRight;
import com.mfoyou.agent.web.intercepter.UserRight;
import com.mfoyou.agent.web.service.order.OrderInfo;
import com.mfoyou.agent.web.service.order.OrderService;
import com.mfoyou.agent.web.service.session.SessionService;
import com.mfoyou.agent.web.service.wx.PayService;
import com.mfoyou.agent.web.utils.wx.WxRequestData;
import com.mfoyou.agent.web.utils.wx.WxResponseData;

@Path("/pay/wechat")
@Service
public class PayWeChatController {
	@Autowired
	SessionService sessionService;
	@Autowired
	OrderService orderService;
	@Autowired
	PayService payService;
	@Autowired
	ICommon iCommon;
	@Autowired
	IAccount iAccount;
	@Autowired
	IPayment iPayment;
	@Value("#{settings['notifyUrl_h5']}")
	public String notifyurl;
	static Logger logger = LoggerFactory.getLogger(PayWeChatController.class);

	// @GET
	// @Path("getToken")
	// @Produces("application/json;charset=UTF-8")
	// @UrlRight(UserRight.ALLACCESS)
	// public JsonRet<?> getTyyyyy(@Context HttpServletRequest request, @Context
	// HttpServletResponse response) throws Exception{
	// return JsonRet.buildSuccRet(WxThirdPartService.getTokenV2());
	// }
	@GET
	@Path("h5/{agentId}")
	@Produces("application/json;charset=UTF-8")
	@UrlRight(UserRight.LOGINACCESS)
	public JsonRet<?> h5PayParams(@Context HttpServletRequest request, @Context HttpServletResponse response,
			@QueryParam("orderId") Integer orderId, @QueryParam("orderType") Integer orderType,
			@PathParam("agentId") Integer agentId) throws Exception {
		Map<String, String> currentUser = sessionService.currentUser(request);
		Integer appid = Integer.parseInt(currentUser.get("appId"));
		String openid = currentUser.get("openId");
		int userId = Integer.parseInt(currentUser.get("userId"));
		if (orderId == null || orderType == null) {
			return JsonRet.buildRet(-96);
		}
		HuawuAgentWxInfo huawuAgentWxInfo = iCommon.getHuawuWxInfo(agentId, appid);
		String post = null;
		HuawuPay huawuPay = new HuawuPay();
		if (openid == null) {
			HuawuThirdUser huawuThirdUser = iAccount.getThirdByUserId(userId, appid);
			openid = huawuThirdUser.getOpenId();
		}
		OrderInfo orderInfo = orderService.getOrderInfo(orderId, orderType);
		if (orderInfo == null)
			return JsonRet.buildRet(-98);
		if (orderInfo.getOrderState() >= OrderState.emPaySucess.getValue()) {
			return JsonRet.buildRet(-95);
		}
		int fee = orderInfo.getOrderAmount() - orderInfo.getOrderPaidAmount()-orderInfo.getCouponReduceMoney();;
		String number = UUID.randomUUID().toString().replace("-", "");
		String title = orderInfo.getOrderTitle();
		post = payService.post(new WxRequestData(notifyurl, title, number, openid, fee, huawuAgentWxInfo.getXcxId(),
				huawuAgentWxInfo.getXcxMchid(), huawuAgentWxInfo.getXcxPaySecret()));
		logger.info("订单信息: " + post);
		if (!StringUtils.checkIsSignValidFromResponseString(post, huawuAgentWxInfo.getXcxPaySecret())) {
			return JsonRet.buildRet(-98);
		}
		String preId = XMLParse.getPreId(post, "prepay_id");
		huawuPay.setPayAmount(fee);
		huawuPay.setPayNumber(number);
		huawuPay.setPayType(PayType.WeChat.getValue());
		huawuPay.setPayOrderType(orderType);
		huawuPay.setPayState(0);
		huawuPay.setPayPreText(post);
		huawuPay.setUserId(userId);
		huawuPay.setPayOrderId(orderId);
		huawuPay.setPayPreId(preId);
		huawuPay.setPayAppId(appid);
		huawuPay.setAgentId(agentId);
		huawuPay.setPayStoreId(orderInfo.getStoreId());
		iPayment.addMfoyouPay(huawuPay);
		return JsonRet.buildRet(0,
				new WxResponseData(preId, huawuAgentWxInfo.getXcxId(), huawuAgentWxInfo.getXcxPaySecret()));
	}

	@POST
	@Path("pay_result_callback_h5")
	@Produces("text/xml;charset=UTF-8")
	@UrlRight(UserRight.ALLACCESS)
	public String payResultCallback(@Context HttpServletRequest request) throws IOException {
		String responseString = IOUtils.toString(request.getInputStream());
		logger.info("Pay result callback response string is:" + responseString);
		try {
			Map<String, String> mapFromXML = XMLParse.getMapFromXML(responseString);
			String appid = mapFromXML.get("appid");
			HuawuAgentWxInfo huawuAgentWxInfo = iCommon.getXcxInfoByAppid(appid);
			if (huawuAgentWxInfo == null)
				logger.info("xcx info  is null");
			boolean isSign = StringUtils.checkIsSignValidFromResponseString(responseString,
					huawuAgentWxInfo.getXcxPaySecret());
			if (isSign) {
				//  检查对应业务数据的状态，判断该通知是否已经处理过, 如果没有处理过再进行处理，如果处理过直接返回结果成功
				boolean isDealWith = false;
				if (!"SUCCESS".equals(mapFromXML.get("result_code"))) {
					return XMLParser.getXMLFromObject(new Result("SUCCESS", "OK"));
				}
				if ("SUCCESS".equals(mapFromXML.get("result_code"))) {
					HuawuPay mfoyouPay = null;
					if (mapFromXML.get("out_trade_no") != null) {
						mfoyouPay = iPayment.getMfoyouPayByNumber(mapFromXML.get("out_trade_no"));
					}
					if (mfoyouPay == null) {
						logger.info("finsh call_back faile");
						return XMLParser.getXMLFromObject(new Result("FAIL", "NO THIS ORDER"));
					}
					isDealWith = (0 == mfoyouPay.getPayState().intValue());
					if (isDealWith) {
						//  处理支付成功的业务逻辑
						logger.info("begin update db" + System.currentTimeMillis());
						HuawuPay mfoyouPaySave = new HuawuPay();
						mfoyouPaySave.setPayId(mfoyouPay.getPayId());
						mfoyouPaySave.setPayState(1);
						mfoyouPaySave.setPayCallbackText(responseString);
						iPayment.modifyMfoyouPay(mfoyouPaySave);
						if (isDealWith) {
							//  处理支付成功的业务逻辑
							if (OrderType.serviceOrder.getValue() == mfoyouPay.getPayOrderType().intValue()) {
								orderService.payOrder(mfoyouPay.getPayOrderId(), mfoyouPay.getPayOrderType(),
										mfoyouPay.getPayAmount(), PayType.WeChat.getValue());
								iPayment.addStream(mfoyouPay.getUserId(), mfoyouPay.getPayAmount(), -1,
										mfoyouPay.getPayOrderId(), OrderType.serviceOrder.getValue(),
										PayType.WeChat.getValue(), PayType.serviceOrder.getValue(), "服务订单",
										MfoyouUserType.customer.getValue());
								iPayment.addPayWalletLog("WeChat_Order", -1, mfoyouPay.getUserId(),
										mfoyouPay.getPayAmount(), mfoyouPay.getPayNumber(), mfoyouPay.getPayOrderType(),
										null, MfoyouUserType.customer.getValue());
							} else if (OrderType.goodsOrder.getValue() == mfoyouPay.getPayOrderType().intValue()) {
								orderService.payOrder(mfoyouPay.getPayOrderId(), mfoyouPay.getPayOrderType(),
										mfoyouPay.getPayAmount(), PayType.WeChat.getValue());
								iPayment.addStream(mfoyouPay.getUserId(), mfoyouPay.getPayAmount(), -1,
										mfoyouPay.getPayOrderId(), OrderType.goodsOrder.getValue(),
										PayType.WeChat.getValue(), PayType.goodsOrder.getValue(), "商品订单付款",
										MfoyouUserType.customer.getValue());
								iPayment.addPayWalletLog("WeChat_Order", -1, mfoyouPay.getUserId(),
										mfoyouPay.getPayAmount(), mfoyouPay.getPayNumber(), mfoyouPay.getPayOrderType(),
										null, MfoyouUserType.customer.getValue());
							}
							HuawuOrderLog mfoyouOrderLog = new HuawuOrderLog();
							mfoyouOrderLog.setOrderLogState(OrderState.emPaySucess.getValue());
							mfoyouOrderLog.setServiceOrderId(mfoyouPay.getPayOrderId());
							mfoyouOrderLog.setOrderLogRemark(responseString);
							mfoyouOrderLog.setOrderLogUserId(-1);
							mfoyouOrderLog.setOrderType(mfoyouPay.getPayOrderType());
							orderService.addMfoyouOrderLog(mfoyouOrderLog);
							logger.info("finsh update db" + System.currentTimeMillis());
						} else {
							// 处理过直接返回结果成功
							logger.info("finsh call_back ok1");
							return XMLParser.getXMLFromObject(new Result("SUCCESS", "OK"));
						}
					}
				}
			} else {
				// 签名验证失败, "假通知"
				logger.warn("签名验证失败: " + responseString);
				return XMLParser.getXMLFromObject(new Result("FAIL", "Sign Fail"));
			}
		} catch (Throwable e) {
			logger.error("pay_result_callback error!" + e);
			return XMLParser.getXMLFromObject(new Result("FAIL", "Server Error"));
		}
		logger.info("finsh call_back ok");
		return XMLParser.getXMLFromObject(new Result("SUCCESS", "OK"));
	}
}
