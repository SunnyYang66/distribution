package org.mfoyou.agent.center.dao.inf;

import java.util.Date;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.mfoyou.agent.common.dao.domain.MfoyouStationMaster;
import org.mfoyou.agent.common.dao.domain.MfoyouStationMasterExample;
import org.mfoyou.agent.common.entity.StationMasterInAgent;

public interface MfoyouStationMasterMapper {
    int countByExample(MfoyouStationMasterExample example);

    int deleteByExample(MfoyouStationMasterExample example);

    int deleteByPrimaryKey(Integer stationId);

    int insert(MfoyouStationMaster record);

    int insertSelective(MfoyouStationMaster record);

    List<MfoyouStationMaster> selectByExample(MfoyouStationMasterExample example);

    MfoyouStationMaster selectByPrimaryKey(Integer stationId);

    int updateByExampleSelective(@Param("record") MfoyouStationMaster record, @Param("example") MfoyouStationMasterExample example);

    int updateByExample(@Param("record") MfoyouStationMaster record, @Param("example") MfoyouStationMasterExample example);

    int updateByPrimaryKeySelective(MfoyouStationMaster record);

    int updateByPrimaryKey(MfoyouStationMaster record);

	List<StationMasterInAgent> selectByAgent(@Param("agentId")Integer agentid,@Param("type")Integer type,
	@Param("sDate")Date sdate,@Param("eDate")Date eDate,@Param("pageStart")Integer pagestart,@Param("pageSize")Integer pagesize);
}