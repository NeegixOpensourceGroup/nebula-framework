package com.neegix.organization.bizUnit.application.service.query;

import com.neegix.cqrs.query.Query;
import com.neegix.organization.bizUnit.interfaces.vo.BizUnitVO;
import lombok.Data;

import java.time.Instant;
import java.util.List;

/**
 * Created by IntelliJ IDEA (Community Edition)
 * Thank you to JetBrains for their contributions to the vast number of developers
 *
 * @Author: kushu001
 * @Date: 2025/05/25/09:47
 * @Description:
 */
@Data
public class GetBizUnitsQuery implements Query<List<BizUnitVO>> {
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
    // 编码
    private String code;
    // 名称
    private String name;
    // 简称
    private String abbreviation;
    // 电话
    private String tel;
    // 负责人
    private String manager;
    // 负责人电话
    private String mobilePhone;
    // 备注
    private String remark;
    // 类型（1 总部 2 分子公司 3 外部公司）
    private Integer type;
    // 是否启用（0 否 1 是）
    private Boolean enabled;
    // 是否删除（0 否 1 是）
    private Boolean deleted;
}
