package com.hs.service.impl;

import com.hs.constants.GlobalConstants;
import com.hs.domain.User;
import com.hs.mapper.UserMapper;
import com.hs.service.UserService;
import com.hs.util.CookieUtil;
import com.hs.util.JsonUtil;
import com.hs.util.Result;
import com.hs.vo.JqGridPagerVO;
import com.hs.vo.LoginUserVO;
import com.hs.vo.PagerVO;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import redis.clients.jedis.JedisPool;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@Service
public class UserServiceImpl implements UserService {
    @Resource
    private JedisPool jedisPool;

    @Resource
    private UserMapper userMapper;

    @Override
    public JqGridPagerVO<User> getJqGridData(PagerVO pager, String username) {
        List<User> users = userMapper.pageList(pager.getOffset(), pager.getRows(), username);
        int count = userMapper.pageListCount(username);
        return new JqGridPagerVO<User>(users, count, pager);
    }

    @Override
    public Result<String> login(HttpServletResponse response, String username, String password) {
        if ("admin".equals(username) && "admin".equals(password)) {
            LoginUserVO loginUserVO = new LoginUserVO();
            loginUserVO.setId(1);
            loginUserVO.setUsername(username);
            loginUserVO.setRealname("管理员");
            loginUserVO.setToken(UUID.randomUUID().toString());

            CookieUtil.set(response, GlobalConstants.LOGIN_USER_COOKIE_KEY, loginUserVO.getToken(), false);
            jedisPool.getResource().set(GlobalConstants.LOGIN_USER_REDIS_PRE + loginUserVO.getToken(), JsonUtil.objectToJson(loginUserVO));
        } else {
            return Result.error("用户名或者密码错误");
        }
        return Result.success("");
    }

    @Override
    public void logout(HttpServletRequest request, HttpServletResponse response) {
        String token = CookieUtil.getValue(request, GlobalConstants.LOGIN_USER_COOKIE_KEY);
        CookieUtil.remove(request, response, GlobalConstants.LOGIN_USER_COOKIE_KEY);
        jedisPool.getResource().del(GlobalConstants.LOGIN_USER_REDIS_PRE + token);
    }

    @Override
    public LoginUserVO getLoginUserByToken(HttpServletRequest request) {
        String token = CookieUtil.getValue(request, GlobalConstants.LOGIN_USER_COOKIE_KEY);
        String json = jedisPool.getResource().get(token);
        return JsonUtil.jsonToPojo(json, LoginUserVO.class);
    }
}
