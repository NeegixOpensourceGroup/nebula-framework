package com.neegix.organization.psn.application.service.query;

import com.neegix.base.PageVO;
import com.neegix.cqrs.query.Query;
import com.neegix.organization.psn.interfaces.vo.PsnVO;
import lombok.Data;

import java.time.Instant;

/**
 * Created by IntelliJ IDEA (Community Edition)
 * Thank you to JetBrains for their contributions to the vast number of developers
 *
 * @Author: kushu001
 * @Date: 2025/05/28/17:43
 * @Description:
 */
@Data
public class GetPagePsnQuery implements Query<PageVO<PsnVO>> {

    // 当前页
    private Integer currentPage;
    // 每页数
    private Integer pageSize;
    // 出生日期
    private String birth;
    // 人员编码
    private String code;
    // 联系电话
    private String contactTel;
    // 创建时间-开始
    private Instant startCreateTime;
    // 创建时间-结束
    private Instant endCreateTime;
    // 创建人
    private Long createUser;
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
    // ID
    private Long id;
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
    // 更新时间-开始
    private Instant startUpdateTime;
    // 更新时间-结束
    private Instant endUpdateTime;
    // 更新人
    private Long updateUser;

    private Long pkDept;
}
