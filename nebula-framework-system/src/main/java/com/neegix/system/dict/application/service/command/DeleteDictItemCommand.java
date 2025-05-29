package com.neegix.system.dict.application.service.command;

import com.neegix.cqrs.command.Command;
import lombok.Data;

import java.util.List;

/**
 * Created by IntelliJ IDEA (Community Edition)
 * Thank you to JetBrains for their contributions to the vast number of developers
 *
 * @Author: kushu001
 * @Date: 2025/05/22/15:44
 * @Description:
 */
@Data
public class DeleteDictItemCommand implements Command<Void> {

    private List<Long> ids;

    public DeleteDictItemCommand(List<Long> ids) {
        this.ids = ids;
    }
}
