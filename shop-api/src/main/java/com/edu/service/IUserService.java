package com.edu.service;


import com.edu.pojo.UserPojo;

public interface IUserService {
    public UserPojo queryUserByAccount(String account);

    public int insertUser(UserPojo userPojo);

}
