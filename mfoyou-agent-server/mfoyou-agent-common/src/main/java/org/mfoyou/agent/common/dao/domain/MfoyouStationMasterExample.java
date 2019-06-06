package org.mfoyou.agent.common.dao.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class MfoyouStationMasterExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    protected Integer limitStart;

    protected Integer limitEnd;

    public MfoyouStationMasterExample() {
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

        public Criteria andStationIdIsNull() {
            addCriterion("station_id is null");
            return (Criteria) this;
        }

        public Criteria andStationIdIsNotNull() {
            addCriterion("station_id is not null");
            return (Criteria) this;
        }

        public Criteria andStationIdEqualTo(Integer value) {
            addCriterion("station_id =", value, "stationId");
            return (Criteria) this;
        }

        public Criteria andStationIdNotEqualTo(Integer value) {
            addCriterion("station_id <>", value, "stationId");
            return (Criteria) this;
        }

        public Criteria andStationIdGreaterThan(Integer value) {
            addCriterion("station_id >", value, "stationId");
            return (Criteria) this;
        }

        public Criteria andStationIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("station_id >=", value, "stationId");
            return (Criteria) this;
        }

        public Criteria andStationIdLessThan(Integer value) {
            addCriterion("station_id <", value, "stationId");
            return (Criteria) this;
        }

        public Criteria andStationIdLessThanOrEqualTo(Integer value) {
            addCriterion("station_id <=", value, "stationId");
            return (Criteria) this;
        }

        public Criteria andStationIdIn(List<Integer> values) {
            addCriterion("station_id in", values, "stationId");
            return (Criteria) this;
        }

        public Criteria andStationIdNotIn(List<Integer> values) {
            addCriterion("station_id not in", values, "stationId");
            return (Criteria) this;
        }

        public Criteria andStationIdBetween(Integer value1, Integer value2) {
            addCriterion("station_id between", value1, value2, "stationId");
            return (Criteria) this;
        }

        public Criteria andStationIdNotBetween(Integer value1, Integer value2) {
            addCriterion("station_id not between", value1, value2, "stationId");
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

        public Criteria andAgentCoordinateAreaIsNull() {
            addCriterion("agent_coordinate_area is null");
            return (Criteria) this;
        }

        public Criteria andAgentCoordinateAreaIsNotNull() {
            addCriterion("agent_coordinate_area is not null");
            return (Criteria) this;
        }

        public Criteria andAgentCoordinateAreaEqualTo(String value) {
            addCriterion("agent_coordinate_area =", value, "agentCoordinateArea");
            return (Criteria) this;
        }

        public Criteria andAgentCoordinateAreaNotEqualTo(String value) {
            addCriterion("agent_coordinate_area <>", value, "agentCoordinateArea");
            return (Criteria) this;
        }

        public Criteria andAgentCoordinateAreaGreaterThan(String value) {
            addCriterion("agent_coordinate_area >", value, "agentCoordinateArea");
            return (Criteria) this;
        }

        public Criteria andAgentCoordinateAreaGreaterThanOrEqualTo(String value) {
            addCriterion("agent_coordinate_area >=", value, "agentCoordinateArea");
            return (Criteria) this;
        }

        public Criteria andAgentCoordinateAreaLessThan(String value) {
            addCriterion("agent_coordinate_area <", value, "agentCoordinateArea");
            return (Criteria) this;
        }

        public Criteria andAgentCoordinateAreaLessThanOrEqualTo(String value) {
            addCriterion("agent_coordinate_area <=", value, "agentCoordinateArea");
            return (Criteria) this;
        }

        public Criteria andAgentCoordinateAreaLike(String value) {
            addCriterion("agent_coordinate_area like", value, "agentCoordinateArea");
            return (Criteria) this;
        }

        public Criteria andAgentCoordinateAreaNotLike(String value) {
            addCriterion("agent_coordinate_area not like", value, "agentCoordinateArea");
            return (Criteria) this;
        }

        public Criteria andAgentCoordinateAreaIn(List<String> values) {
            addCriterion("agent_coordinate_area in", values, "agentCoordinateArea");
            return (Criteria) this;
        }

        public Criteria andAgentCoordinateAreaNotIn(List<String> values) {
            addCriterion("agent_coordinate_area not in", values, "agentCoordinateArea");
            return (Criteria) this;
        }

        public Criteria andAgentCoordinateAreaBetween(String value1, String value2) {
            addCriterion("agent_coordinate_area between", value1, value2, "agentCoordinateArea");
            return (Criteria) this;
        }

        public Criteria andAgentCoordinateAreaNotBetween(String value1, String value2) {
            addCriterion("agent_coordinate_area not between", value1, value2, "agentCoordinateArea");
            return (Criteria) this;
        }

        public Criteria andStationAreaNameIsNull() {
            addCriterion("station_area_name is null");
            return (Criteria) this;
        }

        public Criteria andStationAreaNameIsNotNull() {
            addCriterion("station_area_name is not null");
            return (Criteria) this;
        }

        public Criteria andStationAreaNameEqualTo(String value) {
            addCriterion("station_area_name =", value, "stationAreaName");
            return (Criteria) this;
        }

        public Criteria andStationAreaNameNotEqualTo(String value) {
            addCriterion("station_area_name <>", value, "stationAreaName");
            return (Criteria) this;
        }

        public Criteria andStationAreaNameGreaterThan(String value) {
            addCriterion("station_area_name >", value, "stationAreaName");
            return (Criteria) this;
        }

        public Criteria andStationAreaNameGreaterThanOrEqualTo(String value) {
            addCriterion("station_area_name >=", value, "stationAreaName");
            return (Criteria) this;
        }

        public Criteria andStationAreaNameLessThan(String value) {
            addCriterion("station_area_name <", value, "stationAreaName");
            return (Criteria) this;
        }

        public Criteria andStationAreaNameLessThanOrEqualTo(String value) {
            addCriterion("station_area_name <=", value, "stationAreaName");
            return (Criteria) this;
        }

        public Criteria andStationAreaNameLike(String value) {
            addCriterion("station_area_name like", value, "stationAreaName");
            return (Criteria) this;
        }

        public Criteria andStationAreaNameNotLike(String value) {
            addCriterion("station_area_name not like", value, "stationAreaName");
            return (Criteria) this;
        }

        public Criteria andStationAreaNameIn(List<String> values) {
            addCriterion("station_area_name in", values, "stationAreaName");
            return (Criteria) this;
        }

        public Criteria andStationAreaNameNotIn(List<String> values) {
            addCriterion("station_area_name not in", values, "stationAreaName");
            return (Criteria) this;
        }

        public Criteria andStationAreaNameBetween(String value1, String value2) {
            addCriterion("station_area_name between", value1, value2, "stationAreaName");
            return (Criteria) this;
        }

        public Criteria andStationAreaNameNotBetween(String value1, String value2) {
            addCriterion("station_area_name not between", value1, value2, "stationAreaName");
            return (Criteria) this;
        }

        public Criteria andPowerStateIsNull() {
            addCriterion("power_state is null");
            return (Criteria) this;
        }

        public Criteria andPowerStateIsNotNull() {
            addCriterion("power_state is not null");
            return (Criteria) this;
        }

        public Criteria andPowerStateEqualTo(Integer value) {
            addCriterion("power_state =", value, "powerState");
            return (Criteria) this;
        }

        public Criteria andPowerStateNotEqualTo(Integer value) {
            addCriterion("power_state <>", value, "powerState");
            return (Criteria) this;
        }

        public Criteria andPowerStateGreaterThan(Integer value) {
            addCriterion("power_state >", value, "powerState");
            return (Criteria) this;
        }

        public Criteria andPowerStateGreaterThanOrEqualTo(Integer value) {
            addCriterion("power_state >=", value, "powerState");
            return (Criteria) this;
        }

        public Criteria andPowerStateLessThan(Integer value) {
            addCriterion("power_state <", value, "powerState");
            return (Criteria) this;
        }

        public Criteria andPowerStateLessThanOrEqualTo(Integer value) {
            addCriterion("power_state <=", value, "powerState");
            return (Criteria) this;
        }

        public Criteria andPowerStateIn(List<Integer> values) {
            addCriterion("power_state in", values, "powerState");
            return (Criteria) this;
        }

        public Criteria andPowerStateNotIn(List<Integer> values) {
            addCriterion("power_state not in", values, "powerState");
            return (Criteria) this;
        }

        public Criteria andPowerStateBetween(Integer value1, Integer value2) {
            addCriterion("power_state between", value1, value2, "powerState");
            return (Criteria) this;
        }

        public Criteria andPowerStateNotBetween(Integer value1, Integer value2) {
            addCriterion("power_state not between", value1, value2, "powerState");
            return (Criteria) this;
        }

        public Criteria andStoreShareFeeIsNull() {
            addCriterion("store_share_fee is null");
            return (Criteria) this;
        }

        public Criteria andStoreShareFeeIsNotNull() {
            addCriterion("store_share_fee is not null");
            return (Criteria) this;
        }

        public Criteria andStoreShareFeeEqualTo(Integer value) {
            addCriterion("store_share_fee =", value, "storeShareFee");
            return (Criteria) this;
        }

        public Criteria andStoreShareFeeNotEqualTo(Integer value) {
            addCriterion("store_share_fee <>", value, "storeShareFee");
            return (Criteria) this;
        }

        public Criteria andStoreShareFeeGreaterThan(Integer value) {
            addCriterion("store_share_fee >", value, "storeShareFee");
            return (Criteria) this;
        }

        public Criteria andStoreShareFeeGreaterThanOrEqualTo(Integer value) {
            addCriterion("store_share_fee >=", value, "storeShareFee");
            return (Criteria) this;
        }

        public Criteria andStoreShareFeeLessThan(Integer value) {
            addCriterion("store_share_fee <", value, "storeShareFee");
            return (Criteria) this;
        }

        public Criteria andStoreShareFeeLessThanOrEqualTo(Integer value) {
            addCriterion("store_share_fee <=", value, "storeShareFee");
            return (Criteria) this;
        }

        public Criteria andStoreShareFeeIn(List<Integer> values) {
            addCriterion("store_share_fee in", values, "storeShareFee");
            return (Criteria) this;
        }

        public Criteria andStoreShareFeeNotIn(List<Integer> values) {
            addCriterion("store_share_fee not in", values, "storeShareFee");
            return (Criteria) this;
        }

        public Criteria andStoreShareFeeBetween(Integer value1, Integer value2) {
            addCriterion("store_share_fee between", value1, value2, "storeShareFee");
            return (Criteria) this;
        }

        public Criteria andStoreShareFeeNotBetween(Integer value1, Integer value2) {
            addCriterion("store_share_fee not between", value1, value2, "storeShareFee");
            return (Criteria) this;
        }

        public Criteria andRunnerShareFeeIsNull() {
            addCriterion("runner_share_fee is null");
            return (Criteria) this;
        }

        public Criteria andRunnerShareFeeIsNotNull() {
            addCriterion("runner_share_fee is not null");
            return (Criteria) this;
        }

        public Criteria andRunnerShareFeeEqualTo(Integer value) {
            addCriterion("runner_share_fee =", value, "runnerShareFee");
            return (Criteria) this;
        }

        public Criteria andRunnerShareFeeNotEqualTo(Integer value) {
            addCriterion("runner_share_fee <>", value, "runnerShareFee");
            return (Criteria) this;
        }

        public Criteria andRunnerShareFeeGreaterThan(Integer value) {
            addCriterion("runner_share_fee >", value, "runnerShareFee");
            return (Criteria) this;
        }

        public Criteria andRunnerShareFeeGreaterThanOrEqualTo(Integer value) {
            addCriterion("runner_share_fee >=", value, "runnerShareFee");
            return (Criteria) this;
        }

        public Criteria andRunnerShareFeeLessThan(Integer value) {
            addCriterion("runner_share_fee <", value, "runnerShareFee");
            return (Criteria) this;
        }

        public Criteria andRunnerShareFeeLessThanOrEqualTo(Integer value) {
            addCriterion("runner_share_fee <=", value, "runnerShareFee");
            return (Criteria) this;
        }

        public Criteria andRunnerShareFeeIn(List<Integer> values) {
            addCriterion("runner_share_fee in", values, "runnerShareFee");
            return (Criteria) this;
        }

        public Criteria andRunnerShareFeeNotIn(List<Integer> values) {
            addCriterion("runner_share_fee not in", values, "runnerShareFee");
            return (Criteria) this;
        }

        public Criteria andRunnerShareFeeBetween(Integer value1, Integer value2) {
            addCriterion("runner_share_fee between", value1, value2, "runnerShareFee");
            return (Criteria) this;
        }

        public Criteria andRunnerShareFeeNotBetween(Integer value1, Integer value2) {
            addCriterion("runner_share_fee not between", value1, value2, "runnerShareFee");
            return (Criteria) this;
        }

        public Criteria andStationLoginNumberIsNull() {
            addCriterion("station_login_number is null");
            return (Criteria) this;
        }

        public Criteria andStationLoginNumberIsNotNull() {
            addCriterion("station_login_number is not null");
            return (Criteria) this;
        }

        public Criteria andStationLoginNumberEqualTo(String value) {
            addCriterion("station_login_number =", value, "stationLoginNumber");
            return (Criteria) this;
        }

        public Criteria andStationLoginNumberNotEqualTo(String value) {
            addCriterion("station_login_number <>", value, "stationLoginNumber");
            return (Criteria) this;
        }

        public Criteria andStationLoginNumberGreaterThan(String value) {
            addCriterion("station_login_number >", value, "stationLoginNumber");
            return (Criteria) this;
        }

        public Criteria andStationLoginNumberGreaterThanOrEqualTo(String value) {
            addCriterion("station_login_number >=", value, "stationLoginNumber");
            return (Criteria) this;
        }

        public Criteria andStationLoginNumberLessThan(String value) {
            addCriterion("station_login_number <", value, "stationLoginNumber");
            return (Criteria) this;
        }

        public Criteria andStationLoginNumberLessThanOrEqualTo(String value) {
            addCriterion("station_login_number <=", value, "stationLoginNumber");
            return (Criteria) this;
        }

        public Criteria andStationLoginNumberLike(String value) {
            addCriterion("station_login_number like", value, "stationLoginNumber");
            return (Criteria) this;
        }

        public Criteria andStationLoginNumberNotLike(String value) {
            addCriterion("station_login_number not like", value, "stationLoginNumber");
            return (Criteria) this;
        }

        public Criteria andStationLoginNumberIn(List<String> values) {
            addCriterion("station_login_number in", values, "stationLoginNumber");
            return (Criteria) this;
        }

        public Criteria andStationLoginNumberNotIn(List<String> values) {
            addCriterion("station_login_number not in", values, "stationLoginNumber");
            return (Criteria) this;
        }

        public Criteria andStationLoginNumberBetween(String value1, String value2) {
            addCriterion("station_login_number between", value1, value2, "stationLoginNumber");
            return (Criteria) this;
        }

        public Criteria andStationLoginNumberNotBetween(String value1, String value2) {
            addCriterion("station_login_number not between", value1, value2, "stationLoginNumber");
            return (Criteria) this;
        }

        public Criteria andCreatTimeIsNull() {
            addCriterion("creat_time is null");
            return (Criteria) this;
        }

        public Criteria andCreatTimeIsNotNull() {
            addCriterion("creat_time is not null");
            return (Criteria) this;
        }

        public Criteria andCreatTimeEqualTo(Date value) {
            addCriterion("creat_time =", value, "creatTime");
            return (Criteria) this;
        }

        public Criteria andCreatTimeNotEqualTo(Date value) {
            addCriterion("creat_time <>", value, "creatTime");
            return (Criteria) this;
        }

        public Criteria andCreatTimeGreaterThan(Date value) {
            addCriterion("creat_time >", value, "creatTime");
            return (Criteria) this;
        }

        public Criteria andCreatTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("creat_time >=", value, "creatTime");
            return (Criteria) this;
        }

        public Criteria andCreatTimeLessThan(Date value) {
            addCriterion("creat_time <", value, "creatTime");
            return (Criteria) this;
        }

        public Criteria andCreatTimeLessThanOrEqualTo(Date value) {
            addCriterion("creat_time <=", value, "creatTime");
            return (Criteria) this;
        }

        public Criteria andCreatTimeIn(List<Date> values) {
            addCriterion("creat_time in", values, "creatTime");
            return (Criteria) this;
        }

        public Criteria andCreatTimeNotIn(List<Date> values) {
            addCriterion("creat_time not in", values, "creatTime");
            return (Criteria) this;
        }

        public Criteria andCreatTimeBetween(Date value1, Date value2) {
            addCriterion("creat_time between", value1, value2, "creatTime");
            return (Criteria) this;
        }

        public Criteria andCreatTimeNotBetween(Date value1, Date value2) {
            addCriterion("creat_time not between", value1, value2, "creatTime");
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

        public Criteria andStationNameIsNull() {
            addCriterion("station_name is null");
            return (Criteria) this;
        }

        public Criteria andStationNameIsNotNull() {
            addCriterion("station_name is not null");
            return (Criteria) this;
        }

        public Criteria andStationNameEqualTo(String value) {
            addCriterion("station_name =", value, "stationName");
            return (Criteria) this;
        }

        public Criteria andStationNameNotEqualTo(String value) {
            addCriterion("station_name <>", value, "stationName");
            return (Criteria) this;
        }

        public Criteria andStationNameGreaterThan(String value) {
            addCriterion("station_name >", value, "stationName");
            return (Criteria) this;
        }

        public Criteria andStationNameGreaterThanOrEqualTo(String value) {
            addCriterion("station_name >=", value, "stationName");
            return (Criteria) this;
        }

        public Criteria andStationNameLessThan(String value) {
            addCriterion("station_name <", value, "stationName");
            return (Criteria) this;
        }

        public Criteria andStationNameLessThanOrEqualTo(String value) {
            addCriterion("station_name <=", value, "stationName");
            return (Criteria) this;
        }

        public Criteria andStationNameLike(String value) {
            addCriterion("station_name like", value, "stationName");
            return (Criteria) this;
        }

        public Criteria andStationNameNotLike(String value) {
            addCriterion("station_name not like", value, "stationName");
            return (Criteria) this;
        }

        public Criteria andStationNameIn(List<String> values) {
            addCriterion("station_name in", values, "stationName");
            return (Criteria) this;
        }

        public Criteria andStationNameNotIn(List<String> values) {
            addCriterion("station_name not in", values, "stationName");
            return (Criteria) this;
        }

        public Criteria andStationNameBetween(String value1, String value2) {
            addCriterion("station_name between", value1, value2, "stationName");
            return (Criteria) this;
        }

        public Criteria andStationNameNotBetween(String value1, String value2) {
            addCriterion("station_name not between", value1, value2, "stationName");
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