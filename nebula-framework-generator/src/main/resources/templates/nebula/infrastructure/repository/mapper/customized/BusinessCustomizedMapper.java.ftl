<#assign currentTime = .now>
package ${templateTable.packageName}.${templateTable.javaTableName[0]?lower_case+templateTable.javaTableName[1..]}.infrastructure.repository.mapper.customized;

import org.apache.ibatis.annotations.Mapper;

import java.util.List;

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

@Mapper
public interface ${templateTable.javaTableName}CustomizedMapper {
    Integer selectCountByIds(List<Long> ids);
}