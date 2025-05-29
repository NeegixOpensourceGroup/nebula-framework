package com.neegix.log.operationLog.infrastructure.repository.impl;

import com.neegix.log.operationLog.domain.entity.OperationLogEntity;
import com.neegix.log.operationLog.domain.repository.OperationLogRepository;
import com.neegix.log.operationLog.infrastructure.repository.mapper.OperationLogMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

/**
 * Created by IntelliJ IDEA (Community Edition)
 * Thank you to JetBrains for their contributions to the vast number of developers
 *
 * @Author: kushu001
 * @Date: 2025/05/07/17:17
 * @Description:
 */
@Repository
public class OperationLogRepositoryImpl implements OperationLogRepository {

    @Autowired
    private OperationLogMapper operationLogMapper;

    @Override
    public void removeByIds(List<Long> longs) {
        operationLogMapper.deleteByPrimaryKeys(longs);
    }

    @Override
    public Optional<OperationLogEntity> findById(Long aLong) {
        return Optional.empty();
    }
}
