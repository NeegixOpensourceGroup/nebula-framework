package com.neegix.organization.psn.application.service.command.handler;

import com.neegix.cqrs.command.handler.CommandHandler;
import com.neegix.organization.psn.application.assembler.PsnAssembler;
import com.neegix.organization.psn.application.service.command.UpdatePsnCommand;
import com.neegix.organization.psn.domain.entity.PsnEntity;
import com.neegix.organization.psn.domain.repository.PsnRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by IntelliJ IDEA (Community Edition)
 * Thank you to JetBrains for their contributions to the vast number of developers
 *
 * @Author: kushu001
 * @Date: 2025/05/27/17:23
 * @Description:
 */
@Service
public class UpdatePsnHandler implements CommandHandler<UpdatePsnCommand, Void> {

    @Autowired
    private PsnRepository psnRepository;

    @Override
    public Void handle(UpdatePsnCommand command) {
        PsnEntity psnEntity = PsnAssembler.INSTANCE.covertEntity(command);
        psnRepository.save(psnEntity);
        return null;
    }
}
