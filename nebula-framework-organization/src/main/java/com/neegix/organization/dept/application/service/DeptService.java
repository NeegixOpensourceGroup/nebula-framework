package com.neegix.organization.dept.application.service;
import com.neegix.organization.dept.domain.entity.DeptEntity;
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

public interface DeptService {
    Void createDept(DeptEntity deptEntity);
    Void modifyDept(DeptEntity deptEntity);
    Void removeDept(List<Long> ids);
}