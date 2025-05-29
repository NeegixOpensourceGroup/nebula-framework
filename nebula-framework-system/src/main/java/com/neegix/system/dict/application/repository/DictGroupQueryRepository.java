package com.neegix.system.dict.application.cqrs.query;

import com.neegix.application.query.NebulaSQL;
import com.neegix.base.PageVO;
import com.neegix.system.dict.application.dto.DictGroupDTO;
import com.neegix.system.dict.interfaces.vo.DictGroupVO;

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
    Optional<DictGroupDTO> findByCodeAndName(String code, String name);
    Integer selectCount(List<Long> ids);
    PageVO<DictGroupVO> findPage(Integer currentPage, Integer pageSize, NebulaSQL nebulaSQL);
}
