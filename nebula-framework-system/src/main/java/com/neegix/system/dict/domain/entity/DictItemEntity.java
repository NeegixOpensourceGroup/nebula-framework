package com.neegix.system.dict.domain.entity;

import lombok.Data;

/**
 * Created by IntelliJ IDEA (Community Edition)
 * Thank you to JetBrains for their contributions to the vast number of developers
 *
 * @Author: kushu001
 * @Date: 2024/10/14/17:06
 * @Description:
 */
@Data
public class DictItemEntity {
    private Long id;
    private Long pkDictGroup;
    private String name;
    private String value;
    private Integer sort;
    private Boolean enabled;
    private Boolean deleted;
}
