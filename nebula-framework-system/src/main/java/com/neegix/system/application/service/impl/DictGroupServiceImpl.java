package com.neegix.system.application.service.impl;

import com.neegix.application.command.BaseService;
import com.neegix.exception.BusinessRuntimeException;
import com.neegix.system.application.cqrs.command.BatchDeleteDictGroupCommand;
import com.neegix.system.application.cqrs.command.NewDictGroupCommand;
import com.neegix.system.application.cqrs.command.UpdateDictGroupCommand;
import com.neegix.system.application.cqrs.query.DictGroupQueryRepository;
import com.neegix.system.application.dto.DictGroupDTO;
import com.neegix.system.application.service.DictGroupService;
import com.neegix.system.domain.entity.DictGroupEntity;
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
public class DictGroupServiceImpl extends BaseService implements DictGroupService{
    @Autowired
    private DictGroupQueryRepository dictGroupQueryRepository;

    @Override
    public Void createDictGroup(String code, String name) {
        Optional<DictGroupDTO> optional = dictGroupQueryRepository.findByCodeAndName(code, name);
        optional.ifPresent((dictGroupDTO)-> {throw new BusinessRuntimeException("字典组已经存在！");});
        return commandInvoker.execute(new NewDictGroupCommand(new DictGroupEntity(code, name)));
    }

    @Override
    public Void modifyDictGroup(Long id, String code, String name) {
        return commandInvoker.execute(new UpdateDictGroupCommand(new DictGroupEntity(id, code, name)));
    }

    @Override
    public Void removeDictGroup(List<Long> ids) {
        Integer count = dictGroupQueryRepository.selectCount(ids);
        if (count.equals(0)){
            throw new BusinessRuntimeException("要删除的记录不存在！");
        }
        return commandInvoker.execute(new BatchDeleteDictGroupCommand(ids));
    }
}
