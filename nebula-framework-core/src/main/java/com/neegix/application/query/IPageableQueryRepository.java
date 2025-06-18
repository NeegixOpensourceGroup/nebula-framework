package com.neegix.application.query;

import com.neegix.inferfaces.vo.BaseVO;
import com.neegix.base.PageVO;

/**
 * Created by IntelliJ IDEA (Community Edition)
 * Thank you to JetBrains for their contributions to the vast number of developers
 *
 * @Author: kushu001
 * @Date: 2024/11/26/14:22
 * @Description:
 */
public interface IPageableQueryRepository<PK, T, R extends BaseVO> extends IQueryRepository<PK, T, R> {
    PageVO<R> findPage(Integer currentPage, Integer pageSize, T t);
}
