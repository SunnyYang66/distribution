package org.mfoyou.agent.center.service;

import java.util.Date;
import java.util.List;

import org.mfoyou.agent.center.dao.inf.HuawuAgentInfoMapper;
import org.mfoyou.agent.center.dao.inf.HuawuAgentStoreSettingMapper;
import org.mfoyou.agent.center.dao.inf.HuawuIdcardInfoMapper;
import org.mfoyou.agent.center.dao.inf.HuawuServicePriceMapper;
import org.mfoyou.agent.center.dao.inf.HuawuUserMapper;
import org.mfoyou.agent.center.dao.inf.HuawuWorkerMapper;
import org.mfoyou.agent.center.dao.inf.MfoyouStationMasterMapper;
import org.mfoyou.agent.center.dao.mfoyou.inf.MfoyouSystemMapper;
import org.mfoyou.agent.common.dao.domain.HuawuAgentInfo;
import org.mfoyou.agent.common.dao.domain.HuawuAgentStoreSetting;
import org.mfoyou.agent.common.dao.domain.HuawuServicePrice;
import org.mfoyou.agent.common.dao.domain.HuawuUserExample;
import org.mfoyou.agent.common.dao.domain.HuawuWorker;
import org.mfoyou.agent.common.dao.domain.HuawuWorkerExample;
import org.mfoyou.agent.common.dao.domain.HuawuWorkerExample.Criteria;
import org.mfoyou.agent.common.dao.domain.MfoyouStationMaster;
import org.mfoyou.agent.common.dao.domain.MfoyouStationMasterExample;
import org.mfoyou.agent.common.entity.HuawuAgentWokerInfo;
import org.mfoyou.agent.common.entity.HuawuAgentWorkerData;
import org.mfoyou.agent.common.entity.StationMasterInAgent;
import org.mfoyou.agent.common.inf.IIdentity;
import org.mfoyou.agent.utils.common.ArrayListObject;
import org.mfoyou.agent.utils.sql.MybatisGenerator;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class IdentityService implements IIdentity{
	@Autowired
	HuawuWorkerMapper huawuWorkerMapper;
	@Autowired
	HuawuAgentInfoMapper huawuAgentInfoMapper;
	@Autowired
	HuawuAgentStoreSettingMapper huawuAgentStoreSettingMapper;
	@Autowired
	HuawuServicePriceMapper huawuServicePriceMapper;
	@Autowired
	HuawuIdcardInfoMapper huawuIdcardInfoMapper;
	@Autowired
	MfoyouStationMasterMapper mfoyouStationMasterMapper;
	@Autowired
	MfoyouSystemMapper mfoyouSystemMapper;
	@Autowired
	HuawuUserMapper huawuUserMapper;
	org.slf4j.Logger logger = LoggerFactory.getLogger(IdentityService.class);
	@Override
	public HuawuWorker getMfoyouWorkerInfo(Integer userId, Integer agentId) {
		HuawuWorkerExample huawuWorkerExample = new HuawuWorkerExample();
		if(agentId!=null && agentId!=0 ){
			huawuWorkerExample.or().andUserIdEqualTo(userId).andAgentIdEqualTo(agentId);
		}else{
			huawuWorkerExample.or().andUserIdEqualTo(userId);
		}
		List<HuawuWorker> selectByExample = huawuWorkerMapper.selectByExample(huawuWorkerExample);
		return MybatisGenerator.getOneValue(selectByExample);
	}
	@Override
	public HuawuWorker getMfoyouWorkerInfoV2(Integer userId, Integer agentId) {
		HuawuWorkerExample huawuWorkerExample = new HuawuWorkerExample();
		huawuWorkerExample.or().andUserIdEqualTo(userId);
		List<HuawuWorker> selectByExample = huawuWorkerMapper.selectByExample(huawuWorkerExample);
		return MybatisGenerator.getOneValue(selectByExample);
	}
	@Override
	public List<HuawuWorker> getMfoyouWorkerList(List<Integer> arrUser) {
		HuawuWorkerExample huawuWorkerExample = new HuawuWorkerExample();
		huawuWorkerExample.or().andUserIdIn(arrUser);
		return huawuWorkerMapper.selectByExample(huawuWorkerExample);
	}
	@Override
	public int modifyMfoyouWorkerInfo(HuawuWorker huawuWorker) {
		if (huawuWorker.getUserId() == null) {
            return 0;
        }
        return huawuWorkerMapper.updateByPrimaryKeySelective(huawuWorker);
	}
	@Override
	public HuawuAgentInfo getAgentInfo(Integer userId) {
		return huawuAgentInfoMapper.selectByPrimaryKey(userId);
	}
	@Override
	public int modifyMfoyouAgent(HuawuAgentInfo mfoyouAgent) {
		
		return huawuAgentInfoMapper.updateByPrimaryKeySelective(mfoyouAgent);
	}
	 @Override
	    public ArrayListObject<HuawuWorker> getMfoyouWorkerList(HuawuWorker mfoyouWorker, Integer pageIndex, Integer pageSize, Date startDate, Date endDate) {
	        HuawuWorkerExample example = new HuawuWorkerExample();
	        MybatisGenerator.setLimit(example, pageIndex, pageSize);
	       Criteria criteria = example.or();
	        if (startDate != null) {
	            criteria.andCreateTimeGreaterThan(startDate);
	        }
	        if (endDate != null) {
	            criteria.andCreateTimeLessThan(endDate);
	        }
	        MybatisGenerator.makeExample(mfoyouWorker, criteria);
	        example.setOrderByClause("worker_join_time desc");
	        int count = huawuWorkerMapper.countByExample(example);
	        List<HuawuWorker> list = huawuWorkerMapper.selectByExample(example);
	        return ArrayListObject.bliudArrayList(list, pageIndex, pageSize, count);
	    }
	@Override
	public HuawuAgentStoreSetting getSpecialSettingV1(Integer agentId) {
		return huawuAgentStoreSettingMapper.selectByPrimaryKey(agentId);
	}
	@Override
	public HuawuServicePrice getServicePrice(Integer agentId) {
		HuawuServicePrice selectByPrimaryKey = huawuServicePriceMapper.selectByPrimaryKey(agentId);
		if(selectByPrimaryKey==null){
			selectByPrimaryKey = huawuServicePriceMapper.selectByPrimaryKey(0);
			selectByPrimaryKey.setCreateTime(null);
			selectByPrimaryKey.setAgentId(agentId);
			selectByPrimaryKey.setModifyTime(null);
			huawuServicePriceMapper.insertSelective(selectByPrimaryKey);
		}
		return selectByPrimaryKey;
	}
	 @Override
	    public ArrayListObject<?> getMfoyouWorkerListV2(HuawuWorker mfoyouWorker, Integer pageid, Integer pageSize,
	            Date startDate, Date endDate) {
	        HuawuWorkerExample mfoyouWorkerExample = new HuawuWorkerExample();
	        Criteria or = mfoyouWorkerExample.or();
	        MybatisGenerator.makeExample(mfoyouWorker, or);
	        int count = huawuWorkerMapper.countByExample(mfoyouWorkerExample);
	        pageid = pageid == null ? 1 : pageid;
	        pageSize = pageSize == null ? 10 :pageSize;
	        Integer pageStart = (pageid-1)*pageSize;
	        List<HuawuAgentWokerInfo> list = huawuWorkerMapper.getWokerInfoByagentInfo(mfoyouWorker,startDate,endDate,pageStart,pageSize);
	        for(HuawuAgentWokerInfo mfoyouAgentWokerInfo:list){
	            mfoyouAgentWokerInfo.setMfoyouIdcardInfo(huawuIdcardInfoMapper.selectByPrimaryKey(mfoyouAgentWokerInfo.getUserId()));
	            if(mfoyouAgentWokerInfo.getStationId()!=null){
	            	 mfoyouAgentWokerInfo.setStationName(mfoyouStationMasterMapper.selectByPrimaryKey(mfoyouAgentWokerInfo.getStationId()).getStationName());
	            }
	        }
	        return ArrayListObject.bliudArrayList(list, pageid, pageSize, count);
	    }
	 
	 @Override
	    public ArrayListObject<HuawuAgentWorkerData> getMfoyouWorkerListV3(HuawuWorker mfoyouWorker, Integer pageId, Integer pageSize) {
	        HuawuWorkerExample mfoyouWorkerExample = new HuawuWorkerExample();
	        Criteria or = mfoyouWorkerExample.or();
	        
	        MybatisGenerator.makeExample(mfoyouWorker, or);
	        int count = huawuWorkerMapper.countByExample(mfoyouWorkerExample);
	        if(mfoyouWorker.getStationId()!=null){
//	        	or.andStationIdEqualTo(mfoyouWorker.getStationId());
	        	mfoyouWorkerExample.setUserId(mfoyouWorker.getStationId());
	        	mfoyouWorkerExample.setUserType(0);
	        }else if(mfoyouWorker.getAgentId()!=0){
	        	mfoyouWorkerExample.setUserId(mfoyouWorker.getAgentId());
	        	mfoyouWorkerExample.setUserType(1);
	        }
	        List<HuawuAgentWorkerData> mfoyouAgentWorkerDatas = huawuWorkerMapper.selectAgentByExample(mfoyouWorkerExample);
	        return ArrayListObject.bliudArrayList(mfoyouAgentWorkerDatas, pageId, pageSize, count);
	    }
	@Override
	public int updatePriceV2ByagentId(HuawuServicePrice mfoyouServicePricev2) {
		HuawuServicePrice selectByPrimaryKey = huawuServicePriceMapper.selectByPrimaryKey(mfoyouServicePricev2.getAgentId());
		if(selectByPrimaryKey==null){
			return huawuServicePriceMapper.insertSelective(mfoyouServicePricev2);
		}
		return huawuServicePriceMapper.updateByPrimaryKeySelective(mfoyouServicePricev2);
	}
	@Override
	public int addWorker(HuawuWorker workerInfo) {
		return huawuWorkerMapper.insertSelective(workerInfo);
	}
	@Override
	public int updateMfoyouAgentSetting(HuawuAgentStoreSetting mfoyouAgentStoreSetting) {
		HuawuAgentStoreSetting selectByPrimaryKey = huawuAgentStoreSettingMapper.selectByPrimaryKey(mfoyouAgentStoreSetting.getAgentId());
		if(selectByPrimaryKey==null){
			return huawuAgentStoreSettingMapper.insertSelective(mfoyouAgentStoreSetting);
		}
		return huawuAgentStoreSettingMapper.updateByPrimaryKeySelective(mfoyouAgentStoreSetting);
	}
	@Override
	public HuawuWorker getWorkerByPhone(String phone) {
		HuawuWorkerExample huawuWorkerExample = new HuawuWorkerExample();
		huawuWorkerExample.or().andWorkerPhoneEqualTo(phone);
		List<HuawuWorker> selectByExample = huawuWorkerMapper.selectByExample(huawuWorkerExample);
		return MybatisGenerator.getOneValue(selectByExample);
	}
	@Override
	public List<HuawuWorker> getMfoyouWorkerListByAgentId(Integer agentId) {
		HuawuWorkerExample huawuWorkerExample = new HuawuWorkerExample();
		huawuWorkerExample.or().andWorkerOpenStateEqualToV1(1).andAgentIdEqualTo(agentId).andWorkerStateNotEqualTo(-1);
		return huawuWorkerMapper.selectByExample(huawuWorkerExample);
	}
	@Override
	public int addStation(MfoyouStationMaster mfoyouStationMaster) {
		return mfoyouStationMasterMapper.insertSelective(mfoyouStationMaster);
	}
	@Override
	public MfoyouStationMaster getStationMasterByUserId(Integer userId) {
		return mfoyouStationMasterMapper.selectByPrimaryKey(userId);
	}
	@Override
	public MfoyouStationMaster getMfoyouStationInfo(Integer stationId) {
		if(stationId==null){
			return  null;
		}
		return mfoyouStationMasterMapper.selectByPrimaryKey(stationId);
	}
	@Override
	public ArrayListObject<?> getStationMaster(MfoyouStationMaster mfoyouStationMaster, Date sDate, Date eDate,
			Integer pageSize, Integer pageId) {
		Integer pagestart = null;
        if(pageSize!=null && pageId!=null){
            pagestart = pageSize*(pageId-1);
        }
        List<StationMasterInAgent> selectByAgent = mfoyouStationMasterMapper.selectByAgent(mfoyouStationMaster.getAgentId(), mfoyouStationMaster.getPowerState(),
                sDate, eDate, pagestart, pageSize);
        int count = mfoyouSystemMapper.selectCount();
        return ArrayListObject.bliudArrayList(selectByAgent, pageId, pageSize, count);
	}
	@Override
	public int updateByAgent(MfoyouStationMaster mfoyouStationMaster) {
		return mfoyouStationMasterMapper.updateByPrimaryKeySelective(mfoyouStationMaster);
	}
	@Override
	public int deleteByPrimartKey(MfoyouStationMaster mfoyouStationMaster) {
		MfoyouStationMaster  mfoyouStationMaster2 = mfoyouStationMasterMapper.selectByPrimaryKey(mfoyouStationMaster.getStationId());
		if(mfoyouStationMaster2==null){
			return -2;//station不存在
		}
		if(!mfoyouStationMaster2.getAgentId().equals(mfoyouStationMaster.getAgentId())){
			return -3;
		}
		int deleteByPrimaryKey = mfoyouStationMasterMapper.deleteByPrimaryKey(mfoyouStationMaster.getStationId());
		//清空商店这边站长数据
		String sql = "update huawu_store_info set store_station_id = null where store_station_id = "+mfoyouStationMaster.getStationId();
		//清空跑腿员数据
		String sql2 = "update huawu_worker set station_id = null where station_id = "+mfoyouStationMaster.getStationId();
		int update_item = mfoyouSystemMapper.update_item(sql);
		int update_item2= mfoyouSystemMapper.update_item(sql2);
		HuawuUserExample huawuUserExample = new HuawuUserExample();
		huawuUserExample.or().andAgentIdEqualTo(-3).andUserIdEqualTo(mfoyouStationMaster.getStationId());
		int deleteByExample = huawuUserMapper.deleteByExample(huawuUserExample);
		logger.info("更新结果 "+update_item+"::"+update_item2+"::"+deleteByExample);
		return deleteByPrimaryKey;
	}
	@Override
	public List<MfoyouStationMaster> getStationByAgentId(Integer agentId) {
		MfoyouStationMasterExample mfoyouStationMasterExample = new MfoyouStationMasterExample();
		mfoyouStationMasterExample.or().andAgentIdEqualTo(agentId);
		return mfoyouStationMasterMapper.selectByExample(mfoyouStationMasterExample);
	}
}
