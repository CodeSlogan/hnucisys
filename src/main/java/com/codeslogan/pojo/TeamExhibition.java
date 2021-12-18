package com.codeslogan.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Collection;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TeamExhibition {
    private int teamid;
    private String teamName;
    private String name;//比赛名
    public Collection<User> teamUsers;
}
