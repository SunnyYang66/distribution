package com.boyuanitsm.pay.wxpay.common;

import com.boyuanitsm.pay.PayProperties;

/**
 * User: rizenguo
 * Date: 2014/10/29
 * Time: 14:40
 * 这里放置各种配置数据
 */
public class Configure_h5 {
//这个就是自己要保管好的私有Key了（切记只能放在自己的后台代码里，不能放在任何可能被看到源代码的客户端程序中）
	// 每次自己Post数据给API的时候都要用这个key来对所有字段进行签名，生成的签名会放在Sign这个字段，API收到Post数据的时候也会用同样的签名算法对Post过来的数据进行签名和验证
	// 收到API的返回的时候也要用这个key来对返回的数据算下签名，跟API的Sign数据进行比较，如果值不一致，有可能数据被第三方给篡改

	private static String key = PayProperties.getInstance().getWechat().getKey_h5();
	//微信分配的公众号ID（开通公众号之后可以获取到）
	private static String appID = PayProperties.getInstance().getWechat().getAppid_h5();
	//微信小程序支付  商家端
	private static String xcxappid = PayProperties.getInstance().getWechat().getAppid_wxxcx();
	
	private static String appidwxxcxcustom = PayProperties.getInstance().getWechat().getAppid_wxxcx_custom();
	//微信支付分配的商户号ID（开通公众号的微信支付功能之后可以获取到）
	private static String mchID = PayProperties.getInstance().getWechat().getMchid_h5();
	//受理模式下给子商户分配的子商户号
	private static String subMchID = PayProperties.getInstance().getWechat().getSubmchid_h5();
	//HTTPS证书的本地路径
	private static String certLocalPath = PayProperties.getInstance().getWechat().getCertLocalPath_h5();
	//HTTPS证书密码，默认密码等于商户号MCHID
	private static String certPassword = PayProperties.getInstance().getWechat().getCertPassword_h5();

	//是否使用异步线程的方式来上报API测速，默认为异步模式
	private static boolean useThreadToDoReport = true;

	//机器IP
	private static String ip = PayProperties.getInstance().getWechat().getIp();

	public static String QRCODE_API = "weixin://wxpay/bizpayurl";

	public static String DEVICE_INFO = "WEB";

	public static String NOTIFY_URL = PayProperties.getInstance().getWechat().getNotifyUrl_h5();

	/**
	 * 随机字符串长度
	 */
	public static final int NONCE_STR_LENGTH = 32;

	//以下是几个API的路径：
	//1）被扫支付API
	public static String PAY_API = "https://api.mch.weixin.qq.com/pay/micropay";

	//2）被扫支付查询API
	public static String PAY_QUERY_API = "https://api.mch.weixin.qq.com/pay/orderquery";

	//3）退款API
	public static String REFUND_API = "https://api.mch.weixin.qq.com/secapi/pay/refund";

	//4）退款查询API
	public static String REFUND_QUERY_API = "https://api.mch.weixin.qq.com/pay/refundquery";

	//5）撤销API
	public static String REVERSE_API = "https://api.mch.weixin.qq.com/secapi/pay/reverse";

	//6）下载对账单API
	public static String DOWNLOAD_BILL_API = "https://api.mch.weixin.qq.com/pay/downloadbill";

	//7) 统计上报API
	public static String REPORT_API = "https://api.mch.weixin.qq.com/payitil/report";

	/**
	 * 统一下单API
	 */
	public static String UNIFIFED_ORDER_API = "https://api.mch.weixin.qq.com/pay/unifiedorder";

	public static boolean isUseThreadToDoReport() {
		return useThreadToDoReport;
	}

	public static void setUseThreadToDoReport(boolean useThreadToDoReport) {
		Configure_h5.useThreadToDoReport = useThreadToDoReport;
	}

	public static String HttpsRequestClassName = "com.boyuanitsm.pay.wxpay.common.HttpsRequest";

	public static void setKey(String key) {
		Configure_h5.key = key;
	}

	public static void setAppID(String appID) {
		Configure_h5.appID = appID;
	}

	public static void setMchID(String mchID) {
		Configure_h5.mchID = mchID;
	}

	public static void setSubMchID(String subMchID) {
		Configure_h5.subMchID = subMchID;
	}

	public static void setCertLocalPath(String certLocalPath) {
		Configure_h5.certLocalPath = certLocalPath;
	}

	public static void setCertPassword(String certPassword) {
		Configure_h5.certPassword = certPassword;
	}

	public static void setIp(String ip) {
		Configure_h5.ip = ip;
	}

	public static String getKey(){
		return key;
	}
	
	public static String getAppid(){
		return appID;
	}
	
	public static String getMchid(){
		return mchID;
	}

	public static String getSubMchid(){
		return subMchID;
	}
	
	public static String getCertLocalPath(){
		return certLocalPath;
	}
	
	public static String getCertPassword(){
		return certPassword;
	}

	public static String getIP(){
		return ip;
	}

	public static void setHttpsRequestClassName(String name){
		HttpsRequestClassName = name;
	}

	public static String getXcxappid() {
		return xcxappid;
	}

	public static void setXcxappid(String xcxappid) {
		Configure_h5.xcxappid = xcxappid;
	}

	public static String getAppidwxxcxcustom() {
		return appidwxxcxcustom;
	}

	public static void setAppidwxxcxcustom(String appidwxxcxcustom) {
		Configure_h5.appidwxxcxcustom = appidwxxcxcustom;
	}

}
