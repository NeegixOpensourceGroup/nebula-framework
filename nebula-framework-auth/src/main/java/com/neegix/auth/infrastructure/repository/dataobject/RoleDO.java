package com.neegix.auth.infrastructure.repository.dataobject;

import com.neegix.base.BaseDO;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * Created by IntelliJ IDEA (Community Edition)
 * Thank you to JetBrains for their contributions to the vast number of developers
 *
 * @Author: kushu001
 * @Date: 2024/09/03/16:32
 * @Description:
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class RoleDO extends BaseDO {
    private String name;
    private String sign;
}
