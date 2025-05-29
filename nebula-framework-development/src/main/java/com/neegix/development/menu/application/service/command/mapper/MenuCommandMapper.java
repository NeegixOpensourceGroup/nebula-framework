package com.neegix.development.menu.application.service.command.mapper;

import com.neegix.development.menu.application.service.command.CreateMenuCommand;
import com.neegix.development.menu.application.service.command.UpdateMenuCommand;
import com.neegix.development.menu.interfaces.form.CreateMenuForm;
import com.neegix.development.menu.interfaces.form.UpdateMenuForm;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

/**
 * Created by IntelliJ IDEA (Community Edition)
 * Thank you to JetBrains for their contributions to the vast number of developers
 *
 * @Author: kushu001
 * @Date: 2025/04/30/22:46
 * @Description:
 */
@Mapper
public interface MenuCommandMapper {
    MenuCommandMapper INSTANCE = Mappers.getMapper(MenuCommandMapper.class);

    CreateMenuCommand covertToCreateCommand(CreateMenuForm createMenuForm);

    UpdateMenuCommand covertToUpdateCommand(UpdateMenuForm updateMenuForm);

}
