package com.neegix.log.operationLog.infrastructure.repository.convert;

import com.neegix.log.operationLog.application.dto.OperationLogDTO;
import com.neegix.log.operationLog.domain.entity.OperationLogEntity;
import com.neegix.log.operationLog.infrastructure.repository.dataobject.OperationLogDO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

 /**
  * This file is auto-generated by nebula-framework-generator.
  * The auto-generation plugin was developed using IntelliJ IDEA Community Edition.
  * Thanks to JetBrains for their outstanding contributions to the developer community.
  * <p>
  * The code generated by this tool is owned by the user of the tool.
  * The tool itself is copyrighted by <a href="https://www.neegix.com">https://www.neegix.com</a>.
  *
  * @author <a href="https://www.neegix.com">https://www.neegix.com</a>
  * @version 1.0.0
  * @since 2024-11-24 19:51:10
  */

@Mapper
public interface OperationLogConverter {
    OperationLogConverter INSTANCE = Mappers.getMapper(OperationLogConverter.class);
    OperationLogDO covertDO(OperationLogEntity operationLogEntity);

    @Mapping(target = "startCreateTime", ignore = true)
    @Mapping(target = "startUpdateTime", ignore = true)
    @Mapping(target = "endCreateTime", ignore = true)
    @Mapping(target = "endUpdateTime", ignore = true)
    OperationLogDTO covertDTO(OperationLogDO operationLogDO);

    @Mapping(target = "startCreateTime", ignore = true)
    @Mapping(target = "startUpdateTime", ignore = true)
    @Mapping(target = "endCreateTime", ignore = true)
    @Mapping(target = "endUpdateTime", ignore = true)
    List<OperationLogDTO> covertDTOS(List<OperationLogDO> operationLogDOS);
}