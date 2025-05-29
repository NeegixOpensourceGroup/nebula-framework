package com.neegix.system.dict.application.service.command.handler;

import com.neegix.cqrs.command.handler.CommandHandler;
import com.neegix.system.dict.application.service.command.DeleteDictItemCommand;
import com.neegix.system.dict.domain.repository.DictItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by IntelliJ IDEA (Community Edition)
 * Thank you to JetBrains for their contributions to the vast number of developers
 *
 * @Author: kushu001
 * @Date: 2025/05/22/15:46
 * @Description:
 */
@Service
public class DeleteDictItemHandler implements CommandHandler<DeleteDictItemCommand, Void> {

    @Autowired
    private DictItemRepository dictItemRepository;

    @Override
    public Void handle(DeleteDictItemCommand command) {
        dictItemRepository.removeByIds(command.getIds());
        return null;
    }
}
