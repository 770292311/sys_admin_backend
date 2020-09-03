package com.gsean.enums;

import lombok.AllArgsConstructor;

/**
 * ProjectName：sys_admin_backend
 * ClassName：HttpReturnEnum
 * Description：TODO
 * Date：2020/9/1 16:56
 * Author：GSean
 * Version: 1.0
 */
@AllArgsConstructor
public enum HttpReturnEnum {
    NOT_LOGIN(1001,"尚未登陆，请登陆"),
    NO_AUTH(1002,"无权限访问"),
    TOKEN_VERIFY_EROOR(1003,"token验证失败"),
    USER_PASSWROD_EROOR(1004,"用户名密码错误"),
    SYS_EROOR(1005,"系统异常");







    private int code;
    private String msg;

    public int getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }
}
