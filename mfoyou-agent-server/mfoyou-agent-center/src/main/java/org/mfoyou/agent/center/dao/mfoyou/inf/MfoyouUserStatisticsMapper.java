package org.mfoyou.agent.center.dao.mfoyou.inf;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.mfoyou.agent.common.dao.mfoyou.domain.MfoyouUserStatistics;
import org.mfoyou.agent.common.dao.mfoyou.domain.MfoyouUserStatisticsExample;

public interface MfoyouUserStatisticsMapper {
    int countByExample(MfoyouUserStatisticsExample example);

    int deleteByExample(MfoyouUserStatisticsExample example);

    int deleteByPrimaryKey(Integer statistisId);

    int insert(MfoyouUserStatistics record);

    int insertSelective(MfoyouUserStatistics record);

    List<MfoyouUserStatistics> selectByExample(MfoyouUserStatisticsExample example);

    MfoyouUserStatistics selectByPrimaryKey(Integer statistisId);

    int updateByExampleSelective(@Param("record") MfoyouUserStatistics record, @Param("example") MfoyouUserStatisticsExample example);

    int updateByExample(@Param("record") MfoyouUserStatistics record, @Param("example") MfoyouUserStatisticsExample example);

    int updateByPrimaryKeySelective(MfoyouUserStatistics record);

    int updateByPrimaryKey(MfoyouUserStatistics record);
}