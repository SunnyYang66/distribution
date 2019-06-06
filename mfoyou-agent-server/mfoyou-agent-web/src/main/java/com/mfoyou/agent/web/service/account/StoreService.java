package com.mfoyou.agent.web.service.account;

import java.util.Date;
import java.util.HashMap;
import java.util.List;

import org.mfoyou.agent.common.dao.domain.HuawuStoreInfo;
import org.mfoyou.agent.common.dao.domain.MfoyouStationMaster;
import org.mfoyou.agent.common.dao.mfoyou.domain.MfoyouAgentStoreCoupon;
import org.mfoyou.agent.common.dao.mfoyou.domain.MfoyouOrderStatistics;
import org.mfoyou.agent.common.dao.mfoyou.domain.MfoyouStoreDispatch;
import org.mfoyou.agent.common.dao.mfoyou.domain.MfoyouStoreFreight;
import org.mfoyou.agent.common.dao.mfoyou.domain.MfoyouStoreOpen;
import org.mfoyou.agent.common.dao.mfoyou.domain.MfoyouStoreType;
import org.mfoyou.agent.common.dao.mfoyou.domain.MfoyouUserStatistics;
import org.mfoyou.agent.common.entity.MfoyouAgentStoreInfo;
import org.mfoyou.agent.common.entity.StoreType;
import org.mfoyou.agent.common.entity.StoreTypeV1;
import org.mfoyou.agent.common.inf.IActivity;
import org.mfoyou.agent.common.inf.ICommon;
import org.mfoyou.agent.common.inf.IGoodsOrder;
import org.mfoyou.agent.common.inf.IIdentity;
import org.mfoyou.agent.common.inf.IStore;
import org.mfoyou.agent.utils.common.ArrayListObject;
import org.mfoyou.agent.utils.common.MfoyouEncrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mfoyou.agent.web.utils.redis.RedisCacheManger;



@Service
public class StoreService {
	@Autowired
	IStore iStore;
	@Autowired
	IGoodsOrder  iGoodsOrder;
	@Autowired
	StoreAgentService storeAgentService;
	@Autowired
	IActivity iActivity;
	@Autowired
	RedisCacheManger redisCacheManger;
	@Autowired
	ICommon iCommon;
	@Autowired
	IIdentity iIdentity;
	private static final String STORE_VISITER_COUNT = "store:visitor:";
	private static final String STORE_LOGIN_USERCOUNT="store:user:";
	public List<MfoyouStoreOpen> getMfoyouStoreOpenByStoreId(Integer id) {
		return iStore.getMfoyouStoreOpenByStoreId(id);
	}
	public int updateOpenInfoByStoreId(MfoyouStoreOpen mfoyouStoreOpen) {
		return iStore.updateOpenInfoByStoreId(mfoyouStoreOpen);
	}
	public int updateStoreInfoById(Integer storeId, HuawuStoreInfo storeInfo) {
		return iStore.updateStoreInfoById(storeId,storeInfo);
	}
	public int addStoreOpenInfo(Integer storeId, Integer startTime, Integer endTime) {
		return iStore.addStoreOpenInfo(storeId,startTime,endTime);
	}
	public int delOpenInfo(Integer storeId, Integer openId) {
		return iStore.delOpenInfo(storeId,openId);
	}
	public List<StoreType> getStoreTypeList(Integer type) {
		return iStore.getStoreTypeList(type);
	}
	public StoreTypeV1 getTypeByid(Integer storeTypeId) {
		return iStore.getTypeByid(storeTypeId);
	}
	public List<MfoyouStoreFreight> getfreightList(Integer storeId) {
		return iStore.getfreightList(storeId);
	}
	public int deletefreight(Integer frightid, Integer storeId) {
		return iStore.deletefreight(frightid,storeId);
	}
	public int updateFreight(MfoyouStoreFreight fright) {
		return iStore.updateFreight(fright);
	}
	public int addFright(MfoyouStoreFreight fright) {
		return iStore.addFright(fright);
	}
	public List<HuawuStoreInfo> getStoreInfo(int i, HuawuStoreInfo info) {
		return iStore.getStoreInfo(i,info);
	}

	public HashMap<String, Object> getAgentMoneyDate(Integer agentId, int userType) {
		HashMap<String , Object> hashMap  = new HashMap<>();
		List<MfoyouOrderStatistics> orderStatistics = iGoodsOrder.getAgentMoney(agentId,null,userType);
		hashMap.put("weekdata", orderStatistics);
		MfoyouOrderStatistics statistics = iGoodsOrder.getAgentToday(agentId,0,userType);
		hashMap.put("todays", statistics);
		String value = redisCacheManger.getValue("visit:times:"+agentId);
		value=value==null?"0":value;
		hashMap.put("visitTime", value);
		return hashMap;
	}
	public ArrayListObject<MfoyouAgentStoreInfo> getStoreInfoByAgent(HuawuStoreInfo mfoyouStoreInfo,Integer pageid,Integer pagesize, Date sdate, Date eDate) {
		ArrayListObject<MfoyouAgentStoreInfo> storeInfoByAgentId = iStore.getStoreInfoByAgentId(mfoyouStoreInfo,pageid,pagesize,sdate,eDate);
		for(MfoyouAgentStoreInfo mfoyouAgentStoreInfo: storeInfoByAgentId){
			mfoyouAgentStoreInfo.setStorestr(MfoyouEncrypt.enCode(mfoyouAgentStoreInfo.getStoreId()));
			if(mfoyouAgentStoreInfo.getStoreStationId()!=null){
				MfoyouStationMaster stationMasterByUserId = iIdentity.getStationMasterByUserId(mfoyouAgentStoreInfo.getStoreStationId());
				if(stationMasterByUserId!=null)
				mfoyouAgentStoreInfo.setStationName(stationMasterByUserId.getStationName());
			}
		}
		return storeInfoByAgentId;
	}
	public MfoyouStoreType gettaxByTypeId(Integer typeid) {
		return iStore.getTypeByTypeid(typeid);
	}
	public int getVisitCount(Integer storeId,String dayStr){
		String value = redisCacheManger.getValue(STORE_VISITER_COUNT+storeId+":"+dayStr);
		return value==null?0:Integer.parseInt(value);
	}
	public int getUsercount(Integer storeId,String daystr){
		String value = redisCacheManger.getValue(STORE_LOGIN_USERCOUNT+storeId+":"+daystr);
		return value==null?0:Integer.parseInt(value);
	}
	public int getNewUsercount(Integer storeId,String daystr){
		String value = redisCacheManger.getValue(STORE_LOGIN_USERCOUNT+storeId+":"+daystr);
		if(value!=null){
			return Integer.parseInt(value);
		}
		MfoyouUserStatistics mfoyouUserStatistics = new MfoyouUserStatistics();
		mfoyouUserStatistics.setDayId(Integer.valueOf(daystr));
		mfoyouUserStatistics.setStoreId(storeId);
		mfoyouUserStatistics = iCommon.getMfoyouUserStatic(mfoyouUserStatistics);
		return mfoyouUserStatistics==null?0:mfoyouUserStatistics.getUserCount();
	}
	public int[] getVisitTorAndUserCount(Integer storeId,String daystr){
		int[] value = new int[2];
		String userCountvalue = redisCacheManger.getValue(STORE_LOGIN_USERCOUNT+storeId+":"+daystr);
		String visitorCountValue = redisCacheManger.getValue(STORE_VISITER_COUNT+storeId+":"+daystr);
		if(userCountvalue!=null || visitorCountValue!=null){
			value[0]=visitorCountValue==null?0:Integer.parseInt(visitorCountValue);
			value[1]=userCountvalue==null?0:Integer.parseInt(userCountvalue);
			return value;
		}
		MfoyouUserStatistics mfoyouUserStatistics = new MfoyouUserStatistics();
		mfoyouUserStatistics.setDayId(Integer.valueOf(daystr));
		mfoyouUserStatistics.setStoreId(storeId);
		mfoyouUserStatistics = iCommon.getMfoyouUserStatic(mfoyouUserStatistics);
		return mfoyouUserStatistics==null?new int[]{0,0}:
			new int[]{mfoyouUserStatistics.getVisitCount()==null?0:mfoyouUserStatistics.getVisitCount(),
					mfoyouUserStatistics.getUserCount()==null?0:mfoyouUserStatistics.getUserCount()};
	}
	public int modifyFrigths(Integer storeId, List<MfoyouStoreFreight> mfoyouStoreFreights) {
		return iStore.modifyFrigths(storeId,mfoyouStoreFreights);
	}
	public int updateDispatch(MfoyouStoreDispatch mfoyouStoreDispatch) {
		return iStore.updateDispatch(mfoyouStoreDispatch);
	}
	public MfoyouStoreDispatch getDispatch(Integer  storeId) {
		return iStore.getDispatchInfo(storeId);
	}
	public ArrayListObject<MfoyouAgentStoreCoupon> getAgentCouponList(Integer agentId, Integer state, Integer pageid,
			Integer pagesize) {
		return iActivity.getAgentCouponList(agentId,state,pageid,pagesize);
	}
	public int addAgentCoupon(MfoyouAgentStoreCoupon mfoyouAgentStoreCoupon) {
		return iActivity.addAgentCoupon(mfoyouAgentStoreCoupon);
	}
	public int modifyAgentCoupon(MfoyouAgentStoreCoupon oldmfoyouAgentStoreCoupon,
			MfoyouAgentStoreCoupon newMfoyouXingStoreCoupon) {
		return iActivity.modifyAgentCoupon(oldmfoyouAgentStoreCoupon,newMfoyouXingStoreCoupon);
	}
	public List<MfoyouAgentStoreCoupon> getAgentCouponListByUser(Integer agentId, Integer userId) {
		return iActivity.getAgentCouponListByUser(agentId,userId);
	}
	public List<Integer> takeCoupons(Integer[] couponIds, Integer userid) {
		return iActivity.takeCoupons(couponIds,userid);
	}
	public List<MfoyouAgentStoreCoupon> getUserCouponList(Integer userId, Integer state, Integer type) {
		return iActivity.getUserCouponList(userId,state,type);
	}
	public MfoyouAgentStoreCoupon getSingleCoupon(Integer couponId) {
		return iActivity.getSingleCoupon(couponId);
	}
	public int getCountVisitUser(String start, String end, Integer storeid) {
		return iCommon.getCountVisitUser(start,end,storeid);
	}
	public HuawuStoreInfo getStoreInfo(Integer storeId) {
		return iStore.getStoreInfo(storeId);
	}
	public int addStoreInfo(HuawuStoreInfo mfoyouStoreInfo) {
		return iStore.addStoreInfo(mfoyouStoreInfo);
	}


	
	
}
