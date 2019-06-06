package org.mfoyou.agent.center.dao.mfoyou.inf;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.mfoyou.agent.common.dao.mfoyou.domain.MfoyouAgentTypeInfo;
import org.mfoyou.agent.common.dao.mfoyou.domain.MfoyouAgentTypeInfoExample;

public interface MfoyouAgentTypeInfoMapper {
    int countByExample(MfoyouAgentTypeInfoExample example);

    int deleteByExample(MfoyouAgentTypeInfoExample example);

    int deleteByPrimaryKey(Integer storeAgentId);

    int insert(MfoyouAgentTypeInfo record);

    int insertSelective(MfoyouAgentTypeInfo record);

    List<MfoyouAgentTypeInfo> selectByExample(MfoyouAgentTypeInfoExample example);

    MfoyouAgentTypeInfo selectByPrimaryKey(Integer storeAgentId);

    int updateByExampleSelective(@Param("record") MfoyouAgentTypeInfo record, @Param("example") MfoyouAgentTypeInfoExample example);

    int updateByExample(@Param("record") MfoyouAgentTypeInfo record, @Param("example") MfoyouAgentTypeInfoExample example);

    int updateByPrimaryKeySelective(MfoyouAgentTypeInfo record);

    int updateByPrimaryKey(MfoyouAgentTypeInfo record);
}