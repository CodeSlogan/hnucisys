package com.codeslogan.service;

import com.codeslogan.mapper.UserMapper;
import com.codeslogan.pojo.User;
import com.codeslogan.pojo.UserRole;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    UserMapper userMapper;

    @Override
    public User queryUserByName(String name) {
        return userMapper.queryUserByName(name);
    }

    @Override
    public Collection<User> queryMatesByGrade(int grade) {
        return userMapper.queryMatesByGrade(grade);
    }

    @Override
    public Collection<User> queryTeamUsersByTeamID(int id) {
        return userMapper.queryTeamUsersByTeamID(id);
    }

    @Override
    public void AddUser(User user) {
        userMapper.AddUser(user);
    }

    @Override
    public User queryUserById(int id) {
        return userMapper.queryUserById(id);
    }

    @Override
    public int delUserById(int id) {
        return userMapper.delUserById(id);
    }

    @Override
    public List<User> queryAllUser() {
        return userMapper.queryAllUser();
    }

    @Override
    public int saveUser(User user) {
        return userMapper.saveUser(user);
    }

    @Override
    public UserRole queryUserByTeamIdUserId(int teamid, int id) {
        return userMapper.queryUserByTeamIdUserId(teamid, id);
    }
}
