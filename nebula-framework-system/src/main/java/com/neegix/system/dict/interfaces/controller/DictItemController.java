package com.neegix.system.dict.interfaces.controller;

import com.neegix.base.PageDTO;
import com.neegix.exception.BusinessRuntimeException;
import com.neegix.result.Result;
import com.neegix.system.dict.application.assembler.DictItemAssembler;
import com.neegix.system.dict.application.cqrs.query.DictItemQueryRepository;
import com.neegix.system.dict.application.dto.DictItemDTO;
import com.neegix.system.dict.application.service.DictItemService;
import com.neegix.system.dict.interfaces.form.NewDictItemForm;
import com.neegix.system.dict.interfaces.form.QueryDictItemForm;
import com.neegix.system.dict.interfaces.form.UpdateDictItemForm;
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
 * Created by IntelliJ IDEA (Community Edition)
 * Thank you to JetBrains for their contributions to the vast number of developers
 *
 * @Author: kushu001
 * @Date: 2024/09/20/16:42
 * @Description:
 */
@RestController
@RequestMapping("/api/v1/dictItems")
public class DictItemController {

    @Autowired
    private DictItemQueryRepository dictItemQueryRepository;

    @Autowired
    private DictItemService dictItemService;

    @PostMapping
    public Result<Void> createDictItem(@RequestBody NewDictItemForm newDictItemForm){
        Void result = dictItemService.createDictItem(newDictItemForm);
        return Result.success("创建成功", result);
    }

    @PutMapping
    public Result<Void> updateDictItem(@RequestBody UpdateDictItemForm updateDictItemForm){
        Void result = dictItemService.modifyDictItem(updateDictItemForm);
        return Result.success("更新成功",result);
    }

    @GetMapping("/{currentPage}/{pageSize}")
    public Result<PageDTO<DictItemDTO>> getDictItems(@PathVariable("currentPage") Integer currentPage, @PathVariable("pageSize") Integer pageSize, @RequestBody QueryDictItemForm queryDictItemForm){
        PageDTO<DictItemDTO> pageDTO = dictItemQueryRepository.findPage(currentPage, pageSize, DictItemAssembler.INSTANCE.covertDTO(queryDictItemForm));
        return Result.success("查询成功",pageDTO);
    }

    @GetMapping("/{id}")
    public Result<DictItemDTO> getDictItemById(@PathVariable("id") Long id) {
        Optional<DictItemDTO> optional = dictItemQueryRepository.findById(id);
        return Result.success("获取成功", optional.orElseThrow(()-> new BusinessRuntimeException("查询结果不存在")));
    }

    @DeleteMapping
    public Result<Void> removeDictItem(@RequestBody List<Long> ids){
        return Result.success("删除成功", dictItemService.removeDictItem(ids));
    }
}
