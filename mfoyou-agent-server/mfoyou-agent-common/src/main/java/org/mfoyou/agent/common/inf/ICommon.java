package org.mfoyou.agent.common.inf;

import java.util.Date;
import java.util.List;

import org.mfoyou.agent.common.dao.domain.HuawuAddress;
import org.mfoyou.agent.common.dao.domain.HuawuAgentWxInfo;
import org.mfoyou.agent.common.dao.domain.HuawuFile;
import org.mfoyou.agent.common.dao.domain.HuawuServiceTag;
import org.mfoyou.agent.common.dao.domain.MfoyouThirdPartAudit;
import org.mfoyou.agent.common.dao.mfoyou.domain.MfoyouGdCity;
import org.mfoyou.agent.common.dao.mfoyou.domain.MfoyouUserStatistics;

public interface ICommon {

	int addMfoyouAddress(HuawuAddress mfoyouAddress);

	Boolean modifyMfoyouAddress(HuawuAddress mfoyouAddress);

	List<HuawuAddress> getUserMfoyouAddress(Integer userId, Integer addressId);

	HuawuAgentWxInfo getXcxInfoByAppid(String appid);

	HuawuAgentWxInfo getHuawuWxInfo(Integer agentId, Integer appid);

	int insertFile(HuawuFile fi);

	HuawuFile getFileInfo(int fileId);

	List<HuawuFile> getFileInfos(List<Integer> fileIds);

	List<HuawuServiceTag> getServiceTags(Integer tageType);

	List<MfoyouGdCity> cityListEx(String province);

	List<MfoyouGdCity> allCityList();

	List<MfoyouGdCity> searchCity(String key);

	List<MfoyouGdCity> countyList(Integer cityId);

	List<MfoyouGdCity> cityList(Integer provinceId);

	List<MfoyouGdCity> provinceList();

	List<MfoyouGdCity> getAll();

	List<MfoyouGdCity> countyListEx(String city);

	List<HuawuFile> getFiles(Integer currentUserId, Integer model);

	int getCountVisitUser(String start, String end, Integer storeid);

	int[] getUserStatiscs(Integer storeId, Date startTime, Date endTime);

	MfoyouUserStatistics getMfoyouUserStatic(MfoyouUserStatistics mfoyouUserStatistics);

	int insertUserStatistics(MfoyouUserStatistics mfoyouUserStatistics);

	List<MfoyouThirdPartAudit> getThirdPartAudit(MfoyouThirdPartAudit mfoyouThirdPartAudit);

	

}
