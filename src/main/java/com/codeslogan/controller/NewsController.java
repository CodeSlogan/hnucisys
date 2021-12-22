package com.codeslogan.controller;

import com.codeslogan.pojo.TeamUser;
import com.codeslogan.pojo.User;
import com.codeslogan.service.TeamUserService;
import com.codeslogan.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/**
 * @Author: codeslogan
 * @Date: 2021-12-21 19:43
 */

@Controller
public class NewsController {

    @Autowired
    TeamUserService teamUserService;

    @Autowired
    UserService userService;

    @RequestMapping("/news")
    public String showTeamUser(Model model, HttpServletRequest request) {
        User user = (User) request.getSession().getAttribute("user");
        List<TeamUser> team = teamUserService.queryByUserId(user.getUserId());
        Iterator<TeamUser> iterator = team.iterator();
        List<User> zeroUsers = new LinkedList<User>();
        while (iterator.hasNext()) {
            TeamUser next = iterator.next();
            // 如果当前用户是此队的队长，根据队伍id查出所有的队员
            if (next.getRole() == 2) {
                List<TeamUser> users = teamUserService.queryByTeamId(next.getTeamId());
                // 遍历需要审核的队员，即role为0
                for (TeamUser teamUser : users) {
                    if (teamUser.getRole() == 0) {
                        zeroUsers.add(userService.queryUserById(teamUser.getUserId()));
                    }
                }
            }
        }
        model.addAttribute("users", zeroUsers);


        return "news";
    }

}
