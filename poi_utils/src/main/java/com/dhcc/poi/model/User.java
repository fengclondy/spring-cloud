/**
 * Copyright (c) 2008-2013 by DHCC
 * All rights reserved.
 */

package com.dhcc.poi.model;

import com.dhcc.poi.utils.ExcelResources;

public class User {

    private int id;
    private String username;
    private String nickname;
    private int age;
    
    public User(){
        
    }
    
    public User(int id, String username, String nickname, int age) {
        this.id = id;
        this.username = username;
        this.nickname = nickname;
        this.age = age;
    }

    public User(String username, String nickname, int age) {
        this.username = username;
        this.nickname = nickname;
        this.age = age;
    }
    
    @ExcelResources(title="用户标识", order=1)
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    @ExcelResources(title="用户名", order=2)
    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }
    @ExcelResources(title="用户昵称", order=3)
    public String getNickname() {
        return nickname;
    }
    public void setNickname(String nickname) {
        this.nickname = nickname;
    }
    @ExcelResources(title="用户年龄", order=4)
    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "User [id=" + id + ", username=" + username + ", nickname=" + nickname + ", age=" + age + "]";
    }
    
    
}
