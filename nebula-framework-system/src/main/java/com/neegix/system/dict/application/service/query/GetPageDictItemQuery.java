package com.neegix.system.dict.application.service.query;

import com.neegix.base.PageVO;
import com.neegix.cqrs.query.Query;
import com.neegix.system.dict.interfaces.vo.DictItemVO;
import lombok.Data;

/**
 * Created by IntelliJ IDEA (Community Edition)
 * Thank you to JetBrains for their contributions to the vast number of developers
 *
 * @Author: kushu001
 * @Date: 2025/05/22/17:03
 * @Description:
 */
@Data
public class GetPageDictItemQuery implements Query<PageVO<DictItemVO>> {
    // 当前页
    private Integer currentPage;
    // 每页数
    private Integer pageSize;
    private Long pkDictGroup;
    private String name;

    public GetPageDictItemQuery(Integer currentPage, Integer pageSize, Long pkDictGroup, String name) {
        this.currentPage = currentPage;
        this.pageSize = pageSize;
        this.pkDictGroup = pkDictGroup;
        this.name = name;
    }
}
