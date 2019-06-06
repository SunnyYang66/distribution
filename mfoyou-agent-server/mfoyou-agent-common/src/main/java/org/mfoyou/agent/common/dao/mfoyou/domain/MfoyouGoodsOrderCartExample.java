package org.mfoyou.agent.common.dao.mfoyou.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class MfoyouGoodsOrderCartExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    protected Integer limitStart;

    protected Integer limitEnd;

    public MfoyouGoodsOrderCartExample() {
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

        public Criteria andCartItmeIdIsNull() {
            addCriterion("cart_itme_id is null");
            return (Criteria) this;
        }

        public Criteria andCartItmeIdIsNotNull() {
            addCriterion("cart_itme_id is not null");
            return (Criteria) this;
        }

        public Criteria andCartItmeIdEqualTo(Integer value) {
            addCriterion("cart_itme_id =", value, "cartItmeId");
            return (Criteria) this;
        }

        public Criteria andCartItmeIdNotEqualTo(Integer value) {
            addCriterion("cart_itme_id <>", value, "cartItmeId");
            return (Criteria) this;
        }

        public Criteria andCartItmeIdGreaterThan(Integer value) {
            addCriterion("cart_itme_id >", value, "cartItmeId");
            return (Criteria) this;
        }

        public Criteria andCartItmeIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("cart_itme_id >=", value, "cartItmeId");
            return (Criteria) this;
        }

        public Criteria andCartItmeIdLessThan(Integer value) {
            addCriterion("cart_itme_id <", value, "cartItmeId");
            return (Criteria) this;
        }

        public Criteria andCartItmeIdLessThanOrEqualTo(Integer value) {
            addCriterion("cart_itme_id <=", value, "cartItmeId");
            return (Criteria) this;
        }

        public Criteria andCartItmeIdIn(List<Integer> values) {
            addCriterion("cart_itme_id in", values, "cartItmeId");
            return (Criteria) this;
        }

        public Criteria andCartItmeIdNotIn(List<Integer> values) {
            addCriterion("cart_itme_id not in", values, "cartItmeId");
            return (Criteria) this;
        }

        public Criteria andCartItmeIdBetween(Integer value1, Integer value2) {
            addCriterion("cart_itme_id between", value1, value2, "cartItmeId");
            return (Criteria) this;
        }

        public Criteria andCartItmeIdNotBetween(Integer value1, Integer value2) {
            addCriterion("cart_itme_id not between", value1, value2, "cartItmeId");
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

        public Criteria andItemUserNonteIsNull() {
            addCriterion("item_user_nonte is null");
            return (Criteria) this;
        }

        public Criteria andItemUserNonteIsNotNull() {
            addCriterion("item_user_nonte is not null");
            return (Criteria) this;
        }

        public Criteria andItemUserNonteEqualTo(String value) {
            addCriterion("item_user_nonte =", value, "itemUserNonte");
            return (Criteria) this;
        }

        public Criteria andItemUserNonteNotEqualTo(String value) {
            addCriterion("item_user_nonte <>", value, "itemUserNonte");
            return (Criteria) this;
        }

        public Criteria andItemUserNonteGreaterThan(String value) {
            addCriterion("item_user_nonte >", value, "itemUserNonte");
            return (Criteria) this;
        }

        public Criteria andItemUserNonteGreaterThanOrEqualTo(String value) {
            addCriterion("item_user_nonte >=", value, "itemUserNonte");
            return (Criteria) this;
        }

        public Criteria andItemUserNonteLessThan(String value) {
            addCriterion("item_user_nonte <", value, "itemUserNonte");
            return (Criteria) this;
        }

        public Criteria andItemUserNonteLessThanOrEqualTo(String value) {
            addCriterion("item_user_nonte <=", value, "itemUserNonte");
            return (Criteria) this;
        }

        public Criteria andItemUserNonteLike(String value) {
            addCriterion("item_user_nonte like", value, "itemUserNonte");
            return (Criteria) this;
        }

        public Criteria andItemUserNonteNotLike(String value) {
            addCriterion("item_user_nonte not like", value, "itemUserNonte");
            return (Criteria) this;
        }

        public Criteria andItemUserNonteIn(List<String> values) {
            addCriterion("item_user_nonte in", values, "itemUserNonte");
            return (Criteria) this;
        }

        public Criteria andItemUserNonteNotIn(List<String> values) {
            addCriterion("item_user_nonte not in", values, "itemUserNonte");
            return (Criteria) this;
        }

        public Criteria andItemUserNonteBetween(String value1, String value2) {
            addCriterion("item_user_nonte between", value1, value2, "itemUserNonte");
            return (Criteria) this;
        }

        public Criteria andItemUserNonteNotBetween(String value1, String value2) {
            addCriterion("item_user_nonte not between", value1, value2, "itemUserNonte");
            return (Criteria) this;
        }

        public Criteria andItemSelectIsNull() {
            addCriterion("item_select is null");
            return (Criteria) this;
        }

        public Criteria andItemSelectIsNotNull() {
            addCriterion("item_select is not null");
            return (Criteria) this;
        }

        public Criteria andItemSelectEqualTo(Integer value) {
            addCriterion("item_select =", value, "itemSelect");
            return (Criteria) this;
        }

        public Criteria andItemSelectNotEqualTo(Integer value) {
            addCriterion("item_select <>", value, "itemSelect");
            return (Criteria) this;
        }

        public Criteria andItemSelectGreaterThan(Integer value) {
            addCriterion("item_select >", value, "itemSelect");
            return (Criteria) this;
        }

        public Criteria andItemSelectGreaterThanOrEqualTo(Integer value) {
            addCriterion("item_select >=", value, "itemSelect");
            return (Criteria) this;
        }

        public Criteria andItemSelectLessThan(Integer value) {
            addCriterion("item_select <", value, "itemSelect");
            return (Criteria) this;
        }

        public Criteria andItemSelectLessThanOrEqualTo(Integer value) {
            addCriterion("item_select <=", value, "itemSelect");
            return (Criteria) this;
        }

        public Criteria andItemSelectIn(List<Integer> values) {
            addCriterion("item_select in", values, "itemSelect");
            return (Criteria) this;
        }

        public Criteria andItemSelectNotIn(List<Integer> values) {
            addCriterion("item_select not in", values, "itemSelect");
            return (Criteria) this;
        }

        public Criteria andItemSelectBetween(Integer value1, Integer value2) {
            addCriterion("item_select between", value1, value2, "itemSelect");
            return (Criteria) this;
        }

        public Criteria andItemSelectNotBetween(Integer value1, Integer value2) {
            addCriterion("item_select not between", value1, value2, "itemSelect");
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