package org.mfoyou.agent.common.dao.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class HuawuThirdUserExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    protected Integer limitStart;

    protected Integer limitEnd;

    public HuawuThirdUserExample() {
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

        public Criteria andThirdUserIdIsNull() {
            addCriterion("third_user_id is null");
            return (Criteria) this;
        }

        public Criteria andThirdUserIdIsNotNull() {
            addCriterion("third_user_id is not null");
            return (Criteria) this;
        }

        public Criteria andThirdUserIdEqualTo(Integer value) {
            addCriterion("third_user_id =", value, "thirdUserId");
            return (Criteria) this;
        }

        public Criteria andThirdUserIdNotEqualTo(Integer value) {
            addCriterion("third_user_id <>", value, "thirdUserId");
            return (Criteria) this;
        }

        public Criteria andThirdUserIdGreaterThan(Integer value) {
            addCriterion("third_user_id >", value, "thirdUserId");
            return (Criteria) this;
        }

        public Criteria andThirdUserIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("third_user_id >=", value, "thirdUserId");
            return (Criteria) this;
        }

        public Criteria andThirdUserIdLessThan(Integer value) {
            addCriterion("third_user_id <", value, "thirdUserId");
            return (Criteria) this;
        }

        public Criteria andThirdUserIdLessThanOrEqualTo(Integer value) {
            addCriterion("third_user_id <=", value, "thirdUserId");
            return (Criteria) this;
        }

        public Criteria andThirdUserIdIn(List<Integer> values) {
            addCriterion("third_user_id in", values, "thirdUserId");
            return (Criteria) this;
        }

        public Criteria andThirdUserIdNotIn(List<Integer> values) {
            addCriterion("third_user_id not in", values, "thirdUserId");
            return (Criteria) this;
        }

        public Criteria andThirdUserIdBetween(Integer value1, Integer value2) {
            addCriterion("third_user_id between", value1, value2, "thirdUserId");
            return (Criteria) this;
        }

        public Criteria andThirdUserIdNotBetween(Integer value1, Integer value2) {
            addCriterion("third_user_id not between", value1, value2, "thirdUserId");
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

        public Criteria andOpenIdIsNull() {
            addCriterion("open_id is null");
            return (Criteria) this;
        }

        public Criteria andOpenIdIsNotNull() {
            addCriterion("open_id is not null");
            return (Criteria) this;
        }

        public Criteria andOpenIdEqualTo(String value) {
            addCriterion("open_id =", value, "openId");
            return (Criteria) this;
        }

        public Criteria andOpenIdNotEqualTo(String value) {
            addCriterion("open_id <>", value, "openId");
            return (Criteria) this;
        }

        public Criteria andOpenIdGreaterThan(String value) {
            addCriterion("open_id >", value, "openId");
            return (Criteria) this;
        }

        public Criteria andOpenIdGreaterThanOrEqualTo(String value) {
            addCriterion("open_id >=", value, "openId");
            return (Criteria) this;
        }

        public Criteria andOpenIdLessThan(String value) {
            addCriterion("open_id <", value, "openId");
            return (Criteria) this;
        }

        public Criteria andOpenIdLessThanOrEqualTo(String value) {
            addCriterion("open_id <=", value, "openId");
            return (Criteria) this;
        }

        public Criteria andOpenIdLike(String value) {
            addCriterion("open_id like", value, "openId");
            return (Criteria) this;
        }

        public Criteria andOpenIdNotLike(String value) {
            addCriterion("open_id not like", value, "openId");
            return (Criteria) this;
        }

        public Criteria andOpenIdIn(List<String> values) {
            addCriterion("open_id in", values, "openId");
            return (Criteria) this;
        }

        public Criteria andOpenIdNotIn(List<String> values) {
            addCriterion("open_id not in", values, "openId");
            return (Criteria) this;
        }

        public Criteria andOpenIdBetween(String value1, String value2) {
            addCriterion("open_id between", value1, value2, "openId");
            return (Criteria) this;
        }

        public Criteria andOpenIdNotBetween(String value1, String value2) {
            addCriterion("open_id not between", value1, value2, "openId");
            return (Criteria) this;
        }

        public Criteria andAppTypeIdIsNull() {
            addCriterion("app_type_id is null");
            return (Criteria) this;
        }

        public Criteria andAppTypeIdIsNotNull() {
            addCriterion("app_type_id is not null");
            return (Criteria) this;
        }

        public Criteria andAppTypeIdEqualTo(Integer value) {
            addCriterion("app_type_id =", value, "appTypeId");
            return (Criteria) this;
        }

        public Criteria andAppTypeIdNotEqualTo(Integer value) {
            addCriterion("app_type_id <>", value, "appTypeId");
            return (Criteria) this;
        }

        public Criteria andAppTypeIdGreaterThan(Integer value) {
            addCriterion("app_type_id >", value, "appTypeId");
            return (Criteria) this;
        }

        public Criteria andAppTypeIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("app_type_id >=", value, "appTypeId");
            return (Criteria) this;
        }

        public Criteria andAppTypeIdLessThan(Integer value) {
            addCriterion("app_type_id <", value, "appTypeId");
            return (Criteria) this;
        }

        public Criteria andAppTypeIdLessThanOrEqualTo(Integer value) {
            addCriterion("app_type_id <=", value, "appTypeId");
            return (Criteria) this;
        }

        public Criteria andAppTypeIdIn(List<Integer> values) {
            addCriterion("app_type_id in", values, "appTypeId");
            return (Criteria) this;
        }

        public Criteria andAppTypeIdNotIn(List<Integer> values) {
            addCriterion("app_type_id not in", values, "appTypeId");
            return (Criteria) this;
        }

        public Criteria andAppTypeIdBetween(Integer value1, Integer value2) {
            addCriterion("app_type_id between", value1, value2, "appTypeId");
            return (Criteria) this;
        }

        public Criteria andAppTypeIdNotBetween(Integer value1, Integer value2) {
            addCriterion("app_type_id not between", value1, value2, "appTypeId");
            return (Criteria) this;
        }

        public Criteria andThirdUserInfoIsNull() {
            addCriterion("third_user_info is null");
            return (Criteria) this;
        }

        public Criteria andThirdUserInfoIsNotNull() {
            addCriterion("third_user_info is not null");
            return (Criteria) this;
        }

        public Criteria andThirdUserInfoEqualTo(String value) {
            addCriterion("third_user_info =", value, "thirdUserInfo");
            return (Criteria) this;
        }

        public Criteria andThirdUserInfoNotEqualTo(String value) {
            addCriterion("third_user_info <>", value, "thirdUserInfo");
            return (Criteria) this;
        }

        public Criteria andThirdUserInfoGreaterThan(String value) {
            addCriterion("third_user_info >", value, "thirdUserInfo");
            return (Criteria) this;
        }

        public Criteria andThirdUserInfoGreaterThanOrEqualTo(String value) {
            addCriterion("third_user_info >=", value, "thirdUserInfo");
            return (Criteria) this;
        }

        public Criteria andThirdUserInfoLessThan(String value) {
            addCriterion("third_user_info <", value, "thirdUserInfo");
            return (Criteria) this;
        }

        public Criteria andThirdUserInfoLessThanOrEqualTo(String value) {
            addCriterion("third_user_info <=", value, "thirdUserInfo");
            return (Criteria) this;
        }

        public Criteria andThirdUserInfoLike(String value) {
            addCriterion("third_user_info like", value, "thirdUserInfo");
            return (Criteria) this;
        }

        public Criteria andThirdUserInfoNotLike(String value) {
            addCriterion("third_user_info not like", value, "thirdUserInfo");
            return (Criteria) this;
        }

        public Criteria andThirdUserInfoIn(List<String> values) {
            addCriterion("third_user_info in", values, "thirdUserInfo");
            return (Criteria) this;
        }

        public Criteria andThirdUserInfoNotIn(List<String> values) {
            addCriterion("third_user_info not in", values, "thirdUserInfo");
            return (Criteria) this;
        }

        public Criteria andThirdUserInfoBetween(String value1, String value2) {
            addCriterion("third_user_info between", value1, value2, "thirdUserInfo");
            return (Criteria) this;
        }

        public Criteria andThirdUserInfoNotBetween(String value1, String value2) {
            addCriterion("third_user_info not between", value1, value2, "thirdUserInfo");
            return (Criteria) this;
        }

        public Criteria andWxRegistTimeIsNull() {
            addCriterion("wx_regist_time is null");
            return (Criteria) this;
        }

        public Criteria andWxRegistTimeIsNotNull() {
            addCriterion("wx_regist_time is not null");
            return (Criteria) this;
        }

        public Criteria andWxRegistTimeEqualTo(Date value) {
            addCriterion("wx_regist_time =", value, "wxRegistTime");
            return (Criteria) this;
        }

        public Criteria andWxRegistTimeNotEqualTo(Date value) {
            addCriterion("wx_regist_time <>", value, "wxRegistTime");
            return (Criteria) this;
        }

        public Criteria andWxRegistTimeGreaterThan(Date value) {
            addCriterion("wx_regist_time >", value, "wxRegistTime");
            return (Criteria) this;
        }

        public Criteria andWxRegistTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("wx_regist_time >=", value, "wxRegistTime");
            return (Criteria) this;
        }

        public Criteria andWxRegistTimeLessThan(Date value) {
            addCriterion("wx_regist_time <", value, "wxRegistTime");
            return (Criteria) this;
        }

        public Criteria andWxRegistTimeLessThanOrEqualTo(Date value) {
            addCriterion("wx_regist_time <=", value, "wxRegistTime");
            return (Criteria) this;
        }

        public Criteria andWxRegistTimeIn(List<Date> values) {
            addCriterion("wx_regist_time in", values, "wxRegistTime");
            return (Criteria) this;
        }

        public Criteria andWxRegistTimeNotIn(List<Date> values) {
            addCriterion("wx_regist_time not in", values, "wxRegistTime");
            return (Criteria) this;
        }

        public Criteria andWxRegistTimeBetween(Date value1, Date value2) {
            addCriterion("wx_regist_time between", value1, value2, "wxRegistTime");
            return (Criteria) this;
        }

        public Criteria andWxRegistTimeNotBetween(Date value1, Date value2) {
            addCriterion("wx_regist_time not between", value1, value2, "wxRegistTime");
            return (Criteria) this;
        }

        public Criteria andWxModifyTimeIsNull() {
            addCriterion("wx_modify_time is null");
            return (Criteria) this;
        }

        public Criteria andWxModifyTimeIsNotNull() {
            addCriterion("wx_modify_time is not null");
            return (Criteria) this;
        }

        public Criteria andWxModifyTimeEqualTo(Date value) {
            addCriterion("wx_modify_time =", value, "wxModifyTime");
            return (Criteria) this;
        }

        public Criteria andWxModifyTimeNotEqualTo(Date value) {
            addCriterion("wx_modify_time <>", value, "wxModifyTime");
            return (Criteria) this;
        }

        public Criteria andWxModifyTimeGreaterThan(Date value) {
            addCriterion("wx_modify_time >", value, "wxModifyTime");
            return (Criteria) this;
        }

        public Criteria andWxModifyTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("wx_modify_time >=", value, "wxModifyTime");
            return (Criteria) this;
        }

        public Criteria andWxModifyTimeLessThan(Date value) {
            addCriterion("wx_modify_time <", value, "wxModifyTime");
            return (Criteria) this;
        }

        public Criteria andWxModifyTimeLessThanOrEqualTo(Date value) {
            addCriterion("wx_modify_time <=", value, "wxModifyTime");
            return (Criteria) this;
        }

        public Criteria andWxModifyTimeIn(List<Date> values) {
            addCriterion("wx_modify_time in", values, "wxModifyTime");
            return (Criteria) this;
        }

        public Criteria andWxModifyTimeNotIn(List<Date> values) {
            addCriterion("wx_modify_time not in", values, "wxModifyTime");
            return (Criteria) this;
        }

        public Criteria andWxModifyTimeBetween(Date value1, Date value2) {
            addCriterion("wx_modify_time between", value1, value2, "wxModifyTime");
            return (Criteria) this;
        }

        public Criteria andWxModifyTimeNotBetween(Date value1, Date value2) {
            addCriterion("wx_modify_time not between", value1, value2, "wxModifyTime");
            return (Criteria) this;
        }

        public Criteria andAgentIdIsNull() {
            addCriterion("agent_id is null");
            return (Criteria) this;
        }

        public Criteria andAgentIdIsNotNull() {
            addCriterion("agent_id is not null");
            return (Criteria) this;
        }

        public Criteria andAgentIdEqualTo(Integer value) {
            addCriterion("agent_id =", value, "agentId");
            return (Criteria) this;
        }

        public Criteria andAgentIdNotEqualTo(Integer value) {
            addCriterion("agent_id <>", value, "agentId");
            return (Criteria) this;
        }

        public Criteria andAgentIdGreaterThan(Integer value) {
            addCriterion("agent_id >", value, "agentId");
            return (Criteria) this;
        }

        public Criteria andAgentIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("agent_id >=", value, "agentId");
            return (Criteria) this;
        }

        public Criteria andAgentIdLessThan(Integer value) {
            addCriterion("agent_id <", value, "agentId");
            return (Criteria) this;
        }

        public Criteria andAgentIdLessThanOrEqualTo(Integer value) {
            addCriterion("agent_id <=", value, "agentId");
            return (Criteria) this;
        }

        public Criteria andAgentIdIn(List<Integer> values) {
            addCriterion("agent_id in", values, "agentId");
            return (Criteria) this;
        }

        public Criteria andAgentIdNotIn(List<Integer> values) {
            addCriterion("agent_id not in", values, "agentId");
            return (Criteria) this;
        }

        public Criteria andAgentIdBetween(Integer value1, Integer value2) {
            addCriterion("agent_id between", value1, value2, "agentId");
            return (Criteria) this;
        }

        public Criteria andAgentIdNotBetween(Integer value1, Integer value2) {
            addCriterion("agent_id not between", value1, value2, "agentId");
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