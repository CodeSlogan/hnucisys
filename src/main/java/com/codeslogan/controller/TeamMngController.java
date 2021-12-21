package com.codeslogan.controller;

import com.codeslogan.pojo.Competition;
import com.codeslogan.pojo.CptContent;
import com.codeslogan.pojo.Team;
import com.codeslogan.pojo.TeamExhibition;
import com.codeslogan.service.CompetitionService;
import com.codeslogan.service.CptContentService;
import com.codeslogan.service.TeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Date;

@Controller
public class TeamMngController {
    private String message;
    @Autowired
    TeamService teamService;

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
    public String submitNewTeam(Team team, Model model) {
        Date date = new Date();
        team.setCreateTime(date);
        team.setUpdateTime(date);
        Competition competition = competitionService.getCompetitionById(team.getCptId());
        System.out.println(competition);
        if (competition != null) {
            teamService.createNewTeam(team);
            message = "提示：队伍创建成功！";
        } else {
            message = "错误：竞赛编号不存在，请查看竞赛后确认！";
        }
        return "redirect:/toUserTeamMng";
    }
}
