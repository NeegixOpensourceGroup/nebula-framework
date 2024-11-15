<#assign currentTime = .now>
package ${templateTable.packageName}.${templateTable.javaTableName[0]?lower_case+templateTable.javaTableName[1..]}.interfaces.controller;

import com.neegix.base.PageDTO;
import com.neegix.exception.BusinessRuntimeException;
import com.neegix.result.Result;
import ${templateTable.packageName}.${templateTable.javaTableName[0]?lower_case+templateTable.javaTableName[1..]}.application.assembler.${templateTable.javaTableName}Assembler;
import ${templateTable.packageName}.${templateTable.javaTableName[0]?lower_case+templateTable.javaTableName[1..]}.application.cqrs.query.${templateTable.javaTableName}QueryRepository;
import ${templateTable.packageName}.${templateTable.javaTableName[0]?lower_case+templateTable.javaTableName[1..]}.application.dto.${templateTable.javaTableName}DTO;
import ${templateTable.packageName}.${templateTable.javaTableName[0]?lower_case+templateTable.javaTableName[1..]}.application.service.${templateTable.javaTableName}Service;
import ${templateTable.packageName}.${templateTable.javaTableName[0]?lower_case+templateTable.javaTableName[1..]}.interfaces.form.New${templateTable.javaTableName}Form;
import ${templateTable.packageName}.${templateTable.javaTableName[0]?lower_case+templateTable.javaTableName[1..]}.interfaces.form.Query${templateTable.javaTableName}Form;
import ${templateTable.packageName}.${templateTable.javaTableName[0]?lower_case+templateTable.javaTableName[1..]}.interfaces.form.Update${templateTable.javaTableName}Form;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

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
@RestController
@RequestMapping("/api/v1/${templateTable.javaTableName[0]?lower_case+templateTable.javaTableName[1..]}")
public class ${templateTable.javaTableName}Controller {

    @Autowired
    private ${templateTable.javaTableName}QueryRepository ${templateTable.javaTableName[0]?lower_case+templateTable.javaTableName[1..]}QueryRepository;

    @Autowired
    private ${templateTable.javaTableName}Service ${templateTable.javaTableName[0]?lower_case+templateTable.javaTableName[1..]}Service;

    @PostMapping
    public Result<Void> create${templateTable.javaTableName}(@RequestBody New${templateTable.javaTableName}Form ${templateTable.javaTableName[0]?lower_case+templateTable.javaTableName[1..]}Form){
        Void result = ${templateTable.javaTableName[0]?lower_case+templateTable.javaTableName[1..]}Service.create${templateTable.javaTableName}(${templateTable.javaTableName}Assembler.INSTANCE.covertEntity(${templateTable.javaTableName[0]?lower_case+templateTable.javaTableName[1..]}Form));
        return Result.success("创建成功", result);
    }

    @PutMapping
    public Result<Void> update${templateTable.javaTableName}(@RequestBody Update${templateTable.javaTableName}Form ${templateTable.javaTableName[0]?lower_case+templateTable.javaTableName[1..]}Form){
        Void result = ${templateTable.javaTableName[0]?lower_case+templateTable.javaTableName[1..]}Service.modify${templateTable.javaTableName}(${templateTable.javaTableName}Assembler.INSTANCE.covertEntity(${templateTable.javaTableName[0]?lower_case+templateTable.javaTableName[1..]}Form));
        return Result.success("更新成功",result);
    }

    @GetMapping("/{currentPage}/{pageSize}")
    public Result<PageDTO<${templateTable.javaTableName}DTO>> get${templateTable.javaTableName}s(@PathVariable("currentPage") Integer currentPage, @PathVariable("pageSize") Integer pageSize, @RequestBody(required = false) Query${templateTable.javaTableName}Form ${templateTable.javaTableName[0]?lower_case+templateTable.javaTableName[1..]}Form){
        if(${templateTable.javaTableName[0]?lower_case+templateTable.javaTableName[1..]}Form == null) {
            ${templateTable.javaTableName[0]?lower_case+templateTable.javaTableName[1..]}Form = new Query${templateTable.javaTableName}Form();
        }
        PageDTO<${templateTable.javaTableName}DTO> pageDTO = ${templateTable.javaTableName[0]?lower_case+templateTable.javaTableName[1..]}QueryRepository.findPage(currentPage, pageSize, ${templateTable.javaTableName}Assembler.INSTANCE.covertDTO(${templateTable.javaTableName[0]?lower_case+templateTable.javaTableName[1..]}Form));
        return Result.success("查询成功",pageDTO);
    }

    @GetMapping("/{id}")
    public Result<${templateTable.javaTableName}DTO> get${templateTable.javaTableName}ById(@PathVariable("id") Long id) {
        Optional<${templateTable.javaTableName}DTO> optional = ${templateTable.javaTableName[0]?lower_case+templateTable.javaTableName[1..]}QueryRepository.findById(id);
        return Result.success("获取成功", optional.orElseThrow(()-> new BusinessRuntimeException("查询结果不存在")));
    }

    @DeleteMapping
    public Result<Void> remove${templateTable.javaTableName}(@RequestBody List<Long> ids){
        return Result.success("删除成功", ${templateTable.javaTableName[0]?lower_case+templateTable.javaTableName[1..]}Service.remove${templateTable.javaTableName}(ids));
    }
}