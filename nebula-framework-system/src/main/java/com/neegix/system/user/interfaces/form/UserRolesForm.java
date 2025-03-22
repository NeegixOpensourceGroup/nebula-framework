package com.neegix.system.user.interfaces.form;

import lombok.Data;

import java.util.List;

/**
 * Created by IntelliJ IDEA (Community Edition)
 * Thank you to JetBrains for their contributions to the vast number of developers
 *
 * @Author: kushu001
 * @Date: 2025/03/19/13:54
 * @Description:
 */
@Data
public class UserRolesForm {
    private List<Long> userIds;
    private List<Long> roleIds;
}
