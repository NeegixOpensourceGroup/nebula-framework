package com.neegix.system.dict.application.dto;

import lombok.Data;

/**
 * Created by IntelliJ IDEA (Community Edition)
 * Thank you to JetBrains for their contributions to the vast number of developers
 *
 * @Author: kushu001
 * @Date: 2024/09/20/21:03
 * @Description:
 */
@Data
public class DictItemDTO {
    private Long id;
    private Long pkDictGroup;
    private String name;
    private String value;
    private Integer sort;
    private Boolean enabled;
    private Boolean deleted;
}
