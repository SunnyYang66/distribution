package org.mfoyou.agent.common.dao.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class HuawuPayExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    protected Integer limitStart;

    protected Integer limitEnd;

    public HuawuPayExample() {
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

        public Criteria andPayIdIsNull() {
            addCriterion("pay_id is null");
            return (Criteria) this;
        }

        public Criteria andPayIdIsNotNull() {
            addCriterion("pay_id is not null");
            return (Criteria) this;
        }

        public Criteria andPayIdEqualTo(Integer value) {
            addCriterion("pay_id =", value, "payId");
            return (Criteria) this;
        }

        public Criteria andPayIdNotEqualTo(Integer value) {
            addCriterion("pay_id <>", value, "payId");
            return (Criteria) this;
        }

        public Criteria andPayIdGreaterThan(Integer value) {
            addCriterion("pay_id >", value, "payId");
            return (Criteria) this;
        }

        public Criteria andPayIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("pay_id >=", value, "payId");
            return (Criteria) this;
        }

        public Criteria andPayIdLessThan(Integer value) {
            addCriterion("pay_id <", value, "payId");
            return (Criteria) this;
        }

        public Criteria andPayIdLessThanOrEqualTo(Integer value) {
            addCriterion("pay_id <=", value, "payId");
            return (Criteria) this;
        }

        public Criteria andPayIdIn(List<Integer> values) {
            addCriterion("pay_id in", values, "payId");
            return (Criteria) this;
        }

        public Criteria andPayIdNotIn(List<Integer> values) {
            addCriterion("pay_id not in", values, "payId");
            return (Criteria) this;
        }

        public Criteria andPayIdBetween(Integer value1, Integer value2) {
            addCriterion("pay_id between", value1, value2, "payId");
            return (Criteria) this;
        }

        public Criteria andPayIdNotBetween(Integer value1, Integer value2) {
            addCriterion("pay_id not between", value1, value2, "payId");
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

        public Criteria andPayNumberIsNull() {
            addCriterion("pay_number is null");
            return (Criteria) this;
        }

        public Criteria andPayNumberIsNotNull() {
            addCriterion("pay_number is not null");
            return (Criteria) this;
        }

        public Criteria andPayNumberEqualTo(String value) {
            addCriterion("pay_number =", value, "payNumber");
            return (Criteria) this;
        }

        public Criteria andPayNumberNotEqualTo(String value) {
            addCriterion("pay_number <>", value, "payNumber");
            return (Criteria) this;
        }

        public Criteria andPayNumberGreaterThan(String value) {
            addCriterion("pay_number >", value, "payNumber");
            return (Criteria) this;
        }

        public Criteria andPayNumberGreaterThanOrEqualTo(String value) {
            addCriterion("pay_number >=", value, "payNumber");
            return (Criteria) this;
        }

        public Criteria andPayNumberLessThan(String value) {
            addCriterion("pay_number <", value, "payNumber");
            return (Criteria) this;
        }

        public Criteria andPayNumberLessThanOrEqualTo(String value) {
            addCriterion("pay_number <=", value, "payNumber");
            return (Criteria) this;
        }

        public Criteria andPayNumberLike(String value) {
            addCriterion("pay_number like", value, "payNumber");
            return (Criteria) this;
        }

        public Criteria andPayNumberNotLike(String value) {
            addCriterion("pay_number not like", value, "payNumber");
            return (Criteria) this;
        }

        public Criteria andPayNumberIn(List<String> values) {
            addCriterion("pay_number in", values, "payNumber");
            return (Criteria) this;
        }

        public Criteria andPayNumberNotIn(List<String> values) {
            addCriterion("pay_number not in", values, "payNumber");
            return (Criteria) this;
        }

        public Criteria andPayNumberBetween(String value1, String value2) {
            addCriterion("pay_number between", value1, value2, "payNumber");
            return (Criteria) this;
        }

        public Criteria andPayNumberNotBetween(String value1, String value2) {
            addCriterion("pay_number not between", value1, value2, "payNumber");
            return (Criteria) this;
        }

        public Criteria andPayOrderTypeIsNull() {
            addCriterion("pay_order_type is null");
            return (Criteria) this;
        }

        public Criteria andPayOrderTypeIsNotNull() {
            addCriterion("pay_order_type is not null");
            return (Criteria) this;
        }

        public Criteria andPayOrderTypeEqualTo(Integer value) {
            addCriterion("pay_order_type =", value, "payOrderType");
            return (Criteria) this;
        }

        public Criteria andPayOrderTypeNotEqualTo(Integer value) {
            addCriterion("pay_order_type <>", value, "payOrderType");
            return (Criteria) this;
        }

        public Criteria andPayOrderTypeGreaterThan(Integer value) {
            addCriterion("pay_order_type >", value, "payOrderType");
            return (Criteria) this;
        }

        public Criteria andPayOrderTypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("pay_order_type >=", value, "payOrderType");
            return (Criteria) this;
        }

        public Criteria andPayOrderTypeLessThan(Integer value) {
            addCriterion("pay_order_type <", value, "payOrderType");
            return (Criteria) this;
        }

        public Criteria andPayOrderTypeLessThanOrEqualTo(Integer value) {
            addCriterion("pay_order_type <=", value, "payOrderType");
            return (Criteria) this;
        }

        public Criteria andPayOrderTypeIn(List<Integer> values) {
            addCriterion("pay_order_type in", values, "payOrderType");
            return (Criteria) this;
        }

        public Criteria andPayOrderTypeNotIn(List<Integer> values) {
            addCriterion("pay_order_type not in", values, "payOrderType");
            return (Criteria) this;
        }

        public Criteria andPayOrderTypeBetween(Integer value1, Integer value2) {
            addCriterion("pay_order_type between", value1, value2, "payOrderType");
            return (Criteria) this;
        }

        public Criteria andPayOrderTypeNotBetween(Integer value1, Integer value2) {
            addCriterion("pay_order_type not between", value1, value2, "payOrderType");
            return (Criteria) this;
        }

        public Criteria andPayOrderIdIsNull() {
            addCriterion("pay_order_id is null");
            return (Criteria) this;
        }

        public Criteria andPayOrderIdIsNotNull() {
            addCriterion("pay_order_id is not null");
            return (Criteria) this;
        }

        public Criteria andPayOrderIdEqualTo(Integer value) {
            addCriterion("pay_order_id =", value, "payOrderId");
            return (Criteria) this;
        }

        public Criteria andPayOrderIdNotEqualTo(Integer value) {
            addCriterion("pay_order_id <>", value, "payOrderId");
            return (Criteria) this;
        }

        public Criteria andPayOrderIdGreaterThan(Integer value) {
            addCriterion("pay_order_id >", value, "payOrderId");
            return (Criteria) this;
        }

        public Criteria andPayOrderIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("pay_order_id >=", value, "payOrderId");
            return (Criteria) this;
        }

        public Criteria andPayOrderIdLessThan(Integer value) {
            addCriterion("pay_order_id <", value, "payOrderId");
            return (Criteria) this;
        }

        public Criteria andPayOrderIdLessThanOrEqualTo(Integer value) {
            addCriterion("pay_order_id <=", value, "payOrderId");
            return (Criteria) this;
        }

        public Criteria andPayOrderIdIn(List<Integer> values) {
            addCriterion("pay_order_id in", values, "payOrderId");
            return (Criteria) this;
        }

        public Criteria andPayOrderIdNotIn(List<Integer> values) {
            addCriterion("pay_order_id not in", values, "payOrderId");
            return (Criteria) this;
        }

        public Criteria andPayOrderIdBetween(Integer value1, Integer value2) {
            addCriterion("pay_order_id between", value1, value2, "payOrderId");
            return (Criteria) this;
        }

        public Criteria andPayOrderIdNotBetween(Integer value1, Integer value2) {
            addCriterion("pay_order_id not between", value1, value2, "payOrderId");
            return (Criteria) this;
        }

        public Criteria andPayTypeIsNull() {
            addCriterion("pay_type is null");
            return (Criteria) this;
        }

        public Criteria andPayTypeIsNotNull() {
            addCriterion("pay_type is not null");
            return (Criteria) this;
        }

        public Criteria andPayTypeEqualTo(Integer value) {
            addCriterion("pay_type =", value, "payType");
            return (Criteria) this;
        }

        public Criteria andPayTypeNotEqualTo(Integer value) {
            addCriterion("pay_type <>", value, "payType");
            return (Criteria) this;
        }

        public Criteria andPayTypeGreaterThan(Integer value) {
            addCriterion("pay_type >", value, "payType");
            return (Criteria) this;
        }

        public Criteria andPayTypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("pay_type >=", value, "payType");
            return (Criteria) this;
        }

        public Criteria andPayTypeLessThan(Integer value) {
            addCriterion("pay_type <", value, "payType");
            return (Criteria) this;
        }

        public Criteria andPayTypeLessThanOrEqualTo(Integer value) {
            addCriterion("pay_type <=", value, "payType");
            return (Criteria) this;
        }

        public Criteria andPayTypeIn(List<Integer> values) {
            addCriterion("pay_type in", values, "payType");
            return (Criteria) this;
        }

        public Criteria andPayTypeNotIn(List<Integer> values) {
            addCriterion("pay_type not in", values, "payType");
            return (Criteria) this;
        }

        public Criteria andPayTypeBetween(Integer value1, Integer value2) {
            addCriterion("pay_type between", value1, value2, "payType");
            return (Criteria) this;
        }

        public Criteria andPayTypeNotBetween(Integer value1, Integer value2) {
            addCriterion("pay_type not between", value1, value2, "payType");
            return (Criteria) this;
        }

        public Criteria andPayPreIdIsNull() {
            addCriterion("pay_pre_id is null");
            return (Criteria) this;
        }

        public Criteria andPayPreIdIsNotNull() {
            addCriterion("pay_pre_id is not null");
            return (Criteria) this;
        }

        public Criteria andPayPreIdEqualTo(String value) {
            addCriterion("pay_pre_id =", value, "payPreId");
            return (Criteria) this;
        }

        public Criteria andPayPreIdNotEqualTo(String value) {
            addCriterion("pay_pre_id <>", value, "payPreId");
            return (Criteria) this;
        }

        public Criteria andPayPreIdGreaterThan(String value) {
            addCriterion("pay_pre_id >", value, "payPreId");
            return (Criteria) this;
        }

        public Criteria andPayPreIdGreaterThanOrEqualTo(String value) {
            addCriterion("pay_pre_id >=", value, "payPreId");
            return (Criteria) this;
        }

        public Criteria andPayPreIdLessThan(String value) {
            addCriterion("pay_pre_id <", value, "payPreId");
            return (Criteria) this;
        }

        public Criteria andPayPreIdLessThanOrEqualTo(String value) {
            addCriterion("pay_pre_id <=", value, "payPreId");
            return (Criteria) this;
        }

        public Criteria andPayPreIdLike(String value) {
            addCriterion("pay_pre_id like", value, "payPreId");
            return (Criteria) this;
        }

        public Criteria andPayPreIdNotLike(String value) {
            addCriterion("pay_pre_id not like", value, "payPreId");
            return (Criteria) this;
        }

        public Criteria andPayPreIdIn(List<String> values) {
            addCriterion("pay_pre_id in", values, "payPreId");
            return (Criteria) this;
        }

        public Criteria andPayPreIdNotIn(List<String> values) {
            addCriterion("pay_pre_id not in", values, "payPreId");
            return (Criteria) this;
        }

        public Criteria andPayPreIdBetween(String value1, String value2) {
            addCriterion("pay_pre_id between", value1, value2, "payPreId");
            return (Criteria) this;
        }

        public Criteria andPayPreIdNotBetween(String value1, String value2) {
            addCriterion("pay_pre_id not between", value1, value2, "payPreId");
            return (Criteria) this;
        }

        public Criteria andPayPreTextIsNull() {
            addCriterion("pay_pre_text is null");
            return (Criteria) this;
        }

        public Criteria andPayPreTextIsNotNull() {
            addCriterion("pay_pre_text is not null");
            return (Criteria) this;
        }

        public Criteria andPayPreTextEqualTo(String value) {
            addCriterion("pay_pre_text =", value, "payPreText");
            return (Criteria) this;
        }

        public Criteria andPayPreTextNotEqualTo(String value) {
            addCriterion("pay_pre_text <>", value, "payPreText");
            return (Criteria) this;
        }

        public Criteria andPayPreTextGreaterThan(String value) {
            addCriterion("pay_pre_text >", value, "payPreText");
            return (Criteria) this;
        }

        public Criteria andPayPreTextGreaterThanOrEqualTo(String value) {
            addCriterion("pay_pre_text >=", value, "payPreText");
            return (Criteria) this;
        }

        public Criteria andPayPreTextLessThan(String value) {
            addCriterion("pay_pre_text <", value, "payPreText");
            return (Criteria) this;
        }

        public Criteria andPayPreTextLessThanOrEqualTo(String value) {
            addCriterion("pay_pre_text <=", value, "payPreText");
            return (Criteria) this;
        }

        public Criteria andPayPreTextLike(String value) {
            addCriterion("pay_pre_text like", value, "payPreText");
            return (Criteria) this;
        }

        public Criteria andPayPreTextNotLike(String value) {
            addCriterion("pay_pre_text not like", value, "payPreText");
            return (Criteria) this;
        }

        public Criteria andPayPreTextIn(List<String> values) {
            addCriterion("pay_pre_text in", values, "payPreText");
            return (Criteria) this;
        }

        public Criteria andPayPreTextNotIn(List<String> values) {
            addCriterion("pay_pre_text not in", values, "payPreText");
            return (Criteria) this;
        }

        public Criteria andPayPreTextBetween(String value1, String value2) {
            addCriterion("pay_pre_text between", value1, value2, "payPreText");
            return (Criteria) this;
        }

        public Criteria andPayPreTextNotBetween(String value1, String value2) {
            addCriterion("pay_pre_text not between", value1, value2, "payPreText");
            return (Criteria) this;
        }

        public Criteria andPayAmountIsNull() {
            addCriterion("pay_amount is null");
            return (Criteria) this;
        }

        public Criteria andPayAmountIsNotNull() {
            addCriterion("pay_amount is not null");
            return (Criteria) this;
        }

        public Criteria andPayAmountEqualTo(Integer value) {
            addCriterion("pay_amount =", value, "payAmount");
            return (Criteria) this;
        }

        public Criteria andPayAmountNotEqualTo(Integer value) {
            addCriterion("pay_amount <>", value, "payAmount");
            return (Criteria) this;
        }

        public Criteria andPayAmountGreaterThan(Integer value) {
            addCriterion("pay_amount >", value, "payAmount");
            return (Criteria) this;
        }

        public Criteria andPayAmountGreaterThanOrEqualTo(Integer value) {
            addCriterion("pay_amount >=", value, "payAmount");
            return (Criteria) this;
        }

        public Criteria andPayAmountLessThan(Integer value) {
            addCriterion("pay_amount <", value, "payAmount");
            return (Criteria) this;
        }

        public Criteria andPayAmountLessThanOrEqualTo(Integer value) {
            addCriterion("pay_amount <=", value, "payAmount");
            return (Criteria) this;
        }

        public Criteria andPayAmountIn(List<Integer> values) {
            addCriterion("pay_amount in", values, "payAmount");
            return (Criteria) this;
        }

        public Criteria andPayAmountNotIn(List<Integer> values) {
            addCriterion("pay_amount not in", values, "payAmount");
            return (Criteria) this;
        }

        public Criteria andPayAmountBetween(Integer value1, Integer value2) {
            addCriterion("pay_amount between", value1, value2, "payAmount");
            return (Criteria) this;
        }

        public Criteria andPayAmountNotBetween(Integer value1) {
            addCriterion("agent_id = ", value1, "agentId");
            return (Criteria) this;
        }

        public Criteria andPayCallbackTextIsNull() {
            addCriterion("pay_callback_text is null");
            return (Criteria) this;
        }

        public Criteria andPayCallbackTextIsNotNull() {
            addCriterion("pay_callback_text is not null");
            return (Criteria) this;
        }

        public Criteria andPayCallbackTextEqualTo(String value) {
            addCriterion("pay_callback_text =", value, "payCallbackText");
            return (Criteria) this;
        }

        public Criteria andPayCallbackTextNotEqualTo(String value) {
            addCriterion("pay_callback_text <>", value, "payCallbackText");
            return (Criteria) this;
        }

        public Criteria andPayCallbackTextGreaterThan(String value) {
            addCriterion("pay_callback_text >", value, "payCallbackText");
            return (Criteria) this;
        }

        public Criteria andPayCallbackTextGreaterThanOrEqualTo(String value) {
            addCriterion("pay_callback_text >=", value, "payCallbackText");
            return (Criteria) this;
        }

        public Criteria andPayCallbackTextLessThan(String value) {
            addCriterion("pay_callback_text <", value, "payCallbackText");
            return (Criteria) this;
        }

        public Criteria andPayCallbackTextLessThanOrEqualTo(String value) {
            addCriterion("pay_callback_text <=", value, "payCallbackText");
            return (Criteria) this;
        }

        public Criteria andPayCallbackTextLike(String value) {
            addCriterion("pay_callback_text like", value, "payCallbackText");
            return (Criteria) this;
        }

        public Criteria andPayCallbackTextNotLike(String value) {
            addCriterion("pay_callback_text not like", value, "payCallbackText");
            return (Criteria) this;
        }

        public Criteria andPayCallbackTextIn(List<String> values) {
            addCriterion("pay_callback_text in", values, "payCallbackText");
            return (Criteria) this;
        }

        public Criteria andPayCallbackTextNotIn(List<String> values) {
            addCriterion("pay_callback_text not in", values, "payCallbackText");
            return (Criteria) this;
        }

        public Criteria andPayCallbackTextBetween(String value1, String value2) {
            addCriterion("pay_callback_text between", value1, value2, "payCallbackText");
            return (Criteria) this;
        }

        public Criteria andPayCallbackTextNotBetween(String value1, String value2) {
            addCriterion("pay_callback_text not between", value1, value2, "payCallbackText");
            return (Criteria) this;
        }

        public Criteria andPayStateIsNull() {
            addCriterion("pay_state is null");
            return (Criteria) this;
        }

        public Criteria andPayStateIsNotNull() {
            addCriterion("pay_state is not null");
            return (Criteria) this;
        }

        public Criteria andPayStateEqualTo(Integer value) {
            addCriterion("pay_state =", value, "payState");
            return (Criteria) this;
        }

        public Criteria andPayStateNotEqualTo(Integer value) {
            addCriterion("pay_state <>", value, "payState");
            return (Criteria) this;
        }

        public Criteria andPayStateGreaterThan(Integer value) {
            addCriterion("pay_state >", value, "payState");
            return (Criteria) this;
        }

        public Criteria andPayStateGreaterThanOrEqualTo(Integer value) {
            addCriterion("pay_state >=", value, "payState");
            return (Criteria) this;
        }

        public Criteria andPayStateLessThan(Integer value) {
            addCriterion("pay_state <", value, "payState");
            return (Criteria) this;
        }

        public Criteria andPayStateLessThanOrEqualTo(Integer value) {
            addCriterion("pay_state <=", value, "payState");
            return (Criteria) this;
        }

        public Criteria andPayStateIn(List<Integer> values) {
            addCriterion("pay_state in", values, "payState");
            return (Criteria) this;
        }

        public Criteria andPayStateNotIn(List<Integer> values) {
            addCriterion("pay_state not in", values, "payState");
            return (Criteria) this;
        }

        public Criteria andPayStateBetween(Integer value1, Integer value2) {
            addCriterion("pay_state between", value1, value2, "payState");
            return (Criteria) this;
        }

        public Criteria andPayStateNotBetween(Integer value1, Integer value2) {
            addCriterion("pay_state not between", value1, value2, "payState");
            return (Criteria) this;
        }

        public Criteria andPayCreateTimeIsNull() {
            addCriterion("pay_create_time is null");
            return (Criteria) this;
        }

        public Criteria andPayCreateTimeIsNotNull() {
            addCriterion("pay_create_time is not null");
            return (Criteria) this;
        }

        public Criteria andPayCreateTimeEqualTo(Date value) {
            addCriterion("pay_create_time =", value, "payCreateTime");
            return (Criteria) this;
        }

        public Criteria andPayCreateTimeNotEqualTo(Date value) {
            addCriterion("pay_create_time <>", value, "payCreateTime");
            return (Criteria) this;
        }

        public Criteria andPayCreateTimeGreaterThan(Date value) {
            addCriterion("pay_create_time >", value, "payCreateTime");
            return (Criteria) this;
        }

        public Criteria andPayCreateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("pay_create_time >=", value, "payCreateTime");
            return (Criteria) this;
        }

        public Criteria andPayCreateTimeLessThan(Date value) {
            addCriterion("pay_create_time <", value, "payCreateTime");
            return (Criteria) this;
        }

        public Criteria andPayCreateTimeLessThanOrEqualTo(Date value) {
            addCriterion("pay_create_time <=", value, "payCreateTime");
            return (Criteria) this;
        }

        public Criteria andPayCreateTimeIn(List<Date> values) {
            addCriterion("pay_create_time in", values, "payCreateTime");
            return (Criteria) this;
        }

        public Criteria andPayCreateTimeNotIn(List<Date> values) {
            addCriterion("pay_create_time not in", values, "payCreateTime");
            return (Criteria) this;
        }

        public Criteria andPayCreateTimeBetween(Date value1, Date value2) {
            addCriterion("pay_create_time between", value1, value2, "payCreateTime");
            return (Criteria) this;
        }

        public Criteria andPayCreateTimeNotBetween(Date value1, Date value2) {
            addCriterion("pay_create_time not between", value1, value2, "payCreateTime");
            return (Criteria) this;
        }

        public Criteria andPayModifyTimeIsNull() {
            addCriterion("pay_modify_time is null");
            return (Criteria) this;
        }

        public Criteria andPayModifyTimeIsNotNull() {
            addCriterion("pay_modify_time is not null");
            return (Criteria) this;
        }

        public Criteria andPayModifyTimeEqualTo(Date value) {
            addCriterion("pay_modify_time =", value, "payModifyTime");
            return (Criteria) this;
        }

        public Criteria andPayModifyTimeNotEqualTo(Date value) {
            addCriterion("pay_modify_time <>", value, "payModifyTime");
            return (Criteria) this;
        }

        public Criteria andPayModifyTimeGreaterThan(Date value) {
            addCriterion("pay_modify_time >", value, "payModifyTime");
            return (Criteria) this;
        }

        public Criteria andPayModifyTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("pay_modify_time >=", value, "payModifyTime");
            return (Criteria) this;
        }

        public Criteria andPayModifyTimeLessThan(Date value) {
            addCriterion("pay_modify_time <", value, "payModifyTime");
            return (Criteria) this;
        }

        public Criteria andPayModifyTimeLessThanOrEqualTo(Date value) {
            addCriterion("pay_modify_time <=", value, "payModifyTime");
            return (Criteria) this;
        }

        public Criteria andPayModifyTimeIn(List<Date> values) {
            addCriterion("pay_modify_time in", values, "payModifyTime");
            return (Criteria) this;
        }

        public Criteria andPayModifyTimeNotIn(List<Date> values) {
            addCriterion("pay_modify_time not in", values, "payModifyTime");
            return (Criteria) this;
        }

        public Criteria andPayModifyTimeBetween(Date value1, Date value2) {
            addCriterion("pay_modify_time between", value1, value2, "payModifyTime");
            return (Criteria) this;
        }

        public Criteria andPayModifyTimeNotBetween(Date value1, Date value2) {
            addCriterion("pay_modify_time not between", value1, value2, "payModifyTime");
            return (Criteria) this;
        }

        public Criteria andPayAppIdIsNull() {
            addCriterion("pay_app_id is null");
            return (Criteria) this;
        }

        public Criteria andPayAppIdIsNotNull() {
            addCriterion("pay_app_id is not null");
            return (Criteria) this;
        }

        public Criteria andPayAppIdEqualTo(Integer value) {
            addCriterion("pay_app_id =", value, "payAppId");
            return (Criteria) this;
        }

        public Criteria andPayAppIdNotEqualTo(Integer value) {
            addCriterion("pay_app_id <>", value, "payAppId");
            return (Criteria) this;
        }

        public Criteria andPayAppIdGreaterThan(Integer value) {
            addCriterion("pay_app_id >", value, "payAppId");
            return (Criteria) this;
        }

        public Criteria andPayAppIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("pay_app_id >=", value, "payAppId");
            return (Criteria) this;
        }

        public Criteria andPayAppIdLessThan(Integer value) {
            addCriterion("pay_app_id <", value, "payAppId");
            return (Criteria) this;
        }

        public Criteria andPayAppIdLessThanOrEqualTo(Integer value) {
            addCriterion("pay_app_id <=", value, "payAppId");
            return (Criteria) this;
        }

        public Criteria andPayAppIdIn(List<Integer> values) {
            addCriterion("pay_app_id in", values, "payAppId");
            return (Criteria) this;
        }

        public Criteria andPayAppIdNotIn(List<Integer> values) {
            addCriterion("pay_app_id not in", values, "payAppId");
            return (Criteria) this;
        }

        public Criteria andPayAppIdBetween(Integer value1, Integer value2) {
            addCriterion("pay_app_id between", value1, value2, "payAppId");
            return (Criteria) this;
        }

        public Criteria andPayAppIdNotBetween(Integer value1, Integer value2) {
            addCriterion("pay_app_id not between", value1, value2, "payAppId");
            return (Criteria) this;
        }

        public Criteria andPayStoreIdIsNull() {
            addCriterion("pay_store_id is null");
            return (Criteria) this;
        }

        public Criteria andPayStoreIdIsNotNull() {
            addCriterion("pay_store_id is not null");
            return (Criteria) this;
        }

        public Criteria andPayStoreIdEqualTo(Integer value) {
            addCriterion("pay_store_id =", value, "payStoreId");
            return (Criteria) this;
        }

        public Criteria andPayStoreIdNotEqualTo(Integer value) {
            addCriterion("pay_store_id <>", value, "payStoreId");
            return (Criteria) this;
        }

        public Criteria andPayStoreIdGreaterThan(Integer value) {
            addCriterion("pay_store_id >", value, "payStoreId");
            return (Criteria) this;
        }

        public Criteria andPayStoreIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("pay_store_id >=", value, "payStoreId");
            return (Criteria) this;
        }

        public Criteria andPayStoreIdLessThan(Integer value) {
            addCriterion("pay_store_id <", value, "payStoreId");
            return (Criteria) this;
        }

        public Criteria andPayStoreIdLessThanOrEqualTo(Integer value) {
            addCriterion("pay_store_id <=", value, "payStoreId");
            return (Criteria) this;
        }

        public Criteria andPayStoreIdIn(List<Integer> values) {
            addCriterion("pay_store_id in", values, "payStoreId");
            return (Criteria) this;
        }

        public Criteria andPayStoreIdNotIn(List<Integer> values) {
            addCriterion("pay_store_id not in", values, "payStoreId");
            return (Criteria) this;
        }

        public Criteria andPayStoreIdBetween(Integer value1, Integer value2) {
            addCriterion("pay_store_id between", value1, value2, "payStoreId");
            return (Criteria) this;
        }

        public Criteria andPayStoreIdNotBetween(Integer value1, Integer value2) {
            addCriterion("pay_store_id not between", value1, value2, "payStoreId");
            return (Criteria) this;
        }

        public Criteria andUserNameIsNull() {
            addCriterion("user_name is null");
            return (Criteria) this;
        }

        public Criteria andUserNameIsNotNull() {
            addCriterion("user_name is not null");
            return (Criteria) this;
        }

        public Criteria andUserNameEqualTo(String value) {
            addCriterion("user_name =", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameNotEqualTo(String value) {
            addCriterion("user_name <>", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameGreaterThan(String value) {
            addCriterion("user_name >", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameGreaterThanOrEqualTo(String value) {
            addCriterion("user_name >=", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameLessThan(String value) {
            addCriterion("user_name <", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameLessThanOrEqualTo(String value) {
            addCriterion("user_name <=", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameLike(String value) {
            addCriterion("user_name like", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameNotLike(String value) {
            addCriterion("user_name not like", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameIn(List<String> values) {
            addCriterion("user_name in", values, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameNotIn(List<String> values) {
            addCriterion("user_name not in", values, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameBetween(String value1, String value2) {
            addCriterion("user_name between", value1, value2, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameNotBetween(String value1, String value2) {
            addCriterion("user_name not between", value1, value2, "userName");
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