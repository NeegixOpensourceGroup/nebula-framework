package com.neegix.system.user.infrastructure.repository.dataobject;

import com.neegix.base.BaseDO;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * Created by IntelliJ IDEA (Community Edition)
 * Thank you to JetBrains for their contributions to the vast number of developers
 *
 * @Author: kushu001
 * @Date: 2025/03/19/17:23
 * @Description:
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class UserRoleRelDO extends BaseDO {
    private Long id;
    private Long pkUser;
    private Long pkRole;

    public UserRoleRelDO(Long id, Long pkUser, Long pkRole) {
        this.id = id;
        this.pkUser = pkUser;
        this.pkRole = pkRole;
    }
}
