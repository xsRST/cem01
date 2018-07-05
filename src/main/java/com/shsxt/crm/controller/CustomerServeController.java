package com.shsxt.crm.controller;

import com.shsxt.base.BaseController;
import com.shsxt.crm.model.ResultInfo;
import com.shsxt.crm.query.CustomerServeQuery;
import com.shsxt.crm.service.CustomerServeService;
import com.shsxt.crm.vo.CustomerServe;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/**
 * 客户服务
 * @author 殇丶无求
 */
@RequestMapping("customer_serve")
@Controller
public class CustomerServeController extends BaseController<CustomerServe> {

    @Resource
    private CustomerServeService customerserveService;

    /**
     * 跳转到不同页面
     * @param type
     * @return
     */
    @RequestMapping("index/{type}")
    public String index(@PathVariable(value = "type") Integer type){
        switch (type){
            case 1:return "customer_serve_create";
            case 2:return "customer_serve_assign";
            case 3:return "customer_serve_proceed";
            case 4:return "customer_serve_feed_back";
            case 5:return "customer_serve_archive";
            default: break;
        }
        return null;
    }

    /**
     * 显示列表
     * @param customerServeQuery
     * @return
     */
    @RequestMapping("list")
    @ResponseBody
    public Map<String,Object> list(CustomerServeQuery customerServeQuery){
        return customerserveService.selectByParams(customerServeQuery);
    }

    /**
     * 添加服务
     */
    @RequestMapping("insert")
    @ResponseBody
    public ResultInfo<CustomerServe> insert(CustomerServe customerServe, HttpServletRequest request){
        customerserveService.insert(customerServe,request);
        return success("添加成功");
    }
    /**
     * 更新服务
     */
    @RequestMapping("update")
    @ResponseBody
    public ResultInfo<CustomerServe> update(CustomerServe customerServe){
        customerserveService.update(customerServe);
        return success("添加成功");
    }
}
