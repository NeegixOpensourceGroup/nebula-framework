package com.neegix.system.dict.application.service.impl;

import com.neegix.application.command.BaseService;
import com.neegix.exception.BusinessRuntimeException;
import com.neegix.system.dict.application.assembler.DictItemAssembler;
import com.neegix.system.dict.application.cqrs.command.BatchDeleteDictItemCommand;
import com.neegix.system.dict.application.cqrs.command.NewDictItemCommand;
import com.neegix.system.dict.application.cqrs.command.UpdateDictItemCommand;
import com.neegix.system.dict.application.cqrs.query.DictItemQueryRepository;
import com.neegix.system.dict.application.dto.DictItemDTO;
import com.neegix.system.dict.application.service.DictItemService;
import com.neegix.system.dict.domain.entity.DictItemEntity;
import com.neegix.system.dict.interfaces.form.NewDictItemForm;
import com.neegix.system.dict.interfaces.form.UpdateDictItemForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * Created by IntelliJ IDEA (Community Edition)
 * Thank you to JetBrains for their contributions to the vast number of developers
 *
 * @Author: kushu001
 * @Date: 2024/09/30/16:15
 * @Description:
 */
@Service
public class DictItemServiceImpl extends BaseService implements DictItemService {
    @Autowired
    private DictItemQueryRepository dictItemQueryRepository;

    @Override
    public Void createDictItem(NewDictItemForm newDictItemForm) {
        Optional<DictItemDTO> optional = dictItemQueryRepository.findByName(newDictItemForm.getName());
        optional.ifPresent((dictItemDTO)-> {throw new BusinessRuntimeException("字典项已经存在！");});
        DictItemEntity dictItemEntity = DictItemAssembler.INSTANCE.covertEntity(newDictItemForm);
        return commandInvoker.execute(new NewDictItemCommand(dictItemEntity));
    }

    @Override
    public Void modifyDictItem(UpdateDictItemForm updateDictItemForm) {
        DictItemEntity dictItemEntity = DictItemAssembler.INSTANCE.covertEntity(updateDictItemForm);
        return commandInvoker.execute(new UpdateDictItemCommand(dictItemEntity));
    }

    @Override
    public Void removeDictItem(List<Long> ids) {
        Integer count = dictItemQueryRepository.selectCount(ids);
        if (count.equals(0)){
            throw new BusinessRuntimeException("要删除的记录不存在！");
        }
        return commandInvoker.execute(new BatchDeleteDictItemCommand(ids));
    }
}
