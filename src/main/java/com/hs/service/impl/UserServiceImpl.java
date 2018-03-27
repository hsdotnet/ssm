package com.hs.service.impl;

import com.hs.domain.User;
import com.hs.mapper.UserMapper;
import com.hs.service.UserService;
import com.hs.vo.JqGridPagerVO;
import com.hs.vo.PagerVO;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Resource
    private UserMapper userMapper;

    @Override
    public JqGridPagerVO<User> getJqGridData(PagerVO pager, String username) {
        List<User> users = userMapper.pageList(pager.getOffset(), pager.getRows(), username);
        int count = userMapper.pageListCount(username);
        return new JqGridPagerVO<User>(users, count, pager.getPage(), pager.getRows());
    }
}
