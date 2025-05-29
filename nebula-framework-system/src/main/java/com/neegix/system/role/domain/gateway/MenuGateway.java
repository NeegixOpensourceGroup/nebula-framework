package com.neegix.system.role.domain.gateway;

import com.neegix.system.role.domain.gateway.dto.MenuDTO;
import com.neegix.system.role.interfaces.form.PagePermissionForm;

import java.util.List;

/**
 * Created by IntelliJ IDEA (Community Edition)
 * Thank you to JetBrains for their contributions to the vast number of developers
 *
 * @Author: kushu001
 * @Date: 2025/05/19/14:55
 * @Description:
 */
public interface MenuGateway {
    List<MenuDTO> getMenus(List<PagePermissionForm> pagePermissionForms);
}
