package org.mfoyou.agent.common.dao.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class HuawuWalletLogExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    protected Integer limitStart;

    protected Integer limitEnd;

    public HuawuWalletLogExample() {
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

        public Criteria andWalletLogIdIsNull() {
            addCriterion("wallet_log_id is null");
            return (Criteria) this;
        }

        public Criteria andWalletLogIdIsNotNull() {
            addCriterion("wallet_log_id is not null");
            return (Criteria) this;
        }

        public Criteria andWalletLogIdEqualTo(Integer value) {
            addCriterion("wallet_log_id =", value, "walletLogId");
            return (Criteria) this;
        }

        public Criteria andWalletLogIdNotEqualTo(Integer value) {
            addCriterion("wallet_log_id <>", value, "walletLogId");
            return (Criteria) this;
        }

        public Criteria andWalletLogIdGreaterThan(Integer value) {
            addCriterion("wallet_log_id >", value, "walletLogId");
            return (Criteria) this;
        }

        public Criteria andWalletLogIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("wallet_log_id >=", value, "walletLogId");
            return (Criteria) this;
        }

        public Criteria andWalletLogIdLessThan(Integer value) {
            addCriterion("wallet_log_id <", value, "walletLogId");
            return (Criteria) this;
        }

        public Criteria andWalletLogIdLessThanOrEqualTo(Integer value) {
            addCriterion("wallet_log_id <=", value, "walletLogId");
            return (Criteria) this;
        }

        public Criteria andWalletLogIdIn(List<Integer> values) {
            addCriterion("wallet_log_id in", values, "walletLogId");
            return (Criteria) this;
        }

        public Criteria andWalletLogIdNotIn(List<Integer> values) {
            addCriterion("wallet_log_id not in", values, "walletLogId");
            return (Criteria) this;
        }

        public Criteria andWalletLogIdBetween(Integer value1, Integer value2) {
            addCriterion("wallet_log_id between", value1, value2, "walletLogId");
            return (Criteria) this;
        }

        public Criteria andWalletLogIdNotBetween(Integer value1, Integer value2) {
            addCriterion("wallet_log_id not between", value1, value2, "walletLogId");
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

        public Criteria andUserRoleTypeIsNull() {
            addCriterion("user_role_type is null");
            return (Criteria) this;
        }

        public Criteria andUserRoleTypeIsNotNull() {
            addCriterion("user_role_type is not null");
            return (Criteria) this;
        }

        public Criteria andUserRoleTypeEqualTo(Integer value) {
            addCriterion("user_role_type =", value, "userRoleType");
            return (Criteria) this;
        }

        public Criteria andUserRoleTypeNotEqualTo(Integer value) {
            addCriterion("user_role_type <>", value, "userRoleType");
            return (Criteria) this;
        }

        public Criteria andUserRoleTypeGreaterThan(Integer value) {
            addCriterion("user_role_type >", value, "userRoleType");
            return (Criteria) this;
        }

        public Criteria andUserRoleTypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("user_role_type >=", value, "userRoleType");
            return (Criteria) this;
        }

        public Criteria andUserRoleTypeLessThan(Integer value) {
            addCriterion("user_role_type <", value, "userRoleType");
            return (Criteria) this;
        }

        public Criteria andUserRoleTypeLessThanOrEqualTo(Integer value) {
            addCriterion("user_role_type <=", value, "userRoleType");
            return (Criteria) this;
        }

        public Criteria andUserRoleTypeIn(List<Integer> values) {
            addCriterion("user_role_type in", values, "userRoleType");
            return (Criteria) this;
        }

        public Criteria andUserRoleTypeNotIn(List<Integer> values) {
            addCriterion("user_role_type not in", values, "userRoleType");
            return (Criteria) this;
        }

        public Criteria andUserRoleTypeBetween(Integer value1, Integer value2) {
            addCriterion("user_role_type between", value1, value2, "userRoleType");
            return (Criteria) this;
        }

        public Criteria andUserRoleTypeNotBetween(Integer value1, Integer value2) {
            addCriterion("user_role_type not between", value1, value2, "userRoleType");
            return (Criteria) this;
        }

        public Criteria andWalletLogDirectionIsNull() {
            addCriterion("wallet_log_direction is null");
            return (Criteria) this;
        }

        public Criteria andWalletLogDirectionIsNotNull() {
            addCriterion("wallet_log_direction is not null");
            return (Criteria) this;
        }

        public Criteria andWalletLogDirectionEqualTo(Integer value) {
            addCriterion("wallet_log_direction =", value, "walletLogDirection");
            return (Criteria) this;
        }

        public Criteria andWalletLogDirectionNotEqualTo(Integer value) {
            addCriterion("wallet_log_direction <>", value, "walletLogDirection");
            return (Criteria) this;
        }

        public Criteria andWalletLogDirectionGreaterThan(Integer value) {
            addCriterion("wallet_log_direction >", value, "walletLogDirection");
            return (Criteria) this;
        }

        public Criteria andWalletLogDirectionGreaterThanOrEqualTo(Integer value) {
            addCriterion("wallet_log_direction >=", value, "walletLogDirection");
            return (Criteria) this;
        }

        public Criteria andWalletLogDirectionLessThan(Integer value) {
            addCriterion("wallet_log_direction <", value, "walletLogDirection");
            return (Criteria) this;
        }

        public Criteria andWalletLogDirectionLessThanOrEqualTo(Integer value) {
            addCriterion("wallet_log_direction <=", value, "walletLogDirection");
            return (Criteria) this;
        }

        public Criteria andWalletLogDirectionIn(List<Integer> values) {
            addCriterion("wallet_log_direction in", values, "walletLogDirection");
            return (Criteria) this;
        }

        public Criteria andWalletLogDirectionNotIn(List<Integer> values) {
            addCriterion("wallet_log_direction not in", values, "walletLogDirection");
            return (Criteria) this;
        }

        public Criteria andWalletLogDirectionBetween(Integer value1, Integer value2) {
            addCriterion("wallet_log_direction between", value1, value2, "walletLogDirection");
            return (Criteria) this;
        }

        public Criteria andWalletLogDirectionNotBetween(Integer value1, Integer value2) {
            addCriterion("wallet_log_direction not between", value1, value2, "walletLogDirection");
            return (Criteria) this;
        }

        public Criteria andWalletLogAmountIsNull() {
            addCriterion("wallet_log_amount is null");
            return (Criteria) this;
        }

        public Criteria andWalletLogAmountIsNotNull() {
            addCriterion("wallet_log_amount is not null");
            return (Criteria) this;
        }

        public Criteria andWalletLogAmountEqualTo(Integer value) {
            addCriterion("wallet_log_amount =", value, "walletLogAmount");
            return (Criteria) this;
        }

        public Criteria andWalletLogAmountNotEqualTo(Integer value) {
            addCriterion("wallet_log_amount <>", value, "walletLogAmount");
            return (Criteria) this;
        }

        public Criteria andWalletLogAmountGreaterThan(Integer value) {
            addCriterion("wallet_log_amount >", value, "walletLogAmount");
            return (Criteria) this;
        }

        public Criteria andWalletLogAmountGreaterThanOrEqualTo(Integer value) {
            addCriterion("wallet_log_amount >=", value, "walletLogAmount");
            return (Criteria) this;
        }

        public Criteria andWalletLogAmountLessThan(Integer value) {
            addCriterion("wallet_log_amount <", value, "walletLogAmount");
            return (Criteria) this;
        }

        public Criteria andWalletLogAmountLessThanOrEqualTo(Integer value) {
            addCriterion("wallet_log_amount <=", value, "walletLogAmount");
            return (Criteria) this;
        }

        public Criteria andWalletLogAmountIn(List<Integer> values) {
            addCriterion("wallet_log_amount in", values, "walletLogAmount");
            return (Criteria) this;
        }

        public Criteria andWalletLogAmountNotIn(List<Integer> values) {
            addCriterion("wallet_log_amount not in", values, "walletLogAmount");
            return (Criteria) this;
        }

        public Criteria andWalletLogAmountBetween(Integer value1, Integer value2) {
            addCriterion("wallet_log_amount between", value1, value2, "walletLogAmount");
            return (Criteria) this;
        }

        public Criteria andWalletLogAmountNotBetween(Integer value1, Integer value2) {
            addCriterion("wallet_log_amount not between", value1, value2, "walletLogAmount");
            return (Criteria) this;
        }

        public Criteria andWalletLogTimeIsNull() {
            addCriterion("wallet_log_time is null");
            return (Criteria) this;
        }

        public Criteria andWalletLogTimeIsNotNull() {
            addCriterion("wallet_log_time is not null");
            return (Criteria) this;
        }

        public Criteria andWalletLogTimeEqualTo(Date value) {
            addCriterion("wallet_log_time =", value, "walletLogTime");
            return (Criteria) this;
        }

        public Criteria andWalletLogTimeNotEqualTo(Date value) {
            addCriterion("wallet_log_time <>", value, "walletLogTime");
            return (Criteria) this;
        }

        public Criteria andWalletLogTimeGreaterThan(Date value) {
            addCriterion("wallet_log_time >", value, "walletLogTime");
            return (Criteria) this;
        }

        public Criteria andWalletLogTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("wallet_log_time >=", value, "walletLogTime");
            return (Criteria) this;
        }

        public Criteria andWalletLogTimeLessThan(Date value) {
            addCriterion("wallet_log_time <", value, "walletLogTime");
            return (Criteria) this;
        }

        public Criteria andWalletLogTimeLessThanOrEqualTo(Date value) {
            addCriterion("wallet_log_time <=", value, "walletLogTime");
            return (Criteria) this;
        }

        public Criteria andWalletLogTimeIn(List<Date> values) {
            addCriterion("wallet_log_time in", values, "walletLogTime");
            return (Criteria) this;
        }

        public Criteria andWalletLogTimeNotIn(List<Date> values) {
            addCriterion("wallet_log_time not in", values, "walletLogTime");
            return (Criteria) this;
        }

        public Criteria andWalletLogTimeBetween(Date value1, Date value2) {
            addCriterion("wallet_log_time between", value1, value2, "walletLogTime");
            return (Criteria) this;
        }

        public Criteria andWalletLogTimeNotBetween(Date value1, Date value2) {
            addCriterion("wallet_log_time not between", value1, value2, "walletLogTime");
            return (Criteria) this;
        }

        public Criteria andWalletLogAgentIdIsNull() {
            addCriterion("wallet_log_agent_id is null");
            return (Criteria) this;
        }

        public Criteria andWalletLogAgentIdIsNotNull() {
            addCriterion("wallet_log_agent_id is not null");
            return (Criteria) this;
        }

        public Criteria andWalletLogAgentIdEqualTo(Integer value) {
            addCriterion("wallet_log_agent_id =", value, "walletLogAgentId");
            return (Criteria) this;
        }

        public Criteria andWalletLogAgentIdNotEqualTo(Integer value) {
            addCriterion("wallet_log_agent_id <>", value, "walletLogAgentId");
            return (Criteria) this;
        }

        public Criteria andWalletLogAgentIdGreaterThan(Integer value) {
            addCriterion("wallet_log_agent_id >", value, "walletLogAgentId");
            return (Criteria) this;
        }

        public Criteria andWalletLogAgentIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("wallet_log_agent_id >=", value, "walletLogAgentId");
            return (Criteria) this;
        }

        public Criteria andWalletLogAgentIdLessThan(Integer value) {
            addCriterion("wallet_log_agent_id <", value, "walletLogAgentId");
            return (Criteria) this;
        }

        public Criteria andWalletLogAgentIdLessThanOrEqualTo(Integer value) {
            addCriterion("wallet_log_agent_id <=", value, "walletLogAgentId");
            return (Criteria) this;
        }

        public Criteria andWalletLogAgentIdIn(List<Integer> values) {
            addCriterion("wallet_log_agent_id in", values, "walletLogAgentId");
            return (Criteria) this;
        }

        public Criteria andWalletLogAgentIdNotIn(List<Integer> values) {
            addCriterion("wallet_log_agent_id not in", values, "walletLogAgentId");
            return (Criteria) this;
        }

        public Criteria andWalletLogAgentIdBetween(Integer value1, Integer value2) {
            addCriterion("wallet_log_agent_id between", value1, value2, "walletLogAgentId");
            return (Criteria) this;
        }

        public Criteria andWalletLogAgentIdNotBetween(Integer value1, Integer value2) {
            addCriterion("wallet_log_agent_id not between", value1, value2, "walletLogAgentId");
            return (Criteria) this;
        }

        public Criteria andWalletLogTypeIsNull() {
            addCriterion("wallet_log_type is null");
            return (Criteria) this;
        }

        public Criteria andWalletLogTypeIsNotNull() {
            addCriterion("wallet_log_type is not null");
            return (Criteria) this;
        }

        public Criteria andWalletLogTypeEqualTo(Integer value) {
            addCriterion("wallet_log_type =", value, "walletLogType");
            return (Criteria) this;
        }

        public Criteria andWalletLogTypeNotEqualTo(Integer value) {
            addCriterion("wallet_log_type <>", value, "walletLogType");
            return (Criteria) this;
        }

        public Criteria andWalletLogTypeGreaterThan(Integer value) {
            addCriterion("wallet_log_type >", value, "walletLogType");
            return (Criteria) this;
        }

        public Criteria andWalletLogTypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("wallet_log_type >=", value, "walletLogType");
            return (Criteria) this;
        }

        public Criteria andWalletLogTypeLessThan(Integer value) {
            addCriterion("wallet_log_type <", value, "walletLogType");
            return (Criteria) this;
        }

        public Criteria andWalletLogTypeLessThanOrEqualTo(Integer value) {
            addCriterion("wallet_log_type <=", value, "walletLogType");
            return (Criteria) this;
        }

        public Criteria andWalletLogTypeIn(List<Integer> values) {
            addCriterion("wallet_log_type in", values, "walletLogType");
            return (Criteria) this;
        }

        public Criteria andWalletLogTypeNotIn(List<Integer> values) {
            addCriterion("wallet_log_type not in", values, "walletLogType");
            return (Criteria) this;
        }

        public Criteria andWalletLogTypeBetween(Integer value1, Integer value2) {
            addCriterion("wallet_log_type between", value1, value2, "walletLogType");
            return (Criteria) this;
        }

        public Criteria andWalletLogTypeNotBetween(Integer value1, Integer value2) {
            addCriterion("wallet_log_type not between", value1, value2, "walletLogType");
            return (Criteria) this;
        }

        public Criteria andWalletLogOrderIdIsNull() {
            addCriterion("wallet_log_order_id is null");
            return (Criteria) this;
        }

        public Criteria andWalletLogOrderIdIsNotNull() {
            addCriterion("wallet_log_order_id is not null");
            return (Criteria) this;
        }

        public Criteria andWalletLogOrderIdEqualTo(String value) {
            addCriterion("wallet_log_order_id =", value, "walletLogOrderId");
            return (Criteria) this;
        }

        public Criteria andWalletLogOrderIdNotEqualTo(String value) {
            addCriterion("wallet_log_order_id <>", value, "walletLogOrderId");
            return (Criteria) this;
        }

        public Criteria andWalletLogOrderIdGreaterThan(String value) {
            addCriterion("wallet_log_order_id >", value, "walletLogOrderId");
            return (Criteria) this;
        }

        public Criteria andWalletLogOrderIdGreaterThanOrEqualTo(String value) {
            addCriterion("wallet_log_order_id >=", value, "walletLogOrderId");
            return (Criteria) this;
        }

        public Criteria andWalletLogOrderIdLessThan(String value) {
            addCriterion("wallet_log_order_id <", value, "walletLogOrderId");
            return (Criteria) this;
        }

        public Criteria andWalletLogOrderIdLessThanOrEqualTo(String value) {
            addCriterion("wallet_log_order_id <=", value, "walletLogOrderId");
            return (Criteria) this;
        }

        public Criteria andWalletLogOrderIdLike(String value) {
            addCriterion("wallet_log_order_id like", value, "walletLogOrderId");
            return (Criteria) this;
        }

        public Criteria andWalletLogOrderIdNotLike(String value) {
            addCriterion("wallet_log_order_id not like", value, "walletLogOrderId");
            return (Criteria) this;
        }

        public Criteria andWalletLogOrderIdIn(List<String> values) {
            addCriterion("wallet_log_order_id in", values, "walletLogOrderId");
            return (Criteria) this;
        }

        public Criteria andWalletLogOrderIdNotIn(List<String> values) {
            addCriterion("wallet_log_order_id not in", values, "walletLogOrderId");
            return (Criteria) this;
        }

        public Criteria andWalletLogOrderIdBetween(String value1, String value2) {
            addCriterion("wallet_log_order_id between", value1, value2, "walletLogOrderId");
            return (Criteria) this;
        }

        public Criteria andWalletLogOrderIdNotBetween(String value1, String value2) {
            addCriterion("wallet_log_order_id not between", value1, value2, "walletLogOrderId");
            return (Criteria) this;
        }

        public Criteria andWalletLogOpItemIsNull() {
            addCriterion("wallet_log_op_item is null");
            return (Criteria) this;
        }

        public Criteria andWalletLogOpItemIsNotNull() {
            addCriterion("wallet_log_op_item is not null");
            return (Criteria) this;
        }

        public Criteria andWalletLogOpItemEqualTo(String value) {
            addCriterion("wallet_log_op_item =", value, "walletLogOpItem");
            return (Criteria) this;
        }

        public Criteria andWalletLogOpItemNotEqualTo(String value) {
            addCriterion("wallet_log_op_item <>", value, "walletLogOpItem");
            return (Criteria) this;
        }

        public Criteria andWalletLogOpItemGreaterThan(String value) {
            addCriterion("wallet_log_op_item >", value, "walletLogOpItem");
            return (Criteria) this;
        }

        public Criteria andWalletLogOpItemGreaterThanOrEqualTo(String value) {
            addCriterion("wallet_log_op_item >=", value, "walletLogOpItem");
            return (Criteria) this;
        }

        public Criteria andWalletLogOpItemLessThan(String value) {
            addCriterion("wallet_log_op_item <", value, "walletLogOpItem");
            return (Criteria) this;
        }

        public Criteria andWalletLogOpItemLessThanOrEqualTo(String value) {
            addCriterion("wallet_log_op_item <=", value, "walletLogOpItem");
            return (Criteria) this;
        }

        public Criteria andWalletLogOpItemLike(String value) {
            addCriterion("wallet_log_op_item like", value, "walletLogOpItem");
            return (Criteria) this;
        }

        public Criteria andWalletLogOpItemNotLike(String value) {
            addCriterion("wallet_log_op_item not like", value, "walletLogOpItem");
            return (Criteria) this;
        }

        public Criteria andWalletLogOpItemIn(List<String> values) {
            addCriterion("wallet_log_op_item in", values, "walletLogOpItem");
            return (Criteria) this;
        }

        public Criteria andWalletLogOpItemNotIn(List<String> values) {
            addCriterion("wallet_log_op_item not in", values, "walletLogOpItem");
            return (Criteria) this;
        }

        public Criteria andWalletLogOpItemBetween(String value1, String value2) {
            addCriterion("wallet_log_op_item between", value1, value2, "walletLogOpItem");
            return (Criteria) this;
        }

        public Criteria andWalletLogOpItemNotBetween(String value1, String value2) {
            addCriterion("wallet_log_op_item not between", value1, value2, "walletLogOpItem");
            return (Criteria) this;
        }

        public Criteria andWalletLogOldValueIsNull() {
            addCriterion("wallet_log_old_value is null");
            return (Criteria) this;
        }

        public Criteria andWalletLogOldValueIsNotNull() {
            addCriterion("wallet_log_old_value is not null");
            return (Criteria) this;
        }

        public Criteria andWalletLogOldValueEqualTo(Integer value) {
            addCriterion("wallet_log_old_value =", value, "walletLogOldValue");
            return (Criteria) this;
        }

        public Criteria andWalletLogOldValueNotEqualTo(Integer value) {
            addCriterion("wallet_log_old_value <>", value, "walletLogOldValue");
            return (Criteria) this;
        }

        public Criteria andWalletLogOldValueGreaterThan(Integer value) {
            addCriterion("wallet_log_old_value >", value, "walletLogOldValue");
            return (Criteria) this;
        }

        public Criteria andWalletLogOldValueGreaterThanOrEqualTo(Integer value) {
            addCriterion("wallet_log_old_value >=", value, "walletLogOldValue");
            return (Criteria) this;
        }

        public Criteria andWalletLogOldValueLessThan(Integer value) {
            addCriterion("wallet_log_old_value <", value, "walletLogOldValue");
            return (Criteria) this;
        }

        public Criteria andWalletLogOldValueLessThanOrEqualTo(Integer value) {
            addCriterion("wallet_log_old_value <=", value, "walletLogOldValue");
            return (Criteria) this;
        }

        public Criteria andWalletLogOldValueIn(List<Integer> values) {
            addCriterion("wallet_log_old_value in", values, "walletLogOldValue");
            return (Criteria) this;
        }

        public Criteria andWalletLogOldValueNotIn(List<Integer> values) {
            addCriterion("wallet_log_old_value not in", values, "walletLogOldValue");
            return (Criteria) this;
        }

        public Criteria andWalletLogOldValueBetween(Integer value1, Integer value2) {
            addCriterion("wallet_log_old_value between", value1, value2, "walletLogOldValue");
            return (Criteria) this;
        }

        public Criteria andWalletLogOldValueNotBetween(Integer value1, Integer value2) {
            addCriterion("wallet_log_old_value not between", value1, value2, "walletLogOldValue");
            return (Criteria) this;
        }

        public Criteria andWalletLogNewValueIsNull() {
            addCriterion("wallet_log_new_value is null");
            return (Criteria) this;
        }

        public Criteria andWalletLogNewValueIsNotNull() {
            addCriterion("wallet_log_new_value is not null");
            return (Criteria) this;
        }

        public Criteria andWalletLogNewValueEqualTo(Integer value) {
            addCriterion("wallet_log_new_value =", value, "walletLogNewValue");
            return (Criteria) this;
        }

        public Criteria andWalletLogNewValueNotEqualTo(Integer value) {
            addCriterion("wallet_log_new_value <>", value, "walletLogNewValue");
            return (Criteria) this;
        }

        public Criteria andWalletLogNewValueGreaterThan(Integer value) {
            addCriterion("wallet_log_new_value >", value, "walletLogNewValue");
            return (Criteria) this;
        }

        public Criteria andWalletLogNewValueGreaterThanOrEqualTo(Integer value) {
            addCriterion("wallet_log_new_value >=", value, "walletLogNewValue");
            return (Criteria) this;
        }

        public Criteria andWalletLogNewValueLessThan(Integer value) {
            addCriterion("wallet_log_new_value <", value, "walletLogNewValue");
            return (Criteria) this;
        }

        public Criteria andWalletLogNewValueLessThanOrEqualTo(Integer value) {
            addCriterion("wallet_log_new_value <=", value, "walletLogNewValue");
            return (Criteria) this;
        }

        public Criteria andWalletLogNewValueIn(List<Integer> values) {
            addCriterion("wallet_log_new_value in", values, "walletLogNewValue");
            return (Criteria) this;
        }

        public Criteria andWalletLogNewValueNotIn(List<Integer> values) {
            addCriterion("wallet_log_new_value not in", values, "walletLogNewValue");
            return (Criteria) this;
        }

        public Criteria andWalletLogNewValueBetween(Integer value1, Integer value2) {
            addCriterion("wallet_log_new_value between", value1, value2, "walletLogNewValue");
            return (Criteria) this;
        }

        public Criteria andWalletLogNewValueNotBetween(Integer value1, Integer value2) {
            addCriterion("wallet_log_new_value not between", value1, value2, "walletLogNewValue");
            return (Criteria) this;
        }

        public Criteria andWalletLogResultIsNull() {
            addCriterion("wallet_log_result is null");
            return (Criteria) this;
        }

        public Criteria andWalletLogResultIsNotNull() {
            addCriterion("wallet_log_result is not null");
            return (Criteria) this;
        }

        public Criteria andWalletLogResultEqualTo(Integer value) {
            addCriterion("wallet_log_result =", value, "walletLogResult");
            return (Criteria) this;
        }

        public Criteria andWalletLogResultNotEqualTo(Integer value) {
            addCriterion("wallet_log_result <>", value, "walletLogResult");
            return (Criteria) this;
        }

        public Criteria andWalletLogResultGreaterThan(Integer value) {
            addCriterion("wallet_log_result >", value, "walletLogResult");
            return (Criteria) this;
        }

        public Criteria andWalletLogResultGreaterThanOrEqualTo(Integer value) {
            addCriterion("wallet_log_result >=", value, "walletLogResult");
            return (Criteria) this;
        }

        public Criteria andWalletLogResultLessThan(Integer value) {
            addCriterion("wallet_log_result <", value, "walletLogResult");
            return (Criteria) this;
        }

        public Criteria andWalletLogResultLessThanOrEqualTo(Integer value) {
            addCriterion("wallet_log_result <=", value, "walletLogResult");
            return (Criteria) this;
        }

        public Criteria andWalletLogResultIn(List<Integer> values) {
            addCriterion("wallet_log_result in", values, "walletLogResult");
            return (Criteria) this;
        }

        public Criteria andWalletLogResultNotIn(List<Integer> values) {
            addCriterion("wallet_log_result not in", values, "walletLogResult");
            return (Criteria) this;
        }

        public Criteria andWalletLogResultBetween(Integer value1, Integer value2) {
            addCriterion("wallet_log_result between", value1, value2, "walletLogResult");
            return (Criteria) this;
        }

        public Criteria andWalletLogResultNotBetween(Integer value1, Integer value2) {
            addCriterion("wallet_log_result not between", value1, value2, "walletLogResult");
            return (Criteria) this;
        }

        public Criteria andWalletLogRemarkIsNull() {
            addCriterion("wallet_log_remark is null");
            return (Criteria) this;
        }

        public Criteria andWalletLogRemarkIsNotNull() {
            addCriterion("wallet_log_remark is not null");
            return (Criteria) this;
        }

        public Criteria andWalletLogRemarkEqualTo(String value) {
            addCriterion("wallet_log_remark =", value, "walletLogRemark");
            return (Criteria) this;
        }

        public Criteria andWalletLogRemarkNotEqualTo(String value) {
            addCriterion("wallet_log_remark <>", value, "walletLogRemark");
            return (Criteria) this;
        }

        public Criteria andWalletLogRemarkGreaterThan(String value) {
            addCriterion("wallet_log_remark >", value, "walletLogRemark");
            return (Criteria) this;
        }

        public Criteria andWalletLogRemarkGreaterThanOrEqualTo(String value) {
            addCriterion("wallet_log_remark >=", value, "walletLogRemark");
            return (Criteria) this;
        }

        public Criteria andWalletLogRemarkLessThan(String value) {
            addCriterion("wallet_log_remark <", value, "walletLogRemark");
            return (Criteria) this;
        }

        public Criteria andWalletLogRemarkLessThanOrEqualTo(String value) {
            addCriterion("wallet_log_remark <=", value, "walletLogRemark");
            return (Criteria) this;
        }

        public Criteria andWalletLogRemarkLike(String value) {
            addCriterion("wallet_log_remark like", value, "walletLogRemark");
            return (Criteria) this;
        }

        public Criteria andWalletLogRemarkNotLike(String value) {
            addCriterion("wallet_log_remark not like", value, "walletLogRemark");
            return (Criteria) this;
        }

        public Criteria andWalletLogRemarkIn(List<String> values) {
            addCriterion("wallet_log_remark in", values, "walletLogRemark");
            return (Criteria) this;
        }

        public Criteria andWalletLogRemarkNotIn(List<String> values) {
            addCriterion("wallet_log_remark not in", values, "walletLogRemark");
            return (Criteria) this;
        }

        public Criteria andWalletLogRemarkBetween(String value1, String value2) {
            addCriterion("wallet_log_remark between", value1, value2, "walletLogRemark");
            return (Criteria) this;
        }

        public Criteria andWalletLogRemarkNotBetween(String value1, String value2) {
            addCriterion("wallet_log_remark not between", value1, value2, "walletLogRemark");
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