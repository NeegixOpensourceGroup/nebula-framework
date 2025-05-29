package com.neegix.cqrs.command.handler;

import com.neegix.cqrs.command.Command;

/**
 * Created by IntelliJ IDEA (Community Edition)
 * Thank you to JetBrains for their contributions to the vast number of developers
 *
 * @Author: kushu001
 * @Date: 2025/04/23/16:53
 * @Description:
 */
public interface CommandHandler<C extends Command<R>, R> {
    R handle(C command);
}
