package org.mfoyou.agent.common.dao.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class HuawuExtractExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    protected Integer limitStart;

    protected Integer limitEnd;

    public HuawuExtractExample() {
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

        public Criteria andExtractIdIsNull() {
            addCriterion("extract_id is null");
            return (Criteria) this;
        }

        public Criteria andExtractIdIsNotNull() {
            addCriterion("extract_id is not null");
            return (Criteria) this;
        }

        public Criteria andExtractIdEqualTo(Integer value) {
            addCriterion("extract_id =", value, "extractId");
            return (Criteria) this;
        }

        public Criteria andExtractIdNotEqualTo(Integer value) {
            addCriterion("extract_id <>", value, "extractId");
            return (Criteria) this;
        }

        public Criteria andExtractIdGreaterThan(Integer value) {
            addCriterion("extract_id >", value, "extractId");
            return (Criteria) this;
        }

        public Criteria andExtractIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("extract_id >=", value, "extractId");
            return (Criteria) this;
        }

        public Criteria andExtractIdLessThan(Integer value) {
            addCriterion("extract_id <", value, "extractId");
            return (Criteria) this;
        }

        public Criteria andExtractIdLessThanOrEqualTo(Integer value) {
            addCriterion("extract_id <=", value, "extractId");
            return (Criteria) this;
        }

        public Criteria andExtractIdIn(List<Integer> values) {
            addCriterion("extract_id in", values, "extractId");
            return (Criteria) this;
        }

        public Criteria andExtractIdNotIn(List<Integer> values) {
            addCriterion("extract_id not in", values, "extractId");
            return (Criteria) this;
        }

        public Criteria andExtractIdBetween(Integer value1, Integer value2) {
            addCriterion("extract_id between", value1, value2, "extractId");
            return (Criteria) this;
        }

        public Criteria andExtractIdNotBetween(Integer value1, Integer value2) {
            addCriterion("extract_id not between", value1, value2, "extractId");
            return (Criteria) this;
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

        public Criteria andExtractAmountIsNull() {
            addCriterion("extract_amount is null");
            return (Criteria) this;
        }

        public Criteria andExtractAmountIsNotNull() {
            addCriterion("extract_amount is not null");
            return (Criteria) this;
        }

        public Criteria andExtractAmountEqualTo(Integer value) {
            addCriterion("extract_amount =", value, "extractAmount");
            return (Criteria) this;
        }

        public Criteria andExtractAmountNotEqualTo(Integer value) {
            addCriterion("extract_amount <>", value, "extractAmount");
            return (Criteria) this;
        }

        public Criteria andExtractAmountGreaterThan(Integer value) {
            addCriterion("extract_amount >", value, "extractAmount");
            return (Criteria) this;
        }

        public Criteria andExtractAmountGreaterThanOrEqualTo(Integer value) {
            addCriterion("extract_amount >=", value, "extractAmount");
            return (Criteria) this;
        }

        public Criteria andExtractAmountLessThan(Integer value) {
            addCriterion("extract_amount <", value, "extractAmount");
            return (Criteria) this;
        }

        public Criteria andExtractAmountLessThanOrEqualTo(Integer value) {
            addCriterion("extract_amount <=", value, "extractAmount");
            return (Criteria) this;
        }

        public Criteria andExtractAmountIn(List<Integer> values) {
            addCriterion("extract_amount in", values, "extractAmount");
            return (Criteria) this;
        }

        public Criteria andExtractAmountNotIn(List<Integer> values) {
            addCriterion("extract_amount not in", values, "extractAmount");
            return (Criteria) this;
        }

        public Criteria andExtractAmountBetween(Integer value1, Integer value2) {
            addCriterion("extract_amount between", value1, value2, "extractAmount");
            return (Criteria) this;
        }

        public Criteria andExtractAmountNotBetween(Integer value1, Integer value2) {
            addCriterion("extract_amount not between", value1, value2, "extractAmount");
            return (Criteria) this;
        }

        public Criteria andExtractTimeIsNull() {
            addCriterion("extract_time is null");
            return (Criteria) this;
        }

        public Criteria andExtractTimeIsNotNull() {
            addCriterion("extract_time is not null");
            return (Criteria) this;
        }

        public Criteria andExtractTimeEqualTo(Date value) {
            addCriterion("extract_time =", value, "extractTime");
            return (Criteria) this;
        }

        public Criteria andExtractTimeNotEqualTo(Date value) {
            addCriterion("extract_time <>", value, "extractTime");
            return (Criteria) this;
        }

        public Criteria andExtractTimeGreaterThan(Date value) {
            addCriterion("extract_time >", value, "extractTime");
            return (Criteria) this;
        }

        public Criteria andExtractTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("extract_time >=", value, "extractTime");
            return (Criteria) this;
        }

        public Criteria andExtractTimeLessThan(Date value) {
            addCriterion("extract_time <", value, "extractTime");
            return (Criteria) this;
        }

        public Criteria andExtractTimeLessThanOrEqualTo(Date value) {
            addCriterion("extract_time <=", value, "extractTime");
            return (Criteria) this;
        }

        public Criteria andExtractTimeIn(List<Date> values) {
            addCriterion("extract_time in", values, "extractTime");
            return (Criteria) this;
        }

        public Criteria andExtractTimeNotIn(List<Date> values) {
            addCriterion("extract_time not in", values, "extractTime");
            return (Criteria) this;
        }

        public Criteria andExtractTimeBetween(Date value1, Date value2) {
            addCriterion("extract_time between", value1, value2, "extractTime");
            return (Criteria) this;
        }

        public Criteria andExtractTimeNotBetween(Date value1, Date value2) {
            addCriterion("extract_time not between", value1, value2, "extractTime");
            return (Criteria) this;
        }

        public Criteria andExtractTypeIsNull() {
            addCriterion("extract_type is null");
            return (Criteria) this;
        }

        public Criteria andExtractTypeIsNotNull() {
            addCriterion("extract_type is not null");
            return (Criteria) this;
        }

        public Criteria andExtractTypeEqualTo(Integer value) {
            addCriterion("extract_type =", value, "extractType");
            return (Criteria) this;
        }

        public Criteria andExtractTypeNotEqualTo(Integer value) {
            addCriterion("extract_type <>", value, "extractType");
            return (Criteria) this;
        }

        public Criteria andExtractTypeGreaterThan(Integer value) {
            addCriterion("extract_type >", value, "extractType");
            return (Criteria) this;
        }

        public Criteria andExtractTypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("extract_type >=", value, "extractType");
            return (Criteria) this;
        }

        public Criteria andExtractTypeLessThan(Integer value) {
            addCriterion("extract_type <", value, "extractType");
            return (Criteria) this;
        }

        public Criteria andExtractTypeLessThanOrEqualTo(Integer value) {
            addCriterion("extract_type <=", value, "extractType");
            return (Criteria) this;
        }

        public Criteria andExtractTypeIn(List<Integer> values) {
            addCriterion("extract_type in", values, "extractType");
            return (Criteria) this;
        }

        public Criteria andExtractTypeNotIn(List<Integer> values) {
            addCriterion("extract_type not in", values, "extractType");
            return (Criteria) this;
        }

        public Criteria andExtractTypeBetween(Integer value1, Integer value2) {
            addCriterion("extract_type between", value1, value2, "extractType");
            return (Criteria) this;
        }

        public Criteria andExtractTypeNotBetween(Integer value1, Integer value2) {
            addCriterion("extract_type not between", value1, value2, "extractType");
            return (Criteria) this;
        }

        public Criteria andExtractAccountIsNull() {
            addCriterion("extract_account is null");
            return (Criteria) this;
        }

        public Criteria andExtractAccountIsNotNull() {
            addCriterion("extract_account is not null");
            return (Criteria) this;
        }

        public Criteria andExtractAccountEqualTo(String value) {
            addCriterion("extract_account =", value, "extractAccount");
            return (Criteria) this;
        }

        public Criteria andExtractAccountNotEqualTo(String value) {
            addCriterion("extract_account <>", value, "extractAccount");
            return (Criteria) this;
        }

        public Criteria andExtractAccountGreaterThan(String value) {
            addCriterion("extract_account >", value, "extractAccount");
            return (Criteria) this;
        }

        public Criteria andExtractAccountGreaterThanOrEqualTo(String value) {
            addCriterion("extract_account >=", value, "extractAccount");
            return (Criteria) this;
        }

        public Criteria andExtractAccountLessThan(String value) {
            addCriterion("extract_account <", value, "extractAccount");
            return (Criteria) this;
        }

        public Criteria andExtractAccountLessThanOrEqualTo(String value) {
            addCriterion("extract_account <=", value, "extractAccount");
            return (Criteria) this;
        }

        public Criteria andExtractAccountLike(String value) {
            addCriterion("extract_account like", value, "extractAccount");
            return (Criteria) this;
        }

        public Criteria andExtractAccountNotLike(String value) {
            addCriterion("extract_account not like", value, "extractAccount");
            return (Criteria) this;
        }

        public Criteria andExtractAccountIn(List<String> values) {
            addCriterion("extract_account in", values, "extractAccount");
            return (Criteria) this;
        }

        public Criteria andExtractAccountNotIn(List<String> values) {
            addCriterion("extract_account not in", values, "extractAccount");
            return (Criteria) this;
        }

        public Criteria andExtractAccountBetween(String value1, String value2) {
            addCriterion("extract_account between", value1, value2, "extractAccount");
            return (Criteria) this;
        }

        public Criteria andExtractAccountNotBetween(String value1, String value2) {
            addCriterion("extract_account not between", value1, value2, "extractAccount");
            return (Criteria) this;
        }

        public Criteria andExtractAccountNameIsNull() {
            addCriterion("extract_account_name is null");
            return (Criteria) this;
        }

        public Criteria andExtractAccountNameIsNotNull() {
            addCriterion("extract_account_name is not null");
            return (Criteria) this;
        }

        public Criteria andExtractAccountNameEqualTo(String value) {
            addCriterion("extract_account_name =", value, "extractAccountName");
            return (Criteria) this;
        }

        public Criteria andExtractAccountNameNotEqualTo(String value) {
            addCriterion("extract_account_name <>", value, "extractAccountName");
            return (Criteria) this;
        }

        public Criteria andExtractAccountNameGreaterThan(String value) {
            addCriterion("extract_account_name >", value, "extractAccountName");
            return (Criteria) this;
        }

        public Criteria andExtractAccountNameGreaterThanOrEqualTo(String value) {
            addCriterion("extract_account_name >=", value, "extractAccountName");
            return (Criteria) this;
        }

        public Criteria andExtractAccountNameLessThan(String value) {
            addCriterion("extract_account_name <", value, "extractAccountName");
            return (Criteria) this;
        }

        public Criteria andExtractAccountNameLessThanOrEqualTo(String value) {
            addCriterion("extract_account_name <=", value, "extractAccountName");
            return (Criteria) this;
        }

        public Criteria andExtractAccountNameLike(String value) {
            addCriterion("extract_account_name like", value, "extractAccountName");
            return (Criteria) this;
        }

        public Criteria andExtractAccountNameNotLike(String value) {
            addCriterion("extract_account_name not like", value, "extractAccountName");
            return (Criteria) this;
        }

        public Criteria andExtractAccountNameIn(List<String> values) {
            addCriterion("extract_account_name in", values, "extractAccountName");
            return (Criteria) this;
        }

        public Criteria andExtractAccountNameNotIn(List<String> values) {
            addCriterion("extract_account_name not in", values, "extractAccountName");
            return (Criteria) this;
        }

        public Criteria andExtractAccountNameBetween(String value1, String value2) {
            addCriterion("extract_account_name between", value1, value2, "extractAccountName");
            return (Criteria) this;
        }

        public Criteria andExtractAccountNameNotBetween(String value1, String value2) {
            addCriterion("extract_account_name not between", value1, value2, "extractAccountName");
            return (Criteria) this;
        }

        public Criteria andExtractUserTypeIsNull() {
            addCriterion("extract_user_type is null");
            return (Criteria) this;
        }

        public Criteria andExtractUserTypeIsNotNull() {
            addCriterion("extract_user_type is not null");
            return (Criteria) this;
        }

        public Criteria andExtractUserTypeEqualTo(Integer value) {
            addCriterion("extract_user_type =", value, "extractUserType");
            return (Criteria) this;
        }

        public Criteria andExtractUserTypeNotEqualTo(Integer value) {
            addCriterion("extract_user_type <>", value, "extractUserType");
            return (Criteria) this;
        }

        public Criteria andExtractUserTypeGreaterThan(Integer value) {
            addCriterion("extract_user_type >", value, "extractUserType");
            return (Criteria) this;
        }

        public Criteria andExtractUserTypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("extract_user_type >=", value, "extractUserType");
            return (Criteria) this;
        }

        public Criteria andExtractUserTypeLessThan(Integer value) {
            addCriterion("extract_user_type <", value, "extractUserType");
            return (Criteria) this;
        }

        public Criteria andExtractUserTypeLessThanOrEqualTo(Integer value) {
            addCriterion("extract_user_type <=", value, "extractUserType");
            return (Criteria) this;
        }

        public Criteria andExtractUserTypeIn(List<Integer> values) {
            addCriterion("extract_user_type in", values, "extractUserType");
            return (Criteria) this;
        }

        public Criteria andExtractUserTypeNotIn(List<Integer> values) {
            addCriterion("extract_user_type not in", values, "extractUserType");
            return (Criteria) this;
        }

        public Criteria andExtractUserTypeBetween(Integer value1, Integer value2) {
            addCriterion("extract_user_type between", value1, value2, "extractUserType");
            return (Criteria) this;
        }

        public Criteria andExtractUserTypeNotBetween(Integer value1, Integer value2) {
            addCriterion("extract_user_type not between", value1, value2, "extractUserType");
            return (Criteria) this;
        }

        public Criteria andExtractUserBalanceIsNull() {
            addCriterion("extract_user_balance is null");
            return (Criteria) this;
        }

        public Criteria andExtractUserBalanceIsNotNull() {
            addCriterion("extract_user_balance is not null");
            return (Criteria) this;
        }

        public Criteria andExtractUserBalanceEqualTo(Integer value) {
            addCriterion("extract_user_balance =", value, "extractUserBalance");
            return (Criteria) this;
        }

        public Criteria andExtractUserBalanceNotEqualTo(Integer value) {
            addCriterion("extract_user_balance <>", value, "extractUserBalance");
            return (Criteria) this;
        }

        public Criteria andExtractUserBalanceGreaterThan(Integer value) {
            addCriterion("extract_user_balance >", value, "extractUserBalance");
            return (Criteria) this;
        }

        public Criteria andExtractUserBalanceGreaterThanOrEqualTo(Integer value) {
            addCriterion("extract_user_balance >=", value, "extractUserBalance");
            return (Criteria) this;
        }

        public Criteria andExtractUserBalanceLessThan(Integer value) {
            addCriterion("extract_user_balance <", value, "extractUserBalance");
            return (Criteria) this;
        }

        public Criteria andExtractUserBalanceLessThanOrEqualTo(Integer value) {
            addCriterion("extract_user_balance <=", value, "extractUserBalance");
            return (Criteria) this;
        }

        public Criteria andExtractUserBalanceIn(List<Integer> values) {
            addCriterion("extract_user_balance in", values, "extractUserBalance");
            return (Criteria) this;
        }

        public Criteria andExtractUserBalanceNotIn(List<Integer> values) {
            addCriterion("extract_user_balance not in", values, "extractUserBalance");
            return (Criteria) this;
        }

        public Criteria andExtractUserBalanceBetween(Integer value1, Integer value2) {
            addCriterion("extract_user_balance between", value1, value2, "extractUserBalance");
            return (Criteria) this;
        }

        public Criteria andExtractUserBalanceNotBetween(Integer value1, Integer value2) {
            addCriterion("extract_user_balance not between", value1, value2, "extractUserBalance");
            return (Criteria) this;
        }

        public Criteria andExtractUserPhoneIsNull() {
            addCriterion("extract_user_phone is null");
            return (Criteria) this;
        }

        public Criteria andExtractUserPhoneIsNotNull() {
            addCriterion("extract_user_phone is not null");
            return (Criteria) this;
        }

        public Criteria andExtractUserPhoneEqualTo(String value) {
            addCriterion("extract_user_phone =", value, "extractUserPhone");
            return (Criteria) this;
        }

        public Criteria andExtractUserPhoneNotEqualTo(String value) {
            addCriterion("extract_user_phone <>", value, "extractUserPhone");
            return (Criteria) this;
        }

        public Criteria andExtractUserPhoneGreaterThan(String value) {
            addCriterion("extract_user_phone >", value, "extractUserPhone");
            return (Criteria) this;
        }

        public Criteria andExtractUserPhoneGreaterThanOrEqualTo(String value) {
            addCriterion("extract_user_phone >=", value, "extractUserPhone");
            return (Criteria) this;
        }

        public Criteria andExtractUserPhoneLessThan(String value) {
            addCriterion("extract_user_phone <", value, "extractUserPhone");
            return (Criteria) this;
        }

        public Criteria andExtractUserPhoneLessThanOrEqualTo(String value) {
            addCriterion("extract_user_phone <=", value, "extractUserPhone");
            return (Criteria) this;
        }

        public Criteria andExtractUserPhoneLike(String value) {
            addCriterion("extract_user_phone like", value, "extractUserPhone");
            return (Criteria) this;
        }

        public Criteria andExtractUserPhoneNotLike(String value) {
            addCriterion("extract_user_phone not like", value, "extractUserPhone");
            return (Criteria) this;
        }

        public Criteria andExtractUserPhoneIn(List<String> values) {
            addCriterion("extract_user_phone in", values, "extractUserPhone");
            return (Criteria) this;
        }

        public Criteria andExtractUserPhoneNotIn(List<String> values) {
            addCriterion("extract_user_phone not in", values, "extractUserPhone");
            return (Criteria) this;
        }

        public Criteria andExtractUserPhoneBetween(String value1, String value2) {
            addCriterion("extract_user_phone between", value1, value2, "extractUserPhone");
            return (Criteria) this;
        }

        public Criteria andExtractUserPhoneNotBetween(String value1, String value2) {
            addCriterion("extract_user_phone not between", value1, value2, "extractUserPhone");
            return (Criteria) this;
        }

        public Criteria andAdminIdIsNull() {
            addCriterion("admin_id is null");
            return (Criteria) this;
        }

        public Criteria andAdminIdIsNotNull() {
            addCriterion("admin_id is not null");
            return (Criteria) this;
        }

        public Criteria andAdminIdEqualTo(Integer value) {
            addCriterion("admin_id =", value, "adminId");
            return (Criteria) this;
        }

        public Criteria andAdminIdNotEqualTo(Integer value) {
            addCriterion("admin_id <>", value, "adminId");
            return (Criteria) this;
        }

        public Criteria andAdminIdGreaterThan(Integer value) {
            addCriterion("admin_id >", value, "adminId");
            return (Criteria) this;
        }

        public Criteria andAdminIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("admin_id >=", value, "adminId");
            return (Criteria) this;
        }

        public Criteria andAdminIdLessThan(Integer value) {
            addCriterion("admin_id <", value, "adminId");
            return (Criteria) this;
        }

        public Criteria andAdminIdLessThanOrEqualTo(Integer value) {
            addCriterion("admin_id <=", value, "adminId");
            return (Criteria) this;
        }

        public Criteria andAdminIdIn(List<Integer> values) {
            addCriterion("admin_id in", values, "adminId");
            return (Criteria) this;
        }

        public Criteria andAdminIdNotIn(List<Integer> values) {
            addCriterion("admin_id not in", values, "adminId");
            return (Criteria) this;
        }

        public Criteria andAdminIdBetween(Integer value1, Integer value2) {
            addCriterion("admin_id between", value1, value2, "adminId");
            return (Criteria) this;
        }

        public Criteria andAdminIdNotBetween(Integer value1, Integer value2) {
            addCriterion("admin_id not between", value1, value2, "adminId");
            return (Criteria) this;
        }

        public Criteria andExtractAuditTimeIsNull() {
            addCriterion("extract_audit_time is null");
            return (Criteria) this;
        }

        public Criteria andExtractAuditTimeIsNotNull() {
            addCriterion("extract_audit_time is not null");
            return (Criteria) this;
        }

        public Criteria andExtractAuditTimeEqualTo(Date value) {
            addCriterion("extract_audit_time =", value, "extractAuditTime");
            return (Criteria) this;
        }

        public Criteria andExtractAuditTimeNotEqualTo(Date value) {
            addCriterion("extract_audit_time <>", value, "extractAuditTime");
            return (Criteria) this;
        }

        public Criteria andExtractAuditTimeGreaterThan(Date value) {
            addCriterion("extract_audit_time >", value, "extractAuditTime");
            return (Criteria) this;
        }

        public Criteria andExtractAuditTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("extract_audit_time >=", value, "extractAuditTime");
            return (Criteria) this;
        }

        public Criteria andExtractAuditTimeLessThan(Date value) {
            addCriterion("extract_audit_time <", value, "extractAuditTime");
            return (Criteria) this;
        }

        public Criteria andExtractAuditTimeLessThanOrEqualTo(Date value) {
            addCriterion("extract_audit_time <=", value, "extractAuditTime");
            return (Criteria) this;
        }

        public Criteria andExtractAuditTimeIn(List<Date> values) {
            addCriterion("extract_audit_time in", values, "extractAuditTime");
            return (Criteria) this;
        }

        public Criteria andExtractAuditTimeNotIn(List<Date> values) {
            addCriterion("extract_audit_time not in", values, "extractAuditTime");
            return (Criteria) this;
        }

        public Criteria andExtractAuditTimeBetween(Date value1, Date value2) {
            addCriterion("extract_audit_time between", value1, value2, "extractAuditTime");
            return (Criteria) this;
        }

        public Criteria andExtractAuditTimeNotBetween(Date value1, Date value2) {
            addCriterion("extract_audit_time not between", value1, value2, "extractAuditTime");
            return (Criteria) this;
        }

        public Criteria andExtractAuditResultIsNull() {
            addCriterion("extract_audit_result is null");
            return (Criteria) this;
        }

        public Criteria andExtractAuditResultIsNotNull() {
            addCriterion("extract_audit_result is not null");
            return (Criteria) this;
        }

        public Criteria andExtractAuditResultEqualTo(Integer value) {
            addCriterion("extract_audit_result =", value, "extractAuditResult");
            return (Criteria) this;
        }

        public Criteria andExtractAuditResultNotEqualTo(Integer value) {
            addCriterion("extract_audit_result <>", value, "extractAuditResult");
            return (Criteria) this;
        }

        public Criteria andExtractAuditResultGreaterThan(Integer value) {
            addCriterion("extract_audit_result >", value, "extractAuditResult");
            return (Criteria) this;
        }

        public Criteria andExtractAuditResultGreaterThanOrEqualTo(Integer value) {
            addCriterion("extract_audit_result >=", value, "extractAuditResult");
            return (Criteria) this;
        }

        public Criteria andExtractAuditResultLessThan(Integer value) {
            addCriterion("extract_audit_result <", value, "extractAuditResult");
            return (Criteria) this;
        }

        public Criteria andExtractAuditResultLessThanOrEqualTo(Integer value) {
            addCriterion("extract_audit_result <=", value, "extractAuditResult");
            return (Criteria) this;
        }

        public Criteria andExtractAuditResultIn(List<Integer> values) {
            addCriterion("extract_audit_result in", values, "extractAuditResult");
            return (Criteria) this;
        }

        public Criteria andExtractAuditResultNotIn(List<Integer> values) {
            addCriterion("extract_audit_result not in", values, "extractAuditResult");
            return (Criteria) this;
        }

        public Criteria andExtractAuditResultBetween(Integer value1, Integer value2) {
            addCriterion("extract_audit_result between", value1, value2, "extractAuditResult");
            return (Criteria) this;
        }

        public Criteria andExtractAuditResultNotBetween(Integer value1, Integer value2) {
            addCriterion("extract_audit_result not between", value1, value2, "extractAuditResult");
            return (Criteria) this;
        }

        public Criteria andExtractStateIsNull() {
            addCriterion("extract_state is null");
            return (Criteria) this;
        }

        public Criteria andExtractStateIsNotNull() {
            addCriterion("extract_state is not null");
            return (Criteria) this;
        }

        public Criteria andExtractStateEqualTo(Integer value) {
            addCriterion("extract_state =", value, "extractState");
            return (Criteria) this;
        }

        public Criteria andExtractStateNotEqualTo(Integer value) {
            addCriterion("extract_state <>", value, "extractState");
            return (Criteria) this;
        }

        public Criteria andExtractStateGreaterThan(Integer value) {
            addCriterion("extract_state >", value, "extractState");
            return (Criteria) this;
        }

        public Criteria andExtractStateGreaterThanOrEqualTo(Integer value) {
            addCriterion("extract_state >=", value, "extractState");
            return (Criteria) this;
        }

        public Criteria andExtractStateLessThan(Integer value) {
            addCriterion("extract_state <", value, "extractState");
            return (Criteria) this;
        }

        public Criteria andExtractStateLessThanOrEqualTo(Integer value) {
            addCriterion("extract_state <=", value, "extractState");
            return (Criteria) this;
        }

        public Criteria andExtractStateIn(List<Integer> values) {
            addCriterion("extract_state in", values, "extractState");
            return (Criteria) this;
        }

        public Criteria andExtractStateNotIn(List<Integer> values) {
            addCriterion("extract_state not in", values, "extractState");
            return (Criteria) this;
        }

        public Criteria andExtractStateBetween(Integer value1, Integer value2) {
            addCriterion("extract_state between", value1, value2, "extractState");
            return (Criteria) this;
        }

        public Criteria andExtractStateNotBetween(Integer value1, Integer value2) {
            addCriterion("extract_state not between", value1, value2, "extractState");
            return (Criteria) this;
        }

        public Criteria andExtractPayTimeIsNull() {
            addCriterion("extract_pay_time is null");
            return (Criteria) this;
        }

        public Criteria andExtractPayTimeIsNotNull() {
            addCriterion("extract_pay_time is not null");
            return (Criteria) this;
        }

        public Criteria andExtractPayTimeEqualTo(Date value) {
            addCriterion("extract_pay_time =", value, "extractPayTime");
            return (Criteria) this;
        }

        public Criteria andExtractPayTimeNotEqualTo(Date value) {
            addCriterion("extract_pay_time <>", value, "extractPayTime");
            return (Criteria) this;
        }

        public Criteria andExtractPayTimeGreaterThan(Date value) {
            addCriterion("extract_pay_time >", value, "extractPayTime");
            return (Criteria) this;
        }

        public Criteria andExtractPayTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("extract_pay_time >=", value, "extractPayTime");
            return (Criteria) this;
        }

        public Criteria andExtractPayTimeLessThan(Date value) {
            addCriterion("extract_pay_time <", value, "extractPayTime");
            return (Criteria) this;
        }

        public Criteria andExtractPayTimeLessThanOrEqualTo(Date value) {
            addCriterion("extract_pay_time <=", value, "extractPayTime");
            return (Criteria) this;
        }

        public Criteria andExtractPayTimeIn(List<Date> values) {
            addCriterion("extract_pay_time in", values, "extractPayTime");
            return (Criteria) this;
        }

        public Criteria andExtractPayTimeNotIn(List<Date> values) {
            addCriterion("extract_pay_time not in", values, "extractPayTime");
            return (Criteria) this;
        }

        public Criteria andExtractPayTimeBetween(Date value1, Date value2) {
            addCriterion("extract_pay_time between", value1, value2, "extractPayTime");
            return (Criteria) this;
        }

        public Criteria andExtractPayTimeNotBetween(Date value1, Date value2) {
            addCriterion("extract_pay_time not between", value1, value2, "extractPayTime");
            return (Criteria) this;
        }

        public Criteria andExtractPayCodeIsNull() {
            addCriterion("extract_pay_code is null");
            return (Criteria) this;
        }

        public Criteria andExtractPayCodeIsNotNull() {
            addCriterion("extract_pay_code is not null");
            return (Criteria) this;
        }

        public Criteria andExtractPayCodeEqualTo(String value) {
            addCriterion("extract_pay_code =", value, "extractPayCode");
            return (Criteria) this;
        }

        public Criteria andExtractPayCodeNotEqualTo(String value) {
            addCriterion("extract_pay_code <>", value, "extractPayCode");
            return (Criteria) this;
        }

        public Criteria andExtractPayCodeGreaterThan(String value) {
            addCriterion("extract_pay_code >", value, "extractPayCode");
            return (Criteria) this;
        }

        public Criteria andExtractPayCodeGreaterThanOrEqualTo(String value) {
            addCriterion("extract_pay_code >=", value, "extractPayCode");
            return (Criteria) this;
        }

        public Criteria andExtractPayCodeLessThan(String value) {
            addCriterion("extract_pay_code <", value, "extractPayCode");
            return (Criteria) this;
        }

        public Criteria andExtractPayCodeLessThanOrEqualTo(String value) {
            addCriterion("extract_pay_code <=", value, "extractPayCode");
            return (Criteria) this;
        }

        public Criteria andExtractPayCodeLike(String value) {
            addCriterion("extract_pay_code like", value, "extractPayCode");
            return (Criteria) this;
        }

        public Criteria andExtractPayCodeNotLike(String value) {
            addCriterion("extract_pay_code not like", value, "extractPayCode");
            return (Criteria) this;
        }

        public Criteria andExtractPayCodeIn(List<String> values) {
            addCriterion("extract_pay_code in", values, "extractPayCode");
            return (Criteria) this;
        }

        public Criteria andExtractPayCodeNotIn(List<String> values) {
            addCriterion("extract_pay_code not in", values, "extractPayCode");
            return (Criteria) this;
        }

        public Criteria andExtractPayCodeBetween(String value1, String value2) {
            addCriterion("extract_pay_code between", value1, value2, "extractPayCode");
            return (Criteria) this;
        }

        public Criteria andExtractPayCodeNotBetween(String value1, String value2) {
            addCriterion("extract_pay_code not between", value1, value2, "extractPayCode");
            return (Criteria) this;
        }

        public Criteria andExtractRemarkIsNull() {
            addCriterion("extract_remark is null");
            return (Criteria) this;
        }

        public Criteria andExtractRemarkIsNotNull() {
            addCriterion("extract_remark is not null");
            return (Criteria) this;
        }

        public Criteria andExtractRemarkEqualTo(String value) {
            addCriterion("extract_remark =", value, "extractRemark");
            return (Criteria) this;
        }

        public Criteria andExtractRemarkNotEqualTo(String value) {
            addCriterion("extract_remark <>", value, "extractRemark");
            return (Criteria) this;
        }

        public Criteria andExtractRemarkGreaterThan(String value) {
            addCriterion("extract_remark >", value, "extractRemark");
            return (Criteria) this;
        }

        public Criteria andExtractRemarkGreaterThanOrEqualTo(String value) {
            addCriterion("extract_remark >=", value, "extractRemark");
            return (Criteria) this;
        }

        public Criteria andExtractRemarkLessThan(String value) {
            addCriterion("extract_remark <", value, "extractRemark");
            return (Criteria) this;
        }

        public Criteria andExtractRemarkLessThanOrEqualTo(String value) {
            addCriterion("extract_remark <=", value, "extractRemark");
            return (Criteria) this;
        }

        public Criteria andExtractRemarkLike(String value) {
            addCriterion("extract_remark like", value, "extractRemark");
            return (Criteria) this;
        }

        public Criteria andExtractRemarkNotLike(String value) {
            addCriterion("extract_remark not like", value, "extractRemark");
            return (Criteria) this;
        }

        public Criteria andExtractRemarkIn(List<String> values) {
            addCriterion("extract_remark in", values, "extractRemark");
            return (Criteria) this;
        }

        public Criteria andExtractRemarkNotIn(List<String> values) {
            addCriterion("extract_remark not in", values, "extractRemark");
            return (Criteria) this;
        }

        public Criteria andExtractRemarkBetween(String value1, String value2) {
            addCriterion("extract_remark between", value1, value2, "extractRemark");
            return (Criteria) this;
        }

        public Criteria andExtractRemarkNotBetween(String value1, String value2) {
            addCriterion("extract_remark not between", value1, value2, "extractRemark");
            return (Criteria) this;
        }

        public Criteria andExtractCreateTimeIsNull() {
            addCriterion("extract_create_time is null");
            return (Criteria) this;
        }

        public Criteria andExtractCreateTimeIsNotNull() {
            addCriterion("extract_create_time is not null");
            return (Criteria) this;
        }

        public Criteria andExtractCreateTimeEqualTo(Date value) {
            addCriterion("extract_create_time =", value, "extractCreateTime");
            return (Criteria) this;
        }

        public Criteria andExtractCreateTimeNotEqualTo(Date value) {
            addCriterion("extract_create_time <>", value, "extractCreateTime");
            return (Criteria) this;
        }

        public Criteria andExtractCreateTimeGreaterThan(Date value) {
            addCriterion("extract_create_time >", value, "extractCreateTime");
            return (Criteria) this;
        }

        public Criteria andExtractCreateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("extract_create_time >=", value, "extractCreateTime");
            return (Criteria) this;
        }

        public Criteria andExtractCreateTimeLessThan(Date value) {
            addCriterion("extract_create_time <", value, "extractCreateTime");
            return (Criteria) this;
        }

        public Criteria andExtractCreateTimeLessThanOrEqualTo(Date value) {
            addCriterion("extract_create_time <=", value, "extractCreateTime");
            return (Criteria) this;
        }

        public Criteria andExtractCreateTimeIn(List<Date> values) {
            addCriterion("extract_create_time in", values, "extractCreateTime");
            return (Criteria) this;
        }

        public Criteria andExtractCreateTimeNotIn(List<Date> values) {
            addCriterion("extract_create_time not in", values, "extractCreateTime");
            return (Criteria) this;
        }

        public Criteria andExtractCreateTimeBetween(Date value1, Date value2) {
            addCriterion("extract_create_time between", value1, value2, "extractCreateTime");
            return (Criteria) this;
        }

        public Criteria andExtractCreateTimeNotBetween(Date value1, Date value2) {
            addCriterion("extract_create_time not between", value1, value2, "extractCreateTime");
            return (Criteria) this;
        }

        public Criteria andExtractModifyTimeIsNull() {
            addCriterion("extract_modify_time is null");
            return (Criteria) this;
        }

        public Criteria andExtractModifyTimeIsNotNull() {
            addCriterion("extract_modify_time is not null");
            return (Criteria) this;
        }

        public Criteria andExtractModifyTimeEqualTo(Date value) {
            addCriterion("extract_modify_time =", value, "extractModifyTime");
            return (Criteria) this;
        }

        public Criteria andExtractModifyTimeNotEqualTo(Date value) {
            addCriterion("extract_modify_time <>", value, "extractModifyTime");
            return (Criteria) this;
        }

        public Criteria andExtractModifyTimeGreaterThan(Date value) {
            addCriterion("extract_modify_time >", value, "extractModifyTime");
            return (Criteria) this;
        }

        public Criteria andExtractModifyTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("extract_modify_time >=", value, "extractModifyTime");
            return (Criteria) this;
        }

        public Criteria andExtractModifyTimeLessThan(Date value) {
            addCriterion("extract_modify_time <", value, "extractModifyTime");
            return (Criteria) this;
        }

        public Criteria andExtractModifyTimeLessThanOrEqualTo(Date value) {
            addCriterion("extract_modify_time <=", value, "extractModifyTime");
            return (Criteria) this;
        }

        public Criteria andExtractModifyTimeIn(List<Date> values) {
            addCriterion("extract_modify_time in", values, "extractModifyTime");
            return (Criteria) this;
        }

        public Criteria andExtractModifyTimeNotIn(List<Date> values) {
            addCriterion("extract_modify_time not in", values, "extractModifyTime");
            return (Criteria) this;
        }

        public Criteria andExtractModifyTimeBetween(Date value1, Date value2) {
            addCriterion("extract_modify_time between", value1, value2, "extractModifyTime");
            return (Criteria) this;
        }

        public Criteria andExtractModifyTimeNotBetween(Date value1, Date value2) {
            addCriterion("extract_modify_time not between", value1, value2, "extractModifyTime");
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