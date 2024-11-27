package com.neegix.auth.interfaces.controller;

import com.neegix.auth.application.service.AuthService;
import com.neegix.auth.interfaces.vo.NebulaUserDetails;
import com.neegix.result.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by IntelliJ IDEA (Community Edition)
 * Thank you to JetBrains for their contributions to the vast number of developers
 *
 * @Author: kushu001
 * @Date: 2024/08/22/18:38
 * @Description:
 */
@RestController
@RequestMapping("/api/v1")
public class AuthController {

    @Autowired
    private AuthService authService;

    @PostMapping("/login")
    public Result<?> login(@RequestParam("username") String username, @RequestParam("password") String password){
        authService.login(username, password);
        return Result.success("登录成功");
    }

    @PostMapping("/register")
    public Result<?> register(@RequestParam("username") String username, @RequestParam("password") String password){
        return Result.success("注册成功");
    }

    @GetMapping("/access")
    @PreAuthorize("hasAuthority('system:menu:access')")
    public Result<List<String>> access(){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        List<String> authorities = null;
        Object principal = authentication.getPrincipal();
        if (principal instanceof NebulaUserDetails nebulaUserDetails){
            authorities = nebulaUserDetails.getMenuPermissions();
        }
        return Result.success("权限获取成功", authorities);
    }
}
