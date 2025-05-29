package com.neegix.organization.bizUnit.application.service.command;

import com.neegix.cqrs.command.Command;
import lombok.Data;

/**
 * Created by IntelliJ IDEA (Community Edition)
 * Thank you to JetBrains for their contributions to the vast number of developers
 *
 * @Author: kushu001
 * @Date: 2025/05/24/10:29
 * @Description:
 */
@Data
public class CreateBizUnitCommand implements Command<Void> {
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
