package com.neegix.development.menu.application.service.command;

import com.neegix.cqrs.command.Command;
import lombok.Data;

/**
 * Created by IntelliJ IDEA (Community Edition)
 * Thank you to JetBrains for their contributions to the vast number of developers
 *
 * @Author: kushu001
 * @Date: 2025/04/30/22:41
 * @Description:
 */
@Data
public class UpdateMenuCommand implements Command<Void> {
    // ID
    private Long id;
    // 父ID
    private Long pid;
    // 名称
    private String name;
    // 权限标识
    private String access;
    // 类型
    private Integer type;
    // 顺序
    private Integer order;
    // 是否启用（0 否 1 是）
    private Boolean enabled;
    // 是否删除（0 否 1 是）
    private Boolean deleted;
}
