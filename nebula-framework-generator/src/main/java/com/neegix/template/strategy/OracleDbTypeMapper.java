package com.neegix.template.strategy;

import java.sql.Timestamp;
import java.util.Date;

/**
 * Created by IntelliJ IDEA (Community Edition)
 * Thank you to JetBrains for their contributions to the vast number of developers
 *
 * @Author: kushu001
 * @Date: 2024/11/06/11:05
 * @Description:
 */
public class OracleDbTypeMapper implements DbTypeMapper {

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
            case "VARCHAR2", "CHAR", "CLOB" -> String.class;
            case "NUMBER" -> {
                if (dbType.contains("(")) { // 处理有精度的情况
                    int precision = Integer.parseInt(dbType.substring(dbType.indexOf("(") + 1, dbType.indexOf(")")).split(",")[0]);
                    if (precision > 9) {
                        yield Long.class;
                    } else {
                        yield Integer.class;
                    }
                }
                yield Integer.class;
            }
            case "FLOAT" -> Float.class;
            case "DOUBLE PRECISION" -> Double.class;
            case "BOOLEAN" -> Boolean.class;
            case "DATE" -> Date.class;
            case "TIMESTAMP" -> Timestamp.class;
            default -> Object.class;
        };
    }
}
