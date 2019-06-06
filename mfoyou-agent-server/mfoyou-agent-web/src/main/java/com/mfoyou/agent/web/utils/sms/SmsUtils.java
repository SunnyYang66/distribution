package com.mfoyou.agent.web.utils.sms;

import org.junit.Test;
import org.mfoyou.agent.utils.common.Logger;

import com.alibaba.fastjson.JSON;
import com.aliyuncs.DefaultAcsClient;
import com.aliyuncs.IAcsClient;
import com.aliyuncs.dysmsapi.model.v20170525.SendSmsRequest;
import com.aliyuncs.dysmsapi.model.v20170525.SendSmsResponse;
import com.aliyuncs.exceptions.ClientException;
import com.aliyuncs.exceptions.ServerException;
import com.aliyuncs.http.MethodType;
import com.aliyuncs.profile.DefaultProfile;
import com.aliyuncs.profile.IClientProfile;

/**
 * 此类用于发送短信验证码
 * 
 * @author yp-tc-m-2681
 *
 */
public class SmsUtils {

	private static Logger logger = new Logger(SmsUtils.class);

	private static final String SIGN_NAME = "国通通讯";
	private static final String app_sercrete = "9cF0Me6ZYCJMg5lp2gjszA9R4MlcaV";
	private static final String APP_key = "LTAIOrG2qKxixO9C";
	private static final String product = "Dysmsapi";// 短信API产品名称（短信产品名固定，无需修改）
	private static final String domain = "dysmsapi.aliyuncs.com";// 短信API产品域名（接口地址固定，无需修改）

	/**
	 * 此方法用于正式环境短信验证码发送
	 * 
	 * @param phoneNum
	 *            手机号码
	 * @param message
	 *            需要发送的消息
	 * @return true表示发送成功，false表示发送失败
	 * @throws Exception
	 */
	public static int sendSMSCode(String phoneNumber, String code, String extenId, int type) {
		IClientProfile profile = DefaultProfile.getProfile("cn-hangzhou", APP_key, app_sercrete);
		try {
			DefaultProfile.addEndpoint("cn-hangzhou", "cn-hangzhou", product, domain);
		} catch (ClientException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		IAcsClient acsClient = new DefaultAcsClient(profile);
		SendSmsRequest request = new SendSmsRequest();
		request.setMethod(MethodType.POST);
		request.setPhoneNumbers(phoneNumber);
		request.setSignName(SIGN_NAME);
		request.setTemplateCode("SMS_143705342");
		request.setTemplateParam("{\"number\":\"" + code + "\"}");
		SendSmsResponse sendSmsResponse = null;
		try {
			sendSmsResponse = acsClient.getAcsResponse(request);
		} catch (ServerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClientException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (sendSmsResponse.getCode() != null && sendSmsResponse.getCode().equals("OK")) {
			return 0;
		} else {
			logger.info(JSON.toJSONString(sendSmsResponse));
			return -32;
		}
	}

	//
	@Test
	public void test() {
		try {
			int sendSMSCode = sendSMSCode("18380448141", "123233", "", -99);
			System.out.println(sendSMSCode);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
