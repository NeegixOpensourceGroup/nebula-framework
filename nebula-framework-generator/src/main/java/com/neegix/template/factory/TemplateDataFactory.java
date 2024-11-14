package com.neegix.template.factory;

import com.neegix.database.ColumnMetadata;
import com.neegix.template.TemplateColumn;
import com.neegix.template.TemplateTable;
import com.neegix.template.strategy.DbTypeMapper;
import com.neegix.utils.StringUtils;
import org.apache.maven.plugin.logging.Log;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Created by IntelliJ IDEA (Community Edition)
 * Thank you to JetBrains for their contributions to the vast number of developers
 *
 * @Author: kushu001
 * @Date: 2024/11/06/13:35
 * @Description:
 */
public class TemplateDataFactory {
    public static TemplateTable create(String tableName, String tablePrefix, String packageName, List<ColumnMetadata> columns, String driver, Log log){
        TemplateTable templateTable = new TemplateTable();

        templateTable.setSqlTableName(tableName);
        templateTable.setJavaTableName(StringUtils.toCamelCaseClassName(tableName, tablePrefix));
        templateTable.setPackageName(packageName);
        log.info("Table Prefix: " +  tablePrefix);
        log.info("JAVA Table Name: " + tableName);

        log.info("SQL Table Name: " + StringUtils.toCamelCaseClassName(tableName, tablePrefix));
        DbTypeMapper dbTypeMapper = DbTypeStrategyFactory.createStrategy(driver);
        List<TemplateColumn> templateColumns = new ArrayList<>();
        Set<String> imports = new HashSet<>();
        // 处理结果集...
        for (ColumnMetadata column : columns) {
            log.info("CamelCase Column Name: " + StringUtils.toCamelCase(column.getColumnName()));
            log.info("FullyQualifiedJavaType: " + dbTypeMapper.getFullyQualifiedJavaType(column.getDataType()));
            log.info("JavaType: " + dbTypeMapper.mapToJavaType(column.getDataType()));
            log.info("Column Name: " + column.getColumnName() +
                    ", Data Type: " + column.getDataType() +
                    ", Nullable: " + column.getIsNullable() +
                    ", IsPrimaryKey: " + column.isPrimaryKey() +
                    ", Default Value: " + column.getDefaultValue() +
                    ", Description: " + column.getDescription()
            );
            TemplateColumn templateColumn;
            if (!imports.contains(dbTypeMapper.getFullyQualifiedJavaType(column.getDataType()))){
                templateColumn = new TemplateColumn(StringUtils.toCamelCase(column.getColumnName()), column.getColumnName(), column.isPrimaryKey(), dbTypeMapper.mapToJavaType(column.getDataType()), column.getDescription(),dbTypeMapper.getFullyQualifiedJavaType(column.getDataType()), true);
                imports.add(dbTypeMapper.getFullyQualifiedJavaType(column.getDataType()));
            } else {
                templateColumn = new TemplateColumn(StringUtils.toCamelCase(column.getColumnName()), column.getColumnName(), column.isPrimaryKey(), dbTypeMapper.mapToJavaType(column.getDataType()), column.getDescription(),dbTypeMapper.getFullyQualifiedJavaType(column.getDataType()), false);
            }

            templateColumns.add(templateColumn);
        }
        templateTable.setColumns(templateColumns);
        return templateTable;
    }
}
