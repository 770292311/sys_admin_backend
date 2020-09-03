package com.gsean.config.aop;

import com.alibaba.fastjson.JSON;
import com.gsean.constant.JwtConstant;
import com.gsean.util.JWTUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.ObjectUtils;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;

/**
 * ProjectName：lottery_backend
 * ClassName：LogAspect
 * Description：TODO
 * Date：2020/7/24 10:36
 * Author：GSean
 * Version: 1.0
 */
@Slf4j
@Aspect
@Component
public class LogAspect {
    //用来记录请求进入的时间，防止多线程时出错，这里用了ThreadLocal
    ThreadLocal<Long> startTime = new ThreadLocal<>();
    /**
     * 定义切入点，controller下面的所有类的所有公有方法，这里需要更改成自己项目的
     */
    @Pointcut("execution(public * com.gsean.controller..*.*(..))")
    public void requestLog(){};

    /**
     * 方法之前执行，日志打印请求信息
     * @param joinPoint joinPoint
     */
    @Before("requestLog()")
    public void doBefore(JoinPoint joinPoint) {
        startTime.set(System.currentTimeMillis());
        ServletRequestAttributes servletRequestAttributes = (ServletRequestAttributes) RequestContextHolder.currentRequestAttributes();
        HttpServletRequest request = servletRequestAttributes.getRequest();
        //打印当前的请求路径
        log.warn("==========请求开始===========");
        log.info("本次RequestMapping:[{},{}]",request.getRequestURI(),request.getMethod());


        //这里是从token中获取用户信息，打印当前的访问用户，代码不通用
        String token = request.getHeader(JwtConstant.JWT_TOKEN);
        if (ObjectUtils.isNotEmpty(token)) {
            String username = JWTUtil.getUsername(token);
            log.info("Current User is:[{}]",username);
        }
        //打印请求参数，如果需要打印其他的信息可以到request中去拿
        log.info("RequestParam:{}", Arrays.toString(joinPoint.getArgs()));
    }

    /**
     * 方法返回之前执行，打印才返回值以及方法消耗时间
     * @param response 返回值
     */
    @AfterReturning(returning = "response",pointcut = "requestLog()")
    public void doAfterRunning(Object response) {
        //打印返回值信息
        log.info("Response:[{}]", JSON.toJSONString(response) );
        //打印请求耗时
        log.info("Request spend times : [{}ms]",System.currentTimeMillis()-startTime.get());
        log.warn("===========请求结束============");
    }


}
