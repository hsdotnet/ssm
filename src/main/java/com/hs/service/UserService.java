package com.hs.service;

import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.IService;
import com.hs.domain.User;

import java.util.List;

public interface UserService extends IService<User> {
    List<User> selectUsers(String username, String realname);
}