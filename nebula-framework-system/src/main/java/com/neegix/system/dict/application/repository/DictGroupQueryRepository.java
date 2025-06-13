package com.neegix.system.dict.application.repository;

import com.neegix.application.query.NebulaSQL;
import com.neegix.base.PageVO;
import com.neegix.system.dict.interfaces.vo.DictGroupVO;

/**
 * Created by IntelliJ IDEA (Community Edition)
 * Thank you to JetBrains for their contributions to the vast number of developers
 *
 * @Author: kushu001
 * @Date: 2024/09/20/20:39
 * @Description:
 */
public interface DictGroupQueryRepository {
    PageVO<DictGroupVO> findPage(Integer currentPage, Integer pageSize, NebulaSQL nebulaSQL);
}
