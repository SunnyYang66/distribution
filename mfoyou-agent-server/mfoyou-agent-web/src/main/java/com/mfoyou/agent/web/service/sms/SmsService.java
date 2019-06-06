package com.mfoyou.agent.web.service.sms;

import com.mfoyou.agent.web.service.session.SessionService;
import com.mfoyou.agent.web.utils.network.WebUtils;
import com.mfoyou.agent.web.utils.redis.IpInfoData;
import com.mfoyou.agent.web.utils.redis.IpSetvice;
import com.mfoyou.agent.web.utils.redis.RedisCacheManger;
import com.mfoyou.agent.web.utils.sms.SmsUtils;
import org.mfoyou.agent.utils.common.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;

@Service
public class SmsService {
	
	Logger logger = Logger.getLogger(SmsService.class);

	@Autowired
	IpSetvice ipSetvice;

	@Autowired
	SessionService sessionService;

	@Autowired
	RedisCacheManger redisCacheManger;

	private static Integer ipMinSpace = 15; // 15s
	private static Integer CODEEXPIRE = 600; // 10m
	private static String CODEPREFIX = "PHONECODE:";

	// 0为成功 其它为失败
	public int sendRandSms(HttpServletRequest request, String phoneCode, int type) throws Exception {

		logger.info("sendmessage:"+phoneCode);
		String ip = WebUtils.getIpAddr(request);
		IpInfoData ipInfoData = ipSetvice.Ip24hInfo(ip);
		if (System.currentTimeMillis() - ipInfoData.getLastSmstime() < ipMinSpace) {
			logger.warn("code = -3, ip:="+ip+",phone="+phoneCode);
			return -3;
		}
		String sessionId = SessionService.getSeesionId(request);
		if (sessionService.currentUserId(request) == null) {
			sessionId = phoneCode;
		}
		Integer code = (int) ((1 + Math.random()) * 1000000);
		String sCode = code.toString().substring(1, 7);
		String bei = redisCacheManger.getValue(CODEPREFIX + type + ":" + sessionId);
		boolean ret22 = redisCacheManger.setValue(CODEPREFIX + type + ":" + sessionId, sCode, CODEEXPIRE);
		int ret = SmsUtils.sendSMSCode(phoneCode, sCode, ip,0);
		System.out.println(ret);
		if (ret == 0 && ret22) {
			ipSetvice.IncIp24hCount(ip);
		} else {
			if(bei!=null){
				redisCacheManger.setValue(CODEPREFIX + type + ":" + sessionId, bei, CODEEXPIRE);
			}
			return ret == 0 ? -2 : ret;
		}
		return ret;
	}
	public int sendPassword(HttpServletRequest request,String phone, String phoneCode)  {

		logger.info("sendmessage:"+phone);
		String ip = WebUtils.getIpAddr(request);
		IpInfoData ipInfoData = null;
		try {
			ipInfoData = ipSetvice.Ip24hInfo(ip);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (System.currentTimeMillis() - ipInfoData.getLastSmstime() < ipMinSpace) {
			logger.warn("code = -3, ip:="+ip+",phone="+phoneCode);
			return -3;
		}
		int ret = SmsUtils.sendSMSCode(phone, phoneCode, ip,1);
		System.out.println(ret);
		return ret;
	}
	public int checkPhoneCode(HttpServletRequest request, String phoneCode, String code, int type,boolean bClear) {
		String sessionId = SessionService.getSeesionId(request);
		if (sessionService.currentUserId(request) == null) {
			sessionId = phoneCode;
		}
		String rCode = redisCacheManger.getValue(CODEPREFIX + type + ":" + sessionId);

		if(rCode==null){
			return -1;
		}
		if (rCode.equals(code)) {
			if(bClear){
				redisCacheManger.deleteKey(CODEPREFIX + type + ":" + sessionId);
			}			
			return 0;
		}
		return -12;
	}

}
