package com.neegix.organization.bizUnit.application.service.command.handler;

import com.neegix.cqrs.command.handler.CommandHandler;
import com.neegix.organization.bizUnit.application.assembler.BizUnitAssembler;
import com.neegix.organization.bizUnit.application.service.command.UpdateBizUnitCommand;
import com.neegix.organization.bizUnit.domain.repository.BizUnitRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by IntelliJ IDEA (Community Edition)
 * Thank you to JetBrains for their contributions to the vast number of developers
 *
 * @Author: kushu001
 * @Date: 2025/05/24/10:56
 * @Description:
 */
@Service
public class UpdateBizUnitHandler implements CommandHandler<UpdateBizUnitCommand, Void> {

    @Autowired
    private BizUnitRepository bizUnitRepository;

    @Override
    public Void handle(UpdateBizUnitCommand command) {
        bizUnitRepository.save(BizUnitAssembler.INSTANCE.covertEntity(command));
        return null;
    }
}
