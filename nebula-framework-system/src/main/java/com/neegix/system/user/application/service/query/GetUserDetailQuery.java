package com.neegix.system.user.application.service.query;

import com.neegix.cqrs.query.Query;
import com.neegix.system.user.interfaces.vo.UserVO;
import lombok.Data;

/**
 * Created by IntelliJ IDEA (Community Edition)
 * Thank you to JetBrains for their contributions to the vast number of developers
 *
 * @Author: kushu001
 * @Date: 2025/05/08/17:16
 * @Description:
 */
@Data
public class GetUserDetailQuery implements Query<UserVO> {
    private Long id;

    public GetUserDetailQuery(Long id){
        this.id = id;
    }
}
