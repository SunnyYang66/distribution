package org.mfoyou.agent.common.dao.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class HuawuAgentStoreSettingExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    protected Integer limitStart;

    protected Integer limitEnd;

    public HuawuAgentStoreSettingExample() {
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

        public Criteria andStoreUrlIsNull() {
            addCriterion("store_url is null");
            return (Criteria) this;
        }

        public Criteria andStoreUrlIsNotNull() {
            addCriterion("store_url is not null");
            return (Criteria) this;
        }

        public Criteria andStoreUrlEqualTo(String value) {
            addCriterion("store_url =", value, "storeUrl");
            return (Criteria) this;
        }

        public Criteria andStoreUrlNotEqualTo(String value) {
            addCriterion("store_url <>", value, "storeUrl");
            return (Criteria) this;
        }

        public Criteria andStoreUrlGreaterThan(String value) {
            addCriterion("store_url >", value, "storeUrl");
            return (Criteria) this;
        }

        public Criteria andStoreUrlGreaterThanOrEqualTo(String value) {
            addCriterion("store_url >=", value, "storeUrl");
            return (Criteria) this;
        }

        public Criteria andStoreUrlLessThan(String value) {
            addCriterion("store_url <", value, "storeUrl");
            return (Criteria) this;
        }

        public Criteria andStoreUrlLessThanOrEqualTo(String value) {
            addCriterion("store_url <=", value, "storeUrl");
            return (Criteria) this;
        }

        public Criteria andStoreUrlLike(String value) {
            addCriterion("store_url like", value, "storeUrl");
            return (Criteria) this;
        }

        public Criteria andStoreUrlNotLike(String value) {
            addCriterion("store_url not like", value, "storeUrl");
            return (Criteria) this;
        }

        public Criteria andStoreUrlIn(List<String> values) {
            addCriterion("store_url in", values, "storeUrl");
            return (Criteria) this;
        }

        public Criteria andStoreUrlNotIn(List<String> values) {
            addCriterion("store_url not in", values, "storeUrl");
            return (Criteria) this;
        }

        public Criteria andStoreUrlBetween(String value1, String value2) {
            addCriterion("store_url between", value1, value2, "storeUrl");
            return (Criteria) this;
        }

        public Criteria andStoreUrlNotBetween(String value1, String value2) {
            addCriterion("store_url not between", value1, value2, "storeUrl");
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

        public Criteria andStoreLogoUrlIsNull() {
            addCriterion("store_logo_url is null");
            return (Criteria) this;
        }

        public Criteria andStoreLogoUrlIsNotNull() {
            addCriterion("store_logo_url is not null");
            return (Criteria) this;
        }

        public Criteria andStoreLogoUrlEqualTo(String value) {
            addCriterion("store_logo_url =", value, "storeLogoUrl");
            return (Criteria) this;
        }

        public Criteria andStoreLogoUrlNotEqualTo(String value) {
            addCriterion("store_logo_url <>", value, "storeLogoUrl");
            return (Criteria) this;
        }

        public Criteria andStoreLogoUrlGreaterThan(String value) {
            addCriterion("store_logo_url >", value, "storeLogoUrl");
            return (Criteria) this;
        }

        public Criteria andStoreLogoUrlGreaterThanOrEqualTo(String value) {
            addCriterion("store_logo_url >=", value, "storeLogoUrl");
            return (Criteria) this;
        }

        public Criteria andStoreLogoUrlLessThan(String value) {
            addCriterion("store_logo_url <", value, "storeLogoUrl");
            return (Criteria) this;
        }

        public Criteria andStoreLogoUrlLessThanOrEqualTo(String value) {
            addCriterion("store_logo_url <=", value, "storeLogoUrl");
            return (Criteria) this;
        }

        public Criteria andStoreLogoUrlLike(String value) {
            addCriterion("store_logo_url like", value, "storeLogoUrl");
            return (Criteria) this;
        }

        public Criteria andStoreLogoUrlNotLike(String value) {
            addCriterion("store_logo_url not like", value, "storeLogoUrl");
            return (Criteria) this;
        }

        public Criteria andStoreLogoUrlIn(List<String> values) {
            addCriterion("store_logo_url in", values, "storeLogoUrl");
            return (Criteria) this;
        }

        public Criteria andStoreLogoUrlNotIn(List<String> values) {
            addCriterion("store_logo_url not in", values, "storeLogoUrl");
            return (Criteria) this;
        }

        public Criteria andStoreLogoUrlBetween(String value1, String value2) {
            addCriterion("store_logo_url between", value1, value2, "storeLogoUrl");
            return (Criteria) this;
        }

        public Criteria andStoreLogoUrlNotBetween(String value1, String value2) {
            addCriterion("store_logo_url not between", value1, value2, "storeLogoUrl");
            return (Criteria) this;
        }

        public Criteria andStoreModelTypeIsNull() {
            addCriterion("store_model_type is null");
            return (Criteria) this;
        }

        public Criteria andStoreModelTypeIsNotNull() {
            addCriterion("store_model_type is not null");
            return (Criteria) this;
        }

        public Criteria andStoreModelTypeEqualTo(Integer value) {
            addCriterion("store_model_type =", value, "storeModelType");
            return (Criteria) this;
        }

        public Criteria andStoreModelTypeNotEqualTo(Integer value) {
            addCriterion("store_model_type <>", value, "storeModelType");
            return (Criteria) this;
        }

        public Criteria andStoreModelTypeGreaterThan(Integer value) {
            addCriterion("store_model_type >", value, "storeModelType");
            return (Criteria) this;
        }

        public Criteria andStoreModelTypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("store_model_type >=", value, "storeModelType");
            return (Criteria) this;
        }

        public Criteria andStoreModelTypeLessThan(Integer value) {
            addCriterion("store_model_type <", value, "storeModelType");
            return (Criteria) this;
        }

        public Criteria andStoreModelTypeLessThanOrEqualTo(Integer value) {
            addCriterion("store_model_type <=", value, "storeModelType");
            return (Criteria) this;
        }

        public Criteria andStoreModelTypeIn(List<Integer> values) {
            addCriterion("store_model_type in", values, "storeModelType");
            return (Criteria) this;
        }

        public Criteria andStoreModelTypeNotIn(List<Integer> values) {
            addCriterion("store_model_type not in", values, "storeModelType");
            return (Criteria) this;
        }

        public Criteria andStoreModelTypeBetween(Integer value1, Integer value2) {
            addCriterion("store_model_type between", value1, value2, "storeModelType");
            return (Criteria) this;
        }

        public Criteria andStoreModelTypeNotBetween(Integer value1, Integer value2) {
            addCriterion("store_model_type not between", value1, value2, "storeModelType");
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

        public Criteria andServiceUrlIsNull() {
            addCriterion("service_url is null");
            return (Criteria) this;
        }

        public Criteria andServiceUrlIsNotNull() {
            addCriterion("service_url is not null");
            return (Criteria) this;
        }

        public Criteria andServiceUrlEqualTo(String value) {
            addCriterion("service_url =", value, "serviceUrl");
            return (Criteria) this;
        }

        public Criteria andServiceUrlNotEqualTo(String value) {
            addCriterion("service_url <>", value, "serviceUrl");
            return (Criteria) this;
        }

        public Criteria andServiceUrlGreaterThan(String value) {
            addCriterion("service_url >", value, "serviceUrl");
            return (Criteria) this;
        }

        public Criteria andServiceUrlGreaterThanOrEqualTo(String value) {
            addCriterion("service_url >=", value, "serviceUrl");
            return (Criteria) this;
        }

        public Criteria andServiceUrlLessThan(String value) {
            addCriterion("service_url <", value, "serviceUrl");
            return (Criteria) this;
        }

        public Criteria andServiceUrlLessThanOrEqualTo(String value) {
            addCriterion("service_url <=", value, "serviceUrl");
            return (Criteria) this;
        }

        public Criteria andServiceUrlLike(String value) {
            addCriterion("service_url like", value, "serviceUrl");
            return (Criteria) this;
        }

        public Criteria andServiceUrlNotLike(String value) {
            addCriterion("service_url not like", value, "serviceUrl");
            return (Criteria) this;
        }

        public Criteria andServiceUrlIn(List<String> values) {
            addCriterion("service_url in", values, "serviceUrl");
            return (Criteria) this;
        }

        public Criteria andServiceUrlNotIn(List<String> values) {
            addCriterion("service_url not in", values, "serviceUrl");
            return (Criteria) this;
        }

        public Criteria andServiceUrlBetween(String value1, String value2) {
            addCriterion("service_url between", value1, value2, "serviceUrl");
            return (Criteria) this;
        }

        public Criteria andServiceUrlNotBetween(String value1, String value2) {
            addCriterion("service_url not between", value1, value2, "serviceUrl");
            return (Criteria) this;
        }

        public Criteria andServiceNameIsNull() {
            addCriterion("service_name is null");
            return (Criteria) this;
        }

        public Criteria andServiceNameIsNotNull() {
            addCriterion("service_name is not null");
            return (Criteria) this;
        }

        public Criteria andServiceNameEqualTo(String value) {
            addCriterion("service_name =", value, "serviceName");
            return (Criteria) this;
        }

        public Criteria andServiceNameNotEqualTo(String value) {
            addCriterion("service_name <>", value, "serviceName");
            return (Criteria) this;
        }

        public Criteria andServiceNameGreaterThan(String value) {
            addCriterion("service_name >", value, "serviceName");
            return (Criteria) this;
        }

        public Criteria andServiceNameGreaterThanOrEqualTo(String value) {
            addCriterion("service_name >=", value, "serviceName");
            return (Criteria) this;
        }

        public Criteria andServiceNameLessThan(String value) {
            addCriterion("service_name <", value, "serviceName");
            return (Criteria) this;
        }

        public Criteria andServiceNameLessThanOrEqualTo(String value) {
            addCriterion("service_name <=", value, "serviceName");
            return (Criteria) this;
        }

        public Criteria andServiceNameLike(String value) {
            addCriterion("service_name like", value, "serviceName");
            return (Criteria) this;
        }

        public Criteria andServiceNameNotLike(String value) {
            addCriterion("service_name not like", value, "serviceName");
            return (Criteria) this;
        }

        public Criteria andServiceNameIn(List<String> values) {
            addCriterion("service_name in", values, "serviceName");
            return (Criteria) this;
        }

        public Criteria andServiceNameNotIn(List<String> values) {
            addCriterion("service_name not in", values, "serviceName");
            return (Criteria) this;
        }

        public Criteria andServiceNameBetween(String value1, String value2) {
            addCriterion("service_name between", value1, value2, "serviceName");
            return (Criteria) this;
        }

        public Criteria andServiceNameNotBetween(String value1, String value2) {
            addCriterion("service_name not between", value1, value2, "serviceName");
            return (Criteria) this;
        }

        public Criteria andServiceLogoIsNull() {
            addCriterion("service_logo is null");
            return (Criteria) this;
        }

        public Criteria andServiceLogoIsNotNull() {
            addCriterion("service_logo is not null");
            return (Criteria) this;
        }

        public Criteria andServiceLogoEqualTo(String value) {
            addCriterion("service_logo =", value, "serviceLogo");
            return (Criteria) this;
        }

        public Criteria andServiceLogoNotEqualTo(String value) {
            addCriterion("service_logo <>", value, "serviceLogo");
            return (Criteria) this;
        }

        public Criteria andServiceLogoGreaterThan(String value) {
            addCriterion("service_logo >", value, "serviceLogo");
            return (Criteria) this;
        }

        public Criteria andServiceLogoGreaterThanOrEqualTo(String value) {
            addCriterion("service_logo >=", value, "serviceLogo");
            return (Criteria) this;
        }

        public Criteria andServiceLogoLessThan(String value) {
            addCriterion("service_logo <", value, "serviceLogo");
            return (Criteria) this;
        }

        public Criteria andServiceLogoLessThanOrEqualTo(String value) {
            addCriterion("service_logo <=", value, "serviceLogo");
            return (Criteria) this;
        }

        public Criteria andServiceLogoLike(String value) {
            addCriterion("service_logo like", value, "serviceLogo");
            return (Criteria) this;
        }

        public Criteria andServiceLogoNotLike(String value) {
            addCriterion("service_logo not like", value, "serviceLogo");
            return (Criteria) this;
        }

        public Criteria andServiceLogoIn(List<String> values) {
            addCriterion("service_logo in", values, "serviceLogo");
            return (Criteria) this;
        }

        public Criteria andServiceLogoNotIn(List<String> values) {
            addCriterion("service_logo not in", values, "serviceLogo");
            return (Criteria) this;
        }

        public Criteria andServiceLogoBetween(String value1, String value2) {
            addCriterion("service_logo between", value1, value2, "serviceLogo");
            return (Criteria) this;
        }

        public Criteria andServiceLogoNotBetween(String value1, String value2) {
            addCriterion("service_logo not between", value1, value2, "serviceLogo");
            return (Criteria) this;
        }

        public Criteria andPhoneIsNull() {
            addCriterion("phone is null");
            return (Criteria) this;
        }

        public Criteria andPhoneIsNotNull() {
            addCriterion("phone is not null");
            return (Criteria) this;
        }

        public Criteria andPhoneEqualTo(String value) {
            addCriterion("phone =", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneNotEqualTo(String value) {
            addCriterion("phone <>", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneGreaterThan(String value) {
            addCriterion("phone >", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneGreaterThanOrEqualTo(String value) {
            addCriterion("phone >=", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneLessThan(String value) {
            addCriterion("phone <", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneLessThanOrEqualTo(String value) {
            addCriterion("phone <=", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneLike(String value) {
            addCriterion("phone like", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneNotLike(String value) {
            addCriterion("phone not like", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneIn(List<String> values) {
            addCriterion("phone in", values, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneNotIn(List<String> values) {
            addCriterion("phone not in", values, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneBetween(String value1, String value2) {
            addCriterion("phone between", value1, value2, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneNotBetween(String value1, String value2) {
            addCriterion("phone not between", value1, value2, "phone");
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