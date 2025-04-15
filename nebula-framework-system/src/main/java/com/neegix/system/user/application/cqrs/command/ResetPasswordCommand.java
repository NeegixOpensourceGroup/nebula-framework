package com.neegix.system.user.application.cqrs.command;

import com.neegix.application.command.ICommand;
import org.springframework.context.ApplicationContext;

/**
 * Created by IntelliJ IDEA (Community Edition)
 * Thank you to JetBrains for their contributions to the vast number of developers
 *
 * @Author: kushu001
 * @Date: 2025/04/15/16:01
 * @Description:
 */
public class ResetPasswordCommand implements ICommand<Void> {

    private String encryptedPassword;
    private Long userId;

    public ResetPasswordCommand(Long userId,String encryptedPassword){
        this.encryptedPassword = encryptedPassword;
        this.userId = userId;
    }
    @Override
    public Void execute(ApplicationContext context) {
        return null;
    }
}
