package com.neegix.template;

import java.util.List;
import java.util.Set;

/**
 * Created by IntelliJ IDEA (Community Edition)
 * Thank you to JetBrains for their contributions to the vast number of developers
 *
 * @Author: kushu001
 * @Date: 2024/11/06/11:39
 * @Description:
 */
public class TemplateTable {
    private String description;
    private String sqlTableName;
    private String javaTableName;
    private String packageName;
    private String version = "1.0.0";
    private String copyright = "https://www.neegix.com";
    private List<TemplateColumn> columns;
    private Set<String> imports;
    private String[] extraColumns;

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public String getSqlTableName() {
        return sqlTableName;
    }

    public void setSqlTableName(String sqlTableName) {
        this.sqlTableName = sqlTableName;
    }

    public String getJavaTableName() {
        return javaTableName;
    }

    public void setJavaTableName(String javaTableName) {
        this.javaTableName = javaTableName;
    }

    public String getPackageName() {
        return packageName;
    }

    public void setPackageName(String packageName) {
        this.packageName = packageName;
    }

    public List<TemplateColumn> getColumns() {
        return columns;
    }

    public void setColumns(List<TemplateColumn> columns) {
        this.columns = columns;
    }

    public String getCopyright() {
        return copyright;
    }

    public void setCopyright(String copyright) {
        this.copyright = copyright;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public Set<String> getImports() {
        return imports;
    }

    public void setImports(Set<String> imports) {
        this.imports = imports;
    }

    public String[] getExtraColumns() {
        return extraColumns;
    }

    public void setExtraColumns(String[] extraColumns) {
        this.extraColumns = extraColumns;
    }
}
