package com.edu.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ToPageController {
    //该类用来写一部分的页面跳转

    //index跳转商品中心
    @RequestMapping("ToProductPage")
    public String ToProductPage(){
        return "product";
    }

    //index跳转帮助页面
    @RequestMapping("ToHelpPage")
    public String ToHelpPage(){
        return "help";
    }

    //indext跳转到contact.html
    @RequestMapping("ToContactPage")
    public String ToContactPage(){
        return "contact";
    }

}
