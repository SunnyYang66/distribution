package org.mfoyou.agent.center.dao.inf;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.mfoyou.agent.common.dao.domain.HuawuAgentInfo;
import org.mfoyou.agent.common.dao.domain.HuawuAgentInfoExample;

public interface HuawuAgentInfoMapper {
    int countByExample(HuawuAgentInfoExample example);

    int deleteByExample(HuawuAgentInfoExample example);

    int deleteByPrimaryKey(Integer agentId);

    int insert(HuawuAgentInfo record);

    int insertSelective(HuawuAgentInfo record);

    List<HuawuAgentInfo> selectByExample(HuawuAgentInfoExample example);

    HuawuAgentInfo selectByPrimaryKey(Integer agentId);

    int updateByExampleSelective(@Param("record") HuawuAgentInfo record, @Param("example") HuawuAgentInfoExample example);

    int updateByExample(@Param("record") HuawuAgentInfo record, @Param("example") HuawuAgentInfoExample example);

    int updateByPrimaryKeySelective(HuawuAgentInfo record);

    int updateByPrimaryKey(HuawuAgentInfo record);
}