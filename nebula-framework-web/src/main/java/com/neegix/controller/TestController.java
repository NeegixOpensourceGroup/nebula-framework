package com.neegix.controller;

import com.neegix.auth.interfaces.vo.NebulaUserDetails;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

/**
 * Created by IntelliJ IDEA (Community Edition)
 * Thank you to JetBrains for their contributions to the vast number of developers
 *
 * @Author: kushu001
 * @Date: 2024/08/22/15:52
 * @Description:
 */
@RestController
@RequestMapping("/api/v1")
public class TestController {
    @GetMapping("/test2")
    @PreAuthorize("hasAuthority('system:role:delete')")
    public String hello(){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        Collection<? extends GrantedAuthority> authorities =  authentication.getAuthorities();
        NebulaUserDetails userDetails = (NebulaUserDetails)authentication.getPrincipal();
        return "Hello world";
    }
}
