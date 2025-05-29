package com.neegix.organization.psn.application.service.command;

import com.neegix.cqrs.command.Command;
import lombok.Data;

import java.util.List;

/**
 * Created by IntelliJ IDEA (Community Edition)
 * Thank you to JetBrains for their contributions to the vast number of developers
 *
 * @Author: kushu001
 * @Date: 2025/05/27/17:37
 * @Description:
 */
@Data
public class DeletePsnCommand implements Command<Void> {
    private List<Long> ids;

    public DeletePsnCommand(List<Long> ids) {
        this.ids = ids;
    }
}
