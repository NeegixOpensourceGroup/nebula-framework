package com.neegix.log.operationLog.application.service.query.mapper;

import com.neegix.log.operationLog.application.service.query.GetPageOperationLogQuery;
import com.neegix.log.operationLog.infrastructure.repository.dataobject.OperationLogDO;
import com.neegix.log.operationLog.interfaces.form.QueryOperationLogForm;
import com.neegix.log.operationLog.interfaces.vo.OperationLogVO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
 * Created by IntelliJ IDEA (Community Edition)
 * Thank you to JetBrains for their contributions to the vast number of developers
 *
 * @Author: kushu001
 * @Date: 2025/05/06/17:36
 * @Description:
 */
@Mapper
public interface OperationLogQueryMapper {
    OperationLogQueryMapper INSTANCE = Mappers.getMapper(OperationLogQueryMapper.class);

    GetPageOperationLogQuery covertToGetQuery(QueryOperationLogForm queryOperationLogForm);

    List<OperationLogVO> covertVO(List<OperationLogDO> OperationLogDOs);
}
