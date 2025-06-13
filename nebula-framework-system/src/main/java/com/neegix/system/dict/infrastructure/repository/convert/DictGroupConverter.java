package com.neegix.system.dict.infrastructure.repository.convert;

import com.neegix.system.dict.domain.entity.DictGroupEntity;
import com.neegix.system.dict.infrastructure.repository.dataobject.DictGroupDO;
import com.neegix.system.dict.interfaces.vo.DictGroupVO;
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
    DictGroupEntity covertEntity(DictGroupDO dictGroupDO);
    List<DictGroupVO> covertDTOS(List<DictGroupDO> dictGroupDOS);
}
