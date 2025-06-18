package com.neegix.log.operationLog.application.service.query;

import com.neegix.base.PageVO;
import com.neegix.cqrs.query.Query;
import com.neegix.log.operationLog.interfaces.vo.OperationLogVO;
import lombok.Data;

import java.time.LocalDate;

/**
 * Created by IntelliJ IDEA (Community Edition)
 * Thank you to JetBrains for their contributions to the vast number of developers
 *
 * @Author: kushu001
 * @Date: 2025/05/07/17:30
 * @Description:
 */
@Data
public class GetPageOperationLogQuery implements Query<PageVO<OperationLogVO>> {
    // 当前页
    private Integer currentPage;
    // 每页数
    private Integer pageSize;
    private String user;
    // 创建时间-开始
    private LocalDate startCreateTime;
    // 创建时间-结束
    private LocalDate endCreateTime;
    // 创建人
    private Long createUser;
    // 描述
    private String description;
    // ID
    private Long id;
    // 模块
    private String module;
    // 类型
    private Integer type;
    // 更新时间-开始
    private LocalDate startUpdateTime;
    // 更新时间-结束
    private LocalDate endUpdateTime;
    // 更新人
    private Long updateUser;
}
