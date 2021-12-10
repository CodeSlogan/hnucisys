package com.codeslogan;

import com.codeslogan.mapper.CompetitionMapper;
import com.codeslogan.pojo.Competition;
import com.codeslogan.service.UserService;
import com.codeslogan.service.UserServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.sql.DataSource;
import java.sql.SQLException;
import java.util.Date;

@SpringBootTest
class HnucisysApplicationTests {

    @Autowired
    UserServiceImpl userService;

    @Autowired
    CompetitionMapper competitionMapper;
    @Autowired
    DataSource dataSource;
    @Test
    void contextLoads() throws SQLException {
        System.out.println(dataSource.getClass());
        System.out.println(dataSource.getConnection());
    }

    @Test
    void findMates() throws SQLException {
        System.out.println(userService.queryMatesByGrade(1));
    }

    @Test
    void selectCompetition(){
        System.out.println(competitionMapper.getById(26));
        competitionMapper.delById(26);
    }


}
