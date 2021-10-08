package com.tianxiao.sportplay.entity;

import lombok.Data;

/**
 * 用户实体类
 */
@Data
public class User {
    private int id; //id
    private String username; //用户名
    private String password; //密码
    private String email; //邮箱
    private String role; //角色
    private boolean state; //状态
}
