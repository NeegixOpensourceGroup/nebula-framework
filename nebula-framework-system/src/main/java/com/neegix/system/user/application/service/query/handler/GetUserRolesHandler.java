package com.neegix.system.user.application.service.query.handler;

import com.neegix.cqrs.query.handler.QueryHandler;
import com.neegix.exception.BusinessRuntimeException;
import com.neegix.system.user.application.service.query.GetUserRolesQuery;
import com.neegix.system.user.domain.entity.UserEntity;
import com.neegix.system.user.domain.entity.UserRoleEntity;
import com.neegix.system.user.domain.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * Created by IntelliJ IDEA (Community Edition)
 * Thank you to JetBrains for their contributions to the vast number of developers
 *
 * @Author: kushu001
 * @Date: 2025/05/12/16:11
 * @Description:
 */
@Service
public class GetUserRolesHandler implements QueryHandler<GetUserRolesQuery, Set<Long>> {

    @Autowired
    private UserRepository userRepository;
    @Override
    public Set<Long> handle(GetUserRolesQuery query) {

        Optional<UserEntity> optional = userRepository.findById(query.getPkUser());

        UserEntity user = optional.orElseThrow(()-> new BusinessRuntimeException("查询用户不存在"));

        return user.getRoles().stream().map(UserRoleEntity::getId).collect(Collectors.toSet());
    }
}
