package com.gsean.service;

import com.gsean.domain.Result;
import com.gsean.entity.TUser;
import com.gsean.util.JWTUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Service;

/**
 * ProjectName：sys_admin_backend
 * ClassName：LoginService
 * Description：TODO
 * Date：2020/8/31 16:11
 * Author：GSean
 * Version: 1.0
 */
@Service
@Slf4j
public class LoginService {
    protected TUser getProfile() {
        Subject subject = SecurityUtils.getSubject();
        return (TUser) subject.getPrincipal();
    }


    public Result<TUser> executeLogin(String username,String password){
        Result<TUser> ret = Result.failure("登录失败");

        if (StringUtils.isAnyBlank(username, password)) {
            return ret;
        }
        UsernamePasswordToken token = new UsernamePasswordToken(username, password);
        try {
            SecurityUtils.getSubject().login(token);
            ret = Result.success(JWTUtil.createToken(username),null);
        } catch (UnknownAccountException e) {
            log.error(e.getMessage());
            ret = Result.failure("用户不存在");
        } catch (LockedAccountException e) {
            log.error(e.getMessage());
            ret = Result.failure("用户被禁用");
        } catch (AuthenticationException e) {
            log.error(e.getMessage());
            ret = Result.failure("用户认证失败");
        }
        return ret;

    }

}
