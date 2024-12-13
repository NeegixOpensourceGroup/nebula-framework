package com.neegix.organization.psn.domain.entity;

import lombok.Data;

/**
 * Created by IntelliJ IDEA (Community Edition)
 * Thank you to JetBrains for their contributions to the vast number of developers
 *
 * @Author: kushu001
 * @Date: 2024/12/12/17:33
 * @Description:
 */
@Data
public class PsnWorkInfoValue {
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
