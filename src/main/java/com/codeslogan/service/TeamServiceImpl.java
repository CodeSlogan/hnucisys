package com.codeslogan.service;

import com.codeslogan.mapper.TeamMapper;
import com.codeslogan.pojo.Team;
import com.codeslogan.pojo.TeamExhibition;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;

@Service
public class TeamServiceImpl implements TeamService{
    @Autowired
    TeamMapper teamMapper;
    @Override
    public Collection<TeamExhibition> queryTeamById(int teamid) {
        return teamMapper.queryTeamById(teamid);
    }

    @Override
    public Collection<TeamExhibition> queryAllTeam() {
        return teamMapper.queryAllTeam();
    }

    @Override
    public int createNewTeam(Team team) {
        return teamMapper.createNewTeam(team);
    }

    @Override
    public List<Team> queryTeamDesc() {
        return teamMapper.queryTeamDesc();
    }
}
