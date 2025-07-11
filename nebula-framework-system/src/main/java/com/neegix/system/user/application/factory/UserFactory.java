package com.neegix.system.user.application.factory;

import com.neegix.exception.BusinessRuntimeException;
import com.neegix.system.dict.domain.entity.DictItemEntity;
import com.neegix.system.dict.domain.repository.DictItemRepository;
import com.neegix.system.user.application.service.command.CreateUserCommand;
import com.neegix.system.user.application.service.command.UpdateUserCommand;
import com.neegix.system.user.domain.entity.UserEntity;
import com.neegix.system.user.domain.entity.UserType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by IntelliJ IDEA (Community Edition)
 * Thank you to JetBrains for their contributions to the vast number of developers
 *
 * @Author: kushu001
 * @Date: 2025/06/26/16:36
 * @Description:
 */
@Component
public class UserFactory {

    @Autowired
    private DictItemRepository dictItemRepository;

    public static UserEntity createUser(String code, String name, String email){
        UserEntity userEntity = new UserEntity();
        userEntity.setName(code);
        userEntity.setNickName(name);
        userEntity.setEmail(email);
        return userEntity;
    }

    public UserEntity createUser(CreateUserCommand command) {
        UserEntity userEntity = new UserEntity();

        if (command.getUserType() != null) {
            DictItemEntity dictItemEntity = dictItemRepository.findById(command.getUserType()).orElseThrow(() -> new BusinessRuntimeException("用户类型不存在"));

            UserType userType = new UserType(dictItemEntity.getId(), dictItemEntity.getName(), dictItemEntity.getValue());

            userEntity.setUserType(userType);
        }

        userEntity.setName(command.getName());
        userEntity.setDescription(command.getDescription());
        userEntity.setMobilePhone(command.getMobilePhone());
        userEntity.setEmail(command.getEmail());
        return userEntity;
    }


    public UserEntity createUser(UpdateUserCommand command) {
        UserEntity userEntity = new UserEntity();
        if (command.getUserType() != null) {
            DictItemEntity dictItemEntity = dictItemRepository.findById(command.getUserType()).orElseThrow(() -> new BusinessRuntimeException("用户类型不存在"));

            UserType userType = new UserType(dictItemEntity.getId(), dictItemEntity.getName(), dictItemEntity.getValue());

            userEntity.setUserType(userType);
        }
        userEntity.setId(command.getId());
        userEntity.setName(command.getName());
        userEntity.setDescription(command.getDescription());
        userEntity.setMobilePhone(command.getMobilePhone());
        userEntity.setEmail(command.getEmail());
        return userEntity;
    }
}
