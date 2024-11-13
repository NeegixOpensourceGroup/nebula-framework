package com.neegix.system.dict.application.assembler;

import com.neegix.system.dict.application.dto.DictItemDTO;
import com.neegix.system.dict.domain.entity.RoleEntity;
import com.neegix.system.dict.interfaces.form.NewRoleForm;
import com.neegix.system.dict.interfaces.form.QueryDictItemForm;
import com.neegix.system.dict.interfaces.form.UpdateRoleForm;
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
public interface RoleAssembler {
    RoleAssembler INSTANCE = Mappers.getMapper(RoleAssembler.class);

    RoleEntity covertEntity(NewRoleForm newRoleForm);

    RoleEntity covertEntity(UpdateRoleForm updateRoleForm);

    DictItemDTO covertDTO(QueryDictItemForm queryDictItemForm);
}
