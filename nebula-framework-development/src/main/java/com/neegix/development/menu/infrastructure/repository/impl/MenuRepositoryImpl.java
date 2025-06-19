package com.neegix.development.menu.infrastructure.repository.impl;

import com.neegix.development.menu.domain.entity.MenuEntity;
import com.neegix.development.menu.domain.repository.MenuRepository;
import com.neegix.development.menu.infrastructure.repository.convert.MenuConverter;
import com.neegix.development.menu.infrastructure.repository.dataobject.MenuDO;
import com.neegix.development.menu.infrastructure.repository.mapper.MenuMapper;
import com.neegix.infrastructure.utils.SnowFlake;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

/**
 * Created by IntelliJ IDEA (Community Edition)
 * Thank you to JetBrains for their contributions to the vast number of developers
 *
 * @Author: kushu001
 * @Date: 2025/04/29/15:15
 * @Description:
 */
@Repository
public class MenuRepositoryImpl implements MenuRepository {

    @Autowired
    private MenuMapper menuMapper;

    @Override
    public void save(MenuEntity menuEntity) {
        MenuDO menuDO = MenuConverter.INSTANCE.covertDO(menuEntity);
        if (menuEntity.getId()==null){
            menuDO.setId(SnowFlake.generateId());
            menuMapper.insert(menuDO);
        } else {
            menuMapper.updateByPrimaryKey(menuDO);
        }
    }

    @Override
    public void removeByIds(List<Long> longs) {
        menuMapper.deleteByPrimaryKeys(longs);
    }

    @Override
    public Optional<MenuEntity> findById(Long aLong) {
        MenuDO menuDO = menuMapper.selectByPrimaryKey(aLong);
        return Optional.ofNullable(MenuConverter.INSTANCE.covertEntity(menuDO));
    }


}
