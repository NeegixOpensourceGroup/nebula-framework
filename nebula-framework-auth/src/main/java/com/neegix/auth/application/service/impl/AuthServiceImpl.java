package com.neegix.auth.application.service.impl;

import com.neegix.auth.application.service.AuthService;
import com.neegix.inferfaces.vo.CurrentUser;
import com.neegix.infrastructure.utils.JWTUtils;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import com.github.benmanes.caffeine.cache.Cache;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

/**
 * Created by IntelliJ IDEA (Community Edition)
 * Thank you to JetBrains for their contributions to the vast number of developers
 *
 * @Author: kushu001
 * @Date: 2024/08/27/21:31
 * @Description:
 */
@Service
public class AuthServiceImpl implements AuthService {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private HttpServletResponse httpServletResponse;

    @Autowired
    private Cache<String, Object> caffeineCache;

    @Override
    public void login(String username, String password) {
        // 传入用户名和密码
        UsernamePasswordAuthenticationToken usernamePassword = new UsernamePasswordAuthenticationToken(username,password);

        //是实现登录逻辑，此时就回去调用LoadUserByUsername方法
        Authentication authenticate = authenticationManager.authenticate(usernamePassword);

        // 获取返回的用户信息
        CurrentUser currentUser = (CurrentUser)authenticate.getPrincipal();

        // 生成jwt token
        String token = JWTUtils.encode(currentUser.getId());

        // 设置响应头 token
        httpServletResponse.setHeader("Authorization","Bearer " + token);
        caffeineCache.put("access_token_" + currentUser.getId(), token);
        caffeineCache.put("user_" + currentUser.getId(), currentUser);
    }
}
