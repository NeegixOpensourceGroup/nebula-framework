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
public class CountAggregateFunction implements IAggregateFunction {
    private final String alias;

    public CountAggregateFunction(String alias) {
        this.alias = alias;
    }

    @Override
    public String getName() {
        return "COUNT";
    }

    @Override
    public String getAlias() {
        return this.alias;
    }

    @Override
    public Object[] getArguments() {
        return new Object[]{};
    }
}
