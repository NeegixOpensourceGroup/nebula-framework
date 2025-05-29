package com.neegix.log.exceptionLog.application.service.command.handler;

import com.neegix.cqrs.command.handler.CommandHandler;
import com.neegix.log.exceptionLog.application.service.command.DeleteExceptionLogCommand;
import com.neegix.log.exceptionLog.domain.repository.ExceptionLogRepository;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by IntelliJ IDEA (Community Edition)
 * Thank you to JetBrains for their contributions to the vast number of developers
 *
 * @Author: kushu001
 * @Date: 2025/05/06/16:00
 * @Description:
 */
public class DeleteExceptionLogHandler implements CommandHandler<DeleteExceptionLogCommand, Void> {

    @Autowired
    private ExceptionLogRepository exceptionLogRepository;
    @Override
    public Void handle(DeleteExceptionLogCommand command) {
        exceptionLogRepository.removeByIds(command.getIds());
        return null;
    }
}
