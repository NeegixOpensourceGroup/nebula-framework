package com.neegix.development.menu.application.service.command.handler;

import com.neegix.cqrs.command.handler.CommandHandler;
import com.neegix.development.menu.application.assembler.MenuAssembler;
import com.neegix.development.menu.application.service.command.CreateMenuCommand;
import com.neegix.development.menu.domain.repository.MenuRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by IntelliJ IDEA (Community Edition)
 * Thank you to JetBrains for their contributions to the vast number of developers
 *
 * @Author: kushu001
 * @Date: 2025/04/30/22:13
 * @Description:
 */
@Service
public class CreateMenuHandler implements CommandHandler<CreateMenuCommand, Void> {
    @Autowired
    private MenuRepository menuRepository;
    @Override
    public Void handle(CreateMenuCommand command) {
        menuRepository.save(MenuAssembler.INSTANCE.covertEntity(command));
        return null;
    }
}
