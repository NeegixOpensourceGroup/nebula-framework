package com.neegix.system.user.application.service.command;

import com.neegix.cqrs.command.Command;
import lombok.Data;

/**
 * Created by IntelliJ IDEA (Community Edition)
 * Thank you to JetBrains for their contributions to the vast number of developers
 *
 * @Author: kushu001
 * @Date: 2025/07/14/15:36
 * @Description:
 */
@Data
public class EnabledCommand  implements Command<Void> {
    private Long pkUser;

    public EnabledCommand(Long pkUser) {
        this.pkUser = pkUser;
    }
}
