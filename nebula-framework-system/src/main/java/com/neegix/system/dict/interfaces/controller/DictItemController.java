package com.neegix.system.dict.interfaces.controller;

import com.neegix.base.PageVO;
import com.neegix.cqrs.command.UniversalCommandBus;
import com.neegix.cqrs.query.UniversalQueryBus;
import com.neegix.result.Result;
import com.neegix.system.dict.application.service.command.CreateDictItemCommand;
import com.neegix.system.dict.application.service.command.DeleteDictItemCommand;
import com.neegix.system.dict.application.service.command.UpdateDictItemCommand;
import com.neegix.system.dict.application.service.command.mapper.DictItemCommandMapper;
import com.neegix.system.dict.application.service.query.GetDictItemDetailQuery;
import com.neegix.system.dict.application.service.query.GetDictItemsQuery;
import com.neegix.system.dict.application.service.query.GetPageDictItemQuery;
import com.neegix.system.dict.interfaces.form.NewDictItemForm;
import com.neegix.system.dict.interfaces.form.QueryDictItemForm;
import com.neegix.system.dict.interfaces.form.UpdateDictItemForm;
import com.neegix.system.dict.interfaces.vo.DictItemVO;
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
@RequestMapping("/api/v1/dictItem")
public class DictItemController {

    @Autowired
    private UniversalCommandBus commandBus;

    @Autowired
    private UniversalQueryBus queryBus;

    @PostMapping("/{pkDictGroup}")
    @PreAuthorize("hasAuthority('system:dictItem:add')")
    public Result<Void> createDictItem(@PathVariable("pkDictGroup") Long pkDictGroup, @RequestBody @Valid NewDictItemForm newDictItemForm){
        CreateDictItemCommand command = DictItemCommandMapper.INSTANCE.covertCommand(newDictItemForm);
        command.setPkDictGroup(pkDictGroup);
        return Result.success("创建成功", commandBus.execute(command));
    }

    @PutMapping("/{pkDictGroup}/{id}")
    @PreAuthorize("hasAuthority('system:dictItem:modify')")
    public Result<Void> updateDictItem(@PathVariable("pkDictGroup") Long pkDictGroup, @PathVariable("id") Long id,  @RequestBody @Valid UpdateDictItemForm updateDictItemForm){
        UpdateDictItemCommand command = DictItemCommandMapper.INSTANCE.covertCommand(updateDictItemForm);
        command.setPkDictGroup(pkDictGroup);
        command.setId(id);
        return Result.success("更新成功",commandBus.execute(command));
    }

    @GetMapping("/{currentPage}/{pageSize}/{dictGroupId}")
    @PreAuthorize("hasAuthority('system:dictItem:list')")
    public Result<PageVO<DictItemVO>> getDictItems(@PathVariable("currentPage") Integer currentPage, @PathVariable("pageSize") Integer pageSize, @PathVariable("dictGroupId") Long dictGroupId,  @ModelAttribute QueryDictItemForm queryDictItemForm){
        GetPageDictItemQuery query = new GetPageDictItemQuery(currentPage, pageSize, dictGroupId, queryDictItemForm.getName());
        return Result.success("查询成功",queryBus.execute(query));
    }

    @GetMapping("/{id}")
    @PreAuthorize("hasAuthority('system:dictItem:get')")
    public Result<DictItemVO> getDictItemByDictGroupId(@PathVariable("id") Long id) {
        return Result.success("获取成功", queryBus.execute(new GetDictItemDetailQuery(id)));
    }

    @DeleteMapping("/{pkDictGroup}")
    @PreAuthorize("hasAuthority('system:dictItem:remove')")
    public Result<Void> removeDictItem(@PathVariable("pkDictGroup") Long pkDictGroup, @RequestBody List<Long> ids){
        return Result.success("删除成功", commandBus.execute(new DeleteDictItemCommand(ids)));
    }

    @GetMapping("/dictGroupCode/{dictGroupCode}")
    @PreAuthorize("hasAuthority('system:dictItem:getByDictGroupCode')")
    public Result<List<DictItemVO>> getDictItemByDictGroupCode(@PathVariable("dictGroupCode") String dictGroupCode){
        return Result.success("获取成功", queryBus.execute(new GetDictItemsQuery(dictGroupCode)));
    }
}
