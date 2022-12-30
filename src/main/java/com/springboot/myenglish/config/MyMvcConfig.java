package com.springboot.myenglish.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class MyMvcConfig implements WebMvcConfigurer {
    //Chuyển trang
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/admin/main").setViewName("admin/main");
        registry.addViewController("/toAdmin").setViewName("admin/index");
    }

    //Chặn tất cả, giải phóng một phần của đường dẫn
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new LoginHandlerInterceptor())
                .addPathPatterns("/**")
                .excludePathPatterns("/static/**", "/index.html", "/toAdmin", "/admin");
    }
}

