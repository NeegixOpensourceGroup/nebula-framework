package com.neegix.organization.bizUnit.application.service.command;

import com.neegix.cqrs.command.Command;
import lombok.Data;

/**
 * Created by IntelliJ IDEA (Community Edition)
 * Thank you to JetBrains for their contributions to the vast number of developers
 *
 * @Author: kushu001
 * @Date: 2025/05/24/10:58
 * @Description:
 */
@Data
public class DeleteBizUnitCommand implements Command<Void> {
    private Long parentId;

    public DeleteBizUnitCommand(Long parentId) {
        this.parentId = parentId;
    }
}
