package com.neegix.organization.post.application.service.query;

import com.neegix.base.PageVO;
import com.neegix.cqrs.query.Query;
import com.neegix.organization.post.interfaces.vo.PostVO;
import lombok.Data;

import java.time.Instant;

/**
 * Created by IntelliJ IDEA (Community Edition)
 * Thank you to JetBrains for their contributions to the vast number of developers
 *
 * @Author: kushu001
 * @Date: 2025/05/27/11:26
 * @Description:
 */
@Data
public class GetPagePostQuery implements Query<PageVO<PostVO>> {
    // 当前页
    private Integer currentPage;
    // 每页数
    private Integer pageSize;
    // 编码
    private String code;
    // 创建时间-开始
    private Instant startCreateTime;
    // 创建时间-结束
    private Instant endCreateTime;
    // 创建人
    private Long createUser;
    // 是否删除（0 否 1 是）
    private Boolean deleted;
    // 是否启用（0 否 1 是）
    private Boolean enabled;
    // ID
    private Long id;
    // 名称
    private String name;
    // 业务单元ID
    private Long pkBizUnit;
    // 部门ID
    private Long pkDept;
    // 更新时间-开始
    private Instant startUpdateTime;
    // 更新时间-结束
    private Instant endUpdateTime;
    // 更新人
    private Long updateUser;
}
