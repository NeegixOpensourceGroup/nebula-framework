package com.neegix.organization.psn.application.service.command;

import com.neegix.cqrs.command.Command;
import lombok.Data;

import java.util.List;

/**
 * Created by IntelliJ IDEA (Community Edition)
 * Thank you to JetBrains for their contributions to the vast number of developers
 *
 * @Author: kushu001
 * @Date: 2025/05/27/17:23
 * @Description:
 */
@Data
public class UpdatePsnCommand implements Command<Void> {

    private Long id;
    // 出生日期
    private String birth;
    // 人员编码
    private String code;
    // 联系电话
    private String contactTel;
    // 是否删除（0 否 1 是）
    private Boolean deleted;
    // 邮箱
    private String email;
    // 是否启用（0 否 1 是）
    private Boolean enabled;
    // 性别
    private Long gender;
    // 参加工作日期
    private String hireDate;
    // 家庭住址
    private String homeAddress;
    // 家庭电话
    private String homeTel;
    // 证件号码
    private String idNo;
    // 证件类型
    private Long idType;
    // 手机号
    private String mobilePhone;
    // 人员名称
    private String name;
    // 人员昵称
    private String nickname;
    // 业务单元PK
    private Long pkBizUnit;

    private List<PsnWorkInfoCommand> psnWorkInfos;
}
