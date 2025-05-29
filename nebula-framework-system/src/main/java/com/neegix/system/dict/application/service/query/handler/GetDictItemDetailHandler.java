package com.neegix.system.dict.application.service.query.handler;

import com.neegix.cqrs.query.handler.QueryHandler;
import com.neegix.exception.BusinessRuntimeException;
import com.neegix.system.dict.application.assembler.DictItemAssembler;
import com.neegix.system.dict.application.service.query.GetDictItemDetailQuery;
import com.neegix.system.dict.domain.entity.DictItemEntity;
import com.neegix.system.dict.domain.repository.DictItemRepository;
import com.neegix.system.dict.interfaces.vo.DictItemVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * Created by IntelliJ IDEA (Community Edition)
 * Thank you to JetBrains for their contributions to the vast number of developers
 *
 * @Author: kushu001
 * @Date: 2025/05/22/16:45
 * @Description:
 */
@Service
public class GetDictItemDetailHandler implements QueryHandler<GetDictItemDetailQuery, DictItemVO> {

    @Autowired
    private DictItemRepository dictItemRepository;

    @Override
    public DictItemVO handle(GetDictItemDetailQuery query) {
        Optional<DictItemEntity> optional = dictItemRepository.findById(query.getId());
        DictItemEntity dictItemEntity = optional.orElseThrow(()-> new BusinessRuntimeException("查询结果不存在"));
        return DictItemAssembler.INSTANCE.covertVO(dictItemEntity);
    }
}
