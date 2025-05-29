package com.neegix.organization.dept.infrastructure.repository.impl;

import com.neegix.organization.dept.domain.entity.DeptEntity;
import com.neegix.organization.dept.domain.repository.DeptRepository;
import com.neegix.organization.dept.infrastructure.repository.convert.DeptConverter;
import com.neegix.organization.dept.infrastructure.repository.dataobject.DeptDO;
import com.neegix.organization.dept.infrastructure.repository.mapper.DeptMapper;
import com.neegix.organization.dept.infrastructure.repository.mapper.customized.DeptCustomizedMapper;
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
 * @Date: 2025/05/26/17:37
 * @Description:
 */
@Repository
public class DeptRepositoryImpl implements DeptRepository {

    @Autowired
    private DeptMapper deptMapper;

    @Autowired
    private DeptCustomizedMapper deptCustomizedMapper;

    @Override
    public void save(DeptEntity deptEntity) {
        DeptDO deptDO = DeptConverter.INSTANCE.covertDO(deptEntity);

        if (deptDO.getId() == null) {
            deptDO.setId(SnowFlake.generateId());
            deptMapper.insert(deptDO);
        } else {
            deptMapper.updateByPrimaryKey(deptDO);
        }
    }

    @Override
    public void removeByIds(List<Long> longs) {
        for (Long id: longs) {
            deptCustomizedMapper.deleteById(id);
        }
    }

    @Override
    public void removeById(Long aLong) {
        deptCustomizedMapper.deleteById(aLong);
    }

    @Override
    public Optional<DeptEntity> findById(Long aLong) {
        DeptDO deptDO = deptMapper.selectByPrimaryKey(aLong);
        return Optional.ofNullable(DeptConverter.INSTANCE.covertEntity(deptDO));
    }
}
