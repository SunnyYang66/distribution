package org.mfoyou.agent.common.dao.mfoyou.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class MfoyouAgentStoreCouponExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    protected Integer limitStart;

    protected Integer limitEnd;

    public MfoyouAgentStoreCouponExample() {
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
        public Criteria andCouponCountGrterThanSold() {
            addCriterion("coupon_count > coupon_sold");
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

        public Criteria andCouponNameIsNull() {
            addCriterion("coupon_name is null");
            return (Criteria) this;
        }

        public Criteria andCouponNameIsNotNull() {
            addCriterion("coupon_name is not null");
            return (Criteria) this;
        }

        public Criteria andCouponNameEqualTo(String value) {
            addCriterion("coupon_name =", value, "couponName");
            return (Criteria) this;
        }

        public Criteria andCouponNameNotEqualTo(String value) {
            addCriterion("coupon_name <>", value, "couponName");
            return (Criteria) this;
        }

        public Criteria andCouponNameGreaterThan(String value) {
            addCriterion("coupon_name >", value, "couponName");
            return (Criteria) this;
        }

        public Criteria andCouponNameGreaterThanOrEqualTo(String value) {
            addCriterion("coupon_name >=", value, "couponName");
            return (Criteria) this;
        }

        public Criteria andCouponNameLessThan(String value) {
            addCriterion("coupon_name <", value, "couponName");
            return (Criteria) this;
        }

        public Criteria andCouponNameLessThanOrEqualTo(String value) {
            addCriterion("coupon_name <=", value, "couponName");
            return (Criteria) this;
        }

        public Criteria andCouponNameLike(String value) {
            addCriterion("coupon_name like", value, "couponName");
            return (Criteria) this;
        }

        public Criteria andCouponNameNotLike(String value) {
            addCriterion("coupon_name not like", value, "couponName");
            return (Criteria) this;
        }

        public Criteria andCouponNameIn(List<String> values) {
            addCriterion("coupon_name in", values, "couponName");
            return (Criteria) this;
        }

        public Criteria andCouponNameNotIn(List<String> values) {
            addCriterion("coupon_name not in", values, "couponName");
            return (Criteria) this;
        }

        public Criteria andCouponNameBetween(String value1, String value2) {
            addCriterion("coupon_name between", value1, value2, "couponName");
            return (Criteria) this;
        }

        public Criteria andCouponNameNotBetween(String value1, String value2) {
            addCriterion("coupon_name not between", value1, value2, "couponName");
            return (Criteria) this;
        }

        public Criteria andCouponCountIsNull() {
            addCriterion("coupon_count is null");
            return (Criteria) this;
        }

        public Criteria andCouponCountIsNotNull() {
            addCriterion("coupon_count is not null");
            return (Criteria) this;
        }

        public Criteria andCouponCountEqualTo(Integer value) {
            addCriterion("coupon_count =", value, "couponCount");
            return (Criteria) this;
        }

        public Criteria andCouponCountNotEqualTo(Integer value) {
            addCriterion("coupon_count <>", value, "couponCount");
            return (Criteria) this;
        }

        public Criteria andCouponCountGreaterThan(Integer value) {
            addCriterion("coupon_count >", value, "couponCount");
            return (Criteria) this;
        }

        public Criteria andCouponCountGreaterThanOrEqualTo(Integer value) {
            addCriterion("coupon_count >=", value, "couponCount");
            return (Criteria) this;
        }

        public Criteria andCouponCountLessThan(Integer value) {
            addCriterion("coupon_count <", value, "couponCount");
            return (Criteria) this;
        }

        public Criteria andCouponCountLessThanOrEqualTo(Integer value) {
            addCriterion("coupon_count <=", value, "couponCount");
            return (Criteria) this;
        }

        public Criteria andCouponCountIn(List<Integer> values) {
            addCriterion("coupon_count in", values, "couponCount");
            return (Criteria) this;
        }

        public Criteria andCouponCountNotIn(List<Integer> values) {
            addCriterion("coupon_count not in", values, "couponCount");
            return (Criteria) this;
        }

        public Criteria andCouponCountBetween(Integer value1, Integer value2) {
            addCriterion("coupon_count between", value1, value2, "couponCount");
            return (Criteria) this;
        }

        public Criteria andCouponCountNotBetween(Integer value1, Integer value2) {
            addCriterion("coupon_count not between", value1, value2, "couponCount");
            return (Criteria) this;
        }

        public Criteria andCouponSoldIsNull() {
            addCriterion("coupon_sold is null");
            return (Criteria) this;
        }

        public Criteria andCouponSoldIsNotNull() {
            addCriterion("coupon_sold is not null");
            return (Criteria) this;
        }

        public Criteria andCouponSoldEqualTo(Integer value) {
            addCriterion("coupon_sold =", value, "couponSold");
            return (Criteria) this;
        }

        public Criteria andCouponSoldNotEqualTo(Integer value) {
            addCriterion("coupon_sold <>", value, "couponSold");
            return (Criteria) this;
        }

        public Criteria andCouponSoldGreaterThan(Integer value) {
            addCriterion("coupon_sold >", value, "couponSold");
            return (Criteria) this;
        }

        public Criteria andCouponSoldGreaterThanOrEqualTo(Integer value) {
            addCriterion("coupon_sold >=", value, "couponSold");
            return (Criteria) this;
        }

        public Criteria andCouponSoldLessThan(Integer value) {
            addCriterion("coupon_sold <", value, "couponSold");
            return (Criteria) this;
        }

        public Criteria andCouponSoldLessThanOrEqualTo(Integer value) {
            addCriterion("coupon_sold <=", value, "couponSold");
            return (Criteria) this;
        }

        public Criteria andCouponSoldIn(List<Integer> values) {
            addCriterion("coupon_sold in", values, "couponSold");
            return (Criteria) this;
        }

        public Criteria andCouponSoldNotIn(List<Integer> values) {
            addCriterion("coupon_sold not in", values, "couponSold");
            return (Criteria) this;
        }

        public Criteria andCouponSoldBetween(Integer value1, Integer value2) {
            addCriterion("coupon_sold between", value1, value2, "couponSold");
            return (Criteria) this;
        }

        public Criteria andCouponSoldNotBetween(Integer value1, Integer value2) {
            addCriterion("coupon_sold not between", value1, value2, "couponSold");
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

        public Criteria andCouponCreateTimeIsNull() {
            addCriterion("coupon_create_time is null");
            return (Criteria) this;
        }

        public Criteria andCouponCreateTimeIsNotNull() {
            addCriterion("coupon_create_time is not null");
            return (Criteria) this;
        }

        public Criteria andCouponCreateTimeEqualTo(Date value) {
            addCriterion("coupon_create_time =", value, "couponCreateTime");
            return (Criteria) this;
        }

        public Criteria andCouponCreateTimeNotEqualTo(Date value) {
            addCriterion("coupon_create_time <>", value, "couponCreateTime");
            return (Criteria) this;
        }

        public Criteria andCouponCreateTimeGreaterThan(Date value) {
            addCriterion("coupon_create_time >", value, "couponCreateTime");
            return (Criteria) this;
        }

        public Criteria andCouponCreateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("coupon_create_time >=", value, "couponCreateTime");
            return (Criteria) this;
        }

        public Criteria andCouponCreateTimeLessThan(Date value) {
            addCriterion("coupon_create_time <", value, "couponCreateTime");
            return (Criteria) this;
        }

        public Criteria andCouponCreateTimeLessThanOrEqualTo(Date value) {
            addCriterion("coupon_create_time <=", value, "couponCreateTime");
            return (Criteria) this;
        }

        public Criteria andCouponCreateTimeIn(List<Date> values) {
            addCriterion("coupon_create_time in", values, "couponCreateTime");
            return (Criteria) this;
        }

        public Criteria andCouponCreateTimeNotIn(List<Date> values) {
            addCriterion("coupon_create_time not in", values, "couponCreateTime");
            return (Criteria) this;
        }

        public Criteria andCouponCreateTimeBetween(Date value1, Date value2) {
            addCriterion("coupon_create_time between", value1, value2, "couponCreateTime");
            return (Criteria) this;
        }

        public Criteria andCouponCreateTimeNotBetween(Date value1, Date value2) {
            addCriterion("coupon_create_time not between", value1, value2, "couponCreateTime");
            return (Criteria) this;
        }

        public Criteria andCouponModifyTimeIsNull() {
            addCriterion("coupon_modify_time is null");
            return (Criteria) this;
        }

        public Criteria andCouponModifyTimeIsNotNull() {
            addCriterion("coupon_modify_time is not null");
            return (Criteria) this;
        }

        public Criteria andCouponModifyTimeEqualTo(Date value) {
            addCriterion("coupon_modify_time =", value, "couponModifyTime");
            return (Criteria) this;
        }

        public Criteria andCouponModifyTimeNotEqualTo(Date value) {
            addCriterion("coupon_modify_time <>", value, "couponModifyTime");
            return (Criteria) this;
        }

        public Criteria andCouponModifyTimeGreaterThan(Date value) {
            addCriterion("coupon_modify_time >", value, "couponModifyTime");
            return (Criteria) this;
        }

        public Criteria andCouponModifyTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("coupon_modify_time >=", value, "couponModifyTime");
            return (Criteria) this;
        }

        public Criteria andCouponModifyTimeLessThan(Date value) {
            addCriterion("coupon_modify_time <", value, "couponModifyTime");
            return (Criteria) this;
        }

        public Criteria andCouponModifyTimeLessThanOrEqualTo(Date value) {
            addCriterion("coupon_modify_time <=", value, "couponModifyTime");
            return (Criteria) this;
        }

        public Criteria andCouponModifyTimeIn(List<Date> values) {
            addCriterion("coupon_modify_time in", values, "couponModifyTime");
            return (Criteria) this;
        }

        public Criteria andCouponModifyTimeNotIn(List<Date> values) {
            addCriterion("coupon_modify_time not in", values, "couponModifyTime");
            return (Criteria) this;
        }

        public Criteria andCouponModifyTimeBetween(Date value1, Date value2) {
            addCriterion("coupon_modify_time between", value1, value2, "couponModifyTime");
            return (Criteria) this;
        }

        public Criteria andCouponModifyTimeNotBetween(Date value1, Date value2) {
            addCriterion("coupon_modify_time not between", value1, value2, "couponModifyTime");
            return (Criteria) this;
        }

        public Criteria andCouponStartTimeIsNull() {
            addCriterion("coupon_start_time is null");
            return (Criteria) this;
        }

        public Criteria andCouponStartTimeIsNotNull() {
            addCriterion("coupon_start_time is not null");
            return (Criteria) this;
        }

        public Criteria andCouponStartTimeEqualTo(Date value) {
            addCriterion("coupon_start_time =", value, "couponStartTime");
            return (Criteria) this;
        }

        public Criteria andCouponStartTimeNotEqualTo(Date value) {
            addCriterion("coupon_start_time <>", value, "couponStartTime");
            return (Criteria) this;
        }

        public Criteria andCouponStartTimeGreaterThan(Date value) {
            addCriterion("coupon_start_time >", value, "couponStartTime");
            return (Criteria) this;
        }

        public Criteria andCouponStartTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("coupon_start_time >=", value, "couponStartTime");
            return (Criteria) this;
        }

        public Criteria andCouponStartTimeLessThan(Date value) {
            addCriterion("coupon_start_time <", value, "couponStartTime");
            return (Criteria) this;
        }

        public Criteria andCouponStartTimeLessThanOrEqualTo(Date value) {
            addCriterion("coupon_start_time <=", value, "couponStartTime");
            return (Criteria) this;
        }

        public Criteria andCouponStartTimeIn(List<Date> values) {
            addCriterion("coupon_start_time in", values, "couponStartTime");
            return (Criteria) this;
        }

        public Criteria andCouponStartTimeNotIn(List<Date> values) {
            addCriterion("coupon_start_time not in", values, "couponStartTime");
            return (Criteria) this;
        }

        public Criteria andCouponStartTimeBetween(Date value1, Date value2) {
            addCriterion("coupon_start_time between", value1, value2, "couponStartTime");
            return (Criteria) this;
        }

        public Criteria andCouponStartTimeNotBetween(Date value1, Date value2) {
            addCriterion("coupon_start_time not between", value1, value2, "couponStartTime");
            return (Criteria) this;
        }

        public Criteria andCouponLimitTimeIsNull() {
            addCriterion("coupon_limit_time is null");
            return (Criteria) this;
        }

        public Criteria andCouponLimitTimeIsNotNull() {
            addCriterion("coupon_limit_time is not null");
            return (Criteria) this;
        }

        public Criteria andCouponLimitTimeEqualTo(Date value) {
            addCriterion("coupon_limit_time =", value, "couponLimitTime");
            return (Criteria) this;
        }

        public Criteria andCouponLimitTimeNotEqualTo(Date value) {
            addCriterion("coupon_limit_time <>", value, "couponLimitTime");
            return (Criteria) this;
        }

        public Criteria andCouponLimitTimeGreaterThan(Date value) {
            addCriterion("coupon_limit_time >", value, "couponLimitTime");
            return (Criteria) this;
        }

        public Criteria andCouponLimitTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("coupon_limit_time >=", value, "couponLimitTime");
            return (Criteria) this;
        }

        public Criteria andCouponLimitTimeLessThan(Date value) {
            addCriterion("coupon_limit_time <", value, "couponLimitTime");
            return (Criteria) this;
        }

        public Criteria andCouponLimitTimeLessThanOrEqualTo(Date value) {
            addCriterion("coupon_limit_time <=", value, "couponLimitTime");
            return (Criteria) this;
        }

        public Criteria andCouponLimitTimeIn(List<Date> values) {
            addCriterion("coupon_limit_time in", values, "couponLimitTime");
            return (Criteria) this;
        }

        public Criteria andCouponLimitTimeNotIn(List<Date> values) {
            addCriterion("coupon_limit_time not in", values, "couponLimitTime");
            return (Criteria) this;
        }

        public Criteria andCouponLimitTimeBetween(Date value1, Date value2) {
            addCriterion("coupon_limit_time between", value1, value2, "couponLimitTime");
            return (Criteria) this;
        }

        public Criteria andCouponLimitTimeNotBetween(Date value1, Date value2) {
            addCriterion("coupon_limit_time not between", value1, value2, "couponLimitTime");
            return (Criteria) this;
        }

        public Criteria andUseTypeIsNull() {
            addCriterion("use_type is null");
            return (Criteria) this;
        }

        public Criteria andUseTypeIsNotNull() {
            addCriterion("use_type is not null");
            return (Criteria) this;
        }

        public Criteria andUseTypeEqualTo(Integer value) {
            addCriterion("use_type =", value, "useType");
            return (Criteria) this;
        }

        public Criteria andUseTypeNotEqualTo(Integer value) {
            addCriterion("use_type <>", value, "useType");
            return (Criteria) this;
        }

        public Criteria andUseTypeGreaterThan(Integer value) {
            addCriterion("use_type >", value, "useType");
            return (Criteria) this;
        }

        public Criteria andUseTypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("use_type >=", value, "useType");
            return (Criteria) this;
        }

        public Criteria andUseTypeLessThan(Integer value) {
            addCriterion("use_type <", value, "useType");
            return (Criteria) this;
        }

        public Criteria andUseTypeLessThanOrEqualTo(Integer value) {
            addCriterion("use_type <=", value, "useType");
            return (Criteria) this;
        }

        public Criteria andUseTypeIn(List<Integer> values) {
            addCriterion("use_type in", values, "useType");
            return (Criteria) this;
        }

        public Criteria andUseTypeNotIn(List<Integer> values) {
            addCriterion("use_type not in", values, "useType");
            return (Criteria) this;
        }

        public Criteria andUseTypeBetween(Integer value1, Integer value2) {
            addCriterion("use_type between", value1, value2, "useType");
            return (Criteria) this;
        }

        public Criteria andUseTypeNotBetween(Integer value1, Integer value2) {
            addCriterion("use_type not between", value1, value2, "useType");
            return (Criteria) this;
        }

        public Criteria andCouponStateIsNull() {
            addCriterion("coupon_state is null");
            return (Criteria) this;
        }

        public Criteria andCouponStateIsNotNull() {
            addCriterion("coupon_state is not null");
            return (Criteria) this;
        }

        public Criteria andCouponStateEqualTo(Integer value) {
            addCriterion("coupon_state =", value, "couponState");
            return (Criteria) this;
        }

        public Criteria andCouponStateNotEqualTo(Integer value) {
            addCriterion("coupon_state <>", value, "couponState");
            return (Criteria) this;
        }

        public Criteria andCouponStateGreaterThan(Integer value) {
            addCriterion("coupon_state >", value, "couponState");
            return (Criteria) this;
        }

        public Criteria andCouponStateGreaterThanOrEqualTo(Integer value) {
            addCriterion("coupon_state >=", value, "couponState");
            return (Criteria) this;
        }

        public Criteria andCouponStateLessThan(Integer value) {
            addCriterion("coupon_state <", value, "couponState");
            return (Criteria) this;
        }

        public Criteria andCouponStateLessThanOrEqualTo(Integer value) {
            addCriterion("coupon_state <=", value, "couponState");
            return (Criteria) this;
        }

        public Criteria andCouponStateIn(List<Integer> values) {
            addCriterion("coupon_state in", values, "couponState");
            return (Criteria) this;
        }

        public Criteria andCouponStateNotIn(List<Integer> values) {
            addCriterion("coupon_state not in", values, "couponState");
            return (Criteria) this;
        }

        public Criteria andCouponStateBetween(Integer value1, Integer value2) {
            addCriterion("coupon_state between", value1, value2, "couponState");
            return (Criteria) this;
        }

        public Criteria andCouponStateNotBetween(Integer value1, Integer value2) {
            addCriterion("coupon_state not between", value1, value2, "couponState");
            return (Criteria) this;
        }

        public Criteria andStoreListIsNull() {
            addCriterion("store_list is null");
            return (Criteria) this;
        }

        public Criteria andStoreListIsNotNull() {
            addCriterion("store_list is not null");
            return (Criteria) this;
        }

        public Criteria andStoreListEqualTo(String value) {
            addCriterion("store_list =", value, "storeList");
            return (Criteria) this;
        }

        public Criteria andStoreListNotEqualTo(String value) {
            addCriterion("store_list <>", value, "storeList");
            return (Criteria) this;
        }

        public Criteria andStoreListGreaterThan(String value) {
            addCriterion("store_list >", value, "storeList");
            return (Criteria) this;
        }

        public Criteria andStoreListGreaterThanOrEqualTo(String value) {
            addCriterion("store_list >=", value, "storeList");
            return (Criteria) this;
        }

        public Criteria andStoreListLessThan(String value) {
            addCriterion("store_list <", value, "storeList");
            return (Criteria) this;
        }

        public Criteria andStoreListLessThanOrEqualTo(String value) {
            addCriterion("store_list <=", value, "storeList");
            return (Criteria) this;
        }

        public Criteria andStoreListLike(String value) {
            addCriterion("store_list like", value, "storeList");
            return (Criteria) this;
        }

        public Criteria andStoreListNotLike(String value) {
            addCriterion("store_list not like", value, "storeList");
            return (Criteria) this;
        }

        public Criteria andStoreListIn(List<String> values) {
            addCriterion("store_list in", values, "storeList");
            return (Criteria) this;
        }

        public Criteria andStoreListNotIn(List<String> values) {
            addCriterion("store_list not in", values, "storeList");
            return (Criteria) this;
        }

        public Criteria andStoreListBetween(String value1, String value2) {
            addCriterion("store_list between", value1, value2, "storeList");
            return (Criteria) this;
        }

        public Criteria andStoreListNotBetween(String value1, String value2) {
            addCriterion("store_list not between", value1, value2, "storeList");
            return (Criteria) this;
        }

        public Criteria andReducetypeIsNull() {
            addCriterion("reduceType is null");
            return (Criteria) this;
        }

        public Criteria andReducetypeIsNotNull() {
            addCriterion("reduceType is not null");
            return (Criteria) this;
        }

        public Criteria andReducetypeEqualTo(Integer value) {
            addCriterion("reduceType =", value, "reducetype");
            return (Criteria) this;
        }

        public Criteria andReducetypeNotEqualTo(Integer value) {
            addCriterion("reduceType <>", value, "reducetype");
            return (Criteria) this;
        }

        public Criteria andReducetypeGreaterThan(Integer value) {
            addCriterion("reduceType >", value, "reducetype");
            return (Criteria) this;
        }

        public Criteria andReducetypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("reduceType >=", value, "reducetype");
            return (Criteria) this;
        }

        public Criteria andReducetypeLessThan(Integer value) {
            addCriterion("reduceType <", value, "reducetype");
            return (Criteria) this;
        }

        public Criteria andReducetypeLessThanOrEqualTo(Integer value) {
            addCriterion("reduceType <=", value, "reducetype");
            return (Criteria) this;
        }

        public Criteria andReducetypeIn(List<Integer> values) {
            addCriterion("reduceType in", values, "reducetype");
            return (Criteria) this;
        }

        public Criteria andReducetypeNotIn(List<Integer> values) {
            addCriterion("reduceType not in", values, "reducetype");
            return (Criteria) this;
        }

        public Criteria andReducetypeBetween(Integer value1, Integer value2) {
            addCriterion("reduceType between", value1, value2, "reducetype");
            return (Criteria) this;
        }

        public Criteria andReducetypeNotBetween(Integer value1, Integer value2) {
            addCriterion("reduceType not between", value1, value2, "reducetype");
            return (Criteria) this;
        }

        public Criteria andReducevalueIsNull() {
            addCriterion("reduceValue is null");
            return (Criteria) this;
        }

        public Criteria andReducevalueIsNotNull() {
            addCriterion("reduceValue is not null");
            return (Criteria) this;
        }

        public Criteria andReducevalueEqualTo(Integer value) {
            addCriterion("reduceValue =", value, "reducevalue");
            return (Criteria) this;
        }

        public Criteria andReducevalueNotEqualTo(Integer value) {
            addCriterion("reduceValue <>", value, "reducevalue");
            return (Criteria) this;
        }

        public Criteria andReducevalueGreaterThan(Integer value) {
            addCriterion("reduceValue >", value, "reducevalue");
            return (Criteria) this;
        }

        public Criteria andReducevalueGreaterThanOrEqualTo(Integer value) {
            addCriterion("reduceValue >=", value, "reducevalue");
            return (Criteria) this;
        }

        public Criteria andReducevalueLessThan(Integer value) {
            addCriterion("reduceValue <", value, "reducevalue");
            return (Criteria) this;
        }

        public Criteria andReducevalueLessThanOrEqualTo(Integer value) {
            addCriterion("reduceValue <=", value, "reducevalue");
            return (Criteria) this;
        }

        public Criteria andReducevalueIn(List<Integer> values) {
            addCriterion("reduceValue in", values, "reducevalue");
            return (Criteria) this;
        }

        public Criteria andReducevalueNotIn(List<Integer> values) {
            addCriterion("reduceValue not in", values, "reducevalue");
            return (Criteria) this;
        }

        public Criteria andReducevalueBetween(Integer value1, Integer value2) {
            addCriterion("reduceValue between", value1, value2, "reducevalue");
            return (Criteria) this;
        }

        public Criteria andReducevalueNotBetween(Integer value1, Integer value2) {
            addCriterion("reduceValue not between", value1, value2, "reducevalue");
            return (Criteria) this;
        }

        public Criteria andLimitmoneyIsNull() {
            addCriterion("limitMoney is null");
            return (Criteria) this;
        }

        public Criteria andLimitmoneyIsNotNull() {
            addCriterion("limitMoney is not null");
            return (Criteria) this;
        }

        public Criteria andLimitmoneyEqualTo(Integer value) {
            addCriterion("limitMoney =", value, "limitmoney");
            return (Criteria) this;
        }

        public Criteria andLimitmoneyNotEqualTo(Integer value) {
            addCriterion("limitMoney <>", value, "limitmoney");
            return (Criteria) this;
        }

        public Criteria andLimitmoneyGreaterThan(Integer value) {
            addCriterion("limitMoney >", value, "limitmoney");
            return (Criteria) this;
        }

        public Criteria andLimitmoneyGreaterThanOrEqualTo(Integer value) {
            addCriterion("limitMoney >=", value, "limitmoney");
            return (Criteria) this;
        }

        public Criteria andLimitmoneyLessThan(Integer value) {
            addCriterion("limitMoney <", value, "limitmoney");
            return (Criteria) this;
        }

        public Criteria andLimitmoneyLessThanOrEqualTo(Integer value) {
            addCriterion("limitMoney <=", value, "limitmoney");
            return (Criteria) this;
        }

        public Criteria andLimitmoneyIn(List<Integer> values) {
            addCriterion("limitMoney in", values, "limitmoney");
            return (Criteria) this;
        }

        public Criteria andLimitmoneyNotIn(List<Integer> values) {
            addCriterion("limitMoney not in", values, "limitmoney");
            return (Criteria) this;
        }

        public Criteria andLimitmoneyBetween(Integer value1, Integer value2) {
            addCriterion("limitMoney between", value1, value2, "limitmoney");
            return (Criteria) this;
        }

        public Criteria andLimitmoneyNotBetween(Integer value1, Integer value2) {
            addCriterion("limitMoney not between", value1, value2, "limitmoney");
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