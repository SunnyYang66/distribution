package org.mfoyou.agent.center.service;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.mfoyou.agent.center.dao.inf.HuawuOrderLogMapper;
import org.mfoyou.agent.center.dao.inf.HuawuServiceOrderMapper;
import org.mfoyou.agent.center.dao.inf.HuawuStoreInfoMapper;
import org.mfoyou.agent.center.dao.inf.HuawuUserMapper;
import org.mfoyou.agent.center.dao.inf.HuawuWorkerMapper;
import org.mfoyou.agent.center.dao.mfoyou.inf.MfoyouAgentServicePricev2Mapper;
import org.mfoyou.agent.center.dao.mfoyou.inf.MfoyouAgentStoreCouponMapper;
import org.mfoyou.agent.center.dao.mfoyou.inf.MfoyouAgentUserCouponMapper;
import org.mfoyou.agent.center.dao.mfoyou.inf.MfoyouGoodsInfoMapper;
import org.mfoyou.agent.center.dao.mfoyou.inf.MfoyouGoodsOrderCartMapper;
import org.mfoyou.agent.center.dao.mfoyou.inf.MfoyouGoodsOrderItmeMapper;
import org.mfoyou.agent.center.dao.mfoyou.inf.MfoyouGoodsOrderMapper;
import org.mfoyou.agent.center.dao.mfoyou.inf.MfoyouGoodsPackageMapper;
import org.mfoyou.agent.center.dao.mfoyou.inf.MfoyouOrderStatisticsMapper;
import org.mfoyou.agent.center.dao.mfoyou.inf.MfoyouSystemMapper;
import org.mfoyou.agent.common.dao.domain.HuawuOrderLog;
import org.mfoyou.agent.common.dao.domain.HuawuOrderLogExample;
import org.mfoyou.agent.common.dao.domain.HuawuServiceOrder;
import org.mfoyou.agent.common.dao.domain.HuawuStoreInfo;
import org.mfoyou.agent.common.dao.domain.HuawuUser;
import org.mfoyou.agent.common.dao.domain.HuawuWorker;
import org.mfoyou.agent.common.dao.mfoyou.domain.MfoyouAgentServicePricev2;
import org.mfoyou.agent.common.dao.mfoyou.domain.MfoyouAgentStoreCoupon;
import org.mfoyou.agent.common.dao.mfoyou.domain.MfoyouAgentUserCoupon;
import org.mfoyou.agent.common.dao.mfoyou.domain.MfoyouGoodsInfo;
import org.mfoyou.agent.common.dao.mfoyou.domain.MfoyouGoodsOrder;
import org.mfoyou.agent.common.dao.mfoyou.domain.MfoyouGoodsOrderCartExample;
import org.mfoyou.agent.common.dao.mfoyou.domain.MfoyouGoodsOrderExample;
import org.mfoyou.agent.common.dao.mfoyou.domain.MfoyouGoodsOrderExample.Criteria;
import org.mfoyou.agent.common.dao.mfoyou.domain.MfoyouGoodsOrderItme;
import org.mfoyou.agent.common.dao.mfoyou.domain.MfoyouGoodsOrderItmeExample;
import org.mfoyou.agent.common.dao.mfoyou.domain.MfoyouGoodsPackage;
import org.mfoyou.agent.common.dao.mfoyou.domain.MfoyouOrderStatistics;
import org.mfoyou.agent.common.entity.GoodsLock;
import org.mfoyou.agent.common.entity.MfoyouGoodsOrderDetail;
import org.mfoyou.agent.common.entity.MfoyouGoodsOrderEx;
import org.mfoyou.agent.common.entity.MfoyouGoodsOrderWithPackage;
import org.mfoyou.agent.common.entity.enums.GoodsOrderState;
import org.mfoyou.agent.common.entity.enums.OrderType;
import org.mfoyou.agent.common.inf.IGoodsOrder;
import org.mfoyou.agent.utils.common.ArrayListObject;
import org.mfoyou.agent.utils.map.ReflectUtil;
import org.mfoyou.agent.utils.sql.MybatisGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
public class GoodsOrderService implements IGoodsOrder{
	
	@Autowired
	MfoyouGoodsOrderMapper mfoyouGoodsOrderMapper;
	@Autowired
	HuawuServiceOrderMapper huawuServiceOrderMapper;
	@Autowired
	HuawuOrderLogMapper huawuOrderLogMapper;
	@Autowired
	MfoyouAgentStoreCouponMapper mfoyouAgentStoreCouponMapper;
	@Autowired
	MfoyouAgentUserCouponMapper mfoyouAgentUserCouponMapper;
	@Autowired
	MfoyouGoodsPackageMapper mfoyouGoodsPackageMapper;
	@Autowired
	MfoyouGoodsInfoMapper mfoyouGoodsInfoMapper;
	@Autowired
	MfoyouGoodsOrderItmeMapper mfoyouGoodsOrderItmeMapper;
	@Autowired
	HuawuWorkerMapper huawuWorkerMapper;
	@Autowired
	HuawuUserMapper huawuUserMapper;
	@Autowired
	HuawuStoreInfoMapper huawuStoreInfoMapper;
	@Autowired
	MfoyouGoodsOrderCartMapper mfoyouGoodsOrderCartMapper;
	@Autowired
	MfoyouSystemMapper mfoyouSystemMapper;
	@Autowired
	MfoyouOrderStatisticsMapper mfoyouOrderStatisticsMapper;
	@Autowired
	MfoyouAgentServicePricev2Mapper mfoyouAgentServicePricev2Mapper;
	@Override
	public ArrayListObject<MfoyouGoodsOrder> getMfoyouGoodsOrderList(MfoyouGoodsOrder mfoyouGoodsOrder,
			Integer pageIndex, Integer pageSize, Date startDate, Date endDate, List<Integer> state, Integer orderBy) {
		MfoyouGoodsOrderExample example = new MfoyouGoodsOrderExample();
		MybatisGenerator.setLimit(example, pageIndex, pageSize);
		Criteria criteria = example.or();
		if (startDate != null) {
			criteria.andOrderGctGreaterThan(startDate);
		}
		if (endDate != null) {
			criteria.andOrderGctLessThan(endDate);
		}
		if (state != null && state.size() > 0) {
			criteria.andOrderStateIn(state);
		}
		MybatisGenerator.makeExample(mfoyouGoodsOrder, criteria);
		if (orderBy != null) {
			if (orderBy == 1) {
				example.setOrderByClause(" order_state desc , order_id asc");
			} else {
				example.setOrderByClause(" order_id desc");
			}
		} else {
			example.setOrderByClause(" order_id desc");
		}
		int count = mfoyouGoodsOrderMapper.countByExample(example);
		List<MfoyouGoodsOrder> list = mfoyouGoodsOrderMapper.selectByExample(example);
		return ArrayListObject.bliudArrayList(list, pageIndex, pageSize, count);
	}
	@Override
	public ArrayListObject<MfoyouGoodsOrderWithPackage> getExceptionOrder(Integer storeId, Integer pageSize,
			Integer pageid, int isneed) {
		MfoyouGoodsOrderExample example = new MfoyouGoodsOrderExample();
		MybatisGenerator.setLimit(example, pageid, pageSize);
		Criteria criteria = example.or();
		criteria.andOrderExceptionStateGreaterThan(0).andStoreIdEqualTo(storeId).andOrderStateBetween(
				GoodsOrderState.emWaitingAccept.getValue(), GoodsOrderState.emFinshDelivery.getValue());
		if (isneed == 1) {
			criteria.andOrderActiveAmountEqualTo(0);
		}
		example.setOrderByClause(" order_id desc");
		int count = mfoyouGoodsOrderMapper.countByExample(example);
		List<MfoyouGoodsOrderWithPackage> list = mfoyouGoodsOrderMapper.selectByExampleWithPacket(example);
		int size = list.size();
		for (int i = 0; i < size; i++) {
			MfoyouGoodsOrderWithPackage mfoyouGoodsOrderWithPackage = list.get(i);
			if (mfoyouGoodsOrderWithPackage.getOrderTransportId() != null) {
				HuawuServiceOrder serviceOrder = huawuServiceOrderMapper
						.selectByPrimaryKey(mfoyouGoodsOrderWithPackage.getOrderTransportId());
				mfoyouGoodsOrderWithPackage.setServiceOrder(serviceOrder);
			}
		}
		return ArrayListObject.bliudArrayList(list, pageid, pageSize, count);
	}
	@Override
	public Boolean modifyGoodsOrder(MfoyouGoodsOrder order) {
		Boolean bRet = mfoyouGoodsOrderMapper.updateByPrimaryKeySelective(order) == 1;
		if (bRet && order.getOrderState() != null
				&& order.getOrderState().intValue() != GoodsOrderState.emSeekRuner.getValue()) {
			HuawuOrderLog mfoyouOrderLog = new HuawuOrderLog();
			mfoyouOrderLog.setOrderLogUserId(order.getUserId());
			mfoyouOrderLog.setOrderLogState(order.getOrderState());
			mfoyouOrderLog.setOrderLogTime(new Date());
			mfoyouOrderLog.setServiceOrderId(order.getOrderId());
			mfoyouOrderLog.setOrderLogRemark("订单状态变更");
			mfoyouOrderLog.setOrderType(OrderType.goodsOrder.getValue());
			huawuOrderLogMapper.insertSelective(mfoyouOrderLog);
		}
		return bRet;
	}

	@Override
	public MfoyouGoodsOrder getGoodsOrderByOrderid(Integer orderid) {
		return mfoyouGoodsOrderMapper.selectByPrimaryKey(orderid);
	}
	@Override
	public List<MfoyouAgentStoreCoupon> getUserCanUseCouponList(Integer userId, Integer agentId, Integer amount) {
		 List<MfoyouAgentStoreCoupon> mfoyouAgentStoreCoupons = mfoyouAgentStoreCouponMapper.getUserCanUseAmount(userId,agentId,amount);
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
	@Transactional(propagation = Propagation.REQUIRED, rollbackForClassName = "Exception")
	public Boolean lockGoods(List<GoodsLock> lockList) {
		// 这函数是有问题的，以后有空了改，这样锁库存在高并发的时候有问题
		// Integer storeCount = 0;
		for (GoodsLock goodsLock : lockList) {
			if (goodsLock.getPackageId() != null) {
				MfoyouGoodsPackage goodsPackage = new MfoyouGoodsPackage();
				goodsPackage.setPackageId(goodsLock.getPackageId());
				goodsPackage.setPackageNumber(goodsLock.getCurCount() - goodsLock.getSubCount());
				mfoyouGoodsPackageMapper.updateByPrimaryKeySelective(goodsPackage);
				MfoyouGoodsInfo goodsInfo = new MfoyouGoodsInfo();
				goodsInfo.setGoodsId(goodsLock.getGoodsId());
				goodsInfo.setGoodsTotalSale(goodsLock.getSaleCount() + goodsLock.getSubCount());
				mfoyouGoodsInfoMapper.updateByPrimaryKeySelective(goodsInfo);
			} else {
				MfoyouGoodsInfo goodsInfo = new MfoyouGoodsInfo();
				goodsInfo.setGoodsId(goodsLock.getGoodsId());
				if (goodsLock.getCurCount() != null)
					goodsInfo.setGoodsNumber(goodsLock.getCurCount() - goodsLock.getSubCount());
				goodsInfo.setGoodsTotalSale(goodsLock.getSaleCount() + goodsLock.getSubCount());
				mfoyouGoodsInfoMapper.updateByPrimaryKeySelective(goodsInfo);
			}
			// storeCount += goodsLock.getSubCount();
		}

		return true;
	}
	@Override
	public int modifyCouponState(Integer touchId, int i,Integer orderId,Integer reduceamount) {
		MfoyouAgentUserCoupon mfoyouAgentUserCoupon = new MfoyouAgentUserCoupon();
		mfoyouAgentUserCoupon.setTouchId(touchId);
		mfoyouAgentUserCoupon.setTouchState(i);
		mfoyouAgentUserCoupon.setOrderId(orderId);
		mfoyouAgentUserCoupon.setReduceAmount(reduceamount);
		return mfoyouAgentUserCouponMapper.updateByPrimaryKeySelective(mfoyouAgentUserCoupon);
	}
	@Override
	@Transactional(propagation = Propagation.REQUIRED, rollbackForClassName = "Exception")
	public MfoyouGoodsOrderEx addGoodsOrder(MfoyouGoodsOrderEx goodsOrder) {
		goodsOrder.setOrderId(null);
		mfoyouGoodsOrderMapper.insertSelective(goodsOrder);
		if (goodsOrder.getOrderId() != null) {
			List<MfoyouGoodsOrderItme> list = goodsOrder.getList();
			for (MfoyouGoodsOrderItme item : list) {
				item.setOrderId(goodsOrder.getOrderId());
				item.setOrderItmeId(null);
				mfoyouGoodsOrderItmeMapper.insertSelective(item);
			}
		}
		HuawuOrderLog mfoyouOrderLog = new HuawuOrderLog();
		mfoyouOrderLog.setOrderLogUserId(goodsOrder.getUserId());
		mfoyouOrderLog.setOrderLogState(goodsOrder.getOrderState());
		mfoyouOrderLog.setOrderLogTime(new Date());
		mfoyouOrderLog.setServiceOrderId(goodsOrder.getOrderId());
		mfoyouOrderLog.setOrderLogRemark("添加订单");
		mfoyouOrderLog.setOrderType(OrderType.goodsOrder.getValue());
		huawuOrderLogMapper.insertSelective(mfoyouOrderLog);
		return goodsOrder;
	}
	@Override
	public MfoyouGoodsOrderWithPackage getGoodsOrderWith(Integer orderId,boolean tag) {
		MfoyouGoodsOrderWithPackage goodsOrderWith = mfoyouGoodsOrderMapper.getGoodsOrderWith(orderId);
		if(tag && goodsOrderWith.getOrderTransportId()!=null){
			HuawuServiceOrder serviceOrder = huawuServiceOrderMapper
					.selectByPrimaryKey(goodsOrderWith.getOrderTransportId());
			if (serviceOrder != null && serviceOrder.getServiceOrderReceiveUser() != null) {
				goodsOrderWith.setServiceOrder(serviceOrder);
				HuawuWorker mfoyouworker = huawuWorkerMapper
						.selectByPrimaryKey(serviceOrder.getServiceOrderReceiveUser());
				goodsOrderWith.setMfoyouWorker(mfoyouworker);
			}
		}
		if (tag &&  goodsOrderWith.getStoreId() != null) {
			HuawuStoreInfo selectByPrimaryKey = huawuStoreInfoMapper.selectByPrimaryKey(goodsOrderWith.getStoreId());
			HuawuStoreInfo info = new HuawuStoreInfo();
			info.setStorePhone(selectByPrimaryKey.getStorePhone());
			info.setStorePrinterNumber(selectByPrimaryKey.getStorePrinterNumber());
			goodsOrderWith.setStoreInfo(info);
		}
		if (tag && goodsOrderWith.getUserId() != null) {
			HuawuUser selectByPrimaryKey = huawuUserMapper.selectByPrimaryKey(goodsOrderWith.getUserId());
			HuawuUser user = new HuawuUser();
				if(selectByPrimaryKey!=null && selectByPrimaryKey.getUserSex()!=null){
					user.setUserSex(selectByPrimaryKey.getUserSex());
				}
				goodsOrderWith.setMfoyouUser(user);
		}
		return goodsOrderWith;
	}
	@Override
	public MfoyouGoodsOrderEx getGoodsOrder(Integer orderId) {
		MfoyouGoodsOrderEx mfoyouGoodsOrderEx = new MfoyouGoodsOrderEx();
		MfoyouGoodsOrder mfoyouGoodsOrder = mfoyouGoodsOrderMapper.selectByPrimaryKey(orderId);
		if (mfoyouGoodsOrder == null)
			return null;
		ReflectUtil.ObjectCopy(mfoyouGoodsOrder, mfoyouGoodsOrderEx);
		MfoyouGoodsOrderItmeExample example = new MfoyouGoodsOrderItmeExample();
		example.or().andOrderIdEqualTo(orderId);
		mfoyouGoodsOrderEx.setList(mfoyouGoodsOrderItmeMapper.selectByExample(example));
		return mfoyouGoodsOrderEx;
	}
	@Override
	public Boolean delAllMfoyouGoodsOrderCart(Integer customerId, Integer storeId) {
        MfoyouGoodsOrderCartExample example = new MfoyouGoodsOrderCartExample();
        MfoyouGoodsOrderCartExample.Criteria criteria = example.or().andUserIdEqualTo(customerId);
        if (storeId != null) {
            criteria.andStoreIdEqualTo(storeId);
        }
        mfoyouGoodsOrderCartMapper.deleteByExample(example);
        return true;
    }
	// 带异常状态的订单接口
		@Override
		@Transactional(propagation = Propagation.REQUIRED, rollbackForClassName = "Exception")
		public ArrayListObject<MfoyouGoodsOrderWithPackage> getGoodsOrderWithPackageListV1(Integer storeId,
				Integer pageIndex, Integer pageSize) {
			Integer start = null;
			Integer end = null;
			if (pageIndex != null && pageSize != null) {
				start = (pageIndex - 1) * pageSize;
				end = pageSize;
			}
			List<MfoyouGoodsOrderWithPackage> list = mfoyouGoodsOrderMapper.selectByExampleWithPacketV1(storeId, start,
					end);
			int count = mfoyouSystemMapper.selectCount();
			int size = list.size();
			for (int i = 0; i < size; i++) {
				MfoyouGoodsOrderWithPackage mfoyouGoodsOrderWithPackage = list.get(i);
				if (mfoyouGoodsOrderWithPackage.getOrderTransportId() != null) {
					HuawuServiceOrder serviceOrder = huawuServiceOrderMapper
							.selectByPrimaryKey(mfoyouGoodsOrderWithPackage.getOrderTransportId());
					mfoyouGoodsOrderWithPackage.setServiceOrder(serviceOrder);
				}
			}
			return ArrayListObject.bliudArrayList(list, pageIndex, pageSize, count);
		}
		@Override
		public MfoyouGoodsOrderDetail getMfoyouOrderPosition(Integer orderid) {
			MfoyouGoodsOrderDetail detail = new MfoyouGoodsOrderDetail();
			MfoyouGoodsOrder mfoyouGoodsOrder = mfoyouGoodsOrderMapper.selectByPrimaryKey(orderid);
			detail.setMfoyouGoodsOrder(mfoyouGoodsOrder);
			HuawuOrderLogExample example = new HuawuOrderLogExample();
			example.or().andServiceOrderIdEqualTo(orderid).andOrderTypeEqualTo(OrderType.goodsOrder.getValue());
			List<HuawuOrderLog> logs = huawuOrderLogMapper.selectByExample(example);
			detail.setMfoyouOrderLogs(logs);
			HuawuStoreInfo mfoyouStoreInfo = huawuStoreInfoMapper.selectByPrimaryKey(mfoyouGoodsOrder.getStoreId());
			HuawuStoreInfo storeInfo = new HuawuStoreInfo();
			// 后期优化
			storeInfo.setStoreLocalLon(mfoyouStoreInfo.getStoreLocalLon());
			storeInfo.setStoreLocalLat(mfoyouStoreInfo.getStoreLocalLat());
			HuawuWorker worker = new HuawuWorker();
			detail.setMfoyouStoreInfo(storeInfo);
			if (mfoyouGoodsOrder.getOrderTransportId() != null) {
				HuawuServiceOrder selectByPrimaryKey = huawuServiceOrderMapper
						.selectByPrimaryKey(mfoyouGoodsOrder.getOrderTransportId());
				if (selectByPrimaryKey.getServiceOrderReceiveUser() != null) {
					HuawuWorker worker1 = huawuWorkerMapper
							.selectByPrimaryKey(selectByPrimaryKey.getServiceOrderReceiveUser());
					worker.setWorkerStar(worker1.getWorkerStar());
					worker.setWorkerServiceDistance(worker1.getWorkerServiceDistance());
					worker.setWorkerOrderCount(worker1.getWorkerOrderCount());
					worker.setWorkerName(worker1.getWorkerName());
					worker.setWorkerPhone(worker1.getWorkerPhone());
				}
			}
			detail.setMfoyouWorker(worker);
			return detail;
		}
		@Override
		public ArrayListObject<MfoyouGoodsOrderWithPackage> getMfoyouGoodsOrderWithPackList(
				MfoyouGoodsOrder mfoyouGoodsOrder, Integer pageIndex, Integer pageSize, Date startDate, Date endDate,
				List<Integer> state, Integer isNeed,String key) {
			MfoyouGoodsOrderExample example = new MfoyouGoodsOrderExample();
			MybatisGenerator.setLimit(example, pageIndex, pageSize);
			Criteria criteria = example.or();
			if (startDate != null) {
				criteria.andOrderGctGreaterThan(startDate);
			}
			if (endDate != null) {
				criteria.andOrderGctLessThan(endDate);
			}
			if (state != null && state.size() > 0) {
				criteria.andOrderStateIn(state);
			}
			if (state==null || !state.contains(900)) {
				criteria.andOrderExceptionStateLessThan(8);
			}
			if(key!=null){
				criteria.andSearchBykey(key);
			}
			MybatisGenerator.makeExample(mfoyouGoodsOrder, criteria);
			int count = 0;
			if (isNeed == null || isNeed == 0) {
				// 下面源码example已修改，为判断是否本地订单
				criteria.andOrderActiveAmountEqualTo(0);
				count = mfoyouGoodsOrderMapper.countByExample(example);
			} else if (isNeed == 1) {
				criteria.andOrderActiveAmountEqualTo(0);
				count = mfoyouGoodsOrderMapper.countAll(mfoyouGoodsOrder.getStoreId(), isNeed);
			} else if(isNeed==2){
				count = mfoyouGoodsOrderMapper.countAll(mfoyouGoodsOrder.getStoreId(), isNeed);
			} else if(isNeed==3){
				count = mfoyouGoodsOrderMapper.countByExample(example);
			}
			example.setOrderByClause(" order_id desc");
			List<MfoyouGoodsOrderWithPackage> list = mfoyouGoodsOrderMapper.selectByExampleWithPacket(example);
			int size = list.size();
			for (int i = 0; i < size; i++) {
				MfoyouGoodsOrderWithPackage mfoyouGoodsOrderWithPackage = list.get(i);
				if (mfoyouGoodsOrderWithPackage.getOrderTransportId() != null) {
					HuawuServiceOrder serviceOrder = huawuServiceOrderMapper
							.selectByPrimaryKey(mfoyouGoodsOrderWithPackage.getOrderTransportId());
					mfoyouGoodsOrderWithPackage.setServiceOrder(serviceOrder);
				}
			}
			return ArrayListObject.bliudArrayList(list, pageIndex, pageSize, count);
		}

		@Override
		public int updateOrderByPromaryKey(MfoyouGoodsOrder order) {

			return mfoyouGoodsOrderMapper.updateByPrimaryKeySelective(order);
		}

		// when system make sure the goodsorder.
		@Override
		public int systemUpdateOrder(MfoyouGoodsOrder order, Integer fromState, Integer toState) {
			MfoyouGoodsOrderExample example = new MfoyouGoodsOrderExample();
			example.or().andOrderStateEqualTo(fromState).andOrderIdEqualTo(order.getOrderId());
			MfoyouGoodsOrder mfoyouGoodsOrder = new MfoyouGoodsOrder();
			mfoyouGoodsOrder.setOrderState(toState);
			return mfoyouGoodsOrderMapper.updateByExampleSelective(mfoyouGoodsOrder, example);
		}
		@Override
		public int updateOrderState(MfoyouGoodsOrder order, Integer transpost, Integer fromState, Integer orderstate) {

			MfoyouGoodsOrderExample example = new MfoyouGoodsOrderExample();
			Criteria or = example.or();
			or.andOrderIdEqualTo(order.getOrderId());
			if (fromState != null && fromState != 0) {
				or.andOrderStateEqualTo(fromState);
			}
			if (transpost != null) {
				order.setOrderTransportState(transpost);
			}
			if (orderstate != null) {
				order.setOrderState(orderstate);
			}
			int ret = mfoyouGoodsOrderMapper.updateByExampleSelective(order, example);
			if (ret == 1) {
				HuawuOrderLog mfoyouOrderLog = new HuawuOrderLog();
				mfoyouOrderLog.setOrderLogUserId(order.getUserId());
				mfoyouOrderLog.setOrderLogState(orderstate);
				mfoyouOrderLog.setOrderLogTime(new Date());
				mfoyouOrderLog.setServiceOrderId(order.getOrderId());
				mfoyouOrderLog.setOrderLogRemark("商品状态变更");
				mfoyouOrderLog.setOrderType(OrderType.goodsOrder.getValue());
				huawuOrderLogMapper.insertSelective(mfoyouOrderLog);
			}
			return ret;
		}
		@Override
		public Boolean mdfGoodsOrder(MfoyouGoodsOrder order) {
			return mfoyouGoodsOrderMapper.updateByPrimaryKeySelective(order) == 1;
		}
		@Override
		public List<MfoyouGoodsOrder> getMfoyouGoodsOrder(Date date) {
			MfoyouGoodsOrderExample example = new MfoyouGoodsOrderExample();
			ArrayList<Integer> integers = new ArrayList<Integer>(2);
			integers.add(3);
			integers.add(1);
			example.or().andOrderUserExpectTimeLessThanOrEqualTo(date)
					.andOrderStateBetween(GoodsOrderState.emStoreAccept.getValue(), GoodsOrderState.emStoreFinsh.getValue())
					.andOrderExceptionStateNotIn(integers);
			List<MfoyouGoodsOrder> orders = mfoyouGoodsOrderMapper.selectByExample(example);
			return orders;
		}
		@Override
		public boolean mdfStoreServiceByStateTime(int fromState, int toState, Date sDate, Date eDate, int opUserId) {
			MfoyouGoodsOrderExample example = new MfoyouGoodsOrderExample();
			Criteria or = example.or();
			or.andOrderStateEqualTo(fromState);
			List<MfoyouGoodsOrder> selectByExample = mfoyouGoodsOrderMapper.selectByExample(example);
			if (selectByExample == null || selectByExample.size() == 0) {
				return false;
			}
			MfoyouGoodsOrder order = new MfoyouGoodsOrder();
			order.setOrderState(toState);
			order.setOrderFinshTime(new Date());
			if (sDate != null) {
				or.andOrderGmtGreaterThanOrEqualTo(sDate);
			}
			if (eDate != null) {
				or.andOrderGctLessThan(eDate);
			}
			mfoyouGoodsOrderMapper.updateByExampleSelective(order, example);
			for (int i = 0; i < selectByExample.size(); i++) {
				HuawuOrderLog mfoyouOrderLog = new HuawuOrderLog();
				mfoyouOrderLog.setOrderLogUserId(opUserId);
				mfoyouOrderLog.setOrderLogState(toState);
				mfoyouOrderLog.setOrderLogTime(new Date());
				mfoyouOrderLog.setServiceOrderId(selectByExample.get(i).getOrderId());
				mfoyouOrderLog.setOrderLogRemark("商品订单批量状态变更");
				mfoyouOrderLog.setOrderType(OrderType.goodsOrder.getValue());
				huawuOrderLogMapper.insertSelective(mfoyouOrderLog);
			}
			return true;
		}
		@Override
		public int modifyWaimaiOrder() {
			String sql = "update mfoyou_goods_order set order_state = 700 where  order_gct < date_sub(now(),interval 1 day) and order_state=1";
			return mfoyouSystemMapper.update_item(sql);
		}
		@Override
		public int fininshOrder() {
			List<Integer> states = new ArrayList<Integer>();
			// states.add(1);
			// states.add(GoodsOrderState.emPaySucess.getValue());
			// states.add(GoodsOrderState.emWaitingAccept.getValue());
			states.add(GoodsOrderState.emStoreAccept.getValue());
			states.add(GoodsOrderState.emSeekRuner.getValue());
			states.add(GoodsOrderState.emAccect.getValue());
			states.add(GoodsOrderState.emBeginDelivery.getValue());
			states.add(GoodsOrderState.emFinshDelivery.getValue());
			states.add(GoodsOrderState.emStoreFinsh.getValue());
			MfoyouGoodsOrderExample example = new MfoyouGoodsOrderExample();
			example.or().andOrderSettlementDateLessThan(new Date()).andOrderStateIn(states).andOrderPayTimeIsNotNull();
			List<MfoyouGoodsOrder> selectByExample = mfoyouGoodsOrderMapper.selectByExample(example);
			if (selectByExample == null || selectByExample.size() == 0) {
				return 0;
			}
			MfoyouGoodsOrder order = new MfoyouGoodsOrder();
			order.setOrderState(GoodsOrderState.emCustomerFinsh.getValue());
			int ret = mfoyouGoodsOrderMapper.updateByExampleSelective(order, example);
			if (ret == 1) {
				for (MfoyouGoodsOrder mfoyouGoodsOrder : selectByExample) {
					HuawuOrderLog mfoyouOrderLog = new HuawuOrderLog();
					mfoyouOrderLog.setOrderLogUserId(mfoyouGoodsOrder.getUserId());
					mfoyouOrderLog.setOrderLogState(mfoyouGoodsOrder.getOrderState());
					mfoyouOrderLog.setOrderLogTime(new Date());
					mfoyouOrderLog.setServiceOrderId(order.getOrderId());
					mfoyouOrderLog.setOrderLogRemark("结算日期商品状态自动更改");
					mfoyouOrderLog.setOrderType(OrderType.goodsOrder.getValue());
					huawuOrderLogMapper.insertSelective(mfoyouOrderLog);
				}
			}
			return ret;
		}
		@Override
		public List<MfoyouGoodsOrder> getGoodsOrderList(MfoyouGoodsOrder mfoyouGoodsOrder) {

			MfoyouGoodsOrderExample example = new MfoyouGoodsOrderExample();
			example.or().andOrderStateEqualTo(mfoyouGoodsOrder.getOrderState()).andOrderSettlementDateLessThan(new Date())
					.andOrderActiveAmountEqualTo(0);
			return mfoyouGoodsOrderMapper.selectByExample(example);
		}
		@Override
		public int fininshGoodorder(Integer orderId) {
			MfoyouGoodsOrder mfoyouGoodsOrder = new MfoyouGoodsOrder();
			mfoyouGoodsOrder.setOrderState(GoodsOrderState.emSystemFinsh.getValue());
			MfoyouGoodsOrderExample mfoyouGoodsOrderExample = new MfoyouGoodsOrderExample();
			mfoyouGoodsOrderExample.or().andOrderStateEqualTo(GoodsOrderState.emCustomerFinsh.getValue())
					.andOrderIdEqualTo(orderId);
			int bRet = mfoyouGoodsOrderMapper.updateByExampleSelective(mfoyouGoodsOrder, mfoyouGoodsOrderExample);
			if (bRet == 1) {
				HuawuOrderLog mfoyouOrderLog = new HuawuOrderLog();
				mfoyouOrderLog.setOrderLogUserId(-22);
				mfoyouOrderLog.setOrderLogState(GoodsOrderState.emSystemFinsh.getValue());
				mfoyouOrderLog.setOrderLogTime(new Date());
				mfoyouOrderLog.setServiceOrderId(orderId);
				mfoyouOrderLog.setOrderLogRemark("商品状态完结结算");
				mfoyouOrderLog.setOrderType(OrderType.goodsOrder.getValue());
				huawuOrderLogMapper.insertSelective(mfoyouOrderLog);
			}
			return bRet;
		}
		@Override
		public List<MfoyouOrderStatistics> getAgentStatistics(Integer agentid, Date sdate, Date edate, int userType) {
			List<MfoyouOrderStatistics> allcount = new ArrayList<>();
			Calendar calendar0 = Calendar.getInstance();
			calendar0.add(Calendar.DATE, -1);
			if (calendar0.getTime().before(edate) && calendar0.getTime().after(sdate)) {
				MfoyouOrderStatistics today = mfoyouOrderStatisticsMapper.getTodayByAgentId(agentid, 0, userType);
				today.setIsIntoAccount(0);
				allcount.add(today);
			}
			Calendar calendar1 = Calendar.getInstance();
			calendar1.add(Calendar.DATE, -2);
			if (calendar1.getTime().before(edate) && calendar1.getTime().after(sdate)) {
				MfoyouOrderStatistics yesterday = mfoyouOrderStatisticsMapper.getTodayByAgentId(agentid, 1, userType);
				yesterday.setIsIntoAccount(0);
				allcount.add(yesterday);
			}
			Calendar calendar2 = Calendar.getInstance();
			calendar2.add(Calendar.DATE, -3);
			if (calendar2.getTime().before(edate) && calendar2.getTime().after(sdate)) {
				MfoyouOrderStatistics byesterday = mfoyouOrderStatisticsMapper.getTodayByAgentId(agentid, 2, userType);
				byesterday.setIsIntoAccount(0);
				allcount.add(byesterday);
			}
			allcount.addAll(mfoyouOrderStatisticsMapper.selectAgentdataByExample(agentid, sdate, edate));
			return allcount;
		}
		@Override
		public List<MfoyouOrderStatistics> getAgentMoney(Integer agentId, Integer daynumber, int userType) {

			MfoyouOrderStatistics beforeYesterday = mfoyouOrderStatisticsMapper.getTodayByAgentId(agentId, 2, userType);
			beforeYesterday.setIsIntoAccount(0);
			MfoyouOrderStatistics yesterday = mfoyouOrderStatisticsMapper.getTodayByAgentId(agentId, 1, userType);
			yesterday.setIsIntoAccount(0);
			List<MfoyouOrderStatistics> mfoyouOrderStatistics = new ArrayList<>();
			mfoyouOrderStatistics.add(yesterday);
			mfoyouOrderStatistics.add(beforeYesterday);
			List<MfoyouOrderStatistics> selectByAgentId = null;
			if (daynumber == null) {
				daynumber = 7;
				selectByAgentId = mfoyouOrderStatisticsMapper.selectByAgentIdWeek(agentId, userType);
			} else {
				selectByAgentId = mfoyouOrderStatisticsMapper.selectByAgentId(agentId, daynumber, userType);
			}
			mfoyouOrderStatistics.addAll(selectByAgentId);
			return mfoyouOrderStatistics;
		}
		@Override
		public MfoyouOrderStatistics getAgentToday(Integer agentId, Integer daycount, int userType) {
			return mfoyouOrderStatisticsMapper.getTodayByAgentId(agentId, daycount, userType);
		}
		  @Override
		    public int applyMfoyouServiceV2(MfoyouAgentServicePricev2 mfoyouAgentServicePricev2) {
		        int updateByPrimaryKeySelective = mfoyouAgentServicePricev2Mapper.updateByPrimaryKeySelective(mfoyouAgentServicePricev2);
		        if(updateByPrimaryKeySelective==0){
		            int insertSelective = mfoyouAgentServicePricev2Mapper.insertSelective(mfoyouAgentServicePricev2);
		            return insertSelective;
		        }
		        return 1;
		    }

		    @Override
		    public MfoyouAgentServicePricev2 getStoreServicePriceV2(Integer agentId,boolean isAdd) {
		        MfoyouAgentServicePricev2 selectByPrimaryKey = mfoyouAgentServicePricev2Mapper.selectByPrimaryKey(agentId);
		        if(selectByPrimaryKey==null){
		            selectByPrimaryKey = mfoyouAgentServicePricev2Mapper.selectByPrimaryKey(0);
		            if(selectByPrimaryKey!=null && isAdd){
		                selectByPrimaryKey.setAgentId(agentId);
		                mfoyouAgentServicePricev2Mapper.insertSelective(selectByPrimaryKey);
		            }
		        }
		        return selectByPrimaryKey;
		    }
		    @Override
			public int updateGoodOrder(MfoyouGoodsOrder oldGoodsOrder, MfoyouGoodsOrder newGoodsOrder) {
				MfoyouGoodsOrderExample example = new MfoyouGoodsOrderExample();
				if (oldGoodsOrder.getOrderTransportId() == null) {
//					logger.error("TransportId is null");
					return 0;
				}
				if (oldGoodsOrder.getOrderId() != null) {
					example.or().andOrderIdEqualTo(oldGoodsOrder.getOrderId());
				} else {
					example.or().andOrderTransportIdEqualTo(oldGoodsOrder.getOrderTransportId());
				}

				List<MfoyouGoodsOrder> mfoyouGoodsOrders = mfoyouGoodsOrderMapper.selectByExample(example);
				if (mfoyouGoodsOrders == null || mfoyouGoodsOrders.size() != 1) {
//					logger.error("TransportId is error");
					return 0;
				}
				Integer orderid = mfoyouGoodsOrders.get(0).getOrderId();
				newGoodsOrder.setOrderId(orderid);
				int bRet = mfoyouGoodsOrderMapper.updateByPrimaryKeySelective(newGoodsOrder);
				if (bRet == 1) {
					HuawuOrderLog mfoyouOrderLog = new HuawuOrderLog();
					mfoyouOrderLog.setOrderLogUserId(oldGoodsOrder.getUserId());
					mfoyouOrderLog.setOrderLogState(newGoodsOrder.getOrderState());
					mfoyouOrderLog.setOrderLogTime(new Date());
					mfoyouOrderLog.setServiceOrderId(orderid);
					mfoyouOrderLog.setOrderLogRemark("商品状态变更");
					mfoyouOrderLog.setOrderType(OrderType.goodsOrder.getValue());
					huawuOrderLogMapper.insertSelective(mfoyouOrderLog);
				}
				return bRet;
			}
		    
}
