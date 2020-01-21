package com.edu.service;

import com.edu.pojo.ShopCartPojo;
import com.edu.repositroy.ShopcarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@com.alibaba.dubbo.config.annotation.Service
public class ShopCarServiceImpl implements IShopCarService {

    @Autowired
    ShopcarRepository shopcarRepository;

    //根据用户uid去购物车数据库中查询有该用户有哪些商品
    @Override
    public List<ShopCartPojo> queryAllByUid(int uid) {
        return shopcarRepository.queryAllByUid(uid);
    }

    //增加购物车商品,如果该用户的购物车中没有这个商品,则增加进去,如果有
    //这个商品,就在商品的数量上面加一即可
    @Override
    public boolean addShopCar(ShopCartPojo shopCartPojo) {

        //根据用户uid查询用户在购物车中有哪些商品
        List<ShopCartPojo> shopList=queryAllByUid(shopCartPojo.getUid());

        //如果查出来的结果为0,说明该用户的购物车中没有任何商品
        if (shopList.size()==0){
            shopcarRepository.save(shopCartPojo);
            return true;
        }
        //num用来对比循环了多少次
        int num=0;
        for (ShopCartPojo ss:shopList) {
            if(ss.getGid()==shopCartPojo.getGid()){
                break;
            }
            num++;
        }
        //如果num等于shopList.size(),说明用户的购物车中没有该商品
        if(num==shopList.size()){
            shopcarRepository.save(shopCartPojo);
            return true;
        }

        //n代表该商品在购物车里的数量
        int n=0;
        //如果num的值小于shopList.size()的话,说明该商品在购物车中已经存在
        //先从购物车里拿出商品的数量
        n=shopList.get(num).getCnum();

        n=shopCartPojo.getCnum()+n;
        shopCartPojo.setCnum(n);

        //根据cid删除这个商品
        shopcarRepository.deleteShopCartPojoByCid(shopList.get(num).getCid());
        //再把新的商品加入到购物车里面去
        shopcarRepository.save(shopCartPojo);

        return true;
    }

    //根据cid删除购物车里的商品
    @Override
    public int deleteShopCartPojoByCid(int cid) {
        return shopcarRepository.deleteShopCartPojoByCid(cid);
    }


}
