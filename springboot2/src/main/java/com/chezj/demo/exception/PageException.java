package com.chezj.demo.exception;

import com.chezj.demo.constant.Status;
import lombok.Getter;

/**
 * @description:
 * @author: bangsun
 * @date: 2020/11/4 14:05
 */
@Getter
public class PageException extends BaseException {
    public PageException(Status status) {
        super(status);
    }

    public PageException(Integer code, String message) {
        super(code, message);
    }
}




