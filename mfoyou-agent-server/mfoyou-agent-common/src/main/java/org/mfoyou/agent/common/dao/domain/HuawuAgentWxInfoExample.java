package org.mfoyou.agent.common.dao.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class HuawuAgentWxInfoExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    protected Integer limitStart;

    protected Integer limitEnd;

    public HuawuAgentWxInfoExample() {
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

        public Criteria andXcxIdIsNull() {
            addCriterion("xcx_id is null");
            return (Criteria) this;
        }

        public Criteria andXcxIdIsNotNull() {
            addCriterion("xcx_id is not null");
            return (Criteria) this;
        }

        public Criteria andXcxIdEqualTo(String value) {
            addCriterion("xcx_id =", value, "xcxId");
            return (Criteria) this;
        }

        public Criteria andXcxIdNotEqualTo(String value) {
            addCriterion("xcx_id <>", value, "xcxId");
            return (Criteria) this;
        }

        public Criteria andXcxIdGreaterThan(String value) {
            addCriterion("xcx_id >", value, "xcxId");
            return (Criteria) this;
        }

        public Criteria andXcxIdGreaterThanOrEqualTo(String value) {
            addCriterion("xcx_id >=", value, "xcxId");
            return (Criteria) this;
        }

        public Criteria andXcxIdLessThan(String value) {
            addCriterion("xcx_id <", value, "xcxId");
            return (Criteria) this;
        }

        public Criteria andXcxIdLessThanOrEqualTo(String value) {
            addCriterion("xcx_id <=", value, "xcxId");
            return (Criteria) this;
        }

        public Criteria andXcxIdLike(String value) {
            addCriterion("xcx_id like", value, "xcxId");
            return (Criteria) this;
        }

        public Criteria andXcxIdNotLike(String value) {
            addCriterion("xcx_id not like", value, "xcxId");
            return (Criteria) this;
        }

        public Criteria andXcxIdIn(List<String> values) {
            addCriterion("xcx_id in", values, "xcxId");
            return (Criteria) this;
        }

        public Criteria andXcxIdNotIn(List<String> values) {
            addCriterion("xcx_id not in", values, "xcxId");
            return (Criteria) this;
        }

        public Criteria andXcxIdBetween(String value1, String value2) {
            addCriterion("xcx_id between", value1, value2, "xcxId");
            return (Criteria) this;
        }

        public Criteria andXcxIdNotBetween(String value1, String value2) {
            addCriterion("xcx_id not between", value1, value2, "xcxId");
            return (Criteria) this;
        }

        public Criteria andXcxSecretIsNull() {
            addCriterion("xcx_secret is null");
            return (Criteria) this;
        }

        public Criteria andXcxSecretIsNotNull() {
            addCriterion("xcx_secret is not null");
            return (Criteria) this;
        }

        public Criteria andXcxSecretEqualTo(String value) {
            addCriterion("xcx_secret =", value, "xcxSecret");
            return (Criteria) this;
        }

        public Criteria andXcxSecretNotEqualTo(String value) {
            addCriterion("xcx_secret <>", value, "xcxSecret");
            return (Criteria) this;
        }

        public Criteria andXcxSecretGreaterThan(String value) {
            addCriterion("xcx_secret >", value, "xcxSecret");
            return (Criteria) this;
        }

        public Criteria andXcxSecretGreaterThanOrEqualTo(String value) {
            addCriterion("xcx_secret >=", value, "xcxSecret");
            return (Criteria) this;
        }

        public Criteria andXcxSecretLessThan(String value) {
            addCriterion("xcx_secret <", value, "xcxSecret");
            return (Criteria) this;
        }

        public Criteria andXcxSecretLessThanOrEqualTo(String value) {
            addCriterion("xcx_secret <=", value, "xcxSecret");
            return (Criteria) this;
        }

        public Criteria andXcxSecretLike(String value) {
            addCriterion("xcx_secret like", value, "xcxSecret");
            return (Criteria) this;
        }

        public Criteria andXcxSecretNotLike(String value) {
            addCriterion("xcx_secret not like", value, "xcxSecret");
            return (Criteria) this;
        }

        public Criteria andXcxSecretIn(List<String> values) {
            addCriterion("xcx_secret in", values, "xcxSecret");
            return (Criteria) this;
        }

        public Criteria andXcxSecretNotIn(List<String> values) {
            addCriterion("xcx_secret not in", values, "xcxSecret");
            return (Criteria) this;
        }

        public Criteria andXcxSecretBetween(String value1, String value2) {
            addCriterion("xcx_secret between", value1, value2, "xcxSecret");
            return (Criteria) this;
        }

        public Criteria andXcxSecretNotBetween(String value1, String value2) {
            addCriterion("xcx_secret not between", value1, value2, "xcxSecret");
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

        public Criteria andXcxTypeIsNull() {
            addCriterion("xcx_type is null");
            return (Criteria) this;
        }

        public Criteria andXcxTypeIsNotNull() {
            addCriterion("xcx_type is not null");
            return (Criteria) this;
        }

        public Criteria andXcxTypeEqualTo(Integer value) {
            addCriterion("xcx_type =", value, "xcxType");
            return (Criteria) this;
        }

        public Criteria andXcxTypeNotEqualTo(Integer value) {
            addCriterion("xcx_type <>", value, "xcxType");
            return (Criteria) this;
        }

        public Criteria andXcxTypeGreaterThan(Integer value) {
            addCriterion("xcx_type >", value, "xcxType");
            return (Criteria) this;
        }

        public Criteria andXcxTypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("xcx_type >=", value, "xcxType");
            return (Criteria) this;
        }

        public Criteria andXcxTypeLessThan(Integer value) {
            addCriterion("xcx_type <", value, "xcxType");
            return (Criteria) this;
        }

        public Criteria andXcxTypeLessThanOrEqualTo(Integer value) {
            addCriterion("xcx_type <=", value, "xcxType");
            return (Criteria) this;
        }

        public Criteria andXcxTypeIn(List<Integer> values) {
            addCriterion("xcx_type in", values, "xcxType");
            return (Criteria) this;
        }

        public Criteria andXcxTypeNotIn(List<Integer> values) {
            addCriterion("xcx_type not in", values, "xcxType");
            return (Criteria) this;
        }

        public Criteria andXcxTypeBetween(Integer value1, Integer value2) {
            addCriterion("xcx_type between", value1, value2, "xcxType");
            return (Criteria) this;
        }

        public Criteria andXcxTypeNotBetween(Integer value1, Integer value2) {
            addCriterion("xcx_type not between", value1, value2, "xcxType");
            return (Criteria) this;
        }

        public Criteria andXcxMchidIsNull() {
            addCriterion("xcx_mchid is null");
            return (Criteria) this;
        }

        public Criteria andXcxMchidIsNotNull() {
            addCriterion("xcx_mchid is not null");
            return (Criteria) this;
        }

        public Criteria andXcxMchidEqualTo(String value) {
            addCriterion("xcx_mchid =", value, "xcxMchid");
            return (Criteria) this;
        }

        public Criteria andXcxMchidNotEqualTo(String value) {
            addCriterion("xcx_mchid <>", value, "xcxMchid");
            return (Criteria) this;
        }

        public Criteria andXcxMchidGreaterThan(String value) {
            addCriterion("xcx_mchid >", value, "xcxMchid");
            return (Criteria) this;
        }

        public Criteria andXcxMchidGreaterThanOrEqualTo(String value) {
            addCriterion("xcx_mchid >=", value, "xcxMchid");
            return (Criteria) this;
        }

        public Criteria andXcxMchidLessThan(String value) {
            addCriterion("xcx_mchid <", value, "xcxMchid");
            return (Criteria) this;
        }

        public Criteria andXcxMchidLessThanOrEqualTo(String value) {
            addCriterion("xcx_mchid <=", value, "xcxMchid");
            return (Criteria) this;
        }

        public Criteria andXcxMchidLike(String value) {
            addCriterion("xcx_mchid like", value, "xcxMchid");
            return (Criteria) this;
        }

        public Criteria andXcxMchidNotLike(String value) {
            addCriterion("xcx_mchid not like", value, "xcxMchid");
            return (Criteria) this;
        }

        public Criteria andXcxMchidIn(List<String> values) {
            addCriterion("xcx_mchid in", values, "xcxMchid");
            return (Criteria) this;
        }

        public Criteria andXcxMchidNotIn(List<String> values) {
            addCriterion("xcx_mchid not in", values, "xcxMchid");
            return (Criteria) this;
        }

        public Criteria andXcxMchidBetween(String value1, String value2) {
            addCriterion("xcx_mchid between", value1, value2, "xcxMchid");
            return (Criteria) this;
        }

        public Criteria andXcxMchidNotBetween(String value1, String value2) {
            addCriterion("xcx_mchid not between", value1, value2, "xcxMchid");
            return (Criteria) this;
        }

        public Criteria andXcxPayRediPathIsNull() {
            addCriterion("xcx_pay_redi_path is null");
            return (Criteria) this;
        }

        public Criteria andXcxPayRediPathIsNotNull() {
            addCriterion("xcx_pay_redi_path is not null");
            return (Criteria) this;
        }

        public Criteria andXcxPayRediPathEqualTo(String value) {
            addCriterion("xcx_pay_redi_path =", value, "xcxPayRediPath");
            return (Criteria) this;
        }

        public Criteria andXcxPayRediPathNotEqualTo(String value) {
            addCriterion("xcx_pay_redi_path <>", value, "xcxPayRediPath");
            return (Criteria) this;
        }

        public Criteria andXcxPayRediPathGreaterThan(String value) {
            addCriterion("xcx_pay_redi_path >", value, "xcxPayRediPath");
            return (Criteria) this;
        }

        public Criteria andXcxPayRediPathGreaterThanOrEqualTo(String value) {
            addCriterion("xcx_pay_redi_path >=", value, "xcxPayRediPath");
            return (Criteria) this;
        }

        public Criteria andXcxPayRediPathLessThan(String value) {
            addCriterion("xcx_pay_redi_path <", value, "xcxPayRediPath");
            return (Criteria) this;
        }

        public Criteria andXcxPayRediPathLessThanOrEqualTo(String value) {
            addCriterion("xcx_pay_redi_path <=", value, "xcxPayRediPath");
            return (Criteria) this;
        }

        public Criteria andXcxPayRediPathLike(String value) {
            addCriterion("xcx_pay_redi_path like", value, "xcxPayRediPath");
            return (Criteria) this;
        }

        public Criteria andXcxPayRediPathNotLike(String value) {
            addCriterion("xcx_pay_redi_path not like", value, "xcxPayRediPath");
            return (Criteria) this;
        }

        public Criteria andXcxPayRediPathIn(List<String> values) {
            addCriterion("xcx_pay_redi_path in", values, "xcxPayRediPath");
            return (Criteria) this;
        }

        public Criteria andXcxPayRediPathNotIn(List<String> values) {
            addCriterion("xcx_pay_redi_path not in", values, "xcxPayRediPath");
            return (Criteria) this;
        }

        public Criteria andXcxPayRediPathBetween(String value1, String value2) {
            addCriterion("xcx_pay_redi_path between", value1, value2, "xcxPayRediPath");
            return (Criteria) this;
        }

        public Criteria andXcxPayRediPathNotBetween(String value1, String value2) {
            addCriterion("xcx_pay_redi_path not between", value1, value2, "xcxPayRediPath");
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

        public Criteria andXcxPaySecretIsNull() {
            addCriterion("xcx_pay_secret is null");
            return (Criteria) this;
        }

        public Criteria andXcxPaySecretIsNotNull() {
            addCriterion("xcx_pay_secret is not null");
            return (Criteria) this;
        }

        public Criteria andXcxPaySecretEqualTo(String value) {
            addCriterion("xcx_pay_secret =", value, "xcxPaySecret");
            return (Criteria) this;
        }

        public Criteria andXcxPaySecretNotEqualTo(String value) {
            addCriterion("xcx_pay_secret <>", value, "xcxPaySecret");
            return (Criteria) this;
        }

        public Criteria andXcxPaySecretGreaterThan(String value) {
            addCriterion("xcx_pay_secret >", value, "xcxPaySecret");
            return (Criteria) this;
        }

        public Criteria andXcxPaySecretGreaterThanOrEqualTo(String value) {
            addCriterion("xcx_pay_secret >=", value, "xcxPaySecret");
            return (Criteria) this;
        }

        public Criteria andXcxPaySecretLessThan(String value) {
            addCriterion("xcx_pay_secret <", value, "xcxPaySecret");
            return (Criteria) this;
        }

        public Criteria andXcxPaySecretLessThanOrEqualTo(String value) {
            addCriterion("xcx_pay_secret <=", value, "xcxPaySecret");
            return (Criteria) this;
        }

        public Criteria andXcxPaySecretLike(String value) {
            addCriterion("xcx_pay_secret like", value, "xcxPaySecret");
            return (Criteria) this;
        }

        public Criteria andXcxPaySecretNotLike(String value) {
            addCriterion("xcx_pay_secret not like", value, "xcxPaySecret");
            return (Criteria) this;
        }

        public Criteria andXcxPaySecretIn(List<String> values) {
            addCriterion("xcx_pay_secret in", values, "xcxPaySecret");
            return (Criteria) this;
        }

        public Criteria andXcxPaySecretNotIn(List<String> values) {
            addCriterion("xcx_pay_secret not in", values, "xcxPaySecret");
            return (Criteria) this;
        }

        public Criteria andXcxPaySecretBetween(String value1, String value2) {
            addCriterion("xcx_pay_secret between", value1, value2, "xcxPaySecret");
            return (Criteria) this;
        }

        public Criteria andXcxPaySecretNotBetween(String value1, String value2) {
            addCriterion("xcx_pay_secret not between", value1, value2, "xcxPaySecret");
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