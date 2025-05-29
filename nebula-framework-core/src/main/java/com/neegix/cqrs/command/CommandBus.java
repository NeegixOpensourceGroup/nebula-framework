package com.neegix.cqrs.command;

/**
 * Created by IntelliJ IDEA (Community Edition)
 * Thank you to JetBrains for their contributions to the vast number of developers
 *
 * @Author: kushu001
 * @Date: 2025/04/23/16:50
 * @Description:
 */

import java.util.concurrent.CompletableFuture;

/**
 * 命令总线核心接口
 */
public interface CommandBus {

    /**
     * 执行同步命令（阻塞式）
     * @param command 命令对象
     * @param <R> 返回类型
     * @param <C> 命令类型
     * @return 处理结果
     */
    <R, C extends Command<R>> R execute(C command);

    /**
     * 执行异步命令（非阻塞）
     * @param command 异步命令对象
     * @param <R> 返回类型
     * @param <C> 命令类型
     * @return CompletableFuture包装的结果
     */
    <R, C extends AsyncCommand<R>> CompletableFuture<R> executeAsync(C command);
}