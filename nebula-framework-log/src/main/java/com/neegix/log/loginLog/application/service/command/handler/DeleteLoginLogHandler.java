package com.neegix.log.loginLog.application.service.command.handler;

import com.neegix.cqrs.command.handler.CommandHandler;
import com.neegix.log.loginLog.application.service.command.DeleteLoginLogCommand;
import com.neegix.log.loginLog.domain.repository.LoginLogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by IntelliJ IDEA (Community Edition)
 * Thank you to JetBrains for their contributions to the vast number of developers
 *
 * @Author: kushu001
 * @Date: 2025/05/08/11:41
 * @Description:
 */
@Service
public class DeleteLoginLogHandler implements CommandHandler<DeleteLoginLogCommand, Void> {

    @Autowired
    private LoginLogRepository loginLogRepository;

    @Override
    public Void handle(DeleteLoginLogCommand command) {
        loginLogRepository.removeByIds(command.getIds());
        return null;
    }
}
