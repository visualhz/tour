package com.gxu.tour.config;

import com.gxu.tour.Interceptor.LoginHandlerInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.*;

@Configuration
public class MvcConfig implements WebMvcConfigurer {

    //放行静态资源和/login,/loginCheck,其他的都拦截。
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        InterceptorRegistration addInterceptor = registry.addInterceptor(new LoginHandlerInterceptor());
        addInterceptor.excludePathPatterns("/assets/**");
        addInterceptor.excludePathPatterns("/login");
        addInterceptor.excludePathPatterns("/loginCheck");
        addInterceptor.excludePathPatterns("/Lfm/GetRecDataOfRoute");
        addInterceptor.excludePathPatterns("/Lfm/GetRecDataOfRouteByTop");
        addInterceptor.excludePathPatterns("/Lfm/GetRecDataOfScene");
        addInterceptor.excludePathPatterns("/Lfm/GetRecDataOfSceneByTop");
        addInterceptor.addPathPatterns("/**");
    }
}
