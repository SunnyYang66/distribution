package org.mfoyou.agent.common.dao.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class HuawuServicePriceExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    protected Integer limitStart;

    protected Integer limitEnd;

    public HuawuServicePriceExample() {
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

        public Criteria andServiceTakeIsNull() {
            addCriterion("service_take is null");
            return (Criteria) this;
        }

        public Criteria andServiceTakeIsNotNull() {
            addCriterion("service_take is not null");
            return (Criteria) this;
        }

        public Criteria andServiceTakeEqualTo(String value) {
            addCriterion("service_take =", value, "serviceTake");
            return (Criteria) this;
        }

        public Criteria andServiceTakeNotEqualTo(String value) {
            addCriterion("service_take <>", value, "serviceTake");
            return (Criteria) this;
        }

        public Criteria andServiceTakeGreaterThan(String value) {
            addCriterion("service_take >", value, "serviceTake");
            return (Criteria) this;
        }

        public Criteria andServiceTakeGreaterThanOrEqualTo(String value) {
            addCriterion("service_take >=", value, "serviceTake");
            return (Criteria) this;
        }

        public Criteria andServiceTakeLessThan(String value) {
            addCriterion("service_take <", value, "serviceTake");
            return (Criteria) this;
        }

        public Criteria andServiceTakeLessThanOrEqualTo(String value) {
            addCriterion("service_take <=", value, "serviceTake");
            return (Criteria) this;
        }

        public Criteria andServiceTakeLike(String value) {
            addCriterion("service_take like", value, "serviceTake");
            return (Criteria) this;
        }

        public Criteria andServiceTakeNotLike(String value) {
            addCriterion("service_take not like", value, "serviceTake");
            return (Criteria) this;
        }

        public Criteria andServiceTakeIn(List<String> values) {
            addCriterion("service_take in", values, "serviceTake");
            return (Criteria) this;
        }

        public Criteria andServiceTakeNotIn(List<String> values) {
            addCriterion("service_take not in", values, "serviceTake");
            return (Criteria) this;
        }

        public Criteria andServiceTakeBetween(String value1, String value2) {
            addCriterion("service_take between", value1, value2, "serviceTake");
            return (Criteria) this;
        }

        public Criteria andServiceTakeNotBetween(String value1, String value2) {
            addCriterion("service_take not between", value1, value2, "serviceTake");
            return (Criteria) this;
        }

        public Criteria andServiceGiveIsNull() {
            addCriterion("service_give is null");
            return (Criteria) this;
        }

        public Criteria andServiceGiveIsNotNull() {
            addCriterion("service_give is not null");
            return (Criteria) this;
        }

        public Criteria andServiceGiveEqualTo(String value) {
            addCriterion("service_give =", value, "serviceGive");
            return (Criteria) this;
        }

        public Criteria andServiceGiveNotEqualTo(String value) {
            addCriterion("service_give <>", value, "serviceGive");
            return (Criteria) this;
        }

        public Criteria andServiceGiveGreaterThan(String value) {
            addCriterion("service_give >", value, "serviceGive");
            return (Criteria) this;
        }

        public Criteria andServiceGiveGreaterThanOrEqualTo(String value) {
            addCriterion("service_give >=", value, "serviceGive");
            return (Criteria) this;
        }

        public Criteria andServiceGiveLessThan(String value) {
            addCriterion("service_give <", value, "serviceGive");
            return (Criteria) this;
        }

        public Criteria andServiceGiveLessThanOrEqualTo(String value) {
            addCriterion("service_give <=", value, "serviceGive");
            return (Criteria) this;
        }

        public Criteria andServiceGiveLike(String value) {
            addCriterion("service_give like", value, "serviceGive");
            return (Criteria) this;
        }

        public Criteria andServiceGiveNotLike(String value) {
            addCriterion("service_give not like", value, "serviceGive");
            return (Criteria) this;
        }

        public Criteria andServiceGiveIn(List<String> values) {
            addCriterion("service_give in", values, "serviceGive");
            return (Criteria) this;
        }

        public Criteria andServiceGiveNotIn(List<String> values) {
            addCriterion("service_give not in", values, "serviceGive");
            return (Criteria) this;
        }

        public Criteria andServiceGiveBetween(String value1, String value2) {
            addCriterion("service_give between", value1, value2, "serviceGive");
            return (Criteria) this;
        }

        public Criteria andServiceGiveNotBetween(String value1, String value2) {
            addCriterion("service_give not between", value1, value2, "serviceGive");
            return (Criteria) this;
        }

        public Criteria andServiceBuyIsNull() {
            addCriterion("service_buy is null");
            return (Criteria) this;
        }

        public Criteria andServiceBuyIsNotNull() {
            addCriterion("service_buy is not null");
            return (Criteria) this;
        }

        public Criteria andServiceBuyEqualTo(String value) {
            addCriterion("service_buy =", value, "serviceBuy");
            return (Criteria) this;
        }

        public Criteria andServiceBuyNotEqualTo(String value) {
            addCriterion("service_buy <>", value, "serviceBuy");
            return (Criteria) this;
        }

        public Criteria andServiceBuyGreaterThan(String value) {
            addCriterion("service_buy >", value, "serviceBuy");
            return (Criteria) this;
        }

        public Criteria andServiceBuyGreaterThanOrEqualTo(String value) {
            addCriterion("service_buy >=", value, "serviceBuy");
            return (Criteria) this;
        }

        public Criteria andServiceBuyLessThan(String value) {
            addCriterion("service_buy <", value, "serviceBuy");
            return (Criteria) this;
        }

        public Criteria andServiceBuyLessThanOrEqualTo(String value) {
            addCriterion("service_buy <=", value, "serviceBuy");
            return (Criteria) this;
        }

        public Criteria andServiceBuyLike(String value) {
            addCriterion("service_buy like", value, "serviceBuy");
            return (Criteria) this;
        }

        public Criteria andServiceBuyNotLike(String value) {
            addCriterion("service_buy not like", value, "serviceBuy");
            return (Criteria) this;
        }

        public Criteria andServiceBuyIn(List<String> values) {
            addCriterion("service_buy in", values, "serviceBuy");
            return (Criteria) this;
        }

        public Criteria andServiceBuyNotIn(List<String> values) {
            addCriterion("service_buy not in", values, "serviceBuy");
            return (Criteria) this;
        }

        public Criteria andServiceBuyBetween(String value1, String value2) {
            addCriterion("service_buy between", value1, value2, "serviceBuy");
            return (Criteria) this;
        }

        public Criteria andServiceBuyNotBetween(String value1, String value2) {
            addCriterion("service_buy not between", value1, value2, "serviceBuy");
            return (Criteria) this;
        }

        public Criteria andServiceDoIsNull() {
            addCriterion("service_do is null");
            return (Criteria) this;
        }

        public Criteria andServiceDoIsNotNull() {
            addCriterion("service_do is not null");
            return (Criteria) this;
        }

        public Criteria andServiceDoEqualTo(String value) {
            addCriterion("service_do =", value, "serviceDo");
            return (Criteria) this;
        }

        public Criteria andServiceDoNotEqualTo(String value) {
            addCriterion("service_do <>", value, "serviceDo");
            return (Criteria) this;
        }

        public Criteria andServiceDoGreaterThan(String value) {
            addCriterion("service_do >", value, "serviceDo");
            return (Criteria) this;
        }

        public Criteria andServiceDoGreaterThanOrEqualTo(String value) {
            addCriterion("service_do >=", value, "serviceDo");
            return (Criteria) this;
        }

        public Criteria andServiceDoLessThan(String value) {
            addCriterion("service_do <", value, "serviceDo");
            return (Criteria) this;
        }

        public Criteria andServiceDoLessThanOrEqualTo(String value) {
            addCriterion("service_do <=", value, "serviceDo");
            return (Criteria) this;
        }

        public Criteria andServiceDoLike(String value) {
            addCriterion("service_do like", value, "serviceDo");
            return (Criteria) this;
        }

        public Criteria andServiceDoNotLike(String value) {
            addCriterion("service_do not like", value, "serviceDo");
            return (Criteria) this;
        }

        public Criteria andServiceDoIn(List<String> values) {
            addCriterion("service_do in", values, "serviceDo");
            return (Criteria) this;
        }

        public Criteria andServiceDoNotIn(List<String> values) {
            addCriterion("service_do not in", values, "serviceDo");
            return (Criteria) this;
        }

        public Criteria andServiceDoBetween(String value1, String value2) {
            addCriterion("service_do between", value1, value2, "serviceDo");
            return (Criteria) this;
        }

        public Criteria andServiceDoNotBetween(String value1, String value2) {
            addCriterion("service_do not between", value1, value2, "serviceDo");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNull() {
            addCriterion("create_time is null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNotNull() {
            addCriterion("create_time is not null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeEqualTo(Date value) {
            addCriterion("create_time =", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotEqualTo(Date value) {
            addCriterion("create_time <>", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThan(Date value) {
            addCriterion("create_time >", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("create_time >=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThan(Date value) {
            addCriterion("create_time <", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThanOrEqualTo(Date value) {
            addCriterion("create_time <=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIn(List<Date> values) {
            addCriterion("create_time in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotIn(List<Date> values) {
            addCriterion("create_time not in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeBetween(Date value1, Date value2) {
            addCriterion("create_time between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotBetween(Date value1, Date value2) {
            addCriterion("create_time not between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andModifyTimeIsNull() {
            addCriterion("modify_time is null");
            return (Criteria) this;
        }

        public Criteria andModifyTimeIsNotNull() {
            addCriterion("modify_time is not null");
            return (Criteria) this;
        }

        public Criteria andModifyTimeEqualTo(Date value) {
            addCriterion("modify_time =", value, "modifyTime");
            return (Criteria) this;
        }

        public Criteria andModifyTimeNotEqualTo(Date value) {
            addCriterion("modify_time <>", value, "modifyTime");
            return (Criteria) this;
        }

        public Criteria andModifyTimeGreaterThan(Date value) {
            addCriterion("modify_time >", value, "modifyTime");
            return (Criteria) this;
        }

        public Criteria andModifyTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("modify_time >=", value, "modifyTime");
            return (Criteria) this;
        }

        public Criteria andModifyTimeLessThan(Date value) {
            addCriterion("modify_time <", value, "modifyTime");
            return (Criteria) this;
        }

        public Criteria andModifyTimeLessThanOrEqualTo(Date value) {
            addCriterion("modify_time <=", value, "modifyTime");
            return (Criteria) this;
        }

        public Criteria andModifyTimeIn(List<Date> values) {
            addCriterion("modify_time in", values, "modifyTime");
            return (Criteria) this;
        }

        public Criteria andModifyTimeNotIn(List<Date> values) {
            addCriterion("modify_time not in", values, "modifyTime");
            return (Criteria) this;
        }

        public Criteria andModifyTimeBetween(Date value1, Date value2) {
            addCriterion("modify_time between", value1, value2, "modifyTime");
            return (Criteria) this;
        }

        public Criteria andModifyTimeNotBetween(Date value1, Date value2) {
            addCriterion("modify_time not between", value1, value2, "modifyTime");
            return (Criteria) this;
        }

        public Criteria andStateIsNull() {
            addCriterion("state is null");
            return (Criteria) this;
        }

        public Criteria andStateIsNotNull() {
            addCriterion("state is not null");
            return (Criteria) this;
        }

        public Criteria andStateEqualTo(Integer value) {
            addCriterion("state =", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateNotEqualTo(Integer value) {
            addCriterion("state <>", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateGreaterThan(Integer value) {
            addCriterion("state >", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateGreaterThanOrEqualTo(Integer value) {
            addCriterion("state >=", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateLessThan(Integer value) {
            addCriterion("state <", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateLessThanOrEqualTo(Integer value) {
            addCriterion("state <=", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateIn(List<Integer> values) {
            addCriterion("state in", values, "state");
            return (Criteria) this;
        }

        public Criteria andStateNotIn(List<Integer> values) {
            addCriterion("state not in", values, "state");
            return (Criteria) this;
        }

        public Criteria andStateBetween(Integer value1, Integer value2) {
            addCriterion("state between", value1, value2, "state");
            return (Criteria) this;
        }

        public Criteria andStateNotBetween(Integer value1, Integer value2) {
            addCriterion("state not between", value1, value2, "state");
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