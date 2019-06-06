package org.mfoyou.agent.center.dao.inf;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.mfoyou.agent.common.dao.domain.HuawuAgentStoreSetting;
import org.mfoyou.agent.common.dao.domain.HuawuAgentStoreSettingExample;

public interface HuawuAgentStoreSettingMapper {
    int countByExample(HuawuAgentStoreSettingExample example);

    int deleteByExample(HuawuAgentStoreSettingExample example);

    int deleteByPrimaryKey(Integer agentId);

    int insert(HuawuAgentStoreSetting record);

    int insertSelective(HuawuAgentStoreSetting record);

    List<HuawuAgentStoreSetting> selectByExample(HuawuAgentStoreSettingExample example);

    HuawuAgentStoreSetting selectByPrimaryKey(Integer agentId);

    int updateByExampleSelective(@Param("record") HuawuAgentStoreSetting record, @Param("example") HuawuAgentStoreSettingExample example);

    int updateByExample(@Param("record") HuawuAgentStoreSetting record, @Param("example") HuawuAgentStoreSettingExample example);

    int updateByPrimaryKeySelective(HuawuAgentStoreSetting record);

    int updateByPrimaryKey(HuawuAgentStoreSetting record);
}