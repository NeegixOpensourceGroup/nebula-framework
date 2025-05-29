package com.neegix.domain.repository;

import com.neegix.domain.entity.AggregateRoot;

import java.util.Optional;

/**
 * Created by IntelliJ IDEA (Community Edition)
 * Thank you to JetBrains for their contributions to the vast number of developers
 *
 * @Author: kushu001
 * @Date: 2025/04/29/11:22
 * @Description:
 */
public interface IAggregateRepository<AR extends AggregateRoot<ID>, ID> {
    Optional<AR> findById(ID id);
    void save(AR aggregate);
    void remove(ID id);
}
