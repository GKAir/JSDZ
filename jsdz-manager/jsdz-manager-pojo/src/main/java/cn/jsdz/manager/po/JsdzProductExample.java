package cn.jsdz.manager.po;

import java.util.ArrayList;
import java.util.List;

public class JsdzProductExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public JsdzProductExample() {
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
            addCriterion("Id is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("Id is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(Integer value) {
            addCriterion("Id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Integer value) {
            addCriterion("Id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Integer value) {
            addCriterion("Id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("Id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Integer value) {
            addCriterion("Id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Integer value) {
            addCriterion("Id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Integer> values) {
            addCriterion("Id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Integer> values) {
            addCriterion("Id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Integer value1, Integer value2) {
            addCriterion("Id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Integer value1, Integer value2) {
            addCriterion("Id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andTypeIdIsNull() {
            addCriterion("type_id is null");
            return (Criteria) this;
        }

        public Criteria andTypeIdIsNotNull() {
            addCriterion("type_id is not null");
            return (Criteria) this;
        }

        public Criteria andTypeIdEqualTo(Integer value) {
            addCriterion("type_id =", value, "typeId");
            return (Criteria) this;
        }

        public Criteria andTypeIdNotEqualTo(Integer value) {
            addCriterion("type_id <>", value, "typeId");
            return (Criteria) this;
        }

        public Criteria andTypeIdGreaterThan(Integer value) {
            addCriterion("type_id >", value, "typeId");
            return (Criteria) this;
        }

        public Criteria andTypeIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("type_id >=", value, "typeId");
            return (Criteria) this;
        }

        public Criteria andTypeIdLessThan(Integer value) {
            addCriterion("type_id <", value, "typeId");
            return (Criteria) this;
        }

        public Criteria andTypeIdLessThanOrEqualTo(Integer value) {
            addCriterion("type_id <=", value, "typeId");
            return (Criteria) this;
        }

        public Criteria andTypeIdIn(List<Integer> values) {
            addCriterion("type_id in", values, "typeId");
            return (Criteria) this;
        }

        public Criteria andTypeIdNotIn(List<Integer> values) {
            addCriterion("type_id not in", values, "typeId");
            return (Criteria) this;
        }

        public Criteria andTypeIdBetween(Integer value1, Integer value2) {
            addCriterion("type_id between", value1, value2, "typeId");
            return (Criteria) this;
        }

        public Criteria andTypeIdNotBetween(Integer value1, Integer value2) {
            addCriterion("type_id not between", value1, value2, "typeId");
            return (Criteria) this;
        }

        public Criteria andThickIdIsNull() {
            addCriterion("thick_id is null");
            return (Criteria) this;
        }

        public Criteria andThickIdIsNotNull() {
            addCriterion("thick_id is not null");
            return (Criteria) this;
        }

        public Criteria andThickIdEqualTo(Integer value) {
            addCriterion("thick_id =", value, "thickId");
            return (Criteria) this;
        }

        public Criteria andThickIdNotEqualTo(Integer value) {
            addCriterion("thick_id <>", value, "thickId");
            return (Criteria) this;
        }

        public Criteria andThickIdGreaterThan(Integer value) {
            addCriterion("thick_id >", value, "thickId");
            return (Criteria) this;
        }

        public Criteria andThickIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("thick_id >=", value, "thickId");
            return (Criteria) this;
        }

        public Criteria andThickIdLessThan(Integer value) {
            addCriterion("thick_id <", value, "thickId");
            return (Criteria) this;
        }

        public Criteria andThickIdLessThanOrEqualTo(Integer value) {
            addCriterion("thick_id <=", value, "thickId");
            return (Criteria) this;
        }

        public Criteria andThickIdIn(List<Integer> values) {
            addCriterion("thick_id in", values, "thickId");
            return (Criteria) this;
        }

        public Criteria andThickIdNotIn(List<Integer> values) {
            addCriterion("thick_id not in", values, "thickId");
            return (Criteria) this;
        }

        public Criteria andThickIdBetween(Integer value1, Integer value2) {
            addCriterion("thick_id between", value1, value2, "thickId");
            return (Criteria) this;
        }

        public Criteria andThickIdNotBetween(Integer value1, Integer value2) {
            addCriterion("thick_id not between", value1, value2, "thickId");
            return (Criteria) this;
        }

        public Criteria andNmcThickIdIsNull() {
            addCriterion("nmc_thick_id is null");
            return (Criteria) this;
        }

        public Criteria andNmcThickIdIsNotNull() {
            addCriterion("nmc_thick_id is not null");
            return (Criteria) this;
        }

        public Criteria andNmcThickIdEqualTo(Integer value) {
            addCriterion("nmc_thick_id =", value, "nmcThickId");
            return (Criteria) this;
        }

        public Criteria andNmcThickIdNotEqualTo(Integer value) {
            addCriterion("nmc_thick_id <>", value, "nmcThickId");
            return (Criteria) this;
        }

        public Criteria andNmcThickIdGreaterThan(Integer value) {
            addCriterion("nmc_thick_id >", value, "nmcThickId");
            return (Criteria) this;
        }

        public Criteria andNmcThickIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("nmc_thick_id >=", value, "nmcThickId");
            return (Criteria) this;
        }

        public Criteria andNmcThickIdLessThan(Integer value) {
            addCriterion("nmc_thick_id <", value, "nmcThickId");
            return (Criteria) this;
        }

        public Criteria andNmcThickIdLessThanOrEqualTo(Integer value) {
            addCriterion("nmc_thick_id <=", value, "nmcThickId");
            return (Criteria) this;
        }

        public Criteria andNmcThickIdIn(List<Integer> values) {
            addCriterion("nmc_thick_id in", values, "nmcThickId");
            return (Criteria) this;
        }

        public Criteria andNmcThickIdNotIn(List<Integer> values) {
            addCriterion("nmc_thick_id not in", values, "nmcThickId");
            return (Criteria) this;
        }

        public Criteria andNmcThickIdBetween(Integer value1, Integer value2) {
            addCriterion("nmc_thick_id between", value1, value2, "nmcThickId");
            return (Criteria) this;
        }

        public Criteria andNmcThickIdNotBetween(Integer value1, Integer value2) {
            addCriterion("nmc_thick_id not between", value1, value2, "nmcThickId");
            return (Criteria) this;
        }

        public Criteria andBackIsNull() {
            addCriterion("back is null");
            return (Criteria) this;
        }

        public Criteria andBackIsNotNull() {
            addCriterion("back is not null");
            return (Criteria) this;
        }

        public Criteria andBackEqualTo(Integer value) {
            addCriterion("back =", value, "back");
            return (Criteria) this;
        }

        public Criteria andBackNotEqualTo(Integer value) {
            addCriterion("back <>", value, "back");
            return (Criteria) this;
        }

        public Criteria andBackGreaterThan(Integer value) {
            addCriterion("back >", value, "back");
            return (Criteria) this;
        }

        public Criteria andBackGreaterThanOrEqualTo(Integer value) {
            addCriterion("back >=", value, "back");
            return (Criteria) this;
        }

        public Criteria andBackLessThan(Integer value) {
            addCriterion("back <", value, "back");
            return (Criteria) this;
        }

        public Criteria andBackLessThanOrEqualTo(Integer value) {
            addCriterion("back <=", value, "back");
            return (Criteria) this;
        }

        public Criteria andBackIn(List<Integer> values) {
            addCriterion("back in", values, "back");
            return (Criteria) this;
        }

        public Criteria andBackNotIn(List<Integer> values) {
            addCriterion("back not in", values, "back");
            return (Criteria) this;
        }

        public Criteria andBackBetween(Integer value1, Integer value2) {
            addCriterion("back between", value1, value2, "back");
            return (Criteria) this;
        }

        public Criteria andBackNotBetween(Integer value1, Integer value2) {
            addCriterion("back not between", value1, value2, "back");
            return (Criteria) this;
        }

        public Criteria andLengthIsNull() {
            addCriterion("length is null");
            return (Criteria) this;
        }

        public Criteria andLengthIsNotNull() {
            addCriterion("length is not null");
            return (Criteria) this;
        }

        public Criteria andLengthEqualTo(Float value) {
            addCriterion("length =", value, "length");
            return (Criteria) this;
        }

        public Criteria andLengthNotEqualTo(Float value) {
            addCriterion("length <>", value, "length");
            return (Criteria) this;
        }

        public Criteria andLengthGreaterThan(Float value) {
            addCriterion("length >", value, "length");
            return (Criteria) this;
        }

        public Criteria andLengthGreaterThanOrEqualTo(Float value) {
            addCriterion("length >=", value, "length");
            return (Criteria) this;
        }

        public Criteria andLengthLessThan(Float value) {
            addCriterion("length <", value, "length");
            return (Criteria) this;
        }

        public Criteria andLengthLessThanOrEqualTo(Float value) {
            addCriterion("length <=", value, "length");
            return (Criteria) this;
        }

        public Criteria andLengthIn(List<Float> values) {
            addCriterion("length in", values, "length");
            return (Criteria) this;
        }

        public Criteria andLengthNotIn(List<Float> values) {
            addCriterion("length not in", values, "length");
            return (Criteria) this;
        }

        public Criteria andLengthBetween(Float value1, Float value2) {
            addCriterion("length between", value1, value2, "length");
            return (Criteria) this;
        }

        public Criteria andLengthNotBetween(Float value1, Float value2) {
            addCriterion("length not between", value1, value2, "length");
            return (Criteria) this;
        }

        public Criteria andWidthIsNull() {
            addCriterion("width is null");
            return (Criteria) this;
        }

        public Criteria andWidthIsNotNull() {
            addCriterion("width is not null");
            return (Criteria) this;
        }

        public Criteria andWidthEqualTo(Float value) {
            addCriterion("width =", value, "width");
            return (Criteria) this;
        }

        public Criteria andWidthNotEqualTo(Float value) {
            addCriterion("width <>", value, "width");
            return (Criteria) this;
        }

        public Criteria andWidthGreaterThan(Float value) {
            addCriterion("width >", value, "width");
            return (Criteria) this;
        }

        public Criteria andWidthGreaterThanOrEqualTo(Float value) {
            addCriterion("width >=", value, "width");
            return (Criteria) this;
        }

        public Criteria andWidthLessThan(Float value) {
            addCriterion("width <", value, "width");
            return (Criteria) this;
        }

        public Criteria andWidthLessThanOrEqualTo(Float value) {
            addCriterion("width <=", value, "width");
            return (Criteria) this;
        }

        public Criteria andWidthIn(List<Float> values) {
            addCriterion("width in", values, "width");
            return (Criteria) this;
        }

        public Criteria andWidthNotIn(List<Float> values) {
            addCriterion("width not in", values, "width");
            return (Criteria) this;
        }

        public Criteria andWidthBetween(Float value1, Float value2) {
            addCriterion("width between", value1, value2, "width");
            return (Criteria) this;
        }

        public Criteria andWidthNotBetween(Float value1, Float value2) {
            addCriterion("width not between", value1, value2, "width");
            return (Criteria) this;
        }

        public Criteria andMaterialIsNull() {
            addCriterion("material is null");
            return (Criteria) this;
        }

        public Criteria andMaterialIsNotNull() {
            addCriterion("material is not null");
            return (Criteria) this;
        }

        public Criteria andMaterialEqualTo(Integer value) {
            addCriterion("material =", value, "material");
            return (Criteria) this;
        }

        public Criteria andMaterialNotEqualTo(Integer value) {
            addCriterion("material <>", value, "material");
            return (Criteria) this;
        }

        public Criteria andMaterialGreaterThan(Integer value) {
            addCriterion("material >", value, "material");
            return (Criteria) this;
        }

        public Criteria andMaterialGreaterThanOrEqualTo(Integer value) {
            addCriterion("material >=", value, "material");
            return (Criteria) this;
        }

        public Criteria andMaterialLessThan(Integer value) {
            addCriterion("material <", value, "material");
            return (Criteria) this;
        }

        public Criteria andMaterialLessThanOrEqualTo(Integer value) {
            addCriterion("material <=", value, "material");
            return (Criteria) this;
        }

        public Criteria andMaterialIn(List<Integer> values) {
            addCriterion("material in", values, "material");
            return (Criteria) this;
        }

        public Criteria andMaterialNotIn(List<Integer> values) {
            addCriterion("material not in", values, "material");
            return (Criteria) this;
        }

        public Criteria andMaterialBetween(Integer value1, Integer value2) {
            addCriterion("material between", value1, value2, "material");
            return (Criteria) this;
        }

        public Criteria andMaterialNotBetween(Integer value1, Integer value2) {
            addCriterion("material not between", value1, value2, "material");
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