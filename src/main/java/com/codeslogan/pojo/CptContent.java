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
public class CptContent {
    private int cptId;
    private String content;
    private Date createTime;
    private Date updateTime;
}
