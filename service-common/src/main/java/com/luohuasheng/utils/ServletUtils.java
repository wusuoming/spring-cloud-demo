package com.luohuasheng.utils;

import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ServletUtils {

    public static ServletRequestAttributes attributes() {
        return (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
    }

    public static HttpServletRequest request() {
        return attributes().getRequest();
    }

    public static HttpServletResponse response() {
        return attributes().getResponse();
    }

}
