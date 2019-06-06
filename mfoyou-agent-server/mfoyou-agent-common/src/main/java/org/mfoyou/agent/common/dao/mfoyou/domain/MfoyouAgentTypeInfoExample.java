package org.mfoyou.agent.common.dao.mfoyou.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class MfoyouAgentTypeInfoExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    protected Integer limitStart;

    protected Integer limitEnd;

    public MfoyouAgentTypeInfoExample() {
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

        public Criteria andStoreAgentIdIsNull() {
            addCriterion("store_agent_id is null");
            return (Criteria) this;
        }

        public Criteria andStoreAgentIdIsNotNull() {
            addCriterion("store_agent_id is not null");
            return (Criteria) this;
        }

        public Criteria andStoreAgentIdEqualTo(Integer value) {
            addCriterion("store_agent_id =", value, "storeAgentId");
            return (Criteria) this;
        }

        public Criteria andStoreAgentIdNotEqualTo(Integer value) {
            addCriterion("store_agent_id <>", value, "storeAgentId");
            return (Criteria) this;
        }

        public Criteria andStoreAgentIdGreaterThan(Integer value) {
            addCriterion("store_agent_id >", value, "storeAgentId");
            return (Criteria) this;
        }

        public Criteria andStoreAgentIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("store_agent_id >=", value, "storeAgentId");
            return (Criteria) this;
        }

        public Criteria andStoreAgentIdLessThan(Integer value) {
            addCriterion("store_agent_id <", value, "storeAgentId");
            return (Criteria) this;
        }

        public Criteria andStoreAgentIdLessThanOrEqualTo(Integer value) {
            addCriterion("store_agent_id <=", value, "storeAgentId");
            return (Criteria) this;
        }

        public Criteria andStoreAgentIdIn(List<Integer> values) {
            addCriterion("store_agent_id in", values, "storeAgentId");
            return (Criteria) this;
        }

        public Criteria andStoreAgentIdNotIn(List<Integer> values) {
            addCriterion("store_agent_id not in", values, "storeAgentId");
            return (Criteria) this;
        }

        public Criteria andStoreAgentIdBetween(Integer value1, Integer value2) {
            addCriterion("store_agent_id between", value1, value2, "storeAgentId");
            return (Criteria) this;
        }

        public Criteria andStoreAgentIdNotBetween(Integer value1, Integer value2) {
            addCriterion("store_agent_id not between", value1, value2, "storeAgentId");
            return (Criteria) this;
        }

        public Criteria andTypeContentIsNull() {
            addCriterion("type_content is null");
            return (Criteria) this;
        }

        public Criteria andTypeContentIsNotNull() {
            addCriterion("type_content is not null");
            return (Criteria) this;
        }

        public Criteria andTypeContentEqualTo(String value) {
            addCriterion("type_content =", value, "typeContent");
            return (Criteria) this;
        }

        public Criteria andTypeContentNotEqualTo(String value) {
            addCriterion("type_content <>", value, "typeContent");
            return (Criteria) this;
        }

        public Criteria andTypeContentGreaterThan(String value) {
            addCriterion("type_content >", value, "typeContent");
            return (Criteria) this;
        }

        public Criteria andTypeContentGreaterThanOrEqualTo(String value) {
            addCriterion("type_content >=", value, "typeContent");
            return (Criteria) this;
        }

        public Criteria andTypeContentLessThan(String value) {
            addCriterion("type_content <", value, "typeContent");
            return (Criteria) this;
        }

        public Criteria andTypeContentLessThanOrEqualTo(String value) {
            addCriterion("type_content <=", value, "typeContent");
            return (Criteria) this;
        }

        public Criteria andTypeContentLike(String value) {
            addCriterion("type_content like", value, "typeContent");
            return (Criteria) this;
        }

        public Criteria andTypeContentNotLike(String value) {
            addCriterion("type_content not like", value, "typeContent");
            return (Criteria) this;
        }

        public Criteria andTypeContentIn(List<String> values) {
            addCriterion("type_content in", values, "typeContent");
            return (Criteria) this;
        }

        public Criteria andTypeContentNotIn(List<String> values) {
            addCriterion("type_content not in", values, "typeContent");
            return (Criteria) this;
        }

        public Criteria andTypeContentBetween(String value1, String value2) {
            addCriterion("type_content between", value1, value2, "typeContent");
            return (Criteria) this;
        }

        public Criteria andTypeContentNotBetween(String value1, String value2) {
            addCriterion("type_content not between", value1, value2, "typeContent");
            return (Criteria) this;
        }

        public Criteria andTypeCreatTimeIsNull() {
            addCriterion("type_creat_time is null");
            return (Criteria) this;
        }

        public Criteria andTypeCreatTimeIsNotNull() {
            addCriterion("type_creat_time is not null");
            return (Criteria) this;
        }

        public Criteria andTypeCreatTimeEqualTo(Date value) {
            addCriterion("type_creat_time =", value, "typeCreatTime");
            return (Criteria) this;
        }

        public Criteria andTypeCreatTimeNotEqualTo(Date value) {
            addCriterion("type_creat_time <>", value, "typeCreatTime");
            return (Criteria) this;
        }

        public Criteria andTypeCreatTimeGreaterThan(Date value) {
            addCriterion("type_creat_time >", value, "typeCreatTime");
            return (Criteria) this;
        }

        public Criteria andTypeCreatTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("type_creat_time >=", value, "typeCreatTime");
            return (Criteria) this;
        }

        public Criteria andTypeCreatTimeLessThan(Date value) {
            addCriterion("type_creat_time <", value, "typeCreatTime");
            return (Criteria) this;
        }

        public Criteria andTypeCreatTimeLessThanOrEqualTo(Date value) {
            addCriterion("type_creat_time <=", value, "typeCreatTime");
            return (Criteria) this;
        }

        public Criteria andTypeCreatTimeIn(List<Date> values) {
            addCriterion("type_creat_time in", values, "typeCreatTime");
            return (Criteria) this;
        }

        public Criteria andTypeCreatTimeNotIn(List<Date> values) {
            addCriterion("type_creat_time not in", values, "typeCreatTime");
            return (Criteria) this;
        }

        public Criteria andTypeCreatTimeBetween(Date value1, Date value2) {
            addCriterion("type_creat_time between", value1, value2, "typeCreatTime");
            return (Criteria) this;
        }

        public Criteria andTypeCreatTimeNotBetween(Date value1, Date value2) {
            addCriterion("type_creat_time not between", value1, value2, "typeCreatTime");
            return (Criteria) this;
        }

        public Criteria andTypeModifyTimeIsNull() {
            addCriterion("type_modify_time is null");
            return (Criteria) this;
        }

        public Criteria andTypeModifyTimeIsNotNull() {
            addCriterion("type_modify_time is not null");
            return (Criteria) this;
        }

        public Criteria andTypeModifyTimeEqualTo(Date value) {
            addCriterion("type_modify_time =", value, "typeModifyTime");
            return (Criteria) this;
        }

        public Criteria andTypeModifyTimeNotEqualTo(Date value) {
            addCriterion("type_modify_time <>", value, "typeModifyTime");
            return (Criteria) this;
        }

        public Criteria andTypeModifyTimeGreaterThan(Date value) {
            addCriterion("type_modify_time >", value, "typeModifyTime");
            return (Criteria) this;
        }

        public Criteria andTypeModifyTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("type_modify_time >=", value, "typeModifyTime");
            return (Criteria) this;
        }

        public Criteria andTypeModifyTimeLessThan(Date value) {
            addCriterion("type_modify_time <", value, "typeModifyTime");
            return (Criteria) this;
        }

        public Criteria andTypeModifyTimeLessThanOrEqualTo(Date value) {
            addCriterion("type_modify_time <=", value, "typeModifyTime");
            return (Criteria) this;
        }

        public Criteria andTypeModifyTimeIn(List<Date> values) {
            addCriterion("type_modify_time in", values, "typeModifyTime");
            return (Criteria) this;
        }

        public Criteria andTypeModifyTimeNotIn(List<Date> values) {
            addCriterion("type_modify_time not in", values, "typeModifyTime");
            return (Criteria) this;
        }

        public Criteria andTypeModifyTimeBetween(Date value1, Date value2) {
            addCriterion("type_modify_time between", value1, value2, "typeModifyTime");
            return (Criteria) this;
        }

        public Criteria andTypeModifyTimeNotBetween(Date value1, Date value2) {
            addCriterion("type_modify_time not between", value1, value2, "typeModifyTime");
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