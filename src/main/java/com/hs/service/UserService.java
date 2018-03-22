package com.hs.service;

import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.IService;
import com.hs.domain.User;

public interface UserService extends IService<User> {
    Page<User> selectUserPage(Page<User> page);
}