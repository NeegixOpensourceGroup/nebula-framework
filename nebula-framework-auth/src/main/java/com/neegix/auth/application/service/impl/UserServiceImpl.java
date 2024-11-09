package com.neegix.auth.application.service.impl;

import com.neegix.auth.application.dto.UserDTO;
import com.neegix.auth.application.query.AuthQueryRepository;
import com.neegix.auth.interfaces.vo.NebulaUserDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 * Created by IntelliJ IDEA (Community Edition)
 * Thank you to JetBrains for their contributions to the vast number of developers
 *
 * @Author: kushu001
 * @Date: 2024/08/24/19:46
 * @Description:
 */
@Service
public class UserServiceImpl implements UserDetailsService {

    @Autowired
    private AuthQueryRepository authRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserDTO userDTO = authRepository.findUserByName(username);
        NebulaUserDetails nebulaUserDetails = new NebulaUserDetails();
        nebulaUserDetails.setId(userDTO.getId());
        nebulaUserDetails.setUsername(userDTO.getName());
        nebulaUserDetails.setRoles(userDTO.getRoleDTOs());
        nebulaUserDetails.setPassword(userDTO.getPassword());
        return nebulaUserDetails;
    }
}
