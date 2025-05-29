package com.neegix.system.user.infrastructure.repository.impl;

import com.neegix.system.user.domain.entity.UserEntity;
import com.neegix.system.user.domain.entity.UserRoleEntity;
import com.neegix.system.user.domain.repository.UserRepository;
import com.neegix.system.user.infrastructure.repository.convert.UserConverter;
import com.neegix.system.user.infrastructure.repository.dataobject.UserDO;
import com.neegix.system.user.infrastructure.repository.dataobject.UserRoleDO;
import com.neegix.system.user.infrastructure.repository.dataobject.UserRoleRelDO;
import com.neegix.system.user.infrastructure.repository.mapper.UserMapper;
import com.neegix.system.user.infrastructure.repository.mapper.customized.UserCustomizedMapper;
import com.neegix.utils.SnowFlake;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * Created by IntelliJ IDEA (Community Edition)
 * Thank you to JetBrains for their contributions to the vast number of developers
 *
 * @Author: kushu001
 * @Date: 2025/05/08/16:16
 * @Description:
 */
@Repository
public class UserRepositoryImpl implements UserRepository {

    @Autowired
    private UserMapper userMapper;


    @Autowired
    private UserCustomizedMapper userCustomizedMapper;

    @Override
    @Transactional
    public void save(UserEntity userEntity) {
        UserDO userDO = UserConverter.INSTANCE.covertDO(userEntity);

        if (userEntity.getId() == null) {
            userDO.setId(SnowFlake.generateId());
            userMapper.insert(userDO);
        } else {
            userMapper.updateByPrimaryKey(userDO);
        }
    }

    @Override
    public void removeByIds(List<Long> longs) {
        userMapper.deleteByPrimaryKeys(longs);
    }

    @Override
    public Optional<UserEntity> findById(Long aLong) {

        // 查询用户
        UserDO userDO = userMapper.selectByPrimaryKey(aLong);
        UserEntity userEntity = UserConverter.INSTANCE.covertEntity(userDO);

        // 查询用户关联的角色
        List<UserRoleDO> userRoleDOS = userCustomizedMapper.selectRolesByPkUser(aLong);

        List<UserRoleEntity> userRoleEntities = userRoleDOS.stream().map(item-> {
            UserRoleEntity userRoleEntity = new UserRoleEntity();
            userRoleEntity.setId(item.getId());
            userRoleEntity.setName(item.getName());
            userRoleEntity.setDescription(item.getDescription());
            return userRoleEntity;
        }).collect(Collectors.toList());

        userEntity.setRoles(userRoleEntities);
        return Optional.ofNullable(userEntity);
    }

    @Override
    public void removeUserRoleRel(List<Long> userIds) {
        userCustomizedMapper.deleteUserRoleRel(userIds);
    }

    @Override
    public void batchInsertUserRoleRel(Long userId, List<Long> roleIds) {
        List<UserRoleRelDO> userRoleRelDOS = new ArrayList<>();
        for (Long roleId : roleIds) {
            UserRoleRelDO userRoleRelDO = new UserRoleRelDO(userId, roleId);
            userRoleRelDOS.add(userRoleRelDO);
        }

        userCustomizedMapper.insertUserRoleRel(userRoleRelDOS);
    }
}
