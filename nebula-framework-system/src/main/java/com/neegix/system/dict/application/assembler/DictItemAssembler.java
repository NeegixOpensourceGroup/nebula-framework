package com.neegix.system.dict.application.assembler;

import com.neegix.system.dict.application.dto.DictItemDTO;
import com.neegix.system.dict.domain.entity.DictItemEntity;
import com.neegix.system.dict.interfaces.form.NewDictItemForm;
import com.neegix.system.dict.interfaces.form.QueryDictItemForm;
import com.neegix.system.dict.interfaces.form.UpdateDictItemForm;
import com.neegix.system.dict.interfaces.vo.DictItemVO;
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
public interface DictItemAssembler {
    DictItemAssembler INSTANCE = Mappers.getMapper(DictItemAssembler.class);

    DictItemEntity covertEntity(NewDictItemForm newDictItemForm);

    DictItemEntity covertEntity(UpdateDictItemForm updateDictItemForm);

    DictItemDTO covertDTO(QueryDictItemForm queryDictItemForm);

    List<DictItemVO> covertVO(List<DictItemDTO> dictItemDTOS);

    DictItemVO covertVO(DictItemDTO dictItemDTO);
}
