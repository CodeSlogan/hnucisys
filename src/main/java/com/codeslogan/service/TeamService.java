package com.codeslogan.service;

import com.codeslogan.pojo.TeamExhibition;

import java.util.Collection;

public interface TeamService {
    public Collection<TeamExhibition> queryTeamById(int teamid);
}
