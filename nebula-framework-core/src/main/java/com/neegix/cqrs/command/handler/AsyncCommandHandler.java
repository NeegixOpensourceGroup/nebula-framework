package com.neegix.cqrs.command.handler;

/**
 * Created by IntelliJ IDEA (Community Edition)
 * Thank you to JetBrains for their contributions to the vast number of developers
 *
 * @Author: kushu001
 * @Date: 2025/04/23/16:54
 * @Description:
 */

import com.neegix.cqrs.command.AsyncCommand;

import java.util.concurrent.CompletableFuture;

/**
 * 异步命令处理器接口
 */
public interface AsyncCommandHandler<C extends AsyncCommand<R>, R> {
    CompletableFuture<R> handleAsync(C command);
}
