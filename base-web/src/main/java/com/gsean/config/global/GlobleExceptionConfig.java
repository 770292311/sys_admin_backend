package com.gsean.config.global;

import com.gsean.domain.Result;
import com.gsean.enums.HttpReturnEnum;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.ShiroException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * ProjectName：lottery
 * ClassName：GlobleExceptionConfig
 * Description：TODO web全局异常处理机制
 * Date：2020/7/16 10:53
 * Author：GSean
 * Version: 1.0
 */
@RestControllerAdvice
@Slf4j
public class GlobleExceptionConfig {
    /**
     * shiro异常，包括认证和授权
     * @return
     */
    @ExceptionHandler(ShiroException.class)
    public Result noAuthEx(Exception e) {
        e.printStackTrace();
        return Result.failure(HttpReturnEnum.NO_AUTH);
    }

    /**
     * 全局异常处理
     * @return
     */
    @ExceptionHandler(Exception.class)
    public Result handleEx(Exception e) {
        e.printStackTrace();
        return Result.failure(HttpReturnEnum.SYS_EROOR);
    }


}
