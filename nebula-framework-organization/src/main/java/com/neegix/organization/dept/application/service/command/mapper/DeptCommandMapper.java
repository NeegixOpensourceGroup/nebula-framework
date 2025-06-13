package com.neegix.organization.dept.application.service.command.mapper;

import com.neegix.organization.dept.application.service.command.CreateDeptCommand;
import com.neegix.organization.dept.application.service.command.UpdateDeptCommand;
import com.neegix.organization.dept.interfaces.form.NewDeptForm;
import com.neegix.organization.dept.interfaces.form.UpdateDeptForm;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

/**
 * Created by IntelliJ IDEA (Community Edition)
 * Thank you to JetBrains for their contributions to the vast number of developers
 *
 * @Author: kushu001
 * @Date: 2025/05/26/19:06
 * @Description:
 */
@Mapper
public interface DeptCommandMapper {
    DeptCommandMapper INSTANCE = Mappers.getMapper(DeptCommandMapper.class);
    CreateDeptCommand covertEntity(NewDeptForm form);

    UpdateDeptCommand covertEntity(UpdateDeptForm form);
}
