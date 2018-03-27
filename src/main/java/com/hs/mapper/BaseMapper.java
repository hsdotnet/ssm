package com.hs.mapper;

import com.hs.domain.BaseModel;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface BaseMapper<T extends BaseModel> {
    int deleteByPrimaryKey(int id);

    int insert(T t);

    int insertSelective(T t);

    T selectByPrimaryKey(int id);

    int updateByPrimaryKeySelective(T t);

    int updateByPrimaryKey(T t);
}