package com.neegix.log.loginLog.application.service.query.handler;

import com.neegix.application.query.NebulaSQL;
import com.neegix.base.PageVO;
import com.neegix.cqrs.query.handler.QueryHandler;
import com.neegix.log.loginLog.application.repository.LoginLogQueryRepository;
import com.neegix.log.loginLog.infrastructure.repository.condition.LoginLogWhereGroup;
import com.neegix.log.loginLog.application.service.query.GetPageLoginLogQuery;
import com.neegix.log.loginLog.interfaces.vo.LoginLogVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by IntelliJ IDEA (Community Edition)
 * Thank you to JetBrains for their contributions to the vast number of developers
 *
 * @Author: kushu001
 * @Date: 2025/05/06/17:14
 * @Description:
 */
@Service
public class QueryPageLoginLogHandler implements QueryHandler<GetPageLoginLogQuery, PageVO<LoginLogVO>> {

    @Autowired
    private LoginLogQueryRepository loginLogQueryRepository;

    @Override
    public PageVO<LoginLogVO> handle(GetPageLoginLogQuery query) {
        NebulaSQL nebulaSQL = new NebulaSQL();
        nebulaSQL.createWhereGroups(LoginLogWhereGroup.class)
                .andCreateTimeBetween(query.getStartCreateTime(),query.getEndCreateTime())
                .andUpdateTimeBetween(query.getStartUpdateTime(),query.getEndUpdateTime())
                .andCreateUserEqualTo(query.getCreateUser())
                .andUpdateUserEqualTo(query.getUpdateUser())
                .andIpLikeTo(query.getIp())
                .andAreaLikeTo(query.getArea())
                .andTypeEqualTo(query.getType())
                .andClientLikeTo(query.getClient())
                .andEnabledEqualTo(query.getEnabled())
                .andDeletedEqualTo(query.getDeleted());
        return loginLogQueryRepository.findPage(query.getCurrentPage(), query.getPageSize(), nebulaSQL);
    }
}
