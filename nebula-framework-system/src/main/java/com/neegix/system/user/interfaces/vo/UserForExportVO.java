package com.neegix.system.user.interfaces.vo;

import cn.idev.excel.annotation.ExcelProperty;
import lombok.Data;

/**
 * Created by IntelliJ IDEA (Community Edition)
 * Thank you to JetBrains for their contributions to the vast number of developers
 *
 * @Author: kushu001
 * @Date: 2025/07/18/16:14
 * @Description:
 */
@Data
public class UserForExportVO {
    // 账号名称
    @ExcelProperty("账号名称")
    private String name;
    // 描述
    @ExcelProperty("描述")
    private String description;
    // 类型
    @ExcelProperty("类型")
    private String userType;
    // 邮箱
    @ExcelProperty("邮箱")
    private String email;
    // 手机号
    @ExcelProperty("手机号")
    private String mobilePhone;
}
