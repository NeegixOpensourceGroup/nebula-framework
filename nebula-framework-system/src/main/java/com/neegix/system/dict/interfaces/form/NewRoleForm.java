package com.neegix.system.dict.interfaces.form;

import lombok.Data;

import java.util.List;

/**
 * Created by IntelliJ IDEA (Community Edition)
 * Thank you to JetBrains for their contributions to the vast number of developers
 *
 * @Author: kushu001
 * @Date: 2024/09/20/17:19
 * @Description:
 */
@Data
public class NewRoleForm {
    private String name;
    private String sign;
    private boolean enabled;
    private List<Long> menuIds;
    private List<Long> interfaceIds;
}
