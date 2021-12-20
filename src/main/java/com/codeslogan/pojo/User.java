package com.codeslogan.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * @Author: codeslogan
 * @Date: 2021-11-17 11:31
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    private int userId;
    private String username;
    private String password;
    private String perms;
    private int grade;
    private String major;
    private int sex;
    private String qq;
    private String introduction;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date createtime;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date updatetime;
}
