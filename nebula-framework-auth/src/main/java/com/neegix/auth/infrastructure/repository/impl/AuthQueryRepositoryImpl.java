package com.neegix.auth.infrastructure.repository.impl;

import com.neegix.auth.application.dto.RoleDTO;
import com.neegix.auth.application.dto.UserDTO;
import com.neegix.auth.application.assembler.UserAssembler;
import com.neegix.auth.application.query.AuthQueryRepository;
import com.neegix.auth.infrastructure.repository.dataobject.RoleDO;
import com.neegix.auth.infrastructure.repository.dataobject.UserDO;
import com.neegix.auth.infrastructure.repository.mapper.AuthMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by IntelliJ IDEA (Community Edition)
 * Thank you to JetBrains for their contributions to the vast number of developers
 *
 * @Author: kushu001
 * @Date: 2024/09/13/13:54
 * @Description:
 */
@Repository
public class AuthQueryRepositoryImpl implements AuthQueryRepository {

    @Autowired
    private AuthMapper authMapper;
    @Override
    public UserDTO findUserByName(String name) {
        UserDO user = authMapper.selectUserByName(name);
        List<RoleDO> roleDOS = authMapper.selectRoleByUserId(user.getId());
        List<String> menuPermissions = authMapper.selectMenuPermissionByRoleIds(roleDOS.stream().map(RoleDO::getId).collect(Collectors.toList()));
        List<String> apiPermissions = authMapper.selectApiPermissionByRoleIds(roleDOS.stream().map(RoleDO::getId).collect(Collectors.toList()));
        UserDTO userDTO = UserAssembler.INSTANCE.covertToUserDTO(user);
        userDTO.setMenuPermissions(menuPermissions);
        userDTO.setApiPermissions(apiPermissions);
        return userDTO;
    }
}
