package com.neegix.database;

/**
 * Created by IntelliJ IDEA (Community Edition)
 * Thank you to JetBrains for their contributions to the vast number of developers
 *
 * @Author: kushu001
 * @Date: 2024/11/05/17:02
 * @Description:
 */
public class ColumnMetadata {
    private final String columnName;
    private final String dataType;
    private final String isNullable;
    private final boolean isPrimaryKey;
    private final String defaultValue;
    private final String description;

    public ColumnMetadata(String columnName, String dataType, String isNullable, boolean isPrimaryKey,  String defaultValue, String description) {
        this.columnName = columnName;
        this.dataType = dataType;
        this.isNullable = isNullable;
        this.isPrimaryKey = isPrimaryKey;
        this.defaultValue = defaultValue;
        this.description = description;
    }

    public String getColumnName() {
        return columnName;
    }

    public String getDataType() {
        return dataType;
    }

    public String getIsNullable() {
        return isNullable;
    }

    public boolean isPrimaryKey() {
        return isPrimaryKey;
    }

    public String getDefaultValue() {
        return defaultValue;
    }

    public String getDescription() {
        return description;
    }

    @Override
    public String toString() {
        return "ColumnMetadata{" +
                "columnName='" + columnName + '\'' +
                ", dataType='" + dataType + '\'' +
                ", isNullable='" + isNullable + '\'' +
                ", isPrimaryKey='" + isPrimaryKey + '\'' +
                ", defaultValue='" + defaultValue + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
