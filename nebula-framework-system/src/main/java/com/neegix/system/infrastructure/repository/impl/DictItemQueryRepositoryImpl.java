package com.neegix.system.infrastructure.repository.impl;

import com.neegix.application.query.NebulaSQL;
import com.neegix.base.PageDTO;
import com.neegix.system.application.cqrs.query.DictItemQueryRepository;
import com.neegix.system.application.cqrs.query.condition.DictItemWhereGroup;
import com.neegix.system.application.dto.DictItemDTO;
import com.neegix.system.infrastructure.repository.convert.DictItemConverter;
import com.neegix.system.infrastructure.repository.dataobject.DictItemDO;
import com.neegix.system.infrastructure.repository.mapper.DictItemMapper;
import com.neegix.system.infrastructure.repository.mapper.customized.DictItemCustomizedMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

/**
 * Created by IntelliJ IDEA (Community Edition)
 * Thank you to JetBrains for their contributions to the vast number of developers
 *
 * @Author: kushu001
 * @Date: 2024/09/20/21:06
 * @Description:
 */
@Repository
public class DictItemQueryRepositoryImpl implements DictItemQueryRepository {

    @Autowired
    private DictItemMapper dictItemMapper;

    @Autowired
    private DictItemCustomizedMapper dictItemCustomizedMapper;

    @Override
    public Optional<DictItemDTO> findById(Long id) {
        DictItemDO dictItemDO = dictItemMapper.selectByPrimaryKey(id);
        return Optional.ofNullable(DictItemConverter.INSTANCE.covertDTO(dictItemDO));
    }


    @Override
    public Optional<DictItemDTO> findByName(String name) {
        NebulaSQL nebulaSQL = new NebulaSQL();
        nebulaSQL.createWhereGroups(DictItemWhereGroup.class).andNameEqualTo(name);
        DictItemDO dictItemDO = dictItemMapper.selectOne(nebulaSQL);
        return Optional.ofNullable(DictItemConverter.INSTANCE.covertDTO(dictItemDO));
    }

    @Override
    public Integer selectCount(List<Long> ids) {
        return dictItemCustomizedMapper.selectCountByIds(ids);
    }

    @Override
    public PageDTO<DictItemDTO> findPage(Integer currentPage, Integer pageSize, DictItemDTO dictItemDTO) {
        NebulaSQL nebulaSQL = new NebulaSQL();
        nebulaSQL.createWhereGroups(DictItemWhereGroup.class);
        nebulaSQL.setPager(currentPage, pageSize);
        List<DictItemDO> result = dictItemMapper.selectList(nebulaSQL);
        Long count = dictItemMapper.selectCount(nebulaSQL);
        PageDTO<DictItemDTO> page = new PageDTO<>(currentPage, pageSize);
        page.setTotal(count);
        page.setResult(DictItemConverter.INSTANCE.covertDTOS(result));
        return page;
    }
}
