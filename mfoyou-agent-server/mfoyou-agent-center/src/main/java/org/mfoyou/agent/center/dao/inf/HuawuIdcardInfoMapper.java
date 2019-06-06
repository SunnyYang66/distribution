package org.mfoyou.agent.center.dao.inf;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.mfoyou.agent.common.dao.domain.HuawuIdcardInfo;
import org.mfoyou.agent.common.dao.domain.HuawuIdcardInfoExample;

public interface HuawuIdcardInfoMapper {
    int countByExample(HuawuIdcardInfoExample example);

    int deleteByExample(HuawuIdcardInfoExample example);

    int deleteByPrimaryKey(Integer userId);

    int insert(HuawuIdcardInfo record);

    int insertSelective(HuawuIdcardInfo record);

    List<HuawuIdcardInfo> selectByExample(HuawuIdcardInfoExample example);

    HuawuIdcardInfo selectByPrimaryKey(Integer userId);

    int updateByExampleSelective(@Param("record") HuawuIdcardInfo record, @Param("example") HuawuIdcardInfoExample example);

    int updateByExample(@Param("record") HuawuIdcardInfo record, @Param("example") HuawuIdcardInfoExample example);

    int updateByPrimaryKeySelective(HuawuIdcardInfo record);

    int updateByPrimaryKey(HuawuIdcardInfo record);
}