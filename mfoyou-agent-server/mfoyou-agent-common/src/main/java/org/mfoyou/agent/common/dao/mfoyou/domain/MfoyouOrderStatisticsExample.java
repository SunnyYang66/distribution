package org.mfoyou.agent.common.dao.mfoyou.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class MfoyouOrderStatisticsExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    protected Integer limitStart;

    protected Integer limitEnd;

    public MfoyouOrderStatisticsExample() {
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

        public Criteria andCountIdIsNull() {
            addCriterion("count_id is null");
            return (Criteria) this;
        }

        public Criteria andCountIdIsNotNull() {
            addCriterion("count_id is not null");
            return (Criteria) this;
        }

        public Criteria andCountIdEqualTo(Integer value) {
            addCriterion("count_id =", value, "countId");
            return (Criteria) this;
        }

        public Criteria andCountIdNotEqualTo(Integer value) {
            addCriterion("count_id <>", value, "countId");
            return (Criteria) this;
        }

        public Criteria andCountIdGreaterThan(Integer value) {
            addCriterion("count_id >", value, "countId");
            return (Criteria) this;
        }

        public Criteria andCountIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("count_id >=", value, "countId");
            return (Criteria) this;
        }

        public Criteria andCountIdLessThan(Integer value) {
            addCriterion("count_id <", value, "countId");
            return (Criteria) this;
        }

        public Criteria andCountIdLessThanOrEqualTo(Integer value) {
            addCriterion("count_id <=", value, "countId");
            return (Criteria) this;
        }

        public Criteria andCountIdIn(List<Integer> values) {
            addCriterion("count_id in", values, "countId");
            return (Criteria) this;
        }

        public Criteria andCountIdNotIn(List<Integer> values) {
            addCriterion("count_id not in", values, "countId");
            return (Criteria) this;
        }

        public Criteria andCountIdBetween(Integer value1, Integer value2) {
            addCriterion("count_id between", value1, value2, "countId");
            return (Criteria) this;
        }

        public Criteria andCountIdNotBetween(Integer value1, Integer value2) {
            addCriterion("count_id not between", value1, value2, "countId");
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

        public Criteria andDayIdIsNull() {
            addCriterion("day_id is null");
            return (Criteria) this;
        }

        public Criteria andDayIdIsNotNull() {
            addCriterion("day_id is not null");
            return (Criteria) this;
        }

        public Criteria andDayIdEqualTo(Integer value) {
            addCriterion("day_id =", value, "dayId");
            return (Criteria) this;
        }

        public Criteria andDayIdNotEqualTo(Integer value) {
            addCriterion("day_id <>", value, "dayId");
            return (Criteria) this;
        }

        public Criteria andDayIdGreaterThan(Integer value) {
            addCriterion("day_id >", value, "dayId");
            return (Criteria) this;
        }

        public Criteria andDayIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("day_id >=", value, "dayId");
            return (Criteria) this;
        }

        public Criteria andDayIdLessThan(Integer value) {
            addCriterion("day_id <", value, "dayId");
            return (Criteria) this;
        }

        public Criteria andDayIdLessThanOrEqualTo(Integer value) {
            addCriterion("day_id <=", value, "dayId");
            return (Criteria) this;
        }

        public Criteria andDayIdIn(List<Integer> values) {
            addCriterion("day_id in", values, "dayId");
            return (Criteria) this;
        }

        public Criteria andDayIdNotIn(List<Integer> values) {
            addCriterion("day_id not in", values, "dayId");
            return (Criteria) this;
        }

        public Criteria andDayIdBetween(Integer value1, Integer value2) {
            addCriterion("day_id between", value1, value2, "dayId");
            return (Criteria) this;
        }

        public Criteria andDayIdNotBetween(Integer value1, Integer value2) {
            addCriterion("day_id not between", value1, value2, "dayId");
            return (Criteria) this;
        }

        public Criteria andOrderCountIsNull() {
            addCriterion("order_count is null");
            return (Criteria) this;
        }

        public Criteria andOrderCountIsNotNull() {
            addCriterion("order_count is not null");
            return (Criteria) this;
        }

        public Criteria andOrderCountEqualTo(Integer value) {
            addCriterion("order_count =", value, "orderCount");
            return (Criteria) this;
        }

        public Criteria andOrderCountNotEqualTo(Integer value) {
            addCriterion("order_count <>", value, "orderCount");
            return (Criteria) this;
        }

        public Criteria andOrderCountGreaterThan(Integer value) {
            addCriterion("order_count >", value, "orderCount");
            return (Criteria) this;
        }

        public Criteria andOrderCountGreaterThanOrEqualTo(Integer value) {
            addCriterion("order_count >=", value, "orderCount");
            return (Criteria) this;
        }

        public Criteria andOrderCountLessThan(Integer value) {
            addCriterion("order_count <", value, "orderCount");
            return (Criteria) this;
        }

        public Criteria andOrderCountLessThanOrEqualTo(Integer value) {
            addCriterion("order_count <=", value, "orderCount");
            return (Criteria) this;
        }

        public Criteria andOrderCountIn(List<Integer> values) {
            addCriterion("order_count in", values, "orderCount");
            return (Criteria) this;
        }

        public Criteria andOrderCountNotIn(List<Integer> values) {
            addCriterion("order_count not in", values, "orderCount");
            return (Criteria) this;
        }

        public Criteria andOrderCountBetween(Integer value1, Integer value2) {
            addCriterion("order_count between", value1, value2, "orderCount");
            return (Criteria) this;
        }

        public Criteria andOrderCountNotBetween(Integer value1, Integer value2) {
            addCriterion("order_count not between", value1, value2, "orderCount");
            return (Criteria) this;
        }

        public Criteria andTotalAmountIsNull() {
            addCriterion("total_amount is null");
            return (Criteria) this;
        }

        public Criteria andTotalAmountIsNotNull() {
            addCriterion("total_amount is not null");
            return (Criteria) this;
        }

        public Criteria andTotalAmountEqualTo(Integer value) {
            addCriterion("total_amount =", value, "totalAmount");
            return (Criteria) this;
        }

        public Criteria andTotalAmountNotEqualTo(Integer value) {
            addCriterion("total_amount <>", value, "totalAmount");
            return (Criteria) this;
        }

        public Criteria andTotalAmountGreaterThan(Integer value) {
            addCriterion("total_amount >", value, "totalAmount");
            return (Criteria) this;
        }

        public Criteria andTotalAmountGreaterThanOrEqualTo(Integer value) {
            addCriterion("total_amount >=", value, "totalAmount");
            return (Criteria) this;
        }

        public Criteria andTotalAmountLessThan(Integer value) {
            addCriterion("total_amount <", value, "totalAmount");
            return (Criteria) this;
        }

        public Criteria andTotalAmountLessThanOrEqualTo(Integer value) {
            addCriterion("total_amount <=", value, "totalAmount");
            return (Criteria) this;
        }

        public Criteria andTotalAmountIn(List<Integer> values) {
            addCriterion("total_amount in", values, "totalAmount");
            return (Criteria) this;
        }

        public Criteria andTotalAmountNotIn(List<Integer> values) {
            addCriterion("total_amount not in", values, "totalAmount");
            return (Criteria) this;
        }

        public Criteria andTotalAmountBetween(Integer value1, Integer value2) {
            addCriterion("total_amount between", value1, value2, "totalAmount");
            return (Criteria) this;
        }

        public Criteria andTotalAmountNotBetween(Integer value1, Integer value2) {
            addCriterion("total_amount not between", value1, value2, "totalAmount");
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

        public Criteria andPayAmountNotBetween(Integer value1, Integer value2) {
            addCriterion("pay_amount not between", value1, value2, "payAmount");
            return (Criteria) this;
        }

        public Criteria andGoodsCountIsNull() {
            addCriterion("goods_count is null");
            return (Criteria) this;
        }

        public Criteria andGoodsCountIsNotNull() {
            addCriterion("goods_count is not null");
            return (Criteria) this;
        }

        public Criteria andGoodsCountEqualTo(Integer value) {
            addCriterion("goods_count =", value, "goodsCount");
            return (Criteria) this;
        }

        public Criteria andGoodsCountNotEqualTo(Integer value) {
            addCriterion("goods_count <>", value, "goodsCount");
            return (Criteria) this;
        }

        public Criteria andGoodsCountGreaterThan(Integer value) {
            addCriterion("goods_count >", value, "goodsCount");
            return (Criteria) this;
        }

        public Criteria andGoodsCountGreaterThanOrEqualTo(Integer value) {
            addCriterion("goods_count >=", value, "goodsCount");
            return (Criteria) this;
        }

        public Criteria andGoodsCountLessThan(Integer value) {
            addCriterion("goods_count <", value, "goodsCount");
            return (Criteria) this;
        }

        public Criteria andGoodsCountLessThanOrEqualTo(Integer value) {
            addCriterion("goods_count <=", value, "goodsCount");
            return (Criteria) this;
        }

        public Criteria andGoodsCountIn(List<Integer> values) {
            addCriterion("goods_count in", values, "goodsCount");
            return (Criteria) this;
        }

        public Criteria andGoodsCountNotIn(List<Integer> values) {
            addCriterion("goods_count not in", values, "goodsCount");
            return (Criteria) this;
        }

        public Criteria andGoodsCountBetween(Integer value1, Integer value2) {
            addCriterion("goods_count between", value1, value2, "goodsCount");
            return (Criteria) this;
        }

        public Criteria andGoodsCountNotBetween(Integer value1, Integer value2) {
            addCriterion("goods_count not between", value1, value2, "goodsCount");
            return (Criteria) this;
        }

        public Criteria andGoodsAmountIsNull() {
            addCriterion("goods_amount is null");
            return (Criteria) this;
        }

        public Criteria andGoodsAmountIsNotNull() {
            addCriterion("goods_amount is not null");
            return (Criteria) this;
        }

        public Criteria andGoodsAmountEqualTo(Integer value) {
            addCriterion("goods_amount =", value, "goodsAmount");
            return (Criteria) this;
        }

        public Criteria andGoodsAmountNotEqualTo(Integer value) {
            addCriterion("goods_amount <>", value, "goodsAmount");
            return (Criteria) this;
        }

        public Criteria andGoodsAmountGreaterThan(Integer value) {
            addCriterion("goods_amount >", value, "goodsAmount");
            return (Criteria) this;
        }

        public Criteria andGoodsAmountGreaterThanOrEqualTo(Integer value) {
            addCriterion("goods_amount >=", value, "goodsAmount");
            return (Criteria) this;
        }

        public Criteria andGoodsAmountLessThan(Integer value) {
            addCriterion("goods_amount <", value, "goodsAmount");
            return (Criteria) this;
        }

        public Criteria andGoodsAmountLessThanOrEqualTo(Integer value) {
            addCriterion("goods_amount <=", value, "goodsAmount");
            return (Criteria) this;
        }

        public Criteria andGoodsAmountIn(List<Integer> values) {
            addCriterion("goods_amount in", values, "goodsAmount");
            return (Criteria) this;
        }

        public Criteria andGoodsAmountNotIn(List<Integer> values) {
            addCriterion("goods_amount not in", values, "goodsAmount");
            return (Criteria) this;
        }

        public Criteria andGoodsAmountBetween(Integer value1, Integer value2) {
            addCriterion("goods_amount between", value1, value2, "goodsAmount");
            return (Criteria) this;
        }

        public Criteria andGoodsAmountNotBetween(Integer value1, Integer value2) {
            addCriterion("goods_amount not between", value1, value2, "goodsAmount");
            return (Criteria) this;
        }

        public Criteria andFreightAmountIsNull() {
            addCriterion("freight_amount is null");
            return (Criteria) this;
        }

        public Criteria andFreightAmountIsNotNull() {
            addCriterion("freight_amount is not null");
            return (Criteria) this;
        }

        public Criteria andFreightAmountEqualTo(Integer value) {
            addCriterion("freight_amount =", value, "freightAmount");
            return (Criteria) this;
        }

        public Criteria andFreightAmountNotEqualTo(Integer value) {
            addCriterion("freight_amount <>", value, "freightAmount");
            return (Criteria) this;
        }

        public Criteria andFreightAmountGreaterThan(Integer value) {
            addCriterion("freight_amount >", value, "freightAmount");
            return (Criteria) this;
        }

        public Criteria andFreightAmountGreaterThanOrEqualTo(Integer value) {
            addCriterion("freight_amount >=", value, "freightAmount");
            return (Criteria) this;
        }

        public Criteria andFreightAmountLessThan(Integer value) {
            addCriterion("freight_amount <", value, "freightAmount");
            return (Criteria) this;
        }

        public Criteria andFreightAmountLessThanOrEqualTo(Integer value) {
            addCriterion("freight_amount <=", value, "freightAmount");
            return (Criteria) this;
        }

        public Criteria andFreightAmountIn(List<Integer> values) {
            addCriterion("freight_amount in", values, "freightAmount");
            return (Criteria) this;
        }

        public Criteria andFreightAmountNotIn(List<Integer> values) {
            addCriterion("freight_amount not in", values, "freightAmount");
            return (Criteria) this;
        }

        public Criteria andFreightAmountBetween(Integer value1, Integer value2) {
            addCriterion("freight_amount between", value1, value2, "freightAmount");
            return (Criteria) this;
        }

        public Criteria andFreightAmountNotBetween(Integer value1, Integer value2) {
            addCriterion("freight_amount not between", value1, value2, "freightAmount");
            return (Criteria) this;
        }

        public Criteria andAttachAmountIsNull() {
            addCriterion("attach_amount is null");
            return (Criteria) this;
        }

        public Criteria andAttachAmountIsNotNull() {
            addCriterion("attach_amount is not null");
            return (Criteria) this;
        }

        public Criteria andAttachAmountEqualTo(Integer value) {
            addCriterion("attach_amount =", value, "attachAmount");
            return (Criteria) this;
        }

        public Criteria andAttachAmountNotEqualTo(Integer value) {
            addCriterion("attach_amount <>", value, "attachAmount");
            return (Criteria) this;
        }

        public Criteria andAttachAmountGreaterThan(Integer value) {
            addCriterion("attach_amount >", value, "attachAmount");
            return (Criteria) this;
        }

        public Criteria andAttachAmountGreaterThanOrEqualTo(Integer value) {
            addCriterion("attach_amount >=", value, "attachAmount");
            return (Criteria) this;
        }

        public Criteria andAttachAmountLessThan(Integer value) {
            addCriterion("attach_amount <", value, "attachAmount");
            return (Criteria) this;
        }

        public Criteria andAttachAmountLessThanOrEqualTo(Integer value) {
            addCriterion("attach_amount <=", value, "attachAmount");
            return (Criteria) this;
        }

        public Criteria andAttachAmountIn(List<Integer> values) {
            addCriterion("attach_amount in", values, "attachAmount");
            return (Criteria) this;
        }

        public Criteria andAttachAmountNotIn(List<Integer> values) {
            addCriterion("attach_amount not in", values, "attachAmount");
            return (Criteria) this;
        }

        public Criteria andAttachAmountBetween(Integer value1, Integer value2) {
            addCriterion("attach_amount between", value1, value2, "attachAmount");
            return (Criteria) this;
        }

        public Criteria andAttachAmountNotBetween(Integer value1, Integer value2) {
            addCriterion("attach_amount not between", value1, value2, "attachAmount");
            return (Criteria) this;
        }

        public Criteria andCountGctIsNull() {
            addCriterion("count_gct is null");
            return (Criteria) this;
        }

        public Criteria andCountGctIsNotNull() {
            addCriterion("count_gct is not null");
            return (Criteria) this;
        }

        public Criteria andCountGctEqualTo(Date value) {
            addCriterion("count_gct =", value, "countGct");
            return (Criteria) this;
        }

        public Criteria andCountGctNotEqualTo(Date value) {
            addCriterion("count_gct <>", value, "countGct");
            return (Criteria) this;
        }

        public Criteria andCountGctGreaterThan(Date value) {
            addCriterion("count_gct >", value, "countGct");
            return (Criteria) this;
        }

        public Criteria andCountGctGreaterThanOrEqualTo(Date value) {
            addCriterion("count_gct >=", value, "countGct");
            return (Criteria) this;
        }

        public Criteria andCountGctLessThan(Date value) {
            addCriterion("count_gct <", value, "countGct");
            return (Criteria) this;
        }

        public Criteria andCountGctLessThanOrEqualTo(Date value) {
            addCriterion("count_gct <=", value, "countGct");
            return (Criteria) this;
        }

        public Criteria andCountGctIn(List<Date> values) {
            addCriterion("count_gct in", values, "countGct");
            return (Criteria) this;
        }

        public Criteria andCountGctNotIn(List<Date> values) {
            addCriterion("count_gct not in", values, "countGct");
            return (Criteria) this;
        }

        public Criteria andCountGctBetween(Date value1, Date value2) {
            addCriterion("count_gct between", value1, value2, "countGct");
            return (Criteria) this;
        }

        public Criteria andCountGctNotBetween(Date value1, Date value2) {
            addCriterion("count_gct not between", value1, value2, "countGct");
            return (Criteria) this;
        }

        public Criteria andCountGmtIsNull() {
            addCriterion("count_gmt is null");
            return (Criteria) this;
        }

        public Criteria andCountGmtIsNotNull() {
            addCriterion("count_gmt is not null");
            return (Criteria) this;
        }

        public Criteria andCountGmtEqualTo(Date value) {
            addCriterion("count_gmt =", value, "countGmt");
            return (Criteria) this;
        }

        public Criteria andCountGmtNotEqualTo(Date value) {
            addCriterion("count_gmt <>", value, "countGmt");
            return (Criteria) this;
        }

        public Criteria andCountGmtGreaterThan(Date value) {
            addCriterion("count_gmt >", value, "countGmt");
            return (Criteria) this;
        }

        public Criteria andCountGmtGreaterThanOrEqualTo(Date value) {
            addCriterion("count_gmt >=", value, "countGmt");
            return (Criteria) this;
        }

        public Criteria andCountGmtLessThan(Date value) {
            addCriterion("count_gmt <", value, "countGmt");
            return (Criteria) this;
        }

        public Criteria andCountGmtLessThanOrEqualTo(Date value) {
            addCriterion("count_gmt <=", value, "countGmt");
            return (Criteria) this;
        }

        public Criteria andCountGmtIn(List<Date> values) {
            addCriterion("count_gmt in", values, "countGmt");
            return (Criteria) this;
        }

        public Criteria andCountGmtNotIn(List<Date> values) {
            addCriterion("count_gmt not in", values, "countGmt");
            return (Criteria) this;
        }

        public Criteria andCountGmtBetween(Date value1, Date value2) {
            addCriterion("count_gmt between", value1, value2, "countGmt");
            return (Criteria) this;
        }

        public Criteria andCountGmtNotBetween(Date value1, Date value2) {
            addCriterion("count_gmt not between", value1, value2, "countGmt");
            return (Criteria) this;
        }

        public Criteria andWeightIsNull() {
            addCriterion("weight is null");
            return (Criteria) this;
        }

        public Criteria andWeightIsNotNull() {
            addCriterion("weight is not null");
            return (Criteria) this;
        }

        public Criteria andWeightEqualTo(Integer value) {
            addCriterion("weight =", value, "weight");
            return (Criteria) this;
        }

        public Criteria andWeightNotEqualTo(Integer value) {
            addCriterion("weight <>", value, "weight");
            return (Criteria) this;
        }

        public Criteria andWeightGreaterThan(Integer value) {
            addCriterion("weight >", value, "weight");
            return (Criteria) this;
        }

        public Criteria andWeightGreaterThanOrEqualTo(Integer value) {
            addCriterion("weight >=", value, "weight");
            return (Criteria) this;
        }

        public Criteria andWeightLessThan(Integer value) {
            addCriterion("weight <", value, "weight");
            return (Criteria) this;
        }

        public Criteria andWeightLessThanOrEqualTo(Integer value) {
            addCriterion("weight <=", value, "weight");
            return (Criteria) this;
        }

        public Criteria andWeightIn(List<Integer> values) {
            addCriterion("weight in", values, "weight");
            return (Criteria) this;
        }

        public Criteria andWeightNotIn(List<Integer> values) {
            addCriterion("weight not in", values, "weight");
            return (Criteria) this;
        }

        public Criteria andWeightBetween(Integer value1, Integer value2) {
            addCriterion("weight between", value1, value2, "weight");
            return (Criteria) this;
        }

        public Criteria andWeightNotBetween(Integer value1, Integer value2) {
            addCriterion("weight not between", value1, value2, "weight");
            return (Criteria) this;
        }

        public Criteria andStoreAmountIsNull() {
            addCriterion("store_amount is null");
            return (Criteria) this;
        }

        public Criteria andStoreAmountIsNotNull() {
            addCriterion("store_amount is not null");
            return (Criteria) this;
        }

        public Criteria andStoreAmountEqualTo(Integer value) {
            addCriterion("store_amount =", value, "storeAmount");
            return (Criteria) this;
        }

        public Criteria andStoreAmountNotEqualTo(Integer value) {
            addCriterion("store_amount <>", value, "storeAmount");
            return (Criteria) this;
        }

        public Criteria andStoreAmountGreaterThan(Integer value) {
            addCriterion("store_amount >", value, "storeAmount");
            return (Criteria) this;
        }

        public Criteria andStoreAmountGreaterThanOrEqualTo(Integer value) {
            addCriterion("store_amount >=", value, "storeAmount");
            return (Criteria) this;
        }

        public Criteria andStoreAmountLessThan(Integer value) {
            addCriterion("store_amount <", value, "storeAmount");
            return (Criteria) this;
        }

        public Criteria andStoreAmountLessThanOrEqualTo(Integer value) {
            addCriterion("store_amount <=", value, "storeAmount");
            return (Criteria) this;
        }

        public Criteria andStoreAmountIn(List<Integer> values) {
            addCriterion("store_amount in", values, "storeAmount");
            return (Criteria) this;
        }

        public Criteria andStoreAmountNotIn(List<Integer> values) {
            addCriterion("store_amount not in", values, "storeAmount");
            return (Criteria) this;
        }

        public Criteria andStoreAmountBetween(Integer value1, Integer value2) {
            addCriterion("store_amount between", value1, value2, "storeAmount");
            return (Criteria) this;
        }

        public Criteria andStoreAmountNotBetween(Integer value1, Integer value2) {
            addCriterion("store_amount not between", value1, value2, "storeAmount");
            return (Criteria) this;
        }

        public Criteria andAgentAdmountIsNull() {
            addCriterion("agent_admount is null");
            return (Criteria) this;
        }

        public Criteria andAgentAdmountIsNotNull() {
            addCriterion("agent_admount is not null");
            return (Criteria) this;
        }

        public Criteria andAgentAdmountEqualTo(Integer value) {
            addCriterion("agent_admount =", value, "agentAdmount");
            return (Criteria) this;
        }

        public Criteria andAgentAdmountNotEqualTo(Integer value) {
            addCriterion("agent_admount <>", value, "agentAdmount");
            return (Criteria) this;
        }

        public Criteria andAgentAdmountGreaterThan(Integer value) {
            addCriterion("agent_admount >", value, "agentAdmount");
            return (Criteria) this;
        }

        public Criteria andAgentAdmountGreaterThanOrEqualTo(Integer value) {
            addCriterion("agent_admount >=", value, "agentAdmount");
            return (Criteria) this;
        }

        public Criteria andAgentAdmountLessThan(Integer value) {
            addCriterion("agent_admount <", value, "agentAdmount");
            return (Criteria) this;
        }

        public Criteria andAgentAdmountLessThanOrEqualTo(Integer value) {
            addCriterion("agent_admount <=", value, "agentAdmount");
            return (Criteria) this;
        }

        public Criteria andAgentAdmountIn(List<Integer> values) {
            addCriterion("agent_admount in", values, "agentAdmount");
            return (Criteria) this;
        }

        public Criteria andAgentAdmountNotIn(List<Integer> values) {
            addCriterion("agent_admount not in", values, "agentAdmount");
            return (Criteria) this;
        }

        public Criteria andAgentAdmountBetween(Integer value1, Integer value2) {
            addCriterion("agent_admount between", value1, value2, "agentAdmount");
            return (Criteria) this;
        }

        public Criteria andAgentAdmountNotBetween(Integer value1, Integer value2) {
            addCriterion("agent_admount not between", value1, value2, "agentAdmount");
            return (Criteria) this;
        }

        public Criteria andAdminAmountIsNull() {
            addCriterion("admin_amount is null");
            return (Criteria) this;
        }

        public Criteria andAdminAmountIsNotNull() {
            addCriterion("admin_amount is not null");
            return (Criteria) this;
        }

        public Criteria andAdminAmountEqualTo(Integer value) {
            addCriterion("admin_amount =", value, "adminAmount");
            return (Criteria) this;
        }

        public Criteria andAdminAmountNotEqualTo(Integer value) {
            addCriterion("admin_amount <>", value, "adminAmount");
            return (Criteria) this;
        }

        public Criteria andAdminAmountGreaterThan(Integer value) {
            addCriterion("admin_amount >", value, "adminAmount");
            return (Criteria) this;
        }

        public Criteria andAdminAmountGreaterThanOrEqualTo(Integer value) {
            addCriterion("admin_amount >=", value, "adminAmount");
            return (Criteria) this;
        }

        public Criteria andAdminAmountLessThan(Integer value) {
            addCriterion("admin_amount <", value, "adminAmount");
            return (Criteria) this;
        }

        public Criteria andAdminAmountLessThanOrEqualTo(Integer value) {
            addCriterion("admin_amount <=", value, "adminAmount");
            return (Criteria) this;
        }

        public Criteria andAdminAmountIn(List<Integer> values) {
            addCriterion("admin_amount in", values, "adminAmount");
            return (Criteria) this;
        }

        public Criteria andAdminAmountNotIn(List<Integer> values) {
            addCriterion("admin_amount not in", values, "adminAmount");
            return (Criteria) this;
        }

        public Criteria andAdminAmountBetween(Integer value1, Integer value2) {
            addCriterion("admin_amount between", value1, value2, "adminAmount");
            return (Criteria) this;
        }

        public Criteria andAdminAmountNotBetween(Integer value1, Integer value2) {
            addCriterion("admin_amount not between", value1, value2, "adminAmount");
            return (Criteria) this;
        }

        public Criteria andReturnAmountIsNull() {
            addCriterion("return_amount is null");
            return (Criteria) this;
        }

        public Criteria andReturnAmountIsNotNull() {
            addCriterion("return_amount is not null");
            return (Criteria) this;
        }

        public Criteria andReturnAmountEqualTo(Integer value) {
            addCriterion("return_amount =", value, "returnAmount");
            return (Criteria) this;
        }

        public Criteria andReturnAmountNotEqualTo(Integer value) {
            addCriterion("return_amount <>", value, "returnAmount");
            return (Criteria) this;
        }

        public Criteria andReturnAmountGreaterThan(Integer value) {
            addCriterion("return_amount >", value, "returnAmount");
            return (Criteria) this;
        }

        public Criteria andReturnAmountGreaterThanOrEqualTo(Integer value) {
            addCriterion("return_amount >=", value, "returnAmount");
            return (Criteria) this;
        }

        public Criteria andReturnAmountLessThan(Integer value) {
            addCriterion("return_amount <", value, "returnAmount");
            return (Criteria) this;
        }

        public Criteria andReturnAmountLessThanOrEqualTo(Integer value) {
            addCriterion("return_amount <=", value, "returnAmount");
            return (Criteria) this;
        }

        public Criteria andReturnAmountIn(List<Integer> values) {
            addCriterion("return_amount in", values, "returnAmount");
            return (Criteria) this;
        }

        public Criteria andReturnAmountNotIn(List<Integer> values) {
            addCriterion("return_amount not in", values, "returnAmount");
            return (Criteria) this;
        }

        public Criteria andReturnAmountBetween(Integer value1, Integer value2) {
            addCriterion("return_amount between", value1, value2, "returnAmount");
            return (Criteria) this;
        }

        public Criteria andReturnAmountNotBetween(Integer value1, Integer value2) {
            addCriterion("return_amount not between", value1, value2, "returnAmount");
            return (Criteria) this;
        }

        public Criteria andTranspoetAmountIsNull() {
            addCriterion("transpoet_amount is null");
            return (Criteria) this;
        }

        public Criteria andTranspoetAmountIsNotNull() {
            addCriterion("transpoet_amount is not null");
            return (Criteria) this;
        }

        public Criteria andTranspoetAmountEqualTo(Integer value) {
            addCriterion("transpoet_amount =", value, "transpoetAmount");
            return (Criteria) this;
        }

        public Criteria andTranspoetAmountNotEqualTo(Integer value) {
            addCriterion("transpoet_amount <>", value, "transpoetAmount");
            return (Criteria) this;
        }

        public Criteria andTranspoetAmountGreaterThan(Integer value) {
            addCriterion("transpoet_amount >", value, "transpoetAmount");
            return (Criteria) this;
        }

        public Criteria andTranspoetAmountGreaterThanOrEqualTo(Integer value) {
            addCriterion("transpoet_amount >=", value, "transpoetAmount");
            return (Criteria) this;
        }

        public Criteria andTranspoetAmountLessThan(Integer value) {
            addCriterion("transpoet_amount <", value, "transpoetAmount");
            return (Criteria) this;
        }

        public Criteria andTranspoetAmountLessThanOrEqualTo(Integer value) {
            addCriterion("transpoet_amount <=", value, "transpoetAmount");
            return (Criteria) this;
        }

        public Criteria andTranspoetAmountIn(List<Integer> values) {
            addCriterion("transpoet_amount in", values, "transpoetAmount");
            return (Criteria) this;
        }

        public Criteria andTranspoetAmountNotIn(List<Integer> values) {
            addCriterion("transpoet_amount not in", values, "transpoetAmount");
            return (Criteria) this;
        }

        public Criteria andTranspoetAmountBetween(Integer value1, Integer value2) {
            addCriterion("transpoet_amount between", value1, value2, "transpoetAmount");
            return (Criteria) this;
        }

        public Criteria andTranspoetAmountNotBetween(Integer value1, Integer value2) {
            addCriterion("transpoet_amount not between", value1, value2, "transpoetAmount");
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