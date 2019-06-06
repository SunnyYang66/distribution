package org.mfoyou.agent.common.dao.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class HuawuWalletExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    protected Integer limitStart;

    protected Integer limitEnd;

    public HuawuWalletExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    public void setLimitStart(Integer limitStart) {
        this.limitStart=limitStart;
    }

    public Integer getLimitStart() {
        return limitStart;
    }

    public void setLimitEnd(Integer limitEnd) {
        this.limitEnd=limitEnd;
    }

    public Integer getLimitEnd() {
        return limitEnd;
    }

    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        public Criteria andUserIdIsNull() {
            addCriterion("user_id is null");
            return (Criteria) this;
        }

        public Criteria andUserIdIsNotNull() {
            addCriterion("user_id is not null");
            return (Criteria) this;
        }

        public Criteria andUserIdEqualTo(Integer value) {
            addCriterion("user_id =", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotEqualTo(Integer value) {
            addCriterion("user_id <>", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdGreaterThan(Integer value) {
            addCriterion("user_id >", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("user_id >=", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLessThan(Integer value) {
            addCriterion("user_id <", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLessThanOrEqualTo(Integer value) {
            addCriterion("user_id <=", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdIn(List<Integer> values) {
            addCriterion("user_id in", values, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotIn(List<Integer> values) {
            addCriterion("user_id not in", values, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdBetween(Integer value1, Integer value2) {
            addCriterion("user_id between", value1, value2, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotBetween(Integer value1, Integer value2) {
            addCriterion("user_id not between", value1, value2, "userId");
            return (Criteria) this;
        }

        public Criteria andWalletExtractAmountIsNull() {
            addCriterion("wallet_extract_amount is null");
            return (Criteria) this;
        }

        public Criteria andWalletExtractAmountIsNotNull() {
            addCriterion("wallet_extract_amount is not null");
            return (Criteria) this;
        }

        public Criteria andWalletExtractAmountEqualTo(Integer value) {
            addCriterion("wallet_extract_amount =", value, "walletExtractAmount");
            return (Criteria) this;
        }

        public Criteria andWalletExtractAmountNotEqualTo(Integer value) {
            addCriterion("wallet_extract_amount <>", value, "walletExtractAmount");
            return (Criteria) this;
        }

        public Criteria andWalletExtractAmountGreaterThan(Integer value) {
            addCriterion("wallet_extract_amount >", value, "walletExtractAmount");
            return (Criteria) this;
        }

        public Criteria andWalletExtractAmountGreaterThanOrEqualTo(Integer value) {
            addCriterion("wallet_extract_amount >=", value, "walletExtractAmount");
            return (Criteria) this;
        }

        public Criteria andWalletExtractAmountLessThan(Integer value) {
            addCriterion("wallet_extract_amount <", value, "walletExtractAmount");
            return (Criteria) this;
        }

        public Criteria andWalletExtractAmountLessThanOrEqualTo(Integer value) {
            addCriterion("wallet_extract_amount <=", value, "walletExtractAmount");
            return (Criteria) this;
        }

        public Criteria andWalletExtractAmountIn(List<Integer> values) {
            addCriterion("wallet_extract_amount in", values, "walletExtractAmount");
            return (Criteria) this;
        }

        public Criteria andWalletExtractAmountNotIn(List<Integer> values) {
            addCriterion("wallet_extract_amount not in", values, "walletExtractAmount");
            return (Criteria) this;
        }

        public Criteria andWalletExtractAmountBetween(Integer value1, Integer value2) {
            addCriterion("wallet_extract_amount between", value1, value2, "walletExtractAmount");
            return (Criteria) this;
        }

        public Criteria andWalletExtractAmountNotBetween(Integer value1, Integer value2) {
            addCriterion("wallet_extract_amount not between", value1, value2, "walletExtractAmount");
            return (Criteria) this;
        }

        public Criteria andWalletUseAmountIsNull() {
            addCriterion("wallet_use_amount is null");
            return (Criteria) this;
        }

        public Criteria andWalletUseAmountIsNotNull() {
            addCriterion("wallet_use_amount is not null");
            return (Criteria) this;
        }

        public Criteria andWalletUseAmountEqualTo(Integer value) {
            addCriterion("wallet_use_amount =", value, "walletUseAmount");
            return (Criteria) this;
        }

        public Criteria andWalletUseAmountNotEqualTo(Integer value) {
            addCriterion("wallet_use_amount <>", value, "walletUseAmount");
            return (Criteria) this;
        }

        public Criteria andWalletUseAmountGreaterThan(Integer value) {
            addCriterion("wallet_use_amount >", value, "walletUseAmount");
            return (Criteria) this;
        }

        public Criteria andWalletUseAmountGreaterThanOrEqualTo(Integer value) {
            addCriterion("wallet_use_amount >=", value, "walletUseAmount");
            return (Criteria) this;
        }

        public Criteria andWalletUseAmountLessThan(Integer value) {
            addCriterion("wallet_use_amount <", value, "walletUseAmount");
            return (Criteria) this;
        }

        public Criteria andWalletUseAmountLessThanOrEqualTo(Integer value) {
            addCriterion("wallet_use_amount <=", value, "walletUseAmount");
            return (Criteria) this;
        }

        public Criteria andWalletUseAmountIn(List<Integer> values) {
            addCriterion("wallet_use_amount in", values, "walletUseAmount");
            return (Criteria) this;
        }

        public Criteria andWalletUseAmountNotIn(List<Integer> values) {
            addCriterion("wallet_use_amount not in", values, "walletUseAmount");
            return (Criteria) this;
        }

        public Criteria andWalletUseAmountBetween(Integer value1, Integer value2) {
            addCriterion("wallet_use_amount between", value1, value2, "walletUseAmount");
            return (Criteria) this;
        }

        public Criteria andWalletUseAmountNotBetween(Integer value1, Integer value2) {
            addCriterion("wallet_use_amount not between", value1, value2, "walletUseAmount");
            return (Criteria) this;
        }

        public Criteria andWalletFreezeAmountIsNull() {
            addCriterion("wallet_freeze_amount is null");
            return (Criteria) this;
        }

        public Criteria andWalletFreezeAmountIsNotNull() {
            addCriterion("wallet_freeze_amount is not null");
            return (Criteria) this;
        }

        public Criteria andWalletFreezeAmountEqualTo(Integer value) {
            addCriterion("wallet_freeze_amount =", value, "walletFreezeAmount");
            return (Criteria) this;
        }

        public Criteria andWalletFreezeAmountNotEqualTo(Integer value) {
            addCriterion("wallet_freeze_amount <>", value, "walletFreezeAmount");
            return (Criteria) this;
        }

        public Criteria andWalletFreezeAmountGreaterThan(Integer value) {
            addCriterion("wallet_freeze_amount >", value, "walletFreezeAmount");
            return (Criteria) this;
        }

        public Criteria andWalletFreezeAmountGreaterThanOrEqualTo(Integer value) {
            addCriterion("wallet_freeze_amount >=", value, "walletFreezeAmount");
            return (Criteria) this;
        }

        public Criteria andWalletFreezeAmountLessThan(Integer value) {
            addCriterion("wallet_freeze_amount <", value, "walletFreezeAmount");
            return (Criteria) this;
        }

        public Criteria andWalletFreezeAmountLessThanOrEqualTo(Integer value) {
            addCriterion("wallet_freeze_amount <=", value, "walletFreezeAmount");
            return (Criteria) this;
        }

        public Criteria andWalletFreezeAmountIn(List<Integer> values) {
            addCriterion("wallet_freeze_amount in", values, "walletFreezeAmount");
            return (Criteria) this;
        }

        public Criteria andWalletFreezeAmountNotIn(List<Integer> values) {
            addCriterion("wallet_freeze_amount not in", values, "walletFreezeAmount");
            return (Criteria) this;
        }

        public Criteria andWalletFreezeAmountBetween(Integer value1, Integer value2) {
            addCriterion("wallet_freeze_amount between", value1, value2, "walletFreezeAmount");
            return (Criteria) this;
        }

        public Criteria andWalletFreezeAmountNotBetween(Integer value1, Integer value2) {
            addCriterion("wallet_freeze_amount not between", value1, value2, "walletFreezeAmount");
            return (Criteria) this;
        }

        public Criteria andWalletRunerAmountIsNull() {
            addCriterion("wallet_runer_amount is null");
            return (Criteria) this;
        }

        public Criteria andWalletRunerAmountIsNotNull() {
            addCriterion("wallet_runer_amount is not null");
            return (Criteria) this;
        }

        public Criteria andWalletRunerAmountEqualTo(Integer value) {
            addCriterion("wallet_runer_amount =", value, "walletRunerAmount");
            return (Criteria) this;
        }

        public Criteria andWalletRunerAmountNotEqualTo(Integer value) {
            addCriterion("wallet_runer_amount <>", value, "walletRunerAmount");
            return (Criteria) this;
        }

        public Criteria andWalletRunerAmountGreaterThan(Integer value) {
            addCriterion("wallet_runer_amount >", value, "walletRunerAmount");
            return (Criteria) this;
        }

        public Criteria andWalletRunerAmountGreaterThanOrEqualTo(Integer value) {
            addCriterion("wallet_runer_amount >=", value, "walletRunerAmount");
            return (Criteria) this;
        }

        public Criteria andWalletRunerAmountLessThan(Integer value) {
            addCriterion("wallet_runer_amount <", value, "walletRunerAmount");
            return (Criteria) this;
        }

        public Criteria andWalletRunerAmountLessThanOrEqualTo(Integer value) {
            addCriterion("wallet_runer_amount <=", value, "walletRunerAmount");
            return (Criteria) this;
        }

        public Criteria andWalletRunerAmountIn(List<Integer> values) {
            addCriterion("wallet_runer_amount in", values, "walletRunerAmount");
            return (Criteria) this;
        }

        public Criteria andWalletRunerAmountNotIn(List<Integer> values) {
            addCriterion("wallet_runer_amount not in", values, "walletRunerAmount");
            return (Criteria) this;
        }

        public Criteria andWalletRunerAmountBetween(Integer value1, Integer value2) {
            addCriterion("wallet_runer_amount between", value1, value2, "walletRunerAmount");
            return (Criteria) this;
        }

        public Criteria andWalletRunerAmountNotBetween(Integer value1, Integer value2) {
            addCriterion("wallet_runer_amount not between", value1, value2, "walletRunerAmount");
            return (Criteria) this;
        }

        public Criteria andWalletAgentAmountIsNull() {
            addCriterion("wallet_agent_amount is null");
            return (Criteria) this;
        }

        public Criteria andWalletAgentAmountIsNotNull() {
            addCriterion("wallet_agent_amount is not null");
            return (Criteria) this;
        }

        public Criteria andWalletAgentAmountEqualTo(Integer value) {
            addCriterion("wallet_agent_amount =", value, "walletAgentAmount");
            return (Criteria) this;
        }

        public Criteria andWalletAgentAmountNotEqualTo(Integer value) {
            addCriterion("wallet_agent_amount <>", value, "walletAgentAmount");
            return (Criteria) this;
        }

        public Criteria andWalletAgentAmountGreaterThan(Integer value) {
            addCriterion("wallet_agent_amount >", value, "walletAgentAmount");
            return (Criteria) this;
        }

        public Criteria andWalletAgentAmountGreaterThanOrEqualTo(Integer value) {
            addCriterion("wallet_agent_amount >=", value, "walletAgentAmount");
            return (Criteria) this;
        }

        public Criteria andWalletAgentAmountLessThan(Integer value) {
            addCriterion("wallet_agent_amount <", value, "walletAgentAmount");
            return (Criteria) this;
        }

        public Criteria andWalletAgentAmountLessThanOrEqualTo(Integer value) {
            addCriterion("wallet_agent_amount <=", value, "walletAgentAmount");
            return (Criteria) this;
        }

        public Criteria andWalletAgentAmountIn(List<Integer> values) {
            addCriterion("wallet_agent_amount in", values, "walletAgentAmount");
            return (Criteria) this;
        }

        public Criteria andWalletAgentAmountNotIn(List<Integer> values) {
            addCriterion("wallet_agent_amount not in", values, "walletAgentAmount");
            return (Criteria) this;
        }

        public Criteria andWalletAgentAmountBetween(Integer value1, Integer value2) {
            addCriterion("wallet_agent_amount between", value1, value2, "walletAgentAmount");
            return (Criteria) this;
        }

        public Criteria andWalletAgentAmountNotBetween(Integer value1, Integer value2) {
            addCriterion("wallet_agent_amount not between", value1, value2, "walletAgentAmount");
            return (Criteria) this;
        }

        public Criteria andWalletStoreAmountIsNull() {
            addCriterion("wallet_store_amount is null");
            return (Criteria) this;
        }

        public Criteria andWalletStoreAmountIsNotNull() {
            addCriterion("wallet_store_amount is not null");
            return (Criteria) this;
        }

        public Criteria andWalletStoreAmountEqualTo(Integer value) {
            addCriterion("wallet_store_amount =", value, "walletStoreAmount");
            return (Criteria) this;
        }

        public Criteria andWalletStoreAmountNotEqualTo(Integer value) {
            addCriterion("wallet_store_amount <>", value, "walletStoreAmount");
            return (Criteria) this;
        }

        public Criteria andWalletStoreAmountGreaterThan(Integer value) {
            addCriterion("wallet_store_amount >", value, "walletStoreAmount");
            return (Criteria) this;
        }

        public Criteria andWalletStoreAmountGreaterThanOrEqualTo(Integer value) {
            addCriterion("wallet_store_amount >=", value, "walletStoreAmount");
            return (Criteria) this;
        }

        public Criteria andWalletStoreAmountLessThan(Integer value) {
            addCriterion("wallet_store_amount <", value, "walletStoreAmount");
            return (Criteria) this;
        }

        public Criteria andWalletStoreAmountLessThanOrEqualTo(Integer value) {
            addCriterion("wallet_store_amount <=", value, "walletStoreAmount");
            return (Criteria) this;
        }

        public Criteria andWalletStoreAmountIn(List<Integer> values) {
            addCriterion("wallet_store_amount in", values, "walletStoreAmount");
            return (Criteria) this;
        }

        public Criteria andWalletStoreAmountNotIn(List<Integer> values) {
            addCriterion("wallet_store_amount not in", values, "walletStoreAmount");
            return (Criteria) this;
        }

        public Criteria andWalletStoreAmountBetween(Integer value1, Integer value2) {
            addCriterion("wallet_store_amount between", value1, value2, "walletStoreAmount");
            return (Criteria) this;
        }

        public Criteria andWalletStoreAmountNotBetween(Integer value1, Integer value2) {
            addCriterion("wallet_store_amount not between", value1, value2, "walletStoreAmount");
            return (Criteria) this;
        }

        public Criteria andWalletStoreAgentAmountIsNull() {
            addCriterion("wallet_store_agent_amount is null");
            return (Criteria) this;
        }

        public Criteria andWalletStoreAgentAmountIsNotNull() {
            addCriterion("wallet_store_agent_amount is not null");
            return (Criteria) this;
        }

        public Criteria andWalletStoreAgentAmountEqualTo(Integer value) {
            addCriterion("wallet_store_agent_amount =", value, "walletStoreAgentAmount");
            return (Criteria) this;
        }

        public Criteria andWalletStoreAgentAmountNotEqualTo(Integer value) {
            addCriterion("wallet_store_agent_amount <>", value, "walletStoreAgentAmount");
            return (Criteria) this;
        }

        public Criteria andWalletStoreAgentAmountGreaterThan(Integer value) {
            addCriterion("wallet_store_agent_amount >", value, "walletStoreAgentAmount");
            return (Criteria) this;
        }

        public Criteria andWalletStoreAgentAmountGreaterThanOrEqualTo(Integer value) {
            addCriterion("wallet_store_agent_amount >=", value, "walletStoreAgentAmount");
            return (Criteria) this;
        }

        public Criteria andWalletStoreAgentAmountLessThan(Integer value) {
            addCriterion("wallet_store_agent_amount <", value, "walletStoreAgentAmount");
            return (Criteria) this;
        }

        public Criteria andWalletStoreAgentAmountLessThanOrEqualTo(Integer value) {
            addCriterion("wallet_store_agent_amount <=", value, "walletStoreAgentAmount");
            return (Criteria) this;
        }

        public Criteria andWalletStoreAgentAmountIn(List<Integer> values) {
            addCriterion("wallet_store_agent_amount in", values, "walletStoreAgentAmount");
            return (Criteria) this;
        }

        public Criteria andWalletStoreAgentAmountNotIn(List<Integer> values) {
            addCriterion("wallet_store_agent_amount not in", values, "walletStoreAgentAmount");
            return (Criteria) this;
        }

        public Criteria andWalletStoreAgentAmountBetween(Integer value1, Integer value2) {
            addCriterion("wallet_store_agent_amount between", value1, value2, "walletStoreAgentAmount");
            return (Criteria) this;
        }

        public Criteria andWalletStoreAgentAmountNotBetween(Integer value1, Integer value2) {
            addCriterion("wallet_store_agent_amount not between", value1, value2, "walletStoreAgentAmount");
            return (Criteria) this;
        }

        public Criteria andWalletIntegralIsNull() {
            addCriterion("wallet_integral is null");
            return (Criteria) this;
        }

        public Criteria andWalletIntegralIsNotNull() {
            addCriterion("wallet_integral is not null");
            return (Criteria) this;
        }

        public Criteria andWalletIntegralEqualTo(Integer value) {
            addCriterion("wallet_integral =", value, "walletIntegral");
            return (Criteria) this;
        }

        public Criteria andWalletIntegralNotEqualTo(Integer value) {
            addCriterion("wallet_integral <>", value, "walletIntegral");
            return (Criteria) this;
        }

        public Criteria andWalletIntegralGreaterThan(Integer value) {
            addCriterion("wallet_integral >", value, "walletIntegral");
            return (Criteria) this;
        }

        public Criteria andWalletIntegralGreaterThanOrEqualTo(Integer value) {
            addCriterion("wallet_integral >=", value, "walletIntegral");
            return (Criteria) this;
        }

        public Criteria andWalletIntegralLessThan(Integer value) {
            addCriterion("wallet_integral <", value, "walletIntegral");
            return (Criteria) this;
        }

        public Criteria andWalletIntegralLessThanOrEqualTo(Integer value) {
            addCriterion("wallet_integral <=", value, "walletIntegral");
            return (Criteria) this;
        }

        public Criteria andWalletIntegralIn(List<Integer> values) {
            addCriterion("wallet_integral in", values, "walletIntegral");
            return (Criteria) this;
        }

        public Criteria andWalletIntegralNotIn(List<Integer> values) {
            addCriterion("wallet_integral not in", values, "walletIntegral");
            return (Criteria) this;
        }

        public Criteria andWalletIntegralBetween(Integer value1, Integer value2) {
            addCriterion("wallet_integral between", value1, value2, "walletIntegral");
            return (Criteria) this;
        }

        public Criteria andWalletIntegralNotBetween(Integer value1, Integer value2) {
            addCriterion("wallet_integral not between", value1, value2, "walletIntegral");
            return (Criteria) this;
        }

        public Criteria andWalletAlipayAccountIsNull() {
            addCriterion("wallet_alipay_account is null");
            return (Criteria) this;
        }

        public Criteria andWalletAlipayAccountIsNotNull() {
            addCriterion("wallet_alipay_account is not null");
            return (Criteria) this;
        }

        public Criteria andWalletAlipayAccountEqualTo(String value) {
            addCriterion("wallet_alipay_account =", value, "walletAlipayAccount");
            return (Criteria) this;
        }

        public Criteria andWalletAlipayAccountNotEqualTo(String value) {
            addCriterion("wallet_alipay_account <>", value, "walletAlipayAccount");
            return (Criteria) this;
        }

        public Criteria andWalletAlipayAccountGreaterThan(String value) {
            addCriterion("wallet_alipay_account >", value, "walletAlipayAccount");
            return (Criteria) this;
        }

        public Criteria andWalletAlipayAccountGreaterThanOrEqualTo(String value) {
            addCriterion("wallet_alipay_account >=", value, "walletAlipayAccount");
            return (Criteria) this;
        }

        public Criteria andWalletAlipayAccountLessThan(String value) {
            addCriterion("wallet_alipay_account <", value, "walletAlipayAccount");
            return (Criteria) this;
        }

        public Criteria andWalletAlipayAccountLessThanOrEqualTo(String value) {
            addCriterion("wallet_alipay_account <=", value, "walletAlipayAccount");
            return (Criteria) this;
        }

        public Criteria andWalletAlipayAccountLike(String value) {
            addCriterion("wallet_alipay_account like", value, "walletAlipayAccount");
            return (Criteria) this;
        }

        public Criteria andWalletAlipayAccountNotLike(String value) {
            addCriterion("wallet_alipay_account not like", value, "walletAlipayAccount");
            return (Criteria) this;
        }

        public Criteria andWalletAlipayAccountIn(List<String> values) {
            addCriterion("wallet_alipay_account in", values, "walletAlipayAccount");
            return (Criteria) this;
        }

        public Criteria andWalletAlipayAccountNotIn(List<String> values) {
            addCriterion("wallet_alipay_account not in", values, "walletAlipayAccount");
            return (Criteria) this;
        }

        public Criteria andWalletAlipayAccountBetween(String value1, String value2) {
            addCriterion("wallet_alipay_account between", value1, value2, "walletAlipayAccount");
            return (Criteria) this;
        }

        public Criteria andWalletAlipayAccountNotBetween(String value1, String value2) {
            addCriterion("wallet_alipay_account not between", value1, value2, "walletAlipayAccount");
            return (Criteria) this;
        }

        public Criteria andWalletWechatAccountIsNull() {
            addCriterion("wallet_wechat_account is null");
            return (Criteria) this;
        }

        public Criteria andWalletWechatAccountIsNotNull() {
            addCriterion("wallet_wechat_account is not null");
            return (Criteria) this;
        }

        public Criteria andWalletWechatAccountEqualTo(String value) {
            addCriterion("wallet_wechat_account =", value, "walletWechatAccount");
            return (Criteria) this;
        }

        public Criteria andWalletWechatAccountNotEqualTo(String value) {
            addCriterion("wallet_wechat_account <>", value, "walletWechatAccount");
            return (Criteria) this;
        }

        public Criteria andWalletWechatAccountGreaterThan(String value) {
            addCriterion("wallet_wechat_account >", value, "walletWechatAccount");
            return (Criteria) this;
        }

        public Criteria andWalletWechatAccountGreaterThanOrEqualTo(String value) {
            addCriterion("wallet_wechat_account >=", value, "walletWechatAccount");
            return (Criteria) this;
        }

        public Criteria andWalletWechatAccountLessThan(String value) {
            addCriterion("wallet_wechat_account <", value, "walletWechatAccount");
            return (Criteria) this;
        }

        public Criteria andWalletWechatAccountLessThanOrEqualTo(String value) {
            addCriterion("wallet_wechat_account <=", value, "walletWechatAccount");
            return (Criteria) this;
        }

        public Criteria andWalletWechatAccountLike(String value) {
            addCriterion("wallet_wechat_account like", value, "walletWechatAccount");
            return (Criteria) this;
        }

        public Criteria andWalletWechatAccountNotLike(String value) {
            addCriterion("wallet_wechat_account not like", value, "walletWechatAccount");
            return (Criteria) this;
        }

        public Criteria andWalletWechatAccountIn(List<String> values) {
            addCriterion("wallet_wechat_account in", values, "walletWechatAccount");
            return (Criteria) this;
        }

        public Criteria andWalletWechatAccountNotIn(List<String> values) {
            addCriterion("wallet_wechat_account not in", values, "walletWechatAccount");
            return (Criteria) this;
        }

        public Criteria andWalletWechatAccountBetween(String value1, String value2) {
            addCriterion("wallet_wechat_account between", value1, value2, "walletWechatAccount");
            return (Criteria) this;
        }

        public Criteria andWalletWechatAccountNotBetween(String value1, String value2) {
            addCriterion("wallet_wechat_account not between", value1, value2, "walletWechatAccount");
            return (Criteria) this;
        }

        public Criteria andWalletUserIdcodeIsNull() {
            addCriterion("wallet_user_idcode is null");
            return (Criteria) this;
        }

        public Criteria andWalletUserIdcodeIsNotNull() {
            addCriterion("wallet_user_idcode is not null");
            return (Criteria) this;
        }

        public Criteria andWalletUserIdcodeEqualTo(String value) {
            addCriterion("wallet_user_idcode =", value, "walletUserIdcode");
            return (Criteria) this;
        }

        public Criteria andWalletUserIdcodeNotEqualTo(String value) {
            addCriterion("wallet_user_idcode <>", value, "walletUserIdcode");
            return (Criteria) this;
        }

        public Criteria andWalletUserIdcodeGreaterThan(String value) {
            addCriterion("wallet_user_idcode >", value, "walletUserIdcode");
            return (Criteria) this;
        }

        public Criteria andWalletUserIdcodeGreaterThanOrEqualTo(String value) {
            addCriterion("wallet_user_idcode >=", value, "walletUserIdcode");
            return (Criteria) this;
        }

        public Criteria andWalletUserIdcodeLessThan(String value) {
            addCriterion("wallet_user_idcode <", value, "walletUserIdcode");
            return (Criteria) this;
        }

        public Criteria andWalletUserIdcodeLessThanOrEqualTo(String value) {
            addCriterion("wallet_user_idcode <=", value, "walletUserIdcode");
            return (Criteria) this;
        }

        public Criteria andWalletUserIdcodeLike(String value) {
            addCriterion("wallet_user_idcode like", value, "walletUserIdcode");
            return (Criteria) this;
        }

        public Criteria andWalletUserIdcodeNotLike(String value) {
            addCriterion("wallet_user_idcode not like", value, "walletUserIdcode");
            return (Criteria) this;
        }

        public Criteria andWalletUserIdcodeIn(List<String> values) {
            addCriterion("wallet_user_idcode in", values, "walletUserIdcode");
            return (Criteria) this;
        }

        public Criteria andWalletUserIdcodeNotIn(List<String> values) {
            addCriterion("wallet_user_idcode not in", values, "walletUserIdcode");
            return (Criteria) this;
        }

        public Criteria andWalletUserIdcodeBetween(String value1, String value2) {
            addCriterion("wallet_user_idcode between", value1, value2, "walletUserIdcode");
            return (Criteria) this;
        }

        public Criteria andWalletUserIdcodeNotBetween(String value1, String value2) {
            addCriterion("wallet_user_idcode not between", value1, value2, "walletUserIdcode");
            return (Criteria) this;
        }

        public Criteria andWalletUserNameIsNull() {
            addCriterion("wallet_user_name is null");
            return (Criteria) this;
        }

        public Criteria andWalletUserNameIsNotNull() {
            addCriterion("wallet_user_name is not null");
            return (Criteria) this;
        }

        public Criteria andWalletUserNameEqualTo(String value) {
            addCriterion("wallet_user_name =", value, "walletUserName");
            return (Criteria) this;
        }

        public Criteria andWalletUserNameNotEqualTo(String value) {
            addCriterion("wallet_user_name <>", value, "walletUserName");
            return (Criteria) this;
        }

        public Criteria andWalletUserNameGreaterThan(String value) {
            addCriterion("wallet_user_name >", value, "walletUserName");
            return (Criteria) this;
        }

        public Criteria andWalletUserNameGreaterThanOrEqualTo(String value) {
            addCriterion("wallet_user_name >=", value, "walletUserName");
            return (Criteria) this;
        }

        public Criteria andWalletUserNameLessThan(String value) {
            addCriterion("wallet_user_name <", value, "walletUserName");
            return (Criteria) this;
        }

        public Criteria andWalletUserNameLessThanOrEqualTo(String value) {
            addCriterion("wallet_user_name <=", value, "walletUserName");
            return (Criteria) this;
        }

        public Criteria andWalletUserNameLike(String value) {
            addCriterion("wallet_user_name like", value, "walletUserName");
            return (Criteria) this;
        }

        public Criteria andWalletUserNameNotLike(String value) {
            addCriterion("wallet_user_name not like", value, "walletUserName");
            return (Criteria) this;
        }

        public Criteria andWalletUserNameIn(List<String> values) {
            addCriterion("wallet_user_name in", values, "walletUserName");
            return (Criteria) this;
        }

        public Criteria andWalletUserNameNotIn(List<String> values) {
            addCriterion("wallet_user_name not in", values, "walletUserName");
            return (Criteria) this;
        }

        public Criteria andWalletUserNameBetween(String value1, String value2) {
            addCriterion("wallet_user_name between", value1, value2, "walletUserName");
            return (Criteria) this;
        }

        public Criteria andWalletUserNameNotBetween(String value1, String value2) {
            addCriterion("wallet_user_name not between", value1, value2, "walletUserName");
            return (Criteria) this;
        }

        public Criteria andWalletCreateTimeIsNull() {
            addCriterion("wallet_create_time is null");
            return (Criteria) this;
        }

        public Criteria andWalletCreateTimeIsNotNull() {
            addCriterion("wallet_create_time is not null");
            return (Criteria) this;
        }

        public Criteria andWalletCreateTimeEqualTo(Date value) {
            addCriterion("wallet_create_time =", value, "walletCreateTime");
            return (Criteria) this;
        }

        public Criteria andWalletCreateTimeNotEqualTo(Date value) {
            addCriterion("wallet_create_time <>", value, "walletCreateTime");
            return (Criteria) this;
        }

        public Criteria andWalletCreateTimeGreaterThan(Date value) {
            addCriterion("wallet_create_time >", value, "walletCreateTime");
            return (Criteria) this;
        }

        public Criteria andWalletCreateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("wallet_create_time >=", value, "walletCreateTime");
            return (Criteria) this;
        }

        public Criteria andWalletCreateTimeLessThan(Date value) {
            addCriterion("wallet_create_time <", value, "walletCreateTime");
            return (Criteria) this;
        }

        public Criteria andWalletCreateTimeLessThanOrEqualTo(Date value) {
            addCriterion("wallet_create_time <=", value, "walletCreateTime");
            return (Criteria) this;
        }

        public Criteria andWalletCreateTimeIn(List<Date> values) {
            addCriterion("wallet_create_time in", values, "walletCreateTime");
            return (Criteria) this;
        }

        public Criteria andWalletCreateTimeNotIn(List<Date> values) {
            addCriterion("wallet_create_time not in", values, "walletCreateTime");
            return (Criteria) this;
        }

        public Criteria andWalletCreateTimeBetween(Date value1, Date value2) {
            addCriterion("wallet_create_time between", value1, value2, "walletCreateTime");
            return (Criteria) this;
        }

        public Criteria andWalletCreateTimeNotBetween(Date value1, Date value2) {
            addCriterion("wallet_create_time not between", value1, value2, "walletCreateTime");
            return (Criteria) this;
        }

        public Criteria andWalletModfiyTimeIsNull() {
            addCriterion("wallet_modfiy_time is null");
            return (Criteria) this;
        }

        public Criteria andWalletModfiyTimeIsNotNull() {
            addCriterion("wallet_modfiy_time is not null");
            return (Criteria) this;
        }

        public Criteria andWalletModfiyTimeEqualTo(Date value) {
            addCriterion("wallet_modfiy_time =", value, "walletModfiyTime");
            return (Criteria) this;
        }

        public Criteria andWalletModfiyTimeNotEqualTo(Date value) {
            addCriterion("wallet_modfiy_time <>", value, "walletModfiyTime");
            return (Criteria) this;
        }

        public Criteria andWalletModfiyTimeGreaterThan(Date value) {
            addCriterion("wallet_modfiy_time >", value, "walletModfiyTime");
            return (Criteria) this;
        }

        public Criteria andWalletModfiyTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("wallet_modfiy_time >=", value, "walletModfiyTime");
            return (Criteria) this;
        }

        public Criteria andWalletModfiyTimeLessThan(Date value) {
            addCriterion("wallet_modfiy_time <", value, "walletModfiyTime");
            return (Criteria) this;
        }

        public Criteria andWalletModfiyTimeLessThanOrEqualTo(Date value) {
            addCriterion("wallet_modfiy_time <=", value, "walletModfiyTime");
            return (Criteria) this;
        }

        public Criteria andWalletModfiyTimeIn(List<Date> values) {
            addCriterion("wallet_modfiy_time in", values, "walletModfiyTime");
            return (Criteria) this;
        }

        public Criteria andWalletModfiyTimeNotIn(List<Date> values) {
            addCriterion("wallet_modfiy_time not in", values, "walletModfiyTime");
            return (Criteria) this;
        }

        public Criteria andWalletModfiyTimeBetween(Date value1, Date value2) {
            addCriterion("wallet_modfiy_time between", value1, value2, "walletModfiyTime");
            return (Criteria) this;
        }

        public Criteria andWalletModfiyTimeNotBetween(Date value1, Date value2) {
            addCriterion("wallet_modfiy_time not between", value1, value2, "walletModfiyTime");
            return (Criteria) this;
        }

        public Criteria andWalletFreightAccountIsNull() {
            addCriterion("wallet_freight_account is null");
            return (Criteria) this;
        }

        public Criteria andWalletFreightAccountIsNotNull() {
            addCriterion("wallet_freight_account is not null");
            return (Criteria) this;
        }

        public Criteria andWalletFreightAccountEqualTo(Integer value) {
            addCriterion("wallet_freight_account =", value, "walletFreightAccount");
            return (Criteria) this;
        }

        public Criteria andWalletFreightAccountNotEqualTo(Integer value) {
            addCriterion("wallet_freight_account <>", value, "walletFreightAccount");
            return (Criteria) this;
        }

        public Criteria andWalletFreightAccountGreaterThan(Integer value) {
            addCriterion("wallet_freight_account >", value, "walletFreightAccount");
            return (Criteria) this;
        }

        public Criteria andWalletFreightAccountGreaterThanOrEqualTo(Integer value) {
            addCriterion("wallet_freight_account >=", value, "walletFreightAccount");
            return (Criteria) this;
        }

        public Criteria andWalletFreightAccountLessThan(Integer value) {
            addCriterion("wallet_freight_account <", value, "walletFreightAccount");
            return (Criteria) this;
        }

        public Criteria andWalletFreightAccountLessThanOrEqualTo(Integer value) {
            addCriterion("wallet_freight_account <=", value, "walletFreightAccount");
            return (Criteria) this;
        }

        public Criteria andWalletFreightAccountIn(List<Integer> values) {
            addCriterion("wallet_freight_account in", values, "walletFreightAccount");
            return (Criteria) this;
        }

        public Criteria andWalletFreightAccountNotIn(List<Integer> values) {
            addCriterion("wallet_freight_account not in", values, "walletFreightAccount");
            return (Criteria) this;
        }

        public Criteria andWalletFreightAccountBetween(Integer value1, Integer value2) {
            addCriterion("wallet_freight_account between", value1, value2, "walletFreightAccount");
            return (Criteria) this;
        }

        public Criteria andWalletFreightAccountNotBetween(Integer value1, Integer value2) {
            addCriterion("wallet_freight_account not between", value1, value2, "walletFreightAccount");
            return (Criteria) this;
        }

        public Criteria andAgentIdIsNull() {
            addCriterion("agent_id is null");
            return (Criteria) this;
        }

        public Criteria andAgentIdIsNotNull() {
            addCriterion("agent_id is not null");
            return (Criteria) this;
        }

        public Criteria andAgentIdEqualTo(Integer value) {
            addCriterion("agent_id =", value, "agentId");
            return (Criteria) this;
        }

        public Criteria andAgentIdNotEqualTo(Integer value) {
            addCriterion("agent_id <>", value, "agentId");
            return (Criteria) this;
        }

        public Criteria andAgentIdGreaterThan(Integer value) {
            addCriterion("agent_id >", value, "agentId");
            return (Criteria) this;
        }

        public Criteria andAgentIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("agent_id >=", value, "agentId");
            return (Criteria) this;
        }

        public Criteria andAgentIdLessThan(Integer value) {
            addCriterion("agent_id <", value, "agentId");
            return (Criteria) this;
        }

        public Criteria andAgentIdLessThanOrEqualTo(Integer value) {
            addCriterion("agent_id <=", value, "agentId");
            return (Criteria) this;
        }

        public Criteria andAgentIdIn(List<Integer> values) {
            addCriterion("agent_id in", values, "agentId");
            return (Criteria) this;
        }

        public Criteria andAgentIdNotIn(List<Integer> values) {
            addCriterion("agent_id not in", values, "agentId");
            return (Criteria) this;
        }

        public Criteria andAgentIdBetween(Integer value1, Integer value2) {
            addCriterion("agent_id between", value1, value2, "agentId");
            return (Criteria) this;
        }

        public Criteria andAgentIdNotBetween(Integer value1, Integer value2) {
            addCriterion("agent_id not between", value1, value2, "agentId");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}