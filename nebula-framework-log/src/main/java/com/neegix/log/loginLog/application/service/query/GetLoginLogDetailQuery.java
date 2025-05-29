package com.neegix.log.loginLog.application.service.query;

import com.neegix.cqrs.query.Query;
import com.neegix.log.loginLog.interfaces.vo.LoginLogVO;
import lombok.Data;

/**
 * Created by IntelliJ IDEA (Community Edition)
 * Thank you to JetBrains for their contributions to the vast number of developers
 *
 * @Author: kushu001
 * @Date: 2025/05/08/11:46
 * @Description:
 */
@Data
public class GetLoginLogDetailQuery implements Query<LoginLogVO> {
    private Long id;

    public GetLoginLogDetailQuery(Long id) {
        this.id = id;
    }
}
