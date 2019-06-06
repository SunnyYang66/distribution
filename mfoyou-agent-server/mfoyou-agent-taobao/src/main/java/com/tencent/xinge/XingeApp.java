/*     */ package com.tencent.xinge;

/*     */
/*     */ import java.io.BufferedReader;
/*     */ import java.io.InputStreamReader;
/*     */ import java.math.BigInteger;
/*     */ import java.net.HttpURLConnection;
/*     */ import java.net.SocketTimeoutException;
/*     */ import java.net.URL;
/*     */ import java.net.URLEncoder;
/*     */ import java.security.MessageDigest;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Comparator;
/*     */ import java.util.HashMap;
/*     */ import java.util.List;
/*     */ import java.util.Map;

/*     */ import org.json.JSONArray;
/*     */ import org.json.JSONObject;

/*     */
/*     */ public class XingeApp
/*     */ {
	/*     */ public static final String RESTAPI_PUSHSINGLEDEVICE = "http://openapi.xg.qq.com/v2/push/single_device";
	/*     */ public static final String RESTAPI_PUSHSINGLEACCOUNT = "http://openapi.xg.qq.com/v2/push/single_account";
	/*     */ public static final String RESTAPI_PUSHACCOUNTLIST = "http://openapi.xg.qq.com/v2/push/account_list";
	/*     */ public static final String RESTAPI_PUSHALLDEVICE = "http://openapi.xg.qq.com/v2/push/all_device";
	/*     */ public static final String RESTAPI_PUSHTAGS = "http://openapi.xg.qq.com/v2/push/tags_device";
	/*     */ public static final String RESTAPI_QUERYPUSHSTATUS = "http://openapi.xg.qq.com/v2/push/get_msg_status";
	/*     */ public static final String RESTAPI_QUERYDEVICECOUNT = "http://openapi.xg.qq.com/v2/application/get_app_device_num";
	/*     */ public static final String RESTAPI_QUERYTAGS = "http://openapi.xg.qq.com/v2/tags/query_app_tags";
	/*     */ public static final String RESTAPI_CANCELTIMINGPUSH = "http://openapi.xg.qq.com/v2/push/cancel_timing_task";
	/*     */ public static final String RESTAPI_BATCHSETTAG = "http://openapi.xg.qq.com/v2/tags/batch_set";
	/*     */ public static final String RESTAPI_BATCHDELTAG = "http://openapi.xg.qq.com/v2/tags/batch_del";
	/*     */ public static final String RESTAPI_QUERYTOKENTAGS = "http://openapi.xg.qq.com/v2/tags/query_token_tags";
	/*     */ public static final String RESTAPI_QUERYTAGTOKENNUM = "http://openapi.xg.qq.com/v2/tags/query_tag_token_num";
	/*     */ public static final String RESTAPI_CREATEMULTIPUSH = "http://openapi.xg.qq.com/v2/push/create_multipush";
	/*     */ public static final String RESTAPI_PUSHACCOUNTLISTMULTIPLE = "http://openapi.xg.qq.com/v2/push/account_list_multiple";
	/*     */ public static final String RESTAPI_PUSHDEVICELISTMULTIPLE = "http://openapi.xg.qq.com/v2/push/device_list_multiple";
	/*     */ public static final String RESTAPI_QUERYINFOOFTOKEN = "http://openapi.xg.qq.com/v2/application/get_app_token_info";
	/*     */ public static final String RESTAPI_QUERYTOKENSOFACCOUNT = "http://openapi.xg.qq.com/v2/application/get_app_account_tokens";
	/*     */ public static final String RESTAPI_DELETETOKENOFACCOUNT = "http://openapi.xg.qq.com/v2/application/del_app_account_tokens";
	/*     */ public static final String RESTAPI_DELETEALLTOKENSOFACCOUNT = "http://openapi.xg.qq.com/v2/application/del_app_account_all_tokens";
	/*     */ public static final String HTTP_POST = "POST";
	/*     */ public static final String HTTP_GET = "GET";
	/*     */ public static final int DEVICE_ALL = 0;
	/*     */ public static final int DEVICE_BROWSER = 1;
	/*     */ public static final int DEVICE_PC = 2;
	/*     */ public static final int DEVICE_ANDROID = 3;
	/*     */ public static final int DEVICE_IOS = 4;
	/*     */ public static final int DEVICE_WINPHONE = 5;
	/*     */ public static final int IOSENV_PROD = 1;
	/*     */ public static final int IOSENV_DEV = 2;
	/*     */ public static final long IOS_MIN_ID = 2200000000L;
	/*     */ private long m_accessId;
	/*     */ private String m_secretKey;

	/*     */
	/*     */ public static void main(String[] args)
	/*     */ {
		/* 60 */ System.out.println("Hello Xinge!");
		/*     */ }

	/*     */
	/*     */ public XingeApp(long accessId, String secretKey) {
		/* 64 */ this.m_accessId = accessId;
		/* 65 */ this.m_secretKey = secretKey;
		/*     */ }

	/*     */
	/*     */ protected String generateSign(String method, String url, Map<String, Object> params) {
		/* 69 */ List<Map.Entry<String, Object>> paramList = new ArrayList(params.entrySet());
		/* 70 */ java.util.Collections.sort(paramList, new Comparator() {
			/*     */ public int compare(Map.Entry<String, Object> o1, Map.Entry<String, Object> o2) {
				/* 72 */ return ((String) o1.getKey()).toString().compareTo((String) o2.getKey());
				/*     */ }
			/* 74 */

			@Override
			public int compare(Object o1, Object o2) {
				// TODO Auto-generated method stub
				return compare((Map.Entry<String, Object>) o1,(Map.Entry<String, Object>) o2);
			}
		});
		/* 75 */ String paramStr = "";
		/* 76 */ String md5Str = "";
		/* 77 */ for (Map.Entry<String, Object> entry : paramList) {
			/* 78 */ paramStr = paramStr + (String) entry.getKey() + "=" + entry.getValue().toString();
			/*     */ }
		/*     */ try {
			/* 81 */ URL u = new URL(url);
			/* 82 */ MessageDigest md5 = MessageDigest.getInstance("MD5");
			/* 83 */ String s = method + u.getHost() + u.getPath() + paramStr + this.m_secretKey;
			/* 84 */ byte[] bArr = s.getBytes("UTF-8");
			/* 85 */ byte[] md5Value = md5.digest(bArr);
			/* 86 */ BigInteger bigInt = new BigInteger(1, md5Value);
			/* 87 */ md5Str = bigInt.toString(16);
			/* 88 */ while (md5Str.length() < 32) {
				/* 89 */ md5Str = "0" + md5Str;
				/*     */ }
			/*     */ }
		/*     */ catch (Exception e) {
			/* 93 */ e.printStackTrace();
			/* 94 */ return "";
			/*     */ }
		/* 96 */ return md5Str;
		/*     */ }

	/*     */
	/*     */ protected JSONObject callRestful(String url, Map<String, Object> params)
	/*     */ {
		/* 101 */ String ret = "";
		/* 102 */ JSONObject jsonRet = null;
		/* 103 */ String sign = generateSign("POST", url, params);
		/* 104 */ if (sign.isEmpty())
			return new JSONObject("{\"ret_code\":-1,\"err_msg\":\"generateSign error\"}");
		/* 105 */ params.put("sign", sign);
		/*     */ try {
			/* 107 */ URL u = new URL(url);
			/* 108 */ HttpURLConnection conn = (HttpURLConnection) u.openConnection();
			/* 109 */ conn.setRequestMethod("POST");
			/* 110 */ conn.setConnectTimeout(10000);
			/* 111 */ conn.setReadTimeout(3000);
			/* 112 */ conn.setDoOutput(true);
			/* 113 */ conn.setDoInput(true);
			/* 114 */ conn.setUseCaches(false);
			/* 115 */ StringBuffer param = new StringBuffer();
			/* 116 */ for (String key : params.keySet()) {
				/* 117 */ param.append(key).append("=").append(URLEncoder.encode(params.get(key).toString(), "UTF-8"))
						.append("&");
				/*     */ }
			/* 119 */ conn.getOutputStream().write(param.toString().getBytes("UTF-8"));
			/*     */
			/* 121 */ conn.getOutputStream().flush();
			/* 122 */ conn.getOutputStream().close();
			/* 123 */ InputStreamReader isr = new InputStreamReader(conn.getInputStream());
			/* 124 */ BufferedReader br = new BufferedReader(isr);
			/* 125 */ String temp;
			while ((temp = br.readLine()) != null) {
				/* 126 */ ret = ret + temp;
				/*     */ }
			/* 128 */ br.close();
			/* 129 */ isr.close();
			/* 130 */ conn.disconnect();
			/*     */
			/* 132 */ jsonRet = new JSONObject(ret);
			/*     */ }
		/*     */ catch (SocketTimeoutException e)
		/*     */ {
			/* 136 */ jsonRet = new JSONObject("{\"ret_code\":-1,\"err_msg\":\"call restful timeout\"}");
			/*     */ }
		/*     */ catch (Exception e) {
			/* 139 */ jsonRet = new JSONObject("{\"ret_code\":-1,\"err_msg\":\"call restful error\"}");
			/*     */ }
		/* 141 */ return jsonRet;
		/*     */ }

	/*     */
	/*     */ protected boolean ValidateToken(String token) {
		/* 145 */ if (this.m_accessId >= 2200000000L) {
			/* 146 */ return token.length() == 64;
			/*     */ }
		/* 148 */ return (token.length() == 40) || (token.length() == 64);
		/*     */ }

	/*     */
	/*     */ protected Map<String, Object> InitParams()
	/*     */ {
		/* 153 */ Map<String, Object> params = new HashMap();
		/*     */
		/* 155 */ params.put("access_id", Long.valueOf(this.m_accessId));
		/* 156 */ params.put("timestamp", Long.valueOf(System.currentTimeMillis() / 1000L));
		/*     */
		/* 158 */ return params;
		/*     */ }

	/*     */
	/*     */ protected boolean ValidateMessageType(Message message) {
		/* 162 */ if (this.m_accessId < 2200000000L) {
			/* 163 */ return true;
			/*     */ }
		/* 165 */ return false;
		/*     */ }

	/*     */
	/*     */ protected boolean ValidateMessageType(MessageIOS message, int environment) {
		/* 169 */ if ((this.m_accessId >= 2200000000L) && ((environment == 1) || (environment == 2))) {
			/* 170 */ return true;
			/*     */ }
		/* 172 */ return false;
		/*     */ }

	/*     */
	/*     */
	/*     */
	/*     */
	/*     */
	/*     */
	/*     */
	/*     */
	/*     */
	/*     */
	/*     */
	/*     */
	/*     */
	/*     */
	/*     */
	/*     */ public static JSONObject pushTokenAndroid(long accessId, String secretKey, String title, String content,
			String token)
	/*     */ {
		/* 191 */ Message message = new Message();
		/* 192 */ message.setType(1);
		/* 193 */ message.setTitle(title);
		/* 194 */ message.setContent(content);
		/*     */
		/* 196 */ XingeApp xinge = new XingeApp(accessId, secretKey);
		/* 197 */ JSONObject ret = xinge.pushSingleDevice(token, message);
		/* 198 */ return ret;
		/*     */ }

	/*     */
	/*     */
	/*     */
	/*     */
	/*     */
	/*     */
	/*     */
	/*     */
	/*     */
	/*     */
	/*     */ public static JSONObject pushAccountAndroid(long accessId, String secretKey, String title, String content,
			String account)
	/*     */ {
		/* 212 */ Message message = new Message();
		/* 213 */ message.setType(1);
		/* 214 */ message.setTitle(title);
		/* 215 */ message.setContent(content);
		/*     */
		/* 217 */ XingeApp xinge = new XingeApp(accessId, secretKey);
		/* 218 */ JSONObject ret = xinge.pushSingleAccount(0, account, message);
		/* 219 */ return ret;
		/*     */ }

	/*     */
	/*     */
	/*     */
	/*     */
	/*     */
	/*     */
	/*     */
	/*     */
	/*     */
	/*     */ public static JSONObject pushAllAndroid(long accessId, String secretKey, String title, String content)
	/*     */ {
		/* 232 */ Message message = new Message();
		/* 233 */ message.setType(1);
		/* 234 */ message.setTitle(title);
		/* 235 */ message.setContent(content);
		/*     */
		/* 237 */ XingeApp xinge = new XingeApp(accessId, secretKey);
		/* 238 */ JSONObject ret = xinge.pushAllDevice(0, message);
		/* 239 */ return ret;
		/*     */ }

	/*     */
	/*     */
	/*     */
	/*     */
	/*     */
	/*     */
	/*     */
	/*     */
	/*     */
	/*     */
	/*     */ public static JSONObject pushTagAndroid(long accessId, String secretKey, String title, String content,
			String tag)
	/*     */ {
		/* 253 */ Message message = new Message();
		/* 254 */ message.setType(1);
		/* 255 */ message.setTitle(title);
		/* 256 */ message.setContent(content);
		/*     */
		/* 258 */ XingeApp xinge = new XingeApp(accessId, secretKey);
		/* 259 */ List<String> tagList = new ArrayList();
		/* 260 */ tagList.add(tag);
		/* 261 */ JSONObject ret = xinge.pushTags(0, tagList, "OR", message);
		/* 262 */ return ret;
		/*     */ }

	/*     */
	/*     */
	/*     */
	/*     */
	/*     */
	/*     */
	/*     */
	/*     */
	/*     */
	/*     */
	/*     */ public static JSONObject pushTokenIos(long accessId, String secretKey, String content, String token,
			int env)
	/*     */ {
		/* 276 */ MessageIOS message = new MessageIOS();
		/* 277 */ message.setAlert(content);
		/* 278 */ message.setBadge(1);
		/* 279 */ message.setSound("beep.wav");
		/*     */
		/* 281 */ XingeApp xinge = new XingeApp(accessId, secretKey);
		/* 282 */ JSONObject ret = xinge.pushSingleDevice(token, message, env);
		/* 283 */ return ret;
		/*     */ }

	/*     */
	/*     */
	/*     */
	/*     */
	/*     */
	/*     */
	/*     */
	/*     */
	/*     */
	/*     */
	/*     */ public static JSONObject pushAccountIos(long accessId, String secretKey, String content, String account,
			int env)
	/*     */ {
		/* 297 */ MessageIOS message = new MessageIOS();
		/* 298 */ message.setAlert(content);
		/* 299 */ message.setBadge(1);
		/* 300 */ message.setSound("beep.wav");
		/*     */
		/* 302 */ XingeApp xinge = new XingeApp(accessId, secretKey);
		/* 303 */ JSONObject ret = xinge.pushSingleAccount(0, account, message, env);
		/* 304 */ return ret;
		/*     */ }

	/*     */
	/*     */
	/*     */
	/*     */
	/*     */
	/*     */
	/*     */
	/*     */
	/*     */
	/*     */ public static JSONObject pushAllIos(long accessId, String secretKey, String content, int env)
	/*     */ {
		/* 317 */ MessageIOS message = new MessageIOS();
		/* 318 */ message.setAlert(content);
		/* 319 */ message.setBadge(1);
		/* 320 */ message.setSound("beep.wav");
		/*     */
		/* 322 */ XingeApp xinge = new XingeApp(accessId, secretKey);
		/* 323 */ JSONObject ret = xinge.pushAllDevice(0, message, env);
		/* 324 */ return ret;
		/*     */ }

	/*     */
	/*     */
	/*     */
	/*     */
	/*     */
	/*     */
	/*     */
	/*     */
	/*     */
	/*     */
	/*     */ public static JSONObject pushTagIos(long accessId, String secretKey, String content, String tag, int env)
	/*     */ {
		/* 338 */ MessageIOS message = new MessageIOS();
		/* 339 */ message.setAlert(content);
		/* 340 */ message.setBadge(1);
		/* 341 */ message.setSound("beep.wav");
		/*     */
		/* 343 */ XingeApp xinge = new XingeApp(accessId, secretKey);
		/* 344 */ List<String> tagList = new ArrayList();
		/* 345 */ tagList.add(tag);
		/* 346 */ JSONObject ret = xinge.pushTags(0, tagList, "OR", message, env);
		/* 347 */ return ret;
		/*     */ }

	/*     */
	/*     */
	/*     */
	/*     */
	/*     */
	/*     */
	/*     */
	/*     */
	/*     */
	/*     */
	/*     */ public JSONObject pushSingleDevice(String deviceToken, Message message)
	/*     */ {
		/* 361 */ if (!ValidateMessageType(message)) {
			/* 362 */ return new JSONObject("{'ret_code':-1,'err_msg':'message type error!'}");
			/*     */ }
		/* 364 */ if (!message.isValid()) {
			/* 365 */ return new JSONObject("{'ret_code':-1,'err_msg':'message invalid!'}");
			/*     */ }
		/* 367 */ Map<String, Object> params = new HashMap();
		/* 368 */ params.put("access_id", Long.valueOf(this.m_accessId));
		/* 369 */ params.put("expire_time", Integer.valueOf(message.getExpireTime()));
		/* 370 */ params.put("send_time", message.getSendTime());
		/* 371 */ params.put("multi_pkg", Integer.valueOf(message.getMultiPkg()));
		/* 372 */ params.put("device_token", deviceToken);
		/* 373 */ params.put("message_type", Integer.valueOf(message.getType()));
		/* 374 */ params.put("message", message.toJson());
		/* 375 */ params.put("timestamp", Long.valueOf(System.currentTimeMillis() / 1000L));
		/*     */
		/* 377 */ return callRestful("http://openapi.xg.qq.com/v2/push/single_device", params);
		/*     */ }

	/*     */
	/*     */
	/*     */
	/*     */
	/*     */
	/*     */
	/*     */
	/*     */
	/*     */ public JSONObject pushSingleDevice(String deviceToken, MessageIOS message, int environment)
	/*     */ {
		/* 389 */ if (!ValidateMessageType(message, environment)) {
			/* 390 */ return new JSONObject("{'ret_code':-1,'err_msg':'message type or environment error!'}");
			/*     */ }
		/* 392 */ if (!message.isValid()) {
			/* 393 */ return new JSONObject("{'ret_code':-1,'err_msg':'message invalid!'}");
			/*     */ }
		/* 395 */ Map<String, Object> params = new HashMap();
		/* 396 */ params.put("access_id", Long.valueOf(this.m_accessId));
		/* 397 */ params.put("expire_time", Integer.valueOf(message.getExpireTime()));
		/* 398 */ params.put("send_time", message.getSendTime());
		/* 399 */ params.put("device_token", deviceToken);
		/* 400 */ params.put("message_type", Integer.valueOf(message.getType()));
		/* 401 */ params.put("message", message.toJson());
		/* 402 */ params.put("timestamp", Long.valueOf(System.currentTimeMillis() / 1000L));
		/* 403 */ params.put("environment", Integer.valueOf(environment));
		/*     */
		/* 405 */ if ((message.getLoopInterval() > 0) && (message.getLoopTimes() > 0)) {
			/* 406 */ params.put("loop_interval", Integer.valueOf(message.getLoopInterval()));
			/* 407 */ params.put("loop_times", Integer.valueOf(message.getLoopTimes()));
			/*     */ }
		/*     */
		/* 410 */ return callRestful("http://openapi.xg.qq.com/v2/push/single_device", params);
		/*     */ }

	/*     */
	/*     */
	/*     */
	/*     */
	/*     */
	/*     */
	/*     */
	/*     */
	/*     */ public JSONObject pushSingleAccount(int deviceType, String account, Message message)
	/*     */ {
		/* 422 */ if (!ValidateMessageType(message)) {
			/* 423 */ return new JSONObject("{'ret_code':-1,'err_msg':'message type error!'}");
			/*     */ }
		/* 425 */ if (!message.isValid()) {
			/* 426 */ return new JSONObject("{'ret_code':-1,'err_msg':'message invalid!'}");
			/*     */ }
		/* 428 */ Map<String, Object> params = new HashMap();
		/* 429 */ params.put("access_id", Long.valueOf(this.m_accessId));
		/* 430 */ params.put("expire_time", Integer.valueOf(message.getExpireTime()));
		/* 431 */ params.put("send_time", message.getSendTime());
		/* 432 */ params.put("multi_pkg", Integer.valueOf(message.getMultiPkg()));
		/* 433 */ params.put("device_type", Integer.valueOf(deviceType));
		/* 434 */ params.put("account", account);
		/* 435 */ params.put("message_type", Integer.valueOf(message.getType()));
		/* 436 */ params.put("message", message.toJson());
		/* 437 */ params.put("timestamp", Long.valueOf(System.currentTimeMillis() / 1000L));
		/*     */
		/* 439 */ return callRestful("http://openapi.xg.qq.com/v2/push/single_account", params);
		/*     */ }

	/*     */
	/*     */
	/*     */
	/*     */
	/*     */
	/*     */
	/*     */
	/*     */
	/*     */
	/*     */ public JSONObject pushSingleAccount(int deviceType, String account, MessageIOS message, int environment)
	/*     */ {
		/* 452 */ if (!ValidateMessageType(message, environment)) {
			/* 453 */ return new JSONObject("{'ret_code':-1,'err_msg':'message type or environment error!'}");
			/*     */ }
		/* 455 */ if (!message.isValid()) {
			/* 456 */ return new JSONObject("{'ret_code':-1,'err_msg':'message invalid!'}");
			/*     */ }
		/* 458 */ Map<String, Object> params = new HashMap();
		/* 459 */ params.put("access_id", Long.valueOf(this.m_accessId));
		/* 460 */ params.put("expire_time", Integer.valueOf(message.getExpireTime()));
		/* 461 */ params.put("send_time", message.getSendTime());
		/* 462 */ params.put("device_type", Integer.valueOf(deviceType));
		/* 463 */ params.put("account", account);
		/* 464 */ params.put("message_type", Integer.valueOf(message.getType()));
		/* 465 */ params.put("message", message.toJson());
		/* 466 */ params.put("timestamp", Long.valueOf(System.currentTimeMillis() / 1000L));
		/* 467 */ params.put("environment", Integer.valueOf(environment));
		/*     */
		/* 469 */ return callRestful("http://openapi.xg.qq.com/v2/push/single_account", params);
		/*     */ }

	/*     */
	/*     */
	/*     */
	/*     */
	/*     */
	/*     */
	/*     */
	/*     */
	/*     */
	/*     */ public JSONObject pushAccountList(int deviceType, List<String> accountList, Message message)
	/*     */ {
		/* 482 */ if (!ValidateMessageType(message)) {
			/* 483 */ return new JSONObject("{'ret_code':-1,'err_msg':'message type error!'}");
			/*     */ }
		/* 485 */ if (!message.isValid()) {
			/* 486 */ return new JSONObject("{'ret_code':-1,'err_msg':'message invalid!'}");
			/*     */ }
		/* 488 */ Map<String, Object> params = new HashMap();
		/* 489 */ params.put("access_id", Long.valueOf(this.m_accessId));
		/* 490 */ params.put("expire_time", Integer.valueOf(message.getExpireTime()));
		/* 491 */ params.put("multi_pkg", Integer.valueOf(message.getMultiPkg()));
		/* 492 */ params.put("device_type", Integer.valueOf(deviceType));
		/* 493 */ params.put("account_list", new JSONArray(accountList).toString());
		/* 494 */ params.put("message_type", Integer.valueOf(message.getType()));
		/* 495 */ params.put("message", message.toJson());
		/* 496 */ params.put("timestamp", Long.valueOf(System.currentTimeMillis() / 1000L));
		/*     */
		/* 498 */ return callRestful("http://openapi.xg.qq.com/v2/push/account_list", params);
		/*     */ }

	/*     */
	/*     */
	/*     */
	/*     */
	/*     */
	/*     */
	/*     */
	/*     */
	/*     */
	/*     */
	/*     */ public JSONObject pushAccountList(int deviceType, List<String> accountList, MessageIOS message,
			int environment)
	/*     */ {
		/* 512 */ if (!ValidateMessageType(message, environment)) {
			/* 513 */ return new JSONObject("{'ret_code':-1,'err_msg':'message type or environment error!'}");
			/*     */ }
		/* 515 */ if (!message.isValid()) {
			/* 516 */ return new JSONObject("{'ret_code':-1,'err_msg':'message invalid!'}");
			/*     */ }
		/* 518 */ Map<String, Object> params = new HashMap();
		/* 519 */ params.put("access_id", Long.valueOf(this.m_accessId));
		/* 520 */ params.put("expire_time", Integer.valueOf(message.getExpireTime()));
		/* 521 */ params.put("device_type", Integer.valueOf(deviceType));
		/* 522 */ params.put("account_list", new JSONArray(accountList).toString());
		/* 523 */ params.put("message_type", Integer.valueOf(message.getType()));
		/* 524 */ params.put("message", message.toJson());
		/* 525 */ params.put("timestamp", Long.valueOf(System.currentTimeMillis() / 1000L));
		/* 526 */ params.put("environment", Integer.valueOf(environment));
		/*     */
		/* 528 */ return callRestful("http://openapi.xg.qq.com/v2/push/account_list", params);
		/*     */ }

	/*     */
	/*     */
	/*     */
	/*     */
	/*     */
	/*     */
	/*     */
	/*     */ public JSONObject pushAllDevice(int deviceType, Message message)
	/*     */ {
		/* 539 */ if (!ValidateMessageType(message)) {
			/* 540 */ return new JSONObject("{'ret_code':-1,'err_msg':'message type error!'}");
			/*     */ }
		/* 542 */ if (!message.isValid()) {
			/* 543 */ return new JSONObject("{'ret_code':-1,'err_msg':'message invalid!'}");
			/*     */ }
		/* 545 */ Map<String, Object> params = new HashMap();
		/* 546 */ params.put("access_id", Long.valueOf(this.m_accessId));
		/* 547 */ params.put("expire_time", Integer.valueOf(message.getExpireTime()));
		/* 548 */ params.put("send_time", message.getSendTime());
		/* 549 */ params.put("multi_pkg", Integer.valueOf(message.getMultiPkg()));
		/* 550 */ params.put("device_type", Integer.valueOf(deviceType));
		/* 551 */ params.put("message_type", Integer.valueOf(message.getType()));
		/* 552 */ params.put("message", message.toJson());
		/* 553 */ params.put("timestamp", Long.valueOf(System.currentTimeMillis() / 1000L));
		/*     */
		/* 555 */ if ((message.getLoopInterval() > 0) && (message.getLoopTimes() > 0)) {
			/* 556 */ params.put("loop_interval", Integer.valueOf(message.getLoopInterval()));
			/* 557 */ params.put("loop_times", Integer.valueOf(message.getLoopTimes()));
			/*     */ }
		/*     */
		/* 560 */ return callRestful("http://openapi.xg.qq.com/v2/push/all_device", params);
		/*     */ }

	/*     */
	/*     */
	/*     */
	/*     */
	/*     */
	/*     */
	/*     */
	/*     */
	/*     */ public JSONObject pushAllDevice(int deviceType, MessageIOS message, int environment)
	/*     */ {
		/* 572 */ if (!ValidateMessageType(message, environment)) {
			/* 573 */ return new JSONObject("{'ret_code':-1,'err_msg':'message type or environment error!'}");
			/*     */ }
		/* 575 */ if (!message.isValid()) {
			/* 576 */ return new JSONObject("{'ret_code':-1,'err_msg':'message invalid!'}");
			/*     */ }
		/* 578 */ Map<String, Object> params = new HashMap();
		/* 579 */ params.put("access_id", Long.valueOf(this.m_accessId));
		/* 580 */ params.put("expire_time", Integer.valueOf(message.getExpireTime()));
		/* 581 */ params.put("send_time", message.getSendTime());
		/* 582 */ params.put("device_type", Integer.valueOf(deviceType));
		/* 583 */ params.put("message_type", Integer.valueOf(message.getType()));
		/* 584 */ params.put("message", message.toJson());
		/* 585 */ params.put("timestamp", Long.valueOf(System.currentTimeMillis() / 1000L));
		/* 586 */ params.put("environment", Integer.valueOf(environment));
		/*     */
		/* 588 */ if ((message.getLoopInterval() > 0) && (message.getLoopTimes() > 0)) {
			/* 589 */ params.put("loop_interval", Integer.valueOf(message.getLoopInterval()));
			/* 590 */ params.put("loop_times", Integer.valueOf(message.getLoopTimes()));
			/*     */ }
		/*     */
		/* 593 */ return callRestful("http://openapi.xg.qq.com/v2/push/all_device", params);
		/*     */ }

	/*     */
	/*     */
	/*     */
	/*     */
	/*     */
	/*     */
	/*     */
	/*     */
	/*     */
	/*     */ public JSONObject pushTags(int deviceType, List<String> tagList, String tagOp, Message message)
	/*     */ {
		/* 606 */ if (!ValidateMessageType(message)) {
			/* 607 */ return new JSONObject("{'ret_code':-1,'err_msg':'message type error!'}");
			/*     */ }
		/* 609 */ if ((!message.isValid()) || (tagList.size() == 0)
				|| ((!tagOp.equals("AND")) && (!tagOp.equals("OR")))) {
			/* 610 */ return new JSONObject("{'ret_code':-1,'err_msg':'param invalid!'}");
			/*     */ }
		/* 612 */ Map<String, Object> params = new HashMap();
		/* 613 */ params.put("access_id", Long.valueOf(this.m_accessId));
		/* 614 */ params.put("expire_time", Integer.valueOf(message.getExpireTime()));
		/* 615 */ params.put("send_time", message.getSendTime());
		/* 616 */ params.put("multi_pkg", Integer.valueOf(message.getMultiPkg()));
		/* 617 */ params.put("device_type", Integer.valueOf(deviceType));
		/* 618 */ params.put("message_type", Integer.valueOf(message.getType()));
		/* 619 */ params.put("tags_list", new JSONArray(tagList).toString());
		/* 620 */ params.put("tags_op", tagOp);
		/* 621 */ params.put("message", message.toJson());
		/* 622 */ params.put("timestamp", Long.valueOf(System.currentTimeMillis() / 1000L));
		/*     */
		/* 624 */ if ((message.getLoopInterval() > 0) && (message.getLoopTimes() > 0)) {
			/* 625 */ params.put("loop_interval", Integer.valueOf(message.getLoopInterval()));
			/* 626 */ params.put("loop_times", Integer.valueOf(message.getLoopTimes()));
			/*     */ }
		/*     */
		/* 629 */ return callRestful("http://openapi.xg.qq.com/v2/push/tags_device", params);
		/*     */ }

	/*     */
	/*     */
	/*     */
	/*     */
	/*     */
	/*     */
	/*     */
	/*     */
	/*     */
	/*     */
	/*     */ public JSONObject pushTags(int deviceType, List<String> tagList, String tagOp, MessageIOS message,
			int environment)
	/*     */ {
		/* 643 */ if (!ValidateMessageType(message, environment)) {
			/* 644 */ return new JSONObject("{'ret_code':-1,'err_msg':'message type or environment error!'}");
			/*     */ }
		/* 646 */ if ((!message.isValid()) || (tagList.size() == 0)
				|| ((!tagOp.equals("AND")) && (!tagOp.equals("OR")))) {
			/* 647 */ return new JSONObject("{'ret_code':-1,'err_msg':'param invalid!'}");
			/*     */ }
		/* 649 */ Map<String, Object> params = new HashMap();
		/* 650 */ params.put("access_id", Long.valueOf(this.m_accessId));
		/* 651 */ params.put("expire_time", Integer.valueOf(message.getExpireTime()));
		/* 652 */ params.put("send_time", message.getSendTime());
		/* 653 */ params.put("device_type", Integer.valueOf(deviceType));
		/* 654 */ params.put("message_type", Integer.valueOf(message.getType()));
		/* 655 */ params.put("tags_list", new JSONArray(tagList).toString());
		/* 656 */ params.put("tags_op", tagOp);
		/* 657 */ params.put("message", message.toJson());
		/* 658 */ params.put("timestamp", Long.valueOf(System.currentTimeMillis() / 1000L));
		/* 659 */ params.put("environment", Integer.valueOf(environment));
		/*     */
		/* 661 */ if ((message.getLoopInterval() > 0) && (message.getLoopTimes() > 0)) {
			/* 662 */ params.put("loop_interval", Integer.valueOf(message.getLoopInterval()));
			/* 663 */ params.put("loop_times", Integer.valueOf(message.getLoopTimes()));
			/*     */ }
		/*     */
		/* 666 */ return callRestful("http://openapi.xg.qq.com/v2/push/tags_device", params);
		/*     */ }

	/*     */
	/*     */
	/*     */
	/*     */
	/*     */
	/*     */
	/*     */
	/*     */ public JSONObject createMultipush(Message message)
	/*     */ {
		/* 677 */ if (!ValidateMessageType(message)) {
			/* 678 */ return new JSONObject("{'ret_code':-1,'err_msg':'message type error!'}");
			/*     */ }
		/* 680 */ if (!message.isValid()) {
			/* 681 */ return new JSONObject("{'ret_code':-1,'err_msg':'message invalid!'}");
			/*     */ }
		/* 683 */ Map<String, Object> params = new HashMap();
		/* 684 */ params.put("access_id", Long.valueOf(this.m_accessId));
		/* 685 */ params.put("expire_time", Integer.valueOf(message.getExpireTime()));
		/* 686 */ params.put("multi_pkg", Integer.valueOf(message.getMultiPkg()));
		/* 687 */ params.put("message_type", Integer.valueOf(message.getType()));
		/* 688 */ params.put("message", message.toJson());
		/* 689 */ params.put("timestamp", Long.valueOf(System.currentTimeMillis() / 1000L));
		/*     */
		/* 691 */ return callRestful("http://openapi.xg.qq.com/v2/push/create_multipush", params);
		/*     */ }

	/*     */
	/*     */
	/*     */
	/*     */
	/*     */
	/*     */
	/*     */
	/*     */
	/*     */ public JSONObject createMultipush(MessageIOS message, int environment)
	/*     */ {
		/* 703 */ if (!ValidateMessageType(message, environment)) {
			/* 704 */ return new JSONObject("{'ret_code':-1,'err_msg':'message type or environment error!'}");
			/*     */ }
		/* 706 */ if (!message.isValid()) {
			/* 707 */ return new JSONObject("{'ret_code':-1,'err_msg':'message invalid!'}");
			/*     */ }
		/* 709 */ Map<String, Object> params = new HashMap();
		/* 710 */ params.put("access_id", Long.valueOf(this.m_accessId));
		/* 711 */ params.put("expire_time", Integer.valueOf(message.getExpireTime()));
		/* 712 */ params.put("message_type", Integer.valueOf(message.getType()));
		/* 713 */ params.put("message", message.toJson());
		/* 714 */ params.put("timestamp", Long.valueOf(System.currentTimeMillis() / 1000L));
		/* 715 */ params.put("environment", Integer.valueOf(environment));
		/*     */
		/* 717 */ return callRestful("http://openapi.xg.qq.com/v2/push/create_multipush", params);
		/*     */ }

	/*     */
	/*     */
	/*     */
	/*     */
	/*     */
	/*     */
	/*     */
	/*     */
	/*     */ public JSONObject pushAccountListMultiple(long pushId, List<String> accountList)
	/*     */ {
		/* 729 */ if (pushId <= 0L) {
			/* 730 */ return new JSONObject("{'ret_code':-1,'err_msg':'pushId invalid!'}");
			/*     */ }
		/* 732 */ Map<String, Object> params = new HashMap();
		/* 733 */ params.put("access_id", Long.valueOf(this.m_accessId));
		/* 734 */ params.put("push_id", Long.valueOf(pushId));
		/* 735 */ params.put("account_list", new JSONArray(accountList).toString());
		/* 736 */ params.put("timestamp", Long.valueOf(System.currentTimeMillis() / 1000L));
		/*     */
		/* 738 */ return callRestful("http://openapi.xg.qq.com/v2/push/account_list_multiple", params);
		/*     */ }

	/*     */
	/*     */
	/*     */
	/*     */
	/*     */
	/*     */
	/*     */
	/*     */
	/*     */ public JSONObject pushDeviceListMultiple(long pushId, List<String> deviceList)
	/*     */ {
		/* 750 */ if (pushId <= 0L) {
			/* 751 */ return new JSONObject("{'ret_code':-1,'err_msg':'pushId invalid!'}");
			/*     */ }
		/* 753 */ Map<String, Object> params = new HashMap();
		/* 754 */ params.put("access_id", Long.valueOf(this.m_accessId));
		/* 755 */ params.put("push_id", Long.valueOf(pushId));
		/* 756 */ params.put("device_list", new JSONArray(deviceList).toString());
		/* 757 */ params.put("timestamp", Long.valueOf(System.currentTimeMillis() / 1000L));
		/*     */
		/* 759 */ return callRestful("http://openapi.xg.qq.com/v2/push/device_list_multiple", params);
		/*     */ }

	/*     */
	/*     */
	/*     */
	/*     */
	/*     */
	/*     */
	/*     */ public JSONObject queryPushStatus(List<String> pushIdList)
	/*     */ {
		/* 769 */ Map<String, Object> params = new HashMap();
		/* 770 */ params.put("access_id", Long.valueOf(this.m_accessId));
		/* 771 */ params.put("timestamp", Long.valueOf(System.currentTimeMillis() / 1000L));
		/* 772 */ JSONArray jArray = new JSONArray();
		/* 773 */ for (String pushId : pushIdList) {
			/* 774 */ JSONObject js = new JSONObject();
			/* 775 */ js.put("push_id", pushId);
			/* 776 */ jArray.put(js);
			/*     */ }
		/* 778 */ params.put("push_ids", jArray.toString());
		/*     */
		/* 780 */ return callRestful("http://openapi.xg.qq.com/v2/push/get_msg_status", params);
		/*     */ }

	/*     */
	/*     */
	/*     */
	/*     */
	/*     */
	/*     */ public JSONObject queryDeviceCount()
	/*     */ {
		/* 789 */ Map<String, Object> params = new HashMap();
		/* 790 */ params.put("access_id", Long.valueOf(this.m_accessId));
		/* 791 */ params.put("timestamp", Long.valueOf(System.currentTimeMillis() / 1000L));
		/*     */
		/* 793 */ return callRestful("http://openapi.xg.qq.com/v2/application/get_app_device_num", params);
		/*     */ }

	/*     */
	/*     */
	/*     */
	/*     */
	/*     */
	/*     */
	/*     */
	/*     */ public JSONObject queryTags(int start, int limit)
	/*     */ {
		/* 804 */ Map<String, Object> params = new HashMap();
		/* 805 */ params.put("access_id", Long.valueOf(this.m_accessId));
		/* 806 */ params.put("start", Integer.valueOf(start));
		/* 807 */ params.put("limit", Integer.valueOf(limit));
		/* 808 */ params.put("timestamp", Long.valueOf(System.currentTimeMillis() / 1000L));
		/*     */
		/* 810 */ return callRestful("http://openapi.xg.qq.com/v2/tags/query_app_tags", params);
		/*     */ }

	/*     */
	/*     */
	/*     */
	/*     */
	/*     */
	/*     */ public JSONObject queryTags()
	/*     */ {
		/* 819 */ return queryTags(0, 100);
		/*     */ }

	/*     */
	/*     */
	/*     */
	/*     */
	/*     */
	/*     */
	/*     */ public JSONObject queryTagTokenNum(String tag)
	/*     */ {
		/* 829 */ Map<String, Object> params = new HashMap();
		/* 830 */ params.put("access_id", Long.valueOf(this.m_accessId));
		/* 831 */ params.put("tag", tag);
		/* 832 */ params.put("timestamp", Long.valueOf(System.currentTimeMillis() / 1000L));
		/*     */
		/* 834 */ return callRestful("http://openapi.xg.qq.com/v2/tags/query_tag_token_num", params);
		/*     */ }

	/*     */
	/*     */
	/*     */
	/*     */
	/*     */
	/*     */
	/*     */ public JSONObject queryTokenTags(String deviceToken)
	/*     */ {
		/* 844 */ Map<String, Object> params = new HashMap();
		/* 845 */ params.put("access_id", Long.valueOf(this.m_accessId));
		/* 846 */ params.put("device_token", deviceToken);
		/* 847 */ params.put("timestamp", Long.valueOf(System.currentTimeMillis() / 1000L));
		/*     */
		/* 849 */ return callRestful("http://openapi.xg.qq.com/v2/tags/query_token_tags", params);
		/*     */ }

	/*     */
	/*     */
	/*     */
	/*     */
	/*     */
	/*     */
	/*     */ public JSONObject cancelTimingPush(String pushId)
	/*     */ {
		/* 859 */ Map<String, Object> params = new HashMap();
		/* 860 */ params.put("access_id", Long.valueOf(this.m_accessId));
		/* 861 */ params.put("push_id", pushId);
		/* 862 */ params.put("timestamp", Long.valueOf(System.currentTimeMillis() / 1000L));
		/*     */
		/* 864 */ return callRestful("http://openapi.xg.qq.com/v2/push/cancel_timing_task", params);
		/*     */ }

	/*     */
	/*     */
	/*     */
	/*     */
	/*     */
	/*     */
	/*     */
	/*     */ public JSONObject BatchSetTag(List<TagTokenPair> tagTokenPairs)
	/*     */ {
		/* 875 */ for (TagTokenPair pair : tagTokenPairs) {
			/* 876 */ if (!ValidateToken(pair.token)) {
				/* 877 */ String returnMsgJsonStr = String.format("{\"ret_code\":-1,\"err_msg\":\"invalid token %s\"}",
						new Object[] { pair.token });
				/* 878 */ return new JSONObject(returnMsgJsonStr);
				/*     */ }
			/*     */ }
		/*     */ String returnMsgJsonStr;
		/* 882 */ Object params = InitParams();
		/*     */
		/* 884 */ List<List> tag_token_list = new ArrayList();
		/*     */
		/* 886 */ for (TagTokenPair pair : tagTokenPairs) {
			/* 887 */ List<String> singleTagToken = new ArrayList();
			/* 888 */ singleTagToken.add(pair.tag);
			/* 889 */ singleTagToken.add(pair.token);
			/*     */
			/* 891 */ tag_token_list.add(singleTagToken);
			/*     */ }
		/*     */
		/* 894 */ ((Map) params).put("tag_token_list", new JSONArray(tag_token_list).toString());
		/*     */
		/* 896 */ return callRestful("http://openapi.xg.qq.com/v2/tags/batch_set", (Map) params);
		/*     */ }

	/*     */
	/*     */
	/*     */
	/*     */
	/*     */
	/*     */
	/*     */
	/*     */ public JSONObject BatchDelTag(List<TagTokenPair> tagTokenPairs)
	/*     */ {
		/* 907 */ for (TagTokenPair pair : tagTokenPairs) {
			/* 908 */ if (!ValidateToken(pair.token)) {
				/* 909 */ String returnMsgJsonStr = String.format("{\"ret_code\":-1,\"err_msg\":\"invalid token %s\"}",
						new Object[] { pair.token });
				/* 910 */ return new JSONObject(returnMsgJsonStr);
				/*     */ }
			/*     */ }
		/*     */ String returnMsgJsonStr;
		/* 914 */ Object params = InitParams();
		/*     */
		/* 916 */ List<List> tag_token_list = new ArrayList();
		/*     */
		/* 918 */ for (TagTokenPair pair : tagTokenPairs) {
			/* 919 */ List<String> singleTagToken = new ArrayList();
			/* 920 */ singleTagToken.add(pair.tag);
			/* 921 */ singleTagToken.add(pair.token);
			/*     */
			/* 923 */ tag_token_list.add(singleTagToken);
			/*     */ }
		/*     */
		/* 926 */ ((Map) params).put("tag_token_list", new JSONArray(tag_token_list).toString());
		/*     */
		/* 928 */ return callRestful("http://openapi.xg.qq.com/v2/tags/batch_del", (Map) params);
		/*     */ }

	/*     */
	/*     */
	/*     */
	/*     */
	/*     */
	/*     */
	/*     */ public JSONObject queryInfoOfToken(String deviceToken)
	/*     */ {
		/* 938 */ Map<String, Object> params = new HashMap();
		/* 939 */ params.put("access_id", Long.valueOf(this.m_accessId));
		/* 940 */ params.put("device_token", deviceToken);
		/* 941 */ params.put("timestamp", Long.valueOf(System.currentTimeMillis() / 1000L));
		/*     */
		/* 943 */ return callRestful("http://openapi.xg.qq.com/v2/application/get_app_token_info", params);
		/*     */ }

	/*     */
	/*     */
	/*     */
	/*     */
	/*     */
	/*     */
	/*     */ public JSONObject queryTokensOfAccount(String account)
	/*     */ {
		/* 953 */ Map<String, Object> params = new HashMap();
		/* 954 */ params.put("access_id", Long.valueOf(this.m_accessId));
		/* 955 */ params.put("account", account);
		/* 956 */ params.put("timestamp", Long.valueOf(System.currentTimeMillis() / 1000L));
		/*     */
		/* 958 */ return callRestful("http://openapi.xg.qq.com/v2/application/get_app_account_tokens", params);
		/*     */ }

	/*     */
	/*     */
	/*     */
	/*     */
	/*     */
	/*     */
	/*     */
	/*     */ public JSONObject deleteTokenOfAccount(String account, String deviceToken)
	/*     */ {
		/* 969 */ Map<String, Object> params = new HashMap();
		/* 970 */ params.put("access_id", Long.valueOf(this.m_accessId));
		/* 971 */ params.put("account", account);
		/* 972 */ params.put("device_token", deviceToken);
		/* 973 */ params.put("timestamp", Long.valueOf(System.currentTimeMillis() / 1000L));
		/*     */
		/* 975 */ return callRestful("http://openapi.xg.qq.com/v2/application/del_app_account_tokens", params);
		/*     */ }

	/*     */
	/*     */
	/*     */
	/*     */
	/*     */
	/*     */
	/*     */ public JSONObject deleteAllTokensOfAccount(String account)
	/*     */ {
		/* 985 */ Map<String, Object> params = new HashMap();
		/* 986 */ params.put("access_id", Long.valueOf(this.m_accessId));
		/* 987 */ params.put("account", account);
		/* 988 */ params.put("timestamp", Long.valueOf(System.currentTimeMillis() / 1000L));
		/*     */
		/* 990 */ return callRestful("http://openapi.xg.qq.com/v2/application/del_app_account_all_tokens", params);
		/*     */ }
	/*     */ }

/*
 * Location:
 * C:\Users\Administrator\Desktop\Xg-Push-SDK-JAVA-1.1.8\PushJavaSDK.jar!\com\
 * tencent\xinge\XingeApp.class Java compiler version: 6 (50.0) JD-Core Version:
 * 0.7.1
 */