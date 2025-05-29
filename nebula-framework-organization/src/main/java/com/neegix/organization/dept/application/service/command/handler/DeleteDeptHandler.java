package com.neegix.organization.dept.application.service.command.handler;

import com.neegix.cqrs.command.handler.CommandHandler;
import com.neegix.organization.dept.application.service.command.DeleteDeptCommand;
import com.neegix.organization.dept.domain.repository.DeptRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by IntelliJ IDEA (Community Edition)
 * Thank you to JetBrains for their contributions to the vast number of developers
 *
 * @Author: kushu001
 * @Date: 2025/05/26/20:58
 * @Description:
 */
@Service
public class DeleteDeptHandler implements CommandHandler<DeleteDeptCommand, Void> {

    @Autowired
    private DeptRepository deptRepository;

    @Override
    public Void handle(DeleteDeptCommand command) {
        deptRepository.removeById(command.getId());
        return null;
    }
}
