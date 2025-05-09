package com.neegix.system.dict.application.cqrs.command;

import com.neegix.application.command.ICommand;
import com.neegix.system.dict.domain.entity.DictGroupEntity;
import com.neegix.system.dict.infrastructure.repository.convert.DictGroupConverter;
import com.neegix.system.dict.infrastructure.repository.mapper.DictGroupMapper;
import org.springframework.context.ApplicationContext;

/**
 * Created by IntelliJ IDEA (Community Edition)
 * Thank you to JetBrains for their contributions to the vast number of developers
 *
 * @Author: kushu001
 * @Date: 2024/09/26/16:31
 * @Description:
 */

public class NewDictGroupCommand implements ICommand<Void> {
    private final DictGroupEntity dictGroupEntity;

    public NewDictGroupCommand(DictGroupEntity dictGroupEntity) {
        this.dictGroupEntity = dictGroupEntity;
    }

    @Override
    public Void execute(ApplicationContext context) {
        DictGroupMapper dictGroupMapper = context.getBean(DictGroupMapper.class);
        dictGroupMapper.insert(DictGroupConverter.INSTANCE.covertDO(dictGroupEntity));
        return null;
    }
}
