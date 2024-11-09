package com.neegix.template.strategy;

import java.sql.Timestamp;
import java.util.Date;

/**
 * Created by IntelliJ IDEA (Community Edition)
 * Thank you to JetBrains for their contributions to the vast number of developers
 *
 * @Author: kushu001
 * @Date: 2024/11/06/11:06
 * @Description:
 */
public class SqlServerDbTypeMapper implements DbTypeMapper {

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
            case "VARCHAR", "CHAR", "NVARCHAR", "NCHAR", "TEXT" -> String.class;
            case "INT" -> Integer.class;
            case "BIGINT" -> Long.class;
            case "FLOAT" -> Double.class; // SQL Server 中的 FLOAT 默认是双精度
            case "REAL" -> Float.class;
            case "BIT" -> Boolean.class;
            case "DATE" -> Date.class;
            case "DATETIME", "SMALLDATETIME", "DATETIME2" -> Timestamp.class;
            default -> Object.class;
        };
    }
}
