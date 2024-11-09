package com.neegix.application.query.aggregateFunctions;

import com.neegix.application.query.IAggregateFunction;

/**
 * Created by IntelliJ IDEA (Community Edition)
 * Thank you to JetBrains for their contributions to the vast number of developers
 *
 * @Author: kushu001
 * @Date: 2024/10/28/09:21
 * @Description:
 */
public class MaxAggregateFunction  implements IAggregateFunction {
    private final String column;
    private final String alias;

    public MaxAggregateFunction(String column, String alias) {
        this.column = column;
        this.alias = alias;
    }

    @Override
    public String getName() {
        return "MAX";
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
