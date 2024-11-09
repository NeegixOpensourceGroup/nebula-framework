package com.neegix.auth.application.dto;

import com.neegix.base.BaseDTO;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * Created by IntelliJ IDEA (Community Edition)
 * Thank you to JetBrains for their contributions to the vast number of developers
 *
 * @Author: kushu001
 * @Date: 2024/09/14/10:44
 * @Description:
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class RoleDTO extends BaseDTO {
    private String name;
    private String sign;
}
