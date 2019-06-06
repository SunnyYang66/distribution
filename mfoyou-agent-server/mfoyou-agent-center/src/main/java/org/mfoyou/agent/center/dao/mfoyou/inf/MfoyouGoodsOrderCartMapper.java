package org.mfoyou.agent.center.dao.mfoyou.inf;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.mfoyou.agent.common.dao.mfoyou.domain.MfoyouGoodsOrderCart;
import org.mfoyou.agent.common.dao.mfoyou.domain.MfoyouGoodsOrderCartExample;

public interface MfoyouGoodsOrderCartMapper {
    int countByExample(MfoyouGoodsOrderCartExample example);

    int deleteByExample(MfoyouGoodsOrderCartExample example);

    int deleteByPrimaryKey(Integer cartItmeId);

    int insert(MfoyouGoodsOrderCart record);

    int insertSelective(MfoyouGoodsOrderCart record);

    List<MfoyouGoodsOrderCart> selectByExample(MfoyouGoodsOrderCartExample example);

    MfoyouGoodsOrderCart selectByPrimaryKey(Integer cartItmeId);

    int updateByExampleSelective(@Param("record") MfoyouGoodsOrderCart record, @Param("example") MfoyouGoodsOrderCartExample example);

    int updateByExample(@Param("record") MfoyouGoodsOrderCart record, @Param("example") MfoyouGoodsOrderCartExample example);

    int updateByPrimaryKeySelective(MfoyouGoodsOrderCart record);

    int updateByPrimaryKey(MfoyouGoodsOrderCart record);
}