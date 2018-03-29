package com.hs.service;

import com.hs.domain.User;
import com.hs.util.Result;
import com.hs.vo.JqGridPagerVO;
import com.hs.vo.LoginUserVO;
import com.hs.vo.PageVO;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface UserService {
    JqGridPagerVO<User> getJqGridData(PageVO page, String username);

    /**
     * 用户登录
     *
     * @param response
     * @param username
     * @param password
     * @return
     */
    Result<String> login(HttpServletResponse response, String username, String password);

    /**
     * 用户退出
     *
     * @param request
     * @param response
     */
    void logout(HttpServletRequest request, HttpServletResponse response);

    /**
     * 从toke中获取用户信息
     *
     * @param request
     * @return
     */
    LoginUserVO getLoginUserByToken(HttpServletRequest request);
}