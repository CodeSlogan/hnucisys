package com.codeslogan.service;

import com.codeslogan.mapper.CompetitionMapper;
import com.codeslogan.pojo.Competition;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author: codeslogan
 * @Date: 2021-12-12 16:15
 */

@Service
public class CompetitionServiceImpl implements CompetitionService{

    @Autowired
    CompetitionMapper competitionMapper;

    @Override
    public List<Competition> getAll(int offset, int maxResults) {
        return competitionMapper.getAll(offset, maxResults);
    }

    @Override
    public List<Competition> getCompetitionByCategory(String category, int offset, int maxResults) {
        return competitionMapper.getCompetitionByCategory(category, offset, maxResults);
    }

    @Override
    public int save(Competition competition) {
        competitionMapper.save(competition);
        return 1;
    }

    @Override
    public Competition getCompetitionById(int id) {
        return competitionMapper.getCompetitionById(id);
    }

    @Override
    public int delCompetitionById(int id) {
        return competitionMapper.delCompetitionById(id);
    }

    @Override
    public List<String> getCategory() {
        return competitionMapper.getCategory();
    }

}
