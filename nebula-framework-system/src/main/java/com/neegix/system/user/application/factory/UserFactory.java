package com.neegix.system.user.application.factory;

import com.neegix.system.user.domain.entity.UserEntity;

/**
 * Created by IntelliJ IDEA (Community Edition)
 * Thank you to JetBrains for their contributions to the vast number of developers
 *
 * @Author: kushu001
 * @Date: 2025/06/26/16:36
 * @Description:
 */
public class UserFactory {
    public static UserEntity createUser(String code, String name, String email){
        UserEntity userEntity = new UserEntity();
        userEntity.setName(code);
        userEntity.setNickName(name);
        userEntity.setEmail(email);
        return userEntity;
    }
}
