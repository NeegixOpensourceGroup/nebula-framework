package com.neegix.system.dict.application.service.query.handler;

import com.neegix.cqrs.query.handler.QueryHandler;
import com.neegix.system.dict.application.repository.DictItemQueryRepository;
import com.neegix.system.dict.application.service.query.GetDictItemsQuery;
import com.neegix.system.dict.interfaces.vo.DictItemVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by IntelliJ IDEA (Community Edition)
 * Thank you to JetBrains for their contributions to the vast number of developers
 *
 * @Author: kushu001
 * @Date: 2025/05/23/17:10
 * @Description:
 */
@Service
public class GetDictItemsHandler implements QueryHandler<GetDictItemsQuery, List<DictItemVO>> {

    @Autowired
    private DictItemQueryRepository dictItemQueryRepository;

    @Override
    public List<DictItemVO> handle(GetDictItemsQuery query) {
        return dictItemQueryRepository.findDictItemsByGroupCode(query.getCode());
    }
}
