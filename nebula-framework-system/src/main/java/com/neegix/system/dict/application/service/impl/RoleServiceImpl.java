package com.neegix.system.dict.application.service.impl;

import com.neegix.application.command.BaseService;
import com.neegix.exception.BusinessRuntimeException;
import com.neegix.system.dict.application.assembler.RoleAssembler;
import com.neegix.system.dict.application.cqrs.command.BatchDeleteDictItemCommand;
import com.neegix.system.dict.application.cqrs.command.NewRoleCommand;
import com.neegix.system.dict.application.cqrs.command.UpdateRoleCommand;
import com.neegix.system.dict.application.cqrs.query.RoleQueryRepository;
import com.neegix.system.dict.application.dto.RoleDTO;
import com.neegix.system.dict.application.service.RoleService;
import com.neegix.system.dict.domain.entity.RoleEntity;
import com.neegix.system.dict.interfaces.form.NewRoleForm;
import com.neegix.system.dict.interfaces.form.UpdateRoleForm;
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
public class RoleServiceImpl extends BaseService implements RoleService {
    @Autowired
    private RoleQueryRepository roleQueryRepository;

    @Override
    public Void createRole(NewRoleForm newRoleForm) {
        Optional<RoleDTO> optional = roleQueryRepository.findByName(newRoleForm.getName());
        optional.ifPresent((dictItemDTO)-> {throw new BusinessRuntimeException("字典项已经存在！");});
        RoleEntity roleEntity = RoleAssembler.INSTANCE.covertEntity(newRoleForm);
        return commandInvoker.execute(new NewRoleCommand(roleEntity));
    }

    @Override
    public Void modifyRole(UpdateRoleForm updateRoleForm) {
        RoleEntity roleEntity = RoleAssembler.INSTANCE.covertEntity(updateRoleForm);
        return commandInvoker.execute(new UpdateRoleCommand(roleEntity));
    }

    @Override
    public Void removeRole(List<Long> ids) {
        Integer count = roleQueryRepository.selectCount(ids);
        if (count.equals(0)){
            throw new BusinessRuntimeException("要删除的记录不存在！");
        }
        return commandInvoker.execute(new BatchDeleteDictItemCommand(ids));
    }
}
