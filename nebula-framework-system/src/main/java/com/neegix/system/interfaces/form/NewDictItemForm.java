package com.neegix.system.interfaces.form;

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
public class NewDictItemForm {
    private Long pkDictGroup;
    private String name;
    private String value;
    private Integer sort;
}
