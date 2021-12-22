package com.codeslogan.mapper;

import com.codeslogan.pojo.Team;
import com.codeslogan.pojo.TeamExhibition;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.List;

@Mapper
@Repository
public interface TeamMapper {
    public Collection<TeamExhibition> queryTeamById(int teamid);

    public Collection<TeamExhibition> queryAllTeam();

    public int createNewTeam(Team team);

    // 降序查所有队伍
    List<Team> queryTeamDesc();


}
