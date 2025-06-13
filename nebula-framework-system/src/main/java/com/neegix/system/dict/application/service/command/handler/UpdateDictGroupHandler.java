package com.neegix.system.dict.application.service.command.handler;

import com.neegix.application.query.NebulaSQL;
import com.neegix.cqrs.command.handler.CommandHandler;
import com.neegix.exception.BusinessRuntimeException;
import com.neegix.system.dict.application.service.command.UpdateDictGroupCommand;
import com.neegix.system.dict.domain.entity.DictGroupEntity;
import com.neegix.system.dict.domain.repository.DictGroupRepository;
import com.neegix.system.dict.infrastructure.repository.condition.DictGroupWhereGroup;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

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

        NebulaSQL nebulaSQL = new NebulaSQL();
        nebulaSQL.createWhereGroups(DictGroupWhereGroup.class).andCodeEqualTo(command.getCode());
        Optional<DictGroupEntity> optional = dictGroupRepository.findByCriteria(nebulaSQL);

        if (optional.isPresent()){
            DictGroupEntity dictGroup = optional.get();
            if (!dictGroup.getId().equals(command.getId())){
                throw new BusinessRuntimeException("字典分组编码["+command.getCode()+"]已存在");
            }
        }


        DictGroupEntity dictGroupEntity = new DictGroupEntity(command.getId(), command.getCode(), command.getName());
        dictGroupRepository.save(dictGroupEntity);
        return null;
    }
}
