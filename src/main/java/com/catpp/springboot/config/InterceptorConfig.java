package com.catpp.springboot.config;

import com.catpp.springboot.interceptor.AccessInterceptor;
import com.catpp.springboot.interceptor.ErrorInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * com.catpp.springboot.config
 *
 * @Author cat_pp
 * @Date 2018/8/30
 * @Description 拦截器配置类
 */
//@Configuration
public class InterceptorConfig extends WebMvcConfigurerAdapter {

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new AccessInterceptor()).addPathPatterns("/*");
        registry.addInterceptor(new ErrorInterceptor()).addPathPatterns("/*");
        super.addInterceptors(registry);
    }
}
