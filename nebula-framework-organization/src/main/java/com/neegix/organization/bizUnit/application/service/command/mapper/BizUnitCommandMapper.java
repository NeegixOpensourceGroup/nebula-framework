package com.neegix.organization.bizUnit.application.service.command.mapper;

import com.neegix.organization.bizUnit.application.service.command.CreateBizUnitCommand;
import com.neegix.organization.bizUnit.application.service.command.UpdateBizUnitCommand;
import com.neegix.organization.bizUnit.interfaces.form.NewBizUnitForm;
import com.neegix.organization.bizUnit.interfaces.form.UpdateBizUnitForm;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

/**
 * Created by IntelliJ IDEA (Community Edition)
 * Thank you to JetBrains for their contributions to the vast number of developers
 *
 * @Author: kushu001
 * @Date: 2025/05/25/09:27
 * @Description:
 */
@Mapper
public interface BizUnitCommandMapper {
    BizUnitCommandMapper  INSTANCE = Mappers.getMapper(BizUnitCommandMapper.class);

    CreateBizUnitCommand convertCommand(NewBizUnitForm form);

    UpdateBizUnitCommand convertCommand(UpdateBizUnitForm form);
}
