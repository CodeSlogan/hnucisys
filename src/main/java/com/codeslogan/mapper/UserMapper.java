package com.codeslogan.mapper;

import com.codeslogan.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * @Author: codeslogan
 * @Date: 2021-11-17 11:34
 */

@Mapper
@Repository
public interface UserMapper {
    //查询用户信息及登录权限
    public User queryUserByName(String name);

    //注册添加新用户
    public void AddUser(User user);
}
