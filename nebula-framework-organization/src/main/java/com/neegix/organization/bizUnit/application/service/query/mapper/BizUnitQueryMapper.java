package com.neegix.organization.bizUnit.application.service.query.mapper;

import com.neegix.organization.bizUnit.application.service.query.GetBizUnitsQuery;
import com.neegix.organization.bizUnit.interfaces.form.QueryBizUnitForm;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

/**
 * Created by IntelliJ IDEA (Community Edition)
 * Thank you to JetBrains for their contributions to the vast number of developers
 *
 * @Author: kushu001
 * @Date: 2025/05/25/10:00
 * @Description:
 */
@Mapper
public interface BizUnitQueryMapper {
    BizUnitQueryMapper INSTANCE = Mappers.getMapper(BizUnitQueryMapper.class);

    GetBizUnitsQuery convertQuery(QueryBizUnitForm form);

}
