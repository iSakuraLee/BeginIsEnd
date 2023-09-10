package com.sakura.study.entity;

import lombok.Data;

import java.util.Date;

@Data
public class UserInfo {

    private int id;

    private String username;

    private String password;

    private String email;

    private Date createTime;

    private Date updateTime;
}
