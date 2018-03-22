package com.hs.service.impl;

import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.hs.domain.User;
import com.hs.mapper.UserMapper;
import com.hs.service.UserService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {
    @Override
    public Page<User> selectUserPage(Page<User> page) {
        return page.setRecords(baseMapper.selectUserList(page));
    }
}
