package com.codeslogan.controller;

import com.codeslogan.pojo.TeamExhibition;
import com.codeslogan.pojo.User;
import com.codeslogan.service.TeamService;
import com.codeslogan.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;

@Controller
public class FindMateController {

    @Autowired
    UserService userService;
    @Autowired
    TeamService teamService;

    @RequestMapping({"/findmate"})
    public String toFindMate(Model model, HttpServletRequest request) {
        User user = (User) request.getSession().getAttribute("user");
        //System.out.println(user);

        Collection<User> mates = userService.queryMatesByGrade(1);
        mates.remove(user);//剔除自己

        Collection<TeamExhibition> teams = teamService.queryTeamById(1111);
        //HashMap<Integer, Collection<User>> teamUsersMap = new HashMap<>();
        Iterator<TeamExhibition> iterator = teams.iterator();
        while (iterator.hasNext()) {
            TeamExhibition teamExhibition = iterator.next();
            int teamid = teamExhibition.getTeamid();
            Collection<User> teamUsers = userService.queryTeamUsersByTeamID(teamid);
            teamExhibition.setTeamUsers(teamUsers);
            //teamUsersMap.put(teamid, teamUsers);
        }

        //System.out.println(teamUsersMap);
        model.addAttribute("mates", mates);
        model.addAttribute("teams", teams);
        //model.addAttribute("teamUsersMap", teamUsersMap);
        return "findmate";
    }
}
