package com.neegix.system.dict.interfaces.controller;

import com.neegix.base.PageVO;
import com.neegix.cqrs.command.UniversalCommandBus;
import com.neegix.cqrs.query.UniversalQueryBus;
import com.neegix.inferfaces.result.Result;
import com.neegix.system.dict.application.service.command.CreateDictGroupCommand;
import com.neegix.system.dict.application.service.command.DeleteDictGroupCommand;
import com.neegix.system.dict.application.service.command.UpdateDictGroupCommand;
import com.neegix.system.dict.application.service.query.GetDictGroupDetailQuery;
import com.neegix.system.dict.application.service.query.GetPageDictGroupQuery;
import com.neegix.system.dict.interfaces.form.NewDictGroupForm;
import com.neegix.system.dict.interfaces.form.QueryDictGroupForm;
import com.neegix.system.dict.interfaces.form.UpdateDictGroupForm;
import com.neegix.system.dict.interfaces.vo.DictGroupVO;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by IntelliJ IDEA (Community Edition)
 * Thank you to JetBrains for their contributions to the vast number of developers
 *
 * @Author: kushu001
 * @Date: 2024/09/20/16:42
 * @Description:
 */
@RestController
@RequestMapping("/api/v1/dictGroup")
public class DictGroupController {

    @Autowired
    private UniversalCommandBus commandBus;

    @Autowired
    private UniversalQueryBus queryBus;

    @PostMapping
    @PreAuthorize("hasAuthority('system:dictGroup:add')")
    public Result<Void> createDictGroup(@RequestBody @Valid NewDictGroupForm dictGroupForm){
        CreateDictGroupCommand command = new CreateDictGroupCommand(dictGroupForm.getCode(), dictGroupForm.getName());
        return Result.success("创建成功", commandBus.execute(command));
    }

    @PutMapping("/{id}")
    @PreAuthorize("hasAuthority('system:dictGroup:modify')")
    public Result<Void> updateDictGroup(@PathVariable("id") Long id, @RequestBody @Valid UpdateDictGroupForm dictGroupForm){
        UpdateDictGroupCommand command = new UpdateDictGroupCommand(id, dictGroupForm.getCode(), dictGroupForm.getName());
        return Result.success("更新成功",commandBus.execute(command));
    }

    @GetMapping("/{currentPage}/{pageSize}")
    @PreAuthorize("hasAuthority('system:dictGroup:list')")
    public Result<PageVO<DictGroupVO>> getDictGroups(@PathVariable("currentPage") Integer currentPage, @PathVariable("pageSize") Integer pageSize, @ModelAttribute QueryDictGroupForm dictGroupForm){
        return Result.success("查询成功",queryBus.execute(new GetPageDictGroupQuery(currentPage, pageSize, dictGroupForm.getCode(), dictGroupForm.getName())));
    }

    @GetMapping("/{id}")
    @PreAuthorize("hasAuthority('system:dictGroup:get')")
    public Result<DictGroupVO> getDictGroupById(@PathVariable("id") Long id) {
        return Result.success("获取成功", queryBus.execute(new GetDictGroupDetailQuery(id)));
    }

    @DeleteMapping
    @PreAuthorize("hasAuthority('system:dictGroup:remove')")
    public Result<Void> removeDictGroup(@RequestBody List<Long> ids){
        return Result.success("删除成功", commandBus.execute(new DeleteDictGroupCommand(ids)));
    }
}
