package org.mfoyou.agent.common.dao.mfoyou.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class MfoyouStoreFreightExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    protected Integer limitStart;

    protected Integer limitEnd;

    public MfoyouStoreFreightExample() {
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

        public Criteria andFreightIdIsNull() {
            addCriterion("freight_id is null");
            return (Criteria) this;
        }

        public Criteria andFreightIdIsNotNull() {
            addCriterion("freight_id is not null");
            return (Criteria) this;
        }

        public Criteria andFreightIdEqualTo(Integer value) {
            addCriterion("freight_id =", value, "freightId");
            return (Criteria) this;
        }

        public Criteria andFreightIdNotEqualTo(Integer value) {
            addCriterion("freight_id <>", value, "freightId");
            return (Criteria) this;
        }

        public Criteria andFreightIdGreaterThan(Integer value) {
            addCriterion("freight_id >", value, "freightId");
            return (Criteria) this;
        }

        public Criteria andFreightIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("freight_id >=", value, "freightId");
            return (Criteria) this;
        }

        public Criteria andFreightIdLessThan(Integer value) {
            addCriterion("freight_id <", value, "freightId");
            return (Criteria) this;
        }

        public Criteria andFreightIdLessThanOrEqualTo(Integer value) {
            addCriterion("freight_id <=", value, "freightId");
            return (Criteria) this;
        }

        public Criteria andFreightIdIn(List<Integer> values) {
            addCriterion("freight_id in", values, "freightId");
            return (Criteria) this;
        }

        public Criteria andFreightIdNotIn(List<Integer> values) {
            addCriterion("freight_id not in", values, "freightId");
            return (Criteria) this;
        }

        public Criteria andFreightIdBetween(Integer value1, Integer value2) {
            addCriterion("freight_id between", value1, value2, "freightId");
            return (Criteria) this;
        }

        public Criteria andFreightIdNotBetween(Integer value1, Integer value2) {
            addCriterion("freight_id not between", value1, value2, "freightId");
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

        public Criteria andFreightMinDistanceIsNull() {
            addCriterion("freight_min_distance is null");
            return (Criteria) this;
        }

        public Criteria andFreightMinDistanceIsNotNull() {
            addCriterion("freight_min_distance is not null");
            return (Criteria) this;
        }

        public Criteria andFreightMinDistanceEqualTo(Integer value) {
            addCriterion("freight_min_distance =", value, "freightMinDistance");
            return (Criteria) this;
        }

        public Criteria andFreightMinDistanceNotEqualTo(Integer value) {
            addCriterion("freight_min_distance <>", value, "freightMinDistance");
            return (Criteria) this;
        }

        public Criteria andFreightMinDistanceGreaterThan(Integer value) {
            addCriterion("freight_min_distance >", value, "freightMinDistance");
            return (Criteria) this;
        }

        public Criteria andFreightMinDistanceGreaterThanOrEqualTo(Integer value) {
            addCriterion("freight_min_distance >=", value, "freightMinDistance");
            return (Criteria) this;
        }

        public Criteria andFreightMinDistanceLessThan(Integer value) {
            addCriterion("freight_min_distance <", value, "freightMinDistance");
            return (Criteria) this;
        }

        public Criteria andFreightMinDistanceLessThanOrEqualTo(Integer value) {
            addCriterion("freight_min_distance <=", value, "freightMinDistance");
            return (Criteria) this;
        }

        public Criteria andFreightMinDistanceIn(List<Integer> values) {
            addCriterion("freight_min_distance in", values, "freightMinDistance");
            return (Criteria) this;
        }

        public Criteria andFreightMinDistanceNotIn(List<Integer> values) {
            addCriterion("freight_min_distance not in", values, "freightMinDistance");
            return (Criteria) this;
        }

        public Criteria andFreightMinDistanceBetween(Integer value1, Integer value2) {
            addCriterion("freight_min_distance between", value1, value2, "freightMinDistance");
            return (Criteria) this;
        }

        public Criteria andFreightMinDistanceNotBetween(Integer value1, Integer value2) {
            addCriterion("freight_min_distance not between", value1, value2, "freightMinDistance");
            return (Criteria) this;
        }

        public Criteria andFreightMaxDistanceIsNull() {
            addCriterion("freight_max_distance is null");
            return (Criteria) this;
        }

        public Criteria andFreightMaxDistanceIsNotNull() {
            addCriterion("freight_max_distance is not null");
            return (Criteria) this;
        }

        public Criteria andFreightMaxDistanceEqualTo(Integer value) {
            addCriterion("freight_max_distance =", value, "freightMaxDistance");
            return (Criteria) this;
        }

        public Criteria andFreightMaxDistanceNotEqualTo(Integer value) {
            addCriterion("freight_max_distance <>", value, "freightMaxDistance");
            return (Criteria) this;
        }

        public Criteria andFreightMaxDistanceGreaterThan(Integer value) {
            addCriterion("freight_max_distance >", value, "freightMaxDistance");
            return (Criteria) this;
        }

        public Criteria andFreightMaxDistanceGreaterThanOrEqualTo(Integer value) {
            addCriterion("freight_max_distance >=", value, "freightMaxDistance");
            return (Criteria) this;
        }

        public Criteria andFreightMaxDistanceLessThan(Integer value) {
            addCriterion("freight_max_distance <", value, "freightMaxDistance");
            return (Criteria) this;
        }

        public Criteria andFreightMaxDistanceLessThanOrEqualTo(Integer value) {
            addCriterion("freight_max_distance <=", value, "freightMaxDistance");
            return (Criteria) this;
        }

        public Criteria andFreightMaxDistanceIn(List<Integer> values) {
            addCriterion("freight_max_distance in", values, "freightMaxDistance");
            return (Criteria) this;
        }

        public Criteria andFreightMaxDistanceNotIn(List<Integer> values) {
            addCriterion("freight_max_distance not in", values, "freightMaxDistance");
            return (Criteria) this;
        }

        public Criteria andFreightMaxDistanceBetween(Integer value1, Integer value2) {
            addCriterion("freight_max_distance between", value1, value2, "freightMaxDistance");
            return (Criteria) this;
        }

        public Criteria andFreightMaxDistanceNotBetween(Integer value1, Integer value2) {
            addCriterion("freight_max_distance not between", value1, value2, "freightMaxDistance");
            return (Criteria) this;
        }

        public Criteria andFreightPriceIsNull() {
            addCriterion("freight_price is null");
            return (Criteria) this;
        }

        public Criteria andFreightPriceIsNotNull() {
            addCriterion("freight_price is not null");
            return (Criteria) this;
        }

        public Criteria andFreightPriceEqualTo(Integer value) {
            addCriterion("freight_price =", value, "freightPrice");
            return (Criteria) this;
        }

        public Criteria andFreightPriceNotEqualTo(Integer value) {
            addCriterion("freight_price <>", value, "freightPrice");
            return (Criteria) this;
        }

        public Criteria andFreightPriceGreaterThan(Integer value) {
            addCriterion("freight_price >", value, "freightPrice");
            return (Criteria) this;
        }

        public Criteria andFreightPriceGreaterThanOrEqualTo(Integer value) {
            addCriterion("freight_price >=", value, "freightPrice");
            return (Criteria) this;
        }

        public Criteria andFreightPriceLessThan(Integer value) {
            addCriterion("freight_price <", value, "freightPrice");
            return (Criteria) this;
        }

        public Criteria andFreightPriceLessThanOrEqualTo(Integer value) {
            addCriterion("freight_price <=", value, "freightPrice");
            return (Criteria) this;
        }

        public Criteria andFreightPriceIn(List<Integer> values) {
            addCriterion("freight_price in", values, "freightPrice");
            return (Criteria) this;
        }

        public Criteria andFreightPriceNotIn(List<Integer> values) {
            addCriterion("freight_price not in", values, "freightPrice");
            return (Criteria) this;
        }

        public Criteria andFreightPriceBetween(Integer value1, Integer value2) {
            addCriterion("freight_price between", value1, value2, "freightPrice");
            return (Criteria) this;
        }

        public Criteria andFreightPriceNotBetween(Integer value1, Integer value2) {
            addCriterion("freight_price not between", value1, value2, "freightPrice");
            return (Criteria) this;
        }

        public Criteria andFreightGctIsNull() {
            addCriterion("freight_gct is null");
            return (Criteria) this;
        }

        public Criteria andFreightGctIsNotNull() {
            addCriterion("freight_gct is not null");
            return (Criteria) this;
        }

        public Criteria andFreightGctEqualTo(Date value) {
            addCriterion("freight_gct =", value, "freightGct");
            return (Criteria) this;
        }

        public Criteria andFreightGctNotEqualTo(Date value) {
            addCriterion("freight_gct <>", value, "freightGct");
            return (Criteria) this;
        }

        public Criteria andFreightGctGreaterThan(Date value) {
            addCriterion("freight_gct >", value, "freightGct");
            return (Criteria) this;
        }

        public Criteria andFreightGctGreaterThanOrEqualTo(Date value) {
            addCriterion("freight_gct >=", value, "freightGct");
            return (Criteria) this;
        }

        public Criteria andFreightGctLessThan(Date value) {
            addCriterion("freight_gct <", value, "freightGct");
            return (Criteria) this;
        }

        public Criteria andFreightGctLessThanOrEqualTo(Date value) {
            addCriterion("freight_gct <=", value, "freightGct");
            return (Criteria) this;
        }

        public Criteria andFreightGctIn(List<Date> values) {
            addCriterion("freight_gct in", values, "freightGct");
            return (Criteria) this;
        }

        public Criteria andFreightGctNotIn(List<Date> values) {
            addCriterion("freight_gct not in", values, "freightGct");
            return (Criteria) this;
        }

        public Criteria andFreightGctBetween(Date value1, Date value2) {
            addCriterion("freight_gct between", value1, value2, "freightGct");
            return (Criteria) this;
        }

        public Criteria andFreightGctNotBetween(Date value1, Date value2) {
            addCriterion("freight_gct not between", value1, value2, "freightGct");
            return (Criteria) this;
        }

        public Criteria andFreightGmtIsNull() {
            addCriterion("freight_gmt is null");
            return (Criteria) this;
        }

        public Criteria andFreightGmtIsNotNull() {
            addCriterion("freight_gmt is not null");
            return (Criteria) this;
        }

        public Criteria andFreightGmtEqualTo(Date value) {
            addCriterion("freight_gmt =", value, "freightGmt");
            return (Criteria) this;
        }

        public Criteria andFreightGmtNotEqualTo(Date value) {
            addCriterion("freight_gmt <>", value, "freightGmt");
            return (Criteria) this;
        }

        public Criteria andFreightGmtGreaterThan(Date value) {
            addCriterion("freight_gmt >", value, "freightGmt");
            return (Criteria) this;
        }

        public Criteria andFreightGmtGreaterThanOrEqualTo(Date value) {
            addCriterion("freight_gmt >=", value, "freightGmt");
            return (Criteria) this;
        }

        public Criteria andFreightGmtLessThan(Date value) {
            addCriterion("freight_gmt <", value, "freightGmt");
            return (Criteria) this;
        }

        public Criteria andFreightGmtLessThanOrEqualTo(Date value) {
            addCriterion("freight_gmt <=", value, "freightGmt");
            return (Criteria) this;
        }

        public Criteria andFreightGmtIn(List<Date> values) {
            addCriterion("freight_gmt in", values, "freightGmt");
            return (Criteria) this;
        }

        public Criteria andFreightGmtNotIn(List<Date> values) {
            addCriterion("freight_gmt not in", values, "freightGmt");
            return (Criteria) this;
        }

        public Criteria andFreightGmtBetween(Date value1, Date value2) {
            addCriterion("freight_gmt between", value1, value2, "freightGmt");
            return (Criteria) this;
        }

        public Criteria andFreightGmtNotBetween(Date value1, Date value2) {
            addCriterion("freight_gmt not between", value1, value2, "freightGmt");
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