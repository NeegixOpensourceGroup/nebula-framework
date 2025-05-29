package com.neegix.organization.post.application.service.query.handler;

import com.neegix.application.query.NebulaSQL;
import com.neegix.base.PageVO;
import com.neegix.cqrs.query.handler.QueryHandler;
import com.neegix.organization.post.application.repository.PostQueryRepository;
import com.neegix.organization.post.infrastructure.repository.condition.PostWhereGroup;
import com.neegix.organization.post.application.service.query.GetPagePostQuery;
import com.neegix.organization.post.interfaces.vo.PostVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by IntelliJ IDEA (Community Edition)
 * Thank you to JetBrains for their contributions to the vast number of developers
 *
 * @Author: kushu001
 * @Date: 2025/05/27/11:36
 * @Description:
 */
@Service
public class GetPagePostHandler implements QueryHandler<GetPagePostQuery, PageVO<PostVO>> {

    @Autowired
    private PostQueryRepository postQueryRepository;

    @Override
    public PageVO<PostVO> handle(GetPagePostQuery query) {
        NebulaSQL nebulaSQL = new NebulaSQL();
        nebulaSQL.createWhereGroups(PostWhereGroup.class)
                .andCodeLikeTo(query.getCode())
                .andCreateTimeBetween(query.getStartCreateTime(), query.getEndCreateTime())
                .andCreateUserEqualTo(query.getCreateUser())
                .andDeletedEqualTo(query.getDeleted())
                .andEnabledEqualTo(query.getEnabled())
                .andIdEqualTo(query.getId())
                .andNameLikeTo(query.getName())
                .andPkBizUnitEqualTo(query.getPkBizUnit())
                .andPkDeptEqualTo(query.getPkDept())
                .andUpdateTimeBetween(query.getStartUpdateTime(), query.getEndUpdateTime())
                .andUpdateUserEqualTo(query.getUpdateUser());
        return postQueryRepository.findPage(query.getCurrentPage(), query.getPageSize(), nebulaSQL);
    }
}
