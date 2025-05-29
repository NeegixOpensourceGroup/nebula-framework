package com.neegix.organization.bizUnit.application.service.query.handler;

import com.neegix.cqrs.query.handler.QueryHandler;
import com.neegix.exception.BusinessRuntimeException;
import com.neegix.organization.bizUnit.application.assembler.BizUnitAssembler;
import com.neegix.organization.bizUnit.application.service.query.GetBizUnitDetailQuery;
import com.neegix.organization.bizUnit.domain.entity.BizUnitEntity;
import com.neegix.organization.bizUnit.domain.repository.BizUnitRepository;
import com.neegix.organization.bizUnit.interfaces.vo.BizUnitVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * Created by IntelliJ IDEA (Community Edition)
 * Thank you to JetBrains for their contributions to the vast number of developers
 *
 * @Author: kushu001
 * @Date: 2025/05/25/09:36
 * @Description:
 */
@Service
public class GetBizUnitDetailHandler implements QueryHandler<GetBizUnitDetailQuery, BizUnitVO> {

    @Autowired
    private BizUnitRepository bizUnitRepository;

    @Override
    public BizUnitVO handle(GetBizUnitDetailQuery query) {
        Optional<BizUnitEntity> optional = bizUnitRepository.findById(query.getId());
        BizUnitEntity bizUnitEntity = optional.orElseThrow(()-> new BusinessRuntimeException("查询结果不存在"));
        return BizUnitAssembler.INSTANCE.covertVO(bizUnitEntity);
    }
}
