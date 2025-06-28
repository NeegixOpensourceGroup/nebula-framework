package com.neegix.log.operationLog.application.service.query.handler;

import com.neegix.application.query.EnumOrder;
import com.neegix.application.query.NebulaSQL;
import com.neegix.base.PageVO;
import com.neegix.cqrs.query.handler.QueryHandler;
import com.neegix.log.operationLog.application.repository.OperationLogQueryRepository;
import com.neegix.log.operationLog.infrastructure.repository.condition.OperationLogWhereGroup;
import com.neegix.log.operationLog.application.service.query.GetPageOperationLogQuery;
import com.neegix.log.operationLog.interfaces.vo.OperationLogVO;
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
public class QueryPageOperationLogHandler implements QueryHandler<GetPageOperationLogQuery, PageVO<OperationLogVO>> {

    @Autowired
    private OperationLogQueryRepository operationLogQueryRepository;

    @Override
    public PageVO<OperationLogVO> handle(GetPageOperationLogQuery query) {
        NebulaSQL nebulaSQL = new NebulaSQL();
        nebulaSQL.createWhereGroups(OperationLogWhereGroup.class)
                .andIdEqualTo(query.getId())
                .andCreateTimeBetween(query.getStartCreateTime(),query.getEndCreateTime())
                .andUpdateTimeBetween(query.getStartUpdateTime(),query.getEndUpdateTime())
                .andCreateUserEqualTo(query.getCreateUser())
                .andUpdateUserEqualTo(query.getUpdateUser())
                .andModuleLikeTo(query.getModule())
                .andTypeEqualTo(query.getType())
                .andDescriptionLikeTo(query.getDescription());
        nebulaSQL.orderBy("create_time", EnumOrder.DESC);
        return operationLogQueryRepository.findPage(query.getCurrentPage(), query.getPageSize(), nebulaSQL);
    }
}
