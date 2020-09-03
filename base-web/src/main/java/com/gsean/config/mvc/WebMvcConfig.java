package com.gsean.config.mvc;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * ProjectName：sys_admin_backend
 * ClassName：WebMvcConfig
 * Description：TODO
 * Date：2020/8/31 14:54
 * Author：GSean
 * Version: 1.0
 */
@Configuration
public class WebMvcConfig extends WebMvcConfigurerAdapter {
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/index").setViewName("index");
        registry.addViewController("/test").setViewName("test");
        registry.addViewController("/403").setViewName("403");
    }

}
