package com.neegix.system.user.domain.entity;

import lombok.Data;

/**
 * Created by IntelliJ IDEA (Community Edition)
 * Thank you to JetBrains for their contributions to the vast number of developers
 *
 * @Author: kushu001
 * @Date: 2025/07/09/15:33
 * @Description:
 */
@Data
public class UserType {
    private Long id;
    private String name;
    private String value;

    public UserType(){}

    public UserType(Long id, String name, String value){
        this.id = id;
        this.name = name;
        this.value = value;
    }
}
