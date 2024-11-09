package com.neegix.application.query;

import lombok.Getter;
import lombok.Setter;

/**
 * Created by IntelliJ IDEA (Community Edition)
 * Thank you to JetBrains for their contributions to the vast number of developers
 *
 * @Author: kushu001
 * @Date: 2024/10/24/16:40
 * @Description:
 */
@Setter
@Getter
public class Pager {
    private int pageSize;
    private int currentPage;
    private int offset;
    public Pager(int currentPage, int pageSize){
        this.currentPage = currentPage;
        this.pageSize = pageSize;
        this.offset = (currentPage - 1) * pageSize; // 在构造函数中计算偏移量
    }

}
