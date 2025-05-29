package com.neegix.log.exceptionLog.application.service.query.handler;

import com.neegix.application.query.NebulaSQL;
import com.neegix.base.PageVO;
import com.neegix.cqrs.query.handler.QueryHandler;
import com.neegix.log.exceptionLog.application.repository.ExceptionLogQueryRepository;
import com.neegix.log.exceptionLog.application.service.query.GetPageExceptionLogQuery;
import com.neegix.log.exceptionLog.infrastructure.repository.condition.ExceptionLogWhereGroup;
import com.neegix.log.exceptionLog.interfaces.vo.ExceptionLogVO;
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
public class QueryPageExceptionLogHandler implements QueryHandler<GetPageExceptionLogQuery, PageVO<ExceptionLogVO>> {

    @Autowired
    private ExceptionLogQueryRepository exceptionLogQueryRepository;

    @Override
    public PageVO<ExceptionLogVO> handle(GetPageExceptionLogQuery query) {
        NebulaSQL nebulaSQL = new NebulaSQL();
        nebulaSQL.createWhereGroups(ExceptionLogWhereGroup.class)
                .andCreateTimeBetween(query.getStartCreateTime(),query.getEndCreateTime())
                .andUpdateTimeBetween(query.getStartUpdateTime(),query.getEndUpdateTime())
                .andCreateUserEqualTo(query.getCreateUser())
                .andUpdateUserEqualTo(query.getUpdateUser())
                .andUserLikeTo(query.getUser())
                .andModuleLikeTo(query.getModule())
                .andTypeEqualTo(query.getType())
                .andDescriptionLikeTo(query.getDescription())
                .andUriLikeTo(query.getUri())
                .andFullNameLikeTo(query.getFullName())
                .andExceptionLikeTo(query.getException());
        return exceptionLogQueryRepository.findPage(query.getCurrentPage(), query.getPageSize(), nebulaSQL);
    }
}
