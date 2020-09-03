package com.gsean.controller;

import com.gsean.constant.JwtConstant;
import com.gsean.domain.Result;
import com.gsean.entity.TUser;
import com.gsean.enums.HttpReturnEnum;
import com.gsean.service.LoginService;
import com.gsean.service.impl.TUserServiceImpl;
import com.gsean.util.JWTUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;

/**
 * ProjectName：sys_admin_backend
 * ClassName：LoginController
 * Description：TODO
 * Date：2020/8/31 15:24
 * Author：GSean
 * Version: 1.0
 */
@RestController
public class LoginController {
    @Autowired
    private LoginService loginService;
    @Autowired
    private TUserServiceImpl tUserService;


    /**
     * 提交登录
     * @param username
     * @param password
     * @return
     */
    @PostMapping(value = "/login")
    public Result login(String username, String password, HttpServletResponse response) {
        TUser user = tUserService.selectByUserName(username);
        if(user==null||!password.equals(user.getPassword())){
            return Result.failure(HttpReturnEnum.USER_PASSWROD_EROOR);
        }
        String token = JWTUtil.createToken(username);
        response.setHeader(JwtConstant.JWT_TOKEN,token);
        return Result.successMessage(token);
    }
}
