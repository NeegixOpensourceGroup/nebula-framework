package com.neegix.system.dict.application.service.command.handler;

import com.neegix.cqrs.command.handler.CommandHandler;
import com.neegix.system.dict.application.assembler.DictItemAssembler;
import com.neegix.system.dict.application.service.command.CreateDictItemCommand;
import com.neegix.system.dict.domain.entity.DictItemEntity;
import com.neegix.system.dict.domain.repository.DictItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by IntelliJ IDEA (Community Edition)
 * Thank you to JetBrains for their contributions to the vast number of developers
 *
 * @Author: kushu001
 * @Date: 2025/05/22/15:15
 * @Description:
 */
@Service
public class CreateDictItemHandler implements CommandHandler<CreateDictItemCommand, Void> {

    @Autowired
    private DictItemRepository dictItemRepository;

    @Override
    public Void handle(CreateDictItemCommand command) {
        DictItemEntity dictItemEntity = DictItemAssembler.INSTANCE.covertEntity(command);
        dictItemRepository.save(dictItemEntity);
        return null;
    }
}
