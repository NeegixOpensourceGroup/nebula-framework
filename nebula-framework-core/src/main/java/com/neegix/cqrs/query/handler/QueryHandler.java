package com.neegix.cqrs.query.handler;

import com.neegix.cqrs.query.Query;

/**
 * Created by IntelliJ IDEA (Community Edition)
 * Thank you to JetBrains for their contributions to the vast number of developers
 *
 * @Author: kushu001
 * @Date: 2025/04/27/11:16
 * @Description:
 */
public interface QueryHandler<Q extends Query<R>, R> {
    R handle(Q query);
}
