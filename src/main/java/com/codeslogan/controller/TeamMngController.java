package com.codeslogan.controller;

import com.codeslogan.pojo.TeamExhibition;
import com.codeslogan.service.TeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Collection;

@Controller
public class TeamMngController {

    @Autowired
    TeamService teamService;

    @RequestMapping("/toteamMng")
    public String ToTeamMngList(Model model){
        Collection<TeamExhibition> team = teamService.queryAllTeam();
        model.addAttribute("team",team);
        model.addAttribute("active","team");
        return "TeamMng/list";
    }
}
