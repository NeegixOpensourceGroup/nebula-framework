package com.neegix.system.dict.application.service.query;

import com.neegix.cqrs.query.Query;
import com.neegix.system.dict.interfaces.vo.DictGroupVO;
import lombok.Data;

/**
 * Created by IntelliJ IDEA (Community Edition)
 * Thank you to JetBrains for their contributions to the vast number of developers
 *
 * @Author: kushu001
 * @Date: 2025/05/21/16:02
 * @Description:
 */
@Data
public class GetDictGroupDetailQuery implements Query<DictGroupVO> {

    private Long id;

    public GetDictGroupDetailQuery(Long id) {
        this.id = id;
    }
}
