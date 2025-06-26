package com.neegix.organization.psn.application.service.query.handler;

import com.neegix.application.query.NebulaSQL;
import com.neegix.application.query.WhereGroups;
import com.neegix.base.PageVO;
import com.neegix.cqrs.query.handler.QueryHandler;
import com.neegix.organization.psn.application.repository.PsnQueryRepository;
import com.neegix.organization.psn.infrastructure.repository.condition.PsnWhereGroup;
import com.neegix.organization.psn.application.service.query.GetPagePsnQuery;
import com.neegix.organization.psn.interfaces.vo.PsnVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by IntelliJ IDEA (Community Edition)
 * Thank you to JetBrains for their contributions to the vast number of developers
 *
 * @Author: kushu001
 * @Date: 2025/05/28/17:44
 * @Description:
 */
@Service
public class GetPagePsnHandler implements QueryHandler<GetPagePsnQuery, PageVO<PsnVO>> {

    @Autowired
    private PsnQueryRepository psnQueryRepository;

    public GetPagePsnHandler(PsnQueryRepository psnQueryRepository){
        this.psnQueryRepository = psnQueryRepository;
    }

    @Override
    public PageVO<PsnVO> handle(GetPagePsnQuery query) {
        List<Long> pkPsn = psnQueryRepository.findPsnPkByBizUnitAndDept(query.getPkBizUnit(), query.getPkDept());
        NebulaSQL nebulaSQL = new NebulaSQL();
        WhereGroups whereGroups = nebulaSQL.createWhereGroups(PsnWhereGroup.class)
                .andBirthLikeTo(query.getBirth())
                .andCodeLikeTo(query.getCode())
                .andContactTelLikeTo(query.getContactTel())
                .andCreateTimeBetween(query.getStartCreateTime(),query.getEndCreateTime())
                .andCreateUserEqualTo(query.getCreateUser())
                .andDeletedEqualTo(query.getDeleted())
                .andEmailLikeTo(query.getEmail())
                .andEnabledEqualTo(query.getEnabled())
                .andGenderEqualTo(query.getGender())
                .andHireDateLikeTo(query.getHireDate())
                .andHomeAddressLikeTo(query.getHomeAddress())
                .andHomeTelLikeTo(query.getHomeTel())
                .andIdIn(pkPsn)
                .andIdNoLikeTo(query.getIdNo())
                .andIdTypeEqualTo(query.getIdType())
                .andMobilePhoneLikeTo(query.getMobilePhone())
                .andNameLikeTo(query.getName())
                .andNicknameLikeTo(query.getNickname())
                .andPkBizUnitEqualTo(query.getPkBizUnit())
                .andUpdateTimeBetween(query.getStartUpdateTime(),query.getEndUpdateTime())
                .andUpdateUserEqualTo(query.getUpdateUser());
        return psnQueryRepository.findPage(query.getCurrentPage(), query.getPageSize(), nebulaSQL);
    }
}
