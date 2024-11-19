package com.neegix.base;

import lombok.Data;

import java.util.List;

/**
 * Created by IntelliJ IDEA (Community Edition)
 * Thank you to JetBrains for their contributions to the vast number of developers
 *
 * @Author: kushu001
 * @Date: 2024/09/23/10:30
 * @Description:
 */
@Data
public class PageVO<T> {
    private Integer currentPage;
    private Integer pageSize;
    private Long total;
    private List<T> result;
    public PageVO(){}
    public PageVO(Integer currentPage, Integer pageSize){
        this.currentPage = currentPage;
        this.pageSize = pageSize;
    }
}
