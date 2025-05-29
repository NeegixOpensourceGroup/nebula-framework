package com.neegix.system.user.application.service.query.mapper;

import com.neegix.system.user.application.service.query.GetPageUserQuery;
import com.neegix.system.user.interfaces.form.QueryUserForm;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

/**
 * Created by IntelliJ IDEA (Community Edition)
 * Thank you to JetBrains for their contributions to the vast number of developers
 *
 * @Author: kushu001
 * @Date: 2025/05/08/17:34
 * @Description:
 */
@Mapper
public interface UserQueryMapper {
    UserQueryMapper INSTANCE = Mappers.getMapper(UserQueryMapper.class);

    GetPageUserQuery covertToGetQuery(QueryUserForm queryUserForm);
}
