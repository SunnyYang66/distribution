package com.mfoyou.agent.web.service.account;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mfoyou.agent.common.dao.domain.HuawuAgentStoreSetting;
import org.mfoyou.agent.common.dao.domain.HuawuIdcardInfo;
import org.mfoyou.agent.common.dao.domain.HuawuServicePrice;
import org.mfoyou.agent.common.dao.domain.HuawuWorker;
import org.mfoyou.agent.common.dao.domain.MfoyouStationMaster;
import org.mfoyou.agent.common.entity.HuawuAgentWorkerData;
import org.mfoyou.agent.common.entity.MfoyouOrderStatic;
import org.mfoyou.agent.common.inf.IAccount;
import org.mfoyou.agent.common.inf.IIdentity;
import org.mfoyou.agent.common.inf.IPayment;
import org.mfoyou.agent.common.inf.IStatistics;
import org.mfoyou.agent.common.inf.IStore;
import org.mfoyou.agent.utils.common.ArrayListObject;
import org.mfoyou.agent.utils.common.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.mfoyou.agent.web.utils.redis.RedisCacheManger;

@Service
public class AgentService {
	@Autowired
	IIdentity iIdentity;
	@Autowired
	IAccount iAccount;
	@Autowired
	RedisCacheManger redisCacheManger;
	@Autowired
	IStore iStore;
	@Autowired
	IStatistics iStatistics;
	@Autowired
	IPayment iPayment;
	Logger logger = Logger.getLogger(AgentService.class);

//	private static final String AGENT_INFO_PRE = "agent:info:";
	private static final String AGENT_TYPE_INFO = "agent:type:info:";
	public HuawuServicePrice getConfigurePrice(Integer agentId, boolean b) {
		
		return iIdentity.getServicePrice(agentId);
	}
	public ArrayListObject<?> getMfoyouWorkerListV2(HuawuWorker mfoyouWorker, Integer pageId, Integer pageSize,
			Date sdate, Date eDate) {
		ArrayListObject<?> mfoyouWorkerListV2 = iIdentity.getMfoyouWorkerListV2(mfoyouWorker, pageId, pageSize, sdate, eDate);
		return mfoyouWorkerListV2;
	}

	public ArrayListObject<HuawuAgentWorkerData> getMfoyouWorkerListV3(HuawuWorker mfoyouWorker, Integer pageId, Integer pageSize) {
		ArrayListObject<HuawuAgentWorkerData> mfoyouWorkerListV3 = iIdentity.getMfoyouWorkerListV3(mfoyouWorker,pageId,pageSize);
		for(HuawuAgentWorkerData mfoyouAgentWorkerData:mfoyouWorkerListV3){
			Integer userId = mfoyouAgentWorkerData.getUserId();
			HuawuIdcardInfo idcardInfo = getIdcardInfo(userId);
			if(idcardInfo!=null)
			mfoyouAgentWorkerData.setWorkerName(idcardInfo.getUserTrueName());
			Map<String, String> map = redisCacheManger.getMapValue("u:" +userId);
			if(map!=null){
				if(map.get("lon")!=null && map.get("lat")!=null){
					logger.info(mfoyouAgentWorkerData.getUserId()+"");
					mfoyouAgentWorkerData.setWorkerLong(Double.parseDouble(map.get("lon")));
					mfoyouAgentWorkerData.setWorkerLat(Double.parseDouble(map.get("lat")));
				}
				mfoyouAgentWorkerData.setUserHeadUrl(map.get("userHeadUrl"));
				mfoyouAgentWorkerData.setNickName(map.get("userNickName"));
			}
		}
		return mfoyouWorkerListV3;
	}
	private HuawuIdcardInfo getIdcardInfo(Integer userId) {
		return iAccount.getIdcardInfo(userId);
	}
	public int updatePriceV2ByagentId(HuawuServicePrice mfoyouServicePricev2) {
		return iIdentity.updatePriceV2ByagentId(mfoyouServicePricev2);
	}
	public ArrayList<String> getTypeList(String typename, Integer agentid) {
		if(agentid == null){
			return null;
		}
		String agentTypeInfo = getAgentTypeInfo(agentid);
		if(agentTypeInfo==null || agentTypeInfo.equals("null")){
			return null;
		}
		ArrayList<String> types = new ArrayList<>();
		JSONObject jsonObject4 = JSONObject.parseObject(agentTypeInfo);
		JSONArray jsonArray1 = jsonObject4.getJSONArray("classify");
		for(int i = 0;i<jsonArray1.size();i++){
			JSONObject jsonObject = jsonArray1.getJSONObject(i);
			String typeName1 = jsonObject.getString("typeName");
			if(!typeName1.equals(typename)){
				continue;
			}
			JSONArray jsonArray = jsonObject.getJSONArray("storeTypes");
			for(int j = 0;j<jsonArray.size();j++){
				JSONObject jsonObject2 = jsonArray.getJSONObject(j);
				types.add(jsonObject2.getString("typeName"));
			}
		}
		return types;
	}
	public String getAgentTypeInfo(Integer agentid) {
		String value = redisCacheManger.getValue(AGENT_TYPE_INFO+agentid);
		if(value==null){
			value = iStore.getAgentTypeInfo(agentid);
//			if(value==null){
//				value = redisCacheManger.getValue(AGENT_TYPE_INFO+0);
//				if(value==null){
//					value = "null";
//				}
//			}
			redisCacheManger.setValue(AGENT_TYPE_INFO+agentid, value, Integer.MAX_VALUE);
		}
		return value;
	}
	public HuawuAgentStoreSetting getAgentSetting(Integer agentId) {
		return iIdentity.getSpecialSettingV1(agentId);
	}
	public int updateMfoyouAgentSetting(HuawuAgentStoreSetting mfoyouAgentStoreSetting) {
		
		return iIdentity.updateMfoyouAgentSetting(mfoyouAgentStoreSetting);
	}
	public HashMap<String, Object> getAgentMoneyDate(Integer agenid, int userType) {
		HashMap<String , Object> hashMap  = new HashMap<>();
		List<MfoyouOrderStatic> orderStatistics = iStatistics.getServiceAgentMoney(agenid,null,userType);
		hashMap.put("weekdata", orderStatistics);
		return hashMap;
	}
	public ArrayListObject<?> getStationMaster(MfoyouStationMaster mfoyouStationMaster, Date sDate, Date eDate,
			Integer pageSize, Integer pageId) {
		return iIdentity.getStationMaster(mfoyouStationMaster,sDate,eDate,pageSize,pageId);
	}
	public int updateByAgent(MfoyouStationMaster mfoyouStationMaster) {
		// TODO Auto-generated method stub
		return iIdentity.updateByAgent(mfoyouStationMaster);
	}
	public int deleteByPrimaryKey(MfoyouStationMaster mfoyouStationMaster) {
		return iIdentity.deleteByPrimartKey(mfoyouStationMaster);
	}
	public List<MfoyouStationMaster> getStationByAgentId(Integer agentId) {
		// TODO Auto-generated method stub
		return iIdentity.getStationByAgentId(agentId);
	}

}
