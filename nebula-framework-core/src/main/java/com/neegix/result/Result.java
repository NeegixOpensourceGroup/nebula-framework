package com.neegix.result;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

import java.io.Serial;
import java.io.Serializable;

/**
 * Created by IntelliJ IDEA (Community Edition)
 * Thank you to JetBrains for their contributions to the vast number of developers
 *
 * @Author: kushu001
 * @Date: 2024/08/25/20:29
 * @Description:
 */
@JsonInclude(value= JsonInclude.Include.NON_NULL)
@Data
@Slf4j
public class Result<T> implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    private int code; // 状态码
    private String message; // 描述信息或错误消息
    private T data; // 响应数据


    // 工具方法
    public static <T> Result<T> success() {
        return success("操作成功！");
    }

    public static <T> Result<T> success(String msg) {
        return success(msg, null);
    }

    public static <T> Result<T> success(String message, T data) {
        Result<T> result = new Result<>();
        result.setCode(200);
        result.setMessage(message);
        result.setData(data);
        return result;
    }

    public static <T> Result<T> failure() {
        return failure( "操作失败！");
    }

    public static <T> Result<T> failure(String message) {
        return failure(500, message);
    }

    public static <T> Result<T> failure(int code, String message) {
        return failure(code, message, null);
    }


    public static <T> Result<T> failure(int code, String message, Exception e) {
        if (null != e){
            log.error(message, e);
        }
        Result<T> result = new Result<>();
        result.setCode(code);
        result.setMessage(message);
        return result;
    }
}
