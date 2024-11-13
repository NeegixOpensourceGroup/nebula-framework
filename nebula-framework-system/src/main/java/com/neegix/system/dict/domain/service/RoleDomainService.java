package com.neegix.system.dict.domain.service;

import com.neegix.system.dict.application.dto.RoleDTO;
import com.neegix.system.dict.domain.entity.RoleEntity;
import org.springframework.stereotype.Component;

/**
 * Created by IntelliJ IDEA (Community Edition)
 * Thank you to JetBrains for their contributions to the vast number of developers
 *
 * @Author: kushu001
 * @Date: 2024/10/30/17:16
 * @Description:
 */
@Component
public class RoleDomainService {

    public RoleEntity createRoleWithMenus(RoleDTO roleDTO){
        RoleEntity roleEntity = new RoleEntity();
        return roleEntity;
    }
}
