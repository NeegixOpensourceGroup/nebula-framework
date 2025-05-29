package com.neegix.system.user.infrastructure.repository.dataobject;

import lombok.Data;

/**
 * Created by IntelliJ IDEA (Community Edition)
 * Thank you to JetBrains for their contributions to the vast number of developers
 *
 * @Author: kushu001
 * @Date: 2025/05/12/15:43
 * @Description:
 */
@Data
public class UserRoleDO {
    private Long id;
    private String name;
    private String description;
    private Boolean enabled;
    private Boolean deleted;
}
