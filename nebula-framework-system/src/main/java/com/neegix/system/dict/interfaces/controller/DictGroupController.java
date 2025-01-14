package com.neegix.system.dict.interfaces.controller;

import com.neegix.base.PageVO;
import com.neegix.exception.BusinessRuntimeException;
import com.neegix.result.Result;
import com.neegix.system.dict.application.assembler.DictGroupAssembler;
import com.neegix.system.dict.application.cqrs.query.DictGroupQueryRepository;
import com.neegix.system.dict.application.dto.DictGroupDTO;
import com.neegix.system.dict.application.service.DictGroupService;
import com.neegix.system.dict.interfaces.form.NewDictGroupForm;
import com.neegix.system.dict.interfaces.form.QueryDictGroupForm;
import com.neegix.system.dict.interfaces.form.UpdateDictGroupForm;
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
@RequestMapping("/api/v1/dictGroup")
public class DictGroupController {

    @Autowired
    private DictGroupQueryRepository dictGroupQueryRepository;

    @Autowired
    private DictGroupService dictGroupService;

    @PostMapping
    @PreAuthorize("hasAuthority('system:dictGroup:add')")
    public Result<Void> createDictGroup(@RequestBody @Valid NewDictGroupForm dictGroupForm){
        Void result = dictGroupService.createDictGroup(dictGroupForm.getCode(), dictGroupForm.getName());
        return Result.success("创建成功", result);
    }

    @PutMapping("/{id}")
    @PreAuthorize("hasAuthority('system:dictGroup:modify')")
    public Result<Void> updateDictGroup(@PathVariable("id") Long id, @RequestBody @Valid UpdateDictGroupForm dictGroupForm){
        Void result = dictGroupService.modifyDictGroup(id, dictGroupForm.getCode(), dictGroupForm.getName());
        return Result.success("更新成功",result);
    }

    @GetMapping("/{currentPage}/{pageSize}")
    @PreAuthorize("hasAuthority('system:dictGroup:list')")
    public Result<PageVO<DictGroupDTO>> getDictGroups(@PathVariable("currentPage") Integer currentPage, @PathVariable("pageSize") Integer pageSize, @ModelAttribute QueryDictGroupForm dictGroupForm){
        PageVO<DictGroupDTO> pageDTO = dictGroupQueryRepository.findPage(currentPage, pageSize, DictGroupAssembler.INSTANCE.covertDTO(dictGroupForm));
        return Result.success("查询成功",pageDTO);
    }

    @GetMapping("/{id}")
    @PreAuthorize("hasAuthority('system:dictGroup:get')")
    public Result<DictGroupDTO> getDictGroupById(@PathVariable("id") Long id) {
        Optional<DictGroupDTO> optional = dictGroupQueryRepository.findById(id);
        return Result.success("获取成功", optional.orElseThrow(()-> new BusinessRuntimeException("查询结果不存在")));
    }

    @DeleteMapping
    @PreAuthorize("hasAuthority('system:dictGroup:remove')")
    public Result<Void> removeDictGroup(@RequestBody List<Long> ids){
        return Result.success("删除成功", dictGroupService.removeDictGroup(ids));
    }
}
