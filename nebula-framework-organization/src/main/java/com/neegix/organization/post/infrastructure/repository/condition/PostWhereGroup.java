package com.neegix.organization.post.infrastructure.repository.condition;

import com.neegix.application.query.EnumOperator;
import com.neegix.application.query.WhereGroups;
import java.time.Instant;
import java.time.LocalDate;
import java.util.List;

 /**
  * This file is auto-generated by nebula-framework-generator.
  * The auto-generation plugin was developed using IntelliJ IDEA Community Edition.
  * Thanks to JetBrains for their outstanding contributions to the developer community.
  * <p>
  * The code generated by this tool is owned by the user of the tool.
  * The tool itself is copyrighted by <a href="https://www.neegix.com">https://www.neegix.com</a>.
  *
  * @author <a href="https://www.neegix.com">https://www.neegix.com</a>
  * @version 1.0.0
  * @since 2024-11-25 11:27:14
  */

public class PostWhereGroup extends WhereGroups {
    public PostWhereGroup andCodeIsNull() {
        addCriterion("code", EnumOperator.IS_NULL, null);
        return this;
    }

    public PostWhereGroup andCodeIsNotNull() {
        addCriterion("code", EnumOperator.IS_NOT_NULL, null);
        return this;
    }

    public PostWhereGroup andCodeEqualTo(String value) {
        addCriterion("code", EnumOperator.EQUAL, value);
        return this;
    }


    public PostWhereGroup andCodeNotEqualTo(String value) {
        addCriterion("code", EnumOperator.NOT_EQUAL, value);
        return this;
    }

    public PostWhereGroup andCodeBetween(String value1, String value2) {
        addCriterion("code", EnumOperator.GREATER_EQUAL_THAN, value1);
        addCriterion("code", EnumOperator.LESS_EQUAL_THAN, value2);
        return this;
    }


    public PostWhereGroup andCodeNotBetween(String value1, String value2) {
        addCriterion("code", EnumOperator.LESS_THAN, value1);
        addCriterion("code", EnumOperator.GREATER_THAN, value2);
        return this;
    }



    public PostWhereGroup andCodeLikeTo(String value) {
        addCriterion("code", EnumOperator.LIKE, true, value, true);
        return this;
    }


    public PostWhereGroup andCodeLikeTo(boolean prefix, String value) {
        addCriterion("code", EnumOperator.LIKE, prefix, value, false);
        return this;
    }


    public PostWhereGroup andCodeLikeTo(String value, boolean suffix) {
        addCriterion("code", EnumOperator.LIKE, false, value, suffix);
        return this;
    }




    public PostWhereGroup andCodeNotLikeTo(String value) {
        addCriterion("code", EnumOperator.NOT_LIKE, true, value, true);
        return this;
    }


    public PostWhereGroup andCodeNotLikeTo(boolean prefix, String value) {
        addCriterion("code", EnumOperator.NOT_LIKE, prefix, value, false);
        return this;
    }


    public PostWhereGroup andCodeNotLikeTo(String value, boolean suffix) {
        addCriterion("code", EnumOperator.NOT_LIKE, false, value, suffix);
        return this;
    }



    public PostWhereGroup andCodeIn(List<String> list) {
        addCriterion("code", EnumOperator.IN, list);
        return this;
    }


    public PostWhereGroup andCodeNotIn(List<String> list) {
        addCriterion("code", EnumOperator.NOT_IN, list);
        return this;
    }

    public PostWhereGroup andCreateTimeIsNull() {
        addCriterion("create_time", EnumOperator.IS_NULL, null);
        return this;
    }

    public PostWhereGroup andCreateTimeIsNotNull() {
        addCriterion("create_time", EnumOperator.IS_NOT_NULL, null);
        return this;
    }

    public PostWhereGroup andCreateTimeEqualTo(Instant value) {
        addCriterion("create_time", EnumOperator.EQUAL, value);
        return this;
    }


    public PostWhereGroup andCreateTimeNotEqualTo(Instant value) {
        addCriterion("create_time", EnumOperator.NOT_EQUAL, value);
        return this;
    }

    public PostWhereGroup andCreateTimeBetween(LocalDate value1, LocalDate value2) {
        addCriterion("create_time", EnumOperator.GREATER_EQUAL_THAN, value1);
        addCriterion("create_time", EnumOperator.LESS_EQUAL_THAN, value2);
        return this;
    }


    public PostWhereGroup andCreateTimeNotBetween(LocalDate value1, LocalDate value2) {
        addCriterion("create_time", EnumOperator.LESS_THAN, value1);
        addCriterion("create_time", EnumOperator.GREATER_THAN, value2);
        return this;
    }



    public PostWhereGroup andCreateTimeLikeTo(Instant value) {
        addCriterion("create_time", EnumOperator.LIKE, true, value, true);
        return this;
    }


    public PostWhereGroup andCreateTimeLikeTo(boolean prefix, Instant value) {
        addCriterion("create_time", EnumOperator.LIKE, prefix, value, false);
        return this;
    }


    public PostWhereGroup andCreateTimeLikeTo(Instant value, boolean suffix) {
        addCriterion("create_time", EnumOperator.LIKE, false, value, suffix);
        return this;
    }




    public PostWhereGroup andCreateTimeNotLikeTo(Instant value) {
        addCriterion("create_time", EnumOperator.NOT_LIKE, true, value, true);
        return this;
    }


    public PostWhereGroup andCreateTimeNotLikeTo(boolean prefix, Instant value) {
        addCriterion("create_time", EnumOperator.NOT_LIKE, prefix, value, false);
        return this;
    }


    public PostWhereGroup andCreateTimeNotLikeTo(Instant value, boolean suffix) {
        addCriterion("create_time", EnumOperator.NOT_LIKE, false, value, suffix);
        return this;
    }



    public PostWhereGroup andCreateTimeIn(List<Instant> list) {
        addCriterion("create_time", EnumOperator.IN, list);
        return this;
    }


    public PostWhereGroup andCreateTimeNotIn(List<Instant> list) {
        addCriterion("create_time", EnumOperator.NOT_IN, list);
        return this;
    }

    public PostWhereGroup andCreateUserIsNull() {
        addCriterion("create_user", EnumOperator.IS_NULL, null);
        return this;
    }

    public PostWhereGroup andCreateUserIsNotNull() {
        addCriterion("create_user", EnumOperator.IS_NOT_NULL, null);
        return this;
    }

    public PostWhereGroup andCreateUserEqualTo(Long value) {
        addCriterion("create_user", EnumOperator.EQUAL, value);
        return this;
    }


    public PostWhereGroup andCreateUserNotEqualTo(Long value) {
        addCriterion("create_user", EnumOperator.NOT_EQUAL, value);
        return this;
    }

    public PostWhereGroup andCreateUserBetween(Long value1, Long value2) {
        addCriterion("create_user", EnumOperator.GREATER_EQUAL_THAN, value1);
        addCriterion("create_user", EnumOperator.LESS_EQUAL_THAN, value2);
        return this;
    }


    public PostWhereGroup andCreateUserNotBetween(Long value1, Long value2) {
        addCriterion("create_user", EnumOperator.LESS_THAN, value1);
        addCriterion("create_user", EnumOperator.GREATER_THAN, value2);
        return this;
    }



    public PostWhereGroup andCreateUserLikeTo(Long value) {
        addCriterion("create_user", EnumOperator.LIKE, true, value, true);
        return this;
    }


    public PostWhereGroup andCreateUserLikeTo(boolean prefix, Long value) {
        addCriterion("create_user", EnumOperator.LIKE, prefix, value, false);
        return this;
    }


    public PostWhereGroup andCreateUserLikeTo(Long value, boolean suffix) {
        addCriterion("create_user", EnumOperator.LIKE, false, value, suffix);
        return this;
    }




    public PostWhereGroup andCreateUserNotLikeTo(Long value) {
        addCriterion("create_user", EnumOperator.NOT_LIKE, true, value, true);
        return this;
    }


    public PostWhereGroup andCreateUserNotLikeTo(boolean prefix, Long value) {
        addCriterion("create_user", EnumOperator.NOT_LIKE, prefix, value, false);
        return this;
    }


    public PostWhereGroup andCreateUserNotLikeTo(Long value, boolean suffix) {
        addCriterion("create_user", EnumOperator.NOT_LIKE, false, value, suffix);
        return this;
    }



    public PostWhereGroup andCreateUserIn(List<Long> list) {
        addCriterion("create_user", EnumOperator.IN, list);
        return this;
    }


    public PostWhereGroup andCreateUserNotIn(List<Long> list) {
        addCriterion("create_user", EnumOperator.NOT_IN, list);
        return this;
    }

    public PostWhereGroup andDeletedIsNull() {
        addCriterion("deleted", EnumOperator.IS_NULL, null);
        return this;
    }

    public PostWhereGroup andDeletedIsNotNull() {
        addCriterion("deleted", EnumOperator.IS_NOT_NULL, null);
        return this;
    }

    public PostWhereGroup andDeletedEqualTo(Boolean value) {
        addCriterion("deleted", EnumOperator.EQUAL, value);
        return this;
    }


    public PostWhereGroup andDeletedNotEqualTo(Boolean value) {
        addCriterion("deleted", EnumOperator.NOT_EQUAL, value);
        return this;
    }

    public PostWhereGroup andDeletedBetween(Boolean value1, Boolean value2) {
        addCriterion("deleted", EnumOperator.GREATER_EQUAL_THAN, value1);
        addCriterion("deleted", EnumOperator.LESS_EQUAL_THAN, value2);
        return this;
    }


    public PostWhereGroup andDeletedNotBetween(Boolean value1, Boolean value2) {
        addCriterion("deleted", EnumOperator.LESS_THAN, value1);
        addCriterion("deleted", EnumOperator.GREATER_THAN, value2);
        return this;
    }



    public PostWhereGroup andDeletedLikeTo(Boolean value) {
        addCriterion("deleted", EnumOperator.LIKE, true, value, true);
        return this;
    }


    public PostWhereGroup andDeletedLikeTo(boolean prefix, Boolean value) {
        addCriterion("deleted", EnumOperator.LIKE, prefix, value, false);
        return this;
    }


    public PostWhereGroup andDeletedLikeTo(Boolean value, boolean suffix) {
        addCriterion("deleted", EnumOperator.LIKE, false, value, suffix);
        return this;
    }




    public PostWhereGroup andDeletedNotLikeTo(Boolean value) {
        addCriterion("deleted", EnumOperator.NOT_LIKE, true, value, true);
        return this;
    }


    public PostWhereGroup andDeletedNotLikeTo(boolean prefix, Boolean value) {
        addCriterion("deleted", EnumOperator.NOT_LIKE, prefix, value, false);
        return this;
    }


    public PostWhereGroup andDeletedNotLikeTo(Boolean value, boolean suffix) {
        addCriterion("deleted", EnumOperator.NOT_LIKE, false, value, suffix);
        return this;
    }



    public PostWhereGroup andDeletedIn(List<Boolean> list) {
        addCriterion("deleted", EnumOperator.IN, list);
        return this;
    }


    public PostWhereGroup andDeletedNotIn(List<Boolean> list) {
        addCriterion("deleted", EnumOperator.NOT_IN, list);
        return this;
    }

    public PostWhereGroup andEnabledIsNull() {
        addCriterion("enabled", EnumOperator.IS_NULL, null);
        return this;
    }

    public PostWhereGroup andEnabledIsNotNull() {
        addCriterion("enabled", EnumOperator.IS_NOT_NULL, null);
        return this;
    }

    public PostWhereGroup andEnabledEqualTo(Boolean value) {
        addCriterion("enabled", EnumOperator.EQUAL, value);
        return this;
    }


    public PostWhereGroup andEnabledNotEqualTo(Boolean value) {
        addCriterion("enabled", EnumOperator.NOT_EQUAL, value);
        return this;
    }

    public PostWhereGroup andEnabledBetween(Boolean value1, Boolean value2) {
        addCriterion("enabled", EnumOperator.GREATER_EQUAL_THAN, value1);
        addCriterion("enabled", EnumOperator.LESS_EQUAL_THAN, value2);
        return this;
    }


    public PostWhereGroup andEnabledNotBetween(Boolean value1, Boolean value2) {
        addCriterion("enabled", EnumOperator.LESS_THAN, value1);
        addCriterion("enabled", EnumOperator.GREATER_THAN, value2);
        return this;
    }



    public PostWhereGroup andEnabledLikeTo(Boolean value) {
        addCriterion("enabled", EnumOperator.LIKE, true, value, true);
        return this;
    }


    public PostWhereGroup andEnabledLikeTo(boolean prefix, Boolean value) {
        addCriterion("enabled", EnumOperator.LIKE, prefix, value, false);
        return this;
    }


    public PostWhereGroup andEnabledLikeTo(Boolean value, boolean suffix) {
        addCriterion("enabled", EnumOperator.LIKE, false, value, suffix);
        return this;
    }




    public PostWhereGroup andEnabledNotLikeTo(Boolean value) {
        addCriterion("enabled", EnumOperator.NOT_LIKE, true, value, true);
        return this;
    }


    public PostWhereGroup andEnabledNotLikeTo(boolean prefix, Boolean value) {
        addCriterion("enabled", EnumOperator.NOT_LIKE, prefix, value, false);
        return this;
    }


    public PostWhereGroup andEnabledNotLikeTo(Boolean value, boolean suffix) {
        addCriterion("enabled", EnumOperator.NOT_LIKE, false, value, suffix);
        return this;
    }



    public PostWhereGroup andEnabledIn(List<Boolean> list) {
        addCriterion("enabled", EnumOperator.IN, list);
        return this;
    }


    public PostWhereGroup andEnabledNotIn(List<Boolean> list) {
        addCriterion("enabled", EnumOperator.NOT_IN, list);
        return this;
    }

    public PostWhereGroup andIdIsNull() {
        addCriterion("id", EnumOperator.IS_NULL, null);
        return this;
    }

    public PostWhereGroup andIdIsNotNull() {
        addCriterion("id", EnumOperator.IS_NOT_NULL, null);
        return this;
    }

    public PostWhereGroup andIdEqualTo(Long value) {
        addCriterion("id", EnumOperator.EQUAL, value);
        return this;
    }


    public PostWhereGroup andIdNotEqualTo(Long value) {
        addCriterion("id", EnumOperator.NOT_EQUAL, value);
        return this;
    }

    public PostWhereGroup andIdBetween(Long value1, Long value2) {
        addCriterion("id", EnumOperator.GREATER_EQUAL_THAN, value1);
        addCriterion("id", EnumOperator.LESS_EQUAL_THAN, value2);
        return this;
    }


    public PostWhereGroup andIdNotBetween(Long value1, Long value2) {
        addCriterion("id", EnumOperator.LESS_THAN, value1);
        addCriterion("id", EnumOperator.GREATER_THAN, value2);
        return this;
    }



    public PostWhereGroup andIdLikeTo(Long value) {
        addCriterion("id", EnumOperator.LIKE, true, value, true);
        return this;
    }


    public PostWhereGroup andIdLikeTo(boolean prefix, Long value) {
        addCriterion("id", EnumOperator.LIKE, prefix, value, false);
        return this;
    }


    public PostWhereGroup andIdLikeTo(Long value, boolean suffix) {
        addCriterion("id", EnumOperator.LIKE, false, value, suffix);
        return this;
    }




    public PostWhereGroup andIdNotLikeTo(Long value) {
        addCriterion("id", EnumOperator.NOT_LIKE, true, value, true);
        return this;
    }


    public PostWhereGroup andIdNotLikeTo(boolean prefix, Long value) {
        addCriterion("id", EnumOperator.NOT_LIKE, prefix, value, false);
        return this;
    }


    public PostWhereGroup andIdNotLikeTo(Long value, boolean suffix) {
        addCriterion("id", EnumOperator.NOT_LIKE, false, value, suffix);
        return this;
    }



    public PostWhereGroup andIdIn(List<Long> list) {
        addCriterion("id", EnumOperator.IN, list);
        return this;
    }


    public PostWhereGroup andIdNotIn(List<Long> list) {
        addCriterion("id", EnumOperator.NOT_IN, list);
        return this;
    }

    public PostWhereGroup andNameIsNull() {
        addCriterion("name", EnumOperator.IS_NULL, null);
        return this;
    }

    public PostWhereGroup andNameIsNotNull() {
        addCriterion("name", EnumOperator.IS_NOT_NULL, null);
        return this;
    }

    public PostWhereGroup andNameEqualTo(String value) {
        addCriterion("name", EnumOperator.EQUAL, value);
        return this;
    }


    public PostWhereGroup andNameNotEqualTo(String value) {
        addCriterion("name", EnumOperator.NOT_EQUAL, value);
        return this;
    }

    public PostWhereGroup andNameBetween(String value1, String value2) {
        addCriterion("name", EnumOperator.GREATER_EQUAL_THAN, value1);
        addCriterion("name", EnumOperator.LESS_EQUAL_THAN, value2);
        return this;
    }


    public PostWhereGroup andNameNotBetween(String value1, String value2) {
        addCriterion("name", EnumOperator.LESS_THAN, value1);
        addCriterion("name", EnumOperator.GREATER_THAN, value2);
        return this;
    }



    public PostWhereGroup andNameLikeTo(String value) {
        addCriterion("name", EnumOperator.LIKE, true, value, true);
        return this;
    }


    public PostWhereGroup andNameLikeTo(boolean prefix, String value) {
        addCriterion("name", EnumOperator.LIKE, prefix, value, false);
        return this;
    }


    public PostWhereGroup andNameLikeTo(String value, boolean suffix) {
        addCriterion("name", EnumOperator.LIKE, false, value, suffix);
        return this;
    }




    public PostWhereGroup andNameNotLikeTo(String value) {
        addCriterion("name", EnumOperator.NOT_LIKE, true, value, true);
        return this;
    }


    public PostWhereGroup andNameNotLikeTo(boolean prefix, String value) {
        addCriterion("name", EnumOperator.NOT_LIKE, prefix, value, false);
        return this;
    }


    public PostWhereGroup andNameNotLikeTo(String value, boolean suffix) {
        addCriterion("name", EnumOperator.NOT_LIKE, false, value, suffix);
        return this;
    }



    public PostWhereGroup andNameIn(List<String> list) {
        addCriterion("name", EnumOperator.IN, list);
        return this;
    }


    public PostWhereGroup andNameNotIn(List<String> list) {
        addCriterion("name", EnumOperator.NOT_IN, list);
        return this;
    }

    public PostWhereGroup andPkBizUnitIsNull() {
        addCriterion("pk_biz_unit", EnumOperator.IS_NULL, null);
        return this;
    }

    public PostWhereGroup andPkBizUnitIsNotNull() {
        addCriterion("pk_biz_unit", EnumOperator.IS_NOT_NULL, null);
        return this;
    }

    public PostWhereGroup andPkBizUnitEqualTo(Long value) {
        addCriterion("pk_biz_unit", EnumOperator.EQUAL, value);
        return this;
    }


    public PostWhereGroup andPkBizUnitNotEqualTo(Long value) {
        addCriterion("pk_biz_unit", EnumOperator.NOT_EQUAL, value);
        return this;
    }

    public PostWhereGroup andPkBizUnitBetween(Long value1, Long value2) {
        addCriterion("pk_biz_unit", EnumOperator.GREATER_EQUAL_THAN, value1);
        addCriterion("pk_biz_unit", EnumOperator.LESS_EQUAL_THAN, value2);
        return this;
    }


    public PostWhereGroup andPkBizUnitNotBetween(Long value1, Long value2) {
        addCriterion("pk_biz_unit", EnumOperator.LESS_THAN, value1);
        addCriterion("pk_biz_unit", EnumOperator.GREATER_THAN, value2);
        return this;
    }



    public PostWhereGroup andPkBizUnitLikeTo(Long value) {
        addCriterion("pk_biz_unit", EnumOperator.LIKE, true, value, true);
        return this;
    }


    public PostWhereGroup andPkBizUnitLikeTo(boolean prefix, Long value) {
        addCriterion("pk_biz_unit", EnumOperator.LIKE, prefix, value, false);
        return this;
    }


    public PostWhereGroup andPkBizUnitLikeTo(Long value, boolean suffix) {
        addCriterion("pk_biz_unit", EnumOperator.LIKE, false, value, suffix);
        return this;
    }




    public PostWhereGroup andPkBizUnitNotLikeTo(Long value) {
        addCriterion("pk_biz_unit", EnumOperator.NOT_LIKE, true, value, true);
        return this;
    }


    public PostWhereGroup andPkBizUnitNotLikeTo(boolean prefix, Long value) {
        addCriterion("pk_biz_unit", EnumOperator.NOT_LIKE, prefix, value, false);
        return this;
    }


    public PostWhereGroup andPkBizUnitNotLikeTo(Long value, boolean suffix) {
        addCriterion("pk_biz_unit", EnumOperator.NOT_LIKE, false, value, suffix);
        return this;
    }



    public PostWhereGroup andPkBizUnitIn(List<Long> list) {
        addCriterion("pk_biz_unit", EnumOperator.IN, list);
        return this;
    }


    public PostWhereGroup andPkBizUnitNotIn(List<Long> list) {
        addCriterion("pk_biz_unit", EnumOperator.NOT_IN, list);
        return this;
    }

    public PostWhereGroup andPkDeptIsNull() {
        addCriterion("pk_dept", EnumOperator.IS_NULL, null);
        return this;
    }

    public PostWhereGroup andPkDeptIsNotNull() {
        addCriterion("pk_dept", EnumOperator.IS_NOT_NULL, null);
        return this;
    }

    public PostWhereGroup andPkDeptEqualTo(Long value) {
        addCriterion("pk_dept", EnumOperator.EQUAL, value);
        return this;
    }


    public PostWhereGroup andPkDeptNotEqualTo(Long value) {
        addCriterion("pk_dept", EnumOperator.NOT_EQUAL, value);
        return this;
    }

    public PostWhereGroup andPkDeptBetween(Long value1, Long value2) {
        addCriterion("pk_dept", EnumOperator.GREATER_EQUAL_THAN, value1);
        addCriterion("pk_dept", EnumOperator.LESS_EQUAL_THAN, value2);
        return this;
    }


    public PostWhereGroup andPkDeptNotBetween(Long value1, Long value2) {
        addCriterion("pk_dept", EnumOperator.LESS_THAN, value1);
        addCriterion("pk_dept", EnumOperator.GREATER_THAN, value2);
        return this;
    }



    public PostWhereGroup andPkDeptLikeTo(Long value) {
        addCriterion("pk_dept", EnumOperator.LIKE, true, value, true);
        return this;
    }


    public PostWhereGroup andPkDeptLikeTo(boolean prefix, Long value) {
        addCriterion("pk_dept", EnumOperator.LIKE, prefix, value, false);
        return this;
    }


    public PostWhereGroup andPkDeptLikeTo(Long value, boolean suffix) {
        addCriterion("pk_dept", EnumOperator.LIKE, false, value, suffix);
        return this;
    }




    public PostWhereGroup andPkDeptNotLikeTo(Long value) {
        addCriterion("pk_dept", EnumOperator.NOT_LIKE, true, value, true);
        return this;
    }


    public PostWhereGroup andPkDeptNotLikeTo(boolean prefix, Long value) {
        addCriterion("pk_dept", EnumOperator.NOT_LIKE, prefix, value, false);
        return this;
    }


    public PostWhereGroup andPkDeptNotLikeTo(Long value, boolean suffix) {
        addCriterion("pk_dept", EnumOperator.NOT_LIKE, false, value, suffix);
        return this;
    }



    public PostWhereGroup andPkDeptIn(List<Long> list) {
        addCriterion("pk_dept", EnumOperator.IN, list);
        return this;
    }


    public PostWhereGroup andPkDeptNotIn(List<Long> list) {
        addCriterion("pk_dept", EnumOperator.NOT_IN, list);
        return this;
    }

    public PostWhereGroup andUpdateTimeIsNull() {
        addCriterion("update_time", EnumOperator.IS_NULL, null);
        return this;
    }

    public PostWhereGroup andUpdateTimeIsNotNull() {
        addCriterion("update_time", EnumOperator.IS_NOT_NULL, null);
        return this;
    }

    public PostWhereGroup andUpdateTimeEqualTo(Instant value) {
        addCriterion("update_time", EnumOperator.EQUAL, value);
        return this;
    }


    public PostWhereGroup andUpdateTimeNotEqualTo(Instant value) {
        addCriterion("update_time", EnumOperator.NOT_EQUAL, value);
        return this;
    }

    public PostWhereGroup andUpdateTimeBetween(LocalDate value1, LocalDate value2) {
        addCriterion("update_time", EnumOperator.GREATER_EQUAL_THAN, value1);
        addCriterion("update_time", EnumOperator.LESS_EQUAL_THAN, value2);
        return this;
    }


    public PostWhereGroup andUpdateTimeNotBetween(LocalDate value1, LocalDate value2) {
        addCriterion("update_time", EnumOperator.LESS_THAN, value1);
        addCriterion("update_time", EnumOperator.GREATER_THAN, value2);
        return this;
    }



    public PostWhereGroup andUpdateTimeLikeTo(Instant value) {
        addCriterion("update_time", EnumOperator.LIKE, true, value, true);
        return this;
    }


    public PostWhereGroup andUpdateTimeLikeTo(boolean prefix, Instant value) {
        addCriterion("update_time", EnumOperator.LIKE, prefix, value, false);
        return this;
    }


    public PostWhereGroup andUpdateTimeLikeTo(Instant value, boolean suffix) {
        addCriterion("update_time", EnumOperator.LIKE, false, value, suffix);
        return this;
    }




    public PostWhereGroup andUpdateTimeNotLikeTo(Instant value) {
        addCriterion("update_time", EnumOperator.NOT_LIKE, true, value, true);
        return this;
    }


    public PostWhereGroup andUpdateTimeNotLikeTo(boolean prefix, Instant value) {
        addCriterion("update_time", EnumOperator.NOT_LIKE, prefix, value, false);
        return this;
    }


    public PostWhereGroup andUpdateTimeNotLikeTo(Instant value, boolean suffix) {
        addCriterion("update_time", EnumOperator.NOT_LIKE, false, value, suffix);
        return this;
    }



    public PostWhereGroup andUpdateTimeIn(List<Instant> list) {
        addCriterion("update_time", EnumOperator.IN, list);
        return this;
    }


    public PostWhereGroup andUpdateTimeNotIn(List<Instant> list) {
        addCriterion("update_time", EnumOperator.NOT_IN, list);
        return this;
    }

    public PostWhereGroup andUpdateUserIsNull() {
        addCriterion("update_user", EnumOperator.IS_NULL, null);
        return this;
    }

    public PostWhereGroup andUpdateUserIsNotNull() {
        addCriterion("update_user", EnumOperator.IS_NOT_NULL, null);
        return this;
    }

    public PostWhereGroup andUpdateUserEqualTo(Long value) {
        addCriterion("update_user", EnumOperator.EQUAL, value);
        return this;
    }


    public PostWhereGroup andUpdateUserNotEqualTo(Long value) {
        addCriterion("update_user", EnumOperator.NOT_EQUAL, value);
        return this;
    }

    public PostWhereGroup andUpdateUserBetween(Long value1, Long value2) {
        addCriterion("update_user", EnumOperator.GREATER_EQUAL_THAN, value1);
        addCriterion("update_user", EnumOperator.LESS_EQUAL_THAN, value2);
        return this;
    }


    public PostWhereGroup andUpdateUserNotBetween(Long value1, Long value2) {
        addCriterion("update_user", EnumOperator.LESS_THAN, value1);
        addCriterion("update_user", EnumOperator.GREATER_THAN, value2);
        return this;
    }



    public PostWhereGroup andUpdateUserLikeTo(Long value) {
        addCriterion("update_user", EnumOperator.LIKE, true, value, true);
        return this;
    }


    public PostWhereGroup andUpdateUserLikeTo(boolean prefix, Long value) {
        addCriterion("update_user", EnumOperator.LIKE, prefix, value, false);
        return this;
    }


    public PostWhereGroup andUpdateUserLikeTo(Long value, boolean suffix) {
        addCriterion("update_user", EnumOperator.LIKE, false, value, suffix);
        return this;
    }




    public PostWhereGroup andUpdateUserNotLikeTo(Long value) {
        addCriterion("update_user", EnumOperator.NOT_LIKE, true, value, true);
        return this;
    }


    public PostWhereGroup andUpdateUserNotLikeTo(boolean prefix, Long value) {
        addCriterion("update_user", EnumOperator.NOT_LIKE, prefix, value, false);
        return this;
    }


    public PostWhereGroup andUpdateUserNotLikeTo(Long value, boolean suffix) {
        addCriterion("update_user", EnumOperator.NOT_LIKE, false, value, suffix);
        return this;
    }



    public PostWhereGroup andUpdateUserIn(List<Long> list) {
        addCriterion("update_user", EnumOperator.IN, list);
        return this;
    }


    public PostWhereGroup andUpdateUserNotIn(List<Long> list) {
        addCriterion("update_user", EnumOperator.NOT_IN, list);
        return this;
    }


}
