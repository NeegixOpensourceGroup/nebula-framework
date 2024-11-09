package com.neegix.application.query.aggregateFunctions;

import com.neegix.application.query.IAggregateFunction;

/**
 * Created by IntelliJ IDEA (Community Edition)
 * Thank you to JetBrains for their contributions to the vast number of developers
 *
 * @Author: kushu001
 * @Date: 2024/10/28/09:17
 * @Description:
 */
public class SumAggregateFunction implements IAggregateFunction {
    private final String column;
    private final String alias;

    public SumAggregateFunction(String column, String alias) {
        this.column = column;
        this.alias = alias;
    }

    @Override
    public String getName() {
        return "SUM";
    }

    @Override
    public String getAlias() {
        return this.alias;
    }

    @Override
    public Object[] getArguments() {
        return new Object[]{column};
    }
}
