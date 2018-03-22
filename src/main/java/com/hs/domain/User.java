package com.hs.domain;

import com.baomidou.mybatisplus.annotations.TableName;

import java.util.Date;

@TableName("jpa_user")
public class User {
    private int id;
    private String username;
    private String password;
    private String realname;
    private Date createtime;
    private String createby;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRealname() {
        return realname;
    }

    public void setRealname(String realname) {
        this.realname = realname;
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    public String getCreateby() {
        return createby;
    }

    public void setCreateby(String createby) {
        this.createby = createby;
    }

    @Override
    public String toString() {
        return "User [id=" + id + ", username=" + username + ", password=" + password + ", realname=" + realname
                + ", createtime=" + createtime + ", createby=" + createby + "]";
    }
}
