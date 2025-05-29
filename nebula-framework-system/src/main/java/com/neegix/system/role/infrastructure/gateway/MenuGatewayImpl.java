package com.neegix.system.role.infrastructure.gateway;

import com.neegix.cqrs.query.UniversalQueryBus;
import com.neegix.development.menu.application.service.query.GetMenuDetailQuery;
import com.neegix.development.menu.interfaces.vo.MenuVO;
import com.neegix.system.role.domain.gateway.MenuGateway;
import com.neegix.system.role.domain.gateway.dto.MenuDTO;
import com.neegix.system.role.interfaces.form.PagePermissionForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by IntelliJ IDEA (Community Edition)
 * Thank you to JetBrains for their contributions to the vast number of developers
 *
 * @Author: kushu001
 * @Date: 2025/05/19/14:57
 * @Description:
 */
@Component
public class MenuGatewayImpl implements MenuGateway {
    @Autowired
    private UniversalQueryBus queryBus;
    @Override
    public List<MenuDTO> getMenus(List<PagePermissionForm> pagePermissionForms) {
        List<MenuDTO> menuDTOS = new ArrayList<>();
        for (PagePermissionForm permissionForm: pagePermissionForms) {
            GetMenuDetailQuery menuDetailQuery = new GetMenuDetailQuery(permissionForm.getPkMenu());
            MenuVO menuVO = queryBus.execute(menuDetailQuery);
            MenuDTO menuDTO = new MenuDTO();
            menuDTO.setId(menuVO.getId());
            menuDTO.setName(menuVO.getName());
            menuDTO.setAccess(menuVO.getAccess());
            menuDTO.setIsHalf(permissionForm.getIsHalf());
            menuDTOS.add(menuDTO);
        }

        return menuDTOS;
    }
}
