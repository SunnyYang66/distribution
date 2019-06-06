package org.mfoyou.agent.center.dao.mfoyou.inf;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.mfoyou.agent.common.dao.mfoyou.domain.MfoyouAgentServicePricev2;
import org.mfoyou.agent.common.dao.mfoyou.domain.MfoyouAgentServicePricev2Example;

public interface MfoyouAgentServicePricev2Mapper {
    int countByExample(MfoyouAgentServicePricev2Example example);

    int deleteByExample(MfoyouAgentServicePricev2Example example);

    int deleteByPrimaryKey(Integer agentId);

    int insert(MfoyouAgentServicePricev2 record);

    int insertSelective(MfoyouAgentServicePricev2 record);

    List<MfoyouAgentServicePricev2> selectByExample(MfoyouAgentServicePricev2Example example);

    MfoyouAgentServicePricev2 selectByPrimaryKey(Integer agentId);

    int updateByExampleSelective(@Param("record") MfoyouAgentServicePricev2 record, @Param("example") MfoyouAgentServicePricev2Example example);

    int updateByExample(@Param("record") MfoyouAgentServicePricev2 record, @Param("example") MfoyouAgentServicePricev2Example example);

    int updateByPrimaryKeySelective(MfoyouAgentServicePricev2 record);

    int updateByPrimaryKey(MfoyouAgentServicePricev2 record);
}