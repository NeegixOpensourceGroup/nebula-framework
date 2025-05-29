package com.neegix.development.api.application.service.command.handler;

import com.neegix.cqrs.command.handler.CommandHandler;
import com.neegix.development.api.application.assembler.ApiAssembler;
import com.neegix.development.api.application.service.command.CreateApiCommand;
import com.neegix.development.api.domain.entity.Api;
import com.neegix.development.api.domain.entity.Module;
import com.neegix.development.api.domain.reponsitory.ApiRepository;
import com.neegix.development.menu.domain.entity.MenuEntity;
import com.neegix.development.menu.domain.repository.MenuRepository;
import com.neegix.exception.BusinessRuntimeException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * Created by IntelliJ IDEA (Community Edition)
 * Thank you to JetBrains for their contributions to the vast number of developers
 *
 * @Author: kushu001
 * @Date: 2025/04/23/17:45
 * @Description:
 */
@Service
public class CreateApiHandler implements CommandHandler<CreateApiCommand, Void> {

    @Autowired
    private ApiRepository apiRepository;

    @Autowired
    private MenuRepository menuRepository;

    @Override
    public Void handle(CreateApiCommand command) {

        boolean isExist = apiRepository.existsByAccess(command.getAccess());

        if (isExist){

            throw new BusinessRuntimeException("接口标识["+command.getAccess()+ "]已存在！");

        }

        Api apiEntity = ApiAssembler.INSTANCE.covertToApiEntity(command);

        if (command.getModule() != null) {

            Optional<MenuEntity> optional = menuRepository.findById(command.getModule());

            MenuEntity menuEntity = optional.orElseThrow(()-> new BusinessRuntimeException("模块不存在"));

            apiEntity.assignModel(new Module(menuEntity.getId(), menuEntity.getName()));

        }

        apiRepository.save(apiEntity);

        return null;
    }
}
