package com.neegix.development.menu.application.service.query;

import com.neegix.cqrs.query.Query;
import com.neegix.development.menu.interfaces.vo.MenuVO;
import lombok.Data;

import java.time.Instant;
import java.util.List;

/**
 * Created by IntelliJ IDEA (Community Edition)
 * Thank you to JetBrains for their contributions to the vast number of developers
 *
 * @Author: kushu001
 * @Date: 2025/04/27/17:32
 * @Description:
 */
@Data
public class GetMenuQuery implements Query<List<MenuVO>> {
    // 创建时间-开始
    private Instant startCreateTime;
    // 创建时间-结束
    private Instant endCreateTime;
    // 更新时间-开始
    private Instant startUpdateTime;
    // 更新时间-结束
    private Instant endUpdateTime;
    // 创建人
    private Long createUser;
    // 更新人
    private Long updateUser;
    // 父ID
    private Long pid;
    // 名称
    private String name;
    // 权限标识
    private String access;
    // 类型
    private Integer type;
    // 是否启用（0 否 1 是）
    private Boolean enabled;
    // 是否删除（0 否 1 是）
    private Boolean deleted;
}
