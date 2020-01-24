package com.edu.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class OrderController {

    //把选中的商品拿去提交,准备支付
    @RequestMapping("tijiao")
    public String tijiao(String[] checked){

        return "success";
    }




}
