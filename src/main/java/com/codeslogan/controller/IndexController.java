package com.codeslogan.controller;

import com.codeslogan.mapper.CompetitionMapper;
import org.springframework.beans.factory.annotation.Autowired;
import com.codeslogan.pojo.Competition;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Collection;

@Controller
public class IndexController {
    @Autowired
    CompetitionMapper competitionMapper;
    @RequestMapping({"/index","/"})
    public String showIndex(Model model){
        Collection<Competition> competitions = competitionMapper.getAll(0,10);
        Collection<String> interests = competitionMapper.getCategory();
        model.addAttribute("cpts", competitions);
        model.addAttribute("interests", interests);
        return "index";
    }
    @RequestMapping("/index/{category}")
    public String showCategory(@PathVariable String category,  Model model){
        Collection<Competition> competitions = competitionMapper.getCompetionByCategory(category, 0, 10);
        Collection<String> interests = competitionMapper.getCategory();
        model.addAttribute("cpts", competitions);
        model.addAttribute("interests", interests);
        return "index";

    }

    @RequestMapping("/tocpt")
    public String ToCompetition(){
        return "cpt";
    }

    @RequestMapping("/noauthor")
    @ResponseBody
    public String Unauthorize(){
        return "抱歉 您没有权限！";
    }

}
