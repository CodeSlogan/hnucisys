package com.codeslogan.controller;

import com.codeslogan.mapper.UserMapper;
import com.codeslogan.pojo.User;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LoginController {

    @Autowired
    UserMapper userMapper;

    @RequestMapping({"/","/index"})
    public String toIndex(){
        return "index";
    }


    @RequestMapping({"/signup"})
    public String toSignUp(){
        return "signup";
    }

    @RequestMapping("/toLogin")
    public String toLogin(){
        return "login";
    }

    @RequestMapping("/login")
    public String login(String username,String password,Model model){
        //获取当前的用户
        Subject subject = SecurityUtils.getSubject();

        //封装用户的登陆数据
        UsernamePasswordToken token = new UsernamePasswordToken(username,password);
        try {
            subject.login(token);//执行登陆方法，如果没有异常就说明登陆成功
            return "index";
        }catch (UnknownAccountException e){//用户名不存在
            model.addAttribute("msg","用户名不存在");
            return "login";
        }catch (IncorrectCredentialsException e){
            model.addAttribute("msg","密码错误");
            return "login";
        }
    }
    @PostMapping("/adduser")
    public String AddUser(User user){

        userMapper.AddUser(user);

        return "redirect:/toLogin";         //成功插入，重定向返回到首页

    }
}
