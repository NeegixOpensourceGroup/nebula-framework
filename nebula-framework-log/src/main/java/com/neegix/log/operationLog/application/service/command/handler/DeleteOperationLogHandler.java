package com.neegix.log.operationLog.application.service.command.handler;

import com.neegix.cqrs.command.handler.CommandHandler;
import com.neegix.log.operationLog.application.service.command.DeleteOperationLogCommand;
import com.neegix.log.operationLog.domain.repository.OperationLogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by IntelliJ IDEA (Community Edition)
 * Thank you to JetBrains for their contributions to the vast number of developers
 *
 * @Author: kushu001
 * @Date: 2025/05/07/17:14
 * @Description:
 */
@Service
public class DeleteOperationLogHandler implements CommandHandler<DeleteOperationLogCommand, Void> {
    @Autowired
    private OperationLogRepository operationLogRepository;

    @Override
    public Void handle(DeleteOperationLogCommand command) {
        operationLogRepository.removeByIds(command.getIds());
        return null;
    }
}
