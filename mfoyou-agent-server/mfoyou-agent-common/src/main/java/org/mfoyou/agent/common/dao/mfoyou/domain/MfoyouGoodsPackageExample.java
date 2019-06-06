package org.mfoyou.agent.common.dao.mfoyou.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class MfoyouGoodsPackageExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    protected Integer limitStart;

    protected Integer limitEnd;

    public MfoyouGoodsPackageExample() {
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

        public Criteria andPackageCostPriceIsNull() {
            addCriterion("package_cost_price is null");
            return (Criteria) this;
        }

        public Criteria andPackageCostPriceIsNotNull() {
            addCriterion("package_cost_price is not null");
            return (Criteria) this;
        }

        public Criteria andPackageCostPriceEqualTo(Integer value) {
            addCriterion("package_cost_price =", value, "packageCostPrice");
            return (Criteria) this;
        }

        public Criteria andPackageCostPriceNotEqualTo(Integer value) {
            addCriterion("package_cost_price <>", value, "packageCostPrice");
            return (Criteria) this;
        }

        public Criteria andPackageCostPriceGreaterThan(Integer value) {
            addCriterion("package_cost_price >", value, "packageCostPrice");
            return (Criteria) this;
        }

        public Criteria andPackageCostPriceGreaterThanOrEqualTo(Integer value) {
            addCriterion("package_cost_price >=", value, "packageCostPrice");
            return (Criteria) this;
        }

        public Criteria andPackageCostPriceLessThan(Integer value) {
            addCriterion("package_cost_price <", value, "packageCostPrice");
            return (Criteria) this;
        }

        public Criteria andPackageCostPriceLessThanOrEqualTo(Integer value) {
            addCriterion("package_cost_price <=", value, "packageCostPrice");
            return (Criteria) this;
        }

        public Criteria andPackageCostPriceIn(List<Integer> values) {
            addCriterion("package_cost_price in", values, "packageCostPrice");
            return (Criteria) this;
        }

        public Criteria andPackageCostPriceNotIn(List<Integer> values) {
            addCriterion("package_cost_price not in", values, "packageCostPrice");
            return (Criteria) this;
        }

        public Criteria andPackageCostPriceBetween(Integer value1, Integer value2) {
            addCriterion("package_cost_price between", value1, value2, "packageCostPrice");
            return (Criteria) this;
        }

        public Criteria andPackageCostPriceNotBetween(Integer value1, Integer value2) {
            addCriterion("package_cost_price not between", value1, value2, "packageCostPrice");
            return (Criteria) this;
        }

        public Criteria andPackageDiscountPriceIsNull() {
            addCriterion("package_discount_price is null");
            return (Criteria) this;
        }

        public Criteria andPackageDiscountPriceIsNotNull() {
            addCriterion("package_discount_price is not null");
            return (Criteria) this;
        }

        public Criteria andPackageDiscountPriceEqualTo(Integer value) {
            addCriterion("package_discount_price =", value, "packageDiscountPrice");
            return (Criteria) this;
        }

        public Criteria andPackageDiscountPriceNotEqualTo(Integer value) {
            addCriterion("package_discount_price <>", value, "packageDiscountPrice");
            return (Criteria) this;
        }

        public Criteria andPackageDiscountPriceGreaterThan(Integer value) {
            addCriterion("package_discount_price >", value, "packageDiscountPrice");
            return (Criteria) this;
        }

        public Criteria andPackageDiscountPriceGreaterThanOrEqualTo(Integer value) {
            addCriterion("package_discount_price >=", value, "packageDiscountPrice");
            return (Criteria) this;
        }

        public Criteria andPackageDiscountPriceLessThan(Integer value) {
            addCriterion("package_discount_price <", value, "packageDiscountPrice");
            return (Criteria) this;
        }

        public Criteria andPackageDiscountPriceLessThanOrEqualTo(Integer value) {
            addCriterion("package_discount_price <=", value, "packageDiscountPrice");
            return (Criteria) this;
        }

        public Criteria andPackageDiscountPriceIn(List<Integer> values) {
            addCriterion("package_discount_price in", values, "packageDiscountPrice");
            return (Criteria) this;
        }

        public Criteria andPackageDiscountPriceNotIn(List<Integer> values) {
            addCriterion("package_discount_price not in", values, "packageDiscountPrice");
            return (Criteria) this;
        }

        public Criteria andPackageDiscountPriceBetween(Integer value1, Integer value2) {
            addCriterion("package_discount_price between", value1, value2, "packageDiscountPrice");
            return (Criteria) this;
        }

        public Criteria andPackageDiscountPriceNotBetween(Integer value1, Integer value2) {
            addCriterion("package_discount_price not between", value1, value2, "packageDiscountPrice");
            return (Criteria) this;
        }

        public Criteria andPackageNumberIsNull() {
            addCriterion("package_number is null");
            return (Criteria) this;
        }

        public Criteria andPackageNumberIsNotNull() {
            addCriterion("package_number is not null");
            return (Criteria) this;
        }

        public Criteria andPackageNumberEqualTo(Integer value) {
            addCriterion("package_number =", value, "packageNumber");
            return (Criteria) this;
        }

        public Criteria andPackageNumberNotEqualTo(Integer value) {
            addCriterion("package_number <>", value, "packageNumber");
            return (Criteria) this;
        }

        public Criteria andPackageNumberGreaterThan(Integer value) {
            addCriterion("package_number >", value, "packageNumber");
            return (Criteria) this;
        }

        public Criteria andPackageNumberGreaterThanOrEqualTo(Integer value) {
            addCriterion("package_number >=", value, "packageNumber");
            return (Criteria) this;
        }

        public Criteria andPackageNumberLessThan(Integer value) {
            addCriterion("package_number <", value, "packageNumber");
            return (Criteria) this;
        }

        public Criteria andPackageNumberLessThanOrEqualTo(Integer value) {
            addCriterion("package_number <=", value, "packageNumber");
            return (Criteria) this;
        }

        public Criteria andPackageNumberIn(List<Integer> values) {
            addCriterion("package_number in", values, "packageNumber");
            return (Criteria) this;
        }

        public Criteria andPackageNumberNotIn(List<Integer> values) {
            addCriterion("package_number not in", values, "packageNumber");
            return (Criteria) this;
        }

        public Criteria andPackageNumberBetween(Integer value1, Integer value2) {
            addCriterion("package_number between", value1, value2, "packageNumber");
            return (Criteria) this;
        }

        public Criteria andPackageNumberNotBetween(Integer value1, Integer value2) {
            addCriterion("package_number not between", value1, value2, "packageNumber");
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

        public Criteria andPackageContentIsNull() {
            addCriterion("package_content is null");
            return (Criteria) this;
        }

        public Criteria andPackageContentIsNotNull() {
            addCriterion("package_content is not null");
            return (Criteria) this;
        }

        public Criteria andPackageContentEqualTo(String value) {
            addCriterion("package_content =", value, "packageContent");
            return (Criteria) this;
        }

        public Criteria andPackageContentNotEqualTo(String value) {
            addCriterion("package_content <>", value, "packageContent");
            return (Criteria) this;
        }

        public Criteria andPackageContentGreaterThan(String value) {
            addCriterion("package_content >", value, "packageContent");
            return (Criteria) this;
        }

        public Criteria andPackageContentGreaterThanOrEqualTo(String value) {
            addCriterion("package_content >=", value, "packageContent");
            return (Criteria) this;
        }

        public Criteria andPackageContentLessThan(String value) {
            addCriterion("package_content <", value, "packageContent");
            return (Criteria) this;
        }

        public Criteria andPackageContentLessThanOrEqualTo(String value) {
            addCriterion("package_content <=", value, "packageContent");
            return (Criteria) this;
        }

        public Criteria andPackageContentLike(String value) {
            addCriterion("package_content like", value, "packageContent");
            return (Criteria) this;
        }

        public Criteria andPackageContentNotLike(String value) {
            addCriterion("package_content not like", value, "packageContent");
            return (Criteria) this;
        }

        public Criteria andPackageContentIn(List<String> values) {
            addCriterion("package_content in", values, "packageContent");
            return (Criteria) this;
        }

        public Criteria andPackageContentNotIn(List<String> values) {
            addCriterion("package_content not in", values, "packageContent");
            return (Criteria) this;
        }

        public Criteria andPackageContentBetween(String value1, String value2) {
            addCriterion("package_content between", value1, value2, "packageContent");
            return (Criteria) this;
        }

        public Criteria andPackageContentNotBetween(String value1, String value2) {
            addCriterion("package_content not between", value1, value2, "packageContent");
            return (Criteria) this;
        }

        public Criteria andPackageGctIsNull() {
            addCriterion("package_gct is null");
            return (Criteria) this;
        }

        public Criteria andPackageGctIsNotNull() {
            addCriterion("package_gct is not null");
            return (Criteria) this;
        }

        public Criteria andPackageGctEqualTo(Date value) {
            addCriterion("package_gct =", value, "packageGct");
            return (Criteria) this;
        }

        public Criteria andPackageGctNotEqualTo(Date value) {
            addCriterion("package_gct <>", value, "packageGct");
            return (Criteria) this;
        }

        public Criteria andPackageGctGreaterThan(Date value) {
            addCriterion("package_gct >", value, "packageGct");
            return (Criteria) this;
        }

        public Criteria andPackageGctGreaterThanOrEqualTo(Date value) {
            addCriterion("package_gct >=", value, "packageGct");
            return (Criteria) this;
        }

        public Criteria andPackageGctLessThan(Date value) {
            addCriterion("package_gct <", value, "packageGct");
            return (Criteria) this;
        }

        public Criteria andPackageGctLessThanOrEqualTo(Date value) {
            addCriterion("package_gct <=", value, "packageGct");
            return (Criteria) this;
        }

        public Criteria andPackageGctIn(List<Date> values) {
            addCriterion("package_gct in", values, "packageGct");
            return (Criteria) this;
        }

        public Criteria andPackageGctNotIn(List<Date> values) {
            addCriterion("package_gct not in", values, "packageGct");
            return (Criteria) this;
        }

        public Criteria andPackageGctBetween(Date value1, Date value2) {
            addCriterion("package_gct between", value1, value2, "packageGct");
            return (Criteria) this;
        }

        public Criteria andPackageGctNotBetween(Date value1, Date value2) {
            addCriterion("package_gct not between", value1, value2, "packageGct");
            return (Criteria) this;
        }

        public Criteria andPackageGmtIsNull() {
            addCriterion("package_gmt is null");
            return (Criteria) this;
        }

        public Criteria andPackageGmtIsNotNull() {
            addCriterion("package_gmt is not null");
            return (Criteria) this;
        }

        public Criteria andPackageGmtEqualTo(Date value) {
            addCriterion("package_gmt =", value, "packageGmt");
            return (Criteria) this;
        }

        public Criteria andPackageGmtNotEqualTo(Date value) {
            addCriterion("package_gmt <>", value, "packageGmt");
            return (Criteria) this;
        }

        public Criteria andPackageGmtGreaterThan(Date value) {
            addCriterion("package_gmt >", value, "packageGmt");
            return (Criteria) this;
        }

        public Criteria andPackageGmtGreaterThanOrEqualTo(Date value) {
            addCriterion("package_gmt >=", value, "packageGmt");
            return (Criteria) this;
        }

        public Criteria andPackageGmtLessThan(Date value) {
            addCriterion("package_gmt <", value, "packageGmt");
            return (Criteria) this;
        }

        public Criteria andPackageGmtLessThanOrEqualTo(Date value) {
            addCriterion("package_gmt <=", value, "packageGmt");
            return (Criteria) this;
        }

        public Criteria andPackageGmtIn(List<Date> values) {
            addCriterion("package_gmt in", values, "packageGmt");
            return (Criteria) this;
        }

        public Criteria andPackageGmtNotIn(List<Date> values) {
            addCriterion("package_gmt not in", values, "packageGmt");
            return (Criteria) this;
        }

        public Criteria andPackageGmtBetween(Date value1, Date value2) {
            addCriterion("package_gmt between", value1, value2, "packageGmt");
            return (Criteria) this;
        }

        public Criteria andPackageGmtNotBetween(Date value1, Date value2) {
            addCriterion("package_gmt not between", value1, value2, "packageGmt");
            return (Criteria) this;
        }

        public Criteria andPackageSortLeveIsNull() {
            addCriterion("package_sort_leve is null");
            return (Criteria) this;
        }

        public Criteria andPackageSortLeveIsNotNull() {
            addCriterion("package_sort_leve is not null");
            return (Criteria) this;
        }

        public Criteria andPackageSortLeveEqualTo(Double value) {
            addCriterion("package_sort_leve =", value, "packageSortLeve");
            return (Criteria) this;
        }

        public Criteria andPackageSortLeveNotEqualTo(Double value) {
            addCriterion("package_sort_leve <>", value, "packageSortLeve");
            return (Criteria) this;
        }

        public Criteria andPackageSortLeveGreaterThan(Double value) {
            addCriterion("package_sort_leve >", value, "packageSortLeve");
            return (Criteria) this;
        }

        public Criteria andPackageSortLeveGreaterThanOrEqualTo(Double value) {
            addCriterion("package_sort_leve >=", value, "packageSortLeve");
            return (Criteria) this;
        }

        public Criteria andPackageSortLeveLessThan(Double value) {
            addCriterion("package_sort_leve <", value, "packageSortLeve");
            return (Criteria) this;
        }

        public Criteria andPackageSortLeveLessThanOrEqualTo(Double value) {
            addCriterion("package_sort_leve <=", value, "packageSortLeve");
            return (Criteria) this;
        }

        public Criteria andPackageSortLeveIn(List<Double> values) {
            addCriterion("package_sort_leve in", values, "packageSortLeve");
            return (Criteria) this;
        }

        public Criteria andPackageSortLeveNotIn(List<Double> values) {
            addCriterion("package_sort_leve not in", values, "packageSortLeve");
            return (Criteria) this;
        }

        public Criteria andPackageSortLeveBetween(Double value1, Double value2) {
            addCriterion("package_sort_leve between", value1, value2, "packageSortLeve");
            return (Criteria) this;
        }

        public Criteria andPackageSortLeveNotBetween(Double value1, Double value2) {
            addCriterion("package_sort_leve not between", value1, value2, "packageSortLeve");
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