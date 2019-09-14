package com.gxu.tour.config;

import com.gxu.tour.Interceptor.LoginHandlerInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
public class MvcConfig {

    //注册拦截器，拦截除/login，/loginCheck外的所有请求。
    @Bean
    public WebMvcConfigurerAdapter webMvcConfigurerAdapter()
    {
        WebMvcConfigurerAdapter adapter = new WebMvcConfigurerAdapter() {
            @Override
            public void addInterceptors(InterceptorRegistry registry) {
                registry.addInterceptor(new LoginHandlerInterceptor()).addPathPatterns("/**")
                        .excludePathPatterns("/login","/loginCheck");
            }
        };
        return adapter;
    }
}
