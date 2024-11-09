package com.neegix.application.command;

import org.springframework.context.ApplicationContext;

/**
 * Created by IntelliJ IDEA (Community Edition)
 * Thank you to JetBrains for their contributions to the vast number of developers
 *
 * @Author: kushu001
 * @Date: 2024/09/26/16:28
 * @Description:
 */
public interface ICommand<T> {
    T execute(ApplicationContext context);
}
