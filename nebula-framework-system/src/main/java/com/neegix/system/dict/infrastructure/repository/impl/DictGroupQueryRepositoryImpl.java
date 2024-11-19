package com.neegix.system.dict.infrastructure.repository.impl;

import com.neegix.application.query.NebulaSQL;
import com.neegix.base.PageVO;
import com.neegix.system.dict.application.cqrs.query.DictGroupQueryRepository;
import com.neegix.system.dict.application.cqrs.query.condition.DictGroupWhereGroup;
import com.neegix.system.dict.application.dto.DictGroupDTO;
import com.neegix.system.dict.infrastructure.repository.convert.DictGroupConverter;
import com.neegix.system.dict.infrastructure.repository.dataobject.DictGroupDO;
import com.neegix.system.dict.infrastructure.repository.mapper.DictGroupMapper;
import com.neegix.system.dict.infrastructure.repository.mapper.customized.DictGroupCustomizedMapper;
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
public class DictGroupQueryRepositoryImpl implements DictGroupQueryRepository {

    @Autowired
    private DictGroupMapper dictGroupMapper;

    @Autowired
    private DictGroupCustomizedMapper dictGroupCustomizedMapper;

    @Override
    public Optional<DictGroupDTO> findById(Long id) {
        DictGroupDO dictGroupDO = dictGroupMapper.selectByPrimaryKey(id);
        return Optional.ofNullable(DictGroupConverter.INSTANCE.covertDTO(dictGroupDO));
    }

    @Override
    public Optional<DictGroupDTO> findByCodeAndName(String code, String name) {
        NebulaSQL nebulaSQL = new NebulaSQL();
        nebulaSQL.createWhereGroups(DictGroupWhereGroup.class).andNameEqualTo(name).andCodeEqualTo(code);
        DictGroupDO dictGroupDO = dictGroupMapper.selectOne(nebulaSQL);
        return Optional.ofNullable(DictGroupConverter.INSTANCE.covertDTO(dictGroupDO));
    }

    @Override
    public Integer selectCount(List<Long> ids) {
        return dictGroupCustomizedMapper.selectCountByIds(ids);
    }

    @Override
    public PageVO<DictGroupDTO> findPage(Integer currentPage, Integer pageSize, DictGroupDTO dictGroupDTO) {
        NebulaSQL nebulaSQL = new NebulaSQL();
        nebulaSQL.createWhereGroups(DictGroupWhereGroup.class);
        nebulaSQL.setPager(currentPage, pageSize);
        List<DictGroupDO> result = dictGroupMapper.selectList(nebulaSQL);
        Long total = dictGroupMapper.selectCount(nebulaSQL);
        PageVO<DictGroupDTO> page = new PageVO<>(currentPage, pageSize);
        page.setTotal(total);
        page.setResult(DictGroupConverter.INSTANCE.covertDTOS(result));
        return page;
    }
}
