package org.mfoyou.agent.common.inf;

import java.util.List;

import org.mfoyou.agent.common.dao.domain.HuawuAgentInfo;
import org.mfoyou.agent.common.dao.domain.HuawuAgentWxInfo;
import org.mfoyou.agent.common.dao.domain.HuawuIdcardInfo;
import org.mfoyou.agent.common.dao.domain.HuawuThirdUser;
import org.mfoyou.agent.common.dao.domain.HuawuUser;
import org.mfoyou.agent.common.dao.domain.HuawuWorker;
import org.mfoyou.agent.common.dao.domain.MfoyouStationMaster;

public interface IAccount {

	HuawuUser login(String phone, String makePassWord, Integer agentId);

	HuawuAgentInfo getAgentInfoByAgentId(Integer userId);


	HuawuAgentWxInfo getAgentWxInfo(Integer agentId, Integer appId);

	HuawuThirdUser getThirdUser(Integer agentId, Integer appId, String openId);

	HuawuUser getUserInfoByUserId(Integer userId);

	HuawuUser getUserInfoByPhone(String phone, Integer agentId);

	HuawuUser registUser(HuawuUser huawuUser);

	int modifyUser(HuawuUser huawuuserSave);

	int addThirdUser(HuawuThirdUser huawuThirdUser);

	HuawuWorker getWorkerInfo(Integer userId);

	HuawuIdcardInfo getIdcardInfo(Integer userId);

	int updateMfoyouIdcardInfo(HuawuIdcardInfo huawuIdcardInfo);

	int addIdcardInfo(HuawuIdcardInfo huawuIdcardInfo);

	List<HuawuUser> userListById(List<Integer> ids);

	HuawuThirdUser getThirdByUserId(int userId, int parseInt);

	List<HuawuWorker> getAgentMfoyouWorkerList(List<Integer> users, Integer agentId);

	Integer getNewUserAmount(Integer agentId);

	HuawuUser getUserInfoByPhoneV2(String phone, Integer agentId);


}
