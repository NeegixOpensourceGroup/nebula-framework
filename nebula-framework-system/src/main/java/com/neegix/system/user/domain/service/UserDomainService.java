package com.neegix.system.user.domain.service;

import com.neegix.application.query.NebulaSQL;
import com.neegix.exception.BusinessRuntimeException;
import com.neegix.system.dict.domain.entity.DictItemEntity;
import com.neegix.system.dict.domain.repository.DictItemRepository;
import com.neegix.system.user.domain.entity.UserEntity;
import com.neegix.system.user.domain.repository.UserRepository;
import com.neegix.system.user.infrastructure.repository.condition.UserWhereGroup;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

/**
 * Created by IntelliJ IDEA (Community Edition)
 * Thank you to JetBrains for their contributions to the vast number of developers
 *
 * @Author: kushu001
 * @Date: 2025/06/26/21:30
 * @Description:
 */
@Component
public class UserDomainService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private DictItemRepository dictItemRepository;


    public UserEntity getUser(Long id) {
        UserEntity user = userRepository.findById(id).orElseThrow(()->{
            throw  new BusinessRuntimeException("用户不存在");
        });

        if (user.getUserType() != null) {
            DictItemEntity dictItemEntity = dictItemRepository.findById(user.getUserType().getId()).orElseThrow(()->{
                throw  new BusinessRuntimeException("类型不存在");
            });

            user.getUserType().setName(dictItemEntity.getName());
            user.getUserType().setValue(dictItemEntity.getValue());
        }


        return user;
    }

    public boolean checkUserUnique(UserEntity userEntity){
        NebulaSQL nebulaSQL = new NebulaSQL();
        nebulaSQL.createWhereGroups(UserWhereGroup.class).andNameEqualTo(userEntity.getName());
        Optional<UserEntity> nameOptional = userRepository.findByCriteria(nebulaSQL);
        if (nameOptional.isPresent()){
            UserEntity user = nameOptional.get();
            if (!user.getId().equals(userEntity.getId())){
                return false;
               // throw new BusinessRuntimeException("用户名["+userEntity.getName()+"]已存在");
            }
        }

        nebulaSQL.clear();
        nebulaSQL.createWhereGroups(UserWhereGroup.class).andEmailEqualTo(userEntity.getEmail());
        Optional<UserEntity> emailOptional = userRepository.findByCriteria(nebulaSQL);
        if (emailOptional.isPresent()){
            UserEntity user = emailOptional.get();
            if (!user.getId().equals(userEntity.getId())){
                return false;
               // throw new BusinessRuntimeException("邮箱["+userEntity.getEmail()+"]已存在");
            }
        }

        return true;
    }
}
