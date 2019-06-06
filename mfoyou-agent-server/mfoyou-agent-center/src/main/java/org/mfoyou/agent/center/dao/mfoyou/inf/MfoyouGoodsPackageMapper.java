package org.mfoyou.agent.center.dao.mfoyou.inf;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.mfoyou.agent.common.dao.mfoyou.domain.MfoyouGoodsPackage;
import org.mfoyou.agent.common.dao.mfoyou.domain.MfoyouGoodsPackageExample;

public interface MfoyouGoodsPackageMapper {
    int countByExample(MfoyouGoodsPackageExample example);

    int deleteByExample(MfoyouGoodsPackageExample example);

    int deleteByPrimaryKey(Integer packageId);

    int insert(MfoyouGoodsPackage record);

    int insertSelective(MfoyouGoodsPackage record);

    List<MfoyouGoodsPackage> selectByExample(MfoyouGoodsPackageExample example);

    MfoyouGoodsPackage selectByPrimaryKey(Integer packageId);

    int updateByExampleSelective(@Param("record") MfoyouGoodsPackage record, @Param("example") MfoyouGoodsPackageExample example);

    int updateByExample(@Param("record") MfoyouGoodsPackage record, @Param("example") MfoyouGoodsPackageExample example);

    int updateByPrimaryKeySelective(MfoyouGoodsPackage record);

    int updateByPrimaryKey(MfoyouGoodsPackage record);
}