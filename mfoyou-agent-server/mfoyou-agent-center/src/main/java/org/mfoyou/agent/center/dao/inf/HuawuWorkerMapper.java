package org.mfoyou.agent.center.dao.inf;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.mfoyou.agent.common.dao.domain.HuawuWorker;
import org.mfoyou.agent.common.dao.domain.HuawuWorkerExample;
import org.mfoyou.agent.common.entity.HuawuAgentWokerInfo;
import org.mfoyou.agent.common.entity.HuawuAgentWorkerData;

public interface HuawuWorkerMapper {
    int countByExample(HuawuWorkerExample example);

    int deleteByExample(HuawuWorkerExample example);

    int deleteByPrimaryKey(Integer userId);

    int insert(HuawuWorker record);

    int insertSelective(HuawuWorker record);

    List<HuawuWorker> selectByExample(HuawuWorkerExample example);

    HuawuWorker selectByPrimaryKey(Integer userId);

    int updateByExampleSelective(@Param("record") HuawuWorker record, @Param("example") HuawuWorkerExample example);

    int updateByExample(@Param("record") HuawuWorker record, @Param("example") HuawuWorkerExample example);

    int updateByPrimaryKeySelective(HuawuWorker record);

    int updateByPrimaryKey(HuawuWorker record);
    
    List<HuawuAgentWokerInfo> getWokerInfoByagentInfo(@Param("workerInfo")HuawuWorker mfoyouWorker, @Param("sdate")Date sdate,
			@Param("edate")Date edate,@Param("pageStart")Integer pageStart,@Param("pagesize")Integer pagesize);
    
    List<HuawuAgentWorkerData> selectAgentByExample(HuawuWorkerExample mfoyouWorkerExample);

}