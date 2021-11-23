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
    public User queryUserByName(String name);

}
