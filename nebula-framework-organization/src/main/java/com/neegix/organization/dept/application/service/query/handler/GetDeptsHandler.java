package com.neegix.organization.dept.application.service.query.handler;

import com.neegix.application.query.NebulaSQL;
import com.neegix.cqrs.query.handler.QueryHandler;
import com.neegix.organization.dept.application.repository.DeptQueryRepository;
import com.neegix.organization.dept.infrastructure.repository.condition.DeptWhereGroup;
import com.neegix.organization.dept.application.service.query.GetDeptsQuery;
import com.neegix.organization.dept.interfaces.vo.DeptVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by IntelliJ IDEA (Community Edition)
 * Thank you to JetBrains for their contributions to the vast number of developers
 *
 * @Author: kushu001
 * @Date: 2025/05/26/21:23
 * @Description:
 */
@Service
public class GetDeptsHandler implements QueryHandler<GetDeptsQuery, List<DeptVO>> {

    @Autowired
    private DeptQueryRepository deptQueryRepository;

    @Override
    public List<DeptVO> handle(GetDeptsQuery query) {
        NebulaSQL nebulaSQL = new NebulaSQL();
        nebulaSQL.createWhereGroups(DeptWhereGroup.class)
                .andAbbreviationLikeTo(query.getAbbreviation())
                .andCodeLikeTo(query.getCode())
                .andCreateTimeBetween(query.getStartCreateTime(),query.getEndCreateTime())
                .andCreateUserEqualTo(query.getCreateUser())
                .andDeletedEqualTo(query.getDeleted())
                .andEnabledEqualTo(query.getEnabled())
                .andIdEqualTo(query.getId())
                .andManagerLikeTo(query.getManager())
                .andMobilePhoneLikeTo(query.getMobilePhone())
                .andNameLikeTo(query.getName())
                .andPidEqualTo(query.getPid())
                .andPkBizUnitEqualTo(query.getPkBizUnit())
                .andTelLikeTo(query.getTel())
                .andUpdateTimeBetween(query.getStartUpdateTime(),query.getEndUpdateTime())
                .andUpdateUserEqualTo(query.getUpdateUser());

        return deptQueryRepository.findList(nebulaSQL);
    }
}
