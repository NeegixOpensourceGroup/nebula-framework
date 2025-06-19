package com.neegix.utils;

import jakarta.servlet.http.HttpServletRequest;

/**
 * Created by IntelliJ IDEA (Community Edition)
 * Thank you to JetBrains for their contributions to the vast number of developers
 *
 * @Author: kushu001
 * @Date: 2025/01/15/11:56
 * @Description:
 */
public class PlatformTypeUtil {
    public static Integer getClientType(HttpServletRequest request) {
        String userAgent = request.getHeader("User-Agent");

        if (userAgent != null) {
            userAgent = userAgent.toLowerCase();

            if (userAgent.contains("mobile") || userAgent.contains("android") || userAgent.contains("iphone")) {
                return 1; // "Mobile"
            } else if (userAgent.contains("windows") || userAgent.contains("mac") || userAgent.contains("linux")) {
                return 2; //"Windows PC"
            } else {
                return 0; //"Unknown"
            }
        } else {
            return 0; //"Unknown"
        }
    }
}
