package org.mfoyou.agent.common.inf;


import java.util.List;

import org.mfoyou.agent.common.dao.mfoyou.domain.MfoyouAgentStoreCoupon;
import org.mfoyou.agent.common.dao.mfoyou.domain.MfoyouAgentUserCoupon;
import org.mfoyou.agent.utils.common.ArrayListObject;

public interface IActivity {

	ArrayListObject<MfoyouAgentStoreCoupon> getAgentCouponList(Integer agentId, Integer state, Integer pageid,
			Integer pagesize);

	int addAgentCoupon(MfoyouAgentStoreCoupon mfoyouAgentStoreCoupon);

	int modifyAgentCoupon(MfoyouAgentStoreCoupon oldmfoyouAgentStoreCoupon,
			MfoyouAgentStoreCoupon newMfoyouXingStoreCoupon);

	List<MfoyouAgentStoreCoupon> getAgentCouponListByUser(Integer agentId, Integer userId);

	List<Integer> takeCoupons(Integer[] couponIds, Integer userid);

	List<MfoyouAgentStoreCoupon> getUserCouponList(Integer userId, Integer state, Integer type);

	List<MfoyouAgentStoreCoupon> getUserCanUseCouponList(Integer userId, Integer agentId, Integer amount);

	MfoyouAgentUserCoupon getTouchById(Integer touchId);

	MfoyouAgentStoreCoupon getCouponById(Integer couponId);

	int deleteCoupon(Integer couponId);

	MfoyouAgentStoreCoupon getSingleCoupon(Integer couponId);

	List<MfoyouAgentStoreCoupon> getCanFinishOrder();

	int getUsedCoupons(Integer couponId);

}
