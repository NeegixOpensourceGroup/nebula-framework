package com.neegix.organization.dept.application.service.command;

import com.neegix.cqrs.command.Command;
import lombok.Data;

/**
 * Created by IntelliJ IDEA (Community Edition)
 * Thank you to JetBrains for their contributions to the vast number of developers
 *
 * @Author: kushu001
 * @Date: 2025/05/26/20:57
 * @Description:
 */
@Data
public class DeleteDeptCommand implements Command<Void> {
    private Long id;

    public DeleteDeptCommand(Long id) {
        this.id = id;
    }
}
