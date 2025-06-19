package com.neegix.system.dict.infrastructure.repository.impl;

import com.neegix.application.query.NebulaSQL;
import com.neegix.system.dict.infrastructure.repository.condition.DictItemWhereGroup;
import com.neegix.system.dict.domain.entity.DictGroupEntity;
import com.neegix.system.dict.domain.repository.DictGroupRepository;
import com.neegix.system.dict.infrastructure.repository.convert.DictGroupConverter;
import com.neegix.system.dict.infrastructure.repository.dataobject.DictGroupDO;
import com.neegix.system.dict.infrastructure.repository.mapper.DictGroupMapper;
import com.neegix.system.dict.infrastructure.repository.mapper.DictItemMapper;
import com.neegix.infrastructure.utils.SnowFlake;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

/**
 * Created by IntelliJ IDEA (Community Edition)
 * Thank you to JetBrains for their contributions to the vast number of developers
 *
 * @Author: kushu001
 * @Date: 2025/05/20/15:54
 * @Description:
 */
@Repository
public class DictGroupRepositoryImpl implements DictGroupRepository {
    @Autowired
    private DictGroupMapper dictGroupMapper;

    @Autowired
    private DictItemMapper dictItemMapper;

    @Override
    public void save(DictGroupEntity dictGroupEntity) {
        DictGroupDO dictGroupDO = DictGroupConverter.INSTANCE.covertDO(dictGroupEntity);

        if (dictGroupDO.getId() == null) {
            dictGroupDO.setId(SnowFlake.generateId());
            dictGroupMapper.insert(dictGroupDO);
        } else {
            dictGroupMapper.updateByPrimaryKey(dictGroupDO);
        }

    }

    @Override
    @Transactional
    public void removeByIds(List<Long> longs) {
        // 删除字典明细项
        NebulaSQL nebulaSQL = new NebulaSQL();
        nebulaSQL.createWhereGroups(DictItemWhereGroup.class).andPkDictGroupIn(longs);
        dictItemMapper.delete(nebulaSQL);

        // 删除字典组项
        dictGroupMapper.deleteByPrimaryKeys(longs);

    }

    @Override
    public Optional<DictGroupEntity> findById(Long aLong) {
        DictGroupDO dictGroupDO = dictGroupMapper.selectByPrimaryKey(aLong);
        return Optional.ofNullable(DictGroupConverter.INSTANCE.covertEntity(dictGroupDO));
    }

    @Override
    public Optional<DictGroupEntity> findByCriteria(NebulaSQL nebulaSQL) {
        DictGroupDO dictGroupDO = dictGroupMapper.selectOne(nebulaSQL);
        return Optional.ofNullable(DictGroupConverter.INSTANCE.covertEntity(dictGroupDO));
    }
}
