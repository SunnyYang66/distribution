package org.mfoyou.agent.common.dao.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class HuawuIdcardInfoExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    protected Integer limitStart;

    protected Integer limitEnd;

    public HuawuIdcardInfoExample() {
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

        public Criteria andUserTypeIsNull() {
            addCriterion("user_type is null");
            return (Criteria) this;
        }

        public Criteria andUserTypeIsNotNull() {
            addCriterion("user_type is not null");
            return (Criteria) this;
        }

        public Criteria andUserTypeEqualTo(Integer value) {
            addCriterion("user_type =", value, "userType");
            return (Criteria) this;
        }

        public Criteria andUserTypeNotEqualTo(Integer value) {
            addCriterion("user_type <>", value, "userType");
            return (Criteria) this;
        }

        public Criteria andUserTypeGreaterThan(Integer value) {
            addCriterion("user_type >", value, "userType");
            return (Criteria) this;
        }

        public Criteria andUserTypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("user_type >=", value, "userType");
            return (Criteria) this;
        }

        public Criteria andUserTypeLessThan(Integer value) {
            addCriterion("user_type <", value, "userType");
            return (Criteria) this;
        }

        public Criteria andUserTypeLessThanOrEqualTo(Integer value) {
            addCriterion("user_type <=", value, "userType");
            return (Criteria) this;
        }

        public Criteria andUserTypeIn(List<Integer> values) {
            addCriterion("user_type in", values, "userType");
            return (Criteria) this;
        }

        public Criteria andUserTypeNotIn(List<Integer> values) {
            addCriterion("user_type not in", values, "userType");
            return (Criteria) this;
        }

        public Criteria andUserTypeBetween(Integer value1, Integer value2) {
            addCriterion("user_type between", value1, value2, "userType");
            return (Criteria) this;
        }

        public Criteria andUserTypeNotBetween(Integer value1, Integer value2) {
            addCriterion("user_type not between", value1, value2, "userType");
            return (Criteria) this;
        }

        public Criteria andUserTrueNameIsNull() {
            addCriterion("user_true_name is null");
            return (Criteria) this;
        }

        public Criteria andUserTrueNameIsNotNull() {
            addCriterion("user_true_name is not null");
            return (Criteria) this;
        }

        public Criteria andUserTrueNameEqualTo(String value) {
            addCriterion("user_true_name =", value, "userTrueName");
            return (Criteria) this;
        }

        public Criteria andUserTrueNameNotEqualTo(String value) {
            addCriterion("user_true_name <>", value, "userTrueName");
            return (Criteria) this;
        }

        public Criteria andUserTrueNameGreaterThan(String value) {
            addCriterion("user_true_name >", value, "userTrueName");
            return (Criteria) this;
        }

        public Criteria andUserTrueNameGreaterThanOrEqualTo(String value) {
            addCriterion("user_true_name >=", value, "userTrueName");
            return (Criteria) this;
        }

        public Criteria andUserTrueNameLessThan(String value) {
            addCriterion("user_true_name <", value, "userTrueName");
            return (Criteria) this;
        }

        public Criteria andUserTrueNameLessThanOrEqualTo(String value) {
            addCriterion("user_true_name <=", value, "userTrueName");
            return (Criteria) this;
        }

        public Criteria andUserTrueNameLike(String value) {
            addCriterion("user_true_name like", value, "userTrueName");
            return (Criteria) this;
        }

        public Criteria andUserTrueNameNotLike(String value) {
            addCriterion("user_true_name not like", value, "userTrueName");
            return (Criteria) this;
        }

        public Criteria andUserTrueNameIn(List<String> values) {
            addCriterion("user_true_name in", values, "userTrueName");
            return (Criteria) this;
        }

        public Criteria andUserTrueNameNotIn(List<String> values) {
            addCriterion("user_true_name not in", values, "userTrueName");
            return (Criteria) this;
        }

        public Criteria andUserTrueNameBetween(String value1, String value2) {
            addCriterion("user_true_name between", value1, value2, "userTrueName");
            return (Criteria) this;
        }

        public Criteria andUserTrueNameNotBetween(String value1, String value2) {
            addCriterion("user_true_name not between", value1, value2, "userTrueName");
            return (Criteria) this;
        }

        public Criteria andUserIdCodeIsNull() {
            addCriterion("user_id_code is null");
            return (Criteria) this;
        }

        public Criteria andUserIdCodeIsNotNull() {
            addCriterion("user_id_code is not null");
            return (Criteria) this;
        }

        public Criteria andUserIdCodeEqualTo(String value) {
            addCriterion("user_id_code =", value, "userIdCode");
            return (Criteria) this;
        }

        public Criteria andUserIdCodeNotEqualTo(String value) {
            addCriterion("user_id_code <>", value, "userIdCode");
            return (Criteria) this;
        }

        public Criteria andUserIdCodeGreaterThan(String value) {
            addCriterion("user_id_code >", value, "userIdCode");
            return (Criteria) this;
        }

        public Criteria andUserIdCodeGreaterThanOrEqualTo(String value) {
            addCriterion("user_id_code >=", value, "userIdCode");
            return (Criteria) this;
        }

        public Criteria andUserIdCodeLessThan(String value) {
            addCriterion("user_id_code <", value, "userIdCode");
            return (Criteria) this;
        }

        public Criteria andUserIdCodeLessThanOrEqualTo(String value) {
            addCriterion("user_id_code <=", value, "userIdCode");
            return (Criteria) this;
        }

        public Criteria andUserIdCodeLike(String value) {
            addCriterion("user_id_code like", value, "userIdCode");
            return (Criteria) this;
        }

        public Criteria andUserIdCodeNotLike(String value) {
            addCriterion("user_id_code not like", value, "userIdCode");
            return (Criteria) this;
        }

        public Criteria andUserIdCodeIn(List<String> values) {
            addCriterion("user_id_code in", values, "userIdCode");
            return (Criteria) this;
        }

        public Criteria andUserIdCodeNotIn(List<String> values) {
            addCriterion("user_id_code not in", values, "userIdCode");
            return (Criteria) this;
        }

        public Criteria andUserIdCodeBetween(String value1, String value2) {
            addCriterion("user_id_code between", value1, value2, "userIdCode");
            return (Criteria) this;
        }

        public Criteria andUserIdCodeNotBetween(String value1, String value2) {
            addCriterion("user_id_code not between", value1, value2, "userIdCode");
            return (Criteria) this;
        }

        public Criteria andUserHandleIdcardIsNull() {
            addCriterion("user_handle_idcard is null");
            return (Criteria) this;
        }

        public Criteria andUserHandleIdcardIsNotNull() {
            addCriterion("user_handle_idcard is not null");
            return (Criteria) this;
        }

        public Criteria andUserHandleIdcardEqualTo(String value) {
            addCriterion("user_handle_idcard =", value, "userHandleIdcard");
            return (Criteria) this;
        }

        public Criteria andUserHandleIdcardNotEqualTo(String value) {
            addCriterion("user_handle_idcard <>", value, "userHandleIdcard");
            return (Criteria) this;
        }

        public Criteria andUserHandleIdcardGreaterThan(String value) {
            addCriterion("user_handle_idcard >", value, "userHandleIdcard");
            return (Criteria) this;
        }

        public Criteria andUserHandleIdcardGreaterThanOrEqualTo(String value) {
            addCriterion("user_handle_idcard >=", value, "userHandleIdcard");
            return (Criteria) this;
        }

        public Criteria andUserHandleIdcardLessThan(String value) {
            addCriterion("user_handle_idcard <", value, "userHandleIdcard");
            return (Criteria) this;
        }

        public Criteria andUserHandleIdcardLessThanOrEqualTo(String value) {
            addCriterion("user_handle_idcard <=", value, "userHandleIdcard");
            return (Criteria) this;
        }

        public Criteria andUserHandleIdcardLike(String value) {
            addCriterion("user_handle_idcard like", value, "userHandleIdcard");
            return (Criteria) this;
        }

        public Criteria andUserHandleIdcardNotLike(String value) {
            addCriterion("user_handle_idcard not like", value, "userHandleIdcard");
            return (Criteria) this;
        }

        public Criteria andUserHandleIdcardIn(List<String> values) {
            addCriterion("user_handle_idcard in", values, "userHandleIdcard");
            return (Criteria) this;
        }

        public Criteria andUserHandleIdcardNotIn(List<String> values) {
            addCriterion("user_handle_idcard not in", values, "userHandleIdcard");
            return (Criteria) this;
        }

        public Criteria andUserHandleIdcardBetween(String value1, String value2) {
            addCriterion("user_handle_idcard between", value1, value2, "userHandleIdcard");
            return (Criteria) this;
        }

        public Criteria andUserHandleIdcardNotBetween(String value1, String value2) {
            addCriterion("user_handle_idcard not between", value1, value2, "userHandleIdcard");
            return (Criteria) this;
        }

        public Criteria andUserFactIdcardIsNull() {
            addCriterion("user_fact_idcard is null");
            return (Criteria) this;
        }

        public Criteria andUserFactIdcardIsNotNull() {
            addCriterion("user_fact_idcard is not null");
            return (Criteria) this;
        }

        public Criteria andUserFactIdcardEqualTo(String value) {
            addCriterion("user_fact_idcard =", value, "userFactIdcard");
            return (Criteria) this;
        }

        public Criteria andUserFactIdcardNotEqualTo(String value) {
            addCriterion("user_fact_idcard <>", value, "userFactIdcard");
            return (Criteria) this;
        }

        public Criteria andUserFactIdcardGreaterThan(String value) {
            addCriterion("user_fact_idcard >", value, "userFactIdcard");
            return (Criteria) this;
        }

        public Criteria andUserFactIdcardGreaterThanOrEqualTo(String value) {
            addCriterion("user_fact_idcard >=", value, "userFactIdcard");
            return (Criteria) this;
        }

        public Criteria andUserFactIdcardLessThan(String value) {
            addCriterion("user_fact_idcard <", value, "userFactIdcard");
            return (Criteria) this;
        }

        public Criteria andUserFactIdcardLessThanOrEqualTo(String value) {
            addCriterion("user_fact_idcard <=", value, "userFactIdcard");
            return (Criteria) this;
        }

        public Criteria andUserFactIdcardLike(String value) {
            addCriterion("user_fact_idcard like", value, "userFactIdcard");
            return (Criteria) this;
        }

        public Criteria andUserFactIdcardNotLike(String value) {
            addCriterion("user_fact_idcard not like", value, "userFactIdcard");
            return (Criteria) this;
        }

        public Criteria andUserFactIdcardIn(List<String> values) {
            addCriterion("user_fact_idcard in", values, "userFactIdcard");
            return (Criteria) this;
        }

        public Criteria andUserFactIdcardNotIn(List<String> values) {
            addCriterion("user_fact_idcard not in", values, "userFactIdcard");
            return (Criteria) this;
        }

        public Criteria andUserFactIdcardBetween(String value1, String value2) {
            addCriterion("user_fact_idcard between", value1, value2, "userFactIdcard");
            return (Criteria) this;
        }

        public Criteria andUserFactIdcardNotBetween(String value1, String value2) {
            addCriterion("user_fact_idcard not between", value1, value2, "userFactIdcard");
            return (Criteria) this;
        }

        public Criteria andUserReverseIdcardIsNull() {
            addCriterion("user_reverse_idcard is null");
            return (Criteria) this;
        }

        public Criteria andUserReverseIdcardIsNotNull() {
            addCriterion("user_reverse_idcard is not null");
            return (Criteria) this;
        }

        public Criteria andUserReverseIdcardEqualTo(String value) {
            addCriterion("user_reverse_idcard =", value, "userReverseIdcard");
            return (Criteria) this;
        }

        public Criteria andUserReverseIdcardNotEqualTo(String value) {
            addCriterion("user_reverse_idcard <>", value, "userReverseIdcard");
            return (Criteria) this;
        }

        public Criteria andUserReverseIdcardGreaterThan(String value) {
            addCriterion("user_reverse_idcard >", value, "userReverseIdcard");
            return (Criteria) this;
        }

        public Criteria andUserReverseIdcardGreaterThanOrEqualTo(String value) {
            addCriterion("user_reverse_idcard >=", value, "userReverseIdcard");
            return (Criteria) this;
        }

        public Criteria andUserReverseIdcardLessThan(String value) {
            addCriterion("user_reverse_idcard <", value, "userReverseIdcard");
            return (Criteria) this;
        }

        public Criteria andUserReverseIdcardLessThanOrEqualTo(String value) {
            addCriterion("user_reverse_idcard <=", value, "userReverseIdcard");
            return (Criteria) this;
        }

        public Criteria andUserReverseIdcardLike(String value) {
            addCriterion("user_reverse_idcard like", value, "userReverseIdcard");
            return (Criteria) this;
        }

        public Criteria andUserReverseIdcardNotLike(String value) {
            addCriterion("user_reverse_idcard not like", value, "userReverseIdcard");
            return (Criteria) this;
        }

        public Criteria andUserReverseIdcardIn(List<String> values) {
            addCriterion("user_reverse_idcard in", values, "userReverseIdcard");
            return (Criteria) this;
        }

        public Criteria andUserReverseIdcardNotIn(List<String> values) {
            addCriterion("user_reverse_idcard not in", values, "userReverseIdcard");
            return (Criteria) this;
        }

        public Criteria andUserReverseIdcardBetween(String value1, String value2) {
            addCriterion("user_reverse_idcard between", value1, value2, "userReverseIdcard");
            return (Criteria) this;
        }

        public Criteria andUserReverseIdcardNotBetween(String value1, String value2) {
            addCriterion("user_reverse_idcard not between", value1, value2, "userReverseIdcard");
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

        public Criteria andStateIsNull() {
            addCriterion("state is null");
            return (Criteria) this;
        }

        public Criteria andStateIsNotNull() {
            addCriterion("state is not null");
            return (Criteria) this;
        }

        public Criteria andStateEqualTo(Integer value) {
            addCriterion("state =", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateNotEqualTo(Integer value) {
            addCriterion("state <>", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateGreaterThan(Integer value) {
            addCriterion("state >", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateGreaterThanOrEqualTo(Integer value) {
            addCriterion("state >=", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateLessThan(Integer value) {
            addCriterion("state <", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateLessThanOrEqualTo(Integer value) {
            addCriterion("state <=", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateIn(List<Integer> values) {
            addCriterion("state in", values, "state");
            return (Criteria) this;
        }

        public Criteria andStateNotIn(List<Integer> values) {
            addCriterion("state not in", values, "state");
            return (Criteria) this;
        }

        public Criteria andStateBetween(Integer value1, Integer value2) {
            addCriterion("state between", value1, value2, "state");
            return (Criteria) this;
        }

        public Criteria andStateNotBetween(Integer value1, Integer value2) {
            addCriterion("state not between", value1, value2, "state");
            return (Criteria) this;
        }

        public Criteria andAgentidIsNull() {
            addCriterion("agentId is null");
            return (Criteria) this;
        }

        public Criteria andAgentidIsNotNull() {
            addCriterion("agentId is not null");
            return (Criteria) this;
        }

        public Criteria andAgentidEqualTo(Integer value) {
            addCriterion("agentId =", value, "agentid");
            return (Criteria) this;
        }

        public Criteria andAgentidNotEqualTo(Integer value) {
            addCriterion("agentId <>", value, "agentid");
            return (Criteria) this;
        }

        public Criteria andAgentidGreaterThan(Integer value) {
            addCriterion("agentId >", value, "agentid");
            return (Criteria) this;
        }

        public Criteria andAgentidGreaterThanOrEqualTo(Integer value) {
            addCriterion("agentId >=", value, "agentid");
            return (Criteria) this;
        }

        public Criteria andAgentidLessThan(Integer value) {
            addCriterion("agentId <", value, "agentid");
            return (Criteria) this;
        }

        public Criteria andAgentidLessThanOrEqualTo(Integer value) {
            addCriterion("agentId <=", value, "agentid");
            return (Criteria) this;
        }

        public Criteria andAgentidIn(List<Integer> values) {
            addCriterion("agentId in", values, "agentid");
            return (Criteria) this;
        }

        public Criteria andAgentidNotIn(List<Integer> values) {
            addCriterion("agentId not in", values, "agentid");
            return (Criteria) this;
        }

        public Criteria andAgentidBetween(Integer value1, Integer value2) {
            addCriterion("agentId between", value1, value2, "agentid");
            return (Criteria) this;
        }

        public Criteria andAgentidNotBetween(Integer value1, Integer value2) {
            addCriterion("agentId not between", value1, value2, "agentid");
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