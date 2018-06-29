package com.shsxt.crm.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

/**
 * 登录页面
 */
@Controller
public class IndexController {

    @RequestMapping("index")
    public String index(HttpServletRequest request){
        request.setAttribute("ctx",request.getContextPath());
        return "index";
    }
}
