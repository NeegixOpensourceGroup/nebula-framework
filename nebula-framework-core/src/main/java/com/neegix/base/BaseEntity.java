package com.neegix.base;

import lombok.Data;

import java.time.LocalDate;

/**
 * Created by IntelliJ IDEA (Community Edition)
 * Thank you to JetBrains for their contributions to the vast number of developers
 *
 * @Author: kushu001
 * @Date: 2024/09/13/14:04
 * @Description:
 */
@Data
public class BaseEntity {
    private Long id;
    private LocalDate createTime;
    private LocalDate updateTime;
    private Long createUser;
    private Long updateUser;
}
