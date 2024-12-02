package com.neegix.base;

import com.neegix.utils.SnowFlake;
import lombok.Data;

import java.time.Instant;
import java.util.Date;

/**
 * Created by IntelliJ IDEA (Community Edition)
 * Thank you to JetBrains for their contributions to the vast number of developers
 *
 * @Author: kushu001
 * @Date: 2024/09/13/14:04
 * @Description:
 */
@Data
public class BaseEntity {
    private Long id = new SnowFlake(1, 1).nextId();
    private Instant createTime;
    private Instant updateTime;
    private Long createUser;
    private Long updateUser;
}
