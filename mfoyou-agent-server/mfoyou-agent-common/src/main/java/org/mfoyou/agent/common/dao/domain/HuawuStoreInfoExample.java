package org.mfoyou.agent.common.dao.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class HuawuStoreInfoExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    protected Integer limitStart;

    protected Integer limitEnd;

    public HuawuStoreInfoExample() {
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

        public Criteria andStoreTypeIsNull() {
            addCriterion("store_type is null");
            return (Criteria) this;
        }

        public Criteria andStoreTypeIsNotNull() {
            addCriterion("store_type is not null");
            return (Criteria) this;
        }

        public Criteria andStoreTypeEqualTo(Integer value) {
            addCriterion("store_type =", value, "storeType");
            return (Criteria) this;
        }

        public Criteria andStoreTypeNotEqualTo(Integer value) {
            addCriterion("store_type <>", value, "storeType");
            return (Criteria) this;
        }

        public Criteria andStoreTypeGreaterThan(Integer value) {
            addCriterion("store_type >", value, "storeType");
            return (Criteria) this;
        }

        public Criteria andStoreTypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("store_type >=", value, "storeType");
            return (Criteria) this;
        }

        public Criteria andStoreTypeLessThan(Integer value) {
            addCriterion("store_type <", value, "storeType");
            return (Criteria) this;
        }

        public Criteria andStoreTypeLessThanOrEqualTo(Integer value) {
            addCriterion("store_type <=", value, "storeType");
            return (Criteria) this;
        }

        public Criteria andStoreTypeIn(List<Integer> values) {
            addCriterion("store_type in", values, "storeType");
            return (Criteria) this;
        }
        public Criteria andStoreTypeNameIn(List<String> values) {
            addCriterion("store_type_name in", values, "storeType");
            return (Criteria) this;
        }
        public Criteria andStoreTypeNotIn(List<Integer> values) {
            addCriterion("store_type not in", values, "storeType");
            return (Criteria) this;
        }

        public Criteria andStoreTypeBetween(Integer value1, Integer value2) {
            addCriterion("store_type between", value1, value2, "storeType");
            return (Criteria) this;
        }

        public Criteria andStoreTypeNotBetween(Integer value1, Integer value2) {
            addCriterion("store_type not between", value1, value2, "storeType");
            return (Criteria) this;
        }

        public Criteria andStoreSubjectTypeIsNull() {
            addCriterion("store_subject_type is null");
            return (Criteria) this;
        }

        public Criteria andStoreSubjectTypeIsNotNull() {
            addCriterion("store_subject_type is not null");
            return (Criteria) this;
        }

        public Criteria andStoreSubjectTypeEqualTo(Integer value) {
            addCriterion("store_subject_type =", value, "storeSubjectType");
            return (Criteria) this;
        }

        public Criteria andStoreSubjectTypeNotEqualTo(Integer value) {
            addCriterion("store_subject_type <>", value, "storeSubjectType");
            return (Criteria) this;
        }

        public Criteria andStoreSubjectTypeGreaterThan(Integer value) {
            addCriterion("store_subject_type >", value, "storeSubjectType");
            return (Criteria) this;
        }

        public Criteria andStoreSubjectTypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("store_subject_type >=", value, "storeSubjectType");
            return (Criteria) this;
        }

        public Criteria andStoreSubjectTypeLessThan(Integer value) {
            addCriterion("store_subject_type <", value, "storeSubjectType");
            return (Criteria) this;
        }

        public Criteria andStoreSubjectTypeLessThanOrEqualTo(Integer value) {
            addCriterion("store_subject_type <=", value, "storeSubjectType");
            return (Criteria) this;
        }

        public Criteria andStoreSubjectTypeIn(List<Integer> values) {
            addCriterion("store_subject_type in", values, "storeSubjectType");
            return (Criteria) this;
        }

        public Criteria andStoreSubjectTypeNotIn(List<Integer> values) {
            addCriterion("store_subject_type not in", values, "storeSubjectType");
            return (Criteria) this;
        }

        public Criteria andStoreSubjectTypeBetween(Integer value1, Integer value2) {
            addCriterion("store_subject_type between", value1, value2, "storeSubjectType");
            return (Criteria) this;
        }

        public Criteria andStoreSubjectTypeNotBetween(Integer value1, Integer value2) {
            addCriterion("store_subject_type not between", value1, value2, "storeSubjectType");
            return (Criteria) this;
        }

        public Criteria andStorePersonalAuthIsNull() {
            addCriterion("store_personal_auth is null");
            return (Criteria) this;
        }

        public Criteria andStorePersonalAuthIsNotNull() {
            addCriterion("store_personal_auth is not null");
            return (Criteria) this;
        }

        public Criteria andStorePersonalAuthEqualTo(Integer value) {
            addCriterion("store_personal_auth =", value, "storePersonalAuth");
            return (Criteria) this;
        }

        public Criteria andStorePersonalAuthNotEqualTo(Integer value) {
            addCriterion("store_personal_auth <>", value, "storePersonalAuth");
            return (Criteria) this;
        }

        public Criteria andStorePersonalAuthGreaterThan(Integer value) {
            addCriterion("store_personal_auth >", value, "storePersonalAuth");
            return (Criteria) this;
        }

        public Criteria andStorePersonalAuthGreaterThanOrEqualTo(Integer value) {
            addCriterion("store_personal_auth >=", value, "storePersonalAuth");
            return (Criteria) this;
        }

        public Criteria andStorePersonalAuthLessThan(Integer value) {
            addCriterion("store_personal_auth <", value, "storePersonalAuth");
            return (Criteria) this;
        }

        public Criteria andStorePersonalAuthLessThanOrEqualTo(Integer value) {
            addCriterion("store_personal_auth <=", value, "storePersonalAuth");
            return (Criteria) this;
        }

        public Criteria andStorePersonalAuthIn(List<Integer> values) {
            addCriterion("store_personal_auth in", values, "storePersonalAuth");
            return (Criteria) this;
        }

        public Criteria andStorePersonalAuthNotIn(List<Integer> values) {
            addCriterion("store_personal_auth not in", values, "storePersonalAuth");
            return (Criteria) this;
        }

        public Criteria andStorePersonalAuthBetween(Integer value1, Integer value2) {
            addCriterion("store_personal_auth between", value1, value2, "storePersonalAuth");
            return (Criteria) this;
        }

        public Criteria andStorePersonalAuthNotBetween(Integer value1, Integer value2) {
            addCriterion("store_personal_auth not between", value1, value2, "storePersonalAuth");
            return (Criteria) this;
        }

        public Criteria andStoreEnterpriseAuthIsNull() {
            addCriterion("store_enterprise_auth is null");
            return (Criteria) this;
        }

        public Criteria andStoreEnterpriseAuthIsNotNull() {
            addCriterion("store_enterprise_auth is not null");
            return (Criteria) this;
        }

        public Criteria andStoreEnterpriseAuthEqualTo(Integer value) {
            addCriterion("store_enterprise_auth =", value, "storeEnterpriseAuth");
            return (Criteria) this;
        }

        public Criteria andStoreEnterpriseAuthNotEqualTo(Integer value) {
            addCriterion("store_enterprise_auth <>", value, "storeEnterpriseAuth");
            return (Criteria) this;
        }

        public Criteria andStoreEnterpriseAuthGreaterThan(Integer value) {
            addCriterion("store_enterprise_auth >", value, "storeEnterpriseAuth");
            return (Criteria) this;
        }

        public Criteria andStoreEnterpriseAuthGreaterThanOrEqualTo(Integer value) {
            addCriterion("store_enterprise_auth >=", value, "storeEnterpriseAuth");
            return (Criteria) this;
        }

        public Criteria andStoreEnterpriseAuthLessThan(Integer value) {
            addCriterion("store_enterprise_auth <", value, "storeEnterpriseAuth");
            return (Criteria) this;
        }

        public Criteria andStoreEnterpriseAuthLessThanOrEqualTo(Integer value) {
            addCriterion("store_enterprise_auth <=", value, "storeEnterpriseAuth");
            return (Criteria) this;
        }

        public Criteria andStoreEnterpriseAuthIn(List<Integer> values) {
            addCriterion("store_enterprise_auth in", values, "storeEnterpriseAuth");
            return (Criteria) this;
        }

        public Criteria andStoreEnterpriseAuthNotIn(List<Integer> values) {
            addCriterion("store_enterprise_auth not in", values, "storeEnterpriseAuth");
            return (Criteria) this;
        }

        public Criteria andStoreEnterpriseAuthBetween(Integer value1, Integer value2) {
            addCriterion("store_enterprise_auth between", value1, value2, "storeEnterpriseAuth");
            return (Criteria) this;
        }

        public Criteria andStoreEnterpriseAuthNotBetween(Integer value1, Integer value2) {
            addCriterion("store_enterprise_auth not between", value1, value2, "storeEnterpriseAuth");
            return (Criteria) this;
        }

        public Criteria andStoreLeveIsNull() {
            addCriterion("store_leve is null");
            return (Criteria) this;
        }

        public Criteria andStoreLeveIsNotNull() {
            addCriterion("store_leve is not null");
            return (Criteria) this;
        }

        public Criteria andStoreLeveEqualTo(Integer value) {
            addCriterion("store_leve =", value, "storeLeve");
            return (Criteria) this;
        }

        public Criteria andStoreLeveNotEqualTo(Integer value) {
            addCriterion("store_leve <>", value, "storeLeve");
            return (Criteria) this;
        }

        public Criteria andStoreLeveGreaterThan(Integer value) {
            addCriterion("store_leve >", value, "storeLeve");
            return (Criteria) this;
        }

        public Criteria andStoreLeveGreaterThanOrEqualTo(Integer value) {
            addCriterion("store_leve >=", value, "storeLeve");
            return (Criteria) this;
        }

        public Criteria andStoreLeveLessThan(Integer value) {
            addCriterion("store_leve <", value, "storeLeve");
            return (Criteria) this;
        }

        public Criteria andStoreLeveLessThanOrEqualTo(Integer value) {
            addCriterion("store_leve <=", value, "storeLeve");
            return (Criteria) this;
        }

        public Criteria andStoreLeveIn(List<Integer> values) {
            addCriterion("store_leve in", values, "storeLeve");
            return (Criteria) this;
        }

        public Criteria andStoreLeveNotIn(List<Integer> values) {
            addCriterion("store_leve not in", values, "storeLeve");
            return (Criteria) this;
        }

        public Criteria andStoreLeveBetween(Integer value1, Integer value2) {
            addCriterion("store_leve between", value1, value2, "storeLeve");
            return (Criteria) this;
        }

        public Criteria andStoreLeveNotBetween(Integer value1, Integer value2) {
            addCriterion("store_leve not between", value1, value2, "storeLeve");
            return (Criteria) this;
        }

        public Criteria andStoreSubjectInfoIsNull() {
            addCriterion("store_subject_info is null");
            return (Criteria) this;
        }

        public Criteria andStoreSubjectInfoIsNotNull() {
            addCriterion("store_subject_info is not null");
            return (Criteria) this;
        }

        public Criteria andStoreSubjectInfoEqualTo(String value) {
            addCriterion("store_subject_info =", value, "storeSubjectInfo");
            return (Criteria) this;
        }

        public Criteria andStoreSubjectInfoNotEqualTo(String value) {
            addCriterion("store_subject_info <>", value, "storeSubjectInfo");
            return (Criteria) this;
        }

        public Criteria andStoreSubjectInfoGreaterThan(String value) {
            addCriterion("store_subject_info >", value, "storeSubjectInfo");
            return (Criteria) this;
        }

        public Criteria andStoreSubjectInfoGreaterThanOrEqualTo(String value) {
            addCriterion("store_subject_info >=", value, "storeSubjectInfo");
            return (Criteria) this;
        }

        public Criteria andStoreSubjectInfoLessThan(String value) {
            addCriterion("store_subject_info <", value, "storeSubjectInfo");
            return (Criteria) this;
        }

        public Criteria andStoreSubjectInfoLessThanOrEqualTo(String value) {
            addCriterion("store_subject_info <=", value, "storeSubjectInfo");
            return (Criteria) this;
        }

        public Criteria andStoreSubjectInfoLike(String value) {
            addCriterion("store_subject_info like", value, "storeSubjectInfo");
            return (Criteria) this;
        }

        public Criteria andStoreSubjectInfoNotLike(String value) {
            addCriterion("store_subject_info not like", value, "storeSubjectInfo");
            return (Criteria) this;
        }

        public Criteria andStoreSubjectInfoIn(List<String> values) {
            addCriterion("store_subject_info in", values, "storeSubjectInfo");
            return (Criteria) this;
        }

        public Criteria andStoreSubjectInfoNotIn(List<String> values) {
            addCriterion("store_subject_info not in", values, "storeSubjectInfo");
            return (Criteria) this;
        }

        public Criteria andStoreSubjectInfoBetween(String value1, String value2) {
            addCriterion("store_subject_info between", value1, value2, "storeSubjectInfo");
            return (Criteria) this;
        }

        public Criteria andStoreSubjectInfoNotBetween(String value1, String value2) {
            addCriterion("store_subject_info not between", value1, value2, "storeSubjectInfo");
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

        public Criteria andStoreSummaryIsNull() {
            addCriterion("store_summary is null");
            return (Criteria) this;
        }

        public Criteria andStoreSummaryIsNotNull() {
            addCriterion("store_summary is not null");
            return (Criteria) this;
        }

        public Criteria andStoreSummaryEqualTo(String value) {
            addCriterion("store_summary =", value, "storeSummary");
            return (Criteria) this;
        }

        public Criteria andStoreSummaryNotEqualTo(String value) {
            addCriterion("store_summary <>", value, "storeSummary");
            return (Criteria) this;
        }

        public Criteria andStoreSummaryGreaterThan(String value) {
            addCriterion("store_summary >", value, "storeSummary");
            return (Criteria) this;
        }

        public Criteria andStoreSummaryGreaterThanOrEqualTo(String value) {
            addCriterion("store_summary >=", value, "storeSummary");
            return (Criteria) this;
        }

        public Criteria andStoreSummaryLessThan(String value) {
            addCriterion("store_summary <", value, "storeSummary");
            return (Criteria) this;
        }

        public Criteria andStoreSummaryLessThanOrEqualTo(String value) {
            addCriterion("store_summary <=", value, "storeSummary");
            return (Criteria) this;
        }

        public Criteria andStoreSummaryLike(String value) {
            addCriterion("store_summary like", value, "storeSummary");
            return (Criteria) this;
        }

        public Criteria andStoreSummaryNotLike(String value) {
            addCriterion("store_summary not like", value, "storeSummary");
            return (Criteria) this;
        }

        public Criteria andStoreSummaryIn(List<String> values) {
            addCriterion("store_summary in", values, "storeSummary");
            return (Criteria) this;
        }

        public Criteria andStoreSummaryNotIn(List<String> values) {
            addCriterion("store_summary not in", values, "storeSummary");
            return (Criteria) this;
        }

        public Criteria andStoreSummaryBetween(String value1, String value2) {
            addCriterion("store_summary between", value1, value2, "storeSummary");
            return (Criteria) this;
        }

        public Criteria andStoreSummaryNotBetween(String value1, String value2) {
            addCriterion("store_summary not between", value1, value2, "storeSummary");
            return (Criteria) this;
        }

        public Criteria andStoreLogoIsNull() {
            addCriterion("store_logo is null");
            return (Criteria) this;
        }

        public Criteria andStoreLogoIsNotNull() {
            addCriterion("store_logo is not null");
            return (Criteria) this;
        }

        public Criteria andStoreLogoEqualTo(String value) {
            addCriterion("store_logo =", value, "storeLogo");
            return (Criteria) this;
        }

        public Criteria andStoreLogoNotEqualTo(String value) {
            addCriterion("store_logo <>", value, "storeLogo");
            return (Criteria) this;
        }

        public Criteria andStoreLogoGreaterThan(String value) {
            addCriterion("store_logo >", value, "storeLogo");
            return (Criteria) this;
        }

        public Criteria andStoreLogoGreaterThanOrEqualTo(String value) {
            addCriterion("store_logo >=", value, "storeLogo");
            return (Criteria) this;
        }

        public Criteria andStoreLogoLessThan(String value) {
            addCriterion("store_logo <", value, "storeLogo");
            return (Criteria) this;
        }

        public Criteria andStoreLogoLessThanOrEqualTo(String value) {
            addCriterion("store_logo <=", value, "storeLogo");
            return (Criteria) this;
        }

        public Criteria andStoreLogoLike(String value) {
            addCriterion("store_logo like", value, "storeLogo");
            return (Criteria) this;
        }

        public Criteria andStoreLogoNotLike(String value) {
            addCriterion("store_logo not like", value, "storeLogo");
            return (Criteria) this;
        }

        public Criteria andStoreLogoIn(List<String> values) {
            addCriterion("store_logo in", values, "storeLogo");
            return (Criteria) this;
        }

        public Criteria andStoreLogoNotIn(List<String> values) {
            addCriterion("store_logo not in", values, "storeLogo");
            return (Criteria) this;
        }

        public Criteria andStoreLogoBetween(String value1, String value2) {
            addCriterion("store_logo between", value1, value2, "storeLogo");
            return (Criteria) this;
        }

        public Criteria andStoreLogoNotBetween(String value1, String value2) {
            addCriterion("store_logo not between", value1, value2, "storeLogo");
            return (Criteria) this;
        }

        public Criteria andStoreProvinceIsNull() {
            addCriterion("store_province is null");
            return (Criteria) this;
        }

        public Criteria andStoreProvinceIsNotNull() {
            addCriterion("store_province is not null");
            return (Criteria) this;
        }

        public Criteria andStoreProvinceEqualTo(String value) {
            addCriterion("store_province =", value, "storeProvince");
            return (Criteria) this;
        }

        public Criteria andStoreProvinceNotEqualTo(String value) {
            addCriterion("store_province <>", value, "storeProvince");
            return (Criteria) this;
        }

        public Criteria andStoreProvinceGreaterThan(String value) {
            addCriterion("store_province >", value, "storeProvince");
            return (Criteria) this;
        }

        public Criteria andStoreProvinceGreaterThanOrEqualTo(String value) {
            addCriterion("store_province >=", value, "storeProvince");
            return (Criteria) this;
        }

        public Criteria andStoreProvinceLessThan(String value) {
            addCriterion("store_province <", value, "storeProvince");
            return (Criteria) this;
        }

        public Criteria andStoreProvinceLessThanOrEqualTo(String value) {
            addCriterion("store_province <=", value, "storeProvince");
            return (Criteria) this;
        }

        public Criteria andStoreProvinceLike(String value) {
            addCriterion("store_province like", value, "storeProvince");
            return (Criteria) this;
        }

        public Criteria andStoreProvinceNotLike(String value) {
            addCriterion("store_province not like", value, "storeProvince");
            return (Criteria) this;
        }

        public Criteria andStoreProvinceIn(List<String> values) {
            addCriterion("store_province in", values, "storeProvince");
            return (Criteria) this;
        }

        public Criteria andStoreProvinceNotIn(List<String> values) {
            addCriterion("store_province not in", values, "storeProvince");
            return (Criteria) this;
        }

        public Criteria andStoreProvinceBetween(String value1, String value2) {
            addCriterion("store_province between", value1, value2, "storeProvince");
            return (Criteria) this;
        }

        public Criteria andStoreProvinceNotBetween(String value1, String value2) {
            addCriterion("store_province not between", value1, value2, "storeProvince");
            return (Criteria) this;
        }

        public Criteria andStoreCityIsNull() {
            addCriterion("store_city is null");
            return (Criteria) this;
        }

        public Criteria andStoreCityIsNotNull() {
            addCriterion("store_city is not null");
            return (Criteria) this;
        }

        public Criteria andStoreCityEqualTo(String value) {
            addCriterion("store_city =", value, "storeCity");
            return (Criteria) this;
        }

        public Criteria andStoreCityNotEqualTo(String value) {
            addCriterion("store_city <>", value, "storeCity");
            return (Criteria) this;
        }

        public Criteria andStoreCityGreaterThan(String value) {
            addCriterion("store_city >", value, "storeCity");
            return (Criteria) this;
        }

        public Criteria andStoreCityGreaterThanOrEqualTo(String value) {
            addCriterion("store_city >=", value, "storeCity");
            return (Criteria) this;
        }

        public Criteria andStoreCityLessThan(String value) {
            addCriterion("store_city <", value, "storeCity");
            return (Criteria) this;
        }

        public Criteria andStoreCityLessThanOrEqualTo(String value) {
            addCriterion("store_city <=", value, "storeCity");
            return (Criteria) this;
        }

        public Criteria andStoreCityLike(String value) {
            addCriterion("store_city like", value, "storeCity");
            return (Criteria) this;
        }

        public Criteria andStoreCityNotLike(String value) {
            addCriterion("store_city not like", value, "storeCity");
            return (Criteria) this;
        }

        public Criteria andStoreCityIn(List<String> values) {
            addCriterion("store_city in", values, "storeCity");
            return (Criteria) this;
        }

        public Criteria andStoreCityNotIn(List<String> values) {
            addCriterion("store_city not in", values, "storeCity");
            return (Criteria) this;
        }

        public Criteria andStoreCityBetween(String value1, String value2) {
            addCriterion("store_city between", value1, value2, "storeCity");
            return (Criteria) this;
        }

        public Criteria andStoreCityNotBetween(String value1, String value2) {
            addCriterion("store_city not between", value1, value2, "storeCity");
            return (Criteria) this;
        }

        public Criteria andStoreCountyIsNull() {
            addCriterion("store_county is null");
            return (Criteria) this;
        }

        public Criteria andStoreCountyIsNotNull() {
            addCriterion("store_county is not null");
            return (Criteria) this;
        }

        public Criteria andStoreCountyEqualTo(String value) {
            addCriterion("store_county =", value, "storeCounty");
            return (Criteria) this;
        }

        public Criteria andStoreCountyNotEqualTo(String value) {
            addCriterion("store_county <>", value, "storeCounty");
            return (Criteria) this;
        }

        public Criteria andStoreCountyGreaterThan(String value) {
            addCriterion("store_county >", value, "storeCounty");
            return (Criteria) this;
        }

        public Criteria andStoreCountyGreaterThanOrEqualTo(String value) {
            addCriterion("store_county >=", value, "storeCounty");
            return (Criteria) this;
        }

        public Criteria andStoreCountyLessThan(String value) {
            addCriterion("store_county <", value, "storeCounty");
            return (Criteria) this;
        }

        public Criteria andStoreCountyLessThanOrEqualTo(String value) {
            addCriterion("store_county <=", value, "storeCounty");
            return (Criteria) this;
        }

        public Criteria andStoreCountyLike(String value) {
            addCriterion("store_county like", value, "storeCounty");
            return (Criteria) this;
        }

        public Criteria andStoreCountyNotLike(String value) {
            addCriterion("store_county not like", value, "storeCounty");
            return (Criteria) this;
        }

        public Criteria andStoreCountyIn(List<String> values) {
            addCriterion("store_county in", values, "storeCounty");
            return (Criteria) this;
        }

        public Criteria andStoreCountyNotIn(List<String> values) {
            addCriterion("store_county not in", values, "storeCounty");
            return (Criteria) this;
        }

        public Criteria andStoreCountyBetween(String value1, String value2) {
            addCriterion("store_county between", value1, value2, "storeCounty");
            return (Criteria) this;
        }

        public Criteria andStoreCountyNotBetween(String value1, String value2) {
            addCriterion("store_county not between", value1, value2, "storeCounty");
            return (Criteria) this;
        }

        public Criteria andStoreAddressIsNull() {
            addCriterion("store_address is null");
            return (Criteria) this;
        }

        public Criteria andStoreAddressIsNotNull() {
            addCriterion("store_address is not null");
            return (Criteria) this;
        }

        public Criteria andStoreAddressEqualTo(String value) {
            addCriterion("store_address =", value, "storeAddress");
            return (Criteria) this;
        }

        public Criteria andStoreAddressNotEqualTo(String value) {
            addCriterion("store_address <>", value, "storeAddress");
            return (Criteria) this;
        }

        public Criteria andStoreAddressGreaterThan(String value) {
            addCriterion("store_address >", value, "storeAddress");
            return (Criteria) this;
        }

        public Criteria andStoreAddressGreaterThanOrEqualTo(String value) {
            addCriterion("store_address >=", value, "storeAddress");
            return (Criteria) this;
        }

        public Criteria andStoreAddressLessThan(String value) {
            addCriterion("store_address <", value, "storeAddress");
            return (Criteria) this;
        }

        public Criteria andStoreAddressLessThanOrEqualTo(String value) {
            addCriterion("store_address <=", value, "storeAddress");
            return (Criteria) this;
        }

        public Criteria andStoreAddressLike(String value) {
            addCriterion("store_address like", value, "storeAddress");
            return (Criteria) this;
        }

        public Criteria andStoreAddressNotLike(String value) {
            addCriterion("store_address not like", value, "storeAddress");
            return (Criteria) this;
        }

        public Criteria andStoreAddressIn(List<String> values) {
            addCriterion("store_address in", values, "storeAddress");
            return (Criteria) this;
        }

        public Criteria andStoreAddressNotIn(List<String> values) {
            addCriterion("store_address not in", values, "storeAddress");
            return (Criteria) this;
        }

        public Criteria andStoreAddressBetween(String value1, String value2) {
            addCriterion("store_address between", value1, value2, "storeAddress");
            return (Criteria) this;
        }

        public Criteria andStoreAddressNotBetween(String value1, String value2) {
            addCriterion("store_address not between", value1, value2, "storeAddress");
            return (Criteria) this;
        }

        public Criteria andStoreContactsIsNull() {
            addCriterion("store_contacts is null");
            return (Criteria) this;
        }

        public Criteria andStoreContactsIsNotNull() {
            addCriterion("store_contacts is not null");
            return (Criteria) this;
        }

        public Criteria andStoreContactsEqualTo(String value) {
            addCriterion("store_contacts =", value, "storeContacts");
            return (Criteria) this;
        }

        public Criteria andStoreContactsNotEqualTo(String value) {
            addCriterion("store_contacts <>", value, "storeContacts");
            return (Criteria) this;
        }

        public Criteria andStoreContactsGreaterThan(String value) {
            addCriterion("store_contacts >", value, "storeContacts");
            return (Criteria) this;
        }

        public Criteria andStoreContactsGreaterThanOrEqualTo(String value) {
            addCriterion("store_contacts >=", value, "storeContacts");
            return (Criteria) this;
        }

        public Criteria andStoreContactsLessThan(String value) {
            addCriterion("store_contacts <", value, "storeContacts");
            return (Criteria) this;
        }

        public Criteria andStoreContactsLessThanOrEqualTo(String value) {
            addCriterion("store_contacts <=", value, "storeContacts");
            return (Criteria) this;
        }

        public Criteria andStoreContactsLike(String value) {
            addCriterion("store_contacts like", value, "storeContacts");
            return (Criteria) this;
        }

        public Criteria andStoreContactsNotLike(String value) {
            addCriterion("store_contacts not like", value, "storeContacts");
            return (Criteria) this;
        }

        public Criteria andStoreContactsIn(List<String> values) {
            addCriterion("store_contacts in", values, "storeContacts");
            return (Criteria) this;
        }

        public Criteria andStoreContactsNotIn(List<String> values) {
            addCriterion("store_contacts not in", values, "storeContacts");
            return (Criteria) this;
        }

        public Criteria andStoreContactsBetween(String value1, String value2) {
            addCriterion("store_contacts between", value1, value2, "storeContacts");
            return (Criteria) this;
        }

        public Criteria andStoreContactsNotBetween(String value1, String value2) {
            addCriterion("store_contacts not between", value1, value2, "storeContacts");
            return (Criteria) this;
        }

        public Criteria andStorePhoneIsNull() {
            addCriterion("store_phone is null");
            return (Criteria) this;
        }

        public Criteria andStorePhoneIsNotNull() {
            addCriterion("store_phone is not null");
            return (Criteria) this;
        }

        public Criteria andStorePhoneEqualTo(String value) {
            addCriterion("store_phone =", value, "storePhone");
            return (Criteria) this;
        }

        public Criteria andStorePhoneNotEqualTo(String value) {
            addCriterion("store_phone <>", value, "storePhone");
            return (Criteria) this;
        }

        public Criteria andStorePhoneGreaterThan(String value) {
            addCriterion("store_phone >", value, "storePhone");
            return (Criteria) this;
        }

        public Criteria andStorePhoneGreaterThanOrEqualTo(String value) {
            addCriterion("store_phone >=", value, "storePhone");
            return (Criteria) this;
        }

        public Criteria andStorePhoneLessThan(String value) {
            addCriterion("store_phone <", value, "storePhone");
            return (Criteria) this;
        }

        public Criteria andStorePhoneLessThanOrEqualTo(String value) {
            addCriterion("store_phone <=", value, "storePhone");
            return (Criteria) this;
        }

        public Criteria andStorePhoneLike(String value) {
            addCriterion("store_phone like", value, "storePhone");
            return (Criteria) this;
        }

        public Criteria andStorePhoneNotLike(String value) {
            addCriterion("store_phone not like", value, "storePhone");
            return (Criteria) this;
        }

        public Criteria andStorePhoneIn(List<String> values) {
            addCriterion("store_phone in", values, "storePhone");
            return (Criteria) this;
        }

        public Criteria andStorePhoneNotIn(List<String> values) {
            addCriterion("store_phone not in", values, "storePhone");
            return (Criteria) this;
        }

        public Criteria andStorePhoneBetween(String value1, String value2) {
            addCriterion("store_phone between", value1, value2, "storePhone");
            return (Criteria) this;
        }

        public Criteria andStorePhoneNotBetween(String value1, String value2) {
            addCriterion("store_phone not between", value1, value2, "storePhone");
            return (Criteria) this;
        }

        public Criteria andStoreLocalLonIsNull() {
            addCriterion("store_local_lon is null");
            return (Criteria) this;
        }

        public Criteria andStoreLocalLonIsNotNull() {
            addCriterion("store_local_lon is not null");
            return (Criteria) this;
        }

        public Criteria andStoreLocalLonEqualTo(Double value) {
            addCriterion("store_local_lon =", value, "storeLocalLon");
            return (Criteria) this;
        }

        public Criteria andStoreLocalLonNotEqualTo(Double value) {
            addCriterion("store_local_lon <>", value, "storeLocalLon");
            return (Criteria) this;
        }

        public Criteria andStoreLocalLonGreaterThan(Double value) {
            addCriterion("store_local_lon >", value, "storeLocalLon");
            return (Criteria) this;
        }

        public Criteria andStoreLocalLonGreaterThanOrEqualTo(Double value) {
            addCriterion("store_local_lon >=", value, "storeLocalLon");
            return (Criteria) this;
        }

        public Criteria andStoreLocalLonLessThan(Double value) {
            addCriterion("store_local_lon <", value, "storeLocalLon");
            return (Criteria) this;
        }

        public Criteria andStoreLocalLonLessThanOrEqualTo(Double value) {
            addCriterion("store_local_lon <=", value, "storeLocalLon");
            return (Criteria) this;
        }

        public Criteria andStoreLocalLonIn(List<Double> values) {
            addCriterion("store_local_lon in", values, "storeLocalLon");
            return (Criteria) this;
        }

        public Criteria andStoreLocalLonNotIn(List<Double> values) {
            addCriterion("store_local_lon not in", values, "storeLocalLon");
            return (Criteria) this;
        }

        public Criteria andStoreLocalLonBetween(Double value1, Double value2) {
            addCriterion("store_local_lon between", value1, value2, "storeLocalLon");
            return (Criteria) this;
        }

        public Criteria andStoreLocalLonNotBetween(Double value1, Double value2) {
            addCriterion("store_local_lon not between", value1, value2, "storeLocalLon");
            return (Criteria) this;
        }

        public Criteria andStoreLocalLatIsNull() {
            addCriterion("store_local_lat is null");
            return (Criteria) this;
        }

        public Criteria andStoreLocalLatIsNotNull() {
            addCriterion("store_local_lat is not null");
            return (Criteria) this;
        }

        public Criteria andStoreLocalLatEqualTo(Double value) {
            addCriterion("store_local_lat =", value, "storeLocalLat");
            return (Criteria) this;
        }

        public Criteria andStoreLocalLatNotEqualTo(Double value) {
            addCriterion("store_local_lat <>", value, "storeLocalLat");
            return (Criteria) this;
        }

        public Criteria andStoreLocalLatGreaterThan(Double value) {
            addCriterion("store_local_lat >", value, "storeLocalLat");
            return (Criteria) this;
        }

        public Criteria andStoreLocalLatGreaterThanOrEqualTo(Double value) {
            addCriterion("store_local_lat >=", value, "storeLocalLat");
            return (Criteria) this;
        }

        public Criteria andStoreLocalLatLessThan(Double value) {
            addCriterion("store_local_lat <", value, "storeLocalLat");
            return (Criteria) this;
        }

        public Criteria andStoreLocalLatLessThanOrEqualTo(Double value) {
            addCriterion("store_local_lat <=", value, "storeLocalLat");
            return (Criteria) this;
        }

        public Criteria andStoreLocalLatIn(List<Double> values) {
            addCriterion("store_local_lat in", values, "storeLocalLat");
            return (Criteria) this;
        }

        public Criteria andStoreLocalLatNotIn(List<Double> values) {
            addCriterion("store_local_lat not in", values, "storeLocalLat");
            return (Criteria) this;
        }

        public Criteria andStoreLocalLatBetween(Double value1, Double value2) {
            addCriterion("store_local_lat between", value1, value2, "storeLocalLat");
            return (Criteria) this;
        }

        public Criteria andStoreLocalLatNotBetween(Double value1, Double value2) {
            addCriterion("store_local_lat not between", value1, value2, "storeLocalLat");
            return (Criteria) this;
        }

        public Criteria andStoreAutoReceiptIsNull() {
            addCriterion("store_auto_receipt is null");
            return (Criteria) this;
        }

        public Criteria andStoreAutoReceiptIsNotNull() {
            addCriterion("store_auto_receipt is not null");
            return (Criteria) this;
        }

        public Criteria andStoreAutoReceiptEqualTo(Integer value) {
            addCriterion("store_auto_receipt =", value, "storeAutoReceipt");
            return (Criteria) this;
        }

        public Criteria andStoreAutoReceiptNotEqualTo(Integer value) {
            addCriterion("store_auto_receipt <>", value, "storeAutoReceipt");
            return (Criteria) this;
        }

        public Criteria andStoreAutoReceiptGreaterThan(Integer value) {
            addCriterion("store_auto_receipt >", value, "storeAutoReceipt");
            return (Criteria) this;
        }

        public Criteria andStoreAutoReceiptGreaterThanOrEqualTo(Integer value) {
            addCriterion("store_auto_receipt >=", value, "storeAutoReceipt");
            return (Criteria) this;
        }

        public Criteria andStoreAutoReceiptLessThan(Integer value) {
            addCriterion("store_auto_receipt <", value, "storeAutoReceipt");
            return (Criteria) this;
        }

        public Criteria andStoreAutoReceiptLessThanOrEqualTo(Integer value) {
            addCriterion("store_auto_receipt <=", value, "storeAutoReceipt");
            return (Criteria) this;
        }

        public Criteria andStoreAutoReceiptIn(List<Integer> values) {
            addCriterion("store_auto_receipt in", values, "storeAutoReceipt");
            return (Criteria) this;
        }

        public Criteria andStoreAutoReceiptNotIn(List<Integer> values) {
            addCriterion("store_auto_receipt not in", values, "storeAutoReceipt");
            return (Criteria) this;
        }

        public Criteria andStoreAutoReceiptBetween(Integer value1, Integer value2) {
            addCriterion("store_auto_receipt between", value1, value2, "storeAutoReceipt");
            return (Criteria) this;
        }

        public Criteria andStoreAutoReceiptNotBetween(Integer value1, Integer value2) {
            addCriterion("store_auto_receipt not between", value1, value2, "storeAutoReceipt");
            return (Criteria) this;
        }

        public Criteria andStoreAuditStateIsNull() {
            addCriterion("store_audit_state is null");
            return (Criteria) this;
        }

        public Criteria andStoreAuditStateIsNotNull() {
            addCriterion("store_audit_state is not null");
            return (Criteria) this;
        }

        public Criteria andStoreAuditStateEqualTo(Integer value) {
            addCriterion("store_audit_state =", value, "storeAuditState");
            return (Criteria) this;
        }

        public Criteria andStoreAuditStateNotEqualTo(Integer value) {
            addCriterion("store_audit_state <>", value, "storeAuditState");
            return (Criteria) this;
        }

        public Criteria andStoreAuditStateGreaterThan(Integer value) {
            addCriterion("store_audit_state >", value, "storeAuditState");
            return (Criteria) this;
        }

        public Criteria andStoreAuditStateGreaterThanOrEqualTo(Integer value) {
            addCriterion("store_audit_state >=", value, "storeAuditState");
            return (Criteria) this;
        }

        public Criteria andStoreAuditStateLessThan(Integer value) {
            addCriterion("store_audit_state <", value, "storeAuditState");
            return (Criteria) this;
        }

        public Criteria andStoreAuditStateLessThanOrEqualTo(Integer value) {
            addCriterion("store_audit_state <=", value, "storeAuditState");
            return (Criteria) this;
        }

        public Criteria andStoreAuditStateIn(List<Integer> values) {
            addCriterion("store_audit_state in", values, "storeAuditState");
            return (Criteria) this;
        }

        public Criteria andStoreAuditStateNotIn(List<Integer> values) {
            addCriterion("store_audit_state not in", values, "storeAuditState");
            return (Criteria) this;
        }

        public Criteria andStoreAuditStateBetween(Integer value1, Integer value2) {
            addCriterion("store_audit_state between", value1, value2, "storeAuditState");
            return (Criteria) this;
        }

        public Criteria andStoreAuditStateNotBetween(Integer value1, Integer value2) {
            addCriterion("store_audit_state not between", value1, value2, "storeAuditState");
            return (Criteria) this;
        }

        public Criteria andStoreOverdueTimeIsNull() {
            addCriterion("store_overdue_time is null");
            return (Criteria) this;
        }

        public Criteria andStoreOverdueTimeIsNotNull() {
            addCriterion("store_overdue_time is not null");
            return (Criteria) this;
        }

        public Criteria andStoreOverdueTimeEqualTo(Date value) {
            addCriterion("store_overdue_time =", value, "storeOverdueTime");
            return (Criteria) this;
        }

        public Criteria andStoreOverdueTimeNotEqualTo(Date value) {
            addCriterion("store_overdue_time <>", value, "storeOverdueTime");
            return (Criteria) this;
        }

        public Criteria andStoreOverdueTimeGreaterThan(Date value) {
            addCriterion("store_overdue_time >", value, "storeOverdueTime");
            return (Criteria) this;
        }

        public Criteria andStoreOverdueTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("store_overdue_time >=", value, "storeOverdueTime");
            return (Criteria) this;
        }

        public Criteria andStoreOverdueTimeLessThan(Date value) {
            addCriterion("store_overdue_time <", value, "storeOverdueTime");
            return (Criteria) this;
        }

        public Criteria andStoreOverdueTimeLessThanOrEqualTo(Date value) {
            addCriterion("store_overdue_time <=", value, "storeOverdueTime");
            return (Criteria) this;
        }

        public Criteria andStoreOverdueTimeIn(List<Date> values) {
            addCriterion("store_overdue_time in", values, "storeOverdueTime");
            return (Criteria) this;
        }

        public Criteria andStoreOverdueTimeNotIn(List<Date> values) {
            addCriterion("store_overdue_time not in", values, "storeOverdueTime");
            return (Criteria) this;
        }

        public Criteria andStoreOverdueTimeBetween(Date value1, Date value2) {
            addCriterion("store_overdue_time between", value1, value2, "storeOverdueTime");
            return (Criteria) this;
        }

        public Criteria andStoreOverdueTimeNotBetween(Date value1, Date value2) {
            addCriterion("store_overdue_time not between", value1, value2, "storeOverdueTime");
            return (Criteria) this;
        }

        public Criteria andStoreOpenTimeIsNull() {
            addCriterion("store_open_time is null");
            return (Criteria) this;
        }

        public Criteria andStoreOpenTimeIsNotNull() {
            addCriterion("store_open_time is not null");
            return (Criteria) this;
        }

        public Criteria andStoreOpenTimeEqualTo(Date value) {
            addCriterion("store_open_time =", value, "storeOpenTime");
            return (Criteria) this;
        }

        public Criteria andStoreOpenTimeNotEqualTo(Date value) {
            addCriterion("store_open_time <>", value, "storeOpenTime");
            return (Criteria) this;
        }

        public Criteria andStoreOpenTimeGreaterThan(Date value) {
            addCriterion("store_open_time >", value, "storeOpenTime");
            return (Criteria) this;
        }

        public Criteria andStoreOpenTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("store_open_time >=", value, "storeOpenTime");
            return (Criteria) this;
        }

        public Criteria andStoreOpenTimeLessThan(Date value) {
            addCriterion("store_open_time <", value, "storeOpenTime");
            return (Criteria) this;
        }

        public Criteria andStoreOpenTimeLessThanOrEqualTo(Date value) {
            addCriterion("store_open_time <=", value, "storeOpenTime");
            return (Criteria) this;
        }

        public Criteria andStoreOpenTimeIn(List<Date> values) {
            addCriterion("store_open_time in", values, "storeOpenTime");
            return (Criteria) this;
        }

        public Criteria andStoreOpenTimeNotIn(List<Date> values) {
            addCriterion("store_open_time not in", values, "storeOpenTime");
            return (Criteria) this;
        }

        public Criteria andStoreOpenTimeBetween(Date value1, Date value2) {
            addCriterion("store_open_time between", value1, value2, "storeOpenTime");
            return (Criteria) this;
        }

        public Criteria andStoreOpenTimeNotBetween(Date value1, Date value2) {
            addCriterion("store_open_time not between", value1, value2, "storeOpenTime");
            return (Criteria) this;
        }

        public Criteria andStoreOpenStateIsNull() {
            addCriterion("store_open_state is null");
            return (Criteria) this;
        }

        public Criteria andStoreOpenStateIsNotNull() {
            addCriterion("store_open_state is not null");
            return (Criteria) this;
        }

        public Criteria andStoreOpenStateEqualTo(Integer value) {
            addCriterion("store_open_state =", value, "storeOpenState");
            return (Criteria) this;
        }

        public Criteria andStoreOpenStateNotEqualTo(Integer value) {
            addCriterion("store_open_state <>", value, "storeOpenState");
            return (Criteria) this;
        }

        public Criteria andStoreOpenStateGreaterThan(Integer value) {
            addCriterion("store_open_state >", value, "storeOpenState");
            return (Criteria) this;
        }

        public Criteria andStoreOpenStateGreaterThanOrEqualTo(Integer value) {
            addCriterion("store_open_state >=", value, "storeOpenState");
            return (Criteria) this;
        }

        public Criteria andStoreOpenStateLessThan(Integer value) {
            addCriterion("store_open_state <", value, "storeOpenState");
            return (Criteria) this;
        }

        public Criteria andStoreOpenStateLessThanOrEqualTo(Integer value) {
            addCriterion("store_open_state <=", value, "storeOpenState");
            return (Criteria) this;
        }

        public Criteria andStoreOpenStateIn(List<Integer> values) {
            addCriterion("store_open_state in", values, "storeOpenState");
            return (Criteria) this;
        }

        public Criteria andStoreOpenStateNotIn(List<Integer> values) {
            addCriterion("store_open_state not in", values, "storeOpenState");
            return (Criteria) this;
        }

        public Criteria andStoreOpenStateBetween(Integer value1, Integer value2) {
            addCriterion("store_open_state between", value1, value2, "storeOpenState");
            return (Criteria) this;
        }

        public Criteria andStoreOpenStateNotBetween(Integer value1, Integer value2) {
            addCriterion("store_open_state not between", value1, value2, "storeOpenState");
            return (Criteria) this;
        }

        public Criteria andStoreCurrentOpenStateIsNull() {
            addCriterion("store_current_open_state is null");
            return (Criteria) this;
        }

        public Criteria andStoreCurrentOpenStateIsNotNull() {
            addCriterion("store_current_open_state is not null");
            return (Criteria) this;
        }

        public Criteria andStoreCurrentOpenStateEqualTo(Integer value) {
            addCriterion("store_current_open_state =", value, "storeCurrentOpenState");
            return (Criteria) this;
        }

        public Criteria andStoreCurrentOpenStateNotEqualTo(Integer value) {
            addCriterion("store_current_open_state <>", value, "storeCurrentOpenState");
            return (Criteria) this;
        }

        public Criteria andStoreCurrentOpenStateGreaterThan(Integer value) {
            addCriterion("store_current_open_state >", value, "storeCurrentOpenState");
            return (Criteria) this;
        }

        public Criteria andStoreCurrentOpenStateGreaterThanOrEqualTo(Integer value) {
            addCriterion("store_current_open_state >=", value, "storeCurrentOpenState");
            return (Criteria) this;
        }

        public Criteria andStoreCurrentOpenStateLessThan(Integer value) {
            addCriterion("store_current_open_state <", value, "storeCurrentOpenState");
            return (Criteria) this;
        }

        public Criteria andStoreCurrentOpenStateLessThanOrEqualTo(Integer value) {
            addCriterion("store_current_open_state <=", value, "storeCurrentOpenState");
            return (Criteria) this;
        }

        public Criteria andStoreCurrentOpenStateIn(List<Integer> values) {
            addCriterion("store_current_open_state in", values, "storeCurrentOpenState");
            return (Criteria) this;
        }

        public Criteria andStoreCurrentOpenStateNotIn(List<Integer> values) {
            addCriterion("store_current_open_state not in", values, "storeCurrentOpenState");
            return (Criteria) this;
        }

        public Criteria andStoreCurrentOpenStateBetween(Integer value1, Integer value2) {
            addCriterion("store_current_open_state between", value1, value2, "storeCurrentOpenState");
            return (Criteria) this;
        }

        public Criteria andStoreCurrentOpenStateNotBetween(Integer value1, Integer value2) {
            addCriterion("store_current_open_state not between", value1, value2, "storeCurrentOpenState");
            return (Criteria) this;
        }

        public Criteria andStoreWeightScoreIsNull() {
            addCriterion("store_weight_score is null");
            return (Criteria) this;
        }

        public Criteria andStoreWeightScoreIsNotNull() {
            addCriterion("store_weight_score is not null");
            return (Criteria) this;
        }

        public Criteria andStoreWeightScoreEqualTo(Integer value) {
            addCriterion("store_weight_score =", value, "storeWeightScore");
            return (Criteria) this;
        }

        public Criteria andStoreWeightScoreNotEqualTo(Integer value) {
            addCriterion("store_weight_score <>", value, "storeWeightScore");
            return (Criteria) this;
        }

        public Criteria andStoreWeightScoreGreaterThan(Integer value) {
            addCriterion("store_weight_score >", value, "storeWeightScore");
            return (Criteria) this;
        }

        public Criteria andStoreWeightScoreGreaterThanOrEqualTo(Integer value) {
            addCriterion("store_weight_score >=", value, "storeWeightScore");
            return (Criteria) this;
        }

        public Criteria andStoreWeightScoreLessThan(Integer value) {
            addCriterion("store_weight_score <", value, "storeWeightScore");
            return (Criteria) this;
        }

        public Criteria andStoreWeightScoreLessThanOrEqualTo(Integer value) {
            addCriterion("store_weight_score <=", value, "storeWeightScore");
            return (Criteria) this;
        }

        public Criteria andStoreWeightScoreIn(List<Integer> values) {
            addCriterion("store_weight_score in", values, "storeWeightScore");
            return (Criteria) this;
        }

        public Criteria andStoreWeightScoreNotIn(List<Integer> values) {
            addCriterion("store_weight_score not in", values, "storeWeightScore");
            return (Criteria) this;
        }

        public Criteria andStoreWeightScoreBetween(Integer value1, Integer value2) {
            addCriterion("store_weight_score between", value1, value2, "storeWeightScore");
            return (Criteria) this;
        }

        public Criteria andStoreWeightScoreNotBetween(Integer value1, Integer value2) {
            addCriterion("store_weight_score not between", value1, value2, "storeWeightScore");
            return (Criteria) this;
        }

        public Criteria andStoreAutoDispatchIsNull() {
            addCriterion("store_auto_dispatch is null");
            return (Criteria) this;
        }

        public Criteria andStoreAutoDispatchIsNotNull() {
            addCriterion("store_auto_dispatch is not null");
            return (Criteria) this;
        }

        public Criteria andStoreAutoDispatchEqualTo(Integer value) {
            addCriterion("store_auto_dispatch =", value, "storeAutoDispatch");
            return (Criteria) this;
        }

        public Criteria andStoreAutoDispatchNotEqualTo(Integer value) {
            addCriterion("store_auto_dispatch <>", value, "storeAutoDispatch");
            return (Criteria) this;
        }

        public Criteria andStoreAutoDispatchGreaterThan(Integer value) {
            addCriterion("store_auto_dispatch >", value, "storeAutoDispatch");
            return (Criteria) this;
        }

        public Criteria andStoreAutoDispatchGreaterThanOrEqualTo(Integer value) {
            addCriterion("store_auto_dispatch >=", value, "storeAutoDispatch");
            return (Criteria) this;
        }

        public Criteria andStoreAutoDispatchLessThan(Integer value) {
            addCriterion("store_auto_dispatch <", value, "storeAutoDispatch");
            return (Criteria) this;
        }

        public Criteria andStoreAutoDispatchLessThanOrEqualTo(Integer value) {
            addCriterion("store_auto_dispatch <=", value, "storeAutoDispatch");
            return (Criteria) this;
        }

        public Criteria andStoreAutoDispatchIn(List<Integer> values) {
            addCriterion("store_auto_dispatch in", values, "storeAutoDispatch");
            return (Criteria) this;
        }

        public Criteria andStoreAutoDispatchNotIn(List<Integer> values) {
            addCriterion("store_auto_dispatch not in", values, "storeAutoDispatch");
            return (Criteria) this;
        }

        public Criteria andStoreAutoDispatchBetween(Integer value1, Integer value2) {
            addCriterion("store_auto_dispatch between", value1, value2, "storeAutoDispatch");
            return (Criteria) this;
        }

        public Criteria andStoreAutoDispatchNotBetween(Integer value1, Integer value2) {
            addCriterion("store_auto_dispatch not between", value1, value2, "storeAutoDispatch");
            return (Criteria) this;
        }

        public Criteria andStoreDefaultDispatchTearmIsNull() {
            addCriterion("store_default_dispatch_tearm is null");
            return (Criteria) this;
        }

        public Criteria andStoreDefaultDispatchTearmIsNotNull() {
            addCriterion("store_default_dispatch_tearm is not null");
            return (Criteria) this;
        }

        public Criteria andStoreDefaultDispatchTearmEqualTo(Integer value) {
            addCriterion("store_default_dispatch_tearm =", value, "storeDefaultDispatchTearm");
            return (Criteria) this;
        }

        public Criteria andStoreDefaultDispatchTearmNotEqualTo(Integer value) {
            addCriterion("store_default_dispatch_tearm <>", value, "storeDefaultDispatchTearm");
            return (Criteria) this;
        }

        public Criteria andStoreDefaultDispatchTearmGreaterThan(Integer value) {
            addCriterion("store_default_dispatch_tearm >", value, "storeDefaultDispatchTearm");
            return (Criteria) this;
        }

        public Criteria andStoreDefaultDispatchTearmGreaterThanOrEqualTo(Integer value) {
            addCriterion("store_default_dispatch_tearm >=", value, "storeDefaultDispatchTearm");
            return (Criteria) this;
        }

        public Criteria andStoreDefaultDispatchTearmLessThan(Integer value) {
            addCriterion("store_default_dispatch_tearm <", value, "storeDefaultDispatchTearm");
            return (Criteria) this;
        }

        public Criteria andStoreDefaultDispatchTearmLessThanOrEqualTo(Integer value) {
            addCriterion("store_default_dispatch_tearm <=", value, "storeDefaultDispatchTearm");
            return (Criteria) this;
        }

        public Criteria andStoreDefaultDispatchTearmIn(List<Integer> values) {
            addCriterion("store_default_dispatch_tearm in", values, "storeDefaultDispatchTearm");
            return (Criteria) this;
        }

        public Criteria andStoreDefaultDispatchTearmNotIn(List<Integer> values) {
            addCriterion("store_default_dispatch_tearm not in", values, "storeDefaultDispatchTearm");
            return (Criteria) this;
        }

        public Criteria andStoreDefaultDispatchTearmBetween(Integer value1, Integer value2) {
            addCriterion("store_default_dispatch_tearm between", value1, value2, "storeDefaultDispatchTearm");
            return (Criteria) this;
        }

        public Criteria andStoreDefaultDispatchTearmNotBetween(Integer value1, Integer value2) {
            addCriterion("store_default_dispatch_tearm not between", value1, value2, "storeDefaultDispatchTearm");
            return (Criteria) this;
        }

        public Criteria andStoreSaleCountIsNull() {
            addCriterion("store_sale_count is null");
            return (Criteria) this;
        }

        public Criteria andStoreSaleCountIsNotNull() {
            addCriterion("store_sale_count is not null");
            return (Criteria) this;
        }

        public Criteria andStoreSaleCountEqualTo(Integer value) {
            addCriterion("store_sale_count =", value, "storeSaleCount");
            return (Criteria) this;
        }

        public Criteria andStoreSaleCountNotEqualTo(Integer value) {
            addCriterion("store_sale_count <>", value, "storeSaleCount");
            return (Criteria) this;
        }

        public Criteria andStoreSaleCountGreaterThan(Integer value) {
            addCriterion("store_sale_count >", value, "storeSaleCount");
            return (Criteria) this;
        }

        public Criteria andStoreSaleCountGreaterThanOrEqualTo(Integer value) {
            addCriterion("store_sale_count >=", value, "storeSaleCount");
            return (Criteria) this;
        }

        public Criteria andStoreSaleCountLessThan(Integer value) {
            addCriterion("store_sale_count <", value, "storeSaleCount");
            return (Criteria) this;
        }

        public Criteria andStoreSaleCountLessThanOrEqualTo(Integer value) {
            addCriterion("store_sale_count <=", value, "storeSaleCount");
            return (Criteria) this;
        }

        public Criteria andStoreSaleCountIn(List<Integer> values) {
            addCriterion("store_sale_count in", values, "storeSaleCount");
            return (Criteria) this;
        }

        public Criteria andStoreSaleCountNotIn(List<Integer> values) {
            addCriterion("store_sale_count not in", values, "storeSaleCount");
            return (Criteria) this;
        }

        public Criteria andStoreSaleCountBetween(Integer value1, Integer value2) {
            addCriterion("store_sale_count between", value1, value2, "storeSaleCount");
            return (Criteria) this;
        }

        public Criteria andStoreSaleCountNotBetween(Integer value1, Integer value2) {
            addCriterion("store_sale_count not between", value1, value2, "storeSaleCount");
            return (Criteria) this;
        }

        public Criteria andStoreAgentIdIsNull() {
            addCriterion("store_agent_id is null");
            return (Criteria) this;
        }

        public Criteria andStoreAgentIdIsNotNull() {
            addCriterion("store_agent_id is not null");
            return (Criteria) this;
        }

        public Criteria andStoreAgentIdEqualTo(Integer value) {
            addCriterion("store_agent_id =", value, "storeAgentId");
            return (Criteria) this;
        }

        public Criteria andStoreAgentIdNotEqualTo(Integer value) {
            addCriterion("store_agent_id <>", value, "storeAgentId");
            return (Criteria) this;
        }

        public Criteria andStoreAgentIdGreaterThan(Integer value) {
            addCriterion("store_agent_id >", value, "storeAgentId");
            return (Criteria) this;
        }

        public Criteria andStoreAgentIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("store_agent_id >=", value, "storeAgentId");
            return (Criteria) this;
        }

        public Criteria andStoreAgentIdLessThan(Integer value) {
            addCriterion("store_agent_id <", value, "storeAgentId");
            return (Criteria) this;
        }

        public Criteria andStoreAgentIdLessThanOrEqualTo(Integer value) {
            addCriterion("store_agent_id <=", value, "storeAgentId");
            return (Criteria) this;
        }

        public Criteria andStoreAgentIdIn(List<Integer> values) {
            addCriterion("store_agent_id in", values, "storeAgentId");
            return (Criteria) this;
        }

        public Criteria andStoreAgentIdNotIn(List<Integer> values) {
            addCriterion("store_agent_id not in", values, "storeAgentId");
            return (Criteria) this;
        }

        public Criteria andStoreAgentIdBetween(Integer value1, Integer value2) {
            addCriterion("store_agent_id between", value1, value2, "storeAgentId");
            return (Criteria) this;
        }

        public Criteria andStoreAgentIdNotBetween(Integer value1, Integer value2) {
            addCriterion("store_agent_id not between", value1, value2, "storeAgentId");
            return (Criteria) this;
        }

        public Criteria andStoreGctIsNull() {
            addCriterion("store_gct is null");
            return (Criteria) this;
        }

        public Criteria andStoreGctIsNotNull() {
            addCriterion("store_gct is not null");
            return (Criteria) this;
        }

        public Criteria andStoreGctEqualTo(Date value) {
            addCriterion("store_gct =", value, "storeGct");
            return (Criteria) this;
        }

        public Criteria andStoreGctNotEqualTo(Date value) {
            addCriterion("store_gct <>", value, "storeGct");
            return (Criteria) this;
        }

        public Criteria andStoreGctGreaterThan(Date value) {
            addCriterion("store_gct >", value, "storeGct");
            return (Criteria) this;
        }

        public Criteria andStoreGctGreaterThanOrEqualTo(Date value) {
            addCriterion("store_gct >=", value, "storeGct");
            return (Criteria) this;
        }

        public Criteria andStoreGctLessThan(Date value) {
            addCriterion("store_gct <", value, "storeGct");
            return (Criteria) this;
        }

        public Criteria andStoreGctLessThanOrEqualTo(Date value) {
            addCriterion("store_gct <=", value, "storeGct");
            return (Criteria) this;
        }

        public Criteria andStoreGctIn(List<Date> values) {
            addCriterion("store_gct in", values, "storeGct");
            return (Criteria) this;
        }

        public Criteria andStoreGctNotIn(List<Date> values) {
            addCriterion("store_gct not in", values, "storeGct");
            return (Criteria) this;
        }

        public Criteria andStoreGctBetween(Date value1, Date value2) {
            addCriterion("store_gct between", value1, value2, "storeGct");
            return (Criteria) this;
        }

        public Criteria andStoreGctNotBetween(Date value1, Date value2) {
            addCriterion("store_gct not between", value1, value2, "storeGct");
            return (Criteria) this;
        }

        public Criteria andStoreGmtIsNull() {
            addCriterion("store_gmt is null");
            return (Criteria) this;
        }

        public Criteria andStoreGmtIsNotNull() {
            addCriterion("store_gmt is not null");
            return (Criteria) this;
        }

        public Criteria andStoreGmtEqualTo(Date value) {
            addCriterion("store_gmt =", value, "storeGmt");
            return (Criteria) this;
        }

        public Criteria andStoreGmtNotEqualTo(Date value) {
            addCriterion("store_gmt <>", value, "storeGmt");
            return (Criteria) this;
        }

        public Criteria andStoreGmtGreaterThan(Date value) {
            addCriterion("store_gmt >", value, "storeGmt");
            return (Criteria) this;
        }

        public Criteria andStoreGmtGreaterThanOrEqualTo(Date value) {
            addCriterion("store_gmt >=", value, "storeGmt");
            return (Criteria) this;
        }

        public Criteria andStoreGmtLessThan(Date value) {
            addCriterion("store_gmt <", value, "storeGmt");
            return (Criteria) this;
        }

        public Criteria andStoreGmtLessThanOrEqualTo(Date value) {
            addCriterion("store_gmt <=", value, "storeGmt");
            return (Criteria) this;
        }

        public Criteria andStoreGmtIn(List<Date> values) {
            addCriterion("store_gmt in", values, "storeGmt");
            return (Criteria) this;
        }

        public Criteria andStoreGmtNotIn(List<Date> values) {
            addCriterion("store_gmt not in", values, "storeGmt");
            return (Criteria) this;
        }

        public Criteria andStoreGmtBetween(Date value1, Date value2) {
            addCriterion("store_gmt between", value1, value2, "storeGmt");
            return (Criteria) this;
        }

        public Criteria andStoreGmtNotBetween(Date value1, Date value2) {
            addCriterion("store_gmt not between", value1, value2, "storeGmt");
            return (Criteria) this;
        }

        public Criteria andStoreSettlementDelayIsNull() {
            addCriterion("store_settlement_delay is null");
            return (Criteria) this;
        }

        public Criteria andStoreSettlementDelayIsNotNull() {
            addCriterion("store_settlement_delay is not null");
            return (Criteria) this;
        }

        public Criteria andStoreSettlementDelayEqualTo(Integer value) {
            addCriterion("store_settlement_delay =", value, "storeSettlementDelay");
            return (Criteria) this;
        }

        public Criteria andStoreSettlementDelayNotEqualTo(Integer value) {
            addCriterion("store_settlement_delay <>", value, "storeSettlementDelay");
            return (Criteria) this;
        }

        public Criteria andStoreSettlementDelayGreaterThan(Integer value) {
            addCriterion("store_settlement_delay >", value, "storeSettlementDelay");
            return (Criteria) this;
        }

        public Criteria andStoreSettlementDelayGreaterThanOrEqualTo(Integer value) {
            addCriterion("store_settlement_delay >=", value, "storeSettlementDelay");
            return (Criteria) this;
        }

        public Criteria andStoreSettlementDelayLessThan(Integer value) {
            addCriterion("store_settlement_delay <", value, "storeSettlementDelay");
            return (Criteria) this;
        }

        public Criteria andStoreSettlementDelayLessThanOrEqualTo(Integer value) {
            addCriterion("store_settlement_delay <=", value, "storeSettlementDelay");
            return (Criteria) this;
        }

        public Criteria andStoreSettlementDelayIn(List<Integer> values) {
            addCriterion("store_settlement_delay in", values, "storeSettlementDelay");
            return (Criteria) this;
        }

        public Criteria andStoreSettlementDelayNotIn(List<Integer> values) {
            addCriterion("store_settlement_delay not in", values, "storeSettlementDelay");
            return (Criteria) this;
        }

        public Criteria andStoreSettlementDelayBetween(Integer value1, Integer value2) {
            addCriterion("store_settlement_delay between", value1, value2, "storeSettlementDelay");
            return (Criteria) this;
        }

        public Criteria andStoreSettlementDelayNotBetween(Integer value1, Integer value2) {
            addCriterion("store_settlement_delay not between", value1, value2, "storeSettlementDelay");
            return (Criteria) this;
        }

        public Criteria andStoreSettlementTypeIsNull() {
            addCriterion("store_settlement_type is null");
            return (Criteria) this;
        }

        public Criteria andStoreSettlementTypeIsNotNull() {
            addCriterion("store_settlement_type is not null");
            return (Criteria) this;
        }

        public Criteria andStoreSettlementTypeEqualTo(Integer value) {
            addCriterion("store_settlement_type =", value, "storeSettlementType");
            return (Criteria) this;
        }

        public Criteria andStoreSettlementTypeNotEqualTo(Integer value) {
            addCriterion("store_settlement_type <>", value, "storeSettlementType");
            return (Criteria) this;
        }

        public Criteria andStoreSettlementTypeGreaterThan(Integer value) {
            addCriterion("store_settlement_type >", value, "storeSettlementType");
            return (Criteria) this;
        }

        public Criteria andStoreSettlementTypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("store_settlement_type >=", value, "storeSettlementType");
            return (Criteria) this;
        }

        public Criteria andStoreSettlementTypeLessThan(Integer value) {
            addCriterion("store_settlement_type <", value, "storeSettlementType");
            return (Criteria) this;
        }

        public Criteria andStoreSettlementTypeLessThanOrEqualTo(Integer value) {
            addCriterion("store_settlement_type <=", value, "storeSettlementType");
            return (Criteria) this;
        }

        public Criteria andStoreSettlementTypeIn(List<Integer> values) {
            addCriterion("store_settlement_type in", values, "storeSettlementType");
            return (Criteria) this;
        }

        public Criteria andStoreSettlementTypeNotIn(List<Integer> values) {
            addCriterion("store_settlement_type not in", values, "storeSettlementType");
            return (Criteria) this;
        }

        public Criteria andStoreSettlementTypeBetween(Integer value1, Integer value2) {
            addCriterion("store_settlement_type between", value1, value2, "storeSettlementType");
            return (Criteria) this;
        }

        public Criteria andStoreSettlementTypeNotBetween(Integer value1, Integer value2) {
            addCriterion("store_settlement_type not between", value1, value2, "storeSettlementType");
            return (Criteria) this;
        }

        public Criteria andStoreSettlementAccountNumberIsNull() {
            addCriterion("store_settlement_account_number is null");
            return (Criteria) this;
        }

        public Criteria andStoreSettlementAccountNumberIsNotNull() {
            addCriterion("store_settlement_account_number is not null");
            return (Criteria) this;
        }

        public Criteria andStoreSettlementAccountNumberEqualTo(String value) {
            addCriterion("store_settlement_account_number =", value, "storeSettlementAccountNumber");
            return (Criteria) this;
        }

        public Criteria andStoreSettlementAccountNumberNotEqualTo(String value) {
            addCriterion("store_settlement_account_number <>", value, "storeSettlementAccountNumber");
            return (Criteria) this;
        }

        public Criteria andStoreSettlementAccountNumberGreaterThan(String value) {
            addCriterion("store_settlement_account_number >", value, "storeSettlementAccountNumber");
            return (Criteria) this;
        }

        public Criteria andStoreSettlementAccountNumberGreaterThanOrEqualTo(String value) {
            addCriterion("store_settlement_account_number >=", value, "storeSettlementAccountNumber");
            return (Criteria) this;
        }

        public Criteria andStoreSettlementAccountNumberLessThan(String value) {
            addCriterion("store_settlement_account_number <", value, "storeSettlementAccountNumber");
            return (Criteria) this;
        }

        public Criteria andStoreSettlementAccountNumberLessThanOrEqualTo(String value) {
            addCriterion("store_settlement_account_number <=", value, "storeSettlementAccountNumber");
            return (Criteria) this;
        }

        public Criteria andStoreSettlementAccountNumberLike(String value) {
            addCriterion("store_settlement_account_number like", value, "storeSettlementAccountNumber");
            return (Criteria) this;
        }

        public Criteria andStoreSettlementAccountNumberNotLike(String value) {
            addCriterion("store_settlement_account_number not like", value, "storeSettlementAccountNumber");
            return (Criteria) this;
        }

        public Criteria andStoreSettlementAccountNumberIn(List<String> values) {
            addCriterion("store_settlement_account_number in", values, "storeSettlementAccountNumber");
            return (Criteria) this;
        }

        public Criteria andStoreSettlementAccountNumberNotIn(List<String> values) {
            addCriterion("store_settlement_account_number not in", values, "storeSettlementAccountNumber");
            return (Criteria) this;
        }

        public Criteria andStoreSettlementAccountNumberBetween(String value1, String value2) {
            addCriterion("store_settlement_account_number between", value1, value2, "storeSettlementAccountNumber");
            return (Criteria) this;
        }

        public Criteria andStoreSettlementAccountNumberNotBetween(String value1, String value2) {
            addCriterion("store_settlement_account_number not between", value1, value2, "storeSettlementAccountNumber");
            return (Criteria) this;
        }

        public Criteria andStoreSettlementAccountNameIsNull() {
            addCriterion("store_settlement_account_name is null");
            return (Criteria) this;
        }

        public Criteria andStoreSettlementAccountNameIsNotNull() {
            addCriterion("store_settlement_account_name is not null");
            return (Criteria) this;
        }

        public Criteria andStoreSettlementAccountNameEqualTo(String value) {
            addCriterion("store_settlement_account_name =", value, "storeSettlementAccountName");
            return (Criteria) this;
        }

        public Criteria andStoreSettlementAccountNameNotEqualTo(String value) {
            addCriterion("store_settlement_account_name <>", value, "storeSettlementAccountName");
            return (Criteria) this;
        }

        public Criteria andStoreSettlementAccountNameGreaterThan(String value) {
            addCriterion("store_settlement_account_name >", value, "storeSettlementAccountName");
            return (Criteria) this;
        }

        public Criteria andStoreSettlementAccountNameGreaterThanOrEqualTo(String value) {
            addCriterion("store_settlement_account_name >=", value, "storeSettlementAccountName");
            return (Criteria) this;
        }

        public Criteria andStoreSettlementAccountNameLessThan(String value) {
            addCriterion("store_settlement_account_name <", value, "storeSettlementAccountName");
            return (Criteria) this;
        }

        public Criteria andStoreSettlementAccountNameLessThanOrEqualTo(String value) {
            addCriterion("store_settlement_account_name <=", value, "storeSettlementAccountName");
            return (Criteria) this;
        }

        public Criteria andStoreSettlementAccountNameLike(String value) {
            addCriterion("store_settlement_account_name like", value, "storeSettlementAccountName");
            return (Criteria) this;
        }

        public Criteria andStoreSettlementAccountNameNotLike(String value) {
            addCriterion("store_settlement_account_name not like", value, "storeSettlementAccountName");
            return (Criteria) this;
        }

        public Criteria andStoreSettlementAccountNameIn(List<String> values) {
            addCriterion("store_settlement_account_name in", values, "storeSettlementAccountName");
            return (Criteria) this;
        }

        public Criteria andStoreSettlementAccountNameNotIn(List<String> values) {
            addCriterion("store_settlement_account_name not in", values, "storeSettlementAccountName");
            return (Criteria) this;
        }

        public Criteria andStoreSettlementAccountNameBetween(String value1, String value2) {
            addCriterion("store_settlement_account_name between", value1, value2, "storeSettlementAccountName");
            return (Criteria) this;
        }

        public Criteria andStoreSettlementAccountNameNotBetween(String value1, String value2) {
            addCriterion("store_settlement_account_name not between", value1, value2, "storeSettlementAccountName");
            return (Criteria) this;
        }

        public Criteria andStoreSettlementAccountBankIsNull() {
            addCriterion("store_settlement_account_bank is null");
            return (Criteria) this;
        }

        public Criteria andStoreSettlementAccountBankIsNotNull() {
            addCriterion("store_settlement_account_bank is not null");
            return (Criteria) this;
        }

        public Criteria andStoreSettlementAccountBankEqualTo(String value) {
            addCriterion("store_settlement_account_bank =", value, "storeSettlementAccountBank");
            return (Criteria) this;
        }

        public Criteria andStoreSettlementAccountBankNotEqualTo(String value) {
            addCriterion("store_settlement_account_bank <>", value, "storeSettlementAccountBank");
            return (Criteria) this;
        }

        public Criteria andStoreSettlementAccountBankGreaterThan(String value) {
            addCriterion("store_settlement_account_bank >", value, "storeSettlementAccountBank");
            return (Criteria) this;
        }

        public Criteria andStoreSettlementAccountBankGreaterThanOrEqualTo(String value) {
            addCriterion("store_settlement_account_bank >=", value, "storeSettlementAccountBank");
            return (Criteria) this;
        }

        public Criteria andStoreSettlementAccountBankLessThan(String value) {
            addCriterion("store_settlement_account_bank <", value, "storeSettlementAccountBank");
            return (Criteria) this;
        }

        public Criteria andStoreSettlementAccountBankLessThanOrEqualTo(String value) {
            addCriterion("store_settlement_account_bank <=", value, "storeSettlementAccountBank");
            return (Criteria) this;
        }

        public Criteria andStoreSettlementAccountBankLike(String value) {
            addCriterion("store_settlement_account_bank like", value, "storeSettlementAccountBank");
            return (Criteria) this;
        }

        public Criteria andStoreSettlementAccountBankNotLike(String value) {
            addCriterion("store_settlement_account_bank not like", value, "storeSettlementAccountBank");
            return (Criteria) this;
        }

        public Criteria andStoreSettlementAccountBankIn(List<String> values) {
            addCriterion("store_settlement_account_bank in", values, "storeSettlementAccountBank");
            return (Criteria) this;
        }

        public Criteria andStoreSettlementAccountBankNotIn(List<String> values) {
            addCriterion("store_settlement_account_bank not in", values, "storeSettlementAccountBank");
            return (Criteria) this;
        }

        public Criteria andStoreSettlementAccountBankBetween(String value1, String value2) {
            addCriterion("store_settlement_account_bank between", value1, value2, "storeSettlementAccountBank");
            return (Criteria) this;
        }

        public Criteria andStoreSettlementAccountBankNotBetween(String value1, String value2) {
            addCriterion("store_settlement_account_bank not between", value1, value2, "storeSettlementAccountBank");
            return (Criteria) this;
        }

        public Criteria andStoreTotalScoreIsNull() {
            addCriterion("store_total_score is null");
            return (Criteria) this;
        }

        public Criteria andStoreTotalScoreIsNotNull() {
            addCriterion("store_total_score is not null");
            return (Criteria) this;
        }

        public Criteria andStoreTotalScoreEqualTo(Integer value) {
            addCriterion("store_total_score =", value, "storeTotalScore");
            return (Criteria) this;
        }

        public Criteria andStoreTotalScoreNotEqualTo(Integer value) {
            addCriterion("store_total_score <>", value, "storeTotalScore");
            return (Criteria) this;
        }

        public Criteria andStoreTotalScoreGreaterThan(Integer value) {
            addCriterion("store_total_score >", value, "storeTotalScore");
            return (Criteria) this;
        }

        public Criteria andStoreTotalScoreGreaterThanOrEqualTo(Integer value) {
            addCriterion("store_total_score >=", value, "storeTotalScore");
            return (Criteria) this;
        }

        public Criteria andStoreTotalScoreLessThan(Integer value) {
            addCriterion("store_total_score <", value, "storeTotalScore");
            return (Criteria) this;
        }

        public Criteria andStoreTotalScoreLessThanOrEqualTo(Integer value) {
            addCriterion("store_total_score <=", value, "storeTotalScore");
            return (Criteria) this;
        }

        public Criteria andStoreTotalScoreIn(List<Integer> values) {
            addCriterion("store_total_score in", values, "storeTotalScore");
            return (Criteria) this;
        }

        public Criteria andStoreTotalScoreNotIn(List<Integer> values) {
            addCriterion("store_total_score not in", values, "storeTotalScore");
            return (Criteria) this;
        }

        public Criteria andStoreTotalScoreBetween(Integer value1, Integer value2) {
            addCriterion("store_total_score between", value1, value2, "storeTotalScore");
            return (Criteria) this;
        }

        public Criteria andStoreTotalScoreNotBetween(Integer value1, Integer value2) {
            addCriterion("store_total_score not between", value1, value2, "storeTotalScore");
            return (Criteria) this;
        }

        public Criteria andStoreTotalCommentCountIsNull() {
            addCriterion("store_total_comment_count is null");
            return (Criteria) this;
        }

        public Criteria andStoreTotalCommentCountIsNotNull() {
            addCriterion("store_total_comment_count is not null");
            return (Criteria) this;
        }

        public Criteria andStoreTotalCommentCountEqualTo(Integer value) {
            addCriterion("store_total_comment_count =", value, "storeTotalCommentCount");
            return (Criteria) this;
        }

        public Criteria andStoreTotalCommentCountNotEqualTo(Integer value) {
            addCriterion("store_total_comment_count <>", value, "storeTotalCommentCount");
            return (Criteria) this;
        }

        public Criteria andStoreTotalCommentCountGreaterThan(Integer value) {
            addCriterion("store_total_comment_count >", value, "storeTotalCommentCount");
            return (Criteria) this;
        }

        public Criteria andStoreTotalCommentCountGreaterThanOrEqualTo(Integer value) {
            addCriterion("store_total_comment_count >=", value, "storeTotalCommentCount");
            return (Criteria) this;
        }

        public Criteria andStoreTotalCommentCountLessThan(Integer value) {
            addCriterion("store_total_comment_count <", value, "storeTotalCommentCount");
            return (Criteria) this;
        }

        public Criteria andStoreTotalCommentCountLessThanOrEqualTo(Integer value) {
            addCriterion("store_total_comment_count <=", value, "storeTotalCommentCount");
            return (Criteria) this;
        }

        public Criteria andStoreTotalCommentCountIn(List<Integer> values) {
            addCriterion("store_total_comment_count in", values, "storeTotalCommentCount");
            return (Criteria) this;
        }

        public Criteria andStoreTotalCommentCountNotIn(List<Integer> values) {
            addCriterion("store_total_comment_count not in", values, "storeTotalCommentCount");
            return (Criteria) this;
        }

        public Criteria andStoreTotalCommentCountBetween(Integer value1, Integer value2) {
            addCriterion("store_total_comment_count between", value1, value2, "storeTotalCommentCount");
            return (Criteria) this;
        }

        public Criteria andStoreTotalCommentCountNotBetween(Integer value1, Integer value2) {
            addCriterion("store_total_comment_count not between", value1, value2, "storeTotalCommentCount");
            return (Criteria) this;
        }

        public Criteria andStoreTotalOrderCountIsNull() {
            addCriterion("store_total_order_count is null");
            return (Criteria) this;
        }

        public Criteria andStoreTotalOrderCountIsNotNull() {
            addCriterion("store_total_order_count is not null");
            return (Criteria) this;
        }

        public Criteria andStoreTotalOrderCountEqualTo(Integer value) {
            addCriterion("store_total_order_count =", value, "storeTotalOrderCount");
            return (Criteria) this;
        }

        public Criteria andStoreTotalOrderCountNotEqualTo(Integer value) {
            addCriterion("store_total_order_count <>", value, "storeTotalOrderCount");
            return (Criteria) this;
        }

        public Criteria andStoreTotalOrderCountGreaterThan(Integer value) {
            addCriterion("store_total_order_count >", value, "storeTotalOrderCount");
            return (Criteria) this;
        }

        public Criteria andStoreTotalOrderCountGreaterThanOrEqualTo(Integer value) {
            addCriterion("store_total_order_count >=", value, "storeTotalOrderCount");
            return (Criteria) this;
        }

        public Criteria andStoreTotalOrderCountLessThan(Integer value) {
            addCriterion("store_total_order_count <", value, "storeTotalOrderCount");
            return (Criteria) this;
        }

        public Criteria andStoreTotalOrderCountLessThanOrEqualTo(Integer value) {
            addCriterion("store_total_order_count <=", value, "storeTotalOrderCount");
            return (Criteria) this;
        }

        public Criteria andStoreTotalOrderCountIn(List<Integer> values) {
            addCriterion("store_total_order_count in", values, "storeTotalOrderCount");
            return (Criteria) this;
        }

        public Criteria andStoreTotalOrderCountNotIn(List<Integer> values) {
            addCriterion("store_total_order_count not in", values, "storeTotalOrderCount");
            return (Criteria) this;
        }

        public Criteria andStoreTotalOrderCountBetween(Integer value1, Integer value2) {
            addCriterion("store_total_order_count between", value1, value2, "storeTotalOrderCount");
            return (Criteria) this;
        }

        public Criteria andStoreTotalOrderCountNotBetween(Integer value1, Integer value2) {
            addCriterion("store_total_order_count not between", value1, value2, "storeTotalOrderCount");
            return (Criteria) this;
        }

        public Criteria andStoreBasicFreightIsNull() {
            addCriterion("store_basic_freight is null");
            return (Criteria) this;
        }

        public Criteria andStoreBasicFreightIsNotNull() {
            addCriterion("store_basic_freight is not null");
            return (Criteria) this;
        }

        public Criteria andStoreBasicFreightEqualTo(Integer value) {
            addCriterion("store_basic_freight =", value, "storeBasicFreight");
            return (Criteria) this;
        }

        public Criteria andStoreBasicFreightNotEqualTo(Integer value) {
            addCriterion("store_basic_freight <>", value, "storeBasicFreight");
            return (Criteria) this;
        }

        public Criteria andStoreBasicFreightGreaterThan(Integer value) {
            addCriterion("store_basic_freight >", value, "storeBasicFreight");
            return (Criteria) this;
        }

        public Criteria andStoreBasicFreightGreaterThanOrEqualTo(Integer value) {
            addCriterion("store_basic_freight >=", value, "storeBasicFreight");
            return (Criteria) this;
        }

        public Criteria andStoreBasicFreightLessThan(Integer value) {
            addCriterion("store_basic_freight <", value, "storeBasicFreight");
            return (Criteria) this;
        }

        public Criteria andStoreBasicFreightLessThanOrEqualTo(Integer value) {
            addCriterion("store_basic_freight <=", value, "storeBasicFreight");
            return (Criteria) this;
        }

        public Criteria andStoreBasicFreightIn(List<Integer> values) {
            addCriterion("store_basic_freight in", values, "storeBasicFreight");
            return (Criteria) this;
        }

        public Criteria andStoreBasicFreightNotIn(List<Integer> values) {
            addCriterion("store_basic_freight not in", values, "storeBasicFreight");
            return (Criteria) this;
        }

        public Criteria andStoreBasicFreightBetween(Integer value1, Integer value2) {
            addCriterion("store_basic_freight between", value1, value2, "storeBasicFreight");
            return (Criteria) this;
        }

        public Criteria andStoreBasicFreightNotBetween(Integer value1, Integer value2) {
            addCriterion("store_basic_freight not between", value1, value2, "storeBasicFreight");
            return (Criteria) this;
        }

        public Criteria andStoreMaxDeliveryDistanceIsNull() {
            addCriterion("store_max_delivery_distance is null");
            return (Criteria) this;
        }

        public Criteria andStoreMaxDeliveryDistanceIsNotNull() {
            addCriterion("store_max_delivery_distance is not null");
            return (Criteria) this;
        }

        public Criteria andStoreMaxDeliveryDistanceEqualTo(Integer value) {
            addCriterion("store_max_delivery_distance =", value, "storeMaxDeliveryDistance");
            return (Criteria) this;
        }

        public Criteria andStoreMaxDeliveryDistanceNotEqualTo(Integer value) {
            addCriterion("store_max_delivery_distance <>", value, "storeMaxDeliveryDistance");
            return (Criteria) this;
        }

        public Criteria andStoreMaxDeliveryDistanceGreaterThan(Integer value) {
            addCriterion("store_max_delivery_distance >", value, "storeMaxDeliveryDistance");
            return (Criteria) this;
        }

        public Criteria andStoreMaxDeliveryDistanceGreaterThanOrEqualTo(Integer value) {
            addCriterion("store_max_delivery_distance >=", value, "storeMaxDeliveryDistance");
            return (Criteria) this;
        }

        public Criteria andStoreMaxDeliveryDistanceLessThan(Integer value) {
            addCriterion("store_max_delivery_distance <", value, "storeMaxDeliveryDistance");
            return (Criteria) this;
        }

        public Criteria andStoreMaxDeliveryDistanceLessThanOrEqualTo(Integer value) {
            addCriterion("store_max_delivery_distance <=", value, "storeMaxDeliveryDistance");
            return (Criteria) this;
        }

        public Criteria andStoreMaxDeliveryDistanceIn(List<Integer> values) {
            addCriterion("store_max_delivery_distance in", values, "storeMaxDeliveryDistance");
            return (Criteria) this;
        }

        public Criteria andStoreMaxDeliveryDistanceNotIn(List<Integer> values) {
            addCriterion("store_max_delivery_distance not in", values, "storeMaxDeliveryDistance");
            return (Criteria) this;
        }

        public Criteria andStoreMaxDeliveryDistanceBetween(Integer value1, Integer value2) {
            addCriterion("store_max_delivery_distance between", value1, value2, "storeMaxDeliveryDistance");
            return (Criteria) this;
        }

        public Criteria andStoreMaxDeliveryDistanceNotBetween(Integer value1, Integer value2) {
            addCriterion("store_max_delivery_distance not between", value1, value2, "storeMaxDeliveryDistance");
            return (Criteria) this;
        }

        public Criteria andStorePercentageIsNull() {
            addCriterion("store_percentage is null");
            return (Criteria) this;
        }

        public Criteria andStorePercentageIsNotNull() {
            addCriterion("store_percentage is not null");
            return (Criteria) this;
        }

        public Criteria andStorePercentageEqualTo(Integer value) {
            addCriterion("store_percentage =", value, "storePercentage");
            return (Criteria) this;
        }

        public Criteria andStorePercentageNotEqualTo(Integer value) {
            addCriterion("store_percentage <>", value, "storePercentage");
            return (Criteria) this;
        }

        public Criteria andStorePercentageGreaterThan(Integer value) {
            addCriterion("store_percentage >", value, "storePercentage");
            return (Criteria) this;
        }

        public Criteria andStorePercentageGreaterThanOrEqualTo(Integer value) {
            addCriterion("store_percentage >=", value, "storePercentage");
            return (Criteria) this;
        }

        public Criteria andStorePercentageLessThan(Integer value) {
            addCriterion("store_percentage <", value, "storePercentage");
            return (Criteria) this;
        }

        public Criteria andStorePercentageLessThanOrEqualTo(Integer value) {
            addCriterion("store_percentage <=", value, "storePercentage");
            return (Criteria) this;
        }

        public Criteria andStorePercentageIn(List<Integer> values) {
            addCriterion("store_percentage in", values, "storePercentage");
            return (Criteria) this;
        }

        public Criteria andStorePercentageNotIn(List<Integer> values) {
            addCriterion("store_percentage not in", values, "storePercentage");
            return (Criteria) this;
        }

        public Criteria andStorePercentageBetween(Integer value1, Integer value2) {
            addCriterion("store_percentage between", value1, value2, "storePercentage");
            return (Criteria) this;
        }

        public Criteria andStorePercentageNotBetween(Integer value1, Integer value2) {
            addCriterion("store_percentage not between", value1, value2, "storePercentage");
            return (Criteria) this;
        }

        public Criteria andStorePrinterNumberIsNull() {
            addCriterion("store_printer_number is null");
            return (Criteria) this;
        }

        public Criteria andStorePrinterNumberIsNotNull() {
            addCriterion("store_printer_number is not null");
            return (Criteria) this;
        }

        public Criteria andStorePrinterNumberEqualTo(String value) {
            addCriterion("store_printer_number =", value, "storePrinterNumber");
            return (Criteria) this;
        }

        public Criteria andStorePrinterNumberNotEqualTo(String value) {
            addCriterion("store_printer_number <>", value, "storePrinterNumber");
            return (Criteria) this;
        }

        public Criteria andStorePrinterNumberGreaterThan(String value) {
            addCriterion("store_printer_number >", value, "storePrinterNumber");
            return (Criteria) this;
        }

        public Criteria andStorePrinterNumberGreaterThanOrEqualTo(String value) {
            addCriterion("store_printer_number >=", value, "storePrinterNumber");
            return (Criteria) this;
        }

        public Criteria andStorePrinterNumberLessThan(String value) {
            addCriterion("store_printer_number <", value, "storePrinterNumber");
            return (Criteria) this;
        }

        public Criteria andStorePrinterNumberLessThanOrEqualTo(String value) {
            addCriterion("store_printer_number <=", value, "storePrinterNumber");
            return (Criteria) this;
        }

        public Criteria andStorePrinterNumberLike(String value) {
            addCriterion("store_printer_number like", value, "storePrinterNumber");
            return (Criteria) this;
        }

        public Criteria andStorePrinterNumberNotLike(String value) {
            addCriterion("store_printer_number not like", value, "storePrinterNumber");
            return (Criteria) this;
        }

        public Criteria andStorePrinterNumberIn(List<String> values) {
            addCriterion("store_printer_number in", values, "storePrinterNumber");
            return (Criteria) this;
        }

        public Criteria andStorePrinterNumberNotIn(List<String> values) {
            addCriterion("store_printer_number not in", values, "storePrinterNumber");
            return (Criteria) this;
        }

        public Criteria andStorePrinterNumberBetween(String value1, String value2) {
            addCriterion("store_printer_number between", value1, value2, "storePrinterNumber");
            return (Criteria) this;
        }

        public Criteria andStorePrinterNumberNotBetween(String value1, String value2) {
            addCriterion("store_printer_number not between", value1, value2, "storePrinterNumber");
            return (Criteria) this;
        }

        public Criteria andStoreLoginNumberIsNull() {
            addCriterion("store_login_number is null");
            return (Criteria) this;
        }

        public Criteria andStoreLoginNumberIsNotNull() {
            addCriterion("store_login_number is not null");
            return (Criteria) this;
        }

        public Criteria andStoreLoginNumberEqualTo(String value) {
            addCriterion("store_login_number =", value, "storeLoginNumber");
            return (Criteria) this;
        }

        public Criteria andStoreLoginNumberNotEqualTo(String value) {
            addCriterion("store_login_number <>", value, "storeLoginNumber");
            return (Criteria) this;
        }

        public Criteria andStoreLoginNumberGreaterThan(String value) {
            addCriterion("store_login_number >", value, "storeLoginNumber");
            return (Criteria) this;
        }

        public Criteria andStoreLoginNumberGreaterThanOrEqualTo(String value) {
            addCriterion("store_login_number >=", value, "storeLoginNumber");
            return (Criteria) this;
        }

        public Criteria andStoreLoginNumberLessThan(String value) {
            addCriterion("store_login_number <", value, "storeLoginNumber");
            return (Criteria) this;
        }

        public Criteria andStoreLoginNumberLessThanOrEqualTo(String value) {
            addCriterion("store_login_number <=", value, "storeLoginNumber");
            return (Criteria) this;
        }

        public Criteria andStoreLoginNumberLike(String value) {
            addCriterion("store_login_number like", value, "storeLoginNumber");
            return (Criteria) this;
        }

        public Criteria andStoreLoginNumberNotLike(String value) {
            addCriterion("store_login_number not like", value, "storeLoginNumber");
            return (Criteria) this;
        }

        public Criteria andStoreLoginNumberIn(List<String> values) {
            addCriterion("store_login_number in", values, "storeLoginNumber");
            return (Criteria) this;
        }

        public Criteria andStoreLoginNumberNotIn(List<String> values) {
            addCriterion("store_login_number not in", values, "storeLoginNumber");
            return (Criteria) this;
        }

        public Criteria andStoreLoginNumberBetween(String value1, String value2) {
            addCriterion("store_login_number between", value1, value2, "storeLoginNumber");
            return (Criteria) this;
        }

        public Criteria andStoreLoginNumberNotBetween(String value1, String value2) {
            addCriterion("store_login_number not between", value1, value2, "storeLoginNumber");
            return (Criteria) this;
        }

        public Criteria andStoreInvitedTimeIsNull() {
            addCriterion("store_invited_time is null");
            return (Criteria) this;
        }

        public Criteria andStoreInvitedTimeIsNotNull() {
            addCriterion("store_invited_time is not null");
            return (Criteria) this;
        }

        public Criteria andStoreInvitedTimeEqualTo(Date value) {
            addCriterion("store_invited_time =", value, "storeInvitedTime");
            return (Criteria) this;
        }

        public Criteria andStoreInvitedTimeNotEqualTo(Date value) {
            addCriterion("store_invited_time <>", value, "storeInvitedTime");
            return (Criteria) this;
        }

        public Criteria andStoreInvitedTimeGreaterThan(Date value) {
            addCriterion("store_invited_time >", value, "storeInvitedTime");
            return (Criteria) this;
        }

        public Criteria andStoreInvitedTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("store_invited_time >=", value, "storeInvitedTime");
            return (Criteria) this;
        }

        public Criteria andStoreInvitedTimeLessThan(Date value) {
            addCriterion("store_invited_time <", value, "storeInvitedTime");
            return (Criteria) this;
        }

        public Criteria andStoreInvitedTimeLessThanOrEqualTo(Date value) {
            addCriterion("store_invited_time <=", value, "storeInvitedTime");
            return (Criteria) this;
        }

        public Criteria andStoreInvitedTimeIn(List<Date> values) {
            addCriterion("store_invited_time in", values, "storeInvitedTime");
            return (Criteria) this;
        }

        public Criteria andStoreInvitedTimeNotIn(List<Date> values) {
            addCriterion("store_invited_time not in", values, "storeInvitedTime");
            return (Criteria) this;
        }

        public Criteria andStoreInvitedTimeBetween(Date value1, Date value2) {
            addCriterion("store_invited_time between", value1, value2, "storeInvitedTime");
            return (Criteria) this;
        }

        public Criteria andStoreInvitedTimeNotBetween(Date value1, Date value2) {
            addCriterion("store_invited_time not between", value1, value2, "storeInvitedTime");
            return (Criteria) this;
        }

        public Criteria andStoreRejectIsNull() {
            addCriterion("store_reject is null");
            return (Criteria) this;
        }

        public Criteria andStoreRejectIsNotNull() {
            addCriterion("store_reject is not null");
            return (Criteria) this;
        }

        public Criteria andStoreRejectEqualTo(Integer value) {
            addCriterion("store_reject =", value, "storeReject");
            return (Criteria) this;
        }

        public Criteria andStoreRejectNotEqualTo(Integer value) {
            addCriterion("store_reject <>", value, "storeReject");
            return (Criteria) this;
        }

        public Criteria andStoreRejectGreaterThan(Integer value) {
            addCriterion("store_reject >", value, "storeReject");
            return (Criteria) this;
        }

        public Criteria andStoreRejectGreaterThanOrEqualTo(Integer value) {
            addCriterion("store_reject >=", value, "storeReject");
            return (Criteria) this;
        }

        public Criteria andStoreRejectLessThan(Integer value) {
            addCriterion("store_reject <", value, "storeReject");
            return (Criteria) this;
        }

        public Criteria andStoreRejectLessThanOrEqualTo(Integer value) {
            addCriterion("store_reject <=", value, "storeReject");
            return (Criteria) this;
        }

        public Criteria andStoreRejectIn(List<Integer> values) {
            addCriterion("store_reject in", values, "storeReject");
            return (Criteria) this;
        }

        public Criteria andStoreRejectNotIn(List<Integer> values) {
            addCriterion("store_reject not in", values, "storeReject");
            return (Criteria) this;
        }

        public Criteria andStoreRejectBetween(Integer value1, Integer value2) {
            addCriterion("store_reject between", value1, value2, "storeReject");
            return (Criteria) this;
        }

        public Criteria andStoreRejectNotBetween(Integer value1, Integer value2) {
            addCriterion("store_reject not between", value1, value2, "storeReject");
            return (Criteria) this;
        }

        public Criteria andStoreMinGoodsAmountIsNull() {
            addCriterion("store_min_goods_amount is null");
            return (Criteria) this;
        }

        public Criteria andStoreMinGoodsAmountIsNotNull() {
            addCriterion("store_min_goods_amount is not null");
            return (Criteria) this;
        }

        public Criteria andStoreMinGoodsAmountEqualTo(Integer value) {
            addCriterion("store_min_goods_amount =", value, "storeMinGoodsAmount");
            return (Criteria) this;
        }

        public Criteria andStoreMinGoodsAmountNotEqualTo(Integer value) {
            addCriterion("store_min_goods_amount <>", value, "storeMinGoodsAmount");
            return (Criteria) this;
        }

        public Criteria andStoreMinGoodsAmountGreaterThan(Integer value) {
            addCriterion("store_min_goods_amount >", value, "storeMinGoodsAmount");
            return (Criteria) this;
        }

        public Criteria andStoreMinGoodsAmountGreaterThanOrEqualTo(Integer value) {
            addCriterion("store_min_goods_amount >=", value, "storeMinGoodsAmount");
            return (Criteria) this;
        }

        public Criteria andStoreMinGoodsAmountLessThan(Integer value) {
            addCriterion("store_min_goods_amount <", value, "storeMinGoodsAmount");
            return (Criteria) this;
        }

        public Criteria andStoreMinGoodsAmountLessThanOrEqualTo(Integer value) {
            addCriterion("store_min_goods_amount <=", value, "storeMinGoodsAmount");
            return (Criteria) this;
        }

        public Criteria andStoreMinGoodsAmountIn(List<Integer> values) {
            addCriterion("store_min_goods_amount in", values, "storeMinGoodsAmount");
            return (Criteria) this;
        }

        public Criteria andStoreMinGoodsAmountNotIn(List<Integer> values) {
            addCriterion("store_min_goods_amount not in", values, "storeMinGoodsAmount");
            return (Criteria) this;
        }

        public Criteria andStoreMinGoodsAmountBetween(Integer value1, Integer value2) {
            addCriterion("store_min_goods_amount between", value1, value2, "storeMinGoodsAmount");
            return (Criteria) this;
        }

        public Criteria andStoreMinGoodsAmountNotBetween(Integer value1, Integer value2) {
            addCriterion("store_min_goods_amount not between", value1, value2, "storeMinGoodsAmount");
            return (Criteria) this;
        }

        public Criteria andStoreFreeFreightAmountIsNull() {
            addCriterion("store_free_freight_amount is null");
            return (Criteria) this;
        }

        public Criteria andStoreFreeFreightAmountIsNotNull() {
            addCriterion("store_free_freight_amount is not null");
            return (Criteria) this;
        }

        public Criteria andStoreFreeFreightAmountEqualTo(Integer value) {
            addCriterion("store_free_freight_amount =", value, "storeFreeFreightAmount");
            return (Criteria) this;
        }

        public Criteria andStoreFreeFreightAmountNotEqualTo(Integer value) {
            addCriterion("store_free_freight_amount <>", value, "storeFreeFreightAmount");
            return (Criteria) this;
        }

        public Criteria andStoreFreeFreightAmountGreaterThan(Integer value) {
            addCriterion("store_free_freight_amount >", value, "storeFreeFreightAmount");
            return (Criteria) this;
        }

        public Criteria andStoreFreeFreightAmountGreaterThanOrEqualTo(Integer value) {
            addCriterion("store_free_freight_amount >=", value, "storeFreeFreightAmount");
            return (Criteria) this;
        }

        public Criteria andStoreFreeFreightAmountLessThan(Integer value) {
            addCriterion("store_free_freight_amount <", value, "storeFreeFreightAmount");
            return (Criteria) this;
        }

        public Criteria andStoreFreeFreightAmountLessThanOrEqualTo(Integer value) {
            addCriterion("store_free_freight_amount <=", value, "storeFreeFreightAmount");
            return (Criteria) this;
        }

        public Criteria andStoreFreeFreightAmountIn(List<Integer> values) {
            addCriterion("store_free_freight_amount in", values, "storeFreeFreightAmount");
            return (Criteria) this;
        }

        public Criteria andStoreFreeFreightAmountNotIn(List<Integer> values) {
            addCriterion("store_free_freight_amount not in", values, "storeFreeFreightAmount");
            return (Criteria) this;
        }

        public Criteria andStoreFreeFreightAmountBetween(Integer value1, Integer value2) {
            addCriterion("store_free_freight_amount between", value1, value2, "storeFreeFreightAmount");
            return (Criteria) this;
        }

        public Criteria andStoreFreeFreightAmountNotBetween(Integer value1, Integer value2) {
            addCriterion("store_free_freight_amount not between", value1, value2, "storeFreeFreightAmount");
            return (Criteria) this;
        }

        public Criteria andStoreStationIdIsNull() {
            addCriterion("store_station_id is null");
            return (Criteria) this;
        }

        public Criteria andStoreStationIdIsNotNull() {
            addCriterion("store_station_id is not null");
            return (Criteria) this;
        }

        public Criteria andStoreStationIdEqualTo(Integer value) {
            addCriterion("store_station_id =", value, "storeStationId");
            return (Criteria) this;
        }

        public Criteria andStoreStationIdNotEqualTo(Integer value) {
            addCriterion("store_station_id <>", value, "storeStationId");
            return (Criteria) this;
        }

        public Criteria andStoreStationIdGreaterThan(Integer value) {
            addCriterion("store_station_id >", value, "storeStationId");
            return (Criteria) this;
        }

        public Criteria andStoreStationIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("store_station_id >=", value, "storeStationId");
            return (Criteria) this;
        }

        public Criteria andStoreStationIdLessThan(Integer value) {
            addCriterion("store_station_id <", value, "storeStationId");
            return (Criteria) this;
        }

        public Criteria andStoreStationIdLessThanOrEqualTo(Integer value) {
            addCriterion("store_station_id <=", value, "storeStationId");
            return (Criteria) this;
        }

        public Criteria andStoreStationIdIn(List<Integer> values) {
            addCriterion("store_station_id in", values, "storeStationId");
            return (Criteria) this;
        }

        public Criteria andStoreStationIdNotIn(List<Integer> values) {
            addCriterion("store_station_id not in", values, "storeStationId");
            return (Criteria) this;
        }

        public Criteria andStoreStationIdBetween(Integer value1, Integer value2) {
            addCriterion("store_station_id between", value1, value2, "storeStationId");
            return (Criteria) this;
        }

        public Criteria andStoreStationIdNotBetween(Integer value1, Integer value2) {
            addCriterion("store_station_id not between", value1, value2, "storeStationId");
            return (Criteria) this;
        }

        public Criteria andStorePicsIsNull() {
            addCriterion("store_pics is null");
            return (Criteria) this;
        }

        public Criteria andStorePicsIsNotNull() {
            addCriterion("store_pics is not null");
            return (Criteria) this;
        }

        public Criteria andStorePicsEqualTo(String value) {
            addCriterion("store_pics =", value, "storePics");
            return (Criteria) this;
        }

        public Criteria andStorePicsNotEqualTo(String value) {
            addCriterion("store_pics <>", value, "storePics");
            return (Criteria) this;
        }

        public Criteria andStorePicsGreaterThan(String value) {
            addCriterion("store_pics >", value, "storePics");
            return (Criteria) this;
        }

        public Criteria andStorePicsGreaterThanOrEqualTo(String value) {
            addCriterion("store_pics >=", value, "storePics");
            return (Criteria) this;
        }

        public Criteria andStorePicsLessThan(String value) {
            addCriterion("store_pics <", value, "storePics");
            return (Criteria) this;
        }

        public Criteria andStorePicsLessThanOrEqualTo(String value) {
            addCriterion("store_pics <=", value, "storePics");
            return (Criteria) this;
        }

        public Criteria andStorePicsLike(String value) {
            addCriterion("store_pics like", value, "storePics");
            return (Criteria) this;
        }

        public Criteria andStorePicsNotLike(String value) {
            addCriterion("store_pics not like", value, "storePics");
            return (Criteria) this;
        }

        public Criteria andStorePicsIn(List<String> values) {
            addCriterion("store_pics in", values, "storePics");
            return (Criteria) this;
        }

        public Criteria andStorePicsNotIn(List<String> values) {
            addCriterion("store_pics not in", values, "storePics");
            return (Criteria) this;
        }

        public Criteria andStorePicsBetween(String value1, String value2) {
            addCriterion("store_pics between", value1, value2, "storePics");
            return (Criteria) this;
        }

        public Criteria andStorePicsNotBetween(String value1, String value2) {
            addCriterion("store_pics not between", value1, value2, "storePics");
            return (Criteria) this;
        }

        public Criteria andStoreNoticeIsNull() {
            addCriterion("store_notice is null");
            return (Criteria) this;
        }

        public Criteria andStoreNoticeIsNotNull() {
            addCriterion("store_notice is not null");
            return (Criteria) this;
        }

        public Criteria andStoreNoticeEqualTo(String value) {
            addCriterion("store_notice =", value, "storeNotice");
            return (Criteria) this;
        }

        public Criteria andStoreNoticeNotEqualTo(String value) {
            addCriterion("store_notice <>", value, "storeNotice");
            return (Criteria) this;
        }

        public Criteria andStoreNoticeGreaterThan(String value) {
            addCriterion("store_notice >", value, "storeNotice");
            return (Criteria) this;
        }

        public Criteria andStoreNoticeGreaterThanOrEqualTo(String value) {
            addCriterion("store_notice >=", value, "storeNotice");
            return (Criteria) this;
        }

        public Criteria andStoreNoticeLessThan(String value) {
            addCriterion("store_notice <", value, "storeNotice");
            return (Criteria) this;
        }

        public Criteria andStoreNoticeLessThanOrEqualTo(String value) {
            addCriterion("store_notice <=", value, "storeNotice");
            return (Criteria) this;
        }

        public Criteria andStoreNoticeLike(String value) {
            addCriterion("store_notice like", value, "storeNotice");
            return (Criteria) this;
        }

        public Criteria andStoreNoticeNotLike(String value) {
            addCriterion("store_notice not like", value, "storeNotice");
            return (Criteria) this;
        }

        public Criteria andStoreNoticeIn(List<String> values) {
            addCriterion("store_notice in", values, "storeNotice");
            return (Criteria) this;
        }

        public Criteria andStoreNoticeNotIn(List<String> values) {
            addCriterion("store_notice not in", values, "storeNotice");
            return (Criteria) this;
        }

        public Criteria andStoreNoticeBetween(String value1, String value2) {
            addCriterion("store_notice between", value1, value2, "storeNotice");
            return (Criteria) this;
        }

        public Criteria andStoreNoticeNotBetween(String value1, String value2) {
            addCriterion("store_notice not between", value1, value2, "storeNotice");
            return (Criteria) this;
        }

        public Criteria andStoreIsKillOpenIsNull() {
            addCriterion("store_is_kill_open is null");
            return (Criteria) this;
        }

        public Criteria andStoreIsKillOpenIsNotNull() {
            addCriterion("store_is_kill_open is not null");
            return (Criteria) this;
        }

        public Criteria andStoreIsKillOpenEqualTo(Integer value) {
            addCriterion("store_is_kill_open =", value, "storeIsKillOpen");
            return (Criteria) this;
        }

        public Criteria andStoreIsKillOpenNotEqualTo(Integer value) {
            addCriterion("store_is_kill_open <>", value, "storeIsKillOpen");
            return (Criteria) this;
        }

        public Criteria andStoreIsKillOpenGreaterThan(Integer value) {
            addCriterion("store_is_kill_open >", value, "storeIsKillOpen");
            return (Criteria) this;
        }

        public Criteria andStoreIsKillOpenGreaterThanOrEqualTo(Integer value) {
            addCriterion("store_is_kill_open >=", value, "storeIsKillOpen");
            return (Criteria) this;
        }

        public Criteria andStoreIsKillOpenLessThan(Integer value) {
            addCriterion("store_is_kill_open <", value, "storeIsKillOpen");
            return (Criteria) this;
        }

        public Criteria andStoreIsKillOpenLessThanOrEqualTo(Integer value) {
            addCriterion("store_is_kill_open <=", value, "storeIsKillOpen");
            return (Criteria) this;
        }

        public Criteria andStoreIsKillOpenIn(List<Integer> values) {
            addCriterion("store_is_kill_open in", values, "storeIsKillOpen");
            return (Criteria) this;
        }

        public Criteria andStoreIsKillOpenNotIn(List<Integer> values) {
            addCriterion("store_is_kill_open not in", values, "storeIsKillOpen");
            return (Criteria) this;
        }

        public Criteria andStoreIsKillOpenBetween(Integer value1, Integer value2) {
            addCriterion("store_is_kill_open between", value1, value2, "storeIsKillOpen");
            return (Criteria) this;
        }

        public Criteria andStoreIsKillOpenNotBetween(Integer value1, Integer value2) {
            addCriterion("store_is_kill_open not between", value1, value2, "storeIsKillOpen");
            return (Criteria) this;
        }

        public Criteria andStoreKillEndtimeIsNull() {
            addCriterion("store_kill_endtime is null");
            return (Criteria) this;
        }

        public Criteria andStoreKillEndtimeIsNotNull() {
            addCriterion("store_kill_endtime is not null");
            return (Criteria) this;
        }

        public Criteria andStoreKillEndtimeEqualTo(Date value) {
            addCriterion("store_kill_endtime =", value, "storeKillEndtime");
            return (Criteria) this;
        }

        public Criteria andStoreKillEndtimeNotEqualTo(Date value) {
            addCriterion("store_kill_endtime <>", value, "storeKillEndtime");
            return (Criteria) this;
        }

        public Criteria andStoreKillEndtimeGreaterThan(Date value) {
            addCriterion("store_kill_endtime >", value, "storeKillEndtime");
            return (Criteria) this;
        }

        public Criteria andStoreKillEndtimeGreaterThanOrEqualTo(Date value) {
            addCriterion("store_kill_endtime >=", value, "storeKillEndtime");
            return (Criteria) this;
        }

        public Criteria andStoreKillEndtimeLessThan(Date value) {
            addCriterion("store_kill_endtime <", value, "storeKillEndtime");
            return (Criteria) this;
        }

        public Criteria andStoreKillEndtimeLessThanOrEqualTo(Date value) {
            addCriterion("store_kill_endtime <=", value, "storeKillEndtime");
            return (Criteria) this;
        }

        public Criteria andStoreKillEndtimeIn(List<Date> values) {
            addCriterion("store_kill_endtime in", values, "storeKillEndtime");
            return (Criteria) this;
        }

        public Criteria andStoreKillEndtimeNotIn(List<Date> values) {
            addCriterion("store_kill_endtime not in", values, "storeKillEndtime");
            return (Criteria) this;
        }

        public Criteria andStoreKillEndtimeBetween(Date value1, Date value2) {
            addCriterion("store_kill_endtime between", value1, value2, "storeKillEndtime");
            return (Criteria) this;
        }

        public Criteria andStoreKillEndtimeNotBetween(Date value1, Date value2) {
            addCriterion("store_kill_endtime not between", value1, value2, "storeKillEndtime");
            return (Criteria) this;
        }

        public Criteria andStoreBannerIsNull() {
            addCriterion("store_banner is null");
            return (Criteria) this;
        }

        public Criteria andStoreBannerIsNotNull() {
            addCriterion("store_banner is not null");
            return (Criteria) this;
        }

        public Criteria andStoreBannerEqualTo(String value) {
            addCriterion("store_banner =", value, "storeBanner");
            return (Criteria) this;
        }

        public Criteria andStoreBannerNotEqualTo(String value) {
            addCriterion("store_banner <>", value, "storeBanner");
            return (Criteria) this;
        }

        public Criteria andStoreBannerGreaterThan(String value) {
            addCriterion("store_banner >", value, "storeBanner");
            return (Criteria) this;
        }

        public Criteria andStoreBannerGreaterThanOrEqualTo(String value) {
            addCriterion("store_banner >=", value, "storeBanner");
            return (Criteria) this;
        }

        public Criteria andStoreBannerLessThan(String value) {
            addCriterion("store_banner <", value, "storeBanner");
            return (Criteria) this;
        }

        public Criteria andStoreBannerLessThanOrEqualTo(String value) {
            addCriterion("store_banner <=", value, "storeBanner");
            return (Criteria) this;
        }

        public Criteria andStoreBannerLike(String value) {
            addCriterion("store_banner like", value, "storeBanner");
            return (Criteria) this;
        }

        public Criteria andStoreBannerNotLike(String value) {
            addCriterion("store_banner not like", value, "storeBanner");
            return (Criteria) this;
        }

        public Criteria andStoreBannerIn(List<String> values) {
            addCriterion("store_banner in", values, "storeBanner");
            return (Criteria) this;
        }

        public Criteria andStoreBannerNotIn(List<String> values) {
            addCriterion("store_banner not in", values, "storeBanner");
            return (Criteria) this;
        }

        public Criteria andStoreBannerBetween(String value1, String value2) {
            addCriterion("store_banner between", value1, value2, "storeBanner");
            return (Criteria) this;
        }

        public Criteria andStoreBannerNotBetween(String value1, String value2) {
            addCriterion("store_banner not between", value1, value2, "storeBanner");
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