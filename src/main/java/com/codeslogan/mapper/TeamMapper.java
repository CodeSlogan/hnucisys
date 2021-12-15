package com.codeslogan.mapper;

import com.codeslogan.pojo.Team;
import com.codeslogan.pojo.TeamExhibition;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.Collection;
@Mapper
@Repository
public interface TeamMapper {
    public Collection<TeamExhibition> queryTeamById(int teamid);
}