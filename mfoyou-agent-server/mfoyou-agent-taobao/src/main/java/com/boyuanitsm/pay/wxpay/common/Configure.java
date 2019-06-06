package com.boyuanitsm.pay.wxpay.common;

import com.boyuanitsm.pay.PayProperties;

/**
 * User: rizenguo Date: 2014/10/29 Time: 14:40 这里放置各种配置数据
 */
public class Configure {
	
	// 是否使用异步线程的方式来上报API测速，默认为异步模式
	private static boolean useThreadToDoReport = true;

	// 机器IP
	private static String ip = PayProperties.getInstance().getWechat().getIp();

	public static String QRCODE_API = "weixin://wxpay/bizpayurl";

	public static String DEVICE_INFO = "WEB";

	/**
	 * 随机字符串长度
	 */
	public static final int NONCE_STR_LENGTH = 32;

	// 以下是几个API的路径：
	// 1）被扫支付API
	public static String PAY_API = "https://api.mch.weixin.qq.com/pay/micropay";

	// 2）被扫支付查询API
	public static String PAY_QUERY_API = "https://api.mch.weixin.qq.com/pay/orderquery";

	// 3）退款API
	public static String REFUND_API = "https://api.mch.weixin.qq.com/secapi/pay/refund";

	// 4）退款查询API
	public static String REFUND_QUERY_API = "https://api.mch.weixin.qq.com/pay/refundquery";

	// 5）撤销API
	public static String REVERSE_API = "https://api.mch.weixin.qq.com/secapi/pay/reverse";

	// 6）下载对账单API
	public static String DOWNLOAD_BILL_API = "https://api.mch.weixin.qq.com/pay/downloadbill";

	// 7) 统计上报API
	public static String REPORT_API = "https://api.mch.weixin.qq.com/payitil/report";

	/**
	 * 统一下单API
	 */
	public static String UNIFIFED_ORDER_API = "https://api.mch.weixin.qq.com/pay/unifiedorder";

	public static boolean isUseThreadToDoReport() {
		return useThreadToDoReport;
	}

	public static void setUseThreadToDoReport(boolean useThreadToDoReport) {
		Configure.useThreadToDoReport = useThreadToDoReport;
	}

	public static String HttpsRequestClassName = "com.boyuanitsm.pay.wxpay.common.HttpsRequest";

	//////////////////////////////////////////////////////////////////////////
	private static ThreadLocal<Integer> configureType = new ThreadLocal<Integer>();

	// 1=app,2=h5
	public static void switchType(Integer type) {
		configureType.set(type);
	}

	public static String getKey() {
		if (1 == configureType.get()) {
			return Configure_app.getKey();
		} else {
			return Configure_h5.getKey();
		}
	}

	public static String getAppid() {
		if (1 == configureType.get()) {
			return Configure_app.getAppid();
		} else if(2 == configureType.get()){
			return Configure_h5.getAppid();
		}else if(3 == configureType.get()){
			return Configure_h5.getXcxappid();
		}else {
			return null;
		}
	}

	public static String getMchid() {
		if (1 == configureType.get()) {
			return Configure_app.getMchid();
		} else {
			return Configure_h5.getMchid();
		}
	}

	public static String getSubMchid() {
		if (1 == configureType.get()) {
			return Configure_app.getSubMchid();
		} else {
			return Configure_h5.getSubMchid();
		}
	}

	public static String getCertLocalPath() {
		if (1 == configureType.get()) {
			return Configure_app.getCertLocalPath();
		} else {
			return Configure_h5.getCertLocalPath();
		}
	}

	public static String getCertPassword() {
		if (1 == configureType.get()) {
			return Configure_app.getCertPassword();
		} else {
			return Configure_h5.getCertPassword();
		}
	}
	public static String getCallBackUrl() {
		if (1 == configureType.get()) {
			return Configure_app.NOTIFY_URL;
		} else {
			return Configure_h5.NOTIFY_URL;
		}
	}

	public static String getIP() {
		return ip;
	}

	public static void setHttpsRequestClassName(String name) {
		HttpsRequestClassName = name;
	}

}
