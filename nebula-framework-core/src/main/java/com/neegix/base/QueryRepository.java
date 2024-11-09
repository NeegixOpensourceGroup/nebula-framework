package com.neegix.base;

import java.util.List;

/**
 * Created by IntelliJ IDEA (Community Edition)
 * Thank you to JetBrains for their contributions to the vast number of developers
 *
 * @Author: kushu001
 * @Date: 2024/09/20/20:54
 * @Description:
 */
public interface QueryRepository<T, ID> {
    List<T> findAll();
    T findById(ID id);
}
