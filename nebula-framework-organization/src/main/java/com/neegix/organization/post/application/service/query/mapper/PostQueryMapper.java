package com.neegix.organization.post.application.service.query.mapper;

import com.neegix.organization.post.application.service.query.GetPagePostQuery;
import com.neegix.organization.post.interfaces.form.QueryPostForm;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

/**
 * Created by IntelliJ IDEA (Community Edition)
 * Thank you to JetBrains for their contributions to the vast number of developers
 *
 * @Author: kushu001
 * @Date: 2025/05/27/14:08
 * @Description:
 */
@Mapper
public interface PostQueryMapper {
    PostQueryMapper INSTANCE = Mappers.getMapper(PostQueryMapper.class);

    GetPagePostQuery covertQuery(QueryPostForm postForm);
}
