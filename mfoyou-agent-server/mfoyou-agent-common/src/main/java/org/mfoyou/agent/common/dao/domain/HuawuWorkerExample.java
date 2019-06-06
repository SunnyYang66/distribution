package org.mfoyou.agent.common.dao.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class HuawuWorkerExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    protected Integer limitStart;

    protected Integer limitEnd;
    
    private Integer userType;
    private  Integer userId;
    public HuawuWorkerExample() {
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

    public Integer getUserType() {
		return userType;
	}

	public void setUserType(Integer userType) {
		this.userType = userType;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
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

        public Criteria andAgentIdIsNull(Integer agentId) {
            addCriterion("agent_id is null or agent_id = "+agentId);
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

        public Criteria andWorkerPhoneIsNull() {
            addCriterion("worker_phone is null");
            return (Criteria) this;
        }

        public Criteria andWorkerPhoneIsNotNull() {
            addCriterion("worker_phone is not null");
            return (Criteria) this;
        }

        public Criteria andWorkerPhoneEqualTo(String value) {
            addCriterion("worker_phone =", value, "workerPhone");
            return (Criteria) this;
        }
        
        public Criteria andStationIdEqualTo(Integer value) {
            addCriterion("station_id =", value, "stationId");
            return (Criteria) this;
        }
        
        public Criteria andWorkerPhoneNotEqualTo(String value) {
            addCriterion("worker_phone <>", value, "workerPhone");
            return (Criteria) this;
        }

        public Criteria andWorkerPhoneGreaterThan(String value) {
            addCriterion("worker_phone >", value, "workerPhone");
            return (Criteria) this;
        }

        public Criteria andWorkerPhoneGreaterThanOrEqualTo(String value) {
            addCriterion("worker_phone >=", value, "workerPhone");
            return (Criteria) this;
        }

        public Criteria andWorkerPhoneLessThan(String value) {
            addCriterion("worker_phone <", value, "workerPhone");
            return (Criteria) this;
        }

        public Criteria andWorkerPhoneLessThanOrEqualTo(String value) {
            addCriterion("worker_phone <=", value, "workerPhone");
            return (Criteria) this;
        }

        public Criteria andWorkerPhoneLike(String value) {
            addCriterion("worker_phone like", value, "workerPhone");
            return (Criteria) this;
        }

        public Criteria andWorkerPhoneNotLike(String value) {
            addCriterion("worker_phone not like", value, "workerPhone");
            return (Criteria) this;
        }

        public Criteria andWorkerPhoneIn(List<String> values) {
            addCriterion("worker_phone in", values, "workerPhone");
            return (Criteria) this;
        }

        public Criteria andWorkerPhoneNotIn(List<String> values) {
            addCriterion("worker_phone not in", values, "workerPhone");
            return (Criteria) this;
        }

        public Criteria andWorkerPhoneBetween(String value1, String value2) {
            addCriterion("worker_phone between", value1, value2, "workerPhone");
            return (Criteria) this;
        }

        public Criteria andWorkerPhoneNotBetween(String value1, String value2) {
            addCriterion("worker_phone not between", value1, value2, "workerPhone");
            return (Criteria) this;
        }

        public Criteria andWorkerAddressIsNull() {
            addCriterion("worker_address is null");
            return (Criteria) this;
        }

        public Criteria andWorkerAddressIsNotNull() {
            addCriterion("worker_address is not null");
            return (Criteria) this;
        }

        public Criteria andWorkerAddressEqualTo(String value) {
            addCriterion("worker_address =", value, "workerAddress");
            return (Criteria) this;
        }

        public Criteria andWorkerAddressNotEqualTo(String value) {
            addCriterion("worker_address <>", value, "workerAddress");
            return (Criteria) this;
        }

        public Criteria andWorkerAddressGreaterThan(String value) {
            addCriterion("worker_address >", value, "workerAddress");
            return (Criteria) this;
        }

        public Criteria andWorkerAddressGreaterThanOrEqualTo(String value) {
            addCriterion("worker_address >=", value, "workerAddress");
            return (Criteria) this;
        }

        public Criteria andWorkerAddressLessThan(String value) {
            addCriterion("worker_address <", value, "workerAddress");
            return (Criteria) this;
        }

        public Criteria andWorkerAddressLessThanOrEqualTo(String value) {
            addCriterion("worker_address <=", value, "workerAddress");
            return (Criteria) this;
        }

        public Criteria andWorkerAddressLike(String value) {
            addCriterion("worker_address like", value, "workerAddress");
            return (Criteria) this;
        }

        public Criteria andWorkerAddressNotLike(String value) {
            addCriterion("worker_address not like", value, "workerAddress");
            return (Criteria) this;
        }

        public Criteria andWorkerAddressIn(List<String> values) {
            addCriterion("worker_address in", values, "workerAddress");
            return (Criteria) this;
        }

        public Criteria andWorkerAddressNotIn(List<String> values) {
            addCriterion("worker_address not in", values, "workerAddress");
            return (Criteria) this;
        }

        public Criteria andWorkerAddressBetween(String value1, String value2) {
            addCriterion("worker_address between", value1, value2, "workerAddress");
            return (Criteria) this;
        }

        public Criteria andWorkerAddressNotBetween(String value1, String value2) {
            addCriterion("worker_address not between", value1, value2, "workerAddress");
            return (Criteria) this;
        }

        public Criteria andWorkerStarIsNull() {
            addCriterion("worker_star is null");
            return (Criteria) this;
        }

        public Criteria andWorkerStarIsNotNull() {
            addCriterion("worker_star is not null");
            return (Criteria) this;
        }

        public Criteria andWorkerStarEqualTo(String value) {
            addCriterion("worker_star =", value, "workerStar");
            return (Criteria) this;
        }

        public Criteria andWorkerStarNotEqualTo(String value) {
            addCriterion("worker_star <>", value, "workerStar");
            return (Criteria) this;
        }

        public Criteria andWorkerStarGreaterThan(String value) {
            addCriterion("worker_star >", value, "workerStar");
            return (Criteria) this;
        }

        public Criteria andWorkerStarGreaterThanOrEqualTo(String value) {
            addCriterion("worker_star >=", value, "workerStar");
            return (Criteria) this;
        }

        public Criteria andWorkerStarLessThan(String value) {
            addCriterion("worker_star <", value, "workerStar");
            return (Criteria) this;
        }

        public Criteria andWorkerStarLessThanOrEqualTo(String value) {
            addCriterion("worker_star <=", value, "workerStar");
            return (Criteria) this;
        }

        public Criteria andWorkerStarLike(String value) {
            addCriterion("worker_star like", value, "workerStar");
            return (Criteria) this;
        }

        public Criteria andWorkerStarNotLike(String value) {
            addCriterion("worker_star not like", value, "workerStar");
            return (Criteria) this;
        }

        public Criteria andWorkerStarIn(List<String> values) {
            addCriterion("worker_star in", values, "workerStar");
            return (Criteria) this;
        }

        public Criteria andWorkerStarNotIn(List<String> values) {
            addCriterion("worker_star not in", values, "workerStar");
            return (Criteria) this;
        }

        public Criteria andWorkerStarBetween(String value1, String value2) {
            addCriterion("worker_star between", value1, value2, "workerStar");
            return (Criteria) this;
        }

        public Criteria andWorkerStarNotBetween(String value1, String value2) {
            addCriterion("worker_star not between", value1, value2, "workerStar");
            return (Criteria) this;
        }

        public Criteria andWorkerOrderCountIsNull() {
            addCriterion("worker_order_count is null");
            return (Criteria) this;
        }

        public Criteria andWorkerOrderCountIsNotNull() {
            addCriterion("worker_order_count is not null");
            return (Criteria) this;
        }

        public Criteria andWorkerOrderCountEqualTo(Integer value) {
            addCriterion("worker_order_count =", value, "workerOrderCount");
            return (Criteria) this;
        }

        public Criteria andWorkerOrderCountNotEqualTo(Integer value) {
            addCriterion("worker_order_count <>", value, "workerOrderCount");
            return (Criteria) this;
        }

        public Criteria andWorkerOrderCountGreaterThan(Integer value) {
            addCriterion("worker_order_count >", value, "workerOrderCount");
            return (Criteria) this;
        }

        public Criteria andWorkerOrderCountGreaterThanOrEqualTo(Integer value) {
            addCriterion("worker_order_count >=", value, "workerOrderCount");
            return (Criteria) this;
        }

        public Criteria andWorkerOrderCountLessThan(Integer value) {
            addCriterion("worker_order_count <", value, "workerOrderCount");
            return (Criteria) this;
        }

        public Criteria andWorkerOrderCountLessThanOrEqualTo(Integer value) {
            addCriterion("worker_order_count <=", value, "workerOrderCount");
            return (Criteria) this;
        }

        public Criteria andWorkerOrderCountIn(List<Integer> values) {
            addCriterion("worker_order_count in", values, "workerOrderCount");
            return (Criteria) this;
        }

        public Criteria andWorkerOrderCountNotIn(List<Integer> values) {
            addCriterion("worker_order_count not in", values, "workerOrderCount");
            return (Criteria) this;
        }

        public Criteria andWorkerOrderCountBetween(Integer value1, Integer value2) {
            addCriterion("worker_order_count between", value1, value2, "workerOrderCount");
            return (Criteria) this;
        }

        public Criteria andWorkerOrderCountNotBetween(Integer value1, Integer value2) {
            addCriterion("worker_order_count not between", value1, value2, "workerOrderCount");
            return (Criteria) this;
        }

        public Criteria andWorkerServiceDistanceIsNull() {
            addCriterion("worker_service_distance is null");
            return (Criteria) this;
        }

        public Criteria andWorkerServiceDistanceIsNotNull() {
            addCriterion("worker_service_distance is not null");
            return (Criteria) this;
        }

        public Criteria andWorkerServiceDistanceEqualTo(Integer value) {
            addCriterion("worker_service_distance =", value, "workerServiceDistance");
            return (Criteria) this;
        }

        public Criteria andWorkerServiceDistanceNotEqualTo(Integer value) {
            addCriterion("worker_service_distance <>", value, "workerServiceDistance");
            return (Criteria) this;
        }

        public Criteria andWorkerServiceDistanceGreaterThan(Integer value) {
            addCriterion("worker_service_distance >", value, "workerServiceDistance");
            return (Criteria) this;
        }

        public Criteria andWorkerServiceDistanceGreaterThanOrEqualTo(Integer value) {
            addCriterion("worker_service_distance >=", value, "workerServiceDistance");
            return (Criteria) this;
        }

        public Criteria andWorkerServiceDistanceLessThan(Integer value) {
            addCriterion("worker_service_distance <", value, "workerServiceDistance");
            return (Criteria) this;
        }

        public Criteria andWorkerServiceDistanceLessThanOrEqualTo(Integer value) {
            addCriterion("worker_service_distance <=", value, "workerServiceDistance");
            return (Criteria) this;
        }

        public Criteria andWorkerServiceDistanceIn(List<Integer> values) {
            addCriterion("worker_service_distance in", values, "workerServiceDistance");
            return (Criteria) this;
        }

        public Criteria andWorkerServiceDistanceNotIn(List<Integer> values) {
            addCriterion("worker_service_distance not in", values, "workerServiceDistance");
            return (Criteria) this;
        }

        public Criteria andWorkerServiceDistanceBetween(Integer value1, Integer value2) {
            addCriterion("worker_service_distance between", value1, value2, "workerServiceDistance");
            return (Criteria) this;
        }

        public Criteria andWorkerServiceDistanceNotBetween(Integer value1, Integer value2) {
            addCriterion("worker_service_distance not between", value1, value2, "workerServiceDistance");
            return (Criteria) this;
        }

        public Criteria andWorkerStateIsNull() {
            addCriterion("worker_state is null");
            return (Criteria) this;
        }

        public Criteria andWorkerStateIsNotNull() {
            addCriterion("worker_state is not null");
            return (Criteria) this;
        }

        public Criteria andWorkerStateEqualTo(Integer value) {
            addCriterion("worker_state =", value, "workerState");
            return (Criteria) this;
        }

        public Criteria andWorkerStateNotEqualTo(Integer value) {
            addCriterion("worker_state <>", value, "workerState");
            return (Criteria) this;
        }

        public Criteria andWorkerStateGreaterThan(Integer value) {
            addCriterion("worker_state >", value, "workerState");
            return (Criteria) this;
        }

        public Criteria andWorkerStateGreaterThanOrEqualTo(Integer value) {
            addCriterion("worker_state >=", value, "workerState");
            return (Criteria) this;
        }

        public Criteria andWorkerStateLessThan(Integer value) {
            addCriterion("worker_state <", value, "workerState");
            return (Criteria) this;
        }

        public Criteria andWorkerStateLessThanOrEqualTo(Integer value) {
            addCriterion("worker_state <=", value, "workerState");
            return (Criteria) this;
        }

        public Criteria andWorkerStateIn(List<Integer> values) {
            addCriterion("worker_state in", values, "workerState");
            return (Criteria) this;
        }

        public Criteria andWorkerStateNotIn(List<Integer> values) {
            addCriterion("worker_state not in", values, "workerState");
            return (Criteria) this;
        }

        public Criteria andWorkerStateBetween(Integer value1, Integer value2) {
            addCriterion("worker_state between", value1, value2, "workerState");
            return (Criteria) this;
        }

        public Criteria andWorkerStateNotBetween(Integer value1, Integer value2) {
            addCriterion("worker_state not between", value1, value2, "workerState");
            return (Criteria) this;
        }

        public Criteria andWorkerOpenStateIsNull() {
            addCriterion("worker_open_state is null");
            return (Criteria) this;
        }

        public Criteria andWorkerOpenStateIsNotNull() {
            addCriterion("worker_open_state is not null");
            return (Criteria) this;
        }

        public Criteria andWorkerOpenStateEqualTo(Integer value) {
        	if(value==-1){
        		addCriterion("(select count(*)  from huawu_idcard_info where huawu_idcard_info.user_id = huawu_worker.user_id)=0");
        	}else{
        		addCriterion("(select count(*)  from huawu_idcard_info where huawu_idcard_info.user_id = huawu_worker.user_id and state = 2)  >0");
        	}
            return (Criteria) this;
        }
        public Criteria andWorkerOpenStateEqualToV1(Integer value) {
        	addCriterion("worker_open_state =", value, "workerOpenState");
            return (Criteria) this;
        }
        public Criteria andWorkerOpenStateNotEqualTo(Integer value) {
            addCriterion("worker_open_state <>", value, "workerOpenState");
            return (Criteria) this;
        }

        public Criteria andWorkerOpenStateGreaterThan(Integer value) {
            addCriterion("worker_open_state >", value, "workerOpenState");
            return (Criteria) this;
        }

        public Criteria andWorkerOpenStateGreaterThanOrEqualTo(Integer value) {
            addCriterion("worker_open_state >=", value, "workerOpenState");
            return (Criteria) this;
        }

        public Criteria andWorkerOpenStateLessThan(Integer value) {
            addCriterion("worker_open_state <", value, "workerOpenState");
            return (Criteria) this;
        }

        public Criteria andWorkerOpenStateLessThanOrEqualTo(Integer value) {
            addCriterion("worker_open_state <=", value, "workerOpenState");
            return (Criteria) this;
        }

        public Criteria andWorkerOpenStateIn(List<Integer> values) {
            addCriterion("worker_open_state in", values, "workerOpenState");
            return (Criteria) this;
        }

        public Criteria andWorkerOpenStateNotIn(List<Integer> values) {
            addCriterion("worker_open_state not in", values, "workerOpenState");
            return (Criteria) this;
        }

        public Criteria andWorkerOpenStateBetween(Integer value1, Integer value2) {
            addCriterion("worker_open_state between", value1, value2, "workerOpenState");
            return (Criteria) this;
        }

        public Criteria andWorkerOpenStateNotBetween(Integer value1, Integer value2) {
            addCriterion("worker_open_state not between", value1, value2, "workerOpenState");
            return (Criteria) this;
        }

        public Criteria andWorkerLongIsNull() {
            addCriterion("worker_long is null");
            return (Criteria) this;
        }

        public Criteria andWorkerLongIsNotNull() {
            addCriterion("worker_long is not null");
            return (Criteria) this;
        }

        public Criteria andWorkerLongEqualTo(Double value) {
            addCriterion("worker_long =", value, "workerLong");
            return (Criteria) this;
        }

        public Criteria andWorkerLongNotEqualTo(Double value) {
            addCriterion("worker_long <>", value, "workerLong");
            return (Criteria) this;
        }

        public Criteria andWorkerLongGreaterThan(Double value) {
            addCriterion("worker_long >", value, "workerLong");
            return (Criteria) this;
        }

        public Criteria andWorkerLongGreaterThanOrEqualTo(Double value) {
            addCriterion("worker_long >=", value, "workerLong");
            return (Criteria) this;
        }

        public Criteria andWorkerLongLessThan(Double value) {
            addCriterion("worker_long <", value, "workerLong");
            return (Criteria) this;
        }

        public Criteria andWorkerLongLessThanOrEqualTo(Double value) {
            addCriterion("worker_long <=", value, "workerLong");
            return (Criteria) this;
        }

        public Criteria andWorkerLongIn(List<Double> values) {
            addCriterion("worker_long in", values, "workerLong");
            return (Criteria) this;
        }

        public Criteria andWorkerLongNotIn(List<Double> values) {
            addCriterion("worker_long not in", values, "workerLong");
            return (Criteria) this;
        }

        public Criteria andWorkerLongBetween(Double value1, Double value2) {
            addCriterion("worker_long between", value1, value2, "workerLong");
            return (Criteria) this;
        }

        public Criteria andWorkerLongNotBetween(Double value1, Double value2) {
            addCriterion("worker_long not between", value1, value2, "workerLong");
            return (Criteria) this;
        }

        public Criteria andWorkerLatIsNull() {
            addCriterion("worker_lat is null");
            return (Criteria) this;
        }

        public Criteria andWorkerLatIsNotNull() {
            addCriterion("worker_lat is not null");
            return (Criteria) this;
        }

        public Criteria andWorkerLatEqualTo(Double value) {
            addCriterion("worker_lat =", value, "workerLat");
            return (Criteria) this;
        }

        public Criteria andWorkerLatNotEqualTo(Double value) {
            addCriterion("worker_lat <>", value, "workerLat");
            return (Criteria) this;
        }

        public Criteria andWorkerLatGreaterThan(Double value) {
            addCriterion("worker_lat >", value, "workerLat");
            return (Criteria) this;
        }

        public Criteria andWorkerLatGreaterThanOrEqualTo(Double value) {
            addCriterion("worker_lat >=", value, "workerLat");
            return (Criteria) this;
        }

        public Criteria andWorkerLatLessThan(Double value) {
            addCriterion("worker_lat <", value, "workerLat");
            return (Criteria) this;
        }

        public Criteria andWorkerLatLessThanOrEqualTo(Double value) {
            addCriterion("worker_lat <=", value, "workerLat");
            return (Criteria) this;
        }

        public Criteria andWorkerLatIn(List<Double> values) {
            addCriterion("worker_lat in", values, "workerLat");
            return (Criteria) this;
        }

        public Criteria andWorkerLatNotIn(List<Double> values) {
            addCriterion("worker_lat not in", values, "workerLat");
            return (Criteria) this;
        }

        public Criteria andWorkerLatBetween(Double value1, Double value2) {
            addCriterion("worker_lat between", value1, value2, "workerLat");
            return (Criteria) this;
        }

        public Criteria andWorkerLatNotBetween(Double value1, Double value2) {
            addCriterion("worker_lat not between", value1, value2, "workerLat");
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

        public Criteria andWorkerThirdAuthIsNull() {
            addCriterion("worker_third_auth is null");
            return (Criteria) this;
        }

        public Criteria andWorkerThirdAuthIsNotNull() {
            addCriterion("worker_third_auth is not null");
            return (Criteria) this;
        }

        public Criteria andWorkerThirdAuthEqualTo(Integer value) {
            addCriterion("worker_third_auth =", value, "workerThirdAuth");
            return (Criteria) this;
        }

        public Criteria andWorkerThirdAuthNotEqualTo(Integer value) {
            addCriterion("worker_third_auth <>", value, "workerThirdAuth");
            return (Criteria) this;
        }

        public Criteria andWorkerThirdAuthGreaterThan(Integer value) {
            addCriterion("worker_third_auth >", value, "workerThirdAuth");
            return (Criteria) this;
        }

        public Criteria andWorkerThirdAuthGreaterThanOrEqualTo(Integer value) {
            addCriterion("worker_third_auth >=", value, "workerThirdAuth");
            return (Criteria) this;
        }

        public Criteria andWorkerThirdAuthLessThan(Integer value) {
            addCriterion("worker_third_auth <", value, "workerThirdAuth");
            return (Criteria) this;
        }

        public Criteria andWorkerThirdAuthLessThanOrEqualTo(Integer value) {
            addCriterion("worker_third_auth <=", value, "workerThirdAuth");
            return (Criteria) this;
        }

        public Criteria andWorkerThirdAuthIn(List<Integer> values) {
            addCriterion("worker_third_auth in", values, "workerThirdAuth");
            return (Criteria) this;
        }

        public Criteria andWorkerThirdAuthNotIn(List<Integer> values) {
            addCriterion("worker_third_auth not in", values, "workerThirdAuth");
            return (Criteria) this;
        }

        public Criteria andWorkerThirdAuthBetween(Integer value1, Integer value2) {
            addCriterion("worker_third_auth between", value1, value2, "workerThirdAuth");
            return (Criteria) this;
        }

        public Criteria andWorkerThirdAuthNotBetween(Integer value1, Integer value2) {
            addCriterion("worker_third_auth not between", value1, value2, "workerThirdAuth");
            return (Criteria) this;
        }

        public Criteria andWorkerFeeIsNull() {
            addCriterion("worker_fee is null");
            return (Criteria) this;
        }

        public Criteria andWorkerFeeIsNotNull() {
            addCriterion("worker_fee is not null");
            return (Criteria) this;
        }

        public Criteria andWorkerFeeEqualTo(Integer value) {
            addCriterion("worker_fee =", value, "workerFee");
            return (Criteria) this;
        }

        public Criteria andWorkerFeeNotEqualTo(Integer value) {
            addCriterion("worker_fee <>", value, "workerFee");
            return (Criteria) this;
        }

        public Criteria andWorkerFeeGreaterThan(Integer value) {
            addCriterion("worker_fee >", value, "workerFee");
            return (Criteria) this;
        }

        public Criteria andWorkerFeeGreaterThanOrEqualTo(Integer value) {
            addCriterion("worker_fee >=", value, "workerFee");
            return (Criteria) this;
        }

        public Criteria andWorkerFeeLessThan(Integer value) {
            addCriterion("worker_fee <", value, "workerFee");
            return (Criteria) this;
        }

        public Criteria andWorkerFeeLessThanOrEqualTo(Integer value) {
            addCriterion("worker_fee <=", value, "workerFee");
            return (Criteria) this;
        }

        public Criteria andWorkerFeeIn(List<Integer> values) {
            addCriterion("worker_fee in", values, "workerFee");
            return (Criteria) this;
        }

        public Criteria andWorkerFeeNotIn(List<Integer> values) {
            addCriterion("worker_fee not in", values, "workerFee");
            return (Criteria) this;
        }

        public Criteria andWorkerFeeBetween(Integer value1, Integer value2) {
            addCriterion("worker_fee between", value1, value2, "workerFee");
            return (Criteria) this;
        }

        public Criteria andWorkerFeeNotBetween(Integer value1, Integer value2) {
            addCriterion("worker_fee not between", value1, value2, "workerFee");
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