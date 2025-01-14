package com.neegix.system.dict.interfaces.controller;

import com.neegix.base.PageVO;
import com.neegix.exception.BusinessRuntimeException;
import com.neegix.result.Result;
import com.neegix.system.dict.application.assembler.DictItemAssembler;
import com.neegix.system.dict.application.cqrs.query.DictItemQueryRepository;
import com.neegix.system.dict.application.service.DictItemService;
import com.neegix.system.dict.domain.entity.DictItemEntity;
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
import java.util.Optional;

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
    private DictItemQueryRepository dictItemQueryRepository;

    @Autowired
    private DictItemService dictItemService;

    @PostMapping("/{pkDictGroup}")
    @PreAuthorize("hasAuthority('system:dictItem:add')")
    public Result<Void> createDictItem(@PathVariable("pkDictGroup") Long pkDictGroup, @RequestBody @Valid NewDictItemForm newDictItemForm){
        DictItemEntity dictItemEntity = DictItemAssembler.INSTANCE.covertEntity(newDictItemForm);
        dictItemEntity.setPkDictGroup(pkDictGroup);
        Void result = dictItemService.createDictItem(dictItemEntity);
        return Result.success("创建成功", result);
    }

    @PutMapping("/{pkDictGroup}/{id}")
    @PreAuthorize("hasAuthority('system:dictItem:modify')")
    public Result<Void> updateDictItem(@PathVariable("pkDictGroup") Long pkDictGroup, @PathVariable("id") Long id,  @RequestBody @Valid UpdateDictItemForm updateDictItemForm){
        DictItemEntity dictItemEntity = DictItemAssembler.INSTANCE.covertEntity(updateDictItemForm);
        dictItemEntity.setPkDictGroup(pkDictGroup);
        dictItemEntity.setId(id);
        Void result = dictItemService.modifyDictItem(dictItemEntity);
        return Result.success("更新成功",result);
    }

    @GetMapping("/{currentPage}/{pageSize}/{dictGroupId}")
    @PreAuthorize("hasAuthority('system:dictItem:list')")
    public Result<PageVO<DictItemVO>> getDictItems(@PathVariable("currentPage") Integer currentPage, @PathVariable("pageSize") Integer pageSize, @PathVariable("dictGroupId") Long dictGroupId,  @ModelAttribute QueryDictItemForm queryDictItemForm){
        PageVO<DictItemVO> pageVO = dictItemQueryRepository.findPage(currentPage, pageSize, dictGroupId, DictItemAssembler.INSTANCE.covertDTO(queryDictItemForm));
        return Result.success("查询成功",pageVO);
    }

    @GetMapping("/{id}")
    @PreAuthorize("hasAuthority('system:dictItem:get')")
    public Result<DictItemVO> getDictItemByDictGroupId(@PathVariable("id") Long id) {
        Optional<DictItemVO> optional = dictItemQueryRepository.findById(id);
        return Result.success("获取成功", optional.orElseThrow(()-> new BusinessRuntimeException("查询结果不存在")));
    }

    @DeleteMapping("/{pkDictGroup}")
    @PreAuthorize("hasAuthority('system:dictItem:remove')")
    public Result<Void> removeDictItem(@PathVariable("pkDictGroup") Long pkDictGroup, @RequestBody List<Long> ids){
        return Result.success("删除成功", dictItemService.removeDictItem(pkDictGroup, ids));
    }

    @GetMapping("/dictGroupCode/{dictGroupCode}")
    @PreAuthorize("hasAuthority('system:dictItem:getByDictGroupCode')")
    public Result<List<DictItemVO>> getDictItemByDictGroupCode(@PathVariable("dictGroupCode") String dictGroupCode){
        return Result.success("获取成功", dictItemQueryRepository.findDictItemsByGroupCode(dictGroupCode));
    }
}
