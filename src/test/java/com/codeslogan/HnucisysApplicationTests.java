package com.codeslogan;

import com.codeslogan.mapper.CompetitionMapper;
import com.codeslogan.mapper.TeamUserMapper;
import com.codeslogan.pojo.*;
import com.codeslogan.service.UserService;
import com.codeslogan.service.UserServiceImpl;
import com.mysql.cj.Session;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.sql.DataSource;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;

@SpringBootTest
class HnucisysApplicationTests {

    @Autowired
    UserServiceImpl userService;

    @Autowired
    TeamUserMapper teamUserMapper;
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

//    @Test
//    void selectCompetition(){
//        System.out.println(competitionMapper.getCompetitionById(26));
//        competitionMapper.delCompetitionById(26);
//    }
    @Test
    void test02(){
        List<User> users = teamUserMapper.queryMatesInfoByTeamId(1111);
        System.out.println(users);
    }

    @Test
    void text03(){
        List<User> users = teamUserMapper.queryMatesInfoByTeamId(1111);
        System.out.println(users);
    }
}
