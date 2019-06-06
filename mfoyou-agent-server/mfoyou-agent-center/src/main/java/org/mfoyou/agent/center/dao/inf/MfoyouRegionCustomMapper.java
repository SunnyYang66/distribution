package org.mfoyou.agent.center.dao.inf;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.mfoyou.agent.common.dao.domain.MfoyouRegionCustom;
import org.mfoyou.agent.common.dao.domain.MfoyouRegionCustomExample;

public interface MfoyouRegionCustomMapper {
    int countByExample(MfoyouRegionCustomExample example);

    int deleteByExample(MfoyouRegionCustomExample example);

    int deleteByPrimaryKey(Integer regionCustomId);

    int insert(MfoyouRegionCustom record);

    int insertSelective(MfoyouRegionCustom record);

    List<MfoyouRegionCustom> selectByExample(MfoyouRegionCustomExample example);

    MfoyouRegionCustom selectByPrimaryKey(Integer regionCustomId);

    int updateByExampleSelective(@Param("record") MfoyouRegionCustom record, @Param("example") MfoyouRegionCustomExample example);

    int updateByExample(@Param("record") MfoyouRegionCustom record, @Param("example") MfoyouRegionCustomExample example);

    int updateByPrimaryKeySelective(MfoyouRegionCustom record);

    int updateByPrimaryKey(MfoyouRegionCustom record);
}