package com.codeslogan.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @Author: codeslogan
 * @Date: 2021-11-17 11:38
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Team {
    private int teamId;
    private String teamName;
    private int cptId;
    private Date createTime;
    private Date updateTime;
}
