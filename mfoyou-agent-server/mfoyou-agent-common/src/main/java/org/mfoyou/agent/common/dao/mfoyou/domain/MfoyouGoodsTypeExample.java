package org.mfoyou.agent.common.dao.mfoyou.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class MfoyouGoodsTypeExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    protected Integer limitStart;

    protected Integer limitEnd;

    public MfoyouGoodsTypeExample() {
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

        public Criteria andTypeIdIsNull() {
            addCriterion("type_id is null");
            return (Criteria) this;
        }

        public Criteria andTypeIdIsNotNull() {
            addCriterion("type_id is not null");
            return (Criteria) this;
        }

        public Criteria andTypeIdEqualTo(Integer value) {
            addCriterion("type_id =", value, "typeId");
            return (Criteria) this;
        }

        public Criteria andTypeIdNotEqualTo(Integer value) {
            addCriterion("type_id <>", value, "typeId");
            return (Criteria) this;
        }

        public Criteria andTypeIdGreaterThan(Integer value) {
            addCriterion("type_id >", value, "typeId");
            return (Criteria) this;
        }

        public Criteria andTypeIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("type_id >=", value, "typeId");
            return (Criteria) this;
        }

        public Criteria andTypeIdLessThan(Integer value) {
            addCriterion("type_id <", value, "typeId");
            return (Criteria) this;
        }

        public Criteria andTypeIdLessThanOrEqualTo(Integer value) {
            addCriterion("type_id <=", value, "typeId");
            return (Criteria) this;
        }

        public Criteria andTypeIdIn(List<Integer> values) {
            addCriterion("type_id in", values, "typeId");
            return (Criteria) this;
        }

        public Criteria andTypeIdNotIn(List<Integer> values) {
            addCriterion("type_id not in", values, "typeId");
            return (Criteria) this;
        }

        public Criteria andTypeIdBetween(Integer value1, Integer value2) {
            addCriterion("type_id between", value1, value2, "typeId");
            return (Criteria) this;
        }

        public Criteria andTypeIdNotBetween(Integer value1, Integer value2) {
            addCriterion("type_id not between", value1, value2, "typeId");
            return (Criteria) this;
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

        public Criteria andTypeNameIsNull() {
            addCriterion("type_name is null");
            return (Criteria) this;
        }

        public Criteria andTypeNameIsNotNull() {
            addCriterion("type_name is not null");
            return (Criteria) this;
        }

        public Criteria andTypeNameEqualTo(String value) {
            addCriterion("type_name =", value, "typeName");
            return (Criteria) this;
        }

        public Criteria andTypeNameNotEqualTo(String value) {
            addCriterion("type_name <>", value, "typeName");
            return (Criteria) this;
        }

        public Criteria andTypeNameGreaterThan(String value) {
            addCriterion("type_name >", value, "typeName");
            return (Criteria) this;
        }

        public Criteria andTypeNameGreaterThanOrEqualTo(String value) {
            addCriterion("type_name >=", value, "typeName");
            return (Criteria) this;
        }

        public Criteria andTypeNameLessThan(String value) {
            addCriterion("type_name <", value, "typeName");
            return (Criteria) this;
        }

        public Criteria andTypeNameLessThanOrEqualTo(String value) {
            addCriterion("type_name <=", value, "typeName");
            return (Criteria) this;
        }

        public Criteria andTypeNameLike(String value) {
            addCriterion("type_name like", value, "typeName");
            return (Criteria) this;
        }

        public Criteria andTypeNameNotLike(String value) {
            addCriterion("type_name not like", value, "typeName");
            return (Criteria) this;
        }

        public Criteria andTypeNameIn(List<String> values) {
            addCriterion("type_name in", values, "typeName");
            return (Criteria) this;
        }

        public Criteria andTypeNameNotIn(List<String> values) {
            addCriterion("type_name not in", values, "typeName");
            return (Criteria) this;
        }

        public Criteria andTypeNameBetween(String value1, String value2) {
            addCriterion("type_name between", value1, value2, "typeName");
            return (Criteria) this;
        }

        public Criteria andTypeNameNotBetween(String value1, String value2) {
            addCriterion("type_name not between", value1, value2, "typeName");
            return (Criteria) this;
        }

        public Criteria andTypeParentIsNull() {
            addCriterion("type_parent is null");
            return (Criteria) this;
        }

        public Criteria andTypeParentIsNotNull() {
            addCriterion("type_parent is not null");
            return (Criteria) this;
        }

        public Criteria andTypeParentEqualTo(Integer value) {
            addCriterion("type_parent =", value, "typeParent");
            return (Criteria) this;
        }

        public Criteria andTypeParentNotEqualTo(Integer value) {
            addCriterion("type_parent <>", value, "typeParent");
            return (Criteria) this;
        }

        public Criteria andTypeParentGreaterThan(Integer value) {
            addCriterion("type_parent >", value, "typeParent");
            return (Criteria) this;
        }

        public Criteria andTypeParentGreaterThanOrEqualTo(Integer value) {
            addCriterion("type_parent >=", value, "typeParent");
            return (Criteria) this;
        }

        public Criteria andTypeParentLessThan(Integer value) {
            addCriterion("type_parent <", value, "typeParent");
            return (Criteria) this;
        }

        public Criteria andTypeParentLessThanOrEqualTo(Integer value) {
            addCriterion("type_parent <=", value, "typeParent");
            return (Criteria) this;
        }

        public Criteria andTypeParentIn(List<Integer> values) {
            addCriterion("type_parent in", values, "typeParent");
            return (Criteria) this;
        }

        public Criteria andTypeParentNotIn(List<Integer> values) {
            addCriterion("type_parent not in", values, "typeParent");
            return (Criteria) this;
        }

        public Criteria andTypeParentBetween(Integer value1, Integer value2) {
            addCriterion("type_parent between", value1, value2, "typeParent");
            return (Criteria) this;
        }

        public Criteria andTypeParentNotBetween(Integer value1, Integer value2) {
            addCriterion("type_parent not between", value1, value2, "typeParent");
            return (Criteria) this;
        }

        public Criteria andTypeLeveIsNull() {
            addCriterion("type_leve is null");
            return (Criteria) this;
        }

        public Criteria andTypeLeveIsNotNull() {
            addCriterion("type_leve is not null");
            return (Criteria) this;
        }

        public Criteria andTypeLeveEqualTo(Integer value) {
            addCriterion("type_leve =", value, "typeLeve");
            return (Criteria) this;
        }

        public Criteria andTypeLeveNotEqualTo(Integer value) {
            addCriterion("type_leve <>", value, "typeLeve");
            return (Criteria) this;
        }

        public Criteria andTypeLeveGreaterThan(Integer value) {
            addCriterion("type_leve >", value, "typeLeve");
            return (Criteria) this;
        }

        public Criteria andTypeLeveGreaterThanOrEqualTo(Integer value) {
            addCriterion("type_leve >=", value, "typeLeve");
            return (Criteria) this;
        }

        public Criteria andTypeLeveLessThan(Integer value) {
            addCriterion("type_leve <", value, "typeLeve");
            return (Criteria) this;
        }

        public Criteria andTypeLeveLessThanOrEqualTo(Integer value) {
            addCriterion("type_leve <=", value, "typeLeve");
            return (Criteria) this;
        }

        public Criteria andTypeLeveIn(List<Integer> values) {
            addCriterion("type_leve in", values, "typeLeve");
            return (Criteria) this;
        }

        public Criteria andTypeLeveNotIn(List<Integer> values) {
            addCriterion("type_leve not in", values, "typeLeve");
            return (Criteria) this;
        }

        public Criteria andTypeLeveBetween(Integer value1, Integer value2) {
            addCriterion("type_leve between", value1, value2, "typeLeve");
            return (Criteria) this;
        }

        public Criteria andTypeLeveNotBetween(Integer value1, Integer value2) {
            addCriterion("type_leve not between", value1, value2, "typeLeve");
            return (Criteria) this;
        }

        public Criteria andTypeSortValueIsNull() {
            addCriterion("type_sort_value is null");
            return (Criteria) this;
        }

        public Criteria andTypeSortValueIsNotNull() {
            addCriterion("type_sort_value is not null");
            return (Criteria) this;
        }

        public Criteria andTypeSortValueEqualTo(Long value) {
            addCriterion("type_sort_value =", value, "typeSortValue");
            return (Criteria) this;
        }

        public Criteria andTypeSortValueNotEqualTo(Long value) {
            addCriterion("type_sort_value <>", value, "typeSortValue");
            return (Criteria) this;
        }

        public Criteria andTypeSortValueGreaterThan(Long value) {
            addCriterion("type_sort_value >", value, "typeSortValue");
            return (Criteria) this;
        }

        public Criteria andTypeSortValueGreaterThanOrEqualTo(Long value) {
            addCriterion("type_sort_value >=", value, "typeSortValue");
            return (Criteria) this;
        }

        public Criteria andTypeSortValueLessThan(Long value) {
            addCriterion("type_sort_value <", value, "typeSortValue");
            return (Criteria) this;
        }

        public Criteria andTypeSortValueLessThanOrEqualTo(Long value) {
            addCriterion("type_sort_value <=", value, "typeSortValue");
            return (Criteria) this;
        }

        public Criteria andTypeSortValueIn(List<Long> values) {
            addCriterion("type_sort_value in", values, "typeSortValue");
            return (Criteria) this;
        }

        public Criteria andTypeSortValueNotIn(List<Long> values) {
            addCriterion("type_sort_value not in", values, "typeSortValue");
            return (Criteria) this;
        }

        public Criteria andTypeSortValueBetween(Long value1, Long value2) {
            addCriterion("type_sort_value between", value1, value2, "typeSortValue");
            return (Criteria) this;
        }

        public Criteria andTypeSortValueNotBetween(Long value1, Long value2) {
            addCriterion("type_sort_value not between", value1, value2, "typeSortValue");
            return (Criteria) this;
        }

        public Criteria andTypeTopIsNull() {
            addCriterion("type_top is null");
            return (Criteria) this;
        }

        public Criteria andTypeTopIsNotNull() {
            addCriterion("type_top is not null");
            return (Criteria) this;
        }

        public Criteria andTypeTopEqualTo(Integer value) {
            addCriterion("type_top =", value, "typeTop");
            return (Criteria) this;
        }

        public Criteria andTypeTopNotEqualTo(Integer value) {
            addCriterion("type_top <>", value, "typeTop");
            return (Criteria) this;
        }

        public Criteria andTypeTopGreaterThan(Integer value) {
            addCriterion("type_top >", value, "typeTop");
            return (Criteria) this;
        }

        public Criteria andTypeTopGreaterThanOrEqualTo(Integer value) {
            addCriterion("type_top >=", value, "typeTop");
            return (Criteria) this;
        }

        public Criteria andTypeTopLessThan(Integer value) {
            addCriterion("type_top <", value, "typeTop");
            return (Criteria) this;
        }

        public Criteria andTypeTopLessThanOrEqualTo(Integer value) {
            addCriterion("type_top <=", value, "typeTop");
            return (Criteria) this;
        }

        public Criteria andTypeTopIn(List<Integer> values) {
            addCriterion("type_top in", values, "typeTop");
            return (Criteria) this;
        }

        public Criteria andTypeTopNotIn(List<Integer> values) {
            addCriterion("type_top not in", values, "typeTop");
            return (Criteria) this;
        }

        public Criteria andTypeTopBetween(Integer value1, Integer value2) {
            addCriterion("type_top between", value1, value2, "typeTop");
            return (Criteria) this;
        }

        public Criteria andTypeTopNotBetween(Integer value1, Integer value2) {
            addCriterion("type_top not between", value1, value2, "typeTop");
            return (Criteria) this;
        }

        public Criteria andTypeVisibleIsNull() {
            addCriterion("type_visible is null");
            return (Criteria) this;
        }

        public Criteria andTypeVisibleIsNotNull() {
            addCriterion("type_visible is not null");
            return (Criteria) this;
        }

        public Criteria andTypeVisibleEqualTo(Integer value) {
            addCriterion("type_visible =", value, "typeVisible");
            return (Criteria) this;
        }

        public Criteria andTypeVisibleNotEqualTo(Integer value) {
            addCriterion("type_visible <>", value, "typeVisible");
            return (Criteria) this;
        }

        public Criteria andTypeVisibleGreaterThan(Integer value) {
            addCriterion("type_visible >", value, "typeVisible");
            return (Criteria) this;
        }

        public Criteria andTypeVisibleGreaterThanOrEqualTo(Integer value) {
            addCriterion("type_visible >=", value, "typeVisible");
            return (Criteria) this;
        }

        public Criteria andTypeVisibleLessThan(Integer value) {
            addCriterion("type_visible <", value, "typeVisible");
            return (Criteria) this;
        }

        public Criteria andTypeVisibleLessThanOrEqualTo(Integer value) {
            addCriterion("type_visible <=", value, "typeVisible");
            return (Criteria) this;
        }

        public Criteria andTypeVisibleIn(List<Integer> values) {
            addCriterion("type_visible in", values, "typeVisible");
            return (Criteria) this;
        }

        public Criteria andTypeVisibleNotIn(List<Integer> values) {
            addCriterion("type_visible not in", values, "typeVisible");
            return (Criteria) this;
        }

        public Criteria andTypeVisibleBetween(Integer value1, Integer value2) {
            addCriterion("type_visible between", value1, value2, "typeVisible");
            return (Criteria) this;
        }

        public Criteria andTypeVisibleNotBetween(Integer value1, Integer value2) {
            addCriterion("type_visible not between", value1, value2, "typeVisible");
            return (Criteria) this;
        }

        public Criteria andTypeGctIsNull() {
            addCriterion("type_gct is null");
            return (Criteria) this;
        }

        public Criteria andTypeGctIsNotNull() {
            addCriterion("type_gct is not null");
            return (Criteria) this;
        }

        public Criteria andTypeGctEqualTo(Date value) {
            addCriterion("type_gct =", value, "typeGct");
            return (Criteria) this;
        }

        public Criteria andTypeGctNotEqualTo(Date value) {
            addCriterion("type_gct <>", value, "typeGct");
            return (Criteria) this;
        }

        public Criteria andTypeGctGreaterThan(Date value) {
            addCriterion("type_gct >", value, "typeGct");
            return (Criteria) this;
        }

        public Criteria andTypeGctGreaterThanOrEqualTo(Date value) {
            addCriterion("type_gct >=", value, "typeGct");
            return (Criteria) this;
        }

        public Criteria andTypeGctLessThan(Date value) {
            addCriterion("type_gct <", value, "typeGct");
            return (Criteria) this;
        }

        public Criteria andTypeGctLessThanOrEqualTo(Date value) {
            addCriterion("type_gct <=", value, "typeGct");
            return (Criteria) this;
        }

        public Criteria andTypeGctIn(List<Date> values) {
            addCriterion("type_gct in", values, "typeGct");
            return (Criteria) this;
        }

        public Criteria andTypeGctNotIn(List<Date> values) {
            addCriterion("type_gct not in", values, "typeGct");
            return (Criteria) this;
        }

        public Criteria andTypeGctBetween(Date value1, Date value2) {
            addCriterion("type_gct between", value1, value2, "typeGct");
            return (Criteria) this;
        }

        public Criteria andTypeGctNotBetween(Date value1, Date value2) {
            addCriterion("type_gct not between", value1, value2, "typeGct");
            return (Criteria) this;
        }

        public Criteria andTypeGmtIsNull() {
            addCriterion("type_gmt is null");
            return (Criteria) this;
        }

        public Criteria andTypeGmtIsNotNull() {
            addCriterion("type_gmt is not null");
            return (Criteria) this;
        }

        public Criteria andTypeGmtEqualTo(Date value) {
            addCriterion("type_gmt =", value, "typeGmt");
            return (Criteria) this;
        }

        public Criteria andTypeGmtNotEqualTo(Date value) {
            addCriterion("type_gmt <>", value, "typeGmt");
            return (Criteria) this;
        }

        public Criteria andTypeGmtGreaterThan(Date value) {
            addCriterion("type_gmt >", value, "typeGmt");
            return (Criteria) this;
        }

        public Criteria andTypeGmtGreaterThanOrEqualTo(Date value) {
            addCriterion("type_gmt >=", value, "typeGmt");
            return (Criteria) this;
        }

        public Criteria andTypeGmtLessThan(Date value) {
            addCriterion("type_gmt <", value, "typeGmt");
            return (Criteria) this;
        }

        public Criteria andTypeGmtLessThanOrEqualTo(Date value) {
            addCriterion("type_gmt <=", value, "typeGmt");
            return (Criteria) this;
        }

        public Criteria andTypeGmtIn(List<Date> values) {
            addCriterion("type_gmt in", values, "typeGmt");
            return (Criteria) this;
        }

        public Criteria andTypeGmtNotIn(List<Date> values) {
            addCriterion("type_gmt not in", values, "typeGmt");
            return (Criteria) this;
        }

        public Criteria andTypeGmtBetween(Date value1, Date value2) {
            addCriterion("type_gmt between", value1, value2, "typeGmt");
            return (Criteria) this;
        }

        public Criteria andTypeGmtNotBetween(Date value1, Date value2) {
            addCriterion("type_gmt not between", value1, value2, "typeGmt");
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