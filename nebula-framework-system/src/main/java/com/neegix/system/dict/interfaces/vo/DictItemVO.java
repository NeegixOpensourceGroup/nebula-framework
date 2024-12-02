package com.neegix.system.dict.interfaces.vo;

import lombok.Data;

/**
 * Created by IntelliJ IDEA (Community Edition)
 * Thank you to JetBrains for their contributions to the vast number of developers
 *
 * @Author: kushu001
 * @Date: 2024/09/20/17:19
 * @Description:
 */
@Data
public class DictItemVO {
    private Long id;
    private Long pkDictGroup;
    private String name;
    private String value;
    private Integer sort;
}
