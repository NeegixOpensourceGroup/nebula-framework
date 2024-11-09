package com.neegix.system.application.cqrs.query;

import com.neegix.base.PageDTO;
import com.neegix.system.application.dto.RoleDTO;

import java.util.List;
import java.util.Optional;

/**
 * Created by IntelliJ IDEA (Community Edition)
 * Thank you to JetBrains for their contributions to the vast number of developers
 *
 * @Author: kushu001
 * @Date: 2024/09/20/20:39
 * @Description:
 */
public interface RoleQueryRepository {
    Optional<RoleDTO> findById(Long id);
    Optional<RoleDTO> findByName(String name);
    Integer selectCount(List<Long> ids);
    PageDTO<RoleDTO> findPage(Integer currentPage, Integer pageSize, RoleDTO roleDTO);
}
