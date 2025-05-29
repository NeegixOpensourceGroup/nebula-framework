package com.neegix.log.loginLog.application.service.command;

import com.neegix.cqrs.command.Command;
import lombok.Data;

import java.util.List;

/**
 * Created by IntelliJ IDEA (Community Edition)
 * Thank you to JetBrains for their contributions to the vast number of developers
 *
 * @Author: kushu001
 * @Date: 2025/05/08/11:39
 * @Description:
 */
@Data
public class DeleteLoginLogCommand implements Command<Void> {
    private List<Long> ids;

    public DeleteLoginLogCommand(List<Long> ids) {
        this.ids = ids;
    }
}
