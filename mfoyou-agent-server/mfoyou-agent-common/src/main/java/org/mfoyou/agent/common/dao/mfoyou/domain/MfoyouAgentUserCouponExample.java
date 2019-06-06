package org.mfoyou.agent.common.dao.mfoyou.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class MfoyouAgentUserCouponExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    protected Integer limitStart;

    protected Integer limitEnd;

    public MfoyouAgentUserCouponExample() {
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

        public Criteria andTouchIdIsNull() {
            addCriterion("touch_id is null");
            return (Criteria) this;
        }

        public Criteria andTouchIdIsNotNull() {
            addCriterion("touch_id is not null");
            return (Criteria) this;
        }

        public Criteria andTouchIdEqualTo(Integer value) {
            addCriterion("touch_id =", value, "touchId");
            return (Criteria) this;
        }

        public Criteria andTouchIdNotEqualTo(Integer value) {
            addCriterion("touch_id <>", value, "touchId");
            return (Criteria) this;
        }

        public Criteria andTouchIdGreaterThan(Integer value) {
            addCriterion("touch_id >", value, "touchId");
            return (Criteria) this;
        }

        public Criteria andTouchIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("touch_id >=", value, "touchId");
            return (Criteria) this;
        }

        public Criteria andTouchIdLessThan(Integer value) {
            addCriterion("touch_id <", value, "touchId");
            return (Criteria) this;
        }

        public Criteria andTouchIdLessThanOrEqualTo(Integer value) {
            addCriterion("touch_id <=", value, "touchId");
            return (Criteria) this;
        }

        public Criteria andTouchIdIn(List<Integer> values) {
            addCriterion("touch_id in", values, "touchId");
            return (Criteria) this;
        }

        public Criteria andTouchIdNotIn(List<Integer> values) {
            addCriterion("touch_id not in", values, "touchId");
            return (Criteria) this;
        }

        public Criteria andTouchIdBetween(Integer value1, Integer value2) {
            addCriterion("touch_id between", value1, value2, "touchId");
            return (Criteria) this;
        }

        public Criteria andTouchIdNotBetween(Integer value1, Integer value2) {
            addCriterion("touch_id not between", value1, value2, "touchId");
            return (Criteria) this;
        }

        public Criteria andCouponIdIsNull() {
            addCriterion("coupon_id is null");
            return (Criteria) this;
        }

        public Criteria andCouponIdIsNotNull() {
            addCriterion("coupon_id is not null");
            return (Criteria) this;
        }

        public Criteria andCouponIdEqualTo(Integer value) {
            addCriterion("coupon_id =", value, "couponId");
            return (Criteria) this;
        }

        public Criteria andCouponIdNotEqualTo(Integer value) {
            addCriterion("coupon_id <>", value, "couponId");
            return (Criteria) this;
        }

        public Criteria andCouponIdGreaterThan(Integer value) {
            addCriterion("coupon_id >", value, "couponId");
            return (Criteria) this;
        }

        public Criteria andCouponIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("coupon_id >=", value, "couponId");
            return (Criteria) this;
        }

        public Criteria andCouponIdLessThan(Integer value) {
            addCriterion("coupon_id <", value, "couponId");
            return (Criteria) this;
        }

        public Criteria andCouponIdLessThanOrEqualTo(Integer value) {
            addCriterion("coupon_id <=", value, "couponId");
            return (Criteria) this;
        }

        public Criteria andCouponIdIn(List<Integer> values) {
            addCriterion("coupon_id in", values, "couponId");
            return (Criteria) this;
        }

        public Criteria andCouponIdNotIn(List<Integer> values) {
            addCriterion("coupon_id not in", values, "couponId");
            return (Criteria) this;
        }

        public Criteria andCouponIdBetween(Integer value1, Integer value2) {
            addCriterion("coupon_id between", value1, value2, "couponId");
            return (Criteria) this;
        }

        public Criteria andCouponIdNotBetween(Integer value1, Integer value2) {
            addCriterion("coupon_id not between", value1, value2, "couponId");
            return (Criteria) this;
        }

        public Criteria andCouponTextIsNull() {
            addCriterion("coupon_text is null");
            return (Criteria) this;
        }

        public Criteria andCouponTextIsNotNull() {
            addCriterion("coupon_text is not null");
            return (Criteria) this;
        }

        public Criteria andCouponTextEqualTo(String value) {
            addCriterion("coupon_text =", value, "couponText");
            return (Criteria) this;
        }

        public Criteria andCouponTextNotEqualTo(String value) {
            addCriterion("coupon_text <>", value, "couponText");
            return (Criteria) this;
        }

        public Criteria andCouponTextGreaterThan(String value) {
            addCriterion("coupon_text >", value, "couponText");
            return (Criteria) this;
        }

        public Criteria andCouponTextGreaterThanOrEqualTo(String value) {
            addCriterion("coupon_text >=", value, "couponText");
            return (Criteria) this;
        }

        public Criteria andCouponTextLessThan(String value) {
            addCriterion("coupon_text <", value, "couponText");
            return (Criteria) this;
        }

        public Criteria andCouponTextLessThanOrEqualTo(String value) {
            addCriterion("coupon_text <=", value, "couponText");
            return (Criteria) this;
        }

        public Criteria andCouponTextLike(String value) {
            addCriterion("coupon_text like", value, "couponText");
            return (Criteria) this;
        }

        public Criteria andCouponTextNotLike(String value) {
            addCriterion("coupon_text not like", value, "couponText");
            return (Criteria) this;
        }

        public Criteria andCouponTextIn(List<String> values) {
            addCriterion("coupon_text in", values, "couponText");
            return (Criteria) this;
        }

        public Criteria andCouponTextNotIn(List<String> values) {
            addCriterion("coupon_text not in", values, "couponText");
            return (Criteria) this;
        }

        public Criteria andCouponTextBetween(String value1, String value2) {
            addCriterion("coupon_text between", value1, value2, "couponText");
            return (Criteria) this;
        }

        public Criteria andCouponTextNotBetween(String value1, String value2) {
            addCriterion("coupon_text not between", value1, value2, "couponText");
            return (Criteria) this;
        }

        public Criteria andTouchStateIsNull() {
            addCriterion("touch_state is null");
            return (Criteria) this;
        }

        public Criteria andTouchStateIsNotNull() {
            addCriterion("touch_state is not null");
            return (Criteria) this;
        }

        public Criteria andTouchStateEqualTo(Integer value) {
            addCriterion("touch_state =", value, "touchState");
            return (Criteria) this;
        }

        public Criteria andTouchStateNotEqualTo(Integer value) {
            addCriterion("touch_state <>", value, "touchState");
            return (Criteria) this;
        }

        public Criteria andTouchStateGreaterThan(Integer value) {
            addCriterion("touch_state >", value, "touchState");
            return (Criteria) this;
        }

        public Criteria andTouchStateGreaterThanOrEqualTo(Integer value) {
            addCriterion("touch_state >=", value, "touchState");
            return (Criteria) this;
        }

        public Criteria andTouchStateLessThan(Integer value) {
            addCriterion("touch_state <", value, "touchState");
            return (Criteria) this;
        }

        public Criteria andTouchStateLessThanOrEqualTo(Integer value) {
            addCriterion("touch_state <=", value, "touchState");
            return (Criteria) this;
        }

        public Criteria andTouchStateIn(List<Integer> values) {
            addCriterion("touch_state in", values, "touchState");
            return (Criteria) this;
        }

        public Criteria andTouchStateNotIn(List<Integer> values) {
            addCriterion("touch_state not in", values, "touchState");
            return (Criteria) this;
        }

        public Criteria andTouchStateBetween(Integer value1, Integer value2) {
            addCriterion("touch_state between", value1, value2, "touchState");
            return (Criteria) this;
        }

        public Criteria andTouchStateNotBetween(Integer value1, Integer value2) {
            addCriterion("touch_state not between", value1, value2, "touchState");
            return (Criteria) this;
        }

        public Criteria andUserIdIsNull() {
            addCriterion("user_id is null");
            return (Criteria) this;
        }

        public Criteria andUserIdIsNotNull() {
            addCriterion("user_id is not null");
            return (Criteria) this;
        }

        public Criteria andUserIdEqualTo(Integer value) {
            addCriterion("user_id =", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotEqualTo(Integer value) {
            addCriterion("user_id <>", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdGreaterThan(Integer value) {
            addCriterion("user_id >", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("user_id >=", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLessThan(Integer value) {
            addCriterion("user_id <", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLessThanOrEqualTo(Integer value) {
            addCriterion("user_id <=", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdIn(List<Integer> values) {
            addCriterion("user_id in", values, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotIn(List<Integer> values) {
            addCriterion("user_id not in", values, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdBetween(Integer value1, Integer value2) {
            addCriterion("user_id between", value1, value2, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotBetween(Integer value1, Integer value2) {
            addCriterion("user_id not between", value1, value2, "userId");
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