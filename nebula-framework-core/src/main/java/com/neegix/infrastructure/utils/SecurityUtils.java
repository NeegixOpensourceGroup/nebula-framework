package com.neegix.infrastructure.utils;

import com.neegix.inferfaces.vo.CurrentUser;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

/**
 * Created by IntelliJ IDEA (Community Edition)
 * Thank you to JetBrains for their contributions to the vast number of developers
 *
 * @Author: kushu001
 * @Date: 2025/03/26/13:49
 * @Description:
 */
public class SecurityUtils {
    private static Authentication getAuthentication() {
        return SecurityContextHolder.getContext().getAuthentication();
    }

    public static <T> T getCurrentUser(Class<T> clazz) {
        Authentication authentication = getAuthentication();
        if (authentication != null) {
            Object principal = authentication.getPrincipal();
            if (clazz.isInstance(principal)) {
                return clazz.cast(principal);
            }
        }
        return null;
    }

    public static CurrentUser getCurrentUser() {
        Authentication authentication = getAuthentication();
        if (authentication != null && authentication.getPrincipal() instanceof CurrentUser userDetails) {
            return userDetails;
        }
        return null;
    }

}
