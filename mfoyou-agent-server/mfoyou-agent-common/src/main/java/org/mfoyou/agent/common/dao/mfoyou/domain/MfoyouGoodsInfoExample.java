package org.mfoyou.agent.common.dao.mfoyou.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class MfoyouGoodsInfoExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    protected Integer limitStart;

    protected Integer limitEnd;

    public MfoyouGoodsInfoExample() {
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

        public Criteria andGoodsMainPicIsNull() {
            addCriterion("goods_main_pic is null");
            return (Criteria) this;
        }

        public Criteria andGoodsMainPicIsNotNull() {
            addCriterion("goods_main_pic is not null");
            return (Criteria) this;
        }

        public Criteria andGoodsMainPicEqualTo(String value) {
            addCriterion("goods_main_pic =", value, "goodsMainPic");
            return (Criteria) this;
        }

        public Criteria andGoodsMainPicNotEqualTo(String value) {
            addCriterion("goods_main_pic <>", value, "goodsMainPic");
            return (Criteria) this;
        }

        public Criteria andGoodsMainPicGreaterThan(String value) {
            addCriterion("goods_main_pic >", value, "goodsMainPic");
            return (Criteria) this;
        }

        public Criteria andGoodsMainPicGreaterThanOrEqualTo(String value) {
            addCriterion("goods_main_pic >=", value, "goodsMainPic");
            return (Criteria) this;
        }

        public Criteria andGoodsMainPicLessThan(String value) {
            addCriterion("goods_main_pic <", value, "goodsMainPic");
            return (Criteria) this;
        }

        public Criteria andGoodsMainPicLessThanOrEqualTo(String value) {
            addCriterion("goods_main_pic <=", value, "goodsMainPic");
            return (Criteria) this;
        }

        public Criteria andGoodsMainPicLike(String value) {
            addCriterion("goods_main_pic like", value, "goodsMainPic");
            return (Criteria) this;
        }

        public Criteria andGoodsMainPicNotLike(String value) {
            addCriterion("goods_main_pic not like", value, "goodsMainPic");
            return (Criteria) this;
        }

        public Criteria andGoodsMainPicIn(List<String> values) {
            addCriterion("goods_main_pic in", values, "goodsMainPic");
            return (Criteria) this;
        }

        public Criteria andGoodsMainPicNotIn(List<String> values) {
            addCriterion("goods_main_pic not in", values, "goodsMainPic");
            return (Criteria) this;
        }

        public Criteria andGoodsMainPicBetween(String value1, String value2) {
            addCriterion("goods_main_pic between", value1, value2, "goodsMainPic");
            return (Criteria) this;
        }

        public Criteria andGoodsMainPicNotBetween(String value1, String value2) {
            addCriterion("goods_main_pic not between", value1, value2, "goodsMainPic");
            return (Criteria) this;
        }

        public Criteria andGoodsShowPicIsNull() {
            addCriterion("goods_show_pic is null");
            return (Criteria) this;
        }

        public Criteria andGoodsShowPicIsNotNull() {
            addCriterion("goods_show_pic is not null");
            return (Criteria) this;
        }

        public Criteria andGoodsShowPicEqualTo(String value) {
            addCriterion("goods_show_pic =", value, "goodsShowPic");
            return (Criteria) this;
        }

        public Criteria andGoodsShowPicNotEqualTo(String value) {
            addCriterion("goods_show_pic <>", value, "goodsShowPic");
            return (Criteria) this;
        }

        public Criteria andGoodsShowPicGreaterThan(String value) {
            addCriterion("goods_show_pic >", value, "goodsShowPic");
            return (Criteria) this;
        }

        public Criteria andGoodsShowPicGreaterThanOrEqualTo(String value) {
            addCriterion("goods_show_pic >=", value, "goodsShowPic");
            return (Criteria) this;
        }

        public Criteria andGoodsShowPicLessThan(String value) {
            addCriterion("goods_show_pic <", value, "goodsShowPic");
            return (Criteria) this;
        }

        public Criteria andGoodsShowPicLessThanOrEqualTo(String value) {
            addCriterion("goods_show_pic <=", value, "goodsShowPic");
            return (Criteria) this;
        }

        public Criteria andGoodsShowPicLike(String value) {
            addCriterion("goods_show_pic like", value, "goodsShowPic");
            return (Criteria) this;
        }

        public Criteria andGoodsShowPicNotLike(String value) {
            addCriterion("goods_show_pic not like", value, "goodsShowPic");
            return (Criteria) this;
        }

        public Criteria andGoodsShowPicIn(List<String> values) {
            addCriterion("goods_show_pic in", values, "goodsShowPic");
            return (Criteria) this;
        }

        public Criteria andGoodsShowPicNotIn(List<String> values) {
            addCriterion("goods_show_pic not in", values, "goodsShowPic");
            return (Criteria) this;
        }

        public Criteria andGoodsShowPicBetween(String value1, String value2) {
            addCriterion("goods_show_pic between", value1, value2, "goodsShowPic");
            return (Criteria) this;
        }

        public Criteria andGoodsShowPicNotBetween(String value1, String value2) {
            addCriterion("goods_show_pic not between", value1, value2, "goodsShowPic");
            return (Criteria) this;
        }

        public Criteria andGoodsGctIsNull() {
            addCriterion("goods_gct is null");
            return (Criteria) this;
        }

        public Criteria andGoodsGctIsNotNull() {
            addCriterion("goods_gct is not null");
            return (Criteria) this;
        }

        public Criteria andGoodsGctEqualTo(Date value) {
            addCriterion("goods_gct =", value, "goodsGct");
            return (Criteria) this;
        }

        public Criteria andGoodsGctNotEqualTo(Date value) {
            addCriterion("goods_gct <>", value, "goodsGct");
            return (Criteria) this;
        }

        public Criteria andGoodsGctGreaterThan(Date value) {
            addCriterion("goods_gct >", value, "goodsGct");
            return (Criteria) this;
        }

        public Criteria andGoodsGctGreaterThanOrEqualTo(Date value) {
            addCriterion("goods_gct >=", value, "goodsGct");
            return (Criteria) this;
        }

        public Criteria andGoodsGctLessThan(Date value) {
            addCriterion("goods_gct <", value, "goodsGct");
            return (Criteria) this;
        }

        public Criteria andGoodsGctLessThanOrEqualTo(Date value) {
            addCriterion("goods_gct <=", value, "goodsGct");
            return (Criteria) this;
        }

        public Criteria andGoodsGctIn(List<Date> values) {
            addCriterion("goods_gct in", values, "goodsGct");
            return (Criteria) this;
        }

        public Criteria andGoodsGctNotIn(List<Date> values) {
            addCriterion("goods_gct not in", values, "goodsGct");
            return (Criteria) this;
        }

        public Criteria andGoodsGctBetween(Date value1, Date value2) {
            addCriterion("goods_gct between", value1, value2, "goodsGct");
            return (Criteria) this;
        }

        public Criteria andGoodsGctNotBetween(Date value1, Date value2) {
            addCriterion("goods_gct not between", value1, value2, "goodsGct");
            return (Criteria) this;
        }

        public Criteria andGoodsGmtIsNull() {
            addCriterion("goods_gmt is null");
            return (Criteria) this;
        }

        public Criteria andGoodsGmtIsNotNull() {
            addCriterion("goods_gmt is not null");
            return (Criteria) this;
        }

        public Criteria andGoodsGmtEqualTo(Date value) {
            addCriterion("goods_gmt =", value, "goodsGmt");
            return (Criteria) this;
        }

        public Criteria andGoodsGmtNotEqualTo(Date value) {
            addCriterion("goods_gmt <>", value, "goodsGmt");
            return (Criteria) this;
        }

        public Criteria andGoodsGmtGreaterThan(Date value) {
            addCriterion("goods_gmt >", value, "goodsGmt");
            return (Criteria) this;
        }

        public Criteria andGoodsGmtGreaterThanOrEqualTo(Date value) {
            addCriterion("goods_gmt >=", value, "goodsGmt");
            return (Criteria) this;
        }

        public Criteria andGoodsGmtLessThan(Date value) {
            addCriterion("goods_gmt <", value, "goodsGmt");
            return (Criteria) this;
        }

        public Criteria andGoodsGmtLessThanOrEqualTo(Date value) {
            addCriterion("goods_gmt <=", value, "goodsGmt");
            return (Criteria) this;
        }

        public Criteria andGoodsGmtIn(List<Date> values) {
            addCriterion("goods_gmt in", values, "goodsGmt");
            return (Criteria) this;
        }

        public Criteria andGoodsGmtNotIn(List<Date> values) {
            addCriterion("goods_gmt not in", values, "goodsGmt");
            return (Criteria) this;
        }

        public Criteria andGoodsGmtBetween(Date value1, Date value2) {
            addCriterion("goods_gmt between", value1, value2, "goodsGmt");
            return (Criteria) this;
        }

        public Criteria andGoodsGmtNotBetween(Date value1, Date value2) {
            addCriterion("goods_gmt not between", value1, value2, "goodsGmt");
            return (Criteria) this;
        }

        public Criteria andGoodsShelvesStateIsNull() {
            addCriterion("goods_shelves_state is null");
            return (Criteria) this;
        }

        public Criteria andGoodsShelvesStateIsNotNull() {
            addCriterion("goods_shelves_state is not null");
            return (Criteria) this;
        }

        public Criteria andGoodsShelvesStateEqualTo(Integer value) {
            addCriterion("goods_shelves_state =", value, "goodsShelvesState");
            return (Criteria) this;
        }

        public Criteria andGoodsShelvesStateNotEqualTo(Integer value) {
            addCriterion("goods_shelves_state <>", value, "goodsShelvesState");
            return (Criteria) this;
        }

        public Criteria andGoodsShelvesStateGreaterThan(Integer value) {
            addCriterion("goods_shelves_state >", value, "goodsShelvesState");
            return (Criteria) this;
        }

        public Criteria andGoodsShelvesStateGreaterThanOrEqualTo(Integer value) {
            addCriterion("goods_shelves_state >=", value, "goodsShelvesState");
            return (Criteria) this;
        }

        public Criteria andGoodsShelvesStateLessThan(Integer value) {
            addCriterion("goods_shelves_state <", value, "goodsShelvesState");
            return (Criteria) this;
        }

        public Criteria andGoodsShelvesStateLessThanOrEqualTo(Integer value) {
            addCriterion("goods_shelves_state <=", value, "goodsShelvesState");
            return (Criteria) this;
        }

        public Criteria andGoodsShelvesStateIn(List<Integer> values) {
            addCriterion("goods_shelves_state in", values, "goodsShelvesState");
            return (Criteria) this;
        }

        public Criteria andGoodsShelvesStateNotIn(List<Integer> values) {
            addCriterion("goods_shelves_state not in", values, "goodsShelvesState");
            return (Criteria) this;
        }

        public Criteria andGoodsShelvesStateBetween(Integer value1, Integer value2) {
            addCriterion("goods_shelves_state between", value1, value2, "goodsShelvesState");
            return (Criteria) this;
        }

        public Criteria andGoodsShelvesStateNotBetween(Integer value1, Integer value2) {
            addCriterion("goods_shelves_state not between", value1, value2, "goodsShelvesState");
            return (Criteria) this;
        }

        public Criteria andGoodsTitleIsNull() {
            addCriterion("goods_title is null");
            return (Criteria) this;
        }

        public Criteria andGoodsTitleIsNotNull() {
            addCriterion("goods_title is not null");
            return (Criteria) this;
        }

        public Criteria andGoodsTitleEqualTo(String value) {
            addCriterion("goods_title =", value, "goodsTitle");
            return (Criteria) this;
        }

        public Criteria andGoodsTitleNotEqualTo(String value) {
            addCriterion("goods_title <>", value, "goodsTitle");
            return (Criteria) this;
        }

        public Criteria andGoodsTitleGreaterThan(String value) {
            addCriterion("goods_title >", value, "goodsTitle");
            return (Criteria) this;
        }

        public Criteria andGoodsTitleGreaterThanOrEqualTo(String value) {
            addCriterion("goods_title >=", value, "goodsTitle");
            return (Criteria) this;
        }

        public Criteria andGoodsTitleLessThan(String value) {
            addCriterion("goods_title <", value, "goodsTitle");
            return (Criteria) this;
        }

        public Criteria andGoodsTitleLessThanOrEqualTo(String value) {
            addCriterion("goods_title <=", value, "goodsTitle");
            return (Criteria) this;
        }

        public Criteria andGoodsTitleLike(String value) {
            addCriterion("goods_title like", value, "goodsTitle");
            return (Criteria) this;
        }

        public Criteria andGoodsTitleNotLike(String value) {
            addCriterion("goods_title not like", value, "goodsTitle");
            return (Criteria) this;
        }

        public Criteria andGoodsTitleIn(List<String> values) {
            addCriterion("goods_title in", values, "goodsTitle");
            return (Criteria) this;
        }

        public Criteria andGoodsTitleNotIn(List<String> values) {
            addCriterion("goods_title not in", values, "goodsTitle");
            return (Criteria) this;
        }

        public Criteria andGoodsTitleBetween(String value1, String value2) {
            addCriterion("goods_title between", value1, value2, "goodsTitle");
            return (Criteria) this;
        }

        public Criteria andGoodsTitleNotBetween(String value1, String value2) {
            addCriterion("goods_title not between", value1, value2, "goodsTitle");
            return (Criteria) this;
        }

        public Criteria andGoodsTypeIsNull() {
            addCriterion("goods_type is null");
            return (Criteria) this;
        }

        public Criteria andGoodsTypeIsNotNull() {
            addCriterion("goods_type is not null");
            return (Criteria) this;
        }

        public Criteria andGoodsTypeEqualTo(Integer value) {
            addCriterion("goods_type =", value, "goodsType");
            return (Criteria) this;
        }

        public Criteria andGoodsTypeNotEqualTo(Integer value) {
            addCriterion("goods_type <>", value, "goodsType");
            return (Criteria) this;
        }

        public Criteria andGoodsTypeGreaterThan(Integer value) {
            addCriterion("goods_type >", value, "goodsType");
            return (Criteria) this;
        }

        public Criteria andGoodsTypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("goods_type >=", value, "goodsType");
            return (Criteria) this;
        }

        public Criteria andGoodsTypeLessThan(Integer value) {
            addCriterion("goods_type <", value, "goodsType");
            return (Criteria) this;
        }

        public Criteria andGoodsTypeLessThanOrEqualTo(Integer value) {
            addCriterion("goods_type <=", value, "goodsType");
            return (Criteria) this;
        }

        public Criteria andGoodsTypeIn(List<Integer> values) {
            addCriterion("goods_type in", values, "goodsType");
            return (Criteria) this;
        }

        public Criteria andGoodsTypeNotIn(List<Integer> values) {
            addCriterion("goods_type not in", values, "goodsType");
            return (Criteria) this;
        }

        public Criteria andGoodsTypeBetween(Integer value1, Integer value2) {
            addCriterion("goods_type between", value1, value2, "goodsType");
            return (Criteria) this;
        }

        public Criteria andGoodsTypeNotBetween(Integer value1, Integer value2) {
            addCriterion("goods_type not between", value1, value2, "goodsType");
            return (Criteria) this;
        }

        public Criteria andGoodsPromotionTypeIsNull() {
            addCriterion("goods_promotion_type is null");
            return (Criteria) this;
        }

        public Criteria andGoodsPromotionTypeIsNotNull() {
            addCriterion("goods_promotion_type is not null");
            return (Criteria) this;
        }

        public Criteria andGoodsPromotionTypeEqualTo(Integer value) {
            addCriterion("goods_promotion_type =", value, "goodsPromotionType");
            return (Criteria) this;
        }

        public Criteria andGoodsPromotionTypeNotEqualTo(Integer value) {
            addCriterion("goods_promotion_type <>", value, "goodsPromotionType");
            return (Criteria) this;
        }

        public Criteria andGoodsPromotionTypeGreaterThan(Integer value) {
            addCriterion("goods_promotion_type >", value, "goodsPromotionType");
            return (Criteria) this;
        }

        public Criteria andGoodsPromotionTypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("goods_promotion_type >=", value, "goodsPromotionType");
            return (Criteria) this;
        }

        public Criteria andGoodsPromotionTypeLessThan(Integer value) {
            addCriterion("goods_promotion_type <", value, "goodsPromotionType");
            return (Criteria) this;
        }

        public Criteria andGoodsPromotionTypeLessThanOrEqualTo(Integer value) {
            addCriterion("goods_promotion_type <=", value, "goodsPromotionType");
            return (Criteria) this;
        }

        public Criteria andGoodsPromotionTypeIn(List<Integer> values) {
            addCriterion("goods_promotion_type in", values, "goodsPromotionType");
            return (Criteria) this;
        }

        public Criteria andGoodsPromotionTypeNotIn(List<Integer> values) {
            addCriterion("goods_promotion_type not in", values, "goodsPromotionType");
            return (Criteria) this;
        }

        public Criteria andGoodsPromotionTypeBetween(Integer value1, Integer value2) {
            addCriterion("goods_promotion_type between", value1, value2, "goodsPromotionType");
            return (Criteria) this;
        }

        public Criteria andGoodsPromotionTypeNotBetween(Integer value1, Integer value2) {
            addCriterion("goods_promotion_type not between", value1, value2, "goodsPromotionType");
            return (Criteria) this;
        }

        public Criteria andGoodsSortTopIsNull() {
            addCriterion("goods_sort_top is null");
            return (Criteria) this;
        }

        public Criteria andGoodsSortTopIsNotNull() {
            addCriterion("goods_sort_top is not null");
            return (Criteria) this;
        }

        public Criteria andGoodsSortTopEqualTo(Integer value) {
            addCriterion("goods_sort_top =", value, "goodsSortTop");
            return (Criteria) this;
        }

        public Criteria andGoodsSortTopNotEqualTo(Integer value) {
            addCriterion("goods_sort_top <>", value, "goodsSortTop");
            return (Criteria) this;
        }

        public Criteria andGoodsSortTopGreaterThan(Integer value) {
            addCriterion("goods_sort_top >", value, "goodsSortTop");
            return (Criteria) this;
        }

        public Criteria andGoodsSortTopGreaterThanOrEqualTo(Integer value) {
            addCriterion("goods_sort_top >=", value, "goodsSortTop");
            return (Criteria) this;
        }

        public Criteria andGoodsSortTopLessThan(Integer value) {
            addCriterion("goods_sort_top <", value, "goodsSortTop");
            return (Criteria) this;
        }

        public Criteria andGoodsSortTopLessThanOrEqualTo(Integer value) {
            addCriterion("goods_sort_top <=", value, "goodsSortTop");
            return (Criteria) this;
        }

        public Criteria andGoodsSortTopIn(List<Integer> values) {
            addCriterion("goods_sort_top in", values, "goodsSortTop");
            return (Criteria) this;
        }

        public Criteria andGoodsSortTopNotIn(List<Integer> values) {
            addCriterion("goods_sort_top not in", values, "goodsSortTop");
            return (Criteria) this;
        }

        public Criteria andGoodsSortTopBetween(Integer value1, Integer value2) {
            addCriterion("goods_sort_top between", value1, value2, "goodsSortTop");
            return (Criteria) this;
        }

        public Criteria andGoodsSortTopNotBetween(Integer value1, Integer value2) {
            addCriterion("goods_sort_top not between", value1, value2, "goodsSortTop");
            return (Criteria) this;
        }

        public Criteria andGoodsSortLeveIsNull() {
            addCriterion("goods_sort_leve is null");
            return (Criteria) this;
        }

        public Criteria andGoodsSortLeveIsNotNull() {
            addCriterion("goods_sort_leve is not null");
            return (Criteria) this;
        }

        public Criteria andGoodsSortLeveEqualTo(Double value) {
            addCriterion("goods_sort_leve =", value, "goodsSortLeve");
            return (Criteria) this;
        }

        public Criteria andGoodsSortLeveNotEqualTo(Double value) {
            addCriterion("goods_sort_leve <>", value, "goodsSortLeve");
            return (Criteria) this;
        }

        public Criteria andGoodsSortLeveGreaterThan(Double value) {
            addCriterion("goods_sort_leve >", value, "goodsSortLeve");
            return (Criteria) this;
        }

        public Criteria andGoodsSortLeveGreaterThanOrEqualTo(Double value) {
            addCriterion("goods_sort_leve >=", value, "goodsSortLeve");
            return (Criteria) this;
        }

        public Criteria andGoodsSortLeveLessThan(Double value) {
            addCriterion("goods_sort_leve <", value, "goodsSortLeve");
            return (Criteria) this;
        }

        public Criteria andGoodsSortLeveLessThanOrEqualTo(Double value) {
            addCriterion("goods_sort_leve <=", value, "goodsSortLeve");
            return (Criteria) this;
        }

        public Criteria andGoodsSortLeveIn(List<Double> values) {
            addCriterion("goods_sort_leve in", values, "goodsSortLeve");
            return (Criteria) this;
        }

        public Criteria andGoodsSortLeveNotIn(List<Double> values) {
            addCriterion("goods_sort_leve not in", values, "goodsSortLeve");
            return (Criteria) this;
        }

        public Criteria andGoodsSortLeveBetween(Double value1, Double value2) {
            addCriterion("goods_sort_leve between", value1, value2, "goodsSortLeve");
            return (Criteria) this;
        }

        public Criteria andGoodsSortLeveNotBetween(Double value1, Double value2) {
            addCriterion("goods_sort_leve not between", value1, value2, "goodsSortLeve");
            return (Criteria) this;
        }

        public Criteria andGoodsPackageTypeIsNull() {
            addCriterion("goods_package_type is null");
            return (Criteria) this;
        }

        public Criteria andGoodsPackageTypeIsNotNull() {
            addCriterion("goods_package_type is not null");
            return (Criteria) this;
        }

        public Criteria andGoodsPackageTypeEqualTo(Integer value) {
            addCriterion("goods_package_type =", value, "goodsPackageType");
            return (Criteria) this;
        }

        public Criteria andGoodsPackageTypeNotEqualTo(Integer value) {
            addCriterion("goods_package_type <>", value, "goodsPackageType");
            return (Criteria) this;
        }

        public Criteria andGoodsPackageTypeGreaterThan(Integer value) {
            addCriterion("goods_package_type >", value, "goodsPackageType");
            return (Criteria) this;
        }

        public Criteria andGoodsPackageTypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("goods_package_type >=", value, "goodsPackageType");
            return (Criteria) this;
        }

        public Criteria andGoodsPackageTypeLessThan(Integer value) {
            addCriterion("goods_package_type <", value, "goodsPackageType");
            return (Criteria) this;
        }

        public Criteria andGoodsPackageTypeLessThanOrEqualTo(Integer value) {
            addCriterion("goods_package_type <=", value, "goodsPackageType");
            return (Criteria) this;
        }

        public Criteria andGoodsPackageTypeIn(List<Integer> values) {
            addCriterion("goods_package_type in", values, "goodsPackageType");
            return (Criteria) this;
        }

        public Criteria andGoodsPackageTypeNotIn(List<Integer> values) {
            addCriterion("goods_package_type not in", values, "goodsPackageType");
            return (Criteria) this;
        }

        public Criteria andGoodsPackageTypeBetween(Integer value1, Integer value2) {
            addCriterion("goods_package_type between", value1, value2, "goodsPackageType");
            return (Criteria) this;
        }

        public Criteria andGoodsPackageTypeNotBetween(Integer value1, Integer value2) {
            addCriterion("goods_package_type not between", value1, value2, "goodsPackageType");
            return (Criteria) this;
        }

        public Criteria andGoodsCostPriceIsNull() {
            addCriterion("goods_cost_price is null");
            return (Criteria) this;
        }

        public Criteria andGoodsCostPriceIsNotNull() {
            addCriterion("goods_cost_price is not null");
            return (Criteria) this;
        }

        public Criteria andGoodsCostPriceEqualTo(Integer value) {
            addCriterion("goods_cost_price =", value, "goodsCostPrice");
            return (Criteria) this;
        }

        public Criteria andGoodsCostPriceNotEqualTo(Integer value) {
            addCriterion("goods_cost_price <>", value, "goodsCostPrice");
            return (Criteria) this;
        }

        public Criteria andGoodsCostPriceGreaterThan(Integer value) {
            addCriterion("goods_cost_price >", value, "goodsCostPrice");
            return (Criteria) this;
        }

        public Criteria andGoodsCostPriceGreaterThanOrEqualTo(Integer value) {
            addCriterion("goods_cost_price >=", value, "goodsCostPrice");
            return (Criteria) this;
        }

        public Criteria andGoodsCostPriceLessThan(Integer value) {
            addCriterion("goods_cost_price <", value, "goodsCostPrice");
            return (Criteria) this;
        }

        public Criteria andGoodsCostPriceLessThanOrEqualTo(Integer value) {
            addCriterion("goods_cost_price <=", value, "goodsCostPrice");
            return (Criteria) this;
        }

        public Criteria andGoodsCostPriceIn(List<Integer> values) {
            addCriterion("goods_cost_price in", values, "goodsCostPrice");
            return (Criteria) this;
        }

        public Criteria andGoodsCostPriceNotIn(List<Integer> values) {
            addCriterion("goods_cost_price not in", values, "goodsCostPrice");
            return (Criteria) this;
        }

        public Criteria andGoodsCostPriceBetween(Integer value1, Integer value2) {
            addCriterion("goods_cost_price between", value1, value2, "goodsCostPrice");
            return (Criteria) this;
        }

        public Criteria andGoodsCostPriceNotBetween(Integer value1, Integer value2) {
            addCriterion("goods_cost_price not between", value1, value2, "goodsCostPrice");
            return (Criteria) this;
        }

        public Criteria andGoodsDiscountPriceIsNull() {
            addCriterion("goods_discount_price is null");
            return (Criteria) this;
        }

        public Criteria andGoodsDiscountPriceIsNotNull() {
            addCriterion("goods_discount_price is not null");
            return (Criteria) this;
        }

        public Criteria andGoodsDiscountPriceEqualTo(Integer value) {
            addCriterion("goods_discount_price =", value, "goodsDiscountPrice");
            return (Criteria) this;
        }

        public Criteria andGoodsDiscountPriceNotEqualTo(Integer value) {
            addCriterion("goods_discount_price <>", value, "goodsDiscountPrice");
            return (Criteria) this;
        }

        public Criteria andGoodsDiscountPriceGreaterThan(Integer value) {
            addCriterion("goods_discount_price >", value, "goodsDiscountPrice");
            return (Criteria) this;
        }

        public Criteria andGoodsDiscountPriceGreaterThanOrEqualTo(Integer value) {
            addCriterion("goods_discount_price >=", value, "goodsDiscountPrice");
            return (Criteria) this;
        }

        public Criteria andGoodsDiscountPriceLessThan(Integer value) {
            addCriterion("goods_discount_price <", value, "goodsDiscountPrice");
            return (Criteria) this;
        }

        public Criteria andGoodsDiscountPriceLessThanOrEqualTo(Integer value) {
            addCriterion("goods_discount_price <=", value, "goodsDiscountPrice");
            return (Criteria) this;
        }

        public Criteria andGoodsDiscountPriceIn(List<Integer> values) {
            addCriterion("goods_discount_price in", values, "goodsDiscountPrice");
            return (Criteria) this;
        }

        public Criteria andGoodsDiscountPriceNotIn(List<Integer> values) {
            addCriterion("goods_discount_price not in", values, "goodsDiscountPrice");
            return (Criteria) this;
        }

        public Criteria andGoodsDiscountPriceBetween(Integer value1, Integer value2) {
            addCriterion("goods_discount_price between", value1, value2, "goodsDiscountPrice");
            return (Criteria) this;
        }

        public Criteria andGoodsDiscountPriceNotBetween(Integer value1, Integer value2) {
            addCriterion("goods_discount_price not between", value1, value2, "goodsDiscountPrice");
            return (Criteria) this;
        }

        public Criteria andGoodsNumberIsNull() {
            addCriterion("goods_number is null");
            return (Criteria) this;
        }

        public Criteria andGoodsNumberIsNotNull() {
            addCriterion("goods_number is not null");
            return (Criteria) this;
        }

        public Criteria andGoodsNumberEqualTo(Integer value) {
            addCriterion("goods_number =", value, "goodsNumber");
            return (Criteria) this;
        }

        public Criteria andGoodsNumberNotEqualTo(Integer value) {
            addCriterion("goods_number <>", value, "goodsNumber");
            return (Criteria) this;
        }

        public Criteria andGoodsNumberGreaterThan(Integer value) {
            addCriterion("goods_number >", value, "goodsNumber");
            return (Criteria) this;
        }

        public Criteria andGoodsNumberGreaterThanOrEqualTo(Integer value) {
            addCriterion("goods_number >=", value, "goodsNumber");
            return (Criteria) this;
        }

        public Criteria andGoodsNumberLessThan(Integer value) {
            addCriterion("goods_number <", value, "goodsNumber");
            return (Criteria) this;
        }

        public Criteria andGoodsNumberLessThanOrEqualTo(Integer value) {
            addCriterion("goods_number <=", value, "goodsNumber");
            return (Criteria) this;
        }

        public Criteria andGoodsNumberIn(List<Integer> values) {
            addCriterion("goods_number in", values, "goodsNumber");
            return (Criteria) this;
        }

        public Criteria andGoodsNumberNotIn(List<Integer> values) {
            addCriterion("goods_number not in", values, "goodsNumber");
            return (Criteria) this;
        }

        public Criteria andGoodsNumberBetween(Integer value1, Integer value2) {
            addCriterion("goods_number between", value1, value2, "goodsNumber");
            return (Criteria) this;
        }

        public Criteria andGoodsNumberNotBetween(Integer value1, Integer value2) {
            addCriterion("goods_number not between", value1, value2, "goodsNumber");
            return (Criteria) this;
        }

        public Criteria andGoodsTotalScoreIsNull() {
            addCriterion("goods_total_score is null");
            return (Criteria) this;
        }

        public Criteria andGoodsTotalScoreIsNotNull() {
            addCriterion("goods_total_score is not null");
            return (Criteria) this;
        }

        public Criteria andGoodsTotalScoreEqualTo(Integer value) {
            addCriterion("goods_total_score =", value, "goodsTotalScore");
            return (Criteria) this;
        }

        public Criteria andGoodsTotalScoreNotEqualTo(Integer value) {
            addCriterion("goods_total_score <>", value, "goodsTotalScore");
            return (Criteria) this;
        }

        public Criteria andGoodsTotalScoreGreaterThan(Integer value) {
            addCriterion("goods_total_score >", value, "goodsTotalScore");
            return (Criteria) this;
        }

        public Criteria andGoodsTotalScoreGreaterThanOrEqualTo(Integer value) {
            addCriterion("goods_total_score >=", value, "goodsTotalScore");
            return (Criteria) this;
        }

        public Criteria andGoodsTotalScoreLessThan(Integer value) {
            addCriterion("goods_total_score <", value, "goodsTotalScore");
            return (Criteria) this;
        }

        public Criteria andGoodsTotalScoreLessThanOrEqualTo(Integer value) {
            addCriterion("goods_total_score <=", value, "goodsTotalScore");
            return (Criteria) this;
        }

        public Criteria andGoodsTotalScoreIn(List<Integer> values) {
            addCriterion("goods_total_score in", values, "goodsTotalScore");
            return (Criteria) this;
        }

        public Criteria andGoodsTotalScoreNotIn(List<Integer> values) {
            addCriterion("goods_total_score not in", values, "goodsTotalScore");
            return (Criteria) this;
        }

        public Criteria andGoodsTotalScoreBetween(Integer value1, Integer value2) {
            addCriterion("goods_total_score between", value1, value2, "goodsTotalScore");
            return (Criteria) this;
        }

        public Criteria andGoodsTotalScoreNotBetween(Integer value1, Integer value2) {
            addCriterion("goods_total_score not between", value1, value2, "goodsTotalScore");
            return (Criteria) this;
        }

        public Criteria andGoodsTotalCommentIsNull() {
            addCriterion("goods_total_comment is null");
            return (Criteria) this;
        }

        public Criteria andGoodsTotalCommentIsNotNull() {
            addCriterion("goods_total_comment is not null");
            return (Criteria) this;
        }

        public Criteria andGoodsTotalCommentEqualTo(Integer value) {
            addCriterion("goods_total_comment =", value, "goodsTotalComment");
            return (Criteria) this;
        }

        public Criteria andGoodsTotalCommentNotEqualTo(Integer value) {
            addCriterion("goods_total_comment <>", value, "goodsTotalComment");
            return (Criteria) this;
        }

        public Criteria andGoodsTotalCommentGreaterThan(Integer value) {
            addCriterion("goods_total_comment >", value, "goodsTotalComment");
            return (Criteria) this;
        }

        public Criteria andGoodsTotalCommentGreaterThanOrEqualTo(Integer value) {
            addCriterion("goods_total_comment >=", value, "goodsTotalComment");
            return (Criteria) this;
        }

        public Criteria andGoodsTotalCommentLessThan(Integer value) {
            addCriterion("goods_total_comment <", value, "goodsTotalComment");
            return (Criteria) this;
        }

        public Criteria andGoodsTotalCommentLessThanOrEqualTo(Integer value) {
            addCriterion("goods_total_comment <=", value, "goodsTotalComment");
            return (Criteria) this;
        }

        public Criteria andGoodsTotalCommentIn(List<Integer> values) {
            addCriterion("goods_total_comment in", values, "goodsTotalComment");
            return (Criteria) this;
        }

        public Criteria andGoodsTotalCommentNotIn(List<Integer> values) {
            addCriterion("goods_total_comment not in", values, "goodsTotalComment");
            return (Criteria) this;
        }

        public Criteria andGoodsTotalCommentBetween(Integer value1, Integer value2) {
            addCriterion("goods_total_comment between", value1, value2, "goodsTotalComment");
            return (Criteria) this;
        }

        public Criteria andGoodsTotalCommentNotBetween(Integer value1, Integer value2) {
            addCriterion("goods_total_comment not between", value1, value2, "goodsTotalComment");
            return (Criteria) this;
        }

        public Criteria andGoodsTotalSaleIsNull() {
            addCriterion("goods_total_sale is null");
            return (Criteria) this;
        }

        public Criteria andGoodsTotalSaleIsNotNull() {
            addCriterion("goods_total_sale is not null");
            return (Criteria) this;
        }

        public Criteria andGoodsTotalSaleEqualTo(Integer value) {
            addCriterion("goods_total_sale =", value, "goodsTotalSale");
            return (Criteria) this;
        }

        public Criteria andGoodsTotalSaleNotEqualTo(Integer value) {
            addCriterion("goods_total_sale <>", value, "goodsTotalSale");
            return (Criteria) this;
        }

        public Criteria andGoodsTotalSaleGreaterThan(Integer value) {
            addCriterion("goods_total_sale >", value, "goodsTotalSale");
            return (Criteria) this;
        }

        public Criteria andGoodsTotalSaleGreaterThanOrEqualTo(Integer value) {
            addCriterion("goods_total_sale >=", value, "goodsTotalSale");
            return (Criteria) this;
        }
        public Criteria hasSoldAll() {
            addCriterion("goods_total_sale >= goods_number && goods_number !=-1 ");
            return (Criteria) this;
        }
        public Criteria andGoodsTotalSaleLessThan(Integer value) {
            addCriterion("goods_total_sale <", value, "goodsTotalSale");
            return (Criteria) this;
        }

        public Criteria andGoodsTotalSaleLessThanOrEqualTo(Integer value) {
            addCriterion("goods_total_sale <=", value, "goodsTotalSale");
            return (Criteria) this;
        }

        public Criteria andGoodsTotalSaleIn(List<Integer> values) {
            addCriterion("goods_total_sale in", values, "goodsTotalSale");
            return (Criteria) this;
        }

        public Criteria andGoodsTotalSaleNotIn(List<Integer> values) {
            addCriterion("goods_total_sale not in", values, "goodsTotalSale");
            return (Criteria) this;
        }

        public Criteria andGoodsTotalSaleBetween(Integer value1, Integer value2) {
            addCriterion("goods_total_sale between", value1, value2, "goodsTotalSale");
            return (Criteria) this;
        }

        public Criteria andGoodsTotalSaleNotBetween(Integer value1, Integer value2) {
            addCriterion("goods_total_sale not between", value1, value2, "goodsTotalSale");
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