package com.gsean;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import tk.mybatis.spring.annotation.MapperScan;

/**
 * ProjectName：sys_admin_backend
 * ClassName：BaseWebApplication
 * Description：TODO
 * Date：2020/8/31 10:06
 * Author：GSean
 * Version: 1.0
 */
@SpringBootApplication
@MapperScan(basePackages = {"com.gsean.dao"})
public class BaseWebApplication {
    public static void main(String[] args) {
        SpringApplication.run(BaseWebApplication.class,args);
    }
}
