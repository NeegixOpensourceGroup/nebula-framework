package com.neegix.system.dict.application.cqrs.query;

import com.neegix.base.PageDTO;
import com.neegix.system.dict.application.dto.DictGroupDTO;

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
public interface DictGroupQueryRepository {
    Optional<DictGroupDTO> findById(Long id);
    Optional<DictGroupDTO> findByCodeAndName(String code, String name);
    Integer selectCount(List<Long> ids);
    PageDTO<DictGroupDTO> findPage(Integer currentPage, Integer pageSize, DictGroupDTO dictGroupDTO);
}
