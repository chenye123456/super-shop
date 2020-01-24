package com.edu.service.impl;

import com.edu.pojo.ShopCartPojo;
import com.edu.repositroy.ShopcarRepository;
import com.edu.service.IShopCarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
@com.alibaba.dubbo.config.annotation.Service
public class ShopCarServiceImpl implements IShopCarService {

    @Autowired
    ShopcarRepository shopcarRepository;

    //根据账户名去购物车数据库中查询有该用户有哪些商品
    @Override
    public List<ShopCartPojo> queryAllByUaccount(String uaccount) {
        return shopcarRepository.queryAllByUaccount(uaccount);
    }

    //把某个商品添加到购物车,如果该用户的购物车中没有这个商品,则增加进去,如果有
    //这个商品,就在商品的数量上面加一即可
    @Override
    public boolean addShopCar(ShopCartPojo shopCartPojo) {

        //根据用户uid查询用户在购物车中有哪些商品
        List<ShopCartPojo> shopList=queryAllByUaccount(shopCartPojo.getUaccount());

        //如果查出来的结果为0,说明该用户的购物车中没有任何商品
        if (shopList.size()==0){
            shopcarRepository.save(shopCartPojo);
            return true;
        }

        int num=0;
        for (ShopCartPojo shopGood:shopList) {
            //如果gid相同,说明这个商品在购物车中已经存在
            if(shopGood.getGid()==shopCartPojo.getGid()){

                //把购物车中的该商品数量,和本次商品的数量加到一起,变成一个新的商品数量
                shopCartPojo.setCnum(shopCartPojo.getCnum()+shopGood.getCnum());

                //把购物车中商品的总价格换掉
                shopCartPojo.setCtotal(shopCartPojo.getCtotal()+shopGood.getCtotal());

                //删除原商品
                shopcarRepository.delete(shopGood);

                //把新的商品信息存入到购物车的数据库中
                shopcarRepository.save(shopCartPojo);

                return true;
            }
            num++;
        }

        //如果num等于购物车中该用户的所有商品数量,说明用户的购物车
        //数量不为空,并且没有该商品,那么直接把商品存入到购物车中即可
        if(num==shopList.size()){
            shopcarRepository.save(shopCartPojo);
            return true;
        }

        return false;
    }

    //根据cid删除购物车里的商品
    @Override
    public int deleteShopCartPojoByCid(int cid) {
        return shopcarRepository.deleteShopCartPojoByCid(cid);
    }

    //根据cid查询购物车中某个商品的信息
    @Override
    public ShopCartPojo findByCid(int cid) {
        return shopcarRepository.findByCid(cid);
    }

    //购物车中某个商品的数量加一
    @Override
    public boolean addOne(int cid) {

        ShopCartPojo shopCartPojo=findByCid(cid);

        shopCartPojo.setCtotal(shopCartPojo.getCtotal()+shopCartPojo.getGprice());
        shopCartPojo.setCnum(shopCartPojo.getCnum()+1);


        //shopcarRepository.deleteShopCartPojoByCid(cid);



        shopcarRepository.save(shopCartPojo);

        return true;
    }

    //购物车中某个商品的数量减一
    @Override
    public boolean reduceOne(int cid){
        ShopCartPojo shopCartPojo=findByCid(cid);

        if(shopCartPojo.getCnum()==1){
            shopcarRepository.deleteShopCartPojoByCid(cid);
            return true;
        }

        shopCartPojo.setCtotal(shopCartPojo.getCtotal()-shopCartPojo.getGprice());
        shopCartPojo.setCnum(shopCartPojo.getCnum()-1);

        //shopcarRepository.deleteShopCartPojoByCid(cid);

        shopcarRepository.save(shopCartPojo);

        return true;
    }

    @Override
    public int deleteAllByUaccount(String uaccount) {
        return shopcarRepository.deleteAllByUaccount(uaccount);
    }

    //同时根据账户名和gid查询ShopCarPojo
    @Override
    public List<ShopCartPojo> findAllByUaccountAndGid(String uaccount, String[] gids) {
        List<ShopCartPojo> list=new ArrayList<>();

        for (String gid:gids) {
            ShopCartPojo shopCartPojo=shopcarRepository.findAllByUaccountAndGid(uaccount,Integer.parseInt(gid));
            list.add(shopCartPojo);
        }
        return list;
    }


}
