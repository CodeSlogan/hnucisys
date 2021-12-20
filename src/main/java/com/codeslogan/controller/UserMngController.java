package com.codeslogan.controller;

import com.codeslogan.pojo.Competition;
import com.codeslogan.pojo.User;
import com.codeslogan.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Collection;

/**
 * @Author: codeslogan
 * @Date: 2021-12-20 22:40
 */

@Controller
public class UserMngController {

    @Autowired
    UserService userService;

    @RequestMapping("/touserMng")
    public String ToUser(Model model){
        Collection<User> users = userService.queryAllUser();
        model.addAttribute("users",users);            //传入竞赛信息
        model.addAttribute("active","user");
        return "UserMng/list";
    }

    // 编辑更新页面
    @RequestMapping("/userMng/{userId}")
    public String editUser (@PathVariable int userId, Model model){
        User user = userService.queryUserById(userId);
        model.addAttribute("user",user);
        model.addAttribute("active","user");

        return "UserMng/update";
    }
    @RequestMapping("/updateUser")
    public String updateUser(User user){       //先删除再保存
        userService.delUserById(user.getUserId());
        userService.saveUser(user);
        System.out.println("debug================================================>");
        return "redirect:/touserMng" ;
    }
    @RequestMapping("/delUser/{userId}")
    public String delUser (@PathVariable int userId, Model model){
        userService.delUserById(userId);
        return "redirect:/touserMng";
    }

    @RequestMapping("/toAddUser")
    public String addUser(Model model){
        model.addAttribute("active","user");
        return "UserMng/add";
    }

    @RequestMapping("/submitUser")
    public String submitUser(User user){
        userService.saveUser(user);
        return "redirect:/touserMng";
    }

}
