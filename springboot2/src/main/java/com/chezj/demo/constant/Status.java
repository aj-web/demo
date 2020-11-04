package com.chezj.demo.constant;

import lombok.Getter;

/**
 * @description:状态码封装，本质上是一个美剧
 * @author: bangsun
 * @date: 2020/10/20 17:29
 */
@Getter
public enum Status {
    /**
     * 操作成功
     */
    OK(200, "操作成功"),
    /**
     *未知异常
     */
    UNKNOWN_ERROR(500, "服务器出错");
    /**
     * 状态码
     */
    private Integer code;
    /**
     *消息
     */
    private String message;

    Status(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

}
