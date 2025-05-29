package com.neegix.development.menu.application.service.query;

import com.neegix.cqrs.query.Query;
import com.neegix.development.menu.interfaces.vo.MenuVO;
import lombok.Data;

/**
 * Created by IntelliJ IDEA (Community Edition)
 * Thank you to JetBrains for their contributions to the vast number of developers
 *
 * @Author: kushu001
 * @Date: 2025/04/27/16:23
 * @Description:
 */
@Data
public class GetMenuDetailQuery implements Query<MenuVO> {
    private Long id;

    public GetMenuDetailQuery(Long id) {
        this.id = id;
    }
}
