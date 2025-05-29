package com.neegix.system.user.application.service.command.handler;

import com.neegix.cqrs.command.handler.CommandHandler;
import com.neegix.system.user.application.assembler.UserAssembler;
import com.neegix.system.user.application.service.command.UpdateUserCommand;
import com.neegix.system.user.domain.entity.UserEntity;
import com.neegix.system.user.domain.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by IntelliJ IDEA (Community Edition)
 * Thank you to JetBrains for their contributions to the vast number of developers
 *
 * @Author: kushu001
 * @Date: 2025/05/08/16:14
 * @Description:
 */
@Service
public class UpdateUserHandler implements CommandHandler<UpdateUserCommand, Void> {

    @Autowired
    private UserRepository userRepository;

    @Override
    public Void handle(UpdateUserCommand command) {
        UserEntity userEntity = UserAssembler.INSTANCE.covertEntity(command);
        userRepository.save(userEntity);
        return null;
    }
}
