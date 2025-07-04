package com.neegix.auth.infrastructure.config.filter;

import com.github.benmanes.caffeine.cache.Cache;
import com.neegix.inferfaces.vo.CurrentUser;
import com.neegix.inferfaces.result.Result;
import com.neegix.infrastructure.utils.JWTUtils;
import com.neegix.infrastructure.utils.WebUtils;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

/**
 * Created by IntelliJ IDEA (Community Edition)
 * Thank you to JetBrains for their contributions to the vast number of developers
 *
 * @Author: kushu001
 * @Date: 2024/08/23/16:21
 * @Description:
 */
@Component
public class SecurityFilter extends OncePerRequestFilter {
    @Autowired
    private Cache<String, Object> caffeineCache;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        String bearerToken = request.getHeader("Authorization");
        if (!StringUtils.hasText(bearerToken)){
            filterChain.doFilter(request, response);
            return;
        }

        String[] tokenArray = bearerToken.split(" ");

        Long userId = JWTUtils.decode(tokenArray[1]);

        CurrentUser currentUser = (CurrentUser)caffeineCache.asMap().get("user_" + userId);

        // 如果用户失效，则验证失败
        if (currentUser == null){
            WebUtils.renderString(response, Result.failure(HttpStatus.UNAUTHORIZED.value(), "凭证过期！"));
            //filterChain.doFilter(request, response);
            return;
        }
        //TODO 否则 重置生效时间(需引入redis)

        UsernamePasswordAuthenticationToken authenticationToken =
                new UsernamePasswordAuthenticationToken(currentUser,null, currentUser.getAuthorities());
        SecurityContextHolder.getContext().setAuthentication(authenticationToken);
        filterChain.doFilter(request, response);
    }
}
