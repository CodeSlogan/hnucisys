package com.codeslogan.config;

import com.codeslogan.pojo.User;
import com.codeslogan.service.UserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;

public class UserRealm extends AuthorizingRealm {
    @Autowired
    UserService userService;

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        System.out.println("执行了=》授权");

        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();

        Subject subject = SecurityUtils.getSubject();

        User currentuser = (User)subject.getPrincipal();        //拿到user对象

        //设置当前用户权限
        info.addStringPermission(currentuser.getPerms());

        return info;
    }

    //认证
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        System.out.println("执行了=》认证");

        UsernamePasswordToken userToken = (UsernamePasswordToken) token;
        //连接数据库
        User user = userService.queryUserByName(userToken.getUsername());

        if (user == null) {
            return null;
        }
        return new SimpleAuthenticationInfo(user, user.getPassword(), "");
    }
}
