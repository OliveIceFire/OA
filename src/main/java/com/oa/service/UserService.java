package com.oa.service;

import com.oa.entity.User;
import com.oa.mapper.UserMapper;
import com.oa.service.exception.LoginException;

public class UserService {
    private UserMapper userMapper = new UserMapper();

    public User checkLogin(String username, String password) {
        User user = userMapper.selectByUsername(username);
        if (user == null) {
            throw new LoginException("用户名不存在");
        }
        if (!password.equals(user.getPassword())) {
            throw new LoginException("密码错误");
        }
        return user;
    }
}
