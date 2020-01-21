package com.edu.service.impl;

import com.edu.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.edu.service.IUserService;
import com.edu.pojo.UserPojo;

@Service
@com.alibaba.dubbo.config.annotation.Service
public class UserServiceImpl implements IUserService {

    @Autowired
    UserMapper userMapper;


    @Override
    public UserPojo queryUserByAccount(String account) {
        UserPojo userPojo= userMapper.queryUserByAccount(account);
        return userPojo;
    }

    @Override
    public int insertUser(UserPojo userPojo) {
        return userMapper.insertUser(userPojo);
    }

}
