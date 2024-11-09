package com.neegix.auth.application.dto;

import com.neegix.base.BaseDTO;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

/**
 * Created by IntelliJ IDEA (Community Edition)
 * Thank you to JetBrains for their contributions to the vast number of developers
 *
 * @Author: kushu001
 * @Date: 2024/09/13/14:47
 * @Description:
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class UserDTO extends BaseDTO {
    private Long id;
    private String name;
    private String password;
    private List<RoleDTO> roleDTOs;
}
