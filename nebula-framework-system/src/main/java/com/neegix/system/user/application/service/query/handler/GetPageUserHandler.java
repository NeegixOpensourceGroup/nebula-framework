package com.neegix.system.user.application.service.query.handler;

import com.neegix.application.query.NebulaSQL;
import com.neegix.base.PageVO;
import com.neegix.cqrs.query.handler.QueryHandler;
import com.neegix.system.user.application.repository.UserQueryRepository;
import com.neegix.system.user.infrastructure.repository.condition.UserWhereGroup;
import com.neegix.system.user.application.service.query.GetPageUserQuery;
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
public class GetPageUserHandler implements QueryHandler<GetPageUserQuery, PageVO<UserVO>> {

    @Autowired
    private UserQueryRepository userQueryRepository;

    @Override
    public PageVO<UserVO> handle(GetPageUserQuery query) {
        NebulaSQL nebulaSQL = new NebulaSQL();
        nebulaSQL.createWhereGroups(UserWhereGroup.class)
                .andCreateTimeBetween(query.getStartCreateTime(),query.getEndCreateTime())
                .andUpdateTimeBetween(query.getStartUpdateTime(),query.getEndUpdateTime())
                .andCreateUserEqualTo(query.getCreateUser())
                .andUpdateUserEqualTo(query.getUpdateUser())
                .andNameLikeTo(query.getName())
                .andPasswordLikeTo(query.getPassword())
                .andDescriptionLikeTo(query.getDescription())
                .andEmailLikeTo(query.getEmail())
                .andMobilePhoneLikeTo(query.getMobilePhone())
                .andEnabledEqualTo(query.getEnabled())
                .andDeletedEqualTo(query.getDeleted());
        return userQueryRepository.findPage(query.getCurrentPage(), query.getPageSize(), nebulaSQL);
    }
}
