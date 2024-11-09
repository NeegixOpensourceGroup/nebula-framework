package com.neegix.application.query.aggregateFunctions;

import com.neegix.application.query.IAggregateFunction;

/**
 * Created by IntelliJ IDEA (Community Edition)
 * Thank you to JetBrains for their contributions to the vast number of developers
 *
 * @Author: kushu001
 * @Date: 2024/10/28/09:24
 * @Description:
 */
public class VarAggregateFunction implements IAggregateFunction {
    private final String column;
    private final String alias;

    public VarAggregateFunction(String column, String alias) {
        this.column = column;
        this.alias = alias;
    }

    @Override
    public String getName() {
        return "VAR_SAMP";
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
