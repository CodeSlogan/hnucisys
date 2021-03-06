package com.codeslogan.service;

import com.codeslogan.pojo.Team;
import com.codeslogan.pojo.TeamExhibition;
import com.codeslogan.pojo.TeamUser;
import com.codeslogan.pojo.User;

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

    List<TeamExhibition> queryTeamInfoByUserId(int userId);

    List<User> queryMatesInfoByTeamId(int teamid);

    // tuid查对应信息
    TeamUser queryBytuid(int tuid);

    // 更新role
    int updateRoleBytuid(int tuid);
}
