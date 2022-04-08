package com.homeward.website.aop.pointcuts;

import org.aspectj.lang.annotation.Pointcut;

public class CustomExceptionAdvice {

    @Pointcut("execution(" +
            "@com.homeward.website.aop.annotations.JoinPointSymbol " +
            "com.homeward.website.bean.VO.R " +
            "com.homeward.website.controller.CartController.*(..))")
    public void orderControllerMethod() {}

    @Pointcut("execution(" +
            "@com.homeward.website.aop.annotations.JoinPointSymbol " +
            "boolean " +
            "com.homeward.website.executor.interceptor.LoginInterceptor.preHandle(..))")
    public void jsonWebTokenMethod() {}

    @Pointcut("execution(" +
            "@com.homeward.website.aop.annotations.JoinPointSymbol " +
            "com.homeward.website.bean.VO.R " +
            "com.homeward.website.controller.PlayerController.getPlayerProfile(..))")
    public void playerControllerMethod() {}
}
