package com.neegix.system.user.application.service.query.handler;

import com.neegix.cqrs.query.handler.QueryHandler;
import com.neegix.system.user.application.assembler.UserAssembler;
import com.neegix.system.user.application.service.query.GetUserDetailQuery;
import com.neegix.system.user.domain.entity.UserEntity;
import com.neegix.system.user.domain.service.UserDomainService;
import com.neegix.system.user.interfaces.vo.UserTypeVO;
import com.neegix.system.user.interfaces.vo.UserVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
    private UserDomainService userDomainService;

    @Override
    public UserVO handle(GetUserDetailQuery query) {
        UserEntity user = userDomainService.getUser(query.getId());
        UserVO userVO = UserAssembler.INSTANCE.covertVO(user);
        if (user.getUserType() != null) {
            userVO.setUserType(new UserTypeVO(user.getUserType().getId(), user.getUserType().getName(), user.getUserType().getValue()));
        }
        return userVO;
    }
}
