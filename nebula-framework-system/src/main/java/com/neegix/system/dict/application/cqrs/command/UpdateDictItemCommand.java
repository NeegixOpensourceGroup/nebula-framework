package com.neegix.system.dict.application.cqrs.command;

import com.neegix.application.command.ICommand;
import com.neegix.system.dict.domain.entity.DictItemEntity;
import com.neegix.system.dict.infrastructure.repository.dataobject.DictItemDO;
import com.neegix.system.dict.infrastructure.repository.mapper.DictItemMapper;
import org.springframework.context.ApplicationContext;

/**
 * Created by IntelliJ IDEA (Community Edition)
 * Thank you to JetBrains for their contributions to the vast number of developers
 *
 * @Author: kushu001
 * @Date: 2024/09/26/16:31
 * @Description:
 */

public class UpdateDictItemCommand implements ICommand<Void> {
    private final DictItemEntity dictItemEntity;

    public UpdateDictItemCommand(DictItemEntity dictItemEntity) {
        this.dictItemEntity = dictItemEntity;
    }

    @Override
    public Void execute(ApplicationContext context) {
        DictItemMapper dictItemMapper = context.getBean(DictItemMapper.class);
        DictItemDO newDictItemDO = new DictItemDO();
        newDictItemDO.setId(dictItemEntity.getId());
        newDictItemDO.setName(dictItemEntity.getName());
        newDictItemDO.setValue(dictItemEntity.getValue());
        newDictItemDO.setSort(dictItemEntity.getSort());
        dictItemMapper.updateByPrimaryKey(newDictItemDO);
        return null;
    }
}
