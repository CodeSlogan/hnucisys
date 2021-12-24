package com.codeslogan.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author: codeslogan
 * @Date: 2021-12-22 15:52
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserRole {
    private String username;
    private int role;
}
