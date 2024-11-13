package com.neegix.system.dict.application.cqrs.command;

import com.neegix.application.command.ICommand;
import com.neegix.system.dict.domain.entity.RoleEntity;
import com.neegix.system.dict.infrastructure.repository.mapper.RoleMapper;
import org.springframework.context.ApplicationContext;

/**
 * Created by IntelliJ IDEA (Community Edition)
 * Thank you to JetBrains for their contributions to the vast number of developers
 *
 * @Author: kushu001
 * @Date: 2024/09/26/16:31
 * @Description:
 */

public class UpdateRoleCommand implements ICommand<Void> {
    private final RoleEntity roleEntity;

    public UpdateRoleCommand(RoleEntity roleEntity) {
        this.roleEntity = roleEntity;
    }

    @Override
    public Void execute(ApplicationContext context) {
        RoleMapper roleMapper = context.getBean(RoleMapper.class);

        return null;
    }
}
