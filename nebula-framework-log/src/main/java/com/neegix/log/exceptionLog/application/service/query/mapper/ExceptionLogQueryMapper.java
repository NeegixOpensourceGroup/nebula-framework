package com.neegix.log.exceptionLog.application.service.query.mapper;

import com.neegix.log.exceptionLog.application.service.query.GetPageExceptionLogQuery;
import com.neegix.log.exceptionLog.infrastructure.repository.dataobject.ExceptionLogDO;
import com.neegix.log.exceptionLog.interfaces.form.QueryExceptionLogForm;
import com.neegix.log.exceptionLog.interfaces.vo.ExceptionLogVO;
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
public interface ExceptionLogQueryMapper {
    ExceptionLogQueryMapper INSTANCE = Mappers.getMapper(ExceptionLogQueryMapper.class);

    GetPageExceptionLogQuery covertToGetQuery(QueryExceptionLogForm queryExceptionLogForm);

    List<ExceptionLogVO> covertVO(List<ExceptionLogDO> ExceptionLogDOs);
}
