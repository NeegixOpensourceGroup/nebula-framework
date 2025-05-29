package com.neegix.system.user.application.service.command;

import com.neegix.cqrs.command.Command;
import lombok.Data;

import java.util.List;

/**
 * Created by IntelliJ IDEA (Community Edition)
 * Thank you to JetBrains for their contributions to the vast number of developers
 *
 * @Author: kushu001
 * @Date: 2025/05/12/17:19
 * @Description:
 */
@Data
public class BindRolesCommand implements Command<Void> {
    private List<Long> userIds;
    private List<Long> roleIds;

    public BindRolesCommand(List<Long> userIds, List<Long> roleIds){
        this.userIds = userIds;
        this.roleIds = roleIds;
    }
}
