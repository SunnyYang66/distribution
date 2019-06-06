package org.mfoyou.agent.center.dao.inf;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.mfoyou.agent.common.dao.domain.HuawuXgClient;
import org.mfoyou.agent.common.dao.domain.HuawuXgClientExample;

public interface HuawuXgClientMapper {
    int countByExample(HuawuXgClientExample example);

    int deleteByExample(HuawuXgClientExample example);

    int deleteByPrimaryKey(Integer xgPushId);

    int insert(HuawuXgClient record);

    int insertSelective(HuawuXgClient record);

    List<HuawuXgClient> selectByExample(HuawuXgClientExample example);

    HuawuXgClient selectByPrimaryKey(Integer xgPushId);

    int updateByExampleSelective(@Param("record") HuawuXgClient record, @Param("example") HuawuXgClientExample example);

    int updateByExample(@Param("record") HuawuXgClient record, @Param("example") HuawuXgClientExample example);

    int updateByPrimaryKeySelective(HuawuXgClient record);

    int updateByPrimaryKey(HuawuXgClient record);
}