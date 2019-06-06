package org.mfoyou.agent.center.dao.mfoyou.inf;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.mfoyou.agent.common.dao.mfoyou.domain.MfoyouGoodsInfo;
import org.mfoyou.agent.common.dao.mfoyou.domain.MfoyouGoodsInfoExample;

public interface MfoyouGoodsInfoMapper {
    int countByExample(MfoyouGoodsInfoExample example);

    int deleteByExample(MfoyouGoodsInfoExample example);

    int deleteByPrimaryKey(Integer goodsId);

    int insert(MfoyouGoodsInfo record);

    int insertSelective(MfoyouGoodsInfo record);

    List<MfoyouGoodsInfo> selectByExampleWithBLOBs(MfoyouGoodsInfoExample example);

    List<MfoyouGoodsInfo> selectByExample(MfoyouGoodsInfoExample example);

    MfoyouGoodsInfo selectByPrimaryKey(Integer goodsId);

    int updateByExampleSelective(@Param("record") MfoyouGoodsInfo record, @Param("example") MfoyouGoodsInfoExample example);

    int updateByExampleWithBLOBs(@Param("record") MfoyouGoodsInfo record, @Param("example") MfoyouGoodsInfoExample example);

    int updateByExample(@Param("record") MfoyouGoodsInfo record, @Param("example") MfoyouGoodsInfoExample example);

    int updateByPrimaryKeySelective(MfoyouGoodsInfo record);

    int updateByPrimaryKeyWithBLOBs(MfoyouGoodsInfo record);

    int updateByPrimaryKey(MfoyouGoodsInfo record);
}