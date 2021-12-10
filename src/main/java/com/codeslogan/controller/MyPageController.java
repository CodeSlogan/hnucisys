package com.codeslogan.controller;

import com.codeslogan.pojo.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
public class MyPageController {

    @RequestMapping({"/mypage"})
    public String toMyPage(Model model, HttpServletRequest request) {
        User user = (User) request.getSession().getAttribute("user");
        model.addAttribute("user",user);
        return "mypage";
    }
}
