package com.neegix.organization.psn.application.service.query.mapper;

import com.neegix.organization.psn.application.service.query.GetPagePsnQuery;
import com.neegix.organization.psn.interfaces.form.QueryPsnForm;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

/**
 * Created by IntelliJ IDEA (Community Edition)
 * Thank you to JetBrains for their contributions to the vast number of developers
 *
 * @Author: kushu001
 * @Date: 2025/05/28/21:22
 * @Description:
 */
@Mapper
public interface PsnQueryMapper {
    PsnQueryMapper INSTANCE = Mappers.getMapper(PsnQueryMapper.class);

    GetPagePsnQuery covertQuery(QueryPsnForm psnForm);
}
