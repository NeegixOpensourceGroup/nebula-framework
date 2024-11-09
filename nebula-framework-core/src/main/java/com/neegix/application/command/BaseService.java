package com.neegix.application.command;

/**
 * Created by IntelliJ IDEA (Community Edition)
 * Thank you to JetBrains for their contributions to the vast number of developers
 * @Author: kushu001
 * @Date: 2024/09/30/17:11
 * @Description: 
 */
public abstract class BaseService {
    protected CommandInvoker commandInvoker = CommandInvoker.getInstance();
}
