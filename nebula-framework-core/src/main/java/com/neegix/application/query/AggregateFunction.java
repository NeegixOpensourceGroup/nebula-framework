package com.neegix.application.query;

import lombok.Getter;

/**
 * Created by IntelliJ IDEA (Community Edition)
 * Thank you to JetBrains for their contributions to the vast number of developers
 *
 * @Author: kushu001
 * @Date: 2024/10/25/15:26
 * @Description:
 */
@Getter
public class AggregateFunction {
    private final IAggregateFunction function;

    public AggregateFunction(IAggregateFunction function) {
        this.function = function;
    }

}
