package com.neegix.organization.bizUnit.application.service.query.handler;

import com.neegix.application.query.NebulaSQL;
import com.neegix.cqrs.query.handler.QueryHandler;
import com.neegix.organization.bizUnit.application.repository.BizUnitQueryRepository;
import com.neegix.organization.bizUnit.infrastructure.repository.condition.BizUnitWhereGroup;
import com.neegix.organization.bizUnit.application.service.query.GetBizUnitsQuery;
import com.neegix.organization.bizUnit.interfaces.vo.BizUnitVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by IntelliJ IDEA (Community Edition)
 * Thank you to JetBrains for their contributions to the vast number of developers
 *
 * @Author: kushu001
 * @Date: 2025/05/25/09:49
 * @Description:
 */
@Service
public class GetBizUnitsHandler implements QueryHandler<GetBizUnitsQuery, List<BizUnitVO>> {

    @Autowired
    private BizUnitQueryRepository bizUnitQueryRepository;

    @Override
    public List<BizUnitVO> handle(GetBizUnitsQuery query) {
        NebulaSQL nebulaSQL = new NebulaSQL();
        nebulaSQL.createWhereGroups(BizUnitWhereGroup.class)
                .andCreateTimeBetween(query.getStartCreateTime(),query.getEndCreateTime())
                .andUpdateTimeBetween(query.getStartUpdateTime(),query.getEndUpdateTime())
                .andCreateUserEqualTo(query.getCreateUser())
                .andUpdateUserEqualTo(query.getUpdateUser())
                .andPidEqualTo(query.getPid())
                .andCodeLikeTo(query.getCode())
                .andNameLikeTo(query.getName())
                .andAbbreviationLikeTo(query.getAbbreviation())
                .andTelLikeTo(query.getTel())
                .andManagerLikeTo(query.getManager())
                .andMobilePhoneLikeTo(query.getMobilePhone())
                .andRemarkLikeTo(query.getRemark())
                .andTypeEqualTo(query.getType())
                .andEnabledEqualTo(query.getEnabled())
                .andDeletedEqualTo(query.getDeleted());
        return bizUnitQueryRepository.findList(nebulaSQL);
    }
}
