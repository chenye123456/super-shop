package com.edu.service.impl;

import com.edu.pojo.OrderPojo;
import com.edu.repository.OrderRepository;
import com.edu.service.IOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@com.alibaba.dubbo.config.annotation.Service
public class OrderServiceImpl implements IOrderService {

    @Autowired
    OrderRepository orderRepository;


    @Override
    public OrderPojo saveIorderPojo(OrderPojo orderPojo) {
        return orderRepository.save(orderPojo);
    }
}
