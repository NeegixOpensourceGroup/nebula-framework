package com.neegix.log.operationLog.application.service.query.handler;

import com.neegix.cqrs.query.handler.QueryHandler;
import com.neegix.exception.BusinessRuntimeException;
import com.neegix.log.operationLog.application.assembler.OperationLogAssembler;
import com.neegix.log.operationLog.application.service.query.GetOperationLogDetailQuery;
import com.neegix.log.operationLog.domain.entity.OperationLogEntity;
import com.neegix.log.operationLog.domain.repository.OperationLogRepository;
import com.neegix.log.operationLog.interfaces.vo.OperationLogVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * Created by IntelliJ IDEA (Community Edition)
 * Thank you to JetBrains for their contributions to the vast number of developers
 *
 * @Author: kushu001
 * @Date: 2025/05/07/17:32
 * @Description:
 */
@Service
public class GetOperationLogDetailHandler implements QueryHandler<GetOperationLogDetailQuery, OperationLogVO> {
    @Autowired
    private OperationLogRepository operationLogRepository;

    @Override
    public OperationLogVO handle(GetOperationLogDetailQuery query) {
        Optional<OperationLogEntity> optional = operationLogRepository.findById(query.getId());
        OperationLogEntity entity = optional.orElseThrow(()-> new BusinessRuntimeException("查询结果不存在"));
        return OperationLogAssembler.INSTANCE.covertVO(entity);
    }
}
