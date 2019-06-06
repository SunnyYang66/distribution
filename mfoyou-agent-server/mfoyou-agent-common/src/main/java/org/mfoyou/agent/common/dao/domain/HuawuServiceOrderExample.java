package org.mfoyou.agent.common.dao.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class HuawuServiceOrderExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    protected Integer limitStart;

    protected Integer limitEnd;

    public HuawuServiceOrderExample() {
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

        public Criteria andServiceOrderIdIsNull() {
            addCriterion("service_order_id is null");
            return (Criteria) this;
        }

        public Criteria andServiceOrderIdIsNotNull() {
            addCriterion("service_order_id is not null");
            return (Criteria) this;
        }

        public Criteria andServiceOrderIdEqualTo(Integer value) {
            addCriterion("service_order_id =", value, "serviceOrderId");
            return (Criteria) this;
        }

        public Criteria andServiceOrderIdNotEqualTo(Integer value) {
            addCriterion("service_order_id <>", value, "serviceOrderId");
            return (Criteria) this;
        }

        public Criteria andServiceOrderIdGreaterThan(Integer value) {
            addCriterion("service_order_id >", value, "serviceOrderId");
            return (Criteria) this;
        }

        public Criteria andServiceOrderIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("service_order_id >=", value, "serviceOrderId");
            return (Criteria) this;
        }

        public Criteria andServiceOrderIdLessThan(Integer value) {
            addCriterion("service_order_id <", value, "serviceOrderId");
            return (Criteria) this;
        }

        public Criteria andServiceOrderIdLessThanOrEqualTo(Integer value) {
            addCriterion("service_order_id <=", value, "serviceOrderId");
            return (Criteria) this;
        }

        public Criteria andServiceOrderIdIn(List<Integer> values) {
            addCriterion("service_order_id in", values, "serviceOrderId");
            return (Criteria) this;
        }

        public Criteria andServiceOrderIdNotIn(List<Integer> values) {
            addCriterion("service_order_id not in", values, "serviceOrderId");
            return (Criteria) this;
        }

        public Criteria andServiceOrderIdBetween(Integer value1, Integer value2) {
            addCriterion("service_order_id between", value1, value2, "serviceOrderId");
            return (Criteria) this;
        }

        public Criteria andServiceOrderIdNotBetween(Integer value1, Integer value2) {
            addCriterion("service_order_id not between", value1, value2, "serviceOrderId");
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

        public Criteria andServiceTagIdIsNull() {
            addCriterion("service_tag_id is null");
            return (Criteria) this;
        }

        public Criteria andServiceTagIdIsNotNull() {
            addCriterion("service_tag_id is not null");
            return (Criteria) this;
        }

        public Criteria andServiceTagIdEqualTo(Integer value) {
            addCriterion("service_tag_id =", value, "serviceTagId");
            return (Criteria) this;
        }

        public Criteria andServiceTagIdNotEqualTo(Integer value) {
            addCriterion("service_tag_id <>", value, "serviceTagId");
            return (Criteria) this;
        }

        public Criteria andServiceTagIdGreaterThan(Integer value) {
            addCriterion("service_tag_id >", value, "serviceTagId");
            return (Criteria) this;
        }

        public Criteria andServiceTagIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("service_tag_id >=", value, "serviceTagId");
            return (Criteria) this;
        }

        public Criteria andServiceTagIdLessThan(Integer value) {
            addCriterion("service_tag_id <", value, "serviceTagId");
            return (Criteria) this;
        }

        public Criteria andServiceTagIdLessThanOrEqualTo(Integer value) {
            addCriterion("service_tag_id <=", value, "serviceTagId");
            return (Criteria) this;
        }

        public Criteria andServiceTagIdIn(List<Integer> values) {
            addCriterion("service_tag_id in", values, "serviceTagId");
            return (Criteria) this;
        }

        public Criteria andServiceTagIdNotIn(List<Integer> values) {
            addCriterion("service_tag_id not in", values, "serviceTagId");
            return (Criteria) this;
        }

        public Criteria andServiceTagIdBetween(Integer value1, Integer value2) {
            addCriterion("service_tag_id between", value1, value2, "serviceTagId");
            return (Criteria) this;
        }

        public Criteria andServiceTagIdNotBetween(Integer value1, Integer value2) {
            addCriterion("service_tag_id not between", value1, value2, "serviceTagId");
            return (Criteria) this;
        }

        public Criteria andServiceUserLatIsNull() {
            addCriterion("service_user_lat is null");
            return (Criteria) this;
        }

        public Criteria andServiceUserLatIsNotNull() {
            addCriterion("service_user_lat is not null");
            return (Criteria) this;
        }

        public Criteria andServiceUserLatEqualTo(Double value) {
            addCriterion("service_user_lat =", value, "serviceUserLat");
            return (Criteria) this;
        }

        public Criteria andServiceUserLatNotEqualTo(Double value) {
            addCriterion("service_user_lat <>", value, "serviceUserLat");
            return (Criteria) this;
        }

        public Criteria andServiceUserLatGreaterThan(Double value) {
            addCriterion("service_user_lat >", value, "serviceUserLat");
            return (Criteria) this;
        }

        public Criteria andServiceUserLatGreaterThanOrEqualTo(Double value) {
            addCriterion("service_user_lat >=", value, "serviceUserLat");
            return (Criteria) this;
        }

        public Criteria andServiceUserLatLessThan(Double value) {
            addCriterion("service_user_lat <", value, "serviceUserLat");
            return (Criteria) this;
        }

        public Criteria andServiceUserLatLessThanOrEqualTo(Double value) {
            addCriterion("service_user_lat <=", value, "serviceUserLat");
            return (Criteria) this;
        }

        public Criteria andServiceUserLatIn(List<Double> values) {
            addCriterion("service_user_lat in", values, "serviceUserLat");
            return (Criteria) this;
        }

        public Criteria andServiceUserLatNotIn(List<Double> values) {
            addCriterion("service_user_lat not in", values, "serviceUserLat");
            return (Criteria) this;
        }

        public Criteria andServiceUserLatBetween(Double value1, Double value2) {
            addCriterion("service_user_lat between", value1, value2, "serviceUserLat");
            return (Criteria) this;
        }

        public Criteria andServiceUserLatNotBetween(Double value1, Double value2) {
            addCriterion("service_user_lat not between", value1, value2, "serviceUserLat");
            return (Criteria) this;
        }

        public Criteria andServiceUserLonIsNull() {
            addCriterion("service_user_lon is null");
            return (Criteria) this;
        }

        public Criteria andServiceUserLonIsNotNull() {
            addCriterion("service_user_lon is not null");
            return (Criteria) this;
        }

        public Criteria andServiceUserLonEqualTo(Double value) {
            addCriterion("service_user_lon =", value, "serviceUserLon");
            return (Criteria) this;
        }

        public Criteria andServiceUserLonNotEqualTo(Double value) {
            addCriterion("service_user_lon <>", value, "serviceUserLon");
            return (Criteria) this;
        }

        public Criteria andServiceUserLonGreaterThan(Double value) {
            addCriterion("service_user_lon >", value, "serviceUserLon");
            return (Criteria) this;
        }

        public Criteria andServiceUserLonGreaterThanOrEqualTo(Double value) {
            addCriterion("service_user_lon >=", value, "serviceUserLon");
            return (Criteria) this;
        }

        public Criteria andServiceUserLonLessThan(Double value) {
            addCriterion("service_user_lon <", value, "serviceUserLon");
            return (Criteria) this;
        }

        public Criteria andServiceUserLonLessThanOrEqualTo(Double value) {
            addCriterion("service_user_lon <=", value, "serviceUserLon");
            return (Criteria) this;
        }

        public Criteria andServiceUserLonIn(List<Double> values) {
            addCriterion("service_user_lon in", values, "serviceUserLon");
            return (Criteria) this;
        }

        public Criteria andServiceUserLonNotIn(List<Double> values) {
            addCriterion("service_user_lon not in", values, "serviceUserLon");
            return (Criteria) this;
        }

        public Criteria andServiceUserLonBetween(Double value1, Double value2) {
            addCriterion("service_user_lon between", value1, value2, "serviceUserLon");
            return (Criteria) this;
        }

        public Criteria andServiceUserLonNotBetween(Double value1, Double value2) {
            addCriterion("service_user_lon not between", value1, value2, "serviceUserLon");
            return (Criteria) this;
        }

        public Criteria andServiceTagNameIsNull() {
            addCriterion("service_tag_name is null");
            return (Criteria) this;
        }

        public Criteria andServiceTagNameIsNotNull() {
            addCriterion("service_tag_name is not null");
            return (Criteria) this;
        }

        public Criteria andServiceTagNameEqualTo(String value) {
            addCriterion("service_tag_name =", value, "serviceTagName");
            return (Criteria) this;
        }

        public Criteria andServiceTagNameNotEqualTo(String value) {
            addCriterion("service_tag_name <>", value, "serviceTagName");
            return (Criteria) this;
        }

        public Criteria andServiceTagNameGreaterThan(String value) {
            addCriterion("service_tag_name >", value, "serviceTagName");
            return (Criteria) this;
        }

        public Criteria andServiceTagNameGreaterThanOrEqualTo(String value) {
            addCriterion("service_tag_name >=", value, "serviceTagName");
            return (Criteria) this;
        }

        public Criteria andServiceTagNameLessThan(String value) {
            addCriterion("service_tag_name <", value, "serviceTagName");
            return (Criteria) this;
        }

        public Criteria andServiceTagNameLessThanOrEqualTo(String value) {
            addCriterion("service_tag_name <=", value, "serviceTagName");
            return (Criteria) this;
        }

        public Criteria andServiceTagNameLike(String value) {
            addCriterion("service_tag_name like", value, "serviceTagName");
            return (Criteria) this;
        }

        public Criteria andServiceTagNameNotLike(String value) {
            addCriterion("service_tag_name not like", value, "serviceTagName");
            return (Criteria) this;
        }

        public Criteria andServiceTagNameIn(List<String> values) {
            addCriterion("service_tag_name in", values, "serviceTagName");
            return (Criteria) this;
        }

        public Criteria andServiceTagNameNotIn(List<String> values) {
            addCriterion("service_tag_name not in", values, "serviceTagName");
            return (Criteria) this;
        }

        public Criteria andServiceTagNameBetween(String value1, String value2) {
            addCriterion("service_tag_name between", value1, value2, "serviceTagName");
            return (Criteria) this;
        }

        public Criteria andServiceTagNameNotBetween(String value1, String value2) {
            addCriterion("service_tag_name not between", value1, value2, "serviceTagName");
            return (Criteria) this;
        }

        public Criteria andServiceOrderNumberIsNull() {
            addCriterion("service_order_number is null");
            return (Criteria) this;
        }

        public Criteria andServiceOrderNumberIsNotNull() {
            addCriterion("service_order_number is not null");
            return (Criteria) this;
        }

        public Criteria andServiceOrderNumberEqualTo(String value) {
            addCriterion("service_order_number =", value, "serviceOrderNumber");
            return (Criteria) this;
        }

        public Criteria andServiceOrderNumberNotEqualTo(String value) {
            addCriterion("service_order_number <>", value, "serviceOrderNumber");
            return (Criteria) this;
        }

        public Criteria andServiceOrderNumberGreaterThan(String value) {
            addCriterion("service_order_number >", value, "serviceOrderNumber");
            return (Criteria) this;
        }

        public Criteria andServiceOrderNumberGreaterThanOrEqualTo(String value) {
            addCriterion("service_order_number >=", value, "serviceOrderNumber");
            return (Criteria) this;
        }

        public Criteria andServiceOrderNumberLessThan(String value) {
            addCriterion("service_order_number <", value, "serviceOrderNumber");
            return (Criteria) this;
        }

        public Criteria andServiceOrderNumberLessThanOrEqualTo(String value) {
            addCriterion("service_order_number <=", value, "serviceOrderNumber");
            return (Criteria) this;
        }

        public Criteria andServiceOrderNumberLike(String value) {
            addCriterion("service_order_number like", value, "serviceOrderNumber");
            return (Criteria) this;
        }

        public Criteria andServiceOrderNumberNotLike(String value) {
            addCriterion("service_order_number not like", value, "serviceOrderNumber");
            return (Criteria) this;
        }

        public Criteria andServiceOrderNumberIn(List<String> values) {
            addCriterion("service_order_number in", values, "serviceOrderNumber");
            return (Criteria) this;
        }

        public Criteria andServiceOrderNumberNotIn(List<String> values) {
            addCriterion("service_order_number not in", values, "serviceOrderNumber");
            return (Criteria) this;
        }

        public Criteria andServiceOrderNumberBetween(String value1, String value2) {
            addCriterion("service_order_number between", value1, value2, "serviceOrderNumber");
            return (Criteria) this;
        }

        public Criteria andServiceOrderNumberNotBetween(String value1, String value2) {
            addCriterion("service_order_number not between", value1, value2, "serviceOrderNumber");
            return (Criteria) this;
        }

        public Criteria andServiceOrderBespeakIsNull() {
            addCriterion("service_order_bespeak is null");
            return (Criteria) this;
        }

        public Criteria andServiceOrderBespeakIsNotNull() {
            addCriterion("service_order_bespeak is not null");
            return (Criteria) this;
        }

        public Criteria andServiceOrderBespeakEqualTo(Integer value) {
            addCriterion("service_order_bespeak =", value, "serviceOrderBespeak");
            return (Criteria) this;
        }

        public Criteria andServiceOrderBespeakNotEqualTo(Integer value) {
            addCriterion("service_order_bespeak <>", value, "serviceOrderBespeak");
            return (Criteria) this;
        }

        public Criteria andServiceOrderBespeakGreaterThan(Integer value) {
            addCriterion("service_order_bespeak >", value, "serviceOrderBespeak");
            return (Criteria) this;
        }

        public Criteria andServiceOrderBespeakGreaterThanOrEqualTo(Integer value) {
            addCriterion("service_order_bespeak >=", value, "serviceOrderBespeak");
            return (Criteria) this;
        }

        public Criteria andServiceOrderBespeakLessThan(Integer value) {
            addCriterion("service_order_bespeak <", value, "serviceOrderBespeak");
            return (Criteria) this;
        }

        public Criteria andServiceOrderBespeakLessThanOrEqualTo(Integer value) {
            addCriterion("service_order_bespeak <=", value, "serviceOrderBespeak");
            return (Criteria) this;
        }

        public Criteria andServiceOrderBespeakIn(List<Integer> values) {
            addCriterion("service_order_bespeak in", values, "serviceOrderBespeak");
            return (Criteria) this;
        }

        public Criteria andServiceOrderBespeakNotIn(List<Integer> values) {
            addCriterion("service_order_bespeak not in", values, "serviceOrderBespeak");
            return (Criteria) this;
        }

        public Criteria andServiceOrderBespeakBetween(Integer value1, Integer value2) {
            addCriterion("service_order_bespeak between", value1, value2, "serviceOrderBespeak");
            return (Criteria) this;
        }

        public Criteria andServiceOrderBespeakNotBetween(Integer value1, Integer value2) {
            addCriterion("service_order_bespeak not between", value1, value2, "serviceOrderBespeak");
            return (Criteria) this;
        }

        public Criteria andServiceOrderEffectTimeIsNull() {
            addCriterion("service_order_effect_time is null");
            return (Criteria) this;
        }

        public Criteria andServiceOrderEffectTimeIsNotNull() {
            addCriterion("service_order_effect_time is not null");
            return (Criteria) this;
        }

        public Criteria andServiceOrderEffectTimeEqualTo(Date value) {
            addCriterion("service_order_effect_time =", value, "serviceOrderEffectTime");
            return (Criteria) this;
        }

        public Criteria andServiceOrderEffectTimeNotEqualTo(Date value) {
            addCriterion("service_order_effect_time <>", value, "serviceOrderEffectTime");
            return (Criteria) this;
        }

        public Criteria andServiceOrderEffectTimeGreaterThan(Date value) {
            addCriterion("service_order_effect_time >", value, "serviceOrderEffectTime");
            return (Criteria) this;
        }

        public Criteria andServiceOrderEffectTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("service_order_effect_time >=", value, "serviceOrderEffectTime");
            return (Criteria) this;
        }

        public Criteria andServiceOrderEffectTimeLessThan(Date value) {
            addCriterion("service_order_effect_time <", value, "serviceOrderEffectTime");
            return (Criteria) this;
        }

        public Criteria andServiceOrderEffectTimeLessThanOrEqualTo(Date value) {
            addCriterion("service_order_effect_time <=", value, "serviceOrderEffectTime");
            return (Criteria) this;
        }

        public Criteria andServiceOrderEffectTimeIn(List<Date> values) {
            addCriterion("service_order_effect_time in", values, "serviceOrderEffectTime");
            return (Criteria) this;
        }

        public Criteria andServiceOrderEffectTimeNotIn(List<Date> values) {
            addCriterion("service_order_effect_time not in", values, "serviceOrderEffectTime");
            return (Criteria) this;
        }

        public Criteria andServiceOrderEffectTimeBetween(Date value1, Date value2) {
            addCriterion("service_order_effect_time between", value1, value2, "serviceOrderEffectTime");
            return (Criteria) this;
        }

        public Criteria andServiceOrderEffectTimeNotBetween(Date value1, Date value2) {
            addCriterion("service_order_effect_time not between", value1, value2, "serviceOrderEffectTime");
            return (Criteria) this;
        }

        public Criteria andServiceOrderSendUserIsNull() {
            addCriterion("service_order_send_user is null");
            return (Criteria) this;
        }

        public Criteria andServiceOrderSendUserIsNotNull() {
            addCriterion("service_order_send_user is not null");
            return (Criteria) this;
        }

        public Criteria andServiceOrderSendUserEqualTo(Integer value) {
            addCriterion("service_order_send_user =", value, "serviceOrderSendUser");
            return (Criteria) this;
        }

        public Criteria andServiceOrderSendUserNotEqualTo(Integer value) {
            addCriterion("service_order_send_user <>", value, "serviceOrderSendUser");
            return (Criteria) this;
        }

        public Criteria andServiceOrderSendUserGreaterThan(Integer value) {
            addCriterion("service_order_send_user >", value, "serviceOrderSendUser");
            return (Criteria) this;
        }

        public Criteria andServiceOrderSendUserGreaterThanOrEqualTo(Integer value) {
            addCriterion("service_order_send_user >=", value, "serviceOrderSendUser");
            return (Criteria) this;
        }

        public Criteria andServiceOrderSendUserLessThan(Integer value) {
            addCriterion("service_order_send_user <", value, "serviceOrderSendUser");
            return (Criteria) this;
        }

        public Criteria andServiceOrderSendUserLessThanOrEqualTo(Integer value) {
            addCriterion("service_order_send_user <=", value, "serviceOrderSendUser");
            return (Criteria) this;
        }

        public Criteria andServiceOrderSendUserIn(List<Integer> values) {
            addCriterion("service_order_send_user in", values, "serviceOrderSendUser");
            return (Criteria) this;
        }

        public Criteria andServiceOrderSendUserNotIn(List<Integer> values) {
            addCriterion("service_order_send_user not in", values, "serviceOrderSendUser");
            return (Criteria) this;
        }

        public Criteria andServiceOrderSendUserBetween(Integer value1, Integer value2) {
            addCriterion("service_order_send_user between", value1, value2, "serviceOrderSendUser");
            return (Criteria) this;
        }

        public Criteria andServiceOrderSendUserNotBetween(Integer value1, Integer value2) {
            addCriterion("service_order_send_user not between", value1, value2, "serviceOrderSendUser");
            return (Criteria) this;
        }

        public Criteria andServiceOrderReceiveUserIsNull() {
            addCriterion("service_order_receive_user is null");
            return (Criteria) this;
        }

        public Criteria andServiceOrderReceiveUserIsNotNull() {
            addCriterion("service_order_receive_user is not null");
            return (Criteria) this;
        }

        public Criteria andServiceOrderReceiveUserEqualTo(Integer value) {
            addCriterion("service_order_receive_user =", value, "serviceOrderReceiveUser");
            return (Criteria) this;
        }

        public Criteria andServiceOrderReceiveUserNotEqualTo(Integer value) {
            addCriterion("service_order_receive_user <>", value, "serviceOrderReceiveUser");
            return (Criteria) this;
        }

        public Criteria andServiceOrderReceiveUserGreaterThan(Integer value) {
            addCriterion("service_order_receive_user >", value, "serviceOrderReceiveUser");
            return (Criteria) this;
        }

        public Criteria andServiceOrderReceiveUserGreaterThanOrEqualTo(Integer value) {
            addCriterion("service_order_receive_user >=", value, "serviceOrderReceiveUser");
            return (Criteria) this;
        }

        public Criteria andServiceOrderReceiveUserLessThan(Integer value) {
            addCriterion("service_order_receive_user <", value, "serviceOrderReceiveUser");
            return (Criteria) this;
        }

        public Criteria andServiceOrderReceiveUserLessThanOrEqualTo(Integer value) {
            addCriterion("service_order_receive_user <=", value, "serviceOrderReceiveUser");
            return (Criteria) this;
        }

        public Criteria andServiceOrderReceiveUserIn(List<Integer> values) {
            addCriterion("service_order_receive_user in", values, "serviceOrderReceiveUser");
            return (Criteria) this;
        }

        public Criteria andServiceOrderReceiveUserNotIn(List<Integer> values) {
            addCriterion("service_order_receive_user not in", values, "serviceOrderReceiveUser");
            return (Criteria) this;
        }

        public Criteria andServiceOrderReceiveUserBetween(Integer value1, Integer value2) {
            addCriterion("service_order_receive_user between", value1, value2, "serviceOrderReceiveUser");
            return (Criteria) this;
        }

        public Criteria andServiceOrderReceiveUserNotBetween(Integer value1, Integer value2) {
            addCriterion("service_order_receive_user not between", value1, value2, "serviceOrderReceiveUser");
            return (Criteria) this;
        }

        public Criteria andServiceOrderTypeIsNull() {
            addCriterion("service_order_type is null");
            return (Criteria) this;
        }

        public Criteria andServiceOrderTypeIsNotNull() {
            addCriterion("service_order_type is not null");
            return (Criteria) this;
        }

        public Criteria andServiceOrderTypeEqualTo(Integer value) {
            addCriterion("service_order_type =", value, "serviceOrderType");
            return (Criteria) this;
        }

        public Criteria andServiceOrderTypeNotEqualTo(Integer value) {
            addCriterion("service_order_type <>", value, "serviceOrderType");
            return (Criteria) this;
        }

        public Criteria andServiceOrderTypeGreaterThan(Integer value) {
            addCriterion("service_order_type >", value, "serviceOrderType");
            return (Criteria) this;
        }

        public Criteria andServiceOrderTypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("service_order_type >=", value, "serviceOrderType");
            return (Criteria) this;
        }

        public Criteria andServiceOrderTypeLessThan(Integer value) {
            addCriterion("service_order_type <", value, "serviceOrderType");
            return (Criteria) this;
        }

        public Criteria andServiceOrderTypeLessThanOrEqualTo(Integer value) {
            addCriterion("service_order_type <=", value, "serviceOrderType");
            return (Criteria) this;
        }

        public Criteria andServiceOrderTypeIn(List<Integer> values) {
            addCriterion("service_order_type in", values, "serviceOrderType");
            return (Criteria) this;
        }

        public Criteria andServiceOrderTypeNotIn(List<Integer> values) {
            addCriterion("service_order_type not in", values, "serviceOrderType");
            return (Criteria) this;
        }

        public Criteria andServiceOrderTypeBetween(Integer value1, Integer value2) {
            addCriterion("service_order_type between", value1, value2, "serviceOrderType");
            return (Criteria) this;
        }

        public Criteria andServiceOrderTypeNotBetween(Integer value1, Integer value2) {
            addCriterion("service_order_type not between", value1, value2, "serviceOrderType");
            return (Criteria) this;
        }

        public Criteria andServiceOrderSmallTypeIsNull() {
            addCriterion("service_order_small_type is null");
            return (Criteria) this;
        }

        public Criteria andServiceOrderSmallTypeIsNotNull() {
            addCriterion("service_order_small_type is not null");
            return (Criteria) this;
        }

        public Criteria andServiceOrderSmallTypeEqualTo(Integer value) {
            addCriterion("service_order_small_type =", value, "serviceOrderSmallType");
            return (Criteria) this;
        }

        public Criteria andServiceOrderSmallTypeNotEqualTo(Integer value) {
            addCriterion("service_order_small_type <>", value, "serviceOrderSmallType");
            return (Criteria) this;
        }

        public Criteria andServiceOrderSmallTypeGreaterThan(Integer value) {
            addCriterion("service_order_small_type >", value, "serviceOrderSmallType");
            return (Criteria) this;
        }

        public Criteria andServiceOrderSmallTypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("service_order_small_type >=", value, "serviceOrderSmallType");
            return (Criteria) this;
        }

        public Criteria andServiceOrderSmallTypeLessThan(Integer value) {
            addCriterion("service_order_small_type <", value, "serviceOrderSmallType");
            return (Criteria) this;
        }

        public Criteria andServiceOrderSmallTypeLessThanOrEqualTo(Integer value) {
            addCriterion("service_order_small_type <=", value, "serviceOrderSmallType");
            return (Criteria) this;
        }

        public Criteria andServiceOrderSmallTypeIn(List<Integer> values) {
            addCriterion("service_order_small_type in", values, "serviceOrderSmallType");
            return (Criteria) this;
        }

        public Criteria andServiceOrderSmallTypeNotIn(List<Integer> values) {
            addCriterion("service_order_small_type not in", values, "serviceOrderSmallType");
            return (Criteria) this;
        }

        public Criteria andServiceOrderSmallTypeBetween(Integer value1, Integer value2) {
            addCriterion("service_order_small_type between", value1, value2, "serviceOrderSmallType");
            return (Criteria) this;
        }

        public Criteria andServiceOrderSmallTypeNotBetween(Integer value1, Integer value2) {
            addCriterion("service_order_small_type not between", value1, value2, "serviceOrderSmallType");
            return (Criteria) this;
        }

        public Criteria andServiceOrderTitleIsNull() {
            addCriterion("service_order_title is null");
            return (Criteria) this;
        }

        public Criteria andServiceOrderTitleIsNotNull() {
            addCriterion("service_order_title is not null");
            return (Criteria) this;
        }

        public Criteria andServiceOrderTitleEqualTo(String value) {
            addCriterion("service_order_title =", value, "serviceOrderTitle");
            return (Criteria) this;
        }

        public Criteria andServiceOrderTitleNotEqualTo(String value) {
            addCriterion("service_order_title <>", value, "serviceOrderTitle");
            return (Criteria) this;
        }

        public Criteria andServiceOrderTitleGreaterThan(String value) {
            addCriterion("service_order_title >", value, "serviceOrderTitle");
            return (Criteria) this;
        }

        public Criteria andServiceOrderTitleGreaterThanOrEqualTo(String value) {
            addCriterion("service_order_title >=", value, "serviceOrderTitle");
            return (Criteria) this;
        }

        public Criteria andServiceOrderTitleLessThan(String value) {
            addCriterion("service_order_title <", value, "serviceOrderTitle");
            return (Criteria) this;
        }

        public Criteria andServiceOrderTitleLessThanOrEqualTo(String value) {
            addCriterion("service_order_title <=", value, "serviceOrderTitle");
            return (Criteria) this;
        }

        public Criteria andServiceOrderTitleLike(String value) {
            addCriterion("service_order_title like", value, "serviceOrderTitle");
            return (Criteria) this;
        }

        public Criteria andServiceOrderTitleNotLike(String value) {
            addCriterion("service_order_title not like", value, "serviceOrderTitle");
            return (Criteria) this;
        }

        public Criteria andServiceOrderTitleIn(List<String> values) {
            addCriterion("service_order_title in", values, "serviceOrderTitle");
            return (Criteria) this;
        }

        public Criteria andServiceOrderTitleNotIn(List<String> values) {
            addCriterion("service_order_title not in", values, "serviceOrderTitle");
            return (Criteria) this;
        }

        public Criteria andServiceOrderTitleBetween(String value1, String value2) {
            addCriterion("service_order_title between", value1, value2, "serviceOrderTitle");
            return (Criteria) this;
        }

        public Criteria andServiceOrderTitleNotBetween(String value1, String value2) {
            addCriterion("service_order_title not between", value1, value2, "serviceOrderTitle");
            return (Criteria) this;
        }

        public Criteria andServiceOrderContentIsNull() {
            addCriterion("service_order_content is null");
            return (Criteria) this;
        }

        public Criteria andServiceOrderContentIsNotNull() {
            addCriterion("service_order_content is not null");
            return (Criteria) this;
        }

        public Criteria andServiceOrderContentEqualTo(String value) {
            addCriterion("service_order_content =", value, "serviceOrderContent");
            return (Criteria) this;
        }

        public Criteria andServiceOrderContentNotEqualTo(String value) {
            addCriterion("service_order_content <>", value, "serviceOrderContent");
            return (Criteria) this;
        }

        public Criteria andServiceOrderContentGreaterThan(String value) {
            addCriterion("service_order_content >", value, "serviceOrderContent");
            return (Criteria) this;
        }

        public Criteria andServiceOrderContentGreaterThanOrEqualTo(String value) {
            addCriterion("service_order_content >=", value, "serviceOrderContent");
            return (Criteria) this;
        }

        public Criteria andServiceOrderContentLessThan(String value) {
            addCriterion("service_order_content <", value, "serviceOrderContent");
            return (Criteria) this;
        }

        public Criteria andServiceOrderContentLessThanOrEqualTo(String value) {
            addCriterion("service_order_content <=", value, "serviceOrderContent");
            return (Criteria) this;
        }

        public Criteria andServiceOrderContentLike(String value) {
            addCriterion("service_order_content like", value, "serviceOrderContent");
            return (Criteria) this;
        }

        public Criteria andServiceOrderContentNotLike(String value) {
            addCriterion("service_order_content not like", value, "serviceOrderContent");
            return (Criteria) this;
        }

        public Criteria andServiceOrderContentIn(List<String> values) {
            addCriterion("service_order_content in", values, "serviceOrderContent");
            return (Criteria) this;
        }

        public Criteria andServiceOrderContentNotIn(List<String> values) {
            addCriterion("service_order_content not in", values, "serviceOrderContent");
            return (Criteria) this;
        }

        public Criteria andServiceOrderContentBetween(String value1, String value2) {
            addCriterion("service_order_content between", value1, value2, "serviceOrderContent");
            return (Criteria) this;
        }

        public Criteria andServiceOrderContentNotBetween(String value1, String value2) {
            addCriterion("service_order_content not between", value1, value2, "serviceOrderContent");
            return (Criteria) this;
        }

        public Criteria andServiceOrderStartAmountIsNull() {
            addCriterion("service_order_start_amount is null");
            return (Criteria) this;
        }

        public Criteria andServiceOrderStartAmountIsNotNull() {
            addCriterion("service_order_start_amount is not null");
            return (Criteria) this;
        }

        public Criteria andServiceOrderStartAmountEqualTo(Integer value) {
            addCriterion("service_order_start_amount =", value, "serviceOrderStartAmount");
            return (Criteria) this;
        }

        public Criteria andServiceOrderStartAmountNotEqualTo(Integer value) {
            addCriterion("service_order_start_amount <>", value, "serviceOrderStartAmount");
            return (Criteria) this;
        }

        public Criteria andServiceOrderStartAmountGreaterThan(Integer value) {
            addCriterion("service_order_start_amount >", value, "serviceOrderStartAmount");
            return (Criteria) this;
        }

        public Criteria andServiceOrderStartAmountGreaterThanOrEqualTo(Integer value) {
            addCriterion("service_order_start_amount >=", value, "serviceOrderStartAmount");
            return (Criteria) this;
        }

        public Criteria andServiceOrderStartAmountLessThan(Integer value) {
            addCriterion("service_order_start_amount <", value, "serviceOrderStartAmount");
            return (Criteria) this;
        }

        public Criteria andServiceOrderStartAmountLessThanOrEqualTo(Integer value) {
            addCriterion("service_order_start_amount <=", value, "serviceOrderStartAmount");
            return (Criteria) this;
        }

        public Criteria andServiceOrderStartAmountIn(List<Integer> values) {
            addCriterion("service_order_start_amount in", values, "serviceOrderStartAmount");
            return (Criteria) this;
        }

        public Criteria andServiceOrderStartAmountNotIn(List<Integer> values) {
            addCriterion("service_order_start_amount not in", values, "serviceOrderStartAmount");
            return (Criteria) this;
        }

        public Criteria andServiceOrderStartAmountBetween(Integer value1, Integer value2) {
            addCriterion("service_order_start_amount between", value1, value2, "serviceOrderStartAmount");
            return (Criteria) this;
        }

        public Criteria andServiceOrderStartAmountNotBetween(Integer value1, Integer value2) {
            addCriterion("service_order_start_amount not between", value1, value2, "serviceOrderStartAmount");
            return (Criteria) this;
        }

        public Criteria andServiceOrderDistanceAmountIsNull() {
            addCriterion("service_order_distance_amount is null");
            return (Criteria) this;
        }

        public Criteria andServiceOrderDistanceAmountIsNotNull() {
            addCriterion("service_order_distance_amount is not null");
            return (Criteria) this;
        }

        public Criteria andServiceOrderDistanceAmountEqualTo(Integer value) {
            addCriterion("service_order_distance_amount =", value, "serviceOrderDistanceAmount");
            return (Criteria) this;
        }

        public Criteria andServiceOrderDistanceAmountNotEqualTo(Integer value) {
            addCriterion("service_order_distance_amount <>", value, "serviceOrderDistanceAmount");
            return (Criteria) this;
        }

        public Criteria andServiceOrderDistanceAmountGreaterThan(Integer value) {
            addCriterion("service_order_distance_amount >", value, "serviceOrderDistanceAmount");
            return (Criteria) this;
        }

        public Criteria andServiceOrderDistanceAmountGreaterThanOrEqualTo(Integer value) {
            addCriterion("service_order_distance_amount >=", value, "serviceOrderDistanceAmount");
            return (Criteria) this;
        }

        public Criteria andServiceOrderDistanceAmountLessThan(Integer value) {
            addCriterion("service_order_distance_amount <", value, "serviceOrderDistanceAmount");
            return (Criteria) this;
        }

        public Criteria andServiceOrderDistanceAmountLessThanOrEqualTo(Integer value) {
            addCriterion("service_order_distance_amount <=", value, "serviceOrderDistanceAmount");
            return (Criteria) this;
        }

        public Criteria andServiceOrderDistanceAmountIn(List<Integer> values) {
            addCriterion("service_order_distance_amount in", values, "serviceOrderDistanceAmount");
            return (Criteria) this;
        }

        public Criteria andServiceOrderDistanceAmountNotIn(List<Integer> values) {
            addCriterion("service_order_distance_amount not in", values, "serviceOrderDistanceAmount");
            return (Criteria) this;
        }

        public Criteria andServiceOrderDistanceAmountBetween(Integer value1, Integer value2) {
            addCriterion("service_order_distance_amount between", value1, value2, "serviceOrderDistanceAmount");
            return (Criteria) this;
        }

        public Criteria andServiceOrderDistanceAmountNotBetween(Integer value1, Integer value2) {
            addCriterion("service_order_distance_amount not between", value1, value2, "serviceOrderDistanceAmount");
            return (Criteria) this;
        }

        public Criteria andServiceOrderWeightAmountIsNull() {
            addCriterion("service_order_weight_amount is null");
            return (Criteria) this;
        }

        public Criteria andServiceOrderWeightAmountIsNotNull() {
            addCriterion("service_order_weight_amount is not null");
            return (Criteria) this;
        }

        public Criteria andServiceOrderWeightAmountEqualTo(Integer value) {
            addCriterion("service_order_weight_amount =", value, "serviceOrderWeightAmount");
            return (Criteria) this;
        }

        public Criteria andServiceOrderWeightAmountNotEqualTo(Integer value) {
            addCriterion("service_order_weight_amount <>", value, "serviceOrderWeightAmount");
            return (Criteria) this;
        }

        public Criteria andServiceOrderWeightAmountGreaterThan(Integer value) {
            addCriterion("service_order_weight_amount >", value, "serviceOrderWeightAmount");
            return (Criteria) this;
        }

        public Criteria andServiceOrderWeightAmountGreaterThanOrEqualTo(Integer value) {
            addCriterion("service_order_weight_amount >=", value, "serviceOrderWeightAmount");
            return (Criteria) this;
        }

        public Criteria andServiceOrderWeightAmountLessThan(Integer value) {
            addCriterion("service_order_weight_amount <", value, "serviceOrderWeightAmount");
            return (Criteria) this;
        }

        public Criteria andServiceOrderWeightAmountLessThanOrEqualTo(Integer value) {
            addCriterion("service_order_weight_amount <=", value, "serviceOrderWeightAmount");
            return (Criteria) this;
        }

        public Criteria andServiceOrderWeightAmountIn(List<Integer> values) {
            addCriterion("service_order_weight_amount in", values, "serviceOrderWeightAmount");
            return (Criteria) this;
        }

        public Criteria andServiceOrderWeightAmountNotIn(List<Integer> values) {
            addCriterion("service_order_weight_amount not in", values, "serviceOrderWeightAmount");
            return (Criteria) this;
        }

        public Criteria andServiceOrderWeightAmountBetween(Integer value1, Integer value2) {
            addCriterion("service_order_weight_amount between", value1, value2, "serviceOrderWeightAmount");
            return (Criteria) this;
        }

        public Criteria andServiceOrderWeightAmountNotBetween(Integer value1, Integer value2) {
            addCriterion("service_order_weight_amount not between", value1, value2, "serviceOrderWeightAmount");
            return (Criteria) this;
        }

        public Criteria andServiceOrderAttachAmountIsNull() {
            addCriterion("service_order_attach_amount is null");
            return (Criteria) this;
        }

        public Criteria andServiceOrderAttachAmountIsNotNull() {
            addCriterion("service_order_attach_amount is not null");
            return (Criteria) this;
        }

        public Criteria andServiceOrderAttachAmountEqualTo(Integer value) {
            addCriterion("service_order_attach_amount =", value, "serviceOrderAttachAmount");
            return (Criteria) this;
        }

        public Criteria andServiceOrderAttachAmountNotEqualTo(Integer value) {
            addCriterion("service_order_attach_amount <>", value, "serviceOrderAttachAmount");
            return (Criteria) this;
        }

        public Criteria andServiceOrderAttachAmountGreaterThan(Integer value) {
            addCriterion("service_order_attach_amount >", value, "serviceOrderAttachAmount");
            return (Criteria) this;
        }

        public Criteria andServiceOrderAttachAmountGreaterThanOrEqualTo(Integer value) {
            addCriterion("service_order_attach_amount >=", value, "serviceOrderAttachAmount");
            return (Criteria) this;
        }

        public Criteria andServiceOrderAttachAmountLessThan(Integer value) {
            addCriterion("service_order_attach_amount <", value, "serviceOrderAttachAmount");
            return (Criteria) this;
        }

        public Criteria andServiceOrderAttachAmountLessThanOrEqualTo(Integer value) {
            addCriterion("service_order_attach_amount <=", value, "serviceOrderAttachAmount");
            return (Criteria) this;
        }

        public Criteria andServiceOrderAttachAmountIn(List<Integer> values) {
            addCriterion("service_order_attach_amount in", values, "serviceOrderAttachAmount");
            return (Criteria) this;
        }

        public Criteria andServiceOrderAttachAmountNotIn(List<Integer> values) {
            addCriterion("service_order_attach_amount not in", values, "serviceOrderAttachAmount");
            return (Criteria) this;
        }

        public Criteria andServiceOrderAttachAmountBetween(Integer value1, Integer value2) {
            addCriterion("service_order_attach_amount between", value1, value2, "serviceOrderAttachAmount");
            return (Criteria) this;
        }

        public Criteria andServiceOrderAttachAmountNotBetween(Integer value1, Integer value2) {
            addCriterion("service_order_attach_amount not between", value1, value2, "serviceOrderAttachAmount");
            return (Criteria) this;
        }

        public Criteria andServiceOrderAmountIsNull() {
            addCriterion("service_order_amount is null");
            return (Criteria) this;
        }

        public Criteria andServiceOrderAmountIsNotNull() {
            addCriterion("service_order_amount is not null");
            return (Criteria) this;
        }

        public Criteria andServiceOrderAmountEqualTo(Integer value) {
            addCriterion("service_order_amount =", value, "serviceOrderAmount");
            return (Criteria) this;
        }

        public Criteria andServiceOrderAmountNotEqualTo(Integer value) {
            addCriterion("service_order_amount <>", value, "serviceOrderAmount");
            return (Criteria) this;
        }

        public Criteria andServiceOrderAmountGreaterThan(Integer value) {
            addCriterion("service_order_amount >", value, "serviceOrderAmount");
            return (Criteria) this;
        }

        public Criteria andServiceOrderAmountGreaterThanOrEqualTo(Integer value) {
            addCriterion("service_order_amount >=", value, "serviceOrderAmount");
            return (Criteria) this;
        }

        public Criteria andServiceOrderAmountLessThan(Integer value) {
            addCriterion("service_order_amount <", value, "serviceOrderAmount");
            return (Criteria) this;
        }

        public Criteria andServiceOrderAmountLessThanOrEqualTo(Integer value) {
            addCriterion("service_order_amount <=", value, "serviceOrderAmount");
            return (Criteria) this;
        }

        public Criteria andServiceOrderAmountIn(List<Integer> values) {
            addCriterion("service_order_amount in", values, "serviceOrderAmount");
            return (Criteria) this;
        }

        public Criteria andServiceOrderAmountNotIn(List<Integer> values) {
            addCriterion("service_order_amount not in", values, "serviceOrderAmount");
            return (Criteria) this;
        }

        public Criteria andServiceOrderAmountBetween(Integer value1, Integer value2) {
            addCriterion("service_order_amount between", value1, value2, "serviceOrderAmount");
            return (Criteria) this;
        }

        public Criteria andServiceOrderAmountNotBetween(Integer value1, Integer value2) {
            addCriterion("service_order_amount not between", value1, value2, "serviceOrderAmount");
            return (Criteria) this;
        }

        public Criteria andServiceOrderGoodAmountIsNull() {
            addCriterion("service_order_good_amount is null");
            return (Criteria) this;
        }

        public Criteria andServiceOrderGoodAmountIsNotNull() {
            addCriterion("service_order_good_amount is not null");
            return (Criteria) this;
        }

        public Criteria andServiceOrderGoodAmountEqualTo(Integer value) {
            addCriterion("service_order_good_amount =", value, "serviceOrderGoodAmount");
            return (Criteria) this;
        }

        public Criteria andServiceOrderGoodAmountNotEqualTo(Integer value) {
            addCriterion("service_order_good_amount <>", value, "serviceOrderGoodAmount");
            return (Criteria) this;
        }

        public Criteria andServiceOrderGoodAmountGreaterThan(Integer value) {
            addCriterion("service_order_good_amount >", value, "serviceOrderGoodAmount");
            return (Criteria) this;
        }

        public Criteria andServiceOrderGoodAmountGreaterThanOrEqualTo(Integer value) {
            addCriterion("service_order_good_amount >=", value, "serviceOrderGoodAmount");
            return (Criteria) this;
        }

        public Criteria andServiceOrderGoodAmountLessThan(Integer value) {
            addCriterion("service_order_good_amount <", value, "serviceOrderGoodAmount");
            return (Criteria) this;
        }

        public Criteria andServiceOrderGoodAmountLessThanOrEqualTo(Integer value) {
            addCriterion("service_order_good_amount <=", value, "serviceOrderGoodAmount");
            return (Criteria) this;
        }

        public Criteria andServiceOrderGoodAmountIn(List<Integer> values) {
            addCriterion("service_order_good_amount in", values, "serviceOrderGoodAmount");
            return (Criteria) this;
        }

        public Criteria andServiceOrderGoodAmountNotIn(List<Integer> values) {
            addCriterion("service_order_good_amount not in", values, "serviceOrderGoodAmount");
            return (Criteria) this;
        }

        public Criteria andServiceOrderGoodAmountBetween(Integer value1, Integer value2) {
            addCriterion("service_order_good_amount between", value1, value2, "serviceOrderGoodAmount");
            return (Criteria) this;
        }

        public Criteria andServiceOrderGoodAmountNotBetween(Integer value1, Integer value2) {
            addCriterion("service_order_good_amount not between", value1, value2, "serviceOrderGoodAmount");
            return (Criteria) this;
        }

        public Criteria andServiceOrderPayAmountIsNull() {
            addCriterion("service_order_pay_amount is null");
            return (Criteria) this;
        }

        public Criteria andServiceOrderPayAmountIsNotNull() {
            addCriterion("service_order_pay_amount is not null");
            return (Criteria) this;
        }

        public Criteria andServiceOrderPayAmountEqualTo(Integer value) {
            addCriterion("service_order_pay_amount =", value, "serviceOrderPayAmount");
            return (Criteria) this;
        }

        public Criteria andServiceOrderPayAmountNotEqualTo(Integer value) {
            addCriterion("service_order_pay_amount <>", value, "serviceOrderPayAmount");
            return (Criteria) this;
        }

        public Criteria andServiceOrderPayAmountGreaterThan(Integer value) {
            addCriterion("service_order_pay_amount >", value, "serviceOrderPayAmount");
            return (Criteria) this;
        }

        public Criteria andServiceOrderPayAmountGreaterThanOrEqualTo(Integer value) {
            addCriterion("service_order_pay_amount >=", value, "serviceOrderPayAmount");
            return (Criteria) this;
        }

        public Criteria andServiceOrderPayAmountLessThan(Integer value) {
            addCriterion("service_order_pay_amount <", value, "serviceOrderPayAmount");
            return (Criteria) this;
        }

        public Criteria andServiceOrderPayAmountLessThanOrEqualTo(Integer value) {
            addCriterion("service_order_pay_amount <=", value, "serviceOrderPayAmount");
            return (Criteria) this;
        }

        public Criteria andServiceOrderPayAmountIn(List<Integer> values) {
            addCriterion("service_order_pay_amount in", values, "serviceOrderPayAmount");
            return (Criteria) this;
        }

        public Criteria andServiceOrderPayAmountNotIn(List<Integer> values) {
            addCriterion("service_order_pay_amount not in", values, "serviceOrderPayAmount");
            return (Criteria) this;
        }

        public Criteria andServiceOrderPayAmountBetween(Integer value1, Integer value2) {
            addCriterion("service_order_pay_amount between", value1, value2, "serviceOrderPayAmount");
            return (Criteria) this;
        }

        public Criteria andServiceOrderPayAmountNotBetween(Integer value1, Integer value2) {
            addCriterion("service_order_pay_amount not between", value1, value2, "serviceOrderPayAmount");
            return (Criteria) this;
        }

        public Criteria andServiceOrderStateIsNull() {
            addCriterion("service_order_state is null");
            return (Criteria) this;
        }

        public Criteria andServiceOrderStateIsNotNull() {
            addCriterion("service_order_state is not null");
            return (Criteria) this;
        }

        public Criteria andServiceOrderStateEqualTo(Integer value) {
            addCriterion("service_order_state =", value, "serviceOrderState");
            return (Criteria) this;
        }

        public Criteria andServiceOrderStateNotEqualTo(Integer value) {
            addCriterion("service_order_state <>", value, "serviceOrderState");
            return (Criteria) this;
        }

        public Criteria andServiceOrderStateGreaterThan(Integer value) {
            addCriterion("service_order_state >", value, "serviceOrderState");
            return (Criteria) this;
        }

        public Criteria andServiceOrderStateGreaterThanOrEqualTo(Integer value) {
            addCriterion("service_order_state >=", value, "serviceOrderState");
            return (Criteria) this;
        }

        public Criteria andServiceOrderStateLessThan(Integer value) {
            addCriterion("service_order_state <", value, "serviceOrderState");
            return (Criteria) this;
        }

        public Criteria andServiceOrderStateLessThanOrEqualTo(Integer value) {
            addCriterion("service_order_state <=", value, "serviceOrderState");
            return (Criteria) this;
        }

        public Criteria andServiceOrderStateIn(List<Integer> values) {
            addCriterion("service_order_state in", values, "serviceOrderState");
            return (Criteria) this;
        }

        public Criteria andServiceOrderStateNotIn(List<Integer> values) {
            addCriterion("service_order_state not in", values, "serviceOrderState");
            return (Criteria) this;
        }

        public Criteria andServiceOrderStateBetween(Integer value1, Integer value2) {
            addCriterion("service_order_state between", value1, value2, "serviceOrderState");
            return (Criteria) this;
        }

        public Criteria andServiceOrderStateNotBetween(Integer value1, Integer value2) {
            addCriterion("service_order_state not between", value1, value2, "serviceOrderState");
            return (Criteria) this;
        }

        public Criteria andServiceOrderRemarkIsNull() {
            addCriterion("service_order_remark is null");
            return (Criteria) this;
        }

        public Criteria andServiceOrderRemarkIsNotNull() {
            addCriterion("service_order_remark is not null");
            return (Criteria) this;
        }

        public Criteria andServiceOrderRemarkEqualTo(String value) {
            addCriterion("service_order_remark =", value, "serviceOrderRemark");
            return (Criteria) this;
        }

        public Criteria andServiceOrderRemarkNotEqualTo(String value) {
            addCriterion("service_order_remark <>", value, "serviceOrderRemark");
            return (Criteria) this;
        }

        public Criteria andServiceOrderRemarkGreaterThan(String value) {
            addCriterion("service_order_remark >", value, "serviceOrderRemark");
            return (Criteria) this;
        }

        public Criteria andServiceOrderRemarkGreaterThanOrEqualTo(String value) {
            addCriterion("service_order_remark >=", value, "serviceOrderRemark");
            return (Criteria) this;
        }

        public Criteria andServiceOrderRemarkLessThan(String value) {
            addCriterion("service_order_remark <", value, "serviceOrderRemark");
            return (Criteria) this;
        }

        public Criteria andServiceOrderRemarkLessThanOrEqualTo(String value) {
            addCriterion("service_order_remark <=", value, "serviceOrderRemark");
            return (Criteria) this;
        }

        public Criteria andServiceOrderRemarkLike(String value) {
            addCriterion("service_order_remark like", value, "serviceOrderRemark");
            return (Criteria) this;
        }

        public Criteria andServiceOrderRemarkNotLike(String value) {
            addCriterion("service_order_remark not like", value, "serviceOrderRemark");
            return (Criteria) this;
        }

        public Criteria andServiceOrderRemarkIn(List<String> values) {
            addCriterion("service_order_remark in", values, "serviceOrderRemark");
            return (Criteria) this;
        }

        public Criteria andServiceOrderRemarkNotIn(List<String> values) {
            addCriterion("service_order_remark not in", values, "serviceOrderRemark");
            return (Criteria) this;
        }

        public Criteria andServiceOrderRemarkBetween(String value1, String value2) {
            addCriterion("service_order_remark between", value1, value2, "serviceOrderRemark");
            return (Criteria) this;
        }

        public Criteria andServiceOrderRemarkNotBetween(String value1, String value2) {
            addCriterion("service_order_remark not between", value1, value2, "serviceOrderRemark");
            return (Criteria) this;
        }

        public Criteria andServiceOrderDeliveryContactNameIsNull() {
            addCriterion("service_order_delivery_contact_name is null");
            return (Criteria) this;
        }

        public Criteria andServiceOrderDeliveryContactNameIsNotNull() {
            addCriterion("service_order_delivery_contact_name is not null");
            return (Criteria) this;
        }

        public Criteria andServiceOrderDeliveryContactNameEqualTo(String value) {
            addCriterion("service_order_delivery_contact_name =", value, "serviceOrderDeliveryContactName");
            return (Criteria) this;
        }

        public Criteria andServiceOrderDeliveryContactNameNotEqualTo(String value) {
            addCriterion("service_order_delivery_contact_name <>", value, "serviceOrderDeliveryContactName");
            return (Criteria) this;
        }

        public Criteria andServiceOrderDeliveryContactNameGreaterThan(String value) {
            addCriterion("service_order_delivery_contact_name >", value, "serviceOrderDeliveryContactName");
            return (Criteria) this;
        }

        public Criteria andServiceOrderDeliveryContactNameGreaterThanOrEqualTo(String value) {
            addCriterion("service_order_delivery_contact_name >=", value, "serviceOrderDeliveryContactName");
            return (Criteria) this;
        }

        public Criteria andServiceOrderDeliveryContactNameLessThan(String value) {
            addCriterion("service_order_delivery_contact_name <", value, "serviceOrderDeliveryContactName");
            return (Criteria) this;
        }

        public Criteria andServiceOrderDeliveryContactNameLessThanOrEqualTo(String value) {
            addCriterion("service_order_delivery_contact_name <=", value, "serviceOrderDeliveryContactName");
            return (Criteria) this;
        }

        public Criteria andServiceOrderDeliveryContactNameLike(String value) {
            addCriterion("service_order_delivery_contact_name like", value, "serviceOrderDeliveryContactName");
            return (Criteria) this;
        }

        public Criteria andServiceOrderDeliveryContactNameNotLike(String value) {
            addCriterion("service_order_delivery_contact_name not like", value, "serviceOrderDeliveryContactName");
            return (Criteria) this;
        }

        public Criteria andServiceOrderDeliveryContactNameIn(List<String> values) {
            addCriterion("service_order_delivery_contact_name in", values, "serviceOrderDeliveryContactName");
            return (Criteria) this;
        }

        public Criteria andServiceOrderDeliveryContactNameNotIn(List<String> values) {
            addCriterion("service_order_delivery_contact_name not in", values, "serviceOrderDeliveryContactName");
            return (Criteria) this;
        }

        public Criteria andServiceOrderDeliveryContactNameBetween(String value1, String value2) {
            addCriterion("service_order_delivery_contact_name between", value1, value2, "serviceOrderDeliveryContactName");
            return (Criteria) this;
        }

        public Criteria andServiceOrderDeliveryContactNameNotBetween(String value1, String value2) {
            addCriterion("service_order_delivery_contact_name not between", value1, value2, "serviceOrderDeliveryContactName");
            return (Criteria) this;
        }

        public Criteria andServiceOrderDeliveryAddressIsNull() {
            addCriterion("service_order_delivery_address is null");
            return (Criteria) this;
        }

        public Criteria andServiceOrderDeliveryAddressIsNotNull() {
            addCriterion("service_order_delivery_address is not null");
            return (Criteria) this;
        }

        public Criteria andServiceOrderDeliveryAddressEqualTo(String value) {
            addCriterion("service_order_delivery_address =", value, "serviceOrderDeliveryAddress");
            return (Criteria) this;
        }

        public Criteria andServiceOrderDeliveryAddressNotEqualTo(String value) {
            addCriterion("service_order_delivery_address <>", value, "serviceOrderDeliveryAddress");
            return (Criteria) this;
        }

        public Criteria andServiceOrderDeliveryAddressGreaterThan(String value) {
            addCriterion("service_order_delivery_address >", value, "serviceOrderDeliveryAddress");
            return (Criteria) this;
        }

        public Criteria andServiceOrderDeliveryAddressGreaterThanOrEqualTo(String value) {
            addCriterion("service_order_delivery_address >=", value, "serviceOrderDeliveryAddress");
            return (Criteria) this;
        }

        public Criteria andServiceOrderDeliveryAddressLessThan(String value) {
            addCriterion("service_order_delivery_address <", value, "serviceOrderDeliveryAddress");
            return (Criteria) this;
        }

        public Criteria andServiceOrderDeliveryAddressLessThanOrEqualTo(String value) {
            addCriterion("service_order_delivery_address <=", value, "serviceOrderDeliveryAddress");
            return (Criteria) this;
        }

        public Criteria andServiceOrderDeliveryAddressLike(String value) {
            addCriterion("service_order_delivery_address like", value, "serviceOrderDeliveryAddress");
            return (Criteria) this;
        }

        public Criteria andServiceOrderDeliveryAddressNotLike(String value) {
            addCriterion("service_order_delivery_address not like", value, "serviceOrderDeliveryAddress");
            return (Criteria) this;
        }

        public Criteria andServiceOrderDeliveryAddressIn(List<String> values) {
            addCriterion("service_order_delivery_address in", values, "serviceOrderDeliveryAddress");
            return (Criteria) this;
        }

        public Criteria andServiceOrderDeliveryAddressNotIn(List<String> values) {
            addCriterion("service_order_delivery_address not in", values, "serviceOrderDeliveryAddress");
            return (Criteria) this;
        }

        public Criteria andServiceOrderDeliveryAddressBetween(String value1, String value2) {
            addCriterion("service_order_delivery_address between", value1, value2, "serviceOrderDeliveryAddress");
            return (Criteria) this;
        }

        public Criteria andServiceOrderDeliveryAddressNotBetween(String value1, String value2) {
            addCriterion("service_order_delivery_address not between", value1, value2, "serviceOrderDeliveryAddress");
            return (Criteria) this;
        }

        public Criteria andServiceOrderDeliveryContactNumberIsNull() {
            addCriterion("service_order_delivery_contact_number is null");
            return (Criteria) this;
        }

        public Criteria andServiceOrderDeliveryContactNumberIsNotNull() {
            addCriterion("service_order_delivery_contact_number is not null");
            return (Criteria) this;
        }

        public Criteria andServiceOrderDeliveryContactNumberEqualTo(String value) {
            addCriterion("service_order_delivery_contact_number =", value, "serviceOrderDeliveryContactNumber");
            return (Criteria) this;
        }

        public Criteria andServiceOrderDeliveryContactNumberNotEqualTo(String value) {
            addCriterion("service_order_delivery_contact_number <>", value, "serviceOrderDeliveryContactNumber");
            return (Criteria) this;
        }

        public Criteria andServiceOrderDeliveryContactNumberGreaterThan(String value) {
            addCriterion("service_order_delivery_contact_number >", value, "serviceOrderDeliveryContactNumber");
            return (Criteria) this;
        }

        public Criteria andServiceOrderDeliveryContactNumberGreaterThanOrEqualTo(String value) {
            addCriterion("service_order_delivery_contact_number >=", value, "serviceOrderDeliveryContactNumber");
            return (Criteria) this;
        }

        public Criteria andServiceOrderDeliveryContactNumberLessThan(String value) {
            addCriterion("service_order_delivery_contact_number <", value, "serviceOrderDeliveryContactNumber");
            return (Criteria) this;
        }

        public Criteria andServiceOrderDeliveryContactNumberLessThanOrEqualTo(String value) {
            addCriterion("service_order_delivery_contact_number <=", value, "serviceOrderDeliveryContactNumber");
            return (Criteria) this;
        }

        public Criteria andServiceOrderDeliveryContactNumberLike(String value) {
            addCriterion("service_order_delivery_contact_number like", value, "serviceOrderDeliveryContactNumber");
            return (Criteria) this;
        }

        public Criteria andServiceOrderDeliveryContactNumberNotLike(String value) {
            addCriterion("service_order_delivery_contact_number not like", value, "serviceOrderDeliveryContactNumber");
            return (Criteria) this;
        }

        public Criteria andServiceOrderDeliveryContactNumberIn(List<String> values) {
            addCriterion("service_order_delivery_contact_number in", values, "serviceOrderDeliveryContactNumber");
            return (Criteria) this;
        }

        public Criteria andServiceOrderDeliveryContactNumberNotIn(List<String> values) {
            addCriterion("service_order_delivery_contact_number not in", values, "serviceOrderDeliveryContactNumber");
            return (Criteria) this;
        }

        public Criteria andServiceOrderDeliveryContactNumberBetween(String value1, String value2) {
            addCriterion("service_order_delivery_contact_number between", value1, value2, "serviceOrderDeliveryContactNumber");
            return (Criteria) this;
        }

        public Criteria andServiceOrderDeliveryContactNumberNotBetween(String value1, String value2) {
            addCriterion("service_order_delivery_contact_number not between", value1, value2, "serviceOrderDeliveryContactNumber");
            return (Criteria) this;
        }

        public Criteria andServiceOrderDeliveryAddressLonIsNull() {
            addCriterion("service_order_delivery_address_lon is null");
            return (Criteria) this;
        }

        public Criteria andServiceOrderDeliveryAddressLonIsNotNull() {
            addCriterion("service_order_delivery_address_lon is not null");
            return (Criteria) this;
        }

        public Criteria andServiceOrderDeliveryAddressLonEqualTo(Double value) {
            addCriterion("service_order_delivery_address_lon =", value, "serviceOrderDeliveryAddressLon");
            return (Criteria) this;
        }

        public Criteria andServiceOrderDeliveryAddressLonNotEqualTo(Double value) {
            addCriterion("service_order_delivery_address_lon <>", value, "serviceOrderDeliveryAddressLon");
            return (Criteria) this;
        }

        public Criteria andServiceOrderDeliveryAddressLonGreaterThan(Double value) {
            addCriterion("service_order_delivery_address_lon >", value, "serviceOrderDeliveryAddressLon");
            return (Criteria) this;
        }

        public Criteria andServiceOrderDeliveryAddressLonGreaterThanOrEqualTo(Double value) {
            addCriterion("service_order_delivery_address_lon >=", value, "serviceOrderDeliveryAddressLon");
            return (Criteria) this;
        }

        public Criteria andServiceOrderDeliveryAddressLonLessThan(Double value) {
            addCriterion("service_order_delivery_address_lon <", value, "serviceOrderDeliveryAddressLon");
            return (Criteria) this;
        }

        public Criteria andServiceOrderDeliveryAddressLonLessThanOrEqualTo(Double value) {
            addCriterion("service_order_delivery_address_lon <=", value, "serviceOrderDeliveryAddressLon");
            return (Criteria) this;
        }

        public Criteria andServiceOrderDeliveryAddressLonIn(List<Double> values) {
            addCriterion("service_order_delivery_address_lon in", values, "serviceOrderDeliveryAddressLon");
            return (Criteria) this;
        }

        public Criteria andServiceOrderDeliveryAddressLonNotIn(List<Double> values) {
            addCriterion("service_order_delivery_address_lon not in", values, "serviceOrderDeliveryAddressLon");
            return (Criteria) this;
        }

        public Criteria andServiceOrderDeliveryAddressLonBetween(Double value1, Double value2) {
            addCriterion("service_order_delivery_address_lon between", value1, value2, "serviceOrderDeliveryAddressLon");
            return (Criteria) this;
        }

        public Criteria andServiceOrderDeliveryAddressLonNotBetween(Double value1, Double value2) {
            addCriterion("service_order_delivery_address_lon not between", value1, value2, "serviceOrderDeliveryAddressLon");
            return (Criteria) this;
        }

        public Criteria andServiceOrderDeliveryAddressLatIsNull() {
            addCriterion("service_order_delivery_address_lat is null");
            return (Criteria) this;
        }

        public Criteria andServiceOrderDeliveryAddressLatIsNotNull() {
            addCriterion("service_order_delivery_address_lat is not null");
            return (Criteria) this;
        }

        public Criteria andServiceOrderDeliveryAddressLatEqualTo(Double value) {
            addCriterion("service_order_delivery_address_lat =", value, "serviceOrderDeliveryAddressLat");
            return (Criteria) this;
        }

        public Criteria andServiceOrderDeliveryAddressLatNotEqualTo(Double value) {
            addCriterion("service_order_delivery_address_lat <>", value, "serviceOrderDeliveryAddressLat");
            return (Criteria) this;
        }

        public Criteria andServiceOrderDeliveryAddressLatGreaterThan(Double value) {
            addCriterion("service_order_delivery_address_lat >", value, "serviceOrderDeliveryAddressLat");
            return (Criteria) this;
        }

        public Criteria andServiceOrderDeliveryAddressLatGreaterThanOrEqualTo(Double value) {
            addCriterion("service_order_delivery_address_lat >=", value, "serviceOrderDeliveryAddressLat");
            return (Criteria) this;
        }

        public Criteria andServiceOrderDeliveryAddressLatLessThan(Double value) {
            addCriterion("service_order_delivery_address_lat <", value, "serviceOrderDeliveryAddressLat");
            return (Criteria) this;
        }

        public Criteria andServiceOrderDeliveryAddressLatLessThanOrEqualTo(Double value) {
            addCriterion("service_order_delivery_address_lat <=", value, "serviceOrderDeliveryAddressLat");
            return (Criteria) this;
        }

        public Criteria andServiceOrderDeliveryAddressLatIn(List<Double> values) {
            addCriterion("service_order_delivery_address_lat in", values, "serviceOrderDeliveryAddressLat");
            return (Criteria) this;
        }

        public Criteria andServiceOrderDeliveryAddressLatNotIn(List<Double> values) {
            addCriterion("service_order_delivery_address_lat not in", values, "serviceOrderDeliveryAddressLat");
            return (Criteria) this;
        }

        public Criteria andServiceOrderDeliveryAddressLatBetween(Double value1, Double value2) {
            addCriterion("service_order_delivery_address_lat between", value1, value2, "serviceOrderDeliveryAddressLat");
            return (Criteria) this;
        }

        public Criteria andServiceOrderDeliveryAddressLatNotBetween(Double value1, Double value2) {
            addCriterion("service_order_delivery_address_lat not between", value1, value2, "serviceOrderDeliveryAddressLat");
            return (Criteria) this;
        }

        public Criteria andServiceOrderPickupAddressIsNull() {
            addCriterion("service_order_pickup_address is null");
            return (Criteria) this;
        }

        public Criteria andServiceOrderPickupAddressIsNotNull() {
            addCriterion("service_order_pickup_address is not null");
            return (Criteria) this;
        }

        public Criteria andServiceOrderPickupAddressEqualTo(String value) {
            addCriterion("service_order_pickup_address =", value, "serviceOrderPickupAddress");
            return (Criteria) this;
        }

        public Criteria andServiceOrderPickupAddressNotEqualTo(String value) {
            addCriterion("service_order_pickup_address <>", value, "serviceOrderPickupAddress");
            return (Criteria) this;
        }

        public Criteria andServiceOrderPickupAddressGreaterThan(String value) {
            addCriterion("service_order_pickup_address >", value, "serviceOrderPickupAddress");
            return (Criteria) this;
        }

        public Criteria andServiceOrderPickupAddressGreaterThanOrEqualTo(String value) {
            addCriterion("service_order_pickup_address >=", value, "serviceOrderPickupAddress");
            return (Criteria) this;
        }

        public Criteria andServiceOrderPickupAddressLessThan(String value) {
            addCriterion("service_order_pickup_address <", value, "serviceOrderPickupAddress");
            return (Criteria) this;
        }

        public Criteria andServiceOrderPickupAddressLessThanOrEqualTo(String value) {
            addCriterion("service_order_pickup_address <=", value, "serviceOrderPickupAddress");
            return (Criteria) this;
        }

        public Criteria andServiceOrderPickupAddressLike(String value) {
            addCriterion("service_order_pickup_address like", value, "serviceOrderPickupAddress");
            return (Criteria) this;
        }

        public Criteria andServiceOrderPickupAddressNotLike(String value) {
            addCriterion("service_order_pickup_address not like", value, "serviceOrderPickupAddress");
            return (Criteria) this;
        }

        public Criteria andServiceOrderPickupAddressIn(List<String> values) {
            addCriterion("service_order_pickup_address in", values, "serviceOrderPickupAddress");
            return (Criteria) this;
        }

        public Criteria andServiceOrderPickupAddressNotIn(List<String> values) {
            addCriterion("service_order_pickup_address not in", values, "serviceOrderPickupAddress");
            return (Criteria) this;
        }

        public Criteria andServiceOrderPickupAddressBetween(String value1, String value2) {
            addCriterion("service_order_pickup_address between", value1, value2, "serviceOrderPickupAddress");
            return (Criteria) this;
        }

        public Criteria andServiceOrderPickupAddressNotBetween(String value1, String value2) {
            addCriterion("service_order_pickup_address not between", value1, value2, "serviceOrderPickupAddress");
            return (Criteria) this;
        }

        public Criteria andServiceOrderPickupAddressLonIsNull() {
            addCriterion("service_order_pickup_address_lon is null");
            return (Criteria) this;
        }

        public Criteria andServiceOrderPickupAddressLonIsNotNull() {
            addCriterion("service_order_pickup_address_lon is not null");
            return (Criteria) this;
        }

        public Criteria andServiceOrderPickupAddressLonEqualTo(Double value) {
            addCriterion("service_order_pickup_address_lon =", value, "serviceOrderPickupAddressLon");
            return (Criteria) this;
        }

        public Criteria andServiceOrderPickupAddressLonNotEqualTo(Double value) {
            addCriterion("service_order_pickup_address_lon <>", value, "serviceOrderPickupAddressLon");
            return (Criteria) this;
        }

        public Criteria andServiceOrderPickupAddressLonGreaterThan(Double value) {
            addCriterion("service_order_pickup_address_lon >", value, "serviceOrderPickupAddressLon");
            return (Criteria) this;
        }

        public Criteria andServiceOrderPickupAddressLonGreaterThanOrEqualTo(Double value) {
            addCriterion("service_order_pickup_address_lon >=", value, "serviceOrderPickupAddressLon");
            return (Criteria) this;
        }

        public Criteria andServiceOrderPickupAddressLonLessThan(Double value) {
            addCriterion("service_order_pickup_address_lon <", value, "serviceOrderPickupAddressLon");
            return (Criteria) this;
        }

        public Criteria andServiceOrderPickupAddressLonLessThanOrEqualTo(Double value) {
            addCriterion("service_order_pickup_address_lon <=", value, "serviceOrderPickupAddressLon");
            return (Criteria) this;
        }

        public Criteria andServiceOrderPickupAddressLonIn(List<Double> values) {
            addCriterion("service_order_pickup_address_lon in", values, "serviceOrderPickupAddressLon");
            return (Criteria) this;
        }

        public Criteria andServiceOrderPickupAddressLonNotIn(List<Double> values) {
            addCriterion("service_order_pickup_address_lon not in", values, "serviceOrderPickupAddressLon");
            return (Criteria) this;
        }

        public Criteria andServiceOrderPickupAddressLonBetween(Double value1, Double value2) {
            addCriterion("service_order_pickup_address_lon between", value1, value2, "serviceOrderPickupAddressLon");
            return (Criteria) this;
        }

        public Criteria andServiceOrderPickupAddressLonNotBetween(Double value1, Double value2) {
            addCriterion("service_order_pickup_address_lon not between", value1, value2, "serviceOrderPickupAddressLon");
            return (Criteria) this;
        }

        public Criteria andServiceOrderPickupAddressLatIsNull() {
            addCriterion("service_order_pickup_address_lat is null");
            return (Criteria) this;
        }

        public Criteria andServiceOrderPickupAddressLatIsNotNull() {
            addCriterion("service_order_pickup_address_lat is not null");
            return (Criteria) this;
        }

        public Criteria andServiceOrderPickupAddressLatEqualTo(Double value) {
            addCriterion("service_order_pickup_address_lat =", value, "serviceOrderPickupAddressLat");
            return (Criteria) this;
        }

        public Criteria andServiceOrderPickupAddressLatNotEqualTo(Double value) {
            addCriterion("service_order_pickup_address_lat <>", value, "serviceOrderPickupAddressLat");
            return (Criteria) this;
        }

        public Criteria andServiceOrderPickupAddressLatGreaterThan(Double value) {
            addCriterion("service_order_pickup_address_lat >", value, "serviceOrderPickupAddressLat");
            return (Criteria) this;
        }

        public Criteria andServiceOrderPickupAddressLatGreaterThanOrEqualTo(Double value) {
            addCriterion("service_order_pickup_address_lat >=", value, "serviceOrderPickupAddressLat");
            return (Criteria) this;
        }

        public Criteria andServiceOrderPickupAddressLatLessThan(Double value) {
            addCriterion("service_order_pickup_address_lat <", value, "serviceOrderPickupAddressLat");
            return (Criteria) this;
        }

        public Criteria andServiceOrderPickupAddressLatLessThanOrEqualTo(Double value) {
            addCriterion("service_order_pickup_address_lat <=", value, "serviceOrderPickupAddressLat");
            return (Criteria) this;
        }

        public Criteria andServiceOrderPickupAddressLatIn(List<Double> values) {
            addCriterion("service_order_pickup_address_lat in", values, "serviceOrderPickupAddressLat");
            return (Criteria) this;
        }

        public Criteria andServiceOrderPickupAddressLatNotIn(List<Double> values) {
            addCriterion("service_order_pickup_address_lat not in", values, "serviceOrderPickupAddressLat");
            return (Criteria) this;
        }

        public Criteria andServiceOrderPickupAddressLatBetween(Double value1, Double value2) {
            addCriterion("service_order_pickup_address_lat between", value1, value2, "serviceOrderPickupAddressLat");
            return (Criteria) this;
        }

        public Criteria andServiceOrderPickupAddressLatNotBetween(Double value1, Double value2) {
            addCriterion("service_order_pickup_address_lat not between", value1, value2, "serviceOrderPickupAddressLat");
            return (Criteria) this;
        }

        public Criteria andServiceOrderPickupContactNumberIsNull() {
            addCriterion("service_order_pickup_contact_number is null");
            return (Criteria) this;
        }

        public Criteria andServiceOrderPickupContactNumberIsNotNull() {
            addCriterion("service_order_pickup_contact_number is not null");
            return (Criteria) this;
        }

        public Criteria andServiceOrderPickupContactNumberEqualTo(String value) {
            addCriterion("service_order_pickup_contact_number =", value, "serviceOrderPickupContactNumber");
            return (Criteria) this;
        }

        public Criteria andServiceOrderPickupContactNumberNotEqualTo(String value) {
            addCriterion("service_order_pickup_contact_number <>", value, "serviceOrderPickupContactNumber");
            return (Criteria) this;
        }

        public Criteria andServiceOrderPickupContactNumberGreaterThan(String value) {
            addCriterion("service_order_pickup_contact_number >", value, "serviceOrderPickupContactNumber");
            return (Criteria) this;
        }

        public Criteria andServiceOrderPickupContactNumberGreaterThanOrEqualTo(String value) {
            addCriterion("service_order_pickup_contact_number >=", value, "serviceOrderPickupContactNumber");
            return (Criteria) this;
        }

        public Criteria andServiceOrderPickupContactNumberLessThan(String value) {
            addCriterion("service_order_pickup_contact_number <", value, "serviceOrderPickupContactNumber");
            return (Criteria) this;
        }

        public Criteria andServiceOrderPickupContactNumberLessThanOrEqualTo(String value) {
            addCriterion("service_order_pickup_contact_number <=", value, "serviceOrderPickupContactNumber");
            return (Criteria) this;
        }

        public Criteria andServiceOrderPickupContactNumberLike(String value) {
            addCriterion("service_order_pickup_contact_number like", value, "serviceOrderPickupContactNumber");
            return (Criteria) this;
        }

        public Criteria andServiceOrderPickupContactNumberNotLike(String value) {
            addCriterion("service_order_pickup_contact_number not like", value, "serviceOrderPickupContactNumber");
            return (Criteria) this;
        }

        public Criteria andServiceOrderPickupContactNumberIn(List<String> values) {
            addCriterion("service_order_pickup_contact_number in", values, "serviceOrderPickupContactNumber");
            return (Criteria) this;
        }

        public Criteria andServiceOrderPickupContactNumberNotIn(List<String> values) {
            addCriterion("service_order_pickup_contact_number not in", values, "serviceOrderPickupContactNumber");
            return (Criteria) this;
        }

        public Criteria andServiceOrderPickupContactNumberBetween(String value1, String value2) {
            addCriterion("service_order_pickup_contact_number between", value1, value2, "serviceOrderPickupContactNumber");
            return (Criteria) this;
        }

        public Criteria andServiceOrderPickupContactNumberNotBetween(String value1, String value2) {
            addCriterion("service_order_pickup_contact_number not between", value1, value2, "serviceOrderPickupContactNumber");
            return (Criteria) this;
        }

        public Criteria andServiceOrderPickupContactNameIsNull() {
            addCriterion("service_order_pickup_contact_name is null");
            return (Criteria) this;
        }

        public Criteria andServiceOrderPickupContactNameIsNotNull() {
            addCriterion("service_order_pickup_contact_name is not null");
            return (Criteria) this;
        }

        public Criteria andServiceOrderPickupContactNameEqualTo(String value) {
            addCriterion("service_order_pickup_contact_name =", value, "serviceOrderPickupContactName");
            return (Criteria) this;
        }

        public Criteria andServiceOrderPickupContactNameNotEqualTo(String value) {
            addCriterion("service_order_pickup_contact_name <>", value, "serviceOrderPickupContactName");
            return (Criteria) this;
        }

        public Criteria andServiceOrderPickupContactNameGreaterThan(String value) {
            addCriterion("service_order_pickup_contact_name >", value, "serviceOrderPickupContactName");
            return (Criteria) this;
        }

        public Criteria andServiceOrderPickupContactNameGreaterThanOrEqualTo(String value) {
            addCriterion("service_order_pickup_contact_name >=", value, "serviceOrderPickupContactName");
            return (Criteria) this;
        }

        public Criteria andServiceOrderPickupContactNameLessThan(String value) {
            addCriterion("service_order_pickup_contact_name <", value, "serviceOrderPickupContactName");
            return (Criteria) this;
        }

        public Criteria andServiceOrderPickupContactNameLessThanOrEqualTo(String value) {
            addCriterion("service_order_pickup_contact_name <=", value, "serviceOrderPickupContactName");
            return (Criteria) this;
        }

        public Criteria andServiceOrderPickupContactNameLike(String value) {
            addCriterion("service_order_pickup_contact_name like", value, "serviceOrderPickupContactName");
            return (Criteria) this;
        }

        public Criteria andServiceOrderPickupContactNameNotLike(String value) {
            addCriterion("service_order_pickup_contact_name not like", value, "serviceOrderPickupContactName");
            return (Criteria) this;
        }

        public Criteria andServiceOrderPickupContactNameIn(List<String> values) {
            addCriterion("service_order_pickup_contact_name in", values, "serviceOrderPickupContactName");
            return (Criteria) this;
        }

        public Criteria andServiceOrderPickupContactNameNotIn(List<String> values) {
            addCriterion("service_order_pickup_contact_name not in", values, "serviceOrderPickupContactName");
            return (Criteria) this;
        }

        public Criteria andServiceOrderPickupContactNameBetween(String value1, String value2) {
            addCriterion("service_order_pickup_contact_name between", value1, value2, "serviceOrderPickupContactName");
            return (Criteria) this;
        }

        public Criteria andServiceOrderPickupContactNameNotBetween(String value1, String value2) {
            addCriterion("service_order_pickup_contact_name not between", value1, value2, "serviceOrderPickupContactName");
            return (Criteria) this;
        }

        public Criteria andServiceOrderWeightIsNull() {
            addCriterion("service_order_weight is null");
            return (Criteria) this;
        }

        public Criteria andServiceOrderWeightIsNotNull() {
            addCriterion("service_order_weight is not null");
            return (Criteria) this;
        }

        public Criteria andServiceOrderWeightEqualTo(Integer value) {
            addCriterion("service_order_weight =", value, "serviceOrderWeight");
            return (Criteria) this;
        }

        public Criteria andServiceOrderWeightNotEqualTo(Integer value) {
            addCriterion("service_order_weight <>", value, "serviceOrderWeight");
            return (Criteria) this;
        }

        public Criteria andServiceOrderWeightGreaterThan(Integer value) {
            addCriterion("service_order_weight >", value, "serviceOrderWeight");
            return (Criteria) this;
        }

        public Criteria andServiceOrderWeightGreaterThanOrEqualTo(Integer value) {
            addCriterion("service_order_weight >=", value, "serviceOrderWeight");
            return (Criteria) this;
        }

        public Criteria andServiceOrderWeightLessThan(Integer value) {
            addCriterion("service_order_weight <", value, "serviceOrderWeight");
            return (Criteria) this;
        }

        public Criteria andServiceOrderWeightLessThanOrEqualTo(Integer value) {
            addCriterion("service_order_weight <=", value, "serviceOrderWeight");
            return (Criteria) this;
        }

        public Criteria andServiceOrderWeightIn(List<Integer> values) {
            addCriterion("service_order_weight in", values, "serviceOrderWeight");
            return (Criteria) this;
        }

        public Criteria andServiceOrderWeightNotIn(List<Integer> values) {
            addCriterion("service_order_weight not in", values, "serviceOrderWeight");
            return (Criteria) this;
        }

        public Criteria andServiceOrderWeightBetween(Integer value1, Integer value2) {
            addCriterion("service_order_weight between", value1, value2, "serviceOrderWeight");
            return (Criteria) this;
        }

        public Criteria andServiceOrderWeightNotBetween(Integer value1, Integer value2) {
            addCriterion("service_order_weight not between", value1, value2, "serviceOrderWeight");
            return (Criteria) this;
        }

        public Criteria andServiceOrderDistanceIsNull() {
            addCriterion("service_order_distance is null");
            return (Criteria) this;
        }

        public Criteria andServiceOrderDistanceIsNotNull() {
            addCriterion("service_order_distance is not null");
            return (Criteria) this;
        }

        public Criteria andServiceOrderDistanceEqualTo(Integer value) {
            addCriterion("service_order_distance =", value, "serviceOrderDistance");
            return (Criteria) this;
        }

        public Criteria andServiceOrderDistanceNotEqualTo(Integer value) {
            addCriterion("service_order_distance <>", value, "serviceOrderDistance");
            return (Criteria) this;
        }

        public Criteria andServiceOrderDistanceGreaterThan(Integer value) {
            addCriterion("service_order_distance >", value, "serviceOrderDistance");
            return (Criteria) this;
        }

        public Criteria andServiceOrderDistanceGreaterThanOrEqualTo(Integer value) {
            addCriterion("service_order_distance >=", value, "serviceOrderDistance");
            return (Criteria) this;
        }

        public Criteria andServiceOrderDistanceLessThan(Integer value) {
            addCriterion("service_order_distance <", value, "serviceOrderDistance");
            return (Criteria) this;
        }

        public Criteria andServiceOrderDistanceLessThanOrEqualTo(Integer value) {
            addCriterion("service_order_distance <=", value, "serviceOrderDistance");
            return (Criteria) this;
        }

        public Criteria andServiceOrderDistanceIn(List<Integer> values) {
            addCriterion("service_order_distance in", values, "serviceOrderDistance");
            return (Criteria) this;
        }

        public Criteria andServiceOrderDistanceNotIn(List<Integer> values) {
            addCriterion("service_order_distance not in", values, "serviceOrderDistance");
            return (Criteria) this;
        }

        public Criteria andServiceOrderDistanceBetween(Integer value1, Integer value2) {
            addCriterion("service_order_distance between", value1, value2, "serviceOrderDistance");
            return (Criteria) this;
        }

        public Criteria andServiceOrderDistanceNotBetween(Integer value1, Integer value2) {
            addCriterion("service_order_distance not between", value1, value2, "serviceOrderDistance");
            return (Criteria) this;
        }

        public Criteria andServiceOrderCreateTimeIsNull() {
            addCriterion("service_order_create_time is null");
            return (Criteria) this;
        }

        public Criteria andServiceOrderCreateTimeIsNotNull() {
            addCriterion("service_order_create_time is not null");
            return (Criteria) this;
        }

        public Criteria andServiceOrderCreateTimeEqualTo(Date value) {
            addCriterion("service_order_create_time =", value, "serviceOrderCreateTime");
            return (Criteria) this;
        }

        public Criteria andServiceOrderCreateTimeNotEqualTo(Date value) {
            addCriterion("service_order_create_time <>", value, "serviceOrderCreateTime");
            return (Criteria) this;
        }

        public Criteria andServiceOrderCreateTimeGreaterThan(Date value) {
            addCriterion("service_order_create_time >", value, "serviceOrderCreateTime");
            return (Criteria) this;
        }

        public Criteria andServiceOrderCreateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("service_order_create_time >=", value, "serviceOrderCreateTime");
            return (Criteria) this;
        }

        public Criteria andServiceOrderCreateTimeLessThan(Date value) {
            addCriterion("service_order_create_time <", value, "serviceOrderCreateTime");
            return (Criteria) this;
        }

        public Criteria andServiceOrderCreateTimeLessThanOrEqualTo(Date value) {
            addCriterion("service_order_create_time <=", value, "serviceOrderCreateTime");
            return (Criteria) this;
        }

        public Criteria andServiceOrderCreateTimeIn(List<Date> values) {
            addCriterion("service_order_create_time in", values, "serviceOrderCreateTime");
            return (Criteria) this;
        }

        public Criteria andServiceOrderCreateTimeNotIn(List<Date> values) {
            addCriterion("service_order_create_time not in", values, "serviceOrderCreateTime");
            return (Criteria) this;
        }

        public Criteria andServiceOrderCreateTimeBetween(Date value1, Date value2) {
            addCriterion("service_order_create_time between", value1, value2, "serviceOrderCreateTime");
            return (Criteria) this;
        }

        public Criteria andServiceOrderCreateTimeNotBetween(Date value1, Date value2) {
            addCriterion("service_order_create_time not between", value1, value2, "serviceOrderCreateTime");
            return (Criteria) this;
        }

        public Criteria andServiceOrderModifyTimeIsNull() {
            addCriterion("service_order_modify_time is null");
            return (Criteria) this;
        }

        public Criteria andServiceOrderModifyTimeIsNotNull() {
            addCriterion("service_order_modify_time is not null");
            return (Criteria) this;
        }

        public Criteria andServiceOrderModifyTimeEqualTo(Date value) {
            addCriterion("service_order_modify_time =", value, "serviceOrderModifyTime");
            return (Criteria) this;
        }

        public Criteria andServiceOrderModifyTimeNotEqualTo(Date value) {
            addCriterion("service_order_modify_time <>", value, "serviceOrderModifyTime");
            return (Criteria) this;
        }

        public Criteria andServiceOrderModifyTimeGreaterThan(Date value) {
            addCriterion("service_order_modify_time >", value, "serviceOrderModifyTime");
            return (Criteria) this;
        }

        public Criteria andServiceOrderModifyTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("service_order_modify_time >=", value, "serviceOrderModifyTime");
            return (Criteria) this;
        }

        public Criteria andServiceOrderModifyTimeLessThan(Date value) {
            addCriterion("service_order_modify_time <", value, "serviceOrderModifyTime");
            return (Criteria) this;
        }

        public Criteria andServiceOrderModifyTimeLessThanOrEqualTo(Date value) {
            addCriterion("service_order_modify_time <=", value, "serviceOrderModifyTime");
            return (Criteria) this;
        }

        public Criteria andServiceOrderModifyTimeIn(List<Date> values) {
            addCriterion("service_order_modify_time in", values, "serviceOrderModifyTime");
            return (Criteria) this;
        }

        public Criteria andServiceOrderModifyTimeNotIn(List<Date> values) {
            addCriterion("service_order_modify_time not in", values, "serviceOrderModifyTime");
            return (Criteria) this;
        }

        public Criteria andServiceOrderModifyTimeBetween(Date value1, Date value2) {
            addCriterion("service_order_modify_time between", value1, value2, "serviceOrderModifyTime");
            return (Criteria) this;
        }

        public Criteria andServiceOrderModifyTimeNotBetween(Date value1, Date value2) {
            addCriterion("service_order_modify_time not between", value1, value2, "serviceOrderModifyTime");
            return (Criteria) this;
        }

        public Criteria andServiceOrderAllSeeTimeIsNull() {
            addCriterion("service_order_all_see_time is null");
            return (Criteria) this;
        }

        public Criteria andServiceOrderAllSeeTimeIsNotNull() {
            addCriterion("service_order_all_see_time is not null");
            return (Criteria) this;
        }

        public Criteria andServiceOrderAllSeeTimeEqualTo(Date value) {
            addCriterion("service_order_all_see_time =", value, "serviceOrderAllSeeTime");
            return (Criteria) this;
        }

        public Criteria andServiceOrderAllSeeTimeNotEqualTo(Date value) {
            addCriterion("service_order_all_see_time <>", value, "serviceOrderAllSeeTime");
            return (Criteria) this;
        }

        public Criteria andServiceOrderAllSeeTimeGreaterThan(Date value) {
            addCriterion("service_order_all_see_time >", value, "serviceOrderAllSeeTime");
            return (Criteria) this;
        }

        public Criteria andServiceOrderAllSeeTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("service_order_all_see_time >=", value, "serviceOrderAllSeeTime");
            return (Criteria) this;
        }

        public Criteria andServiceOrderAllSeeTimeLessThan(Date value) {
            addCriterion("service_order_all_see_time <", value, "serviceOrderAllSeeTime");
            return (Criteria) this;
        }

        public Criteria andServiceOrderAllSeeTimeLessThanOrEqualTo(Date value) {
            addCriterion("service_order_all_see_time <=", value, "serviceOrderAllSeeTime");
            return (Criteria) this;
        }

        public Criteria andServiceOrderAllSeeTimeIn(List<Date> values) {
            addCriterion("service_order_all_see_time in", values, "serviceOrderAllSeeTime");
            return (Criteria) this;
        }

        public Criteria andServiceOrderAllSeeTimeNotIn(List<Date> values) {
            addCriterion("service_order_all_see_time not in", values, "serviceOrderAllSeeTime");
            return (Criteria) this;
        }

        public Criteria andServiceOrderAllSeeTimeBetween(Date value1, Date value2) {
            addCriterion("service_order_all_see_time between", value1, value2, "serviceOrderAllSeeTime");
            return (Criteria) this;
        }

        public Criteria andServiceOrderAllSeeTimeNotBetween(Date value1, Date value2) {
            addCriterion("service_order_all_see_time not between", value1, value2, "serviceOrderAllSeeTime");
            return (Criteria) this;
        }

        public Criteria andServiceOrderFinshTimeIsNull() {
            addCriterion("service_order_finsh_time is null");
            return (Criteria) this;
        }

        public Criteria andServiceOrderFinshTimeIsNotNull() {
            addCriterion("service_order_finsh_time is not null");
            return (Criteria) this;
        }

        public Criteria andServiceOrderFinshTimeEqualTo(Date value) {
            addCriterion("service_order_finsh_time =", value, "serviceOrderFinshTime");
            return (Criteria) this;
        }

        public Criteria andServiceOrderFinshTimeNotEqualTo(Date value) {
            addCriterion("service_order_finsh_time <>", value, "serviceOrderFinshTime");
            return (Criteria) this;
        }

        public Criteria andServiceOrderFinshTimeGreaterThan(Date value) {
            addCriterion("service_order_finsh_time >", value, "serviceOrderFinshTime");
            return (Criteria) this;
        }

        public Criteria andServiceOrderFinshTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("service_order_finsh_time >=", value, "serviceOrderFinshTime");
            return (Criteria) this;
        }

        public Criteria andServiceOrderFinshTimeLessThan(Date value) {
            addCriterion("service_order_finsh_time <", value, "serviceOrderFinshTime");
            return (Criteria) this;
        }

        public Criteria andServiceOrderFinshTimeLessThanOrEqualTo(Date value) {
            addCriterion("service_order_finsh_time <=", value, "serviceOrderFinshTime");
            return (Criteria) this;
        }

        public Criteria andServiceOrderFinshTimeIn(List<Date> values) {
            addCriterion("service_order_finsh_time in", values, "serviceOrderFinshTime");
            return (Criteria) this;
        }

        public Criteria andServiceOrderFinshTimeNotIn(List<Date> values) {
            addCriterion("service_order_finsh_time not in", values, "serviceOrderFinshTime");
            return (Criteria) this;
        }

        public Criteria andServiceOrderFinshTimeBetween(Date value1, Date value2) {
            addCriterion("service_order_finsh_time between", value1, value2, "serviceOrderFinshTime");
            return (Criteria) this;
        }

        public Criteria andServiceOrderFinshTimeNotBetween(Date value1, Date value2) {
            addCriterion("service_order_finsh_time not between", value1, value2, "serviceOrderFinshTime");
            return (Criteria) this;
        }

        public Criteria andServiceOrderIsCommentIsNull() {
            addCriterion("service_order_is_comment is null");
            return (Criteria) this;
        }

        public Criteria andServiceOrderIsCommentIsNotNull() {
            addCriterion("service_order_is_comment is not null");
            return (Criteria) this;
        }

        public Criteria andServiceOrderIsCommentEqualTo(Integer value) {
            addCriterion("service_order_is_comment =", value, "serviceOrderIsComment");
            return (Criteria) this;
        }

        public Criteria andServiceOrderIsCommentNotEqualTo(Integer value) {
            addCriterion("service_order_is_comment <>", value, "serviceOrderIsComment");
            return (Criteria) this;
        }

        public Criteria andServiceOrderIsCommentGreaterThan(Integer value) {
            addCriterion("service_order_is_comment >", value, "serviceOrderIsComment");
            return (Criteria) this;
        }

        public Criteria andServiceOrderIsCommentGreaterThanOrEqualTo(Integer value) {
            addCriterion("service_order_is_comment >=", value, "serviceOrderIsComment");
            return (Criteria) this;
        }

        public Criteria andServiceOrderIsCommentLessThan(Integer value) {
            addCriterion("service_order_is_comment <", value, "serviceOrderIsComment");
            return (Criteria) this;
        }

        public Criteria andServiceOrderIsCommentLessThanOrEqualTo(Integer value) {
            addCriterion("service_order_is_comment <=", value, "serviceOrderIsComment");
            return (Criteria) this;
        }

        public Criteria andServiceOrderIsCommentIn(List<Integer> values) {
            addCriterion("service_order_is_comment in", values, "serviceOrderIsComment");
            return (Criteria) this;
        }

        public Criteria andServiceOrderIsCommentNotIn(List<Integer> values) {
            addCriterion("service_order_is_comment not in", values, "serviceOrderIsComment");
            return (Criteria) this;
        }

        public Criteria andServiceOrderIsCommentBetween(Integer value1, Integer value2) {
            addCriterion("service_order_is_comment between", value1, value2, "serviceOrderIsComment");
            return (Criteria) this;
        }

        public Criteria andServiceOrderIsCommentNotBetween(Integer value1, Integer value2) {
            addCriterion("service_order_is_comment not between", value1, value2, "serviceOrderIsComment");
            return (Criteria) this;
        }

        public Criteria andServiceOrderNightAmountIsNull() {
            addCriterion("service_order_night_amount is null");
            return (Criteria) this;
        }

        public Criteria andServiceOrderNightAmountIsNotNull() {
            addCriterion("service_order_night_amount is not null");
            return (Criteria) this;
        }

        public Criteria andServiceOrderNightAmountEqualTo(Integer value) {
            addCriterion("service_order_night_amount =", value, "serviceOrderNightAmount");
            return (Criteria) this;
        }

        public Criteria andServiceOrderNightAmountNotEqualTo(Integer value) {
            addCriterion("service_order_night_amount <>", value, "serviceOrderNightAmount");
            return (Criteria) this;
        }

        public Criteria andServiceOrderNightAmountGreaterThan(Integer value) {
            addCriterion("service_order_night_amount >", value, "serviceOrderNightAmount");
            return (Criteria) this;
        }

        public Criteria andServiceOrderNightAmountGreaterThanOrEqualTo(Integer value) {
            addCriterion("service_order_night_amount >=", value, "serviceOrderNightAmount");
            return (Criteria) this;
        }

        public Criteria andServiceOrderNightAmountLessThan(Integer value) {
            addCriterion("service_order_night_amount <", value, "serviceOrderNightAmount");
            return (Criteria) this;
        }

        public Criteria andServiceOrderNightAmountLessThanOrEqualTo(Integer value) {
            addCriterion("service_order_night_amount <=", value, "serviceOrderNightAmount");
            return (Criteria) this;
        }

        public Criteria andServiceOrderNightAmountIn(List<Integer> values) {
            addCriterion("service_order_night_amount in", values, "serviceOrderNightAmount");
            return (Criteria) this;
        }

        public Criteria andServiceOrderNightAmountNotIn(List<Integer> values) {
            addCriterion("service_order_night_amount not in", values, "serviceOrderNightAmount");
            return (Criteria) this;
        }

        public Criteria andServiceOrderNightAmountBetween(Integer value1, Integer value2) {
            addCriterion("service_order_night_amount between", value1, value2, "serviceOrderNightAmount");
            return (Criteria) this;
        }

        public Criteria andServiceOrderNightAmountNotBetween(Integer value1, Integer value2) {
            addCriterion("service_order_night_amount not between", value1, value2, "serviceOrderNightAmount");
            return (Criteria) this;
        }

        public Criteria andServiceOrderPriceCoeffcientIsNull() {
            addCriterion("service_order_price_coeffcient is null");
            return (Criteria) this;
        }

        public Criteria andServiceOrderPriceCoeffcientIsNotNull() {
            addCriterion("service_order_price_coeffcient is not null");
            return (Criteria) this;
        }

        public Criteria andServiceOrderPriceCoeffcientEqualTo(Integer value) {
            addCriterion("service_order_price_coeffcient =", value, "serviceOrderPriceCoeffcient");
            return (Criteria) this;
        }

        public Criteria andServiceOrderPriceCoeffcientNotEqualTo(Integer value) {
            addCriterion("service_order_price_coeffcient <>", value, "serviceOrderPriceCoeffcient");
            return (Criteria) this;
        }

        public Criteria andServiceOrderPriceCoeffcientGreaterThan(Integer value) {
            addCriterion("service_order_price_coeffcient >", value, "serviceOrderPriceCoeffcient");
            return (Criteria) this;
        }

        public Criteria andServiceOrderPriceCoeffcientGreaterThanOrEqualTo(Integer value) {
            addCriterion("service_order_price_coeffcient >=", value, "serviceOrderPriceCoeffcient");
            return (Criteria) this;
        }

        public Criteria andServiceOrderPriceCoeffcientLessThan(Integer value) {
            addCriterion("service_order_price_coeffcient <", value, "serviceOrderPriceCoeffcient");
            return (Criteria) this;
        }

        public Criteria andServiceOrderPriceCoeffcientLessThanOrEqualTo(Integer value) {
            addCriterion("service_order_price_coeffcient <=", value, "serviceOrderPriceCoeffcient");
            return (Criteria) this;
        }

        public Criteria andServiceOrderPriceCoeffcientIn(List<Integer> values) {
            addCriterion("service_order_price_coeffcient in", values, "serviceOrderPriceCoeffcient");
            return (Criteria) this;
        }

        public Criteria andServiceOrderPriceCoeffcientNotIn(List<Integer> values) {
            addCriterion("service_order_price_coeffcient not in", values, "serviceOrderPriceCoeffcient");
            return (Criteria) this;
        }

        public Criteria andServiceOrderPriceCoeffcientBetween(Integer value1, Integer value2) {
            addCriterion("service_order_price_coeffcient between", value1, value2, "serviceOrderPriceCoeffcient");
            return (Criteria) this;
        }

        public Criteria andServiceOrderPriceCoeffcientNotBetween(Integer value1, Integer value2) {
            addCriterion("service_order_price_coeffcient not between", value1, value2, "serviceOrderPriceCoeffcient");
            return (Criteria) this;
        }

        public Criteria andServiceOrderAttachmentIsNull() {
            addCriterion("service_order_attachment is null");
            return (Criteria) this;
        }

        public Criteria andServiceOrderAttachmentIsNotNull() {
            addCriterion("service_order_attachment is not null");
            return (Criteria) this;
        }

        public Criteria andServiceOrderAttachmentEqualTo(String value) {
            addCriterion("service_order_attachment =", value, "serviceOrderAttachment");
            return (Criteria) this;
        }

        public Criteria andServiceOrderAttachmentNotEqualTo(String value) {
            addCriterion("service_order_attachment <>", value, "serviceOrderAttachment");
            return (Criteria) this;
        }

        public Criteria andServiceOrderAttachmentGreaterThan(String value) {
            addCriterion("service_order_attachment >", value, "serviceOrderAttachment");
            return (Criteria) this;
        }

        public Criteria andServiceOrderAttachmentGreaterThanOrEqualTo(String value) {
            addCriterion("service_order_attachment >=", value, "serviceOrderAttachment");
            return (Criteria) this;
        }

        public Criteria andServiceOrderAttachmentLessThan(String value) {
            addCriterion("service_order_attachment <", value, "serviceOrderAttachment");
            return (Criteria) this;
        }

        public Criteria andServiceOrderAttachmentLessThanOrEqualTo(String value) {
            addCriterion("service_order_attachment <=", value, "serviceOrderAttachment");
            return (Criteria) this;
        }

        public Criteria andServiceOrderAttachmentLike(String value) {
            addCriterion("service_order_attachment like", value, "serviceOrderAttachment");
            return (Criteria) this;
        }

        public Criteria andServiceOrderAttachmentNotLike(String value) {
            addCriterion("service_order_attachment not like", value, "serviceOrderAttachment");
            return (Criteria) this;
        }

        public Criteria andServiceOrderAttachmentIn(List<String> values) {
            addCriterion("service_order_attachment in", values, "serviceOrderAttachment");
            return (Criteria) this;
        }

        public Criteria andServiceOrderAttachmentNotIn(List<String> values) {
            addCriterion("service_order_attachment not in", values, "serviceOrderAttachment");
            return (Criteria) this;
        }

        public Criteria andServiceOrderAttachmentBetween(String value1, String value2) {
            addCriterion("service_order_attachment between", value1, value2, "serviceOrderAttachment");
            return (Criteria) this;
        }

        public Criteria andServiceOrderAttachmentNotBetween(String value1, String value2) {
            addCriterion("service_order_attachment not between", value1, value2, "serviceOrderAttachment");
            return (Criteria) this;
        }

        public Criteria andServicePayTypeIsNull() {
            addCriterion("service_pay_type is null");
            return (Criteria) this;
        }

        public Criteria andServicePayTypeIsNotNull() {
            addCriterion("service_pay_type is not null");
            return (Criteria) this;
        }

        public Criteria andServicePayTypeEqualTo(String value) {
            addCriterion("service_pay_type =", value, "servicePayType");
            return (Criteria) this;
        }

        public Criteria andServicePayTypeNotEqualTo(String value) {
            addCriterion("service_pay_type <>", value, "servicePayType");
            return (Criteria) this;
        }

        public Criteria andServicePayTypeGreaterThan(String value) {
            addCriterion("service_pay_type >", value, "servicePayType");
            return (Criteria) this;
        }

        public Criteria andServicePayTypeGreaterThanOrEqualTo(String value) {
            addCriterion("service_pay_type >=", value, "servicePayType");
            return (Criteria) this;
        }

        public Criteria andServicePayTypeLessThan(String value) {
            addCriterion("service_pay_type <", value, "servicePayType");
            return (Criteria) this;
        }

        public Criteria andServicePayTypeLessThanOrEqualTo(String value) {
            addCriterion("service_pay_type <=", value, "servicePayType");
            return (Criteria) this;
        }

        public Criteria andServicePayTypeLike(String value) {
            addCriterion("service_pay_type like", value, "servicePayType");
            return (Criteria) this;
        }

        public Criteria andServicePayTypeNotLike(String value) {
            addCriterion("service_pay_type not like", value, "servicePayType");
            return (Criteria) this;
        }

        public Criteria andServicePayTypeIn(List<String> values) {
            addCriterion("service_pay_type in", values, "servicePayType");
            return (Criteria) this;
        }

        public Criteria andServicePayTypeNotIn(List<String> values) {
            addCriterion("service_pay_type not in", values, "servicePayType");
            return (Criteria) this;
        }

        public Criteria andServicePayTypeBetween(String value1, String value2) {
            addCriterion("service_pay_type between", value1, value2, "servicePayType");
            return (Criteria) this;
        }

        public Criteria andServicePayTypeNotBetween(String value1, String value2) {
            addCriterion("service_pay_type not between", value1, value2, "servicePayType");
            return (Criteria) this;
        }

        public Criteria andServiceAgentAmountIsNull() {
            addCriterion("service_agent_amount is null");
            return (Criteria) this;
        }

        public Criteria andServiceAgentAmountIsNotNull() {
            addCriterion("service_agent_amount is not null");
            return (Criteria) this;
        }

        public Criteria andServiceAgentAmountEqualTo(Integer value) {
            addCriterion("service_agent_amount =", value, "serviceAgentAmount");
            return (Criteria) this;
        }

        public Criteria andServiceAgentAmountNotEqualTo(Integer value) {
            addCriterion("service_agent_amount <>", value, "serviceAgentAmount");
            return (Criteria) this;
        }

        public Criteria andServiceAgentAmountGreaterThan(Integer value) {
            addCriterion("service_agent_amount >", value, "serviceAgentAmount");
            return (Criteria) this;
        }

        public Criteria andServiceAgentAmountGreaterThanOrEqualTo(Integer value) {
            addCriterion("service_agent_amount >=", value, "serviceAgentAmount");
            return (Criteria) this;
        }

        public Criteria andServiceAgentAmountLessThan(Integer value) {
            addCriterion("service_agent_amount <", value, "serviceAgentAmount");
            return (Criteria) this;
        }

        public Criteria andServiceAgentAmountLessThanOrEqualTo(Integer value) {
            addCriterion("service_agent_amount <=", value, "serviceAgentAmount");
            return (Criteria) this;
        }

        public Criteria andServiceAgentAmountIn(List<Integer> values) {
            addCriterion("service_agent_amount in", values, "serviceAgentAmount");
            return (Criteria) this;
        }

        public Criteria andServiceAgentAmountNotIn(List<Integer> values) {
            addCriterion("service_agent_amount not in", values, "serviceAgentAmount");
            return (Criteria) this;
        }

        public Criteria andServiceAgentAmountBetween(Integer value1, Integer value2) {
            addCriterion("service_agent_amount between", value1, value2, "serviceAgentAmount");
            return (Criteria) this;
        }

        public Criteria andServiceAgentAmountNotBetween(Integer value1, Integer value2) {
            addCriterion("service_agent_amount not between", value1, value2, "serviceAgentAmount");
            return (Criteria) this;
        }

        public Criteria andServiceAdminAmountIsNull() {
            addCriterion("service_admin_amount is null");
            return (Criteria) this;
        }

        public Criteria andServiceAdminAmountIsNotNull() {
            addCriterion("service_admin_amount is not null");
            return (Criteria) this;
        }

        public Criteria andServiceAdminAmountEqualTo(Integer value) {
            addCriterion("service_admin_amount =", value, "serviceAdminAmount");
            return (Criteria) this;
        }

        public Criteria andServiceAdminAmountNotEqualTo(Integer value) {
            addCriterion("service_admin_amount <>", value, "serviceAdminAmount");
            return (Criteria) this;
        }

        public Criteria andServiceAdminAmountGreaterThan(Integer value) {
            addCriterion("service_admin_amount >", value, "serviceAdminAmount");
            return (Criteria) this;
        }

        public Criteria andServiceAdminAmountGreaterThanOrEqualTo(Integer value) {
            addCriterion("service_admin_amount >=", value, "serviceAdminAmount");
            return (Criteria) this;
        }

        public Criteria andServiceAdminAmountLessThan(Integer value) {
            addCriterion("service_admin_amount <", value, "serviceAdminAmount");
            return (Criteria) this;
        }

        public Criteria andServiceAdminAmountLessThanOrEqualTo(Integer value) {
            addCriterion("service_admin_amount <=", value, "serviceAdminAmount");
            return (Criteria) this;
        }

        public Criteria andServiceAdminAmountIn(List<Integer> values) {
            addCriterion("service_admin_amount in", values, "serviceAdminAmount");
            return (Criteria) this;
        }

        public Criteria andServiceAdminAmountNotIn(List<Integer> values) {
            addCriterion("service_admin_amount not in", values, "serviceAdminAmount");
            return (Criteria) this;
        }

        public Criteria andServiceAdminAmountBetween(Integer value1, Integer value2) {
            addCriterion("service_admin_amount between", value1, value2, "serviceAdminAmount");
            return (Criteria) this;
        }

        public Criteria andServiceAdminAmountNotBetween(Integer value1, Integer value2) {
            addCriterion("service_admin_amount not between", value1, value2, "serviceAdminAmount");
            return (Criteria) this;
        }

        public Criteria andServiceOrderSourceIsNull() {
            addCriterion("service_order_source is null");
            return (Criteria) this;
        }

        public Criteria andServiceOrderSourceIsNotNull() {
            addCriterion("service_order_source is not null");
            return (Criteria) this;
        }

        public Criteria andServiceOrderSourceEqualTo(Integer value) {
            addCriterion("service_order_source =", value, "serviceOrderSource");
            return (Criteria) this;
        }

        public Criteria andServiceOrderSourceNotEqualTo(Integer value) {
            addCriterion("service_order_source <>", value, "serviceOrderSource");
            return (Criteria) this;
        }

        public Criteria andServiceOrderSourceGreaterThan(Integer value) {
            addCriterion("service_order_source >", value, "serviceOrderSource");
            return (Criteria) this;
        }

        public Criteria andServiceOrderSourceGreaterThanOrEqualTo(Integer value) {
            addCriterion("service_order_source >=", value, "serviceOrderSource");
            return (Criteria) this;
        }

        public Criteria andServiceOrderSourceLessThan(Integer value) {
            addCriterion("service_order_source <", value, "serviceOrderSource");
            return (Criteria) this;
        }

        public Criteria andServiceOrderSourceLessThanOrEqualTo(Integer value) {
            addCriterion("service_order_source <=", value, "serviceOrderSource");
            return (Criteria) this;
        }

        public Criteria andServiceOrderSourceIn(List<Integer> values) {
            addCriterion("service_order_source in", values, "serviceOrderSource");
            return (Criteria) this;
        }

        public Criteria andServiceOrderSourceNotIn(List<Integer> values) {
            addCriterion("service_order_source not in", values, "serviceOrderSource");
            return (Criteria) this;
        }

        public Criteria andServiceOrderSourceBetween(Integer value1, Integer value2) {
            addCriterion("service_order_source between", value1, value2, "serviceOrderSource");
            return (Criteria) this;
        }

        public Criteria andServiceOrderSourceNotBetween(Integer value1, Integer value2) {
            addCriterion("service_order_source not between", value1, value2, "serviceOrderSource");
            return (Criteria) this;
        }

        public Criteria andServiceOrderSourceIdIsNull() {
            addCriterion("service_order_source_id is null");
            return (Criteria) this;
        }

        public Criteria andServiceOrderSourceIdIsNotNull() {
            addCriterion("service_order_source_id is not null");
            return (Criteria) this;
        }

        public Criteria andServiceOrderSourceIdEqualTo(Integer value) {
            addCriterion("service_order_source_id =", value, "serviceOrderSourceId");
            return (Criteria) this;
        }
        
        public Criteria andStationIdEqualTo(Integer value) {
            addCriterion("station_id =", value, "stationId");
            return (Criteria) this;
        }
        
        public Criteria andServiceOrderSourceIdNotEqualTo(Integer value) {
            addCriterion("service_order_source_id <>", value, "serviceOrderSourceId");
            return (Criteria) this;
        }

        public Criteria andServiceOrderSourceIdGreaterThan(Integer value) {
            addCriterion("service_order_source_id >", value, "serviceOrderSourceId");
            return (Criteria) this;
        }

        public Criteria andServiceOrderSourceIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("service_order_source_id >=", value, "serviceOrderSourceId");
            return (Criteria) this;
        }

        public Criteria andServiceOrderSourceIdLessThan(Integer value) {
            addCriterion("service_order_source_id <", value, "serviceOrderSourceId");
            return (Criteria) this;
        }

        public Criteria andServiceOrderSourceIdLessThanOrEqualTo(Integer value) {
            addCriterion("service_order_source_id <=", value, "serviceOrderSourceId");
            return (Criteria) this;
        }

        public Criteria andServiceOrderSourceIdIn(List<Integer> values) {
            addCriterion("service_order_source_id in", values, "serviceOrderSourceId");
            return (Criteria) this;
        }

        public Criteria andServiceOrderSourceIdNotIn(List<Integer> values) {
            addCriterion("service_order_source_id not in", values, "serviceOrderSourceId");
            return (Criteria) this;
        }

        public Criteria andServiceOrderSourceIdBetween(Integer value1, Integer value2) {
            addCriterion("service_order_source_id between", value1, value2, "serviceOrderSourceId");
            return (Criteria) this;
        }

        public Criteria andServiceOrderSourceIdNotBetween(Integer value1, Integer value2) {
            addCriterion("service_order_source_id not between", value1, value2, "serviceOrderSourceId");
            return (Criteria) this;
        }

        public Criteria andServiceOrderUrgeIsNull() {
            addCriterion("service_order_urge is null");
            return (Criteria) this;
        }

        public Criteria andServiceOrderUrgeIsNotNull() {
            addCriterion("service_order_urge is not null");
            return (Criteria) this;
        }

        public Criteria andServiceOrderUrgeEqualTo(Integer value) {
            addCriterion("service_order_urge =", value, "serviceOrderUrge");
            return (Criteria) this;
        }

        public Criteria andServiceOrderUrgeNotEqualTo(Integer value) {
            addCriterion("service_order_urge <>", value, "serviceOrderUrge");
            return (Criteria) this;
        }

        public Criteria andServiceOrderUrgeGreaterThan(Integer value) {
            addCriterion("service_order_urge >", value, "serviceOrderUrge");
            return (Criteria) this;
        }

        public Criteria andServiceOrderUrgeGreaterThanOrEqualTo(Integer value) {
            addCriterion("service_order_urge >=", value, "serviceOrderUrge");
            return (Criteria) this;
        }

        public Criteria andServiceOrderUrgeLessThan(Integer value) {
            addCriterion("service_order_urge <", value, "serviceOrderUrge");
            return (Criteria) this;
        }

        public Criteria andServiceOrderUrgeLessThanOrEqualTo(Integer value) {
            addCriterion("service_order_urge <=", value, "serviceOrderUrge");
            return (Criteria) this;
        }

        public Criteria andServiceOrderUrgeIn(List<Integer> values) {
            addCriterion("service_order_urge in", values, "serviceOrderUrge");
            return (Criteria) this;
        }

        public Criteria andServiceOrderUrgeNotIn(List<Integer> values) {
            addCriterion("service_order_urge not in", values, "serviceOrderUrge");
            return (Criteria) this;
        }

        public Criteria andServiceOrderUrgeBetween(Integer value1, Integer value2) {
            addCriterion("service_order_urge between", value1, value2, "serviceOrderUrge");
            return (Criteria) this;
        }

        public Criteria andServiceOrderUrgeNotBetween(Integer value1, Integer value2) {
            addCriterion("service_order_urge not between", value1, value2, "serviceOrderUrge");
            return (Criteria) this;
        }

        public Criteria andServiceOrderAbnormalIsNull() {
            addCriterion("service_order_abnormal is null");
            return (Criteria) this;
        }

        public Criteria andServiceOrderAbnormalIsNotNull() {
            addCriterion("service_order_abnormal is not null");
            return (Criteria) this;
        }

        public Criteria andServiceOrderAbnormalEqualTo(Integer value) {
            addCriterion("service_order_abnormal =", value, "serviceOrderAbnormal");
            return (Criteria) this;
        }

        public Criteria andServiceOrderAbnormalNotEqualTo(Integer value) {
            addCriterion("service_order_abnormal <>", value, "serviceOrderAbnormal");
            return (Criteria) this;
        }

        public Criteria andServiceOrderAbnormalGreaterThan(Integer value) {
            addCriterion("service_order_abnormal >", value, "serviceOrderAbnormal");
            return (Criteria) this;
        }

        public Criteria andServiceOrderAbnormalGreaterThanOrEqualTo(Integer value) {
            addCriterion("service_order_abnormal >=", value, "serviceOrderAbnormal");
            return (Criteria) this;
        }

        public Criteria andServiceOrderAbnormalLessThan(Integer value) {
            addCriterion("service_order_abnormal <", value, "serviceOrderAbnormal");
            return (Criteria) this;
        }

        public Criteria andServiceOrderAbnormalLessThanOrEqualTo(Integer value) {
            addCriterion("service_order_abnormal <=", value, "serviceOrderAbnormal");
            return (Criteria) this;
        }

        public Criteria andServiceOrderAbnormalIn(List<Integer> values) {
            addCriterion("service_order_abnormal in", values, "serviceOrderAbnormal");
            return (Criteria) this;
        }

        public Criteria andServiceOrderAbnormalNotIn(List<Integer> values) {
            addCriterion("service_order_abnormal not in", values, "serviceOrderAbnormal");
            return (Criteria) this;
        }

        public Criteria andServiceOrderAbnormalBetween(Integer value1, Integer value2) {
            addCriterion("service_order_abnormal between", value1, value2, "serviceOrderAbnormal");
            return (Criteria) this;
        }

        public Criteria andServiceOrderAbnormalNotBetween(Integer value1, Integer value2) {
            addCriterion("service_order_abnormal not between", value1, value2, "serviceOrderAbnormal");
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