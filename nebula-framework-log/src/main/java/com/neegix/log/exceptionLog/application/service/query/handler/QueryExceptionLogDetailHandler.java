package com.neegix.log.exceptionLog.application.service.query.handler;

import com.neegix.cqrs.query.handler.QueryHandler;
import com.neegix.exception.BusinessRuntimeException;
import com.neegix.log.exceptionLog.application.assembler.ExceptionLogAssembler;
import com.neegix.log.exceptionLog.application.service.query.GetExceptionLogDetailQuery;
import com.neegix.log.exceptionLog.domain.entity.ExceptionLogEntity;
import com.neegix.log.exceptionLog.domain.repository.ExceptionLogRepository;
import com.neegix.log.exceptionLog.interfaces.vo.ExceptionLogVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * Created by IntelliJ IDEA (Community Edition)
 * Thank you to JetBrains for their contributions to the vast number of developers
 *
 * @Author: kushu001
 * @Date: 2025/05/06/17:41
 * @Description:
 */
@Service
public class QueryExceptionLogDetailHandler implements QueryHandler<GetExceptionLogDetailQuery, ExceptionLogVO> {

    @Autowired
    private ExceptionLogRepository exceptionLogRepository;

    @Override
    public ExceptionLogVO handle(GetExceptionLogDetailQuery query) {
        Optional<ExceptionLogEntity> optional = exceptionLogRepository.findById(query.getId());
        ExceptionLogEntity exceptionLog = optional.orElseThrow(()-> new BusinessRuntimeException("查询结果不存在"));
        return ExceptionLogAssembler.INSTANCE.convertVO(exceptionLog);
    }
}
