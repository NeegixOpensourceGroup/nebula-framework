
package com.neegix.log.operationLog.interfaces.controller;

import com.neegix.base.PageVO;
import com.neegix.exception.BusinessRuntimeException;
import com.neegix.result.Result;
import com.neegix.log.operationLog.application.assembler.OperationLogAssembler;
import com.neegix.log.operationLog.application.cqrs.query.OperationLogQueryRepository;
import com.neegix.log.operationLog.interfaces.vo.OperationLogVO;
import com.neegix.log.operationLog.application.service.OperationLogService;
import com.neegix.log.operationLog.interfaces.form.NewOperationLogForm;
import com.neegix.log.operationLog.interfaces.form.QueryOperationLogForm;
import com.neegix.log.operationLog.interfaces.form.UpdateOperationLogForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
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
  * The tool itself is copyrighted by <a href="https://www.neegix.com">https://www.neegix.com</a>.
  *
  * @author <a href="https://www.neegix.com">https://www.neegix.com</a>
  * @version 1.0.0
  * @since 2024-11-24 19:51:10
  */

@RestController
@RequestMapping("/api/v1/operationLog")
public class OperationLogController {

    @Autowired
    private OperationLogQueryRepository operationLogQueryRepository;

    @Autowired
    private OperationLogService operationLogService;

    @PreAuthorize("hasAuthority('log:operationLog:add')")
    @PostMapping
    public Result<Void> createOperationLog(@RequestBody NewOperationLogForm operationLogForm){
        Void result = operationLogService.createOperationLog(OperationLogAssembler.INSTANCE.covertEntity(operationLogForm));
        return Result.success("创建成功", result);
    }

    @PreAuthorize("hasAuthority('log:operationLog:modify')")
    @PutMapping
    public Result<Void> updateOperationLog(@RequestBody UpdateOperationLogForm operationLogForm){
        Void result = operationLogService.modifyOperationLog(OperationLogAssembler.INSTANCE.covertEntity(operationLogForm));
        return Result.success("更新成功",result);
    }

    @PreAuthorize("hasAuthority('log:operationLog:list')")
    @GetMapping("/{currentPage}/{pageSize}")
    public Result<PageVO<OperationLogVO>> getOperationLogs(@PathVariable("currentPage") Integer currentPage, @PathVariable("pageSize") Integer pageSize, @ModelAttribute QueryOperationLogForm operationLogForm){
        if(operationLogForm == null) {
            operationLogForm = new QueryOperationLogForm();
        }
        PageVO<OperationLogVO> pageVO = operationLogQueryRepository.findPage(currentPage, pageSize, OperationLogAssembler.INSTANCE.covertDTO(operationLogForm));
        return Result.success("查询成功",pageVO);
    }

    @PreAuthorize("hasAuthority('log:operationLog:get')")
    @GetMapping("/{id}")
    public Result<OperationLogVO> getOperationLogById(@PathVariable("id") Long id) {
        Optional<OperationLogVO> optional = operationLogQueryRepository.findById(id);
        return Result.success("获取成功", optional.orElseThrow(()-> new BusinessRuntimeException("查询结果不存在")));
    }

    @PreAuthorize("hasAuthority('log:operationLog:remove')")
    @DeleteMapping
    public Result<Void> removeOperationLog(@RequestBody List<Long> ids){
        return Result.success("删除成功", operationLogService.removeOperationLog(ids));
    }
}