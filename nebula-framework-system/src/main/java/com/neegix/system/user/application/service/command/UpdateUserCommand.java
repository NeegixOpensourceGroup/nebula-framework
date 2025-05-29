package com.neegix.system.user.application.service.command;

import com.neegix.cqrs.command.Command;
import lombok.Data;

/**
 * Created by IntelliJ IDEA (Community Edition)
 * Thank you to JetBrains for their contributions to the vast number of developers
 *
 * @Author: kushu001
 * @Date: 2025/05/08/16:13
 * @Description:
 */
@Data
public class UpdateUserCommand implements Command<Void> {

    // ID
    private Long id;
    // 账号名称
    private String name;
    // 描述
    private String description;
    // 邮箱
    private String email;
    // 手机号
    private String mobilePhone;
    // 是否启用（0 否 1 是）
    private Boolean enabled;
    // 是否删除（0 否 1 是）
    private Boolean deleted;
}
