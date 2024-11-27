package com.neegix.auth.infrastructure.repository.mapper;

import com.neegix.auth.infrastructure.repository.dataobject.RoleDO;
import com.neegix.auth.infrastructure.repository.dataobject.UserDO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * Created by IntelliJ IDEA (Community Edition)
 * Thank you to JetBrains for their contributions to the vast number of developers
 *
 * @Author: kushu001
 * @Date: 2024/09/13/13:55
 * @Description:
 */
@Mapper
public interface AuthMapper {
    List<RoleDO> selectRoleByUserId(Long userId);
    List<String> selectMenuPermissionByRoleIds(List<Long> roleIds);
    List<String> selectApiPermissionByRoleIds(List<Long> roleIds);
    UserDO selectUserByName(String name);
}
