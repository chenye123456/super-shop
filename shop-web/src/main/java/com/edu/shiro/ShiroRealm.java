package com.edu.shiro;

import com.alibaba.dubbo.config.annotation.Reference;
import com.edu.pojo.UserPojo;
import com.edu.service.IUserService;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;


public class ShiroRealm extends AuthorizingRealm {

    @Reference
    IUserService iUserService;

    //授权
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {


        return null;
    }

    //认证
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {

        UsernamePasswordToken user = (UsernamePasswordToken)token;



        UserPojo userPojo1=iUserService.queryUserByAccount(user.getUsername());

        if(null == userPojo1){ //用户为空
            throw new UnknownAccountException("用户为空");
        }

        String principal = user.getUsername(); //帐号
        String credentials = userPojo1.getUpass();  //从数据库获取的密码
        String realmName = super.getName(); //realm的名字

        AuthenticationInfo ai = new SimpleAuthenticationInfo(principal,credentials,realmName);

        return ai;
    }
}
