package com.codeslogan.controller;

import com.codeslogan.pojo.Competition;
import com.codeslogan.service.CompetitionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class CptMngController {

    @Autowired
    CompetitionService competitionService;

    @RequestMapping("/cptMng/{cptId}")
    public String editCompetition (@PathVariable int cptId, Model model){
        Competition competition = competitionService.getCompetitionById(cptId);
        model.addAttribute("cpt",competition);
        return "CptMng/update";
    }
    @RequestMapping("updateCpt")
    public String updateCompetition(Competition competition){       //先删除再保存
        competitionService.delCompetitionById(competition.getCptId());
        competitionService.save(competition);
        return "2" ;
    }

}
