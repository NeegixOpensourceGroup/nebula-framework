package com.neegix.organization.dept.interfaces.form;

import lombok.Data;
import java.time.Instant;

 /**
  * This file is auto-generated by nebula-framework-generator.
  * The auto-generation plugin was developed using IntelliJ IDEA Community Edition.
  * Thanks to JetBrains for their outstanding contributions to the developer community.
  * <p>
  * The code generated by this tool is owned by the user of the tool.
  * The tool itself is copyrighted by <a href="https://www.neegix.com">https://www.neegix.com</a>.
  *
  * @author <a href="https://www.neegix.com">https://www.neegix.com</a>
  * @version 1.0.0
  * @since 2024-12-10 14:48:03
  */

@Data
public class QueryDeptForm {
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

