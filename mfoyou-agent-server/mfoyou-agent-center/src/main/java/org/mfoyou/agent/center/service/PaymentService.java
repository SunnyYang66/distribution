package org.mfoyou.agent.center.service;

import com.alibaba.fastjson.JSON;
import org.mfoyou.agent.center.dao.inf.*;
import org.mfoyou.agent.center.dao.mfoyou.inf.MfoyouSystemMapper;
import org.mfoyou.agent.common.dao.domain.*;
import org.mfoyou.agent.common.dao.domain.HuawuPayExample.Criteria;
import org.mfoyou.agent.common.entity.MfoyouWorkStatistics;
import org.mfoyou.agent.common.entity.enums.CommonState;
import org.mfoyou.agent.common.entity.enums.MfoyouUserType;
import org.mfoyou.agent.common.inf.IPayment;
import org.mfoyou.agent.utils.common.ArrayListObject;
import org.mfoyou.agent.utils.common.DateUtils;
import org.mfoyou.agent.utils.common.Logger;
import org.mfoyou.agent.utils.sql.MybatisGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Service
public class PaymentService implements IPayment {

    @Autowired
    HuawuSystemMapper HuawuSystemMapper;
    @Autowired
    HuawuPayMapper huawuPayMapper;
    @Autowired
    HuawuStreamMapper huawuStreamMapper;
    @Autowired
    HuawuWalletLogMapper huawuWalletLogMapper;
    @Autowired
    HuawuWalletMapper huawuWalletMapper;
    @Autowired
    HuawuExtractMapper huawuExtractMapper;
    @Autowired
    MfoyouSystemMapper mfoyouSystemMapper;
    @Autowired
    HuawuUserMapper huawuUserMapper;
    Logger logger = Logger.getLogger(PaymentService.class);

    @Override
    public MfoyouWorkStatistics getUserWallet(Integer userId, Date sDate, Date eDate, Integer countType,
                                              Integer userType) {
        String sql = "select user_id as userId,sum(wallet_log_amount) as orderAoument , count( DISTINCT wallet_log_order_id) as orderCount  from huawu_wallet_log where user_id="
                + userId;
        if (sDate != null) {
            sql += " and wallet_log_time >='" + DateUtils.datetimeFormat.format(sDate) + "'";
        }
        if (eDate != null) {
            sql += " and wallet_log_time <'" + DateUtils.datetimeFormat.format(eDate) + "'";
        }
        sql += " and wallet_log_result = 1";
        if (countType != null && countType == 1) {
            sql += " and wallet_log_direction = 1";
        }
        if (userType != null) {
            sql += " and user_role_type = " + userType;
        }
        Map<String, Object> ret = HuawuSystemMapper.select_item(sql);
        MfoyouWorkStatistics mfoyouWorkStatistics = JSON.parseObject(JSON.toJSONString(ret),
                MfoyouWorkStatistics.class);
        if (mfoyouWorkStatistics.getOrderAoument() == null) {
            mfoyouWorkStatistics.setOrderAoument(0);
        }
        return mfoyouWorkStatistics;
    }

    @Override
    public int addMfoyouPay(HuawuPay huawuPay) {
        return huawuPayMapper.insertSelective(huawuPay);
    }

    @Override
    public HuawuPay getMfoyouPayByNumber(String orderNumber) {
        HuawuPayExample huawuPayExample = new HuawuPayExample();
        huawuPayExample.or().andPayNumberEqualTo(orderNumber);
        return MybatisGenerator.getOneValue(huawuPayMapper.selectByExample(huawuPayExample));
    }

    @Override
    public int modifyMfoyouPay(HuawuPay mfoyouPaySave) {
        return huawuPayMapper.updateByPrimaryKeySelective(mfoyouPaySave);
    }

    @Override
    public List<MfoyouWorkStatistics> getUsersWorkeWallet(List<Integer> userIds, Date sDate, Date eDate) {
        String sql = "select user_id as userId,sum(wallet_log_amount) as orderAoument , count(DISTINCT wallet_log_order_id) as orderCount  from huawu_wallet_log where  wallet_log_type != 98 and user_id in"
                + MybatisGenerator.makeIn(userIds);
        if (sDate != null) {
            sql += " and wallet_log_time >='" + DateUtils.datetimeFormat.format(sDate) + "'";
        }
        if (eDate != null) {
            sql += " and wallet_log_time <'" + DateUtils.datetimeFormat.format(eDate) + "'";
        }
        sql += " and wallet_log_op_item in('wallet_extract_amount','wallet_runer_amount','wallet_agent_amount') and wallet_log_direction = 1";
        sql += " group by user_id";

        List<Map<String, Object>> selectList = HuawuSystemMapper.select_list(sql);
        List<MfoyouWorkStatistics> retList = JSON.parseArray(JSON.toJSONString(selectList), MfoyouWorkStatistics.class);
        return retList;
    }

    @Override
    public Boolean addStream(Integer userId, Integer amount, Integer direction, Integer orderId, Integer orderType,
                             Integer sourceType, Integer targetType, String remark, Integer userType) {
        HuawuStream gxnnStream = new HuawuStream();
        gxnnStream.setStreamAmount(amount);
        gxnnStream.setStreamDirection(direction);
        gxnnStream.setStreamOrderId(orderId);
        gxnnStream.setStreamOrderType(orderType);
        gxnnStream.setStreamSource(sourceType);
        gxnnStream.setStreamTarget(targetType);
        gxnnStream.setStreamRemark(remark);
        gxnnStream.setStreamTime(new Date());
        gxnnStream.setStreamUserId(userId);
        gxnnStream.setStreamUserType(userType);
        return addStream(gxnnStream);
    }

    @Override
    public Boolean addStream(HuawuStream gxnnStream) {
        huawuStreamMapper.insertSelective(gxnnStream);
        return true;
    }

    @Override
    public Boolean addPayWalletLog(String payType, Integer direction, Integer userId, Integer payAmount,
                                   String orderNumber, Integer orderType, Integer agentId, Integer userRole) {
        HuawuWalletLog mfoyouWalletLog = new HuawuWalletLog();
        mfoyouWalletLog.setUserId(userId);
        mfoyouWalletLog.setWalletLogAmount(payAmount);
        mfoyouWalletLog.setWalletLogDirection(-1);
        mfoyouWalletLog.setWalletLogOpItem(payType);
        mfoyouWalletLog.setWalletLogResult(1);
        mfoyouWalletLog.setWalletLogOrderId(orderNumber);
        mfoyouWalletLog.setWalletLogRemark("");
        mfoyouWalletLog.setWalletLogAgentId(agentId);
        mfoyouWalletLog.setWalletLogType(orderType);
        mfoyouWalletLog.setUserRoleType(userRole);
        huawuWalletLogMapper.insertSelective(mfoyouWalletLog);
        return true;
    }

    @Override
    public HuawuWallet getUserMfoyouWallet(Integer userId) {
        HuawuWallet mfoyouWallet = huawuWalletMapper.selectByPrimaryKey(userId);
        if (mfoyouWallet == null) {
            mfoyouWallet = new HuawuWallet();
            mfoyouWallet.setUserId(userId);
            mfoyouWallet.setWalletUseAmount(0);
            mfoyouWallet.setWalletFreezeAmount(0);
            mfoyouWallet.setWalletExtractAmount(0);
            huawuWalletMapper.insertSelective(mfoyouWallet);
            mfoyouWallet = huawuWalletMapper.selectByPrimaryKey(userId);
        }
        return mfoyouWallet;
    }

    @Override
    public Boolean payAddRunerWallet(Integer userId, Integer checkAmount, Integer payAmount, int orderType,
                                     String orderNumber, Integer agentId) {
        HuawuWalletExample example = new HuawuWalletExample();
        example.or().andUserIdEqualTo(userId).andWalletRunerAmountEqualTo(checkAmount);
        HuawuWallet record = new HuawuWallet();
        record.setWalletRunerAmount(checkAmount + payAmount);
        Boolean bSucess = huawuWalletMapper.updateByExampleSelective(record, example) == 1;
        HuawuWalletLog mfoyouWalletLog = new HuawuWalletLog();
        mfoyouWalletLog.setUserId(userId);
        mfoyouWalletLog.setWalletLogAmount(payAmount);
        mfoyouWalletLog.setWalletLogDirection(payAmount > 0 ? 1 : -1);
        mfoyouWalletLog.setWalletLogNewValue(record.getWalletRunerAmount());
        mfoyouWalletLog.setWalletLogOldValue(checkAmount);
        mfoyouWalletLog.setWalletLogOpItem("wallet_runer_amount");
        mfoyouWalletLog.setWalletLogResult(bSucess ? 1 : -1);
        mfoyouWalletLog.setWalletLogOrderId(orderNumber);
        mfoyouWalletLog.setWalletLogRemark("");
        mfoyouWalletLog.setWalletLogAgentId(agentId);
        mfoyouWalletLog.setWalletLogType(orderType);
        mfoyouWalletLog.setUserRoleType(MfoyouUserType.runer.getValue());
        huawuWalletLogMapper.insertSelective(mfoyouWalletLog);
        logger.info("finsh payAddRunerWallet: payNumber=" + orderNumber);
        return bSucess;
    }

    @Override
    public Boolean payAddAgentWallet(Integer userId, Integer checkAmount, Integer payAmount, int orderType,
                                     String orderNumber, Integer agentId, Integer type) {
        HuawuWalletExample example = new HuawuWalletExample();
        example.or().andUserIdEqualTo(userId).andWalletAgentAmountEqualTo(checkAmount);
        HuawuWallet record = new HuawuWallet();
        record.setWalletAgentAmount(checkAmount + payAmount);
        Boolean bSucess = huawuWalletMapper.updateByExampleSelective(record, example) == 1;
        HuawuWalletLog mfoyouWalletLog = new HuawuWalletLog();
        mfoyouWalletLog.setUserId(userId);
        mfoyouWalletLog.setWalletLogAmount(payAmount);
        mfoyouWalletLog.setWalletLogDirection(payAmount > 0 ? 1 : -1);
        mfoyouWalletLog.setWalletLogNewValue(record.getWalletAgentAmount());
        mfoyouWalletLog.setWalletLogOldValue(checkAmount);
        mfoyouWalletLog.setWalletLogOpItem("wallet_agent_amount");
        mfoyouWalletLog.setWalletLogResult(bSucess ? 1 : -1);
        mfoyouWalletLog.setWalletLogOrderId(orderNumber);
        mfoyouWalletLog.setWalletLogRemark("");
        mfoyouWalletLog.setWalletLogAgentId(agentId);
        mfoyouWalletLog.setWalletLogType(orderType);
        mfoyouWalletLog.setUserRoleType(type);
        huawuWalletLogMapper.insertSelective(mfoyouWalletLog);
        logger.info("finsh payAddAgentWallet: payNumber=" + orderNumber);
        return bSucess;
    }

    @Override
    public ArrayListObject<HuawuPay> getServicePayList(HuawuPay mfoyouServiceOrder, Integer pageIndex,
                                                       Integer pageSize, Date startDate, Date endDate) {
        HuawuPayExample example = new HuawuPayExample();
        MybatisGenerator.setLimit(example, pageIndex, pageSize);
        Criteria criteria = example.or();
        if (startDate != null) {
            criteria.andPayCreateTimeGreaterThanOrEqualTo(startDate);
        }
        if (endDate != null) {
            criteria.andPayCreateTimeLessThan(endDate);
        }
        MybatisGenerator.makeExample(mfoyouServiceOrder, criteria);
        int count = huawuPayMapper.countByExample(example);
        List<HuawuPay> list = huawuPayMapper.selectByExample(example);

        return ArrayListObject.bliudArrayList(list, pageIndex, pageSize, count);
    }

    @Override
    public ArrayListObject<HuawuExtract> getExtractList(Integer type, HuawuExtract mfoyouServiceOrder,
                                                        Integer pageId, Integer pageSize, Date startDate, Date endDate) {
        HuawuExtractExample example = new HuawuExtractExample();
        MybatisGenerator.setLimit(example, pageId, pageSize);
        org.mfoyou.agent.common.dao.domain.HuawuExtractExample.Criteria criteria = example.or();
        if (startDate != null) {
            criteria.andExtractCreateTimeGreaterThanOrEqualTo(startDate);
        }
        if (endDate != null) {
            criteria.andExtractCreateTimeLessThan(endDate);
        }
        if (type != null && type.intValue() == 2) {
            List<Integer> integers = new ArrayList<>();
            integers.add(8);
//			integers.add(16);
//			integers.add(64);
            criteria.andExtractUserTypeIn(integers);
        } else {
            List<Integer> integers = new ArrayList<>();
//			integers.add(2);
            integers.add(4);
//			integers.add(32);
            criteria.andExtractUserTypeIn(integers);
        }
        MybatisGenerator.makeExample(mfoyouServiceOrder, criteria);
        example.setOrderByClause(" extract_id desc");
        int count = huawuExtractMapper.countByExample(example);
        List<HuawuExtract> list = huawuExtractMapper.selectByExampleWithBLOBs(example);
        return ArrayListObject.bliudArrayList(list, pageId, pageSize, count);
    }

    @Override
    public Boolean modifyExtract(HuawuExtract checkExtract, HuawuExtract changeExtract) {
        HuawuExtractExample mfoyouExtractExample = new HuawuExtractExample();
        MybatisGenerator.makeExample(checkExtract, mfoyouExtractExample.or());//实体类转换条件
        return huawuExtractMapper.updateByExampleSelective(changeExtract, mfoyouExtractExample) == 1;
    }

    @Override
    public HuawuExtract getMfoyouExtract(int extractId) {
        return huawuExtractMapper.selectByPrimaryKey(extractId);
    }

    @Override
    public HuawuUser getOpenId(Integer userId) {
        return huawuUserMapper.selectByPrimaryKey(userId);
    }

    @Override
    public Boolean modifyExtractByKey(HuawuExtract changeExtract) {
        return huawuExtractMapper.updateByPrimaryKeySelective(changeExtract) == 1;
    }

    @Override
    public Integer applyExtract(HuawuExtract mfoyouExtract) {
        mfoyouExtract.setAdminId(null);
        mfoyouExtract.setExtractAuditResult(0);
        mfoyouExtract.setExtractId(null);
        mfoyouExtract.setExtractState(CommonState.emauit.getValue());
        huawuExtractMapper.insertSelective(mfoyouExtract);
        return mfoyouExtract.getExtractId();
    }

    @Override
    public Boolean beginExtractWallet(Integer userId, Integer checkAmount, Integer payAmount, Integer checkUserAmount,
                                      Integer payUserAmount, String payNumber, int orderType, Integer agentId, Integer userType) {
        logger.info("userExtractWallet:userId=" + userId + ";checkAmount=" + checkAmount + ";payAmount=" + payAmount
                + ";payNumber=" + payNumber);
        HuawuWalletExample example = new HuawuWalletExample();
        HuawuWalletExample.Criteria criteria = example.or().andUserIdEqualTo(userId)
                .andWalletExtractAmountEqualTo(checkAmount);
        String amountFiled = "";
        HuawuWallet record = new HuawuWallet();
        if (payUserAmount != null && payUserAmount > 0) {
            if (MfoyouUserType.runer.getValue() == userType.intValue()) {
                criteria.andWalletRunerAmountEqualTo(checkUserAmount);
                record.setWalletRunerAmount(checkUserAmount - payUserAmount);
                amountFiled = "wallet_runer_amount";
            } else if (MfoyouUserType.agent.getValue() == userType.intValue()) {
                criteria.andWalletAgentAmountEqualTo(checkUserAmount);
                record.setWalletAgentAmount(checkUserAmount - payUserAmount);
                amountFiled = "wallet_agent_amount";
            } else if (MfoyouUserType.store.getValue() == userType.intValue()) {
                criteria.andWalletStoreAmountEqualTo(checkUserAmount);
                record.setWalletStoreAmount(checkUserAmount - payUserAmount);
                amountFiled = "wallet_store_amount";
            } else if (32 == userType.intValue()) {
                criteria.andWalletStoreAgentAmountEqualTo(checkUserAmount);
                record.setWalletAgentAmount(checkUserAmount - payUserAmount);
                amountFiled = "wallet_station_agent_amount";
            } else {
                logger.error("parmIserror");
                return false;
            }
        }
        record.setWalletExtractAmount(checkAmount - payAmount);
        Boolean bSucess = huawuWalletMapper.updateByExampleSelective(record, example) == 1;

        if (payAmount > 0) {
            HuawuWalletLog mfoyouWalletLog = new HuawuWalletLog();
            mfoyouWalletLog.setUserId(userId);
            mfoyouWalletLog.setWalletLogAmount(payAmount);
            mfoyouWalletLog.setWalletLogDirection(-1);
            mfoyouWalletLog.setWalletLogNewValue(record.getWalletExtractAmount());
            mfoyouWalletLog.setWalletLogOldValue(checkAmount);
            mfoyouWalletLog.setUserRoleType(userType);
            mfoyouWalletLog.setWalletLogOpItem("wallet_extract_amount");
            mfoyouWalletLog.setWalletLogResult(bSucess ? 1 : -1);
            mfoyouWalletLog.setWalletLogOrderId(payNumber);
            mfoyouWalletLog.setWalletLogRemark("");
            mfoyouWalletLog.setWalletLogAgentId(agentId);
            mfoyouWalletLog.setWalletLogType(orderType);
            huawuWalletLogMapper.insertSelective(mfoyouWalletLog);
        }
        if (payUserAmount > 0) {
            HuawuWalletLog mfoyouWalletLog = new HuawuWalletLog();
            mfoyouWalletLog.setUserId(userId);
            mfoyouWalletLog.setWalletLogAmount(payUserAmount);
            mfoyouWalletLog.setWalletLogDirection(-1);
            mfoyouWalletLog.setWalletLogNewValue(checkUserAmount - payUserAmount);
            mfoyouWalletLog.setWalletLogOldValue(checkUserAmount);
            mfoyouWalletLog.setWalletLogOpItem(amountFiled);
            mfoyouWalletLog.setWalletLogResult(bSucess ? 1 : -1);
            mfoyouWalletLog.setWalletLogOrderId(payNumber);
            mfoyouWalletLog.setWalletLogRemark("");
            mfoyouWalletLog.setUserRoleType(userType);
            mfoyouWalletLog.setWalletLogAgentId(agentId);
            mfoyouWalletLog.setWalletLogType(orderType);
            huawuWalletLogMapper.insertSelective(mfoyouWalletLog);
        }

        logger.info("finsh payByWallet: payNumber=" + payNumber);

        return bSucess;
    }

    @Override
    public Boolean modifyWallet(HuawuWallet mfoyouWallet) {
        HuawuWallet mfoyouWalletSave = new HuawuWallet();
        mfoyouWalletSave.setUserId(mfoyouWallet.getUserId());
        mfoyouWalletSave.setWalletAlipayAccount(mfoyouWallet.getWalletAlipayAccount());
        mfoyouWalletSave.setWalletWechatAccount(mfoyouWallet.getWalletWechatAccount());
        mfoyouWalletSave.setWalletUserName(mfoyouWallet.getWalletUserName());
        huawuWalletMapper.updateByPrimaryKeySelective(mfoyouWalletSave);
        return true;
    }

    @Override
    public Boolean payAddStoreWallet(Integer userId, Integer checkAmount, Integer payAmount, int orderType,
                                     String orderNumber, Integer agentId) {
        HuawuWalletExample example = new HuawuWalletExample();
        example.or().andUserIdEqualTo(userId).andWalletStoreAmountEqualTo(checkAmount);
        HuawuWallet record = new HuawuWallet();
        record.setWalletStoreAmount(checkAmount + payAmount);
        Boolean bSucess = huawuWalletMapper.updateByExampleSelective(record, example) == 1;
        HuawuWalletLog mfoyouWalletLog = new HuawuWalletLog();
        mfoyouWalletLog.setUserId(userId);
        mfoyouWalletLog.setWalletLogAmount(payAmount);
        mfoyouWalletLog.setWalletLogDirection(payAmount > 0 ? 1 : -1);
        mfoyouWalletLog.setWalletLogNewValue(record.getWalletStoreAmount());
        mfoyouWalletLog.setWalletLogOldValue(checkAmount);
        mfoyouWalletLog.setWalletLogOpItem("wallet_store_amount");
        mfoyouWalletLog.setWalletLogResult(bSucess ? 1 : -1);
        mfoyouWalletLog.setWalletLogOrderId(orderNumber);
        mfoyouWalletLog.setWalletLogRemark("");
        mfoyouWalletLog.setWalletLogAgentId(agentId);
        mfoyouWalletLog.setWalletLogType(orderType);
        mfoyouWalletLog.setUserRoleType(MfoyouUserType.store.getValue());
        huawuWalletLogMapper.insertSelective(mfoyouWalletLog);
        logger.info("finsh payAddStoreWallet: payNumber=" + orderNumber);
        return bSucess;
    }

    @Override
    public Boolean payAddStoreAgentWallet(Integer userId, Integer checkAmount, Integer payAmount, int orderType,
                                          String orderNumber, Integer agentId, Integer type) {
        HuawuWalletExample example = new HuawuWalletExample();
        example.or().andUserIdEqualTo(userId).andWalletStoreAgentAmountEqualTo(checkAmount);
        HuawuWallet record = new HuawuWallet();
        record.setWalletStoreAgentAmount(checkAmount + payAmount);
        Boolean bSucess = huawuWalletMapper.updateByExampleSelective(record, example) == 1;
        HuawuWalletLog mfoyouWalletLog = new HuawuWalletLog();
        mfoyouWalletLog.setUserId(userId);
        mfoyouWalletLog.setWalletLogAmount(payAmount);
        mfoyouWalletLog.setWalletLogDirection(payAmount > 0 ? 1 : -1);
        mfoyouWalletLog.setWalletLogNewValue(record.getWalletStoreAgentAmount());
        mfoyouWalletLog.setWalletLogOldValue(checkAmount);
        mfoyouWalletLog.setWalletLogOpItem("wallet_store_agent_amount");
        mfoyouWalletLog.setWalletLogResult(bSucess ? 1 : -1);
        mfoyouWalletLog.setWalletLogOrderId(orderNumber);
        mfoyouWalletLog.setWalletLogRemark("");
        mfoyouWalletLog.setWalletLogAgentId(agentId);
        mfoyouWalletLog.setWalletLogType(orderType);
        mfoyouWalletLog.setUserRoleType(type);
        huawuWalletLogMapper.insertSelective(mfoyouWalletLog);
        logger.info("finsh payAddStoreAgentWallet: payNumber=" + orderNumber);
        return bSucess;
    }

    @Override
    public Map<String, Object> getCountData(Integer agentId, Integer type) {
        String sql = "select count(distinct(user_id)) userCount,ifnull(sum(pay_amount),0) amount,count(1) order_count  "
                + "from huawu_pay  where  pay_order_type =" + type + " and pay_state = 1  and  pay_modify_time > from_days(to_days(now())-7) "
                + "and agent_id = " + agentId;
        return HuawuSystemMapper.select_item(sql);
    }

    @Override
    public ArrayListObject<?> getPayList(Integer agenid, Integer pageId, Integer pageSize, Date startDate,
                                         Date endDate, Integer type) {
        HuawuPayExample huawuPayExample = new HuawuPayExample();
        Criteria andPayAmountNotBetween = huawuPayExample.or().andPayAmountNotBetween(agenid).
                andPayStateEqualTo(1).andPayOrderTypeEqualTo(type);//已改源码
        if (startDate != null && endDate != null) {
            andPayAmountNotBetween.andPayModifyTimeBetween(startDate, endDate);
        }
        int count = huawuPayMapper.countByExample(huawuPayExample);
        huawuPayExample.setOrderByClause(" pay_id desc");
        MybatisGenerator.setLimit(huawuPayExample, pageId, pageSize);
        List<HuawuPay> selectByExample = huawuPayMapper.selectByExample(huawuPayExample);
        return ArrayListObject.bliudArrayList(selectByExample, pageId, pageSize, count);
    }

    @Override
    public ArrayListObject<HuawuStream> getStreamList(HuawuStream gxnnStream, Integer pageId, Integer pageSize,
                                                      Date startDate, Date endDate) {
        HuawuStreamExample example = new HuawuStreamExample();
        MybatisGenerator.setLimit(example, pageId, pageSize);
        HuawuStreamExample.Criteria criteria = example.or();
        if (startDate != null) {
            criteria.andStreamTimeGreaterThanOrEqualTo(startDate);
        }
        if (endDate != null) {
            criteria.andStreamTimeLessThan(endDate);
        }
        MybatisGenerator.makeExample(gxnnStream, criteria);
        example.setOrderByClause(" stream_id desc");
        int count = huawuStreamMapper.countByExample(example);
        List<HuawuStream> list = huawuStreamMapper.selectByExample(example);
        return ArrayListObject.bliudArrayList(list, pageId, pageSize, count);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, rollbackForClassName = "Exception")
    public ArrayListObject<HuawuWalletLog> getAgentWalletList(Integer agentid, int userType, Date sdate, Date edDate,
                                                              Integer pageid, Integer pagesize) {
        Integer start = null;
        Integer end = null;
        if (pageid != null && pagesize != null) {
            start = (pageid - 1) * pagesize;
            end = pagesize;
        }
        List<HuawuWalletLog> selectAgentByExample = huawuWalletLogMapper.selectAgentByExample(agentid, userType,
                sdate, edDate, start, end);
        int count = mfoyouSystemMapper.selectCount();
        return ArrayListObject.bliudArrayList(selectAgentByExample, pageid, pagesize, count);
    }
}
