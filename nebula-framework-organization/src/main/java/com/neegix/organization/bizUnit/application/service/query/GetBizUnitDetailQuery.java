package com.neegix.organization.bizUnit.application.service.query;

import com.neegix.cqrs.query.Query;
import com.neegix.organization.bizUnit.interfaces.vo.BizUnitVO;
import lombok.Data;

/**
 * Created by IntelliJ IDEA (Community Edition)
 * Thank you to JetBrains for their contributions to the vast number of developers
 *
 * @Author: kushu001
 * @Date: 2025/05/25/09:34
 * @Description:
 */
@Data
public class GetBizUnitDetailQuery implements Query<BizUnitVO> {

    private Long id;

    public GetBizUnitDetailQuery(Long id){
        this.id = id;
    }
}
