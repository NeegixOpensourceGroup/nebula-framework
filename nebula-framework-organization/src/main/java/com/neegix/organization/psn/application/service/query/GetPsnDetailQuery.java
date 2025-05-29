package com.neegix.organization.psn.application.service.query;

import com.neegix.cqrs.query.Query;
import com.neegix.organization.psn.interfaces.vo.PsnVO;
import lombok.Data;

/**
 * Created by IntelliJ IDEA (Community Edition)
 * Thank you to JetBrains for their contributions to the vast number of developers
 *
 * @Author: kushu001
 * @Date: 2025/05/28/17:00
 * @Description:
 */
@Data
public class GetPsnDetailQuery implements Query<PsnVO> {

    private Long id;

    public GetPsnDetailQuery(Long id) {
        this.id = id;
    }
}
