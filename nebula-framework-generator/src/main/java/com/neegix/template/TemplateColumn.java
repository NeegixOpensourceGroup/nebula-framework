package com.neegix.template;

/**
 * Created by IntelliJ IDEA (Community Edition)
 * Thank you to JetBrains for their contributions to the vast number of developers
 *
 * @Author: kushu001
 * @Date: 2024/11/06/11:28
 * @Description:
 */
public class TemplateColumn {
    private final String javaName;
    private final String sqlName;
    private final boolean isPrimaryKey;
    private final String fullyQualifiedJavaType;
    private final String javaType;
    private final String description;

    public TemplateColumn(String javaName, String sqlName,boolean isPrimaryKey, String fullyQualifiedJavaType, String javaType, String description) {
        this.javaName = javaName;
        this.sqlName = sqlName;
        this.isPrimaryKey = isPrimaryKey;
        this.fullyQualifiedJavaType = fullyQualifiedJavaType;
        this.javaType = javaType;
        this.description = description;
    }

    public String getJavaName() {
        return javaName;
    }

    public String getSqlName() {
        return sqlName;
    }

    public boolean isPrimaryKey() {
        return isPrimaryKey;
    }

    public String getFullyQualifiedJavaType() {
        return fullyQualifiedJavaType;
    }

    public String getJavaType() {
        return javaType;
    }

    public String getDescription() {
        return description;
    }
}
