package com.codeslogan.mapper;

import com.codeslogan.pojo.Competition;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface CompetitionMapper {
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
