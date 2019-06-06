package org.mfoyou.agent.center.service;

import java.util.List;
import java.util.Map;

import org.mfoyou.agent.center.dao.inf.HuawuAlipayMapper;
import org.mfoyou.agent.center.dao.inf.HuawuSystemMapper;
import org.mfoyou.agent.center.dao.inf.HuawuXgClientMapper;
import org.mfoyou.agent.common.dao.domain.HuawuAlipay;
import org.mfoyou.agent.common.dao.domain.HuawuXgClient;
import org.mfoyou.agent.common.dao.domain.HuawuXgClientExample;
import org.mfoyou.agent.common.inf.IThirdPartInfo;
import org.mfoyou.agent.utils.sql.MybatisGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ThirdPartInfoService implements IThirdPartInfo{
	@Autowired
	HuawuXgClientMapper huawuXgClientMapper;
	@Autowired
	HuawuAlipayMapper huawuAlipayMapper;
	@Autowired
	HuawuSystemMapper huawuSystemMapper;
	@Override
	public HuawuXgClient getXgClient(Integer agentId, Integer type) {
		HuawuXgClientExample huawuXgClientExample = new HuawuXgClientExample();
		huawuXgClientExample.or().andAgentIdEqualTo(agentId).andTypeIdEqualTo(type);
		List<HuawuXgClient> list = huawuXgClientMapper.selectByExample(huawuXgClientExample);
		return MybatisGenerator.getOneValue(list);
	}
	@Override
	public HuawuAlipay getAliPayByAgentId(Integer agentId) {
		return huawuAlipayMapper.selectByPrimaryKey(agentId);
	}
	@Override
	public String getModelId(Integer agentId, Integer type) {
		String sql = "select model_id from huawu_wx_push_model where agent_id = "+agentId+" and model_type = "+type;
		Map<String, Object> select_item = huawuSystemMapper.select_item(sql);
		return select_item==null?null:select_item.get("model_id").toString();
	}

}
