package org.mfoyou.agent.center.dao.inf;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.mfoyou.agent.common.dao.domain.HuawuThirdUser;
import org.mfoyou.agent.common.dao.domain.HuawuThirdUserExample;

public interface HuawuThirdUserMapper {
    int countByExample(HuawuThirdUserExample example);

    int deleteByExample(HuawuThirdUserExample example);

    int insert(HuawuThirdUser record);

    int insertSelective(HuawuThirdUser record);

    List<HuawuThirdUser> selectByExample(HuawuThirdUserExample example);

    int updateByExampleSelective(@Param("record") HuawuThirdUser record, @Param("example") HuawuThirdUserExample example);

    int updateByExample(@Param("record") HuawuThirdUser record, @Param("example") HuawuThirdUserExample example);
}