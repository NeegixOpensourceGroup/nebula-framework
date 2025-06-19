package com.neegix.system.role.infrastructure.repository.impl;

import com.neegix.application.query.NebulaSQL;
import com.neegix.system.role.domain.entity.Role;
import com.neegix.system.role.domain.entity.RoleApi;
import com.neegix.system.role.domain.entity.RoleMenu;
import com.neegix.system.role.domain.repository.RoleRepository;
import com.neegix.system.role.infrastructure.repository.convert.RoleConverter;
import com.neegix.system.role.infrastructure.repository.dataobject.RoleApiDO;
import com.neegix.system.role.infrastructure.repository.dataobject.RoleDO;
import com.neegix.system.role.infrastructure.repository.dataobject.RoleMenuDO;
import com.neegix.system.role.infrastructure.repository.dataobject.RoleMenuRelDO;
import com.neegix.system.role.infrastructure.repository.mapper.RoleMapper;
import com.neegix.system.role.infrastructure.repository.mapper.customized.RoleCustomizedMapper;
import com.neegix.infrastructure.utils.SnowFlake;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * Created by IntelliJ IDEA (Community Edition)
 * Thank you to JetBrains for their contributions to the vast number of developers
 *
 * @Author: kushu001
 * @Date: 2025/05/13/15:31
 * @Description:
 */
@Repository
public class RoleRepositoryImpl implements RoleRepository {

    @Autowired
    private RoleMapper roleMapper;

    @Autowired
    private RoleCustomizedMapper roleCustomizedMapper;

    @Override
    @Transactional
    public void save(Role role) {
        RoleDO roleDO = RoleConverter.INSTANCE.covertDO(role);
        if (role.getId() == null) {
            roleDO.setId(SnowFlake.generateId());
            // 新增角色记录
            roleMapper.insert(roleDO);

            //新增角色关联接口记录
            if (!role.getApiPermissions().isEmpty()){
                roleCustomizedMapper.insertRoleApi(roleDO.getId(), getApiDOS(role.getApiPermissions()));
            }

            // 新增角色关联菜单功能
            if (!role.getPagePermissions().isEmpty()){
                roleCustomizedMapper.insertRoleMenu(roleDO.getId(), getMenuDOS(role.getId(), role.getPagePermissions()));
            }

        } else {
            roleMapper.updateByPrimaryKey(roleDO);
            // 删除角色接口关系
            roleCustomizedMapper.deleteRoleApiByPkRole(Arrays.asList(role.getId()));
            //新增角色关联接口记录
            if (!role.getApiPermissions().isEmpty()){
                roleCustomizedMapper.insertRoleApi(role.getId(), getApiDOS(role.getApiPermissions()));
            }


            // 删除角色菜单关系
            roleCustomizedMapper.deleteRoleMenuByPkRole(Arrays.asList(role.getId()));
            // 新增角色关联菜单功能
            if (!role.getPagePermissions().isEmpty()){
                roleCustomizedMapper.insertRoleMenu(role.getId(), getMenuDOS(role.getId(), role.getPagePermissions()));
            }
        }
    }


    private List<Long> getApiDOS(List<RoleApi> apis) {
        List<Long> apiDOS = apis.stream().map(RoleApi::getId).collect(Collectors.toList());
        return apiDOS;
    }

    private List<RoleMenuRelDO> getMenuDOS(Long pkRole, List<RoleMenu> menus) {
        List<RoleMenuRelDO> menuDOS = menus.stream().map(item->{
            RoleMenuRelDO menuDO = new RoleMenuRelDO();
            menuDO.setPkMenu(item.getId());
            menuDO.setPkRole(pkRole);
            menuDO.setIsHalf(item.getIsHalf());
            return menuDO;
        }).collect(Collectors.toList());
        return menuDOS;
    }

    @Override
    @Transactional
    public void removeByIds(List<Long> longs) {
        roleMapper.deleteByPrimaryKeys(longs);
        // 删除角色接口关系
        roleCustomizedMapper.deleteRoleApiByPkRole(longs);
        // 删除角色菜单关系
        roleCustomizedMapper.deleteRoleMenuByPkRole(longs);
    }

    @Override
    public Optional<Role> findById(Long aLong) {
        RoleDO roleDO = roleMapper.selectByPrimaryKey(aLong);

        List<RoleApiDO> roleApiDOS = roleCustomizedMapper.getApiPermissionsByPkRole(aLong);

        List<RoleMenuDO> roleMenuDOS = roleCustomizedMapper.getMenuPermissionsByPkRole(aLong);

        Role role = RoleConverter.INSTANCE.convertEntity(roleDO);

        List<RoleMenu> roleMenus = roleMenuDOS.stream().map(item -> {
            RoleMenu roleMenu = new RoleMenu();
            roleMenu.setId(item.getId());
            roleMenu.setName(item.getName());
            roleMenu.setIsHalf(item.getIsHalf());
            return roleMenu;
        }).collect(Collectors.toList());


        List<RoleApi> roleApis = roleApiDOS.stream().map(item->{
            RoleApi roleApi = new RoleApi();
            roleApi.setId(item.getId());
            roleApi.setName(item.getName());
            return roleApi;
        }).collect(Collectors.toList());


        role.setApiPermissions(roleApis);
        role.setPagePermissions(roleMenus);

        return Optional.ofNullable(role);
    }

    @Override
    public Optional<Role> findByCriteria(NebulaSQL nebulaSQL) {
        RoleDO roleDO = roleMapper.selectOne(nebulaSQL);
        Role role = RoleConverter.INSTANCE.convertEntity(roleDO);
        if (roleDO != null){
            List<RoleApiDO> roleApiDOS = roleCustomizedMapper.getApiPermissionsByPkRole(roleDO.getId());

            List<RoleMenuDO> roleMenuDOS = roleCustomizedMapper.getMenuPermissionsByPkRole(roleDO.getId());

            List<RoleMenu> roleMenus = roleMenuDOS.stream().map(item -> {
                RoleMenu roleMenu = new RoleMenu();
                roleMenu.setId(item.getId());
                roleMenu.setName(item.getName());
                roleMenu.setIsHalf(item.getIsHalf());
                return roleMenu;
            }).collect(Collectors.toList());


            List<RoleApi> roleApis = roleApiDOS.stream().map(item->{
                RoleApi roleApi = new RoleApi();
                roleApi.setId(item.getId());
                roleApi.setName(item.getName());
                return roleApi;
            }).collect(Collectors.toList());


            role.setApiPermissions(roleApis);
            role.setPagePermissions(roleMenus);
        }


        return Optional.ofNullable(role);
    }
}
