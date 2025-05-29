package com.neegix.development.api.application.service.query;

import com.neegix.cqrs.query.Query;
import com.neegix.development.api.interfaces.vo.ApiVO;
import lombok.Data;

/**
 * Created by IntelliJ IDEA (Community Edition)
 * Thank you to JetBrains for their contributions to the vast number of developers
 *
 * @Author: kushu001
 * @Date: 2025/04/27/16:23
 * @Description:
 */
@Data
public class GetApiDetailQuery implements Query<ApiVO> {
    private Long id;
    public GetApiDetailQuery(Long id) {
        this.id = id;
    }
}
