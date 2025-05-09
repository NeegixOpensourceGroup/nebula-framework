package com.neegix.template.factory;

import com.neegix.database.ColumnMetadata;
import com.neegix.template.TemplateColumn;
import com.neegix.template.TemplateTable;
import com.neegix.template.strategy.DbTypeMapper;
import com.neegix.utils.StringUtils;
import org.apache.maven.plugin.logging.Log;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
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
        String[] extraColumns = new String[]{"id", "create_time", "create_user", "update_time", "update_user"};
        String tableDescription = "";
        // 处理结果集...
        for (ColumnMetadata column : columns) {
//            log.info("CamelCase Column Name: " + StringUtils.toCamelCase(column.getColumnName()));
//            log.info("FullyQualifiedJavaType: " + dbTypeMapper.getFullyQualifiedJavaType(column.getDataType()));
//            log.info("JavaType: " + dbTypeMapper.mapToJavaType(column.getDataType()));
//            log.info("Column Name: " + column.getColumnName() +
//                    ", Data Type: " + column.getDataType() +
//                    ", Nullable: " + column.getIsNullable() +
//                    ", IsPrimaryKey: " + column.isPrimaryKey() +
//                    ", Default Value: " + column.getDefaultValue() +
//                    ", Description: " + column.getDescription() +
//                    ", Table Description: " + column.getTableDescription()
//            );
            TemplateColumn templateColumn = new TemplateColumn(StringUtils.toCamelCase(column.getColumnName()), column.getColumnName(), column.isPrimaryKey(), column.getIsNullable().contains("Y"), dbTypeMapper.mapToJavaType(column.getDataType()), column.getDescription(),dbTypeMapper.getFullyQualifiedJavaType(column.getDataType()));
            log.info(templateColumn.getSqlName()+": " + templateColumn.isAllowedNull()+":"+dbTypeMapper.getFullyQualifiedJavaType(column.getDataType()));
            if (!dbTypeMapper.getFullyQualifiedJavaType(column.getDataType()).contains("lang")){
                imports.add(dbTypeMapper.getFullyQualifiedJavaType(column.getDataType()));
            }
            if(!templateColumn.isAllowedNull()){
                if (dbTypeMapper.mapToJavaType(column.getDataType()).contains("Long")){
                    imports.add("jakarta.validation.constraints.NotNull");
                    //templateColumn.setFullyQualifiedJavaType("jakarta.validation.constraints.NotNull");
                } else {
                    imports.add("jakarta.validation.constraints.NotEmpty");
                   // templateColumn.setFullyQualifiedJavaType("jakarta.validation.constraints.NotEmpty");
                }
            }

            templateColumns.add(templateColumn);
            tableDescription = column.getTableDescription();
        }
        templateTable.setExtraColumns(extraColumns);
        templateTable.setImports(imports);
        templateTable.setColumns(templateColumns);
        templateTable.setDescription(tableDescription);
        return templateTable;
    }
}
