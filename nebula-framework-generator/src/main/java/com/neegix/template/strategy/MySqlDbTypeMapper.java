package com.neegix.template.strategy;

import java.sql.Timestamp;
import java.util.Date;

/**
 * Created by IntelliJ IDEA (Community Edition)
 * Thank you to JetBrains for their contributions to the vast number of developers
 *
 * @Author: kushu001
 * @Date: 2024/11/06/11:04
 * @Description:
 */
public class MySqlDbTypeMapper implements DbTypeMapper {

    @Override
    public String mapToJavaType(String dbType) {
        return getJavaClass(dbType).getSimpleName();
    }

    @Override
    public String getFullyQualifiedJavaType(String dbType) {
        return getJavaClass(dbType).getName();
    }

    @Override
    public Class<?> getJavaClass(String dbType) {
        return switch (dbType.toUpperCase()) {
            case "VARCHAR", "CHAR", "TEXT" -> String.class;
            case "INT", "INTEGER" -> Integer.class;
            case "BIGINT" -> Long.class;
            case "FLOAT" -> Float.class;
            case "DOUBLE" -> Double.class;
            case "BOOLEAN","TINYINT" -> Boolean.class;
            case "DATE" -> Date.class;
            case "TIMESTAMP","DATETIME" -> Timestamp.class;
            default -> Object.class;
        };
    }
}
