package com.neegix.system.role.domain.entity;

import lombok.Data;

import java.util.List;

/**
 * Created by IntelliJ IDEA (Community Edition)
 * Thank you to JetBrains for their contributions to the vast number of developers
 *
 * @Author: kushu001
 * @Date: 2025/05/13/15:30
 * @Description:
 */
@Data
public class Role {
    // ID
    private Long id;
    // 是否删除（0 否 1 是）
    private Boolean deleted;
    // 是否启用（0 否 1 是）
    private Boolean enabled;
    // 角色名称
    private String name;
    // 描述
    private String description;
    // 菜单权限
    private List<RoleMenu> pagePermissions;
    //Api权限
    private List<RoleApi> apiPermissions;
}
