package com.edu.service;

import com.edu.pojo.ShopCartPojo;

import java.util.List;

public interface IShopCarService {

    //根据账户名查询当前用户在购物车列表中一共有哪些商品
    public List<ShopCartPojo> queryAllByUaccount(String uaccount);

    //添加购物车
    public boolean addShopCar(ShopCartPojo shopCartPojo);

    //根据cid删除购物车里的商品
    public int deleteShopCartPojoByCid(int cid);

}
