package com.shsxt.crm.controller;

import com.shsxt.base.BaseController;
import com.shsxt.crm.model.ResultInfo;
import com.shsxt.crm.query.CustomerQuery;
import com.shsxt.crm.service.CustomerService;
import com.shsxt.crm.vo.Customer;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.Map;

/**
 * @author 殇丶无求
 */
@RequestMapping("customer")
@Controller
public class CustomerController extends BaseController<Customer> {

    @Resource
    private CustomerService customerService;

    @RequestMapping("add")
    @ResponseBody
    public ResultInfo<Customer> add(Customer customer){
        customerService.addCustomer(customer);
        return success("添加成功");
    }
    /**
     * 更新客户
     * @param customer
     * @return
     */
    @RequestMapping("update")
    @ResponseBody
    public ResultInfo<Customer> update(Customer customer){
        customerService.updateCustomer(customer);
        return success("更新成功");
    }

    /**
     * 查询客户列表
     * @param customerQuery
     * @return
     */
    @RequestMapping("queryByParams")
    @ResponseBody
    public Map<String,Object> queryByParams(CustomerQuery customerQuery){
        return customerService.queryByParams(customerQuery);
    }

    /**
     * 跳转到客户管理页面
     * @return
     */
    @RequestMapping("index")
    public String index(){
        return "customer";
    }
}
