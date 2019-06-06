package org.mfoyou.agent.common.dao.mfoyou.domain;

import java.util.ArrayList;
import java.util.List;

public class MfoyouStoreTypeExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    protected Integer limitStart;

    protected Integer limitEnd;

    public MfoyouStoreTypeExample() {
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

        public Criteria andStoreTypeIdIsNull() {
            addCriterion("store_type_id is null");
            return (Criteria) this;
        }

        public Criteria andStoreTypeIdIsNotNull() {
            addCriterion("store_type_id is not null");
            return (Criteria) this;
        }

        public Criteria andStoreTypeIdEqualTo(Integer value) {
            addCriterion("store_type_id =", value, "storeTypeId");
            return (Criteria) this;
        }

        public Criteria andStoreTypeIdNotEqualTo(Integer value) {
            addCriterion("store_type_id <>", value, "storeTypeId");
            return (Criteria) this;
        }

        public Criteria andStoreTypeIdGreaterThan(Integer value) {
            addCriterion("store_type_id >", value, "storeTypeId");
            return (Criteria) this;
        }

        public Criteria andStoreTypeIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("store_type_id >=", value, "storeTypeId");
            return (Criteria) this;
        }

        public Criteria andStoreTypeIdLessThan(Integer value) {
            addCriterion("store_type_id <", value, "storeTypeId");
            return (Criteria) this;
        }

        public Criteria andStoreTypeIdLessThanOrEqualTo(Integer value) {
            addCriterion("store_type_id <=", value, "storeTypeId");
            return (Criteria) this;
        }

        public Criteria andStoreTypeIdIn(List<Integer> values) {
            addCriterion("store_type_id in", values, "storeTypeId");
            return (Criteria) this;
        }

        public Criteria andStoreTypeIdNotIn(List<Integer> values) {
            addCriterion("store_type_id not in", values, "storeTypeId");
            return (Criteria) this;
        }

        public Criteria andStoreTypeIdBetween(Integer value1, Integer value2) {
            addCriterion("store_type_id between", value1, value2, "storeTypeId");
            return (Criteria) this;
        }

        public Criteria andStoreTypeIdNotBetween(Integer value1, Integer value2) {
            addCriterion("store_type_id not between", value1, value2, "storeTypeId");
            return (Criteria) this;
        }

        public Criteria andStoreTypeNameIsNull() {
            addCriterion("store_type_name is null");
            return (Criteria) this;
        }

        public Criteria andStoreTypeNameIsNotNull() {
            addCriterion("store_type_name is not null");
            return (Criteria) this;
        }

        public Criteria andStoreTypeNameEqualTo(String value) {
            addCriterion("store_type_name =", value, "storeTypeName");
            return (Criteria) this;
        }

        public Criteria andStoreTypeNameNotEqualTo(String value) {
            addCriterion("store_type_name <>", value, "storeTypeName");
            return (Criteria) this;
        }

        public Criteria andStoreTypeNameGreaterThan(String value) {
            addCriterion("store_type_name >", value, "storeTypeName");
            return (Criteria) this;
        }

        public Criteria andStoreTypeNameGreaterThanOrEqualTo(String value) {
            addCriterion("store_type_name >=", value, "storeTypeName");
            return (Criteria) this;
        }

        public Criteria andStoreTypeNameLessThan(String value) {
            addCriterion("store_type_name <", value, "storeTypeName");
            return (Criteria) this;
        }

        public Criteria andStoreTypeNameLessThanOrEqualTo(String value) {
            addCriterion("store_type_name <=", value, "storeTypeName");
            return (Criteria) this;
        }

        public Criteria andStoreTypeNameLike(String value) {
            addCriterion("store_type_name like", value, "storeTypeName");
            return (Criteria) this;
        }

        public Criteria andStoreTypeNameNotLike(String value) {
            addCriterion("store_type_name not like", value, "storeTypeName");
            return (Criteria) this;
        }

        public Criteria andStoreTypeNameIn(List<String> values) {
            addCriterion("store_type_name in", values, "storeTypeName");
            return (Criteria) this;
        }

        public Criteria andStoreTypeNameNotIn(List<String> values) {
            addCriterion("store_type_name not in", values, "storeTypeName");
            return (Criteria) this;
        }

        public Criteria andStoreTypeNameBetween(String value1, String value2) {
            addCriterion("store_type_name between", value1, value2, "storeTypeName");
            return (Criteria) this;
        }

        public Criteria andStoreTypeNameNotBetween(String value1, String value2) {
            addCriterion("store_type_name not between", value1, value2, "storeTypeName");
            return (Criteria) this;
        }

        public Criteria andStoreTypeLeveIsNull() {
            addCriterion("store_type_leve is null");
            return (Criteria) this;
        }

        public Criteria andStoreTypeLeveIsNotNull() {
            addCriterion("store_type_leve is not null");
            return (Criteria) this;
        }

        public Criteria andStoreTypeLeveEqualTo(Integer value) {
            addCriterion("store_type_leve =", value, "storeTypeLeve");
            return (Criteria) this;
        }

        public Criteria andStoreTypeLeveNotEqualTo(Integer value) {
            addCriterion("store_type_leve <>", value, "storeTypeLeve");
            return (Criteria) this;
        }

        public Criteria andStoreTypeLeveGreaterThan(Integer value) {
            addCriterion("store_type_leve >", value, "storeTypeLeve");
            return (Criteria) this;
        }

        public Criteria andStoreTypeLeveGreaterThanOrEqualTo(Integer value) {
            addCriterion("store_type_leve >=", value, "storeTypeLeve");
            return (Criteria) this;
        }

        public Criteria andStoreTypeLeveLessThan(Integer value) {
            addCriterion("store_type_leve <", value, "storeTypeLeve");
            return (Criteria) this;
        }

        public Criteria andStoreTypeLeveLessThanOrEqualTo(Integer value) {
            addCriterion("store_type_leve <=", value, "storeTypeLeve");
            return (Criteria) this;
        }

        public Criteria andStoreTypeLeveIn(List<Integer> values) {
            addCriterion("store_type_leve in", values, "storeTypeLeve");
            return (Criteria) this;
        }

        public Criteria andStoreTypeLeveNotIn(List<Integer> values) {
            addCriterion("store_type_leve not in", values, "storeTypeLeve");
            return (Criteria) this;
        }

        public Criteria andStoreTypeLeveBetween(Integer value1, Integer value2) {
            addCriterion("store_type_leve between", value1, value2, "storeTypeLeve");
            return (Criteria) this;
        }

        public Criteria andStoreTypeLeveNotBetween(Integer value1, Integer value2) {
            addCriterion("store_type_leve not between", value1, value2, "storeTypeLeve");
            return (Criteria) this;
        }

        public Criteria andStoreTypeParentIsNull() {
            addCriterion("store_type_parent is null");
            return (Criteria) this;
        }

        public Criteria andStoreTypeParentIsNotNull() {
            addCriterion("store_type_parent is not null");
            return (Criteria) this;
        }

        public Criteria andStoreTypeParentEqualTo(Integer value) {
            addCriterion("store_type_parent =", value, "storeTypeParent");
            return (Criteria) this;
        }

        public Criteria andStoreTypeParentNotEqualTo(Integer value) {
            addCriterion("store_type_parent <>", value, "storeTypeParent");
            return (Criteria) this;
        }

        public Criteria andStoreTypeParentGreaterThan(Integer value) {
            addCriterion("store_type_parent >", value, "storeTypeParent");
            return (Criteria) this;
        }

        public Criteria andStoreTypeParentGreaterThanOrEqualTo(Integer value) {
            addCriterion("store_type_parent >=", value, "storeTypeParent");
            return (Criteria) this;
        }

        public Criteria andStoreTypeParentLessThan(Integer value) {
            addCriterion("store_type_parent <", value, "storeTypeParent");
            return (Criteria) this;
        }

        public Criteria andStoreTypeParentLessThanOrEqualTo(Integer value) {
            addCriterion("store_type_parent <=", value, "storeTypeParent");
            return (Criteria) this;
        }

        public Criteria andStoreTypeParentIn(List<Integer> values) {
            addCriterion("store_type_parent in", values, "storeTypeParent");
            return (Criteria) this;
        }

        public Criteria andStoreTypeParentNotIn(List<Integer> values) {
            addCriterion("store_type_parent not in", values, "storeTypeParent");
            return (Criteria) this;
        }

        public Criteria andStoreTypeParentBetween(Integer value1, Integer value2) {
            addCriterion("store_type_parent between", value1, value2, "storeTypeParent");
            return (Criteria) this;
        }

        public Criteria andStoreTypeParentNotBetween(Integer value1, Integer value2) {
            addCriterion("store_type_parent not between", value1, value2, "storeTypeParent");
            return (Criteria) this;
        }

        public Criteria andStorePercentIsNull() {
            addCriterion("store_percent is null");
            return (Criteria) this;
        }

        public Criteria andStorePercentIsNotNull() {
            addCriterion("store_percent is not null");
            return (Criteria) this;
        }

        public Criteria andStorePercentEqualTo(Integer value) {
            addCriterion("store_percent =", value, "storePercent");
            return (Criteria) this;
        }

        public Criteria andStorePercentNotEqualTo(Integer value) {
            addCriterion("store_percent <>", value, "storePercent");
            return (Criteria) this;
        }

        public Criteria andStorePercentGreaterThan(Integer value) {
            addCriterion("store_percent >", value, "storePercent");
            return (Criteria) this;
        }

        public Criteria andStorePercentGreaterThanOrEqualTo(Integer value) {
            addCriterion("store_percent >=", value, "storePercent");
            return (Criteria) this;
        }

        public Criteria andStorePercentLessThan(Integer value) {
            addCriterion("store_percent <", value, "storePercent");
            return (Criteria) this;
        }

        public Criteria andStorePercentLessThanOrEqualTo(Integer value) {
            addCriterion("store_percent <=", value, "storePercent");
            return (Criteria) this;
        }

        public Criteria andStorePercentIn(List<Integer> values) {
            addCriterion("store_percent in", values, "storePercent");
            return (Criteria) this;
        }

        public Criteria andStorePercentNotIn(List<Integer> values) {
            addCriterion("store_percent not in", values, "storePercent");
            return (Criteria) this;
        }

        public Criteria andStorePercentBetween(Integer value1, Integer value2) {
            addCriterion("store_percent between", value1, value2, "storePercent");
            return (Criteria) this;
        }

        public Criteria andStorePercentNotBetween(Integer value1, Integer value2) {
            addCriterion("store_percent not between", value1, value2, "storePercent");
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