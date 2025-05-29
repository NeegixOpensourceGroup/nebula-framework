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
public class ModifyMinePasswordCommand implements Command<Void> {
    private String oldPassword;
    private String newPassword;
    private String confirmPassword;

    public ModifyMinePasswordCommand(String oldPassword, String newPassword, String confirmPassword) {
        this.oldPassword = oldPassword;
        this.newPassword = newPassword;
        this.confirmPassword = confirmPassword;
    }
}
