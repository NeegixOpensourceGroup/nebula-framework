<#assign currentTime = .now>
<#-- 使用 ?split 方法将字符串按 '.' 分割成列表 -->
<#assign modules = templateTable.packageName?split(".")>
<#-- 使用 last 方法获取列表中的最后一个元素 -->
<#assign module = modules?last>

<#-- 包名 -->
<#assign packageName = templateTable.packageName>

<#-- 模块名 -->
<#assign moduleName = templateTable.javaTableName[0]?lower_case+templateTable.javaTableName[1..]>

<#-- 类名 -->
<#assign className = templateTable.javaTableName>

package ${packageName}.${moduleName}.interfaces.controller;

import com.neegix.base.PageVO;
import com.neegix.exception.BusinessRuntimeException;
import com.neegix.result.Result;
import ${packageName}.${moduleName}.application.assembler.${className}Assembler;
import ${packageName}.${moduleName}.application.cqrs.query.${className}QueryRepository;
import ${packageName}.${moduleName}.domain.entity.${className}Entity;
import ${packageName}.${moduleName}.interfaces.vo.${className}VO;
import ${packageName}.${moduleName}.application.service.${className}Service;
import ${packageName}.${moduleName}.interfaces.form.New${className}Form;
import ${packageName}.${moduleName}.interfaces.form.Query${className}Form;
import ${packageName}.${moduleName}.interfaces.form.Update${className}Form;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.security.access.prepost.PreAuthorize;

import java.util.List;
import java.util.Optional;

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

@RestController
@RequestMapping("/api/v1/${moduleName}")
public class ${className}Controller {

    @Autowired
    private ${className}QueryRepository ${moduleName}QueryRepository;

    @Autowired
    private ${className}Service ${moduleName}Service;

    @PreAuthorize("hasAuthority('${module}:${moduleName}:add')")
    @PostMapping
    public Result<Void> create${className}(@RequestBody @Valid New${className}Form ${moduleName}Form){
        Void result = ${moduleName}Service.create${className}(${className}Assembler.INSTANCE.covertEntity(${moduleName}Form));
        return Result.success("创建成功", result);
    }

    @PreAuthorize("hasAuthority('${module}:${moduleName}:modify')")
    @PutMapping("/{id}")
    public Result<Void> update${className}(@PathVariable Long id, @RequestBody @Valid Update${className}Form ${moduleName}Form){
        ${className}Entity ${moduleName}Entity = ${className}Assembler.INSTANCE.covertEntity(${moduleName}Form);
        ${moduleName}Entity.setId(id);
        Void result = ${moduleName}Service.modify${className}(${moduleName}Entity);
        return Result.success("更新成功",result);
    }

    @PreAuthorize("hasAuthority('${module}:${moduleName}:list')")
    @GetMapping("/{currentPage}/{pageSize}")
    public Result<PageVO<${className}VO>> get${className}s(@PathVariable("currentPage") Integer currentPage, @PathVariable("pageSize") Integer pageSize, @ModelAttribute Query${className}Form ${moduleName}Form){
        if(${moduleName}Form == null) {
            ${moduleName}Form = new Query${className}Form();
        }
        PageVO<${className}VO> pageVO = ${moduleName}QueryRepository.findPage(currentPage, pageSize, ${className}Assembler.INSTANCE.covertDTO(${moduleName}Form));
        return Result.success("查询成功",pageVO);
    }

    @PreAuthorize("hasAuthority('${module}:${moduleName}:get')")
    @GetMapping("/{id}")
    public Result<${className}VO> get${className}ById(@PathVariable("id") Long id) {
        Optional<${className}VO> optional = ${moduleName}QueryRepository.findById(id);
        return Result.success("获取成功", optional.orElseThrow(()-> new BusinessRuntimeException("查询结果不存在")));
    }

    @PreAuthorize("hasAuthority('${module}:${moduleName}:remove')")
    @DeleteMapping
    public Result<Void> remove${className}(@RequestBody List<Long> ids){
        return Result.success("删除成功", ${moduleName}Service.remove${className}(ids));
    }
}