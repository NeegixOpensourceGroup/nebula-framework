package com.neegix.system.dict.infrastructure.repository.impl;

import com.neegix.system.dict.domain.entity.DictItemEntity;
import com.neegix.system.dict.domain.repository.DictItemRepository;
import com.neegix.system.dict.infrastructure.repository.convert.DictItemConverter;
import com.neegix.system.dict.infrastructure.repository.dataobject.DictItemDO;
import com.neegix.system.dict.infrastructure.repository.mapper.DictItemMapper;
import com.neegix.utils.SnowFlake;
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
public class DictItemRepositoryImpl implements DictItemRepository {
    @Autowired
    private DictItemMapper dictItemMapper;

    @Override
    public void save(DictItemEntity dictItemEntity) {
        DictItemDO dictItemDO = DictItemConverter.INSTANCE.covertDO(dictItemEntity);

        if (dictItemDO.getId() == null) {
            dictItemDO.setId(SnowFlake.generateId());
            dictItemMapper.insert(dictItemDO);
        } else {
            dictItemMapper.updateByPrimaryKey(dictItemDO);
        }

    }

    @Override
    @Transactional
    public void removeByIds(List<Long> longs) {
        // 删除字典明细项
        dictItemMapper.deleteByPrimaryKeys(longs);


    }

    @Override
    public Optional<DictItemEntity> findById(Long aLong) {
        DictItemDO dictItemDO = dictItemMapper.selectByPrimaryKey(aLong);
        return Optional.ofNullable(DictItemConverter.INSTANCE.covertEntity(dictItemDO));
    }
}
