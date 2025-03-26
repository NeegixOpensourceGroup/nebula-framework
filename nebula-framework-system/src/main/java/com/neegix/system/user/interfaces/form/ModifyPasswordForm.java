package com.neegix.system.user.interfaces.form;

import lombok.Data;

/**
 * Created by IntelliJ IDEA (Community Edition)
 * Thank you to JetBrains for their contributions to the vast number of developers
 *
 * @Author: kushu001
 * @Date: 2025/03/26/11:10
 * @Description:
 */
@Data
public class ModifyPasswordForm {
    private String oldPassword;
    private String newPassword;
    private String confirmPassword;
}
