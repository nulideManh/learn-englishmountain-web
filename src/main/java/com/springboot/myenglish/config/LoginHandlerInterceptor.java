package com.springboot.myenglish.config;

import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginHandlerInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception
    {
        //Sau khi đăng nhập thành công, sẽ tới session của người dùng.
        Object loginUser = request.getSession().getAttribute("loginUser");
        if (loginUser == null){
            request.setAttribute("msg","Không được phép, vui lòng đăng nhập trước");
            request.getRequestDispatcher("/toAdmin").forward(request,response);
            return false;
        }else
            return true;
    }
}
