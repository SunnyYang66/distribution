package com.mfoyou.agent.web.utils.redis;

import java.util.Map;

import org.mfoyou.agent.utils.map.MapObjectTrans;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;




@Service
public class IpSetvice {

	private static String IpPrefix = "IP:";
	private static int SECONDS24=3600*24;

	@Autowired
	private RedisCacheManger redisCacheManger;

	public IpInfoData Ip24hInfo(String ip) throws Exception {
		Map<String, String> map = redisCacheManger.getMapValue(IpPrefix + ip);
		if (map.size() == 0) {
			IpInfoData ipInfoData = new IpInfoData();
			ipInfoData.setIp(ip);
			redisCacheManger.setMapValue(IpPrefix + ip, MapObjectTrans.objectToMap(ipInfoData), SECONDS24);
			return ipInfoData;
		}
		IpInfoData ipInfoData = MapObjectTrans.mapToObject(map, IpInfoData.class);
		return ipInfoData;

	}
	
	public void IncIp24hCount(String ip) throws Exception {		
		redisCacheManger.IncMapKeyValue(IpPrefix + ip, "smsCount", 1, null);
		redisCacheManger.setMapKeyValue(IpPrefix + ip, "lastSmstime", ""+System.currentTimeMillis(), null);
	}

}
