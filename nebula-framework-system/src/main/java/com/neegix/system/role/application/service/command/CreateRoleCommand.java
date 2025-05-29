package com.neegix.system.role.application.service.command;

import com.neegix.cqrs.command.Command;
import com.neegix.system.role.interfaces.form.PagePermissionForm;
import lombok.Data;

import java.util.List;

/**
 * Created by IntelliJ IDEA (Community Edition)
 * Thank you to JetBrains for their contributions to the vast number of developers
 *
 * @Author: kushu001
 * @Date: 2025/05/13/15:01
 * @Description:
 */
@Data
public class CreateRoleCommand implements Command<Void> {
    // 是否启用（0 否 1 是）
    private Boolean enabled;
    // 角色名称
    private String name;

    private String description;
    // Api权限
    private List<Long> apiPermissions;
    // 页面权限
    private List<PagePermissionForm> pagePermissions;
}
