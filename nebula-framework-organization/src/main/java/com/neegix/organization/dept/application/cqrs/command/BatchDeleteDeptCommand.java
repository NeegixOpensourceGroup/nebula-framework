package com.neegix.organization.dept.application.cqrs.command;

import com.neegix.application.command.ICommand;
import com.neegix.organization.dept.infrastructure.repository.mapper.DeptMapper;
import org.springframework.context.ApplicationContext;
import org.springframework.transaction.support.TransactionTemplate;

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

public class BatchDeleteDeptCommand implements ICommand<Void> {
    private final List<Long> ids;

    public BatchDeleteDeptCommand(List<Long> ids) {
        this.ids = ids;
    }
    @Override
    public Void execute(ApplicationContext context) {
        // 开启事务
        TransactionTemplate transactionTemplate = context.getBean(TransactionTemplate.class);
        transactionTemplate.execute(status -> {
            DeptMapper deptMapper = context.getBean(DeptMapper.class);
            deptMapper.deleteByPrimaryKeys(ids);
            return null;
        });
        return null;
    }
}