package com.neegix.system.application.assembler;

import com.neegix.system.application.dto.DictItemDTO;
import com.neegix.system.domain.entity.DictItemEntity;
import com.neegix.system.interfaces.form.NewDictItemForm;
import com.neegix.system.interfaces.form.QueryDictItemForm;
import com.neegix.system.interfaces.form.UpdateDictItemForm;
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
public interface DictItemAssembler {
    DictItemAssembler INSTANCE = Mappers.getMapper(DictItemAssembler.class);

    DictItemEntity covertEntity(NewDictItemForm newDictItemForm);

    DictItemEntity covertEntity(UpdateDictItemForm updateDictItemForm);

    DictItemDTO covertDTO(QueryDictItemForm queryDictItemForm);
}
