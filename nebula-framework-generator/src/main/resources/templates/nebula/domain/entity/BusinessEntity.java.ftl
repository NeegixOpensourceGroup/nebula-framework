<#assign currentTime = .now>
<#assign extraColumns = ["id", "create_time", "create_user", "update_time", "update_user"]>

package ${templateTable.packageName}.${templateTable.javaTableName[0]?lower_case+templateTable.javaTableName[1..]}.domain.entity;

<#if templateTable.columns?exists>
    <#list templateTable.columns as column>
        <#if !(column.fullyQualifiedJavaType?contains("lang")) && column.isFirstImportPackage() && !extraColumns?seq_contains(column.sqlName)>
import ${column.fullyQualifiedJavaType};
        </#if>
    </#list>
</#if>
import com.neegix.base.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

 /**
  * This file is auto-generated by nebula-framework-generator.
  * The auto-generation plugin was developed using IntelliJ IDEA Community Edition.
  * Thanks to JetBrains for their outstanding contributions to the developer community.
  *
  * The code generated by this tool is owned by the user of the tool.
  * The tool itself is copyrighted by ${templateTable.copyright}.
  *
  * @author ${templateTable.copyright}
  * @version ${templateTable.version}
  * @since ${currentTime?string("yyyy-MM-dd HH:mm:ss")}
  */
@EqualsAndHashCode(callSuper = true)
@Data
public class ${templateTable.javaTableName}Entity extends BaseEntity {
    <#if templateTable.columns?exists>
        <#list templateTable.columns as column>
             <#if !extraColumns?seq_contains(column.sqlName)>
    // ${column.description}
    private ${column.javaType} ${column.javaName};
            </#if>
        </#list>
    </#if>
}