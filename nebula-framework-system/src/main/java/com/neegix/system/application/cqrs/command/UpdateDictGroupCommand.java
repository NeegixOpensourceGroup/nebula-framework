package com.neegix.system.application.cqrs.command;

import com.neegix.application.command.ICommand;
import com.neegix.system.domain.entity.DictGroupEntity;
import com.neegix.system.infrastructure.repository.convert.DictGroupConverter;
import com.neegix.system.infrastructure.repository.mapper.DictGroupMapper;
import org.springframework.context.ApplicationContext;

/**
 * Created by IntelliJ IDEA (Community Edition)
 * Thank you to JetBrains for their contributions to the vast number of developers
 *
 * @Author: kushu001
 * @Date: 2024/09/26/16:31
 * @Description:
 */

public class UpdateDictGroupCommand implements ICommand<Void> {
    private final DictGroupEntity dictGroupEntity;

    public UpdateDictGroupCommand(DictGroupEntity dictGroupEntity) {
        this.dictGroupEntity = dictGroupEntity;
    }

    @Override
    public Void execute(ApplicationContext context) {
        DictGroupMapper dictGroupMapper = context.getBean(DictGroupMapper.class);
        dictGroupMapper.updateByPrimaryKey(DictGroupConverter.INSTANCE.covertDO(dictGroupEntity));
        return null;
    }
}
