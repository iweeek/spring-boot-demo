package com.nijun.demo.aspect;

import org.aopalliance.intercept.Joinpoint;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;


/**
 * Created by IntelliJ IDEA.
 * User: nijun
 * Date: 2018/7/5
 * Time: 1:56 AM
 */
@Aspect
@Component
public class HttpAspect {

    private final static Logger LOGGER = LoggerFactory.getLogger(HttpAspect.class);

    @Pointcut("execution(public * com.nijun.demo.controller.GirlController.*(..))")
    public void log() {
    }

    @Before("log()")
    public void before(JoinPoint joinPoint) {
        ServletRequestAttributes requestAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = requestAttributes.getRequest();

        // url
        LOGGER.info("url={}", request.getRequestURL());

        // method
        LOGGER.info("method={}", request.getMethod());

        // ip
        LOGGER.info("ip={}", request.getRemoteAddr());

        // 类方法
        LOGGER.info("class_method={}", joinPoint.getSignature().getDeclaringTypeName() + "." + joinPoint.getSignature().getName());

        // 类方法
        LOGGER.info("args={}", joinPoint.getArgs());

        LOGGER.info("before");
    }

    @After("log()")
    public void after() {
        LOGGER.info("after");
    }

    // TODO 没有日志
    @AfterReturning(pointcut = "log()", returning = "returnValue")
    public void afterReturning(Object returnValue) {
        LOGGER.debug("afterReturning: " + returnValue.toString());
    }

    @Around("log()")
    public Object around(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        LOGGER.info("around 1 ");
        Object proceed = proceedingJoinPoint.proceed();
        LOGGER.info("around 2 ");
        return proceed;
    }

    @AfterThrowing("log()")
    public void afterThrowing() throws Throwable {
        LOGGER.info("afterThrowing");
    }
}
