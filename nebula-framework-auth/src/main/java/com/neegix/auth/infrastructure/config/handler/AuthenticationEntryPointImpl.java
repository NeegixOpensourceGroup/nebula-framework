package com.neegix.auth.infrastructure.config.handler;

import com.neegix.result.Result;
import com.neegix.utils.WebUtils;
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
        String errorMessage = "";
        if (authException instanceof BadCredentialsException) {
            errorMessage = authException.getMessage();
            // 处理错误的凭据异常
        } else if (authException instanceof LockedException) {
            errorMessage = "账户被锁定";
            // 处理账户锁定异常
        } else if (authException instanceof DisabledException) {
            errorMessage = "账户被禁用";
            // 处理账户禁用异常
        } else if (authException instanceof CredentialsExpiredException) {
            errorMessage = "凭据过期";
            // 处理凭据过期异常
        } else if (authException instanceof InsufficientAuthenticationException) {
           errorMessage = "访问这个资源需要完整的认证";
        } else {
            errorMessage = "其他认证异常";
            // 通用处理
        }
        Result<?> result = Result.failure(HttpStatus.FORBIDDEN.value(), errorMessage);
        WebUtils.renderString(response, result);
    }
}
