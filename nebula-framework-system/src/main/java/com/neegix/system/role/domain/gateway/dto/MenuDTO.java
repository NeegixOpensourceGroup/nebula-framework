package com.neegix.system.role.domain.gateway.dto;

import lombok.Data;

/**
 * Created by IntelliJ IDEA (Community Edition)
 * Thank you to JetBrains for their contributions to the vast number of developers
 *
 * @Author: kushu001
 * @Date: 2025/05/19/14:56
 * @Description:
 */
@Data
public class MenuDTO {
    private Long id;
    private String name;
    private String access;
    private Boolean isHalf;
}
