package com.edu.web;

import com.alibaba.dubbo.config.annotation.Reference;
import com.edu.pojo.GoodsPojo;
import com.edu.pojo.GoodsTypePojo;
import com.edu.pojo.UserPojo;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.edu.service.IGoodsService;
import com.edu.service.IGoodsTypeService;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class IndexController {
    @Reference(check = false)
    IGoodsTypeService goodsTypeService;
    @Reference(check = false)
    IGoodsService goodsService;
    @RequestMapping("toindex")
    public String toIndex(UserPojo userPojo, Model model, HttpSession session){
        session.setAttribute("uaccount",userPojo.getUaccount());  //用户名
        //一级类别
        List<GoodsTypePojo> goodsTypePojos = goodsTypeService.queryGoodsTypeOne(0);

        session.setAttribute("goodsTypePojos",goodsTypePojos);

        //所有类别
        List<GoodsTypePojo> gtlist = goodsTypeService.queryGoodsTypeAll();
        session.setAttribute("gtlist",gtlist);

        //主页底部的三个类别
        List<GoodsTypePojo> fiveGoodsType = goodsTypeService.queryGoodsTypeTwo(1);
        System.out.println(fiveGoodsType);
        model.addAttribute("typeList",fiveGoodsType);

        List<GoodsTypePojo> fiveGoodsType2 = goodsTypeService.queryGoodsTypeTwo(14);
        System.out.println(fiveGoodsType2);
        model.addAttribute("typeList2",fiveGoodsType2);

        List<GoodsTypePojo> fiveGoodsType3 = goodsTypeService.queryGoodsTypeTwo(21);
        System.out.println(fiveGoodsType3);
        model.addAttribute("typeList3",fiveGoodsType3);
        //促销产品查询
//        List<GoodsPojo> promotions = goodsService.findAllByGclass(0);
//        model.addAttribute("promotions",promotions);

        /*List<GoodsPojo> goodsPojos = goodsService.findAllByGtype(2);
        model.addAttribute("goodspojos",goodsPojos);*/
        return "index";
    }



}
