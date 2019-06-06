package org.mfoyou.agent.center.dao.mfoyou.inf;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.mfoyou.agent.common.dao.mfoyou.domain.MfoyouOrderStatistics;
import org.mfoyou.agent.common.dao.mfoyou.domain.MfoyouOrderStatisticsExample;

public interface MfoyouOrderStatisticsMapper {
	
    int countByExample(MfoyouOrderStatisticsExample example);

    int deleteByExample(MfoyouOrderStatisticsExample example);

    int deleteByPrimaryKey(Integer countId);

    int insert(MfoyouOrderStatistics record);

    int insertSelective(MfoyouOrderStatistics record);

    List<MfoyouOrderStatistics> selectByExample(MfoyouOrderStatisticsExample example);

    MfoyouOrderStatistics selectByPrimaryKey(Integer countId);

    int updateByExampleSelective(@Param("record") MfoyouOrderStatistics record, @Param("example") MfoyouOrderStatisticsExample example);

    int updateByExample(@Param("record") MfoyouOrderStatistics record, @Param("example") MfoyouOrderStatisticsExample example);

    int updateByPrimaryKeySelective(MfoyouOrderStatistics record);

    int updateByPrimaryKey(MfoyouOrderStatistics record);
    
    List<MfoyouOrderStatistics> selectcurrent(@Param("storeId")Integer storeId);
    
    MfoyouOrderStatistics selectTodaysCount(@Param("storeid")Integer storeid,@Param("daycount") Integer daycount);
    
    MfoyouOrderStatistics selectSum(@Param("storeid")Integer storeid,@Param("time")Integer time);

	List<MfoyouOrderStatistics> selectByAgentId(@Param("agentId")Integer agentId,@Param("dayCount")Integer dayCount, @Param("userType")int userType);
	
	List<MfoyouOrderStatistics> selectByAgentIdWeek(@Param("agentId")Integer agentId,@Param("userType") int userType);
	
	MfoyouOrderStatistics getTodayByAgentId(@Param("agentId") Integer agentId,@Param("daycount") Integer daycount, @Param("userType")int userType);
	
	List<MfoyouOrderStatistics> adminorderStatics(@Param("sdate")Date sdate,@Param("edate")Date edate,@Param("start")Integer start,@Param("end") Integer end);

	List<MfoyouOrderStatistics> selectAgentdataByExample(@Param("agentId")Integer agentid,@Param("sdate") Date sdate, @Param("edate")Date edate);

	MfoyouOrderStatistics getAdminStatistic(@Param("daycount")Integer daycount);

	List<MfoyouOrderStatistics> selectAdmin();
}