package com.coco.pojo;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TbMedicalDetailExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TbMedicalDetailExample() {
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

        public Criteria andIdIsNull() {
            addCriterion("ID is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("ID is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(BigDecimal value) {
            addCriterion("ID =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(BigDecimal value) {
            addCriterion("ID <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(BigDecimal value) {
            addCriterion("ID >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("ID >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(BigDecimal value) {
            addCriterion("ID <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(BigDecimal value) {
            addCriterion("ID <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<BigDecimal> values) {
            addCriterion("ID in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<BigDecimal> values) {
            addCriterion("ID not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("ID between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("ID not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andMedicalidIsNull() {
            addCriterion("MEDICALID is null");
            return (Criteria) this;
        }

        public Criteria andMedicalidIsNotNull() {
            addCriterion("MEDICALID is not null");
            return (Criteria) this;
        }

        public Criteria andMedicalidEqualTo(BigDecimal value) {
            addCriterion("MEDICALID =", value, "medicalid");
            return (Criteria) this;
        }

        public Criteria andMedicalidNotEqualTo(BigDecimal value) {
            addCriterion("MEDICALID <>", value, "medicalid");
            return (Criteria) this;
        }

        public Criteria andMedicalidGreaterThan(BigDecimal value) {
            addCriterion("MEDICALID >", value, "medicalid");
            return (Criteria) this;
        }

        public Criteria andMedicalidGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("MEDICALID >=", value, "medicalid");
            return (Criteria) this;
        }

        public Criteria andMedicalidLessThan(BigDecimal value) {
            addCriterion("MEDICALID <", value, "medicalid");
            return (Criteria) this;
        }

        public Criteria andMedicalidLessThanOrEqualTo(BigDecimal value) {
            addCriterion("MEDICALID <=", value, "medicalid");
            return (Criteria) this;
        }

        public Criteria andMedicalidIn(List<BigDecimal> values) {
            addCriterion("MEDICALID in", values, "medicalid");
            return (Criteria) this;
        }

        public Criteria andMedicalidNotIn(List<BigDecimal> values) {
            addCriterion("MEDICALID not in", values, "medicalid");
            return (Criteria) this;
        }

        public Criteria andMedicalidBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("MEDICALID between", value1, value2, "medicalid");
            return (Criteria) this;
        }

        public Criteria andMedicalidNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("MEDICALID not between", value1, value2, "medicalid");
            return (Criteria) this;
        }

        public Criteria andSicknameIsNull() {
            addCriterion("SICKNAME is null");
            return (Criteria) this;
        }

        public Criteria andSicknameIsNotNull() {
            addCriterion("SICKNAME is not null");
            return (Criteria) this;
        }

        public Criteria andSicknameEqualTo(String value) {
            addCriterion("SICKNAME =", value, "sickname");
            return (Criteria) this;
        }

        public Criteria andSicknameNotEqualTo(String value) {
            addCriterion("SICKNAME <>", value, "sickname");
            return (Criteria) this;
        }

        public Criteria andSicknameGreaterThan(String value) {
            addCriterion("SICKNAME >", value, "sickname");
            return (Criteria) this;
        }

        public Criteria andSicknameGreaterThanOrEqualTo(String value) {
            addCriterion("SICKNAME >=", value, "sickname");
            return (Criteria) this;
        }

        public Criteria andSicknameLessThan(String value) {
            addCriterion("SICKNAME <", value, "sickname");
            return (Criteria) this;
        }

        public Criteria andSicknameLessThanOrEqualTo(String value) {
            addCriterion("SICKNAME <=", value, "sickname");
            return (Criteria) this;
        }

        public Criteria andSicknameLike(String value) {
            addCriterion("SICKNAME like", value, "sickname");
            return (Criteria) this;
        }

        public Criteria andSicknameNotLike(String value) {
            addCriterion("SICKNAME not like", value, "sickname");
            return (Criteria) this;
        }

        public Criteria andSicknameIn(List<String> values) {
            addCriterion("SICKNAME in", values, "sickname");
            return (Criteria) this;
        }

        public Criteria andSicknameNotIn(List<String> values) {
            addCriterion("SICKNAME not in", values, "sickname");
            return (Criteria) this;
        }

        public Criteria andSicknameBetween(String value1, String value2) {
            addCriterion("SICKNAME between", value1, value2, "sickname");
            return (Criteria) this;
        }

        public Criteria andSicknameNotBetween(String value1, String value2) {
            addCriterion("SICKNAME not between", value1, value2, "sickname");
            return (Criteria) this;
        }

        public Criteria andRoomIsNull() {
            addCriterion("ROOM is null");
            return (Criteria) this;
        }

        public Criteria andRoomIsNotNull() {
            addCriterion("ROOM is not null");
            return (Criteria) this;
        }

        public Criteria andRoomEqualTo(BigDecimal value) {
            addCriterion("ROOM =", value, "room");
            return (Criteria) this;
        }

        public Criteria andRoomNotEqualTo(BigDecimal value) {
            addCriterion("ROOM <>", value, "room");
            return (Criteria) this;
        }

        public Criteria andRoomGreaterThan(BigDecimal value) {
            addCriterion("ROOM >", value, "room");
            return (Criteria) this;
        }

        public Criteria andRoomGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("ROOM >=", value, "room");
            return (Criteria) this;
        }

        public Criteria andRoomLessThan(BigDecimal value) {
            addCriterion("ROOM <", value, "room");
            return (Criteria) this;
        }

        public Criteria andRoomLessThanOrEqualTo(BigDecimal value) {
            addCriterion("ROOM <=", value, "room");
            return (Criteria) this;
        }

        public Criteria andRoomIn(List<BigDecimal> values) {
            addCriterion("ROOM in", values, "room");
            return (Criteria) this;
        }

        public Criteria andRoomNotIn(List<BigDecimal> values) {
            addCriterion("ROOM not in", values, "room");
            return (Criteria) this;
        }

        public Criteria andRoomBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("ROOM between", value1, value2, "room");
            return (Criteria) this;
        }

        public Criteria andRoomNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("ROOM not between", value1, value2, "room");
            return (Criteria) this;
        }

        public Criteria andNeeddaysIsNull() {
            addCriterion("NEEDDAYS is null");
            return (Criteria) this;
        }

        public Criteria andNeeddaysIsNotNull() {
            addCriterion("NEEDDAYS is not null");
            return (Criteria) this;
        }

        public Criteria andNeeddaysEqualTo(Integer value) {
            addCriterion("NEEDDAYS =", value, "needdays");
            return (Criteria) this;
        }

        public Criteria andNeeddaysNotEqualTo(Integer value) {
            addCriterion("NEEDDAYS <>", value, "needdays");
            return (Criteria) this;
        }

        public Criteria andNeeddaysGreaterThan(Integer value) {
            addCriterion("NEEDDAYS >", value, "needdays");
            return (Criteria) this;
        }

        public Criteria andNeeddaysGreaterThanOrEqualTo(Integer value) {
            addCriterion("NEEDDAYS >=", value, "needdays");
            return (Criteria) this;
        }

        public Criteria andNeeddaysLessThan(Integer value) {
            addCriterion("NEEDDAYS <", value, "needdays");
            return (Criteria) this;
        }

        public Criteria andNeeddaysLessThanOrEqualTo(Integer value) {
            addCriterion("NEEDDAYS <=", value, "needdays");
            return (Criteria) this;
        }

        public Criteria andNeeddaysIn(List<Integer> values) {
            addCriterion("NEEDDAYS in", values, "needdays");
            return (Criteria) this;
        }

        public Criteria andNeeddaysNotIn(List<Integer> values) {
            addCriterion("NEEDDAYS not in", values, "needdays");
            return (Criteria) this;
        }

        public Criteria andNeeddaysBetween(Integer value1, Integer value2) {
            addCriterion("NEEDDAYS between", value1, value2, "needdays");
            return (Criteria) this;
        }

        public Criteria andNeeddaysNotBetween(Integer value1, Integer value2) {
            addCriterion("NEEDDAYS not between", value1, value2, "needdays");
            return (Criteria) this;
        }

        public Criteria andPriceIsNull() {
            addCriterion("PRICE is null");
            return (Criteria) this;
        }

        public Criteria andPriceIsNotNull() {
            addCriterion("PRICE is not null");
            return (Criteria) this;
        }

        public Criteria andPriceEqualTo(BigDecimal value) {
            addCriterion("PRICE =", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceNotEqualTo(BigDecimal value) {
            addCriterion("PRICE <>", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceGreaterThan(BigDecimal value) {
            addCriterion("PRICE >", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("PRICE >=", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceLessThan(BigDecimal value) {
            addCriterion("PRICE <", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceLessThanOrEqualTo(BigDecimal value) {
            addCriterion("PRICE <=", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceIn(List<BigDecimal> values) {
            addCriterion("PRICE in", values, "price");
            return (Criteria) this;
        }

        public Criteria andPriceNotIn(List<BigDecimal> values) {
            addCriterion("PRICE not in", values, "price");
            return (Criteria) this;
        }

        public Criteria andPriceBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("PRICE between", value1, value2, "price");
            return (Criteria) this;
        }

        public Criteria andPriceNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("PRICE not between", value1, value2, "price");
            return (Criteria) this;
        }

        public Criteria andStatusIsNull() {
            addCriterion("STATUS is null");
            return (Criteria) this;
        }

        public Criteria andStatusIsNotNull() {
            addCriterion("STATUS is not null");
            return (Criteria) this;
        }

        public Criteria andStatusEqualTo(Short value) {
            addCriterion("STATUS =", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotEqualTo(Short value) {
            addCriterion("STATUS <>", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThan(Short value) {
            addCriterion("STATUS >", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThanOrEqualTo(Short value) {
            addCriterion("STATUS >=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThan(Short value) {
            addCriterion("STATUS <", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThanOrEqualTo(Short value) {
            addCriterion("STATUS <=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusIn(List<Short> values) {
            addCriterion("STATUS in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotIn(List<Short> values) {
            addCriterion("STATUS not in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusBetween(Short value1, Short value2) {
            addCriterion("STATUS between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotBetween(Short value1, Short value2) {
            addCriterion("STATUS not between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andCreatedIsNull() {
            addCriterion("CREATED is null");
            return (Criteria) this;
        }

        public Criteria andCreatedIsNotNull() {
            addCriterion("CREATED is not null");
            return (Criteria) this;
        }

        public Criteria andCreatedEqualTo(Date value) {
            addCriterion("CREATED =", value, "created");
            return (Criteria) this;
        }

        public Criteria andCreatedNotEqualTo(Date value) {
            addCriterion("CREATED <>", value, "created");
            return (Criteria) this;
        }

        public Criteria andCreatedGreaterThan(Date value) {
            addCriterion("CREATED >", value, "created");
            return (Criteria) this;
        }

        public Criteria andCreatedGreaterThanOrEqualTo(Date value) {
            addCriterion("CREATED >=", value, "created");
            return (Criteria) this;
        }

        public Criteria andCreatedLessThan(Date value) {
            addCriterion("CREATED <", value, "created");
            return (Criteria) this;
        }

        public Criteria andCreatedLessThanOrEqualTo(Date value) {
            addCriterion("CREATED <=", value, "created");
            return (Criteria) this;
        }

        public Criteria andCreatedIn(List<Date> values) {
            addCriterion("CREATED in", values, "created");
            return (Criteria) this;
        }

        public Criteria andCreatedNotIn(List<Date> values) {
            addCriterion("CREATED not in", values, "created");
            return (Criteria) this;
        }

        public Criteria andCreatedBetween(Date value1, Date value2) {
            addCriterion("CREATED between", value1, value2, "created");
            return (Criteria) this;
        }

        public Criteria andCreatedNotBetween(Date value1, Date value2) {
            addCriterion("CREATED not between", value1, value2, "created");
            return (Criteria) this;
        }

        public Criteria andUpdatedIsNull() {
            addCriterion("UPDATED is null");
            return (Criteria) this;
        }

        public Criteria andUpdatedIsNotNull() {
            addCriterion("UPDATED is not null");
            return (Criteria) this;
        }

        public Criteria andUpdatedEqualTo(Date value) {
            addCriterion("UPDATED =", value, "updated");
            return (Criteria) this;
        }

        public Criteria andUpdatedNotEqualTo(Date value) {
            addCriterion("UPDATED <>", value, "updated");
            return (Criteria) this;
        }

        public Criteria andUpdatedGreaterThan(Date value) {
            addCriterion("UPDATED >", value, "updated");
            return (Criteria) this;
        }

        public Criteria andUpdatedGreaterThanOrEqualTo(Date value) {
            addCriterion("UPDATED >=", value, "updated");
            return (Criteria) this;
        }

        public Criteria andUpdatedLessThan(Date value) {
            addCriterion("UPDATED <", value, "updated");
            return (Criteria) this;
        }

        public Criteria andUpdatedLessThanOrEqualTo(Date value) {
            addCriterion("UPDATED <=", value, "updated");
            return (Criteria) this;
        }

        public Criteria andUpdatedIn(List<Date> values) {
            addCriterion("UPDATED in", values, "updated");
            return (Criteria) this;
        }

        public Criteria andUpdatedNotIn(List<Date> values) {
            addCriterion("UPDATED not in", values, "updated");
            return (Criteria) this;
        }

        public Criteria andUpdatedBetween(Date value1, Date value2) {
            addCriterion("UPDATED between", value1, value2, "updated");
            return (Criteria) this;
        }

        public Criteria andUpdatedNotBetween(Date value1, Date value2) {
            addCriterion("UPDATED not between", value1, value2, "updated");
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