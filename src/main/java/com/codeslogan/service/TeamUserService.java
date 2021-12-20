package com.codeslogan.service;

import com.codeslogan.pojo.TeamUser;

import java.util.List;

public interface TeamUserService {
    //获取所有的组队信息
    List<TeamUser> queryAll();

    //根据队伍id获取所有的组队信息
    List<TeamUser> queryByTeamId(int teamId);

    //根据用户id获取所有的组队信息
    List<TeamUser> queryByUserId(int userId);

    //插入组队信息
    int save(TeamUser teamUser);

    //删除组队信息
    int delTeamUserById(int tuId);
}
