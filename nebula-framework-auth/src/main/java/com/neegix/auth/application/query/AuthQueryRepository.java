package com.neegix.auth.application.query;

import com.neegix.auth.application.dto.UserDTO;

/**
 * Created by IntelliJ IDEA (Community Edition)
 * Thank you to JetBrains for their contributions to the vast number of developers
 *
 * @Author: kushu001
 * @Date: 2024/09/13/13:54
 * @Description:
 */
public interface AuthQueryRepository {
    UserDTO findUserByName(String name);
}
