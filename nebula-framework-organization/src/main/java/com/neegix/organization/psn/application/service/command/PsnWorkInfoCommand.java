package com.neegix.organization.psn.application.service.command;

import lombok.Data;

/**
 * Created by IntelliJ IDEA (Community Edition)
 * Thank you to JetBrains for their contributions to the vast number of developers
 *
 * @Author: kushu001
 * @Date: 2025/05/27/15:39
 * @Description:
 */
@Data
public class PsnWorkInfoCommand {
    private Long pkPsn;
    private Long pkBizUnit;
    private Long pkDept;
    private Long pkPost;
    private String code;
    private String type;
    private Boolean major;
    private String start;
    private String end;
    private String position;
}
