package com.codeslogan.service;

import com.codeslogan.pojo.User;

import java.util.Collection;

public interface UserService {
    public User queryUserByName(String name);
    public Collection<User> queryMatesByGrade(int grade);
    public Collection<User> queryTeamUsersByTeamID(int id);
    public void AddUser(User user);
}
