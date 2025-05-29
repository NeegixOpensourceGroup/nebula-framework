package com.neegix.system.role.application.service.query.handler;

import com.neegix.cqrs.query.handler.QueryHandler;
import com.neegix.system.role.application.repository.RoleQueryRepository;
import com.neegix.system.role.application.service.query.GetAllRoleQuery;
import com.neegix.system.role.interfaces.vo.RoleVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by IntelliJ IDEA (Community Edition)
 * Thank you to JetBrains for their contributions to the vast number of developers
 *
 * @Author: kushu001
 * @Date: 2025/05/19/17:22
 * @Description:
 */
@Service
public class GetAllRoleHandler implements QueryHandler<GetAllRoleQuery, List<RoleVO>> {

    @Autowired
    private RoleQueryRepository roleQueryRepository;

    @Override
    public List<RoleVO> handle(GetAllRoleQuery query) {
        return roleQueryRepository.findAll();
    }
}
