package com.neegix.system.role.application.service.query.mapper;

import com.neegix.system.role.application.service.query.GetPageRoleQuery;
import com.neegix.system.role.interfaces.form.QueryRoleForm;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

/**
 * Created by IntelliJ IDEA (Community Edition)
 * Thank you to JetBrains for their contributions to the vast number of developers
 *
 * @Author: kushu001
 * @Date: 2025/05/14/17:38
 * @Description:
 */
@Mapper
public interface RoleQueryMapper {
    RoleQueryMapper INSTANCE = Mappers.getMapper(RoleQueryMapper.class);

    GetPageRoleQuery covertToGetQuery(QueryRoleForm queryRoleForm);
}
