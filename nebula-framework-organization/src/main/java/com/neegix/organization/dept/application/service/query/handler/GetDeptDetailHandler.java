package com.neegix.organization.dept.application.service.query.handler;

import com.neegix.cqrs.query.handler.QueryHandler;
import com.neegix.exception.BusinessRuntimeException;
import com.neegix.organization.dept.application.assembler.DeptAssembler;
import com.neegix.organization.dept.application.service.query.GetDeptDetailQuery;
import com.neegix.organization.dept.domain.entity.DeptEntity;
import com.neegix.organization.dept.domain.repository.DeptRepository;
import com.neegix.organization.dept.interfaces.vo.DeptVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * Created by IntelliJ IDEA (Community Edition)
 * Thank you to JetBrains for their contributions to the vast number of developers
 *
 * @Author: kushu001
 * @Date: 2025/05/26/21:13
 * @Description:
 */
@Service
public class GetDeptDetailHandler implements QueryHandler<GetDeptDetailQuery, DeptVO> {

    @Autowired
    private DeptRepository deptRepository;

    @Override
    public DeptVO handle(GetDeptDetailQuery query) {
        Optional<DeptEntity> optional = deptRepository.findById(query.getId());
        DeptEntity deptEntity = optional.orElseThrow(()-> new BusinessRuntimeException("查询结果不存在"));
        return DeptAssembler.INSTANCE.covertVO(deptEntity);
    }
}
