package com.neegix.system.dict.application.service.query.handler;

import com.neegix.application.query.NebulaSQL;
import com.neegix.base.PageVO;
import com.neegix.cqrs.query.handler.QueryHandler;
import com.neegix.system.dict.application.repository.DictGroupQueryRepository;
import com.neegix.system.dict.infrastructure.repository.condition.DictGroupWhereGroup;
import com.neegix.system.dict.application.service.query.GetPageDictGroupQuery;
import com.neegix.system.dict.interfaces.vo.DictGroupVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by IntelliJ IDEA (Community Edition)
 * Thank you to JetBrains for their contributions to the vast number of developers
 *
 * @Author: kushu001
 * @Date: 2025/05/21/16:55
 * @Description:
 */
@Service
public class GetPageDictGroupHandler implements QueryHandler<GetPageDictGroupQuery, PageVO<DictGroupVO>> {

    @Autowired
    private DictGroupQueryRepository dictGroupQueryRepository;
    @Override
    public PageVO<DictGroupVO> handle(GetPageDictGroupQuery query) {
        NebulaSQL nebulaSQL = new NebulaSQL();
        nebulaSQL.createWhereGroups(DictGroupWhereGroup.class).andNameLikeTo(query.getName()).andCodeEqualTo(query.getCode());
        return dictGroupQueryRepository.findPage(query.getCurrentPage(), query.getPageSize(), nebulaSQL);
    }
}
