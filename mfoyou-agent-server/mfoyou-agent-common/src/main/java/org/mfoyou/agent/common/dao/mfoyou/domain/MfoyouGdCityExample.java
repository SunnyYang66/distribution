package org.mfoyou.agent.common.dao.mfoyou.domain;

import java.util.ArrayList;
import java.util.List;

public class MfoyouGdCityExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    protected Integer limitStart;

    protected Integer limitEnd;

    public MfoyouGdCityExample() {
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

        public Criteria andCityAdcodeIsNull() {
            addCriterion("city_adcode is null");
            return (Criteria) this;
        }

        public Criteria andCityAdcodeIsNotNull() {
            addCriterion("city_adcode is not null");
            return (Criteria) this;
        }

        public Criteria andCityAdcodeEqualTo(Integer value) {
            addCriterion("city_adcode =", value, "cityAdcode");
            return (Criteria) this;
        }

        public Criteria andCityAdcodeNotEqualTo(Integer value) {
            addCriterion("city_adcode <>", value, "cityAdcode");
            return (Criteria) this;
        }

        public Criteria andCityAdcodeGreaterThan(Integer value) {
            addCriterion("city_adcode >", value, "cityAdcode");
            return (Criteria) this;
        }

        public Criteria andCityAdcodeGreaterThanOrEqualTo(Integer value) {
            addCriterion("city_adcode >=", value, "cityAdcode");
            return (Criteria) this;
        }

        public Criteria andCityAdcodeLessThan(Integer value) {
            addCriterion("city_adcode <", value, "cityAdcode");
            return (Criteria) this;
        }

        public Criteria andCityAdcodeLessThanOrEqualTo(Integer value) {
            addCriterion("city_adcode <=", value, "cityAdcode");
            return (Criteria) this;
        }

        public Criteria andCityAdcodeIn(List<Integer> values) {
            addCriterion("city_adcode in", values, "cityAdcode");
            return (Criteria) this;
        }

        public Criteria andCityAdcodeNotIn(List<Integer> values) {
            addCriterion("city_adcode not in", values, "cityAdcode");
            return (Criteria) this;
        }

        public Criteria andCityAdcodeBetween(Integer value1, Integer value2) {
            addCriterion("city_adcode between", value1, value2, "cityAdcode");
            return (Criteria) this;
        }

        public Criteria andCityAdcodeNotBetween(Integer value1, Integer value2) {
            addCriterion("city_adcode not between", value1, value2, "cityAdcode");
            return (Criteria) this;
        }

        public Criteria andCityNameIsNull() {
            addCriterion("city_name is null");
            return (Criteria) this;
        }

        public Criteria andCityNameIsNotNull() {
            addCriterion("city_name is not null");
            return (Criteria) this;
        }

        public Criteria andCityNameEqualTo(String value) {
            addCriterion("city_name =", value, "cityName");
            return (Criteria) this;
        }

        public Criteria andCityNameNotEqualTo(String value) {
            addCriterion("city_name <>", value, "cityName");
            return (Criteria) this;
        }

        public Criteria andCityNameGreaterThan(String value) {
            addCriterion("city_name >", value, "cityName");
            return (Criteria) this;
        }

        public Criteria andCityNameGreaterThanOrEqualTo(String value) {
            addCriterion("city_name >=", value, "cityName");
            return (Criteria) this;
        }

        public Criteria andCityNameLessThan(String value) {
            addCriterion("city_name <", value, "cityName");
            return (Criteria) this;
        }

        public Criteria andCityNameLessThanOrEqualTo(String value) {
            addCriterion("city_name <=", value, "cityName");
            return (Criteria) this;
        }

        public Criteria andCityNameLike(String value) {
            addCriterion("city_name like", value, "cityName");
            return (Criteria) this;
        }

        public Criteria andCityNameNotLike(String value) {
            addCriterion("city_name not like", value, "cityName");
            return (Criteria) this;
        }

        public Criteria andCityNameIn(List<String> values) {
            addCriterion("city_name in", values, "cityName");
            return (Criteria) this;
        }

        public Criteria andCityNameNotIn(List<String> values) {
            addCriterion("city_name not in", values, "cityName");
            return (Criteria) this;
        }

        public Criteria andCityNameBetween(String value1, String value2) {
            addCriterion("city_name between", value1, value2, "cityName");
            return (Criteria) this;
        }

        public Criteria andCityNameNotBetween(String value1, String value2) {
            addCriterion("city_name not between", value1, value2, "cityName");
            return (Criteria) this;
        }

        public Criteria andCityCitycodeIsNull() {
            addCriterion("city_citycode is null");
            return (Criteria) this;
        }

        public Criteria andCityCitycodeIsNotNull() {
            addCriterion("city_citycode is not null");
            return (Criteria) this;
        }

        public Criteria andCityCitycodeEqualTo(String value) {
            addCriterion("city_citycode =", value, "cityCitycode");
            return (Criteria) this;
        }

        public Criteria andCityCitycodeNotEqualTo(String value) {
            addCriterion("city_citycode <>", value, "cityCitycode");
            return (Criteria) this;
        }

        public Criteria andCityCitycodeGreaterThan(String value) {
            addCriterion("city_citycode >", value, "cityCitycode");
            return (Criteria) this;
        }

        public Criteria andCityCitycodeGreaterThanOrEqualTo(String value) {
            addCriterion("city_citycode >=", value, "cityCitycode");
            return (Criteria) this;
        }

        public Criteria andCityCitycodeLessThan(String value) {
            addCriterion("city_citycode <", value, "cityCitycode");
            return (Criteria) this;
        }

        public Criteria andCityCitycodeLessThanOrEqualTo(String value) {
            addCriterion("city_citycode <=", value, "cityCitycode");
            return (Criteria) this;
        }

        public Criteria andCityCitycodeLike(String value) {
            addCriterion("city_citycode like", value, "cityCitycode");
            return (Criteria) this;
        }

        public Criteria andCityCitycodeNotLike(String value) {
            addCriterion("city_citycode not like", value, "cityCitycode");
            return (Criteria) this;
        }

        public Criteria andCityCitycodeIn(List<String> values) {
            addCriterion("city_citycode in", values, "cityCitycode");
            return (Criteria) this;
        }

        public Criteria andCityCitycodeNotIn(List<String> values) {
            addCriterion("city_citycode not in", values, "cityCitycode");
            return (Criteria) this;
        }

        public Criteria andCityCitycodeBetween(String value1, String value2) {
            addCriterion("city_citycode between", value1, value2, "cityCitycode");
            return (Criteria) this;
        }

        public Criteria andCityCitycodeNotBetween(String value1, String value2) {
            addCriterion("city_citycode not between", value1, value2, "cityCitycode");
            return (Criteria) this;
        }

        public Criteria andCityPyIsNull() {
            addCriterion("city_PY is null");
            return (Criteria) this;
        }

        public Criteria andCityPyIsNotNull() {
            addCriterion("city_PY is not null");
            return (Criteria) this;
        }

        public Criteria andCityPyEqualTo(String value) {
            addCriterion("city_PY =", value, "cityPy");
            return (Criteria) this;
        }

        public Criteria andCityPyNotEqualTo(String value) {
            addCriterion("city_PY <>", value, "cityPy");
            return (Criteria) this;
        }

        public Criteria andCityPyGreaterThan(String value) {
            addCriterion("city_PY >", value, "cityPy");
            return (Criteria) this;
        }

        public Criteria andCityPyGreaterThanOrEqualTo(String value) {
            addCriterion("city_PY >=", value, "cityPy");
            return (Criteria) this;
        }

        public Criteria andCityPyLessThan(String value) {
            addCriterion("city_PY <", value, "cityPy");
            return (Criteria) this;
        }

        public Criteria andCityPyLessThanOrEqualTo(String value) {
            addCriterion("city_PY <=", value, "cityPy");
            return (Criteria) this;
        }

        public Criteria andCityPyLike(String value) {
            addCriterion("city_PY like", value, "cityPy");
            return (Criteria) this;
        }

        public Criteria andCityPyNotLike(String value) {
            addCriterion("city_PY not like", value, "cityPy");
            return (Criteria) this;
        }

        public Criteria andCityPyIn(List<String> values) {
            addCriterion("city_PY in", values, "cityPy");
            return (Criteria) this;
        }

        public Criteria andCityPyNotIn(List<String> values) {
            addCriterion("city_PY not in", values, "cityPy");
            return (Criteria) this;
        }

        public Criteria andCityPyBetween(String value1, String value2) {
            addCriterion("city_PY between", value1, value2, "cityPy");
            return (Criteria) this;
        }

        public Criteria andCityPyNotBetween(String value1, String value2) {
            addCriterion("city_PY not between", value1, value2, "cityPy");
            return (Criteria) this;
        }

        public Criteria andCityLeveIsNull() {
            addCriterion("city_leve is null");
            return (Criteria) this;
        }

        public Criteria andCityLeveIsNotNull() {
            addCriterion("city_leve is not null");
            return (Criteria) this;
        }

        public Criteria andCityLeveEqualTo(Integer value) {
            addCriterion("city_leve =", value, "cityLeve");
            return (Criteria) this;
        }

        public Criteria andCityLeveNotEqualTo(Integer value) {
            addCriterion("city_leve <>", value, "cityLeve");
            return (Criteria) this;
        }

        public Criteria andCityLeveGreaterThan(Integer value) {
            addCriterion("city_leve >", value, "cityLeve");
            return (Criteria) this;
        }

        public Criteria andCityLeveGreaterThanOrEqualTo(Integer value) {
            addCriterion("city_leve >=", value, "cityLeve");
            return (Criteria) this;
        }

        public Criteria andCityLeveLessThan(Integer value) {
            addCriterion("city_leve <", value, "cityLeve");
            return (Criteria) this;
        }

        public Criteria andCityLeveLessThanOrEqualTo(Integer value) {
            addCriterion("city_leve <=", value, "cityLeve");
            return (Criteria) this;
        }

        public Criteria andCityLeveIn(List<Integer> values) {
            addCriterion("city_leve in", values, "cityLeve");
            return (Criteria) this;
        }

        public Criteria andCityLeveNotIn(List<Integer> values) {
            addCriterion("city_leve not in", values, "cityLeve");
            return (Criteria) this;
        }

        public Criteria andCityLeveBetween(Integer value1, Integer value2) {
            addCriterion("city_leve between", value1, value2, "cityLeve");
            return (Criteria) this;
        }

        public Criteria andCityLeveNotBetween(Integer value1, Integer value2) {
            addCriterion("city_leve not between", value1, value2, "cityLeve");
            return (Criteria) this;
        }

        public Criteria andCityParentIsNull() {
            addCriterion("city_parent is null");
            return (Criteria) this;
        }

        public Criteria andCityParentIsNotNull() {
            addCriterion("city_parent is not null");
            return (Criteria) this;
        }

        public Criteria andCityParentEqualTo(String value) {
            addCriterion("city_parent =", value, "cityParent");
            return (Criteria) this;
        }

        public Criteria andCityParentNotEqualTo(String value) {
            addCriterion("city_parent <>", value, "cityParent");
            return (Criteria) this;
        }

        public Criteria andCityParentGreaterThan(String value) {
            addCriterion("city_parent >", value, "cityParent");
            return (Criteria) this;
        }

        public Criteria andCityParentGreaterThanOrEqualTo(String value) {
            addCriterion("city_parent >=", value, "cityParent");
            return (Criteria) this;
        }

        public Criteria andCityParentLessThan(String value) {
            addCriterion("city_parent <", value, "cityParent");
            return (Criteria) this;
        }

        public Criteria andCityParentLessThanOrEqualTo(String value) {
            addCriterion("city_parent <=", value, "cityParent");
            return (Criteria) this;
        }

        public Criteria andCityParentLike(String value) {
            addCriterion("city_parent like", value, "cityParent");
            return (Criteria) this;
        }

        public Criteria andCityParentNotLike(String value) {
            addCriterion("city_parent not like", value, "cityParent");
            return (Criteria) this;
        }

        public Criteria andCityParentIn(List<String> values) {
            addCriterion("city_parent in", values, "cityParent");
            return (Criteria) this;
        }

        public Criteria andCityParentNotIn(List<String> values) {
            addCriterion("city_parent not in", values, "cityParent");
            return (Criteria) this;
        }

        public Criteria andCityParentBetween(String value1, String value2) {
            addCriterion("city_parent between", value1, value2, "cityParent");
            return (Criteria) this;
        }

        public Criteria andCityParentNotBetween(String value1, String value2) {
            addCriterion("city_parent not between", value1, value2, "cityParent");
            return (Criteria) this;
        }

        public Criteria andCityParentAdcodeIsNull() {
            addCriterion("city_parent_adcode is null");
            return (Criteria) this;
        }

        public Criteria andCityParentAdcodeIsNotNull() {
            addCriterion("city_parent_adcode is not null");
            return (Criteria) this;
        }

        public Criteria andCityParentAdcodeEqualTo(Integer value) {
            addCriterion("city_parent_adcode =", value, "cityParentAdcode");
            return (Criteria) this;
        }

        public Criteria andCityParentAdcodeNotEqualTo(Integer value) {
            addCriterion("city_parent_adcode <>", value, "cityParentAdcode");
            return (Criteria) this;
        }

        public Criteria andCityParentAdcodeGreaterThan(Integer value) {
            addCriterion("city_parent_adcode >", value, "cityParentAdcode");
            return (Criteria) this;
        }

        public Criteria andCityParentAdcodeGreaterThanOrEqualTo(Integer value) {
            addCriterion("city_parent_adcode >=", value, "cityParentAdcode");
            return (Criteria) this;
        }

        public Criteria andCityParentAdcodeLessThan(Integer value) {
            addCriterion("city_parent_adcode <", value, "cityParentAdcode");
            return (Criteria) this;
        }

        public Criteria andCityParentAdcodeLessThanOrEqualTo(Integer value) {
            addCriterion("city_parent_adcode <=", value, "cityParentAdcode");
            return (Criteria) this;
        }

        public Criteria andCityParentAdcodeIn(List<Integer> values) {
            addCriterion("city_parent_adcode in", values, "cityParentAdcode");
            return (Criteria) this;
        }

        public Criteria andCityParentAdcodeNotIn(List<Integer> values) {
            addCriterion("city_parent_adcode not in", values, "cityParentAdcode");
            return (Criteria) this;
        }

        public Criteria andCityParentAdcodeBetween(Integer value1, Integer value2) {
            addCriterion("city_parent_adcode between", value1, value2, "cityParentAdcode");
            return (Criteria) this;
        }

        public Criteria andCityParentAdcodeNotBetween(Integer value1, Integer value2) {
            addCriterion("city_parent_adcode not between", value1, value2, "cityParentAdcode");
            return (Criteria) this;
        }

        public Criteria andCityVisbleIsNull() {
            addCriterion("city_visble is null");
            return (Criteria) this;
        }

        public Criteria andCityVisbleIsNotNull() {
            addCriterion("city_visble is not null");
            return (Criteria) this;
        }

        public Criteria andCityVisbleEqualTo(Integer value) {
            addCriterion("city_visble =", value, "cityVisble");
            return (Criteria) this;
        }

        public Criteria andCityVisbleNotEqualTo(Integer value) {
            addCriterion("city_visble <>", value, "cityVisble");
            return (Criteria) this;
        }

        public Criteria andCityVisbleGreaterThan(Integer value) {
            addCriterion("city_visble >", value, "cityVisble");
            return (Criteria) this;
        }

        public Criteria andCityVisbleGreaterThanOrEqualTo(Integer value) {
            addCriterion("city_visble >=", value, "cityVisble");
            return (Criteria) this;
        }

        public Criteria andCityVisbleLessThan(Integer value) {
            addCriterion("city_visble <", value, "cityVisble");
            return (Criteria) this;
        }

        public Criteria andCityVisbleLessThanOrEqualTo(Integer value) {
            addCriterion("city_visble <=", value, "cityVisble");
            return (Criteria) this;
        }

        public Criteria andCityVisbleIn(List<Integer> values) {
            addCriterion("city_visble in", values, "cityVisble");
            return (Criteria) this;
        }

        public Criteria andCityVisbleNotIn(List<Integer> values) {
            addCriterion("city_visble not in", values, "cityVisble");
            return (Criteria) this;
        }

        public Criteria andCityVisbleBetween(Integer value1, Integer value2) {
            addCriterion("city_visble between", value1, value2, "cityVisble");
            return (Criteria) this;
        }

        public Criteria andCityVisbleNotBetween(Integer value1, Integer value2) {
            addCriterion("city_visble not between", value1, value2, "cityVisble");
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