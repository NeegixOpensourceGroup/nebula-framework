package com.neegix.organization.psn.infrastructure.repository.impl;

import com.neegix.organization.psn.domain.entity.PsnEntity;
import com.neegix.organization.psn.domain.repository.PsnRepository;
import com.neegix.organization.psn.infrastructure.repository.convert.PsnConverter;
import com.neegix.organization.psn.infrastructure.repository.convert.PsnWorkInfoConverter;
import com.neegix.organization.psn.infrastructure.repository.dataobject.PsnDO;
import com.neegix.organization.psn.infrastructure.repository.dataobject.PsnWorkInfoDO;
import com.neegix.organization.psn.infrastructure.repository.mapper.PsnMapper;
import com.neegix.organization.psn.infrastructure.repository.mapper.customized.PsnWorkInfoCustomizedMapper;
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
 * @Date: 2025/05/27/16:29
 * @Description:
 */
@Repository
public class PsnRepositoryImpl implements PsnRepository {

    @Autowired
    private PsnMapper psnMapper;

    @Autowired
    private PsnWorkInfoCustomizedMapper psnWorkInfoCustomizedMapper;

    @Override
    @Transactional
    public void save(PsnEntity psnEntity) {
        PsnDO psnDO = PsnConverter.INSTANCE.covertDO(psnEntity);

        if (psnDO.getId() == null) {
            psnDO.setId(SnowFlake.generateId());
            psnMapper.insert(psnDO);
        } else {
            psnMapper.updateByPrimaryKey(psnDO);
            psnWorkInfoCustomizedMapper.batchDeleteByPkPsn(Arrays.asList(psnDO.getId()));
        }
        List<PsnWorkInfoDO> psnWorkInfoDOS = PsnWorkInfoConverter.INSTANCE.covertDO(psnEntity.getPsnWorkInfos());
        if (!psnWorkInfoDOS.isEmpty()){
            psnWorkInfoCustomizedMapper.batchInsertPsnWorkInfo(psnWorkInfoDOS.stream().peek(item->item.setPkPsn(psnDO.getId())).collect(Collectors.toList()));
        }
    }

    @Override
    @Transactional
    public void removeByIds(List<Long> longs) {
        psnMapper.deleteByPrimaryKeys(longs);
        psnWorkInfoCustomizedMapper.batchDeleteByPkPsn(longs);
    }

    @Override
    public Optional<PsnEntity> findById(Long aLong) {
        PsnDO psnDO = psnMapper.selectByPrimaryKey(aLong);
        List<PsnWorkInfoDO> psnWorkInfoDOS = psnWorkInfoCustomizedMapper.selectPsnWorkInfos(aLong);
        PsnEntity psnEntity = PsnConverter.INSTANCE.covertEntity(psnDO);
        psnEntity.setPsnWorkInfos(PsnWorkInfoConverter.INSTANCE.covertValues(psnWorkInfoDOS));
        return Optional.ofNullable(psnEntity);
    }
}
