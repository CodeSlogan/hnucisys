package com.codeslogan.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @Author: codeslogan
 * @Date: 2021-12-12 16:09
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserMessage {
    private int messageid;
    private int wuid;
    private int guid;
    private String messagetext;
    private String replymessage;
    private Date createtime;
    private Date updatetime;
}
