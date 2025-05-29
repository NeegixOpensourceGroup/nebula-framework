package com.neegix.organization.post.application.service.query.handler;

import com.neegix.cqrs.query.handler.QueryHandler;
import com.neegix.exception.BusinessRuntimeException;
import com.neegix.organization.post.application.assembler.PostAssembler;
import com.neegix.organization.post.application.service.query.GetPostDetailQuery;
import com.neegix.organization.post.domain.entity.PostEntity;
import com.neegix.organization.post.domain.repository.PostRepository;
import com.neegix.organization.post.interfaces.vo.PostVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * Created by IntelliJ IDEA (Community Edition)
 * Thank you to JetBrains for their contributions to the vast number of developers
 *
 * @Author: kushu001
 * @Date: 2025/05/27/11:52
 * @Description:
 */
@Service
public class GetPostDetailHandler implements QueryHandler<GetPostDetailQuery, PostVO> {

    @Autowired
    private PostRepository postRepository;

    @Override
    public PostVO handle(GetPostDetailQuery query) {
        Optional<PostEntity> optional = postRepository.findById(query.getId());
        PostEntity post = optional.orElseThrow(()-> new BusinessRuntimeException("查询结果不存在"));
        return PostAssembler.INSTANCE.covertVO(post);
    }
}
