package org.mfoyou.agent.common.dao.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class HuawuUserExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    protected Integer limitStart;

    protected Integer limitEnd;

    public HuawuUserExample() {
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

        public Criteria andUserPhoneIsNull() {
            addCriterion("user_phone is null");
            return (Criteria) this;
        }

        public Criteria andUserPhoneIsNotNull() {
            addCriterion("user_phone is not null");
            return (Criteria) this;
        }

        public Criteria andUserPhoneEqualTo(String value) {
            addCriterion("user_phone =", value, "userPhone");
            return (Criteria) this;
        }

        public Criteria andUserPhoneNotEqualTo(String value) {
            addCriterion("user_phone <>", value, "userPhone");
            return (Criteria) this;
        }

        public Criteria andUserPhoneGreaterThan(String value) {
            addCriterion("user_phone >", value, "userPhone");
            return (Criteria) this;
        }

        public Criteria andUserPhoneGreaterThanOrEqualTo(String value) {
            addCriterion("user_phone >=", value, "userPhone");
            return (Criteria) this;
        }

        public Criteria andUserPhoneLessThan(String value) {
            addCriterion("user_phone <", value, "userPhone");
            return (Criteria) this;
        }

        public Criteria andUserPhoneLessThanOrEqualTo(String value) {
            addCriterion("user_phone <=", value, "userPhone");
            return (Criteria) this;
        }

        public Criteria andUserPhoneLike(String value) {
            addCriterion("user_phone like", value, "userPhone");
            return (Criteria) this;
        }

        public Criteria andUserPhoneNotLike(String value) {
            addCriterion("user_phone not like", value, "userPhone");
            return (Criteria) this;
        }

        public Criteria andUserPhoneIn(List<String> values) {
            addCriterion("user_phone in", values, "userPhone");
            return (Criteria) this;
        }

        public Criteria andUserPhoneNotIn(List<String> values) {
            addCriterion("user_phone not in", values, "userPhone");
            return (Criteria) this;
        }

        public Criteria andUserPhoneBetween(String value1, String value2) {
            addCriterion("user_phone between", value1, value2, "userPhone");
            return (Criteria) this;
        }

        public Criteria andUserPhoneNotBetween(String value1, String value2) {
            addCriterion("user_phone not between", value1, value2, "userPhone");
            return (Criteria) this;
        }

        public Criteria andUserPasswordIsNull() {
            addCriterion("user_password is null");
            return (Criteria) this;
        }

        public Criteria andUserPasswordIsNotNull() {
            addCriterion("user_password is not null");
            return (Criteria) this;
        }

        public Criteria andUserPasswordEqualTo(String value) {
            addCriterion("user_password =", value, "userPassword");
            return (Criteria) this;
        }

        public Criteria andUserPasswordNotEqualTo(String value) {
            addCriterion("user_password <>", value, "userPassword");
            return (Criteria) this;
        }

        public Criteria andUserPasswordGreaterThan(String value) {
            addCriterion("user_password >", value, "userPassword");
            return (Criteria) this;
        }

        public Criteria andUserPasswordGreaterThanOrEqualTo(String value) {
            addCriterion("user_password >=", value, "userPassword");
            return (Criteria) this;
        }

        public Criteria andUserPasswordLessThan(String value) {
            addCriterion("user_password <", value, "userPassword");
            return (Criteria) this;
        }

        public Criteria andUserPasswordLessThanOrEqualTo(String value) {
            addCriterion("user_password <=", value, "userPassword");
            return (Criteria) this;
        }

        public Criteria andUserPasswordLike(String value) {
            addCriterion("user_password like", value, "userPassword");
            return (Criteria) this;
        }

        public Criteria andUserPasswordNotLike(String value) {
            addCriterion("user_password not like", value, "userPassword");
            return (Criteria) this;
        }

        public Criteria andUserPasswordIn(List<String> values) {
            addCriterion("user_password in", values, "userPassword");
            return (Criteria) this;
        }

        public Criteria andUserPasswordNotIn(List<String> values) {
            addCriterion("user_password not in", values, "userPassword");
            return (Criteria) this;
        }

        public Criteria andUserPasswordBetween(String value1, String value2) {
            addCriterion("user_password between", value1, value2, "userPassword");
            return (Criteria) this;
        }

        public Criteria andUserPasswordNotBetween(String value1, String value2) {
            addCriterion("user_password not between", value1, value2, "userPassword");
            return (Criteria) this;
        }

        public Criteria andUserNickNameIsNull() {
            addCriterion("user_nick_name is null");
            return (Criteria) this;
        }

        public Criteria andUserNickNameIsNotNull() {
            addCriterion("user_nick_name is not null");
            return (Criteria) this;
        }

        public Criteria andUserNickNameEqualTo(String value) {
            addCriterion("user_nick_name =", value, "userNickName");
            return (Criteria) this;
        }

        public Criteria andUserNickNameNotEqualTo(String value) {
            addCriterion("user_nick_name <>", value, "userNickName");
            return (Criteria) this;
        }

        public Criteria andUserNickNameGreaterThan(String value) {
            addCriterion("user_nick_name >", value, "userNickName");
            return (Criteria) this;
        }

        public Criteria andUserNickNameGreaterThanOrEqualTo(String value) {
            addCriterion("user_nick_name >=", value, "userNickName");
            return (Criteria) this;
        }

        public Criteria andUserNickNameLessThan(String value) {
            addCriterion("user_nick_name <", value, "userNickName");
            return (Criteria) this;
        }

        public Criteria andUserNickNameLessThanOrEqualTo(String value) {
            addCriterion("user_nick_name <=", value, "userNickName");
            return (Criteria) this;
        }

        public Criteria andUserNickNameLike(String value) {
            addCriterion("user_nick_name like", value, "userNickName");
            return (Criteria) this;
        }

        public Criteria andUserNickNameNotLike(String value) {
            addCriterion("user_nick_name not like", value, "userNickName");
            return (Criteria) this;
        }

        public Criteria andUserNickNameIn(List<String> values) {
            addCriterion("user_nick_name in", values, "userNickName");
            return (Criteria) this;
        }

        public Criteria andUserNickNameNotIn(List<String> values) {
            addCriterion("user_nick_name not in", values, "userNickName");
            return (Criteria) this;
        }

        public Criteria andUserNickNameBetween(String value1, String value2) {
            addCriterion("user_nick_name between", value1, value2, "userNickName");
            return (Criteria) this;
        }

        public Criteria andUserNickNameNotBetween(String value1, String value2) {
            addCriterion("user_nick_name not between", value1, value2, "userNickName");
            return (Criteria) this;
        }

        public Criteria andUserHeadUrlIsNull() {
            addCriterion("user_head_url is null");
            return (Criteria) this;
        }

        public Criteria andUserHeadUrlIsNotNull() {
            addCriterion("user_head_url is not null");
            return (Criteria) this;
        }

        public Criteria andUserHeadUrlEqualTo(String value) {
            addCriterion("user_head_url =", value, "userHeadUrl");
            return (Criteria) this;
        }

        public Criteria andUserHeadUrlNotEqualTo(String value) {
            addCriterion("user_head_url <>", value, "userHeadUrl");
            return (Criteria) this;
        }

        public Criteria andUserHeadUrlGreaterThan(String value) {
            addCriterion("user_head_url >", value, "userHeadUrl");
            return (Criteria) this;
        }

        public Criteria andUserHeadUrlGreaterThanOrEqualTo(String value) {
            addCriterion("user_head_url >=", value, "userHeadUrl");
            return (Criteria) this;
        }

        public Criteria andUserHeadUrlLessThan(String value) {
            addCriterion("user_head_url <", value, "userHeadUrl");
            return (Criteria) this;
        }

        public Criteria andUserHeadUrlLessThanOrEqualTo(String value) {
            addCriterion("user_head_url <=", value, "userHeadUrl");
            return (Criteria) this;
        }

        public Criteria andUserHeadUrlLike(String value) {
            addCriterion("user_head_url like", value, "userHeadUrl");
            return (Criteria) this;
        }

        public Criteria andUserHeadUrlNotLike(String value) {
            addCriterion("user_head_url not like", value, "userHeadUrl");
            return (Criteria) this;
        }

        public Criteria andUserHeadUrlIn(List<String> values) {
            addCriterion("user_head_url in", values, "userHeadUrl");
            return (Criteria) this;
        }

        public Criteria andUserHeadUrlNotIn(List<String> values) {
            addCriterion("user_head_url not in", values, "userHeadUrl");
            return (Criteria) this;
        }

        public Criteria andUserHeadUrlBetween(String value1, String value2) {
            addCriterion("user_head_url between", value1, value2, "userHeadUrl");
            return (Criteria) this;
        }

        public Criteria andUserHeadUrlNotBetween(String value1, String value2) {
            addCriterion("user_head_url not between", value1, value2, "userHeadUrl");
            return (Criteria) this;
        }

        public Criteria andUserBirthdayIsNull() {
            addCriterion("user_birthday is null");
            return (Criteria) this;
        }

        public Criteria andUserBirthdayIsNotNull() {
            addCriterion("user_birthday is not null");
            return (Criteria) this;
        }

        public Criteria andUserBirthdayEqualTo(String value) {
            addCriterion("user_birthday =", value, "userBirthday");
            return (Criteria) this;
        }

        public Criteria andUserBirthdayNotEqualTo(String value) {
            addCriterion("user_birthday <>", value, "userBirthday");
            return (Criteria) this;
        }

        public Criteria andUserBirthdayGreaterThan(String value) {
            addCriterion("user_birthday >", value, "userBirthday");
            return (Criteria) this;
        }

        public Criteria andUserBirthdayGreaterThanOrEqualTo(String value) {
            addCriterion("user_birthday >=", value, "userBirthday");
            return (Criteria) this;
        }

        public Criteria andUserBirthdayLessThan(String value) {
            addCriterion("user_birthday <", value, "userBirthday");
            return (Criteria) this;
        }

        public Criteria andUserBirthdayLessThanOrEqualTo(String value) {
            addCriterion("user_birthday <=", value, "userBirthday");
            return (Criteria) this;
        }

        public Criteria andUserBirthdayLike(String value) {
            addCriterion("user_birthday like", value, "userBirthday");
            return (Criteria) this;
        }

        public Criteria andUserBirthdayNotLike(String value) {
            addCriterion("user_birthday not like", value, "userBirthday");
            return (Criteria) this;
        }

        public Criteria andUserBirthdayIn(List<String> values) {
            addCriterion("user_birthday in", values, "userBirthday");
            return (Criteria) this;
        }

        public Criteria andUserBirthdayNotIn(List<String> values) {
            addCriterion("user_birthday not in", values, "userBirthday");
            return (Criteria) this;
        }

        public Criteria andUserBirthdayBetween(String value1, String value2) {
            addCriterion("user_birthday between", value1, value2, "userBirthday");
            return (Criteria) this;
        }

        public Criteria andUserBirthdayNotBetween(String value1, String value2) {
            addCriterion("user_birthday not between", value1, value2, "userBirthday");
            return (Criteria) this;
        }

        public Criteria andUserSexIsNull() {
            addCriterion("user_sex is null");
            return (Criteria) this;
        }

        public Criteria andUserSexIsNotNull() {
            addCriterion("user_sex is not null");
            return (Criteria) this;
        }

        public Criteria andUserSexEqualTo(Integer value) {
            addCriterion("user_sex =", value, "userSex");
            return (Criteria) this;
        }

        public Criteria andUserSexNotEqualTo(Integer value) {
            addCriterion("user_sex <>", value, "userSex");
            return (Criteria) this;
        }

        public Criteria andUserSexGreaterThan(Integer value) {
            addCriterion("user_sex >", value, "userSex");
            return (Criteria) this;
        }

        public Criteria andUserSexGreaterThanOrEqualTo(Integer value) {
            addCriterion("user_sex >=", value, "userSex");
            return (Criteria) this;
        }

        public Criteria andUserSexLessThan(Integer value) {
            addCriterion("user_sex <", value, "userSex");
            return (Criteria) this;
        }

        public Criteria andUserSexLessThanOrEqualTo(Integer value) {
            addCriterion("user_sex <=", value, "userSex");
            return (Criteria) this;
        }

        public Criteria andUserSexIn(List<Integer> values) {
            addCriterion("user_sex in", values, "userSex");
            return (Criteria) this;
        }

        public Criteria andUserSexNotIn(List<Integer> values) {
            addCriterion("user_sex not in", values, "userSex");
            return (Criteria) this;
        }

        public Criteria andUserSexBetween(Integer value1, Integer value2) {
            addCriterion("user_sex between", value1, value2, "userSex");
            return (Criteria) this;
        }

        public Criteria andUserSexNotBetween(Integer value1, Integer value2) {
            addCriterion("user_sex not between", value1, value2, "userSex");
            return (Criteria) this;
        }

        public Criteria andUserRegistTimeIsNull() {
            addCriterion("user_regist_time is null");
            return (Criteria) this;
        }

        public Criteria andUserRegistTimeIsNotNull() {
            addCriterion("user_regist_time is not null");
            return (Criteria) this;
        }

        public Criteria andUserRegistTimeEqualTo(Date value) {
            addCriterion("user_regist_time =", value, "userRegistTime");
            return (Criteria) this;
        }

        public Criteria andUserRegistTimeNotEqualTo(Date value) {
            addCriterion("user_regist_time <>", value, "userRegistTime");
            return (Criteria) this;
        }

        public Criteria andUserRegistTimeGreaterThan(Date value) {
            addCriterion("user_regist_time >", value, "userRegistTime");
            return (Criteria) this;
        }

        public Criteria andUserRegistTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("user_regist_time >=", value, "userRegistTime");
            return (Criteria) this;
        }

        public Criteria andUserRegistTimeLessThan(Date value) {
            addCriterion("user_regist_time <", value, "userRegistTime");
            return (Criteria) this;
        }

        public Criteria andUserRegistTimeLessThanOrEqualTo(Date value) {
            addCriterion("user_regist_time <=", value, "userRegistTime");
            return (Criteria) this;
        }

        public Criteria andUserRegistTimeIn(List<Date> values) {
            addCriterion("user_regist_time in", values, "userRegistTime");
            return (Criteria) this;
        }

        public Criteria andUserRegistTimeNotIn(List<Date> values) {
            addCriterion("user_regist_time not in", values, "userRegistTime");
            return (Criteria) this;
        }

        public Criteria andUserRegistTimeBetween(Date value1, Date value2) {
            addCriterion("user_regist_time between", value1, value2, "userRegistTime");
            return (Criteria) this;
        }

        public Criteria andUserRegistTimeNotBetween(Date value1, Date value2) {
            addCriterion("user_regist_time not between", value1, value2, "userRegistTime");
            return (Criteria) this;
        }

        public Criteria andUserModifyTimeIsNull() {
            addCriterion("user_modify_time is null");
            return (Criteria) this;
        }

        public Criteria andUserModifyTimeIsNotNull() {
            addCriterion("user_modify_time is not null");
            return (Criteria) this;
        }

        public Criteria andUserModifyTimeEqualTo(Date value) {
            addCriterion("user_modify_time =", value, "userModifyTime");
            return (Criteria) this;
        }

        public Criteria andUserModifyTimeNotEqualTo(Date value) {
            addCriterion("user_modify_time <>", value, "userModifyTime");
            return (Criteria) this;
        }

        public Criteria andUserModifyTimeGreaterThan(Date value) {
            addCriterion("user_modify_time >", value, "userModifyTime");
            return (Criteria) this;
        }

        public Criteria andUserModifyTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("user_modify_time >=", value, "userModifyTime");
            return (Criteria) this;
        }

        public Criteria andUserModifyTimeLessThan(Date value) {
            addCriterion("user_modify_time <", value, "userModifyTime");
            return (Criteria) this;
        }

        public Criteria andUserModifyTimeLessThanOrEqualTo(Date value) {
            addCriterion("user_modify_time <=", value, "userModifyTime");
            return (Criteria) this;
        }

        public Criteria andUserModifyTimeIn(List<Date> values) {
            addCriterion("user_modify_time in", values, "userModifyTime");
            return (Criteria) this;
        }

        public Criteria andUserModifyTimeNotIn(List<Date> values) {
            addCriterion("user_modify_time not in", values, "userModifyTime");
            return (Criteria) this;
        }

        public Criteria andUserModifyTimeBetween(Date value1, Date value2) {
            addCriterion("user_modify_time between", value1, value2, "userModifyTime");
            return (Criteria) this;
        }

        public Criteria andUserModifyTimeNotBetween(Date value1, Date value2) {
            addCriterion("user_modify_time not between", value1, value2, "userModifyTime");
            return (Criteria) this;
        }

        public Criteria andUserDisableIsNull() {
            addCriterion("user_disable is null");
            return (Criteria) this;
        }

        public Criteria andUserDisableIsNotNull() {
            addCriterion("user_disable is not null");
            return (Criteria) this;
        }

        public Criteria andUserDisableEqualTo(Integer value) {
            addCriterion("user_disable =", value, "userDisable");
            return (Criteria) this;
        }

        public Criteria andUserDisableNotEqualTo(Integer value) {
            addCriterion("user_disable <>", value, "userDisable");
            return (Criteria) this;
        }

        public Criteria andUserDisableGreaterThan(Integer value) {
            addCriterion("user_disable >", value, "userDisable");
            return (Criteria) this;
        }

        public Criteria andUserDisableGreaterThanOrEqualTo(Integer value) {
            addCriterion("user_disable >=", value, "userDisable");
            return (Criteria) this;
        }

        public Criteria andUserDisableLessThan(Integer value) {
            addCriterion("user_disable <", value, "userDisable");
            return (Criteria) this;
        }

        public Criteria andUserDisableLessThanOrEqualTo(Integer value) {
            addCriterion("user_disable <=", value, "userDisable");
            return (Criteria) this;
        }

        public Criteria andUserDisableIn(List<Integer> values) {
            addCriterion("user_disable in", values, "userDisable");
            return (Criteria) this;
        }

        public Criteria andUserDisableNotIn(List<Integer> values) {
            addCriterion("user_disable not in", values, "userDisable");
            return (Criteria) this;
        }

        public Criteria andUserDisableBetween(Integer value1, Integer value2) {
            addCriterion("user_disable between", value1, value2, "userDisable");
            return (Criteria) this;
        }

        public Criteria andUserDisableNotBetween(Integer value1, Integer value2) {
            addCriterion("user_disable not between", value1, value2, "userDisable");
            return (Criteria) this;
        }

        public Criteria andUserLastLoginIsNull() {
            addCriterion("user_last_login is null");
            return (Criteria) this;
        }

        public Criteria andUserLastLoginIsNotNull() {
            addCriterion("user_last_login is not null");
            return (Criteria) this;
        }

        public Criteria andUserLastLoginEqualTo(Date value) {
            addCriterion("user_last_login =", value, "userLastLogin");
            return (Criteria) this;
        }

        public Criteria andUserLastLoginNotEqualTo(Date value) {
            addCriterion("user_last_login <>", value, "userLastLogin");
            return (Criteria) this;
        }

        public Criteria andUserLastLoginGreaterThan(Date value) {
            addCriterion("user_last_login >", value, "userLastLogin");
            return (Criteria) this;
        }

        public Criteria andUserLastLoginGreaterThanOrEqualTo(Date value) {
            addCriterion("user_last_login >=", value, "userLastLogin");
            return (Criteria) this;
        }

        public Criteria andUserLastLoginLessThan(Date value) {
            addCriterion("user_last_login <", value, "userLastLogin");
            return (Criteria) this;
        }

        public Criteria andUserLastLoginLessThanOrEqualTo(Date value) {
            addCriterion("user_last_login <=", value, "userLastLogin");
            return (Criteria) this;
        }

        public Criteria andUserLastLoginIn(List<Date> values) {
            addCriterion("user_last_login in", values, "userLastLogin");
            return (Criteria) this;
        }

        public Criteria andUserLastLoginNotIn(List<Date> values) {
            addCriterion("user_last_login not in", values, "userLastLogin");
            return (Criteria) this;
        }

        public Criteria andUserLastLoginBetween(Date value1, Date value2) {
            addCriterion("user_last_login between", value1, value2, "userLastLogin");
            return (Criteria) this;
        }

        public Criteria andUserLastLoginNotBetween(Date value1, Date value2) {
            addCriterion("user_last_login not between", value1, value2, "userLastLogin");
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