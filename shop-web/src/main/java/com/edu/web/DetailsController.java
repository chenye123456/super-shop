package com.edu.web;

import com.alibaba.dubbo.config.annotation.Reference;
import com.edu.pojo.GoodsPojo;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import com.edu.service.DetailsService;

@Controller
public class DetailsController {

    @Reference
    DetailsService detailsService;


    //此方法跳转到商品指定的商品详情页面
    @RequestMapping("ToDetails")
    public String ToDetails(int gid,Model model){
        GoodsPojo goodsPojo=detailsService.findByGid(gid);
        model.addAttribute("goods",goodsPojo);
        System.out.println(goodsPojo);
        return "proinfo";
    }

    //商品详情页面中的加入收藏方法



}
