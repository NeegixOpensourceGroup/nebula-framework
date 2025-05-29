package com.neegix.development.api.application.service.query.handler;

import com.neegix.application.query.NebulaSQL;
import com.neegix.base.PageVO;
import com.neegix.cqrs.query.handler.QueryHandler;
import com.neegix.development.api.application.repository.ApiQueryRepository;
import com.neegix.development.api.application.service.query.GetPageApiQuery;
import com.neegix.development.api.infrastructure.repository.condition.ApiWhereGroup;
import com.neegix.development.api.interfaces.vo.ApiListVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by IntelliJ IDEA (Community Edition)
 * Thank you to JetBrains for their contributions to the vast number of developers
 *
 * @Author: kushu001
 * @Date: 2025/04/27/17:33
 * @Description:
 */
@Service
public class QueryPageApiHandler implements QueryHandler<GetPageApiQuery, PageVO<ApiListVO>> {
    @Autowired
    private ApiQueryRepository apiQueryRepository;
    @Override
    public PageVO<ApiListVO> handle(GetPageApiQuery query) {
        NebulaSQL nebulaSQL = new NebulaSQL();
        nebulaSQL.createWhereGroups(ApiWhereGroup.class)
                .andCreateTimeBetween(query.getStartCreateTime(),query.getEndCreateTime())
                .andUpdateTimeBetween(query.getStartUpdateTime(),query.getEndUpdateTime())
                .andCreateUserEqualTo(query.getCreateUser())
                .andUpdateUserEqualTo(query.getUpdateUser())
                .andModuleEqualTo(query.getModule())
                .andNameLikeTo(query.getName())
                .andAccessLikeTo(query.getAccess())
                .andTypeEqualTo(query.getType())
                .andEnabledEqualTo(query.getEnabled())
                .andDeletedEqualTo(query.getDeleted());
        return apiQueryRepository.findPage(query.getCurrentPage(), query.getPageSize(), nebulaSQL);
    }
}
