package com.neegix.development.api.interfaces.form;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

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
  * @since 2024-11-22 11:43:14
  */

@Data
public class QueryApiForm {
    // ID
    private Long id;
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
    // 菜单模块
    private Long module;
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

