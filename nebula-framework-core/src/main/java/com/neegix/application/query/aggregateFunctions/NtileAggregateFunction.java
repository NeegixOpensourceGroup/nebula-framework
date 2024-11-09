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
public class NtileAggregateFunction  implements IAggregateFunction {
    private final int ntiles; // 要分成的组数
    private final String column; // 排序依据的列名
    private final String alias;

    public NtileAggregateFunction(int ntiles, String column, String alias) {
        this.ntiles = ntiles;
        this.column = column;
        this.alias = alias;
    }

    @Override
    public String getName() {
        return "NTILE";
    }

    @Override
    public String getAlias() {
        return this.alias;
    }

    @Override
    public Object[] getArguments() {
        return new Object[]{ntiles, column};
    }

}
