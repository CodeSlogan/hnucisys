package com.codeslogan.controller;

import com.codeslogan.pojo.TeamUser;
import com.codeslogan.pojo.User;
import com.codeslogan.pojo.UserMessage;
import com.codeslogan.service.TeamUserService;
import com.codeslogan.service.UserMessageService;
import com.codeslogan.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.*;

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

    @Autowired
    UserMessageService userMessageService;

    // 信息展示接口
    @RequestMapping("/news")
    public String showTeamUser(Model model, HttpServletRequest request) {
        User user = (User) request.getSession().getAttribute("user");

        // 入队申请
        List<TeamUser> team = teamUserService.queryByUserId(user.getUserId());
        Iterator<TeamUser> teamItor = team.iterator();
        List<Integer> tuids = new ArrayList<Integer>();
        List<User> zeroUsers = new LinkedList<User>();

        // 信息内容
        Collection<UserMessage> userMessages = userMessageService.queryMegByGuid(user.getUserId());
        /*
        Iterator<UserMessage> messageItor = userMessages.iterator();
        while (messageItor.hasNext()) {
            UserMessage userMessage = messageItor.next();
            if (userMessage.getReplymessage() != null) {//回复过的剔除
                userMessages.remove(userMessage);
            }
        }
         */
        while (teamItor.hasNext()) {
            TeamUser next = teamItor.next();
            // 如果当前用户是此队的队长，根据队伍id查出所有的队员
            if (next.getRole() == 2) {
                List<TeamUser> users = teamUserService.queryByTeamId(next.getTeamId());
                // 遍历需要审核的队员，即role为0
                for (TeamUser teamUser : users) {
                    if (teamUser.getRole() == 0) {
                        tuids.add(teamUser.getTuId());
                        zeroUsers.add(userService.queryUserById(teamUser.getUserId()));
                    }
                }
            }
        }
        model.addAttribute("tuids", tuids);
        model.addAttribute("users", zeroUsers);
        model.addAttribute("invitations", userMessages);
        return "news";
    }

    /*
    @RequestMapping("/news/invitations")
    public String showInvitations(Model model, HttpServletRequest request) {
        User user = (User) request.getSession().getAttribute("user");
        if(user == null) {
            return "redirect:/login";
        }
        Collection<UserMessage> userMessages = userMessageService.queryMegByGuid(user.getUserId());
        model.addAttribute("invitations", userMessages);
        return "news";
    }

     */

    @PostMapping("/news/replyinvitation")
    @ResponseBody
    public String acceptInvitation(@RequestBody UserMessage userMessage, HttpServletRequest request) {
        User user = (User) request.getSession().getAttribute("user");
        if (user == null) {
            return "redirect:/login";
        }
        /*回复邀请*/
        userMessage.setUpdatetime(new Date());
        System.out.println(userMessage.getReplymessage());
        userMessageService.replyMessage(userMessage);
        return "success";
    }

    @PostMapping("/news/acceptMate")
    @ResponseBody
    public String acceptMate(@RequestBody int tuid) {

        // 若接受，根据tuid更新role为1
        teamUserService.updateRoleBytuid(tuid);
        return "redirect:/news";
    }

    @PostMapping("/news/refuseMate")
    @ResponseBody
    public String refuseMate(@RequestBody int tuid) {

        // 若拒绝，直接删除这条记录

        teamUserService.delTeamUserById(tuid);
        return "redirect:/news";
    }

}
