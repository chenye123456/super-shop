package com.edu.repository;

import com.edu.pojo.OrderPojo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends JpaRepository<OrderPojo,Integer> {



}
