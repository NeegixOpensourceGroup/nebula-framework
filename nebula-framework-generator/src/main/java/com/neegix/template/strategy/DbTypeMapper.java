package com.neegix.template.strategy;

/**
 * Created by IntelliJ IDEA (Community Edition)
 * Thank you to JetBrains for their contributions to the vast number of developers
 *
 * @Author: kushu001
 * @Date: 2024/11/06/11:04
 * @Description:
 */
public interface DbTypeMapper {
    String mapToJavaType(String dbType);
    String getFullyQualifiedJavaType(String dbType);
    Class<?> getJavaClass(String dbType);
}
