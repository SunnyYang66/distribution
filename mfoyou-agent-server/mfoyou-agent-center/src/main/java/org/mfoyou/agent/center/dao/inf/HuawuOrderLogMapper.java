package org.mfoyou.agent.center.dao.inf;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.mfoyou.agent.common.dao.domain.HuawuOrderLog;
import org.mfoyou.agent.common.dao.domain.HuawuOrderLogExample;

public interface HuawuOrderLogMapper {
    int countByExample(HuawuOrderLogExample example);

    int deleteByExample(HuawuOrderLogExample example);

    int deleteByPrimaryKey(Integer orderLogId);

    int insert(HuawuOrderLog record);

    int insertSelective(HuawuOrderLog record);

    List<HuawuOrderLog> selectByExample(HuawuOrderLogExample example);

    HuawuOrderLog selectByPrimaryKey(Integer orderLogId);

    int updateByExampleSelective(@Param("record") HuawuOrderLog record, @Param("example") HuawuOrderLogExample example);

    int updateByExample(@Param("record") HuawuOrderLog record, @Param("example") HuawuOrderLogExample example);

    int updateByPrimaryKeySelective(HuawuOrderLog record);

    int updateByPrimaryKey(HuawuOrderLog record);
}