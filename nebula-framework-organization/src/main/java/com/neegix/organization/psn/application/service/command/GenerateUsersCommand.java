package com.neegix.organization.psn.application.service.command;

import com.neegix.cqrs.command.Command;
import lombok.Data;

import java.util.List;

/**
 * Created by IntelliJ IDEA (Community Edition)
 * Thank you to JetBrains for their contributions to the vast number of developers
 *
 * @Author: kushu001
 * @Date: 2025/06/21/10:57
 * @Description:
 */
@Data
public class GenerateUsersCommand implements Command<Void> {
    private List<Long> psnIds;

    public GenerateUsersCommand(List<Long> psnIds){
        this.psnIds = psnIds;
    }
}
