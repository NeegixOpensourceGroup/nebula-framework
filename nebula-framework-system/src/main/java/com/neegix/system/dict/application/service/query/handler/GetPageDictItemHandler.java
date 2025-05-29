package com.neegix.system.dict.application.service.query.handler;

import com.neegix.application.query.NebulaSQL;
import com.neegix.base.PageVO;
import com.neegix.cqrs.query.handler.QueryHandler;
import com.neegix.system.dict.application.repository.DictItemQueryRepository;
import com.neegix.system.dict.infrastructure.repository.condition.DictItemWhereGroup;
import com.neegix.system.dict.application.service.query.GetPageDictItemQuery;
import com.neegix.system.dict.interfaces.vo.DictItemVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by IntelliJ IDEA (Community Edition)
 * Thank you to JetBrains for their contributions to the vast number of developers
 *
 * @Author: kushu001
 * @Date: 2025/05/22/17:04
 * @Description:
 */
@Service
public class GetPageDictItemHandler implements QueryHandler<GetPageDictItemQuery, PageVO<DictItemVO>> {

    @Autowired
    private DictItemQueryRepository dictItemQueryRepository;

    @Override
    public PageVO<DictItemVO> handle(GetPageDictItemQuery query) {
        NebulaSQL nebulaSQL = new NebulaSQL();
        nebulaSQL.createWhereGroups(DictItemWhereGroup.class)
                .andPkDictGroupEqualTo(query.getPkDictGroup())
                .andNameLikeTo(query.getName());
        return dictItemQueryRepository.findPage(query.getCurrentPage(), query.getPageSize(), nebulaSQL);
    }
}
