package com.neegix.system.dict.application.service.query.handler;

import com.neegix.cqrs.query.handler.QueryHandler;
import com.neegix.exception.BusinessRuntimeException;
import com.neegix.system.dict.application.assembler.DictGroupAssembler;
import com.neegix.system.dict.application.service.query.GetDictGroupDetailQuery;
import com.neegix.system.dict.domain.entity.DictGroupEntity;
import com.neegix.system.dict.domain.repository.DictGroupRepository;
import com.neegix.system.dict.interfaces.vo.DictGroupVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * Created by IntelliJ IDEA (Community Edition)
 * Thank you to JetBrains for their contributions to the vast number of developers
 *
 * @Author: kushu001
 * @Date: 2025/05/21/16:04
 * @Description:
 */
@Service
public class GetDictGroupDetailHandler implements QueryHandler<GetDictGroupDetailQuery, DictGroupVO> {

    @Autowired
    private DictGroupRepository dictGroupRepository;

    @Override
    public DictGroupVO handle(GetDictGroupDetailQuery query) {
        Optional<DictGroupEntity> optional = dictGroupRepository.findById(query.getId());
        DictGroupEntity dictGroup = optional.orElseThrow(()-> new BusinessRuntimeException("查询结果不存在"));
        return DictGroupAssembler.INSTANCE.covertVO(dictGroup);
    }
}
