package com.neegix.infrastructure.utils;

import jakarta.servlet.http.HttpServletRequest;

/**
 * Created by IntelliJ IDEA (Community Edition)
 * Thank you to JetBrains for their contributions to the vast number of developers
 *
 * @Author: kushu001
 * @Date: 2025/01/15/12:17
 * @Description:
 */
public class ClientInfoUtil {
    public static String getClientInfo(HttpServletRequest request) {
        String userAgent = request.getHeader("User-Agent");

        if (userAgent != null) {
            userAgent = userAgent.toLowerCase();

            if (userAgent.contains("msie") || userAgent.contains("trident")) {
                return "Internet Explorer";
            } else if (userAgent.contains("edg")) {
                return "Microsoft Edge";
            } else if (userAgent.contains("chrome")) {
                return "Google Chrome";
            } else if (userAgent.contains("firefox")) {
                return "Mozilla Firefox";
            } else if (userAgent.contains("safari")) {
                if (userAgent.contains("chrome")) {
                    return "Google Chrome"; // Chrome 的 User-Agent 中也包含 Safari
                } else {
                    return "Apple Safari";
                }
            } else if (userAgent.contains("opera")) {
                return "Opera";
            } else {
                return "Unknown Browser";
            }
        } else {
            return "Unknown Browser";
        }
    }
}
