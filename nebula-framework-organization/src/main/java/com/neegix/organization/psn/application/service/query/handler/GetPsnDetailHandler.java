package com.neegix.organization.psn.application.service.query.handler;

import com.neegix.cqrs.query.handler.QueryHandler;
import com.neegix.exception.BusinessRuntimeException;
import com.neegix.organization.psn.application.assembler.PsnAssembler;
import com.neegix.organization.psn.application.service.query.GetPsnDetailQuery;
import com.neegix.organization.psn.domain.entity.PsnEntity;
import com.neegix.organization.psn.domain.repository.PsnRepository;
import com.neegix.organization.psn.interfaces.vo.PsnVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.stream.IntStream;

/**
 * Created by IntelliJ IDEA (Community Edition)
 * Thank you to JetBrains for their contributions to the vast number of developers
 *
 * @Author: kushu001
 * @Date: 2025/05/28/17:01
 * @Description:
 */
@Service
public class GetPsnDetailHandler implements QueryHandler<GetPsnDetailQuery, PsnVO> {

    @Autowired
    private PsnRepository psnRepository;

    @Override
    public PsnVO handle(GetPsnDetailQuery query) {
        Optional<PsnEntity> optional = psnRepository.findById(query.getId());
        PsnEntity psnEntity = optional.orElseThrow(()-> new BusinessRuntimeException("查询结果不存在"));
        PsnVO psnVO = PsnAssembler.INSTANCE.covertVO(psnEntity);
        IntStream.range(0, psnVO.getPsnWorkInfos().size())
                .forEach(index -> psnVO.getPsnWorkInfos().get(index).setId(index));
        return psnVO;
    }
}
