package org.mfoyou.agent.common.inf;

import org.mfoyou.agent.common.dao.domain.HuawuAlipay;
import org.mfoyou.agent.common.dao.domain.HuawuXgClient;

public interface IThirdPartInfo {

	HuawuXgClient getXgClient(Integer agentId, Integer type);

	HuawuAlipay getAliPayByAgentId(Integer agentId);

	String getModelId(Integer agentId, Integer type);

}
