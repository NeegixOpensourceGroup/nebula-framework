package com.neegix.inferfaces.form;

import lombok.Data;

import java.time.LocalDate;

/**
 * Created by IntelliJ IDEA (Community Edition)
 * Thank you to JetBrains for their contributions to the vast number of developers
 *
 * @Author: kushu001
 * @Date: 2025/06/17/15:58
 * @Description:
 */
@Data
public class BaseQueryForm {
    // 创建时间-开始
    private LocalDate startCreateTime;
    // 创建时间-结束
    private LocalDate endCreateTime;
    // 更新时间-开始
    private LocalDate startUpdateTime;
    // 更新时间-结束
    private LocalDate endUpdateTime;
    // 创建人
    private Long createUser;
    // 更新人
    private Long updateUser;
    // 是否删除（0 否 1 是）
    private Boolean deleted;
    // 是否启用（0 否 1 是）
    private Boolean enabled;
}
