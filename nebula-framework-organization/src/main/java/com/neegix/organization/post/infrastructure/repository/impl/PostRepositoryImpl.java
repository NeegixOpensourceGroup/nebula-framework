package com.neegix.organization.post.infrastructure.repository.impl;

import com.neegix.organization.post.domain.entity.PostEntity;
import com.neegix.organization.post.domain.repository.PostRepository;
import com.neegix.organization.post.infrastructure.repository.convert.PostConverter;
import com.neegix.organization.post.infrastructure.repository.dataobject.PostDO;
import com.neegix.organization.post.infrastructure.repository.mapper.PostMapper;
import com.neegix.utils.SnowFlake;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

/**
 * Created by IntelliJ IDEA (Community Edition)
 * Thank you to JetBrains for their contributions to the vast number of developers
 *
 * @Author: kushu001
 * @Date: 2025/05/27/11:15
 * @Description:
 */
@Repository
public class PostRepositoryImpl implements PostRepository {

    @Autowired
    private PostMapper postMapper;

    @Override
    public void save(PostEntity postEntity) {
        PostDO postDO = PostConverter.INSTANCE.covertDO(postEntity);

        if (postDO.getId() == null) {
            postDO.setId(SnowFlake.generateId());
            postMapper.insert(postDO);
        } else {
            postMapper.updateByPrimaryKey(postDO);
        }
    }

    @Override
    public void removeByIds(List<Long> longs) {
        postMapper.deleteByPrimaryKeys(longs);
    }

    @Override
    public Optional<PostEntity> findById(Long aLong) {
        PostDO postDO = postMapper.selectByPrimaryKey(aLong);
        return Optional.ofNullable(PostConverter.INSTANCE.covertEntity(postDO));
    }
}
