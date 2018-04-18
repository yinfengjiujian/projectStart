package com.leecx.interceptors.config;

import com.leecx.interceptors.interceptor.OneInterceptor;
import com.leecx.interceptors.interceptor.TwoInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
public class WebMvcConfigurer extends WebMvcConfigurerAdapter{

    /**
     * <p>Title:</p>
     * <p>Description:重写增加自定义拦截器的注册，某一个拦截器需要先注册进来，才能工作</p>
     * param[1]: null
     * return:
     * exception:
     * date:2018/4/18 0018 下午 17:29
     * author:段美林[duanml@neusoft.com]
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {

        registry.addInterceptor(new OneInterceptor()).addPathPatterns("/one/**");

        registry.addInterceptor(new TwoInterceptor()).addPathPatterns("/one/**")
                                                     .addPathPatterns("/two/**");

        super.addInterceptors(registry);
    }
}
