package com.neegix.development.api.application.service.command.handler;

import com.neegix.cqrs.command.handler.CommandHandler;
import com.neegix.development.api.application.service.command.DeleteApiCommand;
import com.neegix.development.api.domain.reponsitory.ApiRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by IntelliJ IDEA (Community Edition)
 * Thank you to JetBrains for their contributions to the vast number of developers
 *
 * @Author: kushu001
 * @Date: 2025/04/23/17:45
 * @Description:
 */
@Service
public class DeleteApiHandler implements CommandHandler<DeleteApiCommand, Void> {

    @Autowired
    private ApiRepository apiRepository;

    @Override
    public Void handle(DeleteApiCommand command) {

        apiRepository.removeByIds(command.getIds());

        return null;
    }
}
