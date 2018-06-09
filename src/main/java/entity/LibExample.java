package entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class LibExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public LibExample() {
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

        protected void addCriterionForJDBCDate(String condition, Date value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            addCriterion(condition, new java.sql.Date(value.getTime()), property);
        }

        protected void addCriterionForJDBCDate(String condition, List<Date> values, String property) {
            if (values == null || values.size() == 0) {
                throw new RuntimeException("Value list for " + property + " cannot be null or empty");
            }
            List<java.sql.Date> dateList = new ArrayList<java.sql.Date>();
            Iterator<Date> iter = values.iterator();
            while (iter.hasNext()) {
                dateList.add(new java.sql.Date(iter.next().getTime()));
            }
            addCriterion(condition, dateList, property);
        }

        protected void addCriterionForJDBCDate(String condition, Date value1, Date value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            addCriterion(condition, new java.sql.Date(value1.getTime()), new java.sql.Date(value2.getTime()), property);
        }

        public Criteria andLibIdIsNull() {
            addCriterion("libId is null");
            return (Criteria) this;
        }

        public Criteria andLibIdIsNotNull() {
            addCriterion("libId is not null");
            return (Criteria) this;
        }

        public Criteria andLibIdEqualTo(Integer value) {
            addCriterion("libId =", value, "libId");
            return (Criteria) this;
        }

        public Criteria andLibIdNotEqualTo(Integer value) {
            addCriterion("libId <>", value, "libId");
            return (Criteria) this;
        }

        public Criteria andLibIdGreaterThan(Integer value) {
            addCriterion("libId >", value, "libId");
            return (Criteria) this;
        }

        public Criteria andLibIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("libId >=", value, "libId");
            return (Criteria) this;
        }

        public Criteria andLibIdLessThan(Integer value) {
            addCriterion("libId <", value, "libId");
            return (Criteria) this;
        }

        public Criteria andLibIdLessThanOrEqualTo(Integer value) {
            addCriterion("libId <=", value, "libId");
            return (Criteria) this;
        }

        public Criteria andLibIdIn(List<Integer> values) {
            addCriterion("libId in", values, "libId");
            return (Criteria) this;
        }

        public Criteria andLibIdNotIn(List<Integer> values) {
            addCriterion("libId not in", values, "libId");
            return (Criteria) this;
        }

        public Criteria andLibIdBetween(Integer value1, Integer value2) {
            addCriterion("libId between", value1, value2, "libId");
            return (Criteria) this;
        }

        public Criteria andLibIdNotBetween(Integer value1, Integer value2) {
            addCriterion("libId not between", value1, value2, "libId");
            return (Criteria) this;
        }

        public Criteria andLibNameIsNull() {
            addCriterion("libName is null");
            return (Criteria) this;
        }

        public Criteria andLibNameIsNotNull() {
            addCriterion("libName is not null");
            return (Criteria) this;
        }

        public Criteria andLibNameEqualTo(String value) {
            addCriterion("libName =", value, "libName");
            return (Criteria) this;
        }

        public Criteria andLibNameNotEqualTo(String value) {
            addCriterion("libName <>", value, "libName");
            return (Criteria) this;
        }

        public Criteria andLibNameGreaterThan(String value) {
            addCriterion("libName >", value, "libName");
            return (Criteria) this;
        }

        public Criteria andLibNameGreaterThanOrEqualTo(String value) {
            addCriterion("libName >=", value, "libName");
            return (Criteria) this;
        }

        public Criteria andLibNameLessThan(String value) {
            addCriterion("libName <", value, "libName");
            return (Criteria) this;
        }

        public Criteria andLibNameLessThanOrEqualTo(String value) {
            addCriterion("libName <=", value, "libName");
            return (Criteria) this;
        }

        public Criteria andLibNameLike(String value) {
            addCriterion("libName like", value, "libName");
            return (Criteria) this;
        }

        public Criteria andLibNameNotLike(String value) {
            addCriterion("libName not like", value, "libName");
            return (Criteria) this;
        }

        public Criteria andLibNameIn(List<String> values) {
            addCriterion("libName in", values, "libName");
            return (Criteria) this;
        }

        public Criteria andLibNameNotIn(List<String> values) {
            addCriterion("libName not in", values, "libName");
            return (Criteria) this;
        }

        public Criteria andLibNameBetween(String value1, String value2) {
            addCriterion("libName between", value1, value2, "libName");
            return (Criteria) this;
        }

        public Criteria andLibNameNotBetween(String value1, String value2) {
            addCriterion("libName not between", value1, value2, "libName");
            return (Criteria) this;
        }

        public Criteria andLibProfileIsNull() {
            addCriterion("libProfile is null");
            return (Criteria) this;
        }

        public Criteria andLibProfileIsNotNull() {
            addCriterion("libProfile is not null");
            return (Criteria) this;
        }

        public Criteria andLibProfileEqualTo(String value) {
            addCriterion("libProfile =", value, "libProfile");
            return (Criteria) this;
        }

        public Criteria andLibProfileNotEqualTo(String value) {
            addCriterion("libProfile <>", value, "libProfile");
            return (Criteria) this;
        }

        public Criteria andLibProfileGreaterThan(String value) {
            addCriterion("libProfile >", value, "libProfile");
            return (Criteria) this;
        }

        public Criteria andLibProfileGreaterThanOrEqualTo(String value) {
            addCriterion("libProfile >=", value, "libProfile");
            return (Criteria) this;
        }

        public Criteria andLibProfileLessThan(String value) {
            addCriterion("libProfile <", value, "libProfile");
            return (Criteria) this;
        }

        public Criteria andLibProfileLessThanOrEqualTo(String value) {
            addCriterion("libProfile <=", value, "libProfile");
            return (Criteria) this;
        }

        public Criteria andLibProfileLike(String value) {
            addCriterion("libProfile like", value, "libProfile");
            return (Criteria) this;
        }

        public Criteria andLibProfileNotLike(String value) {
            addCriterion("libProfile not like", value, "libProfile");
            return (Criteria) this;
        }

        public Criteria andLibProfileIn(List<String> values) {
            addCriterion("libProfile in", values, "libProfile");
            return (Criteria) this;
        }

        public Criteria andLibProfileNotIn(List<String> values) {
            addCriterion("libProfile not in", values, "libProfile");
            return (Criteria) this;
        }

        public Criteria andLibProfileBetween(String value1, String value2) {
            addCriterion("libProfile between", value1, value2, "libProfile");
            return (Criteria) this;
        }

        public Criteria andLibProfileNotBetween(String value1, String value2) {
            addCriterion("libProfile not between", value1, value2, "libProfile");
            return (Criteria) this;
        }

        public Criteria andTeamIdIsNull() {
            addCriterion("teamId is null");
            return (Criteria) this;
        }

        public Criteria andTeamIdIsNotNull() {
            addCriterion("teamId is not null");
            return (Criteria) this;
        }

        public Criteria andTeamIdEqualTo(Integer value) {
            addCriterion("teamId =", value, "teamId");
            return (Criteria) this;
        }

        public Criteria andTeamIdNotEqualTo(Integer value) {
            addCriterion("teamId <>", value, "teamId");
            return (Criteria) this;
        }

        public Criteria andTeamIdGreaterThan(Integer value) {
            addCriterion("teamId >", value, "teamId");
            return (Criteria) this;
        }

        public Criteria andTeamIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("teamId >=", value, "teamId");
            return (Criteria) this;
        }

        public Criteria andTeamIdLessThan(Integer value) {
            addCriterion("teamId <", value, "teamId");
            return (Criteria) this;
        }

        public Criteria andTeamIdLessThanOrEqualTo(Integer value) {
            addCriterion("teamId <=", value, "teamId");
            return (Criteria) this;
        }

        public Criteria andTeamIdIn(List<Integer> values) {
            addCriterion("teamId in", values, "teamId");
            return (Criteria) this;
        }

        public Criteria andTeamIdNotIn(List<Integer> values) {
            addCriterion("teamId not in", values, "teamId");
            return (Criteria) this;
        }

        public Criteria andTeamIdBetween(Integer value1, Integer value2) {
            addCriterion("teamId between", value1, value2, "teamId");
            return (Criteria) this;
        }

        public Criteria andTeamIdNotBetween(Integer value1, Integer value2) {
            addCriterion("teamId not between", value1, value2, "teamId");
            return (Criteria) this;
        }

        public Criteria andCreateDateIsNull() {
            addCriterion("createDate is null");
            return (Criteria) this;
        }

        public Criteria andCreateDateIsNotNull() {
            addCriterion("createDate is not null");
            return (Criteria) this;
        }

        public Criteria andCreateDateEqualTo(Date value) {
            addCriterionForJDBCDate("createDate =", value, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateNotEqualTo(Date value) {
            addCriterionForJDBCDate("createDate <>", value, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateGreaterThan(Date value) {
            addCriterionForJDBCDate("createDate >", value, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("createDate >=", value, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateLessThan(Date value) {
            addCriterionForJDBCDate("createDate <", value, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("createDate <=", value, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateIn(List<Date> values) {
            addCriterionForJDBCDate("createDate in", values, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateNotIn(List<Date> values) {
            addCriterionForJDBCDate("createDate not in", values, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("createDate between", value1, value2, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("createDate not between", value1, value2, "createDate");
            return (Criteria) this;
        }

        public Criteria andStatusIsNull() {
            addCriterion("status is null");
            return (Criteria) this;
        }

        public Criteria andStatusIsNotNull() {
            addCriterion("status is not null");
            return (Criteria) this;
        }

        public Criteria andStatusEqualTo(Integer value) {
            addCriterion("status =", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotEqualTo(Integer value) {
            addCriterion("status <>", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThan(Integer value) {
            addCriterion("status >", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThanOrEqualTo(Integer value) {
            addCriterion("status >=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThan(Integer value) {
            addCriterion("status <", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThanOrEqualTo(Integer value) {
            addCriterion("status <=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusIn(List<Integer> values) {
            addCriterion("status in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotIn(List<Integer> values) {
            addCriterion("status not in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusBetween(Integer value1, Integer value2) {
            addCriterion("status between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotBetween(Integer value1, Integer value2) {
            addCriterion("status not between", value1, value2, "status");
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