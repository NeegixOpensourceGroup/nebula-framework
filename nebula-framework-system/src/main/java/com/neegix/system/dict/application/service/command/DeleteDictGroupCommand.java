package com.neegix.system.dict.application.service.command;

import com.neegix.cqrs.command.Command;
import lombok.Data;

import java.util.List;

/**
 * Created by IntelliJ IDEA (Community Edition)
 * Thank you to JetBrains for their contributions to the vast number of developers
 *
 * @Author: kushu001
 * @Date: 2025/05/21/15:55
 * @Description:
 */
@Data
public class DeleteDictGroupCommand implements Command<Void> {

    private List<Long> ids;

    public DeleteDictGroupCommand(List<Long> ids) {

        this.ids = ids;

    }
}
