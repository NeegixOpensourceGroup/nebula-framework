package com.neegix.organization.dept.application.service.query.mapper;

import com.neegix.organization.dept.application.service.query.GetDeptsQuery;
import com.neegix.organization.dept.interfaces.form.QueryDeptForm;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

/**
 * Created by IntelliJ IDEA (Community Edition)
 * Thank you to JetBrains for their contributions to the vast number of developers
 *
 * @Author: kushu001
 * @Date: 2025/05/26/21:26
 * @Description:
 */
@Mapper
public interface DeptQueryMapper {
    DeptQueryMapper INSTANCE = Mappers.getMapper(DeptQueryMapper.class);
    GetDeptsQuery covertEntity(QueryDeptForm deptForm);
}
