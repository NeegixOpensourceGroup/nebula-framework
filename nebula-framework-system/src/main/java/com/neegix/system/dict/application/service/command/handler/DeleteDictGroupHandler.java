package com.neegix.system.dict.application.service.command.handler;

import com.neegix.cqrs.command.handler.CommandHandler;
import com.neegix.system.dict.application.service.command.DeleteDictGroupCommand;
import com.neegix.system.dict.domain.repository.DictGroupRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by IntelliJ IDEA (Community Edition)
 * Thank you to JetBrains for their contributions to the vast number of developers
 *
 * @Author: kushu001
 * @Date: 2025/05/21/15:56
 * @Description:
 */
@Service
public class DeleteDictGroupHandler implements CommandHandler<DeleteDictGroupCommand, Void> {

    @Autowired
    private DictGroupRepository dictGroupRepository;

    @Override
    public Void handle(DeleteDictGroupCommand command) {
        dictGroupRepository.removeByIds(command.getIds());
        return null;
    }
}
