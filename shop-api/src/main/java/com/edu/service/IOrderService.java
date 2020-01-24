package com.edu.service;


import com.edu.pojo.OrderPojo;

public interface IOrderService {

    //把订单信息存入数据库
    public OrderPojo saveIorderPojo(OrderPojo orderPojo);

}
