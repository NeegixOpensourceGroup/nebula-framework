package com.neegix.system.user.application.service.query;

import com.neegix.base.PageVO;
import com.neegix.cqrs.query.Query;
import com.neegix.system.user.interfaces.vo.UserVO;
import lombok.Data;

import java.time.Instant;

/**
 * Created by IntelliJ IDEA (Community Edition)
 * Thank you to JetBrains for their contributions to the vast number of developers
 *
 * @Author: kushu001
 * @Date: 2025/05/06/17:12
 * @Description:
 */
@Data
public class GetPageUserQuery implements Query<PageVO<UserVO>> {
    // 当前页
    private Integer currentPage;
    // 每页数
    private Integer pageSize;
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
    // 账号名称
    private String name;
    // 密码
    private String password;
    // 描述
    private String description;
    // 邮箱
    private String email;
    // 手机号
    private String mobilePhone;
    // 是否启用（0 否 1 是）
    private Boolean enabled;
    // 是否删除（0 否 1 是）
    private Boolean deleted;
}
