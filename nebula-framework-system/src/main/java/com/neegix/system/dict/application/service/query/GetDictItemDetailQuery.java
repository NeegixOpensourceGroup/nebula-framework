package com.neegix.system.dict.application.service.query;

import com.neegix.cqrs.query.Query;
import com.neegix.system.dict.interfaces.vo.DictItemVO;
import lombok.Data;

/**
 * Created by IntelliJ IDEA (Community Edition)
 * Thank you to JetBrains for their contributions to the vast number of developers
 *
 * @Author: kushu001
 * @Date: 2025/05/22/16:44
 * @Description:
 */
@Data
public class GetDictItemDetailQuery implements Query<DictItemVO> {
    private Long id;

    public GetDictItemDetailQuery(Long id) {
        this.id = id;
    }
}
