package com.neegix.organization.psn.interfaces.form;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

/**
 * Created by IntelliJ IDEA (Community Edition)
 * Thank you to JetBrains for their contributions to the vast number of developers
 *
 * @Author: kushu001
 * @Date: 2024/12/12/16:59
 * @Description:
 */
@Data
public class PsnWorkInfoForm {
    private Long pkPsn;
    private Long pkBizUnit;
    @NotNull(message="人员所属部门不能为空")
    private Long pkDept;
    private Long pkPost;
    private String code;
    private String type;
    private Boolean major;
    @NotNull(message="任职开始时间不能为空")
    private String start;
    @NotNull(message="任职结束时间不能为空")
    private String end;
    private String position;
}
