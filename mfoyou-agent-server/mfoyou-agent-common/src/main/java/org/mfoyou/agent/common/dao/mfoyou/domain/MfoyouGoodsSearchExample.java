package org.mfoyou.agent.common.dao.mfoyou.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class MfoyouGoodsSearchExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    protected Integer limitStart;

    protected Integer limitEnd;

    public MfoyouGoodsSearchExample() {
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

        public Criteria andSearchIdIsNull() {
            addCriterion("search_id is null");
            return (Criteria) this;
        }

        public Criteria andSearchIdIsNotNull() {
            addCriterion("search_id is not null");
            return (Criteria) this;
        }

        public Criteria andSearchIdEqualTo(Integer value) {
            addCriterion("search_id =", value, "searchId");
            return (Criteria) this;
        }

        public Criteria andSearchIdNotEqualTo(Integer value) {
            addCriterion("search_id <>", value, "searchId");
            return (Criteria) this;
        }

        public Criteria andSearchIdGreaterThan(Integer value) {
            addCriterion("search_id >", value, "searchId");
            return (Criteria) this;
        }

        public Criteria andSearchIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("search_id >=", value, "searchId");
            return (Criteria) this;
        }

        public Criteria andSearchIdLessThan(Integer value) {
            addCriterion("search_id <", value, "searchId");
            return (Criteria) this;
        }

        public Criteria andSearchIdLessThanOrEqualTo(Integer value) {
            addCriterion("search_id <=", value, "searchId");
            return (Criteria) this;
        }

        public Criteria andSearchIdIn(List<Integer> values) {
            addCriterion("search_id in", values, "searchId");
            return (Criteria) this;
        }

        public Criteria andSearchIdNotIn(List<Integer> values) {
            addCriterion("search_id not in", values, "searchId");
            return (Criteria) this;
        }

        public Criteria andSearchIdBetween(Integer value1, Integer value2) {
            addCriterion("search_id between", value1, value2, "searchId");
            return (Criteria) this;
        }

        public Criteria andSearchIdNotBetween(Integer value1, Integer value2) {
            addCriterion("search_id not between", value1, value2, "searchId");
            return (Criteria) this;
        }

        public Criteria andSearchNameIsNull() {
            addCriterion("search_name is null");
            return (Criteria) this;
        }

        public Criteria andSearchNameIsNotNull() {
            addCriterion("search_name is not null");
            return (Criteria) this;
        }

        public Criteria andSearchNameEqualTo(String value) {
            addCriterion("search_name =", value, "searchName");
            return (Criteria) this;
        }

        public Criteria andSearchNameNotEqualTo(String value) {
            addCriterion("search_name <>", value, "searchName");
            return (Criteria) this;
        }

        public Criteria andSearchNameGreaterThan(String value) {
            addCriterion("search_name >", value, "searchName");
            return (Criteria) this;
        }

        public Criteria andSearchNameGreaterThanOrEqualTo(String value) {
            addCriterion("search_name >=", value, "searchName");
            return (Criteria) this;
        }

        public Criteria andSearchNameLessThan(String value) {
            addCriterion("search_name <", value, "searchName");
            return (Criteria) this;
        }

        public Criteria andSearchNameLessThanOrEqualTo(String value) {
            addCriterion("search_name <=", value, "searchName");
            return (Criteria) this;
        }

        public Criteria andSearchNameLike(String value) {
            addCriterion("search_name like", value, "searchName");
            return (Criteria) this;
        }

        public Criteria andSearchNameNotLike(String value) {
            addCriterion("search_name not like", value, "searchName");
            return (Criteria) this;
        }

        public Criteria andSearchNameIn(List<String> values) {
            addCriterion("search_name in", values, "searchName");
            return (Criteria) this;
        }

        public Criteria andSearchNameNotIn(List<String> values) {
            addCriterion("search_name not in", values, "searchName");
            return (Criteria) this;
        }

        public Criteria andSearchNameBetween(String value1, String value2) {
            addCriterion("search_name between", value1, value2, "searchName");
            return (Criteria) this;
        }

        public Criteria andSearchNameNotBetween(String value1, String value2) {
            addCriterion("search_name not between", value1, value2, "searchName");
            return (Criteria) this;
        }

        public Criteria andSearchTimesIsNull() {
            addCriterion("search_times is null");
            return (Criteria) this;
        }

        public Criteria andSearchTimesIsNotNull() {
            addCriterion("search_times is not null");
            return (Criteria) this;
        }

        public Criteria andSearchTimesEqualTo(Integer value) {
            addCriterion("search_times =", value, "searchTimes");
            return (Criteria) this;
        }

        public Criteria andSearchTimesNotEqualTo(Integer value) {
            addCriterion("search_times <>", value, "searchTimes");
            return (Criteria) this;
        }

        public Criteria andSearchTimesGreaterThan(Integer value) {
            addCriterion("search_times >", value, "searchTimes");
            return (Criteria) this;
        }

        public Criteria andSearchTimesGreaterThanOrEqualTo(Integer value) {
            addCriterion("search_times >=", value, "searchTimes");
            return (Criteria) this;
        }

        public Criteria andSearchTimesLessThan(Integer value) {
            addCriterion("search_times <", value, "searchTimes");
            return (Criteria) this;
        }

        public Criteria andSearchTimesLessThanOrEqualTo(Integer value) {
            addCriterion("search_times <=", value, "searchTimes");
            return (Criteria) this;
        }

        public Criteria andSearchTimesIn(List<Integer> values) {
            addCriterion("search_times in", values, "searchTimes");
            return (Criteria) this;
        }

        public Criteria andSearchTimesNotIn(List<Integer> values) {
            addCriterion("search_times not in", values, "searchTimes");
            return (Criteria) this;
        }

        public Criteria andSearchTimesBetween(Integer value1, Integer value2) {
            addCriterion("search_times between", value1, value2, "searchTimes");
            return (Criteria) this;
        }

        public Criteria andSearchTimesNotBetween(Integer value1, Integer value2) {
            addCriterion("search_times not between", value1, value2, "searchTimes");
            return (Criteria) this;
        }

        public Criteria andSearchGctIsNull() {
            addCriterion("search_gct is null");
            return (Criteria) this;
        }

        public Criteria andSearchGctIsNotNull() {
            addCriterion("search_gct is not null");
            return (Criteria) this;
        }

        public Criteria andSearchGctEqualTo(Date value) {
            addCriterion("search_gct =", value, "searchGct");
            return (Criteria) this;
        }

        public Criteria andSearchGctNotEqualTo(Date value) {
            addCriterion("search_gct <>", value, "searchGct");
            return (Criteria) this;
        }

        public Criteria andSearchGctGreaterThan(Date value) {
            addCriterion("search_gct >", value, "searchGct");
            return (Criteria) this;
        }

        public Criteria andSearchGctGreaterThanOrEqualTo(Date value) {
            addCriterion("search_gct >=", value, "searchGct");
            return (Criteria) this;
        }

        public Criteria andSearchGctLessThan(Date value) {
            addCriterion("search_gct <", value, "searchGct");
            return (Criteria) this;
        }

        public Criteria andSearchGctLessThanOrEqualTo(Date value) {
            addCriterion("search_gct <=", value, "searchGct");
            return (Criteria) this;
        }

        public Criteria andSearchGctIn(List<Date> values) {
            addCriterion("search_gct in", values, "searchGct");
            return (Criteria) this;
        }

        public Criteria andSearchGctNotIn(List<Date> values) {
            addCriterion("search_gct not in", values, "searchGct");
            return (Criteria) this;
        }

        public Criteria andSearchGctBetween(Date value1, Date value2) {
            addCriterion("search_gct between", value1, value2, "searchGct");
            return (Criteria) this;
        }

        public Criteria andSearchGctNotBetween(Date value1, Date value2) {
            addCriterion("search_gct not between", value1, value2, "searchGct");
            return (Criteria) this;
        }

        public Criteria andSearchTopIsNull() {
            addCriterion("search_top is null");
            return (Criteria) this;
        }

        public Criteria andSearchTopIsNotNull() {
            addCriterion("search_top is not null");
            return (Criteria) this;
        }

        public Criteria andSearchTopEqualTo(Integer value) {
            addCriterion("search_top =", value, "searchTop");
            return (Criteria) this;
        }

        public Criteria andSearchTopNotEqualTo(Integer value) {
            addCriterion("search_top <>", value, "searchTop");
            return (Criteria) this;
        }

        public Criteria andSearchTopGreaterThan(Integer value) {
            addCriterion("search_top >", value, "searchTop");
            return (Criteria) this;
        }

        public Criteria andSearchTopGreaterThanOrEqualTo(Integer value) {
            addCriterion("search_top >=", value, "searchTop");
            return (Criteria) this;
        }

        public Criteria andSearchTopLessThan(Integer value) {
            addCriterion("search_top <", value, "searchTop");
            return (Criteria) this;
        }

        public Criteria andSearchTopLessThanOrEqualTo(Integer value) {
            addCriterion("search_top <=", value, "searchTop");
            return (Criteria) this;
        }

        public Criteria andSearchTopIn(List<Integer> values) {
            addCriterion("search_top in", values, "searchTop");
            return (Criteria) this;
        }

        public Criteria andSearchTopNotIn(List<Integer> values) {
            addCriterion("search_top not in", values, "searchTop");
            return (Criteria) this;
        }

        public Criteria andSearchTopBetween(Integer value1, Integer value2) {
            addCriterion("search_top between", value1, value2, "searchTop");
            return (Criteria) this;
        }

        public Criteria andSearchTopNotBetween(Integer value1, Integer value2) {
            addCriterion("search_top not between", value1, value2, "searchTop");
            return (Criteria) this;
        }

        public Criteria andSearchGmtIsNull() {
            addCriterion("search_gmt is null");
            return (Criteria) this;
        }

        public Criteria andSearchGmtIsNotNull() {
            addCriterion("search_gmt is not null");
            return (Criteria) this;
        }

        public Criteria andSearchGmtEqualTo(Date value) {
            addCriterion("search_gmt =", value, "searchGmt");
            return (Criteria) this;
        }

        public Criteria andSearchGmtNotEqualTo(Date value) {
            addCriterion("search_gmt <>", value, "searchGmt");
            return (Criteria) this;
        }

        public Criteria andSearchGmtGreaterThan(Date value) {
            addCriterion("search_gmt >", value, "searchGmt");
            return (Criteria) this;
        }

        public Criteria andSearchGmtGreaterThanOrEqualTo(Date value) {
            addCriterion("search_gmt >=", value, "searchGmt");
            return (Criteria) this;
        }

        public Criteria andSearchGmtLessThan(Date value) {
            addCriterion("search_gmt <", value, "searchGmt");
            return (Criteria) this;
        }

        public Criteria andSearchGmtLessThanOrEqualTo(Date value) {
            addCriterion("search_gmt <=", value, "searchGmt");
            return (Criteria) this;
        }

        public Criteria andSearchGmtIn(List<Date> values) {
            addCriterion("search_gmt in", values, "searchGmt");
            return (Criteria) this;
        }

        public Criteria andSearchGmtNotIn(List<Date> values) {
            addCriterion("search_gmt not in", values, "searchGmt");
            return (Criteria) this;
        }

        public Criteria andSearchGmtBetween(Date value1, Date value2) {
            addCriterion("search_gmt between", value1, value2, "searchGmt");
            return (Criteria) this;
        }

        public Criteria andSearchGmtNotBetween(Date value1, Date value2) {
            addCriterion("search_gmt not between", value1, value2, "searchGmt");
            return (Criteria) this;
        }

        public Criteria andSearchWeightIsNull() {
            addCriterion("search_weight is null");
            return (Criteria) this;
        }

        public Criteria andSearchWeightIsNotNull() {
            addCriterion("search_weight is not null");
            return (Criteria) this;
        }

        public Criteria andSearchWeightEqualTo(Integer value) {
            addCriterion("search_weight =", value, "searchWeight");
            return (Criteria) this;
        }

        public Criteria andSearchWeightNotEqualTo(Integer value) {
            addCriterion("search_weight <>", value, "searchWeight");
            return (Criteria) this;
        }

        public Criteria andSearchWeightGreaterThan(Integer value) {
            addCriterion("search_weight >", value, "searchWeight");
            return (Criteria) this;
        }

        public Criteria andSearchWeightGreaterThanOrEqualTo(Integer value) {
            addCriterion("search_weight >=", value, "searchWeight");
            return (Criteria) this;
        }

        public Criteria andSearchWeightLessThan(Integer value) {
            addCriterion("search_weight <", value, "searchWeight");
            return (Criteria) this;
        }

        public Criteria andSearchWeightLessThanOrEqualTo(Integer value) {
            addCriterion("search_weight <=", value, "searchWeight");
            return (Criteria) this;
        }

        public Criteria andSearchWeightIn(List<Integer> values) {
            addCriterion("search_weight in", values, "searchWeight");
            return (Criteria) this;
        }

        public Criteria andSearchWeightNotIn(List<Integer> values) {
            addCriterion("search_weight not in", values, "searchWeight");
            return (Criteria) this;
        }

        public Criteria andSearchWeightBetween(Integer value1, Integer value2) {
            addCriterion("search_weight between", value1, value2, "searchWeight");
            return (Criteria) this;
        }

        public Criteria andSearchWeightNotBetween(Integer value1, Integer value2) {
            addCriterion("search_weight not between", value1, value2, "searchWeight");
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