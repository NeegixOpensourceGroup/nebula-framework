package com.neegix.log.operationLog.application.service.query;

import com.neegix.cqrs.query.Query;
import com.neegix.log.operationLog.interfaces.vo.OperationLogVO;
import lombok.Data;

/**
 * Created by IntelliJ IDEA (Community Edition)
 * Thank you to JetBrains for their contributions to the vast number of developers
 *
 * @Author: kushu001
 * @Date: 2025/05/07/17:30
 * @Description:
 */
@Data
public class GetOperationLogDetailQuery implements Query<OperationLogVO> {
    private Long id;

    public GetOperationLogDetailQuery(Long id) {
        this.id = id;
    }
}
