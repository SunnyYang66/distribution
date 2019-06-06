package com.mfoyou.agent.web.service.account;

import java.util.ArrayList;

import org.mfoyou.agent.common.dao.mfoyou.domain.MfoyouAgentServicePricev2;
import org.mfoyou.agent.common.dao.mfoyou.domain.MfoyouAgentTypeInfo;
import org.mfoyou.agent.common.entity.StoreTypeV1;
import org.mfoyou.agent.common.inf.IAccount;
import org.mfoyou.agent.common.inf.IGoodsOrder;
import org.mfoyou.agent.common.inf.IStore;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.mfoyou.agent.web.utils.common.MfoyouPriceV2;
import com.mfoyou.agent.web.utils.redis.RedisCacheManger;

@Service
public class StoreAgentService {
	@Autowired
	IStore iStore;
	@Autowired
	RedisCacheManger redisCacheManger ;
	@Autowired
	IAccount iAccount;
	@Autowired
	IGoodsOrder iGoodsOrder;
//	private static final String AGENT_INFO_PRE = "agent:info:";
	private static final String AGENT_TYPE_INFO = "agent:type:info:";
	
	public int saveTypeInfo(MfoyouAgentTypeInfo mfoyouAgentTypeInfo) {
		redisCacheManger.setValue(AGENT_TYPE_INFO+mfoyouAgentTypeInfo.getStoreAgentId(),mfoyouAgentTypeInfo.getTypeContent(),Integer.MAX_VALUE);
		return iStore.savaTypeInfo(mfoyouAgentTypeInfo);
	}
	public String getAgentTypeInfo(Integer agentid) {
		String value = redisCacheManger.getValue(AGENT_TYPE_INFO+agentid);
		if(value==null || value.equals("null")){
			value = iStore.getAgentTypeInfo(agentid);
			if(value==null){
				value = redisCacheManger.getValue(AGENT_TYPE_INFO+0);
				if(value==null){
					return null;
				}
			}
			redisCacheManger.setValue(AGENT_TYPE_INFO+agentid, value, Integer.MAX_VALUE);
		}
		return value;
	}
	public Integer getPercentByTypeName(String typename, Integer agentId) {
		String agentTypeInfo = getAgentTypeInfo(agentId);
		if(agentTypeInfo == null || agentTypeInfo.equals("null")){
			return null;
		}
		JSONObject jsonObject4 = JSONObject.parseObject(agentTypeInfo);
		JSONArray jsonArray1 = jsonObject4.getJSONArray("classify");
		for(int i = 0;i<jsonArray1.size();i++){
			JSONObject jsonObject = jsonArray1.getJSONObject(i);
			JSONArray jsonArray = jsonObject.getJSONArray("storeTypes");
			for(int j = 0;j<jsonArray.size();j++){
				JSONObject jsonObject2 = jsonArray.getJSONObject(j);
				if(jsonObject2.getString("typeName").equals(typename)){
					return jsonObject2.getIntValue("typePercent");
				}
			}
		}
		return null;
	}
	public Integer getStoreTypeCount(Integer agentid, Integer typeid) {
		// TODO Auto-generated method stub
		return iStore.getStoreTypeCount(agentid,typeid);
	}
	public ArrayList<Integer> getTypeList(String typename, Integer agentid) {
		if(agentid == null){
			return null;
		}
		String agentTypeInfo = getAgentTypeInfo(agentid);
		if(agentTypeInfo==null || agentTypeInfo.equals("null")){
			return null;
		}
		ArrayList<Integer> types = new ArrayList<>();
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
				types.add(jsonObject2.getInteger("typeId"));
			}
		}
		return types;
	}
	public StoreTypeV1 getTypeName(Integer typeId, Integer agentid) {
		if(agentid == null){
			return  iStore.getTypeByid(typeId);
		}
		String agentTypeInfo = getAgentTypeInfo(agentid);
		if(agentTypeInfo==null || agentTypeInfo.equals("null")){
			return iStore.getTypeByid(typeId);
		}
		StoreTypeV1 storeTypeV1 = new StoreTypeV1();
		JSONObject jsonObject4 = JSONObject.parseObject(agentTypeInfo);
		JSONArray jsonArray1 = jsonObject4.getJSONArray("classify");
		for(int i = 0;i<jsonArray1.size();i++){
			JSONObject jsonObject = jsonArray1.getJSONObject(i);
			String typeName1 = jsonObject.getString("typeName");
			JSONArray jsonArray = jsonObject.getJSONArray("storeTypes");
			for(int j = 0;j<jsonArray.size();j++){
				JSONObject jsonObject2 = jsonArray.getJSONObject(j);
				Integer typeIdV2 = jsonObject2.getInteger("typeId");
				if(typeIdV2.equals(typeId)){
					//找到了
					String childName = jsonObject2.getString("typeName");
					storeTypeV1.setChildId(typeId);
					storeTypeV1.setParentName(typeName1);
					storeTypeV1.setChildName(childName);
					return storeTypeV1;
				}
			}
		}
		return null;
	}
//	public int applyMfoyouService(MfoyouAgentServicePrice save) {
//		// TODO Auto-generated method stub
//		return iStaffUser.applyMfoyouService(save);
//	}
	public 	Integer getNewUserAmount(Integer agentId) {
		return iAccount.getNewUserAmount(agentId);
	}
//	
//	public void exchange(Integer userId, Integer agentId) {
//		iStaffUser.exchange(userId,agentId);
//		
//	}
	public int applyMfoyouServiceV2(MfoyouAgentServicePricev2 mfoyouAgentServicePricev2) {
		return iGoodsOrder.applyMfoyouServiceV2(mfoyouAgentServicePricev2);
	}
	public MfoyouAgentServicePricev2 getStoreServicePriceV2(Integer agentId,boolean isadd) {
		return iGoodsOrder.getStoreServicePriceV2(agentId,isadd);
	}
	public MfoyouPriceV2 getServicePrice(Integer agentId) {
		MfoyouAgentServicePricev2 storeServicePriceV2 = getStoreServicePriceV2(agentId,false);
		if(storeServicePriceV2==null || storeServicePriceV2.getServicePrice()==null){
			storeServicePriceV2 = getStoreServicePriceV2(0,false);
		}
		return JSON.parseObject(storeServicePriceV2.getServicePrice(), MfoyouPriceV2.class);
	}

}
