package com.neegix.organization.dept.application.service.query;

import com.neegix.cqrs.query.Query;
import com.neegix.organization.dept.interfaces.vo.DeptVO;
import lombok.Data;

import java.time.Instant;
import java.util.List;

/**
 * Created by IntelliJ IDEA (Community Edition)
 * Thank you to JetBrains for their contributions to the vast number of developers
 *
 * @Author: kushu001
 * @Date: 2025/05/26/21:21
 * @Description:
 */
@Data
public class GetDeptsQuery implements Query<List<DeptVO>> {
    // 简称
    private String abbreviation;
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
    // 负责人
    private String manager;
    // 负责人电话
    private String mobilePhone;
    // 名称
    private String name;
    // 父ID
    private Long pid;
    // 业务单元ID
    private Long pkBizUnit;
    // 电话
    private String tel;
    // 更新时间-开始
    private Instant startUpdateTime;
    // 更新时间-结束
    private Instant endUpdateTime;
    // 更新人
    private Long updateUser;
}
