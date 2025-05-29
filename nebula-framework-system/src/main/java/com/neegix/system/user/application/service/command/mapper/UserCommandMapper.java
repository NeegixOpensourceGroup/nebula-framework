package com.neegix.system.user.application.service.command.mapper;

import com.neegix.system.user.application.service.command.CreateUserCommand;
import com.neegix.system.user.application.service.command.UpdateUserCommand;
import com.neegix.system.user.interfaces.form.NewUserForm;
import com.neegix.system.user.interfaces.form.UpdateUserForm;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

/**
 * Created by IntelliJ IDEA (Community Edition)
 * Thank you to JetBrains for their contributions to the vast number of developers
 *
 * @Author: kushu001
 * @Date: 2025/05/08/17:09
 * @Description:
 */
@Mapper
public interface UserCommandMapper {
    UserCommandMapper INSTANCE = Mappers.getMapper(UserCommandMapper.class);

    CreateUserCommand covertCommand(NewUserForm userForm);

    UpdateUserCommand covertCommand(UpdateUserForm userForm);
}
