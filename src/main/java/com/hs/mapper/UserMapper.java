package com.hs.mapper;

import com.hs.domain.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserMapper extends BaseMapper<User> {
    List<User> pageList(@Param("offset") int offset, @Param("pagesize") int pagesize, @Param("username") String username);

    int pageListCount(@Param("username") String username);
}