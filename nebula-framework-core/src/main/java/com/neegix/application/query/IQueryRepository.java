package com.neegix.application.query;

import java.util.List;
import java.util.Optional;

/**
 * Created by IntelliJ IDEA (Community Edition)
 * Thank you to JetBrains for their contributions to the vast number of developers
 *
 * @Author: kushu001
 * @Date: 2024/11/21/16:05
 * @Description:
 */
public interface IQueryRepository<PK, T, R> {
    Optional<R> findById(PK id);
    Integer selectCount(List<PK> ids);
}
