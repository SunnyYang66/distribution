package org.mfoyou.agent.center.dao.mfoyou.inf;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.mfoyou.agent.common.dao.mfoyou.domain.MfoyouGdCity;
import org.mfoyou.agent.common.dao.mfoyou.domain.MfoyouGdCityExample;

public interface MfoyouGdCityMapper {
    int countByExample(MfoyouGdCityExample example);

    int deleteByExample(MfoyouGdCityExample example);

    int deleteByPrimaryKey(Integer cityAdcode);

    int insert(MfoyouGdCity record);

    int insertSelective(MfoyouGdCity record);

    List<MfoyouGdCity> selectByExample(MfoyouGdCityExample example);

    MfoyouGdCity selectByPrimaryKey(Integer cityAdcode);

    int updateByExampleSelective(@Param("record") MfoyouGdCity record, @Param("example") MfoyouGdCityExample example);

    int updateByExample(@Param("record") MfoyouGdCity record, @Param("example") MfoyouGdCityExample example);

    int updateByPrimaryKeySelective(MfoyouGdCity record);

    int updateByPrimaryKey(MfoyouGdCity record);
}