package com.neegix.application.query;

import lombok.Getter;

/**
 * Created by IntelliJ IDEA (Community Edition)
 * Thank you to JetBrains for their contributions to the vast number of developers
 *
 * @Author: kushu001
 * @Date: 2024/10/23/16:40
 * @Description:
 */
@Getter
public class Where {
    private final EnumOperator enumOperator;
    private final Object value;
    private final String column;
    private final boolean prefix;
    private final boolean suffix;

    public Where(String column, EnumOperator enumOperator, Object value) {
        this(column, enumOperator, false, value, false);
    }

    public Where(String column, EnumOperator enumOperator, boolean prefix, Object value) {
        this(column, enumOperator, prefix, value, false);
    }

    public Where(String column, EnumOperator enumOperator, Object value, boolean suffix) {
        this(column, enumOperator, false, value, suffix);
    }

    public Where(String column, EnumOperator enumOperator, boolean prefix, Object value, boolean suffix) {
        this.column = column;
        this.enumOperator = enumOperator;
        this.value = value;
        this.prefix = prefix;
        this.suffix = suffix;
    }

}
