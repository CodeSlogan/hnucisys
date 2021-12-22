package com.codeslogan.controller;

import com.codeslogan.pojo.*;
import com.codeslogan.service.CompetitionService;
import com.codeslogan.service.CptContentService;
import com.codeslogan.service.TeamService;
import com.codeslogan.service.TeamUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Date;
import java.util.List;

@Controller
public class TeamMngController {
    private String message;
    @Autowired
    TeamService teamService;

    @Autowired
    TeamUserService teamUserService;

    @Autowired
    CompetitionService competitionService;

    @RequestMapping("/toteamMng")
    public String ToTeamMngList(Model model) {
        Collection<TeamExhibition> team = teamService.queryAllTeam();
        model.addAttribute("team", team);
        model.addAttribute("active", "team");
        return "TeamMng/list";
    }

    @RequestMapping("/toUserTeamMng")
    public String ToUserTeamMng(Model model) {
        model.addAttribute("msg", message);
        return "TeamMng/userTeamMng";
    }

    @RequestMapping("/submitNewTeam")
    public String submitNewTeam(Team team, Model model, HttpServletRequest request) {
        User user = (User) request.getSession().getAttribute("user");

        Date date = new Date();
        team.setCreateTime(date);
        team.setUpdateTime(date);
        Competition competition = competitionService.getCompetitionById(team.getCptId());
        System.out.println(competition);
        TeamUser teamUser = new TeamUser();
        teamUser.setUserId(user.getUserId());
        teamUser.setRole(2);
        teamUser.setCreateTime(date);
        teamUser.setUpdateTime(date);
        if (competition != null) {
            teamService.createNewTeam(team);
            // 倒序查所有队伍，队伍id最大为最新创建
            List<Team> teams = teamService.queryTeamDesc();
            Team team1 = teams.get(0);
            teamUser.setTeamId(team1.getTeamId());
            // 创建队伍队长
            teamUserService.save(teamUser);
            message = "提示：队伍创建成功！";
        } else {
            message = "错误：竞赛编号不存在，请查看竞赛后确认！";
        }
        return "redirect:/toUserTeamMng";
    }
}
