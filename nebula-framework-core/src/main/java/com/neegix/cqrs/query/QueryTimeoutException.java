package com.neegix.cqrs.query;

/**
 * Created by IntelliJ IDEA (Community Edition)
 * Thank you to JetBrains for their contributions to the vast number of developers
 *
 * @Author: kushu001
 * @Date: 2025/04/27/15:37
 * @Description:
 */
public class QueryTimeoutException extends RuntimeException{
    public QueryTimeoutException(String message) {
        super(message);
    }
}
