package com.codeslogan.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @Author: codeslogan
 * @Date: 2021-11-17 11:39
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Competition {
    private int cptId;
    private String name;
    private String url;
    private String category;
    private Date time;
    private int evaluation;
    private Date createTime;
    private Date updateTime;
}
