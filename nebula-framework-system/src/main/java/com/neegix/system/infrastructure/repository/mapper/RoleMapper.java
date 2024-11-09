package com.neegix.system.infrastructure.repository.mapper;

import com.neegix.base.BaseMapper;
import com.neegix.system.infrastructure.repository.dataobject.RoleDO;
import org.apache.ibatis.annotations.Mapper;

/**
 * Created by IntelliJ IDEA (Community Edition)
 * Thank you to JetBrains for their contributions to the vast number of developers
 *
 * @Author: kushu001
 * @Date: 2024/09/21/22:37
 * @Description:
 */
@Mapper
public interface RoleMapper extends BaseMapper<RoleDO, Long> {
}
