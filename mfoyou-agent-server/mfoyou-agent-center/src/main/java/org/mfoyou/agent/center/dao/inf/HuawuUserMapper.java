package org.mfoyou.agent.center.dao.inf;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.mfoyou.agent.common.dao.domain.HuawuUser;
import org.mfoyou.agent.common.dao.domain.HuawuUserExample;

public interface HuawuUserMapper {
    int countByExample(HuawuUserExample example);

    int deleteByExample(HuawuUserExample example);

    int deleteByPrimaryKey(Integer userId);

    int insert(HuawuUser record);

    int insertSelective(HuawuUser record);

    List<HuawuUser> selectByExample(HuawuUserExample example);

    HuawuUser selectByPrimaryKey(Integer userId);

    int updateByExampleSelective(@Param("record") HuawuUser record, @Param("example") HuawuUserExample example);

    int updateByExample(@Param("record") HuawuUser record, @Param("example") HuawuUserExample example);

    int updateByPrimaryKeySelective(HuawuUser record);

    int updateByPrimaryKey(HuawuUser record);
}