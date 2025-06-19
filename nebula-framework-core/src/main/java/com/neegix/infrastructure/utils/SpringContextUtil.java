package com.neegix.infrastructure.utils;

import lombok.Getter;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

/**
 * Created by IntelliJ IDEA (Community Edition)
 * Thank you to JetBrains for their contributions to the vast number of developers
 *
 * @Author: kushu001
 * @Date: 2024/10/08/10:04
 * @Description:
 */
@Component
public class SpringContextUtil implements ApplicationContextAware {
    // 提供一个静态方法，返回应用上下文
    // Spring应用上下文
    @Getter
    private static ApplicationContext applicationContext;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        SpringContextUtil.applicationContext = applicationContext;
    }

    // 提供一个获取Bean的静态方法
    public static <T> T getBean(Class<T> beanClass) {
        if (applicationContext != null) {
            return applicationContext.getBean(beanClass);
        } else {
            throw new IllegalStateException("ApplicationContext is not initialized yet!");
        }
    }
}
