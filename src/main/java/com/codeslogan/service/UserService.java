package com.codeslogan.service;

import com.codeslogan.pojo.TeamUser;
import com.codeslogan.pojo.User;
import com.codeslogan.pojo.UserRole;

import java.util.Collection;
import java.util.List;

public interface UserService {
    public User queryUserByName(String name);
    public Collection<User> queryMatesByGrade(int grade);
    public Collection<User> queryTeamUsersByTeamID(int id);
    public void AddUser(User user);
    // 根据Id查询用户
    public User queryUserById(int id);

    // 根据id删除用户
    public int delUserById(int id);

    // 查询出所有的用户
    public List<User> queryAllUser();

    // 后台保存用户
    int saveUser(User user);

    // 根据teamid和userid查其role
    public UserRole queryUserByTeamIdUserId(int teamid, int id);
}
