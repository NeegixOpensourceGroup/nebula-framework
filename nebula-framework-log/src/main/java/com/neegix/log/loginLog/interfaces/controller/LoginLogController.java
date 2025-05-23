
package com.neegix.log.loginLog.interfaces.controller;

import com.neegix.base.PageVO;
import com.neegix.exception.BusinessRuntimeException;
import com.neegix.result.Result;
import com.neegix.log.loginLog.application.assembler.LoginLogAssembler;
import com.neegix.log.loginLog.application.cqrs.query.LoginLogQueryRepository;
import com.neegix.log.loginLog.domain.entity.LoginLogEntity;
import com.neegix.log.loginLog.interfaces.vo.LoginLogVO;
import com.neegix.log.loginLog.application.service.LoginLogService;
import com.neegix.log.loginLog.interfaces.form.NewLoginLogForm;
import com.neegix.log.loginLog.interfaces.form.QueryLoginLogForm;
import com.neegix.log.loginLog.interfaces.form.UpdateLoginLogForm;
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
  * The tool itself is copyrighted by <a href="https://www.neegix.com">https://www.neegix.com</a>.
  *
  * @author <a href="https://www.neegix.com">https://www.neegix.com</a>
  * @version 1.0.0
  * @since 2024-12-19 15:39:21
  */

@RestController
@RequestMapping("/api/v1/loginLog")
public class LoginLogController {

    @Autowired
    private LoginLogQueryRepository loginLogQueryRepository;

    @Autowired
    private LoginLogService loginLogService;

    @PreAuthorize("hasAuthority('log:loginLog:add')")
    @PostMapping
    public Result<Void> createLoginLog(@RequestBody NewLoginLogForm loginLogForm){
        Void result = loginLogService.createLoginLog(LoginLogAssembler.INSTANCE.covertEntity(loginLogForm));
        return Result.success("创建成功", result);
    }

    @PreAuthorize("hasAuthority('log:loginLog:modify')")
    @PutMapping("/{id}")
    public Result<Void> updateLoginLog(@PathVariable Long id, @RequestBody UpdateLoginLogForm loginLogForm){
        LoginLogEntity loginLogEntity = LoginLogAssembler.INSTANCE.covertEntity(loginLogForm);
        loginLogEntity.setId(id);
        Void result = loginLogService.modifyLoginLog(loginLogEntity);
        return Result.success("更新成功",result);
    }

    @PreAuthorize("hasAuthority('log:loginLog:list')")
    @GetMapping("/{currentPage}/{pageSize}")
    public Result<PageVO<LoginLogVO>> getLoginLogs(@PathVariable("currentPage") Integer currentPage, @PathVariable("pageSize") Integer pageSize, @ModelAttribute QueryLoginLogForm loginLogForm){
        if(loginLogForm == null) {
            loginLogForm = new QueryLoginLogForm();
        }
        PageVO<LoginLogVO> pageVO = loginLogQueryRepository.findPage(currentPage, pageSize, LoginLogAssembler.INSTANCE.covertDTO(loginLogForm));
        return Result.success("查询成功",pageVO);
    }

    @PreAuthorize("hasAuthority('log:loginLog:get')")
    @GetMapping("/{id}")
    public Result<LoginLogVO> getLoginLogById(@PathVariable("id") Long id) {
        Optional<LoginLogVO> optional = loginLogQueryRepository.findById(id);
        return Result.success("获取成功", optional.orElseThrow(()-> new BusinessRuntimeException("查询结果不存在")));
    }

    @PreAuthorize("hasAuthority('log:loginLog:remove')")
    @DeleteMapping
    public Result<Void> removeLoginLog(@RequestBody List<Long> ids){
        return Result.success("删除成功", loginLogService.removeLoginLog(ids));
    }
}