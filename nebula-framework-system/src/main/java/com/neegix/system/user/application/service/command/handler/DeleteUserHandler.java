package com.neegix.system.user.application.service.command.handler;

import com.neegix.cqrs.command.handler.CommandHandler;
import com.neegix.system.user.application.service.command.DeleteUserCommand;
import com.neegix.system.user.domain.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by IntelliJ IDEA (Community Edition)
 * Thank you to JetBrains for their contributions to the vast number of developers
 *
 * @Author: kushu001
 * @Date: 2025/05/08/16:14
 * @Description:
 */
@Service
public class DeleteUserHandler implements CommandHandler<DeleteUserCommand, Void> {

    @Autowired
    private UserRepository userRepository;

    @Override
    @Transactional
    public Void handle(DeleteUserCommand command) {

        // 先删除用户角色关系
        userRepository.removeUserRoleRel(command.getIds());

        // 再删除用户
        userRepository.removeByIds(command.getIds());

        return null;
    }
}
