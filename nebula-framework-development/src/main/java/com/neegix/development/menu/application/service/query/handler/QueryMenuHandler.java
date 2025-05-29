package com.neegix.development.menu.application.service.query.handler;

import com.neegix.application.query.NebulaSQL;
import com.neegix.cqrs.query.handler.QueryHandler;
import com.neegix.development.menu.application.repository.MenuQueryRepository;
import com.neegix.development.menu.infrastructure.repository.condition.MenuWhereGroup;
import com.neegix.development.menu.application.service.query.GetMenuQuery;
import com.neegix.development.menu.interfaces.vo.MenuVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by IntelliJ IDEA (Community Edition)
 * Thank you to JetBrains for their contributions to the vast number of developers
 *
 * @Author: kushu001
 * @Date: 2025/04/30/23:28
 * @Description:
 */
@Service
public class QueryMenuHandler implements QueryHandler<GetMenuQuery, List<MenuVO>> {
    @Autowired
    private MenuQueryRepository menuQueryRepository;
    @Override
    public List<MenuVO> handle(GetMenuQuery query) {
        NebulaSQL nebulaSQL = new NebulaSQL();
        nebulaSQL.createWhereGroups(MenuWhereGroup.class).andNameLikeTo(query.getName());
        return menuQueryRepository.findList(nebulaSQL);
    }
}
