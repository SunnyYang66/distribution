package org.mfoyou.agent.center.service;

import org.mfoyou.agent.center.dao.inf.*;
import org.mfoyou.agent.common.dao.domain.*;
import org.mfoyou.agent.common.dao.domain.HuawuWorkerExample.Criteria;
import org.mfoyou.agent.common.inf.IAccount;
import org.mfoyou.agent.utils.common.StringUtils;
import org.mfoyou.agent.utils.sql.MybatisGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.Calendar;
import java.util.List;

@Service
public class AccountService implements IAccount{
	@Autowired
	HuawuUserMapper huawuUserMapper;
	@Autowired
	HuawuAgentInfoMapper huawuAgentInfoMapper;
	@Autowired
	HuawuAgentWxInfoMapper huawuAgentWxInfoMapper;
	@Autowired
	HuawuThirdUserMapper huawuThirdUserMapper;
	@Autowired
	HuawuWorkerMapper huawuWorkerMapper;
	@Autowired
	HuawuIdcardInfoMapper huawuIdcardInfoMapper;
	@Override
	public HuawuUser login(String phone, String makePassWord,Integer agentId) {
		HuawuUserExample huawuUserExample = new HuawuUserExample();
		huawuUserExample.or().andUserPhoneEqualTo(phone).andUserPasswordEqualTo(makePassWord).andAgentIdEqualTo(agentId);
		List<HuawuUser> list = huawuUserMapper.selectByExample(huawuUserExample);
        if (list.size() == 1) {
            list.get(0).setUserPassword(null);
            return list.get(0);
        }
        return null;
	}
	
	@Override
	public HuawuAgentInfo getAgentInfoByAgentId(Integer userId) {
		return huawuAgentInfoMapper.selectByPrimaryKey(userId);
	}
	
	@Override
	public HuawuAgentWxInfo getAgentWxInfo(Integer agentId, Integer appId) {
		HuawuAgentWxInfoExample huawuAgentWxInfoExample = new HuawuAgentWxInfoExample();
		huawuAgentWxInfoExample.or().andAgentIdEqualTo(1).andXcxTypeEqualTo(appId);
		List<HuawuAgentWxInfo> list = huawuAgentWxInfoMapper.selectByExample(huawuAgentWxInfoExample);
		return list==null||list.size()!=1?null:list.get(0);
	}

	@Override
	public HuawuThirdUser getThirdUser(Integer agentId, Integer appId, String openId) {
		HuawuThirdUserExample huawuThirdUserExample = new HuawuThirdUserExample();
		huawuThirdUserExample.or().andAgentIdEqualTo(agentId).andAppTypeIdEqualTo(appId).andOpenIdEqualTo(openId);
		List<HuawuThirdUser> list = huawuThirdUserMapper.selectByExample(huawuThirdUserExample);
		return list==null||list.size()==0?null:list.get(0);
	}
	/**
	 * 根据userId找user
	 */
	@Override
	public HuawuUser getUserInfoByUserId(Integer userId) {
		HuawuUser selectByPrimaryKey = huawuUserMapper.selectByPrimaryKey(userId);
		selectByPrimaryKey.setUserPassword(null);
		HuawuIdcardInfo selectByPrimaryKey2 = huawuIdcardInfoMapper.selectByPrimaryKey(selectByPrimaryKey.getUserId());
		if(selectByPrimaryKey2!=null){
			selectByPrimaryKey.setUserName(selectByPrimaryKey2.getUserTrueName());
		}
		return selectByPrimaryKey;
	}
	/**
	 * 根据电话找user
	 */
	@Override
	public HuawuUser getUserInfoByPhone(String phone, Integer agentId) {
		HuawuUserExample huawuUserExample = new HuawuUserExample();
		huawuUserExample.or().andUserPhoneEqualTo(phone).andAgentIdEqualTo(agentId);
		List<HuawuUser> selectByExample = huawuUserMapper.selectByExample(huawuUserExample);
		if(selectByExample==null || selectByExample.size()==0){
			return null;
		}
		return selectByExample.get(0);
	}
	/**
	 * 根据电话找user
	 */
	@Override
	public HuawuUser getUserInfoByPhoneV2(String phone, Integer agentId) {
		HuawuUserExample huawuUserExample = new HuawuUserExample();
		huawuUserExample.or().andUserPhoneEqualTo(phone).andAgentIdIn(Arrays.asList(agentId,-2));
		huawuUserExample.setOrderByClause(" agent_id asc");
		List<HuawuUser> selectByExample = huawuUserMapper.selectByExample(huawuUserExample);
		if(selectByExample==null || selectByExample.size()==0){
			return null;
		}
		return selectByExample.get(0);
	}
	@Override
	public HuawuUser registUser(HuawuUser huawuUser) {
		if(huawuUser.getUserNickName()!=null)
		huawuUser.setUserNickName(StringUtils.filterEmoji(huawuUser.getUserNickName()));
		 huawuUserMapper.insertSelective(huawuUser);
		 if(huawuUser.getUserId()!=null){
			 return huawuUserMapper.selectByPrimaryKey(huawuUser.getUserId());
		 }
		 return null;
	}

	@Override
	public int modifyUser(HuawuUser huawuuserSave) {
		if(huawuuserSave.getUserNickName()!=null)
			huawuuserSave.setUserNickName(StringUtils.filterEmoji(huawuuserSave.getUserNickName()));
		return huawuUserMapper.updateByPrimaryKeySelective(huawuuserSave);
	}

	@Override
	public int addThirdUser(HuawuThirdUser huawuThirdUser) {
		return huawuThirdUserMapper.insertSelective(huawuThirdUser);
	}

	@Override
	public HuawuWorker getWorkerInfo(Integer userId) {
		return huawuWorkerMapper.selectByPrimaryKey(userId);
	}

	@Override
	public HuawuIdcardInfo getIdcardInfo(Integer userId) {
		return huawuIdcardInfoMapper.selectByPrimaryKey(userId);
	}

	@Override
	public int updateMfoyouIdcardInfo(HuawuIdcardInfo huawuIdcardInfo) {
		return huawuIdcardInfoMapper.updateByPrimaryKeySelective(huawuIdcardInfo);
	}

	@Override
	public int addIdcardInfo(HuawuIdcardInfo huawuIdcardInfo) {
		return huawuIdcardInfoMapper.insertSelective(huawuIdcardInfo);
	}

	@Override
	public List<HuawuUser> userListById(List<Integer> ids) {
		HuawuUserExample huawuUserExample = new HuawuUserExample();
		huawuUserExample.or().andUserIdIn(ids);
		return huawuUserMapper.selectByExample(huawuUserExample);
	}

	@Override
	public HuawuThirdUser getThirdByUserId(int userId, int appid) {
		HuawuThirdUserExample huawuThirdUserExample = new HuawuThirdUserExample();
		huawuThirdUserExample.or().andUserIdEqualTo(userId).andAppTypeIdEqualTo(appid);
		return MybatisGenerator.getOneValue(huawuThirdUserMapper.selectByExample(huawuThirdUserExample));
	}

	@Override
	public List<HuawuWorker> getAgentMfoyouWorkerList(List<Integer> users, Integer agentId) {
		HuawuWorkerExample huawuWorkerExample = new HuawuWorkerExample();
		Criteria andAgentIdEqualTo = huawuWorkerExample.or().andAgentIdEqualTo(agentId);
		if(users!=null){
			andAgentIdEqualTo.andUserIdIn(users);
		}
		return huawuWorkerMapper.selectByExample(huawuWorkerExample);
	}

	@Override
	public Integer getNewUserAmount(Integer agentId) {
		Calendar calendar = Calendar.getInstance();
		calendar.set(Calendar.HOUR_OF_DAY, 0);
		calendar.set(Calendar.MINUTE, 0);
		calendar.set(Calendar.SECOND, 0);
		HuawuUserExample huawuUserExample = new HuawuUserExample();
		huawuUserExample.or().andAgentIdEqualTo(agentId).andUserRegistTimeGreaterThanOrEqualTo(calendar.getTime());
		return  huawuUserMapper.countByExample(huawuUserExample);
	}

}
