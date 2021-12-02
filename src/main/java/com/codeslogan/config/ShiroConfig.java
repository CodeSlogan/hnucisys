package com.codeslogan.config;

import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.LinkedHashMap;
import java.util.Map;
@Configuration
public class ShiroConfig {
    //创建realm对象
    @Bean
    public UserRealm userRealm(){
        return new UserRealm();
    }

    //DefaultWebSecurityManager：2
    @Bean(name="securityManager")
    public DefaultWebSecurityManager getDefaultWebSecurityManager(@Qualifier("userRealm") UserRealm userRealm){
        DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
        //关联UserRealm
        securityManager.setRealm(userRealm);
        return securityManager;
    }

    //shiroFilterFactoryBean：3
    @Bean
    public ShiroFilterFactoryBean getShiroFilterFactoryBean(@Qualifier("securityManager") DefaultWebSecurityManager defaultWebSecurityManager){
        ShiroFilterFactoryBean bean = new ShiroFilterFactoryBean();
        //设置安全管理器
        bean.setSecurityManager(defaultWebSecurityManager);

        Map<String, String> filterMap = new LinkedHashMap<>();


        filterMap.put("/index","authc");
        filterMap.put("/","authc");
        bean.setFilterChainDefinitionMap(filterMap);

        //如果没有权限就调到登陆页面
        bean.setLoginUrl("/toLogin");
        return bean;
    }
}
