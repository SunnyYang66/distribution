package org.mfoyou.agent.common.inf;

import java.util.Date;
import java.util.List;

import org.mfoyou.agent.common.dao.domain.HuawuAgentInfo;
import org.mfoyou.agent.common.dao.domain.HuawuAgentStoreSetting;
import org.mfoyou.agent.common.dao.domain.HuawuServicePrice;
import org.mfoyou.agent.common.dao.domain.HuawuWorker;
import org.mfoyou.agent.common.dao.domain.MfoyouStationMaster;
import org.mfoyou.agent.common.entity.HuawuAgentWorkerData;
import org.mfoyou.agent.utils.common.ArrayListObject;

public interface IIdentity {

	HuawuWorker getMfoyouWorkerInfo(Integer userId, Integer agentId);

	List<HuawuWorker> getMfoyouWorkerList(List<Integer> arrUser);

	int modifyMfoyouWorkerInfo(HuawuWorker huawuWorker);

	HuawuAgentInfo getAgentInfo(Integer userId);

	int modifyMfoyouAgent(HuawuAgentInfo mfoyouAgent);

	ArrayListObject<?> getMfoyouWorkerList(HuawuWorker mfoyouWorker, Integer pageId, Integer pageSize, Date startDate,
			Date endDate);

	HuawuAgentStoreSetting getSpecialSettingV1(Integer agentId);

	HuawuServicePrice getServicePrice(Integer agentId);

	ArrayListObject<?> getMfoyouWorkerListV2(HuawuWorker mfoyouWorker, Integer pageid, Integer pageSize, Date startDate,
			Date endDate);

	ArrayListObject<HuawuAgentWorkerData> getMfoyouWorkerListV3(HuawuWorker mfoyouWorker, Integer pageId,
			Integer pageSize);

	int updatePriceV2ByagentId(HuawuServicePrice mfoyouServicePricev2);

	int addWorker(HuawuWorker workerInfo);

	int updateMfoyouAgentSetting(HuawuAgentStoreSetting mfoyouAgentStoreSetting);

	HuawuWorker getWorkerByPhone(String phone);

	HuawuWorker getMfoyouWorkerInfoV2(Integer userId, Integer agentId);

	List<HuawuWorker> getMfoyouWorkerListByAgentId(Integer agentId);

	int addStation(MfoyouStationMaster mfoyouStationMaster);

	MfoyouStationMaster getStationMasterByUserId(Integer userId);

	MfoyouStationMaster getMfoyouStationInfo(Integer stationId);

	ArrayListObject<?> getStationMaster(MfoyouStationMaster mfoyouStationMaster, Date sDate, Date eDate,
			Integer pageSize, Integer pageId);

	int updateByAgent(MfoyouStationMaster mfoyouStationMaster);

	int deleteByPrimartKey(MfoyouStationMaster mfoyouStationMaster);

	List<MfoyouStationMaster> getStationByAgentId(Integer agentId);

}
