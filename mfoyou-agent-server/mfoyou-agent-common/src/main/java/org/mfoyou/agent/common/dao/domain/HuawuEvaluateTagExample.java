package org.mfoyou.agent.common.dao.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class HuawuEvaluateTagExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    protected Integer limitStart;

    protected Integer limitEnd;

    public HuawuEvaluateTagExample() {
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

        public Criteria andEvaluateTagIdIsNull() {
            addCriterion("evaluate_tag_id is null");
            return (Criteria) this;
        }

        public Criteria andEvaluateTagIdIsNotNull() {
            addCriterion("evaluate_tag_id is not null");
            return (Criteria) this;
        }

        public Criteria andEvaluateTagIdEqualTo(Integer value) {
            addCriterion("evaluate_tag_id =", value, "evaluateTagId");
            return (Criteria) this;
        }

        public Criteria andEvaluateTagIdNotEqualTo(Integer value) {
            addCriterion("evaluate_tag_id <>", value, "evaluateTagId");
            return (Criteria) this;
        }

        public Criteria andEvaluateTagIdGreaterThan(Integer value) {
            addCriterion("evaluate_tag_id >", value, "evaluateTagId");
            return (Criteria) this;
        }

        public Criteria andEvaluateTagIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("evaluate_tag_id >=", value, "evaluateTagId");
            return (Criteria) this;
        }

        public Criteria andEvaluateTagIdLessThan(Integer value) {
            addCriterion("evaluate_tag_id <", value, "evaluateTagId");
            return (Criteria) this;
        }

        public Criteria andEvaluateTagIdLessThanOrEqualTo(Integer value) {
            addCriterion("evaluate_tag_id <=", value, "evaluateTagId");
            return (Criteria) this;
        }

        public Criteria andEvaluateTagIdIn(List<Integer> values) {
            addCriterion("evaluate_tag_id in", values, "evaluateTagId");
            return (Criteria) this;
        }

        public Criteria andEvaluateTagIdNotIn(List<Integer> values) {
            addCriterion("evaluate_tag_id not in", values, "evaluateTagId");
            return (Criteria) this;
        }

        public Criteria andEvaluateTagIdBetween(Integer value1, Integer value2) {
            addCriterion("evaluate_tag_id between", value1, value2, "evaluateTagId");
            return (Criteria) this;
        }

        public Criteria andEvaluateTagIdNotBetween(Integer value1, Integer value2) {
            addCriterion("evaluate_tag_id not between", value1, value2, "evaluateTagId");
            return (Criteria) this;
        }

        public Criteria andEvaluateTagTypeIsNull() {
            addCriterion("evaluate_tag_type is null");
            return (Criteria) this;
        }

        public Criteria andEvaluateTagTypeIsNotNull() {
            addCriterion("evaluate_tag_type is not null");
            return (Criteria) this;
        }

        public Criteria andEvaluateTagTypeEqualTo(Integer value) {
            addCriterion("evaluate_tag_type =", value, "evaluateTagType");
            return (Criteria) this;
        }

        public Criteria andEvaluateTagTypeNotEqualTo(Integer value) {
            addCriterion("evaluate_tag_type <>", value, "evaluateTagType");
            return (Criteria) this;
        }

        public Criteria andEvaluateTagTypeGreaterThan(Integer value) {
            addCriterion("evaluate_tag_type >", value, "evaluateTagType");
            return (Criteria) this;
        }

        public Criteria andEvaluateTagTypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("evaluate_tag_type >=", value, "evaluateTagType");
            return (Criteria) this;
        }

        public Criteria andEvaluateTagTypeLessThan(Integer value) {
            addCriterion("evaluate_tag_type <", value, "evaluateTagType");
            return (Criteria) this;
        }

        public Criteria andEvaluateTagTypeLessThanOrEqualTo(Integer value) {
            addCriterion("evaluate_tag_type <=", value, "evaluateTagType");
            return (Criteria) this;
        }

        public Criteria andEvaluateTagTypeIn(List<Integer> values) {
            addCriterion("evaluate_tag_type in", values, "evaluateTagType");
            return (Criteria) this;
        }

        public Criteria andEvaluateTagTypeNotIn(List<Integer> values) {
            addCriterion("evaluate_tag_type not in", values, "evaluateTagType");
            return (Criteria) this;
        }

        public Criteria andEvaluateTagTypeBetween(Integer value1, Integer value2) {
            addCriterion("evaluate_tag_type between", value1, value2, "evaluateTagType");
            return (Criteria) this;
        }

        public Criteria andEvaluateTagTypeNotBetween(Integer value1, Integer value2) {
            addCriterion("evaluate_tag_type not between", value1, value2, "evaluateTagType");
            return (Criteria) this;
        }

        public Criteria andEvaluateTagScoreIsNull() {
            addCriterion("evaluate_tag_score is null");
            return (Criteria) this;
        }

        public Criteria andEvaluateTagScoreIsNotNull() {
            addCriterion("evaluate_tag_score is not null");
            return (Criteria) this;
        }

        public Criteria andEvaluateTagScoreEqualTo(Integer value) {
            addCriterion("evaluate_tag_score =", value, "evaluateTagScore");
            return (Criteria) this;
        }

        public Criteria andEvaluateTagScoreNotEqualTo(Integer value) {
            addCriterion("evaluate_tag_score <>", value, "evaluateTagScore");
            return (Criteria) this;
        }

        public Criteria andEvaluateTagScoreGreaterThan(Integer value) {
            addCriterion("evaluate_tag_score >", value, "evaluateTagScore");
            return (Criteria) this;
        }

        public Criteria andEvaluateTagScoreGreaterThanOrEqualTo(Integer value) {
            addCriterion("evaluate_tag_score >=", value, "evaluateTagScore");
            return (Criteria) this;
        }

        public Criteria andEvaluateTagScoreLessThan(Integer value) {
            addCriterion("evaluate_tag_score <", value, "evaluateTagScore");
            return (Criteria) this;
        }

        public Criteria andEvaluateTagScoreLessThanOrEqualTo(Integer value) {
            addCriterion("evaluate_tag_score <=", value, "evaluateTagScore");
            return (Criteria) this;
        }

        public Criteria andEvaluateTagScoreIn(List<Integer> values) {
            addCriterion("evaluate_tag_score in", values, "evaluateTagScore");
            return (Criteria) this;
        }

        public Criteria andEvaluateTagScoreNotIn(List<Integer> values) {
            addCriterion("evaluate_tag_score not in", values, "evaluateTagScore");
            return (Criteria) this;
        }

        public Criteria andEvaluateTagScoreBetween(Integer value1, Integer value2) {
            addCriterion("evaluate_tag_score between", value1, value2, "evaluateTagScore");
            return (Criteria) this;
        }

        public Criteria andEvaluateTagScoreNotBetween(Integer value1, Integer value2) {
            addCriterion("evaluate_tag_score not between", value1, value2, "evaluateTagScore");
            return (Criteria) this;
        }

        public Criteria andEvaluateTagNameIsNull() {
            addCriterion("evaluate_tag_name is null");
            return (Criteria) this;
        }

        public Criteria andEvaluateTagNameIsNotNull() {
            addCriterion("evaluate_tag_name is not null");
            return (Criteria) this;
        }

        public Criteria andEvaluateTagNameEqualTo(String value) {
            addCriterion("evaluate_tag_name =", value, "evaluateTagName");
            return (Criteria) this;
        }

        public Criteria andEvaluateTagNameNotEqualTo(String value) {
            addCriterion("evaluate_tag_name <>", value, "evaluateTagName");
            return (Criteria) this;
        }

        public Criteria andEvaluateTagNameGreaterThan(String value) {
            addCriterion("evaluate_tag_name >", value, "evaluateTagName");
            return (Criteria) this;
        }

        public Criteria andEvaluateTagNameGreaterThanOrEqualTo(String value) {
            addCriterion("evaluate_tag_name >=", value, "evaluateTagName");
            return (Criteria) this;
        }

        public Criteria andEvaluateTagNameLessThan(String value) {
            addCriterion("evaluate_tag_name <", value, "evaluateTagName");
            return (Criteria) this;
        }

        public Criteria andEvaluateTagNameLessThanOrEqualTo(String value) {
            addCriterion("evaluate_tag_name <=", value, "evaluateTagName");
            return (Criteria) this;
        }

        public Criteria andEvaluateTagNameLike(String value) {
            addCriterion("evaluate_tag_name like", value, "evaluateTagName");
            return (Criteria) this;
        }

        public Criteria andEvaluateTagNameNotLike(String value) {
            addCriterion("evaluate_tag_name not like", value, "evaluateTagName");
            return (Criteria) this;
        }

        public Criteria andEvaluateTagNameIn(List<String> values) {
            addCriterion("evaluate_tag_name in", values, "evaluateTagName");
            return (Criteria) this;
        }

        public Criteria andEvaluateTagNameNotIn(List<String> values) {
            addCriterion("evaluate_tag_name not in", values, "evaluateTagName");
            return (Criteria) this;
        }

        public Criteria andEvaluateTagNameBetween(String value1, String value2) {
            addCriterion("evaluate_tag_name between", value1, value2, "evaluateTagName");
            return (Criteria) this;
        }

        public Criteria andEvaluateTagNameNotBetween(String value1, String value2) {
            addCriterion("evaluate_tag_name not between", value1, value2, "evaluateTagName");
            return (Criteria) this;
        }

        public Criteria andEvaluateTagPrefabIsNull() {
            addCriterion("evaluate_tag_prefab is null");
            return (Criteria) this;
        }

        public Criteria andEvaluateTagPrefabIsNotNull() {
            addCriterion("evaluate_tag_prefab is not null");
            return (Criteria) this;
        }

        public Criteria andEvaluateTagPrefabEqualTo(Integer value) {
            addCriterion("evaluate_tag_prefab =", value, "evaluateTagPrefab");
            return (Criteria) this;
        }

        public Criteria andEvaluateTagPrefabNotEqualTo(Integer value) {
            addCriterion("evaluate_tag_prefab <>", value, "evaluateTagPrefab");
            return (Criteria) this;
        }

        public Criteria andEvaluateTagPrefabGreaterThan(Integer value) {
            addCriterion("evaluate_tag_prefab >", value, "evaluateTagPrefab");
            return (Criteria) this;
        }

        public Criteria andEvaluateTagPrefabGreaterThanOrEqualTo(Integer value) {
            addCriterion("evaluate_tag_prefab >=", value, "evaluateTagPrefab");
            return (Criteria) this;
        }

        public Criteria andEvaluateTagPrefabLessThan(Integer value) {
            addCriterion("evaluate_tag_prefab <", value, "evaluateTagPrefab");
            return (Criteria) this;
        }

        public Criteria andEvaluateTagPrefabLessThanOrEqualTo(Integer value) {
            addCriterion("evaluate_tag_prefab <=", value, "evaluateTagPrefab");
            return (Criteria) this;
        }

        public Criteria andEvaluateTagPrefabIn(List<Integer> values) {
            addCriterion("evaluate_tag_prefab in", values, "evaluateTagPrefab");
            return (Criteria) this;
        }

        public Criteria andEvaluateTagPrefabNotIn(List<Integer> values) {
            addCriterion("evaluate_tag_prefab not in", values, "evaluateTagPrefab");
            return (Criteria) this;
        }

        public Criteria andEvaluateTagPrefabBetween(Integer value1, Integer value2) {
            addCriterion("evaluate_tag_prefab between", value1, value2, "evaluateTagPrefab");
            return (Criteria) this;
        }

        public Criteria andEvaluateTagPrefabNotBetween(Integer value1, Integer value2) {
            addCriterion("evaluate_tag_prefab not between", value1, value2, "evaluateTagPrefab");
            return (Criteria) this;
        }

        public Criteria andEvaluateTagUseTimesIsNull() {
            addCriterion("evaluate_tag_use_times is null");
            return (Criteria) this;
        }

        public Criteria andEvaluateTagUseTimesIsNotNull() {
            addCriterion("evaluate_tag_use_times is not null");
            return (Criteria) this;
        }

        public Criteria andEvaluateTagUseTimesEqualTo(Integer value) {
            addCriterion("evaluate_tag_use_times =", value, "evaluateTagUseTimes");
            return (Criteria) this;
        }

        public Criteria andEvaluateTagUseTimesNotEqualTo(Integer value) {
            addCriterion("evaluate_tag_use_times <>", value, "evaluateTagUseTimes");
            return (Criteria) this;
        }

        public Criteria andEvaluateTagUseTimesGreaterThan(Integer value) {
            addCriterion("evaluate_tag_use_times >", value, "evaluateTagUseTimes");
            return (Criteria) this;
        }

        public Criteria andEvaluateTagUseTimesGreaterThanOrEqualTo(Integer value) {
            addCriterion("evaluate_tag_use_times >=", value, "evaluateTagUseTimes");
            return (Criteria) this;
        }

        public Criteria andEvaluateTagUseTimesLessThan(Integer value) {
            addCriterion("evaluate_tag_use_times <", value, "evaluateTagUseTimes");
            return (Criteria) this;
        }

        public Criteria andEvaluateTagUseTimesLessThanOrEqualTo(Integer value) {
            addCriterion("evaluate_tag_use_times <=", value, "evaluateTagUseTimes");
            return (Criteria) this;
        }

        public Criteria andEvaluateTagUseTimesIn(List<Integer> values) {
            addCriterion("evaluate_tag_use_times in", values, "evaluateTagUseTimes");
            return (Criteria) this;
        }

        public Criteria andEvaluateTagUseTimesNotIn(List<Integer> values) {
            addCriterion("evaluate_tag_use_times not in", values, "evaluateTagUseTimes");
            return (Criteria) this;
        }

        public Criteria andEvaluateTagUseTimesBetween(Integer value1, Integer value2) {
            addCriterion("evaluate_tag_use_times between", value1, value2, "evaluateTagUseTimes");
            return (Criteria) this;
        }

        public Criteria andEvaluateTagUseTimesNotBetween(Integer value1, Integer value2) {
            addCriterion("evaluate_tag_use_times not between", value1, value2, "evaluateTagUseTimes");
            return (Criteria) this;
        }

        public Criteria andEvaluateTagCreateTimeIsNull() {
            addCriterion("evaluate_tag_create_time is null");
            return (Criteria) this;
        }

        public Criteria andEvaluateTagCreateTimeIsNotNull() {
            addCriterion("evaluate_tag_create_time is not null");
            return (Criteria) this;
        }

        public Criteria andEvaluateTagCreateTimeEqualTo(Date value) {
            addCriterion("evaluate_tag_create_time =", value, "evaluateTagCreateTime");
            return (Criteria) this;
        }

        public Criteria andEvaluateTagCreateTimeNotEqualTo(Date value) {
            addCriterion("evaluate_tag_create_time <>", value, "evaluateTagCreateTime");
            return (Criteria) this;
        }

        public Criteria andEvaluateTagCreateTimeGreaterThan(Date value) {
            addCriterion("evaluate_tag_create_time >", value, "evaluateTagCreateTime");
            return (Criteria) this;
        }

        public Criteria andEvaluateTagCreateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("evaluate_tag_create_time >=", value, "evaluateTagCreateTime");
            return (Criteria) this;
        }

        public Criteria andEvaluateTagCreateTimeLessThan(Date value) {
            addCriterion("evaluate_tag_create_time <", value, "evaluateTagCreateTime");
            return (Criteria) this;
        }

        public Criteria andEvaluateTagCreateTimeLessThanOrEqualTo(Date value) {
            addCriterion("evaluate_tag_create_time <=", value, "evaluateTagCreateTime");
            return (Criteria) this;
        }

        public Criteria andEvaluateTagCreateTimeIn(List<Date> values) {
            addCriterion("evaluate_tag_create_time in", values, "evaluateTagCreateTime");
            return (Criteria) this;
        }

        public Criteria andEvaluateTagCreateTimeNotIn(List<Date> values) {
            addCriterion("evaluate_tag_create_time not in", values, "evaluateTagCreateTime");
            return (Criteria) this;
        }

        public Criteria andEvaluateTagCreateTimeBetween(Date value1, Date value2) {
            addCriterion("evaluate_tag_create_time between", value1, value2, "evaluateTagCreateTime");
            return (Criteria) this;
        }

        public Criteria andEvaluateTagCreateTimeNotBetween(Date value1, Date value2) {
            addCriterion("evaluate_tag_create_time not between", value1, value2, "evaluateTagCreateTime");
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