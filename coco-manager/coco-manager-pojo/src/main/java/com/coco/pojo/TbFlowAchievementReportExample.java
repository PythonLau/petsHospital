package com.coco.pojo;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class TbFlowAchievementReportExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TbFlowAchievementReportExample() {
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

        public Criteria andServerdateIsNull() {
            addCriterion("SERVERDATE is null");
            return (Criteria) this;
        }

        public Criteria andServerdateIsNotNull() {
            addCriterion("SERVERDATE is not null");
            return (Criteria) this;
        }

        public Criteria andServerdateEqualTo(String value) {
            addCriterion("SERVERDATE =", value, "serverdate");
            return (Criteria) this;
        }

        public Criteria andServerdateNotEqualTo(String value) {
            addCriterion("SERVERDATE <>", value, "serverdate");
            return (Criteria) this;
        }

        public Criteria andServerdateGreaterThan(String value) {
            addCriterion("SERVERDATE >", value, "serverdate");
            return (Criteria) this;
        }

        public Criteria andServerdateGreaterThanOrEqualTo(String value) {
            addCriterion("SERVERDATE >=", value, "serverdate");
            return (Criteria) this;
        }

        public Criteria andServerdateLessThan(String value) {
            addCriterion("SERVERDATE <", value, "serverdate");
            return (Criteria) this;
        }

        public Criteria andServerdateLessThanOrEqualTo(String value) {
            addCriterion("SERVERDATE <=", value, "serverdate");
            return (Criteria) this;
        }

        public Criteria andServerdateLike(String value) {
            addCriterion("SERVERDATE like", value, "serverdate");
            return (Criteria) this;
        }

        public Criteria andServerdateNotLike(String value) {
            addCriterion("SERVERDATE not like", value, "serverdate");
            return (Criteria) this;
        }

        public Criteria andServerdateIn(List<String> values) {
            addCriterion("SERVERDATE in", values, "serverdate");
            return (Criteria) this;
        }

        public Criteria andServerdateNotIn(List<String> values) {
            addCriterion("SERVERDATE not in", values, "serverdate");
            return (Criteria) this;
        }

        public Criteria andServerdateBetween(String value1, String value2) {
            addCriterion("SERVERDATE between", value1, value2, "serverdate");
            return (Criteria) this;
        }

        public Criteria andServerdateNotBetween(String value1, String value2) {
            addCriterion("SERVERDATE not between", value1, value2, "serverdate");
            return (Criteria) this;
        }

        public Criteria andPvIsNull() {
            addCriterion("PV is null");
            return (Criteria) this;
        }

        public Criteria andPvIsNotNull() {
            addCriterion("PV is not null");
            return (Criteria) this;
        }

        public Criteria andPvEqualTo(BigDecimal value) {
            addCriterion("PV =", value, "pv");
            return (Criteria) this;
        }

        public Criteria andPvNotEqualTo(BigDecimal value) {
            addCriterion("PV <>", value, "pv");
            return (Criteria) this;
        }

        public Criteria andPvGreaterThan(BigDecimal value) {
            addCriterion("PV >", value, "pv");
            return (Criteria) this;
        }

        public Criteria andPvGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("PV >=", value, "pv");
            return (Criteria) this;
        }

        public Criteria andPvLessThan(BigDecimal value) {
            addCriterion("PV <", value, "pv");
            return (Criteria) this;
        }

        public Criteria andPvLessThanOrEqualTo(BigDecimal value) {
            addCriterion("PV <=", value, "pv");
            return (Criteria) this;
        }

        public Criteria andPvIn(List<BigDecimal> values) {
            addCriterion("PV in", values, "pv");
            return (Criteria) this;
        }

        public Criteria andPvNotIn(List<BigDecimal> values) {
            addCriterion("PV not in", values, "pv");
            return (Criteria) this;
        }

        public Criteria andPvBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("PV between", value1, value2, "pv");
            return (Criteria) this;
        }

        public Criteria andPvNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("PV not between", value1, value2, "pv");
            return (Criteria) this;
        }

        public Criteria andUvIsNull() {
            addCriterion("UV is null");
            return (Criteria) this;
        }

        public Criteria andUvIsNotNull() {
            addCriterion("UV is not null");
            return (Criteria) this;
        }

        public Criteria andUvEqualTo(Long value) {
            addCriterion("UV =", value, "uv");
            return (Criteria) this;
        }

        public Criteria andUvNotEqualTo(Long value) {
            addCriterion("UV <>", value, "uv");
            return (Criteria) this;
        }

        public Criteria andUvGreaterThan(Long value) {
            addCriterion("UV >", value, "uv");
            return (Criteria) this;
        }

        public Criteria andUvGreaterThanOrEqualTo(Long value) {
            addCriterion("UV >=", value, "uv");
            return (Criteria) this;
        }

        public Criteria andUvLessThan(Long value) {
            addCriterion("UV <", value, "uv");
            return (Criteria) this;
        }

        public Criteria andUvLessThanOrEqualTo(Long value) {
            addCriterion("UV <=", value, "uv");
            return (Criteria) this;
        }

        public Criteria andUvIn(List<Long> values) {
            addCriterion("UV in", values, "uv");
            return (Criteria) this;
        }

        public Criteria andUvNotIn(List<Long> values) {
            addCriterion("UV not in", values, "uv");
            return (Criteria) this;
        }

        public Criteria andUvBetween(Long value1, Long value2) {
            addCriterion("UV between", value1, value2, "uv");
            return (Criteria) this;
        }

        public Criteria andUvNotBetween(Long value1, Long value2) {
            addCriterion("UV not between", value1, value2, "uv");
            return (Criteria) this;
        }

        public Criteria andStatusonemedicalIsNull() {
            addCriterion("STATUSONEMEDICAL is null");
            return (Criteria) this;
        }

        public Criteria andStatusonemedicalIsNotNull() {
            addCriterion("STATUSONEMEDICAL is not null");
            return (Criteria) this;
        }

        public Criteria andStatusonemedicalEqualTo(Integer value) {
            addCriterion("STATUSONEMEDICAL =", value, "statusonemedical");
            return (Criteria) this;
        }

        public Criteria andStatusonemedicalNotEqualTo(Integer value) {
            addCriterion("STATUSONEMEDICAL <>", value, "statusonemedical");
            return (Criteria) this;
        }

        public Criteria andStatusonemedicalGreaterThan(Integer value) {
            addCriterion("STATUSONEMEDICAL >", value, "statusonemedical");
            return (Criteria) this;
        }

        public Criteria andStatusonemedicalGreaterThanOrEqualTo(Integer value) {
            addCriterion("STATUSONEMEDICAL >=", value, "statusonemedical");
            return (Criteria) this;
        }

        public Criteria andStatusonemedicalLessThan(Integer value) {
            addCriterion("STATUSONEMEDICAL <", value, "statusonemedical");
            return (Criteria) this;
        }

        public Criteria andStatusonemedicalLessThanOrEqualTo(Integer value) {
            addCriterion("STATUSONEMEDICAL <=", value, "statusonemedical");
            return (Criteria) this;
        }

        public Criteria andStatusonemedicalIn(List<Integer> values) {
            addCriterion("STATUSONEMEDICAL in", values, "statusonemedical");
            return (Criteria) this;
        }

        public Criteria andStatusonemedicalNotIn(List<Integer> values) {
            addCriterion("STATUSONEMEDICAL not in", values, "statusonemedical");
            return (Criteria) this;
        }

        public Criteria andStatusonemedicalBetween(Integer value1, Integer value2) {
            addCriterion("STATUSONEMEDICAL between", value1, value2, "statusonemedical");
            return (Criteria) this;
        }

        public Criteria andStatusonemedicalNotBetween(Integer value1, Integer value2) {
            addCriterion("STATUSONEMEDICAL not between", value1, value2, "statusonemedical");
            return (Criteria) this;
        }

        public Criteria andStatustwomedicalIsNull() {
            addCriterion("STATUSTWOMEDICAL is null");
            return (Criteria) this;
        }

        public Criteria andStatustwomedicalIsNotNull() {
            addCriterion("STATUSTWOMEDICAL is not null");
            return (Criteria) this;
        }

        public Criteria andStatustwomedicalEqualTo(Integer value) {
            addCriterion("STATUSTWOMEDICAL =", value, "statustwomedical");
            return (Criteria) this;
        }

        public Criteria andStatustwomedicalNotEqualTo(Integer value) {
            addCriterion("STATUSTWOMEDICAL <>", value, "statustwomedical");
            return (Criteria) this;
        }

        public Criteria andStatustwomedicalGreaterThan(Integer value) {
            addCriterion("STATUSTWOMEDICAL >", value, "statustwomedical");
            return (Criteria) this;
        }

        public Criteria andStatustwomedicalGreaterThanOrEqualTo(Integer value) {
            addCriterion("STATUSTWOMEDICAL >=", value, "statustwomedical");
            return (Criteria) this;
        }

        public Criteria andStatustwomedicalLessThan(Integer value) {
            addCriterion("STATUSTWOMEDICAL <", value, "statustwomedical");
            return (Criteria) this;
        }

        public Criteria andStatustwomedicalLessThanOrEqualTo(Integer value) {
            addCriterion("STATUSTWOMEDICAL <=", value, "statustwomedical");
            return (Criteria) this;
        }

        public Criteria andStatustwomedicalIn(List<Integer> values) {
            addCriterion("STATUSTWOMEDICAL in", values, "statustwomedical");
            return (Criteria) this;
        }

        public Criteria andStatustwomedicalNotIn(List<Integer> values) {
            addCriterion("STATUSTWOMEDICAL not in", values, "statustwomedical");
            return (Criteria) this;
        }

        public Criteria andStatustwomedicalBetween(Integer value1, Integer value2) {
            addCriterion("STATUSTWOMEDICAL between", value1, value2, "statustwomedical");
            return (Criteria) this;
        }

        public Criteria andStatustwomedicalNotBetween(Integer value1, Integer value2) {
            addCriterion("STATUSTWOMEDICAL not between", value1, value2, "statustwomedical");
            return (Criteria) this;
        }

        public Criteria andStatusthreemedicalIsNull() {
            addCriterion("STATUSTHREEMEDICAL is null");
            return (Criteria) this;
        }

        public Criteria andStatusthreemedicalIsNotNull() {
            addCriterion("STATUSTHREEMEDICAL is not null");
            return (Criteria) this;
        }

        public Criteria andStatusthreemedicalEqualTo(Integer value) {
            addCriterion("STATUSTHREEMEDICAL =", value, "statusthreemedical");
            return (Criteria) this;
        }

        public Criteria andStatusthreemedicalNotEqualTo(Integer value) {
            addCriterion("STATUSTHREEMEDICAL <>", value, "statusthreemedical");
            return (Criteria) this;
        }

        public Criteria andStatusthreemedicalGreaterThan(Integer value) {
            addCriterion("STATUSTHREEMEDICAL >", value, "statusthreemedical");
            return (Criteria) this;
        }

        public Criteria andStatusthreemedicalGreaterThanOrEqualTo(Integer value) {
            addCriterion("STATUSTHREEMEDICAL >=", value, "statusthreemedical");
            return (Criteria) this;
        }

        public Criteria andStatusthreemedicalLessThan(Integer value) {
            addCriterion("STATUSTHREEMEDICAL <", value, "statusthreemedical");
            return (Criteria) this;
        }

        public Criteria andStatusthreemedicalLessThanOrEqualTo(Integer value) {
            addCriterion("STATUSTHREEMEDICAL <=", value, "statusthreemedical");
            return (Criteria) this;
        }

        public Criteria andStatusthreemedicalIn(List<Integer> values) {
            addCriterion("STATUSTHREEMEDICAL in", values, "statusthreemedical");
            return (Criteria) this;
        }

        public Criteria andStatusthreemedicalNotIn(List<Integer> values) {
            addCriterion("STATUSTHREEMEDICAL not in", values, "statusthreemedical");
            return (Criteria) this;
        }

        public Criteria andStatusthreemedicalBetween(Integer value1, Integer value2) {
            addCriterion("STATUSTHREEMEDICAL between", value1, value2, "statusthreemedical");
            return (Criteria) this;
        }

        public Criteria andStatusthreemedicalNotBetween(Integer value1, Integer value2) {
            addCriterion("STATUSTHREEMEDICAL not between", value1, value2, "statusthreemedical");
            return (Criteria) this;
        }

        public Criteria andStatuszeromedicalIsNull() {
            addCriterion("STATUSZEROMEDICAL is null");
            return (Criteria) this;
        }

        public Criteria andStatuszeromedicalIsNotNull() {
            addCriterion("STATUSZEROMEDICAL is not null");
            return (Criteria) this;
        }

        public Criteria andStatuszeromedicalEqualTo(Integer value) {
            addCriterion("STATUSZEROMEDICAL =", value, "statuszeromedical");
            return (Criteria) this;
        }

        public Criteria andStatuszeromedicalNotEqualTo(Integer value) {
            addCriterion("STATUSZEROMEDICAL <>", value, "statuszeromedical");
            return (Criteria) this;
        }

        public Criteria andStatuszeromedicalGreaterThan(Integer value) {
            addCriterion("STATUSZEROMEDICAL >", value, "statuszeromedical");
            return (Criteria) this;
        }

        public Criteria andStatuszeromedicalGreaterThanOrEqualTo(Integer value) {
            addCriterion("STATUSZEROMEDICAL >=", value, "statuszeromedical");
            return (Criteria) this;
        }

        public Criteria andStatuszeromedicalLessThan(Integer value) {
            addCriterion("STATUSZEROMEDICAL <", value, "statuszeromedical");
            return (Criteria) this;
        }

        public Criteria andStatuszeromedicalLessThanOrEqualTo(Integer value) {
            addCriterion("STATUSZEROMEDICAL <=", value, "statuszeromedical");
            return (Criteria) this;
        }

        public Criteria andStatuszeromedicalIn(List<Integer> values) {
            addCriterion("STATUSZEROMEDICAL in", values, "statuszeromedical");
            return (Criteria) this;
        }

        public Criteria andStatuszeromedicalNotIn(List<Integer> values) {
            addCriterion("STATUSZEROMEDICAL not in", values, "statuszeromedical");
            return (Criteria) this;
        }

        public Criteria andStatuszeromedicalBetween(Integer value1, Integer value2) {
            addCriterion("STATUSZEROMEDICAL between", value1, value2, "statuszeromedical");
            return (Criteria) this;
        }

        public Criteria andStatuszeromedicalNotBetween(Integer value1, Integer value2) {
            addCriterion("STATUSZEROMEDICAL not between", value1, value2, "statuszeromedical");
            return (Criteria) this;
        }

        public Criteria andStatusonepackageIsNull() {
            addCriterion("STATUSONEPACKAGE is null");
            return (Criteria) this;
        }

        public Criteria andStatusonepackageIsNotNull() {
            addCriterion("STATUSONEPACKAGE is not null");
            return (Criteria) this;
        }

        public Criteria andStatusonepackageEqualTo(Integer value) {
            addCriterion("STATUSONEPACKAGE =", value, "statusonepackage");
            return (Criteria) this;
        }

        public Criteria andStatusonepackageNotEqualTo(Integer value) {
            addCriterion("STATUSONEPACKAGE <>", value, "statusonepackage");
            return (Criteria) this;
        }

        public Criteria andStatusonepackageGreaterThan(Integer value) {
            addCriterion("STATUSONEPACKAGE >", value, "statusonepackage");
            return (Criteria) this;
        }

        public Criteria andStatusonepackageGreaterThanOrEqualTo(Integer value) {
            addCriterion("STATUSONEPACKAGE >=", value, "statusonepackage");
            return (Criteria) this;
        }

        public Criteria andStatusonepackageLessThan(Integer value) {
            addCriterion("STATUSONEPACKAGE <", value, "statusonepackage");
            return (Criteria) this;
        }

        public Criteria andStatusonepackageLessThanOrEqualTo(Integer value) {
            addCriterion("STATUSONEPACKAGE <=", value, "statusonepackage");
            return (Criteria) this;
        }

        public Criteria andStatusonepackageIn(List<Integer> values) {
            addCriterion("STATUSONEPACKAGE in", values, "statusonepackage");
            return (Criteria) this;
        }

        public Criteria andStatusonepackageNotIn(List<Integer> values) {
            addCriterion("STATUSONEPACKAGE not in", values, "statusonepackage");
            return (Criteria) this;
        }

        public Criteria andStatusonepackageBetween(Integer value1, Integer value2) {
            addCriterion("STATUSONEPACKAGE between", value1, value2, "statusonepackage");
            return (Criteria) this;
        }

        public Criteria andStatusonepackageNotBetween(Integer value1, Integer value2) {
            addCriterion("STATUSONEPACKAGE not between", value1, value2, "statusonepackage");
            return (Criteria) this;
        }

        public Criteria andStatustwopackageIsNull() {
            addCriterion("STATUSTWOPACKAGE is null");
            return (Criteria) this;
        }

        public Criteria andStatustwopackageIsNotNull() {
            addCriterion("STATUSTWOPACKAGE is not null");
            return (Criteria) this;
        }

        public Criteria andStatustwopackageEqualTo(Integer value) {
            addCriterion("STATUSTWOPACKAGE =", value, "statustwopackage");
            return (Criteria) this;
        }

        public Criteria andStatustwopackageNotEqualTo(Integer value) {
            addCriterion("STATUSTWOPACKAGE <>", value, "statustwopackage");
            return (Criteria) this;
        }

        public Criteria andStatustwopackageGreaterThan(Integer value) {
            addCriterion("STATUSTWOPACKAGE >", value, "statustwopackage");
            return (Criteria) this;
        }

        public Criteria andStatustwopackageGreaterThanOrEqualTo(Integer value) {
            addCriterion("STATUSTWOPACKAGE >=", value, "statustwopackage");
            return (Criteria) this;
        }

        public Criteria andStatustwopackageLessThan(Integer value) {
            addCriterion("STATUSTWOPACKAGE <", value, "statustwopackage");
            return (Criteria) this;
        }

        public Criteria andStatustwopackageLessThanOrEqualTo(Integer value) {
            addCriterion("STATUSTWOPACKAGE <=", value, "statustwopackage");
            return (Criteria) this;
        }

        public Criteria andStatustwopackageIn(List<Integer> values) {
            addCriterion("STATUSTWOPACKAGE in", values, "statustwopackage");
            return (Criteria) this;
        }

        public Criteria andStatustwopackageNotIn(List<Integer> values) {
            addCriterion("STATUSTWOPACKAGE not in", values, "statustwopackage");
            return (Criteria) this;
        }

        public Criteria andStatustwopackageBetween(Integer value1, Integer value2) {
            addCriterion("STATUSTWOPACKAGE between", value1, value2, "statustwopackage");
            return (Criteria) this;
        }

        public Criteria andStatustwopackageNotBetween(Integer value1, Integer value2) {
            addCriterion("STATUSTWOPACKAGE not between", value1, value2, "statustwopackage");
            return (Criteria) this;
        }

        public Criteria andStatuszeropackageIsNull() {
            addCriterion("STATUSZEROPACKAGE is null");
            return (Criteria) this;
        }

        public Criteria andStatuszeropackageIsNotNull() {
            addCriterion("STATUSZEROPACKAGE is not null");
            return (Criteria) this;
        }

        public Criteria andStatuszeropackageEqualTo(Integer value) {
            addCriterion("STATUSZEROPACKAGE =", value, "statuszeropackage");
            return (Criteria) this;
        }

        public Criteria andStatuszeropackageNotEqualTo(Integer value) {
            addCriterion("STATUSZEROPACKAGE <>", value, "statuszeropackage");
            return (Criteria) this;
        }

        public Criteria andStatuszeropackageGreaterThan(Integer value) {
            addCriterion("STATUSZEROPACKAGE >", value, "statuszeropackage");
            return (Criteria) this;
        }

        public Criteria andStatuszeropackageGreaterThanOrEqualTo(Integer value) {
            addCriterion("STATUSZEROPACKAGE >=", value, "statuszeropackage");
            return (Criteria) this;
        }

        public Criteria andStatuszeropackageLessThan(Integer value) {
            addCriterion("STATUSZEROPACKAGE <", value, "statuszeropackage");
            return (Criteria) this;
        }

        public Criteria andStatuszeropackageLessThanOrEqualTo(Integer value) {
            addCriterion("STATUSZEROPACKAGE <=", value, "statuszeropackage");
            return (Criteria) this;
        }

        public Criteria andStatuszeropackageIn(List<Integer> values) {
            addCriterion("STATUSZEROPACKAGE in", values, "statuszeropackage");
            return (Criteria) this;
        }

        public Criteria andStatuszeropackageNotIn(List<Integer> values) {
            addCriterion("STATUSZEROPACKAGE not in", values, "statuszeropackage");
            return (Criteria) this;
        }

        public Criteria andStatuszeropackageBetween(Integer value1, Integer value2) {
            addCriterion("STATUSZEROPACKAGE between", value1, value2, "statuszeropackage");
            return (Criteria) this;
        }

        public Criteria andStatuszeropackageNotBetween(Integer value1, Integer value2) {
            addCriterion("STATUSZEROPACKAGE not between", value1, value2, "statuszeropackage");
            return (Criteria) this;
        }

        public Criteria andRevenueofmedicalIsNull() {
            addCriterion("REVENUEOFMEDICAL is null");
            return (Criteria) this;
        }

        public Criteria andRevenueofmedicalIsNotNull() {
            addCriterion("REVENUEOFMEDICAL is not null");
            return (Criteria) this;
        }

        public Criteria andRevenueofmedicalEqualTo(BigDecimal value) {
            addCriterion("REVENUEOFMEDICAL =", value, "revenueofmedical");
            return (Criteria) this;
        }

        public Criteria andRevenueofmedicalNotEqualTo(BigDecimal value) {
            addCriterion("REVENUEOFMEDICAL <>", value, "revenueofmedical");
            return (Criteria) this;
        }

        public Criteria andRevenueofmedicalGreaterThan(BigDecimal value) {
            addCriterion("REVENUEOFMEDICAL >", value, "revenueofmedical");
            return (Criteria) this;
        }

        public Criteria andRevenueofmedicalGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("REVENUEOFMEDICAL >=", value, "revenueofmedical");
            return (Criteria) this;
        }

        public Criteria andRevenueofmedicalLessThan(BigDecimal value) {
            addCriterion("REVENUEOFMEDICAL <", value, "revenueofmedical");
            return (Criteria) this;
        }

        public Criteria andRevenueofmedicalLessThanOrEqualTo(BigDecimal value) {
            addCriterion("REVENUEOFMEDICAL <=", value, "revenueofmedical");
            return (Criteria) this;
        }

        public Criteria andRevenueofmedicalIn(List<BigDecimal> values) {
            addCriterion("REVENUEOFMEDICAL in", values, "revenueofmedical");
            return (Criteria) this;
        }

        public Criteria andRevenueofmedicalNotIn(List<BigDecimal> values) {
            addCriterion("REVENUEOFMEDICAL not in", values, "revenueofmedical");
            return (Criteria) this;
        }

        public Criteria andRevenueofmedicalBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("REVENUEOFMEDICAL between", value1, value2, "revenueofmedical");
            return (Criteria) this;
        }

        public Criteria andRevenueofmedicalNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("REVENUEOFMEDICAL not between", value1, value2, "revenueofmedical");
            return (Criteria) this;
        }

        public Criteria andRevenueofpackageIsNull() {
            addCriterion("REVENUEOFPACKAGE is null");
            return (Criteria) this;
        }

        public Criteria andRevenueofpackageIsNotNull() {
            addCriterion("REVENUEOFPACKAGE is not null");
            return (Criteria) this;
        }

        public Criteria andRevenueofpackageEqualTo(BigDecimal value) {
            addCriterion("REVENUEOFPACKAGE =", value, "revenueofpackage");
            return (Criteria) this;
        }

        public Criteria andRevenueofpackageNotEqualTo(BigDecimal value) {
            addCriterion("REVENUEOFPACKAGE <>", value, "revenueofpackage");
            return (Criteria) this;
        }

        public Criteria andRevenueofpackageGreaterThan(BigDecimal value) {
            addCriterion("REVENUEOFPACKAGE >", value, "revenueofpackage");
            return (Criteria) this;
        }

        public Criteria andRevenueofpackageGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("REVENUEOFPACKAGE >=", value, "revenueofpackage");
            return (Criteria) this;
        }

        public Criteria andRevenueofpackageLessThan(BigDecimal value) {
            addCriterion("REVENUEOFPACKAGE <", value, "revenueofpackage");
            return (Criteria) this;
        }

        public Criteria andRevenueofpackageLessThanOrEqualTo(BigDecimal value) {
            addCriterion("REVENUEOFPACKAGE <=", value, "revenueofpackage");
            return (Criteria) this;
        }

        public Criteria andRevenueofpackageIn(List<BigDecimal> values) {
            addCriterion("REVENUEOFPACKAGE in", values, "revenueofpackage");
            return (Criteria) this;
        }

        public Criteria andRevenueofpackageNotIn(List<BigDecimal> values) {
            addCriterion("REVENUEOFPACKAGE not in", values, "revenueofpackage");
            return (Criteria) this;
        }

        public Criteria andRevenueofpackageBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("REVENUEOFPACKAGE between", value1, value2, "revenueofpackage");
            return (Criteria) this;
        }

        public Criteria andRevenueofpackageNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("REVENUEOFPACKAGE not between", value1, value2, "revenueofpackage");
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