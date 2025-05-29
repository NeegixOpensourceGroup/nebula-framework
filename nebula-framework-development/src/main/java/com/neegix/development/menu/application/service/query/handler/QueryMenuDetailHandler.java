package com.neegix.development.menu.application.service.query.handler;

import com.neegix.cqrs.query.handler.QueryHandler;
import com.neegix.development.menu.application.assembler.MenuAssembler;
import com.neegix.development.menu.application.service.query.GetMenuDetailQuery;
import com.neegix.development.menu.domain.entity.MenuEntity;
import com.neegix.development.menu.domain.repository.MenuRepository;
import com.neegix.development.menu.interfaces.vo.MenuVO;
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
public class QueryMenuDetailHandler implements QueryHandler<GetMenuDetailQuery, MenuVO> {

    @Autowired
    private MenuRepository menuRepository;

    @Override
    public MenuVO handle(GetMenuDetailQuery query) {

        Optional<MenuEntity> optional= menuRepository.findById(query.getId());

        MenuEntity menu = optional.orElseThrow(()-> new BusinessRuntimeException("查询结果不存在"));

        return MenuAssembler.INSTANCE.covertVO(menu);

    }
}
