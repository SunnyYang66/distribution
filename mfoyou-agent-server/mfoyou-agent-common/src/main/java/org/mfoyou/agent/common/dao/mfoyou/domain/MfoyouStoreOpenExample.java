package org.mfoyou.agent.common.dao.mfoyou.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class MfoyouStoreOpenExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    protected Integer limitStart;

    protected Integer limitEnd;

    public MfoyouStoreOpenExample() {
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

        public Criteria andOpenIdIsNull() {
            addCriterion("open_id is null");
            return (Criteria) this;
        }

        public Criteria andOpenIdIsNotNull() {
            addCriterion("open_id is not null");
            return (Criteria) this;
        }

        public Criteria andOpenIdEqualTo(Integer value) {
            addCriterion("open_id =", value, "openId");
            return (Criteria) this;
        }

        public Criteria andOpenIdNotEqualTo(Integer value) {
            addCriterion("open_id <>", value, "openId");
            return (Criteria) this;
        }

        public Criteria andOpenIdGreaterThan(Integer value) {
            addCriterion("open_id >", value, "openId");
            return (Criteria) this;
        }

        public Criteria andOpenIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("open_id >=", value, "openId");
            return (Criteria) this;
        }

        public Criteria andOpenIdLessThan(Integer value) {
            addCriterion("open_id <", value, "openId");
            return (Criteria) this;
        }

        public Criteria andOpenIdLessThanOrEqualTo(Integer value) {
            addCriterion("open_id <=", value, "openId");
            return (Criteria) this;
        }

        public Criteria andOpenIdIn(List<Integer> values) {
            addCriterion("open_id in", values, "openId");
            return (Criteria) this;
        }

        public Criteria andOpenIdNotIn(List<Integer> values) {
            addCriterion("open_id not in", values, "openId");
            return (Criteria) this;
        }

        public Criteria andOpenIdBetween(Integer value1, Integer value2) {
            addCriterion("open_id between", value1, value2, "openId");
            return (Criteria) this;
        }

        public Criteria andOpenIdNotBetween(Integer value1, Integer value2) {
            addCriterion("open_id not between", value1, value2, "openId");
            return (Criteria) this;
        }

        public Criteria andOpenStartTimeIsNull() {
            addCriterion("open_start_time is null");
            return (Criteria) this;
        }

        public Criteria andOpenStartTimeIsNotNull() {
            addCriterion("open_start_time is not null");
            return (Criteria) this;
        }

        public Criteria andOpenStartTimeEqualTo(Integer value) {
            addCriterion("open_start_time =", value, "openStartTime");
            return (Criteria) this;
        }

        public Criteria andOpenStartTimeNotEqualTo(Integer value) {
            addCriterion("open_start_time <>", value, "openStartTime");
            return (Criteria) this;
        }

        public Criteria andOpenStartTimeGreaterThan(Integer value) {
            addCriterion("open_start_time >", value, "openStartTime");
            return (Criteria) this;
        }

        public Criteria andOpenStartTimeGreaterThanOrEqualTo(Integer value) {
            addCriterion("open_start_time >=", value, "openStartTime");
            return (Criteria) this;
        }

        public Criteria andOpenStartTimeLessThan(Integer value) {
            addCriterion("open_start_time <", value, "openStartTime");
            return (Criteria) this;
        }

        public Criteria andOpenStartTimeLessThanOrEqualTo(Integer value) {
            addCriterion("open_start_time <=", value, "openStartTime");
            return (Criteria) this;
        }

        public Criteria andOpenStartTimeIn(List<Integer> values) {
            addCriterion("open_start_time in", values, "openStartTime");
            return (Criteria) this;
        }

        public Criteria andOpenStartTimeNotIn(List<Integer> values) {
            addCriterion("open_start_time not in", values, "openStartTime");
            return (Criteria) this;
        }

        public Criteria andOpenStartTimeBetween(Integer value1, Integer value2) {
            addCriterion("open_start_time between", value1, value2, "openStartTime");
            return (Criteria) this;
        }

        public Criteria andOpenStartTimeNotBetween(Integer value1, Integer value2) {
            addCriterion("open_start_time not between", value1, value2, "openStartTime");
            return (Criteria) this;
        }

        public Criteria andOpenEndTimeIsNull() {
            addCriterion("open_end_time is null");
            return (Criteria) this;
        }

        public Criteria andOpenEndTimeIsNotNull() {
            addCriterion("open_end_time is not null");
            return (Criteria) this;
        }

        public Criteria andOpenEndTimeEqualTo(Integer value) {
            addCriterion("open_end_time =", value, "openEndTime");
            return (Criteria) this;
        }

        public Criteria andOpenEndTimeNotEqualTo(Integer value) {
            addCriterion("open_end_time <>", value, "openEndTime");
            return (Criteria) this;
        }

        public Criteria andOpenEndTimeGreaterThan(Integer value) {
            addCriterion("open_end_time >", value, "openEndTime");
            return (Criteria) this;
        }

        public Criteria andOpenEndTimeGreaterThanOrEqualTo(Integer value) {
            addCriterion("open_end_time >=", value, "openEndTime");
            return (Criteria) this;
        }

        public Criteria andOpenEndTimeLessThan(Integer value) {
            addCriterion("open_end_time <", value, "openEndTime");
            return (Criteria) this;
        }

        public Criteria andOpenEndTimeLessThanOrEqualTo(Integer value) {
            addCriterion("open_end_time <=", value, "openEndTime");
            return (Criteria) this;
        }

        public Criteria andOpenEndTimeIn(List<Integer> values) {
            addCriterion("open_end_time in", values, "openEndTime");
            return (Criteria) this;
        }

        public Criteria andOpenEndTimeNotIn(List<Integer> values) {
            addCriterion("open_end_time not in", values, "openEndTime");
            return (Criteria) this;
        }

        public Criteria andOpenEndTimeBetween(Integer value1, Integer value2) {
            addCriterion("open_end_time between", value1, value2, "openEndTime");
            return (Criteria) this;
        }

        public Criteria andOpenEndTimeNotBetween(Integer value1, Integer value2) {
            addCriterion("open_end_time not between", value1, value2, "openEndTime");
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

        public Criteria andOpenEffectIsNull() {
            addCriterion("open_effect is null");
            return (Criteria) this;
        }

        public Criteria andOpenEffectIsNotNull() {
            addCriterion("open_effect is not null");
            return (Criteria) this;
        }

        public Criteria andOpenEffectEqualTo(Integer value) {
            addCriterion("open_effect =", value, "openEffect");
            return (Criteria) this;
        }

        public Criteria andOpenEffectNotEqualTo(Integer value) {
            addCriterion("open_effect <>", value, "openEffect");
            return (Criteria) this;
        }

        public Criteria andOpenEffectGreaterThan(Integer value) {
            addCriterion("open_effect >", value, "openEffect");
            return (Criteria) this;
        }

        public Criteria andOpenEffectGreaterThanOrEqualTo(Integer value) {
            addCriterion("open_effect >=", value, "openEffect");
            return (Criteria) this;
        }

        public Criteria andOpenEffectLessThan(Integer value) {
            addCriterion("open_effect <", value, "openEffect");
            return (Criteria) this;
        }

        public Criteria andOpenEffectLessThanOrEqualTo(Integer value) {
            addCriterion("open_effect <=", value, "openEffect");
            return (Criteria) this;
        }

        public Criteria andOpenEffectIn(List<Integer> values) {
            addCriterion("open_effect in", values, "openEffect");
            return (Criteria) this;
        }

        public Criteria andOpenEffectNotIn(List<Integer> values) {
            addCriterion("open_effect not in", values, "openEffect");
            return (Criteria) this;
        }

        public Criteria andOpenEffectBetween(Integer value1, Integer value2) {
            addCriterion("open_effect between", value1, value2, "openEffect");
            return (Criteria) this;
        }

        public Criteria andOpenEffectNotBetween(Integer value1, Integer value2) {
            addCriterion("open_effect not between", value1, value2, "openEffect");
            return (Criteria) this;
        }

        public Criteria andOpenGctIsNull() {
            addCriterion("open_gct is null");
            return (Criteria) this;
        }

        public Criteria andOpenGctIsNotNull() {
            addCriterion("open_gct is not null");
            return (Criteria) this;
        }

        public Criteria andOpenGctEqualTo(Date value) {
            addCriterion("open_gct =", value, "openGct");
            return (Criteria) this;
        }

        public Criteria andOpenGctNotEqualTo(Date value) {
            addCriterion("open_gct <>", value, "openGct");
            return (Criteria) this;
        }

        public Criteria andOpenGctGreaterThan(Date value) {
            addCriterion("open_gct >", value, "openGct");
            return (Criteria) this;
        }

        public Criteria andOpenGctGreaterThanOrEqualTo(Date value) {
            addCriterion("open_gct >=", value, "openGct");
            return (Criteria) this;
        }

        public Criteria andOpenGctLessThan(Date value) {
            addCriterion("open_gct <", value, "openGct");
            return (Criteria) this;
        }

        public Criteria andOpenGctLessThanOrEqualTo(Date value) {
            addCriterion("open_gct <=", value, "openGct");
            return (Criteria) this;
        }

        public Criteria andOpenGctIn(List<Date> values) {
            addCriterion("open_gct in", values, "openGct");
            return (Criteria) this;
        }

        public Criteria andOpenGctNotIn(List<Date> values) {
            addCriterion("open_gct not in", values, "openGct");
            return (Criteria) this;
        }

        public Criteria andOpenGctBetween(Date value1, Date value2) {
            addCriterion("open_gct between", value1, value2, "openGct");
            return (Criteria) this;
        }

        public Criteria andOpenGctNotBetween(Date value1, Date value2) {
            addCriterion("open_gct not between", value1, value2, "openGct");
            return (Criteria) this;
        }

        public Criteria andOpenGmtIsNull() {
            addCriterion("open_gmt is null");
            return (Criteria) this;
        }

        public Criteria andOpenGmtIsNotNull() {
            addCriterion("open_gmt is not null");
            return (Criteria) this;
        }

        public Criteria andOpenGmtEqualTo(Date value) {
            addCriterion("open_gmt =", value, "openGmt");
            return (Criteria) this;
        }

        public Criteria andOpenGmtNotEqualTo(Date value) {
            addCriterion("open_gmt <>", value, "openGmt");
            return (Criteria) this;
        }

        public Criteria andOpenGmtGreaterThan(Date value) {
            addCriterion("open_gmt >", value, "openGmt");
            return (Criteria) this;
        }

        public Criteria andOpenGmtGreaterThanOrEqualTo(Date value) {
            addCriterion("open_gmt >=", value, "openGmt");
            return (Criteria) this;
        }

        public Criteria andOpenGmtLessThan(Date value) {
            addCriterion("open_gmt <", value, "openGmt");
            return (Criteria) this;
        }

        public Criteria andOpenGmtLessThanOrEqualTo(Date value) {
            addCriterion("open_gmt <=", value, "openGmt");
            return (Criteria) this;
        }

        public Criteria andOpenGmtIn(List<Date> values) {
            addCriterion("open_gmt in", values, "openGmt");
            return (Criteria) this;
        }

        public Criteria andOpenGmtNotIn(List<Date> values) {
            addCriterion("open_gmt not in", values, "openGmt");
            return (Criteria) this;
        }

        public Criteria andOpenGmtBetween(Date value1, Date value2) {
            addCriterion("open_gmt between", value1, value2, "openGmt");
            return (Criteria) this;
        }

        public Criteria andOpenGmtNotBetween(Date value1, Date value2) {
            addCriterion("open_gmt not between", value1, value2, "openGmt");
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