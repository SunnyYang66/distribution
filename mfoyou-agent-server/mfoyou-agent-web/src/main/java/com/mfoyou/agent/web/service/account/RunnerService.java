package com.mfoyou.agent.web.service.account;

import java.util.Date;

import org.mfoyou.agent.common.dao.domain.HuawuUser;
import org.mfoyou.agent.common.dao.domain.HuawuWorker;
import org.mfoyou.agent.common.inf.IAccount;
import org.mfoyou.agent.utils.json.JSONMaker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONObject;

@Service
public class RunnerService {
	@Autowired
	IAccount iAccount;

	public JSONObject getWorkKeysInfo(int workerId, String[] keys) {
		HuawuWorker mfoyouWorker = iAccount.getWorkerInfo(workerId);
		HuawuUser mfoyouUser = iAccount.getUserInfoByUserId(workerId);
		JSONObject temp = JSONMaker.mergeJson(mfoyouWorker, mfoyouUser);
		JSONObject ret = new JSONObject();
		for (String key : keys) {
			ret.put(key, temp.get(key));
		}
		return ret;
	}
	public static void main(String[] args) {
		HuawuWorker huawuWorker = new HuawuWorker();
//		huawuWorker.setAgentId(6);
		huawuWorker.setWorkerAddress("hdsad");
		HuawuUser huawuUser = new HuawuUser();
		huawuUser.setUserId(5);
		huawuUser.setUserHeadUrl("sdsada");
		huawuUser.setUserLastLogin(new Date());
		huawuUser.setAgentId(9);
		JSONObject temp = JSONMaker.mergeJson(huawuWorker, huawuUser);
		System.out.println(temp.toJSONString());
	}
}
