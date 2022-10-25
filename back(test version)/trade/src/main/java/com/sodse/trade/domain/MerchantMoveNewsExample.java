package com.sodse.trade.domain;

import java.util.ArrayList;
import java.util.List;

public class MerchantMoveNewsExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public MerchantMoveNewsExample() {
        oredCriteria = new ArrayList<>();
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
            criteria = new ArrayList<>();
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
            addCriterion("id is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("id is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(Long value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Long value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Long value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Long value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Long value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Long value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Long> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Long> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Long value1, Long value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Long value1, Long value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andMerchantIdIsNull() {
            addCriterion("merchant_id is null");
            return (Criteria) this;
        }

        public Criteria andMerchantIdIsNotNull() {
            addCriterion("merchant_id is not null");
            return (Criteria) this;
        }

        public Criteria andMerchantIdEqualTo(Long value) {
            addCriterion("merchant_id =", value, "merchantId");
            return (Criteria) this;
        }

        public Criteria andMerchantIdNotEqualTo(Long value) {
            addCriterion("merchant_id <>", value, "merchantId");
            return (Criteria) this;
        }

        public Criteria andMerchantIdGreaterThan(Long value) {
            addCriterion("merchant_id >", value, "merchantId");
            return (Criteria) this;
        }

        public Criteria andMerchantIdGreaterThanOrEqualTo(Long value) {
            addCriterion("merchant_id >=", value, "merchantId");
            return (Criteria) this;
        }

        public Criteria andMerchantIdLessThan(Long value) {
            addCriterion("merchant_id <", value, "merchantId");
            return (Criteria) this;
        }

        public Criteria andMerchantIdLessThanOrEqualTo(Long value) {
            addCriterion("merchant_id <=", value, "merchantId");
            return (Criteria) this;
        }

        public Criteria andMerchantIdIn(List<Long> values) {
            addCriterion("merchant_id in", values, "merchantId");
            return (Criteria) this;
        }

        public Criteria andMerchantIdNotIn(List<Long> values) {
            addCriterion("merchant_id not in", values, "merchantId");
            return (Criteria) this;
        }

        public Criteria andMerchantIdBetween(Long value1, Long value2) {
            addCriterion("merchant_id between", value1, value2, "merchantId");
            return (Criteria) this;
        }

        public Criteria andMerchantIdNotBetween(Long value1, Long value2) {
            addCriterion("merchant_id not between", value1, value2, "merchantId");
            return (Criteria) this;
        }

        public Criteria andMoveNewNameIsNull() {
            addCriterion("move_new_name is null");
            return (Criteria) this;
        }

        public Criteria andMoveNewNameIsNotNull() {
            addCriterion("move_new_name is not null");
            return (Criteria) this;
        }

        public Criteria andMoveNewNameEqualTo(String value) {
            addCriterion("move_new_name =", value, "moveNewName");
            return (Criteria) this;
        }

        public Criteria andMoveNewNameNotEqualTo(String value) {
            addCriterion("move_new_name <>", value, "moveNewName");
            return (Criteria) this;
        }

        public Criteria andMoveNewNameGreaterThan(String value) {
            addCriterion("move_new_name >", value, "moveNewName");
            return (Criteria) this;
        }

        public Criteria andMoveNewNameGreaterThanOrEqualTo(String value) {
            addCriterion("move_new_name >=", value, "moveNewName");
            return (Criteria) this;
        }

        public Criteria andMoveNewNameLessThan(String value) {
            addCriterion("move_new_name <", value, "moveNewName");
            return (Criteria) this;
        }

        public Criteria andMoveNewNameLessThanOrEqualTo(String value) {
            addCriterion("move_new_name <=", value, "moveNewName");
            return (Criteria) this;
        }

        public Criteria andMoveNewNameLike(String value) {
            addCriterion("move_new_name like", value, "moveNewName");
            return (Criteria) this;
        }

        public Criteria andMoveNewNameNotLike(String value) {
            addCriterion("move_new_name not like", value, "moveNewName");
            return (Criteria) this;
        }

        public Criteria andMoveNewNameIn(List<String> values) {
            addCriterion("move_new_name in", values, "moveNewName");
            return (Criteria) this;
        }

        public Criteria andMoveNewNameNotIn(List<String> values) {
            addCriterion("move_new_name not in", values, "moveNewName");
            return (Criteria) this;
        }

        public Criteria andMoveNewNameBetween(String value1, String value2) {
            addCriterion("move_new_name between", value1, value2, "moveNewName");
            return (Criteria) this;
        }

        public Criteria andMoveNewNameNotBetween(String value1, String value2) {
            addCriterion("move_new_name not between", value1, value2, "moveNewName");
            return (Criteria) this;
        }

        public Criteria andMoveNewCreatTimeIsNull() {
            addCriterion("move_new_creat_time is null");
            return (Criteria) this;
        }

        public Criteria andMoveNewCreatTimeIsNotNull() {
            addCriterion("move_new_creat_time is not null");
            return (Criteria) this;
        }

        public Criteria andMoveNewCreatTimeEqualTo(String value) {
            addCriterion("move_new_creat_time =", value, "moveNewCreatTime");
            return (Criteria) this;
        }

        public Criteria andMoveNewCreatTimeNotEqualTo(String value) {
            addCriterion("move_new_creat_time <>", value, "moveNewCreatTime");
            return (Criteria) this;
        }

        public Criteria andMoveNewCreatTimeGreaterThan(String value) {
            addCriterion("move_new_creat_time >", value, "moveNewCreatTime");
            return (Criteria) this;
        }

        public Criteria andMoveNewCreatTimeGreaterThanOrEqualTo(String value) {
            addCriterion("move_new_creat_time >=", value, "moveNewCreatTime");
            return (Criteria) this;
        }

        public Criteria andMoveNewCreatTimeLessThan(String value) {
            addCriterion("move_new_creat_time <", value, "moveNewCreatTime");
            return (Criteria) this;
        }

        public Criteria andMoveNewCreatTimeLessThanOrEqualTo(String value) {
            addCriterion("move_new_creat_time <=", value, "moveNewCreatTime");
            return (Criteria) this;
        }

        public Criteria andMoveNewCreatTimeLike(String value) {
            addCriterion("move_new_creat_time like", value, "moveNewCreatTime");
            return (Criteria) this;
        }

        public Criteria andMoveNewCreatTimeNotLike(String value) {
            addCriterion("move_new_creat_time not like", value, "moveNewCreatTime");
            return (Criteria) this;
        }

        public Criteria andMoveNewCreatTimeIn(List<String> values) {
            addCriterion("move_new_creat_time in", values, "moveNewCreatTime");
            return (Criteria) this;
        }

        public Criteria andMoveNewCreatTimeNotIn(List<String> values) {
            addCriterion("move_new_creat_time not in", values, "moveNewCreatTime");
            return (Criteria) this;
        }

        public Criteria andMoveNewCreatTimeBetween(String value1, String value2) {
            addCriterion("move_new_creat_time between", value1, value2, "moveNewCreatTime");
            return (Criteria) this;
        }

        public Criteria andMoveNewCreatTimeNotBetween(String value1, String value2) {
            addCriterion("move_new_creat_time not between", value1, value2, "moveNewCreatTime");
            return (Criteria) this;
        }

        public Criteria andMoveNewContentIsNull() {
            addCriterion("move_new_content is null");
            return (Criteria) this;
        }

        public Criteria andMoveNewContentIsNotNull() {
            addCriterion("move_new_content is not null");
            return (Criteria) this;
        }

        public Criteria andMoveNewContentEqualTo(String value) {
            addCriterion("move_new_content =", value, "moveNewContent");
            return (Criteria) this;
        }

        public Criteria andMoveNewContentNotEqualTo(String value) {
            addCriterion("move_new_content <>", value, "moveNewContent");
            return (Criteria) this;
        }

        public Criteria andMoveNewContentGreaterThan(String value) {
            addCriterion("move_new_content >", value, "moveNewContent");
            return (Criteria) this;
        }

        public Criteria andMoveNewContentGreaterThanOrEqualTo(String value) {
            addCriterion("move_new_content >=", value, "moveNewContent");
            return (Criteria) this;
        }

        public Criteria andMoveNewContentLessThan(String value) {
            addCriterion("move_new_content <", value, "moveNewContent");
            return (Criteria) this;
        }

        public Criteria andMoveNewContentLessThanOrEqualTo(String value) {
            addCriterion("move_new_content <=", value, "moveNewContent");
            return (Criteria) this;
        }

        public Criteria andMoveNewContentLike(String value) {
            addCriterion("move_new_content like", value, "moveNewContent");
            return (Criteria) this;
        }

        public Criteria andMoveNewContentNotLike(String value) {
            addCriterion("move_new_content not like", value, "moveNewContent");
            return (Criteria) this;
        }

        public Criteria andMoveNewContentIn(List<String> values) {
            addCriterion("move_new_content in", values, "moveNewContent");
            return (Criteria) this;
        }

        public Criteria andMoveNewContentNotIn(List<String> values) {
            addCriterion("move_new_content not in", values, "moveNewContent");
            return (Criteria) this;
        }

        public Criteria andMoveNewContentBetween(String value1, String value2) {
            addCriterion("move_new_content between", value1, value2, "moveNewContent");
            return (Criteria) this;
        }

        public Criteria andMoveNewContentNotBetween(String value1, String value2) {
            addCriterion("move_new_content not between", value1, value2, "moveNewContent");
            return (Criteria) this;
        }

        public Criteria andMoveNewImgIsNull() {
            addCriterion("move_new_img is null");
            return (Criteria) this;
        }

        public Criteria andMoveNewImgIsNotNull() {
            addCriterion("move_new_img is not null");
            return (Criteria) this;
        }

        public Criteria andMoveNewImgEqualTo(String value) {
            addCriterion("move_new_img =", value, "moveNewImg");
            return (Criteria) this;
        }

        public Criteria andMoveNewImgNotEqualTo(String value) {
            addCriterion("move_new_img <>", value, "moveNewImg");
            return (Criteria) this;
        }

        public Criteria andMoveNewImgGreaterThan(String value) {
            addCriterion("move_new_img >", value, "moveNewImg");
            return (Criteria) this;
        }

        public Criteria andMoveNewImgGreaterThanOrEqualTo(String value) {
            addCriterion("move_new_img >=", value, "moveNewImg");
            return (Criteria) this;
        }

        public Criteria andMoveNewImgLessThan(String value) {
            addCriterion("move_new_img <", value, "moveNewImg");
            return (Criteria) this;
        }

        public Criteria andMoveNewImgLessThanOrEqualTo(String value) {
            addCriterion("move_new_img <=", value, "moveNewImg");
            return (Criteria) this;
        }

        public Criteria andMoveNewImgLike(String value) {
            addCriterion("move_new_img like", value, "moveNewImg");
            return (Criteria) this;
        }

        public Criteria andMoveNewImgNotLike(String value) {
            addCriterion("move_new_img not like", value, "moveNewImg");
            return (Criteria) this;
        }

        public Criteria andMoveNewImgIn(List<String> values) {
            addCriterion("move_new_img in", values, "moveNewImg");
            return (Criteria) this;
        }

        public Criteria andMoveNewImgNotIn(List<String> values) {
            addCriterion("move_new_img not in", values, "moveNewImg");
            return (Criteria) this;
        }

        public Criteria andMoveNewImgBetween(String value1, String value2) {
            addCriterion("move_new_img between", value1, value2, "moveNewImg");
            return (Criteria) this;
        }

        public Criteria andMoveNewImgNotBetween(String value1, String value2) {
            addCriterion("move_new_img not between", value1, value2, "moveNewImg");
            return (Criteria) this;
        }

        public Criteria andMerchantNameIsNull() {
            addCriterion("merchant_name is null");
            return (Criteria) this;
        }

        public Criteria andMerchantNameIsNotNull() {
            addCriterion("merchant_name is not null");
            return (Criteria) this;
        }

        public Criteria andMerchantNameEqualTo(String value) {
            addCriterion("merchant_name =", value, "merchantName");
            return (Criteria) this;
        }

        public Criteria andMerchantNameNotEqualTo(String value) {
            addCriterion("merchant_name <>", value, "merchantName");
            return (Criteria) this;
        }

        public Criteria andMerchantNameGreaterThan(String value) {
            addCriterion("merchant_name >", value, "merchantName");
            return (Criteria) this;
        }

        public Criteria andMerchantNameGreaterThanOrEqualTo(String value) {
            addCriterion("merchant_name >=", value, "merchantName");
            return (Criteria) this;
        }

        public Criteria andMerchantNameLessThan(String value) {
            addCriterion("merchant_name <", value, "merchantName");
            return (Criteria) this;
        }

        public Criteria andMerchantNameLessThanOrEqualTo(String value) {
            addCriterion("merchant_name <=", value, "merchantName");
            return (Criteria) this;
        }

        public Criteria andMerchantNameLike(String value) {
            addCriterion("merchant_name like", value, "merchantName");
            return (Criteria) this;
        }

        public Criteria andMerchantNameNotLike(String value) {
            addCriterion("merchant_name not like", value, "merchantName");
            return (Criteria) this;
        }

        public Criteria andMerchantNameIn(List<String> values) {
            addCriterion("merchant_name in", values, "merchantName");
            return (Criteria) this;
        }

        public Criteria andMerchantNameNotIn(List<String> values) {
            addCriterion("merchant_name not in", values, "merchantName");
            return (Criteria) this;
        }

        public Criteria andMerchantNameBetween(String value1, String value2) {
            addCriterion("merchant_name between", value1, value2, "merchantName");
            return (Criteria) this;
        }

        public Criteria andMerchantNameNotBetween(String value1, String value2) {
            addCriterion("merchant_name not between", value1, value2, "merchantName");
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