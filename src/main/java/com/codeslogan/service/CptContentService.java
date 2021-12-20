package com.codeslogan.service;

import com.codeslogan.pojo.CptContent;

/**
 * @Author: codeslogan
 * @Date: 2021-12-17 16:15
 */
public interface CptContentService {
    // 根据比赛ID查询具体的内容
    public CptContent queryCptContentById(int id);
}
