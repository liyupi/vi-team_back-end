package entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class CommitExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public CommitExample() {
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

        public Criteria andCommitIdIsNull() {
            addCriterion("commitId is null");
            return (Criteria) this;
        }

        public Criteria andCommitIdIsNotNull() {
            addCriterion("commitId is not null");
            return (Criteria) this;
        }

        public Criteria andCommitIdEqualTo(Integer value) {
            addCriterion("commitId =", value, "commitId");
            return (Criteria) this;
        }

        public Criteria andCommitIdNotEqualTo(Integer value) {
            addCriterion("commitId <>", value, "commitId");
            return (Criteria) this;
        }

        public Criteria andCommitIdGreaterThan(Integer value) {
            addCriterion("commitId >", value, "commitId");
            return (Criteria) this;
        }

        public Criteria andCommitIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("commitId >=", value, "commitId");
            return (Criteria) this;
        }

        public Criteria andCommitIdLessThan(Integer value) {
            addCriterion("commitId <", value, "commitId");
            return (Criteria) this;
        }

        public Criteria andCommitIdLessThanOrEqualTo(Integer value) {
            addCriterion("commitId <=", value, "commitId");
            return (Criteria) this;
        }

        public Criteria andCommitIdIn(List<Integer> values) {
            addCriterion("commitId in", values, "commitId");
            return (Criteria) this;
        }

        public Criteria andCommitIdNotIn(List<Integer> values) {
            addCriterion("commitId not in", values, "commitId");
            return (Criteria) this;
        }

        public Criteria andCommitIdBetween(Integer value1, Integer value2) {
            addCriterion("commitId between", value1, value2, "commitId");
            return (Criteria) this;
        }

        public Criteria andCommitIdNotBetween(Integer value1, Integer value2) {
            addCriterion("commitId not between", value1, value2, "commitId");
            return (Criteria) this;
        }

        public Criteria andTitleIsNull() {
            addCriterion("title is null");
            return (Criteria) this;
        }

        public Criteria andTitleIsNotNull() {
            addCriterion("title is not null");
            return (Criteria) this;
        }

        public Criteria andTitleEqualTo(String value) {
            addCriterion("title =", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleNotEqualTo(String value) {
            addCriterion("title <>", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleGreaterThan(String value) {
            addCriterion("title >", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleGreaterThanOrEqualTo(String value) {
            addCriterion("title >=", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleLessThan(String value) {
            addCriterion("title <", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleLessThanOrEqualTo(String value) {
            addCriterion("title <=", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleLike(String value) {
            addCriterion("title like", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleNotLike(String value) {
            addCriterion("title not like", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleIn(List<String> values) {
            addCriterion("title in", values, "title");
            return (Criteria) this;
        }

        public Criteria andTitleNotIn(List<String> values) {
            addCriterion("title not in", values, "title");
            return (Criteria) this;
        }

        public Criteria andTitleBetween(String value1, String value2) {
            addCriterion("title between", value1, value2, "title");
            return (Criteria) this;
        }

        public Criteria andTitleNotBetween(String value1, String value2) {
            addCriterion("title not between", value1, value2, "title");
            return (Criteria) this;
        }

        public Criteria andCommitTimeIsNull() {
            addCriterion("commitTime is null");
            return (Criteria) this;
        }

        public Criteria andCommitTimeIsNotNull() {
            addCriterion("commitTime is not null");
            return (Criteria) this;
        }

        public Criteria andCommitTimeEqualTo(Date value) {
            addCriterion("commitTime =", value, "commitTime");
            return (Criteria) this;
        }

        public Criteria andCommitTimeNotEqualTo(Date value) {
            addCriterion("commitTime <>", value, "commitTime");
            return (Criteria) this;
        }

        public Criteria andCommitTimeGreaterThan(Date value) {
            addCriterion("commitTime >", value, "commitTime");
            return (Criteria) this;
        }

        public Criteria andCommitTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("commitTime >=", value, "commitTime");
            return (Criteria) this;
        }

        public Criteria andCommitTimeLessThan(Date value) {
            addCriterion("commitTime <", value, "commitTime");
            return (Criteria) this;
        }

        public Criteria andCommitTimeLessThanOrEqualTo(Date value) {
            addCriterion("commitTime <=", value, "commitTime");
            return (Criteria) this;
        }

        public Criteria andCommitTimeIn(List<Date> values) {
            addCriterion("commitTime in", values, "commitTime");
            return (Criteria) this;
        }

        public Criteria andCommitTimeNotIn(List<Date> values) {
            addCriterion("commitTime not in", values, "commitTime");
            return (Criteria) this;
        }

        public Criteria andCommitTimeBetween(Date value1, Date value2) {
            addCriterion("commitTime between", value1, value2, "commitTime");
            return (Criteria) this;
        }

        public Criteria andCommitTimeNotBetween(Date value1, Date value2) {
            addCriterion("commitTime not between", value1, value2, "commitTime");
            return (Criteria) this;
        }

        public Criteria andCommitterIdIsNull() {
            addCriterion("committerId is null");
            return (Criteria) this;
        }

        public Criteria andCommitterIdIsNotNull() {
            addCriterion("committerId is not null");
            return (Criteria) this;
        }

        public Criteria andCommitterIdEqualTo(String value) {
            addCriterion("committerId =", value, "committerId");
            return (Criteria) this;
        }

        public Criteria andCommitterIdNotEqualTo(String value) {
            addCriterion("committerId <>", value, "committerId");
            return (Criteria) this;
        }

        public Criteria andCommitterIdGreaterThan(String value) {
            addCriterion("committerId >", value, "committerId");
            return (Criteria) this;
        }

        public Criteria andCommitterIdGreaterThanOrEqualTo(String value) {
            addCriterion("committerId >=", value, "committerId");
            return (Criteria) this;
        }

        public Criteria andCommitterIdLessThan(String value) {
            addCriterion("committerId <", value, "committerId");
            return (Criteria) this;
        }

        public Criteria andCommitterIdLessThanOrEqualTo(String value) {
            addCriterion("committerId <=", value, "committerId");
            return (Criteria) this;
        }

        public Criteria andCommitterIdLike(String value) {
            addCriterion("committerId like", value, "committerId");
            return (Criteria) this;
        }

        public Criteria andCommitterIdNotLike(String value) {
            addCriterion("committerId not like", value, "committerId");
            return (Criteria) this;
        }

        public Criteria andCommitterIdIn(List<String> values) {
            addCriterion("committerId in", values, "committerId");
            return (Criteria) this;
        }

        public Criteria andCommitterIdNotIn(List<String> values) {
            addCriterion("committerId not in", values, "committerId");
            return (Criteria) this;
        }

        public Criteria andCommitterIdBetween(String value1, String value2) {
            addCriterion("committerId between", value1, value2, "committerId");
            return (Criteria) this;
        }

        public Criteria andCommitterIdNotBetween(String value1, String value2) {
            addCriterion("committerId not between", value1, value2, "committerId");
            return (Criteria) this;
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