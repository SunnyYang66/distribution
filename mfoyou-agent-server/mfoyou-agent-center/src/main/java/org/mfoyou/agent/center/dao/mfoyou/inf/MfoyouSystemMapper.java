package org.mfoyou.agent.center.dao.mfoyou.inf;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import org.mfoyou.agent.common.dao.mfoyou.domain.MfoyouGoodsInfoExample;
import org.mfoyou.agent.common.entity.AdminMainCount;
import org.mfoyou.agent.common.entity.GoodsInfo;
import org.mfoyou.agent.common.entity.MfoyouOrderStatic;
import org.mfoyou.agent.common.entity.MfoyouServiceOrderStatic;
import org.mfoyou.agent.common.entity.SearchStoreInfo;

public interface MfoyouSystemMapper {
    Map<String, Object> select_item(String sql);

    List<Map<String, Object>> select_list(String sql);
    
    int update_item(String sql);
    
    List<Map<String, Object>> selectByExample(@Param("resultColumn") String resultColumn, @Param("tableName") String tableName, @Param("example") Object example);
    
    int countGoods(@Param("date") String date);
    
    Integer selectCount();
    
    Integer getDayid();
    
    List<GoodsInfo>  selectGoodsByExample(@Param("example") MfoyouGoodsInfoExample example);
    
    
    List<SearchStoreInfo>  selectStoreByExample(@Param("sKey") String sKey,@Param("lat")Double lat, @Param("lon")Double lon, @Param("sStart") Integer sStart,@Param("sLimit") Integer sLimit,@Param("agentId") Integer agentid);

	Integer selectSumGoods(@Param("storeId")Integer storeId);
	
	List<AdminMainCount> selectStatistics();

	Integer relaseStore();
	
	int modifyPower(@Param("userId")Integer userId,@Param("type")Integer type,@Param("power")Integer power);

	List<MfoyouOrderStatic> selectdate(@Param("userId")Integer userId,@Param("dayCount")Integer dayCount,@Param("type")Integer type);

	void unbindStation(@Param("stationId")Integer stationId);

	void updateMfoyoustoreInfo(@Param("userId")Integer userId, @Param("agentId")Integer agentId);
	
	List<MfoyouServiceOrderStatic> selectServiceStatistics(@Param("userId")int userId,@Param("type")int type,
			@Param("sDate")Date sDate,@Param("eDate")Date eDate);
}