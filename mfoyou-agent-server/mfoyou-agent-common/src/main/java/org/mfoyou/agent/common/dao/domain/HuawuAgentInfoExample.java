package org.mfoyou.agent.common.dao.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class HuawuAgentInfoExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    protected Integer limitStart;

    protected Integer limitEnd;

    public HuawuAgentInfoExample() {
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

        public Criteria andAgentNameIsNull() {
            addCriterion("agent_name is null");
            return (Criteria) this;
        }

        public Criteria andAgentNameIsNotNull() {
            addCriterion("agent_name is not null");
            return (Criteria) this;
        }

        public Criteria andAgentNameEqualTo(String value) {
            addCriterion("agent_name =", value, "agentName");
            return (Criteria) this;
        }

        public Criteria andAgentNameNotEqualTo(String value) {
            addCriterion("agent_name <>", value, "agentName");
            return (Criteria) this;
        }

        public Criteria andAgentNameGreaterThan(String value) {
            addCriterion("agent_name >", value, "agentName");
            return (Criteria) this;
        }

        public Criteria andAgentNameGreaterThanOrEqualTo(String value) {
            addCriterion("agent_name >=", value, "agentName");
            return (Criteria) this;
        }

        public Criteria andAgentNameLessThan(String value) {
            addCriterion("agent_name <", value, "agentName");
            return (Criteria) this;
        }

        public Criteria andAgentNameLessThanOrEqualTo(String value) {
            addCriterion("agent_name <=", value, "agentName");
            return (Criteria) this;
        }

        public Criteria andAgentNameLike(String value) {
            addCriterion("agent_name like", value, "agentName");
            return (Criteria) this;
        }

        public Criteria andAgentNameNotLike(String value) {
            addCriterion("agent_name not like", value, "agentName");
            return (Criteria) this;
        }

        public Criteria andAgentNameIn(List<String> values) {
            addCriterion("agent_name in", values, "agentName");
            return (Criteria) this;
        }

        public Criteria andAgentNameNotIn(List<String> values) {
            addCriterion("agent_name not in", values, "agentName");
            return (Criteria) this;
        }

        public Criteria andAgentNameBetween(String value1, String value2) {
            addCriterion("agent_name between", value1, value2, "agentName");
            return (Criteria) this;
        }

        public Criteria andAgentNameNotBetween(String value1, String value2) {
            addCriterion("agent_name not between", value1, value2, "agentName");
            return (Criteria) this;
        }

        public Criteria andAgentUserContactsIsNull() {
            addCriterion("agent_user_contacts is null");
            return (Criteria) this;
        }

        public Criteria andAgentUserContactsIsNotNull() {
            addCriterion("agent_user_contacts is not null");
            return (Criteria) this;
        }

        public Criteria andAgentUserContactsEqualTo(String value) {
            addCriterion("agent_user_contacts =", value, "agentUserContacts");
            return (Criteria) this;
        }

        public Criteria andAgentUserContactsNotEqualTo(String value) {
            addCriterion("agent_user_contacts <>", value, "agentUserContacts");
            return (Criteria) this;
        }

        public Criteria andAgentUserContactsGreaterThan(String value) {
            addCriterion("agent_user_contacts >", value, "agentUserContacts");
            return (Criteria) this;
        }

        public Criteria andAgentUserContactsGreaterThanOrEqualTo(String value) {
            addCriterion("agent_user_contacts >=", value, "agentUserContacts");
            return (Criteria) this;
        }

        public Criteria andAgentUserContactsLessThan(String value) {
            addCriterion("agent_user_contacts <", value, "agentUserContacts");
            return (Criteria) this;
        }

        public Criteria andAgentUserContactsLessThanOrEqualTo(String value) {
            addCriterion("agent_user_contacts <=", value, "agentUserContacts");
            return (Criteria) this;
        }

        public Criteria andAgentUserContactsLike(String value) {
            addCriterion("agent_user_contacts like", value, "agentUserContacts");
            return (Criteria) this;
        }

        public Criteria andAgentUserContactsNotLike(String value) {
            addCriterion("agent_user_contacts not like", value, "agentUserContacts");
            return (Criteria) this;
        }

        public Criteria andAgentUserContactsIn(List<String> values) {
            addCriterion("agent_user_contacts in", values, "agentUserContacts");
            return (Criteria) this;
        }

        public Criteria andAgentUserContactsNotIn(List<String> values) {
            addCriterion("agent_user_contacts not in", values, "agentUserContacts");
            return (Criteria) this;
        }

        public Criteria andAgentUserContactsBetween(String value1, String value2) {
            addCriterion("agent_user_contacts between", value1, value2, "agentUserContacts");
            return (Criteria) this;
        }

        public Criteria andAgentUserContactsNotBetween(String value1, String value2) {
            addCriterion("agent_user_contacts not between", value1, value2, "agentUserContacts");
            return (Criteria) this;
        }

        public Criteria andAgentPhoneIsNull() {
            addCriterion("agent_phone is null");
            return (Criteria) this;
        }

        public Criteria andAgentPhoneIsNotNull() {
            addCriterion("agent_phone is not null");
            return (Criteria) this;
        }

        public Criteria andAgentPhoneEqualTo(String value) {
            addCriterion("agent_phone =", value, "agentPhone");
            return (Criteria) this;
        }

        public Criteria andAgentPhoneNotEqualTo(String value) {
            addCriterion("agent_phone <>", value, "agentPhone");
            return (Criteria) this;
        }

        public Criteria andAgentPhoneGreaterThan(String value) {
            addCriterion("agent_phone >", value, "agentPhone");
            return (Criteria) this;
        }

        public Criteria andAgentPhoneGreaterThanOrEqualTo(String value) {
            addCriterion("agent_phone >=", value, "agentPhone");
            return (Criteria) this;
        }

        public Criteria andAgentPhoneLessThan(String value) {
            addCriterion("agent_phone <", value, "agentPhone");
            return (Criteria) this;
        }

        public Criteria andAgentPhoneLessThanOrEqualTo(String value) {
            addCriterion("agent_phone <=", value, "agentPhone");
            return (Criteria) this;
        }

        public Criteria andAgentPhoneLike(String value) {
            addCriterion("agent_phone like", value, "agentPhone");
            return (Criteria) this;
        }

        public Criteria andAgentPhoneNotLike(String value) {
            addCriterion("agent_phone not like", value, "agentPhone");
            return (Criteria) this;
        }

        public Criteria andAgentPhoneIn(List<String> values) {
            addCriterion("agent_phone in", values, "agentPhone");
            return (Criteria) this;
        }

        public Criteria andAgentPhoneNotIn(List<String> values) {
            addCriterion("agent_phone not in", values, "agentPhone");
            return (Criteria) this;
        }

        public Criteria andAgentPhoneBetween(String value1, String value2) {
            addCriterion("agent_phone between", value1, value2, "agentPhone");
            return (Criteria) this;
        }

        public Criteria andAgentPhoneNotBetween(String value1, String value2) {
            addCriterion("agent_phone not between", value1, value2, "agentPhone");
            return (Criteria) this;
        }

        public Criteria andAgentAuditStateIsNull() {
            addCriterion("agent_audit_state is null");
            return (Criteria) this;
        }

        public Criteria andAgentAuditStateIsNotNull() {
            addCriterion("agent_audit_state is not null");
            return (Criteria) this;
        }

        public Criteria andAgentAuditStateEqualTo(Integer value) {
            addCriterion("agent_audit_state =", value, "agentAuditState");
            return (Criteria) this;
        }

        public Criteria andAgentAuditStateNotEqualTo(Integer value) {
            addCriterion("agent_audit_state <>", value, "agentAuditState");
            return (Criteria) this;
        }

        public Criteria andAgentAuditStateGreaterThan(Integer value) {
            addCriterion("agent_audit_state >", value, "agentAuditState");
            return (Criteria) this;
        }

        public Criteria andAgentAuditStateGreaterThanOrEqualTo(Integer value) {
            addCriterion("agent_audit_state >=", value, "agentAuditState");
            return (Criteria) this;
        }

        public Criteria andAgentAuditStateLessThan(Integer value) {
            addCriterion("agent_audit_state <", value, "agentAuditState");
            return (Criteria) this;
        }

        public Criteria andAgentAuditStateLessThanOrEqualTo(Integer value) {
            addCriterion("agent_audit_state <=", value, "agentAuditState");
            return (Criteria) this;
        }

        public Criteria andAgentAuditStateIn(List<Integer> values) {
            addCriterion("agent_audit_state in", values, "agentAuditState");
            return (Criteria) this;
        }

        public Criteria andAgentAuditStateNotIn(List<Integer> values) {
            addCriterion("agent_audit_state not in", values, "agentAuditState");
            return (Criteria) this;
        }

        public Criteria andAgentAuditStateBetween(Integer value1, Integer value2) {
            addCriterion("agent_audit_state between", value1, value2, "agentAuditState");
            return (Criteria) this;
        }

        public Criteria andAgentAuditStateNotBetween(Integer value1, Integer value2) {
            addCriterion("agent_audit_state not between", value1, value2, "agentAuditState");
            return (Criteria) this;
        }

        public Criteria andAgentUserNameIsNull() {
            addCriterion("agent_user_name is null");
            return (Criteria) this;
        }

        public Criteria andAgentUserNameIsNotNull() {
            addCriterion("agent_user_name is not null");
            return (Criteria) this;
        }

        public Criteria andAgentUserNameEqualTo(String value) {
            addCriterion("agent_user_name =", value, "agentUserName");
            return (Criteria) this;
        }

        public Criteria andAgentUserNameNotEqualTo(String value) {
            addCriterion("agent_user_name <>", value, "agentUserName");
            return (Criteria) this;
        }

        public Criteria andAgentUserNameGreaterThan(String value) {
            addCriterion("agent_user_name >", value, "agentUserName");
            return (Criteria) this;
        }

        public Criteria andAgentUserNameGreaterThanOrEqualTo(String value) {
            addCriterion("agent_user_name >=", value, "agentUserName");
            return (Criteria) this;
        }

        public Criteria andAgentUserNameLessThan(String value) {
            addCriterion("agent_user_name <", value, "agentUserName");
            return (Criteria) this;
        }

        public Criteria andAgentUserNameLessThanOrEqualTo(String value) {
            addCriterion("agent_user_name <=", value, "agentUserName");
            return (Criteria) this;
        }

        public Criteria andAgentUserNameLike(String value) {
            addCriterion("agent_user_name like", value, "agentUserName");
            return (Criteria) this;
        }

        public Criteria andAgentUserNameNotLike(String value) {
            addCriterion("agent_user_name not like", value, "agentUserName");
            return (Criteria) this;
        }

        public Criteria andAgentUserNameIn(List<String> values) {
            addCriterion("agent_user_name in", values, "agentUserName");
            return (Criteria) this;
        }

        public Criteria andAgentUserNameNotIn(List<String> values) {
            addCriterion("agent_user_name not in", values, "agentUserName");
            return (Criteria) this;
        }

        public Criteria andAgentUserNameBetween(String value1, String value2) {
            addCriterion("agent_user_name between", value1, value2, "agentUserName");
            return (Criteria) this;
        }

        public Criteria andAgentUserNameNotBetween(String value1, String value2) {
            addCriterion("agent_user_name not between", value1, value2, "agentUserName");
            return (Criteria) this;
        }

        public Criteria andAgentStartTimeIsNull() {
            addCriterion("agent_start_time is null");
            return (Criteria) this;
        }

        public Criteria andAgentStartTimeIsNotNull() {
            addCriterion("agent_start_time is not null");
            return (Criteria) this;
        }

        public Criteria andAgentStartTimeEqualTo(Date value) {
            addCriterion("agent_start_time =", value, "agentStartTime");
            return (Criteria) this;
        }

        public Criteria andAgentStartTimeNotEqualTo(Date value) {
            addCriterion("agent_start_time <>", value, "agentStartTime");
            return (Criteria) this;
        }

        public Criteria andAgentStartTimeGreaterThan(Date value) {
            addCriterion("agent_start_time >", value, "agentStartTime");
            return (Criteria) this;
        }

        public Criteria andAgentStartTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("agent_start_time >=", value, "agentStartTime");
            return (Criteria) this;
        }

        public Criteria andAgentStartTimeLessThan(Date value) {
            addCriterion("agent_start_time <", value, "agentStartTime");
            return (Criteria) this;
        }

        public Criteria andAgentStartTimeLessThanOrEqualTo(Date value) {
            addCriterion("agent_start_time <=", value, "agentStartTime");
            return (Criteria) this;
        }

        public Criteria andAgentStartTimeIn(List<Date> values) {
            addCriterion("agent_start_time in", values, "agentStartTime");
            return (Criteria) this;
        }

        public Criteria andAgentStartTimeNotIn(List<Date> values) {
            addCriterion("agent_start_time not in", values, "agentStartTime");
            return (Criteria) this;
        }

        public Criteria andAgentStartTimeBetween(Date value1, Date value2) {
            addCriterion("agent_start_time between", value1, value2, "agentStartTime");
            return (Criteria) this;
        }

        public Criteria andAgentStartTimeNotBetween(Date value1, Date value2) {
            addCriterion("agent_start_time not between", value1, value2, "agentStartTime");
            return (Criteria) this;
        }

        public Criteria andAgentEndTimeIsNull() {
            addCriterion("agent_end_time is null");
            return (Criteria) this;
        }

        public Criteria andAgentEndTimeIsNotNull() {
            addCriterion("agent_end_time is not null");
            return (Criteria) this;
        }

        public Criteria andAgentEndTimeEqualTo(Date value) {
            addCriterion("agent_end_time =", value, "agentEndTime");
            return (Criteria) this;
        }

        public Criteria andAgentEndTimeNotEqualTo(Date value) {
            addCriterion("agent_end_time <>", value, "agentEndTime");
            return (Criteria) this;
        }

        public Criteria andAgentEndTimeGreaterThan(Date value) {
            addCriterion("agent_end_time >", value, "agentEndTime");
            return (Criteria) this;
        }

        public Criteria andAgentEndTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("agent_end_time >=", value, "agentEndTime");
            return (Criteria) this;
        }

        public Criteria andAgentEndTimeLessThan(Date value) {
            addCriterion("agent_end_time <", value, "agentEndTime");
            return (Criteria) this;
        }

        public Criteria andAgentEndTimeLessThanOrEqualTo(Date value) {
            addCriterion("agent_end_time <=", value, "agentEndTime");
            return (Criteria) this;
        }

        public Criteria andAgentEndTimeIn(List<Date> values) {
            addCriterion("agent_end_time in", values, "agentEndTime");
            return (Criteria) this;
        }

        public Criteria andAgentEndTimeNotIn(List<Date> values) {
            addCriterion("agent_end_time not in", values, "agentEndTime");
            return (Criteria) this;
        }

        public Criteria andAgentEndTimeBetween(Date value1, Date value2) {
            addCriterion("agent_end_time between", value1, value2, "agentEndTime");
            return (Criteria) this;
        }

        public Criteria andAgentEndTimeNotBetween(Date value1, Date value2) {
            addCriterion("agent_end_time not between", value1, value2, "agentEndTime");
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