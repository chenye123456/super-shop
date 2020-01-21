package com.edu.web;

import com.alibaba.dubbo.config.annotation.Reference;
import com.edu.pojo.GoodsPojo;
import com.edu.pojo.ShopCartPojo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.edu.service.IGoodsService;
import com.edu.service.IShopCarService;

@Controller
public class ShopCarController {

    @Reference(check = false)
    IShopCarService shopCarService;

    @Reference
    IGoodsService iGoodsService;

    @RequestMapping("addShopCar")
    @ResponseBody
    public String addShopCar(Integer gid){

        GoodsPojo goodsPojo=iGoodsService.findGoodsPojoByGid(gid);

        ShopCartPojo shopCartPojo=new ShopCartPojo(2,goodsPojo.getGid(),goodsPojo.getGimage(),goodsPojo.getGname(),goodsPojo.getGprice(),1,goodsPojo.getGprice()*1);

        shopCarService.addShopCar(shopCartPojo);

        return "ok";
    }



}
