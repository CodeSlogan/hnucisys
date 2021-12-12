package com.codeslogan.controller;

import com.codeslogan.pojo.User;
import com.codeslogan.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.Collection;

@Controller
public class FindMateController {

    @Autowired
    UserService userService;

    @RequestMapping({"/findmate"})
    public String toFindMate(Model model, HttpServletRequest request) {
        User user = (User) request.getSession().getAttribute("user");
        System.out.println(user);
        Collection<User> mates = userService.queryMatesByGrade(1);
        mates.remove(user);//剔除自己
        model.addAttribute("mates", mates);
        return "findmate";
    }
}
