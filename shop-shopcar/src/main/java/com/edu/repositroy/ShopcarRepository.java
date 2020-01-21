package com.edu.repositroy;

import com.edu.pojo.ShopCartPojo;
import org.hibernate.sql.Update;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ShopcarRepository extends JpaRepository<ShopCartPojo,Integer> {

    //根据账户名查询当前用户在购物车列表中一共有哪些商品
    public List<ShopCartPojo> queryAllByUaccount(String uaccount);

    //根据cid删除购物车里的商品
    public int deleteShopCartPojoByCid(int cid);






}
