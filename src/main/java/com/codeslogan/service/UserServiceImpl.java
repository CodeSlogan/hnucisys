package com.codeslogan.service;

import com.codeslogan.mapper.UserMapper;
import com.codeslogan.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

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
    public void AddUser(User user) {
        userMapper.AddUser(user);
    }
}
