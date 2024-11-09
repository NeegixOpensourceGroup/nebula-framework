package com.neegix.application.query;

/**
 * Created by IntelliJ IDEA (Community Edition)
 * Thank you to JetBrains for their contributions to the vast number of developers
 *
 * @Author: kushu001
 * @Date: 2024/10/28/09:16
 * @Description:
 */
public interface IAggregateFunction {
    String getName();
    String getAlias(); // 获取聚合函数的别名
    Object[] getArguments();
}
