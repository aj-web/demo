package com.chezj.demo.constant;

/**
 * @description:
 * @author: bangsun
 * @date: 2020/10/20 17:29
 */
public enum Status {
    OK(200, "操作成功"),

    UNKNOWN_ERROR(500, "服务器出错");

    private Integer code;
    private String message;

    Status(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

}
