package org.mfoyou.agent.common.dao.mfoyou.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class MfoyouStoreDispatchExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    protected Integer limitStart;

    protected Integer limitEnd;

    public MfoyouStoreDispatchExample() {
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

        public Criteria andAreaFrightInfoIsNull() {
            addCriterion("area_fright_info is null");
            return (Criteria) this;
        }

        public Criteria andAreaFrightInfoIsNotNull() {
            addCriterion("area_fright_info is not null");
            return (Criteria) this;
        }

        public Criteria andAreaFrightInfoEqualTo(String value) {
            addCriterion("area_fright_info =", value, "areaFrightInfo");
            return (Criteria) this;
        }

        public Criteria andAreaFrightInfoNotEqualTo(String value) {
            addCriterion("area_fright_info <>", value, "areaFrightInfo");
            return (Criteria) this;
        }

        public Criteria andAreaFrightInfoGreaterThan(String value) {
            addCriterion("area_fright_info >", value, "areaFrightInfo");
            return (Criteria) this;
        }

        public Criteria andAreaFrightInfoGreaterThanOrEqualTo(String value) {
            addCriterion("area_fright_info >=", value, "areaFrightInfo");
            return (Criteria) this;
        }

        public Criteria andAreaFrightInfoLessThan(String value) {
            addCriterion("area_fright_info <", value, "areaFrightInfo");
            return (Criteria) this;
        }

        public Criteria andAreaFrightInfoLessThanOrEqualTo(String value) {
            addCriterion("area_fright_info <=", value, "areaFrightInfo");
            return (Criteria) this;
        }

        public Criteria andAreaFrightInfoLike(String value) {
            addCriterion("area_fright_info like", value, "areaFrightInfo");
            return (Criteria) this;
        }

        public Criteria andAreaFrightInfoNotLike(String value) {
            addCriterion("area_fright_info not like", value, "areaFrightInfo");
            return (Criteria) this;
        }

        public Criteria andAreaFrightInfoIn(List<String> values) {
            addCriterion("area_fright_info in", values, "areaFrightInfo");
            return (Criteria) this;
        }

        public Criteria andAreaFrightInfoNotIn(List<String> values) {
            addCriterion("area_fright_info not in", values, "areaFrightInfo");
            return (Criteria) this;
        }

        public Criteria andAreaFrightInfoBetween(String value1, String value2) {
            addCriterion("area_fright_info between", value1, value2, "areaFrightInfo");
            return (Criteria) this;
        }

        public Criteria andAreaFrightInfoNotBetween(String value1, String value2) {
            addCriterion("area_fright_info not between", value1, value2, "areaFrightInfo");
            return (Criteria) this;
        }

        public Criteria andDistanceFrightInfoIsNull() {
            addCriterion("distance_fright_info is null");
            return (Criteria) this;
        }

        public Criteria andDistanceFrightInfoIsNotNull() {
            addCriterion("distance_fright_info is not null");
            return (Criteria) this;
        }

        public Criteria andDistanceFrightInfoEqualTo(String value) {
            addCriterion("distance_fright_info =", value, "distanceFrightInfo");
            return (Criteria) this;
        }

        public Criteria andDistanceFrightInfoNotEqualTo(String value) {
            addCriterion("distance_fright_info <>", value, "distanceFrightInfo");
            return (Criteria) this;
        }

        public Criteria andDistanceFrightInfoGreaterThan(String value) {
            addCriterion("distance_fright_info >", value, "distanceFrightInfo");
            return (Criteria) this;
        }

        public Criteria andDistanceFrightInfoGreaterThanOrEqualTo(String value) {
            addCriterion("distance_fright_info >=", value, "distanceFrightInfo");
            return (Criteria) this;
        }

        public Criteria andDistanceFrightInfoLessThan(String value) {
            addCriterion("distance_fright_info <", value, "distanceFrightInfo");
            return (Criteria) this;
        }

        public Criteria andDistanceFrightInfoLessThanOrEqualTo(String value) {
            addCriterion("distance_fright_info <=", value, "distanceFrightInfo");
            return (Criteria) this;
        }

        public Criteria andDistanceFrightInfoLike(String value) {
            addCriterion("distance_fright_info like", value, "distanceFrightInfo");
            return (Criteria) this;
        }

        public Criteria andDistanceFrightInfoNotLike(String value) {
            addCriterion("distance_fright_info not like", value, "distanceFrightInfo");
            return (Criteria) this;
        }

        public Criteria andDistanceFrightInfoIn(List<String> values) {
            addCriterion("distance_fright_info in", values, "distanceFrightInfo");
            return (Criteria) this;
        }

        public Criteria andDistanceFrightInfoNotIn(List<String> values) {
            addCriterion("distance_fright_info not in", values, "distanceFrightInfo");
            return (Criteria) this;
        }

        public Criteria andDistanceFrightInfoBetween(String value1, String value2) {
            addCriterion("distance_fright_info between", value1, value2, "distanceFrightInfo");
            return (Criteria) this;
        }

        public Criteria andDistanceFrightInfoNotBetween(String value1, String value2) {
            addCriterion("distance_fright_info not between", value1, value2, "distanceFrightInfo");
            return (Criteria) this;
        }

        public Criteria andCurrentTypeIsNull() {
            addCriterion("current_type is null");
            return (Criteria) this;
        }

        public Criteria andCurrentTypeIsNotNull() {
            addCriterion("current_type is not null");
            return (Criteria) this;
        }

        public Criteria andCurrentTypeEqualTo(Integer value) {
            addCriterion("current_type =", value, "currentType");
            return (Criteria) this;
        }

        public Criteria andCurrentTypeNotEqualTo(Integer value) {
            addCriterion("current_type <>", value, "currentType");
            return (Criteria) this;
        }

        public Criteria andCurrentTypeGreaterThan(Integer value) {
            addCriterion("current_type >", value, "currentType");
            return (Criteria) this;
        }

        public Criteria andCurrentTypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("current_type >=", value, "currentType");
            return (Criteria) this;
        }

        public Criteria andCurrentTypeLessThan(Integer value) {
            addCriterion("current_type <", value, "currentType");
            return (Criteria) this;
        }

        public Criteria andCurrentTypeLessThanOrEqualTo(Integer value) {
            addCriterion("current_type <=", value, "currentType");
            return (Criteria) this;
        }

        public Criteria andCurrentTypeIn(List<Integer> values) {
            addCriterion("current_type in", values, "currentType");
            return (Criteria) this;
        }

        public Criteria andCurrentTypeNotIn(List<Integer> values) {
            addCriterion("current_type not in", values, "currentType");
            return (Criteria) this;
        }

        public Criteria andCurrentTypeBetween(Integer value1, Integer value2) {
            addCriterion("current_type between", value1, value2, "currentType");
            return (Criteria) this;
        }

        public Criteria andCurrentTypeNotBetween(Integer value1, Integer value2) {
            addCriterion("current_type not between", value1, value2, "currentType");
            return (Criteria) this;
        }

        public Criteria andCreatTimeIsNull() {
            addCriterion("creat_time is null");
            return (Criteria) this;
        }

        public Criteria andCreatTimeIsNotNull() {
            addCriterion("creat_time is not null");
            return (Criteria) this;
        }

        public Criteria andCreatTimeEqualTo(Date value) {
            addCriterion("creat_time =", value, "creatTime");
            return (Criteria) this;
        }

        public Criteria andCreatTimeNotEqualTo(Date value) {
            addCriterion("creat_time <>", value, "creatTime");
            return (Criteria) this;
        }

        public Criteria andCreatTimeGreaterThan(Date value) {
            addCriterion("creat_time >", value, "creatTime");
            return (Criteria) this;
        }

        public Criteria andCreatTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("creat_time >=", value, "creatTime");
            return (Criteria) this;
        }

        public Criteria andCreatTimeLessThan(Date value) {
            addCriterion("creat_time <", value, "creatTime");
            return (Criteria) this;
        }

        public Criteria andCreatTimeLessThanOrEqualTo(Date value) {
            addCriterion("creat_time <=", value, "creatTime");
            return (Criteria) this;
        }

        public Criteria andCreatTimeIn(List<Date> values) {
            addCriterion("creat_time in", values, "creatTime");
            return (Criteria) this;
        }

        public Criteria andCreatTimeNotIn(List<Date> values) {
            addCriterion("creat_time not in", values, "creatTime");
            return (Criteria) this;
        }

        public Criteria andCreatTimeBetween(Date value1, Date value2) {
            addCriterion("creat_time between", value1, value2, "creatTime");
            return (Criteria) this;
        }

        public Criteria andCreatTimeNotBetween(Date value1, Date value2) {
            addCriterion("creat_time not between", value1, value2, "creatTime");
            return (Criteria) this;
        }

        public Criteria andModifyTimeIsNull() {
            addCriterion("modify_time is null");
            return (Criteria) this;
        }

        public Criteria andModifyTimeIsNotNull() {
            addCriterion("modify_time is not null");
            return (Criteria) this;
        }

        public Criteria andModifyTimeEqualTo(Date value) {
            addCriterion("modify_time =", value, "modifyTime");
            return (Criteria) this;
        }

        public Criteria andModifyTimeNotEqualTo(Date value) {
            addCriterion("modify_time <>", value, "modifyTime");
            return (Criteria) this;
        }

        public Criteria andModifyTimeGreaterThan(Date value) {
            addCriterion("modify_time >", value, "modifyTime");
            return (Criteria) this;
        }

        public Criteria andModifyTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("modify_time >=", value, "modifyTime");
            return (Criteria) this;
        }

        public Criteria andModifyTimeLessThan(Date value) {
            addCriterion("modify_time <", value, "modifyTime");
            return (Criteria) this;
        }

        public Criteria andModifyTimeLessThanOrEqualTo(Date value) {
            addCriterion("modify_time <=", value, "modifyTime");
            return (Criteria) this;
        }

        public Criteria andModifyTimeIn(List<Date> values) {
            addCriterion("modify_time in", values, "modifyTime");
            return (Criteria) this;
        }

        public Criteria andModifyTimeNotIn(List<Date> values) {
            addCriterion("modify_time not in", values, "modifyTime");
            return (Criteria) this;
        }

        public Criteria andModifyTimeBetween(Date value1, Date value2) {
            addCriterion("modify_time between", value1, value2, "modifyTime");
            return (Criteria) this;
        }

        public Criteria andModifyTimeNotBetween(Date value1, Date value2) {
            addCriterion("modify_time not between", value1, value2, "modifyTime");
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