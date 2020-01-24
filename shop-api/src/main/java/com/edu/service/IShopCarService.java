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

    //根据cid查询购物车中某个商品的信息
    public ShopCartPojo findByCid(int cid);

    //购物车中某个商品的数量加一
    public boolean addOne(int cid);

    //购物车中某个商品的数量减一
    public boolean reduceOne(int cid);

    //根据用户的uaccount删除所有的商品
    public int deleteAllByUaccount(String uaccount);

    //根据用户名和gid查询购物车中的所有商品
    public List<ShopCartPojo> findAllByUaccountAndGid(String uaccount, String[] gids);


}
