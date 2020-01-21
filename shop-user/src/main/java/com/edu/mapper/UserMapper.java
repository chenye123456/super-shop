package com.edu.mapper;

import com.edu.pojo.UserPojo;

public interface UserMapper {
    //根据用户名查询用户
    public UserPojo queryUserByAccount(String account);

    public int insertUser(UserPojo userPojo);
}
