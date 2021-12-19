package com.codeslogan.service;

import com.codeslogan.mapper.TeamUserMapper;
import com.codeslogan.pojo.TeamExhibition;
import com.codeslogan.pojo.TeamUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;

@Service
public class TeamUserServiceImpl implements TeamUserService{

    @Autowired
    TeamUserMapper teamUserMapper;

    @Override
    public List<TeamUser> queryAll() {
        return teamUserMapper.queryAll();
    }

    @Override
    public List<TeamUser> queryByTeamId(int teamId) {
        return teamUserMapper.queryByTeamId(teamId);
    }

    @Override
    public List<TeamUser> queryByUserId(int userId) {
        return teamUserMapper.queryByUserId(userId);
    }

    @Override
    public int save(TeamUser teamUser) {
        return teamUserMapper.save(teamUser);
    }

    @Override
    public int delTeamUserById(int tuId) {
        return delTeamUserById(tuId);
    }
}
