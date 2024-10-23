package com.li.interceptor;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.net.ssl.HandshakeCompletedEvent;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginInterceptor extends HandlerInterceptorAdapter {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

//        判断session是否为空
        if (request.getSession().getAttribute("user") == null) {
//            重定向
            response.sendRedirect("/admin");
            return false;
        }

        return true;
    }
}
