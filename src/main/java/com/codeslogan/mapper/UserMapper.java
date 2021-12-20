package com.codeslogan.mapper;

import com.codeslogan.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.List;

/**
 * @Author: codeslogan
 * @Date: 2021-11-17 11:34
 */

@Mapper
@Repository
public interface UserMapper {
    //查询用户信息及登录权限
    public User queryUserByName(String name);

    //查找等级大于等于grade的队友
    public Collection<User> queryMatesByGrade(int grade);

    //查找属于同一个队伍的成员
    public Collection<User> queryTeamUsersByTeamID(int id);
    //注册添加新用户
    public void AddUser(User user);

    // 根据Id查询用户
    public User queryUserById(int id);

    // 根据id删除用户
    public int delUserById(int id);

    // 查询出所有的用户
    public List<User> queryAllUser();

    // 后台保存用户
    int saveUser(User user);

}
