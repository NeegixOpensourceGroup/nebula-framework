<#assign currentTime = .now>
package ${templateTable.packageName}.${templateTable.javaTableName[0]?lower_case+templateTable.javaTableName[1..]}.application.dto;
<#if templateTable.columns?exists>
    <#list templateTable.columns as column>
        <#if !(column.fullyQualifiedJavaType?contains("lang")) && column.isFirstImportPackage()>
import ${column.fullyQualifiedJavaType};
        </#if>
    </#list>
</#if>
import lombok.Data;

 /**
  * This file is auto-generated by nebula-framework-generator.
  * The auto-generation plugin was developed using IntelliJ IDEA Community Edition.
  * Thanks to JetBrains for their outstanding contributions to the developer community.
  * <p>
  * The code generated by this tool is owned by the user of the tool.
  * The tool itself is copyrighted by <a href="${templateTable.copyright}">${templateTable.copyright}</a>.
  *
  * @author <a href="${templateTable.copyright}">${templateTable.copyright}</a>
  * @version ${templateTable.version}
  * @since ${currentTime?string("yyyy-MM-dd HH:mm:ss")}
  */

@Data
public class ${templateTable.javaTableName}DTO {
    <#if templateTable.columns?exists>
        <#list templateTable.columns as column>
    // ${column.description}
    private ${column.javaType} ${column.javaName};
        </#list>
    </#if>
}