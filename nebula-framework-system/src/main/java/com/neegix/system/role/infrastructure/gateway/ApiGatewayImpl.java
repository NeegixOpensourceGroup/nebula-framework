package com.neegix.system.role.infrastructure.gateway;

import com.neegix.cqrs.query.UniversalQueryBus;
import com.neegix.development.api.application.service.query.GetApiDetailQuery;
import com.neegix.development.api.interfaces.vo.ApiVO;
import com.neegix.system.role.domain.gateway.ApiGateway;
import com.neegix.system.role.domain.gateway.dto.ApiDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by IntelliJ IDEA (Community Edition)
 * Thank you to JetBrains for their contributions to the vast number of developers
 *
 * @Author: kushu001
 * @Date: 2025/05/16/15:43
 * @Description:
 */
@Component
public class ApiGatewayImpl implements ApiGateway {
    @Autowired
    private UniversalQueryBus queryBus;
    @Override
    public List<ApiDTO> getApis(List<Long> ids) {
        List<ApiDTO> apiDTOS = new ArrayList<>();
        for (Long id: ids) {
            GetApiDetailQuery getApiDetailQuery = new GetApiDetailQuery(id);
            ApiVO api = queryBus.execute(getApiDetailQuery);
            ApiDTO apiDTO = new ApiDTO();
            apiDTO.setId(api.getId());
            apiDTO.setName(api.getName());
            apiDTO.setAccess(api.getAccess());
            apiDTOS.add(apiDTO);
        }

        return apiDTOS;
    }
}
