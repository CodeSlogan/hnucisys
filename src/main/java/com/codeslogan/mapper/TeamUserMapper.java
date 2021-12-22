package com.codeslogan.mapper;

import com.codeslogan.pojo.Team;
import com.codeslogan.pojo.TeamExhibition;
import com.codeslogan.pojo.TeamUser;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface TeamUserMapper {
    //获取所有的组队信息
    List<TeamUser> queryAll();

    //根据队伍id查询组队信息
    List<TeamUser> queryByTeamId(int teamId);

    //根据用户id查询组队信息
    List<TeamUser> queryByUserId(int userId);

    //插入组队信息
    int save(TeamUser teamUser);

    //通过tuid删除比赛信息
    int delTeamUserById(int tuId);

    List<TeamExhibition> queryTeamInfoByUserId(int userId);

    // tuid查对应信息
    TeamUser queryBytuid(int tuid);

    // 更新role
    int updateRoleBytuid(int tuid);
}
