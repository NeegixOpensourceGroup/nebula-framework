package com.neegix.organization.post.application.assembler;

import com.neegix.organization.post.application.dto.PostDTO;
import com.neegix.organization.post.interfaces.vo.PostVO;
import com.neegix.organization.post.domain.entity.PostEntity;
import com.neegix.organization.post.interfaces.form.NewPostForm;
import com.neegix.organization.post.interfaces.form.QueryPostForm;
import com.neegix.organization.post.interfaces.form.UpdatePostForm;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
import java.util.List;

 /**
  * This file is auto-generated by nebula-framework-generator.
  * The auto-generation plugin was developed using IntelliJ IDEA Community Edition.
  * Thanks to JetBrains for their outstanding contributions to the developer community.
  * <p>
  * The code generated by this tool is owned by the user of the tool.
  * The tool itself is copyrighted by <a href="https://www.neegix.com">https://www.neegix.com</a>.
  *
  * @author <a href="https://www.neegix.com">https://www.neegix.com</a>
  * @version 1.0.0
  * @since 2024-11-25 11:27:14
  */

@Mapper
public interface PostAssembler {
    PostAssembler INSTANCE = Mappers.getMapper(PostAssembler.class);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "createTime", ignore = true)
    @Mapping(target = "updateTime", ignore = true)
    @Mapping(target = "createUser", ignore = true)
    @Mapping(target = "updateUser", ignore = true)
    PostEntity covertEntity(NewPostForm newPostForm);

    @Mapping(target = "createTime", ignore = true)
    @Mapping(target = "updateTime", ignore = true)
    @Mapping(target = "createUser", ignore = true)
    @Mapping(target = "updateUser", ignore = true)
    PostEntity covertEntity(UpdatePostForm updatePostForm);

    @Mapping(target = "createTime", ignore = true)
    @Mapping(target = "updateTime", ignore = true)
    PostDTO covertDTO(QueryPostForm queryPostForm);

    List<PostVO> covertVO(List<PostDTO> PostDTOs);

    PostVO covertVO(PostDTO queryPostDTO);
}