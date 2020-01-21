package com.edu.web;

import com.alibaba.dubbo.config.annotation.Reference;
import com.edu.pojo.GoodsPojo;
import com.edu.pojo.ShopCartPojo;
import com.edu.pojo.UserPojo;
import com.edu.service.IUserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.edu.service.IGoodsService;
import com.edu.service.IShopCarService;

import javax.servlet.http.HttpSession;

@Controller
public class ShopCarController {

    @Reference(check = false)
    IShopCarService shopCarService;

    @Reference(check = false)
    IGoodsService iGoodsService;

    @Reference
    IUserService userService;

    //点击商品收藏时,把商品加入到购物车
    @RequestMapping("addShopCar")
    @ResponseBody
    public String addShopCar(Integer gid, HttpSession session){

        //获得当前用户的账户名
        String uaccount=(String) session.getAttribute("uaccount");


        GoodsPojo goodsPojo=iGoodsService.findGoodsPojoByGid(gid);

        //创建存储到购物车商品的内容
        ShopCartPojo shopCartPojo=new ShopCartPojo(uaccount,goodsPojo.getGid(),goodsPojo.getGimage(),goodsPojo.getGname(),goodsPojo.getGprice(),1,goodsPojo.getGprice()*1);

        shopCarService.addShopCar(shopCartPojo);

        return "ok";
    }



}
