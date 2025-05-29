package com.neegix.development.api.domain.entity;

import lombok.Data;

/**
 * Created by IntelliJ IDEA (Community Edition)
 * Thank you to JetBrains for their contributions to the vast number of developers
 *
 * @Author: kushu001
 * @Date: 2025/04/29/15:00
 * @Description:
 */
@Data
public class Module {
    private Long id;
    private String name;

    public Module() {
        // 默认构造函数
    }
    public Module(Long id, String name) {
        this.id = id;
        this.name = name;
    }
}
