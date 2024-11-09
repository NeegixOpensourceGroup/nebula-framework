package com.neegix.system.interfaces.controller;

import com.neegix.result.Result;
import com.neegix.system.interfaces.form.NewRoleForm;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by IntelliJ IDEA (Community Edition)
 * Thank you to JetBrains for their contributions to the vast number of developers
 *
 * @Author: kushu001
 * @Date: 2024/10/29/16:47
 * @Description:
 */
@RestController
@RequestMapping("/api/v1/roles")
public class RoleController {
    @PostMapping
    public Result<Void> createRole(@RequestBody NewRoleForm roleForm){

        return Result.success("创建成功");
    }
}
