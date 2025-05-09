package com.neegix.organization.dept.application.cqrs.command;

import com.neegix.application.command.ICommand;
import com.neegix.organization.dept.domain.entity.DeptEntity;
import com.neegix.organization.dept.infrastructure.repository.convert.DeptConverter;
import com.neegix.organization.dept.infrastructure.repository.mapper.DeptMapper;
import org.springframework.context.ApplicationContext;

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

public class UpdateDeptCommand implements ICommand<Void> {
    private final DeptEntity deptEntity;

    public UpdateDeptCommand(DeptEntity deptEntity) {
        this.deptEntity = deptEntity;
    }

    @Override
    public Void execute(ApplicationContext context) {
        DeptMapper deptMapper = context.getBean(DeptMapper.class);
        deptMapper.updateByPrimaryKey(DeptConverter.INSTANCE.covertDO(deptEntity));
        return null;
    }
}
