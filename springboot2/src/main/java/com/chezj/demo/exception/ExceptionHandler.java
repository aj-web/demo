package com.chezj.demo.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.servlet.ModelAndView;

/**
 * @description:
 * @author: bangsun
 * @date: 2020/11/4 14:11
 */
@ControllerAdvice
@Slf4j
public class ExceptionHandler {
    public static final String DEFAULT_ERROR_VIEW = "error";

/**
 * @description:统一页面异常处理
 * @author: bangsun
 * @date: 2020/11/4 14:17
 No such property: code for class: Script1
 * @return: org.springframework.web.servlet.ModelAndView
 */
    public ModelAndView pageErrorHandler(PageException exception) {
        log.error("【DemoPageException】:{}", exception.getMessage());
        ModelAndView view = new ModelAndView();
        view.addObject("message", exception.getMessage());
        view.setViewName(DEFAULT_ERROR_VIEW);
        return view;
    }


}
