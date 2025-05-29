package com.neegix.system.user.application.service.query.handler;

import com.neegix.cqrs.query.handler.QueryHandler;
import com.neegix.exception.BusinessRuntimeException;
import com.neegix.system.user.application.assembler.UserAssembler;
import com.neegix.system.user.application.service.query.GetUserDetailQuery;
import com.neegix.system.user.domain.entity.UserEntity;
import com.neegix.system.user.domain.repository.UserRepository;
import com.neegix.system.user.interfaces.vo.UserVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * Created by IntelliJ IDEA (Community Edition)
 * Thank you to JetBrains for their contributions to the vast number of developers
 *
 * @Author: kushu001
 * @Date: 2025/05/08/17:17
 * @Description:
 */
@Service
public class GetUserDetailHandler implements QueryHandler<GetUserDetailQuery, UserVO> {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserVO handle(GetUserDetailQuery query) {
        Optional<UserEntity> optional = userRepository.findById(query.getId());
        UserEntity entity = optional.orElseThrow(()-> new BusinessRuntimeException("查询结果不存在"));
        return UserAssembler.INSTANCE.covertVO(entity);
    }
}
