package com.neegix.auth.infrastructure.config.handler;

import com.neegix.inferfaces.result.Result;
import com.neegix.infrastructure.utils.WebUtils;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.CredentialsExpiredException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.InsufficientAuthenticationException;
import org.springframework.security.authentication.LockedException;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import java.io.IOException;

/**
 * Created by IntelliJ IDEA (Community Edition)
 * Thank you to JetBrains for their contributions to the vast number of developers
 *
 * @Author: kushu001
 * @Date: 2024/08/28/21:48
 * @Description:
 */
@Component
@Slf4j
public class AuthenticationEntryPointImpl implements AuthenticationEntryPoint {
    @Override
    public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException authException) throws IOException, ServletException {

        String errorMessage;
        int code;

        if (authException instanceof BadCredentialsException) {
            errorMessage = "用户名或密码错误";
            code = HttpStatus.UNAUTHORIZED.value(); // 401 未授权
        } else if (authException instanceof LockedException) {
            errorMessage = "账户已被锁定，请联系管理员";
            code = HttpStatus.LOCKED.value(); // 423 锁定
        } else if (authException instanceof DisabledException) {
            errorMessage = "账户已被禁用";
            code = HttpStatus.FORBIDDEN.value(); // 403 禁止访问
        } else if (authException instanceof CredentialsExpiredException) {
            errorMessage = "密码已过期，请重置密码";
            code = HttpStatus.UNAUTHORIZED.value(); // 401 未授权
        } else if (authException instanceof InsufficientAuthenticationException) {
            errorMessage = "未提供有效身份凭证";
            code = HttpStatus.UNAUTHORIZED.value(); // 401 未授权
        } else {
            errorMessage = "认证失败，请重新登录";
            code = HttpStatus.UNAUTHORIZED.value(); // 401 未授权
        }
        Result<?> result = Result.failure(code, errorMessage);
        WebUtils.renderString(response, result);
    }
}
