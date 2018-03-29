package com.hs.mapper;

import com.hs.domain.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserMapper extends BaseMapper<User> {
    List<User> pageList(@Param("username") String username);
    /**
     * 登录
     *
     * @param username
     * @param password
     * @return
     */
    User login(@Param("username") String username, @Param("password") String password);
}