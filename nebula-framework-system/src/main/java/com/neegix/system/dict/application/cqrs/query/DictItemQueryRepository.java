package com.neegix.system.dict.application.cqrs.query;

import com.neegix.base.PageVO;
import com.neegix.system.dict.application.dto.DictItemDTO;

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
public interface DictItemQueryRepository {
    Optional<DictItemDTO> findById(Long id);
    Optional<DictItemDTO> findByName(String name);
    Integer selectCount(List<Long> ids);
    PageVO<DictItemDTO> findPage(Integer currentPage, Integer pageSize, DictItemDTO dictItemDTO);
}
