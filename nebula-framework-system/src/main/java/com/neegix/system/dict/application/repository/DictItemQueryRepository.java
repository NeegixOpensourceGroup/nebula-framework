package com.neegix.system.dict.application.repository;

import com.neegix.application.query.IQueryRepository;
import com.neegix.application.query.NebulaSQL;
import com.neegix.base.PageVO;
import com.neegix.system.dict.interfaces.vo.DictItemVO;

import java.util.List;

/**
 * Created by IntelliJ IDEA (Community Edition)
 * Thank you to JetBrains for their contributions to the vast number of developers
 *
 * @Author: kushu001
 * @Date: 2024/09/20/20:39
 * @Description:
 */
public interface DictItemQueryRepository extends IQueryRepository<Long, NebulaSQL, DictItemVO> {
    PageVO<DictItemVO> findPage(Integer currentPage, Integer pageSize, NebulaSQL nebulaSQL);
    List<DictItemVO> findDictItemsByGroupCode(String code);
}
