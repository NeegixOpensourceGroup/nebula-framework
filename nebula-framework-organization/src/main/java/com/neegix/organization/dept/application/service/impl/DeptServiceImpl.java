package com.neegix.organization.dept.application.service.impl;

import com.neegix.application.command.BaseService;
import com.neegix.exception.BusinessRuntimeException;
import com.neegix.organization.dept.application.cqrs.command.BatchDeleteDeptCommand;
import com.neegix.organization.dept.application.cqrs.command.NewDeptCommand;
import com.neegix.organization.dept.application.cqrs.command.UpdateDeptCommand;
import com.neegix.organization.dept.application.cqrs.query.DeptQueryRepository;
import com.neegix.organization.dept.application.service.DeptService;
import com.neegix.organization.dept.domain.entity.DeptEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

 /**
  * This file is auto-generated by nebula-framework-generator.
  * The auto-generation plugin was developed using IntelliJ IDEA Community Edition.
  * Thanks to JetBrains for their outstanding contributions to the developer community.
  * <p>
  * The code generated by this tool is owned by the user of the tool.
  * The tool itself is copyrighted by <a href="https://www.neegix.com">https://www.neegix.com</a>.
  *
  * @author <a href="https://www.neegix.com">https://www.neegix.com</a>
  * @version 1.0.0
  * @since 2024-12-10 14:48:03
  */

@Service
public class DeptServiceImpl extends BaseService implements DeptService{
    @Autowired
    private DeptQueryRepository deptQueryRepository;

    @Override
    public Void createDept(DeptEntity deptEntity) {
        return commandInvoker.execute(new NewDeptCommand(deptEntity));
    }

    @Override
    public Void modifyDept(DeptEntity deptEntity) {
        return commandInvoker.execute(new UpdateDeptCommand(deptEntity));
    }

    @Override
    public Void removeDept(List<Long> ids) {
        Integer count = deptQueryRepository.selectCount(ids);
        if (count.equals(0)){
            throw new BusinessRuntimeException("要删除的记录不存在！");
        }
        return commandInvoker.execute(new BatchDeleteDeptCommand(ids));
    }
}