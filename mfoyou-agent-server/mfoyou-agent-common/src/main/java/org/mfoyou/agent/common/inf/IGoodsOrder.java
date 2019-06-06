package org.mfoyou.agent.common.inf;

import java.util.Date;
import java.util.List;

import org.mfoyou.agent.common.dao.mfoyou.domain.MfoyouAgentServicePricev2;
import org.mfoyou.agent.common.dao.mfoyou.domain.MfoyouAgentStoreCoupon;
import org.mfoyou.agent.common.dao.mfoyou.domain.MfoyouAgentUserCoupon;
import org.mfoyou.agent.common.dao.mfoyou.domain.MfoyouGoodsOrder;
import org.mfoyou.agent.common.dao.mfoyou.domain.MfoyouOrderStatistics;
import org.mfoyou.agent.common.entity.GoodsLock;
import org.mfoyou.agent.common.entity.MfoyouGoodsOrderDetail;
import org.mfoyou.agent.common.entity.MfoyouGoodsOrderEx;
import org.mfoyou.agent.common.entity.MfoyouGoodsOrderWithPackage;
import org.mfoyou.agent.utils.common.ArrayListObject;

public interface IGoodsOrder {

	ArrayListObject<MfoyouGoodsOrder> getMfoyouGoodsOrderList(MfoyouGoodsOrder mfoyouGoodsOrder, Integer pageIndex,
			Integer pageSize, Date startDate, Date endDate, List<Integer> state, Integer orderBy);

	ArrayListObject<MfoyouGoodsOrderWithPackage> getExceptionOrder(Integer storeId, Integer pageSize, Integer pageid,
			int isneed);

	Boolean modifyGoodsOrder(MfoyouGoodsOrder order);

	MfoyouGoodsOrder getGoodsOrderByOrderid(Integer orderid);

	MfoyouAgentUserCoupon getTouchById(Integer touchId);

	List<MfoyouAgentStoreCoupon> getUserCanUseCouponList(Integer userId, Integer agentId, Integer amount);

	MfoyouAgentStoreCoupon getCouponById(Integer couponId);

	Boolean lockGoods(List<GoodsLock> lockList);

	int modifyCouponState(Integer touchId, int i, Integer orderId, Integer reduceamount);

	MfoyouGoodsOrderEx addGoodsOrder(MfoyouGoodsOrderEx goodsOrder);

	MfoyouGoodsOrderEx getGoodsOrder(Integer orderId);

	Boolean delAllMfoyouGoodsOrderCart(Integer customerId, Integer storeId);

	ArrayListObject<MfoyouGoodsOrderWithPackage> getGoodsOrderWithPackageListV1(Integer storeId, Integer pageIndex,
			Integer pageSize);

	MfoyouGoodsOrderDetail getMfoyouOrderPosition(Integer orderid);

	int systemUpdateOrder(MfoyouGoodsOrder order, Integer fromState, Integer toState);

	int updateOrderByPromaryKey(MfoyouGoodsOrder order);

	ArrayListObject<MfoyouGoodsOrderWithPackage> getMfoyouGoodsOrderWithPackList(MfoyouGoodsOrder mfoyouGoodsOrder,
			Integer pageIndex, Integer pageSize, Date startDate, Date endDate, List<Integer> state, Integer isNeed,
			String key);

	int updateOrderState(MfoyouGoodsOrder order, Integer transpost, Integer fromState, Integer orderstate);

	Boolean mdfGoodsOrder(MfoyouGoodsOrder order);

	List<MfoyouGoodsOrder> getMfoyouGoodsOrder(Date date);

	boolean mdfStoreServiceByStateTime(int fromState, int toState, Date sDate, Date eDate, int opUserId);

	int modifyWaimaiOrder();

	int fininshOrder();

	List<MfoyouGoodsOrder> getGoodsOrderList(MfoyouGoodsOrder mfoyouGoodsOrder);

	int fininshGoodorder(Integer orderId);

	List<MfoyouOrderStatistics> getAgentStatistics(Integer agentid, Date sdate, Date edate, int userType);

	MfoyouOrderStatistics getAgentToday(Integer agentId, Integer daycount, int userType);

	List<MfoyouOrderStatistics> getAgentMoney(Integer agentId, Integer daynumber, int userType);

	MfoyouGoodsOrderWithPackage getGoodsOrderWith(Integer orderId, boolean tag);

	MfoyouAgentServicePricev2 getStoreServicePriceV2(Integer agentId, boolean isAdd);

	int applyMfoyouServiceV2(MfoyouAgentServicePricev2 mfoyouAgentServicePricev2);

	int updateGoodOrder(MfoyouGoodsOrder oldGoodsOrder, MfoyouGoodsOrder newGoodsOrder);

}
