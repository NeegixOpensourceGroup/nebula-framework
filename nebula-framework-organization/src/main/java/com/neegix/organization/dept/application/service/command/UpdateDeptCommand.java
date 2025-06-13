package com.neegix.organization.dept.application.service.command;

import com.neegix.cqrs.command.Command;
import lombok.Data;

/**
 * Created by IntelliJ IDEA (Community Edition)
 * Thank you to JetBrains for their contributions to the vast number of developers
 *
 * @Author: kushu001
 * @Date: 2025/05/26/17:40
 * @Description:
 */
@Data
public class UpdateDeptCommand implements Command<Void> {
    // ID
    private Long id;
    // PID
    private Long pid;
    // 简称
    private String abbreviation;
    // 编码
    private String code;
    // 是否删除（0 否 1 是）
    private Boolean deleted;
    // 是否启用（0 否 1 是）
    private Boolean enabled;
    // 负责人
    private String manager;
    // 负责人电话
    private String mobilePhone;
    // 名称
    private String name;
    // 父ID
    private Long pkBizUnit;
    // 电话
    private String tel;
}
