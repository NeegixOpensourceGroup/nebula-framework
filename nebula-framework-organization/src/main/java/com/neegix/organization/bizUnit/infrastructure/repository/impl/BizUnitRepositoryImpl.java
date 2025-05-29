package com.neegix.organization.bizUnit.infrastructure.repository.impl;

import com.neegix.organization.bizUnit.domain.entity.BizUnitEntity;
import com.neegix.organization.bizUnit.domain.repository.BizUnitRepository;
import com.neegix.organization.bizUnit.infrastructure.repository.convert.BizUnitConverter;
import com.neegix.organization.bizUnit.infrastructure.repository.dataobject.BizUnitDO;
import com.neegix.organization.bizUnit.infrastructure.repository.mapper.BizUnitMapper;
import com.neegix.organization.bizUnit.infrastructure.repository.mapper.customized.BizUnitCustomizedMapper;
import com.neegix.utils.SnowFlake;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

/**
 * Created by IntelliJ IDEA (Community Edition)
 * Thank you to JetBrains for their contributions to the vast number of developers
 *
 * @Author: kushu001
 * @Date: 2025/05/24/10:32
 * @Description:
 */
@Repository
public class BizUnitRepositoryImpl implements BizUnitRepository {

    @Autowired
    private BizUnitMapper bizUnitMapper;

    @Autowired
    private BizUnitCustomizedMapper bizUnitCustomizedMapper;


    @Override
    public void save(BizUnitEntity bizUnitEntity) {
        BizUnitDO bizUnitDO = BizUnitConverter.INSTANCE.covertDO(bizUnitEntity);

        if (bizUnitDO.getId() == null) {
            bizUnitDO.setId(SnowFlake.generateId());
            bizUnitMapper.insert(bizUnitDO);
        } else {
            bizUnitMapper.updateByPrimaryKey(bizUnitDO);
        }
    }

    @Override
    public void removeByIds(List<Long> longs) {
        // 树结构， 需要考虑删除子节点
        for (Long id: longs) {
            bizUnitCustomizedMapper.deleteById(id);
        }
    }

    @Override
    public void removeById(Long aLong) {
        bizUnitCustomizedMapper.deleteById(aLong);
    }

    @Override
    public Optional<BizUnitEntity> findById(Long aLong) {
        BizUnitDO bizUnitDO = bizUnitMapper.selectByPrimaryKey(aLong);
        return Optional.ofNullable(BizUnitConverter.INSTANCE.covertDO(bizUnitDO));
    }
}
