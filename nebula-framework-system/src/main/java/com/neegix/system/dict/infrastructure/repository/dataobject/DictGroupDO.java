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
public class DictGroupDO extends BaseDO {
    private String code;
    private String name;
}
