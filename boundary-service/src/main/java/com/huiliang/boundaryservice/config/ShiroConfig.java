package com.huiliang.boundaryservice.config;

import com.huiliang.boundaryservice.filter.JWTFilter;
import com.huiliang.boundaryservice.realm.JWTRealm;
import org.apache.shiro.mgt.DefaultSessionStorageEvaluator;
import org.apache.shiro.mgt.DefaultSubjectDAO;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.spring.LifecycleBeanPostProcessor;
import org.apache.shiro.spring.security.interceptor.AuthorizationAttributeSourceAdvisor;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.aop.framework.autoproxy.DefaultAdvisorAutoProxyCreator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;

import javax.servlet.Filter;
import java.util.HashMap;
import java.util.Map;

@Configuration
public class ShiroConfig {
    @Bean("JWTRealm")
    public JWTRealm getJWTRealm(){
        return new JWTRealm();
    }

    @Bean("SecurityManager")
    public SecurityManager getManager(){
        DefaultWebSecurityManager securityManager=new DefaultWebSecurityManager();
        securityManager.setRealm(getJWTRealm());
        DefaultSubjectDAO dao=new DefaultSubjectDAO();
        DefaultSessionStorageEvaluator sessionStorageEvaluator=new DefaultSessionStorageEvaluator();
        sessionStorageEvaluator.setSessionStorageEnabled(false);
        dao.setSessionStorageEvaluator(sessionStorageEvaluator);
        securityManager.setSubjectDAO(dao);
        return securityManager;
    }
    @Bean("JWTFilter")
    public ShiroFilterFactoryBean factory(SecurityManager manager){
        ShiroFilterFactoryBean factoryBean=new ShiroFilterFactoryBean();
        //必须设置给FactoryBean设置securityManager
        factoryBean.setSecurityManager(getManager());
        //添加自己的过滤器
        Map<String,Filter> filterMap=new HashMap<>();
        filterMap.put("authentication",new JWTFilter());
        factoryBean.setFilters(filterMap);
        //自定义过滤规则
        Map<String,String> ruleMap=new HashMap<>();
        ruleMap.put("/**","authentication");
        ruleMap.put("/logout","logout");
        factoryBean.setFilterChainDefinitionMap(ruleMap);
        return factoryBean;
    }
    @Bean
    public LifecycleBeanPostProcessor lifecycleBeanPostProcessor() {
        return new LifecycleBeanPostProcessor();
    }

    /**
     * 开启Shiro的注解(如@RequiresRoles,@RequiresPermissions),需借助SpringAOP扫描使用Shiro注解的类,并在必要时进行安全逻辑验证 * 配置以下两个bean(DefaultAdvisorAutoProxyCreator(可选)和AuthorizationAttributeSourceAdvisor)即可实现此功能 * @return
     */
    @Bean
    @DependsOn({"lifecycleBeanPostProcessor"})
    public DefaultAdvisorAutoProxyCreator advisorAutoProxyCreator() {
        DefaultAdvisorAutoProxyCreator advisorAutoProxyCreator = new DefaultAdvisorAutoProxyCreator();
        advisorAutoProxyCreator.setProxyTargetClass(true);
        return advisorAutoProxyCreator;
    }

    @Bean
    public AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor(SecurityManager securityManager) {
        AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor = new AuthorizationAttributeSourceAdvisor();
        authorizationAttributeSourceAdvisor.setSecurityManager(securityManager);
        return authorizationAttributeSourceAdvisor;
    }}
