package com.neegix.system.dict.application.service.query;

import com.neegix.cqrs.query.Query;
import com.neegix.system.dict.interfaces.vo.DictItemVO;
import lombok.Data;

import java.util.List;

/**
 * Created by IntelliJ IDEA (Community Edition)
 * Thank you to JetBrains for their contributions to the vast number of developers
 *
 * @Author: kushu001
 * @Date: 2025/05/23/17:09
 * @Description:
 */
@Data
public class GetDictItemsQuery implements Query<List<DictItemVO>> {

    private String code;

    public GetDictItemsQuery(String code) {
        this.code = code;
    }
}
