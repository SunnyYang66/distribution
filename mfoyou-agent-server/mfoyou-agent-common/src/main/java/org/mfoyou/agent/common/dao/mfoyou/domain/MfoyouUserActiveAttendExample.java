package org.mfoyou.agent.common.dao.mfoyou.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class MfoyouUserActiveAttendExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    protected Integer limitStart;

    protected Integer limitEnd;

    public MfoyouUserActiveAttendExample() {
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

        public Criteria andAttendIdIsNull() {
            addCriterion("attend_id is null");
            return (Criteria) this;
        }

        public Criteria andAttendIdIsNotNull() {
            addCriterion("attend_id is not null");
            return (Criteria) this;
        }

        public Criteria andAttendIdEqualTo(Integer value) {
            addCriterion("attend_id =", value, "attendId");
            return (Criteria) this;
        }

        public Criteria andAttendIdNotEqualTo(Integer value) {
            addCriterion("attend_id <>", value, "attendId");
            return (Criteria) this;
        }

        public Criteria andAttendIdGreaterThan(Integer value) {
            addCriterion("attend_id >", value, "attendId");
            return (Criteria) this;
        }

        public Criteria andAttendIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("attend_id >=", value, "attendId");
            return (Criteria) this;
        }

        public Criteria andAttendIdLessThan(Integer value) {
            addCriterion("attend_id <", value, "attendId");
            return (Criteria) this;
        }

        public Criteria andAttendIdLessThanOrEqualTo(Integer value) {
            addCriterion("attend_id <=", value, "attendId");
            return (Criteria) this;
        }

        public Criteria andAttendIdIn(List<Integer> values) {
            addCriterion("attend_id in", values, "attendId");
            return (Criteria) this;
        }

        public Criteria andAttendIdNotIn(List<Integer> values) {
            addCriterion("attend_id not in", values, "attendId");
            return (Criteria) this;
        }

        public Criteria andAttendIdBetween(Integer value1, Integer value2) {
            addCriterion("attend_id between", value1, value2, "attendId");
            return (Criteria) this;
        }

        public Criteria andAttendIdNotBetween(Integer value1, Integer value2) {
            addCriterion("attend_id not between", value1, value2, "attendId");
            return (Criteria) this;
        }

        public Criteria andAttendUserIdIsNull() {
            addCriterion("attend_user_id is null");
            return (Criteria) this;
        }

        public Criteria andAttendUserIdIsNotNull() {
            addCriterion("attend_user_id is not null");
            return (Criteria) this;
        }

        public Criteria andAttendUserIdEqualTo(Integer value) {
            addCriterion("attend_user_id =", value, "attendUserId");
            return (Criteria) this;
        }

        public Criteria andAttendUserIdNotEqualTo(Integer value) {
            addCriterion("attend_user_id <>", value, "attendUserId");
            return (Criteria) this;
        }

        public Criteria andAttendUserIdGreaterThan(Integer value) {
            addCriterion("attend_user_id >", value, "attendUserId");
            return (Criteria) this;
        }

        public Criteria andAttendUserIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("attend_user_id >=", value, "attendUserId");
            return (Criteria) this;
        }

        public Criteria andAttendUserIdLessThan(Integer value) {
            addCriterion("attend_user_id <", value, "attendUserId");
            return (Criteria) this;
        }

        public Criteria andAttendUserIdLessThanOrEqualTo(Integer value) {
            addCriterion("attend_user_id <=", value, "attendUserId");
            return (Criteria) this;
        }

        public Criteria andAttendUserIdIn(List<Integer> values) {
            addCriterion("attend_user_id in", values, "attendUserId");
            return (Criteria) this;
        }

        public Criteria andAttendUserIdNotIn(List<Integer> values) {
            addCriterion("attend_user_id not in", values, "attendUserId");
            return (Criteria) this;
        }

        public Criteria andAttendUserIdBetween(Integer value1, Integer value2) {
            addCriterion("attend_user_id between", value1, value2, "attendUserId");
            return (Criteria) this;
        }

        public Criteria andAttendUserIdNotBetween(Integer value1, Integer value2) {
            addCriterion("attend_user_id not between", value1, value2, "attendUserId");
            return (Criteria) this;
        }

        public Criteria andAttendStoreIdIsNull() {
            addCriterion("attend_store_id is null");
            return (Criteria) this;
        }

        public Criteria andAttendStoreIdIsNotNull() {
            addCriterion("attend_store_id is not null");
            return (Criteria) this;
        }

        public Criteria andAttendStoreIdEqualTo(Integer value) {
            addCriterion("attend_store_id =", value, "attendStoreId");
            return (Criteria) this;
        }

        public Criteria andAttendStoreIdNotEqualTo(Integer value) {
            addCriterion("attend_store_id <>", value, "attendStoreId");
            return (Criteria) this;
        }

        public Criteria andAttendStoreIdGreaterThan(Integer value) {
            addCriterion("attend_store_id >", value, "attendStoreId");
            return (Criteria) this;
        }

        public Criteria andAttendStoreIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("attend_store_id >=", value, "attendStoreId");
            return (Criteria) this;
        }

        public Criteria andAttendStoreIdLessThan(Integer value) {
            addCriterion("attend_store_id <", value, "attendStoreId");
            return (Criteria) this;
        }

        public Criteria andAttendStoreIdLessThanOrEqualTo(Integer value) {
            addCriterion("attend_store_id <=", value, "attendStoreId");
            return (Criteria) this;
        }

        public Criteria andAttendStoreIdIn(List<Integer> values) {
            addCriterion("attend_store_id in", values, "attendStoreId");
            return (Criteria) this;
        }

        public Criteria andAttendStoreIdNotIn(List<Integer> values) {
            addCriterion("attend_store_id not in", values, "attendStoreId");
            return (Criteria) this;
        }

        public Criteria andAttendStoreIdBetween(Integer value1, Integer value2) {
            addCriterion("attend_store_id between", value1, value2, "attendStoreId");
            return (Criteria) this;
        }

        public Criteria andAttendStoreIdNotBetween(Integer value1, Integer value2) {
            addCriterion("attend_store_id not between", value1, value2, "attendStoreId");
            return (Criteria) this;
        }

        public Criteria andAttendActiveIdIsNull() {
            addCriterion("attend_active_id is null");
            return (Criteria) this;
        }

        public Criteria andAttendActiveIdIsNotNull() {
            addCriterion("attend_active_id is not null");
            return (Criteria) this;
        }

        public Criteria andAttendActiveIdEqualTo(Integer value) {
            addCriterion("attend_active_id =", value, "attendActiveId");
            return (Criteria) this;
        }

        public Criteria andAttendActiveIdNotEqualTo(Integer value) {
            addCriterion("attend_active_id <>", value, "attendActiveId");
            return (Criteria) this;
        }

        public Criteria andAttendActiveIdGreaterThan(Integer value) {
            addCriterion("attend_active_id >", value, "attendActiveId");
            return (Criteria) this;
        }

        public Criteria andAttendActiveIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("attend_active_id >=", value, "attendActiveId");
            return (Criteria) this;
        }

        public Criteria andAttendActiveIdLessThan(Integer value) {
            addCriterion("attend_active_id <", value, "attendActiveId");
            return (Criteria) this;
        }

        public Criteria andAttendActiveIdLessThanOrEqualTo(Integer value) {
            addCriterion("attend_active_id <=", value, "attendActiveId");
            return (Criteria) this;
        }

        public Criteria andAttendActiveIdIn(List<Integer> values) {
            addCriterion("attend_active_id in", values, "attendActiveId");
            return (Criteria) this;
        }

        public Criteria andAttendActiveIdNotIn(List<Integer> values) {
            addCriterion("attend_active_id not in", values, "attendActiveId");
            return (Criteria) this;
        }

        public Criteria andAttendActiveIdBetween(Integer value1, Integer value2) {
            addCriterion("attend_active_id between", value1, value2, "attendActiveId");
            return (Criteria) this;
        }

        public Criteria andAttendActiveIdNotBetween(Integer value1, Integer value2) {
            addCriterion("attend_active_id not between", value1, value2, "attendActiveId");
            return (Criteria) this;
        }

        public Criteria andAttendOrderIdIsNull() {
            addCriterion("attend_order_id is null");
            return (Criteria) this;
        }

        public Criteria andAttendOrderIdIsNotNull() {
            addCriterion("attend_order_id is not null");
            return (Criteria) this;
        }

        public Criteria andAttendOrderIdEqualTo(Integer value) {
            addCriterion("attend_order_id =", value, "attendOrderId");
            return (Criteria) this;
        }

        public Criteria andAttendOrderIdNotEqualTo(Integer value) {
            addCriterion("attend_order_id <>", value, "attendOrderId");
            return (Criteria) this;
        }

        public Criteria andAttendOrderIdGreaterThan(Integer value) {
            addCriterion("attend_order_id >", value, "attendOrderId");
            return (Criteria) this;
        }

        public Criteria andAttendOrderIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("attend_order_id >=", value, "attendOrderId");
            return (Criteria) this;
        }

        public Criteria andAttendOrderIdLessThan(Integer value) {
            addCriterion("attend_order_id <", value, "attendOrderId");
            return (Criteria) this;
        }

        public Criteria andAttendOrderIdLessThanOrEqualTo(Integer value) {
            addCriterion("attend_order_id <=", value, "attendOrderId");
            return (Criteria) this;
        }

        public Criteria andAttendOrderIdIn(List<Integer> values) {
            addCriterion("attend_order_id in", values, "attendOrderId");
            return (Criteria) this;
        }

        public Criteria andAttendOrderIdNotIn(List<Integer> values) {
            addCriterion("attend_order_id not in", values, "attendOrderId");
            return (Criteria) this;
        }

        public Criteria andAttendOrderIdBetween(Integer value1, Integer value2) {
            addCriterion("attend_order_id between", value1, value2, "attendOrderId");
            return (Criteria) this;
        }

        public Criteria andAttendOrderIdNotBetween(Integer value1, Integer value2) {
            addCriterion("attend_order_id not between", value1, value2, "attendOrderId");
            return (Criteria) this;
        }

        public Criteria andAttendOrderAmountIsNull() {
            addCriterion("attend_order_amount is null");
            return (Criteria) this;
        }

        public Criteria andAttendOrderAmountIsNotNull() {
            addCriterion("attend_order_amount is not null");
            return (Criteria) this;
        }

        public Criteria andAttendOrderAmountEqualTo(Integer value) {
            addCriterion("attend_order_amount =", value, "attendOrderAmount");
            return (Criteria) this;
        }

        public Criteria andAttendOrderAmountNotEqualTo(Integer value) {
            addCriterion("attend_order_amount <>", value, "attendOrderAmount");
            return (Criteria) this;
        }

        public Criteria andAttendOrderAmountGreaterThan(Integer value) {
            addCriterion("attend_order_amount >", value, "attendOrderAmount");
            return (Criteria) this;
        }

        public Criteria andAttendOrderAmountGreaterThanOrEqualTo(Integer value) {
            addCriterion("attend_order_amount >=", value, "attendOrderAmount");
            return (Criteria) this;
        }

        public Criteria andAttendOrderAmountLessThan(Integer value) {
            addCriterion("attend_order_amount <", value, "attendOrderAmount");
            return (Criteria) this;
        }

        public Criteria andAttendOrderAmountLessThanOrEqualTo(Integer value) {
            addCriterion("attend_order_amount <=", value, "attendOrderAmount");
            return (Criteria) this;
        }

        public Criteria andAttendOrderAmountIn(List<Integer> values) {
            addCriterion("attend_order_amount in", values, "attendOrderAmount");
            return (Criteria) this;
        }

        public Criteria andAttendOrderAmountNotIn(List<Integer> values) {
            addCriterion("attend_order_amount not in", values, "attendOrderAmount");
            return (Criteria) this;
        }

        public Criteria andAttendOrderAmountBetween(Integer value1, Integer value2) {
            addCriterion("attend_order_amount between", value1, value2, "attendOrderAmount");
            return (Criteria) this;
        }

        public Criteria andAttendOrderAmountNotBetween(Integer value1, Integer value2) {
            addCriterion("attend_order_amount not between", value1, value2, "attendOrderAmount");
            return (Criteria) this;
        }

        public Criteria andAttendActiveContentIsNull() {
            addCriterion("attend_active_content is null");
            return (Criteria) this;
        }

        public Criteria andAttendActiveContentIsNotNull() {
            addCriterion("attend_active_content is not null");
            return (Criteria) this;
        }

        public Criteria andAttendActiveContentEqualTo(String value) {
            addCriterion("attend_active_content =", value, "attendActiveContent");
            return (Criteria) this;
        }

        public Criteria andAttendActiveContentNotEqualTo(String value) {
            addCriterion("attend_active_content <>", value, "attendActiveContent");
            return (Criteria) this;
        }

        public Criteria andAttendActiveContentGreaterThan(String value) {
            addCriterion("attend_active_content >", value, "attendActiveContent");
            return (Criteria) this;
        }

        public Criteria andAttendActiveContentGreaterThanOrEqualTo(String value) {
            addCriterion("attend_active_content >=", value, "attendActiveContent");
            return (Criteria) this;
        }

        public Criteria andAttendActiveContentLessThan(String value) {
            addCriterion("attend_active_content <", value, "attendActiveContent");
            return (Criteria) this;
        }

        public Criteria andAttendActiveContentLessThanOrEqualTo(String value) {
            addCriterion("attend_active_content <=", value, "attendActiveContent");
            return (Criteria) this;
        }

        public Criteria andAttendActiveContentLike(String value) {
            addCriterion("attend_active_content like", value, "attendActiveContent");
            return (Criteria) this;
        }

        public Criteria andAttendActiveContentNotLike(String value) {
            addCriterion("attend_active_content not like", value, "attendActiveContent");
            return (Criteria) this;
        }

        public Criteria andAttendActiveContentIn(List<String> values) {
            addCriterion("attend_active_content in", values, "attendActiveContent");
            return (Criteria) this;
        }

        public Criteria andAttendActiveContentNotIn(List<String> values) {
            addCriterion("attend_active_content not in", values, "attendActiveContent");
            return (Criteria) this;
        }

        public Criteria andAttendActiveContentBetween(String value1, String value2) {
            addCriterion("attend_active_content between", value1, value2, "attendActiveContent");
            return (Criteria) this;
        }

        public Criteria andAttendActiveContentNotBetween(String value1, String value2) {
            addCriterion("attend_active_content not between", value1, value2, "attendActiveContent");
            return (Criteria) this;
        }

        public Criteria andAttendTimeIsNull() {
            addCriterion("attend_time is null");
            return (Criteria) this;
        }

        public Criteria andAttendTimeIsNotNull() {
            addCriterion("attend_time is not null");
            return (Criteria) this;
        }

        public Criteria andAttendTimeEqualTo(Date value) {
            addCriterion("attend_time =", value, "attendTime");
            return (Criteria) this;
        }

        public Criteria andAttendTimeNotEqualTo(Date value) {
            addCriterion("attend_time <>", value, "attendTime");
            return (Criteria) this;
        }

        public Criteria andAttendTimeGreaterThan(Date value) {
            addCriterion("attend_time >", value, "attendTime");
            return (Criteria) this;
        }

        public Criteria andAttendTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("attend_time >=", value, "attendTime");
            return (Criteria) this;
        }

        public Criteria andAttendTimeLessThan(Date value) {
            addCriterion("attend_time <", value, "attendTime");
            return (Criteria) this;
        }

        public Criteria andAttendTimeLessThanOrEqualTo(Date value) {
            addCriterion("attend_time <=", value, "attendTime");
            return (Criteria) this;
        }

        public Criteria andAttendTimeIn(List<Date> values) {
            addCriterion("attend_time in", values, "attendTime");
            return (Criteria) this;
        }

        public Criteria andAttendTimeNotIn(List<Date> values) {
            addCriterion("attend_time not in", values, "attendTime");
            return (Criteria) this;
        }

        public Criteria andAttendTimeBetween(Date value1, Date value2) {
            addCriterion("attend_time between", value1, value2, "attendTime");
            return (Criteria) this;
        }

        public Criteria andAttendTimeNotBetween(Date value1, Date value2) {
            addCriterion("attend_time not between", value1, value2, "attendTime");
            return (Criteria) this;
        }

        public Criteria andAttengGmtIsNull() {
            addCriterion("atteng_gmt is null");
            return (Criteria) this;
        }

        public Criteria andAttengGmtIsNotNull() {
            addCriterion("atteng_gmt is not null");
            return (Criteria) this;
        }

        public Criteria andAttengGmtEqualTo(Date value) {
            addCriterion("atteng_gmt =", value, "attengGmt");
            return (Criteria) this;
        }

        public Criteria andAttengGmtNotEqualTo(Date value) {
            addCriterion("atteng_gmt <>", value, "attengGmt");
            return (Criteria) this;
        }

        public Criteria andAttengGmtGreaterThan(Date value) {
            addCriterion("atteng_gmt >", value, "attengGmt");
            return (Criteria) this;
        }

        public Criteria andAttengGmtGreaterThanOrEqualTo(Date value) {
            addCriterion("atteng_gmt >=", value, "attengGmt");
            return (Criteria) this;
        }

        public Criteria andAttengGmtLessThan(Date value) {
            addCriterion("atteng_gmt <", value, "attengGmt");
            return (Criteria) this;
        }

        public Criteria andAttengGmtLessThanOrEqualTo(Date value) {
            addCriterion("atteng_gmt <=", value, "attengGmt");
            return (Criteria) this;
        }

        public Criteria andAttengGmtIn(List<Date> values) {
            addCriterion("atteng_gmt in", values, "attengGmt");
            return (Criteria) this;
        }

        public Criteria andAttengGmtNotIn(List<Date> values) {
            addCriterion("atteng_gmt not in", values, "attengGmt");
            return (Criteria) this;
        }

        public Criteria andAttengGmtBetween(Date value1, Date value2) {
            addCriterion("atteng_gmt between", value1, value2, "attengGmt");
            return (Criteria) this;
        }

        public Criteria andAttengGmtNotBetween(Date value1, Date value2) {
            addCriterion("atteng_gmt not between", value1, value2, "attengGmt");
            return (Criteria) this;
        }

        public Criteria andAttendOrderStateIsNull() {
            addCriterion("attend_order_state is null");
            return (Criteria) this;
        }

        public Criteria andAttendOrderStateIsNotNull() {
            addCriterion("attend_order_state is not null");
            return (Criteria) this;
        }

        public Criteria andAttendOrderStateEqualTo(Integer value) {
            addCriterion("attend_order_state =", value, "attendOrderState");
            return (Criteria) this;
        }

        public Criteria andAttendOrderStateNotEqualTo(Integer value) {
            addCriterion("attend_order_state <>", value, "attendOrderState");
            return (Criteria) this;
        }

        public Criteria andAttendOrderStateGreaterThan(Integer value) {
            addCriterion("attend_order_state >", value, "attendOrderState");
            return (Criteria) this;
        }

        public Criteria andAttendOrderStateGreaterThanOrEqualTo(Integer value) {
            addCriterion("attend_order_state >=", value, "attendOrderState");
            return (Criteria) this;
        }

        public Criteria andAttendOrderStateLessThan(Integer value) {
            addCriterion("attend_order_state <", value, "attendOrderState");
            return (Criteria) this;
        }

        public Criteria andAttendOrderStateLessThanOrEqualTo(Integer value) {
            addCriterion("attend_order_state <=", value, "attendOrderState");
            return (Criteria) this;
        }

        public Criteria andAttendOrderStateIn(List<Integer> values) {
            addCriterion("attend_order_state in", values, "attendOrderState");
            return (Criteria) this;
        }

        public Criteria andAttendOrderStateNotIn(List<Integer> values) {
            addCriterion("attend_order_state not in", values, "attendOrderState");
            return (Criteria) this;
        }

        public Criteria andAttendOrderStateBetween(Integer value1, Integer value2) {
            addCriterion("attend_order_state between", value1, value2, "attendOrderState");
            return (Criteria) this;
        }

        public Criteria andAttendOrderStateNotBetween(Integer value1, Integer value2) {
            addCriterion("attend_order_state not between", value1, value2, "attendOrderState");
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