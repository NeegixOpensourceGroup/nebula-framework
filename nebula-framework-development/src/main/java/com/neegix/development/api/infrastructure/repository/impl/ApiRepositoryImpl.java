package com.neegix.development.api.infrastructure.repository.impl;

import com.neegix.application.query.NebulaSQL;
import com.neegix.development.api.domain.entity.Api;
import com.neegix.development.api.domain.entity.Module;
import com.neegix.development.api.domain.reponsitory.ApiRepository;
import com.neegix.development.api.infrastructure.repository.condition.ApiWhereGroup;
import com.neegix.development.api.infrastructure.repository.convert.ApiConverter;
import com.neegix.development.api.infrastructure.repository.dataobject.ApiDO;
import com.neegix.development.api.infrastructure.repository.mapper.ApiMapper;
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
 * @Date: 2025/04/24/17:15
 * @Description:
 */
@Repository
public class ApiRepositoryImpl implements ApiRepository {
    @Autowired
    private ApiMapper apiMapper;

    @Autowired
    private MenuMapper menuMapper;

    @Override
    public void save(Api apiEntity) {
        ApiDO apiDO = ApiConverter.INSTANCE.convertToDO(apiEntity);

        if (apiEntity.getId()==null){
            apiDO.setId(SnowFlake.generateId());
            apiDO.setModule(apiEntity.getModule().getId());
            apiMapper.insert(apiDO);
        } else {
            apiDO.setModule(apiEntity.getModule().getId());
            apiMapper.updateByPrimaryKey(apiDO);
        }

    }

    @Override
    public void removeByIds(List<Long> ids) {
        apiMapper.deleteByPrimaryKeys(ids);
    }

    @Override
    public Optional<Api> findById(Long aLong) {
        ApiDO apiDO = apiMapper.selectByPrimaryKey(aLong);
        Api api = ApiConverter.INSTANCE.convertToEntity(apiDO);
        if (apiDO.getModule() != null){
            MenuDO menuDO = menuMapper.selectByPrimaryKey(apiDO.getModule());
            api.assignModel(new Module(menuDO.getId(), menuDO.getName()));
        }
        return Optional.ofNullable(api);
    }


    @Override
    public boolean existsByAccess(String access) {
        NebulaSQL sql = new NebulaSQL();
        sql.createWhereGroups(ApiWhereGroup.class).andAccessEqualTo(access);
        Long count = apiMapper.selectCount(sql);
        return count > 0;
    }
}
