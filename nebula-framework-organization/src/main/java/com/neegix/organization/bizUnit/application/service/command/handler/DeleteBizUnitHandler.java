package com.neegix.organization.bizUnit.application.service.command.handler;

import com.neegix.cqrs.command.handler.CommandHandler;
import com.neegix.organization.bizUnit.application.service.command.DeleteBizUnitCommand;
import com.neegix.organization.bizUnit.domain.repository.BizUnitRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by IntelliJ IDEA (Community Edition)
 * Thank you to JetBrains for their contributions to the vast number of developers
 *
 * @Author: kushu001
 * @Date: 2025/05/25/09:03
 * @Description:
 */
@Service
public class DeleteBizUnitHandler implements CommandHandler<DeleteBizUnitCommand, Void> {

    @Autowired
    private BizUnitRepository bizUnitRepository;

    @Override
    public Void handle(DeleteBizUnitCommand command) {
        bizUnitRepository.removeById(command.getParentId());
        return null;
    }
}
