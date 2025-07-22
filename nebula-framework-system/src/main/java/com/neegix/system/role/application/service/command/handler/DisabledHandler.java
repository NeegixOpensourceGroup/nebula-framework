package com.neegix.system.role.application.service.command.handler;

import com.neegix.cqrs.command.handler.CommandHandler;
import com.neegix.exception.BusinessRuntimeException;
import com.neegix.system.role.domain.entity.Role;
import com.neegix.system.role.domain.repository.RoleRepository;
import com.neegix.system.role.application.service.command.DisabledCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by IntelliJ IDEA (Community Edition)
 * Thank you to JetBrains for their contributions to the vast number of developers
 *
 * @Author: kushu001
 * @Date: 2025/07/14/15:37
 * @Description:
 */
@Service(value = "roleDisabledHandler")
public class DisabledHandler implements CommandHandler<DisabledCommand, Void> {
    @Autowired
    private RoleRepository roleRepository;
    @Override
    public Void handle(DisabledCommand command) {
        Role role = roleRepository.findById(command.getPkRole()).orElseThrow(() -> {throw new BusinessRuntimeException("角色不存在！");});

        role.disabled();

        roleRepository.save(role);
        return null;
    }
}
