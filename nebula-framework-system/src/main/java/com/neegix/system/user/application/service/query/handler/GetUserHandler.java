package com.neegix.system.user.application.service.query.handler;

import com.neegix.cqrs.command.handler.CommandHandler;
import com.neegix.cqrs.query.handler.QueryHandler;
import com.neegix.system.user.application.repository.UserQueryRepository;
import com.neegix.system.user.application.service.query.GetUserQuery;
import com.neegix.system.user.infrastructure.repository.mapper.customized.UserCustomizedMapper;
import com.neegix.system.user.interfaces.vo.UserForExportVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by IntelliJ IDEA (Community Edition)
 * Thank you to JetBrains for their contributions to the vast number of developers
 *
 * @Author: kushu001
 * @Date: 2025/07/18/16:13
 * @Description:
 */
@Service
public class GetUserHandler implements QueryHandler<GetUserQuery, List<UserForExportVO>> {

    @Autowired
    private UserQueryRepository userQueryRepository;

    @Override
    public List<UserForExportVO> handle(GetUserQuery query) {
        return userQueryRepository.findUsers();
    }
}
