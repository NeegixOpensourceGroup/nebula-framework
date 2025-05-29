package com.neegix.system.role.application.service.query;

import com.neegix.cqrs.query.Query;
import com.neegix.system.role.interfaces.vo.RoleVO;
import lombok.Data;

/**
 * Created by IntelliJ IDEA (Community Edition)
 * Thank you to JetBrains for their contributions to the vast number of developers
 *
 * @Author: kushu001
 * @Date: 2025/05/14/11:05
 * @Description:
 */
@Data
public class GetRoleDetailQuery implements Query<RoleVO> {

    private Long id;

    public GetRoleDetailQuery(Long id) {
        this.id = id;
    }
}
