package com.neegix.development.api.application.service.query.handler;

import com.neegix.cqrs.query.handler.QueryHandler;
import com.neegix.development.api.application.assembler.ApiAssembler;
import com.neegix.development.api.application.service.query.GetApiDetailQuery;
import com.neegix.development.api.domain.entity.Api;
import com.neegix.development.api.domain.reponsitory.ApiRepository;
import com.neegix.development.api.interfaces.vo.ApiVO;
import com.neegix.exception.BusinessRuntimeException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * Created by IntelliJ IDEA (Community Edition)
 * Thank you to JetBrains for their contributions to the vast number of developers
 *
 * @Author: kushu001
 * @Date: 2025/04/27/16:24
 * @Description:
 */
@Service
public class QueryApiDetailHandler implements QueryHandler<GetApiDetailQuery, ApiVO> {

    @Autowired
    private ApiRepository apiRepository;

    @Override
    public ApiVO handle(GetApiDetailQuery query) {

        Optional<Api> optional= apiRepository.findById(query.getId());

        Api api = optional.orElseThrow(()-> new BusinessRuntimeException("查询结果不存在"));

        return ApiAssembler.INSTANCE.covertVO(api);

    }
}
