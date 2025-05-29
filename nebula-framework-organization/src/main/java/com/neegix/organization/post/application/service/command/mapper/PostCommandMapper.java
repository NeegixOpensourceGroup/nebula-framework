package com.neegix.organization.post.application.service.command.mapper;

import com.neegix.organization.post.application.service.command.CreatePostCommand;
import com.neegix.organization.post.application.service.command.UpdatePostCommand;
import com.neegix.organization.post.interfaces.form.NewPostForm;
import com.neegix.organization.post.interfaces.form.UpdatePostForm;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

/**
 * Created by IntelliJ IDEA (Community Edition)
 * Thank you to JetBrains for their contributions to the vast number of developers
 *
 * @Author: kushu001
 * @Date: 2025/05/27/11:45
 * @Description:
 */
@Mapper
public interface PostCommandMapper {
    PostCommandMapper INSTANCE = Mappers.getMapper(PostCommandMapper.class);

    CreatePostCommand covertCommand(NewPostForm postForm);

    UpdatePostCommand covertCommand(UpdatePostForm postForm);
}
