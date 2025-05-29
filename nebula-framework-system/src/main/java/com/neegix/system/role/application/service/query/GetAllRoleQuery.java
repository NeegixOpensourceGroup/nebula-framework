package com.neegix.system.role.application.service.query;

import com.neegix.cqrs.query.Query;
import com.neegix.system.role.interfaces.vo.RoleVO;
import lombok.Data;

import java.util.List;

/**
 * Created by IntelliJ IDEA (Community Edition)
 * Thank you to JetBrains for their contributions to the vast number of developers
 *
 * @Author: kushu001
 * @Date: 2025/05/19/17:21
 * @Description:
 */
@Data
public class GetAllRoleQuery implements Query<List<RoleVO>> {
}
