package org.mfoyou.agent.center.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mfoyou.agent.center.dao.inf.HuawuStoreInfoMapper;
import org.mfoyou.agent.center.dao.mfoyou.inf.MfoyouAgentTypeInfoMapper;
import org.mfoyou.agent.center.dao.mfoyou.inf.MfoyouGoodsTypeMapper;
import org.mfoyou.agent.center.dao.mfoyou.inf.MfoyouStoreActiveMapper;
import org.mfoyou.agent.center.dao.mfoyou.inf.MfoyouStoreDispatchMapper;
import org.mfoyou.agent.center.dao.mfoyou.inf.MfoyouStoreFreightMapper;
import org.mfoyou.agent.center.dao.mfoyou.inf.MfoyouStoreOpenMapper;
import org.mfoyou.agent.center.dao.mfoyou.inf.MfoyouStoreTypeMapper;
import org.mfoyou.agent.center.dao.mfoyou.inf.MfoyouUserActiveAttendMapper;
import org.mfoyou.agent.common.dao.domain.HuawuStoreInfo;
import org.mfoyou.agent.common.dao.domain.HuawuStoreInfoExample;
import org.mfoyou.agent.common.dao.domain.HuawuStoreInfoExample.Criteria;
import org.mfoyou.agent.common.dao.mfoyou.domain.MfoyouAgentTypeInfo;
import org.mfoyou.agent.common.dao.mfoyou.domain.MfoyouGoodsType;
import org.mfoyou.agent.common.dao.mfoyou.domain.MfoyouStoreActive;
import org.mfoyou.agent.common.dao.mfoyou.domain.MfoyouStoreDispatch;
import org.mfoyou.agent.common.dao.mfoyou.domain.MfoyouStoreFreight;
import org.mfoyou.agent.common.dao.mfoyou.domain.MfoyouStoreFreightExample;
import org.mfoyou.agent.common.dao.mfoyou.domain.MfoyouStoreOpen;
import org.mfoyou.agent.common.dao.mfoyou.domain.MfoyouStoreOpenExample;
import org.mfoyou.agent.common.dao.mfoyou.domain.MfoyouStoreType;
import org.mfoyou.agent.common.dao.mfoyou.domain.MfoyouUserActiveAttend;
import org.mfoyou.agent.common.dao.mfoyou.domain.MfoyouUserActiveAttendExample;
import org.mfoyou.agent.common.entity.MfoyouAgentStoreInfo;
import org.mfoyou.agent.common.entity.StoreOpenInfo;
import org.mfoyou.agent.common.entity.StoreType;
import org.mfoyou.agent.common.entity.StoreTypeV1;
import org.mfoyou.agent.common.inf.IStore;
import org.mfoyou.agent.utils.common.ArrayListObject;
import org.mfoyou.agent.utils.common.GisUtils;
import org.mfoyou.agent.utils.sql.MybatisGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StoreService implements IStore {
	@Autowired
	HuawuStoreInfoMapper huawuStoreInfoMapper;
	@Autowired
	MfoyouStoreTypeMapper mfoyouStoreTypeMapper;
	@Autowired
	MfoyouStoreOpenMapper mfoyouStoreOpenMapper;
	@Autowired
	MfoyouStoreFreightMapper mfoyouStoreFreightMapper;
	@Autowired
	MfoyouStoreActiveMapper mfoyouStoreActiveMapper;
	@Autowired
	MfoyouAgentTypeInfoMapper mfoyouAgentTypeInfoMapper;
	@Autowired
	MfoyouStoreDispatchMapper mfoyouStoreDispatchMapper;
	@Autowired
	MfoyouUserActiveAttendMapper mfoyouUserActiveAttendMapper;
	@Autowired
	MfoyouGoodsTypeMapper   mfoyouGoodsTypeMapper;

	@Override
	public HuawuStoreInfo getStoreInfo(Integer userId) {
		HuawuStoreInfo selectByPrimaryKey = huawuStoreInfoMapper.selectByPrimaryKey(userId);
		return selectByPrimaryKey;
	}

	@Override
	public int addStoreInfo(HuawuStoreInfo mfoyouStoreInfo) {
		int insertSelective = huawuStoreInfoMapper.insertSelective(mfoyouStoreInfo);
		if(insertSelective==1){
			MfoyouGoodsType mfoyouGoodsType = new MfoyouGoodsType();
			mfoyouGoodsType.setStoreId(mfoyouStoreInfo.getStoreId());
			mfoyouGoodsType.setTypeName("所有商品");
			mfoyouGoodsTypeMapper.insertSelective(mfoyouGoodsType);
		}
		return insertSelective;
	}

	@Override
	public StoreTypeV1 getTypeByid(Integer storeTypeId) {
		return mfoyouStoreTypeMapper.getTypeByid(storeTypeId);
	}

	@Override
	public List<MfoyouStoreOpen> getMfoyouStoreOpenByStoreId(Integer id) {
		MfoyouStoreOpenExample example = new MfoyouStoreOpenExample();
		example.or().andStoreIdEqualTo(id);
		List<MfoyouStoreOpen> mfoyouStoreOpens = mfoyouStoreOpenMapper.selectByExample(example);
		return mfoyouStoreOpens;
	}

	@Override
	public int updateOpenInfoByStoreId(MfoyouStoreOpen mfoyouStoreOpen) {

		MfoyouStoreOpenExample example = new MfoyouStoreOpenExample();
		example.or().andStoreIdEqualTo(mfoyouStoreOpen.getStoreId()).andOpenIdEqualTo(mfoyouStoreOpen.getOpenId());
		return mfoyouStoreOpenMapper.updateByExampleSelective(mfoyouStoreOpen, example);
	}

	@Override
	public int updateStoreInfoById(Integer storeId, HuawuStoreInfo storeInfo) {
		storeInfo.setStoreId(storeId);
		List<MfoyouStoreOpen> opens = storeInfo.getOpens();
		if (opens != null && opens.size() != 0) {
			MfoyouStoreOpenExample mfoyouStoreOpenExample = new MfoyouStoreOpenExample();
			mfoyouStoreOpenExample.or().andStoreIdEqualTo(storeId);
			mfoyouStoreOpenMapper.deleteByExample(mfoyouStoreOpenExample);
			for (MfoyouStoreOpen mfoyouStoreOpen : opens) {
				mfoyouStoreOpenMapper.insertSelective(mfoyouStoreOpen);
			}
		}
		return huawuStoreInfoMapper.updateByPrimaryKeySelective(storeInfo);
	}

	@Override
	public int modifyFrigths(Integer storeId, List<MfoyouStoreFreight> mfoyouStoreFreights) {
		MfoyouStoreFreightExample mfoyouStoreFreightExample = new MfoyouStoreFreightExample();
		mfoyouStoreFreightExample.or().andStoreIdEqualTo(storeId);
		int deleteByExample = mfoyouStoreFreightMapper.deleteByExample(mfoyouStoreFreightExample);
		for (MfoyouStoreFreight mfoyouStoreFreight : mfoyouStoreFreights) {
			mfoyouStoreFreightMapper.insertSelective(mfoyouStoreFreight);
		}
		return deleteByExample;
	}

	@Override
	public int delOpenInfo(Integer storeId, Integer openId) {

		MfoyouStoreOpenExample example = new MfoyouStoreOpenExample();
		example.or().andStoreIdEqualTo(storeId).andOpenIdEqualTo(openId);
		return mfoyouStoreOpenMapper.deleteByExample(example);
	}

	@Override
	public int addStoreOpenInfo(Integer storeId, Integer startTime, Integer endTime) {

		MfoyouStoreOpen mfoyouStoreOpen = new MfoyouStoreOpen();
		mfoyouStoreOpen.setOpenStartTime(startTime);
		mfoyouStoreOpen.setOpenEndTime(endTime);
		mfoyouStoreOpen.setStoreId(storeId);
		mfoyouStoreOpen.setOpenEffect(1);
		return mfoyouStoreOpenMapper.insertSelective(mfoyouStoreOpen);
	}

	@Override
	public List<StoreType> getStoreTypeList(Integer type) {
		if (type == null) {
			type = 1;
		}
		return mfoyouStoreTypeMapper.getTypeList(type);
	}

	@Override
	public List<MfoyouStoreFreight> getfreightList(Integer storeId) {
		MfoyouStoreFreightExample example = new MfoyouStoreFreightExample();
		example.or().andStoreIdEqualTo(storeId);
		example.setOrderByClause("freight_price");
		return mfoyouStoreFreightMapper.selectByExample(example);
	}
	private void updateStoreBaseFreight(Integer storeId) {
		List<MfoyouStoreFreight> list = getfreightList(storeId);
		Integer minPrice = Integer.MAX_VALUE;
		Integer maxDistance = 10000;
		for (MfoyouStoreFreight freight : list) {
			minPrice = Math.min(minPrice,
					freight.getFreightPrice() == null ? Integer.MAX_VALUE : freight.getFreightPrice());
			maxDistance = freight.getFreightMaxDistance() == null ? maxDistance
					: freight.getFreightMaxDistance() > maxDistance ? freight.getFreightMaxDistance() : maxDistance;
		}
		if (minPrice == Integer.MAX_VALUE) {
			minPrice = 0;
		}
		HuawuStoreInfo mfoyouStoreInfo = new HuawuStoreInfo();
		mfoyouStoreInfo.setStoreId(storeId);
		mfoyouStoreInfo.setStoreBasicFreight(minPrice);
		mfoyouStoreInfo.setStoreMaxDeliveryDistance(maxDistance);
		mdfMfoyouStoreInfo(mfoyouStoreInfo);
	}

	@Override
	public int deletefreight(Integer frightid, Integer storeId) {

		MfoyouStoreFreightExample example = new MfoyouStoreFreightExample();
		example.or().andStoreIdEqualTo(storeId).andFreightIdEqualTo(frightid);
		Integer ret = mfoyouStoreFreightMapper.deleteByExample(example);
		updateStoreBaseFreight(storeId);
		return ret;
	}

	@Override
	public int updateFreight(MfoyouStoreFreight fright) {
		MfoyouStoreFreightExample example = new MfoyouStoreFreightExample();
		example.or().andStoreIdEqualTo(fright.getStoreId()).andFreightIdEqualTo(fright.getFreightId());
		Integer ret = mfoyouStoreFreightMapper.updateByExampleSelective(fright, example);
		updateStoreBaseFreight(fright.getStoreId());
		return ret;
	}

	@Override
	public int addFright(MfoyouStoreFreight fright) {

		int result = mfoyouStoreFreightMapper.insertSelective(fright);
		updateStoreBaseFreight(fright.getStoreId());
		return result == 1 ? fright.getFreightId() : -1;
	}
	@Override
	public Boolean mdfMfoyouStoreInfo(HuawuStoreInfo mfoyouStoreInfo) {
		return huawuStoreInfoMapper.updateByPrimaryKeySelective(mfoyouStoreInfo) == 1;
	}

	@Override
	public List<HuawuStoreInfo> getStoreInfo(int i, HuawuStoreInfo info) {
		HuawuStoreInfoExample example = new HuawuStoreInfoExample();
		Criteria or = example.or();
		if (info.getStoreLocalLon() != null && info.getStoreAddress() != null) {
			or.andStoreLocalLatBetween(info.getStoreLocalLat() - 0.33, info.getStoreLocalLat() - 0.33)
					.andStoreLocalLonBetween(info.getStoreLocalLon() - 0.33, info.getStoreLocalLon() + 0.33);
		}
		if (info.getStoreName() != null) {
			or.andStoreNameLike(info.getStoreName());
		}
		if (info.getStoreType() != null) {
			or.andStoreTypeEqualTo(info.getStoreType());
		}
		if (info.getStoreId() != null) {
			or.andStoreIdEqualTo(info.getStoreId());
		}
		if (info.getStoreAgentId() != null) {
			or.andStoreAgentIdEqualTo(info.getStoreAgentId());
		}
		if (info.getStoreLoginNumber() != null) {
			or.andStoreLoginNumberEqualTo(info.getStoreLoginNumber());
		}
		List<HuawuStoreInfo> selectByExample = huawuStoreInfoMapper.selectByExample(example);
		for (HuawuStoreInfo mfoyouStoreInfo : selectByExample) {
			mfoyouStoreInfo
					.setMfoyouStoreActive(mfoyouStoreActiveMapper.selectByPrimaryKey(mfoyouStoreInfo.getStoreId()));
		}
		return selectByExample;
	}

	@Override
	public ArrayListObject<MfoyouAgentStoreInfo> getStoreInfoByAgentId(HuawuStoreInfo mfoyouStoreInfo, Integer pageid,
			Integer PageSize, Date sdate, Date edate) {
		HuawuStoreInfoExample example = new HuawuStoreInfoExample();
		Criteria or = example.or();
		MybatisGenerator.makeExample(mfoyouStoreInfo, or);
		int count = huawuStoreInfoMapper.countByExample(example);
		pageid = pageid == null ? 1 : pageid;
		PageSize = PageSize == null ? 10 : PageSize;
		Integer pageStart = (pageid - 1) * PageSize;
		List<MfoyouAgentStoreInfo> list = huawuStoreInfoMapper.getStoreInfoByAgent(mfoyouStoreInfo, sdate, edate,
				pageStart, PageSize);
		return ArrayListObject.bliudArrayList(list, pageid, PageSize, count);
	}

	@Override
	public ArrayListObject<HuawuStoreInfo> getnearStoreInfos(HuawuStoreInfo info, Integer pageId, Integer pageSize,
			ArrayList<String> types) {
		HuawuStoreInfoExample example = new HuawuStoreInfoExample();
		Criteria or = example.or();
//		if (info.getStoreLocalLat() != null && info.getStoreLocalLon() != null && info.getStoreAgentId() == null) {
//			or.andStoreLocalLonBetween(info.getStoreLocalLon() - 0.22, info.getStoreLocalLon() + 0.22);
//			or.andStoreLocalLatBetween(info.getStoreLocalLat() - 0.22, info.getStoreLocalLat() + 0.22);
//			example.setOrderByClause("pow(store_local_lat-" + info.getStoreLocalLat() + ",2)+pow(store_local_lon-"
//					+ info.getStoreLocalLon() + ",2) asc");
//		}
		if (types != null) {
			or.andStoreTypeNameIn(types);
		}
		if (info.getStoreName() != null) {
			or.andStoreNameLike(info.getStoreName());
		}
		if (info.getStoreAgentId() != null) {
			or.andStoreAgentIdEqualTo(info.getStoreAgentId());
		}
		// 不显示强制关店的
		or.andStoreOpenStateNotEqualTo(-1);
		// 不显示休息中的
		or.andStoreCurrentOpenStateLessThan(2);
		int count = huawuStoreInfoMapper.countByExample(example);
		MybatisGenerator.setLimit(example, pageId, pageSize);
		// 不会显示没商品的store 下面参数为1的时候
		List<HuawuStoreInfo> list = huawuStoreInfoMapper.selectByExampleV2(example);
		for (HuawuStoreInfo storeInfo : list) {
			storeInfo.setMfoyouStoreActive(mfoyouStoreActiveMapper.selectByPrimaryKey(storeInfo.getStoreId()));
			Double storeLat = storeInfo.getStoreLocalLat();
			Double storeLon = storeInfo.getStoreLocalLon();
			if (storeLat != null && storeLon != null) {
				long distance = (long) (1000L
						* GisUtils.distVincenty(storeLat, storeLon, info.getStoreLocalLat(), info.getStoreLocalLon()));
				storeInfo.setDistance(distance);
			}
		}
		return ArrayListObject.bliudArrayList(list, pageId, pageSize, count);
	}

	@Override
	public String getAgentTypeInfo(Integer agentid) {
		MfoyouAgentTypeInfo selectByPrimaryKey = mfoyouAgentTypeInfoMapper.selectByPrimaryKey(agentid);
		if (selectByPrimaryKey == null) {
			selectByPrimaryKey = mfoyouAgentTypeInfoMapper.selectByPrimaryKey(0);
			selectByPrimaryKey.setStoreAgentId(agentid);
			mfoyouAgentTypeInfoMapper.insertSelective(selectByPrimaryKey);
		}
		return selectByPrimaryKey.getTypeContent();
	}

	@Override
	public int savaTypeInfo(MfoyouAgentTypeInfo mfoyouAgentTypeInfo) {
		int updateByPrimaryKeySelective = mfoyouAgentTypeInfoMapper.updateByPrimaryKeySelective(mfoyouAgentTypeInfo);
		if (updateByPrimaryKeySelective == 1) {
			return updateByPrimaryKeySelective;
		}
		return mfoyouAgentTypeInfoMapper.insertSelective(mfoyouAgentTypeInfo);
	}

	@Override
	public int updateDispatch(MfoyouStoreDispatch mfoyouStoreDispatch) {
		MfoyouStoreDispatch selectByPrimaryKey = mfoyouStoreDispatchMapper
				.selectByPrimaryKey(mfoyouStoreDispatch.getStoreId());
		if (selectByPrimaryKey == null) {
			return mfoyouStoreDispatchMapper.insertSelective(mfoyouStoreDispatch);
		}
		return mfoyouStoreDispatchMapper.updateByPrimaryKeySelective(mfoyouStoreDispatch);
	}

	@Override
	public MfoyouStoreDispatch getDispatchInfo(Integer storeId) {
		return mfoyouStoreDispatchMapper.selectByPrimaryKey(storeId);
	}

	@Override
	public MfoyouStoreType getTypeByTypeid(Integer typeid) {

		return mfoyouStoreTypeMapper.selectByPrimaryKey(typeid);
	}

	@Override
	public Boolean addMfoyouStoreActive(MfoyouStoreActive active) {
		return mfoyouStoreActiveMapper.insertSelective(active) == 1;
	}

	@Override
	public Boolean mdfMfoyouStoreActive(MfoyouStoreActive active) {
		return mfoyouStoreActiveMapper.updateByPrimaryKeySelective(active) == 1;
	}

	@Override
	public MfoyouStoreActive getMfoyouStoreActive(Integer storeId) {
		return mfoyouStoreActiveMapper.selectByPrimaryKey(storeId);
	}

	@Override
	public int getUserStoreActiveCount(Integer userId, Integer storeId) {
		MfoyouUserActiveAttendExample example = new MfoyouUserActiveAttendExample();
		example.or().andAttendStoreIdEqualTo(storeId).andAttendUserIdEqualTo(userId);
		return mfoyouUserActiveAttendMapper.countByExample(example);
	}

	@Override
	public Integer addMfoyouUserActiveAttend(MfoyouUserActiveAttend mfoyouUserActiveAttend) {
		mfoyouUserActiveAttendMapper.insertSelective(mfoyouUserActiveAttend);
		return mfoyouUserActiveAttend.getAttendId();
	}

	@Override
	public Integer delMfoyouUserActiveAttend(Integer orderId) {
		MfoyouUserActiveAttendExample example = new MfoyouUserActiveAttendExample();
		example.or().andAttendOrderIdEqualTo(orderId);
		return mfoyouUserActiveAttendMapper.deleteByExample(example);
	}
	@Override
	public List<StoreOpenInfo> getStoreOpenList(Integer pageId, Integer pageSize) {
		HuawuStoreInfoExample example = new HuawuStoreInfoExample();
		MybatisGenerator.setLimit(example, pageId, pageSize);
		example.or().andStoreOpenStateNotEqualTo(-1);
		List<HuawuStoreInfo> listStore = huawuStoreInfoMapper.selectByExample(example);
		MfoyouStoreOpenExample exampleOpen = new MfoyouStoreOpenExample();
		List<Integer> inArrary = new ArrayList<>();
		Map<Integer, StoreOpenInfo> retMap = new HashMap<>();
		for (HuawuStoreInfo info : listStore) {
			inArrary.add(info.getStoreId());
			StoreOpenInfo storeOpenInfo = new StoreOpenInfo();
			storeOpenInfo.setMfoyouStoreInfo(info);
			retMap.put(info.getStoreId(), storeOpenInfo);
		}
		if (!inArrary.isEmpty()) {
			exampleOpen.or().andStoreIdIn(inArrary).andOpenEffectEqualTo(1);
			List<MfoyouStoreOpen> listOpen = mfoyouStoreOpenMapper.selectByExample(exampleOpen);
			for (MfoyouStoreOpen mfoyouStoreOpen : listOpen) {
				StoreOpenInfo storeOpenInfo = retMap.get(mfoyouStoreOpen.getStoreId());
				storeOpenInfo.addMfoyouStoreOpen(mfoyouStoreOpen);
			}
		}
		return new ArrayList<StoreOpenInfo>(retMap.values());
	}
	@Override
    public Integer getStoreTypeCount(Integer agentid, Integer typeid) {
        HuawuStoreInfoExample mfoyouStoreInfoExample = new HuawuStoreInfoExample();
        mfoyouStoreInfoExample.or().andStoreAgentIdEqualTo(agentid).andStoreTypeEqualTo(typeid);
        return huawuStoreInfoMapper.countByExample(mfoyouStoreInfoExample);
    }
	
}
