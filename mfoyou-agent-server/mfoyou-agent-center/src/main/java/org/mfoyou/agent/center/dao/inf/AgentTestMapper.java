package org.mfoyou.agent.center.dao.inf;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.mfoyou.agent.common.dao.domain.AgentTest;
import org.mfoyou.agent.common.dao.domain.AgentTestExample;

public interface AgentTestMapper {
    int countByExample(AgentTestExample example);

    int deleteByExample(AgentTestExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(AgentTest record);

    int insertSelective(AgentTest record);

    List<AgentTest> selectByExample(AgentTestExample example);

    AgentTest selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") AgentTest record, @Param("example") AgentTestExample example);

    int updateByExample(@Param("record") AgentTest record, @Param("example") AgentTestExample example);

    int updateByPrimaryKeySelective(AgentTest record);

    int updateByPrimaryKey(AgentTest record);
}