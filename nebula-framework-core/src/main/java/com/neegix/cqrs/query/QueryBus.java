package com.neegix.cqrs.query;

import java.time.Duration;
import java.util.concurrent.CompletableFuture;

/**
 * Created by IntelliJ IDEA (Community Edition)
 * Thank you to JetBrains for their contributions to the vast number of developers
 *
 * @Author: kushu001
 * @Date: 2025/04/27/11:18
 * @Description:
 */
public interface QueryBus {
    // 同步执行
    <R> R execute(Query<R> query);

    // 异步执行
    <R> CompletableFuture<R> executeAsync(Query<R> query);

    // 带超时的异步执行
    <R> CompletableFuture<R> executeAsync(Query<R> query, Duration timeout);
}
