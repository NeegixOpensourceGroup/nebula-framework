package com.neegix.base;

import lombok.Data;

import java.time.LocalDate;

/**
 * Created by IntelliJ IDEA (Community Edition)
 * Thank you to JetBrains for their contributions to the vast number of developers
 *
 * @Author: kushu001
 * @Date: 2025/06/17/16:00
 * @Description:
 */
@Data
public class BaseDateForm {
    // 创建时间-开始
    private LocalDate startCreateTime;
    // 创建时间-结束
    private LocalDate endCreateTime;
    // 更新时间-开始
    private LocalDate startUpdateTime;
    // 更新时间-结束
    private LocalDate endUpdateTime;
}
