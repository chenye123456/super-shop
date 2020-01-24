package com.edu.repositroy;

import com.edu.pojo.ShopCartPojo;
import org.hibernate.sql.Update;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface ShopcarRepository extends JpaRepository<ShopCartPojo,Integer> {

    //根据账户名查询当前用户在购物车列表中一共有哪些商品
    public List<ShopCartPojo> queryAllByUaccount(String uaccount);

    //根据cid删除购物车里的商品
    @Transactional
    public int deleteShopCartPojoByCid(int cid);

    //根据cid查询购物车中某个商品的信息
    public ShopCartPojo findByCid(int cid);

    //根据用户的uaccount删除所有的商品
    @Transactional
    public int deleteAllByUaccount(String uaccount);

    //根据用户名和gid查询购物车中的所有商品
    public ShopCartPojo findAllByUaccountAndGid(String uaccount, int gid);






}
