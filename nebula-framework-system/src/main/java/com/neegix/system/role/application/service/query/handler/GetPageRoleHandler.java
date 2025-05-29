package com.neegix.system.role.application.service.query.handler;

import com.neegix.application.query.NebulaSQL;
import com.neegix.base.PageVO;
import com.neegix.cqrs.query.handler.QueryHandler;
import com.neegix.system.role.application.repository.RoleQueryRepository;
import com.neegix.system.role.application.service.query.GetPageRoleQuery;
import com.neegix.system.role.infrastructure.repository.condition.RoleWhereGroup;
import com.neegix.system.role.interfaces.vo.RolePageVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by IntelliJ IDEA (Community Edition)
 * Thank you to JetBrains for their contributions to the vast number of developers
 *
 * @Author: kushu001
 * @Date: 2025/05/14/17:19
 * @Description:
 */
@Service
public class GetPageRoleHandler implements QueryHandler<GetPageRoleQuery, PageVO<RolePageVO>> {
    @Autowired
    private RoleQueryRepository roleQueryRepository;
    @Override
    public PageVO<RolePageVO> handle(GetPageRoleQuery query) {
        NebulaSQL nebulaSQL = new NebulaSQL();
        nebulaSQL.createWhereGroups(RoleWhereGroup.class)
                .andCreateTimeBetween(query.getStartCreateTime(),query.getEndCreateTime())
                .andCreateUserEqualTo(query.getCreateUser())
                .andDeletedEqualTo(query.getDeleted())
                .andEnabledEqualTo(query.getEnabled())
                .andNameLikeTo(query.getName())
                .andDescriptionLikeTo(query.getDescription())
                .andUpdateTimeBetween(query.getStartUpdateTime(),query.getEndUpdateTime())
                .andUpdateUserEqualTo(query.getUpdateUser());

        return roleQueryRepository.findPage(query.getCurrentPage(), query.getPageSize(), nebulaSQL);
    }
}
