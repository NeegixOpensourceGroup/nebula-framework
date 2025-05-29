package com.neegix.log.exceptionLog.application.service.query;

import com.neegix.cqrs.query.Query;
import com.neegix.log.exceptionLog.interfaces.vo.ExceptionLogVO;
import lombok.Data;

/**
 * Created by IntelliJ IDEA (Community Edition)
 * Thank you to JetBrains for their contributions to the vast number of developers
 *
 * @Author: kushu001
 * @Date: 2025/05/06/17:40
 * @Description:
 */
@Data
public class GetExceptionLogDetailQuery implements Query<ExceptionLogVO> {
    private Long id;

    public GetExceptionLogDetailQuery(Long id) {
        this.id = id;
    }
}
