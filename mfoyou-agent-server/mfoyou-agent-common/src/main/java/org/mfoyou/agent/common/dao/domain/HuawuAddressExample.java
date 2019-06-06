package org.mfoyou.agent.common.dao.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class HuawuAddressExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    protected Integer limitStart;

    protected Integer limitEnd;

    public HuawuAddressExample() {
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

        public Criteria andAddressIdIsNull() {
            addCriterion("address_id is null");
            return (Criteria) this;
        }

        public Criteria andAddressIdIsNotNull() {
            addCriterion("address_id is not null");
            return (Criteria) this;
        }

        public Criteria andAddressIdEqualTo(Integer value) {
            addCriterion("address_id =", value, "addressId");
            return (Criteria) this;
        }

        public Criteria andAddressIdNotEqualTo(Integer value) {
            addCriterion("address_id <>", value, "addressId");
            return (Criteria) this;
        }

        public Criteria andAddressIdGreaterThan(Integer value) {
            addCriterion("address_id >", value, "addressId");
            return (Criteria) this;
        }

        public Criteria andAddressIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("address_id >=", value, "addressId");
            return (Criteria) this;
        }

        public Criteria andAddressIdLessThan(Integer value) {
            addCriterion("address_id <", value, "addressId");
            return (Criteria) this;
        }

        public Criteria andAddressIdLessThanOrEqualTo(Integer value) {
            addCriterion("address_id <=", value, "addressId");
            return (Criteria) this;
        }

        public Criteria andAddressIdIn(List<Integer> values) {
            addCriterion("address_id in", values, "addressId");
            return (Criteria) this;
        }

        public Criteria andAddressIdNotIn(List<Integer> values) {
            addCriterion("address_id not in", values, "addressId");
            return (Criteria) this;
        }

        public Criteria andAddressIdBetween(Integer value1, Integer value2) {
            addCriterion("address_id between", value1, value2, "addressId");
            return (Criteria) this;
        }

        public Criteria andAddressIdNotBetween(Integer value1, Integer value2) {
            addCriterion("address_id not between", value1, value2, "addressId");
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

        public Criteria andAddressProvinceIsNull() {
            addCriterion("address_province is null");
            return (Criteria) this;
        }

        public Criteria andAddressProvinceIsNotNull() {
            addCriterion("address_province is not null");
            return (Criteria) this;
        }

        public Criteria andAddressProvinceEqualTo(String value) {
            addCriterion("address_province =", value, "addressProvince");
            return (Criteria) this;
        }

        public Criteria andAddressProvinceNotEqualTo(String value) {
            addCriterion("address_province <>", value, "addressProvince");
            return (Criteria) this;
        }

        public Criteria andAddressProvinceGreaterThan(String value) {
            addCriterion("address_province >", value, "addressProvince");
            return (Criteria) this;
        }

        public Criteria andAddressProvinceGreaterThanOrEqualTo(String value) {
            addCriterion("address_province >=", value, "addressProvince");
            return (Criteria) this;
        }

        public Criteria andAddressProvinceLessThan(String value) {
            addCriterion("address_province <", value, "addressProvince");
            return (Criteria) this;
        }

        public Criteria andAddressProvinceLessThanOrEqualTo(String value) {
            addCriterion("address_province <=", value, "addressProvince");
            return (Criteria) this;
        }

        public Criteria andAddressProvinceLike(String value) {
            addCriterion("address_province like", value, "addressProvince");
            return (Criteria) this;
        }

        public Criteria andAddressProvinceNotLike(String value) {
            addCriterion("address_province not like", value, "addressProvince");
            return (Criteria) this;
        }

        public Criteria andAddressProvinceIn(List<String> values) {
            addCriterion("address_province in", values, "addressProvince");
            return (Criteria) this;
        }

        public Criteria andAddressProvinceNotIn(List<String> values) {
            addCriterion("address_province not in", values, "addressProvince");
            return (Criteria) this;
        }

        public Criteria andAddressProvinceBetween(String value1, String value2) {
            addCriterion("address_province between", value1, value2, "addressProvince");
            return (Criteria) this;
        }

        public Criteria andAddressProvinceNotBetween(String value1, String value2) {
            addCriterion("address_province not between", value1, value2, "addressProvince");
            return (Criteria) this;
        }

        public Criteria andAddressCityIsNull() {
            addCriterion("address_city is null");
            return (Criteria) this;
        }

        public Criteria andAddressCityIsNotNull() {
            addCriterion("address_city is not null");
            return (Criteria) this;
        }

        public Criteria andAddressCityEqualTo(String value) {
            addCriterion("address_city =", value, "addressCity");
            return (Criteria) this;
        }

        public Criteria andAddressCityNotEqualTo(String value) {
            addCriterion("address_city <>", value, "addressCity");
            return (Criteria) this;
        }

        public Criteria andAddressCityGreaterThan(String value) {
            addCriterion("address_city >", value, "addressCity");
            return (Criteria) this;
        }

        public Criteria andAddressCityGreaterThanOrEqualTo(String value) {
            addCriterion("address_city >=", value, "addressCity");
            return (Criteria) this;
        }

        public Criteria andAddressCityLessThan(String value) {
            addCriterion("address_city <", value, "addressCity");
            return (Criteria) this;
        }

        public Criteria andAddressCityLessThanOrEqualTo(String value) {
            addCriterion("address_city <=", value, "addressCity");
            return (Criteria) this;
        }

        public Criteria andAddressCityLike(String value) {
            addCriterion("address_city like", value, "addressCity");
            return (Criteria) this;
        }

        public Criteria andAddressCityNotLike(String value) {
            addCriterion("address_city not like", value, "addressCity");
            return (Criteria) this;
        }

        public Criteria andAddressCityIn(List<String> values) {
            addCriterion("address_city in", values, "addressCity");
            return (Criteria) this;
        }

        public Criteria andAddressCityNotIn(List<String> values) {
            addCriterion("address_city not in", values, "addressCity");
            return (Criteria) this;
        }

        public Criteria andAddressCityBetween(String value1, String value2) {
            addCriterion("address_city between", value1, value2, "addressCity");
            return (Criteria) this;
        }

        public Criteria andAddressCityNotBetween(String value1, String value2) {
            addCriterion("address_city not between", value1, value2, "addressCity");
            return (Criteria) this;
        }

        public Criteria andAddressCountyIsNull() {
            addCriterion("address_county is null");
            return (Criteria) this;
        }

        public Criteria andAddressCountyIsNotNull() {
            addCriterion("address_county is not null");
            return (Criteria) this;
        }

        public Criteria andAddressCountyEqualTo(String value) {
            addCriterion("address_county =", value, "addressCounty");
            return (Criteria) this;
        }

        public Criteria andAddressCountyNotEqualTo(String value) {
            addCriterion("address_county <>", value, "addressCounty");
            return (Criteria) this;
        }

        public Criteria andAddressCountyGreaterThan(String value) {
            addCriterion("address_county >", value, "addressCounty");
            return (Criteria) this;
        }

        public Criteria andAddressCountyGreaterThanOrEqualTo(String value) {
            addCriterion("address_county >=", value, "addressCounty");
            return (Criteria) this;
        }

        public Criteria andAddressCountyLessThan(String value) {
            addCriterion("address_county <", value, "addressCounty");
            return (Criteria) this;
        }

        public Criteria andAddressCountyLessThanOrEqualTo(String value) {
            addCriterion("address_county <=", value, "addressCounty");
            return (Criteria) this;
        }

        public Criteria andAddressCountyLike(String value) {
            addCriterion("address_county like", value, "addressCounty");
            return (Criteria) this;
        }

        public Criteria andAddressCountyNotLike(String value) {
            addCriterion("address_county not like", value, "addressCounty");
            return (Criteria) this;
        }

        public Criteria andAddressCountyIn(List<String> values) {
            addCriterion("address_county in", values, "addressCounty");
            return (Criteria) this;
        }

        public Criteria andAddressCountyNotIn(List<String> values) {
            addCriterion("address_county not in", values, "addressCounty");
            return (Criteria) this;
        }

        public Criteria andAddressCountyBetween(String value1, String value2) {
            addCriterion("address_county between", value1, value2, "addressCounty");
            return (Criteria) this;
        }

        public Criteria andAddressCountyNotBetween(String value1, String value2) {
            addCriterion("address_county not between", value1, value2, "addressCounty");
            return (Criteria) this;
        }

        public Criteria andAddressAreaIsNull() {
            addCriterion("address_area is null");
            return (Criteria) this;
        }

        public Criteria andAddressAreaIsNotNull() {
            addCriterion("address_area is not null");
            return (Criteria) this;
        }

        public Criteria andAddressAreaEqualTo(String value) {
            addCriterion("address_area =", value, "addressArea");
            return (Criteria) this;
        }

        public Criteria andAddressAreaNotEqualTo(String value) {
            addCriterion("address_area <>", value, "addressArea");
            return (Criteria) this;
        }

        public Criteria andAddressAreaGreaterThan(String value) {
            addCriterion("address_area >", value, "addressArea");
            return (Criteria) this;
        }

        public Criteria andAddressAreaGreaterThanOrEqualTo(String value) {
            addCriterion("address_area >=", value, "addressArea");
            return (Criteria) this;
        }

        public Criteria andAddressAreaLessThan(String value) {
            addCriterion("address_area <", value, "addressArea");
            return (Criteria) this;
        }

        public Criteria andAddressAreaLessThanOrEqualTo(String value) {
            addCriterion("address_area <=", value, "addressArea");
            return (Criteria) this;
        }

        public Criteria andAddressAreaLike(String value) {
            addCriterion("address_area like", value, "addressArea");
            return (Criteria) this;
        }

        public Criteria andAddressAreaNotLike(String value) {
            addCriterion("address_area not like", value, "addressArea");
            return (Criteria) this;
        }

        public Criteria andAddressAreaIn(List<String> values) {
            addCriterion("address_area in", values, "addressArea");
            return (Criteria) this;
        }

        public Criteria andAddressAreaNotIn(List<String> values) {
            addCriterion("address_area not in", values, "addressArea");
            return (Criteria) this;
        }

        public Criteria andAddressAreaBetween(String value1, String value2) {
            addCriterion("address_area between", value1, value2, "addressArea");
            return (Criteria) this;
        }

        public Criteria andAddressAreaNotBetween(String value1, String value2) {
            addCriterion("address_area not between", value1, value2, "addressArea");
            return (Criteria) this;
        }

        public Criteria andAddressTextIsNull() {
            addCriterion("address_text is null");
            return (Criteria) this;
        }

        public Criteria andAddressTextIsNotNull() {
            addCriterion("address_text is not null");
            return (Criteria) this;
        }

        public Criteria andAddressTextEqualTo(String value) {
            addCriterion("address_text =", value, "addressText");
            return (Criteria) this;
        }

        public Criteria andAddressTextNotEqualTo(String value) {
            addCriterion("address_text <>", value, "addressText");
            return (Criteria) this;
        }

        public Criteria andAddressTextGreaterThan(String value) {
            addCriterion("address_text >", value, "addressText");
            return (Criteria) this;
        }

        public Criteria andAddressTextGreaterThanOrEqualTo(String value) {
            addCriterion("address_text >=", value, "addressText");
            return (Criteria) this;
        }

        public Criteria andAddressTextLessThan(String value) {
            addCriterion("address_text <", value, "addressText");
            return (Criteria) this;
        }

        public Criteria andAddressTextLessThanOrEqualTo(String value) {
            addCriterion("address_text <=", value, "addressText");
            return (Criteria) this;
        }

        public Criteria andAddressTextLike(String value) {
            addCriterion("address_text like", value, "addressText");
            return (Criteria) this;
        }

        public Criteria andAddressTextNotLike(String value) {
            addCriterion("address_text not like", value, "addressText");
            return (Criteria) this;
        }

        public Criteria andAddressTextIn(List<String> values) {
            addCriterion("address_text in", values, "addressText");
            return (Criteria) this;
        }

        public Criteria andAddressTextNotIn(List<String> values) {
            addCriterion("address_text not in", values, "addressText");
            return (Criteria) this;
        }

        public Criteria andAddressTextBetween(String value1, String value2) {
            addCriterion("address_text between", value1, value2, "addressText");
            return (Criteria) this;
        }

        public Criteria andAddressTextNotBetween(String value1, String value2) {
            addCriterion("address_text not between", value1, value2, "addressText");
            return (Criteria) this;
        }

        public Criteria andAddressDetailedIsNull() {
            addCriterion("address_detailed is null");
            return (Criteria) this;
        }

        public Criteria andAddressDetailedIsNotNull() {
            addCriterion("address_detailed is not null");
            return (Criteria) this;
        }

        public Criteria andAddressDetailedEqualTo(String value) {
            addCriterion("address_detailed =", value, "addressDetailed");
            return (Criteria) this;
        }

        public Criteria andAddressDetailedNotEqualTo(String value) {
            addCriterion("address_detailed <>", value, "addressDetailed");
            return (Criteria) this;
        }

        public Criteria andAddressDetailedGreaterThan(String value) {
            addCriterion("address_detailed >", value, "addressDetailed");
            return (Criteria) this;
        }

        public Criteria andAddressDetailedGreaterThanOrEqualTo(String value) {
            addCriterion("address_detailed >=", value, "addressDetailed");
            return (Criteria) this;
        }

        public Criteria andAddressDetailedLessThan(String value) {
            addCriterion("address_detailed <", value, "addressDetailed");
            return (Criteria) this;
        }

        public Criteria andAddressDetailedLessThanOrEqualTo(String value) {
            addCriterion("address_detailed <=", value, "addressDetailed");
            return (Criteria) this;
        }

        public Criteria andAddressDetailedLike(String value) {
            addCriterion("address_detailed like", value, "addressDetailed");
            return (Criteria) this;
        }

        public Criteria andAddressDetailedNotLike(String value) {
            addCriterion("address_detailed not like", value, "addressDetailed");
            return (Criteria) this;
        }

        public Criteria andAddressDetailedIn(List<String> values) {
            addCriterion("address_detailed in", values, "addressDetailed");
            return (Criteria) this;
        }

        public Criteria andAddressDetailedNotIn(List<String> values) {
            addCriterion("address_detailed not in", values, "addressDetailed");
            return (Criteria) this;
        }

        public Criteria andAddressDetailedBetween(String value1, String value2) {
            addCriterion("address_detailed between", value1, value2, "addressDetailed");
            return (Criteria) this;
        }

        public Criteria andAddressDetailedNotBetween(String value1, String value2) {
            addCriterion("address_detailed not between", value1, value2, "addressDetailed");
            return (Criteria) this;
        }

        public Criteria andAddressLocationIsNull() {
            addCriterion("address_location is null");
            return (Criteria) this;
        }

        public Criteria andAddressLocationIsNotNull() {
            addCriterion("address_location is not null");
            return (Criteria) this;
        }

        public Criteria andAddressLocationEqualTo(String value) {
            addCriterion("address_location =", value, "addressLocation");
            return (Criteria) this;
        }

        public Criteria andAddressLocationNotEqualTo(String value) {
            addCriterion("address_location <>", value, "addressLocation");
            return (Criteria) this;
        }

        public Criteria andAddressLocationGreaterThan(String value) {
            addCriterion("address_location >", value, "addressLocation");
            return (Criteria) this;
        }

        public Criteria andAddressLocationGreaterThanOrEqualTo(String value) {
            addCriterion("address_location >=", value, "addressLocation");
            return (Criteria) this;
        }

        public Criteria andAddressLocationLessThan(String value) {
            addCriterion("address_location <", value, "addressLocation");
            return (Criteria) this;
        }

        public Criteria andAddressLocationLessThanOrEqualTo(String value) {
            addCriterion("address_location <=", value, "addressLocation");
            return (Criteria) this;
        }

        public Criteria andAddressLocationLike(String value) {
            addCriterion("address_location like", value, "addressLocation");
            return (Criteria) this;
        }

        public Criteria andAddressLocationNotLike(String value) {
            addCriterion("address_location not like", value, "addressLocation");
            return (Criteria) this;
        }

        public Criteria andAddressLocationIn(List<String> values) {
            addCriterion("address_location in", values, "addressLocation");
            return (Criteria) this;
        }

        public Criteria andAddressLocationNotIn(List<String> values) {
            addCriterion("address_location not in", values, "addressLocation");
            return (Criteria) this;
        }

        public Criteria andAddressLocationBetween(String value1, String value2) {
            addCriterion("address_location between", value1, value2, "addressLocation");
            return (Criteria) this;
        }

        public Criteria andAddressLocationNotBetween(String value1, String value2) {
            addCriterion("address_location not between", value1, value2, "addressLocation");
            return (Criteria) this;
        }

        public Criteria andAddressGisLongIsNull() {
            addCriterion("address_gis_long is null");
            return (Criteria) this;
        }

        public Criteria andAddressGisLongIsNotNull() {
            addCriterion("address_gis_long is not null");
            return (Criteria) this;
        }

        public Criteria andAddressGisLongEqualTo(Double value) {
            addCriterion("address_gis_long =", value, "addressGisLong");
            return (Criteria) this;
        }

        public Criteria andAddressGisLongNotEqualTo(Double value) {
            addCriterion("address_gis_long <>", value, "addressGisLong");
            return (Criteria) this;
        }

        public Criteria andAddressGisLongGreaterThan(Double value) {
            addCriterion("address_gis_long >", value, "addressGisLong");
            return (Criteria) this;
        }

        public Criteria andAddressGisLongGreaterThanOrEqualTo(Double value) {
            addCriterion("address_gis_long >=", value, "addressGisLong");
            return (Criteria) this;
        }

        public Criteria andAddressGisLongLessThan(Double value) {
            addCriterion("address_gis_long <", value, "addressGisLong");
            return (Criteria) this;
        }

        public Criteria andAddressGisLongLessThanOrEqualTo(Double value) {
            addCriterion("address_gis_long <=", value, "addressGisLong");
            return (Criteria) this;
        }

        public Criteria andAddressGisLongIn(List<Double> values) {
            addCriterion("address_gis_long in", values, "addressGisLong");
            return (Criteria) this;
        }

        public Criteria andAddressGisLongNotIn(List<Double> values) {
            addCriterion("address_gis_long not in", values, "addressGisLong");
            return (Criteria) this;
        }

        public Criteria andAddressGisLongBetween(Double value1, Double value2) {
            addCriterion("address_gis_long between", value1, value2, "addressGisLong");
            return (Criteria) this;
        }

        public Criteria andAddressGisLongNotBetween(Double value1, Double value2) {
            addCriterion("address_gis_long not between", value1, value2, "addressGisLong");
            return (Criteria) this;
        }

        public Criteria andAddressGisLatIsNull() {
            addCriterion("address_gis_lat is null");
            return (Criteria) this;
        }

        public Criteria andAddressGisLatIsNotNull() {
            addCriterion("address_gis_lat is not null");
            return (Criteria) this;
        }

        public Criteria andAddressGisLatEqualTo(Double value) {
            addCriterion("address_gis_lat =", value, "addressGisLat");
            return (Criteria) this;
        }

        public Criteria andAddressGisLatNotEqualTo(Double value) {
            addCriterion("address_gis_lat <>", value, "addressGisLat");
            return (Criteria) this;
        }

        public Criteria andAddressGisLatGreaterThan(Double value) {
            addCriterion("address_gis_lat >", value, "addressGisLat");
            return (Criteria) this;
        }

        public Criteria andAddressGisLatGreaterThanOrEqualTo(Double value) {
            addCriterion("address_gis_lat >=", value, "addressGisLat");
            return (Criteria) this;
        }

        public Criteria andAddressGisLatLessThan(Double value) {
            addCriterion("address_gis_lat <", value, "addressGisLat");
            return (Criteria) this;
        }

        public Criteria andAddressGisLatLessThanOrEqualTo(Double value) {
            addCriterion("address_gis_lat <=", value, "addressGisLat");
            return (Criteria) this;
        }

        public Criteria andAddressGisLatIn(List<Double> values) {
            addCriterion("address_gis_lat in", values, "addressGisLat");
            return (Criteria) this;
        }

        public Criteria andAddressGisLatNotIn(List<Double> values) {
            addCriterion("address_gis_lat not in", values, "addressGisLat");
            return (Criteria) this;
        }

        public Criteria andAddressGisLatBetween(Double value1, Double value2) {
            addCriterion("address_gis_lat between", value1, value2, "addressGisLat");
            return (Criteria) this;
        }

        public Criteria andAddressGisLatNotBetween(Double value1, Double value2) {
            addCriterion("address_gis_lat not between", value1, value2, "addressGisLat");
            return (Criteria) this;
        }

        public Criteria andAddressNameIsNull() {
            addCriterion("address_name is null");
            return (Criteria) this;
        }

        public Criteria andAddressNameIsNotNull() {
            addCriterion("address_name is not null");
            return (Criteria) this;
        }

        public Criteria andAddressNameEqualTo(String value) {
            addCriterion("address_name =", value, "addressName");
            return (Criteria) this;
        }

        public Criteria andAddressNameNotEqualTo(String value) {
            addCriterion("address_name <>", value, "addressName");
            return (Criteria) this;
        }

        public Criteria andAddressNameGreaterThan(String value) {
            addCriterion("address_name >", value, "addressName");
            return (Criteria) this;
        }

        public Criteria andAddressNameGreaterThanOrEqualTo(String value) {
            addCriterion("address_name >=", value, "addressName");
            return (Criteria) this;
        }

        public Criteria andAddressNameLessThan(String value) {
            addCriterion("address_name <", value, "addressName");
            return (Criteria) this;
        }

        public Criteria andAddressNameLessThanOrEqualTo(String value) {
            addCriterion("address_name <=", value, "addressName");
            return (Criteria) this;
        }

        public Criteria andAddressNameLike(String value) {
            addCriterion("address_name like", value, "addressName");
            return (Criteria) this;
        }

        public Criteria andAddressNameNotLike(String value) {
            addCriterion("address_name not like", value, "addressName");
            return (Criteria) this;
        }

        public Criteria andAddressNameIn(List<String> values) {
            addCriterion("address_name in", values, "addressName");
            return (Criteria) this;
        }

        public Criteria andAddressNameNotIn(List<String> values) {
            addCriterion("address_name not in", values, "addressName");
            return (Criteria) this;
        }

        public Criteria andAddressNameBetween(String value1, String value2) {
            addCriterion("address_name between", value1, value2, "addressName");
            return (Criteria) this;
        }

        public Criteria andAddressNameNotBetween(String value1, String value2) {
            addCriterion("address_name not between", value1, value2, "addressName");
            return (Criteria) this;
        }

        public Criteria andAddressSexIsNull() {
            addCriterion("address_sex is null");
            return (Criteria) this;
        }

        public Criteria andAddressSexIsNotNull() {
            addCriterion("address_sex is not null");
            return (Criteria) this;
        }

        public Criteria andAddressSexEqualTo(Integer value) {
            addCriterion("address_sex =", value, "addressSex");
            return (Criteria) this;
        }

        public Criteria andAddressSexNotEqualTo(Integer value) {
            addCriterion("address_sex <>", value, "addressSex");
            return (Criteria) this;
        }

        public Criteria andAddressSexGreaterThan(Integer value) {
            addCriterion("address_sex >", value, "addressSex");
            return (Criteria) this;
        }

        public Criteria andAddressSexGreaterThanOrEqualTo(Integer value) {
            addCriterion("address_sex >=", value, "addressSex");
            return (Criteria) this;
        }

        public Criteria andAddressSexLessThan(Integer value) {
            addCriterion("address_sex <", value, "addressSex");
            return (Criteria) this;
        }

        public Criteria andAddressSexLessThanOrEqualTo(Integer value) {
            addCriterion("address_sex <=", value, "addressSex");
            return (Criteria) this;
        }

        public Criteria andAddressSexIn(List<Integer> values) {
            addCriterion("address_sex in", values, "addressSex");
            return (Criteria) this;
        }

        public Criteria andAddressSexNotIn(List<Integer> values) {
            addCriterion("address_sex not in", values, "addressSex");
            return (Criteria) this;
        }

        public Criteria andAddressSexBetween(Integer value1, Integer value2) {
            addCriterion("address_sex between", value1, value2, "addressSex");
            return (Criteria) this;
        }

        public Criteria andAddressSexNotBetween(Integer value1, Integer value2) {
            addCriterion("address_sex not between", value1, value2, "addressSex");
            return (Criteria) this;
        }

        public Criteria andAddressPhoneIsNull() {
            addCriterion("address_phone is null");
            return (Criteria) this;
        }

        public Criteria andAddressPhoneIsNotNull() {
            addCriterion("address_phone is not null");
            return (Criteria) this;
        }

        public Criteria andAddressPhoneEqualTo(String value) {
            addCriterion("address_phone =", value, "addressPhone");
            return (Criteria) this;
        }

        public Criteria andAddressPhoneNotEqualTo(String value) {
            addCriterion("address_phone <>", value, "addressPhone");
            return (Criteria) this;
        }

        public Criteria andAddressPhoneGreaterThan(String value) {
            addCriterion("address_phone >", value, "addressPhone");
            return (Criteria) this;
        }

        public Criteria andAddressPhoneGreaterThanOrEqualTo(String value) {
            addCriterion("address_phone >=", value, "addressPhone");
            return (Criteria) this;
        }

        public Criteria andAddressPhoneLessThan(String value) {
            addCriterion("address_phone <", value, "addressPhone");
            return (Criteria) this;
        }

        public Criteria andAddressPhoneLessThanOrEqualTo(String value) {
            addCriterion("address_phone <=", value, "addressPhone");
            return (Criteria) this;
        }

        public Criteria andAddressPhoneLike(String value) {
            addCriterion("address_phone like", value, "addressPhone");
            return (Criteria) this;
        }

        public Criteria andAddressPhoneNotLike(String value) {
            addCriterion("address_phone not like", value, "addressPhone");
            return (Criteria) this;
        }

        public Criteria andAddressPhoneIn(List<String> values) {
            addCriterion("address_phone in", values, "addressPhone");
            return (Criteria) this;
        }

        public Criteria andAddressPhoneNotIn(List<String> values) {
            addCriterion("address_phone not in", values, "addressPhone");
            return (Criteria) this;
        }

        public Criteria andAddressPhoneBetween(String value1, String value2) {
            addCriterion("address_phone between", value1, value2, "addressPhone");
            return (Criteria) this;
        }

        public Criteria andAddressPhoneNotBetween(String value1, String value2) {
            addCriterion("address_phone not between", value1, value2, "addressPhone");
            return (Criteria) this;
        }

        public Criteria andAddressSparePhoneIsNull() {
            addCriterion("address_spare_phone is null");
            return (Criteria) this;
        }

        public Criteria andAddressSparePhoneIsNotNull() {
            addCriterion("address_spare_phone is not null");
            return (Criteria) this;
        }

        public Criteria andAddressSparePhoneEqualTo(String value) {
            addCriterion("address_spare_phone =", value, "addressSparePhone");
            return (Criteria) this;
        }

        public Criteria andAddressSparePhoneNotEqualTo(String value) {
            addCriterion("address_spare_phone <>", value, "addressSparePhone");
            return (Criteria) this;
        }

        public Criteria andAddressSparePhoneGreaterThan(String value) {
            addCriterion("address_spare_phone >", value, "addressSparePhone");
            return (Criteria) this;
        }

        public Criteria andAddressSparePhoneGreaterThanOrEqualTo(String value) {
            addCriterion("address_spare_phone >=", value, "addressSparePhone");
            return (Criteria) this;
        }

        public Criteria andAddressSparePhoneLessThan(String value) {
            addCriterion("address_spare_phone <", value, "addressSparePhone");
            return (Criteria) this;
        }

        public Criteria andAddressSparePhoneLessThanOrEqualTo(String value) {
            addCriterion("address_spare_phone <=", value, "addressSparePhone");
            return (Criteria) this;
        }

        public Criteria andAddressSparePhoneLike(String value) {
            addCriterion("address_spare_phone like", value, "addressSparePhone");
            return (Criteria) this;
        }

        public Criteria andAddressSparePhoneNotLike(String value) {
            addCriterion("address_spare_phone not like", value, "addressSparePhone");
            return (Criteria) this;
        }

        public Criteria andAddressSparePhoneIn(List<String> values) {
            addCriterion("address_spare_phone in", values, "addressSparePhone");
            return (Criteria) this;
        }

        public Criteria andAddressSparePhoneNotIn(List<String> values) {
            addCriterion("address_spare_phone not in", values, "addressSparePhone");
            return (Criteria) this;
        }

        public Criteria andAddressSparePhoneBetween(String value1, String value2) {
            addCriterion("address_spare_phone between", value1, value2, "addressSparePhone");
            return (Criteria) this;
        }

        public Criteria andAddressSparePhoneNotBetween(String value1, String value2) {
            addCriterion("address_spare_phone not between", value1, value2, "addressSparePhone");
            return (Criteria) this;
        }

        public Criteria andAddressIsDelIsNull() {
            addCriterion("address_is_del is null");
            return (Criteria) this;
        }

        public Criteria andAddressIsDelIsNotNull() {
            addCriterion("address_is_del is not null");
            return (Criteria) this;
        }

        public Criteria andAddressIsDelEqualTo(Integer value) {
            addCriterion("address_is_del =", value, "addressIsDel");
            return (Criteria) this;
        }

        public Criteria andAddressIsDelNotEqualTo(Integer value) {
            addCriterion("address_is_del <>", value, "addressIsDel");
            return (Criteria) this;
        }

        public Criteria andAddressIsDelGreaterThan(Integer value) {
            addCriterion("address_is_del >", value, "addressIsDel");
            return (Criteria) this;
        }

        public Criteria andAddressIsDelGreaterThanOrEqualTo(Integer value) {
            addCriterion("address_is_del >=", value, "addressIsDel");
            return (Criteria) this;
        }

        public Criteria andAddressIsDelLessThan(Integer value) {
            addCriterion("address_is_del <", value, "addressIsDel");
            return (Criteria) this;
        }

        public Criteria andAddressIsDelLessThanOrEqualTo(Integer value) {
            addCriterion("address_is_del <=", value, "addressIsDel");
            return (Criteria) this;
        }

        public Criteria andAddressIsDelIn(List<Integer> values) {
            addCriterion("address_is_del in", values, "addressIsDel");
            return (Criteria) this;
        }

        public Criteria andAddressIsDelNotIn(List<Integer> values) {
            addCriterion("address_is_del not in", values, "addressIsDel");
            return (Criteria) this;
        }

        public Criteria andAddressIsDelBetween(Integer value1, Integer value2) {
            addCriterion("address_is_del between", value1, value2, "addressIsDel");
            return (Criteria) this;
        }

        public Criteria andAddressIsDelNotBetween(Integer value1, Integer value2) {
            addCriterion("address_is_del not between", value1, value2, "addressIsDel");
            return (Criteria) this;
        }

        public Criteria andAddressCreateTimeIsNull() {
            addCriterion("address_create_time is null");
            return (Criteria) this;
        }

        public Criteria andAddressCreateTimeIsNotNull() {
            addCriterion("address_create_time is not null");
            return (Criteria) this;
        }

        public Criteria andAddressCreateTimeEqualTo(Date value) {
            addCriterion("address_create_time =", value, "addressCreateTime");
            return (Criteria) this;
        }

        public Criteria andAddressCreateTimeNotEqualTo(Date value) {
            addCriterion("address_create_time <>", value, "addressCreateTime");
            return (Criteria) this;
        }

        public Criteria andAddressCreateTimeGreaterThan(Date value) {
            addCriterion("address_create_time >", value, "addressCreateTime");
            return (Criteria) this;
        }

        public Criteria andAddressCreateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("address_create_time >=", value, "addressCreateTime");
            return (Criteria) this;
        }

        public Criteria andAddressCreateTimeLessThan(Date value) {
            addCriterion("address_create_time <", value, "addressCreateTime");
            return (Criteria) this;
        }

        public Criteria andAddressCreateTimeLessThanOrEqualTo(Date value) {
            addCriterion("address_create_time <=", value, "addressCreateTime");
            return (Criteria) this;
        }

        public Criteria andAddressCreateTimeIn(List<Date> values) {
            addCriterion("address_create_time in", values, "addressCreateTime");
            return (Criteria) this;
        }

        public Criteria andAddressCreateTimeNotIn(List<Date> values) {
            addCriterion("address_create_time not in", values, "addressCreateTime");
            return (Criteria) this;
        }

        public Criteria andAddressCreateTimeBetween(Date value1, Date value2) {
            addCriterion("address_create_time between", value1, value2, "addressCreateTime");
            return (Criteria) this;
        }

        public Criteria andAddressCreateTimeNotBetween(Date value1, Date value2) {
            addCriterion("address_create_time not between", value1, value2, "addressCreateTime");
            return (Criteria) this;
        }

        public Criteria andAddressDefalutIsNull() {
            addCriterion("address_defalut is null");
            return (Criteria) this;
        }

        public Criteria andAddressDefalutIsNotNull() {
            addCriterion("address_defalut is not null");
            return (Criteria) this;
        }

        public Criteria andAddressDefalutEqualTo(Integer value) {
            addCriterion("address_defalut =", value, "addressDefalut");
            return (Criteria) this;
        }

        public Criteria andAddressDefalutNotEqualTo(Integer value) {
            addCriterion("address_defalut <>", value, "addressDefalut");
            return (Criteria) this;
        }

        public Criteria andAddressDefalutGreaterThan(Integer value) {
            addCriterion("address_defalut >", value, "addressDefalut");
            return (Criteria) this;
        }

        public Criteria andAddressDefalutGreaterThanOrEqualTo(Integer value) {
            addCriterion("address_defalut >=", value, "addressDefalut");
            return (Criteria) this;
        }

        public Criteria andAddressDefalutLessThan(Integer value) {
            addCriterion("address_defalut <", value, "addressDefalut");
            return (Criteria) this;
        }

        public Criteria andAddressDefalutLessThanOrEqualTo(Integer value) {
            addCriterion("address_defalut <=", value, "addressDefalut");
            return (Criteria) this;
        }

        public Criteria andAddressDefalutIn(List<Integer> values) {
            addCriterion("address_defalut in", values, "addressDefalut");
            return (Criteria) this;
        }

        public Criteria andAddressDefalutNotIn(List<Integer> values) {
            addCriterion("address_defalut not in", values, "addressDefalut");
            return (Criteria) this;
        }

        public Criteria andAddressDefalutBetween(Integer value1, Integer value2) {
            addCriterion("address_defalut between", value1, value2, "addressDefalut");
            return (Criteria) this;
        }

        public Criteria andAddressDefalutNotBetween(Integer value1, Integer value2) {
            addCriterion("address_defalut not between", value1, value2, "addressDefalut");
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