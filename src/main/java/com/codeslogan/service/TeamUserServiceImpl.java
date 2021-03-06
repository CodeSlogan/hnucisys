package com.codeslogan.service;

import com.codeslogan.mapper.TeamUserMapper;
import com.codeslogan.pojo.Team;
import com.codeslogan.pojo.TeamExhibition;
import com.codeslogan.pojo.TeamUser;
import com.codeslogan.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;

@Service
public class TeamUserServiceImpl implements TeamUserService {

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
    public int delTeamUserById(int tuid) {
        return teamUserMapper.delTeamUserById(tuid);
    }

    @Override
    public List<TeamExhibition> queryTeamInfoByUserId(int userId) {
        return teamUserMapper.queryTeamInfoByUserId(userId);
    }

    @Override
    public List<User> queryMatesInfoByTeamId(int teamid) {
        return teamUserMapper.queryMatesInfoByTeamId(teamid);
    }

    @Override
    public TeamUser queryBytuid(int tuid) {
        return teamUserMapper.queryBytuid(tuid);
    }

    @Override
    public int updateRoleBytuid(int tuid) {
        return teamUserMapper.updateRoleBytuid(tuid);
    }
}
