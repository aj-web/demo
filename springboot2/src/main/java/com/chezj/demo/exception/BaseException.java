package com.chezj.demo.exception;

import com.chezj.demo.constant.Status;
import lombok.EqualsAndHashCode;
import lombok.Getter;

/**
 * @description:手动编写异常的基础异常
 * @author: bangsun
 * @date: 2020/10/20 17:16
 */
@Getter
@EqualsAndHashCode(callSuper = true)
public class BaseException extends RuntimeException{
    private Integer code;
    private String message;

    public BaseException(Status status){

    }
}
