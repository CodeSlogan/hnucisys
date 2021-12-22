package com.codeslogan.controller;

import com.codeslogan.mapper.TeamUserMapper;
import com.codeslogan.pojo.Team;
import com.codeslogan.pojo.TeamExhibition;
import com.codeslogan.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class MyPageController {

    @Autowired
    TeamUserMapper teamUserMapper;

    @RequestMapping({"/mypage"})
    public String toMyPage(Model model, HttpServletRequest request) {

        User user = (User) request.getSession().getAttribute("user");
        List<TeamExhibition> teams = teamUserMapper.queryTeamInfoByUserId(user.getUserId());
        model.addAttribute("teams",teams);
        model.addAttribute("user",user);
        return "mypage";
    }
}
