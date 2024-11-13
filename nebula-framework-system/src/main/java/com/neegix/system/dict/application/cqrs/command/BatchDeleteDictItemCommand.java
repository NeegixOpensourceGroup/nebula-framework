package com.neegix.system.dict.application.cqrs.command;

import com.neegix.application.command.ICommand;
import com.neegix.system.dict.infrastructure.repository.mapper.DictItemMapper;
import org.springframework.context.ApplicationContext;
import org.springframework.transaction.support.TransactionTemplate;

import java.util.List;

/**
 * Created by IntelliJ IDEA (Community Edition)
 * Thank you to JetBrains for their contributions to the vast number of developers
 *
 * @Author: kushu001
 * @Date: 2024/09/26/16:31
 * @Description:
 */

public class BatchDeleteDictItemCommand implements ICommand<Void> {
    private final List<Long> ids;

    public BatchDeleteDictItemCommand(List<Long> ids) {
        this.ids = ids;
    }
    @Override
    public Void execute(ApplicationContext context) {
        TransactionTemplate transactionTemplate = context.getBean(TransactionTemplate.class);
        transactionTemplate.execute(status -> {
            DictItemMapper dictItemMapper = context.getBean(DictItemMapper.class);
            dictItemMapper.deleteByPrimaryKeys(ids);
            return null;
        });
        return null;
    }
}
