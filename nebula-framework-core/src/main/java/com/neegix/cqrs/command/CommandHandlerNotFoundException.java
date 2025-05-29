package com.neegix.cqrs.command;

/**
 * Created by IntelliJ IDEA (Community Edition)
 * Thank you to JetBrains for their contributions to the vast number of developers
 *
 * @Author: kushu001
 * @Date: 2025/04/23/16:55
 * @Description:
 */
public class CommandHandlerNotFoundException extends RuntimeException {
    public CommandHandlerNotFoundException(Class<?> commandType) {
        super("未找到 " + commandType.getName() + " 对应的处理器");
    }
}
