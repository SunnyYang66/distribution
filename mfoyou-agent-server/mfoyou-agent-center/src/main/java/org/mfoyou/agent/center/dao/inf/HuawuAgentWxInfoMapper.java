package org.mfoyou.agent.center.dao.inf;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.mfoyou.agent.common.dao.domain.HuawuAgentWxInfo;
import org.mfoyou.agent.common.dao.domain.HuawuAgentWxInfoExample;

public interface HuawuAgentWxInfoMapper {
    int countByExample(HuawuAgentWxInfoExample example);

    int deleteByExample(HuawuAgentWxInfoExample example);

    int deleteByPrimaryKey(String xcxId);

    int insert(HuawuAgentWxInfo record);

    int insertSelective(HuawuAgentWxInfo record);

    List<HuawuAgentWxInfo> selectByExample(HuawuAgentWxInfoExample example);

    HuawuAgentWxInfo selectByPrimaryKey(String xcxId);

    int updateByExampleSelective(@Param("record") HuawuAgentWxInfo record, @Param("example") HuawuAgentWxInfoExample example);

    int updateByExample(@Param("record") HuawuAgentWxInfo record, @Param("example") HuawuAgentWxInfoExample example);

    int updateByPrimaryKeySelective(HuawuAgentWxInfo record);

    int updateByPrimaryKey(HuawuAgentWxInfo record);
}