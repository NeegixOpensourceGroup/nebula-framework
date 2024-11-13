package com.neegix.system.dict.infrastructure.repository.dataobject;

import com.neegix.base.BaseDO;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * Created by IntelliJ IDEA (Community Edition)
 * Thank you to JetBrains for their contributions to the vast number of developers
 *
 * @Author: kushu001
 * @Date: 2024/09/21/22:35
 * @Description:
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class RoleDO extends BaseDO {
    private String name;
    private String sign;
    private Boolean enabled;
    private Boolean deleted;
}
