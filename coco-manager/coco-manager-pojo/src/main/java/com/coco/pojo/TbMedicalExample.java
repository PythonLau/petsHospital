package com.coco.pojo;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TbMedicalExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TbMedicalExample() {
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

        public Criteria andPetidIsNull() {
            addCriterion("PETID is null");
            return (Criteria) this;
        }

        public Criteria andPetidIsNotNull() {
            addCriterion("PETID is not null");
            return (Criteria) this;
        }

        public Criteria andPetidEqualTo(BigDecimal value) {
            addCriterion("PETID =", value, "petid");
            return (Criteria) this;
        }

        public Criteria andPetidNotEqualTo(BigDecimal value) {
            addCriterion("PETID <>", value, "petid");
            return (Criteria) this;
        }

        public Criteria andPetidGreaterThan(BigDecimal value) {
            addCriterion("PETID >", value, "petid");
            return (Criteria) this;
        }

        public Criteria andPetidGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("PETID >=", value, "petid");
            return (Criteria) this;
        }

        public Criteria andPetidLessThan(BigDecimal value) {
            addCriterion("PETID <", value, "petid");
            return (Criteria) this;
        }

        public Criteria andPetidLessThanOrEqualTo(BigDecimal value) {
            addCriterion("PETID <=", value, "petid");
            return (Criteria) this;
        }

        public Criteria andPetidIn(List<BigDecimal> values) {
            addCriterion("PETID in", values, "petid");
            return (Criteria) this;
        }

        public Criteria andPetidNotIn(List<BigDecimal> values) {
            addCriterion("PETID not in", values, "petid");
            return (Criteria) this;
        }

        public Criteria andPetidBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("PETID between", value1, value2, "petid");
            return (Criteria) this;
        }

        public Criteria andPetidNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("PETID not between", value1, value2, "petid");
            return (Criteria) this;
        }

        public Criteria andOfficeidIsNull() {
            addCriterion("OFFICEID is null");
            return (Criteria) this;
        }

        public Criteria andOfficeidIsNotNull() {
            addCriterion("OFFICEID is not null");
            return (Criteria) this;
        }

        public Criteria andOfficeidEqualTo(Long value) {
            addCriterion("OFFICEID =", value, "officeid");
            return (Criteria) this;
        }

        public Criteria andOfficeidNotEqualTo(Long value) {
            addCriterion("OFFICEID <>", value, "officeid");
            return (Criteria) this;
        }

        public Criteria andOfficeidGreaterThan(Long value) {
            addCriterion("OFFICEID >", value, "officeid");
            return (Criteria) this;
        }

        public Criteria andOfficeidGreaterThanOrEqualTo(Long value) {
            addCriterion("OFFICEID >=", value, "officeid");
            return (Criteria) this;
        }

        public Criteria andOfficeidLessThan(Long value) {
            addCriterion("OFFICEID <", value, "officeid");
            return (Criteria) this;
        }

        public Criteria andOfficeidLessThanOrEqualTo(Long value) {
            addCriterion("OFFICEID <=", value, "officeid");
            return (Criteria) this;
        }

        public Criteria andOfficeidIn(List<Long> values) {
            addCriterion("OFFICEID in", values, "officeid");
            return (Criteria) this;
        }

        public Criteria andOfficeidNotIn(List<Long> values) {
            addCriterion("OFFICEID not in", values, "officeid");
            return (Criteria) this;
        }

        public Criteria andOfficeidBetween(Long value1, Long value2) {
            addCriterion("OFFICEID between", value1, value2, "officeid");
            return (Criteria) this;
        }

        public Criteria andOfficeidNotBetween(Long value1, Long value2) {
            addCriterion("OFFICEID not between", value1, value2, "officeid");
            return (Criteria) this;
        }

        public Criteria andRegistertimeIsNull() {
            addCriterion("REGISTERTIME is null");
            return (Criteria) this;
        }

        public Criteria andRegistertimeIsNotNull() {
            addCriterion("REGISTERTIME is not null");
            return (Criteria) this;
        }

        public Criteria andRegistertimeEqualTo(Date value) {
            addCriterion("REGISTERTIME =", value, "registertime");
            return (Criteria) this;
        }

        public Criteria andRegistertimeNotEqualTo(Date value) {
            addCriterion("REGISTERTIME <>", value, "registertime");
            return (Criteria) this;
        }

        public Criteria andRegistertimeGreaterThan(Date value) {
            addCriterion("REGISTERTIME >", value, "registertime");
            return (Criteria) this;
        }

        public Criteria andRegistertimeGreaterThanOrEqualTo(Date value) {
            addCriterion("REGISTERTIME >=", value, "registertime");
            return (Criteria) this;
        }

        public Criteria andRegistertimeLessThan(Date value) {
            addCriterion("REGISTERTIME <", value, "registertime");
            return (Criteria) this;
        }

        public Criteria andRegistertimeLessThanOrEqualTo(Date value) {
            addCriterion("REGISTERTIME <=", value, "registertime");
            return (Criteria) this;
        }

        public Criteria andRegistertimeIn(List<Date> values) {
            addCriterion("REGISTERTIME in", values, "registertime");
            return (Criteria) this;
        }

        public Criteria andRegistertimeNotIn(List<Date> values) {
            addCriterion("REGISTERTIME not in", values, "registertime");
            return (Criteria) this;
        }

        public Criteria andRegistertimeBetween(Date value1, Date value2) {
            addCriterion("REGISTERTIME between", value1, value2, "registertime");
            return (Criteria) this;
        }

        public Criteria andRegistertimeNotBetween(Date value1, Date value2) {
            addCriterion("REGISTERTIME not between", value1, value2, "registertime");
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

        public Criteria andDoctoridIsNull() {
            addCriterion("DOCTORID is null");
            return (Criteria) this;
        }

        public Criteria andDoctoridIsNotNull() {
            addCriterion("DOCTORID is not null");
            return (Criteria) this;
        }

        public Criteria andDoctoridEqualTo(BigDecimal value) {
            addCriterion("DOCTORID =", value, "doctorid");
            return (Criteria) this;
        }

        public Criteria andDoctoridNotEqualTo(BigDecimal value) {
            addCriterion("DOCTORID <>", value, "doctorid");
            return (Criteria) this;
        }

        public Criteria andDoctoridGreaterThan(BigDecimal value) {
            addCriterion("DOCTORID >", value, "doctorid");
            return (Criteria) this;
        }

        public Criteria andDoctoridGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("DOCTORID >=", value, "doctorid");
            return (Criteria) this;
        }

        public Criteria andDoctoridLessThan(BigDecimal value) {
            addCriterion("DOCTORID <", value, "doctorid");
            return (Criteria) this;
        }

        public Criteria andDoctoridLessThanOrEqualTo(BigDecimal value) {
            addCriterion("DOCTORID <=", value, "doctorid");
            return (Criteria) this;
        }

        public Criteria andDoctoridIn(List<BigDecimal> values) {
            addCriterion("DOCTORID in", values, "doctorid");
            return (Criteria) this;
        }

        public Criteria andDoctoridNotIn(List<BigDecimal> values) {
            addCriterion("DOCTORID not in", values, "doctorid");
            return (Criteria) this;
        }

        public Criteria andDoctoridBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("DOCTORID between", value1, value2, "doctorid");
            return (Criteria) this;
        }

        public Criteria andDoctoridNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("DOCTORID not between", value1, value2, "doctorid");
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

        public Criteria andBedroomIsNull() {
            addCriterion("BEDROOM is null");
            return (Criteria) this;
        }

        public Criteria andBedroomIsNotNull() {
            addCriterion("BEDROOM is not null");
            return (Criteria) this;
        }

        public Criteria andBedroomEqualTo(BigDecimal value) {
            addCriterion("BEDROOM =", value, "bedroom");
            return (Criteria) this;
        }

        public Criteria andBedroomNotEqualTo(BigDecimal value) {
            addCriterion("BEDROOM <>", value, "bedroom");
            return (Criteria) this;
        }

        public Criteria andBedroomGreaterThan(BigDecimal value) {
            addCriterion("BEDROOM >", value, "bedroom");
            return (Criteria) this;
        }

        public Criteria andBedroomGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("BEDROOM >=", value, "bedroom");
            return (Criteria) this;
        }

        public Criteria andBedroomLessThan(BigDecimal value) {
            addCriterion("BEDROOM <", value, "bedroom");
            return (Criteria) this;
        }

        public Criteria andBedroomLessThanOrEqualTo(BigDecimal value) {
            addCriterion("BEDROOM <=", value, "bedroom");
            return (Criteria) this;
        }

        public Criteria andBedroomIn(List<BigDecimal> values) {
            addCriterion("BEDROOM in", values, "bedroom");
            return (Criteria) this;
        }

        public Criteria andBedroomNotIn(List<BigDecimal> values) {
            addCriterion("BEDROOM not in", values, "bedroom");
            return (Criteria) this;
        }

        public Criteria andBedroomBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("BEDROOM between", value1, value2, "bedroom");
            return (Criteria) this;
        }

        public Criteria andBedroomNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("BEDROOM not between", value1, value2, "bedroom");
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

        public Criteria andWordsIsNull() {
            addCriterion("WORDS is null");
            return (Criteria) this;
        }

        public Criteria andWordsIsNotNull() {
            addCriterion("WORDS is not null");
            return (Criteria) this;
        }

        public Criteria andWordsEqualTo(String value) {
            addCriterion("WORDS =", value, "words");
            return (Criteria) this;
        }

        public Criteria andWordsNotEqualTo(String value) {
            addCriterion("WORDS <>", value, "words");
            return (Criteria) this;
        }

        public Criteria andWordsGreaterThan(String value) {
            addCriterion("WORDS >", value, "words");
            return (Criteria) this;
        }

        public Criteria andWordsGreaterThanOrEqualTo(String value) {
            addCriterion("WORDS >=", value, "words");
            return (Criteria) this;
        }

        public Criteria andWordsLessThan(String value) {
            addCriterion("WORDS <", value, "words");
            return (Criteria) this;
        }

        public Criteria andWordsLessThanOrEqualTo(String value) {
            addCriterion("WORDS <=", value, "words");
            return (Criteria) this;
        }

        public Criteria andWordsLike(String value) {
            addCriterion("WORDS like", value, "words");
            return (Criteria) this;
        }

        public Criteria andWordsNotLike(String value) {
            addCriterion("WORDS not like", value, "words");
            return (Criteria) this;
        }

        public Criteria andWordsIn(List<String> values) {
            addCriterion("WORDS in", values, "words");
            return (Criteria) this;
        }

        public Criteria andWordsNotIn(List<String> values) {
            addCriterion("WORDS not in", values, "words");
            return (Criteria) this;
        }

        public Criteria andWordsBetween(String value1, String value2) {
            addCriterion("WORDS between", value1, value2, "words");
            return (Criteria) this;
        }

        public Criteria andWordsNotBetween(String value1, String value2) {
            addCriterion("WORDS not between", value1, value2, "words");
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