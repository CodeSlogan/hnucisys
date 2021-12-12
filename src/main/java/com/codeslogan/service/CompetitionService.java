package com.codeslogan.service;

import java.util.List;
import com.codeslogan.pojo.Competition;

/**
 * @Author: codeslogan
 * @Date: 2021-12-12 16:15
 */
public interface CompetitionService {
    // 获取所有的竞赛信息，根据时间顺序，取出一定条数的比赛信息
    List<Competition> getAll(int offset, int maxResults);

    //根据分类获取比赛信息
    List<Competition> getCompetitionByCategory(String category, int offset, int maxResults);

    //新增一条竞赛信息
    int save(Competition competition);

    //通过id获取竞赛信息
    Competition getCompetitionById(int id);

    //通过id删除竞赛信息
    int delCompetitionById(int id);

    //获取分类，当成兴趣
    List<String> getCategory();
}
