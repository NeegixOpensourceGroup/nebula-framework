package com.neegix.system.role.infrastructure.repository.dataobject;

import lombok.Data;

/**
 * Created by IntelliJ IDEA (Community Edition)
 * Thank you to JetBrains for their contributions to the vast number of developers
 *
 * @Author: kushu001
 * @Date: 2024/12/02/15:04
 * @Description:
 */
@Data
public class RoleMenuRelDO {
    private Long pkRole;
    private Long pkMenu;
    private Boolean isHalf;
}
