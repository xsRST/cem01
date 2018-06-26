package com.shsxt.crm.controller;

import com.shsxt.crm.service.UserService;
import com.shsxt.crm.utils.LoginUserUtil;
import com.shsxt.crm.vo.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

@Controller
public class MainController {

    @Resource
    private UserService userService;

    @RequestMapping("main")
    public String index(HttpServletRequest request){
        /**
         * 存储上下文环境:
         * 获取id
         * 通过id获取User对应的信息
         */
        request.setAttribute("ctx",request.getContextPath());

        int id=LoginUserUtil.releaseUserIdFromCookie(request);
        User user =userService.selectById(id);
        request.setAttribute("user",user);
        return "main";
    }
}
