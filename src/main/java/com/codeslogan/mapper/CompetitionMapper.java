package com.codeslogan.mapper;

import com.codeslogan.pojo.Competition;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface CompetitionMapper {
    //获取所有的竞赛信息，根据时间顺序，取出一定条数的比赛信息
    @Select("select * from competition order by time desc limit #{offset}, #{maxResults}")
    List<Competition> getAll(@Param("offset")int offset, @Param("maxResults")int maxResults);

    //根据分类获取比赛信息
    @Select("select * from competition where category = #{category} order by time desc limit #{offset}, #{maxResults}")
    List<Competition> getCompetionByCategory(@Param("category")String category, @Param("offset")int offset, @Param("maxResults")int maxResults);

    //新增一条竞赛信息
    @Options(useGeneratedKeys=true, keyProperty="cptId", keyColumn = "cptid")
    @Insert("insert into competition(name, url, category, time, evaluation, createtime, updatetime) " +
            "values(#{competition.name}, #{competition.url}, #{competition.category}, #{competition.time}, #{competition.evaluation}, #{competition.createTime}, #{competition.updateTime}) ")
    void save(@Param("competition") Competition competition);

    //通过id获取竞赛信息
    @Select("select * from competition where cptid = #{id}")
    Competition getById(@Param("id")Integer id);


    //通过id删除竞赛信息
    @Delete("delete from competition where cptid = #{id}")
    void delById(@Param("id")Integer id);

    //获取分类，当成兴趣
    @Select("select distinct(category) from competition order by category asc")
    List<String> getCategory();
}
