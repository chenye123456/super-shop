package com.edu.web;

import com.alibaba.dubbo.config.annotation.Reference;
import com.edu.pojo.GoodsPojo;
import com.edu.service.IGoodsService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

@Controller
public class GoodsController {
    @Reference(check = false)
    IGoodsService goodsService;
    //推荐商品和促销产品查询展示
    @RequestMapping("queryPromotions")
    @ResponseBody
    public List<GoodsPojo> queryPromotions(int gclass, Model model){
        List<GoodsPojo> goodsByGclass = goodsService.findAllByGclass(gclass);
        model.addAttribute("goodsByGclass",goodsByGclass);
        return goodsByGclass;
    }
    //根据商品类别查询
    @RequestMapping("queryGoodsByGtype")
    @ResponseBody
    public List<GoodsPojo> queryGoodsByGtype(int gtype,Model model){
        List<GoodsPojo> goodsByGtype = goodsService.findAllByGtype(gtype);
        model.addAttribute("goodsByGtype",goodsByGtype);
        return goodsByGtype;
    }
    //首页根据商品类别查询8个商品
    @RequestMapping("queryEightGoodsByGtype")
    @ResponseBody
    public List<GoodsPojo> queryEightGoodsByGtype(int gtype,Model model){
        List<GoodsPojo> goodsByGtype = new ArrayList<>();
        List<GoodsPojo> goodsPojos = goodsService.findAllByGtype(gtype);
        for (int i=0;i<goodsPojos.size();i++){
            if (i<8){
                goodsByGtype.add(goodsPojos.get(i));
            }
        }
        model.addAttribute("goodsByGtype",goodsByGtype);
        return goodsByGtype;
    }

}
