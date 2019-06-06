package org.mfoyou.agent.center.dao.inf;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.mfoyou.agent.common.dao.domain.HuawuWallet;
import org.mfoyou.agent.common.dao.domain.HuawuWalletExample;

public interface HuawuWalletMapper {
    int countByExample(HuawuWalletExample example);

    int deleteByExample(HuawuWalletExample example);

    int deleteByPrimaryKey(Integer userId);

    int insert(HuawuWallet record);

    int insertSelective(HuawuWallet record);

    List<HuawuWallet> selectByExample(HuawuWalletExample example);

    HuawuWallet selectByPrimaryKey(Integer userId);

    int updateByExampleSelective(@Param("record") HuawuWallet record, @Param("example") HuawuWalletExample example);

    int updateByExample(@Param("record") HuawuWallet record, @Param("example") HuawuWalletExample example);

    int updateByPrimaryKeySelective(HuawuWallet record);

    int updateByPrimaryKey(HuawuWallet record);
}