package org.mfoyou.agent.common.dao.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class HuawuServiceTagExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    protected Integer limitStart;

    protected Integer limitEnd;

    public HuawuServiceTagExample() {
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

        public Criteria andServiceTagIdIsNull() {
            addCriterion("service_tag_id is null");
            return (Criteria) this;
        }

        public Criteria andServiceTagIdIsNotNull() {
            addCriterion("service_tag_id is not null");
            return (Criteria) this;
        }

        public Criteria andServiceTagIdEqualTo(Integer value) {
            addCriterion("service_tag_id =", value, "serviceTagId");
            return (Criteria) this;
        }

        public Criteria andServiceTagIdNotEqualTo(Integer value) {
            addCriterion("service_tag_id <>", value, "serviceTagId");
            return (Criteria) this;
        }

        public Criteria andServiceTagIdGreaterThan(Integer value) {
            addCriterion("service_tag_id >", value, "serviceTagId");
            return (Criteria) this;
        }

        public Criteria andServiceTagIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("service_tag_id >=", value, "serviceTagId");
            return (Criteria) this;
        }

        public Criteria andServiceTagIdLessThan(Integer value) {
            addCriterion("service_tag_id <", value, "serviceTagId");
            return (Criteria) this;
        }

        public Criteria andServiceTagIdLessThanOrEqualTo(Integer value) {
            addCriterion("service_tag_id <=", value, "serviceTagId");
            return (Criteria) this;
        }

        public Criteria andServiceTagIdIn(List<Integer> values) {
            addCriterion("service_tag_id in", values, "serviceTagId");
            return (Criteria) this;
        }

        public Criteria andServiceTagIdNotIn(List<Integer> values) {
            addCriterion("service_tag_id not in", values, "serviceTagId");
            return (Criteria) this;
        }

        public Criteria andServiceTagIdBetween(Integer value1, Integer value2) {
            addCriterion("service_tag_id between", value1, value2, "serviceTagId");
            return (Criteria) this;
        }

        public Criteria andServiceTagIdNotBetween(Integer value1, Integer value2) {
            addCriterion("service_tag_id not between", value1, value2, "serviceTagId");
            return (Criteria) this;
        }

        public Criteria andServiceTagTypeIsNull() {
            addCriterion("service_tag_type is null");
            return (Criteria) this;
        }

        public Criteria andServiceTagTypeIsNotNull() {
            addCriterion("service_tag_type is not null");
            return (Criteria) this;
        }

        public Criteria andServiceTagTypeEqualTo(Integer value) {
            addCriterion("service_tag_type =", value, "serviceTagType");
            return (Criteria) this;
        }

        public Criteria andServiceTagTypeNotEqualTo(Integer value) {
            addCriterion("service_tag_type <>", value, "serviceTagType");
            return (Criteria) this;
        }

        public Criteria andServiceTagTypeGreaterThan(Integer value) {
            addCriterion("service_tag_type >", value, "serviceTagType");
            return (Criteria) this;
        }

        public Criteria andServiceTagTypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("service_tag_type >=", value, "serviceTagType");
            return (Criteria) this;
        }

        public Criteria andServiceTagTypeLessThan(Integer value) {
            addCriterion("service_tag_type <", value, "serviceTagType");
            return (Criteria) this;
        }

        public Criteria andServiceTagTypeLessThanOrEqualTo(Integer value) {
            addCriterion("service_tag_type <=", value, "serviceTagType");
            return (Criteria) this;
        }

        public Criteria andServiceTagTypeIn(List<Integer> values) {
            addCriterion("service_tag_type in", values, "serviceTagType");
            return (Criteria) this;
        }

        public Criteria andServiceTagTypeNotIn(List<Integer> values) {
            addCriterion("service_tag_type not in", values, "serviceTagType");
            return (Criteria) this;
        }

        public Criteria andServiceTagTypeBetween(Integer value1, Integer value2) {
            addCriterion("service_tag_type between", value1, value2, "serviceTagType");
            return (Criteria) this;
        }

        public Criteria andServiceTagTypeNotBetween(Integer value1, Integer value2) {
            addCriterion("service_tag_type not between", value1, value2, "serviceTagType");
            return (Criteria) this;
        }

        public Criteria andServiceTagModeIsNull() {
            addCriterion("service_tag_mode is null");
            return (Criteria) this;
        }

        public Criteria andServiceTagModeIsNotNull() {
            addCriterion("service_tag_mode is not null");
            return (Criteria) this;
        }

        public Criteria andServiceTagModeEqualTo(Integer value) {
            addCriterion("service_tag_mode =", value, "serviceTagMode");
            return (Criteria) this;
        }

        public Criteria andServiceTagModeNotEqualTo(Integer value) {
            addCriterion("service_tag_mode <>", value, "serviceTagMode");
            return (Criteria) this;
        }

        public Criteria andServiceTagModeGreaterThan(Integer value) {
            addCriterion("service_tag_mode >", value, "serviceTagMode");
            return (Criteria) this;
        }

        public Criteria andServiceTagModeGreaterThanOrEqualTo(Integer value) {
            addCriterion("service_tag_mode >=", value, "serviceTagMode");
            return (Criteria) this;
        }

        public Criteria andServiceTagModeLessThan(Integer value) {
            addCriterion("service_tag_mode <", value, "serviceTagMode");
            return (Criteria) this;
        }

        public Criteria andServiceTagModeLessThanOrEqualTo(Integer value) {
            addCriterion("service_tag_mode <=", value, "serviceTagMode");
            return (Criteria) this;
        }

        public Criteria andServiceTagModeIn(List<Integer> values) {
            addCriterion("service_tag_mode in", values, "serviceTagMode");
            return (Criteria) this;
        }

        public Criteria andServiceTagModeNotIn(List<Integer> values) {
            addCriterion("service_tag_mode not in", values, "serviceTagMode");
            return (Criteria) this;
        }

        public Criteria andServiceTagModeBetween(Integer value1, Integer value2) {
            addCriterion("service_tag_mode between", value1, value2, "serviceTagMode");
            return (Criteria) this;
        }

        public Criteria andServiceTagModeNotBetween(Integer value1, Integer value2) {
            addCriterion("service_tag_mode not between", value1, value2, "serviceTagMode");
            return (Criteria) this;
        }

        public Criteria andServiceTagNameIsNull() {
            addCriterion("service_tag_name is null");
            return (Criteria) this;
        }

        public Criteria andServiceTagNameIsNotNull() {
            addCriterion("service_tag_name is not null");
            return (Criteria) this;
        }

        public Criteria andServiceTagNameEqualTo(String value) {
            addCriterion("service_tag_name =", value, "serviceTagName");
            return (Criteria) this;
        }

        public Criteria andServiceTagNameNotEqualTo(String value) {
            addCriterion("service_tag_name <>", value, "serviceTagName");
            return (Criteria) this;
        }

        public Criteria andServiceTagNameGreaterThan(String value) {
            addCriterion("service_tag_name >", value, "serviceTagName");
            return (Criteria) this;
        }

        public Criteria andServiceTagNameGreaterThanOrEqualTo(String value) {
            addCriterion("service_tag_name >=", value, "serviceTagName");
            return (Criteria) this;
        }

        public Criteria andServiceTagNameLessThan(String value) {
            addCriterion("service_tag_name <", value, "serviceTagName");
            return (Criteria) this;
        }

        public Criteria andServiceTagNameLessThanOrEqualTo(String value) {
            addCriterion("service_tag_name <=", value, "serviceTagName");
            return (Criteria) this;
        }

        public Criteria andServiceTagNameLike(String value) {
            addCriterion("service_tag_name like", value, "serviceTagName");
            return (Criteria) this;
        }

        public Criteria andServiceTagNameNotLike(String value) {
            addCriterion("service_tag_name not like", value, "serviceTagName");
            return (Criteria) this;
        }

        public Criteria andServiceTagNameIn(List<String> values) {
            addCriterion("service_tag_name in", values, "serviceTagName");
            return (Criteria) this;
        }

        public Criteria andServiceTagNameNotIn(List<String> values) {
            addCriterion("service_tag_name not in", values, "serviceTagName");
            return (Criteria) this;
        }

        public Criteria andServiceTagNameBetween(String value1, String value2) {
            addCriterion("service_tag_name between", value1, value2, "serviceTagName");
            return (Criteria) this;
        }

        public Criteria andServiceTagNameNotBetween(String value1, String value2) {
            addCriterion("service_tag_name not between", value1, value2, "serviceTagName");
            return (Criteria) this;
        }

        public Criteria andServiceTagAmountIsNull() {
            addCriterion("service_tag_amount is null");
            return (Criteria) this;
        }

        public Criteria andServiceTagAmountIsNotNull() {
            addCriterion("service_tag_amount is not null");
            return (Criteria) this;
        }

        public Criteria andServiceTagAmountEqualTo(Integer value) {
            addCriterion("service_tag_amount =", value, "serviceTagAmount");
            return (Criteria) this;
        }

        public Criteria andServiceTagAmountNotEqualTo(Integer value) {
            addCriterion("service_tag_amount <>", value, "serviceTagAmount");
            return (Criteria) this;
        }

        public Criteria andServiceTagAmountGreaterThan(Integer value) {
            addCriterion("service_tag_amount >", value, "serviceTagAmount");
            return (Criteria) this;
        }

        public Criteria andServiceTagAmountGreaterThanOrEqualTo(Integer value) {
            addCriterion("service_tag_amount >=", value, "serviceTagAmount");
            return (Criteria) this;
        }

        public Criteria andServiceTagAmountLessThan(Integer value) {
            addCriterion("service_tag_amount <", value, "serviceTagAmount");
            return (Criteria) this;
        }

        public Criteria andServiceTagAmountLessThanOrEqualTo(Integer value) {
            addCriterion("service_tag_amount <=", value, "serviceTagAmount");
            return (Criteria) this;
        }

        public Criteria andServiceTagAmountIn(List<Integer> values) {
            addCriterion("service_tag_amount in", values, "serviceTagAmount");
            return (Criteria) this;
        }

        public Criteria andServiceTagAmountNotIn(List<Integer> values) {
            addCriterion("service_tag_amount not in", values, "serviceTagAmount");
            return (Criteria) this;
        }

        public Criteria andServiceTagAmountBetween(Integer value1, Integer value2) {
            addCriterion("service_tag_amount between", value1, value2, "serviceTagAmount");
            return (Criteria) this;
        }

        public Criteria andServiceTagAmountNotBetween(Integer value1, Integer value2) {
            addCriterion("service_tag_amount not between", value1, value2, "serviceTagAmount");
            return (Criteria) this;
        }

        public Criteria andServiceTagPrefabIsNull() {
            addCriterion("service_tag_prefab is null");
            return (Criteria) this;
        }

        public Criteria andServiceTagPrefabIsNotNull() {
            addCriterion("service_tag_prefab is not null");
            return (Criteria) this;
        }

        public Criteria andServiceTagPrefabEqualTo(Integer value) {
            addCriterion("service_tag_prefab =", value, "serviceTagPrefab");
            return (Criteria) this;
        }

        public Criteria andServiceTagPrefabNotEqualTo(Integer value) {
            addCriterion("service_tag_prefab <>", value, "serviceTagPrefab");
            return (Criteria) this;
        }

        public Criteria andServiceTagPrefabGreaterThan(Integer value) {
            addCriterion("service_tag_prefab >", value, "serviceTagPrefab");
            return (Criteria) this;
        }

        public Criteria andServiceTagPrefabGreaterThanOrEqualTo(Integer value) {
            addCriterion("service_tag_prefab >=", value, "serviceTagPrefab");
            return (Criteria) this;
        }

        public Criteria andServiceTagPrefabLessThan(Integer value) {
            addCriterion("service_tag_prefab <", value, "serviceTagPrefab");
            return (Criteria) this;
        }

        public Criteria andServiceTagPrefabLessThanOrEqualTo(Integer value) {
            addCriterion("service_tag_prefab <=", value, "serviceTagPrefab");
            return (Criteria) this;
        }

        public Criteria andServiceTagPrefabIn(List<Integer> values) {
            addCriterion("service_tag_prefab in", values, "serviceTagPrefab");
            return (Criteria) this;
        }

        public Criteria andServiceTagPrefabNotIn(List<Integer> values) {
            addCriterion("service_tag_prefab not in", values, "serviceTagPrefab");
            return (Criteria) this;
        }

        public Criteria andServiceTagPrefabBetween(Integer value1, Integer value2) {
            addCriterion("service_tag_prefab between", value1, value2, "serviceTagPrefab");
            return (Criteria) this;
        }

        public Criteria andServiceTagPrefabNotBetween(Integer value1, Integer value2) {
            addCriterion("service_tag_prefab not between", value1, value2, "serviceTagPrefab");
            return (Criteria) this;
        }

        public Criteria andServiceTagUseTimesIsNull() {
            addCriterion("service_tag_use_times is null");
            return (Criteria) this;
        }

        public Criteria andServiceTagUseTimesIsNotNull() {
            addCriterion("service_tag_use_times is not null");
            return (Criteria) this;
        }

        public Criteria andServiceTagUseTimesEqualTo(Integer value) {
            addCriterion("service_tag_use_times =", value, "serviceTagUseTimes");
            return (Criteria) this;
        }

        public Criteria andServiceTagUseTimesNotEqualTo(Integer value) {
            addCriterion("service_tag_use_times <>", value, "serviceTagUseTimes");
            return (Criteria) this;
        }

        public Criteria andServiceTagUseTimesGreaterThan(Integer value) {
            addCriterion("service_tag_use_times >", value, "serviceTagUseTimes");
            return (Criteria) this;
        }

        public Criteria andServiceTagUseTimesGreaterThanOrEqualTo(Integer value) {
            addCriterion("service_tag_use_times >=", value, "serviceTagUseTimes");
            return (Criteria) this;
        }

        public Criteria andServiceTagUseTimesLessThan(Integer value) {
            addCriterion("service_tag_use_times <", value, "serviceTagUseTimes");
            return (Criteria) this;
        }

        public Criteria andServiceTagUseTimesLessThanOrEqualTo(Integer value) {
            addCriterion("service_tag_use_times <=", value, "serviceTagUseTimes");
            return (Criteria) this;
        }

        public Criteria andServiceTagUseTimesIn(List<Integer> values) {
            addCriterion("service_tag_use_times in", values, "serviceTagUseTimes");
            return (Criteria) this;
        }

        public Criteria andServiceTagUseTimesNotIn(List<Integer> values) {
            addCriterion("service_tag_use_times not in", values, "serviceTagUseTimes");
            return (Criteria) this;
        }

        public Criteria andServiceTagUseTimesBetween(Integer value1, Integer value2) {
            addCriterion("service_tag_use_times between", value1, value2, "serviceTagUseTimes");
            return (Criteria) this;
        }

        public Criteria andServiceTagUseTimesNotBetween(Integer value1, Integer value2) {
            addCriterion("service_tag_use_times not between", value1, value2, "serviceTagUseTimes");
            return (Criteria) this;
        }

        public Criteria andServiceTagCreateTimeIsNull() {
            addCriterion("service_tag_create_time is null");
            return (Criteria) this;
        }

        public Criteria andServiceTagCreateTimeIsNotNull() {
            addCriterion("service_tag_create_time is not null");
            return (Criteria) this;
        }

        public Criteria andServiceTagCreateTimeEqualTo(Date value) {
            addCriterion("service_tag_create_time =", value, "serviceTagCreateTime");
            return (Criteria) this;
        }

        public Criteria andServiceTagCreateTimeNotEqualTo(Date value) {
            addCriterion("service_tag_create_time <>", value, "serviceTagCreateTime");
            return (Criteria) this;
        }

        public Criteria andServiceTagCreateTimeGreaterThan(Date value) {
            addCriterion("service_tag_create_time >", value, "serviceTagCreateTime");
            return (Criteria) this;
        }

        public Criteria andServiceTagCreateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("service_tag_create_time >=", value, "serviceTagCreateTime");
            return (Criteria) this;
        }

        public Criteria andServiceTagCreateTimeLessThan(Date value) {
            addCriterion("service_tag_create_time <", value, "serviceTagCreateTime");
            return (Criteria) this;
        }

        public Criteria andServiceTagCreateTimeLessThanOrEqualTo(Date value) {
            addCriterion("service_tag_create_time <=", value, "serviceTagCreateTime");
            return (Criteria) this;
        }

        public Criteria andServiceTagCreateTimeIn(List<Date> values) {
            addCriterion("service_tag_create_time in", values, "serviceTagCreateTime");
            return (Criteria) this;
        }

        public Criteria andServiceTagCreateTimeNotIn(List<Date> values) {
            addCriterion("service_tag_create_time not in", values, "serviceTagCreateTime");
            return (Criteria) this;
        }

        public Criteria andServiceTagCreateTimeBetween(Date value1, Date value2) {
            addCriterion("service_tag_create_time between", value1, value2, "serviceTagCreateTime");
            return (Criteria) this;
        }

        public Criteria andServiceTagCreateTimeNotBetween(Date value1, Date value2) {
            addCriterion("service_tag_create_time not between", value1, value2, "serviceTagCreateTime");
            return (Criteria) this;
        }

        public Criteria andServiceTagDelFlagIsNull() {
            addCriterion("service_tag_del_flag is null");
            return (Criteria) this;
        }

        public Criteria andServiceTagDelFlagIsNotNull() {
            addCriterion("service_tag_del_flag is not null");
            return (Criteria) this;
        }

        public Criteria andServiceTagDelFlagEqualTo(Integer value) {
            addCriterion("service_tag_del_flag =", value, "serviceTagDelFlag");
            return (Criteria) this;
        }

        public Criteria andServiceTagDelFlagNotEqualTo(Integer value) {
            addCriterion("service_tag_del_flag <>", value, "serviceTagDelFlag");
            return (Criteria) this;
        }

        public Criteria andServiceTagDelFlagGreaterThan(Integer value) {
            addCriterion("service_tag_del_flag >", value, "serviceTagDelFlag");
            return (Criteria) this;
        }

        public Criteria andServiceTagDelFlagGreaterThanOrEqualTo(Integer value) {
            addCriterion("service_tag_del_flag >=", value, "serviceTagDelFlag");
            return (Criteria) this;
        }

        public Criteria andServiceTagDelFlagLessThan(Integer value) {
            addCriterion("service_tag_del_flag <", value, "serviceTagDelFlag");
            return (Criteria) this;
        }

        public Criteria andServiceTagDelFlagLessThanOrEqualTo(Integer value) {
            addCriterion("service_tag_del_flag <=", value, "serviceTagDelFlag");
            return (Criteria) this;
        }

        public Criteria andServiceTagDelFlagIn(List<Integer> values) {
            addCriterion("service_tag_del_flag in", values, "serviceTagDelFlag");
            return (Criteria) this;
        }

        public Criteria andServiceTagDelFlagNotIn(List<Integer> values) {
            addCriterion("service_tag_del_flag not in", values, "serviceTagDelFlag");
            return (Criteria) this;
        }

        public Criteria andServiceTagDelFlagBetween(Integer value1, Integer value2) {
            addCriterion("service_tag_del_flag between", value1, value2, "serviceTagDelFlag");
            return (Criteria) this;
        }

        public Criteria andServiceTagDelFlagNotBetween(Integer value1, Integer value2) {
            addCriterion("service_tag_del_flag not between", value1, value2, "serviceTagDelFlag");
            return (Criteria) this;
        }

        public Criteria andServiceTagPriceIsNull() {
            addCriterion("service_tag_price is null");
            return (Criteria) this;
        }

        public Criteria andServiceTagPriceIsNotNull() {
            addCriterion("service_tag_price is not null");
            return (Criteria) this;
        }

        public Criteria andServiceTagPriceEqualTo(String value) {
            addCriterion("service_tag_price =", value, "serviceTagPrice");
            return (Criteria) this;
        }

        public Criteria andServiceTagPriceNotEqualTo(String value) {
            addCriterion("service_tag_price <>", value, "serviceTagPrice");
            return (Criteria) this;
        }

        public Criteria andServiceTagPriceGreaterThan(String value) {
            addCriterion("service_tag_price >", value, "serviceTagPrice");
            return (Criteria) this;
        }

        public Criteria andServiceTagPriceGreaterThanOrEqualTo(String value) {
            addCriterion("service_tag_price >=", value, "serviceTagPrice");
            return (Criteria) this;
        }

        public Criteria andServiceTagPriceLessThan(String value) {
            addCriterion("service_tag_price <", value, "serviceTagPrice");
            return (Criteria) this;
        }

        public Criteria andServiceTagPriceLessThanOrEqualTo(String value) {
            addCriterion("service_tag_price <=", value, "serviceTagPrice");
            return (Criteria) this;
        }

        public Criteria andServiceTagPriceLike(String value) {
            addCriterion("service_tag_price like", value, "serviceTagPrice");
            return (Criteria) this;
        }

        public Criteria andServiceTagPriceNotLike(String value) {
            addCriterion("service_tag_price not like", value, "serviceTagPrice");
            return (Criteria) this;
        }

        public Criteria andServiceTagPriceIn(List<String> values) {
            addCriterion("service_tag_price in", values, "serviceTagPrice");
            return (Criteria) this;
        }

        public Criteria andServiceTagPriceNotIn(List<String> values) {
            addCriterion("service_tag_price not in", values, "serviceTagPrice");
            return (Criteria) this;
        }

        public Criteria andServiceTagPriceBetween(String value1, String value2) {
            addCriterion("service_tag_price between", value1, value2, "serviceTagPrice");
            return (Criteria) this;
        }

        public Criteria andServiceTagPriceNotBetween(String value1, String value2) {
            addCriterion("service_tag_price not between", value1, value2, "serviceTagPrice");
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