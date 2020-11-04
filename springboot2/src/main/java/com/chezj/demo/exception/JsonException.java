package com.chezj.demo.exception;

import com.chezj.demo.constant.Status;

/**
 * @description:
 * @author: bangsun
 * @date: 2020/10/20 17:15
 */
public class JsonException extends BaseException {
    public JsonException(Status status){
        super(status);
    }

    public JsonException(Integer code, String message) {
        super(code, message);
    }
}
