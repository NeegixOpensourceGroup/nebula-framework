package com.neegix.inferfaces.vo;

import com.alibaba.fastjson2.annotation.JSONField;
import lombok.Data;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.List;

/**
 * Created by IntelliJ IDEA (Community Edition)
 * Thank you to JetBrains for their contributions to the vast number of developers
 *
 * @Author: kushu001
 * @Date: 2024/08/24/19:51
 * @Description:
 */
@Data
public class CurrentUser implements UserDetails {

    private Long id;

    private String username;

    private String password;

    private List<String> menuPermissions;

    //存储SpringSecurity所需要的权限信息的集合
    @JSONField(serialize = false)
    private List<GrantedAuthority> authorities;

}
