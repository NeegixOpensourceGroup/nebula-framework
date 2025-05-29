package com.neegix.system.dict.infrastructure.repository.convert;

import com.neegix.system.dict.application.dto.DictItemDTO;
import com.neegix.system.dict.domain.entity.DictItemEntity;
import com.neegix.system.dict.infrastructure.repository.dataobject.DictItemDO;
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
public interface DictItemConverter {
    DictItemConverter INSTANCE = Mappers.getMapper(DictItemConverter.class);
    DictItemDO covertDO(DictItemEntity dictItemEntity);
    DictItemEntity covertEntity(DictItemDO dictItemDO);
    DictItemDTO covertDTO(DictItemDO dictItemDO);
    List<DictItemDTO> covertDTOS(List<DictItemDO> dictItemDOS);
}
