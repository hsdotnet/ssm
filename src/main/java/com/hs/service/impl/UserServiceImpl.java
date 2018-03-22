package com.hs.service.impl;

import com.baomidou.mybatisplus.mapper.Condition;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
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
    public List<User> selectUsers(String username, String realname) {
        EntityWrapper<User> wrapper = new EntityWrapper<User>();
        wrapper.setEntity(new User());
        if (!username.isEmpty()) {
            wrapper.like("username", username);
        }
        if (!realname.isEmpty()) {
            wrapper.like("realname", realname);
        }
        return baseMapper.selectUserList(wrapper);
    }
}
