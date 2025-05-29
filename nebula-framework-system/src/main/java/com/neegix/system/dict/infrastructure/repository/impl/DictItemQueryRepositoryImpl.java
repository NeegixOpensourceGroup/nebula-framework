package com.neegix.system.dict.infrastructure.repository.impl;

import com.neegix.application.query.NebulaSQL;
import com.neegix.base.PageVO;
import com.neegix.system.dict.application.assembler.DictItemAssembler;
import com.neegix.system.dict.application.repository.DictItemQueryRepository;
import com.neegix.system.dict.infrastructure.repository.condition.DictGroupWhereGroup;
import com.neegix.system.dict.infrastructure.repository.condition.DictItemWhereGroup;
import com.neegix.system.dict.infrastructure.repository.dataobject.DictGroupDO;
import com.neegix.system.dict.infrastructure.repository.dataobject.DictItemDO;
import com.neegix.system.dict.infrastructure.repository.mapper.DictGroupMapper;
import com.neegix.system.dict.infrastructure.repository.mapper.DictItemMapper;
import com.neegix.system.dict.infrastructure.repository.mapper.customized.DictItemCustomizedMapper;
import com.neegix.system.dict.interfaces.vo.DictItemVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

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
    private DictGroupMapper dictGroupMapper;

    @Autowired
    private DictItemCustomizedMapper dictItemCustomizedMapper;

    @Override
    public PageVO<DictItemVO> findPage(Integer currentPage, Integer pageSize, NebulaSQL nebulaSQL) {
        nebulaSQL.setPager(currentPage, pageSize);
        List<DictItemDO> result = dictItemMapper.selectList(nebulaSQL);
        Long count = dictItemMapper.selectCount(nebulaSQL);
        PageVO<DictItemVO> page = new PageVO<>(currentPage, pageSize);
        page.setTotal(count);
        page.setResult(DictItemAssembler.INSTANCE.covertVO(result));
        return page;
    }

    @Override
    public List<DictItemVO> findDictItemsByGroupCode(String code) {
        NebulaSQL nebulaSQL = new NebulaSQL();
        nebulaSQL.createWhereGroups(DictGroupWhereGroup.class).andCodeEqualTo(code);
        DictGroupDO dictGroupDO = dictGroupMapper.selectOne(nebulaSQL);

        nebulaSQL.clear();
        nebulaSQL.createWhereGroups(DictItemWhereGroup.class).andPkDictGroupEqualTo(dictGroupDO.getId());
        List<DictItemDO> dictItemDOS = dictItemMapper.selectList(nebulaSQL);
        return DictItemAssembler.INSTANCE.covertVO(dictItemDOS);
    }
}
