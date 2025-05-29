package com.neegix.log.exceptionLog.infrastructure.repository.impl;

import com.neegix.log.exceptionLog.domain.entity.ExceptionLogEntity;
import com.neegix.log.exceptionLog.domain.repository.ExceptionLogRepository;
import com.neegix.log.exceptionLog.infrastructure.repository.convert.ExceptionLogConverter;
import com.neegix.log.exceptionLog.infrastructure.repository.dataobject.ExceptionLogDO;
import com.neegix.log.exceptionLog.infrastructure.repository.mapper.ExceptionLogMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

/**
 * Created by IntelliJ IDEA (Community Edition)
 * Thank you to JetBrains for their contributions to the vast number of developers
 *
 * @Author: kushu001
 * @Date: 2025/05/06/16:18
 * @Description:
 */
@Repository
public class ExceptionLogRepositoryImpl implements ExceptionLogRepository {

    @Autowired
    private ExceptionLogMapper exceptionLogMapper;


    @Override
    public void removeByIds(List<Long> ids) {
        exceptionLogMapper.deleteByPrimaryKeys(ids);
    }

    @Override
    public Optional<ExceptionLogEntity> findById(Long id) {
        ExceptionLogDO exceptionLogDO = exceptionLogMapper.selectByPrimaryKey(id);
        return Optional.ofNullable(ExceptionLogConverter.INSTANCE.convertEntity(exceptionLogDO));
    }
}
