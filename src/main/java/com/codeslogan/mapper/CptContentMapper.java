package com.codeslogan.mapper;

import com.codeslogan.pojo.CptContent;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * @Author: codeslogan
 * @Date: 2021-12-17 16:02
 */

@Mapper
@Repository
public interface CptContentMapper {
    // 根据比赛ID查询具体的内容
    public CptContent queryCptContentById(int id);
}
