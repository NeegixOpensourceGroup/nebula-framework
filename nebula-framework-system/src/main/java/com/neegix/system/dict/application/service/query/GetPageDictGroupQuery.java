package com.neegix.system.dict.application.service.query;

import com.neegix.base.PageVO;
import com.neegix.cqrs.query.Query;
import com.neegix.system.dict.interfaces.vo.DictGroupVO;
import lombok.Data;

/**
 * Created by IntelliJ IDEA (Community Edition)
 * Thank you to JetBrains for their contributions to the vast number of developers
 *
 * @Author: kushu001
 * @Date: 2025/05/21/16:53
 * @Description:
 */
@Data
public class GetPageDictGroupQuery implements Query<PageVO<DictGroupVO>> {

    // 当前页
    private Integer currentPage;
    // 每页数
    private Integer pageSize;
    private String code;
    private String name;

    public GetPageDictGroupQuery(Integer currentPage, Integer pageSize, String code, String name) {
        this.currentPage = currentPage;
        this.pageSize = pageSize;
        this.code = code;
        this.name = name;
    }
}
