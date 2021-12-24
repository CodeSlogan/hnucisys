package com.codeslogan.controller;

import com.codeslogan.pojo.User;
import com.codeslogan.service.CompetitionService;
import org.springframework.beans.factory.annotation.Autowired;
import com.codeslogan.pojo.Competition;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.Collection;

@Controller
public class IndexController {

    @Autowired
    CompetitionService competitionService;

    @RequestMapping({"/index","/","/index.html"})
    public String showIndex(Model model, HttpServletRequest request){
        Collection<Competition> competitions = competitionService.getAll(0,10);
        Collection<String> interests = competitionService.getCategory();
        model.addAttribute("cpts", competitions);
        model.addAttribute("interests", interests);
        User user = (User) request.getSession().getAttribute("user");
            return "index";
    }

    @RequestMapping("/index/{category}")
    public String showCategory(@PathVariable String category,  Model model){
        Collection<Competition> competitions = competitionService.getCompetitionByCategory(category, 0, 10);
        Collection<String> interests = competitionService.getCategory();
        model.addAttribute("cpts", competitions);
        model.addAttribute("interests", interests);
        model.addAttribute("active", category);
        return "index";

    }

    @RequestMapping("/tocpt")
    public String ToCompetition(Model model){
        Collection<Competition> competitions = competitionService.getAll(0,10);
        model.addAttribute("cpts",competitions);            //传入竞赛信息
        model.addAttribute("active","cpt");
        return "CptMng/list";
    }

    @RequestMapping("/noauthor")
    public String Unauthorize(){
        return "redirect:/index";         //没有权限一律跳入首页
    }

}
