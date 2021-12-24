package com.codeslogan.service;

import com.codeslogan.pojo.Team;
import com.codeslogan.pojo.TeamExhibition;

import java.util.Collection;
import java.util.List;

public interface TeamService {
    public Collection<TeamExhibition> queryTeamById(int teamid);

    public Collection<TeamExhibition> queryAllTeam();

    public int createNewTeam(Team team);

    // 降序查所有队伍
    List<Team> queryTeamDesc();
}
