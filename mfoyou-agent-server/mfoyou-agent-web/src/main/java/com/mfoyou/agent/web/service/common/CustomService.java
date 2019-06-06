package com.mfoyou.agent.web.service.common;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.mfoyou.agent.common.dao.domain.HuawuStoreInfo;
import org.mfoyou.agent.common.inf.IStore;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mfoyou.agent.web.utils.redis.RedisCacheManger;

@Service
public class CustomService {
	@Autowired
	IStore iStore;
	@Autowired
	RedisCacheManger redisCacheManger;
	private static final String IP_PRE = "store_ip_list";
	private static final String STORE_VISITER_COUNT = "store:visitor:"; 
	private static final String STORE_LOGIN_USERCOUNT="store:user:";
	public HuawuStoreInfo getStoreInfo(int storeId) {
		return iStore.getStoreInfo(storeId);
	}
	public void checkIpaddr(String ipAddr, Integer storeId) {
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMdd");
		redisCacheManger.getIncr(STORE_VISITER_COUNT+storeId+":"+simpleDateFormat.format(new Date()));
		String value = redisCacheManger.getValue(IP_PRE+":"+storeId+":"+ipAddr);
		if(value!=null){
			redisCacheManger.getIncr(STORE_LOGIN_USERCOUNT+storeId+":"+simpleDateFormat.format(new Date()));
		}
		redisCacheManger.getIncr(IP_PRE+":"+storeId+":"+ipAddr, 1800);
	}
//	public void addUsercount(Integer storeId) {
//		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMdd");
//		redisCacheManger.getIncr(STORE_LOGIN_USERCOUNT+storeId+":"+simpleDateFormat.format(new Date()));
//	}
}
