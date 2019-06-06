package org.mfoyou.agent.common.inf;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.mfoyou.agent.common.dao.mfoyou.domain.MfoyouGoodsInfo;
import org.mfoyou.agent.common.entity.GoodsInfo;
import org.mfoyou.agent.common.entity.MfoyouOrderStatic;
import org.mfoyou.agent.utils.common.ArrayListObject;

public interface IStatistics {

	String getPriceInfo(int agentId, int type);



	Map<String, Object> getRunerNoSettlement(Integer runerId);



	Map<String, Object> getAgentNoSettlement(Integer agentId);



	Map<String, Object> getOrderCountAll(Integer currentUserId, int type);



	GoodsInfo getGoodsInfo(Integer goodsid);



	ArrayListObject<GoodsInfo> listGoods(Integer pageSize, Integer pageId, MfoyouGoodsInfo info, Integer isStore);



	void dailyCount();



	Integer realseStore();



	List<Map<String, Object>> getWxinfo(Integer agentId);



	List<MfoyouOrderStatic> getServiceAgentMoney(Integer agenid, Integer daynumber, int userType);



	Map<String, Object> getTongjiV3(Integer storeid, Long startDate, Long endDate);



	Map<String, Map<String, Object>> getTongjiV3(Integer storeId, Date date);



	Map<String, Object> getTongji(Integer storeId);



	Map<String, Object> getTongjiV2(Integer storeId);

}
