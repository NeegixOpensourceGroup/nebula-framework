package com.neegix.log.exceptionLog.infrastructure.repository.convert;

import com.neegix.log.exceptionLog.application.dto.ExceptionLogDTO;
import com.neegix.log.exceptionLog.domain.entity.ExceptionLogEntity;
import com.neegix.log.exceptionLog.infrastructure.repository.dataobject.ExceptionLogDO;
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
  * @since 2024-12-19 15:04:54
  */

@Mapper
public interface ExceptionLogConverter {

    ExceptionLogConverter INSTANCE = Mappers.getMapper(ExceptionLogConverter.class);

    ExceptionLogDO covertDO(ExceptionLogEntity exceptionLogEntity);

    @Mapping(target = "startCreateTime", ignore = true)
    @Mapping(target = "startUpdateTime", ignore = true)
    @Mapping(target = "endCreateTime", ignore = true)
    @Mapping(target = "endUpdateTime", ignore = true)
    ExceptionLogDTO covertDTO(ExceptionLogDO exceptionLogDO);

    @Mapping(target = "startCreateTime", ignore = true)
    @Mapping(target = "startUpdateTime", ignore = true)
    @Mapping(target = "endCreateTime", ignore = true)
    @Mapping(target = "endUpdateTime", ignore = true)
    List<ExceptionLogDTO> covertDTOS(List<ExceptionLogDO> exceptionLogDOS);
}