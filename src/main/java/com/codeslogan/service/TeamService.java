package com.codeslogan.service;

import com.codeslogan.pojo.Team;
import com.codeslogan.pojo.TeamExhibition;

import java.util.Collection;

public interface TeamService {
    public Collection<TeamExhibition> queryTeamById(int teamid);

    public Collection<TeamExhibition> queryAllTeam();

    public int createNewTeam(Team team);

}
