package com.homeward.website.util;

import com.homeward.website.consts.SystemConst;

import javax.servlet.http.Cookie;

public class CookieUtils {

    public static Cookie generate(String key, String value) {
        Cookie cookie = new Cookie(key, value);
        cookie.setPath("/");
        // cookie.setDomain(SystemConst.PROJECT_DOMAIN.value());
        // cookie.setSecure(true);
        // cookie.setHttpOnly(true);
        cookie.setMaxAge(604800);
        return cookie;
    }

    public static Cookie generate(String key, String value, String path) {
        Cookie cookie = new Cookie(key, value);
        cookie.setPath(path);
        cookie.setDomain(SystemConst.PROJECT_DOMAIN.value());
        cookie.setSecure(true);
        cookie.setHttpOnly(true);
        cookie.setMaxAge(604800);
        return cookie;
    }

    public static Cookie generate(String key, String value, String path, Integer age) {
        Cookie cookie = new Cookie(key, value);
        cookie.setPath(path);
        cookie.setDomain(SystemConst.PROJECT_DOMAIN.value());
        cookie.setSecure(true);
        cookie.setHttpOnly(true);
        cookie.setMaxAge(age);
        return cookie;
    }
}
