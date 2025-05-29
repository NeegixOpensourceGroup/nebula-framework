package com.neegix.cqrs.query;

/**
 * Created by IntelliJ IDEA (Community Edition)
 * Thank you to JetBrains for their contributions to the vast number of developers
 *
 * @Author: kushu001
 * @Date: 2025/04/27/15:41
 * @Description:
 */
public class QueryHandlerNotFoundException extends RuntimeException {
    private final Class<?> queryType;  // 改为原始Class类型

    public QueryHandlerNotFoundException(Class<?> queryType) {
        super("No handler found for query type: " + queryType.getName());
        this.queryType = queryType;
    }

    public Class<?> getQueryType() {
        return queryType;
    }
}