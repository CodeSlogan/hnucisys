package com.codeslogan.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @Author: codeslogan
 * @Date: 2021-11-17 11:37
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TeamUser {
    private int tuId;
    private int teamId;
    private int userId;
    private int role;
    private Date createTime;
    private Date updateTime;
}
