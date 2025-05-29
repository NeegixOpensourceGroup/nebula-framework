package com.neegix.system.user.application.service.command;

import com.neegix.cqrs.command.Command;
import lombok.Data;

import java.util.List;

/**
 * Created by IntelliJ IDEA (Community Edition)
 * Thank you to JetBrains for their contributions to the vast number of developers
 *
 * @Author: kushu001
 * @Date: 2025/05/10/21:33
 * @Description:
 */
@Data
public class ResetPasswordCommand implements Command<Void> {
    private List<Long> userIds;

    public ResetPasswordCommand(List<Long> userIds) {
        this.userIds = userIds;
    }
}
