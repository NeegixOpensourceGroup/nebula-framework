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
    private final String javaType;
    private final String description;
    private final String fullyQualifiedJavaType;
    private final boolean isFirstImportPackage;

    public TemplateColumn(String javaName, String sqlName,boolean isPrimaryKey, String javaType, String description, String fullyQualifiedJavaType, boolean isFirstImportPackage) {
        this.javaName = javaName;
        this.sqlName = sqlName;
        this.isPrimaryKey = isPrimaryKey;
        this.javaType = javaType;
        this.description = description;
        this.fullyQualifiedJavaType = fullyQualifiedJavaType;
        this.isFirstImportPackage = isFirstImportPackage;
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

    public String getJavaType() {
        return javaType;
    }

    public String getDescription() {
        return description;
    }

    public String getFullyQualifiedJavaType() {
        return fullyQualifiedJavaType;
    }

    public boolean isFirstImportPackage() {
        return isFirstImportPackage;
    }

}
