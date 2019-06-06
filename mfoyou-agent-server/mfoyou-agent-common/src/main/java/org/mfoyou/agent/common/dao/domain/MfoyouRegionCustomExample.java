package org.mfoyou.agent.common.dao.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class MfoyouRegionCustomExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    protected Integer limitStart;

    protected Integer limitEnd;

    public MfoyouRegionCustomExample() {
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

        public Criteria andRegionCustomIdIsNull() {
            addCriterion("region_custom_id is null");
            return (Criteria) this;
        }

        public Criteria andRegionCustomIdIsNotNull() {
            addCriterion("region_custom_id is not null");
            return (Criteria) this;
        }

        public Criteria andRegionCustomIdEqualTo(Integer value) {
            addCriterion("region_custom_id =", value, "regionCustomId");
            return (Criteria) this;
        }

        public Criteria andRegionCustomIdNotEqualTo(Integer value) {
            addCriterion("region_custom_id <>", value, "regionCustomId");
            return (Criteria) this;
        }

        public Criteria andRegionCustomIdGreaterThan(Integer value) {
            addCriterion("region_custom_id >", value, "regionCustomId");
            return (Criteria) this;
        }

        public Criteria andRegionCustomIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("region_custom_id >=", value, "regionCustomId");
            return (Criteria) this;
        }

        public Criteria andRegionCustomIdLessThan(Integer value) {
            addCriterion("region_custom_id <", value, "regionCustomId");
            return (Criteria) this;
        }

        public Criteria andRegionCustomIdLessThanOrEqualTo(Integer value) {
            addCriterion("region_custom_id <=", value, "regionCustomId");
            return (Criteria) this;
        }

        public Criteria andRegionCustomIdIn(List<Integer> values) {
            addCriterion("region_custom_id in", values, "regionCustomId");
            return (Criteria) this;
        }

        public Criteria andRegionCustomIdNotIn(List<Integer> values) {
            addCriterion("region_custom_id not in", values, "regionCustomId");
            return (Criteria) this;
        }

        public Criteria andRegionCustomIdBetween(Integer value1, Integer value2) {
            addCriterion("region_custom_id between", value1, value2, "regionCustomId");
            return (Criteria) this;
        }

        public Criteria andRegionCustomIdNotBetween(Integer value1, Integer value2) {
            addCriterion("region_custom_id not between", value1, value2, "regionCustomId");
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

        public Criteria andRegionCustomLonIsNull() {
            addCriterion("region_custom_lon is null");
            return (Criteria) this;
        }

        public Criteria andRegionCustomLonIsNotNull() {
            addCriterion("region_custom_lon is not null");
            return (Criteria) this;
        }

        public Criteria andRegionCustomLonEqualTo(Double value) {
            addCriterion("region_custom_lon =", value, "regionCustomLon");
            return (Criteria) this;
        }

        public Criteria andRegionCustomLonNotEqualTo(Double value) {
            addCriterion("region_custom_lon <>", value, "regionCustomLon");
            return (Criteria) this;
        }

        public Criteria andRegionCustomLonGreaterThan(Double value) {
            addCriterion("region_custom_lon >", value, "regionCustomLon");
            return (Criteria) this;
        }

        public Criteria andRegionCustomLonGreaterThanOrEqualTo(Double value) {
            addCriterion("region_custom_lon >=", value, "regionCustomLon");
            return (Criteria) this;
        }

        public Criteria andRegionCustomLonLessThan(Double value) {
            addCriterion("region_custom_lon <", value, "regionCustomLon");
            return (Criteria) this;
        }

        public Criteria andRegionCustomLonLessThanOrEqualTo(Double value) {
            addCriterion("region_custom_lon <=", value, "regionCustomLon");
            return (Criteria) this;
        }

        public Criteria andRegionCustomLonIn(List<Double> values) {
            addCriterion("region_custom_lon in", values, "regionCustomLon");
            return (Criteria) this;
        }

        public Criteria andRegionCustomLonNotIn(List<Double> values) {
            addCriterion("region_custom_lon not in", values, "regionCustomLon");
            return (Criteria) this;
        }

        public Criteria andRegionCustomLonBetween(Double value1, Double value2) {
            addCriterion("region_custom_lon between", value1, value2, "regionCustomLon");
            return (Criteria) this;
        }

        public Criteria andRegionCustomLonNotBetween(Double value1, Double value2) {
            addCriterion("region_custom_lon not between", value1, value2, "regionCustomLon");
            return (Criteria) this;
        }

        public Criteria andRegionCustomLatIsNull() {
            addCriterion("region_custom_lat is null");
            return (Criteria) this;
        }

        public Criteria andRegionCustomLatIsNotNull() {
            addCriterion("region_custom_lat is not null");
            return (Criteria) this;
        }

        public Criteria andRegionCustomLatEqualTo(Double value) {
            addCriterion("region_custom_lat =", value, "regionCustomLat");
            return (Criteria) this;
        }

        public Criteria andRegionCustomLatNotEqualTo(Double value) {
            addCriterion("region_custom_lat <>", value, "regionCustomLat");
            return (Criteria) this;
        }

        public Criteria andRegionCustomLatGreaterThan(Double value) {
            addCriterion("region_custom_lat >", value, "regionCustomLat");
            return (Criteria) this;
        }

        public Criteria andRegionCustomLatGreaterThanOrEqualTo(Double value) {
            addCriterion("region_custom_lat >=", value, "regionCustomLat");
            return (Criteria) this;
        }

        public Criteria andRegionCustomLatLessThan(Double value) {
            addCriterion("region_custom_lat <", value, "regionCustomLat");
            return (Criteria) this;
        }

        public Criteria andRegionCustomLatLessThanOrEqualTo(Double value) {
            addCriterion("region_custom_lat <=", value, "regionCustomLat");
            return (Criteria) this;
        }

        public Criteria andRegionCustomLatIn(List<Double> values) {
            addCriterion("region_custom_lat in", values, "regionCustomLat");
            return (Criteria) this;
        }

        public Criteria andRegionCustomLatNotIn(List<Double> values) {
            addCriterion("region_custom_lat not in", values, "regionCustomLat");
            return (Criteria) this;
        }

        public Criteria andRegionCustomLatBetween(Double value1, Double value2) {
            addCriterion("region_custom_lat between", value1, value2, "regionCustomLat");
            return (Criteria) this;
        }

        public Criteria andRegionCustomLatNotBetween(Double value1, Double value2) {
            addCriterion("region_custom_lat not between", value1, value2, "regionCustomLat");
            return (Criteria) this;
        }

        public Criteria andRegionCustomNameIsNull() {
            addCriterion("region_custom_name is null");
            return (Criteria) this;
        }

        public Criteria andRegionCustomNameIsNotNull() {
            addCriterion("region_custom_name is not null");
            return (Criteria) this;
        }

        public Criteria andRegionCustomNameEqualTo(String value) {
            addCriterion("region_custom_name =", value, "regionCustomName");
            return (Criteria) this;
        }

        public Criteria andRegionCustomNameNotEqualTo(String value) {
            addCriterion("region_custom_name <>", value, "regionCustomName");
            return (Criteria) this;
        }

        public Criteria andRegionCustomNameGreaterThan(String value) {
            addCriterion("region_custom_name >", value, "regionCustomName");
            return (Criteria) this;
        }

        public Criteria andRegionCustomNameGreaterThanOrEqualTo(String value) {
            addCriterion("region_custom_name >=", value, "regionCustomName");
            return (Criteria) this;
        }

        public Criteria andRegionCustomNameLessThan(String value) {
            addCriterion("region_custom_name <", value, "regionCustomName");
            return (Criteria) this;
        }

        public Criteria andRegionCustomNameLessThanOrEqualTo(String value) {
            addCriterion("region_custom_name <=", value, "regionCustomName");
            return (Criteria) this;
        }

        public Criteria andRegionCustomNameLike(String value) {
            addCriterion("region_custom_name like", value, "regionCustomName");
            return (Criteria) this;
        }

        public Criteria andRegionCustomNameNotLike(String value) {
            addCriterion("region_custom_name not like", value, "regionCustomName");
            return (Criteria) this;
        }

        public Criteria andRegionCustomNameIn(List<String> values) {
            addCriterion("region_custom_name in", values, "regionCustomName");
            return (Criteria) this;
        }

        public Criteria andRegionCustomNameNotIn(List<String> values) {
            addCriterion("region_custom_name not in", values, "regionCustomName");
            return (Criteria) this;
        }

        public Criteria andRegionCustomNameBetween(String value1, String value2) {
            addCriterion("region_custom_name between", value1, value2, "regionCustomName");
            return (Criteria) this;
        }

        public Criteria andRegionCustomNameNotBetween(String value1, String value2) {
            addCriterion("region_custom_name not between", value1, value2, "regionCustomName");
            return (Criteria) this;
        }

        public Criteria andRegionCustomValidIsNull() {
            addCriterion("region_custom_valid is null");
            return (Criteria) this;
        }

        public Criteria andRegionCustomValidIsNotNull() {
            addCriterion("region_custom_valid is not null");
            return (Criteria) this;
        }

        public Criteria andRegionCustomValidEqualTo(Integer value) {
            addCriterion("region_custom_valid =", value, "regionCustomValid");
            return (Criteria) this;
        }

        public Criteria andRegionCustomValidNotEqualTo(Integer value) {
            addCriterion("region_custom_valid <>", value, "regionCustomValid");
            return (Criteria) this;
        }

        public Criteria andRegionCustomValidGreaterThan(Integer value) {
            addCriterion("region_custom_valid >", value, "regionCustomValid");
            return (Criteria) this;
        }

        public Criteria andRegionCustomValidGreaterThanOrEqualTo(Integer value) {
            addCriterion("region_custom_valid >=", value, "regionCustomValid");
            return (Criteria) this;
        }

        public Criteria andRegionCustomValidLessThan(Integer value) {
            addCriterion("region_custom_valid <", value, "regionCustomValid");
            return (Criteria) this;
        }

        public Criteria andRegionCustomValidLessThanOrEqualTo(Integer value) {
            addCriterion("region_custom_valid <=", value, "regionCustomValid");
            return (Criteria) this;
        }

        public Criteria andRegionCustomValidIn(List<Integer> values) {
            addCriterion("region_custom_valid in", values, "regionCustomValid");
            return (Criteria) this;
        }

        public Criteria andRegionCustomValidNotIn(List<Integer> values) {
            addCriterion("region_custom_valid not in", values, "regionCustomValid");
            return (Criteria) this;
        }

        public Criteria andRegionCustomValidBetween(Integer value1, Integer value2) {
            addCriterion("region_custom_valid between", value1, value2, "regionCustomValid");
            return (Criteria) this;
        }

        public Criteria andRegionCustomValidNotBetween(Integer value1, Integer value2) {
            addCriterion("region_custom_valid not between", value1, value2, "regionCustomValid");
            return (Criteria) this;
        }

        public Criteria andRegionCustomCreateTimeIsNull() {
            addCriterion("region_custom_create_time is null");
            return (Criteria) this;
        }

        public Criteria andRegionCustomCreateTimeIsNotNull() {
            addCriterion("region_custom_create_time is not null");
            return (Criteria) this;
        }

        public Criteria andRegionCustomCreateTimeEqualTo(Date value) {
            addCriterion("region_custom_create_time =", value, "regionCustomCreateTime");
            return (Criteria) this;
        }

        public Criteria andRegionCustomCreateTimeNotEqualTo(Date value) {
            addCriterion("region_custom_create_time <>", value, "regionCustomCreateTime");
            return (Criteria) this;
        }

        public Criteria andRegionCustomCreateTimeGreaterThan(Date value) {
            addCriterion("region_custom_create_time >", value, "regionCustomCreateTime");
            return (Criteria) this;
        }

        public Criteria andRegionCustomCreateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("region_custom_create_time >=", value, "regionCustomCreateTime");
            return (Criteria) this;
        }

        public Criteria andRegionCustomCreateTimeLessThan(Date value) {
            addCriterion("region_custom_create_time <", value, "regionCustomCreateTime");
            return (Criteria) this;
        }

        public Criteria andRegionCustomCreateTimeLessThanOrEqualTo(Date value) {
            addCriterion("region_custom_create_time <=", value, "regionCustomCreateTime");
            return (Criteria) this;
        }

        public Criteria andRegionCustomCreateTimeIn(List<Date> values) {
            addCriterion("region_custom_create_time in", values, "regionCustomCreateTime");
            return (Criteria) this;
        }

        public Criteria andRegionCustomCreateTimeNotIn(List<Date> values) {
            addCriterion("region_custom_create_time not in", values, "regionCustomCreateTime");
            return (Criteria) this;
        }

        public Criteria andRegionCustomCreateTimeBetween(Date value1, Date value2) {
            addCriterion("region_custom_create_time between", value1, value2, "regionCustomCreateTime");
            return (Criteria) this;
        }

        public Criteria andRegionCustomCreateTimeNotBetween(Date value1, Date value2) {
            addCriterion("region_custom_create_time not between", value1, value2, "regionCustomCreateTime");
            return (Criteria) this;
        }

        public Criteria andRegionCustomModfiyTimeIsNull() {
            addCriterion("region_custom_modfiy_time is null");
            return (Criteria) this;
        }

        public Criteria andRegionCustomModfiyTimeIsNotNull() {
            addCriterion("region_custom_modfiy_time is not null");
            return (Criteria) this;
        }

        public Criteria andRegionCustomModfiyTimeEqualTo(Date value) {
            addCriterion("region_custom_modfiy_time =", value, "regionCustomModfiyTime");
            return (Criteria) this;
        }

        public Criteria andRegionCustomModfiyTimeNotEqualTo(Date value) {
            addCriterion("region_custom_modfiy_time <>", value, "regionCustomModfiyTime");
            return (Criteria) this;
        }

        public Criteria andRegionCustomModfiyTimeGreaterThan(Date value) {
            addCriterion("region_custom_modfiy_time >", value, "regionCustomModfiyTime");
            return (Criteria) this;
        }

        public Criteria andRegionCustomModfiyTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("region_custom_modfiy_time >=", value, "regionCustomModfiyTime");
            return (Criteria) this;
        }

        public Criteria andRegionCustomModfiyTimeLessThan(Date value) {
            addCriterion("region_custom_modfiy_time <", value, "regionCustomModfiyTime");
            return (Criteria) this;
        }

        public Criteria andRegionCustomModfiyTimeLessThanOrEqualTo(Date value) {
            addCriterion("region_custom_modfiy_time <=", value, "regionCustomModfiyTime");
            return (Criteria) this;
        }

        public Criteria andRegionCustomModfiyTimeIn(List<Date> values) {
            addCriterion("region_custom_modfiy_time in", values, "regionCustomModfiyTime");
            return (Criteria) this;
        }

        public Criteria andRegionCustomModfiyTimeNotIn(List<Date> values) {
            addCriterion("region_custom_modfiy_time not in", values, "regionCustomModfiyTime");
            return (Criteria) this;
        }

        public Criteria andRegionCustomModfiyTimeBetween(Date value1, Date value2) {
            addCriterion("region_custom_modfiy_time between", value1, value2, "regionCustomModfiyTime");
            return (Criteria) this;
        }

        public Criteria andRegionCustomModfiyTimeNotBetween(Date value1, Date value2) {
            addCriterion("region_custom_modfiy_time not between", value1, value2, "regionCustomModfiyTime");
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