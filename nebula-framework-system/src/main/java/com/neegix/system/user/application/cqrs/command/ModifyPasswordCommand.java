package com.neegix.system.user.application.cqrs.command;

import com.neegix.application.command.ICommand;
import com.neegix.system.user.domain.entity.UserEntity;
import com.neegix.system.user.infrastructure.repository.dataobject.UserDO;
import com.neegix.system.user.infrastructure.repository.mapper.UserMapper;
import org.springframework.context.ApplicationContext;

/**
 * Created by IntelliJ IDEA (Community Edition)
 * Thank you to JetBrains for their contributions to the vast number of developers
 *
 * @Author: kushu001
 * @Date: 2025/03/26/11:12
 * @Description:
 */
public class ModifyPasswordCommand implements ICommand<UserEntity> {

    private final String encryptedPassword;

    private final Long id;

    public ModifyPasswordCommand(Long id, String encryptedPassword){
        this.id = id;
        this.encryptedPassword = encryptedPassword;
    }

    @Override
    public UserEntity execute(ApplicationContext context) {
        UserMapper userMapper = context.getBean(UserMapper.class);
        UserDO userDO = userMapper.selectByPrimaryKey(id);
        UserEntity userEntity = new UserEntity();
        userEntity.setId(userDO.getId());
        userEntity.setPassword(encryptedPassword);
        userEntity.setDeleted(userDO.getDeleted());
        userEntity.setEmail(userDO.getEmail());
        userEntity.setEnabled(userDO.getEnabled());
        userEntity.setName(userDO.getName());
        userEntity.setDescription(userDO.getDescription());
        userEntity.setCreateTime(userDO.getCreateTime());
        userEntity.setCreateUser(userDO.getCreateUser());
        userEntity.setUpdateTime(userDO.getUpdateTime());
        userEntity.setUpdateUser(userDO.getUpdateUser());
        return userEntity;
    }
}
