package com.neegix.system.role.application.service.command.handler;

import com.neegix.cqrs.command.handler.CommandHandler;
import com.neegix.system.role.application.service.command.DeleteRoleCommand;
import com.neegix.system.role.domain.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by IntelliJ IDEA (Community Edition)
 * Thank you to JetBrains for their contributions to the vast number of developers
 *
 * @Author: kushu001
 * @Date: 2025/05/19/16:49
 * @Description:
 */
@Service
public class DeleteRoleHandler implements CommandHandler<DeleteRoleCommand, Void> {

    @Autowired
    private RoleRepository roleRepository;

    @Override
    public Void handle(DeleteRoleCommand command) {
        roleRepository.removeByIds(command.getIds());
        return null;
    }
}
