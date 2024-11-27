package com.neegix.auth.application.assembler;

import com.neegix.auth.application.dto.RoleDTO;
import com.neegix.auth.application.dto.UserDTO;
import com.neegix.auth.infrastructure.repository.dataobject.RoleDO;
import com.neegix.auth.infrastructure.repository.dataobject.UserDO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
 * Created by IntelliJ IDEA (Community Edition)
 * Thank you to JetBrains for their contributions to the vast number of developers
 *
 * @Author: kushu001
 * @Date: 2024/09/14/09:57
 * @Description:
 */
@Mapper
public interface UserAssembler {
    UserAssembler INSTANCE = Mappers.getMapper(UserAssembler.class);

    @Mapping(target = "menuPermissions", ignore = true)
    @Mapping(target = "apiPermissions", ignore = true)
    UserDTO covertToUserDTO(UserDO userDO);
}
