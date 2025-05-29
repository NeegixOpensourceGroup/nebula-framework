package com.neegix.log.loginLog.application.service.query;

import com.neegix.base.PageVO;
import com.neegix.cqrs.query.Query;
import com.neegix.log.loginLog.interfaces.vo.LoginLogVO;
import lombok.Data;

import java.time.Instant;

/**
 * Created by IntelliJ IDEA (Community Edition)
 * Thank you to JetBrains for their contributions to the vast number of developers
 *
 * @Author: kushu001
 * @Date: 2025/05/08/14:09
 * @Description:
 */
@Data
public class GetPageLoginLogQuery implements Query<PageVO<LoginLogVO>> {
    // 当前页
    private Integer currentPage;
    // 每页数
    private Integer pageSize;
    // 登录人
    private String user;
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
    // IP
    private String ip;
    // 地区
    private String area;
    // 类型（1 浏览器 2 移动端 3 TV端）
    private Integer type;
    // 客户端
    private String client;
    // 是否启用（0 否 1 是）
    private Boolean enabled;
    // 是否删除（0 否 1 是）
    private Boolean deleted;
}
