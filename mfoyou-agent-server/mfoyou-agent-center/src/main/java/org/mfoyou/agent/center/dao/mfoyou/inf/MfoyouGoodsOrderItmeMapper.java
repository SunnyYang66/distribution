package org.mfoyou.agent.center.dao.mfoyou.inf;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.mfoyou.agent.common.dao.mfoyou.domain.MfoyouGoodsOrderItme;
import org.mfoyou.agent.common.dao.mfoyou.domain.MfoyouGoodsOrderItmeExample;

public interface MfoyouGoodsOrderItmeMapper {
    int countByExample(MfoyouGoodsOrderItmeExample example);

    int deleteByExample(MfoyouGoodsOrderItmeExample example);

    int deleteByPrimaryKey(Integer orderItmeId);

    int insert(MfoyouGoodsOrderItme record);

    int insertSelective(MfoyouGoodsOrderItme record);

    List<MfoyouGoodsOrderItme> selectByExample(MfoyouGoodsOrderItmeExample example);

    MfoyouGoodsOrderItme selectByPrimaryKey(Integer orderItmeId);

    int updateByExampleSelective(@Param("record") MfoyouGoodsOrderItme record, @Param("example") MfoyouGoodsOrderItmeExample example);

    int updateByExample(@Param("record") MfoyouGoodsOrderItme record, @Param("example") MfoyouGoodsOrderItmeExample example);

    int updateByPrimaryKeySelective(MfoyouGoodsOrderItme record);

    int updateByPrimaryKey(MfoyouGoodsOrderItme record);
}