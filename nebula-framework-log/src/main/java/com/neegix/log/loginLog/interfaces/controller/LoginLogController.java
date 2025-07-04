
package com.neegix.log.loginLog.interfaces.controller;

import com.neegix.base.PageVO;
import com.neegix.cqrs.command.UniversalCommandBus;
import com.neegix.cqrs.query.UniversalQueryBus;
import com.neegix.log.loginLog.application.service.command.DeleteLoginLogCommand;
import com.neegix.log.loginLog.application.service.query.GetLoginLogDetailQuery;
import com.neegix.log.loginLog.application.service.query.GetPageLoginLogQuery;
import com.neegix.log.loginLog.application.service.query.mapper.LoginLogQueryMapper;
import com.neegix.log.loginLog.interfaces.form.QueryLoginLogForm;
import com.neegix.log.loginLog.interfaces.vo.LoginLogVO;
import com.neegix.inferfaces.result.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

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
    private UniversalCommandBus commandBus;

    @Autowired
    private UniversalQueryBus queryBus;

    @PreAuthorize("hasAuthority('log:loginLog:list')")
    @GetMapping("/{currentPage}/{pageSize}")
    public Result<PageVO<LoginLogVO>> getLoginLogs(@PathVariable("currentPage") Integer currentPage, @PathVariable("pageSize") Integer pageSize, @ModelAttribute QueryLoginLogForm loginLogForm){
        if(loginLogForm == null) {
            loginLogForm = new QueryLoginLogForm();
        }

        GetPageLoginLogQuery query = LoginLogQueryMapper.INSTANCE.covertToGetQuery(loginLogForm);
        query.setCurrentPage(currentPage);
        query.setPageSize(pageSize);
        PageVO<LoginLogVO> pageVO = queryBus.execute(query);
        return Result.success("查询成功",pageVO);
    }

    @PreAuthorize("hasAuthority('log:loginLog:get')")
    @GetMapping("/{id}")
    public Result<LoginLogVO> getLoginLogById(@PathVariable("id") Long id) {
        return Result.success("获取成功", queryBus.execute(new GetLoginLogDetailQuery(id)));
    }

    @PreAuthorize("hasAuthority('log:loginLog:remove')")
    @DeleteMapping
    public Result<Void> removeLoginLog(@RequestBody List<Long> ids){
        return Result.success("删除成功", commandBus.execute(new DeleteLoginLogCommand(ids)));
    }
}