package com.chezj.demo.aop;

import cn.hutool.json.JSONUtil;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;
import java.util.Objects;

/**
 * @description:
 * @author: bangsun
 * @date: 2020/9/15 15:25
 */
@Aspect
@Component
@Slf4j
public class TestAop {

    private static final String START_TIME = "request-start";

    /**
     *方法切入点
     */
    @Pointcut("execution(public * com.chezj.demo.controller.*Controller.*(..))")
    public void log() {

    }


    @Before("log()")
    public void beforeLog(JoinPoint joinPoint) {
        //根据前端请求获取方法名、参数、路径等信息,接收到请求，记录上下文
        ServletRequestAttributes attributeEvent =
                (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        //获取到request，同时进行判空操作，
        HttpServletRequest request = Objects.requireNonNull(attributeEvent).getRequest();
        log.info("【请求 URL】：{}", request.getRequestURI());
        log.info("【请求 IP】：{}", request.getRemoteAddr());
        log.info("【请求类名】：{}，【请求方法名】：{}", joinPoint.getSignature().getDeclaringTypeName(),
                joinPoint.getSignature().getName());
        Map<String, String[]> parameterMap = request.getParameterMap();
        log.info("【请求参数】：{}，", JSONUtil.toJsonStr(parameterMap));
        Long start = System.currentTimeMillis();
        request.setAttribute(START_TIME, start);
    }

    @Around("log()")
    public Object aroundLog(ProceedingJoinPoint point) throws Throwable {
        Object result = point.proceed();
        log.info("【返回值】：{}", JSONUtil.toJsonStr(result));
        return result;
    }

    @AfterReturning("log()")
    public void afterReturning() {
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = Objects.requireNonNull(attributes).getRequest();

        Long start = (Long) request.getAttribute(START_TIME);
        Long end = System.currentTimeMillis();
        log.info("【请求耗时】：{}毫秒", end - start);

        //String header = request.getHeader("User-Agent");
        // UserAgent userAgent = UserAgent.parseUserAgentString(header);
        //log.info("【浏览器类型】：{}，【操作系统】：{}，【原始User-Agent】：{}", userAgent.getBrowser().toString(), userAgent
        // .getOperatingSystem().toString(), header);
    }

}
