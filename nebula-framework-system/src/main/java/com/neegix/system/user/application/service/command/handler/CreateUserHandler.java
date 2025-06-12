package com.neegix.system.user.application.service.command.handler;

import com.neegix.application.query.NebulaSQL;
import com.neegix.cqrs.command.handler.CommandHandler;
import com.neegix.exception.BusinessRuntimeException;
import com.neegix.system.user.application.assembler.UserAssembler;
import com.neegix.system.user.application.service.command.CreateUserCommand;
import com.neegix.system.user.domain.entity.UserEntity;
import com.neegix.system.user.domain.repository.UserRepository;
import com.neegix.system.user.infrastructure.repository.condition.UserWhereGroup;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * Created by IntelliJ IDEA (Community Edition)
 * Thank you to JetBrains for their contributions to the vast number of developers
 *
 * @Author: kushu001
 * @Date: 2025/05/08/16:14
 * @Description:
 */
@Service
public class CreateUserHandler implements CommandHandler<CreateUserCommand, Void> {

    @Autowired
    private UserRepository userRepository;

    @Override
    public Void handle(CreateUserCommand command) {
        UserEntity userEntity = UserAssembler.INSTANCE.covertEntity(command);
        NebulaSQL nebulaSQL = new NebulaSQL();
        nebulaSQL.createWhereGroups(UserWhereGroup.class).andNameEqualTo(command.getName());
        Optional<UserEntity> nameOptional = userRepository.findByCriteria(nebulaSQL);
        if (nameOptional.isPresent()){
            throw new BusinessRuntimeException("用户名["+command.getName()+"]已存在");
        }
        nebulaSQL.clear();
        nebulaSQL.createWhereGroups(UserWhereGroup.class).andEmailEqualTo(command.getEmail());
        Optional<UserEntity> emailOptional = userRepository.findByCriteria(nebulaSQL);
        if (emailOptional.isPresent()){
            throw new BusinessRuntimeException("邮箱["+command.getEmail()+"]已存在");
        }
        userRepository.save(userEntity);
        return null;
    }
}
