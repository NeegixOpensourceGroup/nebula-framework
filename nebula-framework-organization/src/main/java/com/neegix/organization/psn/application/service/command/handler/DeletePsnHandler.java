package com.neegix.organization.psn.application.service.command.handler;

import com.neegix.cqrs.command.handler.CommandHandler;
import com.neegix.organization.psn.application.service.command.DeletePsnCommand;
import com.neegix.organization.psn.domain.repository.PsnRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by IntelliJ IDEA (Community Edition)
 * Thank you to JetBrains for their contributions to the vast number of developers
 *
 * @Author: kushu001
 * @Date: 2025/05/27/17:38
 * @Description:
 */
@Service
public class DeletePsnHandler implements CommandHandler<DeletePsnCommand, Void> {

    @Autowired
    private PsnRepository psnRepository;

    @Override
    public Void handle(DeletePsnCommand command) {
        psnRepository.removeByIds(command.getIds());
        return null;
    }
}
