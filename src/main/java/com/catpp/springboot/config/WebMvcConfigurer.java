package com.catpp.springboot.config;

import com.catpp.springboot.SysIntercepter;
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
@Configuration
public class WebMvcConfigurer extends WebMvcConfigurerAdapter {
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        /**
         * 如果多个拦截器，按顺序执行
         * 拦截配置可以传String或者List<String>，可以通过配置文件配置
         */
        registry.addInterceptor(new SysIntercepter()).addPathPatterns("/*/**").
                excludePathPatterns("/exclude/interceptor");
        super.addInterceptors(registry);
    }
}
