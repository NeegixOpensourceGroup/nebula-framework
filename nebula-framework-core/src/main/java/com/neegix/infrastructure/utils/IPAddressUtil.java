package com.neegix.utils;

import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.lionsoul.ip2region.xdb.Searcher;
import org.springframework.core.io.ClassPathResource;
import org.springframework.util.FileCopyUtils;

import java.io.InputStream;
import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * Created by IntelliJ IDEA (Community Edition)
 * Thank you to JetBrains for their contributions to the vast number of developers
 *
 * @Author: kushu001
 * @Date: 2024/12/19/15:48
 * @Description: IP地址工具
 */
@Slf4j
public class IPAddressUtil {
    private static Searcher searcher;

    /**
     * 在 Nginx 等代理之后获取用户真实 IP 地址
     * @return 用户的真实 IP 地址
     */
    public static String getIpAddress(HttpServletRequest request) {
        if (request == null) {
            return null;
        }
        String ip = request.getHeader("x-forwarded-for");
        if (isIpaddress(ip)) {
            ip = request.getHeader("Proxy-Client-IP");
        }
        if (isIpaddress(ip)) {
            ip = request.getHeader("WL-Proxy-Client-IP");
        }
        if (isIpaddress(ip)) {
            ip = request.getHeader("HTTP_CLIENT_IP");
        }
        if (isIpaddress(ip)) {
            ip = request.getHeader("HTTP_X_FORWARDED_FOR");
        }
        if (isIpaddress(ip)) {
            ip = request.getRemoteAddr();
            if ("127.0.0.1".equals(ip) || "0:0:0:0:0:0:0:1".equals(ip)) {
                //根据网卡取本机配置的IP
                try {
                    InetAddress inet = InetAddress.getLocalHost();
                    ip = inet.getHostAddress();
                } catch (UnknownHostException e) {
                    log.error(e.getMessage());
                }
            }
        }
        return ip;
    }

    /**
     * 判断是否为 IP 地址
     * @param ip  IP 地址
     */
    public static boolean isIpaddress(String ip) {
        return ip == null || ip.isEmpty() || "unknown".equalsIgnoreCase(ip);
    }

    /**
     * 获取本地 IP 地址
     * @return 本地 IP 地址
     */
    public static String getHostIp() {
        try {
            return InetAddress.getLocalHost().getHostAddress();
        } catch (UnknownHostException e) {
            log.error(e.getMessage());
        }
        return "127.0.0.1";
    }

    /**
     * 获取主机名
     * @return 本地主机名
     */
    public static String getHostName() {
        try {
            return InetAddress.getLocalHost().getHostName();
        } catch (UnknownHostException e) {
            log.error(e.getMessage());
        }
        return "未知";
    }

    /**
     * 根据 IP 地址返回归属地，国内返回但省份，国外返回到国家
     * @param ip IP 地址
     * @return IP 归属地
     */
    public static IPInfo getIpRegion(String ip) {
        initIp2regionResource();
        String searchIpInfo = getCityInfo(ip);
        //-------------------------------------------------------
        //searchIpInfo 的数据格式： 国家|区域|省份|城市|ISP
        //192.168.31.160 0|0|0|内网IP|内网IP
        //47.52.236.180 中国|0|香港|0|阿里云
        //220.248.12.158 中国|0|上海|上海市|联通
        //164.114.53.60 美国|0|华盛顿|0|0
        //-------------------------------------------------------
        assert searchIpInfo != null;
        String[] splitIpInfo = searchIpInfo.split("\\|");

        //        //--------------国内属地返回省份--------------
//        if ("中国".equals(cityInfo.get("country"))){
//            return cityInfo.get("province");
//        }
//        //------------------内网 IP----------------
//        if ("0".equals(cityInfo.get("country"))){
//            if ("内网IP".equals(cityInfo.get("ISP"))){
//                return "";
//            }
//            else return "";
//        }
//        //--------------国外属地返回国家--------------
//        else {
//            return cityInfo.get("country");
//        }

        return new IPInfo(ip, splitIpInfo[0], splitIpInfo[1], splitIpInfo[2], splitIpInfo[3], splitIpInfo[4]);
    }
    private static void initIp2regionResource() {
        try {
            InputStream inputStream = new ClassPathResource("/ip2region.xdb").getInputStream();
            byte[] dbBinStr = FileCopyUtils.copyToByteArray(inputStream);
            // 创建一个完全基于内存的查询对象
            searcher = Searcher.newWithBuffer(dbBinStr);
        } catch (Exception e) {
            log.error(e.getMessage());
        }
    }

    public static String getCityInfo(String ip) {
        try {
            return searcher.search(ip);
        } catch (Exception e) {
            log.error(e.getMessage());
        }
        return null;
    }
}
