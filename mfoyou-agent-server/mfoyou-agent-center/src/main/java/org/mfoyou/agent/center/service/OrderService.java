package org.mfoyou.agent.center.service;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mfoyou.agent.center.dao.inf.AgentTestMapper;
import org.mfoyou.agent.center.dao.inf.HuawuEvaluateMapper;
import org.mfoyou.agent.center.dao.inf.HuawuOrderLogMapper;
import org.mfoyou.agent.center.dao.inf.HuawuServiceOrderMapper;
import org.mfoyou.agent.center.dao.inf.HuawuServicePriceMapper;
import org.mfoyou.agent.center.dao.inf.HuawuSystemMapper;
import org.mfoyou.agent.center.dao.inf.MfoyouRegionCustomMapper;
import org.mfoyou.agent.center.dao.mfoyou.inf.MfoyouOrderStatisticsMapper;
import org.mfoyou.agent.common.dao.domain.AgentTest;
import org.mfoyou.agent.common.dao.domain.HuawuEvaluate;
import org.mfoyou.agent.common.dao.domain.HuawuEvaluateExample;
import org.mfoyou.agent.common.dao.domain.HuawuOrderLog;
import org.mfoyou.agent.common.dao.domain.HuawuOrderLogExample;
import org.mfoyou.agent.common.dao.domain.HuawuServiceOrder;
import org.mfoyou.agent.common.dao.domain.HuawuServiceOrderExample;
import org.mfoyou.agent.common.dao.domain.HuawuServiceOrderExample.Criteria;
import org.mfoyou.agent.common.dao.domain.HuawuServicePrice;
import org.mfoyou.agent.common.dao.domain.MfoyouRegionCustom;
import org.mfoyou.agent.common.dao.domain.MfoyouRegionCustomExample;
import org.mfoyou.agent.common.dao.mfoyou.domain.MfoyouOrderStatistics;
import org.mfoyou.agent.common.entity.enums.OrderState;
import org.mfoyou.agent.common.entity.enums.OrderType;
import org.mfoyou.agent.common.inf.IOrder;
import org.mfoyou.agent.utils.common.ArrayListObject;
import org.mfoyou.agent.utils.common.DateUtils;
import org.mfoyou.agent.utils.common.StrUtil;
import org.mfoyou.agent.utils.sql.MybatisGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderService implements IOrder {
	@Autowired
	AgentTestMapper agentTestMapper;
	@Autowired
	HuawuServiceOrderMapper huawuServiceOrderMapper;
	@Autowired
	HuawuOrderLogMapper huawuOrderLogMapper;
	@Autowired
	HuawuSystemMapper huawuSystemMapper;
	@Autowired
	HuawuEvaluateMapper huawuEvaluateMapper;
	@Autowired
	HuawuServicePriceMapper huawuServicePriceMapper;
	@Autowired
	MfoyouRegionCustomMapper mfoyouRegionCustomMapper;
	@Autowired
	MfoyouOrderStatisticsMapper mfoyouOrderStatisticsMapper;
	@Override
	public AgentTest getAgntTets(int id) {
		return agentTestMapper.selectByPrimaryKey(id);
	}

	@Override
	public HuawuServiceOrder addServiceOrder(HuawuServiceOrder huawuServiceOrder) {
		huawuServiceOrder.setServiceOrderId(null);
		int ret = huawuServiceOrderMapper.insertSelective(huawuServiceOrder);
		HuawuOrderLog mfoyouOrderLog = new HuawuOrderLog();
		mfoyouOrderLog.setOrderLogUserId(huawuServiceOrder.getServiceOrderSendUser());
		mfoyouOrderLog.setOrderLogState(huawuServiceOrder.getServiceOrderState());
		mfoyouOrderLog.setOrderLogTime(new Date());
		mfoyouOrderLog.setServiceOrderId(huawuServiceOrder.getServiceOrderId());
		mfoyouOrderLog.setOrderLogRemark("添加订单");
		mfoyouOrderLog.setOrderType(OrderType.serviceOrder.getValue());
		mfoyouOrderLog.setOrderAgentid(huawuServiceOrder.getAgentId());
		huawuOrderLogMapper.insertSelective(mfoyouOrderLog);
		if (ret == 1) {
			return huawuServiceOrder;
		}
		return null;
	}

	@Override
	public Boolean updateServiceOrderState(HuawuServiceOrder oldOrder, HuawuServiceOrder targetOrder,
			Integer opUserId) {
		HuawuServiceOrderExample example = new HuawuServiceOrderExample();
		if (targetOrder.getServiceOrderState() != null
				&& targetOrder.getServiceOrderState() == OrderState.emRunerAccept.getValue()) {
			List<Integer> list = new ArrayList<>();
			list.add(OrderState.emPaySucess.getValue());
			list.add(OrderState.emSeekRuner.getValue());
			example.or().andServiceOrderStateIn(list).andServiceOrderIdEqualTo(oldOrder.getServiceOrderId())
					.andServiceOrderReceiveUserIsNull();
		} else {
			MybatisGenerator.makeExample(oldOrder, example.or());
		}
		Boolean bRet = huawuServiceOrderMapper.updateByExampleSelective(targetOrder, example) == 1;
		if (bRet) {
			HuawuOrderLog mfoyouOrderLog = new HuawuOrderLog();
			mfoyouOrderLog.setOrderLogUserId(opUserId);
			mfoyouOrderLog.setOrderLogState(targetOrder.getServiceOrderState());
			mfoyouOrderLog.setOrderLogTime(new Date());
			mfoyouOrderLog.setServiceOrderId(oldOrder.getServiceOrderId());
			mfoyouOrderLog.setOrderLogRemark("状态变更");
			mfoyouOrderLog.setOrderType(OrderType.serviceOrder.getValue());
			huawuOrderLogMapper.insertSelective(mfoyouOrderLog);
		}
		return bRet;
	}

	@Override
	public HuawuServiceOrder getServiceOrderInfo(Integer orderId) {
		return huawuServiceOrderMapper.selectByPrimaryKey(orderId);
	}

	@Override
	public ArrayListObject<HuawuServiceOrder> getServiceOrderList(HuawuServiceOrder mfoyouServiceOrder,
			Integer pageIndex, Integer pageSize, Date startDate, Date endDate, List<Integer> state, Integer orderBy) {
		int flag = 1;
		HuawuServiceOrderExample example = new HuawuServiceOrderExample();
		MybatisGenerator.setLimit(example, pageIndex, pageSize);
		Criteria criteria = example.or();
		if (startDate != null) {
			criteria.andServiceOrderEffectTimeGreaterThan(startDate);
		}
		if (endDate != null) {
			criteria.andServiceOrderEffectTimeLessThan(endDate);
		}
		if (state != null && state.size() > 0) {
			criteria.andServiceOrderStateIn(state);
		}
		if (orderBy == null || orderBy != 4) {
			flag = 0;
			MybatisGenerator.makeExample(mfoyouServiceOrder, criteria);
		} else {
			criteria.andServiceOrderReceiveUserEqualTo(mfoyouServiceOrder.getServiceOrderReceiveUser());
		}
		if (orderBy != null) {
			if (orderBy == 1) {
				example.setOrderByClause(" service_order_state asc , service_order_id desc");
			} else {
				example.setOrderByClause(" service_order_id desc");
			}
		} else {
			example.setOrderByClause(" service_order_id desc");
		}
		int count = 0;
		if (flag == 1) {
			count = huawuServiceOrderMapper.countAll(mfoyouServiceOrder.getServiceUserLon(),
					mfoyouServiceOrder.getServiceUserLat(), mfoyouServiceOrder.getAgentId(),
					mfoyouServiceOrder.getServiceOrderReceiveUser());
		} else {
			count = huawuServiceOrderMapper.countByExample(example);
		}
		// int count = mfoyouServiceOrderMapper.countByExample(example);
		List<HuawuServiceOrder> list = huawuServiceOrderMapper.selectByExample(example);
		return ArrayListObject.bliudArrayList(list, pageIndex, pageSize, count);
	}

	@Override
	public Map<Integer, Integer> getWorkerOrder(List<Integer> workerIds, List<Integer> listState, Date finshS,
			Date finshE) {
		String sql = "select service_order_receive_user as userId , count(*) as orderCount  from huawu_service_order where service_order_receive_user in"
				+ MybatisGenerator.makeIn(workerIds);

		sql += " and service_order_state in " + MybatisGenerator.makeIn(listState);

		if (finshS != null) {
			sql += " and service_order_finsh_time >='" + DateUtils.datetimeFormat.format(finshS) + "'";
		}
		if (finshE != null) {
			sql += " and service_order_finsh_time <'" + DateUtils.datetimeFormat.format(finshE) + "'";
		}
		sql += " group by service_order_receive_user";

		List<Map<String, Object>> ret = huawuSystemMapper.select_list(sql);
		Map<Integer, Integer> rl = new HashMap<>();
		for (Map<String, Object> map : ret) {
			rl.put((int) map.get("userId"), StrUtil.parseInteger(map.get("orderCount")));
		}
		return rl;
	}

	@Override
	public List<HuawuServiceOrder> getServiceOrderListbyId(List<Integer> listId, List<Integer> listState,
			List<Integer> workerIds) {
		HuawuServiceOrderExample example = new HuawuServiceOrderExample();
		Criteria criteria = example.or();
		Boolean bret = false;
		if (listId != null && listId.size() > 0) {
			criteria.andServiceOrderIdIn(listId);
			bret = true;
		}
		if (listState != null && listState.size() > 0) {
			criteria.andServiceOrderStateIn(listState);
			bret = true;
		}
		if (workerIds != null && workerIds.size() > 0) {
			criteria.andServiceOrderReceiveUserIn(workerIds);
			bret = true;
		}
		if (!bret)
			return null;
		return huawuServiceOrderMapper.selectByExample(example);
	}

	@Override
	public Integer getOrderCount(HuawuServiceOrder mfoyouServiceOrder, Date startDate, Date endDate,
			List<Integer> state) {
		HuawuServiceOrderExample example = new HuawuServiceOrderExample();
		Criteria criteria = example.or();
		if (startDate != null) {
			criteria.andServiceOrderCreateTimeGreaterThanOrEqualTo(startDate);
		}
		if (endDate != null) {
			criteria.andServiceOrderCreateTimeLessThan(endDate);
		}
		if (state != null && state.size() > 0) {
			criteria.andServiceOrderStateIn(state);
		}
		MybatisGenerator.makeExample(mfoyouServiceOrder, criteria);
		return huawuServiceOrderMapper.countByExample(example);

	}

	@Override
	public ArrayListObject<HuawuEvaluate> getEvaluate(HuawuEvaluate mfoyouEvaluate, Integer pageIndex, Integer pageSize,
			Date startDate, Date endDate, Integer minScore, Integer maxScore) {
		HuawuEvaluateExample example = new HuawuEvaluateExample();
		MybatisGenerator.setLimit(example, pageIndex, pageSize);
		org.mfoyou.agent.common.dao.domain.HuawuEvaluateExample.Criteria criteria = example.or();
		if (startDate != null) {
			criteria.andEvaluateTimeGreaterThanOrEqualTo(startDate);
		}
		if (endDate != null) {
			criteria.andEvaluateTimeLessThan(endDate);
		}
		if (minScore != null) {
			criteria.andEvaluateStarGreaterThanOrEqualTo(minScore);
		}
		if (maxScore != null) {
			criteria.andEvaluateStarLessThan(maxScore);
		}
		MybatisGenerator.makeExample(mfoyouEvaluate, criteria);
		int count = huawuEvaluateMapper.countByExample(example);
		List<HuawuEvaluate> list = huawuEvaluateMapper.selectByExample(example);
		return ArrayListObject.bliudArrayList(list, pageIndex, pageSize, count);
	}

	@Override
	public Map<Integer, Integer> getEvaluateScoreCount(Integer agentId, Date startDate, Date endDate) {

		String sql = "SELECT evaluate_star as score,count(*) as ct FROM `huawu_evaluate` where agent_id=" + agentId;
		if (startDate != null) {
			sql += " and evaluate_time >='" + DateUtils.datetimeFormat.format(startDate) + "'";
		}
		if (endDate != null) {
			sql += " and evaluate_time <'" + DateUtils.datetimeFormat.format(endDate) + "'";
		}
		sql += " GROUP BY  evaluate_star";

		List<Map<String, Object>> selectList = huawuSystemMapper.select_list(sql);
		Map<Integer, Integer> ret = new HashMap<Integer, Integer>();
		ret.put(1, 0);
		ret.put(2, 0);
		ret.put(3, 0);
		ret.put(4, 0);
		ret.put(5, 0);
		for (Map<String, Object> map : selectList) {
			ret.put(StrUtil.parseInteger(map.get("score")), StrUtil.parseInteger(map.get("ct")));
		}

		return ret;
	}

	@Override
	public Map<Integer, Integer> getRunerEvaluateScoreCount(Integer worker_id, Date startDate, Date endDate) {

		String sql = "SELECT evaluate_star as score,count(*) as ct FROM `huawu_evaluate` where worker_id=" + worker_id;
		if (startDate != null) {
			sql += " and evaluate_time >='" + DateUtils.datetimeFormat.format(startDate) + "'";
		}
		if (endDate != null) {
			sql += " and evaluate_time <'" + DateUtils.datetimeFormat.format(endDate) + "'";
		}
		sql += " GROUP BY  evaluate_star";

		List<Map<String, Object>> selectList = huawuSystemMapper.select_list(sql);
		Map<Integer, Integer> ret = new HashMap<Integer, Integer>();
		ret.put(1, 0);
		ret.put(2, 0);
		ret.put(3, 0);
		ret.put(4, 0);
		ret.put(5, 0);
		for (Map<String, Object> map : selectList) {
			ret.put(StrUtil.parseInteger(map.get("score")), StrUtil.parseInteger(map.get("ct")));
		}
		return ret;
	}

	@Override
	public HuawuServicePrice getConfigurePriceByAgentId(Integer agentId, boolean isAdd) {
		// 获取价格配置列表
		HuawuServicePrice selectByPrimaryKey = huawuServicePriceMapper.selectByPrimaryKey(agentId);
		if (selectByPrimaryKey == null) {
			selectByPrimaryKey = huawuServicePriceMapper.selectByPrimaryKey(0);
			if (selectByPrimaryKey != null && isAdd) {
				selectByPrimaryKey.setAgentId(agentId);
				selectByPrimaryKey.setCreateTime(null);
				selectByPrimaryKey.setState(0);
				selectByPrimaryKey.setModifyTime(null);
				huawuServicePriceMapper.insertSelective(selectByPrimaryKey);
			}
		}
		return selectByPrimaryKey;
	}

	@Override
	public Boolean mdfServiceOrder(HuawuServiceOrder mfoyouServiceOrder, Integer opUserId) {
		if (mfoyouServiceOrder.getServiceOrderId() == null)
			return null;
		if (mfoyouServiceOrder.getServiceOrderState() != null) {
			HuawuOrderLog mfoyouOrderLog = new HuawuOrderLog();
			mfoyouOrderLog.setOrderLogUserId(opUserId);
			mfoyouOrderLog.setOrderLogState(mfoyouServiceOrder.getServiceOrderState());
			mfoyouOrderLog.setOrderLogTime(new Date());
			mfoyouOrderLog.setServiceOrderId(mfoyouServiceOrder.getServiceOrderId());
			mfoyouOrderLog.setOrderLogRemark("订单状态变化");
			mfoyouOrderLog.setOrderType(OrderType.serviceOrder.getValue());
			huawuOrderLogMapper.insertSelective(mfoyouOrderLog);
		}
		return 1 == huawuServiceOrderMapper.updateByPrimaryKeySelective(mfoyouServiceOrder);
	}

	@Override
	public int addMfoyouOrderLog(HuawuOrderLog mfoyouOrderLog) {
		return huawuOrderLogMapper.insertSelective(mfoyouOrderLog);
	}

	@Override
	public Boolean mdfServiceOrderByStateTime(Integer srcState, Integer targState, Date sDate, Date eDate,
			Integer opUserId) {
		HuawuServiceOrderExample example = new HuawuServiceOrderExample();
		HuawuServiceOrder mfoyouServiceOrder = new HuawuServiceOrder();
		mfoyouServiceOrder.setServiceOrderState(targState);
		Criteria criteria = example.or().andServiceOrderStateEqualTo(srcState);
		if (sDate != null) {
			criteria.andServiceOrderModifyTimeGreaterThanOrEqualTo(sDate);
		}
		if (eDate != null) {
			criteria.andServiceOrderModifyTimeLessThan(eDate);
		}

		int ret = huawuServiceOrderMapper.updateByExampleSelective(mfoyouServiceOrder, example);
		if (ret > 0) {
			HuawuOrderLog mfoyouOrderLog = new HuawuOrderLog();
			mfoyouOrderLog.setOrderLogUserId(opUserId);
			mfoyouOrderLog.setOrderLogState(targState);
			mfoyouOrderLog.setOrderLogTime(new Date());
			mfoyouOrderLog.setServiceOrderId(null);
			mfoyouOrderLog.setOrderLogRemark("批量状态变更");
			mfoyouOrderLog.setOrderType(OrderType.serviceOrder.getValue());
			addMfoyouOrderLog(mfoyouOrderLog);
		}
		return true;
	}

	@Override
	public List<HuawuServiceOrder> getNeedCompletServiceOrder() {
		Calendar calendar = Calendar.getInstance();
		calendar.add(Calendar.DATE, -1);
		calendar.set(Calendar.HOUR_OF_DAY, 16);
		calendar.set(Calendar.MINUTE, 0);
		calendar.set(Calendar.SECOND, 0);
		HuawuServiceOrderExample example = new HuawuServiceOrderExample();
		Criteria or = example.or();
		or.andServiceOrderCreateTimeLessThan(calendar.getTime());
		or.andServiceOrderStateBetween(39, 51);
		// or.andServiceOrderSourceEqualTo(1);
		return huawuServiceOrderMapper.selectByExample(example);
	}

	@Override
	public List<HuawuOrderLog> getOrderLog(int orderId, int orderType) {
		HuawuOrderLogExample example = new HuawuOrderLogExample();
		example.or().andServiceOrderIdEqualTo(orderId);
		return huawuOrderLogMapper.selectByExample(example);

	}

	@Override
	public Boolean revokeServiceOrder(Integer orderId, Integer userId, Integer payAmount, Integer orderState,
			Integer targetPayAmount, Integer targetState) {
		HuawuServiceOrderExample mfoyouServiceOrderExample = new HuawuServiceOrderExample();
		mfoyouServiceOrderExample.or().andServiceOrderIdEqualTo(orderId).andServiceOrderSendUserEqualTo(userId)
				.andServiceOrderPayAmountEqualTo(payAmount).andServiceOrderStateEqualTo(orderState);
		HuawuServiceOrder mfoyouServiceOrder = new HuawuServiceOrder();
		// 目前不设置为0
		// mfoyouServiceOrder.setServiceOrderPayAmount(targetPayAmount);
		mfoyouServiceOrder.setServiceOrderState(targetState);
		Boolean bRet = huawuServiceOrderMapper.updateByExampleSelective(mfoyouServiceOrder,
				mfoyouServiceOrderExample) == 1;
		HuawuOrderLog mfoyouOrderLog = new HuawuOrderLog();
		mfoyouOrderLog.setOrderLogUserId(userId);
		mfoyouOrderLog.setOrderLogState(targetState);
		mfoyouOrderLog.setOrderLogTime(new Date());
		mfoyouOrderLog.setServiceOrderId(orderId);
		mfoyouOrderLog.setOrderLogRemark("用户撤单");
		mfoyouOrderLog.setOrderType(OrderType.serviceOrder.getValue());
		addMfoyouOrderLog(mfoyouOrderLog);
		return bRet;
	}

	@Override
	public ArrayListObject<HuawuServiceOrder> getServiceOrderSquareList(HuawuServiceOrder mfoyouServiceOrder,
			Integer pageIndex, Integer pageSize, Date startDate, Date endDate, int userType, List<Integer> states,
			long poshash) {

		HuawuServiceOrderExample example = new HuawuServiceOrderExample();
		MybatisGenerator.setLimit(example, pageIndex, pageSize);
		Double dlon = mfoyouServiceOrder.getServiceUserLon();
		Double dlat = mfoyouServiceOrder.getServiceUserLat();
		Integer serviceOrderReceiveUser = mfoyouServiceOrder.getServiceOrderReceiveUser();
		mfoyouServiceOrder.setServiceUserLat(null);
		mfoyouServiceOrder.setServiceUserLon(null);
		mfoyouServiceOrder.setServiceOrderReceiveUser(null);
		// 如果是团队成员
		Integer agentId = mfoyouServiceOrder.getAgentId();
		if (agentId != null && agentId > 0) {
			// 团队
			HuawuServiceOrderExample.Criteria criteria = example.or();
			if (startDate != null) {
				criteria.andServiceOrderCreateTimeGreaterThanOrEqualTo(startDate);
			}
			if (endDate != null) {
				criteria.andServiceOrderCreateTimeLessThan(endDate);
			}
			if (states != null && states.size() > 0) {
				criteria.andServiceOrderStateIn(states);
			} else {
				criteria.andServiceOrderStateGreaterThanOrEqualTo(OrderState.emPaySucess.getValue());
				criteria.andServiceOrderStateLessThanOrEqualTo(OrderState.emSeekRuner.getValue());
			}
			MybatisGenerator.makeExample(mfoyouServiceOrder, criteria);
			// 没有代理区域的订单
			if (dlon != null && dlat != null) {
				// 散工
				mfoyouServiceOrder.setAgentId(0);
				criteria = example.or();
				if (startDate != null) {
					criteria.andServiceOrderCreateTimeGreaterThanOrEqualTo(startDate);
				}
				if (endDate != null) {
					criteria.andServiceOrderCreateTimeLessThan(endDate);
				}
				// criteria.andServiceOrderAllSeeTimeGreaterThan(new Date());
				criteria.andServiceUserLonBetween(dlon - 0.22, dlon + 0.22);
				criteria.andServiceUserLatBetween(dlat - 0.22, dlat + 0.22);

				if (states != null && states.size() > 0) {
					criteria.andServiceOrderStateIn(states);
				} else {
					criteria.andServiceOrderStateGreaterThanOrEqualTo(OrderState.emPaySucess.getValue());
					criteria.andServiceOrderStateLessThanOrEqualTo(OrderState.emSeekRuner.getValue());
				}
				MybatisGenerator.makeExample(mfoyouServiceOrder, criteria);
			}
		} else {
			return ArrayListObject.bliudArrayList(new ArrayList<HuawuServiceOrder>(), pageIndex, pageSize, 0);
		}
		example.setOrderByClause("service_order_state asc,service_order_id desc");
		int count = 0;
		if (poshash == 1) {
			// 新数量统计方法
			count = huawuServiceOrderMapper.countAll(dlon, dlat, agentId, serviceOrderReceiveUser);
		} else {
			count = huawuServiceOrderMapper.countByExample(example);
		}
		List<HuawuServiceOrder> list = huawuServiceOrderMapper.selectByExample(example);
		return ArrayListObject.bliudArrayList(list, pageIndex, pageSize, count);
	}

	@Override
	public ArrayListObject<HuawuServiceOrder> getAbnormalOrderList(HuawuServiceOrder mfoyouServiceOrder,
			Integer pageIndex, Integer pageSize, Date startDate, Date endDate, String type) {

		HuawuServiceOrderExample example = new HuawuServiceOrderExample();
		MybatisGenerator.setLimit(example, pageIndex, pageSize);
		Criteria criteria = example.or();
		if (startDate != null) {
			criteria.andServiceOrderCreateTimeGreaterThanOrEqualTo(startDate);
		}
		if (endDate != null) {
			criteria.andServiceOrderCreateTimeLessThan(endDate);
		}
		MybatisGenerator.makeExample(mfoyouServiceOrder, criteria);
		if (type != null && type.equals("1")) {
			long tm = System.currentTimeMillis() - 3 * 60 * 1000;
			criteria.andServiceOrderEffectTimeLessThan(new Date(tm))
					.andServiceOrderStateBetween(OrderState.emPaySucess.getValue(), OrderState.emSeekRuner.getValue());
		} else {
			long tm = System.currentTimeMillis() - 30 * 60 * 1000;
			criteria.andServiceOrderEffectTimeLessThan(new Date(tm))
					.andServiceOrderStateLessThan(OrderState.emServiceRunerFinsh.getValue())
					.andServiceOrderStateGreaterThanOrEqualTo(OrderState.emRunerAccept.getValue());
		}
		example.setOrderByClause(" service_order_id desc");
		int count = huawuServiceOrderMapper.countByExample(example);
		List<HuawuServiceOrder> list = huawuServiceOrderMapper.selectByExample(example);

		return ArrayListObject.bliudArrayList(list, pageIndex, pageSize, count);
	}

	@Override
	public int addServiceOrderV1(HuawuServiceOrder mfoyouServiceOrderV1) {

		mfoyouServiceOrderV1.setServiceOrderId(null);
		int ret = huawuServiceOrderMapper.insertSelective(mfoyouServiceOrderV1);
		HuawuOrderLog mfoyouOrderLog = new HuawuOrderLog();
		mfoyouOrderLog.setOrderLogUserId(mfoyouServiceOrderV1.getServiceOrderSendUser());
		mfoyouOrderLog.setOrderLogState(mfoyouServiceOrderV1.getServiceOrderState());
		mfoyouOrderLog.setOrderLogTime(new Date());
		mfoyouOrderLog.setServiceOrderId(mfoyouServiceOrderV1.getServiceOrderId());
		mfoyouOrderLog.setOrderLogRemark("添加商店订单");
		mfoyouOrderLog.setOrderType(OrderType.serviceOrder.getValue());
		addMfoyouOrderLog(mfoyouOrderLog);
		if (ret == 1) {
			ret = mfoyouServiceOrderV1.getServiceOrderId();
		}
		return ret;
	}

	@Override
	public List<MfoyouRegionCustom> getCustomRegionListByAgentId(Integer agentId) {
		MfoyouRegionCustomExample mfoyouRegionCustomExample = new MfoyouRegionCustomExample();
		mfoyouRegionCustomExample.or().andAgentIdEqualTo(agentId);
		return mfoyouRegionCustomMapper.selectByExample(mfoyouRegionCustomExample);
	}

	@Override
	public int addRegionCustom(MfoyouRegionCustom parseObject) {
		return mfoyouRegionCustomMapper.insertSelective(parseObject);
	}

	@Override
	public int deleteRegionCustom(Integer regoinId) {
		return mfoyouRegionCustomMapper.deleteByPrimaryKey(regoinId);
	}

	@Override
	public int updateRegionCustom(MfoyouRegionCustom parseObject) {
		return mfoyouRegionCustomMapper.updateByPrimaryKeySelective(parseObject);
	}
	@Override
	public List<MfoyouOrderStatistics> getCurrentDay(Integer storeId, int model) {
		List<MfoyouOrderStatistics> selectcurrent = mfoyouOrderStatisticsMapper.selectcurrent(storeId);
		MfoyouOrderStatistics byesterday = mfoyouOrderStatisticsMapper.selectTodaysCount(storeId, 2);
		byesterday.setIsIntoAccount(0);
		selectcurrent.add(byesterday);
		MfoyouOrderStatistics yesterday = mfoyouOrderStatisticsMapper.selectTodaysCount(storeId, 1);
		yesterday.setIsIntoAccount(0);
		selectcurrent.add(yesterday);
		if (model == 1) {
			MfoyouOrderStatistics today = mfoyouOrderStatisticsMapper.selectTodaysCount(storeId, 0);
			today.setIsIntoAccount(0);
			selectcurrent.add(today);
		}
		return selectcurrent;
	}

	@Override
	public MfoyouOrderStatistics getMonthCount(Integer storeId, Integer monthId) {
		return mfoyouOrderStatisticsMapper.selectSum(storeId, monthId);
	}

	@Override
	public MfoyouOrderStatistics getTodayCount(Integer storeid) {
		return mfoyouOrderStatisticsMapper.selectTodaysCount(storeid, 0);
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
	public List<MfoyouOrderStatistics> settlementQuery(Integer agentId, Integer daycount, int userType) {
		ArrayList<MfoyouOrderStatistics> statistics = new ArrayList<>();
		MfoyouOrderStatistics today = mfoyouOrderStatisticsMapper.getTodayByAgentId(agentId, 0, userType);
		today.setIsIntoAccount(0);
		MfoyouOrderStatistics yesterday = mfoyouOrderStatisticsMapper.getTodayByAgentId(agentId, 1, userType);
		yesterday.setIsIntoAccount(0);
		MfoyouOrderStatistics beforeyesterday = mfoyouOrderStatisticsMapper.getTodayByAgentId(agentId, 2, userType);
		beforeyesterday.setIsIntoAccount(0);
		statistics.add(today);
		statistics.add(yesterday);
		statistics.add(beforeyesterday);
		statistics.addAll(mfoyouOrderStatisticsMapper.selectByAgentId(agentId, daycount, userType));
		return statistics;
	}
}
