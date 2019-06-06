package org.mfoyou.agent.common.dao.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class HuawuStreamExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    protected Integer limitStart;

    protected Integer limitEnd;

    public HuawuStreamExample() {
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

        public Criteria andStreamIdIsNull() {
            addCriterion("stream_id is null");
            return (Criteria) this;
        }

        public Criteria andStreamIdIsNotNull() {
            addCriterion("stream_id is not null");
            return (Criteria) this;
        }

        public Criteria andStreamIdEqualTo(Integer value) {
            addCriterion("stream_id =", value, "streamId");
            return (Criteria) this;
        }

        public Criteria andStreamIdNotEqualTo(Integer value) {
            addCriterion("stream_id <>", value, "streamId");
            return (Criteria) this;
        }

        public Criteria andStreamIdGreaterThan(Integer value) {
            addCriterion("stream_id >", value, "streamId");
            return (Criteria) this;
        }

        public Criteria andStreamIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("stream_id >=", value, "streamId");
            return (Criteria) this;
        }

        public Criteria andStreamIdLessThan(Integer value) {
            addCriterion("stream_id <", value, "streamId");
            return (Criteria) this;
        }

        public Criteria andStreamIdLessThanOrEqualTo(Integer value) {
            addCriterion("stream_id <=", value, "streamId");
            return (Criteria) this;
        }

        public Criteria andStreamIdIn(List<Integer> values) {
            addCriterion("stream_id in", values, "streamId");
            return (Criteria) this;
        }

        public Criteria andStreamIdNotIn(List<Integer> values) {
            addCriterion("stream_id not in", values, "streamId");
            return (Criteria) this;
        }

        public Criteria andStreamIdBetween(Integer value1, Integer value2) {
            addCriterion("stream_id between", value1, value2, "streamId");
            return (Criteria) this;
        }

        public Criteria andStreamIdNotBetween(Integer value1, Integer value2) {
            addCriterion("stream_id not between", value1, value2, "streamId");
            return (Criteria) this;
        }

        public Criteria andStreamTimeIsNull() {
            addCriterion("stream_time is null");
            return (Criteria) this;
        }

        public Criteria andStreamTimeIsNotNull() {
            addCriterion("stream_time is not null");
            return (Criteria) this;
        }

        public Criteria andStreamTimeEqualTo(Date value) {
            addCriterion("stream_time =", value, "streamTime");
            return (Criteria) this;
        }

        public Criteria andStreamTimeNotEqualTo(Date value) {
            addCriterion("stream_time <>", value, "streamTime");
            return (Criteria) this;
        }

        public Criteria andStreamTimeGreaterThan(Date value) {
            addCriterion("stream_time >", value, "streamTime");
            return (Criteria) this;
        }

        public Criteria andStreamTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("stream_time >=", value, "streamTime");
            return (Criteria) this;
        }

        public Criteria andStreamTimeLessThan(Date value) {
            addCriterion("stream_time <", value, "streamTime");
            return (Criteria) this;
        }

        public Criteria andStreamTimeLessThanOrEqualTo(Date value) {
            addCriterion("stream_time <=", value, "streamTime");
            return (Criteria) this;
        }

        public Criteria andStreamTimeIn(List<Date> values) {
            addCriterion("stream_time in", values, "streamTime");
            return (Criteria) this;
        }

        public Criteria andStreamTimeNotIn(List<Date> values) {
            addCriterion("stream_time not in", values, "streamTime");
            return (Criteria) this;
        }

        public Criteria andStreamTimeBetween(Date value1, Date value2) {
            addCriterion("stream_time between", value1, value2, "streamTime");
            return (Criteria) this;
        }

        public Criteria andStreamTimeNotBetween(Date value1, Date value2) {
            addCriterion("stream_time not between", value1, value2, "streamTime");
            return (Criteria) this;
        }

        public Criteria andStreamOrderIdIsNull() {
            addCriterion("stream_order_id is null");
            return (Criteria) this;
        }

        public Criteria andStreamOrderIdIsNotNull() {
            addCriterion("stream_order_id is not null");
            return (Criteria) this;
        }

        public Criteria andStreamOrderIdEqualTo(Integer value) {
            addCriterion("stream_order_id =", value, "streamOrderId");
            return (Criteria) this;
        }

        public Criteria andStreamOrderIdNotEqualTo(Integer value) {
            addCriterion("stream_order_id <>", value, "streamOrderId");
            return (Criteria) this;
        }

        public Criteria andStreamOrderIdGreaterThan(Integer value) {
            addCriterion("stream_order_id >", value, "streamOrderId");
            return (Criteria) this;
        }

        public Criteria andStreamOrderIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("stream_order_id >=", value, "streamOrderId");
            return (Criteria) this;
        }

        public Criteria andStreamOrderIdLessThan(Integer value) {
            addCriterion("stream_order_id <", value, "streamOrderId");
            return (Criteria) this;
        }

        public Criteria andStreamOrderIdLessThanOrEqualTo(Integer value) {
            addCriterion("stream_order_id <=", value, "streamOrderId");
            return (Criteria) this;
        }

        public Criteria andStreamOrderIdIn(List<Integer> values) {
            addCriterion("stream_order_id in", values, "streamOrderId");
            return (Criteria) this;
        }

        public Criteria andStreamOrderIdNotIn(List<Integer> values) {
            addCriterion("stream_order_id not in", values, "streamOrderId");
            return (Criteria) this;
        }

        public Criteria andStreamOrderIdBetween(Integer value1, Integer value2) {
            addCriterion("stream_order_id between", value1, value2, "streamOrderId");
            return (Criteria) this;
        }

        public Criteria andStreamOrderIdNotBetween(Integer value1, Integer value2) {
            addCriterion("stream_order_id not between", value1, value2, "streamOrderId");
            return (Criteria) this;
        }

        public Criteria andStreamOrderTypeIsNull() {
            addCriterion("stream_order_type is null");
            return (Criteria) this;
        }

        public Criteria andStreamOrderTypeIsNotNull() {
            addCriterion("stream_order_type is not null");
            return (Criteria) this;
        }

        public Criteria andStreamOrderTypeEqualTo(Integer value) {
            addCriterion("stream_order_type =", value, "streamOrderType");
            return (Criteria) this;
        }

        public Criteria andStreamOrderTypeNotEqualTo(Integer value) {
            addCriterion("stream_order_type <>", value, "streamOrderType");
            return (Criteria) this;
        }

        public Criteria andStreamOrderTypeGreaterThan(Integer value) {
            addCriterion("stream_order_type >", value, "streamOrderType");
            return (Criteria) this;
        }

        public Criteria andStreamOrderTypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("stream_order_type >=", value, "streamOrderType");
            return (Criteria) this;
        }

        public Criteria andStreamOrderTypeLessThan(Integer value) {
            addCriterion("stream_order_type <", value, "streamOrderType");
            return (Criteria) this;
        }

        public Criteria andStreamOrderTypeLessThanOrEqualTo(Integer value) {
            addCriterion("stream_order_type <=", value, "streamOrderType");
            return (Criteria) this;
        }

        public Criteria andStreamOrderTypeIn(List<Integer> values) {
            addCriterion("stream_order_type in", values, "streamOrderType");
            return (Criteria) this;
        }

        public Criteria andStreamOrderTypeNotIn(List<Integer> values) {
            addCriterion("stream_order_type not in", values, "streamOrderType");
            return (Criteria) this;
        }

        public Criteria andStreamOrderTypeBetween(Integer value1, Integer value2) {
            addCriterion("stream_order_type between", value1, value2, "streamOrderType");
            return (Criteria) this;
        }

        public Criteria andStreamOrderTypeNotBetween(Integer value1, Integer value2) {
            addCriterion("stream_order_type not between", value1, value2, "streamOrderType");
            return (Criteria) this;
        }

        public Criteria andStreamDirectionIsNull() {
            addCriterion("stream_direction is null");
            return (Criteria) this;
        }

        public Criteria andStreamDirectionIsNotNull() {
            addCriterion("stream_direction is not null");
            return (Criteria) this;
        }

        public Criteria andStreamDirectionEqualTo(Integer value) {
            addCriterion("stream_direction =", value, "streamDirection");
            return (Criteria) this;
        }

        public Criteria andStreamDirectionNotEqualTo(Integer value) {
            addCriterion("stream_direction <>", value, "streamDirection");
            return (Criteria) this;
        }

        public Criteria andStreamDirectionGreaterThan(Integer value) {
            addCriterion("stream_direction >", value, "streamDirection");
            return (Criteria) this;
        }

        public Criteria andStreamDirectionGreaterThanOrEqualTo(Integer value) {
            addCriterion("stream_direction >=", value, "streamDirection");
            return (Criteria) this;
        }

        public Criteria andStreamDirectionLessThan(Integer value) {
            addCriterion("stream_direction <", value, "streamDirection");
            return (Criteria) this;
        }

        public Criteria andStreamDirectionLessThanOrEqualTo(Integer value) {
            addCriterion("stream_direction <=", value, "streamDirection");
            return (Criteria) this;
        }

        public Criteria andStreamDirectionIn(List<Integer> values) {
            addCriterion("stream_direction in", values, "streamDirection");
            return (Criteria) this;
        }

        public Criteria andStreamDirectionNotIn(List<Integer> values) {
            addCriterion("stream_direction not in", values, "streamDirection");
            return (Criteria) this;
        }

        public Criteria andStreamDirectionBetween(Integer value1, Integer value2) {
            addCriterion("stream_direction between", value1, value2, "streamDirection");
            return (Criteria) this;
        }

        public Criteria andStreamDirectionNotBetween(Integer value1, Integer value2) {
            addCriterion("stream_direction not between", value1, value2, "streamDirection");
            return (Criteria) this;
        }

        public Criteria andStreamAmountIsNull() {
            addCriterion("stream_amount is null");
            return (Criteria) this;
        }

        public Criteria andStreamAmountIsNotNull() {
            addCriterion("stream_amount is not null");
            return (Criteria) this;
        }

        public Criteria andStreamAmountEqualTo(Integer value) {
            addCriterion("stream_amount =", value, "streamAmount");
            return (Criteria) this;
        }

        public Criteria andStreamAmountNotEqualTo(Integer value) {
            addCriterion("stream_amount <>", value, "streamAmount");
            return (Criteria) this;
        }

        public Criteria andStreamAmountGreaterThan(Integer value) {
            addCriterion("stream_amount >", value, "streamAmount");
            return (Criteria) this;
        }

        public Criteria andStreamAmountGreaterThanOrEqualTo(Integer value) {
            addCriterion("stream_amount >=", value, "streamAmount");
            return (Criteria) this;
        }

        public Criteria andStreamAmountLessThan(Integer value) {
            addCriterion("stream_amount <", value, "streamAmount");
            return (Criteria) this;
        }

        public Criteria andStreamAmountLessThanOrEqualTo(Integer value) {
            addCriterion("stream_amount <=", value, "streamAmount");
            return (Criteria) this;
        }

        public Criteria andStreamAmountIn(List<Integer> values) {
            addCriterion("stream_amount in", values, "streamAmount");
            return (Criteria) this;
        }

        public Criteria andStreamAmountNotIn(List<Integer> values) {
            addCriterion("stream_amount not in", values, "streamAmount");
            return (Criteria) this;
        }

        public Criteria andStreamAmountBetween(Integer value1, Integer value2) {
            addCriterion("stream_amount between", value1, value2, "streamAmount");
            return (Criteria) this;
        }

        public Criteria andStreamAmountNotBetween(Integer value1, Integer value2) {
            addCriterion("stream_amount not between", value1, value2, "streamAmount");
            return (Criteria) this;
        }

        public Criteria andStreamRemarkIsNull() {
            addCriterion("stream_remark is null");
            return (Criteria) this;
        }

        public Criteria andStreamRemarkIsNotNull() {
            addCriterion("stream_remark is not null");
            return (Criteria) this;
        }

        public Criteria andStreamRemarkEqualTo(String value) {
            addCriterion("stream_remark =", value, "streamRemark");
            return (Criteria) this;
        }

        public Criteria andStreamRemarkNotEqualTo(String value) {
            addCriterion("stream_remark <>", value, "streamRemark");
            return (Criteria) this;
        }

        public Criteria andStreamRemarkGreaterThan(String value) {
            addCriterion("stream_remark >", value, "streamRemark");
            return (Criteria) this;
        }

        public Criteria andStreamRemarkGreaterThanOrEqualTo(String value) {
            addCriterion("stream_remark >=", value, "streamRemark");
            return (Criteria) this;
        }

        public Criteria andStreamRemarkLessThan(String value) {
            addCriterion("stream_remark <", value, "streamRemark");
            return (Criteria) this;
        }

        public Criteria andStreamRemarkLessThanOrEqualTo(String value) {
            addCriterion("stream_remark <=", value, "streamRemark");
            return (Criteria) this;
        }

        public Criteria andStreamRemarkLike(String value) {
            addCriterion("stream_remark like", value, "streamRemark");
            return (Criteria) this;
        }

        public Criteria andStreamRemarkNotLike(String value) {
            addCriterion("stream_remark not like", value, "streamRemark");
            return (Criteria) this;
        }

        public Criteria andStreamRemarkIn(List<String> values) {
            addCriterion("stream_remark in", values, "streamRemark");
            return (Criteria) this;
        }

        public Criteria andStreamRemarkNotIn(List<String> values) {
            addCriterion("stream_remark not in", values, "streamRemark");
            return (Criteria) this;
        }

        public Criteria andStreamRemarkBetween(String value1, String value2) {
            addCriterion("stream_remark between", value1, value2, "streamRemark");
            return (Criteria) this;
        }

        public Criteria andStreamRemarkNotBetween(String value1, String value2) {
            addCriterion("stream_remark not between", value1, value2, "streamRemark");
            return (Criteria) this;
        }

        public Criteria andStreamStateIsNull() {
            addCriterion("stream_state is null");
            return (Criteria) this;
        }

        public Criteria andStreamStateIsNotNull() {
            addCriterion("stream_state is not null");
            return (Criteria) this;
        }

        public Criteria andStreamStateEqualTo(Integer value) {
            addCriterion("stream_state =", value, "streamState");
            return (Criteria) this;
        }

        public Criteria andStreamStateNotEqualTo(Integer value) {
            addCriterion("stream_state <>", value, "streamState");
            return (Criteria) this;
        }

        public Criteria andStreamStateGreaterThan(Integer value) {
            addCriterion("stream_state >", value, "streamState");
            return (Criteria) this;
        }

        public Criteria andStreamStateGreaterThanOrEqualTo(Integer value) {
            addCriterion("stream_state >=", value, "streamState");
            return (Criteria) this;
        }

        public Criteria andStreamStateLessThan(Integer value) {
            addCriterion("stream_state <", value, "streamState");
            return (Criteria) this;
        }

        public Criteria andStreamStateLessThanOrEqualTo(Integer value) {
            addCriterion("stream_state <=", value, "streamState");
            return (Criteria) this;
        }

        public Criteria andStreamStateIn(List<Integer> values) {
            addCriterion("stream_state in", values, "streamState");
            return (Criteria) this;
        }

        public Criteria andStreamStateNotIn(List<Integer> values) {
            addCriterion("stream_state not in", values, "streamState");
            return (Criteria) this;
        }

        public Criteria andStreamStateBetween(Integer value1, Integer value2) {
            addCriterion("stream_state between", value1, value2, "streamState");
            return (Criteria) this;
        }

        public Criteria andStreamStateNotBetween(Integer value1, Integer value2) {
            addCriterion("stream_state not between", value1, value2, "streamState");
            return (Criteria) this;
        }

        public Criteria andStreamSourceIsNull() {
            addCriterion("stream_source is null");
            return (Criteria) this;
        }

        public Criteria andStreamSourceIsNotNull() {
            addCriterion("stream_source is not null");
            return (Criteria) this;
        }

        public Criteria andStreamSourceEqualTo(Integer value) {
            addCriterion("stream_source =", value, "streamSource");
            return (Criteria) this;
        }

        public Criteria andStreamSourceNotEqualTo(Integer value) {
            addCriterion("stream_source <>", value, "streamSource");
            return (Criteria) this;
        }

        public Criteria andStreamSourceGreaterThan(Integer value) {
            addCriterion("stream_source >", value, "streamSource");
            return (Criteria) this;
        }

        public Criteria andStreamSourceGreaterThanOrEqualTo(Integer value) {
            addCriterion("stream_source >=", value, "streamSource");
            return (Criteria) this;
        }

        public Criteria andStreamSourceLessThan(Integer value) {
            addCriterion("stream_source <", value, "streamSource");
            return (Criteria) this;
        }

        public Criteria andStreamSourceLessThanOrEqualTo(Integer value) {
            addCriterion("stream_source <=", value, "streamSource");
            return (Criteria) this;
        }

        public Criteria andStreamSourceIn(List<Integer> values) {
            addCriterion("stream_source in", values, "streamSource");
            return (Criteria) this;
        }

        public Criteria andStreamSourceNotIn(List<Integer> values) {
            addCriterion("stream_source not in", values, "streamSource");
            return (Criteria) this;
        }

        public Criteria andStreamSourceBetween(Integer value1, Integer value2) {
            addCriterion("stream_source between", value1, value2, "streamSource");
            return (Criteria) this;
        }

        public Criteria andStreamSourceNotBetween(Integer value1, Integer value2) {
            addCriterion("stream_source not between", value1, value2, "streamSource");
            return (Criteria) this;
        }

        public Criteria andStreamTargetIsNull() {
            addCriterion("stream_target is null");
            return (Criteria) this;
        }

        public Criteria andStreamTargetIsNotNull() {
            addCriterion("stream_target is not null");
            return (Criteria) this;
        }

        public Criteria andStreamTargetEqualTo(Integer value) {
            addCriterion("stream_target =", value, "streamTarget");
            return (Criteria) this;
        }

        public Criteria andStreamTargetNotEqualTo(Integer value) {
            addCriterion("stream_target <>", value, "streamTarget");
            return (Criteria) this;
        }

        public Criteria andStreamTargetGreaterThan(Integer value) {
            addCriterion("stream_target >", value, "streamTarget");
            return (Criteria) this;
        }

        public Criteria andStreamTargetGreaterThanOrEqualTo(Integer value) {
            addCriterion("stream_target >=", value, "streamTarget");
            return (Criteria) this;
        }

        public Criteria andStreamTargetLessThan(Integer value) {
            addCriterion("stream_target <", value, "streamTarget");
            return (Criteria) this;
        }

        public Criteria andStreamTargetLessThanOrEqualTo(Integer value) {
            addCriterion("stream_target <=", value, "streamTarget");
            return (Criteria) this;
        }

        public Criteria andStreamTargetIn(List<Integer> values) {
            addCriterion("stream_target in", values, "streamTarget");
            return (Criteria) this;
        }

        public Criteria andStreamTargetNotIn(List<Integer> values) {
            addCriterion("stream_target not in", values, "streamTarget");
            return (Criteria) this;
        }

        public Criteria andStreamTargetBetween(Integer value1, Integer value2) {
            addCriterion("stream_target between", value1, value2, "streamTarget");
            return (Criteria) this;
        }

        public Criteria andStreamTargetNotBetween(Integer value1, Integer value2) {
            addCriterion("stream_target not between", value1, value2, "streamTarget");
            return (Criteria) this;
        }

        public Criteria andStreamUserIdIsNull() {
            addCriterion("stream_user_id is null");
            return (Criteria) this;
        }

        public Criteria andStreamUserIdIsNotNull() {
            addCriterion("stream_user_id is not null");
            return (Criteria) this;
        }

        public Criteria andStreamUserIdEqualTo(Integer value) {
            addCriterion("stream_user_id =", value, "streamUserId");
            return (Criteria) this;
        }

        public Criteria andStreamUserIdNotEqualTo(Integer value) {
            addCriterion("stream_user_id <>", value, "streamUserId");
            return (Criteria) this;
        }

        public Criteria andStreamUserIdGreaterThan(Integer value) {
            addCriterion("stream_user_id >", value, "streamUserId");
            return (Criteria) this;
        }

        public Criteria andStreamUserIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("stream_user_id >=", value, "streamUserId");
            return (Criteria) this;
        }

        public Criteria andStreamUserIdLessThan(Integer value) {
            addCriterion("stream_user_id <", value, "streamUserId");
            return (Criteria) this;
        }

        public Criteria andStreamUserIdLessThanOrEqualTo(Integer value) {
            addCriterion("stream_user_id <=", value, "streamUserId");
            return (Criteria) this;
        }

        public Criteria andStreamUserIdIn(List<Integer> values) {
            addCriterion("stream_user_id in", values, "streamUserId");
            return (Criteria) this;
        }

        public Criteria andStreamUserIdNotIn(List<Integer> values) {
            addCriterion("stream_user_id not in", values, "streamUserId");
            return (Criteria) this;
        }

        public Criteria andStreamUserIdBetween(Integer value1, Integer value2) {
            addCriterion("stream_user_id between", value1, value2, "streamUserId");
            return (Criteria) this;
        }

        public Criteria andStreamUserIdNotBetween(Integer value1, Integer value2) {
            addCriterion("stream_user_id not between", value1, value2, "streamUserId");
            return (Criteria) this;
        }

        public Criteria andStreamUserTypeIsNull() {
            addCriterion("stream_user_type is null");
            return (Criteria) this;
        }

        public Criteria andStreamUserTypeIsNotNull() {
            addCriterion("stream_user_type is not null");
            return (Criteria) this;
        }

        public Criteria andStreamUserTypeEqualTo(Integer value) {
            addCriterion("stream_user_type =", value, "streamUserType");
            return (Criteria) this;
        }

        public Criteria andStreamUserTypeNotEqualTo(Integer value) {
            addCriterion("stream_user_type <>", value, "streamUserType");
            return (Criteria) this;
        }

        public Criteria andStreamUserTypeGreaterThan(Integer value) {
            addCriterion("stream_user_type >", value, "streamUserType");
            return (Criteria) this;
        }

        public Criteria andStreamUserTypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("stream_user_type >=", value, "streamUserType");
            return (Criteria) this;
        }

        public Criteria andStreamUserTypeLessThan(Integer value) {
            addCriterion("stream_user_type <", value, "streamUserType");
            return (Criteria) this;
        }

        public Criteria andStreamUserTypeLessThanOrEqualTo(Integer value) {
            addCriterion("stream_user_type <=", value, "streamUserType");
            return (Criteria) this;
        }

        public Criteria andStreamUserTypeIn(List<Integer> values) {
            addCriterion("stream_user_type in", values, "streamUserType");
            return (Criteria) this;
        }

        public Criteria andStreamUserTypeNotIn(List<Integer> values) {
            addCriterion("stream_user_type not in", values, "streamUserType");
            return (Criteria) this;
        }

        public Criteria andStreamUserTypeBetween(Integer value1, Integer value2) {
            addCriterion("stream_user_type between", value1, value2, "streamUserType");
            return (Criteria) this;
        }

        public Criteria andStreamUserTypeNotBetween(Integer value1, Integer value2) {
            addCriterion("stream_user_type not between", value1, value2, "streamUserType");
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