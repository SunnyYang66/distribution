package org.mfoyou.agent.common.dao.mfoyou.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class MfoyouGoodsOrderExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    protected Integer limitStart;

    protected Integer limitEnd;

    public MfoyouGoodsOrderExample() {
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

        public Criteria andOrderIdIsNull() {
            addCriterion("order_id is null");
            return (Criteria) this;
        }

        public Criteria andOrderIdIsNotNull() {
            addCriterion("order_id is not null");
            return (Criteria) this;
        }

        public Criteria andOrderIdEqualTo(Integer value) {
            addCriterion("order_id =", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdNotEqualTo(Integer value) {
            addCriterion("order_id <>", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdGreaterThan(Integer value) {
            addCriterion("order_id >", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("order_id >=", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdLessThan(Integer value) {
            addCriterion("order_id <", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdLessThanOrEqualTo(Integer value) {
            addCriterion("order_id <=", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdIn(List<Integer> values) {
            addCriterion("order_id in", values, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdNotIn(List<Integer> values) {
            addCriterion("order_id not in", values, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdBetween(Integer value1, Integer value2) {
            addCriterion("order_id between", value1, value2, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdNotBetween(Integer value1, Integer value2) {
            addCriterion("order_id not between", value1, value2, "orderId");
            return (Criteria) this;
        }

        public Criteria andStoreIdIsNull() {
            addCriterion("store_id is null");
            return (Criteria) this;
        }

        public Criteria andStoreIdIsNotNull() {
            addCriterion("store_id is not null");
            return (Criteria) this;
        }

        public Criteria andStoreIdEqualTo(Integer value) {
            addCriterion("store_id =", value, "storeId");
            return (Criteria) this;
        }

        public Criteria andStoreIdNotEqualTo(Integer value) {
            addCriterion("store_id <>", value, "storeId");
            return (Criteria) this;
        }

        public Criteria andStoreIdGreaterThan(Integer value) {
            addCriterion("store_id >", value, "storeId");
            return (Criteria) this;
        }

        public Criteria andStoreIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("store_id >=", value, "storeId");
            return (Criteria) this;
        }

        public Criteria andStoreIdLessThan(Integer value) {
            addCriterion("store_id <", value, "storeId");
            return (Criteria) this;
        }

        public Criteria andStoreIdLessThanOrEqualTo(Integer value) {
            addCriterion("store_id <=", value, "storeId");
            return (Criteria) this;
        }

        public Criteria andStoreIdIn(List<Integer> values) {
            addCriterion("store_id in", values, "storeId");
            return (Criteria) this;
        }

        public Criteria andStoreIdNotIn(List<Integer> values) {
            addCriterion("store_id not in", values, "storeId");
            return (Criteria) this;
        }

        public Criteria andStoreIdBetween(Integer value1, Integer value2) {
            addCriterion("store_id between", value1, value2, "storeId");
            return (Criteria) this;
        }

        public Criteria andStoreIdNotBetween(Integer value1, Integer value2) {
            addCriterion("store_id not between", value1, value2, "storeId");
            return (Criteria) this;
        }

        public Criteria andStoreNameIsNull() {
            addCriterion("store_name is null");
            return (Criteria) this;
        }

        public Criteria andStoreNameIsNotNull() {
            addCriterion("store_name is not null");
            return (Criteria) this;
        }

        public Criteria andStoreNameEqualTo(String value) {
            addCriterion("store_name =", value, "storeName");
            return (Criteria) this;
        }

        public Criteria andStoreNameNotEqualTo(String value) {
            addCriterion("store_name <>", value, "storeName");
            return (Criteria) this;
        }

        public Criteria andStoreNameGreaterThan(String value) {
            addCriterion("store_name >", value, "storeName");
            return (Criteria) this;
        }

        public Criteria andStoreNameGreaterThanOrEqualTo(String value) {
            addCriterion("store_name >=", value, "storeName");
            return (Criteria) this;
        }

        public Criteria andStoreNameLessThan(String value) {
            addCriterion("store_name <", value, "storeName");
            return (Criteria) this;
        }

        public Criteria andStoreNameLessThanOrEqualTo(String value) {
            addCriterion("store_name <=", value, "storeName");
            return (Criteria) this;
        }

        public Criteria andStoreNameLike(String value) {
            addCriterion("store_name like", value, "storeName");
            return (Criteria) this;
        }

        public Criteria andStoreNameNotLike(String value) {
            addCriterion("store_name not like", value, "storeName");
            return (Criteria) this;
        }

        public Criteria andStoreNameIn(List<String> values) {
            addCriterion("store_name in", values, "storeName");
            return (Criteria) this;
        }

        public Criteria andStoreNameNotIn(List<String> values) {
            addCriterion("store_name not in", values, "storeName");
            return (Criteria) this;
        }

        public Criteria andStoreNameBetween(String value1, String value2) {
            addCriterion("store_name between", value1, value2, "storeName");
            return (Criteria) this;
        }

        public Criteria andStoreNameNotBetween(String value1, String value2) {
            addCriterion("store_name not between", value1, value2, "storeName");
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

        public Criteria andAreaAgentIdIsNull() {
            addCriterion("area_agent_id is null");
            return (Criteria) this;
        }

        public Criteria andAreaAgentIdIsNotNull() {
            addCriterion("area_agent_id is not null");
            return (Criteria) this;
        }

        public Criteria andAreaAgentIdEqualTo(Integer value) {
            addCriterion("area_agent_id =", value, "areaAgentId");
            return (Criteria) this;
        }

        public Criteria andAreaAgentIdNotEqualTo(Integer value) {
            addCriterion("area_agent_id <>", value, "areaAgentId");
            return (Criteria) this;
        }

        public Criteria andAreaAgentIdGreaterThan(Integer value) {
            addCriterion("area_agent_id >", value, "areaAgentId");
            return (Criteria) this;
        }

        public Criteria andAreaAgentIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("area_agent_id >=", value, "areaAgentId");
            return (Criteria) this;
        }

        public Criteria andAreaAgentIdLessThan(Integer value) {
            addCriterion("area_agent_id <", value, "areaAgentId");
            return (Criteria) this;
        }

        public Criteria andAreaAgentIdLessThanOrEqualTo(Integer value) {
            addCriterion("area_agent_id <=", value, "areaAgentId");
            return (Criteria) this;
        }

        public Criteria andAreaAgentIdIn(List<Integer> values) {
            addCriterion("area_agent_id in", values, "areaAgentId");
            return (Criteria) this;
        }

        public Criteria andAreaAgentIdNotIn(List<Integer> values) {
            addCriterion("area_agent_id not in", values, "areaAgentId");
            return (Criteria) this;
        }

        public Criteria andAreaAgentIdBetween(Integer value1, Integer value2) {
            addCriterion("area_agent_id between", value1, value2, "areaAgentId");
            return (Criteria) this;
        }

        public Criteria andAreaAgentIdNotBetween(Integer value1, Integer value2) {
            addCriterion("area_agent_id not between", value1, value2, "areaAgentId");
            return (Criteria) this;
        }

        public Criteria andOrderStateIsNull() {
            addCriterion("order_state is null");
            return (Criteria) this;
        }

        public Criteria andOrderStateIsNotNull() {
            addCriterion("order_state is not null");
            return (Criteria) this;
        }

        public Criteria andOrderStateEqualTo(Integer value) {
            addCriterion("order_state =", value, "orderState");
            return (Criteria) this;
        }

        public Criteria andOrderStateNotEqualTo(Integer value) {
            addCriterion("order_state <>", value, "orderState");
            return (Criteria) this;
        }

        public Criteria andOrderStateGreaterThan(Integer value) {
            addCriterion("order_state >", value, "orderState");
            return (Criteria) this;
        }

        public Criteria andOrderStateGreaterThanOrEqualTo(Integer value) {
            addCriterion("order_state >=", value, "orderState");
            return (Criteria) this;
        }

        public Criteria andOrderStateLessThan(Integer value) {
            addCriterion("order_state <", value, "orderState");
            return (Criteria) this;
        }

        public Criteria andOrderStateLessThanOrEqualTo(Integer value) {
            addCriterion("order_state <=", value, "orderState");
            return (Criteria) this;
        }

        public Criteria andOrderStateIn(List<Integer> values) {
            addCriterion("order_state in", values, "orderState");
            return (Criteria) this;
        }

        public Criteria andOrderStateNotIn(List<Integer> values) {
            addCriterion("order_state not in", values, "orderState");
            return (Criteria) this;
        }

        public Criteria andOrderStateBetween(Integer value1, Integer value2) {
            addCriterion("order_state between", value1, value2, "orderState");
            return (Criteria) this;
        }

        public Criteria andOrderStateNotBetween(Integer value1, Integer value2) {
            addCriterion("order_state not between", value1, value2, "orderState");
            return (Criteria) this;
        }

        public Criteria andOrderNumberIsNull() {
            addCriterion("order_number is null");
            return (Criteria) this;
        }

        public Criteria andOrderNumberIsNotNull() {
            addCriterion("order_number is not null");
            return (Criteria) this;
        }

        public Criteria andOrderNumberEqualTo(String value) {
            addCriterion("order_number =", value, "orderNumber");
            return (Criteria) this;
        }

        public Criteria andOrderNumberNotEqualTo(String value) {
            addCriterion("order_number <>", value, "orderNumber");
            return (Criteria) this;
        }

        public Criteria andOrderNumberGreaterThan(String value) {
            addCriterion("order_number >", value, "orderNumber");
            return (Criteria) this;
        }

        public Criteria andOrderNumberGreaterThanOrEqualTo(String value) {
            addCriterion("order_number >=", value, "orderNumber");
            return (Criteria) this;
        }

        public Criteria andOrderNumberLessThan(String value) {
            addCriterion("order_number <", value, "orderNumber");
            return (Criteria) this;
        }

        public Criteria andOrderNumberLessThanOrEqualTo(String value) {
            addCriterion("order_number <=", value, "orderNumber");
            return (Criteria) this;
        }

        public Criteria andOrderNumberLike(String value) {
            addCriterion("order_number like", value, "orderNumber");
            return (Criteria) this;
        }

        public Criteria andOrderNumberNotLike(String value) {
            addCriterion("order_number not like", value, "orderNumber");
            return (Criteria) this;
        }

        public Criteria andOrderNumberIn(List<String> values) {
            addCriterion("order_number in", values, "orderNumber");
            return (Criteria) this;
        }

        public Criteria andOrderNumberNotIn(List<String> values) {
            addCriterion("order_number not in", values, "orderNumber");
            return (Criteria) this;
        }

        public Criteria andOrderNumberBetween(String value1, String value2) {
            addCriterion("order_number between", value1, value2, "orderNumber");
            return (Criteria) this;
        }

        public Criteria andOrderNumberNotBetween(String value1, String value2) {
            addCriterion("order_number not between", value1, value2, "orderNumber");
            return (Criteria) this;
        }

        public Criteria andOrderTitleIsNull() {
            addCriterion("order_title is null");
            return (Criteria) this;
        }

        public Criteria andOrderTitleIsNotNull() {
            addCriterion("order_title is not null");
            return (Criteria) this;
        }

        public Criteria andOrderTitleEqualTo(String value) {
            addCriterion("order_title =", value, "orderTitle");
            return (Criteria) this;
        }

        public Criteria andOrderTitleNotEqualTo(String value) {
            addCriterion("order_title <>", value, "orderTitle");
            return (Criteria) this;
        }

        public Criteria andOrderTitleGreaterThan(String value) {
            addCriterion("order_title >", value, "orderTitle");
            return (Criteria) this;
        }

        public Criteria andOrderTitleGreaterThanOrEqualTo(String value) {
            addCriterion("order_title >=", value, "orderTitle");
            return (Criteria) this;
        }

        public Criteria andOrderTitleLessThan(String value) {
            addCriterion("order_title <", value, "orderTitle");
            return (Criteria) this;
        }

        public Criteria andOrderTitleLessThanOrEqualTo(String value) {
            addCriterion("order_title <=", value, "orderTitle");
            return (Criteria) this;
        }

        public Criteria andOrderTitleLike(String value) {
            addCriterion("order_title like", value, "orderTitle");
            return (Criteria) this;
        }

        public Criteria andOrderTitleNotLike(String value) {
            addCriterion("order_title not like", value, "orderTitle");
            return (Criteria) this;
        }

        public Criteria andOrderTitleIn(List<String> values) {
            addCriterion("order_title in", values, "orderTitle");
            return (Criteria) this;
        }

        public Criteria andOrderTitleNotIn(List<String> values) {
            addCriterion("order_title not in", values, "orderTitle");
            return (Criteria) this;
        }

        public Criteria andOrderTitleBetween(String value1, String value2) {
            addCriterion("order_title between", value1, value2, "orderTitle");
            return (Criteria) this;
        }

        public Criteria andOrderTitleNotBetween(String value1, String value2) {
            addCriterion("order_title not between", value1, value2, "orderTitle");
            return (Criteria) this;
        }

        public Criteria andOrderNoteIsNull() {
            addCriterion("order_note is null");
            return (Criteria) this;
        }

        public Criteria andOrderNoteIsNotNull() {
            addCriterion("order_note is not null");
            return (Criteria) this;
        }

        public Criteria andOrderNoteEqualTo(String value) {
            addCriterion("order_note =", value, "orderNote");
            return (Criteria) this;
        }

        public Criteria andOrderNoteNotEqualTo(String value) {
            addCriterion("order_note <>", value, "orderNote");
            return (Criteria) this;
        }

        public Criteria andOrderNoteGreaterThan(String value) {
            addCriterion("order_note >", value, "orderNote");
            return (Criteria) this;
        }

        public Criteria andOrderNoteGreaterThanOrEqualTo(String value) {
            addCriterion("order_note >=", value, "orderNote");
            return (Criteria) this;
        }

        public Criteria andOrderNoteLessThan(String value) {
            addCriterion("order_note <", value, "orderNote");
            return (Criteria) this;
        }

        public Criteria andOrderNoteLessThanOrEqualTo(String value) {
            addCriterion("order_note <=", value, "orderNote");
            return (Criteria) this;
        }

        public Criteria andOrderNoteLike(String value) {
            addCriterion("order_note like", value, "orderNote");
            return (Criteria) this;
        }

        public Criteria andOrderNoteNotLike(String value) {
            addCriterion("order_note not like", value, "orderNote");
            return (Criteria) this;
        }

        public Criteria andOrderNoteIn(List<String> values) {
            addCriterion("order_note in", values, "orderNote");
            return (Criteria) this;
        }

        public Criteria andOrderNoteNotIn(List<String> values) {
            addCriterion("order_note not in", values, "orderNote");
            return (Criteria) this;
        }

        public Criteria andOrderNoteBetween(String value1, String value2) {
            addCriterion("order_note between", value1, value2, "orderNote");
            return (Criteria) this;
        }

        public Criteria andOrderNoteNotBetween(String value1, String value2) {
            addCriterion("order_note not between", value1, value2, "orderNote");
            return (Criteria) this;
        }

        public Criteria andOrderGoodsCountIsNull() {
            addCriterion("order_goods_count is null");
            return (Criteria) this;
        }

        public Criteria andOrderGoodsCountIsNotNull() {
            addCriterion("order_goods_count is not null");
            return (Criteria) this;
        }

        public Criteria andOrderGoodsCountEqualTo(Integer value) {
            addCriterion("order_goods_count =", value, "orderGoodsCount");
            return (Criteria) this;
        }

        public Criteria andOrderGoodsCountNotEqualTo(Integer value) {
            addCriterion("order_goods_count <>", value, "orderGoodsCount");
            return (Criteria) this;
        }

        public Criteria andOrderGoodsCountGreaterThan(Integer value) {
            addCriterion("order_goods_count >", value, "orderGoodsCount");
            return (Criteria) this;
        }

        public Criteria andOrderGoodsCountGreaterThanOrEqualTo(Integer value) {
            addCriterion("order_goods_count >=", value, "orderGoodsCount");
            return (Criteria) this;
        }

        public Criteria andOrderGoodsCountLessThan(Integer value) {
            addCriterion("order_goods_count <", value, "orderGoodsCount");
            return (Criteria) this;
        }

        public Criteria andOrderGoodsCountLessThanOrEqualTo(Integer value) {
            addCriterion("order_goods_count <=", value, "orderGoodsCount");
            return (Criteria) this;
        }

        public Criteria andOrderGoodsCountIn(List<Integer> values) {
            addCriterion("order_goods_count in", values, "orderGoodsCount");
            return (Criteria) this;
        }

        public Criteria andOrderGoodsCountNotIn(List<Integer> values) {
            addCriterion("order_goods_count not in", values, "orderGoodsCount");
            return (Criteria) this;
        }

        public Criteria andOrderGoodsCountBetween(Integer value1, Integer value2) {
            addCriterion("order_goods_count between", value1, value2, "orderGoodsCount");
            return (Criteria) this;
        }

        public Criteria andOrderGoodsCountNotBetween(Integer value1, Integer value2) {
            addCriterion("order_goods_count not between", value1, value2, "orderGoodsCount");
            return (Criteria) this;
        }

        public Criteria andOrderTotalAmountIsNull() {
            addCriterion("order_total_amount is null");
            return (Criteria) this;
        }

        public Criteria andOrderTotalAmountIsNotNull() {
            addCriterion("order_total_amount is not null");
            return (Criteria) this;
        }

        public Criteria andOrderTotalAmountEqualTo(Integer value) {
            addCriterion("order_total_amount =", value, "orderTotalAmount");
            return (Criteria) this;
        }

        public Criteria andOrderTotalAmountNotEqualTo(Integer value) {
            addCriterion("order_total_amount <>", value, "orderTotalAmount");
            return (Criteria) this;
        }

        public Criteria andOrderTotalAmountGreaterThan(Integer value) {
            addCriterion("order_total_amount >", value, "orderTotalAmount");
            return (Criteria) this;
        }

        public Criteria andOrderTotalAmountGreaterThanOrEqualTo(Integer value) {
            addCriterion("order_total_amount >=", value, "orderTotalAmount");
            return (Criteria) this;
        }

        public Criteria andOrderTotalAmountLessThan(Integer value) {
            addCriterion("order_total_amount <", value, "orderTotalAmount");
            return (Criteria) this;
        }

        public Criteria andOrderTotalAmountLessThanOrEqualTo(Integer value) {
            addCriterion("order_total_amount <=", value, "orderTotalAmount");
            return (Criteria) this;
        }

        public Criteria andOrderTotalAmountIn(List<Integer> values) {
            addCriterion("order_total_amount in", values, "orderTotalAmount");
            return (Criteria) this;
        }

        public Criteria andOrderTotalAmountNotIn(List<Integer> values) {
            addCriterion("order_total_amount not in", values, "orderTotalAmount");
            return (Criteria) this;
        }

        public Criteria andOrderTotalAmountBetween(Integer value1, Integer value2) {
            addCriterion("order_total_amount between", value1, value2, "orderTotalAmount");
            return (Criteria) this;
        }

        public Criteria andOrderTotalAmountNotBetween(Integer value1, Integer value2) {
            addCriterion("order_total_amount not between", value1, value2, "orderTotalAmount");
            return (Criteria) this;
        }

        public Criteria andOrderPayAmountIsNull() {
            addCriterion("order_pay_amount is null");
            return (Criteria) this;
        }

        public Criteria andOrderPayAmountIsNotNull() {
            addCriterion("order_pay_amount is not null");
            return (Criteria) this;
        }

        public Criteria andOrderPayAmountEqualTo(Integer value) {
            addCriterion("order_pay_amount =", value, "orderPayAmount");
            return (Criteria) this;
        }

        public Criteria andOrderPayAmountNotEqualTo(Integer value) {
            addCriterion("order_pay_amount <>", value, "orderPayAmount");
            return (Criteria) this;
        }

        public Criteria andOrderPayAmountGreaterThan(Integer value) {
            addCriterion("order_pay_amount >", value, "orderPayAmount");
            return (Criteria) this;
        }

        public Criteria andOrderPayAmountGreaterThanOrEqualTo(Integer value) {
            addCriterion("order_pay_amount >=", value, "orderPayAmount");
            return (Criteria) this;
        }

        public Criteria andOrderPayAmountLessThan(Integer value) {
            addCriterion("order_pay_amount <", value, "orderPayAmount");
            return (Criteria) this;
        }

        public Criteria andOrderPayAmountLessThanOrEqualTo(Integer value) {
            addCriterion("order_pay_amount <=", value, "orderPayAmount");
            return (Criteria) this;
        }

        public Criteria andOrderPayAmountIn(List<Integer> values) {
            addCriterion("order_pay_amount in", values, "orderPayAmount");
            return (Criteria) this;
        }

        public Criteria andOrderPayAmountNotIn(List<Integer> values) {
            addCriterion("order_pay_amount not in", values, "orderPayAmount");
            return (Criteria) this;
        }

        public Criteria andOrderPayAmountBetween(Integer value1, Integer value2) {
            addCriterion("order_pay_amount between", value1, value2, "orderPayAmount");
            return (Criteria) this;
        }

        public Criteria andOrderPayAmountNotBetween(Integer value1, Integer value2) {
            addCriterion("order_pay_amount not between", value1, value2, "orderPayAmount");
            return (Criteria) this;
        }

        public Criteria andOrderGoodsAmountIsNull() {
            addCriterion("order_goods_amount is null");
            return (Criteria) this;
        }

        public Criteria andOrderGoodsAmountIsNotNull() {
            addCriterion("order_goods_amount is not null");
            return (Criteria) this;
        }

        public Criteria andOrderGoodsAmountEqualTo(Integer value) {
            addCriterion("order_goods_amount =", value, "orderGoodsAmount");
            return (Criteria) this;
        }

        public Criteria andOrderGoodsAmountNotEqualTo(Integer value) {
            addCriterion("order_goods_amount <>", value, "orderGoodsAmount");
            return (Criteria) this;
        }

        public Criteria andOrderGoodsAmountGreaterThan(Integer value) {
            addCriterion("order_goods_amount >", value, "orderGoodsAmount");
            return (Criteria) this;
        }

        public Criteria andOrderGoodsAmountGreaterThanOrEqualTo(Integer value) {
            addCriterion("order_goods_amount >=", value, "orderGoodsAmount");
            return (Criteria) this;
        }

        public Criteria andOrderGoodsAmountLessThan(Integer value) {
            addCriterion("order_goods_amount <", value, "orderGoodsAmount");
            return (Criteria) this;
        }

        public Criteria andOrderGoodsAmountLessThanOrEqualTo(Integer value) {
            addCriterion("order_goods_amount <=", value, "orderGoodsAmount");
            return (Criteria) this;
        }

        public Criteria andOrderGoodsAmountIn(List<Integer> values) {
            addCriterion("order_goods_amount in", values, "orderGoodsAmount");
            return (Criteria) this;
        }

        public Criteria andOrderGoodsAmountNotIn(List<Integer> values) {
            addCriterion("order_goods_amount not in", values, "orderGoodsAmount");
            return (Criteria) this;
        }

        public Criteria andOrderGoodsAmountBetween(Integer value1, Integer value2) {
            addCriterion("order_goods_amount between", value1, value2, "orderGoodsAmount");
            return (Criteria) this;
        }

        public Criteria andOrderGoodsAmountNotBetween(Integer value1, Integer value2) {
            addCriterion("order_goods_amount not between", value1, value2, "orderGoodsAmount");
            return (Criteria) this;
        }

        public Criteria andOrderFreightAmountIsNull() {
            addCriterion("order_freight_amount is null");
            return (Criteria) this;
        }

        public Criteria andOrderFreightAmountIsNotNull() {
            addCriterion("order_freight_amount is not null");
            return (Criteria) this;
        }

        public Criteria andOrderFreightAmountEqualTo(Integer value) {
            addCriterion("order_freight_amount =", value, "orderFreightAmount");
            return (Criteria) this;
        }

        public Criteria andOrderFreightAmountNotEqualTo(Integer value) {
            addCriterion("order_freight_amount <>", value, "orderFreightAmount");
            return (Criteria) this;
        }

        public Criteria andOrderFreightAmountGreaterThan(Integer value) {
            addCriterion("order_freight_amount >", value, "orderFreightAmount");
            return (Criteria) this;
        }

        public Criteria andOrderFreightAmountGreaterThanOrEqualTo(Integer value) {
            addCriterion("order_freight_amount >=", value, "orderFreightAmount");
            return (Criteria) this;
        }

        public Criteria andOrderFreightAmountLessThan(Integer value) {
            addCriterion("order_freight_amount <", value, "orderFreightAmount");
            return (Criteria) this;
        }

        public Criteria andOrderFreightAmountLessThanOrEqualTo(Integer value) {
            addCriterion("order_freight_amount <=", value, "orderFreightAmount");
            return (Criteria) this;
        }

        public Criteria andOrderFreightAmountIn(List<Integer> values) {
            addCriterion("order_freight_amount in", values, "orderFreightAmount");
            return (Criteria) this;
        }

        public Criteria andOrderFreightAmountNotIn(List<Integer> values) {
            addCriterion("order_freight_amount not in", values, "orderFreightAmount");
            return (Criteria) this;
        }

        public Criteria andOrderFreightAmountBetween(Integer value1, Integer value2) {
            addCriterion("order_freight_amount between", value1, value2, "orderFreightAmount");
            return (Criteria) this;
        }

        public Criteria andOrderFreightAmountNotBetween(Integer value1, Integer value2) {
            addCriterion("order_freight_amount not between", value1, value2, "orderFreightAmount");
            return (Criteria) this;
        }

        public Criteria andOrderAttachAmountIsNull() {
            addCriterion("order_attach_amount is null");
            return (Criteria) this;
        }

        public Criteria andOrderAttachAmountIsNotNull() {
            addCriterion("order_attach_amount is not null");
            return (Criteria) this;
        }

        public Criteria andOrderAttachAmountEqualTo(Integer value) {
            addCriterion("order_attach_amount =", value, "orderAttachAmount");
            return (Criteria) this;
        }

        public Criteria andOrderAttachAmountNotEqualTo(Integer value) {
            addCriterion("order_attach_amount <>", value, "orderAttachAmount");
            return (Criteria) this;
        }

        public Criteria andOrderAttachAmountGreaterThan(Integer value) {
            addCriterion("order_attach_amount >", value, "orderAttachAmount");
            return (Criteria) this;
        }

        public Criteria andOrderAttachAmountGreaterThanOrEqualTo(Integer value) {
            addCriterion("order_attach_amount >=", value, "orderAttachAmount");
            return (Criteria) this;
        }

        public Criteria andOrderAttachAmountLessThan(Integer value) {
            addCriterion("order_attach_amount <", value, "orderAttachAmount");
            return (Criteria) this;
        }

        public Criteria andOrderAttachAmountLessThanOrEqualTo(Integer value) {
            addCriterion("order_attach_amount <=", value, "orderAttachAmount");
            return (Criteria) this;
        }

        public Criteria andOrderAttachAmountIn(List<Integer> values) {
            addCriterion("order_attach_amount in", values, "orderAttachAmount");
            return (Criteria) this;
        }

        public Criteria andOrderAttachAmountNotIn(List<Integer> values) {
            addCriterion("order_attach_amount not in", values, "orderAttachAmount");
            return (Criteria) this;
        }

        public Criteria andOrderAttachAmountBetween(Integer value1, Integer value2) {
            addCriterion("order_attach_amount between", value1, value2, "orderAttachAmount");
            return (Criteria) this;
        }

        public Criteria andOrderAttachAmountNotBetween(Integer value1, Integer value2) {
            addCriterion("order_attach_amount not between", value1, value2, "orderAttachAmount");
            return (Criteria) this;
        }

        public Criteria andOrderGoodsCostAmountIsNull() {
            addCriterion("order_goods_cost_amount is null");
            return (Criteria) this;
        }

        public Criteria andOrderGoodsCostAmountIsNotNull() {
            addCriterion("order_goods_cost_amount is not null");
            return (Criteria) this;
        }

        public Criteria andOrderGoodsCostAmountEqualTo(Integer value) {
            addCriterion("order_goods_cost_amount =", value, "orderGoodsCostAmount");
            return (Criteria) this;
        }

        public Criteria andOrderGoodsCostAmountNotEqualTo(Integer value) {
            addCriterion("order_goods_cost_amount <>", value, "orderGoodsCostAmount");
            return (Criteria) this;
        }

        public Criteria andOrderGoodsCostAmountGreaterThan(Integer value) {
            addCriterion("order_goods_cost_amount >", value, "orderGoodsCostAmount");
            return (Criteria) this;
        }

        public Criteria andOrderGoodsCostAmountGreaterThanOrEqualTo(Integer value) {
            addCriterion("order_goods_cost_amount >=", value, "orderGoodsCostAmount");
            return (Criteria) this;
        }

        public Criteria andOrderGoodsCostAmountLessThan(Integer value) {
            addCriterion("order_goods_cost_amount <", value, "orderGoodsCostAmount");
            return (Criteria) this;
        }

        public Criteria andOrderGoodsCostAmountLessThanOrEqualTo(Integer value) {
            addCriterion("order_goods_cost_amount <=", value, "orderGoodsCostAmount");
            return (Criteria) this;
        }

        public Criteria andOrderGoodsCostAmountIn(List<Integer> values) {
            addCriterion("order_goods_cost_amount in", values, "orderGoodsCostAmount");
            return (Criteria) this;
        }

        public Criteria andOrderGoodsCostAmountNotIn(List<Integer> values) {
            addCriterion("order_goods_cost_amount not in", values, "orderGoodsCostAmount");
            return (Criteria) this;
        }

        public Criteria andOrderGoodsCostAmountBetween(Integer value1, Integer value2) {
            addCriterion("order_goods_cost_amount between", value1, value2, "orderGoodsCostAmount");
            return (Criteria) this;
        }

        public Criteria andOrderGoodsCostAmountNotBetween(Integer value1, Integer value2) {
            addCriterion("order_goods_cost_amount not between", value1, value2, "orderGoodsCostAmount");
            return (Criteria) this;
        }

        public Criteria andOrderActiveContentIsNull() {
            addCriterion("order_active_content is null");
            return (Criteria) this;
        }

        public Criteria andOrderActiveContentIsNotNull() {
            addCriterion("order_active_content is not null");
            return (Criteria) this;
        }

        public Criteria andOrderActiveContentEqualTo(String value) {
            addCriterion("order_active_content =", value, "orderActiveContent");
            return (Criteria) this;
        }

        public Criteria andOrderActiveContentNotEqualTo(String value) {
            addCriterion("order_active_content <>", value, "orderActiveContent");
            return (Criteria) this;
        }

        public Criteria andOrderActiveContentGreaterThan(String value) {
            addCriterion("order_active_content >", value, "orderActiveContent");
            return (Criteria) this;
        }

        public Criteria andOrderActiveContentGreaterThanOrEqualTo(String value) {
            addCriterion("order_active_content >=", value, "orderActiveContent");
            return (Criteria) this;
        }

        public Criteria andOrderActiveContentLessThan(String value) {
            addCriterion("order_active_content <", value, "orderActiveContent");
            return (Criteria) this;
        }

        public Criteria andOrderActiveContentLessThanOrEqualTo(String value) {
            addCriterion("order_active_content <=", value, "orderActiveContent");
            return (Criteria) this;
        }

        public Criteria andOrderActiveContentLike(String value) {
            addCriterion("order_active_content like", value, "orderActiveContent");
            return (Criteria) this;
        }

        public Criteria andOrderActiveContentNotLike(String value) {
            addCriterion("order_active_content not like", value, "orderActiveContent");
            return (Criteria) this;
        }

        public Criteria andOrderActiveContentIn(List<String> values) {
            addCriterion("order_active_content in", values, "orderActiveContent");
            return (Criteria) this;
        }

        public Criteria andOrderActiveContentNotIn(List<String> values) {
            addCriterion("order_active_content not in", values, "orderActiveContent");
            return (Criteria) this;
        }

        public Criteria andOrderActiveContentBetween(String value1, String value2) {
            addCriterion("order_active_content between", value1, value2, "orderActiveContent");
            return (Criteria) this;
        }

        public Criteria andOrderActiveContentNotBetween(String value1, String value2) {
            addCriterion("order_active_content not between", value1, value2, "orderActiveContent");
            return (Criteria) this;
        }

        public Criteria andOrderActiveAmountIsNull() {
            addCriterion("order_active_amount is null");
            return (Criteria) this;
        }

        public Criteria andOrderActiveAmountIsNotNull() {
            addCriterion("order_active_amount is not null");
            return (Criteria) this;
        }

        public Criteria andOrderActiveAmountEqualTo(Integer value) {
            addCriterion("order_isNative = ", value, "order_isNative");
            return (Criteria) this;
        }

        public Criteria andOrderActiveAmountNotEqualTo(Integer value) {
            addCriterion("order_active_amount <>", value, "orderActiveAmount");
            return (Criteria) this;
        }

        public Criteria andOrderActiveAmountGreaterThan(Integer value) {
            addCriterion("order_active_amount >", value, "orderActiveAmount");
            return (Criteria) this;
        }

        public Criteria andOrderActiveAmountGreaterThanOrEqualTo(Integer value) {
            addCriterion("order_active_amount >=", value, "orderActiveAmount");
            return (Criteria) this;
        }

        public Criteria andOrderActiveAmountLessThan(Integer value) {
            addCriterion("order_active_amount <", value, "orderActiveAmount");
            return (Criteria) this;
        }

        public Criteria andOrderActiveAmountLessThanOrEqualTo(Integer value) {
            addCriterion("order_active_amount <=", value, "orderActiveAmount");
            return (Criteria) this;
        }

        public Criteria andOrderActiveAmountIn(List<Integer> values) {
            addCriterion("order_active_amount in", values, "orderActiveAmount");
            return (Criteria) this;
        }

        public Criteria andOrderActiveAmountNotIn(List<Integer> values) {
            addCriterion("order_active_amount not in", values, "orderActiveAmount");
            return (Criteria) this;
        }

        public Criteria andOrderActiveAmountBetween(Integer value1, Integer value2) {
            addCriterion("order_active_amount between", value1, value2, "orderActiveAmount");
            return (Criteria) this;
        }

        public Criteria andOrderActiveAmountNotBetween(Integer value1, Integer value2) {
            addCriterion("order_active_amount not between", value1, value2, "orderActiveAmount");
            return (Criteria) this;
        }

        public Criteria andOrderActiveIdIsNull() {
            addCriterion("order_active_id is null");
            return (Criteria) this;
        }

        public Criteria andOrderActiveIdIsNotNull() {
            addCriterion("order_active_id is not null");
            return (Criteria) this;
        }

        public Criteria andOrderActiveIdEqualTo(Integer value) {
            addCriterion("order_active_id =", value, "orderActiveId");
            return (Criteria) this;
        }

        public Criteria andOrderActiveIdNotEqualTo(Integer value) {
            addCriterion("order_active_id <>", value, "orderActiveId");
            return (Criteria) this;
        }

        public Criteria andOrderActiveIdGreaterThan(Integer value) {
            addCriterion("order_active_id >", value, "orderActiveId");
            return (Criteria) this;
        }

        public Criteria andOrderActiveIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("order_active_id >=", value, "orderActiveId");
            return (Criteria) this;
        }

        public Criteria andOrderActiveIdLessThan(Integer value) {
            addCriterion("order_active_id <", value, "orderActiveId");
            return (Criteria) this;
        }

        public Criteria andOrderActiveIdLessThanOrEqualTo(Integer value) {
            addCriterion("order_active_id <=", value, "orderActiveId");
            return (Criteria) this;
        }

        public Criteria andOrderActiveIdIn(List<Integer> values) {
            addCriterion("order_active_id in", values, "orderActiveId");
            return (Criteria) this;
        }

        public Criteria andOrderActiveIdNotIn(List<Integer> values) {
            addCriterion("order_active_id not in", values, "orderActiveId");
            return (Criteria) this;
        }

        public Criteria andOrderActiveIdBetween(Integer value1, Integer value2) {
            addCriterion("order_active_id between", value1, value2, "orderActiveId");
            return (Criteria) this;
        }

        public Criteria andOrderActiveIdNotBetween(Integer value1, Integer value2) {
            addCriterion("order_active_id not between", value1, value2, "orderActiveId");
            return (Criteria) this;
        }

        public Criteria andOrderPayDiscostAmountIsNull() {
            addCriterion("order_pay_discost_amount is null");
            return (Criteria) this;
        }

        public Criteria andOrderPayDiscostAmountIsNotNull() {
            addCriterion("order_pay_discost_amount is not null");
            return (Criteria) this;
        }

        public Criteria andOrderPayDiscostAmountEqualTo(Integer value) {
            addCriterion("order_pay_discost_amount =", value, "orderPayDiscostAmount");
            return (Criteria) this;
        }

        public Criteria andOrderPayDiscostAmountNotEqualTo(Integer value) {
            addCriterion("order_pay_discost_amount <>", value, "orderPayDiscostAmount");
            return (Criteria) this;
        }

        public Criteria andOrderPayDiscostAmountGreaterThan(Integer value) {
            addCriterion("order_pay_discost_amount >", value, "orderPayDiscostAmount");
            return (Criteria) this;
        }

        public Criteria andOrderPayDiscostAmountGreaterThanOrEqualTo(Integer value) {
            addCriterion("order_pay_discost_amount >=", value, "orderPayDiscostAmount");
            return (Criteria) this;
        }

        public Criteria andOrderPayDiscostAmountLessThan(Integer value) {
            addCriterion("order_pay_discost_amount <", value, "orderPayDiscostAmount");
            return (Criteria) this;
        }

        public Criteria andOrderPayDiscostAmountLessThanOrEqualTo(Integer value) {
            addCriterion("order_pay_discost_amount <=", value, "orderPayDiscostAmount");
            return (Criteria) this;
        }

        public Criteria andOrderPayDiscostAmountIn(List<Integer> values) {
            addCriterion("order_pay_discost_amount in", values, "orderPayDiscostAmount");
            return (Criteria) this;
        }

        public Criteria andOrderPayDiscostAmountNotIn(List<Integer> values) {
            addCriterion("order_pay_discost_amount not in", values, "orderPayDiscostAmount");
            return (Criteria) this;
        }

        public Criteria andOrderPayDiscostAmountBetween(Integer value1, Integer value2) {
            addCriterion("order_pay_discost_amount between", value1, value2, "orderPayDiscostAmount");
            return (Criteria) this;
        }

        public Criteria andOrderPayDiscostAmountNotBetween(Integer value1, Integer value2) {
            addCriterion("order_pay_discost_amount not between", value1, value2, "orderPayDiscostAmount");
            return (Criteria) this;
        }

        public Criteria andOrderTransportTypeIsNull() {
            addCriterion("order_transport_type is null");
            return (Criteria) this;
        }

        public Criteria andOrderTransportTypeIsNotNull() {
            addCriterion("order_transport_type is not null");
            return (Criteria) this;
        }

        public Criteria andOrderTransportTypeEqualTo(Integer value) {
            addCriterion("order_transport_type =", value, "orderTransportType");
            return (Criteria) this;
        }

        public Criteria andOrderTransportTypeNotEqualTo(Integer value) {
            addCriterion("order_transport_type <>", value, "orderTransportType");
            return (Criteria) this;
        }

        public Criteria andOrderTransportTypeGreaterThan(Integer value) {
            addCriterion("order_transport_type >", value, "orderTransportType");
            return (Criteria) this;
        }

        public Criteria andOrderTransportTypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("order_transport_type >=", value, "orderTransportType");
            return (Criteria) this;
        }

        public Criteria andOrderTransportTypeLessThan(Integer value) {
            addCriterion("order_transport_type <", value, "orderTransportType");
            return (Criteria) this;
        }

        public Criteria andOrderTransportTypeLessThanOrEqualTo(Integer value) {
            addCriterion("order_transport_type <=", value, "orderTransportType");
            return (Criteria) this;
        }

        public Criteria andOrderTransportTypeIn(List<Integer> values) {
            addCriterion("order_transport_type in", values, "orderTransportType");
            return (Criteria) this;
        }

        public Criteria andOrderTransportTypeNotIn(List<Integer> values) {
            addCriterion("order_transport_type not in", values, "orderTransportType");
            return (Criteria) this;
        }

        public Criteria andOrderTransportTypeBetween(Integer value1, Integer value2) {
            addCriterion("order_transport_type between", value1, value2, "orderTransportType");
            return (Criteria) this;
        }

        public Criteria andOrderTransportTypeNotBetween(Integer value1, Integer value2) {
            addCriterion("order_transport_type not between", value1, value2, "orderTransportType");
            return (Criteria) this;
        }

        public Criteria andOrderTransportIdIsNull() {
            addCriterion("order_transport_id is null");
            return (Criteria) this;
        }

        public Criteria andOrderTransportIdIsNotNull() {
            addCriterion("order_transport_id is not null");
            return (Criteria) this;
        }

        public Criteria andOrderTransportIdEqualTo(Integer value) {
            addCriterion("order_transport_id =", value, "orderTransportId");
            return (Criteria) this;
        }

        public Criteria andOrderTransportIdNotEqualTo(Integer value) {
            addCriterion("order_transport_id <>", value, "orderTransportId");
            return (Criteria) this;
        }

        public Criteria andOrderTransportIdGreaterThan(Integer value) {
            addCriterion("order_transport_id >", value, "orderTransportId");
            return (Criteria) this;
        }

        public Criteria andOrderTransportIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("order_transport_id >=", value, "orderTransportId");
            return (Criteria) this;
        }

        public Criteria andOrderTransportIdLessThan(Integer value) {
            addCriterion("order_transport_id <", value, "orderTransportId");
            return (Criteria) this;
        }

        public Criteria andOrderTransportIdLessThanOrEqualTo(Integer value) {
            addCriterion("order_transport_id <=", value, "orderTransportId");
            return (Criteria) this;
        }

        public Criteria andOrderTransportIdIn(List<Integer> values) {
            addCriterion("order_transport_id in", values, "orderTransportId");
            return (Criteria) this;
        }

        public Criteria andOrderTransportIdNotIn(List<Integer> values) {
            addCriterion("order_transport_id not in", values, "orderTransportId");
            return (Criteria) this;
        }

        public Criteria andOrderTransportIdBetween(Integer value1, Integer value2) {
            addCriterion("order_transport_id between", value1, value2, "orderTransportId");
            return (Criteria) this;
        }

        public Criteria andOrderTransportIdNotBetween(Integer value1, Integer value2) {
            addCriterion("order_transport_id not between", value1, value2, "orderTransportId");
            return (Criteria) this;
        }

        public Criteria andOrderTransportRunerNameIsNull() {
            addCriterion("order_transport_runer_name is null");
            return (Criteria) this;
        }

        public Criteria andOrderTransportRunerNameIsNotNull() {
            addCriterion("order_transport_runer_name is not null");
            return (Criteria) this;
        }

        public Criteria andOrderTransportRunerNameEqualTo(String value) {
            addCriterion("order_transport_runer_name =", value, "orderTransportRunerName");
            return (Criteria) this;
        }

        public Criteria andOrderTransportRunerNameNotEqualTo(String value) {
            addCriterion("order_transport_runer_name <>", value, "orderTransportRunerName");
            return (Criteria) this;
        }

        public Criteria andOrderTransportRunerNameGreaterThan(String value) {
            addCriterion("order_transport_runer_name >", value, "orderTransportRunerName");
            return (Criteria) this;
        }

        public Criteria andOrderTransportRunerNameGreaterThanOrEqualTo(String value) {
            addCriterion("order_transport_runer_name >=", value, "orderTransportRunerName");
            return (Criteria) this;
        }

        public Criteria andOrderTransportRunerNameLessThan(String value) {
            addCriterion("order_transport_runer_name <", value, "orderTransportRunerName");
            return (Criteria) this;
        }

        public Criteria andOrderTransportRunerNameLessThanOrEqualTo(String value) {
            addCriterion("order_transport_runer_name <=", value, "orderTransportRunerName");
            return (Criteria) this;
        }

        public Criteria andOrderTransportRunerNameLike(String value) {
            addCriterion("order_transport_runer_name like", value, "orderTransportRunerName");
            return (Criteria) this;
        }

        public Criteria andOrderTransportRunerNameNotLike(String value) {
            addCriterion("order_transport_runer_name not like", value, "orderTransportRunerName");
            return (Criteria) this;
        }

        public Criteria andOrderTransportRunerNameIn(List<String> values) {
            addCriterion("order_transport_runer_name in", values, "orderTransportRunerName");
            return (Criteria) this;
        }

        public Criteria andOrderTransportRunerNameNotIn(List<String> values) {
            addCriterion("order_transport_runer_name not in", values, "orderTransportRunerName");
            return (Criteria) this;
        }

        public Criteria andOrderTransportRunerNameBetween(String value1, String value2) {
            addCriterion("order_transport_runer_name between", value1, value2, "orderTransportRunerName");
            return (Criteria) this;
        }

        public Criteria andOrderTransportRunerNameNotBetween(String value1, String value2) {
            addCriterion("order_transport_runer_name not between", value1, value2, "orderTransportRunerName");
            return (Criteria) this;
        }

        public Criteria andOrderTransportRunerPhoneIsNull() {
            addCriterion("order_transport_runer_phone is null");
            return (Criteria) this;
        }

        public Criteria andOrderTransportRunerPhoneIsNotNull() {
            addCriterion("order_transport_runer_phone is not null");
            return (Criteria) this;
        }

        public Criteria andOrderTransportRunerPhoneEqualTo(String value) {
            addCriterion("order_transport_runer_phone =", value, "orderTransportRunerPhone");
            return (Criteria) this;
        }

        public Criteria andOrderTransportRunerPhoneNotEqualTo(String value) {
            addCriterion("order_transport_runer_phone <>", value, "orderTransportRunerPhone");
            return (Criteria) this;
        }

        public Criteria andOrderTransportRunerPhoneGreaterThan(String value) {
            addCriterion("order_transport_runer_phone >", value, "orderTransportRunerPhone");
            return (Criteria) this;
        }

        public Criteria andOrderTransportRunerPhoneGreaterThanOrEqualTo(String value) {
            addCriterion("order_transport_runer_phone >=", value, "orderTransportRunerPhone");
            return (Criteria) this;
        }

        public Criteria andOrderTransportRunerPhoneLessThan(String value) {
            addCriterion("order_transport_runer_phone <", value, "orderTransportRunerPhone");
            return (Criteria) this;
        }

        public Criteria andOrderTransportRunerPhoneLessThanOrEqualTo(String value) {
            addCriterion("order_transport_runer_phone <=", value, "orderTransportRunerPhone");
            return (Criteria) this;
        }

        public Criteria andOrderTransportRunerPhoneLike(String value) {
            addCriterion("order_transport_runer_phone like", value, "orderTransportRunerPhone");
            return (Criteria) this;
        }

        public Criteria andOrderTransportRunerPhoneNotLike(String value) {
            addCriterion("order_transport_runer_phone not like", value, "orderTransportRunerPhone");
            return (Criteria) this;
        }

        public Criteria andOrderTransportRunerPhoneIn(List<String> values) {
            addCriterion("order_transport_runer_phone in", values, "orderTransportRunerPhone");
            return (Criteria) this;
        }

        public Criteria andOrderTransportRunerPhoneNotIn(List<String> values) {
            addCriterion("order_transport_runer_phone not in", values, "orderTransportRunerPhone");
            return (Criteria) this;
        }

        public Criteria andOrderTransportRunerPhoneBetween(String value1, String value2) {
            addCriterion("order_transport_runer_phone between", value1, value2, "orderTransportRunerPhone");
            return (Criteria) this;
        }

        public Criteria andOrderTransportRunerPhoneNotBetween(String value1, String value2) {
            addCriterion("order_transport_runer_phone not between", value1, value2, "orderTransportRunerPhone");
            return (Criteria) this;
        }

        public Criteria andOrderTransportStateIsNull() {
            addCriterion("order_transport_state is null");
            return (Criteria) this;
        }

        public Criteria andOrderTransportStateIsNotNull() {
            addCriterion("order_transport_state is not null");
            return (Criteria) this;
        }

        public Criteria andOrderTransportStateEqualTo(Integer value) {
            addCriterion("order_transport_state =", value, "orderTransportState");
            return (Criteria) this;
        }

        public Criteria andOrderTransportStateNotEqualTo(Integer value) {
            addCriterion("order_transport_state <>", value, "orderTransportState");
            return (Criteria) this;
        }

        public Criteria andOrderTransportStateGreaterThan(Integer value) {
            addCriterion("order_transport_state >", value, "orderTransportState");
            return (Criteria) this;
        }

        public Criteria andOrderTransportStateGreaterThanOrEqualTo(Integer value) {
            addCriterion("order_transport_state >=", value, "orderTransportState");
            return (Criteria) this;
        }

        public Criteria andOrderTransportStateLessThan(Integer value) {
            addCriterion("order_transport_state <", value, "orderTransportState");
            return (Criteria) this;
        }

        public Criteria andOrderTransportStateLessThanOrEqualTo(Integer value) {
            addCriterion("order_transport_state <=", value, "orderTransportState");
            return (Criteria) this;
        }

        public Criteria andOrderTransportStateIn(List<Integer> values) {
            addCriterion("order_transport_state in", values, "orderTransportState");
            return (Criteria) this;
        }

        public Criteria andOrderTransportStateNotIn(List<Integer> values) {
            addCriterion("order_transport_state not in", values, "orderTransportState");
            return (Criteria) this;
        }

        public Criteria andOrderTransportStateBetween(Integer value1, Integer value2) {
            addCriterion("order_transport_state between", value1, value2, "orderTransportState");
            return (Criteria) this;
        }

        public Criteria andOrderTransportStateNotBetween(Integer value1, Integer value2) {
            addCriterion("order_transport_state not between", value1, value2, "orderTransportState");
            return (Criteria) this;
        }

        public Criteria andOrderUserAddressIsNull() {
            addCriterion("order_user_address is null");
            return (Criteria) this;
        }

        public Criteria andOrderUserAddressIsNotNull() {
            addCriterion("order_user_address is not null");
            return (Criteria) this;
        }

        public Criteria andOrderUserAddressEqualTo(String value) {
            addCriterion("order_user_address =", value, "orderUserAddress");
            return (Criteria) this;
        }

        public Criteria andOrderUserAddressNotEqualTo(String value) {
            addCriterion("order_user_address <>", value, "orderUserAddress");
            return (Criteria) this;
        }

        public Criteria andOrderUserAddressGreaterThan(String value) {
            addCriterion("order_user_address >", value, "orderUserAddress");
            return (Criteria) this;
        }

        public Criteria andOrderUserAddressGreaterThanOrEqualTo(String value) {
            addCriterion("order_user_address >=", value, "orderUserAddress");
            return (Criteria) this;
        }

        public Criteria andOrderUserAddressLessThan(String value) {
            addCriterion("order_user_address <", value, "orderUserAddress");
            return (Criteria) this;
        }

        public Criteria andOrderUserAddressLessThanOrEqualTo(String value) {
            addCriterion("order_user_address <=", value, "orderUserAddress");
            return (Criteria) this;
        }

        public Criteria andOrderUserAddressLike(String value) {
            addCriterion("order_user_address like", value, "orderUserAddress");
            return (Criteria) this;
        }

        public Criteria andOrderUserAddressNotLike(String value) {
            addCriterion("order_user_address not like", value, "orderUserAddress");
            return (Criteria) this;
        }

        public Criteria andOrderUserAddressIn(List<String> values) {
            addCriterion("order_user_address in", values, "orderUserAddress");
            return (Criteria) this;
        }

        public Criteria andOrderUserAddressNotIn(List<String> values) {
            addCriterion("order_user_address not in", values, "orderUserAddress");
            return (Criteria) this;
        }

        public Criteria andOrderUserAddressBetween(String value1, String value2) {
            addCriterion("order_user_address between", value1, value2, "orderUserAddress");
            return (Criteria) this;
        }

        public Criteria andOrderUserAddressNotBetween(String value1, String value2) {
            addCriterion("order_user_address not between", value1, value2, "orderUserAddress");
            return (Criteria) this;
        }

        public Criteria andOrderUserNameIsNull() {
            addCriterion("order_user_name is null");
            return (Criteria) this;
        }

        public Criteria andOrderUserNameIsNotNull() {
            addCriterion("order_user_name is not null");
            return (Criteria) this;
        }

        public Criteria andOrderUserNameEqualTo(String value) {
            addCriterion("order_user_name =", value, "orderUserName");
            return (Criteria) this;
        }

        public Criteria andOrderUserNameNotEqualTo(String value) {
            addCriterion("order_user_name <>", value, "orderUserName");
            return (Criteria) this;
        }

        public Criteria andOrderUserNameGreaterThan(String value) {
            addCriterion("order_user_name >", value, "orderUserName");
            return (Criteria) this;
        }

        public Criteria andOrderUserNameGreaterThanOrEqualTo(String value) {
            addCriterion("order_user_name >=", value, "orderUserName");
            return (Criteria) this;
        }

        public Criteria andOrderUserNameLessThan(String value) {
            addCriterion("order_user_name <", value, "orderUserName");
            return (Criteria) this;
        }

        public Criteria andOrderUserNameLessThanOrEqualTo(String value) {
            addCriterion("order_user_name <=", value, "orderUserName");
            return (Criteria) this;
        }

        public Criteria andOrderUserNameLike(String value) {
            addCriterion("order_user_name like", value, "orderUserName");
            return (Criteria) this;
        }

        public Criteria andOrderUserNameNotLike(String value) {
            addCriterion("order_user_name not like", value, "orderUserName");
            return (Criteria) this;
        }

        public Criteria andOrderUserNameIn(List<String> values) {
            addCriterion("order_user_name in", values, "orderUserName");
            return (Criteria) this;
        }

        public Criteria andOrderUserNameNotIn(List<String> values) {
            addCriterion("order_user_name not in", values, "orderUserName");
            return (Criteria) this;
        }

        public Criteria andOrderUserNameBetween(String value1, String value2) {
            addCriterion("order_user_name between", value1, value2, "orderUserName");
            return (Criteria) this;
        }

        public Criteria andOrderUserNameNotBetween(String value1, String value2) {
            addCriterion("order_user_name not between", value1, value2, "orderUserName");
            return (Criteria) this;
        }

        public Criteria andOrderUserPhoneIsNull() {
            addCriterion("order_user_phone is null");
            return (Criteria) this;
        }

        public Criteria andOrderUserPhoneIsNotNull() {
            addCriterion("order_user_phone is not null");
            return (Criteria) this;
        }

        public Criteria andOrderUserPhoneEqualTo(String value) {
            addCriterion("order_user_phone =", value, "orderUserPhone");
            return (Criteria) this;
        }

        public Criteria andOrderUserPhoneNotEqualTo(String value) {
            addCriterion("order_user_phone <>", value, "orderUserPhone");
            return (Criteria) this;
        }

        public Criteria andOrderUserPhoneGreaterThan(String value) {
            addCriterion("order_user_phone >", value, "orderUserPhone");
            return (Criteria) this;
        }

        public Criteria andOrderUserPhoneGreaterThanOrEqualTo(String value) {
            addCriterion("order_user_phone >=", value, "orderUserPhone");
            return (Criteria) this;
        }

        public Criteria andOrderUserPhoneLessThan(String value) {
            addCriterion("order_user_phone <", value, "orderUserPhone");
            return (Criteria) this;
        }

        public Criteria andOrderUserPhoneLessThanOrEqualTo(String value) {
            addCriterion("order_user_phone <=", value, "orderUserPhone");
            return (Criteria) this;
        }

        public Criteria andOrderUserPhoneLike(String value) {
            addCriterion("order_user_phone like", value, "orderUserPhone");
            return (Criteria) this;
        }

        public Criteria andOrderUserPhoneNotLike(String value) {
            addCriterion("order_user_phone not like", value, "orderUserPhone");
            return (Criteria) this;
        }

        public Criteria andOrderUserPhoneIn(List<String> values) {
            addCriterion("order_user_phone in", values, "orderUserPhone");
            return (Criteria) this;
        }

        public Criteria andOrderUserPhoneNotIn(List<String> values) {
            addCriterion("order_user_phone not in", values, "orderUserPhone");
            return (Criteria) this;
        }

        public Criteria andOrderUserPhoneBetween(String value1, String value2) {
            addCriterion("order_user_phone between", value1, value2, "orderUserPhone");
            return (Criteria) this;
        }

        public Criteria andOrderUserPhoneNotBetween(String value1, String value2) {
            addCriterion("order_user_phone not between", value1, value2, "orderUserPhone");
            return (Criteria) this;
        }

        public Criteria andOrderUserSexIsNull() {
            addCriterion("order_user_sex is null");
            return (Criteria) this;
        }

        public Criteria andOrderUserSexIsNotNull() {
            addCriterion("order_user_sex is not null");
            return (Criteria) this;
        }

        public Criteria andOrderUserSexEqualTo(Integer value) {
            addCriterion("order_user_sex =", value, "orderUserSex");
            return (Criteria) this;
        }

        public Criteria andOrderUserSexNotEqualTo(Integer value) {
            addCriterion("order_user_sex <>", value, "orderUserSex");
            return (Criteria) this;
        }

        public Criteria andOrderUserSexGreaterThan(Integer value) {
            addCriterion("order_user_sex >", value, "orderUserSex");
            return (Criteria) this;
        }

        public Criteria andOrderUserSexGreaterThanOrEqualTo(Integer value) {
            addCriterion("order_user_sex >=", value, "orderUserSex");
            return (Criteria) this;
        }

        public Criteria andOrderUserSexLessThan(Integer value) {
            addCriterion("order_user_sex <", value, "orderUserSex");
            return (Criteria) this;
        }

        public Criteria andOrderUserSexLessThanOrEqualTo(Integer value) {
            addCriterion("order_user_sex <=", value, "orderUserSex");
            return (Criteria) this;
        }

        public Criteria andOrderUserSexIn(List<Integer> values) {
            addCriterion("order_user_sex in", values, "orderUserSex");
            return (Criteria) this;
        }

        public Criteria andOrderUserSexNotIn(List<Integer> values) {
            addCriterion("order_user_sex not in", values, "orderUserSex");
            return (Criteria) this;
        }

        public Criteria andOrderUserSexBetween(Integer value1, Integer value2) {
            addCriterion("order_user_sex between", value1, value2, "orderUserSex");
            return (Criteria) this;
        }

        public Criteria andOrderUserSexNotBetween(Integer value1, Integer value2) {
            addCriterion("order_user_sex not between", value1, value2, "orderUserSex");
            return (Criteria) this;
        }

        public Criteria andOrderUserLatIsNull() {
            addCriterion("order_user_lat is null");
            return (Criteria) this;
        }

        public Criteria andOrderUserLatIsNotNull() {
            addCriterion("order_user_lat is not null");
            return (Criteria) this;
        }

        public Criteria andOrderUserLatEqualTo(Double value) {
            addCriterion("order_user_lat =", value, "orderUserLat");
            return (Criteria) this;
        }

        public Criteria andOrderUserLatNotEqualTo(Double value) {
            addCriterion("order_user_lat <>", value, "orderUserLat");
            return (Criteria) this;
        }

        public Criteria andOrderUserLatGreaterThan(Double value) {
            addCriterion("order_user_lat >", value, "orderUserLat");
            return (Criteria) this;
        }

        public Criteria andOrderUserLatGreaterThanOrEqualTo(Double value) {
            addCriterion("order_user_lat >=", value, "orderUserLat");
            return (Criteria) this;
        }

        public Criteria andOrderUserLatLessThan(Double value) {
            addCriterion("order_user_lat <", value, "orderUserLat");
            return (Criteria) this;
        }

        public Criteria andOrderUserLatLessThanOrEqualTo(Double value) {
            addCriterion("order_user_lat <=", value, "orderUserLat");
            return (Criteria) this;
        }

        public Criteria andOrderUserLatIn(List<Double> values) {
            addCriterion("order_user_lat in", values, "orderUserLat");
            return (Criteria) this;
        }

        public Criteria andOrderUserLatNotIn(List<Double> values) {
            addCriterion("order_user_lat not in", values, "orderUserLat");
            return (Criteria) this;
        }

        public Criteria andOrderUserLatBetween(Double value1, Double value2) {
            addCriterion("order_user_lat between", value1, value2, "orderUserLat");
            return (Criteria) this;
        }

        public Criteria andOrderUserLatNotBetween(Double value1, Double value2) {
            addCriterion("order_user_lat not between", value1, value2, "orderUserLat");
            return (Criteria) this;
        }

        public Criteria andOrderUserLonIsNull() {
            addCriterion("order_user_lon is null");
            return (Criteria) this;
        }

        public Criteria andOrderUserLonIsNotNull() {
            addCriterion("order_user_lon is not null");
            return (Criteria) this;
        }

        public Criteria andOrderUserLonEqualTo(Double value) {
            addCriterion("order_user_lon =", value, "orderUserLon");
            return (Criteria) this;
        }

        public Criteria andOrderUserLonNotEqualTo(Double value) {
            addCriterion("order_user_lon <>", value, "orderUserLon");
            return (Criteria) this;
        }

        public Criteria andOrderUserLonGreaterThan(Double value) {
            addCriterion("order_user_lon >", value, "orderUserLon");
            return (Criteria) this;
        }

        public Criteria andOrderUserLonGreaterThanOrEqualTo(Double value) {
            addCriterion("order_user_lon >=", value, "orderUserLon");
            return (Criteria) this;
        }

        public Criteria andOrderUserLonLessThan(Double value) {
            addCriterion("order_user_lon <", value, "orderUserLon");
            return (Criteria) this;
        }

        public Criteria andOrderUserLonLessThanOrEqualTo(Double value) {
            addCriterion("order_user_lon <=", value, "orderUserLon");
            return (Criteria) this;
        }

        public Criteria andOrderUserLonIn(List<Double> values) {
            addCriterion("order_user_lon in", values, "orderUserLon");
            return (Criteria) this;
        }

        public Criteria andOrderUserLonNotIn(List<Double> values) {
            addCriterion("order_user_lon not in", values, "orderUserLon");
            return (Criteria) this;
        }

        public Criteria andOrderUserLonBetween(Double value1, Double value2) {
            addCriterion("order_user_lon between", value1, value2, "orderUserLon");
            return (Criteria) this;
        }

        public Criteria andOrderUserLonNotBetween(Double value1, Double value2) {
            addCriterion("order_user_lon not between", value1, value2, "orderUserLon");
            return (Criteria) this;
        }

        public Criteria andOrderUserUrgeIsNull() {
            addCriterion("order_user_urge is null");
            return (Criteria) this;
        }

        public Criteria andOrderUserUrgeIsNotNull() {
            addCriterion("order_user_urge is not null");
            return (Criteria) this;
        }

        public Criteria andOrderUserUrgeEqualTo(Integer value) {
            addCriterion("order_user_urge =", value, "orderUserUrge");
            return (Criteria) this;
        }

        public Criteria andOrderUserUrgeNotEqualTo(Integer value) {
            addCriterion("order_user_urge <>", value, "orderUserUrge");
            return (Criteria) this;
        }

        public Criteria andOrderUserUrgeGreaterThan(Integer value) {
            addCriterion("order_user_urge >", value, "orderUserUrge");
            return (Criteria) this;
        }

        public Criteria andOrderUserUrgeGreaterThanOrEqualTo(Integer value) {
            addCriterion("order_user_urge >=", value, "orderUserUrge");
            return (Criteria) this;
        }

        public Criteria andOrderUserUrgeLessThan(Integer value) {
            addCriterion("order_user_urge <", value, "orderUserUrge");
            return (Criteria) this;
        }

        public Criteria andOrderUserUrgeLessThanOrEqualTo(Integer value) {
            addCriterion("order_user_urge <=", value, "orderUserUrge");
            return (Criteria) this;
        }

        public Criteria andOrderUserUrgeIn(List<Integer> values) {
            addCriterion("order_user_urge in", values, "orderUserUrge");
            return (Criteria) this;
        }

        public Criteria andOrderUserUrgeNotIn(List<Integer> values) {
            addCriterion("order_user_urge not in", values, "orderUserUrge");
            return (Criteria) this;
        }

        public Criteria andOrderUserUrgeBetween(Integer value1, Integer value2) {
            addCriterion("order_user_urge between", value1, value2, "orderUserUrge");
            return (Criteria) this;
        }

        public Criteria andOrderUserUrgeNotBetween(Integer value1, Integer value2) {
            addCriterion("order_user_urge not between", value1, value2, "orderUserUrge");
            return (Criteria) this;
        }

        public Criteria andOrderUserExpectTimeIsNull() {
            addCriterion("order_user_expect_time is null");
            return (Criteria) this;
        }

        public Criteria andOrderUserExpectTimeIsNotNull() {
            addCriterion("order_user_expect_time is not null");
            return (Criteria) this;
        }

        public Criteria andOrderUserExpectTimeEqualTo(Date value) {
            addCriterion("order_user_expect_time =", value, "orderUserExpectTime");
            return (Criteria) this;
        }

        public Criteria andOrderUserExpectTimeNotEqualTo(Date value) {
            addCriterion("order_user_expect_time <>", value, "orderUserExpectTime");
            return (Criteria) this;
        }

        public Criteria andOrderUserExpectTimeGreaterThan(Date value) {
            addCriterion("order_user_expect_time >", value, "orderUserExpectTime");
            return (Criteria) this;
        }

        public Criteria andOrderUserExpectTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("order_user_expect_time >=", value, "orderUserExpectTime");
            return (Criteria) this;
        }

        public Criteria andOrderUserExpectTimeLessThan(Date value) {
            addCriterion("order_user_expect_time <", value, "orderUserExpectTime");
            return (Criteria) this;
        }

        public Criteria andOrderUserExpectTimeLessThanOrEqualTo(Date value) {
            addCriterion("order_user_expect_time <=", value, "orderUserExpectTime");
            return (Criteria) this;
        }

        public Criteria andOrderUserExpectTimeIn(List<Date> values) {
            addCriterion("order_user_expect_time in", values, "orderUserExpectTime");
            return (Criteria) this;
        }

        public Criteria andOrderUserExpectTimeNotIn(List<Date> values) {
            addCriterion("order_user_expect_time not in", values, "orderUserExpectTime");
            return (Criteria) this;
        }

        public Criteria andOrderUserExpectTimeBetween(Date value1, Date value2) {
            addCriterion("order_user_expect_time between", value1, value2, "orderUserExpectTime");
            return (Criteria) this;
        }

        public Criteria andOrderUserExpectTimeNotBetween(Date value1, Date value2) {
            addCriterion("order_user_expect_time not between", value1, value2, "orderUserExpectTime");
            return (Criteria) this;
        }

        public Criteria andOrderGctIsNull() {
            addCriterion("order_gct is null");
            return (Criteria) this;
        }

        public Criteria andOrderGctIsNotNull() {
            addCriterion("order_gct is not null");
            return (Criteria) this;
        }

        public Criteria andOrderGctEqualTo(Date value) {
            addCriterion("order_gct =", value, "orderGct");
            return (Criteria) this;
        }

        public Criteria andOrderGctNotEqualTo(Date value) {
            addCriterion("order_gct <>", value, "orderGct");
            return (Criteria) this;
        }

        public Criteria andOrderGctGreaterThan(Date value) {
            addCriterion("order_gct >", value, "orderGct");
            return (Criteria) this;
        }

        public Criteria andOrderGctGreaterThanOrEqualTo(Date value) {
            addCriterion("order_gct >=", value, "orderGct");
            return (Criteria) this;
        }

        public Criteria andOrderGctLessThan(Date value) {
            addCriterion("order_gct <", value, "orderGct");
            return (Criteria) this;
        }

        public Criteria andOrderGctLessThanOrEqualTo(Date value) {
            addCriterion("order_gct <=", value, "orderGct");
            return (Criteria) this;
        }

        public Criteria andOrderGctIn(List<Date> values) {
            addCriterion("order_gct in", values, "orderGct");
            return (Criteria) this;
        }

        public Criteria andOrderGctNotIn(List<Date> values) {
            addCriterion("order_gct not in", values, "orderGct");
            return (Criteria) this;
        }

        public Criteria andOrderGctBetween(Date value1, Date value2) {
            addCriterion("order_gct between", value1, value2, "orderGct");
            return (Criteria) this;
        }

        public Criteria andOrderGctNotBetween(Date value1, Date value2) {
            addCriterion("order_gct not between", value1, value2, "orderGct");
            return (Criteria) this;
        }

        public Criteria andOrderGmtIsNull() {
            addCriterion("order_gmt is null");
            return (Criteria) this;
        }

        public Criteria andOrderGmtIsNotNull() {
            addCriterion("order_gmt is not null");
            return (Criteria) this;
        }

        public Criteria andOrderGmtEqualTo(Date value) {
            addCriterion("order_gmt =", value, "orderGmt");
            return (Criteria) this;
        }

        public Criteria andOrderGmtNotEqualTo(Date value) {
            addCriterion("order_gmt <>", value, "orderGmt");
            return (Criteria) this;
        }

        public Criteria andOrderGmtGreaterThan(Date value) {
            addCriterion("order_gmt >", value, "orderGmt");
            return (Criteria) this;
        }

        public Criteria andOrderGmtGreaterThanOrEqualTo(Date value) {
            addCriterion("order_gmt >=", value, "orderGmt");
            return (Criteria) this;
        }

        public Criteria andOrderGmtLessThan(Date value) {
            addCriterion("order_gmt <", value, "orderGmt");
            return (Criteria) this;
        }

        public Criteria andOrderGmtLessThanOrEqualTo(Date value) {
            addCriterion("order_gmt <=", value, "orderGmt");
            return (Criteria) this;
        }

        public Criteria andOrderGmtIn(List<Date> values) {
            addCriterion("order_gmt in", values, "orderGmt");
            return (Criteria) this;
        }

        public Criteria andOrderGmtNotIn(List<Date> values) {
            addCriterion("order_gmt not in", values, "orderGmt");
            return (Criteria) this;
        }

        public Criteria andOrderGmtBetween(Date value1, Date value2) {
            addCriterion("order_gmt between", value1, value2, "orderGmt");
            return (Criteria) this;
        }

        public Criteria andOrderGmtNotBetween(Date value1, Date value2) {
            addCriterion("order_gmt not between", value1, value2, "orderGmt");
            return (Criteria) this;
        }

        public Criteria andOrderFinshTimeIsNull() {
            addCriterion("order_finsh_time is null");
            return (Criteria) this;
        }

        public Criteria andOrderFinshTimeIsNotNull() {
            addCriterion("order_finsh_time is not null");
            return (Criteria) this;
        }

        public Criteria andOrderFinshTimeEqualTo(Date value) {
            addCriterion("order_finsh_time =", value, "orderFinshTime");
            return (Criteria) this;
        }

        public Criteria andOrderFinshTimeNotEqualTo(Date value) {
            addCriterion("order_finsh_time <>", value, "orderFinshTime");
            return (Criteria) this;
        }

        public Criteria andOrderFinshTimeGreaterThan(Date value) {
            addCriterion("order_finsh_time >", value, "orderFinshTime");
            return (Criteria) this;
        }

        public Criteria andOrderFinshTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("order_finsh_time >=", value, "orderFinshTime");
            return (Criteria) this;
        }

        public Criteria andOrderFinshTimeLessThan(Date value) {
            addCriterion("order_finsh_time <", value, "orderFinshTime");
            return (Criteria) this;
        }

        public Criteria andOrderFinshTimeLessThanOrEqualTo(Date value) {
            addCriterion("order_finsh_time <=", value, "orderFinshTime");
            return (Criteria) this;
        }

        public Criteria andOrderFinshTimeIn(List<Date> values) {
            addCriterion("order_finsh_time in", values, "orderFinshTime");
            return (Criteria) this;
        }

        public Criteria andOrderFinshTimeNotIn(List<Date> values) {
            addCriterion("order_finsh_time not in", values, "orderFinshTime");
            return (Criteria) this;
        }

        public Criteria andOrderFinshTimeBetween(Date value1, Date value2) {
            addCriterion("order_finsh_time between", value1, value2, "orderFinshTime");
            return (Criteria) this;
        }

        public Criteria andOrderFinshTimeNotBetween(Date value1, Date value2) {
            addCriterion("order_finsh_time not between", value1, value2, "orderFinshTime");
            return (Criteria) this;
        }

        public Criteria andOrderExceptionStateIsNull() {
            addCriterion("order_exception_state is null");
            return (Criteria) this;
        }

        public Criteria andOrderExceptionStateIsNotNull() {
            addCriterion("order_exception_state is not null");
            return (Criteria) this;
        }

        public Criteria andOrderExceptionStateEqualTo(Integer value) {
            addCriterion("order_exception_state =", value, "orderExceptionState");
            return (Criteria) this;
        }

        public Criteria andOrderExceptionStateNotEqualTo(Integer value) {
            addCriterion("order_exception_state <>", value, "orderExceptionState");
            return (Criteria) this;
        }

        public Criteria andOrderExceptionStateGreaterThan(Integer value) {
            addCriterion("order_exception_state >", value, "orderExceptionState");
            return (Criteria) this;
        }

        public Criteria andOrderExceptionStateGreaterThanOrEqualTo(Integer value) {
            addCriterion("order_exception_state >=", value, "orderExceptionState");
            return (Criteria) this;
        }

        public Criteria andOrderExceptionStateLessThan(Integer value) {
            addCriterion("order_exception_state <", value, "orderExceptionState");
            return (Criteria) this;
        }
        public Criteria andSearchBykey(String key) {
        	String content = "(order_user_name like '%"+key+"%' or order_number like '%"+key+"%' or order_user_phone like '%"
        			+key+"%') ";
            addCriterion(content);
            return (Criteria) this;
        }
        public Criteria andOrderExceptionStateLessThanOrEqualTo(Integer value) {
            addCriterion("order_exception_state <=", value, "orderExceptionState");
            return (Criteria) this;
        }

        public Criteria andOrderExceptionStateIn(List<Integer> values) {
            addCriterion("order_exception_state in", values, "orderExceptionState");
            return (Criteria) this;
        }

        public Criteria andOrderExceptionStateNotIn(List<Integer> values) {
            addCriterion("order_exception_state not in", values, "orderExceptionState");
            return (Criteria) this;
        }

        public Criteria andOrderExceptionStateBetween(Integer value1, Integer value2) {
            addCriterion("order_exception_state between", value1, value2, "orderExceptionState");
            return (Criteria) this;
        }

        public Criteria andOrderExceptionStateNotBetween(Integer value1, Integer value2) {
            addCriterion("order_exception_state not between", value1, value2, "orderExceptionState");
            return (Criteria) this;
        }

        public Criteria andOrderDistanceIsNull() {
            addCriterion("order_distance is null");
            return (Criteria) this;
        }

        public Criteria andOrderDistanceIsNotNull() {
            addCriterion("order_distance is not null");
            return (Criteria) this;
        }

        public Criteria andOrderDistanceEqualTo(Integer value) {
            addCriterion("order_distance =", value, "orderDistance");
            return (Criteria) this;
        }

        public Criteria andOrderDistanceNotEqualTo(Integer value) {
            addCriterion("order_distance <>", value, "orderDistance");
            return (Criteria) this;
        }

        public Criteria andOrderDistanceGreaterThan(Integer value) {
            addCriterion("order_distance >", value, "orderDistance");
            return (Criteria) this;
        }

        public Criteria andOrderDistanceGreaterThanOrEqualTo(Integer value) {
            addCriterion("order_distance >=", value, "orderDistance");
            return (Criteria) this;
        }

        public Criteria andOrderDistanceLessThan(Integer value) {
            addCriterion("order_distance <", value, "orderDistance");
            return (Criteria) this;
        }

        public Criteria andOrderDistanceLessThanOrEqualTo(Integer value) {
            addCriterion("order_distance <=", value, "orderDistance");
            return (Criteria) this;
        }

        public Criteria andOrderDistanceIn(List<Integer> values) {
            addCriterion("order_distance in", values, "orderDistance");
            return (Criteria) this;
        }

        public Criteria andOrderDistanceNotIn(List<Integer> values) {
            addCriterion("order_distance not in", values, "orderDistance");
            return (Criteria) this;
        }

        public Criteria andOrderDistanceBetween(Integer value1, Integer value2) {
            addCriterion("order_distance between", value1, value2, "orderDistance");
            return (Criteria) this;
        }

        public Criteria andOrderDistanceNotBetween(Integer value1, Integer value2) {
            addCriterion("order_distance not between", value1, value2, "orderDistance");
            return (Criteria) this;
        }

        public Criteria andOrderWeightIsNull() {
            addCriterion("order_weight is null");
            return (Criteria) this;
        }

        public Criteria andOrderWeightIsNotNull() {
            addCriterion("order_weight is not null");
            return (Criteria) this;
        }

        public Criteria andOrderWeightEqualTo(Integer value) {
            addCriterion("order_weight =", value, "orderWeight");
            return (Criteria) this;
        }

        public Criteria andOrderWeightNotEqualTo(Integer value) {
            addCriterion("order_weight <>", value, "orderWeight");
            return (Criteria) this;
        }

        public Criteria andOrderWeightGreaterThan(Integer value) {
            addCriterion("order_weight >", value, "orderWeight");
            return (Criteria) this;
        }

        public Criteria andOrderWeightGreaterThanOrEqualTo(Integer value) {
            addCriterion("order_weight >=", value, "orderWeight");
            return (Criteria) this;
        }

        public Criteria andOrderWeightLessThan(Integer value) {
            addCriterion("order_weight <", value, "orderWeight");
            return (Criteria) this;
        }

        public Criteria andOrderWeightLessThanOrEqualTo(Integer value) {
            addCriterion("order_weight <=", value, "orderWeight");
            return (Criteria) this;
        }

        public Criteria andOrderWeightIn(List<Integer> values) {
            addCriterion("order_weight in", values, "orderWeight");
            return (Criteria) this;
        }

        public Criteria andOrderWeightNotIn(List<Integer> values) {
            addCriterion("order_weight not in", values, "orderWeight");
            return (Criteria) this;
        }

        public Criteria andOrderWeightBetween(Integer value1, Integer value2) {
            addCriterion("order_weight between", value1, value2, "orderWeight");
            return (Criteria) this;
        }

        public Criteria andOrderWeightNotBetween(Integer value1, Integer value2) {
            addCriterion("order_weight not between", value1, value2, "orderWeight");
            return (Criteria) this;
        }

        public Criteria andOrderRefundStateIsNull() {
            addCriterion("order_refund_state is null");
            return (Criteria) this;
        }

        public Criteria andOrderRefundStateIsNotNull() {
            addCriterion("order_refund_state is not null");
            return (Criteria) this;
        }

        public Criteria andOrderRefundStateEqualTo(Integer value) {
            addCriterion("order_refund_state =", value, "orderRefundState");
            return (Criteria) this;
        }

        public Criteria andOrderRefundStateNotEqualTo(Integer value) {
            addCriterion("order_refund_state <>", value, "orderRefundState");
            return (Criteria) this;
        }

        public Criteria andOrderRefundStateGreaterThan(Integer value) {
            addCriterion("order_refund_state >", value, "orderRefundState");
            return (Criteria) this;
        }

        public Criteria andOrderRefundStateGreaterThanOrEqualTo(Integer value) {
            addCriterion("order_refund_state >=", value, "orderRefundState");
            return (Criteria) this;
        }

        public Criteria andOrderRefundStateLessThan(Integer value) {
            addCriterion("order_refund_state <", value, "orderRefundState");
            return (Criteria) this;
        }

        public Criteria andOrderRefundStateLessThanOrEqualTo(Integer value) {
            addCriterion("order_refund_state <=", value, "orderRefundState");
            return (Criteria) this;
        }

        public Criteria andOrderRefundStateIn(List<Integer> values) {
            addCriterion("order_refund_state in", values, "orderRefundState");
            return (Criteria) this;
        }

        public Criteria andOrderRefundStateNotIn(List<Integer> values) {
            addCriterion("order_refund_state not in", values, "orderRefundState");
            return (Criteria) this;
        }

        public Criteria andOrderRefundStateBetween(Integer value1, Integer value2) {
            addCriterion("order_refund_state between", value1, value2, "orderRefundState");
            return (Criteria) this;
        }

        public Criteria andOrderRefundStateNotBetween(Integer value1, Integer value2) {
            addCriterion("order_refund_state not between", value1, value2, "orderRefundState");
            return (Criteria) this;
        }

        public Criteria andOrderPayRemarkIsNull() {
            addCriterion("order_pay_remark is null");
            return (Criteria) this;
        }

        public Criteria andOrderPayRemarkIsNotNull() {
            addCriterion("order_pay_remark is not null");
            return (Criteria) this;
        }

        public Criteria andOrderPayRemarkEqualTo(String value) {
            addCriterion("order_pay_remark =", value, "orderPayRemark");
            return (Criteria) this;
        }

        public Criteria andOrderPayRemarkNotEqualTo(String value) {
            addCriterion("order_pay_remark <>", value, "orderPayRemark");
            return (Criteria) this;
        }

        public Criteria andOrderPayRemarkGreaterThan(String value) {
            addCriterion("order_pay_remark >", value, "orderPayRemark");
            return (Criteria) this;
        }

        public Criteria andOrderPayRemarkGreaterThanOrEqualTo(String value) {
            addCriterion("order_pay_remark >=", value, "orderPayRemark");
            return (Criteria) this;
        }

        public Criteria andOrderPayRemarkLessThan(String value) {
            addCriterion("order_pay_remark <", value, "orderPayRemark");
            return (Criteria) this;
        }

        public Criteria andOrderPayRemarkLessThanOrEqualTo(String value) {
            addCriterion("order_pay_remark <=", value, "orderPayRemark");
            return (Criteria) this;
        }

        public Criteria andOrderPayRemarkLike(String value) {
            addCriterion("order_pay_remark like", value, "orderPayRemark");
            return (Criteria) this;
        }

        public Criteria andOrderPayRemarkNotLike(String value) {
            addCriterion("order_pay_remark not like", value, "orderPayRemark");
            return (Criteria) this;
        }

        public Criteria andOrderPayRemarkIn(List<String> values) {
            addCriterion("order_pay_remark in", values, "orderPayRemark");
            return (Criteria) this;
        }

        public Criteria andOrderPayRemarkNotIn(List<String> values) {
            addCriterion("order_pay_remark not in", values, "orderPayRemark");
            return (Criteria) this;
        }

        public Criteria andOrderPayRemarkBetween(String value1, String value2) {
            addCriterion("order_pay_remark between", value1, value2, "orderPayRemark");
            return (Criteria) this;
        }

        public Criteria andOrderPayRemarkNotBetween(String value1, String value2) {
            addCriterion("order_pay_remark not between", value1, value2, "orderPayRemark");
            return (Criteria) this;
        }

        public Criteria andOrderPayTimeIsNull() {
            addCriterion("order_pay_time is null");
            return (Criteria) this;
        }

        public Criteria andOrderPayTimeIsNotNull() {
            addCriterion("order_pay_time is not null");
            return (Criteria) this;
        }

        public Criteria andOrderPayTimeEqualTo(Date value) {
            addCriterion("order_pay_time =", value, "orderPayTime");
            return (Criteria) this;
        }

        public Criteria andOrderPayTimeNotEqualTo(Date value) {
            addCriterion("order_pay_time <>", value, "orderPayTime");
            return (Criteria) this;
        }

        public Criteria andOrderPayTimeGreaterThan(Date value) {
            addCriterion("order_pay_time >", value, "orderPayTime");
            return (Criteria) this;
        }

        public Criteria andOrderPayTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("order_pay_time >=", value, "orderPayTime");
            return (Criteria) this;
        }

        public Criteria andOrderPayTimeLessThan(Date value) {
            addCriterion("order_pay_time <", value, "orderPayTime");
            return (Criteria) this;
        }

        public Criteria andOrderPayTimeLessThanOrEqualTo(Date value) {
            addCriterion("order_pay_time <=", value, "orderPayTime");
            return (Criteria) this;
        }

        public Criteria andOrderPayTimeIn(List<Date> values) {
            addCriterion("order_pay_time in", values, "orderPayTime");
            return (Criteria) this;
        }

        public Criteria andOrderPayTimeNotIn(List<Date> values) {
            addCriterion("order_pay_time not in", values, "orderPayTime");
            return (Criteria) this;
        }

        public Criteria andOrderPayTimeBetween(Date value1, Date value2) {
            addCriterion("order_pay_time between", value1, value2, "orderPayTime");
            return (Criteria) this;
        }

        public Criteria andOrderPayTimeNotBetween(Date value1, Date value2) {
            addCriterion("order_pay_time not between", value1, value2, "orderPayTime");
            return (Criteria) this;
        }

        public Criteria andOrderTranspoetAmountIsNull() {
            addCriterion("order_transpoet_amount is null");
            return (Criteria) this;
        }

        public Criteria andOrderTranspoetAmountIsNotNull() {
            addCriterion("order_transpoet_amount is not null");
            return (Criteria) this;
        }

        public Criteria andOrderTranspoetAmountEqualTo(Integer value) {
            addCriterion("order_transpoet_amount =", value, "orderTranspoetAmount");
            return (Criteria) this;
        }

        public Criteria andOrderTranspoetAmountNotEqualTo(Integer value) {
            addCriterion("order_transpoet_amount <>", value, "orderTranspoetAmount");
            return (Criteria) this;
        }

        public Criteria andOrderTranspoetAmountGreaterThan(Integer value) {
            addCriterion("order_transpoet_amount >", value, "orderTranspoetAmount");
            return (Criteria) this;
        }

        public Criteria andOrderTranspoetAmountGreaterThanOrEqualTo(Integer value) {
            addCriterion("order_transpoet_amount >=", value, "orderTranspoetAmount");
            return (Criteria) this;
        }

        public Criteria andOrderTranspoetAmountLessThan(Integer value) {
            addCriterion("order_transpoet_amount <", value, "orderTranspoetAmount");
            return (Criteria) this;
        }

        public Criteria andOrderTranspoetAmountLessThanOrEqualTo(Integer value) {
            addCriterion("order_transpoet_amount <=", value, "orderTranspoetAmount");
            return (Criteria) this;
        }

        public Criteria andOrderTranspoetAmountIn(List<Integer> values) {
            addCriterion("order_transpoet_amount in", values, "orderTranspoetAmount");
            return (Criteria) this;
        }

        public Criteria andOrderTranspoetAmountNotIn(List<Integer> values) {
            addCriterion("order_transpoet_amount not in", values, "orderTranspoetAmount");
            return (Criteria) this;
        }

        public Criteria andOrderTranspoetAmountBetween(Integer value1, Integer value2) {
            addCriterion("order_transpoet_amount between", value1, value2, "orderTranspoetAmount");
            return (Criteria) this;
        }

        public Criteria andOrderTranspoetAmountNotBetween(Integer value1, Integer value2) {
            addCriterion("order_transpoet_amount not between", value1, value2, "orderTranspoetAmount");
            return (Criteria) this;
        }

        public Criteria andOrderStoreAmountIsNull() {
            addCriterion("order_store_amount is null");
            return (Criteria) this;
        }

        public Criteria andOrderStoreAmountIsNotNull() {
            addCriterion("order_store_amount is not null");
            return (Criteria) this;
        }

        public Criteria andOrderStoreAmountEqualTo(Integer value) {
            addCriterion("order_store_amount =", value, "orderStoreAmount");
            return (Criteria) this;
        }

        public Criteria andOrderStoreAmountNotEqualTo(Integer value) {
            addCriterion("order_store_amount <>", value, "orderStoreAmount");
            return (Criteria) this;
        }

        public Criteria andOrderStoreAmountGreaterThan(Integer value) {
            addCriterion("order_store_amount >", value, "orderStoreAmount");
            return (Criteria) this;
        }

        public Criteria andOrderStoreAmountGreaterThanOrEqualTo(Integer value) {
            addCriterion("order_store_amount >=", value, "orderStoreAmount");
            return (Criteria) this;
        }

        public Criteria andOrderStoreAmountLessThan(Integer value) {
            addCriterion("order_store_amount <", value, "orderStoreAmount");
            return (Criteria) this;
        }

        public Criteria andOrderStoreAmountLessThanOrEqualTo(Integer value) {
            addCriterion("order_store_amount <=", value, "orderStoreAmount");
            return (Criteria) this;
        }

        public Criteria andOrderStoreAmountIn(List<Integer> values) {
            addCriterion("order_store_amount in", values, "orderStoreAmount");
            return (Criteria) this;
        }

        public Criteria andOrderStoreAmountNotIn(List<Integer> values) {
            addCriterion("order_store_amount not in", values, "orderStoreAmount");
            return (Criteria) this;
        }

        public Criteria andOrderStoreAmountBetween(Integer value1, Integer value2) {
            addCriterion("order_store_amount between", value1, value2, "orderStoreAmount");
            return (Criteria) this;
        }

        public Criteria andOrderStoreAmountNotBetween(Integer value1, Integer value2) {
            addCriterion("order_store_amount not between", value1, value2, "orderStoreAmount");
            return (Criteria) this;
        }

        public Criteria andOrderAgentAdmountIsNull() {
            addCriterion("order_agent_admount is null");
            return (Criteria) this;
        }

        public Criteria andOrderAgentAdmountIsNotNull() {
            addCriterion("order_agent_admount is not null");
            return (Criteria) this;
        }

        public Criteria andOrderAgentAdmountEqualTo(Integer value) {
            addCriterion("order_agent_admount =", value, "orderAgentAdmount");
            return (Criteria) this;
        }

        public Criteria andOrderAgentAdmountNotEqualTo(Integer value) {
            addCriterion("order_agent_admount <>", value, "orderAgentAdmount");
            return (Criteria) this;
        }

        public Criteria andOrderAgentAdmountGreaterThan(Integer value) {
            addCriterion("order_agent_admount >", value, "orderAgentAdmount");
            return (Criteria) this;
        }

        public Criteria andOrderAgentAdmountGreaterThanOrEqualTo(Integer value) {
            addCriterion("order_agent_admount >=", value, "orderAgentAdmount");
            return (Criteria) this;
        }

        public Criteria andOrderAgentAdmountLessThan(Integer value) {
            addCriterion("order_agent_admount <", value, "orderAgentAdmount");
            return (Criteria) this;
        }

        public Criteria andOrderAgentAdmountLessThanOrEqualTo(Integer value) {
            addCriterion("order_agent_admount <=", value, "orderAgentAdmount");
            return (Criteria) this;
        }

        public Criteria andOrderAgentAdmountIn(List<Integer> values) {
            addCriterion("order_agent_admount in", values, "orderAgentAdmount");
            return (Criteria) this;
        }

        public Criteria andOrderAgentAdmountNotIn(List<Integer> values) {
            addCriterion("order_agent_admount not in", values, "orderAgentAdmount");
            return (Criteria) this;
        }

        public Criteria andOrderAgentAdmountBetween(Integer value1, Integer value2) {
            addCriterion("order_agent_admount between", value1, value2, "orderAgentAdmount");
            return (Criteria) this;
        }

        public Criteria andOrderAgentAdmountNotBetween(Integer value1, Integer value2) {
            addCriterion("order_agent_admount not between", value1, value2, "orderAgentAdmount");
            return (Criteria) this;
        }

        public Criteria andOrderAdminAmountIsNull() {
            addCriterion("order_admin_amount is null");
            return (Criteria) this;
        }

        public Criteria andOrderAdminAmountIsNotNull() {
            addCriterion("order_admin_amount is not null");
            return (Criteria) this;
        }

        public Criteria andOrderAdminAmountEqualTo(Integer value) {
            addCriterion("order_admin_amount =", value, "orderAdminAmount");
            return (Criteria) this;
        }

        public Criteria andOrderAdminAmountNotEqualTo(Integer value) {
            addCriterion("order_admin_amount <>", value, "orderAdminAmount");
            return (Criteria) this;
        }

        public Criteria andOrderAdminAmountGreaterThan(Integer value) {
            addCriterion("order_admin_amount >", value, "orderAdminAmount");
            return (Criteria) this;
        }

        public Criteria andOrderAdminAmountGreaterThanOrEqualTo(Integer value) {
            addCriterion("order_admin_amount >=", value, "orderAdminAmount");
            return (Criteria) this;
        }

        public Criteria andOrderAdminAmountLessThan(Integer value) {
            addCriterion("order_admin_amount <", value, "orderAdminAmount");
            return (Criteria) this;
        }

        public Criteria andOrderAdminAmountLessThanOrEqualTo(Integer value) {
            addCriterion("order_admin_amount <=", value, "orderAdminAmount");
            return (Criteria) this;
        }

        public Criteria andOrderAdminAmountIn(List<Integer> values) {
            addCriterion("order_admin_amount in", values, "orderAdminAmount");
            return (Criteria) this;
        }

        public Criteria andOrderAdminAmountNotIn(List<Integer> values) {
            addCriterion("order_admin_amount not in", values, "orderAdminAmount");
            return (Criteria) this;
        }

        public Criteria andOrderAdminAmountBetween(Integer value1, Integer value2) {
            addCriterion("order_admin_amount between", value1, value2, "orderAdminAmount");
            return (Criteria) this;
        }

        public Criteria andOrderAdminAmountNotBetween(Integer value1, Integer value2) {
            addCriterion("order_admin_amount not between", value1, value2, "orderAdminAmount");
            return (Criteria) this;
        }

        public Criteria andOrderStationAmountIsNull() {
            addCriterion("order_station_amount is null");
            return (Criteria) this;
        }

        public Criteria andOrderStationAmountIsNotNull() {
            addCriterion("order_station_amount is not null");
            return (Criteria) this;
        }

        public Criteria andOrderStationAmountEqualTo(Integer value) {
            addCriterion("order_station_amount =", value, "orderStationAmount");
            return (Criteria) this;
        }

        public Criteria andOrderStationAmountNotEqualTo(Integer value) {
            addCriterion("order_station_amount <>", value, "orderStationAmount");
            return (Criteria) this;
        }

        public Criteria andOrderStationAmountGreaterThan(Integer value) {
            addCriterion("order_station_amount >", value, "orderStationAmount");
            return (Criteria) this;
        }

        public Criteria andOrderStationAmountGreaterThanOrEqualTo(Integer value) {
            addCriterion("order_station_amount >=", value, "orderStationAmount");
            return (Criteria) this;
        }

        public Criteria andOrderStationAmountLessThan(Integer value) {
            addCriterion("order_station_amount <", value, "orderStationAmount");
            return (Criteria) this;
        }

        public Criteria andOrderStationAmountLessThanOrEqualTo(Integer value) {
            addCriterion("order_station_amount <=", value, "orderStationAmount");
            return (Criteria) this;
        }

        public Criteria andOrderStationAmountIn(List<Integer> values) {
            addCriterion("order_station_amount in", values, "orderStationAmount");
            return (Criteria) this;
        }

        public Criteria andOrderStationAmountNotIn(List<Integer> values) {
            addCriterion("order_station_amount not in", values, "orderStationAmount");
            return (Criteria) this;
        }

        public Criteria andOrderStationAmountBetween(Integer value1, Integer value2) {
            addCriterion("order_station_amount between", value1, value2, "orderStationAmount");
            return (Criteria) this;
        }

        public Criteria andOrderStationAmountNotBetween(Integer value1, Integer value2) {
            addCriterion("order_station_amount not between", value1, value2, "orderStationAmount");
            return (Criteria) this;
        }

        public Criteria andOrderSettlementDateIsNull() {
            addCriterion("order_settlement_date is null");
            return (Criteria) this;
        }

        public Criteria andOrderSettlementDateIsNotNull() {
            addCriterion("order_settlement_date is not null");
            return (Criteria) this;
        }

        public Criteria andOrderSettlementDateEqualTo(Date value) {
            addCriterion("order_settlement_date =", value, "orderSettlementDate");
            return (Criteria) this;
        }

        public Criteria andOrderSettlementDateNotEqualTo(Date value) {
            addCriterion("order_settlement_date <>", value, "orderSettlementDate");
            return (Criteria) this;
        }

        public Criteria andOrderSettlementDateGreaterThan(Date value) {
            addCriterion("order_settlement_date >", value, "orderSettlementDate");
            return (Criteria) this;
        }

        public Criteria andOrderSettlementDateGreaterThanOrEqualTo(Date value) {
            addCriterion("order_settlement_date >=", value, "orderSettlementDate");
            return (Criteria) this;
        }

        public Criteria andOrderSettlementDateLessThan(Date value) {
            addCriterion("order_settlement_date <", value, "orderSettlementDate");
            return (Criteria) this;
        }

        public Criteria andOrderSettlementDateLessThanOrEqualTo(Date value) {
            addCriterion("order_settlement_date <=", value, "orderSettlementDate");
            return (Criteria) this;
        }

        public Criteria andOrderSettlementDateIn(List<Date> values) {
            addCriterion("order_settlement_date in", values, "orderSettlementDate");
            return (Criteria) this;
        }

        public Criteria andOrderSettlementDateNotIn(List<Date> values) {
            addCriterion("order_settlement_date not in", values, "orderSettlementDate");
            return (Criteria) this;
        }

        public Criteria andOrderSettlementDateBetween(Date value1, Date value2) {
            addCriterion("order_settlement_date between", value1, value2, "orderSettlementDate");
            return (Criteria) this;
        }

        public Criteria andOrderSettlementDateNotBetween(Date value1, Date value2) {
            addCriterion("order_settlement_date not between", value1, value2, "orderSettlementDate");
            return (Criteria) this;
        }

        public Criteria andOrderExpressIdIsNull() {
            addCriterion("order_express_id is null");
            return (Criteria) this;
        }

        public Criteria andOrderExpressIdIsNotNull() {
            addCriterion("order_express_id is not null");
            return (Criteria) this;
        }

        public Criteria andOrderExpressIdEqualTo(Integer value) {
            addCriterion("order_express_id =", value, "orderExpressId");
            return (Criteria) this;
        }

        public Criteria andOrderExpressIdNotEqualTo(Integer value) {
            addCriterion("order_express_id <>", value, "orderExpressId");
            return (Criteria) this;
        }

        public Criteria andOrderExpressIdGreaterThan(Integer value) {
            addCriterion("order_express_id >", value, "orderExpressId");
            return (Criteria) this;
        }

        public Criteria andOrderExpressIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("order_express_id >=", value, "orderExpressId");
            return (Criteria) this;
        }

        public Criteria andOrderExpressIdLessThan(Integer value) {
            addCriterion("order_express_id <", value, "orderExpressId");
            return (Criteria) this;
        }

        public Criteria andOrderExpressIdLessThanOrEqualTo(Integer value) {
            addCriterion("order_express_id <=", value, "orderExpressId");
            return (Criteria) this;
        }

        public Criteria andOrderExpressIdIn(List<Integer> values) {
            addCriterion("order_express_id in", values, "orderExpressId");
            return (Criteria) this;
        }

        public Criteria andOrderExpressIdNotIn(List<Integer> values) {
            addCriterion("order_express_id not in", values, "orderExpressId");
            return (Criteria) this;
        }

        public Criteria andOrderExpressIdBetween(Integer value1, Integer value2) {
            addCriterion("order_express_id between", value1, value2, "orderExpressId");
            return (Criteria) this;
        }

        public Criteria andOrderExpressIdNotBetween(Integer value1, Integer value2) {
            addCriterion("order_express_id not between", value1, value2, "orderExpressId");
            return (Criteria) this;
        }

        public Criteria andOrderExpressNoIsNull() {
            addCriterion("order_express_no is null");
            return (Criteria) this;
        }

        public Criteria andOrderExpressNoIsNotNull() {
            addCriterion("order_express_no is not null");
            return (Criteria) this;
        }

        public Criteria andOrderExpressNoEqualTo(String value) {
            addCriterion("order_express_no =", value, "orderExpressNo");
            return (Criteria) this;
        }

        public Criteria andOrderExpressNoNotEqualTo(String value) {
            addCriterion("order_express_no <>", value, "orderExpressNo");
            return (Criteria) this;
        }

        public Criteria andOrderExpressNoGreaterThan(String value) {
            addCriterion("order_express_no >", value, "orderExpressNo");
            return (Criteria) this;
        }

        public Criteria andOrderExpressNoGreaterThanOrEqualTo(String value) {
            addCriterion("order_express_no >=", value, "orderExpressNo");
            return (Criteria) this;
        }

        public Criteria andOrderExpressNoLessThan(String value) {
            addCriterion("order_express_no <", value, "orderExpressNo");
            return (Criteria) this;
        }

        public Criteria andOrderExpressNoLessThanOrEqualTo(String value) {
            addCriterion("order_express_no <=", value, "orderExpressNo");
            return (Criteria) this;
        }

        public Criteria andOrderExpressNoLike(String value) {
            addCriterion("order_express_no like", value, "orderExpressNo");
            return (Criteria) this;
        }

        public Criteria andOrderExpressNoNotLike(String value) {
            addCriterion("order_express_no not like", value, "orderExpressNo");
            return (Criteria) this;
        }

        public Criteria andOrderExpressNoIn(List<String> values) {
            addCriterion("order_express_no in", values, "orderExpressNo");
            return (Criteria) this;
        }

        public Criteria andOrderExpressNoNotIn(List<String> values) {
            addCriterion("order_express_no not in", values, "orderExpressNo");
            return (Criteria) this;
        }

        public Criteria andOrderExpressNoBetween(String value1, String value2) {
            addCriterion("order_express_no between", value1, value2, "orderExpressNo");
            return (Criteria) this;
        }

        public Criteria andOrderExpressNoNotBetween(String value1, String value2) {
            addCriterion("order_express_no not between", value1, value2, "orderExpressNo");
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