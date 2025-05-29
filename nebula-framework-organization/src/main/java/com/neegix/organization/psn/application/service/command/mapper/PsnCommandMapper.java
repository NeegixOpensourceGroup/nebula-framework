package com.neegix.organization.psn.application.service.command.mapper;

import com.neegix.organization.psn.application.service.command.CreatePsnCommand;
import com.neegix.organization.psn.application.service.command.UpdatePsnCommand;
import com.neegix.organization.psn.interfaces.form.NewPsnForm;
import com.neegix.organization.psn.interfaces.form.UpdatePsnForm;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

/**
 * Created by IntelliJ IDEA (Community Edition)
 * Thank you to JetBrains for their contributions to the vast number of developers
 *
 * @Author: kushu001
 * @Date: 2025/05/28/16:41
 * @Description:
 */

@Mapper
public interface PsnCommandMapper {
    PsnCommandMapper INSTANCE = Mappers.getMapper(PsnCommandMapper.class);

    CreatePsnCommand covertCommand(NewPsnForm psnForm);

    UpdatePsnCommand covertCommand(UpdatePsnForm psnForm);
}
