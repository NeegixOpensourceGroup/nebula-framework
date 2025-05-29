package com.neegix.system.dict.application.service.command.mapper;

import com.neegix.system.dict.application.service.command.CreateDictItemCommand;
import com.neegix.system.dict.application.service.command.UpdateDictItemCommand;
import com.neegix.system.dict.interfaces.form.NewDictItemForm;
import com.neegix.system.dict.interfaces.form.UpdateDictItemForm;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

/**
 * Created by IntelliJ IDEA (Community Edition)
 * Thank you to JetBrains for their contributions to the vast number of developers
 *
 * @Author: kushu001
 * @Date: 2025/05/22/16:18
 * @Description:
 */
@Mapper
public interface DictItemCommandMapper {
    DictItemCommandMapper INSTANCE = Mappers.getMapper(DictItemCommandMapper.class);

    CreateDictItemCommand covertCommand(NewDictItemForm dictItemForm);

    UpdateDictItemCommand covertCommand(UpdateDictItemForm dictItemForm);
}
