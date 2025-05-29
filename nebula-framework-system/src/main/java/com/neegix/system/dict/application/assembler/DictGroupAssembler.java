package com.neegix.system.dict.application.assembler;

import com.neegix.system.dict.domain.entity.DictGroupEntity;
import com.neegix.system.dict.interfaces.vo.DictGroupVO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

/**
 * Created by IntelliJ IDEA (Community Edition)
 * Thank you to JetBrains for their contributions to the vast number of developers
 *
 * @Author: kushu001
 * @Date: 2024/09/21/23:34
 * @Description:
 */
@Mapper
public interface DictGroupAssembler {
    DictGroupAssembler INSTANCE = Mappers.getMapper(DictGroupAssembler.class);

    DictGroupVO covertVO(DictGroupEntity dictGroup);
}
