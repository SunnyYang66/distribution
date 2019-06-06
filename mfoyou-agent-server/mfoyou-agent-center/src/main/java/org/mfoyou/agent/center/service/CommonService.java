package org.mfoyou.agent.center.service;

import org.mfoyou.agent.center.dao.inf.*;
import org.mfoyou.agent.center.dao.mfoyou.inf.MfoyouGdCityMapper;
import org.mfoyou.agent.center.dao.mfoyou.inf.MfoyouUserStatisticsMapper;
import org.mfoyou.agent.common.dao.domain.*;
import org.mfoyou.agent.common.dao.domain.HuawuAddressExample.Criteria;
import org.mfoyou.agent.common.dao.mfoyou.domain.MfoyouGdCity;
import org.mfoyou.agent.common.dao.mfoyou.domain.MfoyouGdCityExample;
import org.mfoyou.agent.common.dao.mfoyou.domain.MfoyouUserStatistics;
import org.mfoyou.agent.common.dao.mfoyou.domain.MfoyouUserStatisticsExample;
import org.mfoyou.agent.common.inf.ICommon;
import org.mfoyou.agent.utils.sql.MybatisGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Service
public class CommonService implements ICommon {

	@Autowired
	HuawuAddressMapper huawuAddressMapper;
	@Autowired
	HuawuAgentWxInfoMapper huawuAgentWxInfoMapper;
	@Autowired
	HuawuFileMapper huawuFileMapper;
	@Autowired
	HuawuServiceTagMapper huawuServiceTagMapper;
	@Autowired
	MfoyouGdCityMapper mfoyouGdCityMapper;
	@Autowired
	HuawuSystemMapper huawuSystemMapper;
	@Autowired
	MfoyouUserStatisticsMapper mfoyouUserStatisticsMapper;
	@Autowired
	MfoyouThirdPartAuditMapper mfoyouThirdPartAuditMapper;
	@Override
	public int addMfoyouAddress(HuawuAddress mfoyouAddress) {
		Integer userId = mfoyouAddress.getUserId();
		if (userId == null)
			return -1;
		HuawuAddressExample mfoyouAddressExample = new HuawuAddressExample();
		mfoyouAddressExample.or().andAddressIsDelEqualTo(0).andUserIdEqualTo(userId);
		Integer count = huawuAddressMapper.countByExample(mfoyouAddressExample);
		if (count == 0) {
			mfoyouAddress.setAddressDefalut(1);
		}
		mfoyouAddress.setAddressIsDel(0);
		mfoyouAddress.setAddressId(null);
		int ret = huawuAddressMapper.insertSelective(mfoyouAddress);
		return ret;
	}

	@Override
	public Boolean modifyMfoyouAddress(HuawuAddress mfoyouAddress) {
		if (mfoyouAddress.getAddressId() == null) {
			return false;
		}
		if (mfoyouAddress.getUserId() == null) {
			return false;
		}
		HuawuAddressExample mfoyouAddressExample = new HuawuAddressExample();
		Criteria andUserIdEqualTo = mfoyouAddressExample.or().andAddressIsDelEqualTo(0)
				.andUserIdEqualTo(mfoyouAddress.getUserId());
		if (mfoyouAddress.getAddressDefalut() != null && mfoyouAddress.getAddressDefalut() == 1) {
			HuawuAddress temp = new HuawuAddress();
			temp.setAddressDefalut(0);
			huawuAddressMapper.updateByExampleSelective(temp, mfoyouAddressExample);
		}
		andUserIdEqualTo.andAddressIdEqualTo(mfoyouAddress.getAddressId());
		return huawuAddressMapper.updateByExampleSelective(mfoyouAddress, mfoyouAddressExample) == 1;
	}

	@Override
	public List<HuawuAddress> getUserMfoyouAddress(Integer userId, Integer addressId) {
		HuawuAddressExample mfoyouAddressExample = new HuawuAddressExample();
		HuawuAddressExample.Criteria criteria = mfoyouAddressExample.or().andAddressIsDelEqualTo(0);
		if (addressId != null) {
			criteria.andAddressIdEqualTo(addressId);
		}
		if (userId != null) {
			criteria.andUserIdEqualTo(userId);
		}
		criteria.andAddressIsDelNotEqualTo(1);
		mfoyouAddressExample.setOrderByClause(" address_defalut desc,address_id desc");
		return huawuAddressMapper.selectByExample(mfoyouAddressExample);
	}

	@Override
	public HuawuAgentWxInfo getHuawuWxInfo(Integer agentId, Integer appid) {
		HuawuAgentWxInfoExample huawuAgentWxInfoExample = new HuawuAgentWxInfoExample();
		huawuAgentWxInfoExample.or().andAgentIdEqualTo(1).andXcxTypeEqualTo(appid);
		return MybatisGenerator.getOneValue(huawuAgentWxInfoMapper.selectByExample(huawuAgentWxInfoExample));
	}

	@Override
	public HuawuAgentWxInfo getXcxInfoByAppid(String appid) {
		return huawuAgentWxInfoMapper.selectByPrimaryKey(appid);
	}

	@Override
	public int insertFile(HuawuFile fi) {
		return huawuFileMapper.insertSelective(fi);
	}

	@Override
	public HuawuFile getFileInfo(int fileId) {
		return huawuFileMapper.selectByPrimaryKey(fileId);
	}

	@Override
	public List<HuawuFile> getFileInfos(List<Integer> fileIds) {
		HuawuFileExample fileInfoExample = new HuawuFileExample();
		fileInfoExample.or().andFileIdIn(fileIds);
		List<HuawuFile> list = null;
		list = huawuFileMapper.selectByExample(fileInfoExample);
		return list;
	}

	@Override
	public List<HuawuServiceTag> getServiceTags(Integer tageType) {
		HuawuServiceTagExample mfoyouServiceTagExample = new HuawuServiceTagExample();
		mfoyouServiceTagExample.or().andServiceTagTypeEqualTo(tageType);
		return huawuServiceTagMapper.selectByExample(mfoyouServiceTagExample);
	}

	@Override
	public List<MfoyouGdCity> getAll() {
		return mfoyouGdCityMapper.selectByExample(new MfoyouGdCityExample());
	}

	@Override
	public List<MfoyouGdCity> provinceList() {
		MfoyouGdCityExample example = new MfoyouGdCityExample();
		example.or().andCityLeveEqualTo(1).andCityVisbleEqualTo(1);
		return mfoyouGdCityMapper.selectByExample(example);
	}

	@Override
	public List<MfoyouGdCity> cityList(Integer provinceId) {
		MfoyouGdCityExample example = new MfoyouGdCityExample();
		example.or().andCityLeveEqualTo(2).andCityParentAdcodeEqualTo(provinceId).andCityVisbleEqualTo(1);
		return mfoyouGdCityMapper.selectByExample(example);
	}

	@Override
	public List<MfoyouGdCity> countyList(Integer cityId) {
		MfoyouGdCityExample example = new MfoyouGdCityExample();
		example.or().andCityLeveEqualTo(3).andCityParentAdcodeEqualTo(cityId).andCityVisbleEqualTo(1);
		return mfoyouGdCityMapper.selectByExample(example);
	}

	@Override
	public List<MfoyouGdCity> searchCity(String key) {
		MfoyouGdCityExample example = new MfoyouGdCityExample();
		example.or().andCityNameLike("%" + key + "%").andCityVisbleEqualTo(1);
		example.setLimitStart(0);
		example.setLimitEnd(10);
		return mfoyouGdCityMapper.selectByExample(example);
	}

	@Override
	public List<MfoyouGdCity> allCityList() {
		MfoyouGdCityExample example = new MfoyouGdCityExample();
		example.or().andCityLeveEqualTo(2).andCityVisbleEqualTo(1);
		example.setOrderByClause(" city_PY");
		return mfoyouGdCityMapper.selectByExample(example);
	}

	@Override
	public List<MfoyouGdCity> cityListEx(String province) {
		MfoyouGdCityExample example = new MfoyouGdCityExample();
		example.or().andCityLeveEqualTo(2).andCityParentEqualTo(province).andCityVisbleEqualTo(1);
		return mfoyouGdCityMapper.selectByExample(example);
	}

	@Override
	public List<MfoyouGdCity> countyListEx(String city) {
		MfoyouGdCityExample example = new MfoyouGdCityExample();
		example.or().andCityLeveEqualTo(3).andCityParentEqualTo(city).andCityVisbleEqualTo(1);
		return mfoyouGdCityMapper.selectByExample(example);
	}

	@Override
	public List<HuawuFile> getFiles(Integer currentUserId, Integer model) {
		HuawuFileExample mfoyouFileExample = new HuawuFileExample();
		mfoyouFileExample.or().andUserIdEqualTo(currentUserId).andFileTypeLike(model);
		return huawuFileMapper.selectByExample(mfoyouFileExample);
	}

	@Override
	public int getCountVisitUser(String start, String end, Integer storeid) {
		String sql = "select ifnull(sum(user_count),0) totalUser from mfoyou_user_statistics where store_id = "
				+ storeid + " and day_id between " + start + " and " + end;
		return Integer.parseInt(huawuSystemMapper.select_item(sql).get("totalUser").toString());
	}

	@Override
	public int insertUserStatistics(MfoyouUserStatistics mfoyouUserStatistics) {
		return mfoyouUserStatisticsMapper.insertSelective(mfoyouUserStatistics);
	}

	@Override
	public MfoyouUserStatistics getMfoyouUserStatic(MfoyouUserStatistics mfoyouUserStatistics) {
		MfoyouUserStatisticsExample mfoyouUserStatisticsExample = new MfoyouUserStatisticsExample();
		MybatisGenerator.makeExample(mfoyouUserStatistics, mfoyouUserStatisticsExample.or());
		List<MfoyouUserStatistics> selectByExample = mfoyouUserStatisticsMapper
				.selectByExample(mfoyouUserStatisticsExample);
		return selectByExample == null || selectByExample.size() == 0 ? null : selectByExample.get(0);
	}

	@Override
	public int[] getUserStatiscs(Integer storeId, Date startTime, Date endTime) {
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMdd");
		String startTimeFormatResult = simpleDateFormat.format(startTime);
		String endTimeFormatResult = simpleDateFormat.format(endTime);
		String sql = "select ifnull(sum(visit_count),0) visitor,ifnull(sum(user_count),0) user from mfoyou_user_statistics where store_id"
				+ "= " + storeId + " and day_id between " + startTimeFormatResult + " and " + endTimeFormatResult;
		Map<String, Object> select_item = huawuSystemMapper.select_item(sql);
		return new int[] { Integer.parseInt(select_item.get("visitor").toString()),
				Integer.parseInt(select_item.get("user").toString()) };
	}
	@Override
	public List<MfoyouThirdPartAudit> getThirdPartAudit(MfoyouThirdPartAudit mfoyouThirdPartAudit) {
		MfoyouThirdPartAuditExample mfoyouThirdPartAuditExample = new MfoyouThirdPartAuditExample();
		org.mfoyou.agent.common.dao.domain.MfoyouThirdPartAuditExample.Criteria andAppidEqualTo = mfoyouThirdPartAuditExample.or();
		andAppidEqualTo.andAppidEqualTo(mfoyouThirdPartAudit.getAppid());
		MybatisGenerator.makeExample(mfoyouThirdPartAudit, andAppidEqualTo);
		return mfoyouThirdPartAuditMapper.selectByExample(mfoyouThirdPartAuditExample);
	}
}
