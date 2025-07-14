package com.neegix.system.user.application.service.command.handler;

import com.neegix.cqrs.command.handler.CommandHandler;
import com.neegix.exception.BusinessRuntimeException;
import com.neegix.system.user.application.service.command.EnabledCommand;
import com.neegix.system.user.domain.entity.UserEntity;
import com.neegix.system.user.domain.repository.UserRepository;
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
@Service
public class EnabledHandler implements CommandHandler<EnabledCommand, Void> {
    @Autowired
    private UserRepository userRepository;
    @Override
    public Void handle(EnabledCommand command) {
        UserEntity user = userRepository.findById(command.getPkUser()).orElseThrow(() -> {throw new BusinessRuntimeException("用户不存在！");});

        user.enabled();

        userRepository.save(user);
        return null;
    }
}
