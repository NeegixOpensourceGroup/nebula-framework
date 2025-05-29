package com.neegix.system.dict.application.cqrs.query.condition;

import com.neegix.application.query.EnumOperator;
import com.neegix.application.query.WhereGroups;

import java.util.List;

/**
 * Created by IntelliJ IDEA (Community Edition)
 * Thank you to JetBrains for their contributions to the vast number of developers
 *
 * @Author: kushu001
 * @Date: 2024/10/17/11:30
 * @Description:
 */

public class DictGroupWhereGroup extends WhereGroups {

    public DictGroupWhereGroup andIdIsNull() {
        addCriterion("id", EnumOperator.IS_NULL, null);
        return this;
    }

    public DictGroupWhereGroup andIdIsNotNull() {
        addCriterion("id", EnumOperator.IS_NOT_NULL, null);
        return this;
    }

    public DictGroupWhereGroup andIdEqualTo(Long value) {
        addCriterion("id", EnumOperator.EQUAL, value);
        return this;
    }

    public DictGroupWhereGroup andIdBetween(Long value1, Long value2) {
        addCriterion("id", EnumOperator.GREATER_EQUAL_THAN, value1);
        addCriterion("id", EnumOperator.LESS_EQUAL_THAN, value2);
        return this;
    }

    public DictGroupWhereGroup andIdNotBetween(Long value1, Long value2) {
        addCriterion("id", EnumOperator.LESS_THAN, value1);
        addCriterion("id", EnumOperator.GREATER_THAN, value2);
        return this;
    }

    public DictGroupWhereGroup andNameIsNull() {
        addCriterion("name", EnumOperator.IS_NULL, null);
        return this;
    }

    public DictGroupWhereGroup andNameIsNotNull() {
        addCriterion("name", EnumOperator.IS_NOT_NULL, null);
        return this;
    }

    public DictGroupWhereGroup andNameEqualTo(String value) {
        addCriterion("name", EnumOperator.EQUAL, value);
        return this;
    }

    public DictGroupWhereGroup andNameLikeTo(String value) {
        addCriterion("name", EnumOperator.LIKE, true, value, true);
        return this;
    }


    public DictGroupWhereGroup andNameLikeTo(boolean prefix, String value) {
        addCriterion("name", EnumOperator.LIKE, prefix, value, false);
        return this;
    }


    public DictGroupWhereGroup andNameLikeTo(String value, boolean suffix) {
        addCriterion("name", EnumOperator.LIKE, false, value, suffix);
        return this;
    }

    public DictGroupWhereGroup andNameNotLikeTo(String value) {
        addCriterion("name", EnumOperator.NOT_LIKE, true, value, true);
        return this;
    }


    public DictGroupWhereGroup andNameNotLikeTo(boolean prefix, String value) {
        addCriterion("name", EnumOperator.NOT_LIKE, prefix, value, false);
        return this;
    }



    public DictGroupWhereGroup andNameIn(List<String> list) {
        addCriterion("name", EnumOperator.IN, list);
        return this;
    }


    public DictGroupWhereGroup andNameNotIn(List<String> list) {
        addCriterion("name", EnumOperator.NOT_IN, list);
        return this;
    }

    public DictGroupWhereGroup andCodeEqualTo(String value) {
        addCriterion("code", EnumOperator.EQUAL, value);
        return this;
    }

}
