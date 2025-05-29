package com.neegix.organization.post.application.service.command;

import com.neegix.cqrs.command.Command;
import lombok.Data;

/**
 * Created by IntelliJ IDEA (Community Edition)
 * Thank you to JetBrains for their contributions to the vast number of developers
 *
 * @Author: kushu001
 * @Date: 2025/05/27/11:10
 * @Description:
 */
@Data
public class CreatePostCommand implements Command<Void> {
    // 编码
    private String code;
    // 是否删除（0 否 1 是）
    private Boolean deleted;
    // 是否启用（0 否 1 是）
    private Boolean enabled;
    // 名称
    private String name;
    // 业务单元ID
    private Long pkBizUnit;
    // 部门ID
    private Long pkDept;
}
