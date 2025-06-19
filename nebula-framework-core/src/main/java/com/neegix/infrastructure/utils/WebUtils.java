package com.neegix.infrastructure.utils;

import com.alibaba.fastjson2.JSON;
import com.neegix.inferfaces.result.Result;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;

/**
 * Created by IntelliJ IDEA (Community Edition)
 * Thank you to JetBrains for their contributions to the vast number of developers
 *
 * @Author: kushu001
 * @Date: 2024/08/28/22:03
 * @Description:
 */
@Slf4j
public class WebUtils {

    public static void renderString( HttpServletResponse response, Result<?> result) {
        try
        {
            response.setStatus(result.getCode());
            response.setContentType("application/json");
            response.setCharacterEncoding("utf-8");
            response.getWriter().print(JSON.toJSONString(result));
        }
        catch (IOException e)
        {
            log.error("error message info: ", e);
        }
    }
}
