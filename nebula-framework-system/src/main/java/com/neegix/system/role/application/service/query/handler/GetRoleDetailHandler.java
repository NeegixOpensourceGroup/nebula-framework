package com.neegix.system.role.application.service.query.handler;

import com.neegix.cqrs.query.handler.QueryHandler;
import com.neegix.exception.BusinessRuntimeException;
import com.neegix.system.role.application.assembler.RoleAssembler;
import com.neegix.system.role.application.service.query.GetRoleDetailQuery;
import com.neegix.system.role.domain.entity.Role;
import com.neegix.system.role.domain.repository.RoleRepository;
import com.neegix.system.role.interfaces.vo.RoleVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * Created by IntelliJ IDEA (Community Edition)
 * Thank you to JetBrains for their contributions to the vast number of developers
 *
 * @Author: kushu001
 * @Date: 2025/05/14/11:06
 * @Description:
 */
@Service
public class GetRoleDetailHandler implements QueryHandler<GetRoleDetailQuery, RoleVO> {

    @Autowired
    private RoleRepository roleRepository;

    @Override
    public RoleVO handle(GetRoleDetailQuery query) {
        Optional<Role> optional = roleRepository.findById(query.getId());
        Role role = optional.orElseThrow(()-> new BusinessRuntimeException("查询结果不存在"));
        return RoleAssembler.INSTANCE.covertVO(role);
    }
}
