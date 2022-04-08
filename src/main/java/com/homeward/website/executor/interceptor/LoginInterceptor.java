package com.homeward.website.executor.interceptor;

import com.homeward.website.aop.annotations.JoinPointSymbol;
import com.homeward.website.enums.StatusEnum;
import com.homeward.website.util.CommonUtils;
import com.homeward.website.util.JwtUtils;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component
public class LoginInterceptor implements HandlerInterceptor {

    @Override
    @JoinPointSymbol
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {
        if ((request.getHeader("Authorization") == null)) {
            CommonUtils.throwRuntimeException(StatusEnum.JWT_NOT_FOUND);
        }
        if (!JwtUtils.verity()) {
            CommonUtils.throwRuntimeException(StatusEnum.USER_UNVERIFIED);
        }
        return true;
    }
}
