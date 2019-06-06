package org.mfoyou.agent.center.dao.mfoyou.inf;


import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.mfoyou.agent.common.dao.mfoyou.domain.MfoyouGoodsType;
import org.mfoyou.agent.common.dao.mfoyou.domain.MfoyouGoodsTypeExample;
import org.mfoyou.agent.common.dao.mfoyou.domain.MfoyouGoodsTypeV2;

public interface MfoyouGoodsTypeMapper {
    int countByExample(MfoyouGoodsTypeExample example);

    int deleteByExample(MfoyouGoodsTypeExample example);

    int deleteByPrimaryKey(Integer typeId);

    int insert(MfoyouGoodsType record);

    int insertSelective(MfoyouGoodsType record);

    List<MfoyouGoodsType> selectByExample(MfoyouGoodsTypeExample example);

    MfoyouGoodsType selectByPrimaryKey(Integer typeId);

    int updateByExampleSelective(@Param("record") MfoyouGoodsType record, @Param("example") MfoyouGoodsTypeExample example);

    int updateByExample(@Param("record") MfoyouGoodsType record, @Param("example") MfoyouGoodsTypeExample example);

    int updateByPrimaryKeySelective(MfoyouGoodsType record);

    int updateByPrimaryKey(MfoyouGoodsType record);
    
	List<MfoyouGoodsTypeV2> selectByStoreId(@Param("storeId")Integer storeId,@Param("model")Integer model);
}