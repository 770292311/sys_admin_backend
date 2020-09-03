package com.gsean.config.shiro.realm;

import cn.hutool.core.collection.CollectionUtil;
import com.alibaba.fastjson.JSON;
import com.gsean.domain.JWTToken;
import com.gsean.entity.UserPermissionResp;
import com.gsean.service.impl.TUserServiceImpl;
import com.gsean.util.JWTUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.ObjectUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.*;
import java.util.stream.Collectors;

/**
 * ProjectName：myspringboot
 * ClassName：ShiroRealm
 * Description：TODO
 * Date：2020/6/22 12:00
 * Author：GSean
 * Version: 1.0
 */
@Slf4j
public class ShiroRealm extends AuthorizingRealm {
    @Autowired
    private TUserServiceImpl userService;

    /**
     * 这个一定要加，不然自定义过滤器不生效
     * @param token
     * @return
     */
    @Override
    public boolean supports(AuthenticationToken token) {
        return token instanceof JWTToken;
    }

    /**
     * @MethodName: doGetAuthorizationInfo
     * @Description: TODO 授权    获取用户角色和权限
     * @Param principalCollection
     * @Return: org.apache.shiro.authz.AuthorizationInfo
     * @Date: 2020/6/22 12:01
     * @Auther: GSean
     *
    */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        String userName = JWTUtil.getUsername(principals.toString());
        log.warn("开始获取用户{}权限----------doGetAuthorizationInfo",userName);
        SimpleAuthorizationInfo simpleAuthorizationInfo = new SimpleAuthorizationInfo();
        Map<String,Object> map=new HashMap<>();
        map.put("userName",userName);
        List<UserPermissionResp> userPermissionResps = userService.selectUserPermissions(map);
        /**
         * 1.获取用户角色集
         */
        Set<String> roleSet = userPermissionResps.stream()
                .map(UserPermissionResp::getRoleName)
                .filter(ObjectUtils::isNotEmpty)
                .collect(Collectors.toSet());
        if(CollectionUtil.isNotEmpty(roleSet)){
            simpleAuthorizationInfo.setRoles(roleSet);
        }
        /**
         * 2.获取用户权限集
         */
        Set<String> permissionSet = userPermissionResps.stream()
                .map(UserPermissionResp::getEnName)
                .filter(ObjectUtils::isNotEmpty)
                .collect(Collectors.toSet());
        if(CollectionUtil.isNotEmpty(permissionSet)){
            simpleAuthorizationInfo.setStringPermissions(permissionSet);
        }
        log.info("用户{}的权限信息：{}",userName, JSON.toJSONString(simpleAuthorizationInfo));
        return simpleAuthorizationInfo;
    }
    /**
     * @MethodName: doGetAuthenticationInfo
     * @Description: TODO 认证
     * @Param authenticationToken
     * @Return: org.apache.shiro.authc.AuthenticationInfo
     * @Date: 2020/6/22 12:01
     * @Auther: GSean
     *
    */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        log.warn("----------开始身份认证------------doGetAuthenticationInfo");
        String token = (String) authenticationToken.getCredentials();
        // 解密获得username，用于和数据库进行对比
        String username = JWTUtil.getUsername(token);
        if (username == null || !JWTUtil.verify(token, username)) {
            throw new AuthenticationException("token认证失败！");
        }
        return new SimpleAuthenticationInfo(token, token, "my_realm");

    }


}
