package com.neegix.log.exceptionLog.application.service.query;

import com.neegix.base.PageVO;
import com.neegix.cqrs.query.Query;
import com.neegix.log.exceptionLog.interfaces.vo.ExceptionLogVO;
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
public class GetPageExceptionLogQuery implements Query<PageVO<ExceptionLogVO>> {
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
    // 操作人
    private String user;
    // 模块
    private String module;
    // 类型
    private Integer type;
    // 描述
    private String description;
    // URI
    private String uri;
    // 全限定名
    private String fullName;
    // 异常信息
    private String exception;
}
