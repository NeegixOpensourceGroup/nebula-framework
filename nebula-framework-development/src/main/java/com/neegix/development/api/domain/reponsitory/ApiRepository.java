package com.neegix.development.api.domain.reponsitory;

import com.neegix.domain.repository.IRepository;
import com.neegix.development.api.domain.entity.Api;

/**
 * Created by IntelliJ IDEA (Community Edition)
 * Thank you to JetBrains for their contributions to the vast number of developers
 *
 * @Author: kushu001
 * @Date: 2025/04/24/17:15
 * @Description:
 */
public interface ApiRepository extends IRepository<Api, Long> {
    boolean existsByAccess(String access);
}
