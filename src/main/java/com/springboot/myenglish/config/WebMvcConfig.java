package com.springboot.myenglish.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebMvcConfig implements WebMvcConfigurer {
    //Chuyển trang
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/").setViewName("index");
        registry.addViewController("/index.html").setViewName("index");
        registry.addViewController("/user/login.html").setViewName("index");
        registry.addViewController("/main.html").setViewName("main");
        registry.addViewController("/admin/main").setViewName("admin/main");
        registry.addViewController("/register.html").setViewName("user/register/page-register");
        registry.addViewController("/toforget").setViewName("user/register/page-forget");
        registry.addViewController("/toAdmin").setViewName("admin/index");
    }

    //Chặn tất cả, giải phóng một phần của đường dẫn
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new LoginHandlerInterceptor())
                .addPathPatterns("/**")
                .excludePathPatterns("/static/**", "/index.html", "/", "/login", "", "/register.html", "/register", "/user/checkCode", "/toAdmin", "/admin", "/toforget");
    }
}
