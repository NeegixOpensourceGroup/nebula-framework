package com.neegix.auth.interfaces.vo;

import com.alibaba.fastjson2.annotation.JSONField;
import com.neegix.auth.application.dto.RoleDTO;
import lombok.Data;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by IntelliJ IDEA (Community Edition)
 * Thank you to JetBrains for their contributions to the vast number of developers
 *
 * @Author: kushu001
 * @Date: 2024/08/24/19:51
 * @Description:
 */
@Data
public class NebulaUserDetails implements UserDetails {

    private Long id;

    private String username;

    private String password;

    private List<String> menuPermissions;

    //存储SpringSecurity所需要的权限信息的集合
    @JSONField(serialize = false)
    private List<GrantedAuthority> authorities;

}
