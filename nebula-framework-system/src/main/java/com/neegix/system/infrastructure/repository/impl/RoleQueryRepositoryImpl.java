package com.neegix.system.infrastructure.repository.impl;

import com.neegix.base.PageDTO;
import com.neegix.system.application.cqrs.query.RoleQueryRepository;
import com.neegix.system.application.dto.RoleDTO;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

/**
 * Created by IntelliJ IDEA (Community Edition)
 * Thank you to JetBrains for their contributions to the vast number of developers
 *
 * @Author: kushu001
 * @Date: 2024/10/31/15:05
 * @Description:
 */
@Repository
public class RoleQueryRepositoryImpl implements RoleQueryRepository {
    @Override
    public Optional<RoleDTO> findById(Long id) {
        return Optional.empty();
    }

    @Override
    public Optional<RoleDTO> findByName(String name) {
        return Optional.empty();
    }

    @Override
    public Integer selectCount(List<Long> ids) {
        return 0;
    }

    @Override
    public PageDTO<RoleDTO> findPage(Integer currentPage, Integer pageSize, RoleDTO roleDTO) {
        return null;
    }
}
