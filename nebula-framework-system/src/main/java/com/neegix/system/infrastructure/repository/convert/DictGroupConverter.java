package com.neegix.system.infrastructure.repository.convert;

import com.neegix.system.application.dto.DictGroupDTO;
import com.neegix.system.domain.entity.DictGroupEntity;
import com.neegix.system.infrastructure.repository.dataobject.DictGroupDO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
 * Created by IntelliJ IDEA (Community Edition)
 * Thank you to JetBrains for their contributions to the vast number of developers
 *
 * @Author: kushu001
 * @Date: 2024/09/21/23:34
 * @Description:
 */
@Mapper
public interface DictGroupConverter {
    DictGroupConverter INSTANCE = Mappers.getMapper(DictGroupConverter.class);
    DictGroupDO covertDO(DictGroupEntity dictGroupEntity);
    DictGroupDTO covertDTO(DictGroupDO dictGroupDO);
    List<DictGroupDTO> covertDTOS(List<DictGroupDO> dictGroupDOS);
}
