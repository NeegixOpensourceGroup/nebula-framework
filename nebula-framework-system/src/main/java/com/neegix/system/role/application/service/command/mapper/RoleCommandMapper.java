package com.neegix.system.role.application.service.command.mapper;

import com.neegix.system.role.application.service.command.CreateRoleCommand;
import com.neegix.system.role.application.service.command.UpdateRoleCommand;
import com.neegix.system.role.interfaces.form.NewRoleForm;
import com.neegix.system.role.interfaces.form.UpdateRoleForm;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

/**
 * Created by IntelliJ IDEA (Community Edition)
 * Thank you to JetBrains for their contributions to the vast number of developers
 *
 * @Author: kushu001
 * @Date: 2025/05/19/16:44
 * @Description:
 */
@Mapper
public interface RoleCommandMapper {
    RoleCommandMapper INSTANCE = Mappers.getMapper(RoleCommandMapper.class);

    CreateRoleCommand covertCommand(NewRoleForm roleForm);

    UpdateRoleCommand covertCommand(UpdateRoleForm roleForm);
}
