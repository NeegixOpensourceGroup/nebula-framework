package com.neegix.domain.repository;

import java.util.List;
import java.util.Optional;

/**
 * Created by IntelliJ IDEA (Community Edition)
 * Thank you to JetBrains for their contributions to the vast number of developers
 *
 * @Author: kushu001
 * @Date: 2025/04/24/17:16
 * @Description:
 */
public interface IRepository<T, ID> {

    default void save(T t){};

    void removeByIds(List<ID> ids);

    Optional<T> findById(ID id);

    default void remove(T t){}

    default void removeById(ID id){}

    default void removeAll(){}



}
