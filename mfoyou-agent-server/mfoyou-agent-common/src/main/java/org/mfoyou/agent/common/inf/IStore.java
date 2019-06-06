package org.mfoyou.agent.common.inf;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.mfoyou.agent.common.dao.domain.HuawuStoreInfo;
import org.mfoyou.agent.common.dao.mfoyou.domain.MfoyouAgentTypeInfo;
import org.mfoyou.agent.common.dao.mfoyou.domain.MfoyouStoreActive;
import org.mfoyou.agent.common.dao.mfoyou.domain.MfoyouStoreDispatch;
import org.mfoyou.agent.common.dao.mfoyou.domain.MfoyouStoreFreight;
import org.mfoyou.agent.common.dao.mfoyou.domain.MfoyouStoreOpen;
import org.mfoyou.agent.common.dao.mfoyou.domain.MfoyouStoreType;
import org.mfoyou.agent.common.dao.mfoyou.domain.MfoyouUserActiveAttend;
import org.mfoyou.agent.common.entity.MfoyouAgentStoreInfo;
import org.mfoyou.agent.common.entity.StoreOpenInfo;
import org.mfoyou.agent.common.entity.StoreType;
import org.mfoyou.agent.common.entity.StoreTypeV1;
import org.mfoyou.agent.utils.common.ArrayListObject;

public interface IStore {
	HuawuStoreInfo getStoreInfo(Integer userId);

	int addStoreInfo(HuawuStoreInfo mfoyouStoreInfo);

	StoreTypeV1 getTypeByid(Integer storeTypeId);

	List<MfoyouStoreOpen> getMfoyouStoreOpenByStoreId(Integer id);

	int updateOpenInfoByStoreId(MfoyouStoreOpen mfoyouStoreOpen);

	int updateStoreInfoById(Integer storeId, HuawuStoreInfo storeInfo);

	int modifyFrigths(Integer storeId, List<MfoyouStoreFreight> mfoyouStoreFreights);

	int delOpenInfo(Integer storeId, Integer openId);

	int addStoreOpenInfo(Integer storeId, Integer startTime, Integer endTime);

	List<StoreType> getStoreTypeList(Integer type);

	List<MfoyouStoreFreight> getfreightList(Integer storeId);

	int addFright(MfoyouStoreFreight fright);

	int updateFreight(MfoyouStoreFreight fright);

	int deletefreight(Integer frightid, Integer storeId);

	List<HuawuStoreInfo> getStoreInfo(int i, HuawuStoreInfo info);

	ArrayListObject<MfoyouAgentStoreInfo> getStoreInfoByAgentId(HuawuStoreInfo mfoyouStoreInfo, Integer pageid,
			Integer PageSize, Date sdate, Date edate);

	ArrayListObject<HuawuStoreInfo> getnearStoreInfos(HuawuStoreInfo info, Integer pageId, Integer pageSize,
			ArrayList<String> types);

	int savaTypeInfo(MfoyouAgentTypeInfo mfoyouAgentTypeInfo);

	String getAgentTypeInfo(Integer agentid);

	MfoyouStoreDispatch getDispatchInfo(Integer storeId);

	int updateDispatch(MfoyouStoreDispatch mfoyouStoreDispatch);

	MfoyouStoreType getTypeByTypeid(Integer typeid);

	Boolean addMfoyouStoreActive(MfoyouStoreActive active);

	Boolean mdfMfoyouStoreActive(MfoyouStoreActive active);

	MfoyouStoreActive getMfoyouStoreActive(Integer storeId);

	int getUserStoreActiveCount(Integer userId, Integer storeId);

	Integer delMfoyouUserActiveAttend(Integer orderId);

	Integer addMfoyouUserActiveAttend(MfoyouUserActiveAttend mfoyouUserActiveAttend);

	List<StoreOpenInfo> getStoreOpenList(Integer pageId, Integer pageSize);

	Boolean mdfMfoyouStoreInfo(HuawuStoreInfo mfoyouStoreInfo);

	Integer getStoreTypeCount(Integer agentid, Integer typeid);

}
