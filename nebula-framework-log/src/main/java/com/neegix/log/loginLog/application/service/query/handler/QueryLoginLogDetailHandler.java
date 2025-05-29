package com.neegix.log.loginLog.application.service.query.handler;

import com.neegix.cqrs.query.handler.QueryHandler;
import com.neegix.exception.BusinessRuntimeException;
import com.neegix.log.loginLog.application.assembler.LoginLogAssembler;
import com.neegix.log.loginLog.application.service.query.GetLoginLogDetailQuery;
import com.neegix.log.loginLog.domain.entity.LoginLogEntity;
import com.neegix.log.loginLog.domain.repository.LoginLogRepository;
import com.neegix.log.loginLog.interfaces.vo.LoginLogVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * Created by IntelliJ IDEA (Community Edition)
 * Thank you to JetBrains for their contributions to the vast number of developers
 *
 * @Author: kushu001
 * @Date: 2025/05/08/11:47
 * @Description:
 */
@Service
public class QueryLoginLogDetailHandler implements QueryHandler<GetLoginLogDetailQuery, LoginLogVO> {
    @Autowired
    private LoginLogRepository loginLogRepository;

    @Override
    public LoginLogVO handle(GetLoginLogDetailQuery query) {
        Optional<LoginLogEntity> optional = loginLogRepository.findById(query.getId());
        LoginLogEntity entity = optional.orElseThrow(()-> new BusinessRuntimeException("查询结果不存在"));
        return LoginLogAssembler.INSTANCE.covertVO(entity);
    }
}
