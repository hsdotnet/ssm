package com.hs.service;

import com.hs.domain.User;
import com.hs.vo.JqGridPagerVO;
import com.hs.vo.PagerVO;

public interface UserService {
    JqGridPagerVO<User> getJqGridData(PagerVO pager);
}