package org.mfoyou.agent.center.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.mfoyou.agent.center.dao.inf.HuawuStoreInfoMapper;
import org.mfoyou.agent.center.dao.mfoyou.inf.MfoyouAgentStoreCouponMapper;
import org.mfoyou.agent.center.dao.mfoyou.inf.MfoyouAgentUserCouponMapper;
import org.mfoyou.agent.center.dao.mfoyou.inf.MfoyouStoreTypeMapper;
import org.mfoyou.agent.center.dao.mfoyou.inf.MfoyouSystemMapper;
import org.mfoyou.agent.common.dao.domain.HuawuStoreInfo;
import org.mfoyou.agent.common.dao.domain.HuawuStoreInfoExample;
import org.mfoyou.agent.common.dao.mfoyou.domain.MfoyouAgentStoreCoupon;
import org.mfoyou.agent.common.dao.mfoyou.domain.MfoyouAgentStoreCouponExample;
import org.mfoyou.agent.common.dao.mfoyou.domain.MfoyouAgentUserCoupon;
import org.mfoyou.agent.common.dao.mfoyou.domain.MfoyouAgentUserCouponExample;
import org.mfoyou.agent.common.dao.mfoyou.domain.MfoyouStoreType;
import org.mfoyou.agent.common.dao.mfoyou.domain.MfoyouStoreTypeExample;
import org.mfoyou.agent.common.inf.IActivity;
import org.mfoyou.agent.utils.common.ArrayListObject;
import org.mfoyou.agent.utils.sql.MybatisGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ActivityService implements IActivity {
	@Autowired
	MfoyouAgentStoreCouponMapper mfoyouAgentStoreCouponMapper;
	@Autowired
	MfoyouAgentUserCouponMapper mfoyouAgentUserCouponMapper;
	@Autowired
	HuawuStoreInfoMapper huawuStoreInfoMapper;
	@Autowired
	MfoyouStoreTypeMapper mfoyouStoreTypeMapper;
	@Autowired
	MfoyouSystemMapper mfoyouSystemMapper;

	@Override
	public ArrayListObject<MfoyouAgentStoreCoupon> getAgentCouponList(Integer agentId, Integer state, Integer pageid,
			Integer pagesize) {
		MfoyouAgentStoreCouponExample mfoyouAgentStoreCouponExample = new MfoyouAgentStoreCouponExample();
		MfoyouAgentStoreCouponExample.Criteria or = mfoyouAgentStoreCouponExample.or();
		or.andAgentIdEqualTo(agentId);
		if (state != null && state == 0) {
			or.andCouponStartTimeLessThan(new Date()).andCouponLimitTimeGreaterThan(new Date())
					.andCouponStateEqualTo(1);
		} else if (state != null && state == 1) {
			or.andCouponLimitTimeLessThan(new Date()).andCouponStateEqualTo(1);
		} else if (state != null && state == 2) {
			or.andCouponStartTimeGreaterThan(new Date()).andCouponStateEqualTo(1);
		}
		int totalCount = mfoyouAgentStoreCouponMapper.countByExample(mfoyouAgentStoreCouponExample);
		MybatisGenerator.setLimit(mfoyouAgentStoreCouponExample, pageid, pagesize);
		mfoyouAgentStoreCouponExample.setOrderByClause(" coupon_id desc");
		List<MfoyouAgentStoreCoupon> list = mfoyouAgentStoreCouponMapper.selectByExample(mfoyouAgentStoreCouponExample);
		for (MfoyouAgentStoreCoupon mfoyouAgentStoreCoupon : list) {
			MfoyouAgentUserCouponExample mfoyouAgentUserCouponExample = new MfoyouAgentUserCouponExample();
			mfoyouAgentUserCouponExample.or().andCouponIdEqualTo(mfoyouAgentStoreCoupon.getCouponId())
					.andTouchStateEqualTo(0);
			mfoyouAgentStoreCoupon.setHasUsed(mfoyouAgentUserCouponMapper.countByExample(mfoyouAgentUserCouponExample));
			if (mfoyouAgentStoreCoupon.getUseType() == 3) {
				List<Integer> asList = Arrays.asList(mfoyouAgentStoreCoupon.getStoreList().split(",")).stream()
						.map((String str) -> Integer.parseInt(str)).collect(Collectors.toList());
				HuawuStoreInfoExample mfoyouStoreInfoExample = new HuawuStoreInfoExample();
				mfoyouStoreInfoExample.or().andStoreIdIn(asList);
				List<HuawuStoreInfo> selectByExample = huawuStoreInfoMapper.selectByExample(mfoyouStoreInfoExample);
				String ret = selectByExample.stream().map(HuawuStoreInfo::getStoreName)
						.collect(Collectors.joining(","));
				mfoyouAgentStoreCoupon.setTypeNameValue(ret);
			}
			if (mfoyouAgentStoreCoupon.getUseType() == 2) {
				List<Integer> asList = Arrays.asList(mfoyouAgentStoreCoupon.getStoreList().split(",")).stream()
						.map((String str) -> Integer.parseInt(str)).collect(Collectors.toList());
				MfoyouStoreTypeExample mfoyouStoreTypeExample = new MfoyouStoreTypeExample();
				mfoyouStoreTypeExample.or().andStoreTypeIdIn(asList);
				List<MfoyouStoreType> selectByExample = mfoyouStoreTypeMapper.selectByExample(mfoyouStoreTypeExample);
				if (selectByExample != null) {
					String ret = mfoyouStoreTypeMapper.selectByExample(mfoyouStoreTypeExample).stream()
							.map(MfoyouStoreType::getStoreTypeName).collect(Collectors.joining(","));
					mfoyouAgentStoreCoupon.setTypeNameValue(ret);
				}
			}
		}
		return ArrayListObject.bliudArrayList(list, pageid, pagesize, totalCount);
	}

	@Override
	public int addAgentCoupon(MfoyouAgentStoreCoupon mfoyouAgentStoreCoupon) {
		mfoyouAgentStoreCoupon.setCouponId(null);
		int ret = mfoyouAgentStoreCouponMapper.insertSelective(mfoyouAgentStoreCoupon);
		return ret == 0 ? -1 : mfoyouAgentStoreCoupon.getCouponId();
	}

	@Override
	public int modifyAgentCoupon(MfoyouAgentStoreCoupon oldmfoyouAgentStoreCoupon,
			MfoyouAgentStoreCoupon newMfoyouXingStoreCoupon) {
		MfoyouAgentStoreCouponExample mfoyouAgentStoreCouponExample = new MfoyouAgentStoreCouponExample();
		MybatisGenerator.makeExample(oldmfoyouAgentStoreCoupon, mfoyouAgentStoreCouponExample.or());
		return mfoyouAgentStoreCouponMapper.updateByExampleSelective(newMfoyouXingStoreCoupon,
				mfoyouAgentStoreCouponExample);
	}

	@Override
	public List<MfoyouAgentStoreCoupon> getAgentCouponListByUser(Integer agentId, Integer userId) {
		MfoyouAgentStoreCouponExample mfoyouAgentStoreCouponExample = new MfoyouAgentStoreCouponExample();
		mfoyouAgentStoreCouponExample.or().andAgentIdEqualTo(agentId).andCouponCountGrterThanSold()
				.andCouponStartTimeLessThan(new Date()).andCouponLimitTimeGreaterThan(new Date())
				.andCouponStateEqualTo(1);
		List<MfoyouAgentStoreCoupon> selectByExample = mfoyouAgentStoreCouponMapper
				.selectByExample(mfoyouAgentStoreCouponExample);
		if (userId == null)
			return selectByExample;
		for (MfoyouAgentStoreCoupon mfoyouAgentStoreCoupon : selectByExample) {
			MfoyouAgentUserCouponExample mfoyouAgentUserCouponExample = new MfoyouAgentUserCouponExample();
			mfoyouAgentUserCouponExample.or().andUserIdEqualTo(userId)
					.andCouponIdEqualTo(mfoyouAgentStoreCoupon.getCouponId());
			if (mfoyouAgentUserCouponMapper.selectByExample(mfoyouAgentUserCouponExample).size() > 0) {
				mfoyouAgentStoreCoupon.setCouponState(5);
			}
		}
		return selectByExample.stream().filter(mfoyouAgentStoreCoupon -> mfoyouAgentStoreCoupon.getCouponState() != 5)
				.collect(Collectors.toList());
	}

	@Override
	@Transactional
	public List<Integer> takeCoupons(Integer[] couponIds, Integer userid) {
		synchronized (this.getClass()) {
			List<Integer> ret = new ArrayList<>();
			for (Integer coupId : couponIds) {
				MfoyouAgentUserCouponExample mfoyouAgentUserCouponExample = new MfoyouAgentUserCouponExample();
				mfoyouAgentUserCouponExample.or().andUserIdEqualTo(userid).andCouponIdEqualTo(coupId);
				List<MfoyouAgentUserCoupon> selectByExample = mfoyouAgentUserCouponMapper
						.selectByExample(mfoyouAgentUserCouponExample);
				if (selectByExample == null || selectByExample.size() == 0) {
					int checkCouponCount = mfoyouAgentStoreCouponMapper.checkCouponCount(coupId, 1);
					if (checkCouponCount == 0)
						continue;
					MfoyouAgentUserCoupon mfoyouAgentUserCoupon = new MfoyouAgentUserCoupon();
					mfoyouAgentUserCoupon.setCouponId(coupId);
					mfoyouAgentUserCoupon.setUserId(userid);
					mfoyouAgentUserCouponMapper.insertSelective(mfoyouAgentUserCoupon);
					ret.add(coupId);
				}
			}
			return ret;
		}
	}

	@Override
	public List<MfoyouAgentStoreCoupon> getUserCouponList(Integer userId, Integer state, Integer type) {
		List<MfoyouAgentStoreCoupon> mfoyouAgentStoreCoupons = mfoyouAgentStoreCouponMapper.selectByUserExample(userId,
				state, type);
		for (MfoyouAgentStoreCoupon mfoyouAgentStoreCoupon : mfoyouAgentStoreCoupons) {
			if (mfoyouAgentStoreCoupon.getUseType() == 3) {
				List<Integer> asList = Arrays.asList(mfoyouAgentStoreCoupon.getStoreList().split(",")).stream()
						.map((String str) -> Integer.parseInt(str)).collect(Collectors.toList());
				HuawuStoreInfoExample mfoyouStoreInfoExample = new HuawuStoreInfoExample();
				mfoyouStoreInfoExample.or().andStoreIdIn(asList);
				List<HuawuStoreInfo> selectByExample = huawuStoreInfoMapper.selectByExample(mfoyouStoreInfoExample);
				String ret = selectByExample.stream().map(HuawuStoreInfo::getStoreName)
						.collect(Collectors.joining(","));
				mfoyouAgentStoreCoupon.setTypeNameValue(ret);
			}
			if (mfoyouAgentStoreCoupon.getUseType() == 2) {
				List<Integer> asList = Arrays.asList(mfoyouAgentStoreCoupon.getStoreList().split(",")).stream()
						.map((String str) -> Integer.parseInt(str)).collect(Collectors.toList());
				MfoyouStoreTypeExample mfoyouStoreTypeExample = new MfoyouStoreTypeExample();
				mfoyouStoreTypeExample.or().andStoreTypeIdIn(asList);
				List<MfoyouStoreType> selectByExample = mfoyouStoreTypeMapper.selectByExample(mfoyouStoreTypeExample);
				if (selectByExample != null) {
					String ret = mfoyouStoreTypeMapper.selectByExample(mfoyouStoreTypeExample).stream()
							.map(MfoyouStoreType::getStoreTypeName).collect(Collectors.joining(","));
					mfoyouAgentStoreCoupon.setTypeNameValue(ret);
				}
			}
		}
		return mfoyouAgentStoreCoupons;
	}

	@Override
	public List<MfoyouAgentStoreCoupon> getUserCanUseCouponList(Integer userId, Integer agentId, Integer amount) {
		List<MfoyouAgentStoreCoupon> mfoyouAgentStoreCoupons = mfoyouAgentStoreCouponMapper.getUserCanUseAmount(userId,
				agentId, amount);
		return mfoyouAgentStoreCoupons;
	}

	@Override
	public MfoyouAgentUserCoupon getTouchById(Integer touchId) {
		return mfoyouAgentUserCouponMapper.selectByPrimaryKey(touchId);
	}

	@Override
	public MfoyouAgentStoreCoupon getCouponById(Integer couponId) {
		return mfoyouAgentStoreCouponMapper.selectByPrimaryKey(couponId);
	}

	@Override
	public MfoyouAgentStoreCoupon getSingleCoupon(Integer couponId) {
		MfoyouAgentStoreCoupon selectByPrimaryKey = mfoyouAgentStoreCouponMapper.selectByPrimaryKey(couponId);
		return selectByPrimaryKey;
	}

	@Override
	public int deleteCoupon(Integer couponId) {
		return mfoyouAgentStoreCouponMapper.deleteByPrimaryKey(couponId);
	}

	@Override
	public List<MfoyouAgentStoreCoupon> getCanFinishOrder() {
		MfoyouAgentStoreCouponExample mfoyouAgentStoreCouponExample = new MfoyouAgentStoreCouponExample();
		// 状态为4 表示已结算的coupon
		mfoyouAgentStoreCouponExample.or().andCouponStateEqualTo(1).andCouponLimitTimeGreaterThan(new Date());
		return mfoyouAgentStoreCouponMapper.selectByExample(mfoyouAgentStoreCouponExample);
	}

	@Override
	public int getUsedCoupons(Integer couponId) {
		String sql = "select ifnull(sum(reduce_amount),0) totalA from mfoyou_agent_user_coupon where touch_state=0 and coupon_id ="
				+ couponId;
		return Integer.parseInt(mfoyouSystemMapper.select_item(sql).get("totalA").toString());
	}
}
