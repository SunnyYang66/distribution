package org.mfoyou.agent.center.dao.mfoyou.inf;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.mfoyou.agent.common.dao.mfoyou.domain.MfoyouGoodsSearch;
import org.mfoyou.agent.common.dao.mfoyou.domain.MfoyouGoodsSearchExample;

public interface MfoyouGoodsSearchMapper {
    int countByExample(MfoyouGoodsSearchExample example);

    int deleteByExample(MfoyouGoodsSearchExample example);

    int deleteByPrimaryKey(Integer searchId);

    int insert(MfoyouGoodsSearch record);

    int insertSelective(MfoyouGoodsSearch record);

    List<MfoyouGoodsSearch> selectByExample(MfoyouGoodsSearchExample example);

    MfoyouGoodsSearch selectByPrimaryKey(Integer searchId);

    int updateByExampleSelective(@Param("record") MfoyouGoodsSearch record, @Param("example") MfoyouGoodsSearchExample example);

    int updateByExample(@Param("record") MfoyouGoodsSearch record, @Param("example") MfoyouGoodsSearchExample example);

    int updateByPrimaryKeySelective(MfoyouGoodsSearch record);

    int updateByPrimaryKey(MfoyouGoodsSearch record);
}