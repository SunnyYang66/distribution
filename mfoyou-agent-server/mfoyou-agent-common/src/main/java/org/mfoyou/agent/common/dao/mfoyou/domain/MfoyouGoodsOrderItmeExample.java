package org.mfoyou.agent.common.dao.mfoyou.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class MfoyouGoodsOrderItmeExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    protected Integer limitStart;

    protected Integer limitEnd;

    public MfoyouGoodsOrderItmeExample() {
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

        public Criteria andOrderItmeIdIsNull() {
            addCriterion("order_itme_id is null");
            return (Criteria) this;
        }

        public Criteria andOrderItmeIdIsNotNull() {
            addCriterion("order_itme_id is not null");
            return (Criteria) this;
        }

        public Criteria andOrderItmeIdEqualTo(Integer value) {
            addCriterion("order_itme_id =", value, "orderItmeId");
            return (Criteria) this;
        }

        public Criteria andOrderItmeIdNotEqualTo(Integer value) {
            addCriterion("order_itme_id <>", value, "orderItmeId");
            return (Criteria) this;
        }

        public Criteria andOrderItmeIdGreaterThan(Integer value) {
            addCriterion("order_itme_id >", value, "orderItmeId");
            return (Criteria) this;
        }

        public Criteria andOrderItmeIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("order_itme_id >=", value, "orderItmeId");
            return (Criteria) this;
        }

        public Criteria andOrderItmeIdLessThan(Integer value) {
            addCriterion("order_itme_id <", value, "orderItmeId");
            return (Criteria) this;
        }

        public Criteria andOrderItmeIdLessThanOrEqualTo(Integer value) {
            addCriterion("order_itme_id <=", value, "orderItmeId");
            return (Criteria) this;
        }

        public Criteria andOrderItmeIdIn(List<Integer> values) {
            addCriterion("order_itme_id in", values, "orderItmeId");
            return (Criteria) this;
        }

        public Criteria andOrderItmeIdNotIn(List<Integer> values) {
            addCriterion("order_itme_id not in", values, "orderItmeId");
            return (Criteria) this;
        }

        public Criteria andOrderItmeIdBetween(Integer value1, Integer value2) {
            addCriterion("order_itme_id between", value1, value2, "orderItmeId");
            return (Criteria) this;
        }

        public Criteria andOrderItmeIdNotBetween(Integer value1, Integer value2) {
            addCriterion("order_itme_id not between", value1, value2, "orderItmeId");
            return (Criteria) this;
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

        public Criteria andGoodsIdIsNull() {
            addCriterion("goods_id is null");
            return (Criteria) this;
        }

        public Criteria andGoodsIdIsNotNull() {
            addCriterion("goods_id is not null");
            return (Criteria) this;
        }

        public Criteria andGoodsIdEqualTo(Integer value) {
            addCriterion("goods_id =", value, "goodsId");
            return (Criteria) this;
        }

        public Criteria andGoodsIdNotEqualTo(Integer value) {
            addCriterion("goods_id <>", value, "goodsId");
            return (Criteria) this;
        }

        public Criteria andGoodsIdGreaterThan(Integer value) {
            addCriterion("goods_id >", value, "goodsId");
            return (Criteria) this;
        }

        public Criteria andGoodsIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("goods_id >=", value, "goodsId");
            return (Criteria) this;
        }

        public Criteria andGoodsIdLessThan(Integer value) {
            addCriterion("goods_id <", value, "goodsId");
            return (Criteria) this;
        }

        public Criteria andGoodsIdLessThanOrEqualTo(Integer value) {
            addCriterion("goods_id <=", value, "goodsId");
            return (Criteria) this;
        }

        public Criteria andGoodsIdIn(List<Integer> values) {
            addCriterion("goods_id in", values, "goodsId");
            return (Criteria) this;
        }

        public Criteria andGoodsIdNotIn(List<Integer> values) {
            addCriterion("goods_id not in", values, "goodsId");
            return (Criteria) this;
        }

        public Criteria andGoodsIdBetween(Integer value1, Integer value2) {
            addCriterion("goods_id between", value1, value2, "goodsId");
            return (Criteria) this;
        }

        public Criteria andGoodsIdNotBetween(Integer value1, Integer value2) {
            addCriterion("goods_id not between", value1, value2, "goodsId");
            return (Criteria) this;
        }

        public Criteria andGoodsNameIsNull() {
            addCriterion("goods_name is null");
            return (Criteria) this;
        }

        public Criteria andGoodsNameIsNotNull() {
            addCriterion("goods_name is not null");
            return (Criteria) this;
        }

        public Criteria andGoodsNameEqualTo(String value) {
            addCriterion("goods_name =", value, "goodsName");
            return (Criteria) this;
        }

        public Criteria andGoodsNameNotEqualTo(String value) {
            addCriterion("goods_name <>", value, "goodsName");
            return (Criteria) this;
        }

        public Criteria andGoodsNameGreaterThan(String value) {
            addCriterion("goods_name >", value, "goodsName");
            return (Criteria) this;
        }

        public Criteria andGoodsNameGreaterThanOrEqualTo(String value) {
            addCriterion("goods_name >=", value, "goodsName");
            return (Criteria) this;
        }

        public Criteria andGoodsNameLessThan(String value) {
            addCriterion("goods_name <", value, "goodsName");
            return (Criteria) this;
        }

        public Criteria andGoodsNameLessThanOrEqualTo(String value) {
            addCriterion("goods_name <=", value, "goodsName");
            return (Criteria) this;
        }

        public Criteria andGoodsNameLike(String value) {
            addCriterion("goods_name like", value, "goodsName");
            return (Criteria) this;
        }

        public Criteria andGoodsNameNotLike(String value) {
            addCriterion("goods_name not like", value, "goodsName");
            return (Criteria) this;
        }

        public Criteria andGoodsNameIn(List<String> values) {
            addCriterion("goods_name in", values, "goodsName");
            return (Criteria) this;
        }

        public Criteria andGoodsNameNotIn(List<String> values) {
            addCriterion("goods_name not in", values, "goodsName");
            return (Criteria) this;
        }

        public Criteria andGoodsNameBetween(String value1, String value2) {
            addCriterion("goods_name between", value1, value2, "goodsName");
            return (Criteria) this;
        }

        public Criteria andGoodsNameNotBetween(String value1, String value2) {
            addCriterion("goods_name not between", value1, value2, "goodsName");
            return (Criteria) this;
        }

        public Criteria andGoodsPicIsNull() {
            addCriterion("goods_pic is null");
            return (Criteria) this;
        }

        public Criteria andGoodsPicIsNotNull() {
            addCriterion("goods_pic is not null");
            return (Criteria) this;
        }

        public Criteria andGoodsPicEqualTo(String value) {
            addCriterion("goods_pic =", value, "goodsPic");
            return (Criteria) this;
        }

        public Criteria andGoodsPicNotEqualTo(String value) {
            addCriterion("goods_pic <>", value, "goodsPic");
            return (Criteria) this;
        }

        public Criteria andGoodsPicGreaterThan(String value) {
            addCriterion("goods_pic >", value, "goodsPic");
            return (Criteria) this;
        }

        public Criteria andGoodsPicGreaterThanOrEqualTo(String value) {
            addCriterion("goods_pic >=", value, "goodsPic");
            return (Criteria) this;
        }

        public Criteria andGoodsPicLessThan(String value) {
            addCriterion("goods_pic <", value, "goodsPic");
            return (Criteria) this;
        }

        public Criteria andGoodsPicLessThanOrEqualTo(String value) {
            addCriterion("goods_pic <=", value, "goodsPic");
            return (Criteria) this;
        }

        public Criteria andGoodsPicLike(String value) {
            addCriterion("goods_pic like", value, "goodsPic");
            return (Criteria) this;
        }

        public Criteria andGoodsPicNotLike(String value) {
            addCriterion("goods_pic not like", value, "goodsPic");
            return (Criteria) this;
        }

        public Criteria andGoodsPicIn(List<String> values) {
            addCriterion("goods_pic in", values, "goodsPic");
            return (Criteria) this;
        }

        public Criteria andGoodsPicNotIn(List<String> values) {
            addCriterion("goods_pic not in", values, "goodsPic");
            return (Criteria) this;
        }

        public Criteria andGoodsPicBetween(String value1, String value2) {
            addCriterion("goods_pic between", value1, value2, "goodsPic");
            return (Criteria) this;
        }

        public Criteria andGoodsPicNotBetween(String value1, String value2) {
            addCriterion("goods_pic not between", value1, value2, "goodsPic");
            return (Criteria) this;
        }

        public Criteria andPackageIdIsNull() {
            addCriterion("package_id is null");
            return (Criteria) this;
        }

        public Criteria andPackageIdIsNotNull() {
            addCriterion("package_id is not null");
            return (Criteria) this;
        }

        public Criteria andPackageIdEqualTo(Integer value) {
            addCriterion("package_id =", value, "packageId");
            return (Criteria) this;
        }

        public Criteria andPackageIdNotEqualTo(Integer value) {
            addCriterion("package_id <>", value, "packageId");
            return (Criteria) this;
        }

        public Criteria andPackageIdGreaterThan(Integer value) {
            addCriterion("package_id >", value, "packageId");
            return (Criteria) this;
        }

        public Criteria andPackageIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("package_id >=", value, "packageId");
            return (Criteria) this;
        }

        public Criteria andPackageIdLessThan(Integer value) {
            addCriterion("package_id <", value, "packageId");
            return (Criteria) this;
        }

        public Criteria andPackageIdLessThanOrEqualTo(Integer value) {
            addCriterion("package_id <=", value, "packageId");
            return (Criteria) this;
        }

        public Criteria andPackageIdIn(List<Integer> values) {
            addCriterion("package_id in", values, "packageId");
            return (Criteria) this;
        }

        public Criteria andPackageIdNotIn(List<Integer> values) {
            addCriterion("package_id not in", values, "packageId");
            return (Criteria) this;
        }

        public Criteria andPackageIdBetween(Integer value1, Integer value2) {
            addCriterion("package_id between", value1, value2, "packageId");
            return (Criteria) this;
        }

        public Criteria andPackageIdNotBetween(Integer value1, Integer value2) {
            addCriterion("package_id not between", value1, value2, "packageId");
            return (Criteria) this;
        }

        public Criteria andPackageNameIsNull() {
            addCriterion("package_name is null");
            return (Criteria) this;
        }

        public Criteria andPackageNameIsNotNull() {
            addCriterion("package_name is not null");
            return (Criteria) this;
        }

        public Criteria andPackageNameEqualTo(String value) {
            addCriterion("package_name =", value, "packageName");
            return (Criteria) this;
        }

        public Criteria andPackageNameNotEqualTo(String value) {
            addCriterion("package_name <>", value, "packageName");
            return (Criteria) this;
        }

        public Criteria andPackageNameGreaterThan(String value) {
            addCriterion("package_name >", value, "packageName");
            return (Criteria) this;
        }

        public Criteria andPackageNameGreaterThanOrEqualTo(String value) {
            addCriterion("package_name >=", value, "packageName");
            return (Criteria) this;
        }

        public Criteria andPackageNameLessThan(String value) {
            addCriterion("package_name <", value, "packageName");
            return (Criteria) this;
        }

        public Criteria andPackageNameLessThanOrEqualTo(String value) {
            addCriterion("package_name <=", value, "packageName");
            return (Criteria) this;
        }

        public Criteria andPackageNameLike(String value) {
            addCriterion("package_name like", value, "packageName");
            return (Criteria) this;
        }

        public Criteria andPackageNameNotLike(String value) {
            addCriterion("package_name not like", value, "packageName");
            return (Criteria) this;
        }

        public Criteria andPackageNameIn(List<String> values) {
            addCriterion("package_name in", values, "packageName");
            return (Criteria) this;
        }

        public Criteria andPackageNameNotIn(List<String> values) {
            addCriterion("package_name not in", values, "packageName");
            return (Criteria) this;
        }

        public Criteria andPackageNameBetween(String value1, String value2) {
            addCriterion("package_name between", value1, value2, "packageName");
            return (Criteria) this;
        }

        public Criteria andPackageNameNotBetween(String value1, String value2) {
            addCriterion("package_name not between", value1, value2, "packageName");
            return (Criteria) this;
        }

        public Criteria andItemNumberIsNull() {
            addCriterion("item_number is null");
            return (Criteria) this;
        }

        public Criteria andItemNumberIsNotNull() {
            addCriterion("item_number is not null");
            return (Criteria) this;
        }

        public Criteria andItemNumberEqualTo(Integer value) {
            addCriterion("item_number =", value, "itemNumber");
            return (Criteria) this;
        }

        public Criteria andItemNumberNotEqualTo(Integer value) {
            addCriterion("item_number <>", value, "itemNumber");
            return (Criteria) this;
        }

        public Criteria andItemNumberGreaterThan(Integer value) {
            addCriterion("item_number >", value, "itemNumber");
            return (Criteria) this;
        }

        public Criteria andItemNumberGreaterThanOrEqualTo(Integer value) {
            addCriterion("item_number >=", value, "itemNumber");
            return (Criteria) this;
        }

        public Criteria andItemNumberLessThan(Integer value) {
            addCriterion("item_number <", value, "itemNumber");
            return (Criteria) this;
        }

        public Criteria andItemNumberLessThanOrEqualTo(Integer value) {
            addCriterion("item_number <=", value, "itemNumber");
            return (Criteria) this;
        }

        public Criteria andItemNumberIn(List<Integer> values) {
            addCriterion("item_number in", values, "itemNumber");
            return (Criteria) this;
        }

        public Criteria andItemNumberNotIn(List<Integer> values) {
            addCriterion("item_number not in", values, "itemNumber");
            return (Criteria) this;
        }

        public Criteria andItemNumberBetween(Integer value1, Integer value2) {
            addCriterion("item_number between", value1, value2, "itemNumber");
            return (Criteria) this;
        }

        public Criteria andItemNumberNotBetween(Integer value1, Integer value2) {
            addCriterion("item_number not between", value1, value2, "itemNumber");
            return (Criteria) this;
        }

        public Criteria andGoodsOriginalPriceIsNull() {
            addCriterion("goods_original_price is null");
            return (Criteria) this;
        }

        public Criteria andGoodsOriginalPriceIsNotNull() {
            addCriterion("goods_original_price is not null");
            return (Criteria) this;
        }

        public Criteria andGoodsOriginalPriceEqualTo(Integer value) {
            addCriterion("goods_original_price =", value, "goodsOriginalPrice");
            return (Criteria) this;
        }

        public Criteria andGoodsOriginalPriceNotEqualTo(Integer value) {
            addCriterion("goods_original_price <>", value, "goodsOriginalPrice");
            return (Criteria) this;
        }

        public Criteria andGoodsOriginalPriceGreaterThan(Integer value) {
            addCriterion("goods_original_price >", value, "goodsOriginalPrice");
            return (Criteria) this;
        }

        public Criteria andGoodsOriginalPriceGreaterThanOrEqualTo(Integer value) {
            addCriterion("goods_original_price >=", value, "goodsOriginalPrice");
            return (Criteria) this;
        }

        public Criteria andGoodsOriginalPriceLessThan(Integer value) {
            addCriterion("goods_original_price <", value, "goodsOriginalPrice");
            return (Criteria) this;
        }

        public Criteria andGoodsOriginalPriceLessThanOrEqualTo(Integer value) {
            addCriterion("goods_original_price <=", value, "goodsOriginalPrice");
            return (Criteria) this;
        }

        public Criteria andGoodsOriginalPriceIn(List<Integer> values) {
            addCriterion("goods_original_price in", values, "goodsOriginalPrice");
            return (Criteria) this;
        }

        public Criteria andGoodsOriginalPriceNotIn(List<Integer> values) {
            addCriterion("goods_original_price not in", values, "goodsOriginalPrice");
            return (Criteria) this;
        }

        public Criteria andGoodsOriginalPriceBetween(Integer value1, Integer value2) {
            addCriterion("goods_original_price between", value1, value2, "goodsOriginalPrice");
            return (Criteria) this;
        }

        public Criteria andGoodsOriginalPriceNotBetween(Integer value1, Integer value2) {
            addCriterion("goods_original_price not between", value1, value2, "goodsOriginalPrice");
            return (Criteria) this;
        }

        public Criteria andGoodsDealPriceIsNull() {
            addCriterion("goods_deal_price is null");
            return (Criteria) this;
        }

        public Criteria andGoodsDealPriceIsNotNull() {
            addCriterion("goods_deal_price is not null");
            return (Criteria) this;
        }

        public Criteria andGoodsDealPriceEqualTo(Integer value) {
            addCriterion("goods_deal_price =", value, "goodsDealPrice");
            return (Criteria) this;
        }

        public Criteria andGoodsDealPriceNotEqualTo(Integer value) {
            addCriterion("goods_deal_price <>", value, "goodsDealPrice");
            return (Criteria) this;
        }

        public Criteria andGoodsDealPriceGreaterThan(Integer value) {
            addCriterion("goods_deal_price >", value, "goodsDealPrice");
            return (Criteria) this;
        }

        public Criteria andGoodsDealPriceGreaterThanOrEqualTo(Integer value) {
            addCriterion("goods_deal_price >=", value, "goodsDealPrice");
            return (Criteria) this;
        }

        public Criteria andGoodsDealPriceLessThan(Integer value) {
            addCriterion("goods_deal_price <", value, "goodsDealPrice");
            return (Criteria) this;
        }

        public Criteria andGoodsDealPriceLessThanOrEqualTo(Integer value) {
            addCriterion("goods_deal_price <=", value, "goodsDealPrice");
            return (Criteria) this;
        }

        public Criteria andGoodsDealPriceIn(List<Integer> values) {
            addCriterion("goods_deal_price in", values, "goodsDealPrice");
            return (Criteria) this;
        }

        public Criteria andGoodsDealPriceNotIn(List<Integer> values) {
            addCriterion("goods_deal_price not in", values, "goodsDealPrice");
            return (Criteria) this;
        }

        public Criteria andGoodsDealPriceBetween(Integer value1, Integer value2) {
            addCriterion("goods_deal_price between", value1, value2, "goodsDealPrice");
            return (Criteria) this;
        }

        public Criteria andGoodsDealPriceNotBetween(Integer value1, Integer value2) {
            addCriterion("goods_deal_price not between", value1, value2, "goodsDealPrice");
            return (Criteria) this;
        }

        public Criteria andItemTotalAmountIsNull() {
            addCriterion("item_total_amount is null");
            return (Criteria) this;
        }

        public Criteria andItemTotalAmountIsNotNull() {
            addCriterion("item_total_amount is not null");
            return (Criteria) this;
        }

        public Criteria andItemTotalAmountEqualTo(Integer value) {
            addCriterion("item_total_amount =", value, "itemTotalAmount");
            return (Criteria) this;
        }

        public Criteria andItemTotalAmountNotEqualTo(Integer value) {
            addCriterion("item_total_amount <>", value, "itemTotalAmount");
            return (Criteria) this;
        }

        public Criteria andItemTotalAmountGreaterThan(Integer value) {
            addCriterion("item_total_amount >", value, "itemTotalAmount");
            return (Criteria) this;
        }

        public Criteria andItemTotalAmountGreaterThanOrEqualTo(Integer value) {
            addCriterion("item_total_amount >=", value, "itemTotalAmount");
            return (Criteria) this;
        }

        public Criteria andItemTotalAmountLessThan(Integer value) {
            addCriterion("item_total_amount <", value, "itemTotalAmount");
            return (Criteria) this;
        }

        public Criteria andItemTotalAmountLessThanOrEqualTo(Integer value) {
            addCriterion("item_total_amount <=", value, "itemTotalAmount");
            return (Criteria) this;
        }

        public Criteria andItemTotalAmountIn(List<Integer> values) {
            addCriterion("item_total_amount in", values, "itemTotalAmount");
            return (Criteria) this;
        }

        public Criteria andItemTotalAmountNotIn(List<Integer> values) {
            addCriterion("item_total_amount not in", values, "itemTotalAmount");
            return (Criteria) this;
        }

        public Criteria andItemTotalAmountBetween(Integer value1, Integer value2) {
            addCriterion("item_total_amount between", value1, value2, "itemTotalAmount");
            return (Criteria) this;
        }

        public Criteria andItemTotalAmountNotBetween(Integer value1, Integer value2) {
            addCriterion("item_total_amount not between", value1, value2, "itemTotalAmount");
            return (Criteria) this;
        }

        public Criteria andItemUserNoteIsNull() {
            addCriterion("item_user_note is null");
            return (Criteria) this;
        }

        public Criteria andItemUserNoteIsNotNull() {
            addCriterion("item_user_note is not null");
            return (Criteria) this;
        }

        public Criteria andItemUserNoteEqualTo(String value) {
            addCriterion("item_user_note =", value, "itemUserNote");
            return (Criteria) this;
        }

        public Criteria andItemUserNoteNotEqualTo(String value) {
            addCriterion("item_user_note <>", value, "itemUserNote");
            return (Criteria) this;
        }

        public Criteria andItemUserNoteGreaterThan(String value) {
            addCriterion("item_user_note >", value, "itemUserNote");
            return (Criteria) this;
        }

        public Criteria andItemUserNoteGreaterThanOrEqualTo(String value) {
            addCriterion("item_user_note >=", value, "itemUserNote");
            return (Criteria) this;
        }

        public Criteria andItemUserNoteLessThan(String value) {
            addCriterion("item_user_note <", value, "itemUserNote");
            return (Criteria) this;
        }

        public Criteria andItemUserNoteLessThanOrEqualTo(String value) {
            addCriterion("item_user_note <=", value, "itemUserNote");
            return (Criteria) this;
        }

        public Criteria andItemUserNoteLike(String value) {
            addCriterion("item_user_note like", value, "itemUserNote");
            return (Criteria) this;
        }

        public Criteria andItemUserNoteNotLike(String value) {
            addCriterion("item_user_note not like", value, "itemUserNote");
            return (Criteria) this;
        }

        public Criteria andItemUserNoteIn(List<String> values) {
            addCriterion("item_user_note in", values, "itemUserNote");
            return (Criteria) this;
        }

        public Criteria andItemUserNoteNotIn(List<String> values) {
            addCriterion("item_user_note not in", values, "itemUserNote");
            return (Criteria) this;
        }

        public Criteria andItemUserNoteBetween(String value1, String value2) {
            addCriterion("item_user_note between", value1, value2, "itemUserNote");
            return (Criteria) this;
        }

        public Criteria andItemUserNoteNotBetween(String value1, String value2) {
            addCriterion("item_user_note not between", value1, value2, "itemUserNote");
            return (Criteria) this;
        }

        public Criteria andItemGctIsNull() {
            addCriterion("item_gct is null");
            return (Criteria) this;
        }

        public Criteria andItemGctIsNotNull() {
            addCriterion("item_gct is not null");
            return (Criteria) this;
        }

        public Criteria andItemGctEqualTo(Date value) {
            addCriterion("item_gct =", value, "itemGct");
            return (Criteria) this;
        }

        public Criteria andItemGctNotEqualTo(Date value) {
            addCriterion("item_gct <>", value, "itemGct");
            return (Criteria) this;
        }

        public Criteria andItemGctGreaterThan(Date value) {
            addCriterion("item_gct >", value, "itemGct");
            return (Criteria) this;
        }

        public Criteria andItemGctGreaterThanOrEqualTo(Date value) {
            addCriterion("item_gct >=", value, "itemGct");
            return (Criteria) this;
        }

        public Criteria andItemGctLessThan(Date value) {
            addCriterion("item_gct <", value, "itemGct");
            return (Criteria) this;
        }

        public Criteria andItemGctLessThanOrEqualTo(Date value) {
            addCriterion("item_gct <=", value, "itemGct");
            return (Criteria) this;
        }

        public Criteria andItemGctIn(List<Date> values) {
            addCriterion("item_gct in", values, "itemGct");
            return (Criteria) this;
        }

        public Criteria andItemGctNotIn(List<Date> values) {
            addCriterion("item_gct not in", values, "itemGct");
            return (Criteria) this;
        }

        public Criteria andItemGctBetween(Date value1, Date value2) {
            addCriterion("item_gct between", value1, value2, "itemGct");
            return (Criteria) this;
        }

        public Criteria andItemGctNotBetween(Date value1, Date value2) {
            addCriterion("item_gct not between", value1, value2, "itemGct");
            return (Criteria) this;
        }

        public Criteria andItemGmtIsNull() {
            addCriterion("item_gmt is null");
            return (Criteria) this;
        }

        public Criteria andItemGmtIsNotNull() {
            addCriterion("item_gmt is not null");
            return (Criteria) this;
        }

        public Criteria andItemGmtEqualTo(Date value) {
            addCriterion("item_gmt =", value, "itemGmt");
            return (Criteria) this;
        }

        public Criteria andItemGmtNotEqualTo(Date value) {
            addCriterion("item_gmt <>", value, "itemGmt");
            return (Criteria) this;
        }

        public Criteria andItemGmtGreaterThan(Date value) {
            addCriterion("item_gmt >", value, "itemGmt");
            return (Criteria) this;
        }

        public Criteria andItemGmtGreaterThanOrEqualTo(Date value) {
            addCriterion("item_gmt >=", value, "itemGmt");
            return (Criteria) this;
        }

        public Criteria andItemGmtLessThan(Date value) {
            addCriterion("item_gmt <", value, "itemGmt");
            return (Criteria) this;
        }

        public Criteria andItemGmtLessThanOrEqualTo(Date value) {
            addCriterion("item_gmt <=", value, "itemGmt");
            return (Criteria) this;
        }

        public Criteria andItemGmtIn(List<Date> values) {
            addCriterion("item_gmt in", values, "itemGmt");
            return (Criteria) this;
        }

        public Criteria andItemGmtNotIn(List<Date> values) {
            addCriterion("item_gmt not in", values, "itemGmt");
            return (Criteria) this;
        }

        public Criteria andItemGmtBetween(Date value1, Date value2) {
            addCriterion("item_gmt between", value1, value2, "itemGmt");
            return (Criteria) this;
        }

        public Criteria andItemGmtNotBetween(Date value1, Date value2) {
            addCriterion("item_gmt not between", value1, value2, "itemGmt");
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