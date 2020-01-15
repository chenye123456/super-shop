package com.edu.web;

import com.alibaba.dubbo.config.annotation.Reference;
import com.edu.pojo.UserPojo;
import com.edu.service.IUserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class UserController {
    @Reference(check = false)
    IUserService userService;

    @RequestMapping("login")
    public String login(UserPojo userPojo){

        Subject currentUser = SecurityUtils.getSubject();

        if (null == currentUser) {
            return "redirect:login.html";
        }

        if (!currentUser.isAuthenticated()) {

            UsernamePasswordToken token = new UsernamePasswordToken(userPojo.getUaccount(),userPojo.getUpass());
            token.setRememberMe(true);
            try {
                currentUser.login(token);
            } catch (UnknownAccountException uae) {
                return "redirect:login.html";
            }catch (LockedAccountException lae) {
                return "redirect:login.html";
            } catch (AuthenticationException ex) {
                return "redirect:login.html";
            }
            if (currentUser.isAuthenticated()) {
                return "redirect:toindex?uaccount="+currentUser.getPrincipal();
            }

        }
        return "redirect:toindex";
    }


    @RequestMapping("register")
    public String register(UserPojo userPojo){
        int num=userService.insertUser(userPojo);
        System.out.println(num);
        if(num!=0){
            return "redirect:login.html";
        }
        return "redirect:reg.html";
    }



}
