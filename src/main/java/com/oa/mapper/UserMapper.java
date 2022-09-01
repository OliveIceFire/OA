package com.oa.mapper;

import com.oa.entity.User;
import com.oa.utils.MybatisUtils;

public class UserMapper {
    public User selectByUsername(String username) {
        return (User) MybatisUtils.executeQuery(sqlSession -> sqlSession.selectOne("usermapper.selectByUsername", username));
    }
}
