package com.shsxt.crm.controller;

import com.shsxt.crm.service.SaleChanceService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

@RequestMapping("cusDevPlan")
@Controller
public class cusDevPlanController {

    @Resource
    private SaleChanceService saleChanceService;

    /*@RequestMapping("queryByParams")
    public ResultInfo<> queryByParams(){

    }*/
    /**
     * 跳转到相应页面
     * @param request
     * @return
     */
    @RequestMapping("index")
    public String index(HttpServletRequest request){

        return "cus_dev_plan";
    }
}
