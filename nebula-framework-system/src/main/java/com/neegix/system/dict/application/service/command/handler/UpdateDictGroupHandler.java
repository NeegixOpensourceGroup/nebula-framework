package com.neegix.system.dict.application.service.command.handler;

import com.neegix.cqrs.command.handler.CommandHandler;
import com.neegix.system.dict.application.service.command.UpdateDictGroupCommand;
import com.neegix.system.dict.domain.entity.DictGroupEntity;
import com.neegix.system.dict.domain.repository.DictGroupRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by IntelliJ IDEA (Community Edition)
 * Thank you to JetBrains for their contributions to the vast number of developers
 *
 * @Author: kushu001
 * @Date: 2025/05/20/17:21
 * @Description:
 */
@Service
public class UpdateDictGroupHandler implements CommandHandler<UpdateDictGroupCommand, Void> {

    @Autowired
    private DictGroupRepository dictGroupRepository;

    @Override
    public Void handle(UpdateDictGroupCommand command) {
        DictGroupEntity dictGroupEntity = new DictGroupEntity(command.getId(), command.getCode(), command.getName());
        dictGroupRepository.save(dictGroupEntity);
        return null;
    }
}
