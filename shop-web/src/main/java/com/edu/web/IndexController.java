package com.edu.web;

import com.alibaba.dubbo.config.annotation.Reference;
import com.edu.pojo.GoodsTypePojo;
import com.edu.pojo.UserPojo;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import service.IGoodsTypeService;

import java.util.List;

@Controller
public class IndexController {
    @Reference(check = false)
    IGoodsTypeService goodsTypeService;

    @RequestMapping("toindex")
    public String toIndex(UserPojo userPojo, Model model){

        //一级类别
        List<GoodsTypePojo> goodsTypePojos = goodsTypeService.queryGoodsTypeOne(0);

        model.addAttribute("goodsTypePojos",goodsTypePojos);

        System.out.println("----------"+goodsTypePojos);
        //所有类别
        List<GoodsTypePojo> gtlist = goodsTypeService.queryGoodsTypeAll();
        model.addAttribute("gtlist",gtlist);
        System.out.println(gtlist);
        return "index";
    }


}
