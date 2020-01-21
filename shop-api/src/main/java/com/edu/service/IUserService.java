package com.edu.service;


import com.edu.pojo.UserPojo;

public interface IUserService {
    public UserPojo queryUserByUname(String uname);

    public int insertUser(UserPojo userPojo);
}
