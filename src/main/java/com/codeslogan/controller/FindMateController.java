package com.codeslogan.controller;

import com.codeslogan.pojo.*;
import com.codeslogan.service.TeamService;
import com.codeslogan.service.TeamUserService;
import com.codeslogan.service.UserMessageService;
import com.codeslogan.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.*;

@Controller
public class FindMateController {

    @Autowired
    UserService userService;
    @Autowired
    TeamService teamService;
    @Autowired
    TeamUserService teamUserService;
    @Autowired
    UserMessageService userMessageService;

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
        model.addAttribute("user", user); //传递用户对象，方便获取用户id
        //model.addAttribute("teamUsersMap", teamUsersMap);
        return "findmate";
    }

    //*** 加入队伍
    @ResponseBody
    @RequestMapping("/jointeam/{teamId}")
    public String joinTeam(@PathVariable Integer teamId, Model model, HttpServletRequest httpServletRequest) {
        int MaxNumber = 5;
        User user = (User) httpServletRequest.getSession().getAttribute("user");
        //userid和teamid都有了。
        // role表示队伍情况，0为非正式成员，1位正式成员，2以上表示队长。
        //如果队伍中没有队长，则可以提交申请；如果队长role为2，则可以提交申请
        //如果队长的role为3，则可以直接加入
        //如果队长的role为4，则拒绝加入
        String msg = "";
        //根据队伍Id查询数据
        Collection<TeamUser> teamUsers = teamUserService.queryByTeamId(teamId);
        //获取队长所在的队伍信息
        TeamUser teamLeader = teamUsers.iterator().next(); //如果没有队长，则为第一个成员
        for (TeamUser teamuser : teamUsers) {
            if (teamuser.getRole() >= 2) {
                teamLeader = teamuser;
                break;
            }
        }

        //判断队员是否在队伍里边
        int flag = 0; //默认不在队伍里边
        for (TeamUser teamUser : teamUsers) {
            if (teamUser.getUserId() == user.getUserId()) {
                flag = 1;
            }
        }

        //如果队伍没满，并且队长允许，自己没在队伍里边，则可以加入
        if (teamUsers.size() < MaxNumber && flag == 0 && teamLeader.getRole() <= 2) {
            //此时加入状态为申请中
            teamUserService.save(new TeamUser(0, teamId, user.getUserId(), 0, new Date(), new Date()));
            msg = "申请成功";
        } else if (teamUsers.size() < MaxNumber && teamLeader.getRole() == 3 && flag == 0) {
            //直接成为正式成员
            teamUserService.save(new TeamUser(0, teamId, user.getUserId(), 1, new Date(), new Date()));
            msg = "加入成功";
        } else if (flag == 1) {
            msg = "已经加入";
        } else if (teamLeader.getRole() > 3) {
            msg = "队长拒绝";
        } else if (teamUsers.size() >= MaxNumber) {
            msg = "队伍已满";
        } else {
            msg = "请重试";
        }
        return msg;
    }

    @PostMapping("/invitemate")
    @ResponseBody
    public String inviteMate(@RequestBody UserMessage userMessage, HttpServletRequest request) {
        //System.out.println(userMessage);
        User user = (User) request.getSession().getAttribute("user");
        if(user == null) {
            return "redirect:/login";
        }
        userMessage.setWuid(user.getUserId());
        userMessage.setCreatetime(new Date());
        userMessageService.addMessage(userMessage);
        return "success";
    }
}
