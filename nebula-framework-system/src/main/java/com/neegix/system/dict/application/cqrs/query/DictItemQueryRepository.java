package com.neegix.system.dict.application.cqrs.query;

import com.neegix.application.query.IQueryRepository;
import com.neegix.base.PageVO;
import com.neegix.system.dict.application.dto.DictItemDTO;
import com.neegix.system.dict.interfaces.vo.DictItemVO;

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
public interface DictItemQueryRepository extends IQueryRepository<Long, DictItemDTO, DictItemVO> {
    Optional<DictItemDTO> findByName(String name);
    Integer selectCount(List<Long> ids);
    PageVO<DictItemVO> findPage(Integer currentPage, Integer pageSize, Long dictGroupId, DictItemDTO dictItemDTO);
    List<DictItemVO> findDictItemsByGroupCode(String code);
}
