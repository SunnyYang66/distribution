package org.mfoyou.agent.common.dao.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class HuawuOrderLogExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    protected Integer limitStart;

    protected Integer limitEnd;

    public HuawuOrderLogExample() {
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

        public Criteria andOrderLogIdIsNull() {
            addCriterion("order_log_id is null");
            return (Criteria) this;
        }

        public Criteria andOrderLogIdIsNotNull() {
            addCriterion("order_log_id is not null");
            return (Criteria) this;
        }

        public Criteria andOrderLogIdEqualTo(Integer value) {
            addCriterion("order_log_id =", value, "orderLogId");
            return (Criteria) this;
        }

        public Criteria andOrderLogIdNotEqualTo(Integer value) {
            addCriterion("order_log_id <>", value, "orderLogId");
            return (Criteria) this;
        }

        public Criteria andOrderLogIdGreaterThan(Integer value) {
            addCriterion("order_log_id >", value, "orderLogId");
            return (Criteria) this;
        }

        public Criteria andOrderLogIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("order_log_id >=", value, "orderLogId");
            return (Criteria) this;
        }

        public Criteria andOrderLogIdLessThan(Integer value) {
            addCriterion("order_log_id <", value, "orderLogId");
            return (Criteria) this;
        }

        public Criteria andOrderLogIdLessThanOrEqualTo(Integer value) {
            addCriterion("order_log_id <=", value, "orderLogId");
            return (Criteria) this;
        }

        public Criteria andOrderLogIdIn(List<Integer> values) {
            addCriterion("order_log_id in", values, "orderLogId");
            return (Criteria) this;
        }

        public Criteria andOrderLogIdNotIn(List<Integer> values) {
            addCriterion("order_log_id not in", values, "orderLogId");
            return (Criteria) this;
        }

        public Criteria andOrderLogIdBetween(Integer value1, Integer value2) {
            addCriterion("order_log_id between", value1, value2, "orderLogId");
            return (Criteria) this;
        }

        public Criteria andOrderLogIdNotBetween(Integer value1, Integer value2) {
            addCriterion("order_log_id not between", value1, value2, "orderLogId");
            return (Criteria) this;
        }

        public Criteria andServiceOrderIdIsNull() {
            addCriterion("service_order_id is null");
            return (Criteria) this;
        }

        public Criteria andServiceOrderIdIsNotNull() {
            addCriterion("service_order_id is not null");
            return (Criteria) this;
        }

        public Criteria andServiceOrderIdEqualTo(Integer value) {
            addCriterion("service_order_id =", value, "serviceOrderId");
            return (Criteria) this;
        }

        public Criteria andServiceOrderIdNotEqualTo(Integer value) {
            addCriterion("service_order_id <>", value, "serviceOrderId");
            return (Criteria) this;
        }

        public Criteria andServiceOrderIdGreaterThan(Integer value) {
            addCriterion("service_order_id >", value, "serviceOrderId");
            return (Criteria) this;
        }

        public Criteria andServiceOrderIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("service_order_id >=", value, "serviceOrderId");
            return (Criteria) this;
        }

        public Criteria andServiceOrderIdLessThan(Integer value) {
            addCriterion("service_order_id <", value, "serviceOrderId");
            return (Criteria) this;
        }

        public Criteria andServiceOrderIdLessThanOrEqualTo(Integer value) {
            addCriterion("service_order_id <=", value, "serviceOrderId");
            return (Criteria) this;
        }

        public Criteria andServiceOrderIdIn(List<Integer> values) {
            addCriterion("service_order_id in", values, "serviceOrderId");
            return (Criteria) this;
        }

        public Criteria andServiceOrderIdNotIn(List<Integer> values) {
            addCriterion("service_order_id not in", values, "serviceOrderId");
            return (Criteria) this;
        }

        public Criteria andServiceOrderIdBetween(Integer value1, Integer value2) {
            addCriterion("service_order_id between", value1, value2, "serviceOrderId");
            return (Criteria) this;
        }

        public Criteria andServiceOrderIdNotBetween(Integer value1, Integer value2) {
            addCriterion("service_order_id not between", value1, value2, "serviceOrderId");
            return (Criteria) this;
        }

        public Criteria andOrderTypeIsNull() {
            addCriterion("order_type is null");
            return (Criteria) this;
        }

        public Criteria andOrderTypeIsNotNull() {
            addCriterion("order_type is not null");
            return (Criteria) this;
        }

        public Criteria andOrderTypeEqualTo(Integer value) {
            addCriterion("order_type =", value, "orderType");
            return (Criteria) this;
        }

        public Criteria andOrderTypeNotEqualTo(Integer value) {
            addCriterion("order_type <>", value, "orderType");
            return (Criteria) this;
        }

        public Criteria andOrderTypeGreaterThan(Integer value) {
            addCriterion("order_type >", value, "orderType");
            return (Criteria) this;
        }

        public Criteria andOrderTypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("order_type >=", value, "orderType");
            return (Criteria) this;
        }

        public Criteria andOrderTypeLessThan(Integer value) {
            addCriterion("order_type <", value, "orderType");
            return (Criteria) this;
        }

        public Criteria andOrderTypeLessThanOrEqualTo(Integer value) {
            addCriterion("order_type <=", value, "orderType");
            return (Criteria) this;
        }

        public Criteria andOrderTypeIn(List<Integer> values) {
            addCriterion("order_type in", values, "orderType");
            return (Criteria) this;
        }

        public Criteria andOrderTypeNotIn(List<Integer> values) {
            addCriterion("order_type not in", values, "orderType");
            return (Criteria) this;
        }

        public Criteria andOrderTypeBetween(Integer value1, Integer value2) {
            addCriterion("order_type between", value1, value2, "orderType");
            return (Criteria) this;
        }

        public Criteria andOrderTypeNotBetween(Integer value1, Integer value2) {
            addCriterion("order_type not between", value1, value2, "orderType");
            return (Criteria) this;
        }

        public Criteria andOrderLogStateIsNull() {
            addCriterion("order_log_state is null");
            return (Criteria) this;
        }

        public Criteria andOrderLogStateIsNotNull() {
            addCriterion("order_log_state is not null");
            return (Criteria) this;
        }

        public Criteria andOrderLogStateEqualTo(Integer value) {
            addCriterion("order_log_state =", value, "orderLogState");
            return (Criteria) this;
        }

        public Criteria andOrderLogStateNotEqualTo(Integer value) {
            addCriterion("order_log_state <>", value, "orderLogState");
            return (Criteria) this;
        }

        public Criteria andOrderLogStateGreaterThan(Integer value) {
            addCriterion("order_log_state >", value, "orderLogState");
            return (Criteria) this;
        }

        public Criteria andOrderLogStateGreaterThanOrEqualTo(Integer value) {
            addCriterion("order_log_state >=", value, "orderLogState");
            return (Criteria) this;
        }

        public Criteria andOrderLogStateLessThan(Integer value) {
            addCriterion("order_log_state <", value, "orderLogState");
            return (Criteria) this;
        }

        public Criteria andOrderLogStateLessThanOrEqualTo(Integer value) {
            addCriterion("order_log_state <=", value, "orderLogState");
            return (Criteria) this;
        }

        public Criteria andOrderLogStateIn(List<Integer> values) {
            addCriterion("order_log_state in", values, "orderLogState");
            return (Criteria) this;
        }

        public Criteria andOrderLogStateNotIn(List<Integer> values) {
            addCriterion("order_log_state not in", values, "orderLogState");
            return (Criteria) this;
        }

        public Criteria andOrderLogStateBetween(Integer value1, Integer value2) {
            addCriterion("order_log_state between", value1, value2, "orderLogState");
            return (Criteria) this;
        }

        public Criteria andOrderLogStateNotBetween(Integer value1, Integer value2) {
            addCriterion("order_log_state not between", value1, value2, "orderLogState");
            return (Criteria) this;
        }

        public Criteria andOrderLogUserIdIsNull() {
            addCriterion("order_log_user_id is null");
            return (Criteria) this;
        }

        public Criteria andOrderLogUserIdIsNotNull() {
            addCriterion("order_log_user_id is not null");
            return (Criteria) this;
        }

        public Criteria andOrderLogUserIdEqualTo(Integer value) {
            addCriterion("order_log_user_id =", value, "orderLogUserId");
            return (Criteria) this;
        }

        public Criteria andOrderLogUserIdNotEqualTo(Integer value) {
            addCriterion("order_log_user_id <>", value, "orderLogUserId");
            return (Criteria) this;
        }

        public Criteria andOrderLogUserIdGreaterThan(Integer value) {
            addCriterion("order_log_user_id >", value, "orderLogUserId");
            return (Criteria) this;
        }

        public Criteria andOrderLogUserIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("order_log_user_id >=", value, "orderLogUserId");
            return (Criteria) this;
        }

        public Criteria andOrderLogUserIdLessThan(Integer value) {
            addCriterion("order_log_user_id <", value, "orderLogUserId");
            return (Criteria) this;
        }

        public Criteria andOrderLogUserIdLessThanOrEqualTo(Integer value) {
            addCriterion("order_log_user_id <=", value, "orderLogUserId");
            return (Criteria) this;
        }

        public Criteria andOrderLogUserIdIn(List<Integer> values) {
            addCriterion("order_log_user_id in", values, "orderLogUserId");
            return (Criteria) this;
        }

        public Criteria andOrderLogUserIdNotIn(List<Integer> values) {
            addCriterion("order_log_user_id not in", values, "orderLogUserId");
            return (Criteria) this;
        }

        public Criteria andOrderLogUserIdBetween(Integer value1, Integer value2) {
            addCriterion("order_log_user_id between", value1, value2, "orderLogUserId");
            return (Criteria) this;
        }

        public Criteria andOrderLogUserIdNotBetween(Integer value1, Integer value2) {
            addCriterion("order_log_user_id not between", value1, value2, "orderLogUserId");
            return (Criteria) this;
        }

        public Criteria andOrderLogTimeIsNull() {
            addCriterion("order_log_time is null");
            return (Criteria) this;
        }

        public Criteria andOrderLogTimeIsNotNull() {
            addCriterion("order_log_time is not null");
            return (Criteria) this;
        }

        public Criteria andOrderLogTimeEqualTo(Date value) {
            addCriterion("order_log_time =", value, "orderLogTime");
            return (Criteria) this;
        }

        public Criteria andOrderLogTimeNotEqualTo(Date value) {
            addCriterion("order_log_time <>", value, "orderLogTime");
            return (Criteria) this;
        }

        public Criteria andOrderLogTimeGreaterThan(Date value) {
            addCriterion("order_log_time >", value, "orderLogTime");
            return (Criteria) this;
        }

        public Criteria andOrderLogTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("order_log_time >=", value, "orderLogTime");
            return (Criteria) this;
        }

        public Criteria andOrderLogTimeLessThan(Date value) {
            addCriterion("order_log_time <", value, "orderLogTime");
            return (Criteria) this;
        }

        public Criteria andOrderLogTimeLessThanOrEqualTo(Date value) {
            addCriterion("order_log_time <=", value, "orderLogTime");
            return (Criteria) this;
        }

        public Criteria andOrderLogTimeIn(List<Date> values) {
            addCriterion("order_log_time in", values, "orderLogTime");
            return (Criteria) this;
        }

        public Criteria andOrderLogTimeNotIn(List<Date> values) {
            addCriterion("order_log_time not in", values, "orderLogTime");
            return (Criteria) this;
        }

        public Criteria andOrderLogTimeBetween(Date value1, Date value2) {
            addCriterion("order_log_time between", value1, value2, "orderLogTime");
            return (Criteria) this;
        }

        public Criteria andOrderLogTimeNotBetween(Date value1, Date value2) {
            addCriterion("order_log_time not between", value1, value2, "orderLogTime");
            return (Criteria) this;
        }

        public Criteria andOrderLogRemarkIsNull() {
            addCriterion("order_log_remark is null");
            return (Criteria) this;
        }

        public Criteria andOrderLogRemarkIsNotNull() {
            addCriterion("order_log_remark is not null");
            return (Criteria) this;
        }

        public Criteria andOrderLogRemarkEqualTo(String value) {
            addCriterion("order_log_remark =", value, "orderLogRemark");
            return (Criteria) this;
        }

        public Criteria andOrderLogRemarkNotEqualTo(String value) {
            addCriterion("order_log_remark <>", value, "orderLogRemark");
            return (Criteria) this;
        }

        public Criteria andOrderLogRemarkGreaterThan(String value) {
            addCriterion("order_log_remark >", value, "orderLogRemark");
            return (Criteria) this;
        }

        public Criteria andOrderLogRemarkGreaterThanOrEqualTo(String value) {
            addCriterion("order_log_remark >=", value, "orderLogRemark");
            return (Criteria) this;
        }

        public Criteria andOrderLogRemarkLessThan(String value) {
            addCriterion("order_log_remark <", value, "orderLogRemark");
            return (Criteria) this;
        }

        public Criteria andOrderLogRemarkLessThanOrEqualTo(String value) {
            addCriterion("order_log_remark <=", value, "orderLogRemark");
            return (Criteria) this;
        }

        public Criteria andOrderLogRemarkLike(String value) {
            addCriterion("order_log_remark like", value, "orderLogRemark");
            return (Criteria) this;
        }

        public Criteria andOrderLogRemarkNotLike(String value) {
            addCriterion("order_log_remark not like", value, "orderLogRemark");
            return (Criteria) this;
        }

        public Criteria andOrderLogRemarkIn(List<String> values) {
            addCriterion("order_log_remark in", values, "orderLogRemark");
            return (Criteria) this;
        }

        public Criteria andOrderLogRemarkNotIn(List<String> values) {
            addCriterion("order_log_remark not in", values, "orderLogRemark");
            return (Criteria) this;
        }

        public Criteria andOrderLogRemarkBetween(String value1, String value2) {
            addCriterion("order_log_remark between", value1, value2, "orderLogRemark");
            return (Criteria) this;
        }

        public Criteria andOrderLogRemarkNotBetween(String value1, String value2) {
            addCriterion("order_log_remark not between", value1, value2, "orderLogRemark");
            return (Criteria) this;
        }

        public Criteria andOrderAgentidIsNull() {
            addCriterion("order_agentId is null");
            return (Criteria) this;
        }

        public Criteria andOrderAgentidIsNotNull() {
            addCriterion("order_agentId is not null");
            return (Criteria) this;
        }

        public Criteria andOrderAgentidEqualTo(Integer value) {
            addCriterion("order_agentId =", value, "orderAgentid");
            return (Criteria) this;
        }

        public Criteria andOrderAgentidNotEqualTo(Integer value) {
            addCriterion("order_agentId <>", value, "orderAgentid");
            return (Criteria) this;
        }

        public Criteria andOrderAgentidGreaterThan(Integer value) {
            addCriterion("order_agentId >", value, "orderAgentid");
            return (Criteria) this;
        }

        public Criteria andOrderAgentidGreaterThanOrEqualTo(Integer value) {
            addCriterion("order_agentId >=", value, "orderAgentid");
            return (Criteria) this;
        }

        public Criteria andOrderAgentidLessThan(Integer value) {
            addCriterion("order_agentId <", value, "orderAgentid");
            return (Criteria) this;
        }

        public Criteria andOrderAgentidLessThanOrEqualTo(Integer value) {
            addCriterion("order_agentId <=", value, "orderAgentid");
            return (Criteria) this;
        }

        public Criteria andOrderAgentidIn(List<Integer> values) {
            addCriterion("order_agentId in", values, "orderAgentid");
            return (Criteria) this;
        }

        public Criteria andOrderAgentidNotIn(List<Integer> values) {
            addCriterion("order_agentId not in", values, "orderAgentid");
            return (Criteria) this;
        }

        public Criteria andOrderAgentidBetween(Integer value1, Integer value2) {
            addCriterion("order_agentId between", value1, value2, "orderAgentid");
            return (Criteria) this;
        }

        public Criteria andOrderAgentidNotBetween(Integer value1, Integer value2) {
            addCriterion("order_agentId not between", value1, value2, "orderAgentid");
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