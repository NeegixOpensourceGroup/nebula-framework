package com.neegix.development.menu.application.service.command;

import com.neegix.cqrs.command.Command;
import lombok.Data;

import java.util.List;

/**
 * Created by IntelliJ IDEA (Community Edition)
 * Thank you to JetBrains for their contributions to the vast number of developers
 *
 * @Author: kushu001
 * @Date: 2025/04/30/23:14
 * @Description:
 */
@Data
public class DeleteMenuCommand implements Command<Void> {
    private List<Long> ids;

    public DeleteMenuCommand(List<Long> ids) {
        this.ids = ids;
    }


}
