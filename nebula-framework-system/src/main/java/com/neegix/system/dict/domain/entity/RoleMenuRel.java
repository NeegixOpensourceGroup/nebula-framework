package com.neegix.system.dict.domain.entity;

import lombok.Data;

/**
 * Created by IntelliJ IDEA (Community Edition)
 * Thank you to JetBrains for their contributions to the vast number of developers
 *
 * @Author: kushu001
 * @Date: 2024/10/30/16:39
 * @Description:
 */
@Data
public class RoleMenuRel {
    private Long pkRole;
    private Long pkMenu;

    public RoleMenuRel(Long pkRole, Long pkMenu){
        this.pkRole = pkRole;
        this.pkMenu = pkMenu;
    }
}
