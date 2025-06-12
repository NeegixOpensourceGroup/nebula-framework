package com.neegix.system.user.domain.repository;

import com.neegix.domain.repository.IRepository;
import com.neegix.system.user.domain.entity.UserEntity;

import java.util.List;

/**
 * Created by IntelliJ IDEA (Community Edition)
 * Thank you to JetBrains for their contributions to the vast number of developers
 *
 * @Author: kushu001
 * @Date: 2025/05/08/16:15
 * @Description:
 */
public interface UserRepository extends IRepository<UserEntity, Long> {

    void removeUserRoleRel(List<Long> userIds);

    void batchInsertUserRoleRel(Long userId, List<Long> roleIds);


}
