package com.codeslogan.controller;

import com.codeslogan.pojo.CptContent;
import com.codeslogan.service.CptContentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @Author: codeslogan
 * @Date: 2021-12-17 16:18
 */

@Controller
public class DetailController {

    @Autowired
    CptContentService cptContentService;

    @RequestMapping("/detail/{cptId}")
    public String showCptContent(@PathVariable int cptId, Model model) {
        CptContent cptContent = cptContentService.queryCptContentById(cptId);
        model.addAttribute("cptContent", cptContent);
        return "detail";
    }
}
