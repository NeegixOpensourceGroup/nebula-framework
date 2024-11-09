package com.neegix.development.interfaces.controller;

import com.neegix.result.Result;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by IntelliJ IDEA (Community Edition)
 * Thank you to JetBrains for their contributions to the vast number of developers
 *
 * @Author: kushu001
 * @Date: 2024/10/31/14:37
 * @Description:
 */
@RestController
@RequestMapping("/api/v1/menu")
public class MenuController {
    @GetMapping
    public Result<?> getMenu(){
        return Result.success("hello");
    }
}
