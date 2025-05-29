package com.neegix.organization.dept.application.service.query;

import com.neegix.cqrs.query.Query;
import com.neegix.organization.dept.interfaces.vo.DeptVO;
import lombok.Data;

/**
 * Created by IntelliJ IDEA (Community Edition)
 * Thank you to JetBrains for their contributions to the vast number of developers
 *
 * @Author: kushu001
 * @Date: 2025/05/26/21:04
 * @Description:
 */
@Data
public class GetDeptDetailQuery implements Query<DeptVO> {
    private Long id;

    public GetDeptDetailQuery(Long id) {
        this.id = id;
    }
}
