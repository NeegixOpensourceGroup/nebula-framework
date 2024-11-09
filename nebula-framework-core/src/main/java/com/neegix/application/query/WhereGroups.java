package com.neegix.application.query;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by IntelliJ IDEA (Community Edition)
 * Thank you to JetBrains for their contributions to the vast number of developers
 *
 * @Author: kushu001
 * @Date: 2024/10/23/16:39
 * @Description:
 */
public class WhereGroups {
    protected List<Where> wheres;

    public WhereGroups() {
        wheres = new ArrayList<>();
    }

    protected void addCriterion(String column, EnumOperator enumOperator, Object object) {
        if (column == null || enumOperator == null) {
            throw new RuntimeException("Value for " + column + " cannot be null");
        }
        wheres.add(new Where(column, enumOperator, object));
    }

    protected void addCriterion(String column, EnumOperator enumOperator, boolean prefix, Object object, boolean suffix) {
        if (column == null || enumOperator == null) {
            throw new RuntimeException("Value for " + column + " cannot be null");
        }
        wheres.add(new Where(column, enumOperator, prefix, object, suffix));
    }

    protected void addCriterion(String column, EnumOperator enumOperator,  Object object, boolean suffix) {
        if (column == null || enumOperator == null) {
            throw new RuntimeException("Value for " + column + " cannot be null");
        }
        wheres.add(new Where(column, enumOperator,  object, suffix));
    }

    protected void addCriterion(String column, EnumOperator enumOperator, boolean prefix, Object object) {
        if (column == null || enumOperator == null) {
            throw new RuntimeException("Value for " + column + " cannot be null");
        }
        wheres.add(new Where(column, enumOperator, prefix, object));
    }
}
