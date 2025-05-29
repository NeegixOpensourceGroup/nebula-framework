package com.neegix.system.user.application.service.command;

import com.neegix.cqrs.command.Command;
import lombok.Data;

import java.util.List;

/**
 * Created by IntelliJ IDEA (Community Edition)
 * Thank you to JetBrains for their contributions to the vast number of developers
 *
 * @Author: kushu001
 * @Date: 2025/05/08/16:13
 * @Description:
 */
@Data
public class DeleteUserCommand implements Command<Void> {
    private List<Long> ids;

    public DeleteUserCommand(List<Long> ids) {
        this.ids = ids;
    }
}
