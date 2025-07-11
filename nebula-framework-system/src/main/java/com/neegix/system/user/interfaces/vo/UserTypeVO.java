package com.neegix.system.user.interfaces.vo;

import lombok.Data;

/**
 * Created by IntelliJ IDEA (Community Edition)
 * Thank you to JetBrains for their contributions to the vast number of developers
 *
 * @Author: kushu001
 * @Date: 2025/07/11/17:02
 * @Description:
 */
@Data
public class UserTypeVO {
    private Long id;
    private String name;
    private String value;

    public UserTypeVO(Long id, String name, String value) {
        this.id = id;
        this.name = name;
        this.value = value;
    }
}
