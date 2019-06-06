package org.mfoyou.agent.common.inf;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.mfoyou.agent.common.dao.domain.AgentTest;
import org.mfoyou.agent.common.dao.domain.HuawuEvaluate;
import org.mfoyou.agent.common.dao.domain.HuawuOrderLog;
import org.mfoyou.agent.common.dao.domain.HuawuServiceOrder;
import org.mfoyou.agent.common.dao.domain.HuawuServicePrice;
import org.mfoyou.agent.common.dao.domain.MfoyouRegionCustom;
import org.mfoyou.agent.common.dao.mfoyou.domain.MfoyouOrderStatistics;
import org.mfoyou.agent.utils.common.ArrayListObject;

public interface IOrder {

	AgentTest getAgntTets(int id);

	HuawuServiceOrder addServiceOrder(HuawuServiceOrder huawuServiceOrder);

	HuawuServiceOrder getServiceOrderInfo(Integer orderId);

	Boolean updateServiceOrderState(HuawuServiceOrder oldOrder, HuawuServiceOrder targetOrder, Integer opUserId);

	ArrayListObject<HuawuServiceOrder> getServiceOrderList(HuawuServiceOrder mfoyouServiceOrder, Integer pageIndex,
			Integer pageSize, Date startDate, Date endDate, List<Integer> state, Integer orderBy);

	Map<Integer, Integer> getWorkerOrder(List<Integer> workerIds, List<Integer> listState, Date finshS, Date finshE);

	List<HuawuServiceOrder> getServiceOrderListbyId(List<Integer> listId, List<Integer> listState,
			List<Integer> workerIds);

	Integer getOrderCount(HuawuServiceOrder mfoyouServiceOrder, Date startDate, Date endDate, List<Integer> states);

	ArrayListObject<HuawuEvaluate> getEvaluate(HuawuEvaluate mfoyouEvaluate, Integer pageId, Integer pageSize,
			Date startDate, Date endDate, Integer minScore, Integer maxScore);

	Map<Integer, Integer> getEvaluateScoreCount(Integer agentId, Date startDate, Date endDate);

	Map<Integer, Integer> getRunerEvaluateScoreCount(Integer userId, Date startDate, Date endDate);

	HuawuServicePrice getConfigurePriceByAgentId(Integer agentId, boolean isAdd);

	Boolean mdfServiceOrder(HuawuServiceOrder mfoyouServiceOrder, Integer opUserId);

	int addMfoyouOrderLog(HuawuOrderLog mfoyouOrderLog);

	Boolean mdfServiceOrderByStateTime(Integer srcState, Integer targState, Date sDate, Date eDate, Integer opUserId);

	List<HuawuServiceOrder> getNeedCompletServiceOrder();

	List<HuawuOrderLog> getOrderLog(int orderId, int orderType);

	Boolean revokeServiceOrder(Integer orderId, Integer userId, Integer payAmount, Integer orderState,
			Integer targetPayAmount, Integer targetState);

	ArrayListObject<HuawuServiceOrder> getServiceOrderSquareList(HuawuServiceOrder mfoyouServiceOrder,
			Integer pageIndex, Integer pageSize, Date startDate, Date endDate, int usertype, List<Integer> states,
			long posHash);

	ArrayListObject<HuawuServiceOrder> getAbnormalOrderList(HuawuServiceOrder mfoyouServiceOrder, Integer pageIndex,
			Integer pageSize, Date startDate, Date endDate, String type);

	int addServiceOrderV1(HuawuServiceOrder mfoyouServiceOrderV1);

	List<MfoyouRegionCustom> getCustomRegionListByAgentId(Integer agentId);

	int addRegionCustom(MfoyouRegionCustom parseObject);

	int deleteRegionCustom(Integer regoinId);

	int updateRegionCustom(MfoyouRegionCustom parseObject);

	MfoyouOrderStatistics getMonthCount(Integer storeId, Integer monthId);

	List<MfoyouOrderStatistics> getCurrentDay(Integer storeId, int model);

	MfoyouOrderStatistics getTodayCount(Integer storeid);

	MfoyouOrderStatistics getAgentToday(Integer agentId, Integer daycount, int userType);

	List<MfoyouOrderStatistics> getAgentMoney(Integer agentId, Integer daynumber, int userType);

	List<MfoyouOrderStatistics> settlementQuery(Integer agentId, Integer daycount, int userType);


}
