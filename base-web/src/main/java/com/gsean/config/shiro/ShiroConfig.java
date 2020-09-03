package com.gsean.config.shiro;

import com.gsean.config.shiro.filter.JWTFilter;
import com.gsean.config.shiro.realm.ShiroRealm;
import org.apache.shiro.mgt.DefaultSessionStorageEvaluator;
import org.apache.shiro.mgt.DefaultSubjectDAO;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.spring.security.interceptor.AuthorizationAttributeSourceAdvisor;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.aop.framework.autoproxy.DefaultAdvisorAutoProxyCreator;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.servlet.Filter;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * ProjectName：sys_admin_backend
 * ClassName：ShiroConfig
 * Description：TODO
 * Date：2020/8/31 15:26
 * Author：GSean
 * Version: 1.0
 */
@Configuration
@ConditionalOnProperty(name = "shiro.web.enabled", matchIfMissing = true)
public class ShiroConfig {

    /**
     * 设置过滤规则
     * @param securityManager
     * @return
     */
    @Bean
    public ShiroFilterFactoryBean shiroFilterFactoryBean(SecurityManager securityManager) {
        ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean();
        /**
         * 添加jwt过滤器
         */
        Map<String, Filter> filterMap = new LinkedHashMap<>();
        filterMap.put("jwt", new JWTFilter());
        shiroFilterFactoryBean.setFilters(filterMap);
        // 设置securityManager
        shiroFilterFactoryBean.setSecurityManager(securityManager);
//        shiroFilterFactoryBean.setUnauthorizedUrl("/401");
        LinkedHashMap<String, String> filterChainDefinitionMap = new LinkedHashMap<>();
        //所有请求通过jwt
        filterChainDefinitionMap.put("/**", "jwt");
        shiroFilterFactoryBean.setFilterChainDefinitionMap(filterChainDefinitionMap);
        return shiroFilterFactoryBean;
    }

    @Bean
    public ShiroRealm shiroRealm(){
        // 配置Realm，需自己实现
        ShiroRealm shiroRealm = new ShiroRealm();
        return shiroRealm;
    }

    /**
     * 相当于 SpringMVC 中的 DispatcherServlet 或者 Struts2 中的 FilterDispatcher。
     * 它是 Shiro 的核心，所有具体的交互都通过 SecurityManager 进行控制。
     * 它管理着所有 Subject、且负责进行认证和授权、及会话、缓存的管理。
     * @return
     */
    @Bean
    public SecurityManager securityManager(){
        // 配置SecurityManager，并注入shiroRealm
        DefaultWebSecurityManager securityManager =  new DefaultWebSecurityManager();
        securityManager.setRealm(shiroRealm());
        /**
         * 关闭shi带的session
         */
        DefaultSubjectDAO subjectDAO=new DefaultSubjectDAO();
        DefaultSessionStorageEvaluator defaultSessionStorageEvaluator = new DefaultSessionStorageEvaluator();
        defaultSessionStorageEvaluator.setSessionStorageEnabled(false);
        subjectDAO.setSessionStorageEvaluator(defaultSessionStorageEvaluator);
        securityManager.setSubjectDAO(subjectDAO);
        return securityManager;
    }





    /**
     * @MethodName: authorizationAttributeSourceAdvisor
     * @Description: TODO 授权配置
     * @Param securityManager
     * @Return: org.apache.shiro.spring.security.interceptor.AuthorizationAttributeSourceAdvisor
     * @Date: 2020/6/30 14:17
     * @Auther: GSean
     *
     */
    @Bean
    public AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor() {
        AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor = new AuthorizationAttributeSourceAdvisor();
        authorizationAttributeSourceAdvisor.setSecurityManager(securityManager());
        return authorizationAttributeSourceAdvisor;
    }
    /**
     * @MethodName: defaultAdvisorAutoProxyCreator
     * @Description: TODO 权限注解不生效需要加上这个配置bean
     * @Param
     * @Return: org.springframework.aop.framework.autoproxy.DefaultAdvisorAutoProxyCreator
     * @Date: 2020/6/30 15:43
     * @Auther: GSean
     *
     */
    @Bean
    @ConditionalOnMissingBean
    public DefaultAdvisorAutoProxyCreator defaultAdvisorAutoProxyCreator(){
        DefaultAdvisorAutoProxyCreator app=new DefaultAdvisorAutoProxyCreator();
        app.setProxyTargetClass(true);
        return app;
    }
}
