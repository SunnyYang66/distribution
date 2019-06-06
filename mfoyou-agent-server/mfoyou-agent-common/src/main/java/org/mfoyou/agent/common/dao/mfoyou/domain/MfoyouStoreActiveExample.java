package org.mfoyou.agent.common.dao.mfoyou.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class MfoyouStoreActiveExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    protected Integer limitStart;

    protected Integer limitEnd;

    public MfoyouStoreActiveExample() {
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

        public Criteria andStoreIdIsNull() {
            addCriterion("store_id is null");
            return (Criteria) this;
        }

        public Criteria andStoreIdIsNotNull() {
            addCriterion("store_id is not null");
            return (Criteria) this;
        }

        public Criteria andStoreIdEqualTo(Integer value) {
            addCriterion("store_id =", value, "storeId");
            return (Criteria) this;
        }

        public Criteria andStoreIdNotEqualTo(Integer value) {
            addCriterion("store_id <>", value, "storeId");
            return (Criteria) this;
        }

        public Criteria andStoreIdGreaterThan(Integer value) {
            addCriterion("store_id >", value, "storeId");
            return (Criteria) this;
        }

        public Criteria andStoreIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("store_id >=", value, "storeId");
            return (Criteria) this;
        }

        public Criteria andStoreIdLessThan(Integer value) {
            addCriterion("store_id <", value, "storeId");
            return (Criteria) this;
        }

        public Criteria andStoreIdLessThanOrEqualTo(Integer value) {
            addCriterion("store_id <=", value, "storeId");
            return (Criteria) this;
        }

        public Criteria andStoreIdIn(List<Integer> values) {
            addCriterion("store_id in", values, "storeId");
            return (Criteria) this;
        }

        public Criteria andStoreIdNotIn(List<Integer> values) {
            addCriterion("store_id not in", values, "storeId");
            return (Criteria) this;
        }

        public Criteria andStoreIdBetween(Integer value1, Integer value2) {
            addCriterion("store_id between", value1, value2, "storeId");
            return (Criteria) this;
        }

        public Criteria andStoreIdNotBetween(Integer value1, Integer value2) {
            addCriterion("store_id not between", value1, value2, "storeId");
            return (Criteria) this;
        }

        public Criteria andNewUserActiveStateIsNull() {
            addCriterion("new_user_active_state is null");
            return (Criteria) this;
        }

        public Criteria andNewUserActiveStateIsNotNull() {
            addCriterion("new_user_active_state is not null");
            return (Criteria) this;
        }

        public Criteria andNewUserActiveStateEqualTo(Integer value) {
            addCriterion("new_user_active_state =", value, "newUserActiveState");
            return (Criteria) this;
        }

        public Criteria andNewUserActiveStateNotEqualTo(Integer value) {
            addCriterion("new_user_active_state <>", value, "newUserActiveState");
            return (Criteria) this;
        }

        public Criteria andNewUserActiveStateGreaterThan(Integer value) {
            addCriterion("new_user_active_state >", value, "newUserActiveState");
            return (Criteria) this;
        }

        public Criteria andNewUserActiveStateGreaterThanOrEqualTo(Integer value) {
            addCriterion("new_user_active_state >=", value, "newUserActiveState");
            return (Criteria) this;
        }

        public Criteria andNewUserActiveStateLessThan(Integer value) {
            addCriterion("new_user_active_state <", value, "newUserActiveState");
            return (Criteria) this;
        }

        public Criteria andNewUserActiveStateLessThanOrEqualTo(Integer value) {
            addCriterion("new_user_active_state <=", value, "newUserActiveState");
            return (Criteria) this;
        }

        public Criteria andNewUserActiveStateIn(List<Integer> values) {
            addCriterion("new_user_active_state in", values, "newUserActiveState");
            return (Criteria) this;
        }

        public Criteria andNewUserActiveStateNotIn(List<Integer> values) {
            addCriterion("new_user_active_state not in", values, "newUserActiveState");
            return (Criteria) this;
        }

        public Criteria andNewUserActiveStateBetween(Integer value1, Integer value2) {
            addCriterion("new_user_active_state between", value1, value2, "newUserActiveState");
            return (Criteria) this;
        }

        public Criteria andNewUserActiveStateNotBetween(Integer value1, Integer value2) {
            addCriterion("new_user_active_state not between", value1, value2, "newUserActiveState");
            return (Criteria) this;
        }

        public Criteria andNewUserReductionAmountIsNull() {
            addCriterion("new_user_reduction_amount is null");
            return (Criteria) this;
        }

        public Criteria andNewUserReductionAmountIsNotNull() {
            addCriterion("new_user_reduction_amount is not null");
            return (Criteria) this;
        }

        public Criteria andNewUserReductionAmountEqualTo(Integer value) {
            addCriterion("new_user_reduction_amount =", value, "newUserReductionAmount");
            return (Criteria) this;
        }

        public Criteria andNewUserReductionAmountNotEqualTo(Integer value) {
            addCriterion("new_user_reduction_amount <>", value, "newUserReductionAmount");
            return (Criteria) this;
        }

        public Criteria andNewUserReductionAmountGreaterThan(Integer value) {
            addCriterion("new_user_reduction_amount >", value, "newUserReductionAmount");
            return (Criteria) this;
        }

        public Criteria andNewUserReductionAmountGreaterThanOrEqualTo(Integer value) {
            addCriterion("new_user_reduction_amount >=", value, "newUserReductionAmount");
            return (Criteria) this;
        }

        public Criteria andNewUserReductionAmountLessThan(Integer value) {
            addCriterion("new_user_reduction_amount <", value, "newUserReductionAmount");
            return (Criteria) this;
        }

        public Criteria andNewUserReductionAmountLessThanOrEqualTo(Integer value) {
            addCriterion("new_user_reduction_amount <=", value, "newUserReductionAmount");
            return (Criteria) this;
        }

        public Criteria andNewUserReductionAmountIn(List<Integer> values) {
            addCriterion("new_user_reduction_amount in", values, "newUserReductionAmount");
            return (Criteria) this;
        }

        public Criteria andNewUserReductionAmountNotIn(List<Integer> values) {
            addCriterion("new_user_reduction_amount not in", values, "newUserReductionAmount");
            return (Criteria) this;
        }

        public Criteria andNewUserReductionAmountBetween(Integer value1, Integer value2) {
            addCriterion("new_user_reduction_amount between", value1, value2, "newUserReductionAmount");
            return (Criteria) this;
        }

        public Criteria andNewUserReductionAmountNotBetween(Integer value1, Integer value2) {
            addCriterion("new_user_reduction_amount not between", value1, value2, "newUserReductionAmount");
            return (Criteria) this;
        }

        public Criteria andFullcutActiveStateIsNull() {
            addCriterion("fullcut_active_state is null");
            return (Criteria) this;
        }

        public Criteria andFullcutActiveStateIsNotNull() {
            addCriterion("fullcut_active_state is not null");
            return (Criteria) this;
        }

        public Criteria andFullcutActiveStateEqualTo(Integer value) {
            addCriterion("fullcut_active_state =", value, "fullcutActiveState");
            return (Criteria) this;
        }

        public Criteria andFullcutActiveStateNotEqualTo(Integer value) {
            addCriterion("fullcut_active_state <>", value, "fullcutActiveState");
            return (Criteria) this;
        }

        public Criteria andFullcutActiveStateGreaterThan(Integer value) {
            addCriterion("fullcut_active_state >", value, "fullcutActiveState");
            return (Criteria) this;
        }

        public Criteria andFullcutActiveStateGreaterThanOrEqualTo(Integer value) {
            addCriterion("fullcut_active_state >=", value, "fullcutActiveState");
            return (Criteria) this;
        }

        public Criteria andFullcutActiveStateLessThan(Integer value) {
            addCriterion("fullcut_active_state <", value, "fullcutActiveState");
            return (Criteria) this;
        }

        public Criteria andFullcutActiveStateLessThanOrEqualTo(Integer value) {
            addCriterion("fullcut_active_state <=", value, "fullcutActiveState");
            return (Criteria) this;
        }

        public Criteria andFullcutActiveStateIn(List<Integer> values) {
            addCriterion("fullcut_active_state in", values, "fullcutActiveState");
            return (Criteria) this;
        }

        public Criteria andFullcutActiveStateNotIn(List<Integer> values) {
            addCriterion("fullcut_active_state not in", values, "fullcutActiveState");
            return (Criteria) this;
        }

        public Criteria andFullcutActiveStateBetween(Integer value1, Integer value2) {
            addCriterion("fullcut_active_state between", value1, value2, "fullcutActiveState");
            return (Criteria) this;
        }

        public Criteria andFullcutActiveStateNotBetween(Integer value1, Integer value2) {
            addCriterion("fullcut_active_state not between", value1, value2, "fullcutActiveState");
            return (Criteria) this;
        }

        public Criteria andFullcutAmountDescribeIsNull() {
            addCriterion("fullcut_amount_describe is null");
            return (Criteria) this;
        }

        public Criteria andFullcutAmountDescribeIsNotNull() {
            addCriterion("fullcut_amount_describe is not null");
            return (Criteria) this;
        }

        public Criteria andFullcutAmountDescribeEqualTo(String value) {
            addCriterion("fullcut_amount_describe =", value, "fullcutAmountDescribe");
            return (Criteria) this;
        }

        public Criteria andFullcutAmountDescribeNotEqualTo(String value) {
            addCriterion("fullcut_amount_describe <>", value, "fullcutAmountDescribe");
            return (Criteria) this;
        }

        public Criteria andFullcutAmountDescribeGreaterThan(String value) {
            addCriterion("fullcut_amount_describe >", value, "fullcutAmountDescribe");
            return (Criteria) this;
        }

        public Criteria andFullcutAmountDescribeGreaterThanOrEqualTo(String value) {
            addCriterion("fullcut_amount_describe >=", value, "fullcutAmountDescribe");
            return (Criteria) this;
        }

        public Criteria andFullcutAmountDescribeLessThan(String value) {
            addCriterion("fullcut_amount_describe <", value, "fullcutAmountDescribe");
            return (Criteria) this;
        }

        public Criteria andFullcutAmountDescribeLessThanOrEqualTo(String value) {
            addCriterion("fullcut_amount_describe <=", value, "fullcutAmountDescribe");
            return (Criteria) this;
        }

        public Criteria andFullcutAmountDescribeLike(String value) {
            addCriterion("fullcut_amount_describe like", value, "fullcutAmountDescribe");
            return (Criteria) this;
        }

        public Criteria andFullcutAmountDescribeNotLike(String value) {
            addCriterion("fullcut_amount_describe not like", value, "fullcutAmountDescribe");
            return (Criteria) this;
        }

        public Criteria andFullcutAmountDescribeIn(List<String> values) {
            addCriterion("fullcut_amount_describe in", values, "fullcutAmountDescribe");
            return (Criteria) this;
        }

        public Criteria andFullcutAmountDescribeNotIn(List<String> values) {
            addCriterion("fullcut_amount_describe not in", values, "fullcutAmountDescribe");
            return (Criteria) this;
        }

        public Criteria andFullcutAmountDescribeBetween(String value1, String value2) {
            addCriterion("fullcut_amount_describe between", value1, value2, "fullcutAmountDescribe");
            return (Criteria) this;
        }

        public Criteria andFullcutAmountDescribeNotBetween(String value1, String value2) {
            addCriterion("fullcut_amount_describe not between", value1, value2, "fullcutAmountDescribe");
            return (Criteria) this;
        }

        public Criteria andActiveGctIsNull() {
            addCriterion("active_gct is null");
            return (Criteria) this;
        }

        public Criteria andActiveGctIsNotNull() {
            addCriterion("active_gct is not null");
            return (Criteria) this;
        }

        public Criteria andActiveGctEqualTo(Date value) {
            addCriterion("active_gct =", value, "activeGct");
            return (Criteria) this;
        }

        public Criteria andActiveGctNotEqualTo(Date value) {
            addCriterion("active_gct <>", value, "activeGct");
            return (Criteria) this;
        }

        public Criteria andActiveGctGreaterThan(Date value) {
            addCriterion("active_gct >", value, "activeGct");
            return (Criteria) this;
        }

        public Criteria andActiveGctGreaterThanOrEqualTo(Date value) {
            addCriterion("active_gct >=", value, "activeGct");
            return (Criteria) this;
        }

        public Criteria andActiveGctLessThan(Date value) {
            addCriterion("active_gct <", value, "activeGct");
            return (Criteria) this;
        }

        public Criteria andActiveGctLessThanOrEqualTo(Date value) {
            addCriterion("active_gct <=", value, "activeGct");
            return (Criteria) this;
        }

        public Criteria andActiveGctIn(List<Date> values) {
            addCriterion("active_gct in", values, "activeGct");
            return (Criteria) this;
        }

        public Criteria andActiveGctNotIn(List<Date> values) {
            addCriterion("active_gct not in", values, "activeGct");
            return (Criteria) this;
        }

        public Criteria andActiveGctBetween(Date value1, Date value2) {
            addCriterion("active_gct between", value1, value2, "activeGct");
            return (Criteria) this;
        }

        public Criteria andActiveGctNotBetween(Date value1, Date value2) {
            addCriterion("active_gct not between", value1, value2, "activeGct");
            return (Criteria) this;
        }

        public Criteria andActiveGmtIsNull() {
            addCriterion("active_gmt is null");
            return (Criteria) this;
        }

        public Criteria andActiveGmtIsNotNull() {
            addCriterion("active_gmt is not null");
            return (Criteria) this;
        }

        public Criteria andActiveGmtEqualTo(Date value) {
            addCriterion("active_gmt =", value, "activeGmt");
            return (Criteria) this;
        }

        public Criteria andActiveGmtNotEqualTo(Date value) {
            addCriterion("active_gmt <>", value, "activeGmt");
            return (Criteria) this;
        }

        public Criteria andActiveGmtGreaterThan(Date value) {
            addCriterion("active_gmt >", value, "activeGmt");
            return (Criteria) this;
        }

        public Criteria andActiveGmtGreaterThanOrEqualTo(Date value) {
            addCriterion("active_gmt >=", value, "activeGmt");
            return (Criteria) this;
        }

        public Criteria andActiveGmtLessThan(Date value) {
            addCriterion("active_gmt <", value, "activeGmt");
            return (Criteria) this;
        }

        public Criteria andActiveGmtLessThanOrEqualTo(Date value) {
            addCriterion("active_gmt <=", value, "activeGmt");
            return (Criteria) this;
        }

        public Criteria andActiveGmtIn(List<Date> values) {
            addCriterion("active_gmt in", values, "activeGmt");
            return (Criteria) this;
        }

        public Criteria andActiveGmtNotIn(List<Date> values) {
            addCriterion("active_gmt not in", values, "activeGmt");
            return (Criteria) this;
        }

        public Criteria andActiveGmtBetween(Date value1, Date value2) {
            addCriterion("active_gmt between", value1, value2, "activeGmt");
            return (Criteria) this;
        }

        public Criteria andActiveGmtNotBetween(Date value1, Date value2) {
            addCriterion("active_gmt not between", value1, value2, "activeGmt");
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