package com.neegix.application.command;

import com.neegix.utils.SpringContextUtil;

/**
 * Created by IntelliJ IDEA (Community Edition)
 * Thank you to JetBrains for their contributions to the vast number of developers
 *
 * @Author: kushu001
 * @Date: 2024/10/06/23:42
 * @Description:
 */
public class CommandInvoker {

    private static CommandInvoker instance;

    private CommandInvoker() {
    }

    public static CommandInvoker getInstance() {
        if (instance == null) {
            synchronized (CommandInvoker.class) {
                if (instance == null) {
                    instance = new CommandInvoker();
                }
            }
        }
        return instance;
    }

    // 执行命令，这里使用了泛型参数T
    public <T> T execute(ICommand<T> command) {
        return command.execute(SpringContextUtil.getApplicationContext());
    }
}
