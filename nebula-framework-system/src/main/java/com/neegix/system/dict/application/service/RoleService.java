package com.neegix.system.dict.application.service;

import com.neegix.system.dict.interfaces.form.NewRoleForm;
import com.neegix.system.dict.interfaces.form.UpdateRoleForm;

import java.util.List;

/**
 * Created by IntelliJ IDEA (Community Edition)
 * Thank you to JetBrains for their contributions to the vast number of developers
 *
 * @Author: kushu001
 * @Date: 2024/09/30/16:15
 * @Description:
 */
public interface RoleService {
    Void createRole(NewRoleForm newRoleForm);
    Void modifyRole(UpdateRoleForm updateRoleForm);
    Void removeRole(List<Long> ids);
}
