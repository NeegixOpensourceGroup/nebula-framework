package com.neegix.application.query.aggregateFunctions;

import com.neegix.application.query.IAggregateFunction;

/**
 * Created by IntelliJ IDEA (Community Edition)
 * Thank you to JetBrains for their contributions to the vast number of developers
 *
 * @Author: kushu001
 * @Date: 2024/10/28/09:23
 * @Description:
 */
public class StddevAggregateFunction implements IAggregateFunction {
    private final String column;
    private final String alias;

    public StddevAggregateFunction(String column, String alias) {
        this.column = column;
        this.alias = alias;
    }

    @Override
    public String getName() {
        return "STDDEV";
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
