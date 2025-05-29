package com.neegix.system.user.application.service.query;

import com.neegix.cqrs.query.Query;
import lombok.Data;

import java.util.Set;

/**
 * Created by IntelliJ IDEA (Community Edition)
 * Thank you to JetBrains for their contributions to the vast number of developers
 *
 * @Author: kushu001
 * @Date: 2025/05/12/16:10
 * @Description:
 */
@Data
public class GetUserRolesQuery implements Query<Set<Long>> {
    private Long pkUser;

    public GetUserRolesQuery(Long pkUser) {
        this.pkUser = pkUser;
    }
}
