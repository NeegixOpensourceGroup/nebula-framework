package com.neegix.system.role.application.service.command.handler;

import com.neegix.cqrs.command.handler.CommandHandler;
import com.neegix.system.role.application.service.command.UpdateRoleCommand;
import com.neegix.system.role.domain.entity.Role;
import com.neegix.system.role.domain.entity.RoleApi;
import com.neegix.system.role.domain.entity.RoleMenu;
import com.neegix.system.role.domain.gateway.ApiGateway;
import com.neegix.system.role.domain.gateway.MenuGateway;
import com.neegix.system.role.domain.gateway.dto.ApiDTO;
import com.neegix.system.role.domain.gateway.dto.MenuDTO;
import com.neegix.system.role.domain.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by IntelliJ IDEA (Community Edition)
 * Thank you to JetBrains for their contributions to the vast number of developers
 *
 * @Author: kushu001
 * @Date: 2025/05/19/16:38
 * @Description:
 */
@Service
public class UpdateRoleHandler implements CommandHandler<UpdateRoleCommand, Void> {

    @Autowired
    private ApiGateway apiGateway;

    @Autowired
    private MenuGateway menuGateway;

    @Autowired
    private RoleRepository roleRepository;
    @Override
    public Void handle(UpdateRoleCommand command) {
        List<ApiDTO> apiDTOS =  apiGateway.getApis(command.getApiPermissions());

        List<RoleApi> roleApis = apiDTOS.stream().map(item-> {
            RoleApi roleApi = new RoleApi();
            roleApi.setId(item.getId());
            roleApi.setName(item.getName());
            return roleApi;
        }).toList();

        List<MenuDTO> menuDTOS = menuGateway.getMenus(command.getPagePermissions());

        List<RoleMenu> roleMenus = menuDTOS.stream().map(item -> {
            RoleMenu roleMenu = new RoleMenu();
            roleMenu.setId(item.getId());
            roleMenu.setName(item.getName());
            roleMenu.setIsHalf(item.getIsHalf());
            return roleMenu;
        }).toList();


        Role role = new Role();
        role.setName(command.getName());
        role.setDescription(command.getDescription());
        role.setEnabled(command.getEnabled());
        role.setPagePermissions(roleMenus);
        role.setApiPermissions(roleApis);

        roleRepository.save(role);
        return null;
    }
}
