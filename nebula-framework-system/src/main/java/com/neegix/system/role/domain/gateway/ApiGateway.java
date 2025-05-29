package com.neegix.system.role.domain.gateway;

import com.neegix.system.role.domain.gateway.dto.ApiDTO;

import java.util.List;

/**
 * Created by IntelliJ IDEA (Community Edition)
 * Thank you to JetBrains for their contributions to the vast number of developers
 *
 * @Author: kushu001
 * @Date: 2025/05/16/15:42
 * @Description:
 */
public interface ApiGateway {
    List<ApiDTO> getApis(List<Long> ids);
}
